package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
/* loaded from: classes10.dex */
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
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        char c2;
        char c3;
        int i6;
        char c4;
        char charAt;
        int i7;
        int i8;
        char charAt2;
        char charAt3;
        char charAt4;
        char charAt5;
        if (i < 8) {
            return false;
        }
        char charAt6 = charAt(this.bp);
        char charAt7 = charAt(this.bp + 1);
        char charAt8 = charAt(this.bp + 2);
        char charAt9 = charAt(this.bp + 3);
        char charAt10 = charAt(this.bp + 4);
        char charAt11 = charAt(this.bp + 5);
        char charAt12 = charAt(this.bp + 6);
        char charAt13 = charAt(this.bp + 7);
        if (!z && i > 13) {
            char charAt14 = charAt((this.bp + i) - 1);
            char charAt15 = charAt((this.bp + i) - 2);
            if (charAt6 == '/' && charAt7 == 'D' && charAt8 == 'a' && charAt9 == 't' && charAt10 == 'e' && charAt11 == '(' && charAt14 == '/' && charAt15 == ')') {
                int i9 = -1;
                for (int i10 = 6; i10 < i; i10++) {
                    char charAt16 = charAt(this.bp + i10);
                    if (charAt16 != '+') {
                        if (charAt16 < '0' || charAt16 > '9') {
                            break;
                        }
                    } else {
                        i9 = i10;
                    }
                }
                if (i9 == -1) {
                    return false;
                }
                int i11 = this.bp + 6;
                long parseLong = Long.parseLong(subString(i11, (i9 + this.bp) - i11));
                this.calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i == 8 || i == 14 || ((i == 16 && ((charAt5 = charAt(this.bp + 10)) == 'T' || charAt5 == ' ')) || (i == 17 && charAt(this.bp + 6) != '-'))) {
            if (z) {
                return false;
            }
            char charAt17 = charAt(this.bp + 8);
            boolean z2 = charAt10 == '-' && charAt13 == '-';
            boolean z3 = z2 && i == 16;
            boolean z4 = z2 && i == 17;
            if (z4 || z3) {
                charAt13 = charAt(this.bp + 9);
                charAt10 = charAt11;
                charAt11 = charAt12;
                charAt12 = charAt17;
            }
            if (!checkDate(charAt6, charAt7, charAt8, charAt9, charAt10, charAt11, charAt12, charAt13)) {
                return false;
            }
            setCalendar(charAt6, charAt7, charAt8, charAt9, charAt10, charAt11, charAt12, charAt13);
            if (i != 8) {
                char charAt18 = charAt(this.bp + 9);
                char charAt19 = charAt(this.bp + 10);
                char charAt20 = charAt(this.bp + 11);
                char charAt21 = charAt(this.bp + 12);
                char charAt22 = charAt(this.bp + 13);
                if ((z4 && charAt19 == 'T' && charAt22 == ':' && charAt(this.bp + 16) == 'Z') || (z3 && ((charAt19 == ' ' || charAt19 == 'T') && charAt22 == ':'))) {
                    charAt19 = charAt(this.bp + 14);
                    c2 = charAt(this.bp + 15);
                    c = '0';
                    charAt22 = '0';
                    charAt18 = charAt21;
                } else {
                    c = charAt21;
                    c2 = charAt20;
                    charAt20 = charAt17;
                }
                if (!checkTime(charAt20, charAt18, charAt19, c2, c, charAt22)) {
                    return false;
                }
                if (i == 17 && !z4) {
                    char charAt23 = charAt(this.bp + 14);
                    char charAt24 = charAt(this.bp + 15);
                    char charAt25 = charAt(this.bp + 16);
                    if (charAt23 < '0' || charAt23 > '9' || charAt24 < '0' || charAt24 > '9' || charAt25 < '0' || charAt25 > '9') {
                        return false;
                    }
                    i5 = ((charAt23 - '0') * 100) + ((charAt24 - '0') * 10) + (charAt25 - '0');
                } else {
                    i5 = 0;
                }
                int i12 = ((charAt20 - '0') * 10) + (charAt18 - '0');
                i3 = (c2 - '0') + ((charAt19 - '0') * 10);
                i4 = ((c - '0') * 10) + (charAt22 - '0');
                i2 = i12;
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
            char charAt26 = charAt(this.bp + 8);
            char charAt27 = charAt(this.bp + 9);
            if ((charAt10 == '-' && charAt13 == '-') || (charAt10 == '/' && charAt13 == '/')) {
                charAt13 = charAt27;
                c3 = charAt11;
                i6 = 10;
                charAt11 = charAt12;
                c4 = charAt26;
            } else if (charAt10 == '-' && charAt12 == '-') {
                c3 = '0';
                if (charAt26 == ' ') {
                    i6 = 8;
                    c4 = '0';
                } else {
                    i6 = 9;
                    c4 = charAt13;
                    charAt13 = charAt26;
                }
            } else if ((charAt8 == '.' && charAt11 == '.') || (charAt8 == '-' && charAt11 == '-')) {
                charAt11 = charAt10;
                charAt8 = charAt26;
                i6 = 10;
                c3 = charAt9;
                charAt9 = charAt27;
                charAt6 = charAt12;
                c4 = charAt6;
                charAt13 = charAt7;
                charAt7 = charAt13;
            } else if (charAt10 == 24180 || charAt10 == 45380) {
                if (charAt13 == 26376 || charAt13 == 50900) {
                    if (charAt27 == 26085 || charAt27 == 51068) {
                        c3 = charAt11;
                        i6 = 10;
                        charAt11 = charAt12;
                        c4 = '0';
                        charAt13 = charAt26;
                    } else if (charAt(this.bp + 10) == 26085 || charAt(this.bp + 10) == 51068) {
                        charAt13 = charAt27;
                        i6 = 11;
                        c3 = charAt11;
                        charAt11 = charAt12;
                        c4 = charAt26;
                    } else {
                        return false;
                    }
                } else if (charAt12 == 26376 || charAt12 == 50900) {
                    c3 = '0';
                    if (charAt26 == 26085 || charAt26 == 51068) {
                        c4 = '0';
                        i6 = 10;
                    } else if (charAt27 == 26085 || charAt27 == 51068) {
                        c4 = charAt13;
                        i6 = 10;
                        charAt13 = charAt26;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
            if (!checkDate(charAt6, charAt7, charAt8, charAt9, c3, charAt11, c4, charAt13)) {
                return false;
            }
            setCalendar(charAt6, charAt7, charAt8, charAt9, c3, charAt11, c4, charAt13);
            char charAt28 = charAt(this.bp + i6);
            if (charAt28 == 'T' || (charAt28 == ' ' && !z)) {
                if (i < i6 + 9 || charAt(this.bp + i6 + 3) != ':' || charAt(this.bp + i6 + 6) != ':') {
                    return false;
                }
                char charAt29 = charAt(this.bp + i6 + 1);
                char charAt30 = charAt(this.bp + i6 + 2);
                char charAt31 = charAt(this.bp + i6 + 4);
                char charAt32 = charAt(this.bp + i6 + 5);
                char charAt33 = charAt(this.bp + i6 + 7);
                char charAt34 = charAt(this.bp + i6 + 8);
                if (!checkTime(charAt29, charAt30, charAt31, charAt32, charAt33, charAt34)) {
                    return false;
                }
                setTime(charAt29, charAt30, charAt31, charAt32, charAt33, charAt34);
                char charAt35 = charAt(this.bp + i6 + 9);
                if (charAt35 == '.') {
                    if (i < i6 + 11 || (charAt = charAt(this.bp + i6 + 10)) < '0' || charAt > '9') {
                        return false;
                    }
                    int i13 = charAt - '0';
                    int i14 = 1;
                    if (i > i6 + 11 && (charAt4 = charAt(this.bp + i6 + 11)) >= '0' && charAt4 <= '9') {
                        i13 = (charAt4 - '0') + (i13 * 10);
                        i14 = 2;
                    }
                    if (i14 != 2 || (charAt3 = charAt(this.bp + i6 + 12)) < '0' || charAt3 > '9') {
                        i7 = i14;
                        i8 = i13;
                    } else {
                        i7 = 3;
                        i8 = (charAt3 - '0') + (i13 * 10);
                    }
                    this.calendar.set(14, i8);
                    int i15 = 0;
                    char charAt36 = charAt(this.bp + i6 + 10 + i7);
                    if (charAt36 == '+' || charAt36 == '-') {
                        char charAt37 = charAt(this.bp + i6 + 10 + i7 + 1);
                        if (charAt37 < '0' || charAt37 > '1' || (charAt2 = charAt(this.bp + i6 + 10 + i7 + 2)) < '0' || charAt2 > '9') {
                            return false;
                        }
                        char charAt38 = charAt(this.bp + i6 + 10 + i7 + 3);
                        char c5 = '0';
                        char c6 = '0';
                        if (charAt38 == ':') {
                            c5 = charAt(this.bp + i6 + 10 + i7 + 4);
                            if ((c5 != '0' && c5 != '3') || (c6 = charAt(this.bp + i6 + 10 + i7 + 5)) != '0') {
                                return false;
                            }
                            i15 = 6;
                        } else if (charAt38 == '0') {
                            c5 = charAt(this.bp + i6 + 10 + i7 + 4);
                            if (c5 != '0' && c5 != '3') {
                                return false;
                            }
                            i15 = 5;
                        } else {
                            i15 = 3;
                        }
                        setTimeZone(charAt36, charAt37, charAt2, c5, c6);
                    } else if (charAt36 == 'Z') {
                        i15 = 1;
                        if (this.calendar.getTimeZone().getRawOffset() != 0) {
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                            }
                        }
                    }
                    char charAt39 = charAt(this.bp + i6 + 10 + i7 + i15);
                    if (charAt39 != 26 && charAt39 != '\"') {
                        return false;
                    }
                    int i16 = this.bp + i6 + 10 + i7 + i15;
                    this.bp = i16;
                    this.ch = charAt(i16);
                    this.token = 5;
                    return true;
                }
                this.calendar.set(14, 0);
                int i17 = this.bp + i6 + 9;
                this.bp = i17;
                this.ch = charAt(i17);
                this.token = 5;
                if (charAt35 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                    if (availableIDs2.length > 0) {
                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                    }
                }
                return true;
            } else if (charAt28 == '\"' || charAt28 == 26 || charAt28 == 26085 || charAt28 == 51068) {
                this.calendar.set(11, 0);
                this.calendar.set(12, 0);
                this.calendar.set(13, 0);
                this.calendar.set(14, 0);
                int i18 = this.bp + i6;
                this.bp = i18;
                this.ch = charAt(i18);
                this.token = 5;
                return true;
            } else if ((charAt28 != '+' && charAt28 != '-') || this.len != i6 + 6 || charAt(this.bp + i6 + 3) != ':' || charAt(this.bp + i6 + 4) != '0' || charAt(this.bp + i6 + 5) != '0') {
                return false;
            } else {
                setTime('0', '0', '0', '0', '0', '0');
                this.calendar.set(14, 0);
                setTimeZone(charAt28, charAt(this.bp + i6 + 1), charAt(this.bp + i6 + 2));
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
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000) + ((((c4 - '0') * 10) + (c5 - '0')) * 60 * 1000);
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
        int i;
        String str;
        this.matchStat = 0;
        int i2 = this.bp;
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
        int i3 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i3);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String subString = subString(i3, indexOf - i3);
        if (subString.indexOf(92) != -1) {
            while (true) {
                int i4 = 0;
                for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                    i4++;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                indexOf = indexOf('\"', indexOf + 1);
            }
            int length2 = indexOf - ((this.bp + cArr.length) + 1);
            String readString = readString(sub_chars(this.bp + cArr.length + 1, length2), length2);
            i = indexOf;
            str = readString;
        } else {
            i = indexOf;
            str = subString;
        }
        char charAt = charAt(i + 1);
        while (charAt != ',' && charAt != '}') {
            if (isWhitespace(charAt)) {
                i++;
                charAt = charAt(i + 1);
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        this.bp = i + 1;
        this.ch = charAt;
        if (charAt == ',') {
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 3;
            return str;
        }
        int i7 = this.bp + 1;
        this.bp = i7;
        char charAt2 = charAt(i7);
        if (charAt2 == ',') {
            this.token = 16;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c;
            this.matchStat = -1;
            return stringDefaultValue();
        }
        this.matchStat = 4;
        return str;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        boolean z;
        int i;
        Date date;
        char c;
        int i2;
        char charAt;
        int i3;
        this.matchStat = 0;
        int i4 = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i5 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', i5);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i5;
            if (scanISO8601DateIfMatch(false, indexOf - i5)) {
                date = this.calendar.getTime();
                char charAt3 = charAt(indexOf + 1);
                this.bp = i4;
                while (true) {
                    i3 = indexOf;
                    c = charAt3;
                    if (c == ',' || c == '}') {
                        break;
                    } else if (isWhitespace(c)) {
                        indexOf = i3 + 1;
                        charAt3 = charAt(indexOf + 1);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.bp = i3 + 1;
                this.ch = c;
            } else {
                this.bp = i4;
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            long j = 0;
            if (charAt2 != '-') {
                z = false;
                i = i5;
            } else {
                charAt2 = charAt(i5);
                i = i5 + 1;
                z = true;
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
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i7 = this.bp + 1;
        this.bp = i7;
        char charAt4 = charAt(i7);
        if (charAt4 == ',') {
            this.token = 16;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt4 == 26) {
            this.token = 20;
        } else {
            this.bp = i4;
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ad, code lost:
        if (r0 != ']') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
        if (r3.size() != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b5, code lost:
        r1 = r6 + 1;
        r0 = charAt(r6);
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ce, code lost:
        r13.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:?, code lost:
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
        int i3;
        String str;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int length = this.bp + cArr.length;
        int i4 = length + 1;
        if (charAt(length) == '[') {
            char charAt3 = charAt(i4);
            int i5 = i4 + 1;
            while (true) {
                if (charAt3 == '\"') {
                    int indexOf = indexOf('\"', i5);
                    if (indexOf == -1) {
                        throw new JSONException("unclosed str");
                    }
                    String subString = subString(i5, indexOf - i5);
                    if (subString.indexOf(92) != -1) {
                        while (true) {
                            int i6 = 0;
                            for (int i7 = indexOf - 1; i7 >= 0 && charAt(i7) == '\\'; i7--) {
                                i6++;
                            }
                            if (i6 % 2 == 0) {
                                break;
                            }
                            indexOf = indexOf('\"', indexOf + 1);
                        }
                        int i8 = indexOf - i5;
                        String readString = readString(sub_chars(i5, i8), i8);
                        i3 = indexOf;
                        str = readString;
                    } else {
                        i3 = indexOf;
                        str = subString;
                    }
                    int i9 = i3 + 1;
                    i2 = i9 + 1;
                    char charAt4 = charAt(i9);
                    newCollectionByType.add(str);
                    charAt2 = charAt4;
                } else if (charAt3 != 'n' || !this.text.startsWith("ull", i5)) {
                    break;
                } else {
                    int i10 = i5 + 3;
                    int i11 = i10 + 1;
                    charAt2 = charAt(i10);
                    newCollectionByType.add(null);
                    i2 = i11;
                }
                if (charAt2 == ',') {
                    charAt3 = charAt(i2);
                    i5 = i2 + 1;
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
        } else if (this.text.startsWith("ull", i4)) {
            int i12 = i4 + 3;
            i = i12 + 1;
            charAt = charAt(i12);
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
            char charAt5 = charAt(this.bp);
            while (true) {
                if (charAt5 == ',') {
                    this.token = 16;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = charAt(i13);
                    break;
                } else if (charAt5 == ']') {
                    this.token = 15;
                    int i14 = this.bp + 1;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    break;
                } else if (charAt5 == '}') {
                    this.token = 13;
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    break;
                } else if (charAt5 == 26) {
                    this.token = 20;
                    this.ch = charAt5;
                    break;
                } else {
                    int i16 = i;
                    char c = charAt5;
                    boolean z = false;
                    while (isWhitespace(c)) {
                        int i17 = i16 + 1;
                        c = charAt(i16);
                        this.bp = i17;
                        z = true;
                        i16 = i17;
                    }
                    if (!z) {
                        this.matchStat = -1;
                        return null;
                    }
                    charAt5 = c;
                    i = i16;
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
        char c;
        int i3;
        char charAt;
        this.matchStat = 0;
        int i4 = this.bp;
        char c2 = this.ch;
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
            c = charAt2;
        } else {
            i2 = i + 1;
            z = true;
            c = charAt(i);
        }
        if (c >= '0' && c <= '9') {
            long j = c - '0';
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
                this.ch = c2;
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
                            this.ch = c2;
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
        this.ch = c2;
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
        long j2;
        int i5;
        int i6;
        int i7;
        int i8;
        double parseDouble;
        int i9;
        char charAt2;
        this.matchStat = 0;
        int i10 = this.bp;
        int i11 = i10 + 1;
        char charAt3 = charAt(i10);
        boolean z = charAt3 == '\"';
        if (z) {
            i = i11 + 1;
            charAt3 = charAt(i11);
        } else {
            i = i11;
        }
        boolean z2 = charAt3 == '-';
        if (z2) {
            i2 = i + 1;
            charAt3 = charAt(i);
        } else {
            i2 = i;
        }
        if (charAt3 >= '0' && charAt3 <= '9') {
            long j3 = charAt3 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j3 = (j3 * 10) + (charAt - '0');
                i2 = i4;
            }
            if (!(charAt == '.')) {
                j = 1;
                j2 = j3;
                i5 = i4;
            } else {
                int i12 = i4 + 1;
                char charAt4 = charAt(i4);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    long j4 = (charAt4 - '0') + (j3 * 10);
                    long j5 = 10;
                    while (true) {
                        i9 = i12 + 1;
                        charAt2 = charAt(i12);
                        if (charAt2 < '0' || charAt2 > '9') {
                            break;
                        }
                        j4 = (j4 * 10) + (charAt2 - '0');
                        j5 *= 10;
                        i12 = i9;
                    }
                    j = j5;
                    j2 = j4;
                    charAt = charAt2;
                    i5 = i9;
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
            }
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i13 = i5 + 1;
                charAt = charAt(i5);
                if (charAt == '+' || charAt == '-') {
                    i5 = i13 + 1;
                    charAt = charAt(i13);
                } else {
                    i5 = i13;
                }
                while (charAt >= '0' && charAt <= '9') {
                    charAt = charAt(i5);
                    i5++;
                }
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0.0d;
                }
                i8 = i5 + 1;
                charAt = charAt(i5);
                i6 = this.bp + 1;
                i7 = (i8 - i6) - 2;
            } else {
                i6 = this.bp;
                i7 = (i5 - i6) - 1;
                i8 = i5;
            }
            if (!z3 && i7 < 20) {
                parseDouble = j2 / j;
                if (z2) {
                    parseDouble = -parseDouble;
                }
            } else {
                parseDouble = Double.parseDouble(subString(i6, i7));
            }
            if (charAt == c) {
                this.bp = i8;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            this.matchStat = -1;
            return parseDouble;
        }
        if (charAt3 == 'n') {
            int i14 = i2 + 1;
            if (charAt(i2) == 'u') {
                int i15 = i14 + 1;
                if (charAt(i14) == 'l') {
                    int i16 = i15 + 1;
                    if (charAt(i15) == 'l') {
                        this.matchStat = 5;
                        int i17 = i16 + 1;
                        char charAt5 = charAt(i16);
                        if (z && charAt5 == '\"') {
                            i3 = i17 + 1;
                            charAt5 = charAt(i17);
                        } else {
                            i3 = i17;
                        }
                        while (charAt5 != ',') {
                            if (charAt5 == ']') {
                                this.bp = i3;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0.0d;
                            } else if (isWhitespace(charAt5)) {
                                charAt5 = charAt(i3);
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
        boolean z;
        int i;
        Date date;
        char c2;
        int i2;
        char charAt;
        int i3;
        this.matchStat = 0;
        int i4 = this.bp;
        char c3 = this.ch;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt2 = charAt(i5);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', i6);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i6;
            if (scanISO8601DateIfMatch(false, indexOf - i6)) {
                date = this.calendar.getTime();
                char charAt3 = charAt(indexOf + 1);
                this.bp = i4;
                while (true) {
                    i3 = indexOf;
                    c2 = charAt3;
                    if (c2 == ',' || c2 == ']') {
                        break;
                    } else if (isWhitespace(c2)) {
                        indexOf = i3 + 1;
                        charAt3 = charAt(indexOf + 1);
                    } else {
                        this.bp = i4;
                        this.ch = c3;
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.bp = i3 + 1;
                this.ch = c2;
            } else {
                this.bp = i4;
                this.ch = c3;
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == '-' || (charAt2 >= '0' && charAt2 <= '9')) {
            long j = 0;
            if (charAt2 != '-') {
                z = false;
                i = i6;
            } else {
                charAt2 = charAt(i6);
                i = i6 + 1;
                z = true;
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
                this.bp = i4;
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
                int i7 = i6 + 1;
                if (charAt(i6) == 'u') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        int i9 = i8 + 1;
                        if (charAt(i8) == 'l') {
                            date = null;
                            c2 = charAt(i9);
                            this.bp = i9;
                        }
                    }
                }
            }
            this.bp = i4;
            this.ch = c3;
            this.matchStat = -1;
            return null;
        }
        if (c2 == ',') {
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            return date;
        }
        int i11 = this.bp + 1;
        this.bp = i11;
        char charAt4 = charAt(i11);
        if (charAt4 == ',') {
            this.token = 16;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.ch = charAt(i12);
        } else if (charAt4 == ']') {
            this.token = 15;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = charAt(i13);
        } else if (charAt4 == '}') {
            this.token = 13;
            int i14 = this.bp + 1;
            this.bp = i14;
            this.ch = charAt(i14);
        } else if (charAt4 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i4;
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
        String[] strArr;
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
            String[] strArr2 = i >= 0 ? new String[i] : new String[4];
            int i6 = 0;
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
                    if (i6 == strArr2.length) {
                        strArr = new String[strArr2.length + (strArr2.length >> 1) + 1];
                        System.arraycopy(strArr2, 0, strArr, 0, strArr2.length);
                    } else {
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
                        strArr2 = strArr;
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
