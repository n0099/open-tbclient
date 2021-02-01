package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
/* loaded from: classes4.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = this.text.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        return i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char charAt = i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
        this.ch = charAt;
        return charAt;
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i + i2, cArr, 0);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 != 0) {
                throw new JSONException("illegal state. " + i2);
            }
            byte[] bArr = new byte[i2 / 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                char charAt = this.text.charAt((i3 * 2) + i);
                char charAt2 = this.text.charAt((i3 * 2) + i + 1);
                bArr[i3] = (byte) ((charAt2 - (charAt2 <= '9' ? '0' : '7')) | ((charAt - (charAt <= '9' ? '0' : '7')) << 4));
            }
            return bArr;
        }
        return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            if (i2 < this.sbuf.length) {
                this.text.getChars(i, i + i2, this.sbuf, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr = new char[i2];
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(cArr);
        }
        return this.text.substring(i, i + i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID && i2 < this.sbuf.length) {
            this.text.getChars(i, i + i2, this.sbuf, 0);
            return this.sbuf;
        }
        char[] cArr = new char[i2];
        this.text.getChars(i, i + i2, cArr, 0);
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        if (i < this.sbuf.length) {
            this.text.getChars(i2, i2 + i, this.sbuf, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr = new char[i];
        this.text.getChars(i2, i + i2, cArr, 0);
        return new BigDecimal(cArr);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    private boolean scanISO8601DateIfMatch(boolean z, int i) {
        char charAt;
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i2;
        int i3;
        int i4;
        int i5;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        char charAt2;
        int i6;
        char charAt3;
        char charAt4;
        char charAt5;
        char charAt6;
        if (i < 8) {
            return false;
        }
        char charAt7 = charAt(this.bp);
        char charAt8 = charAt(this.bp + 1);
        char charAt9 = charAt(this.bp + 2);
        char charAt10 = charAt(this.bp + 3);
        char charAt11 = charAt(this.bp + 4);
        char charAt12 = charAt(this.bp + 5);
        char charAt13 = charAt(this.bp + 6);
        char charAt14 = charAt(this.bp + 7);
        if (!z && i > 13) {
            char charAt15 = charAt((this.bp + i) - 1);
            char charAt16 = charAt((this.bp + i) - 2);
            if (charAt7 == '/' && charAt8 == 'D' && charAt9 == 'a' && charAt10 == 't' && charAt11 == 'e' && charAt12 == '(' && charAt15 == '/' && charAt16 == ')') {
                int i7 = -1;
                for (int i8 = 6; i8 < i; i8++) {
                    char charAt17 = charAt(this.bp + i8);
                    if (charAt17 != '+') {
                        if (charAt17 < '0' || charAt17 > '9') {
                            break;
                        }
                    } else {
                        i7 = i8;
                    }
                }
                if (i7 == -1) {
                    return false;
                }
                int i9 = this.bp + 6;
                long parseLong = Long.parseLong(subString(i9, (i7 + this.bp) - i9));
                this.calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i == 8 || i == 14 || ((i == 16 && ((charAt6 = charAt(this.bp + 10)) == 'T' || charAt6 == ' ')) || (i == 17 && charAt(this.bp + 6) != '-'))) {
            if (z) {
                return false;
            }
            char charAt18 = charAt(this.bp + 8);
            boolean z2 = charAt11 == '-' && charAt14 == '-';
            boolean z3 = z2 && i == 16;
            boolean z4 = z2 && i == 17;
            if (z4 || z3) {
                charAt = charAt(this.bp + 9);
                c = charAt18;
                c2 = charAt13;
                c3 = charAt12;
                c4 = charAt10;
                c5 = charAt8;
                c6 = charAt7;
            } else {
                charAt = charAt14;
                c = charAt13;
                c2 = charAt12;
                c3 = charAt11;
                c4 = charAt10;
                c5 = charAt8;
                c6 = charAt7;
            }
            if (!checkDate(c6, c5, charAt9, c4, c3, c2, c, charAt)) {
                return false;
            }
            setCalendar(c6, c5, charAt9, c4, c3, c2, c, charAt);
            if (i != 8) {
                char charAt19 = charAt(this.bp + 9);
                char charAt20 = charAt(this.bp + 10);
                char charAt21 = charAt(this.bp + 11);
                char charAt22 = charAt(this.bp + 12);
                char charAt23 = charAt(this.bp + 13);
                if ((z4 && charAt20 == 'T' && charAt23 == ':' && charAt(this.bp + 16) == 'Z') || (z3 && ((charAt20 == ' ' || charAt20 == 'T') && charAt23 == ':'))) {
                    charAt20 = charAt(this.bp + 14);
                    c8 = charAt(this.bp + 15);
                    c7 = '0';
                    charAt23 = '0';
                    charAt19 = charAt22;
                    c9 = charAt21;
                } else {
                    c7 = charAt22;
                    c8 = charAt21;
                    c9 = charAt18;
                }
                if (!checkTime(c9, charAt19, charAt20, c8, c7, charAt23)) {
                    return false;
                }
                if (i == 17 && !z4) {
                    char charAt24 = charAt(this.bp + 14);
                    char charAt25 = charAt(this.bp + 15);
                    char charAt26 = charAt(this.bp + 16);
                    if (charAt24 < '0' || charAt24 > '9' || charAt25 < '0' || charAt25 > '9' || charAt26 < '0' || charAt26 > '9') {
                        return false;
                    }
                    i5 = ((charAt24 - '0') * 100) + ((charAt25 - '0') * 10) + (charAt26 - '0');
                } else {
                    i5 = 0;
                }
                int i10 = ((c9 - '0') * 10) + (charAt19 - '0');
                i3 = (c8 - '0') + ((charAt20 - '0') * 10);
                i4 = ((c7 - '0') * 10) + (charAt23 - '0');
                i2 = i10;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            this.calendar.set(11, i2);
            this.calendar.set(12, i3);
            this.calendar.set(13, i4);
            this.calendar.set(14, i5);
            this.token = 5;
            return true;
        } else if (i < 9) {
            return false;
        } else {
            char charAt27 = charAt(this.bp + 8);
            char charAt28 = charAt(this.bp + 9);
            int i11 = 10;
            if ((charAt11 == '-' && charAt14 == '-') || (charAt11 == '/' && charAt14 == '/')) {
                c10 = charAt28;
                c11 = charAt27;
                c12 = charAt13;
                c13 = charAt12;
                c14 = charAt10;
                c15 = charAt8;
                c16 = charAt7;
            } else if (charAt11 == '-' && charAt13 == '-') {
                c13 = '0';
                if (charAt27 == ' ') {
                    c10 = charAt14;
                    c11 = '0';
                    c12 = charAt12;
                    c14 = charAt10;
                    c15 = charAt8;
                    c16 = charAt7;
                    i11 = 8;
                } else {
                    c10 = charAt27;
                    c11 = charAt14;
                    c12 = charAt12;
                    c14 = charAt10;
                    c15 = charAt8;
                    c16 = charAt7;
                    i11 = 9;
                }
            } else if ((charAt9 == '.' && charAt12 == '.') || (charAt9 == '-' && charAt12 == '-')) {
                c10 = charAt8;
                c11 = charAt7;
                c12 = charAt11;
                c13 = charAt10;
                c14 = charAt28;
                charAt9 = charAt27;
                c15 = charAt14;
                c16 = charAt13;
            } else if (charAt11 == 24180 || charAt11 == 45380) {
                if (charAt14 == 26376 || charAt14 == 50900) {
                    if (charAt28 == 26085 || charAt28 == 51068) {
                        c10 = charAt27;
                        c11 = '0';
                        c12 = charAt13;
                        c13 = charAt12;
                        c14 = charAt10;
                        c15 = charAt8;
                        c16 = charAt7;
                    } else if (charAt(this.bp + 10) == 26085 || charAt(this.bp + 10) == 51068) {
                        c10 = charAt28;
                        c11 = charAt27;
                        c12 = charAt13;
                        c13 = charAt12;
                        c14 = charAt10;
                        c15 = charAt8;
                        c16 = charAt7;
                        i11 = 11;
                    } else {
                        return false;
                    }
                } else if (charAt13 == 26376 || charAt13 == 50900) {
                    c13 = '0';
                    if (charAt27 == 26085 || charAt27 == 51068) {
                        c10 = charAt14;
                        c11 = '0';
                        c12 = charAt12;
                        c14 = charAt10;
                        c15 = charAt8;
                        c16 = charAt7;
                    } else if (charAt28 != 26085 && charAt28 != 51068) {
                        return false;
                    } else {
                        c10 = charAt27;
                        c11 = charAt14;
                        c12 = charAt12;
                        c14 = charAt10;
                        c15 = charAt8;
                        c16 = charAt7;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
            if (!checkDate(c16, c15, charAt9, c14, c13, c12, c11, c10)) {
                return false;
            }
            setCalendar(c16, c15, charAt9, c14, c13, c12, c11, c10);
            char charAt29 = charAt(this.bp + i11);
            if (charAt29 == 'T' || (charAt29 == ' ' && !z)) {
                if (i < i11 + 9 || charAt(this.bp + i11 + 3) != ':' || charAt(this.bp + i11 + 6) != ':') {
                    return false;
                }
                char charAt30 = charAt(this.bp + i11 + 1);
                char charAt31 = charAt(this.bp + i11 + 2);
                char charAt32 = charAt(this.bp + i11 + 4);
                char charAt33 = charAt(this.bp + i11 + 5);
                char charAt34 = charAt(this.bp + i11 + 7);
                char charAt35 = charAt(this.bp + i11 + 8);
                if (!checkTime(charAt30, charAt31, charAt32, charAt33, charAt34, charAt35)) {
                    return false;
                }
                setTime(charAt30, charAt31, charAt32, charAt33, charAt34, charAt35);
                char charAt36 = charAt(this.bp + i11 + 9);
                if (charAt36 == '.') {
                    if (i < i11 + 11 || (charAt2 = charAt(this.bp + i11 + 10)) < '0' || charAt2 > '9') {
                        return false;
                    }
                    int i12 = charAt2 - '0';
                    int i13 = 1;
                    if (i > i11 + 11 && (charAt5 = charAt(this.bp + i11 + 11)) >= '0' && charAt5 <= '9') {
                        i12 = (charAt5 - '0') + (i12 * 10);
                        i13 = 2;
                    }
                    if (i13 != 2 || (charAt4 = charAt(this.bp + i11 + 12)) < '0' || charAt4 > '9') {
                        i6 = i13;
                    } else {
                        i12 = (charAt4 - '0') + (i12 * 10);
                        i6 = 3;
                    }
                    this.calendar.set(14, i12);
                    int i14 = 0;
                    char charAt37 = charAt(this.bp + i11 + 10 + i6);
                    if (charAt37 == '+' || charAt37 == '-') {
                        char charAt38 = charAt(this.bp + i11 + 10 + i6 + 1);
                        if (charAt38 < '0' || charAt38 > '1' || (charAt3 = charAt(this.bp + i11 + 10 + i6 + 2)) < '0' || charAt3 > '9') {
                            return false;
                        }
                        char charAt39 = charAt(this.bp + i11 + 10 + i6 + 3);
                        char c17 = '0';
                        char c18 = '0';
                        if (charAt39 == ':') {
                            c17 = charAt(this.bp + i11 + 10 + i6 + 4);
                            if ((c17 != '0' && c17 != '3') || (c18 = charAt(this.bp + i11 + 10 + i6 + 5)) != '0') {
                                return false;
                            }
                            i14 = 6;
                        } else if (charAt39 == '0') {
                            c17 = charAt(this.bp + i11 + 10 + i6 + 4);
                            if (c17 != '0' && c17 != '3') {
                                return false;
                            }
                            i14 = 5;
                        } else {
                            i14 = 3;
                        }
                        setTimeZone(charAt37, charAt38, charAt3, c17, c18);
                    } else if (charAt37 == 'Z') {
                        i14 = 1;
                        if (this.calendar.getTimeZone().getRawOffset() != 0) {
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                            }
                        }
                    }
                    char charAt40 = charAt(this.bp + i11 + 10 + i6 + i14);
                    if (charAt40 != 26 && charAt40 != '\"') {
                        return false;
                    }
                    int i15 = this.bp + i11 + 10 + i6 + i14;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.token = 5;
                    return true;
                }
                this.calendar.set(14, 0);
                int i16 = this.bp + i11 + 9;
                this.bp = i16;
                this.ch = charAt(i16);
                this.token = 5;
                if (charAt36 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                    if (availableIDs2.length > 0) {
                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                    }
                }
                return true;
            } else if (charAt29 == '\"' || charAt29 == 26 || charAt29 == 26085 || charAt29 == 51068) {
                this.calendar.set(11, 0);
                this.calendar.set(12, 0);
                this.calendar.set(13, 0);
                this.calendar.set(14, 0);
                int i17 = this.bp + i11;
                this.bp = i17;
                this.ch = charAt(i17);
                this.token = 5;
                return true;
            } else if ((charAt29 != '+' && charAt29 != '-') || this.len != i11 + 6 || charAt(this.bp + i11 + 3) != ':' || charAt(this.bp + i11 + 4) != '0' || charAt(this.bp + i11 + 5) != '0') {
                return false;
            } else {
                setTime('0', '0', '0', '0', '0', '0');
                this.calendar.set(14, 0);
                setTimeZone(charAt29, charAt(this.bp + i11 + 1), charAt(this.bp + i11 + 2));
                return true;
            }
        }
    }

    protected void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    protected void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    protected void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * SdkConfigData.DEFAULT_REQUEST_INTERVAL * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    private boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c == '1') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '2' || c2 < '0' || c2 > '4') {
            return false;
        }
        if (c3 >= '0' && c3 <= '5') {
            if (c4 < '0' || c4 > '9') {
                return false;
            }
        } else if (c3 != '6' || c4 != '0') {
            return false;
        }
        if (c5 >= '0' && c5 <= '5') {
            if (c6 < '0' || c6 > '9') {
                return false;
            }
        } else if (c5 != '6' || c6 != '0') {
            return false;
        }
        return true;
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c < '1' || c > '3' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 == '0') {
            if (c6 < '1' || c6 > '9') {
                return false;
            }
        } else if (c5 != '1') {
            return false;
        } else {
            if (c6 != '0' && c6 != '1' && c6 != '2') {
                return false;
            }
        }
        if (i == 48) {
            if (i2 < 49 || i2 > 57) {
                return false;
            }
        } else if (i == 49 || i == 50) {
            if (i2 < 48 || i2 > 57) {
                return false;
            }
        } else if (i != 51) {
            return false;
        } else {
            if (i2 != 48 && i2 != 49) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        return this.bp == this.len || (this.ch == 26 && this.bp + 1 == this.len);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i;
        int i2;
        int i3;
        char charAt;
        this.matchStat = 0;
        int i4 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i5 = length + 1;
        char charAt2 = charAt(length);
        boolean z = charAt2 == '\"';
        if (z) {
            i = i5 + 1;
            charAt2 = charAt(i5);
        } else {
            i = i5;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i6 = charAt2 - '0';
            while (true) {
                i3 = i2 + 1;
                charAt = charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i6 = (i6 * 10) + (charAt - '0');
                i2 = i3;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if (i6 < 0) {
                this.matchStat = -1;
                return 0;
            } else {
                if (z) {
                    if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0;
                    }
                    charAt = charAt(i3);
                    i3++;
                }
                while (charAt != ',' && charAt != '}') {
                    if (isWhitespace(charAt)) {
                        charAt = charAt(i3);
                        i3++;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                this.bp = i3 - 1;
                if (charAt == ',') {
                    int i7 = this.bp + 1;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 3;
                    this.token = 16;
                    return z2 ? -i6 : i6;
                }
                if (charAt == '}') {
                    this.bp = i3 - 1;
                    int i8 = this.bp + 1;
                    this.bp = i8;
                    char charAt3 = charAt(i8);
                    while (true) {
                        if (charAt3 == ',') {
                            this.token = 16;
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            this.ch = charAt(i9);
                            break;
                        } else if (charAt3 == ']') {
                            this.token = 15;
                            int i10 = this.bp + 1;
                            this.bp = i10;
                            this.ch = charAt(i10);
                            break;
                        } else if (charAt3 == '}') {
                            this.token = 13;
                            int i11 = this.bp + 1;
                            this.bp = i11;
                            this.ch = charAt(i11);
                            break;
                        } else if (charAt3 == 26) {
                            this.token = 20;
                            break;
                        } else if (isWhitespace(charAt3)) {
                            int i12 = this.bp + 1;
                            this.bp = i12;
                            charAt3 = charAt(i12);
                        } else {
                            this.bp = i4;
                            this.ch = c;
                            this.matchStat = -1;
                            return 0;
                        }
                    }
                    this.matchStat = 4;
                }
                return z2 ? -i6 : i6;
            }
        }
        this.matchStat = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (isWhitespace(this.ch)) {
                next();
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String subString = subString(i2, indexOf - i2);
        if (subString.indexOf(92) != -1) {
            while (true) {
                int i3 = 0;
                for (int i4 = indexOf - 1; i4 >= 0 && charAt(i4) == '\\'; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    break;
                }
                indexOf = indexOf('\"', indexOf + 1);
            }
            int length2 = indexOf - ((this.bp + cArr.length) + 1);
            subString = readString(sub_chars(this.bp + cArr.length + 1, length2), length2);
        }
        char charAt = charAt(indexOf + 1);
        while (charAt != ',' && charAt != '}') {
            if (isWhitespace(charAt)) {
                indexOf++;
                charAt = charAt(indexOf + 1);
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        this.bp = indexOf + 1;
        this.ch = charAt;
        if (charAt == ',') {
            int i5 = this.bp + 1;
            this.bp = i5;
            this.ch = charAt(i5);
            this.matchStat = 3;
            return subString;
        }
        int i6 = this.bp + 1;
        this.bp = i6;
        char charAt2 = charAt(i6);
        if (charAt2 == ',') {
            this.token = 16;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c;
            this.matchStat = -1;
            return stringDefaultValue();
        }
        this.matchStat = 4;
        return subString;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        int i;
        Date date;
        char c;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i3 = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i4 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', i4);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i4;
            if (scanISO8601DateIfMatch(false, indexOf - i4)) {
                date = this.calendar.getTime();
                c = charAt(indexOf + 1);
                this.bp = i3;
                while (c != ',' && c != '}') {
                    if (isWhitespace(c)) {
                        indexOf++;
                        c = charAt(indexOf + 1);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.bp = indexOf + 1;
                this.ch = c;
            } else {
                this.bp = i3;
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            long j = 0;
            if (charAt2 == '-') {
                i = i4 + 1;
                charAt2 = charAt(i4);
                z = true;
            } else {
                i = i4;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                j = charAt2 - '0';
                while (true) {
                    i2 = i + 1;
                    charAt = charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i = i2;
                }
                if (charAt == ',' || charAt == '}') {
                    this.bp = i2 - 1;
                    charAt2 = charAt;
                } else {
                    charAt2 = charAt;
                }
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
            c = charAt2;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c == ',') {
            int i5 = this.bp + 1;
            this.bp = i5;
            this.ch = charAt(i5);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i6 = this.bp + 1;
        this.bp = i6;
        char charAt3 = charAt(i6);
        if (charAt3 == ',') {
            this.token = 16;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt3 == ']') {
            this.token = 15;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt3 == '}') {
            this.token = 13;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt3 == 26) {
            this.token = 20;
        } else {
            this.bp = i3;
            this.ch = c2;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.bp = i2;
                char charAt2 = charAt(this.bp);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (isWhitespace(charAt2)) {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        charAt2 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            } else if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            } else {
                j = (j ^ charAt) * 1099511628211L;
                i = i2;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
        if (r0 != ']') goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
        if (r3.size() != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
        r1 = r6 + 1;
        r0 = charAt(r6);
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ca, code lost:
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        int i;
        char charAt;
        Collection<String> collection;
        char charAt2;
        int i2;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        if (charAt(length) == '[') {
            char charAt3 = charAt(i3);
            int i4 = i3 + 1;
            while (true) {
                if (charAt3 == '\"') {
                    int indexOf = indexOf('\"', i4);
                    if (indexOf == -1) {
                        throw new JSONException("unclosed str");
                    }
                    String subString = subString(i4, indexOf - i4);
                    if (subString.indexOf(92) != -1) {
                        while (true) {
                            int i5 = 0;
                            for (int i6 = indexOf - 1; i6 >= 0 && charAt(i6) == '\\'; i6--) {
                                i5++;
                            }
                            if (i5 % 2 == 0) {
                                break;
                            }
                            indexOf = indexOf('\"', indexOf + 1);
                        }
                        int i7 = indexOf - i4;
                        subString = readString(sub_chars(i4, i7), i7);
                    }
                    int i8 = indexOf + 1;
                    i2 = i8 + 1;
                    charAt2 = charAt(i8);
                    newCollectionByType.add(subString);
                } else if (charAt3 != 'n' || !this.text.startsWith("ull", i4)) {
                    break;
                } else {
                    int i9 = i4 + 3;
                    int i10 = i9 + 1;
                    charAt2 = charAt(i9);
                    newCollectionByType.add(null);
                    i2 = i10;
                }
                if (charAt2 == ',') {
                    charAt3 = charAt(i2);
                    i4 = i2 + 1;
                } else if (charAt2 == ']') {
                    i = i2 + 1;
                    charAt = charAt(i2);
                    while (isWhitespace(charAt)) {
                        charAt = charAt(i);
                        i++;
                    }
                    collection = newCollectionByType;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        } else if (this.text.startsWith("ull", i3)) {
            int i11 = i3 + 3;
            i = i11 + 1;
            charAt = charAt(i11);
            collection = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        this.bp = i;
        if (charAt == ',') {
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return collection;
        } else if (charAt == '}') {
            char charAt4 = charAt(this.bp);
            int i12 = i;
            while (true) {
                if (charAt4 == ',') {
                    this.token = 16;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    break;
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i14 = this.bp + 1;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    break;
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    break;
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.ch = charAt4;
                    break;
                } else {
                    boolean z = false;
                    char c = charAt4;
                    while (isWhitespace(c)) {
                        int i16 = i12 + 1;
                        c = charAt(i12);
                        this.bp = i16;
                        z = true;
                        i12 = i16;
                    }
                    if (!z) {
                        this.matchStat = -1;
                        return null;
                    }
                    charAt4 = c;
                }
            }
            this.matchStat = 4;
            return collection;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        int i;
        boolean z;
        int i2;
        int i3;
        char charAt;
        this.matchStat = 0;
        int i4 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length + this.bp;
        int i5 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            i = i5 + 1;
            charAt2 = charAt(i5);
        } else {
            i = i5;
        }
        if (charAt2 != '-') {
            z = false;
            i2 = i;
        } else {
            i2 = i + 1;
            charAt2 = charAt(i);
            z = true;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i3 = i2 + 1;
                charAt = charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i2 = i3;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z2) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i3);
                i3++;
            }
            if (charAt == ',' || charAt == '}') {
                this.bp = i3 - 1;
            }
            if (!(j >= 0 || (j == Long.MIN_VALUE && z))) {
                this.bp = i4;
                this.ch = c;
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != ',') {
                if (charAt == '}') {
                    int i6 = this.bp + 1;
                    this.bp = i6;
                    char charAt3 = charAt(i6);
                    while (true) {
                        if (charAt3 == ',') {
                            this.token = 16;
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            this.ch = charAt(i7);
                            break;
                        } else if (charAt3 == ']') {
                            this.token = 15;
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            break;
                        } else if (charAt3 == '}') {
                            this.token = 13;
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            this.ch = charAt(i9);
                            break;
                        } else if (charAt3 == 26) {
                            this.token = 20;
                            break;
                        } else if (isWhitespace(charAt3)) {
                            int i10 = this.bp + 1;
                            this.bp = i10;
                            charAt3 = charAt(i10);
                        } else {
                            this.bp = i4;
                            this.ch = c;
                            this.matchStat = -1;
                            return 0L;
                        }
                    }
                    this.matchStat = 4;
                    return z ? -j : j;
                } else if (isWhitespace(charAt)) {
                    this.bp = i3;
                    charAt = charAt(i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        }
        this.bp = i4;
        this.ch = c;
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        char charAt;
        boolean z;
        int i2;
        int i3;
        int i4;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i5 = this.bp;
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            i = i6 + 1;
            charAt2 = charAt(i6);
        } else {
            i = i6;
        }
        if (charAt2 == 't') {
            int i7 = i + 1;
            if (charAt(i) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(i7) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i9 = i8 + 1;
            if (charAt(i8) != 'e') {
                this.matchStat = -1;
                return false;
            }
            if (z2) {
                i4 = i9 + 1;
                if (charAt(i9) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
            } else {
                i4 = i9;
            }
            this.bp = i4;
            charAt = charAt(this.bp);
            z = true;
        } else if (charAt2 == 'f') {
            int i10 = i + 1;
            if (charAt(i) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i11 = i10 + 1;
            if (charAt(i10) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i12 = i11 + 1;
            if (charAt(i11) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i13 = i12 + 1;
            if (charAt(i12) != 'e') {
                this.matchStat = -1;
                return false;
            }
            if (z2) {
                i3 = i13 + 1;
                if (charAt(i13) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
            } else {
                i3 = i13;
            }
            this.bp = i3;
            charAt = charAt(this.bp);
            z = false;
        } else if (charAt2 == '1') {
            if (z2) {
                i2 = i + 1;
                if (charAt(i) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
            } else {
                i2 = i;
            }
            this.bp = i2;
            charAt = charAt(this.bp);
            z = true;
        } else if (charAt2 == '0') {
            if (z2) {
                int i14 = i + 1;
                if (charAt(i) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
                i = i14;
            }
            this.bp = i;
            charAt = charAt(this.bp);
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != ',') {
            if (charAt == '}') {
                int i15 = this.bp + 1;
                this.bp = i15;
                char charAt3 = charAt(i15);
                while (true) {
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i16 = this.bp + 1;
                        this.bp = i16;
                        this.ch = charAt(i16);
                        break;
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i17 = this.bp + 1;
                        this.bp = i17;
                        this.ch = charAt(i17);
                        break;
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i18 = this.bp + 1;
                        this.bp = i18;
                        this.ch = charAt(i18);
                        break;
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        break;
                    } else if (isWhitespace(charAt3)) {
                        int i19 = this.bp + 1;
                        this.bp = i19;
                        charAt3 = charAt(i19);
                    } else {
                        this.matchStat = -1;
                        return false;
                    }
                }
                this.matchStat = 4;
                return z;
            } else if (isWhitespace(charAt)) {
                int i20 = this.bp + 1;
                this.bp = i20;
                charAt = charAt(i20);
            } else {
                this.bp = i5;
                charAt(this.bp);
                this.matchStat = -1;
                return false;
            }
        }
        int i21 = this.bp + 1;
        this.bp = i21;
        this.ch = charAt(i21);
        this.matchStat = 3;
        this.token = 16;
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt2 = charAt(i5);
        while (isWhitespace(charAt2)) {
            charAt2 = charAt(i6);
            i6++;
        }
        boolean z = charAt2 == '\"';
        if (z) {
            i = i6 + 1;
            charAt2 = charAt(i6);
        } else {
            i = i6;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i7 = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i7 = (i7 * 10) + (charAt - '0');
                i2 = i4;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0;
                }
                charAt = charAt(i4);
                i4++;
            }
            if (i7 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return z2 ? -i7 : i7;
                }
            }
            this.bp = i4;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return z2 ? -i7 : i7;
        }
        if (charAt2 == 'n') {
            int i8 = i2 + 1;
            if (charAt(i2) == 'u') {
                int i9 = i8 + 1;
                if (charAt(i8) == 'l') {
                    int i10 = i9 + 1;
                    if (charAt(i9) == 'l') {
                        this.matchStat = 5;
                        int i11 = i10 + 1;
                        char charAt3 = charAt(i10);
                        if (z && charAt3 == '\"') {
                            i3 = i11 + 1;
                            charAt3 = charAt(i11);
                        } else {
                            i3 = i11;
                        }
                        while (charAt3 != ',') {
                            if (charAt3 == ']') {
                                this.bp = i3;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0;
                            } else if (isWhitespace(charAt3)) {
                                charAt3 = charAt(i3);
                                i3++;
                            } else {
                                this.matchStat = -1;
                                return 0;
                            }
                        }
                        this.bp = i3;
                        this.ch = charAt(this.bp);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        long j;
        int i5;
        char c2;
        int i6;
        int i7;
        int i8;
        double parseDouble;
        int i9;
        this.matchStat = 0;
        int i10 = this.bp;
        int i11 = i10 + 1;
        char charAt2 = charAt(i10);
        boolean z = charAt2 == '\"';
        if (z) {
            i = i11 + 1;
            charAt2 = charAt(i11);
        } else {
            i = i11;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j2 = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i2 = i4;
            }
            long j3 = 1;
            if (charAt == '.') {
                int i12 = i4 + 1;
                char charAt3 = charAt(i4);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    long j4 = (charAt3 - '0') + (j2 * 10);
                    long j5 = 10;
                    while (true) {
                        i9 = i12 + 1;
                        charAt = charAt(i12);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j4 = (j4 * 10) + (charAt - '0');
                        j5 *= 10;
                        i12 = i9;
                    }
                    j3 = j5;
                    j = j4;
                    i5 = i9;
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
            } else {
                j = j2;
                i5 = i4;
            }
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i13 = i5 + 1;
                c2 = charAt(i5);
                if (c2 == '+' || c2 == '-') {
                    i5 = i13 + 1;
                    c2 = charAt(i13);
                } else {
                    i5 = i13;
                }
                while (c2 >= '0' && c2 <= '9') {
                    c2 = charAt(i5);
                    i5++;
                }
            } else {
                c2 = charAt;
            }
            if (z) {
                if (c2 != '\"') {
                    this.matchStat = -1;
                    return 0.0d;
                }
                i8 = i5 + 1;
                c2 = charAt(i5);
                i6 = this.bp + 1;
                i7 = (i8 - i6) - 2;
            } else {
                i6 = this.bp;
                i7 = (i5 - i6) - 1;
                i8 = i5;
            }
            if (!z3 && i7 < 20) {
                parseDouble = j / j3;
                if (z2) {
                    parseDouble = -parseDouble;
                }
            } else {
                parseDouble = Double.parseDouble(subString(i6, i7));
            }
            if (c2 == c) {
                this.bp = i8;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            this.matchStat = -1;
            return parseDouble;
        }
        if (charAt2 == 'n') {
            int i14 = i2 + 1;
            if (charAt(i2) == 'u') {
                int i15 = i14 + 1;
                if (charAt(i14) == 'l') {
                    int i16 = i15 + 1;
                    if (charAt(i15) == 'l') {
                        this.matchStat = 5;
                        int i17 = i16 + 1;
                        char charAt4 = charAt(i16);
                        if (z && charAt4 == '\"') {
                            i3 = i17 + 1;
                            charAt4 = charAt(i17);
                        } else {
                            i3 = i17;
                        }
                        while (charAt4 != ',') {
                            if (charAt4 == ']') {
                                this.bp = i3;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0.0d;
                            } else if (isWhitespace(charAt4)) {
                                charAt4 = charAt(i3);
                                i3++;
                            } else {
                                this.matchStat = -1;
                                return 0.0d;
                            }
                        }
                        this.bp = i3;
                        this.ch = charAt(this.bp);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0.0d;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0.0d;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt2 = charAt(i5);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            i = i6 + 1;
            charAt2 = charAt(i6);
        } else {
            i = i6;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            i2 = i + 1;
            charAt2 = charAt(i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i2 = i4;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z2) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(i4);
                i4++;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
                z = true;
            }
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.bp = i4;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j : j;
        }
        if (charAt2 == 'n') {
            int i7 = i2 + 1;
            if (charAt(i2) == 'u') {
                int i8 = i7 + 1;
                if (charAt(i7) == 'l') {
                    int i9 = i8 + 1;
                    if (charAt(i8) == 'l') {
                        this.matchStat = 5;
                        int i10 = i9 + 1;
                        char charAt3 = charAt(i9);
                        if (z2 && charAt3 == '\"') {
                            i3 = i10 + 1;
                            charAt3 = charAt(i10);
                        } else {
                            i3 = i10;
                        }
                        while (charAt3 != ',') {
                            if (charAt3 == ']') {
                                this.bp = i3;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            } else if (isWhitespace(charAt3)) {
                                charAt3 = charAt(i3);
                                i3++;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.bp = i3;
                        this.ch = charAt(this.bp);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c) {
        int i;
        Date date;
        char c2;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i3 = this.bp;
        char c3 = this.ch;
        int i4 = this.bp;
        int i5 = i4 + 1;
        char charAt2 = charAt(i4);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', i5);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i5;
            if (scanISO8601DateIfMatch(false, indexOf - i5)) {
                date = this.calendar.getTime();
                c2 = charAt(indexOf + 1);
                this.bp = i3;
                while (c2 != ',' && c2 != ']') {
                    if (isWhitespace(c2)) {
                        indexOf++;
                        c2 = charAt(indexOf + 1);
                    } else {
                        this.bp = i3;
                        this.ch = c3;
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.bp = indexOf + 1;
                this.ch = c2;
            } else {
                this.bp = i3;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            long j = 0;
            if (charAt2 == '-') {
                i = i5 + 1;
                charAt2 = charAt(i5);
                z = true;
            } else {
                i = i5;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                j = charAt2 - '0';
                while (true) {
                    i2 = i + 1;
                    charAt = charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i = i2;
                }
                if (charAt == ',' || charAt == ']') {
                    this.bp = i2 - 1;
                    charAt2 = charAt;
                } else {
                    charAt2 = charAt;
                }
            }
            if (j < 0) {
                this.bp = i3;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
            c2 = charAt2;
        } else {
            if (charAt2 == 'n') {
                int i6 = i5 + 1;
                if (charAt(i5) == 'u') {
                    int i7 = i6 + 1;
                    if (charAt(i6) == 'l') {
                        int i8 = i7 + 1;
                        if (charAt(i7) == 'l') {
                            c2 = charAt(i8);
                            this.bp = i8;
                            date = null;
                        }
                    }
                }
            }
            this.bp = i3;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        if (c2 == ',') {
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            return date;
        }
        int i10 = this.bp + 1;
        this.bp = i10;
        char charAt3 = charAt(i10);
        if (charAt3 == ',') {
            this.token = 16;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt3 == ']') {
            this.token = 15;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (charAt3 == '}') {
            this.token = 13;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = charAt(i13);
        } else if (charAt3 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i3;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i + i3, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "pos " + this.bp + ", json : " + (this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        int i2;
        char c;
        int i3 = this.bp;
        char c2 = this.ch;
        while (isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt = this.text.charAt(length);
            while (isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                int i5 = i4 + 1;
                c = this.text.charAt(i4);
                while (true) {
                    i2 = i5;
                    if (!isWhitespace(c)) {
                        break;
                    }
                    i5 = i2 + 1;
                    c = this.text.charAt(i2);
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            c = this.ch;
        }
        if (c == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(this.bp);
            int i6 = 0;
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            while (true) {
                if (isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i3;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, '\"');
                    if (i6 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i7 = i6 + 1;
                    strArr[i6] = scanSymbol;
                    while (isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i6 = i7;
                    } else {
                        if (strArr.length != i7) {
                            String[] strArr3 = new String[i7];
                            System.arraycopy(strArr, 0, strArr3, 0, i7);
                            strArr = strArr3;
                        }
                        while (isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c == 'n' && this.text.startsWith("ull", this.bp + 1)) {
            this.bp += 4;
            this.ch = this.text.charAt(this.bp);
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.bp = i;
            this.ch = charAt(this.bp);
            return true;
        }
        this.matchStat = -2;
        return false;
    }
}
