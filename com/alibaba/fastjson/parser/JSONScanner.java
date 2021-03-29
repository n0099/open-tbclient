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
import kotlin.text.Typography;
/* loaded from: classes.dex */
public final class JSONScanner extends JSONLexerBase {
    public final int len;
    public final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i, char[] cArr) {
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

    public static boolean checkDate(char c2, char c3, char c4, char c5, char c6, char c7, int i, int i2) {
        if (c2 >= '1' && c2 <= '3' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9' && c5 >= '0' && c5 <= '9') {
            if (c6 == '0') {
                if (c7 < '1' || c7 > '9') {
                    return false;
                }
            } else if (c6 != '1' || (c7 != '0' && c7 != '1' && c7 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            } else if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            } else if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
        if (r6 <= '4') goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean checkTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        if (c2 == '0') {
            if (c3 < '0' || c3 > '9') {
                return false;
            }
        } else if (c2 != '1') {
            if (c2 == '2') {
                if (c3 >= '0') {
                }
            }
            return false;
        } else if (c3 < '0' || c3 > '9') {
            return false;
        }
        if (c4 < '0' || c4 > '5') {
            if (c4 != '6' || c5 != '0') {
                return false;
            }
        } else if (c5 < '0' || c5 > '9') {
            return false;
        }
        return (c6 < '0' || c6 > '5') ? c6 == '6' && c7 == '0' : c7 >= '0' && c7 <= '9';
    }

    private void setCalendar(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c2 - '0') * 1000) + ((c3 - '0') * 100) + ((c4 - '0') * 10) + (c5 - '0'));
        this.calendar.set(2, (((c6 - '0') * 10) + (c7 - '0')) - 1);
        this.calendar.set(5, ((c8 - '0') * 10) + (c9 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 == 0) {
                int i3 = i2 / 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = (i4 * 2) + i;
                    char charAt = this.text.charAt(i5);
                    char charAt2 = this.text.charAt(i5 + 1);
                    char c2 = '0';
                    int i6 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c2 = '7';
                    }
                    bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c2));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i2);
        }
        return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        return i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c2, int i) {
        return this.text.indexOf(c2, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i = this.bp;
        int i2 = this.len;
        if (i != i2) {
            return this.ch == 26 && i + 1 == i2;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char charAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(charAt)) {
            charAt = this.text.charAt(i);
            i++;
        }
        if (charAt == ':') {
            this.bp = i;
            this.ch = charAt(i);
            return true;
        }
        this.matchStat = -2;
        return false;
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
        } catch (Exception e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char charAt = i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
        this.ch = charAt;
        return charAt;
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c2) {
        char c3;
        long j;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c4 = this.ch;
        int i3 = i2 + 1;
        char charAt = charAt(i2);
        if (charAt == '\"') {
            int indexOf = indexOf(Typography.quote, i3);
            if (indexOf != -1) {
                this.bp = i3;
                if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                    date = this.calendar.getTime();
                    c3 = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c3 != ',' && c3 != ']') {
                        if (JSONLexerBase.isWhitespace(c3)) {
                            indexOf++;
                            c3 = charAt(indexOf + 1);
                        } else {
                            this.bp = i2;
                            this.ch = c4;
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c3;
                } else {
                    this.bp = i2;
                    this.ch = c4;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c5 = '9';
            char c6 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n') {
                    int i4 = i3 + 1;
                    if (charAt(i3) == 'u') {
                        int i5 = i4 + 1;
                        if (charAt(i4) == 'l') {
                            int i6 = i5 + 1;
                            if (charAt(i5) == 'l') {
                                c3 = charAt(i6);
                                this.bp = i6;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i2;
                this.ch = c4;
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i3);
                i3++;
                z = true;
            }
            if (charAt < '0' || charAt > '9') {
                c3 = charAt;
                j = 0;
            } else {
                j = charAt - '0';
                while (true) {
                    i = i3 + 1;
                    c3 = charAt(i3);
                    if (c3 < c6 || c3 > c5) {
                        break;
                    }
                    j = (j * 10) + (c3 - '0');
                    i3 = i;
                    c5 = '9';
                    c6 = '0';
                }
                if (c3 == ',' || c3 == ']') {
                    this.bp = i - 1;
                }
            }
            if (j < 0) {
                this.bp = i2;
                this.ch = c4;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (c3 == ',') {
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            return date;
        }
        int i8 = this.bp + 1;
        this.bp = i8;
        char charAt2 = charAt(i8);
        if (charAt2 == ',') {
            this.token = 16;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (charAt2 == 26) {
            this.ch = JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c4;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:102:0x017a -> B:91:0x014b */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c4 -> B:52:0x00b4). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double scanDouble(char c2) {
        int i;
        char charAt;
        long j;
        int i2;
        int i3;
        double parseDouble;
        int i4;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt2 = charAt(i5);
        boolean z = charAt2 == '\"';
        if (z) {
            int i7 = i6 + 1;
            char charAt3 = charAt(i6);
            i6 = i7;
            charAt2 = charAt3;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            int i8 = i6 + 1;
            char charAt4 = charAt(i6);
            i6 = i8;
            charAt2 = charAt4;
        }
        if (charAt2 >= '0') {
            char c3 = '9';
            if (charAt2 <= '9') {
                long j2 = charAt2 - '0';
                while (true) {
                    i = i6 + 1;
                    charAt = charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j2 = (j2 * 10) + (charAt - '0');
                    i6 = i;
                }
                if (charAt == '.') {
                    int i9 = i + 1;
                    char charAt5 = charAt(i);
                    if (charAt5 < '0' || charAt5 > '9') {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                    j2 = (j2 * 10) + (charAt5 - '0');
                    j = 10;
                    while (true) {
                        i4 = i9 + 1;
                        charAt = charAt(i9);
                        if (charAt < '0' || charAt > c3) {
                            break;
                        }
                        j2 = (j2 * 10) + (charAt - '0');
                        j *= 10;
                        i9 = i4;
                        c3 = '9';
                    }
                    i = i4;
                } else {
                    j = 1;
                }
                boolean z3 = charAt == 'e' || charAt == 'E';
                if (z3) {
                    int i10 = i + 1;
                    char charAt6 = charAt(i);
                    if (charAt6 == '+' || charAt6 == '-') {
                        int i11 = i10 + 1;
                        charAt = charAt(i10);
                        i = i11;
                        if (charAt >= '0' && charAt <= '9') {
                            i10 = i + 1;
                            charAt6 = charAt(i);
                        }
                    }
                    i = i10;
                    charAt = charAt6;
                    if (charAt >= '0') {
                        i10 = i + 1;
                        charAt6 = charAt(i);
                        i = i10;
                        charAt = charAt6;
                        if (charAt >= '0') {
                        }
                    }
                }
                if (!z) {
                    i2 = this.bp;
                    i3 = (i - i2) - 1;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0.0d;
                } else {
                    int i12 = i + 1;
                    char charAt7 = charAt(i);
                    i2 = this.bp + 1;
                    i3 = (i12 - i2) - 2;
                    i = i12;
                    charAt = charAt7;
                }
                if (z3 || i3 >= 20) {
                    parseDouble = Double.parseDouble(subString(i2, i3));
                } else {
                    parseDouble = j2 / j;
                    if (z2) {
                        parseDouble = -parseDouble;
                    }
                }
                if (charAt == c2) {
                    this.bp = i;
                    this.ch = charAt(i);
                    this.matchStat = 3;
                    this.token = 16;
                    return parseDouble;
                }
                this.matchStat = -1;
                return parseDouble;
            }
        }
        if (charAt2 == 'n') {
            int i13 = i6 + 1;
            if (charAt(i6) == 'u') {
                int i14 = i13 + 1;
                if (charAt(i13) == 'l') {
                    int i15 = i14 + 1;
                    if (charAt(i14) == 'l') {
                        this.matchStat = 5;
                        int i16 = i15 + 1;
                        char charAt8 = charAt(i15);
                        if (z && charAt8 == '\"') {
                            int i17 = i16 + 1;
                            char charAt9 = charAt(i16);
                            i16 = i17;
                            charAt8 = charAt9;
                        }
                        while (charAt8 != ',') {
                            if (charAt8 == ']') {
                                this.bp = i16;
                                this.ch = charAt(i16);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0.0d;
                            } else if (JSONLexerBase.isWhitespace(charAt8)) {
                                int i18 = i16 + 1;
                                char charAt10 = charAt(i16);
                                i16 = i18;
                                charAt8 = charAt10;
                            } else {
                                this.matchStat = -1;
                                return 0.0d;
                            }
                        }
                        this.bp = i16;
                        this.ch = charAt(i16);
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

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0152, code lost:
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0104  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanFieldBoolean(char[] cArr) {
        char charAt;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i = this.bp;
        int length = cArr.length + i;
        int i2 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            int i3 = i2 + 1;
            char charAt3 = charAt(i2);
            i2 = i3;
            charAt2 = charAt3;
        }
        if (charAt2 == 't') {
            int i4 = i2 + 1;
            if (charAt(i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i5 = i4 + 1;
            if (charAt(i4) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(i5) != 'e') {
                this.matchStat = -1;
                return false;
            }
            if (z2) {
                int i7 = i6 + 1;
                if (charAt(i6) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
                i6 = i7;
            }
            this.bp = i6;
            charAt = charAt(i6);
        } else {
            if (charAt2 == 'f') {
                int i8 = i2 + 1;
                if (charAt(i2) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i9 = i8 + 1;
                if (charAt(i8) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i10 = i9 + 1;
                if (charAt(i9) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i11 = i10 + 1;
                if (charAt(i10) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                if (z2) {
                    int i12 = i11 + 1;
                    if (charAt(i11) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i11 = i12;
                }
                this.bp = i11;
                charAt = charAt(i11);
            } else if (charAt2 == '1') {
                if (z2) {
                    int i13 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i13;
                }
                this.bp = i2;
                charAt = charAt(i2);
            } else if (charAt2 == '0') {
                if (z2) {
                    int i14 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i14;
                }
                this.bp = i2;
                charAt = charAt(i2);
            } else {
                this.matchStat = -1;
                return false;
            }
            z = false;
            while (true) {
                if (charAt != ',') {
                    int i15 = this.bp + 1;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.matchStat = 3;
                    this.token = 16;
                    break;
                } else if (charAt == '}') {
                    int i16 = this.bp + 1;
                    this.bp = i16;
                    char charAt4 = charAt(i16);
                    while (true) {
                        if (charAt4 == ',') {
                            this.token = 16;
                            int i17 = this.bp + 1;
                            this.bp = i17;
                            this.ch = charAt(i17);
                            break;
                        } else if (charAt4 == ']') {
                            this.token = 15;
                            int i18 = this.bp + 1;
                            this.bp = i18;
                            this.ch = charAt(i18);
                            break;
                        } else if (charAt4 == '}') {
                            this.token = 13;
                            int i19 = this.bp + 1;
                            this.bp = i19;
                            this.ch = charAt(i19);
                            break;
                        } else if (charAt4 == 26) {
                            this.token = 20;
                            break;
                        } else if (JSONLexerBase.isWhitespace(charAt4)) {
                            int i20 = this.bp + 1;
                            this.bp = i20;
                            charAt4 = charAt(i20);
                        } else {
                            this.matchStat = -1;
                            return false;
                        }
                    }
                    this.matchStat = 4;
                } else if (JSONLexerBase.isWhitespace(charAt)) {
                    int i21 = this.bp + 1;
                    this.bp = i21;
                    charAt = charAt(i21);
                } else {
                    this.bp = i;
                    charAt(i);
                    this.matchStat = -1;
                    return false;
                }
            }
        }
        z = true;
        while (true) {
            if (charAt != ',') {
            }
            int i212 = this.bp + 1;
            this.bp = i212;
            charAt = charAt(i212);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        char c2;
        long j;
        char c3;
        Date date;
        int i;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c4 = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt = charAt(length);
        if (charAt == '\"') {
            int indexOf = indexOf(Typography.quote, i3);
            if (indexOf != -1) {
                this.bp = i3;
                if (scanISO8601DateIfMatch(false, indexOf - i3)) {
                    date = this.calendar.getTime();
                    c3 = charAt(indexOf + 1);
                    this.bp = i2;
                    while (c3 != ',' && c3 != '}') {
                        if (JSONLexerBase.isWhitespace(c3)) {
                            indexOf++;
                            c3 = charAt(indexOf + 1);
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    this.bp = indexOf + 1;
                    this.ch = c3;
                } else {
                    this.bp = i2;
                    this.matchStat = -1;
                    return null;
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c5 = '9';
            char c6 = '0';
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '-') {
                charAt = charAt(i3);
                i3++;
                z = true;
            }
            if (charAt < '0' || charAt > '9') {
                c2 = charAt;
                j = 0;
            } else {
                j = charAt - '0';
                while (true) {
                    i = i3 + 1;
                    c2 = charAt(i3);
                    if (c2 < c6 || c2 > c5) {
                        break;
                    }
                    j = (j * 10) + (c2 - '0');
                    i3 = i;
                    c5 = '9';
                    c6 = '0';
                }
                if (c2 == ',' || c2 == '}') {
                    this.bp = i - 1;
                }
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            c3 = c2;
            date = new Date(j);
        }
        if (c3 == ',') {
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i5 = this.bp + 1;
        this.bp = i5;
        char charAt2 = charAt(i5);
        if (charAt2 == ',') {
            this.token = 16;
            int i6 = this.bp + 1;
            this.bp = i6;
            this.ch = charAt(i6);
        } else if (charAt2 == ']') {
            this.token = 15;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (charAt2 == '}') {
            this.token = 13;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (charAt2 == 26) {
            this.token = 20;
        } else {
            this.bp = i2;
            this.ch = c4;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:46:0x0087 -> B:39:0x0076 */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(i3);
            i3++;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(i3);
            i3++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i4 = (i4 * 10) + (charAt - '0');
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i4 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0;
                }
                int i5 = i + 1;
                char charAt3 = charAt(i);
                i = i5;
                charAt = charAt3;
            }
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    int i6 = i + 1;
                    char charAt4 = charAt(i);
                    i = i6;
                    charAt = charAt4;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i7 = i - 1;
            this.bp = i7;
            if (charAt == ',') {
                int i8 = i7 + 1;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -i4 : i4;
            }
            if (charAt == '}') {
                this.bp = i7;
                int i9 = i7 + 1;
                this.bp = i9;
                char charAt5 = charAt(i9);
                while (true) {
                    if (charAt5 == ',') {
                        this.token = 16;
                        int i10 = this.bp + 1;
                        this.bp = i10;
                        this.ch = charAt(i10);
                        break;
                    } else if (charAt5 == ']') {
                        this.token = 15;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        this.ch = charAt(i11);
                        break;
                    } else if (charAt5 == '}') {
                        this.token = 13;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        this.ch = charAt(i12);
                        break;
                    } else if (charAt5 == 26) {
                        this.token = 20;
                        break;
                    } else if (JSONLexerBase.isWhitespace(charAt5)) {
                        int i13 = this.bp + 1;
                        this.bp = i13;
                        charAt5 = charAt(i13);
                    } else {
                        this.bp = i2;
                        this.ch = c2;
                        this.matchStat = -1;
                        return 0;
                    }
                }
                this.matchStat = 4;
            }
            return z2 ? -i4 : i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0112, code lost:
        r20.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0115, code lost:
        if (r11 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0118, code lost:
        return -r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
        return r2;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            charAt2 = charAt(i3);
            i3++;
        }
        if (charAt2 == '-') {
            z = true;
            charAt2 = charAt(i3);
            i3++;
        } else {
            z = false;
        }
        if (charAt2 >= '0') {
            char c3 = '9';
            if (charAt2 <= '9') {
                long j = charAt2 - '0';
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(i3);
                    if (charAt < '0' || charAt > c3) {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i3 = i;
                    c3 = '9';
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
                    int i4 = i + 1;
                    char charAt3 = charAt(i);
                    i = i4;
                    charAt = charAt3;
                }
                if (charAt == ',' || charAt == '}') {
                    this.bp = i - 1;
                }
                if (!(j >= 0 || (j == Long.MIN_VALUE && z))) {
                    this.bp = i2;
                    this.ch = c2;
                    this.matchStat = -1;
                    return 0L;
                }
                while (charAt != ',') {
                    if (charAt == '}') {
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        char charAt4 = charAt(i5);
                        while (true) {
                            if (charAt4 == ',') {
                                this.token = 16;
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                this.ch = charAt(i6);
                                break;
                            } else if (charAt4 == ']') {
                                this.token = 15;
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                this.ch = charAt(i7);
                                break;
                            } else if (charAt4 == '}') {
                                this.token = 13;
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                this.ch = charAt(i8);
                                break;
                            } else if (charAt4 == 26) {
                                this.token = 20;
                                break;
                            } else if (JSONLexerBase.isWhitespace(charAt4)) {
                                int i9 = this.bp + 1;
                                this.bp = i9;
                                charAt4 = charAt(i9);
                            } else {
                                this.bp = i2;
                                this.ch = c2;
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                    } else if (JSONLexerBase.isWhitespace(charAt)) {
                        this.bp = i;
                        int i10 = i + 1;
                        char charAt5 = charAt(i);
                        i = i10;
                        charAt = charAt5;
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
        }
        this.bp = i2;
        this.ch = c2;
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c2 = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (JSONLexerBase.isWhitespace(this.ch)) {
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
        int indexOf = indexOf(Typography.quote, i2);
        if (indexOf != -1) {
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
                    indexOf = indexOf(Typography.quote, indexOf + 1);
                }
                int i5 = this.bp;
                int length2 = indexOf - ((cArr.length + i5) + 1);
                subString = JSONLexerBase.readString(sub_chars(i5 + cArr.length + 1, length2), length2);
            }
            char charAt = charAt(indexOf + 1);
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    indexOf++;
                    charAt = charAt(indexOf + 1);
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i6 = indexOf + 1;
            this.bp = i6;
            this.ch = charAt;
            if (charAt == ',') {
                int i7 = i6 + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            }
            int i8 = i6 + 1;
            this.bp = i8;
            char charAt2 = charAt(i8);
            if (charAt2 == ',') {
                this.token = 16;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.bp = i;
                this.ch = c2;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ca, code lost:
        if (r1 != ']') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:
        if (r3.size() != 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
        r1 = r5 + 1;
        r2 = charAt(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00db, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        char charAt;
        int i;
        boolean z;
        int i2;
        char charAt2;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        if (charAt(length) == '[') {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            while (true) {
                if (charAt3 == '\"') {
                    int indexOf = indexOf(Typography.quote, i4);
                    if (indexOf != -1) {
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
                                indexOf = indexOf(Typography.quote, indexOf + 1);
                            }
                            int i7 = indexOf - i4;
                            subString = JSONLexerBase.readString(sub_chars(i4, i7), i7);
                        }
                        int i8 = indexOf + 1;
                        i2 = i8 + 1;
                        charAt2 = charAt(i8);
                        newCollectionByType.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                } else if (charAt3 != 'n' || !this.text.startsWith("ull", i4)) {
                    break;
                } else {
                    int i9 = i4 + 3;
                    i2 = i9 + 1;
                    charAt2 = charAt(i9);
                    newCollectionByType.add(null);
                }
                if (charAt2 == ',') {
                    i4 = i2 + 1;
                    charAt3 = charAt(i2);
                } else if (charAt2 == ']') {
                    i = i2 + 1;
                    charAt = charAt(i2);
                    while (JSONLexerBase.isWhitespace(charAt)) {
                        charAt = charAt(i);
                        i++;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        } else if (this.text.startsWith("ull", i3)) {
            int i10 = i3 + 3;
            newCollectionByType = null;
            charAt = charAt(i10);
            i = i10 + 1;
        } else {
            this.matchStat = -1;
            return null;
        }
        this.bp = i;
        if (charAt == ',') {
            this.ch = charAt(i);
            this.matchStat = 3;
            return newCollectionByType;
        } else if (charAt == '}') {
            char charAt4 = charAt(i);
            do {
                if (charAt4 == ',') {
                    this.token = 16;
                    int i11 = this.bp + 1;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.ch = charAt4;
                } else {
                    z = false;
                    while (JSONLexerBase.isWhitespace(charAt4)) {
                        int i14 = i + 1;
                        char charAt5 = charAt(i);
                        this.bp = i14;
                        z = true;
                        charAt4 = charAt5;
                        i = i14;
                    }
                }
                this.matchStat = 4;
                return newCollectionByType;
            } while (z);
            this.matchStat = -1;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
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
                char charAt2 = charAt(i2);
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
                    } else if (JSONLexerBase.isWhitespace(charAt2)) {
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

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:74:0x00fe -> B:63:0x00d1 */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c2) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        while (JSONLexerBase.isWhitespace(charAt2)) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        boolean z = charAt2 == '\"';
        if (z) {
            int i5 = i3 + 1;
            char charAt4 = charAt(i3);
            i3 = i5;
            charAt2 = charAt4;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            int i6 = i3 + 1;
            char charAt5 = charAt(i3);
            i3 = i6;
            charAt2 = charAt5;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i7 = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i7 = (i7 * 10) + (charAt - '0');
                i3 = i;
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
                char charAt6 = charAt(i);
                i++;
                charAt = charAt6;
            }
            if (i7 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (charAt != c2) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return z2 ? -i7 : i7;
                }
            }
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return z2 ? -i7 : i7;
        }
        if (charAt2 == 'n') {
            int i8 = i3 + 1;
            if (charAt(i3) == 'u') {
                int i9 = i8 + 1;
                if (charAt(i8) == 'l') {
                    int i10 = i9 + 1;
                    if (charAt(i9) == 'l') {
                        this.matchStat = 5;
                        int i11 = i10 + 1;
                        char charAt7 = charAt(i10);
                        if (z && charAt7 == '\"') {
                            int i12 = i11 + 1;
                            char charAt8 = charAt(i11);
                            i11 = i12;
                            charAt7 = charAt8;
                        }
                        while (charAt7 != ',') {
                            if (charAt7 == ']') {
                                this.bp = i11;
                                this.ch = charAt(i11);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0;
                            } else if (JSONLexerBase.isWhitespace(charAt7)) {
                                int i13 = i11 + 1;
                                char charAt9 = charAt(i11);
                                i11 = i13;
                                charAt7 = charAt9;
                            } else {
                                this.matchStat = -1;
                                return 0;
                            }
                        }
                        this.bp = i11;
                        this.ch = charAt(i11);
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

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:75:0x0116 -> B:64:0x00e3 */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c2) {
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            int i5 = i3 + 1;
            char charAt4 = charAt(i3);
            i3 = i5;
            charAt2 = charAt4;
        }
        char c3 = '0';
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i = i3 + 1;
                charAt = charAt(i3);
                if (charAt < c3 || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i3 = i;
                c3 = '0';
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
                charAt = charAt(i);
                i++;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
                z = true;
            }
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            while (charAt != c2) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.bp = i;
            this.ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j : j;
        }
        if (charAt2 == 'n') {
            int i6 = i3 + 1;
            if (charAt(i3) == 'u') {
                int i7 = i6 + 1;
                if (charAt(i6) == 'l') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        this.matchStat = 5;
                        int i9 = i8 + 1;
                        char charAt5 = charAt(i8);
                        if (z2 && charAt5 == '\"') {
                            int i10 = i9 + 1;
                            char charAt6 = charAt(i9);
                            i9 = i10;
                            charAt5 = charAt6;
                        }
                        while (charAt5 != ',') {
                            if (charAt5 == ']') {
                                this.bp = i9;
                                this.ch = charAt(i9);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            } else if (JSONLexerBase.isWhitespace(charAt5)) {
                                int i11 = i9 + 1;
                                char charAt7 = charAt(i9);
                                i9 = i11;
                                charAt5 = charAt7;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.bp = i9;
                        this.ch = charAt(i9);
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

    public void setTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        this.calendar.set(11, ((c2 - '0') * 10) + (c3 - '0'));
        this.calendar.set(12, ((c4 - '0') * 10) + (c5 - '0'));
        this.calendar.set(13, ((c6 - '0') * 10) + (c7 - '0'));
    }

    public void setTimeZone(char c2, char c3, char c4) {
        setTimeZone(c2, c3, c4, '0', '0');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i + i2, cArr, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr2 = new char[i2];
            this.text.getChars(i, i2 + i, cArr2, 0);
            return new String(cArr2);
        }
        return this.text.substring(i, i2 + i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i2 + i, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    public void setTimeZone(char c2, char c3, char c4, char c5, char c6) {
        int i = ((((c3 - '0') * 10) + (c4 - '0')) * 3600 * 1000) + ((((c5 - '0') * 10) + (c6 - '0')) * 60 * 1000);
        if (c2 == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean scanISO8601DateIfMatch(boolean z, int i) {
        char charAt;
        char c2;
        char c3;
        char c4;
        int i2;
        int i3;
        int i4;
        int i5;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        int i6;
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        int i7;
        char c16;
        char c17;
        char charAt2;
        int i8;
        int i9;
        char charAt3;
        char c18;
        char c19;
        char charAt4;
        char charAt5;
        char charAt6;
        if (i < 8) {
            return false;
        }
        char charAt7 = charAt(this.bp);
        char charAt8 = charAt(this.bp + 1);
        char charAt9 = charAt(this.bp + 2);
        int i10 = 3;
        char charAt10 = charAt(this.bp + 3);
        char charAt11 = charAt(this.bp + 4);
        char charAt12 = charAt(this.bp + 5);
        char charAt13 = charAt(this.bp + 6);
        char charAt14 = charAt(this.bp + 7);
        if (!z && i > 13) {
            char charAt15 = charAt((this.bp + i) - 1);
            char charAt16 = charAt((this.bp + i) - 2);
            if (charAt7 == '/' && charAt8 == 'D' && charAt9 == 'a' && charAt10 == 't' && charAt11 == 'e' && charAt12 == '(' && charAt15 == '/' && charAt16 == ')') {
                int i11 = -1;
                for (int i12 = 6; i12 < i; i12++) {
                    char charAt17 = charAt(this.bp + i12);
                    if (charAt17 != '+') {
                        if (charAt17 < '0' || charAt17 > '9') {
                            break;
                        }
                    } else {
                        i11 = i12;
                    }
                }
                if (i11 == -1) {
                    return false;
                }
                int i13 = this.bp;
                int i14 = i13 + 6;
                long parseLong = Long.parseLong(subString(i14, (i13 + i11) - i14));
                Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar = calendar;
                calendar.setTimeInMillis(parseLong);
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
                c2 = charAt12;
                c3 = charAt13;
                c4 = charAt18;
            } else {
                c2 = charAt11;
                c3 = charAt12;
                c4 = charAt13;
                charAt = charAt14;
            }
            if (checkDate(charAt7, charAt8, charAt9, charAt10, c2, c3, c4, charAt)) {
                setCalendar(charAt7, charAt8, charAt9, charAt10, c2, c3, c4, charAt);
                if (i != 8) {
                    char charAt19 = charAt(this.bp + 9);
                    char charAt20 = charAt(this.bp + 10);
                    char charAt21 = charAt(this.bp + 11);
                    char charAt22 = charAt(this.bp + 12);
                    char charAt23 = charAt(this.bp + 13);
                    if ((z4 && charAt20 == 'T' && charAt23 == ':' && charAt(this.bp + 16) == 'Z') || (z3 && ((charAt20 == ' ' || charAt20 == 'T') && charAt23 == ':'))) {
                        char charAt24 = charAt(this.bp + 14);
                        c7 = charAt(this.bp + 15);
                        c6 = charAt24;
                        charAt18 = charAt21;
                        c5 = charAt22;
                        c8 = '0';
                        c9 = '0';
                    } else {
                        c5 = charAt19;
                        c6 = charAt20;
                        c7 = charAt21;
                        c8 = charAt22;
                        c9 = charAt23;
                    }
                    if (!checkTime(charAt18, c5, c6, c7, c8, c9)) {
                        return false;
                    }
                    if (i != 17 || z4) {
                        i6 = 0;
                    } else {
                        char charAt25 = charAt(this.bp + 14);
                        char charAt26 = charAt(this.bp + 15);
                        char charAt27 = charAt(this.bp + 16);
                        if (charAt25 < '0' || charAt25 > '9' || charAt26 < '0' || charAt26 > '9' || charAt27 < '0' || charAt27 > '9') {
                            return false;
                        }
                        i6 = ((charAt25 - '0') * 100) + ((charAt26 - '0') * 10) + (charAt27 - '0');
                    }
                    i3 = ((c8 - '0') * 10) + (c9 - '0');
                    i5 = ((charAt18 - '0') * 10) + (c5 - '0');
                    i4 = i6;
                    i2 = ((c6 - '0') * 10) + (c7 - '0');
                } else {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                }
                this.calendar.set(11, i5);
                this.calendar.set(12, i2);
                this.calendar.set(13, i3);
                this.calendar.set(14, i4);
                this.token = 5;
                return true;
            }
            return false;
        } else if (i < 9) {
            return false;
        } else {
            char charAt28 = charAt(this.bp + 8);
            char charAt29 = charAt(this.bp + 9);
            if ((charAt11 != '-' || charAt14 != '-') && (charAt11 != '/' || charAt14 != '/')) {
                if (charAt11 == '-' && charAt13 == '-') {
                    if (charAt28 == ' ') {
                        c16 = charAt9;
                        c17 = charAt12;
                        c11 = charAt14;
                        c12 = charAt10;
                        c13 = charAt7;
                        c14 = charAt8;
                        c10 = '0';
                        c15 = '0';
                        i7 = 8;
                    } else {
                        c16 = charAt9;
                        c11 = charAt28;
                        c13 = charAt7;
                        c10 = '0';
                        i7 = 9;
                        c17 = charAt12;
                        c14 = charAt8;
                        c15 = charAt14;
                        c12 = charAt10;
                    }
                } else if ((charAt9 == '.' && charAt12 == '.') || (charAt9 == '-' && charAt12 == '-')) {
                    c14 = charAt14;
                    c12 = charAt29;
                    c10 = charAt10;
                    c15 = charAt7;
                    c11 = charAt8;
                    i7 = 10;
                    c17 = charAt11;
                    c13 = charAt13;
                    c16 = charAt28;
                } else if (charAt11 != 24180 && charAt11 != 45380) {
                    return false;
                } else {
                    if (charAt14 == 26376 || charAt14 == 50900) {
                        if (charAt29 == 26085 || charAt29 == 51068) {
                            c10 = charAt12;
                            c11 = charAt28;
                            c12 = charAt10;
                            c13 = charAt7;
                            c14 = charAt8;
                            c15 = '0';
                            i7 = 10;
                            c17 = charAt13;
                            c16 = charAt9;
                        } else if (charAt(this.bp + 10) != 26085 && charAt(this.bp + 10) != 51068) {
                            return false;
                        } else {
                            c11 = charAt29;
                            c12 = charAt10;
                            c13 = charAt7;
                            i7 = 11;
                        }
                    } else if (charAt13 != 26376 && charAt13 != 50900) {
                        return false;
                    } else {
                        if (charAt28 == 26085 || charAt28 == 51068) {
                            c16 = charAt9;
                            c17 = charAt12;
                            c11 = charAt14;
                            c12 = charAt10;
                            c13 = charAt7;
                            c14 = charAt8;
                            c10 = '0';
                            c15 = '0';
                            i7 = 10;
                        } else if (charAt29 != 26085 && charAt29 != 51068) {
                            return false;
                        } else {
                            c16 = charAt9;
                            c11 = charAt28;
                            c13 = charAt7;
                            c10 = '0';
                            i7 = 10;
                            c17 = charAt12;
                            c14 = charAt8;
                            c15 = charAt14;
                            c12 = charAt10;
                        }
                    }
                }
                if (checkDate(c13, c14, c16, c12, c10, c17, c15, c11)) {
                    return false;
                }
                setCalendar(c13, c14, c16, c12, c10, c17, c15, c11);
                char charAt30 = charAt(this.bp + i7);
                if (charAt30 != 'T' && (charAt30 != ' ' || z)) {
                    if (charAt30 != '\"' && charAt30 != 26 && charAt30 != 26085 && charAt30 != 51068) {
                        if ((charAt30 == '+' || charAt30 == '-') && this.len == i7 + 6 && charAt(this.bp + i7 + 3) == ':' && charAt(this.bp + i7 + 4) == '0' && charAt(this.bp + i7 + 5) == '0') {
                            setTime('0', '0', '0', '0', '0', '0');
                            this.calendar.set(14, 0);
                            setTimeZone(charAt30, charAt(this.bp + i7 + 1), charAt(this.bp + i7 + 2));
                            return true;
                        }
                        return false;
                    }
                    this.calendar.set(11, 0);
                    this.calendar.set(12, 0);
                    this.calendar.set(13, 0);
                    this.calendar.set(14, 0);
                    int i15 = this.bp + i7;
                    this.bp = i15;
                    this.ch = charAt(i15);
                    this.token = 5;
                    return true;
                }
                int i16 = i7 + 9;
                if (i >= i16 && charAt(this.bp + i7 + 3) == ':' && charAt(this.bp + i7 + 6) == ':') {
                    char charAt31 = charAt(this.bp + i7 + 1);
                    char charAt32 = charAt(this.bp + i7 + 2);
                    char charAt33 = charAt(this.bp + i7 + 4);
                    char charAt34 = charAt(this.bp + i7 + 5);
                    char charAt35 = charAt(this.bp + i7 + 7);
                    char charAt36 = charAt(this.bp + i7 + 8);
                    if (checkTime(charAt31, charAt32, charAt33, charAt34, charAt35, charAt36)) {
                        setTime(charAt31, charAt32, charAt33, charAt34, charAt35, charAt36);
                        char charAt37 = charAt(this.bp + i7 + 9);
                        if (charAt37 != '.') {
                            this.calendar.set(14, 0);
                            int i17 = this.bp + i16;
                            this.bp = i17;
                            this.ch = charAt(i17);
                            this.token = 5;
                            if (charAt37 != 'Z' || this.calendar.getTimeZone().getRawOffset() == 0) {
                                return true;
                            }
                            String[] availableIDs = TimeZone.getAvailableIDs(0);
                            if (availableIDs.length > 0) {
                                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                return true;
                            }
                            return true;
                        }
                        int i18 = i7 + 11;
                        if (i >= i18 && (charAt2 = charAt(this.bp + i7 + 10)) >= '0' && charAt2 <= '9') {
                            int i19 = charAt2 - '0';
                            if (i <= i18 || (charAt5 = charAt(this.bp + i7 + 11)) < '0' || charAt5 > '9') {
                                i8 = 1;
                            } else {
                                i19 = (i19 * 10) + (charAt5 - '0');
                                i8 = 2;
                            }
                            if (i8 != 2 || (charAt4 = charAt(this.bp + i7 + 12)) < '0' || charAt4 > '9') {
                                i9 = i8;
                            } else {
                                i19 = (i19 * 10) + (charAt4 - '0');
                                i9 = 3;
                            }
                            this.calendar.set(14, i19);
                            char charAt38 = charAt(this.bp + i7 + 10 + i9);
                            if (charAt38 == '+' || charAt38 == '-') {
                                char charAt39 = charAt(this.bp + i7 + 10 + i9 + 1);
                                if (charAt39 < '0' || charAt39 > '1' || (charAt3 = charAt(this.bp + i7 + 10 + i9 + 2)) < '0' || charAt3 > '9') {
                                    return false;
                                }
                                char charAt40 = charAt(this.bp + i7 + 10 + i9 + 3);
                                if (charAt40 == ':') {
                                    char charAt41 = charAt(this.bp + i7 + 10 + i9 + 4);
                                    if ((charAt41 != '0' && charAt41 != '3') || (c19 = charAt(this.bp + i7 + 10 + i9 + 5)) != '0') {
                                        return false;
                                    }
                                    c18 = charAt41;
                                    i10 = 6;
                                } else if (charAt40 == '0') {
                                    char charAt42 = charAt(this.bp + i7 + 10 + i9 + 4);
                                    if (charAt42 != '0' && charAt42 != '3') {
                                        return false;
                                    }
                                    c18 = charAt42;
                                    c19 = '0';
                                    i10 = 5;
                                } else {
                                    c18 = '0';
                                    c19 = '0';
                                }
                                setTimeZone(charAt38, charAt39, charAt3, c18, c19);
                            } else if (charAt38 == 'Z') {
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                    if (availableIDs2.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                    }
                                }
                                i10 = 1;
                            } else {
                                i10 = 0;
                            }
                            int i20 = i7 + 10 + i9 + i10;
                            char charAt43 = charAt(this.bp + i20);
                            if (charAt43 == 26 || charAt43 == '\"') {
                                int i21 = this.bp + i20;
                                this.bp = i21;
                                this.ch = charAt(i21);
                                this.token = 5;
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            c11 = charAt29;
            c12 = charAt10;
            c13 = charAt7;
            i7 = 10;
            c10 = charAt12;
            c15 = charAt28;
            c14 = charAt8;
            c17 = charAt13;
            c16 = charAt9;
            if (checkDate(c13, c14, c16, c12, c10, c17, c15, c11)) {
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        int i2;
        char c2;
        int i3 = this.bp;
        char c3 = this.ch;
        while (JSONLexerBase.isWhitespace(this.ch)) {
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
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = this.text.charAt(i4);
                i4++;
            }
            if (charAt == ':') {
                i2 = i4 + 1;
                c2 = this.text.charAt(i4);
                while (JSONLexerBase.isWhitespace(c2)) {
                    c2 = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            c2 = this.ch;
        }
        if (c2 == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(i2);
            String[] strArr = i >= 0 ? new String[i] : new String[4];
            int i5 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i3;
                    this.ch = c3;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, Typography.quote);
                    if (i5 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = scanSymbol;
                    while (JSONLexerBase.isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            String[] strArr3 = new String[i6];
                            System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c3;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c2 == 'n' && this.text.startsWith("ull", this.bp + 1)) {
            int i7 = this.bp + 4;
            this.bp = i7;
            this.ch = this.text.charAt(i7);
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }
}
