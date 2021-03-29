package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    public static final int INT_MULTMIN_RADIX_TEN = -214748364;
    public static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    public int bp;
    public char ch;
    public int eofPos;
    public int features;
    public boolean hasSpecial;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public int token;
    public static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    public static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    public static final int[] digits = new int[103];
    public Calendar calendar = null;
    public TimeZone timeZone = JSON.defaultTimeZone;
    public Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    static {
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.stringDefaultValue = null;
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c2) {
        return c2 <= ' ' && (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b');
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c2 = cArr[i3];
            if (c2 != '\\') {
                cArr2[i4] = c2;
                i4++;
            } else {
                i3++;
                char c3 = cArr[i3];
                if (c3 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = Typography.quote;
                } else if (c3 != '\'') {
                    if (c3 != 'F') {
                        if (c3 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\\';
                        } else if (c3 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c3 != 'f') {
                            if (c3 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c3 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\r';
                            } else if (c3 != 'x') {
                                switch (c3) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = '/';
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c3) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed single-quote string");
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[i * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar(Typography.quote);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        continue;
                                    case '0':
                                        putChar((char) 0);
                                        continue;
                                    case '1':
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        putChar((char) 5);
                                        continue;
                                    case '6':
                                        putChar((char) 6);
                                        continue;
                                    case '7':
                                        putChar((char) 7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                continue;
                                                continue;
                                            case 'v':
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                putChar((char) ((digits[next()] * 16) + digits[next()]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (!this.hasSpecial) {
                this.sp++;
            } else {
                int i2 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i2 + 1;
                    cArr3[i2] = next;
                }
            }
        }
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    public abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        } catch (NumberFormatException e2) {
            throw new JSONException(e2.getMessage() + StringUtil.ARRAY_ELEMENT_SEPARATOR + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) && (charAt = numberString.charAt(0)) > '0' && charAt <= '9') {
            throw new JSONException("float overflow : " + numberString);
        }
        return parseFloat;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c2, int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i;
        boolean z;
        int i2 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i3 = this.np;
        int i4 = this.sp + i3;
        if (charAt(i3) == '-') {
            i = Integer.MIN_VALUE;
            i3++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i3 < i4) {
            i2 = -(charAt(i3) - '0');
            i3++;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            char charAt = charAt(i3);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i3 = i5;
                break;
            }
            int i6 = charAt - '0';
            if (i2 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i7 = i2 * 10;
            if (i7 < i + i6) {
                throw new NumberFormatException(numberString());
            }
            i2 = i7 - i6;
            i3 = i5;
        }
        if (z) {
            if (i3 > this.np + 1) {
                return i2;
            }
            throw new NumberFormatException(numberString());
        }
        return -i2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        char c2 = ' ';
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c2 = 'B';
        } else if (charAt == 'L') {
            i2--;
            c2 = 'L';
        } else if (charAt == 'S') {
            i2--;
            c2 = 'S';
        }
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = MULTMIN_RADIX_TEN;
        if (i < i2) {
            j2 = -(charAt(i) - '0');
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < j3) {
                return new BigInteger(numberString());
            }
            long j4 = j2 * 10;
            long j5 = charAt2;
            if (j4 < j + j5) {
                return new BigInteger(numberString());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = MULTMIN_RADIX_TEN;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c2 == 'L') {
                return Long.valueOf(j6);
            }
            if (c2 == 'S') {
                return Short.valueOf((short) j6);
            }
            if (c2 == 'B') {
                return Byte.valueOf((byte) j6);
            }
            return Integer.valueOf((int) j6);
        } else if (i > this.np + 1) {
            if (j2 < -2147483648L || c2 == 'L') {
                return Long.valueOf(j2);
            }
            if (c2 == 'S') {
                return Short.valueOf((short) j2);
            }
            if (c2 == 'B') {
                return Byte.valueOf((byte) j2);
            }
            return Integer.valueOf((int) j2);
        } else {
            throw new NumberFormatException(numberString());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
            }
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005c -> B:12:0x0032). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long longValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i = this.np;
        int i2 = this.sp + i;
        if (charAt(i) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i < i2) {
            int i3 = i + 1;
            j2 = -(charAt(i) - '0');
            i = i3;
            if (i < i2) {
                i3 = i + 1;
                char charAt = charAt(i);
                if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                    i = i3;
                } else {
                    int i4 = charAt - '0';
                    if (j2 < MULTMIN_RADIX_TEN) {
                        throw new NumberFormatException(numberString());
                    }
                    long j3 = j2 * 10;
                    long j4 = i4;
                    if (j3 < j + j4) {
                        throw new NumberFormatException(numberString());
                    }
                    j2 = j3 - j4;
                    i = i3;
                    if (i < i2) {
                    }
                }
            }
            if (z) {
                return -j2;
            }
            if (i > this.np + 1) {
                return j2;
            }
            throw new NumberFormatException(numberString());
        }
        j2 = 0;
        if (i < i2) {
        }
        if (z) {
        }
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char charAt = charAt(length);
        this.ch = charAt;
        if (charAt == '{') {
            next();
            this.token = 12;
        } else if (charAt == '[') {
            next();
            this.token = 14;
        } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i = this.bp + 3;
            this.bp = i;
            this.ch = charAt(i);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c2 = this.ch;
        if (c2 != '_' && c2 != '$' && !Character.isLetter(c2)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c2 = this.ch;
            if (c2 == '/') {
                skipComment();
            } else if (c2 == '\"') {
                scanString();
                return;
            } else if (c2 == ',') {
                next();
                this.token = 16;
                return;
            } else if (c2 >= '0' && c2 <= '9') {
                scanNumber();
                return;
            } else {
                char c3 = this.ch;
                if (c3 == '-') {
                    scanNumber();
                    return;
                }
                switch (c3) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        continue;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i = this.eofPos;
                                this.bp = i;
                                this.pos = i;
                                return;
                            }
                            throw new JSONException("EOF error");
                        }
                        char c4 = this.ch;
                        if (c4 > 31 && c4 != 127) {
                            lexError("illegal.char", String.valueOf((int) c4));
                            next();
                            return;
                        }
                        next();
                        continue;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c2) {
        this.sp = 0;
        while (true) {
            char c3 = this.ch;
            if (c3 == c2) {
                next();
                nextToken();
                return;
            } else if (c3 != ' ' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != '\f' && c3 != '\b') {
                throw new JSONException("not match " + c2 + " - " + this.ch + ", info : " + info());
            } else {
                next();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c2) {
        int i = this.sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.sp;
        this.sp = i2 + 1;
        cArr3[i2] = c2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c2) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                charAt = charAt(this.bp + 4);
                z = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i = 1;
            }
            i = 2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
            charAt = charAt(this.bp + 5);
            i = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c2) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return z;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        this.matchStat = 3;
        return z;
    }

    public Date scanDate(char c2) {
        long j;
        int i;
        Date date;
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i2 = 5;
        if (charAt == '\"') {
            int indexOf = indexOf(Typography.quote, this.bp + 1);
            if (indexOf != -1) {
                int i3 = this.bp + 1;
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
                        indexOf = indexOf(Typography.quote, indexOf + 1);
                    }
                    int i6 = this.bp;
                    int i7 = indexOf - (i6 + 1);
                    subString = readString(sub_chars(i6 + 1, i7), i7);
                }
                int i8 = this.bp;
                int i9 = (indexOf - (i8 + 1)) + 1 + 1;
                int i10 = i9 + 1;
                charAt = charAt(i8 + i9);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                        jSONScanner.close();
                        i2 = i10;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            char c3 = '9';
            int i11 = 2;
            if (charAt != '-' && (charAt < '0' || charAt > '9')) {
                if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                    this.matchStat = 5;
                    charAt = charAt(this.bp + 4);
                    date = null;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } else {
                if (charAt == '-') {
                    charAt = charAt(this.bp + 1);
                    z = true;
                } else {
                    i11 = 1;
                }
                if (charAt >= '0' && charAt <= '9') {
                    j = charAt - '0';
                    while (true) {
                        i = i11 + 1;
                        charAt = charAt(this.bp + i11);
                        if (charAt < '0' || charAt > c3) {
                            break;
                        }
                        j = (j * 10) + (charAt - '0');
                        i11 = i;
                        c3 = '9';
                    }
                } else {
                    j = 0;
                    i = i11;
                }
                if (j < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z) {
                    j = -j;
                }
                date = new Date(j);
                i2 = i;
            }
        }
        if (charAt == ',') {
            int i12 = this.bp + i2;
            this.bp = i12;
            this.ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (charAt == ']') {
            int i13 = i2 + 1;
            char charAt2 = charAt(this.bp + i2);
            if (charAt2 == ',') {
                this.token = 16;
                int i14 = this.bp + i13;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i15 = this.bp + i13;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i16 = this.bp + i13;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt2 == 26) {
                this.token = 20;
                this.bp += i13 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00b1 -> B:50:0x009f). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal scanDecimal(char c2) {
        int i;
        int i2;
        char charAt;
        int i3;
        int i4;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i2 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i = i2;
            }
            if (charAt == '.') {
                int i5 = i2 + 1;
                char charAt3 = charAt(this.bp + i2);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i2 = i5 + 1;
                        charAt = charAt(this.bp + i5);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i5 = i2;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            if (charAt == 'e' || charAt == 'E') {
                int i6 = i2 + 1;
                charAt = charAt(this.bp + i2);
                if (charAt == '+' || charAt == '-') {
                    charAt = charAt(this.bp + i6);
                    i2 = i6 + 1;
                    if (charAt >= '0' && charAt <= '9') {
                        i6 = i2 + 1;
                        charAt = charAt(this.bp + i2);
                    }
                }
                i2 = i6;
                if (charAt >= '0') {
                    i6 = i2 + 1;
                    charAt = charAt(this.bp + i2);
                    i2 = i6;
                    if (charAt >= '0') {
                    }
                }
            }
            if (!z) {
                i3 = this.bp;
                i4 = ((i3 + i2) - i3) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return null;
            } else {
                int i7 = i2 + 1;
                char charAt4 = charAt(this.bp + i2);
                int i8 = this.bp;
                i3 = i8 + 1;
                i4 = ((i8 + i7) - i3) - 2;
                i2 = i7;
                charAt = charAt4;
            }
            BigDecimal bigDecimal = new BigDecimal(sub_chars(i3, i4));
            if (charAt == ',') {
                int i9 = this.bp + i2;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return bigDecimal;
            } else if (charAt == ']') {
                int i10 = i2 + 1;
                char charAt5 = charAt(this.bp + i2);
                if (charAt5 == ',') {
                    this.token = 16;
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt5 == ']') {
                    this.token = 15;
                    int i12 = this.bp + i10;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt5 == '}') {
                    this.token = 13;
                    int i13 = this.bp + i10;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt5 == 26) {
                    this.token = 20;
                    this.bp += i10 - 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return null;
                }
                this.matchStat = 4;
                return bigDecimal;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i14 = i + 3;
            int i15 = i14 + 1;
            char charAt6 = charAt(this.bp + i14);
            if (z && charAt6 == '\"') {
                charAt6 = charAt(this.bp + i15);
                i15++;
            }
            while (charAt6 != ',') {
                if (charAt6 == '}') {
                    int i16 = this.bp + i15;
                    this.bp = i16;
                    this.ch = charAt(i16);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt6)) {
                    charAt6 = charAt(this.bp + i15);
                    i15++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i17 = this.bp + i15;
            this.bp = i17;
            this.ch = charAt(i17);
            this.matchStat = 5;
            this.token = 16;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c9 -> B:53:0x00b7). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double scanDouble(char c2) {
        int i;
        int i2;
        char charAt;
        long j;
        int i3;
        int i4;
        double parseDouble;
        char charAt2;
        this.matchStat = 0;
        char charAt3 = charAt(this.bp + 0);
        boolean z = charAt3 == '\"';
        if (z) {
            charAt3 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt3 == '-';
        if (z2) {
            charAt3 = charAt(this.bp + i);
            i++;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            if (charAt3 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
                this.matchStat = 5;
                int i5 = i + 3;
                int i6 = i5 + 1;
                char charAt4 = charAt(this.bp + i5);
                if (z && charAt4 == '\"') {
                    charAt4 = charAt(this.bp + i6);
                    i6++;
                }
                while (charAt4 != ',') {
                    if (charAt4 == ']') {
                        int i7 = this.bp + i6;
                        this.bp = i7;
                        this.ch = charAt(i7);
                        this.matchStat = 5;
                        this.token = 15;
                        return 0.0d;
                    } else if (isWhitespace(charAt4)) {
                        charAt4 = charAt(this.bp + i6);
                        i6++;
                    } else {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                }
                int i8 = this.bp + i6;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 5;
                this.token = 16;
                return 0.0d;
            }
            this.matchStat = -1;
            return 0.0d;
        }
        long j2 = charAt3 - '0';
        while (true) {
            i2 = i + 1;
            charAt = charAt(this.bp + i);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j2 = (j2 * 10) + (charAt - '0');
            i = i2;
        }
        if (charAt == '.') {
            int i9 = i2 + 1;
            char charAt5 = charAt(this.bp + i2);
            if (charAt5 < '0' || charAt5 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            j2 = (j2 * 10) + (charAt5 - '0');
            long j3 = 10;
            while (true) {
                i2 = i9 + 1;
                charAt2 = charAt(this.bp + i9);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt2 - '0');
                j3 *= 10;
                i9 = i2;
            }
            j = j3;
            charAt = charAt2;
        } else {
            j = 1;
        }
        boolean z3 = charAt == 'e' || charAt == 'E';
        if (z3) {
            int i10 = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt == '+' || charAt == '-') {
                charAt = charAt(this.bp + i10);
                i2 = i10 + 1;
                if (charAt >= '0' && charAt <= '9') {
                    i10 = i2 + 1;
                    charAt = charAt(this.bp + i2);
                }
            }
            i2 = i10;
            if (charAt >= '0') {
                i10 = i2 + 1;
                charAt = charAt(this.bp + i2);
                i2 = i10;
                if (charAt >= '0') {
                }
            }
        }
        if (!z) {
            i3 = this.bp;
            i4 = ((i3 + i2) - i3) - 1;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return 0.0d;
        } else {
            int i11 = i2 + 1;
            char charAt6 = charAt(this.bp + i2);
            int i12 = this.bp;
            i3 = i12 + 1;
            i4 = ((i12 + i11) - i3) - 2;
            i2 = i11;
            charAt = charAt6;
        }
        if (z3 || i4 >= 20) {
            parseDouble = Double.parseDouble(subString(i3, i4));
        } else {
            parseDouble = j2 / j;
            if (z2) {
                parseDouble = -parseDouble;
            }
        }
        if (charAt == c2) {
            int i13 = this.bp + i2;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return parseDouble;
        }
        this.matchStat = -1;
        return parseDouble;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c2) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c2);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c2 = this.ch;
                            if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b' && c2 != ':' && c2 != '/') {
                                throw new JSONException("scan false error");
                            }
                            this.token = 7;
                            return;
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i;
        char charAt;
        int length;
        int i2;
        BigInteger valueOf;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0') {
            char c2 = '9';
            if (charAt2 <= '9') {
                long j = charAt2 - '0';
                while (true) {
                    i = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > c2) {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i3 = i;
                    c2 = '9';
                }
                if (!z) {
                    int i4 = this.bp;
                    length = cArr.length + i4;
                    i2 = ((i4 + i) - length) - 1;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                } else {
                    int i5 = i + 1;
                    charAt = charAt(this.bp + i);
                    int i6 = this.bp;
                    length = cArr.length + i6 + 1;
                    i2 = ((i6 + i5) - length) - 2;
                    i = i5;
                }
                if (i2 >= 20 && (!z2 || i2 >= 21)) {
                    valueOf = new BigInteger(subString(length, i2));
                } else {
                    if (z2) {
                        j = -j;
                    }
                    valueOf = BigInteger.valueOf(j);
                }
                if (charAt == ',') {
                    int i7 = this.bp + i;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 3;
                    this.token = 16;
                    return valueOf;
                } else if (charAt == '}') {
                    int i8 = i + 1;
                    char charAt3 = charAt(this.bp + i);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i9 = this.bp + i8;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i10 = this.bp + i8;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i11 = this.bp + i8;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i8 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return valueOf;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
        }
        if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i3 + 3;
            int i13 = i12 + 1;
            char charAt4 = charAt(this.bp + i12);
            if (z && charAt4 == '\"') {
                charAt4 = charAt(this.bp + i13);
                i13++;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    int i14 = this.bp + i13;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i13);
                    i13++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i15 = this.bp + i13;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        this.matchStat = -1;
        return null;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = i2 + 1;
            if (charAt(this.bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i = i8;
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i9 = i + 1;
        char charAt2 = charAt(this.bp + i);
        if (charAt2 == ',') {
            int i10 = this.bp + i9;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i11 = i9 + 1;
            char charAt3 = charAt(this.bp + i9);
            if (charAt3 == ',') {
                this.token = 16;
                int i12 = this.bp + i11;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i13 = this.bp + i11;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i14 = this.bp + i11;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i11 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    public Date scanFieldDate(char[] cArr) {
        int i;
        long j;
        Date date;
        int i2;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '\"') {
            int indexOf = indexOf(Typography.quote, this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                String subString = subString(length2, indexOf - length2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i4 = 0;
                        for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                            i4++;
                        }
                        if (i4 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf(Typography.quote, indexOf + 1);
                    }
                    int i6 = this.bp;
                    int length3 = indexOf - ((cArr.length + i6) + 1);
                    subString = readString(sub_chars(i6 + cArr.length + 1, length3), length3);
                }
                int i7 = this.bp;
                int length4 = i3 + (indexOf - ((cArr.length + i7) + 1)) + 1;
                i = length4 + 1;
                charAt2 = charAt(i7 + length4);
                JSONScanner jSONScanner = new JSONScanner(subString);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        date = jSONScanner.getCalendar().getTime();
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 != '-' && (charAt2 < '0' || charAt2 > '9')) {
            this.matchStat = -1;
            return null;
        } else {
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3++;
                z = true;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                i = i3;
                j = 0;
            } else {
                j = charAt2 - '0';
                while (true) {
                    i2 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i3 = i2;
                }
                charAt2 = charAt;
                i = i2;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
        }
        if (charAt2 == ',') {
            int i8 = this.bp + i;
            this.bp = i8;
            this.ch = charAt(i8);
            this.matchStat = 3;
            return date;
        } else if (charAt2 == '}') {
            int i9 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i10 = this.bp + i9;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i11 = this.bp + i9;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i12 = this.bp + i9;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i9 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00be -> B:52:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal scanFieldDecimal(char[] cArr) {
        int i;
        char charAt;
        int length;
        int i2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = i;
            }
            if (charAt == '.') {
                int i4 = i + 1;
                char charAt3 = charAt(this.bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i4 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            if (charAt == 'e' || charAt == 'E') {
                int i5 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt == '+' || charAt == '-') {
                    charAt = charAt(this.bp + i5);
                    i = i5 + 1;
                    if (charAt >= '0' && charAt <= '9') {
                        i5 = i + 1;
                        charAt = charAt(this.bp + i);
                    }
                }
                i = i5;
                if (charAt >= '0') {
                    i5 = i + 1;
                    charAt = charAt(this.bp + i);
                    i = i5;
                    if (charAt >= '0') {
                    }
                }
            }
            if (!z) {
                int i6 = this.bp;
                length = cArr.length + i6;
                i2 = ((i6 + i) - length) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return null;
            } else {
                int i7 = i + 1;
                charAt = charAt(this.bp + i);
                int i8 = this.bp;
                length = cArr.length + i8 + 1;
                i2 = ((i8 + i7) - length) - 2;
                i = i7;
            }
            BigDecimal bigDecimal = new BigDecimal(sub_chars(length, i2));
            if (charAt == ',') {
                int i9 = this.bp + i;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return bigDecimal;
            } else if (charAt == '}') {
                int i10 = i + 1;
                char charAt4 = charAt(this.bp + i);
                if (charAt4 == ',') {
                    this.token = 16;
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i12 = this.bp + i10;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i13 = this.bp + i10;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.bp += i10 - 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return null;
                }
                this.matchStat = 4;
                return bigDecimal;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
            this.matchStat = 5;
            int i14 = i3 + 3;
            int i15 = i14 + 1;
            char charAt5 = charAt(this.bp + i14);
            if (z && charAt5 == '\"') {
                charAt5 = charAt(this.bp + i15);
                i15++;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    int i16 = this.bp + i15;
                    this.bp = i16;
                    this.ch = charAt(i16);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i15);
                    i15++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i17 = this.bp + i15;
            this.bp = i17;
            this.ch = charAt(i17);
            this.matchStat = 5;
            this.token = 16;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00de -> B:55:0x00ca). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double scanFieldDouble(char[] cArr) {
        int i;
        char charAt;
        boolean z;
        int length;
        int i2;
        double parseDouble;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            charAt2 = charAt(this.bp + i3);
            i3++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            boolean z4 = z2;
            if (charAt2 == 'n' && charAt(this.bp + i3) == 'u' && charAt(this.bp + i3 + 1) == 'l' && charAt(this.bp + i3 + 2) == 'l') {
                this.matchStat = 5;
                int i4 = i3 + 3;
                int i5 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                if (z4 && charAt3 == '\"') {
                    charAt3 = charAt(this.bp + i5);
                    i5++;
                }
                while (charAt3 != ',') {
                    if (charAt3 == '}') {
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                        this.matchStat = 5;
                        this.token = 13;
                        return 0.0d;
                    } else if (isWhitespace(charAt3)) {
                        charAt3 = charAt(this.bp + i5);
                        i5++;
                    } else {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                }
                int i7 = this.bp + i5;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 5;
                this.token = 16;
                return 0.0d;
            }
            this.matchStat = -1;
            return 0.0d;
        }
        long j = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(this.bp + i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i3 = i;
        }
        long j2 = 1;
        if (charAt == '.') {
            int i8 = i + 1;
            char charAt4 = charAt(this.bp + i);
            if (charAt4 >= '0' && charAt4 <= '9') {
                z = z2;
                j = (j * 10) + (charAt4 - '0');
                j2 = 10;
                while (true) {
                    i = i8 + 1;
                    charAt = charAt(this.bp + i8);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    j2 *= 10;
                    i8 = i;
                }
            } else {
                this.matchStat = -1;
                return 0.0d;
            }
        } else {
            z = z2;
        }
        long j3 = j2;
        boolean z5 = charAt == 'e' || charAt == 'E';
        if (z5) {
            int i9 = i + 1;
            char charAt5 = charAt(this.bp + i);
            if (charAt5 == '+' || charAt5 == '-') {
                int i10 = i9 + 1;
                charAt = charAt(this.bp + i9);
                i = i10;
                if (charAt >= '0' && charAt <= '9') {
                    i9 = i + 1;
                    charAt5 = charAt(this.bp + i);
                }
            }
            i = i9;
            charAt = charAt5;
            if (charAt >= '0') {
                i9 = i + 1;
                charAt5 = charAt(this.bp + i);
                i = i9;
                charAt = charAt5;
                if (charAt >= '0') {
                }
            }
        }
        if (!z) {
            int i11 = this.bp;
            length = cArr.length + i11;
            i2 = ((i11 + i) - length) - 1;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return 0.0d;
        } else {
            int i12 = i + 1;
            char charAt6 = charAt(this.bp + i);
            int i13 = this.bp;
            length = cArr.length + i13 + 1;
            i2 = ((i13 + i12) - length) - 2;
            i = i12;
            charAt = charAt6;
        }
        if (z5 || i2 >= 20) {
            parseDouble = Double.parseDouble(subString(length, i2));
        } else {
            parseDouble = j / j3;
            if (z3) {
                parseDouble = -parseDouble;
            }
        }
        if (charAt == ',') {
            int i14 = this.bp + i;
            this.bp = i14;
            this.ch = charAt(i14);
            this.matchStat = 3;
            this.token = 16;
            return parseDouble;
        } else if (charAt == '}') {
            int i15 = i + 1;
            char charAt7 = charAt(this.bp + i);
            if (charAt7 == ',') {
                this.token = 16;
                int i16 = this.bp + i15;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt7 == ']') {
                this.token = 15;
                int i17 = this.bp + i15;
                this.bp = i17;
                this.ch = charAt(i17);
            } else if (charAt7 == '}') {
                this.token = 13;
                int i18 = this.bp + i15;
                this.bp = i18;
                this.ch = charAt(i18);
            } else if (charAt7 == 26) {
                this.token = 20;
                this.bp += i15 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 4;
            return parseDouble;
        } else {
            this.matchStat = -1;
            return 0.0d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00cd -> B:59:0x00cf). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float scanFieldFloat(char[] cArr) {
        int i;
        char charAt;
        int i2;
        int length;
        int i3;
        float parseFloat;
        char charAt2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i4 = length2 + 1;
        char charAt3 = charAt(this.bp + length2);
        boolean z = charAt3 == '\"';
        if (z) {
            charAt3 = charAt(this.bp + i4);
            i4++;
        }
        boolean z2 = charAt3 == '-';
        if (z2) {
            charAt3 = charAt(this.bp + i4);
            i4++;
        }
        if (charAt3 < '0' || charAt3 > '9') {
            if (charAt3 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                this.matchStat = 5;
                int i5 = i4 + 3;
                int i6 = i5 + 1;
                char charAt4 = charAt(this.bp + i5);
                if (z && charAt4 == '\"') {
                    charAt4 = charAt(this.bp + i6);
                    i6++;
                }
                while (charAt4 != ',') {
                    if (charAt4 == '}') {
                        int i7 = this.bp + i6;
                        this.bp = i7;
                        this.ch = charAt(i7);
                        this.matchStat = 5;
                        this.token = 13;
                        return 0.0f;
                    } else if (isWhitespace(charAt4)) {
                        charAt4 = charAt(this.bp + i6);
                        i6++;
                    } else {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                }
                int i8 = this.bp + i6;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 5;
                this.token = 16;
                return 0.0f;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        int i9 = charAt3 - '0';
        while (true) {
            i = i4 + 1;
            charAt = charAt(this.bp + i4);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i9 = (i9 * 10) + (charAt - '0');
            i4 = i;
        }
        if (charAt == '.') {
            int i10 = i + 1;
            char charAt5 = charAt(this.bp + i);
            if (charAt5 < '0' || charAt5 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            i9 = (i9 * 10) + (charAt5 - '0');
            int i11 = 10;
            while (true) {
                i = i10 + 1;
                charAt2 = charAt(this.bp + i10);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i9 = (i9 * 10) + (charAt2 - '0');
                i11 *= 10;
                i10 = i;
            }
            i2 = i11;
            charAt = charAt2;
        } else {
            i2 = 1;
        }
        boolean z3 = charAt == 'e' || charAt == 'E';
        if (z3) {
            int i12 = i + 1;
            charAt = charAt(this.bp + i);
            if (charAt == '+' || charAt == '-') {
                int i13 = i12 + 1;
                charAt = charAt(this.bp + i12);
                i = i13;
                if (charAt >= '0' && charAt <= '9') {
                    i13 = i + 1;
                    charAt = charAt(this.bp + i);
                    i = i13;
                    if (charAt >= '0') {
                        i13 = i + 1;
                        charAt = charAt(this.bp + i);
                        i = i13;
                        if (charAt >= '0') {
                        }
                    }
                }
            } else {
                i = i12;
                if (charAt >= '0') {
                }
            }
        }
        if (!z) {
            int i14 = this.bp;
            length = cArr.length + i14;
            i3 = ((i14 + i) - length) - 1;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return 0.0f;
        } else {
            int i15 = i + 1;
            char charAt6 = charAt(this.bp + i);
            int i16 = this.bp;
            length = cArr.length + i16 + 1;
            i3 = ((i16 + i15) - length) - 2;
            i = i15;
            charAt = charAt6;
        }
        if (z3 || i3 >= 20) {
            parseFloat = Float.parseFloat(subString(length, i3));
        } else {
            parseFloat = i9 / i2;
            if (z2) {
                parseFloat = -parseFloat;
            }
        }
        if (charAt == ',') {
            int i17 = this.bp + i;
            this.bp = i17;
            this.ch = charAt(i17);
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        } else if (charAt == '}') {
            int i18 = i + 1;
            char charAt7 = charAt(this.bp + i);
            if (charAt7 == ',') {
                this.token = 16;
                int i19 = this.bp + i18;
                this.bp = i19;
                this.ch = charAt(i19);
            } else if (charAt7 == ']') {
                this.token = 15;
                int i20 = this.bp + i18;
                this.bp = i20;
                this.ch = charAt(i20);
            } else if (charAt7 == '}') {
                this.token = 13;
                int i21 = this.bp + i18;
                this.bp = i21;
                this.ch = charAt(i21);
            } else if (charAt7 == 26) {
                this.bp += i18 - 1;
                this.token = 20;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
            this.matchStat = 4;
            return parseFloat;
        } else {
            this.matchStat = -1;
            return 0.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bb, code lost:
        r1 = r4;
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01be, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00d6 -> B:59:0x00d8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] scanFieldFloatArray(char[] cArr) {
        int i;
        char charAt;
        int i2;
        float parseFloat;
        float[] fArr;
        char charAt2;
        this.matchStat = 0;
        float[] fArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i4 = i3 + 1;
        char charAt3 = charAt(this.bp + i3);
        float[] fArr3 = new float[16];
        int i5 = 0;
        while (true) {
            int i6 = (this.bp + i4) - 1;
            boolean z = charAt3 == '-';
            if (z) {
                charAt3 = charAt(this.bp + i4);
                i4++;
            }
            if (charAt3 < '0' || charAt3 > '9') {
                break;
            }
            int i7 = charAt3 - '0';
            while (true) {
                i = i4 + 1;
                charAt = charAt(this.bp + i4);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i7 = (i7 * 10) + (charAt - '0');
                i4 = i;
            }
            if (charAt == '.') {
                int i8 = i + 1;
                char charAt4 = charAt(this.bp + i);
                if (charAt4 < '0' || charAt4 > '9') {
                    break;
                }
                i7 = (i7 * 10) + (charAt4 - '0');
                int i9 = 10;
                while (true) {
                    i = i8 + 1;
                    charAt2 = charAt(this.bp + i8);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i7 = (i7 * 10) + (charAt2 - '0');
                    i9 *= 10;
                    i8 = i;
                }
                int i10 = i9;
                charAt = charAt2;
                i2 = i10;
            } else {
                i2 = 1;
            }
            boolean z2 = charAt == 'e' || charAt == 'E';
            if (z2) {
                int i11 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt == '+' || charAt == '-') {
                    int i12 = i11 + 1;
                    charAt = charAt(this.bp + i11);
                    i = i12;
                    if (charAt >= '0' && charAt <= '9') {
                        i12 = i + 1;
                        charAt = charAt(this.bp + i);
                        i = i12;
                        if (charAt >= '0') {
                            i12 = i + 1;
                            charAt = charAt(this.bp + i);
                            i = i12;
                            if (charAt >= '0') {
                            }
                        }
                    }
                } else {
                    i = i11;
                    if (charAt >= '0') {
                    }
                }
            }
            int i13 = ((this.bp + i) - i6) - 1;
            if (z2 || i13 >= 10) {
                parseFloat = Float.parseFloat(subString(i6, i13));
            } else {
                parseFloat = i7 / i2;
                if (z) {
                    parseFloat = -parseFloat;
                }
            }
            if (i5 >= fArr3.length) {
                float[] fArr4 = new float[(fArr3.length * 3) / 2];
                System.arraycopy(fArr3, 0, fArr4, 0, i5);
                fArr3 = fArr4;
            }
            int i14 = i5 + 1;
            fArr3[i5] = parseFloat;
            if (charAt == ',') {
                i4 = i + 1;
                charAt3 = charAt(this.bp + i);
                fArr = null;
            } else if (charAt == ']') {
                int i15 = i + 1;
                char charAt5 = charAt(this.bp + i);
                if (i14 != fArr3.length) {
                    float[] fArr5 = new float[i14];
                    System.arraycopy(fArr3, 0, fArr5, 0, i14);
                    fArr3 = fArr5;
                }
                if (charAt5 == ',') {
                    this.bp += i15 - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return fArr3;
                } else if (charAt5 == '}') {
                    int i16 = i15 + 1;
                    char charAt6 = charAt(this.bp + i15);
                    if (charAt6 == ',') {
                        this.token = 16;
                        this.bp += i16 - 1;
                        next();
                    } else if (charAt6 == ']') {
                        this.token = 15;
                        this.bp += i16 - 1;
                        next();
                    } else if (charAt6 == '}') {
                        this.token = 13;
                        this.bp += i16 - 1;
                        next();
                    } else if (charAt6 == 26) {
                        this.bp += i16 - 1;
                        this.token = 20;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return fArr3;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } else {
                fArr = null;
                charAt3 = charAt;
                i4 = i;
            }
            fArr2 = fArr;
            i5 = i14;
        }
        this.matchStat = -1;
        return fArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0215, code lost:
        r6 = r4;
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0218, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ae, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b0, code lost:
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00de -> B:58:0x00e0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[][] scanFieldFloatArray2(char[] cArr) {
        int i;
        char charAt;
        int i2;
        float parseFloat;
        int i3;
        float[][] fArr;
        float[][] fArr2;
        char charAt2;
        this.matchStat = 0;
        float[][] fArr3 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        char c2 = '[';
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt3 = charAt(this.bp + i4);
        int i6 = 16;
        float[][] fArr4 = new float[16];
        int i7 = 0;
        loop0: while (true) {
            if (charAt3 == c2) {
                int i8 = i5 + 1;
                char charAt4 = charAt(this.bp + i5);
                float[] fArr5 = new float[i6];
                int i9 = 0;
                while (true) {
                    int i10 = (this.bp + i8) - 1;
                    boolean z = charAt4 == '-';
                    if (z) {
                        charAt4 = charAt(this.bp + i8);
                        i8++;
                    }
                    if (charAt4 < '0' || charAt4 > '9') {
                        break loop0;
                    }
                    int i11 = charAt4 - '0';
                    while (true) {
                        i = i8 + 1;
                        charAt = charAt(this.bp + i8);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i11 = (i11 * 10) + (charAt - '0');
                        i8 = i;
                    }
                    if (charAt == '.') {
                        int i12 = i + 1;
                        char charAt5 = charAt(this.bp + i);
                        if (charAt5 < '0' || charAt5 > '9') {
                            break loop0;
                        }
                        i11 = (i11 * 10) + (charAt5 - '0');
                        int i13 = 10;
                        while (true) {
                            i = i12 + 1;
                            charAt2 = charAt(this.bp + i12);
                            if (charAt2 < '0' || charAt2 > '9') {
                                break;
                            }
                            i11 = (i11 * 10) + (charAt2 - '0');
                            i13 *= 10;
                            i12 = i;
                        }
                        i2 = i13;
                        charAt = charAt2;
                    } else {
                        i2 = 1;
                    }
                    boolean z2 = charAt == 'e' || charAt == 'E';
                    if (z2) {
                        int i14 = i + 1;
                        charAt = charAt(this.bp + i);
                        if (charAt == '+' || charAt == '-') {
                            int i15 = i14 + 1;
                            charAt = charAt(this.bp + i14);
                            i = i15;
                            if (charAt >= '0' && charAt <= '9') {
                                i15 = i + 1;
                                charAt = charAt(this.bp + i);
                                i = i15;
                                if (charAt >= '0') {
                                    i15 = i + 1;
                                    charAt = charAt(this.bp + i);
                                    i = i15;
                                    if (charAt >= '0') {
                                    }
                                }
                            }
                        } else {
                            i = i14;
                            if (charAt >= '0') {
                            }
                        }
                    }
                    int i16 = ((this.bp + i) - i10) - 1;
                    if (z2 || i16 >= 10) {
                        parseFloat = Float.parseFloat(subString(i10, i16));
                    } else {
                        parseFloat = i11 / i2;
                        if (z) {
                            parseFloat = -parseFloat;
                        }
                    }
                    if (i9 >= fArr5.length) {
                        float[] fArr6 = new float[(fArr5.length * 3) / 2];
                        System.arraycopy(fArr5, 0, fArr6, 0, i9);
                        fArr5 = fArr6;
                    }
                    int i17 = i9 + 1;
                    fArr5[i9] = parseFloat;
                    if (charAt == ',') {
                        i8 = i + 1;
                        fArr2 = null;
                        charAt4 = charAt(this.bp + i);
                    } else if (charAt == ']') {
                        int i18 = i + 1;
                        char charAt6 = charAt(this.bp + i);
                        if (i17 != fArr5.length) {
                            float[] fArr7 = new float[i17];
                            i3 = 0;
                            System.arraycopy(fArr5, 0, fArr7, 0, i17);
                            fArr5 = fArr7;
                        } else {
                            i3 = 0;
                        }
                        if (i7 >= fArr4.length) {
                            fArr4 = new float[(fArr4.length * 3) / 2];
                            System.arraycopy(fArr5, i3, fArr4, i3, i17);
                        }
                        int i19 = i7 + 1;
                        fArr4[i7] = fArr5;
                        if (charAt6 == ',') {
                            i5 = i18 + 1;
                            fArr = null;
                            charAt3 = charAt(this.bp + i18);
                        } else if (charAt6 == ']') {
                            int i20 = i18 + 1;
                            char charAt7 = charAt(this.bp + i18);
                            if (i19 != fArr4.length) {
                                float[][] fArr8 = new float[i19];
                                System.arraycopy(fArr4, 0, fArr8, 0, i19);
                                fArr4 = fArr8;
                            }
                            if (charAt7 == ',') {
                                this.bp += i20 - 1;
                                next();
                                this.matchStat = 3;
                                this.token = 16;
                                return fArr4;
                            } else if (charAt7 == '}') {
                                int i21 = i20 + 1;
                                char charAt8 = charAt(this.bp + i20);
                                if (charAt8 == ',') {
                                    this.token = 16;
                                    this.bp += i21 - 1;
                                    next();
                                } else if (charAt8 == ']') {
                                    this.token = 15;
                                    this.bp += i21 - 1;
                                    next();
                                } else if (charAt8 == '}') {
                                    this.token = 13;
                                    this.bp += i21 - 1;
                                    next();
                                } else if (charAt8 == 26) {
                                    this.bp += i21 - 1;
                                    this.token = 20;
                                    this.ch = JSONLexer.EOI;
                                } else {
                                    this.matchStat = -1;
                                    return null;
                                }
                                this.matchStat = 4;
                                return fArr4;
                            } else {
                                this.matchStat = -1;
                                return null;
                            }
                        } else {
                            fArr = null;
                            charAt3 = charAt6;
                            i5 = i18;
                        }
                        i7 = i19;
                        fArr3 = fArr;
                        c2 = '[';
                        i6 = 16;
                    } else {
                        fArr2 = null;
                        charAt4 = charAt;
                        i8 = i;
                    }
                    i9 = i17;
                    fArr3 = fArr2;
                }
            }
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.bp + i2);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = (i3 * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.bp + i;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        } else if (charAt == '}') {
            int i5 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.bp + i5;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.bp + i5;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.bp + i5;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i5 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -i3 : i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        int i2;
        int i3;
        char charAt2;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt3 = charAt(this.bp + i4);
        int[] iArr2 = new int[16];
        if (charAt3 == ']') {
            i3 = i5 + 1;
            charAt2 = charAt(this.bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i7 = charAt3 - '0';
                while (true) {
                    i = i5 + 1;
                    charAt = charAt(this.bp + i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i7 = (i7 * 10) + (charAt - '0');
                    i5 = i;
                }
                if (i6 >= iArr2.length) {
                    int[] iArr3 = new int[(iArr2.length * 3) / 2];
                    System.arraycopy(iArr2, 0, iArr3, 0, i6);
                    iArr2 = iArr3;
                }
                i2 = i6 + 1;
                if (z) {
                    i7 = -i7;
                }
                iArr2[i6] = i7;
                if (charAt == ',') {
                    i++;
                    charAt = charAt(this.bp + i);
                } else if (charAt == ']') {
                    i3 = i + 1;
                    charAt2 = charAt(this.bp + i);
                    break;
                }
                i6 = i2;
                iArr = null;
                charAt3 = charAt;
                i5 = i;
            }
            int[] iArr4 = iArr;
            this.matchStat = -1;
            return iArr4;
        }
        if (i2 != iArr2.length) {
            int[] iArr5 = new int[i2];
            System.arraycopy(iArr2, 0, iArr5, 0, i2);
            iArr2 = iArr5;
        }
        if (charAt2 == ',') {
            this.bp += i3 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (charAt2 == '}') {
            int i8 = i3 + 1;
            char charAt4 = charAt(this.bp + i3);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i8 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i8 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i8 - 1;
                next();
            } else if (charAt4 == 26) {
                this.bp += i8 - 1;
                this.token = 20;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr2;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i2);
            i2++;
            z = true;
        } else {
            z = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (!(i - cArr.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z)))) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i3 = this.bp + i;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i5 = this.bp + i4;
                this.bp = i5;
                this.ch = charAt(i5);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i6 = this.bp + i4;
                this.bp = i6;
                this.ch = charAt(i6);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i7 = this.bp + i4;
                this.bp = i7;
                this.ch = charAt(i7);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i4 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return z ? -j : j;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf(Typography.quote, this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = 0;
                    for (int i3 = indexOf - 1; i3 >= 0 && charAt(i3) == '\\'; i3--) {
                        i2++;
                    }
                    if (i2 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf(Typography.quote, indexOf + 1);
                }
                int i4 = this.bp;
                int length3 = indexOf - ((cArr.length + i4) + 1);
                subString = readString(sub_chars(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.bp;
            int length4 = i + (indexOf - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char charAt = charAt(i5 + length4);
            if (charAt == ',') {
                int i7 = this.bp + i6;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i8 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i10 = this.bp + i8;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i11 = this.bp + i8;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i8 - 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ee, code lost:
        if (r13.size() != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f0, code lost:
        r12 = charAt(r11.bp + r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fa, code lost:
        if (r12 != ',') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
        r12 = r11.bp + r1;
        r11.bp = r12;
        r11.ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010a, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
        if (r12 != '}') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x010f, code lost:
        r6 = r1 + 1;
        r12 = charAt(r11.bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0118, code lost:
        if (r12 != ',') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011a, code lost:
        r11.token = 16;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
        if (r12 != ']') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
        r11.token = 15;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013c, code lost:
        if (r12 != '}') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013e, code lost:
        r11.token = 13;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0150, code lost:
        if (r12 != 26) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0152, code lost:
        r11.bp += r6 - 1;
        r11.token = 20;
        r11.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015f, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0162, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0165, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0166, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0168, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0170, code lost:
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        char charAt;
        int i;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> newCollectionByType = newCollectionByType(cls);
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i3 = i2 + 1;
        char charAt2 = charAt(this.bp + i2);
        while (true) {
            if (charAt2 == '\"') {
                int indexOf = indexOf(Typography.quote, this.bp + i3);
                if (indexOf != -1) {
                    int i4 = this.bp + i3;
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
                        int i7 = this.bp;
                        int i8 = indexOf - (i7 + i3);
                        subString = readString(sub_chars(i7 + i3, i8), i8);
                    }
                    int i9 = this.bp;
                    int i10 = i3 + (indexOf - (i9 + i3)) + 1;
                    i = i10 + 1;
                    charAt = charAt(i9 + i10);
                    newCollectionByType.add(subString);
                } else {
                    throw new JSONException("unclosed str");
                }
            } else if (charAt2 != 'n' || charAt(this.bp + i3) != 'u' || charAt(this.bp + i3 + 1) != 'l' || charAt(this.bp + i3 + 2) != 'l') {
                break;
            } else {
                int i11 = i3 + 3;
                int i12 = i11 + 1;
                charAt = charAt(this.bp + i11);
                newCollectionByType.add(null);
                i = i12;
            }
            if (charAt == ',') {
                int i13 = i + 1;
                charAt2 = charAt(this.bp + i);
                i3 = i13;
            } else if (charAt == ']') {
                int i14 = i + 1;
                char charAt3 = charAt(this.bp + i);
            } else {
                this.matchStat = -1;
                return null;
            }
        }
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.bp + i5;
                        this.bp = i6;
                        this.ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.bp + i5;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.bp + i5;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i5 - 1;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            j = (j ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i = i2;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        char charAt;
        int i;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i15 = length + 1;
        char charAt2 = charAt(this.bp + length);
        char c2 = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf(Typography.quote, this.bp + cArr.length + 1);
            if (indexOf != -1) {
                int length2 = this.bp + cArr.length + 1;
                int i16 = indexOf - length2;
                char c3 = 'F';
                char c4 = 'f';
                char c5 = 'A';
                char c6 = '0';
                if (i16 == 36) {
                    int i17 = 0;
                    long j = 0;
                    while (i17 < 8) {
                        char charAt3 = charAt(length2 + i17);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= 'f') {
                                i13 = charAt3 - 'a';
                            } else if (charAt3 < 'A' || charAt3 > c3) {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i13 = charAt3 - 'A';
                            }
                            i14 = i13 + 10;
                        } else {
                            i14 = charAt3 - '0';
                        }
                        j = (j << 4) | i14;
                        i17++;
                        indexOf = indexOf;
                        c3 = 'F';
                    }
                    int i18 = indexOf;
                    int i19 = 9;
                    int i20 = 13;
                    while (i19 < i20) {
                        char charAt4 = charAt(length2 + i19);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i11 = charAt4 - 'a';
                            } else if (charAt4 < c5 || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i11 = charAt4 - 'A';
                            }
                            i12 = i11 + 10;
                        } else {
                            i12 = charAt4 - '0';
                        }
                        j = (j << c2) | i12;
                        i19++;
                        i20 = 13;
                        c5 = 'A';
                        c2 = 4;
                    }
                    long j2 = j;
                    for (int i21 = 14; i21 < 18; i21++) {
                        char charAt5 = charAt(length2 + i21);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i9 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i9 = charAt5 - 'A';
                            }
                            i10 = i9 + 10;
                        } else {
                            i10 = charAt5 - '0';
                        }
                        j2 = (j2 << 4) | i10;
                    }
                    long j3 = 0;
                    for (int i22 = 19; i22 < 23; i22++) {
                        char charAt6 = charAt(length2 + i22);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= 'a' && charAt6 <= 'f') {
                                i7 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i7 = charAt6 - 'A';
                            }
                            i8 = i7 + 10;
                        } else {
                            i8 = charAt6 - '0';
                        }
                        j3 = (j3 << 4) | i8;
                    }
                    int i23 = 24;
                    long j4 = j3;
                    int i24 = 36;
                    while (i23 < i24) {
                        char charAt7 = charAt(length2 + i23);
                        if (charAt7 < c6 || charAt7 > '9') {
                            if (charAt7 >= 'a' && charAt7 <= c4) {
                                i5 = charAt7 - 'a';
                            } else if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt7 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt7 - '0';
                        }
                        j4 = (j4 << 4) | i6;
                        i23++;
                        i15 = i15;
                        i24 = 36;
                        c6 = '0';
                        c4 = 'f';
                    }
                    uuid = new UUID(j2, j4);
                    int i25 = this.bp;
                    int length3 = i15 + (i18 - ((cArr.length + i25) + 1)) + 1;
                    i = length3 + 1;
                    charAt = charAt(i25 + length3);
                } else {
                    if (i16 == 32) {
                        long j5 = 0;
                        for (int i26 = 0; i26 < 16; i26++) {
                            char charAt8 = charAt(length2 + i26);
                            if (charAt8 < '0' || charAt8 > '9') {
                                if (charAt8 >= 'a' && charAt8 <= 'f') {
                                    i3 = charAt8 - 'a';
                                } else if (charAt8 < 'A' || charAt8 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt8 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt8 - '0';
                            }
                            j5 = (j5 << 4) | i4;
                        }
                        int i27 = 16;
                        long j6 = 0;
                        for (int i28 = 32; i27 < i28; i28 = 32) {
                            char charAt9 = charAt(length2 + i27);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i2 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i2 = (charAt9 - 'a') + 10;
                            } else if (charAt9 < 'A' || charAt9 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt9 - 'A') + 10;
                                j6 = (j6 << 4) | i2;
                                i27++;
                            }
                            j6 = (j6 << 4) | i2;
                            i27++;
                        }
                        uuid = new UUID(j5, j6);
                        int i29 = this.bp;
                        int length4 = i15 + (indexOf - ((cArr.length + i29) + 1)) + 1;
                        i = length4 + 1;
                        charAt = charAt(i29 + length4);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else {
            if (charAt2 == 'n') {
                int i30 = i15 + 1;
                if (charAt(this.bp + i15) == 'u') {
                    int i31 = i30 + 1;
                    if (charAt(this.bp + i30) == 'l') {
                        int i32 = i31 + 1;
                        if (charAt(this.bp + i31) == 'l') {
                            charAt = charAt(this.bp + i32);
                            i = i32 + 1;
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i33 = this.bp + i;
            this.bp = i33;
            this.ch = charAt(i33);
            this.matchStat = 3;
            return uuid;
        } else if (charAt == '}') {
            int i34 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                int i35 = this.bp + i34;
                this.bp = i35;
                this.ch = charAt(i35);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i36 = this.bp + i34;
                this.bp = i36;
                this.ch = charAt(i36);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i37 = this.bp + i34;
                this.bp = i37;
                this.ch = charAt(i37);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i34 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00c3 -> B:54:0x00c5). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float scanFloat(char c2) {
        int i;
        int i2;
        char charAt;
        int i3;
        int i4;
        float parseFloat;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
                this.matchStat = 5;
                int i5 = i + 3;
                int i6 = i5 + 1;
                char charAt3 = charAt(this.bp + i5);
                if (z && charAt3 == '\"') {
                    charAt3 = charAt(this.bp + i6);
                    i6++;
                }
                while (charAt3 != ',') {
                    if (charAt3 == ']') {
                        int i7 = this.bp + i6;
                        this.bp = i7;
                        this.ch = charAt(i7);
                        this.matchStat = 5;
                        this.token = 15;
                        return 0.0f;
                    } else if (isWhitespace(charAt3)) {
                        charAt3 = charAt(this.bp + i6);
                        i6++;
                    } else {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                }
                int i8 = this.bp + i6;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 5;
                this.token = 16;
                return 0.0f;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        long j = charAt2 - '0';
        while (true) {
            i2 = i + 1;
            charAt = charAt(this.bp + i);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i = i2;
        }
        long j2 = 1;
        if (charAt == '.') {
            int i9 = i2 + 1;
            char charAt4 = charAt(this.bp + i2);
            if (charAt4 >= '0' && charAt4 <= '9') {
                j = (j * 10) + (charAt4 - '0');
                j2 = 10;
                while (true) {
                    i2 = i9 + 1;
                    charAt = charAt(this.bp + i9);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    j2 *= 10;
                    i9 = i2;
                }
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        long j3 = j2;
        boolean z3 = charAt == 'e' || charAt == 'E';
        if (z3) {
            int i10 = i2 + 1;
            char charAt5 = charAt(this.bp + i2);
            if (charAt5 == '+' || charAt5 == '-') {
                int i11 = i10 + 1;
                charAt = charAt(this.bp + i10);
                i2 = i11;
                if (charAt >= '0' && charAt <= '9') {
                    i11 = i2 + 1;
                    charAt = charAt(this.bp + i2);
                    i2 = i11;
                    if (charAt >= '0') {
                        i11 = i2 + 1;
                        charAt = charAt(this.bp + i2);
                        i2 = i11;
                        if (charAt >= '0') {
                        }
                    }
                }
            } else {
                i2 = i10;
                charAt = charAt5;
                if (charAt >= '0') {
                }
            }
        }
        if (!z) {
            i3 = this.bp;
            i4 = ((i3 + i2) - i3) - 1;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return 0.0f;
        } else {
            int i12 = i2 + 1;
            charAt = charAt(this.bp + i2);
            int i13 = this.bp;
            i3 = i13 + 1;
            i4 = ((i13 + i12) - i3) - 2;
            i2 = i12;
        }
        if (z3 || i4 >= 20) {
            parseFloat = Float.parseFloat(subString(i3, i4));
        } else {
            parseFloat = ((float) j) / ((float) j3);
            if (z2) {
                parseFloat = -parseFloat;
            }
        }
        if (charAt == c2) {
            int i14 = this.bp + i2;
            this.bp = i14;
            this.ch = charAt(i14);
            this.matchStat = 3;
            this.token = 16;
            return parseFloat;
        }
        this.matchStat = -1;
        return parseFloat;
    }

    public final void scanHex() {
        char next;
        if (this.ch == 'x') {
            next();
            if (this.ch == '\'') {
                this.np = this.bp;
                next();
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    }
                    this.sp++;
                }
                if (next == '\'') {
                    this.sp++;
                    next();
                    this.token = 26;
                    return;
                }
                throw new JSONException("illegal state. " + next);
            }
            throw new JSONException("illegal state. " + this.ch);
        }
        throw new JSONException("illegal state. " + this.ch);
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if (StringUtil.NULL_STRING.equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if (SessionMonitorEngine.PUBLIC_DATA_UNDIFNED.equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:67:0x00fc -> B:56:0x00cb */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c2) {
        int i;
        int i2;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i3 = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = (i3 * 10) + (charAt - '0');
                i = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if (i3 < 0) {
                this.matchStat = -1;
                return 0;
            } else {
                while (charAt != c2) {
                    if (isWhitespace(charAt)) {
                        i2++;
                        charAt = charAt(this.bp + i2);
                    } else {
                        this.matchStat = -1;
                        return z2 ? -i3 : i3;
                    }
                }
                int i4 = this.bp + i2;
                this.bp = i4;
                this.ch = charAt(i4);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -i3 : i3;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i5 = i + 3;
            int i6 = i5 + 1;
            char charAt3 = charAt(this.bp + i5);
            if (z && charAt3 == '\"') {
                int i7 = i6 + 1;
                charAt3 = charAt(this.bp + i6);
                i6 = i7;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i8 = this.bp + i6;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                } else if (isWhitespace(charAt3)) {
                    int i9 = i6 + 1;
                    charAt3 = charAt(this.bp + i6);
                    i6 = i9;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i10 = this.bp + i6;
            this.bp = i10;
            this.ch = charAt(i10);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:79:0x0139 -> B:68:0x0108 */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c2) {
        int i;
        int i2;
        char charAt;
        char c3;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            charAt2 = charAt(this.bp + 1);
            i = 2;
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            charAt2 = charAt(this.bp + i);
            i++;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(this.bp + i);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
                if (!z) {
                    c3 = c2;
                } else if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                } else {
                    charAt = charAt(this.bp + i2);
                    c3 = c2;
                    i2++;
                }
                while (charAt != c3) {
                    if (isWhitespace(charAt)) {
                        charAt = charAt(this.bp + i2);
                        i2++;
                    } else {
                        this.matchStat = -1;
                        return j;
                    }
                }
                int i3 = this.bp + i2;
                this.bp = i3;
                this.ch = charAt(i3);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -j : j;
            }
            throw new NumberFormatException(subString(this.bp, i2 - 1));
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i4 = i + 3;
            int i5 = i4 + 1;
            char charAt3 = charAt(this.bp + i4);
            if (z && charAt3 == '\"') {
                int i6 = i5 + 1;
                charAt3 = charAt(this.bp + i5);
                i5 = i6;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    int i7 = this.bp + i5;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0L;
                } else if (isWhitespace(charAt3)) {
                    int i8 = i5 + 1;
                    charAt3 = charAt(this.bp + i5);
                    i5 = i8;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            int i9 = this.bp + i5;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 5;
            this.token = 16;
            return 0L;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public final void scanNullOrNew() {
        if (this.ch == 'n') {
            next();
            char c2 = this.ch;
            if (c2 != 'u') {
                if (c2 == 'e') {
                    next();
                    if (this.ch == 'w') {
                        next();
                        char c3 = this.ch;
                        if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && c3 != '\f' && c3 != '\b') {
                            throw new JSONException("scan new error");
                        }
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("error parse new");
                }
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch == 'l') {
                next();
                if (this.ch == 'l') {
                    next();
                    char c4 = this.ch;
                    if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b') {
                        throw new JSONException("scan null error");
                    }
                    this.token = 8;
                    return;
                }
                throw new JSONException("error parse null");
            }
            throw new JSONException("error parse null");
        }
        throw new JSONException("error parse null or new");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ce  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void scanNumber() {
        this.np = this.bp;
        boolean z = true;
        if (this.ch == '-') {
            this.sp++;
            next();
        }
        while (true) {
            char c2 = this.ch;
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.sp++;
            next();
        }
        boolean z2 = false;
        if (this.ch == '.') {
            this.sp++;
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                this.sp++;
                next();
            }
            z2 = true;
        }
        char c4 = this.ch;
        if (c4 == 'L') {
            this.sp++;
            next();
        } else if (c4 == 'S') {
            this.sp++;
            next();
        } else if (c4 != 'B') {
            if (c4 == 'F') {
                this.sp++;
                next();
            } else if (c4 == 'D') {
                this.sp++;
                next();
            } else if (c4 == 'e' || c4 == 'E') {
                this.sp++;
                next();
                char c5 = this.ch;
                if (c5 == '+' || c5 == '-') {
                    this.sp++;
                    next();
                }
                while (true) {
                    char c6 = this.ch;
                    if (c6 < '0' || c6 > '9') {
                        break;
                    }
                    this.sp++;
                    next();
                }
                char c7 = this.ch;
                if (c7 == 'D' || c7 == 'F') {
                    this.sp++;
                    next();
                }
            }
            if (!z) {
                this.token = 3;
                return;
            } else {
                this.token = 2;
                return;
            }
        } else {
            this.sp++;
            next();
        }
        z = z2;
        if (!z) {
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed string : " + next);
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.sp;
                    char[] cArr = this.sbuf;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        char[] cArr3 = this.sbuf;
                        System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar(Typography.quote);
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        continue;
                                    case '0':
                                        putChar((char) 0);
                                        continue;
                                    case '1':
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        putChar((char) 5);
                                        continue;
                                    case '6':
                                        putChar((char) 6);
                                        continue;
                                    case '7':
                                        putChar((char) 7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                continue;
                                                continue;
                                            case 'v':
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (!this.hasSpecial) {
                this.sp++;
            } else {
                int i2 = this.sp;
                char[] cArr4 = this.sbuf;
                if (i2 == cArr4.length) {
                    putChar(next);
                } else {
                    this.sp = i2 + 1;
                    cArr4[i2] = next;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
        if (r1 != r18) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013b, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013d, code lost:
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scanStringArray(Collection<String> collection, char c2) {
        int i;
        char charAt;
        int i2;
        char charAt2;
        this.matchStat = 0;
        char charAt3 = charAt(this.bp + 0);
        char c3 = 'u';
        char c4 = 'n';
        if (charAt3 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l' && charAt(this.bp + 1 + 3) == c2) {
            int i3 = this.bp + 5;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 5;
        } else if (charAt3 != '[') {
            this.matchStat = -1;
        } else {
            char charAt4 = charAt(this.bp + 1);
            int i4 = 2;
            while (true) {
                if (charAt4 == c4 && charAt(this.bp + i4) == c3 && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                    int i5 = i4 + 3;
                    i = i5 + 1;
                    charAt = charAt(this.bp + i5);
                    collection.add(null);
                } else if (charAt4 == ']' && collection.size() == 0) {
                    i2 = i4 + 1;
                    charAt2 = charAt(this.bp + i4);
                    break;
                } else if (charAt4 != '\"') {
                    this.matchStat = -1;
                    return;
                } else {
                    int i6 = this.bp + i4;
                    int indexOf = indexOf(Typography.quote, i6);
                    if (indexOf != -1) {
                        String subString = subString(this.bp + i4, indexOf - i6);
                        if (subString.indexOf(92) != -1) {
                            while (true) {
                                int i7 = 0;
                                for (int i8 = indexOf - 1; i8 >= 0 && charAt(i8) == '\\'; i8--) {
                                    i7++;
                                }
                                if (i7 % 2 == 0) {
                                    break;
                                }
                                indexOf = indexOf(Typography.quote, indexOf + 1);
                            }
                            int i9 = indexOf - i6;
                            subString = readString(sub_chars(this.bp + i4, i9), i9);
                        }
                        int i10 = this.bp;
                        int i11 = i4 + (indexOf - (i10 + i4)) + 1;
                        i = i11 + 1;
                        charAt = charAt(i10 + i11);
                        collection.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                }
                if (charAt == ',') {
                    i4 = i + 1;
                    charAt4 = charAt(this.bp + i);
                    c3 = 'u';
                    c4 = 'n';
                } else if (charAt == ']') {
                    i2 = i + 1;
                    charAt2 = charAt(this.bp + i);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c2 = this.ch;
        if (c2 == '\"') {
            return scanSymbol(symbolTable, Typography.quote);
        }
        if (c2 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c2 == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c2 == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c2 == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean z = false;
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if ((i >= zArr.length || zArr[i]) ? true : true) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c2) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c2) {
                    int i2 = this.bp + 5;
                    this.bp = i2;
                    this.ch = charAt(i2);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.bp;
                    int i6 = i5 + 0 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    int i7 = i4 + 1;
                    char charAt3 = charAt(this.bp + i4);
                    while (charAt3 != c2) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
            }
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c2 = this.ch;
                        if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b' && c2 != ':' && c2 != '/') {
                            throw new JSONException("scan true error");
                        }
                        this.token = 6;
                        return;
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        if (charArrayCompare(typeFieldName)) {
            int length = this.bp + typeFieldName.length;
            int length2 = str.length();
            for (int i = 0; i < length2; i++) {
                if (str.charAt(i) != charAt(length + i)) {
                    return -1;
                }
            }
            int i2 = length + length2;
            if (charAt(i2) != '\"') {
                return -1;
            }
            int i3 = i2 + 1;
            char charAt = charAt(i3);
            this.ch = charAt;
            if (charAt == ',') {
                int i4 = i3 + 1;
                this.ch = charAt(i4);
                this.bp = i4;
                this.token = 16;
                return 3;
            }
            if (charAt == '}') {
                i3++;
                char charAt2 = charAt(i3);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    i3++;
                    this.ch = charAt(i3);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    i3++;
                    this.ch = charAt(i3);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    i3++;
                    this.ch = charAt(i3);
                } else if (charAt2 != 26) {
                    return -1;
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            this.bp = i3;
            return this.matchStat;
        }
        return -2;
    }

    public UUID scanUUID(char c2) {
        int i;
        char charAt;
        UUID uuid;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        int i15 = 13;
        char c3 = 4;
        if (charAt2 == '\"') {
            int indexOf = indexOf(Typography.quote, this.bp + 1);
            if (indexOf != -1) {
                int i16 = this.bp + 1;
                int i17 = indexOf - i16;
                char c4 = 'f';
                char c5 = 'A';
                char c6 = 'a';
                if (i17 == 36) {
                    int i18 = 0;
                    long j = 0;
                    while (i18 < 8) {
                        char charAt3 = charAt(i16 + i18);
                        if (charAt3 < '0' || charAt3 > '9') {
                            if (charAt3 >= 'a' && charAt3 <= c4) {
                                i13 = charAt3 - 'a';
                            } else if (charAt3 < 'A' || charAt3 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i13 = charAt3 - 'A';
                            }
                            i14 = i13 + 10;
                        } else {
                            i14 = charAt3 - '0';
                        }
                        j = (j << 4) | i14;
                        i18++;
                        c4 = 'f';
                    }
                    int i19 = 9;
                    while (i19 < i15) {
                        char charAt4 = charAt(i16 + i19);
                        if (charAt4 < '0' || charAt4 > '9') {
                            if (charAt4 >= 'a' && charAt4 <= 'f') {
                                i11 = charAt4 - 'a';
                            } else if (charAt4 < c5 || charAt4 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i11 = charAt4 - 'A';
                            }
                            i12 = i11 + 10;
                        } else {
                            i12 = charAt4 - '0';
                        }
                        j = (j << 4) | i12;
                        i19++;
                        i15 = 13;
                        c5 = 'A';
                    }
                    long j2 = j;
                    for (int i20 = 14; i20 < 18; i20++) {
                        char charAt5 = charAt(i16 + i20);
                        if (charAt5 < '0' || charAt5 > '9') {
                            if (charAt5 >= 'a' && charAt5 <= 'f') {
                                i9 = charAt5 - 'a';
                            } else if (charAt5 < 'A' || charAt5 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i9 = charAt5 - 'A';
                            }
                            i10 = i9 + 10;
                        } else {
                            i10 = charAt5 - '0';
                        }
                        j2 = (j2 << 4) | i10;
                    }
                    int i21 = 19;
                    long j3 = 0;
                    while (i21 < 23) {
                        char charAt6 = charAt(i16 + i21);
                        if (charAt6 < '0' || charAt6 > '9') {
                            if (charAt6 >= c6 && charAt6 <= 'f') {
                                i7 = charAt6 - 'a';
                            } else if (charAt6 < 'A' || charAt6 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i7 = charAt6 - 'A';
                            }
                            i8 = i7 + 10;
                        } else {
                            i8 = charAt6 - '0';
                        }
                        j3 = (j3 << c3) | i8;
                        i21++;
                        c6 = 'a';
                        c3 = 4;
                    }
                    long j4 = j3;
                    for (int i22 = 24; i22 < 36; i22++) {
                        char charAt7 = charAt(i16 + i22);
                        if (charAt7 < '0' || charAt7 > '9') {
                            if (charAt7 >= 'a' && charAt7 <= 'f') {
                                i5 = charAt7 - 'a';
                            } else if (charAt7 < 'A' || charAt7 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i5 = charAt7 - 'A';
                            }
                            i6 = i5 + 10;
                        } else {
                            i6 = charAt7 - '0';
                        }
                        j4 = (j4 << 4) | i6;
                    }
                    uuid = new UUID(j2, j4);
                    int i23 = this.bp;
                    int i24 = 1 + (indexOf - (i23 + 1)) + 1;
                    i = i24 + 1;
                    charAt = charAt(i23 + i24);
                } else {
                    if (i17 == 32) {
                        long j5 = 0;
                        for (int i25 = 0; i25 < 16; i25++) {
                            char charAt8 = charAt(i16 + i25);
                            if (charAt8 < '0' || charAt8 > '9') {
                                if (charAt8 >= 'a' && charAt8 <= 'f') {
                                    i3 = charAt8 - 'a';
                                } else if (charAt8 < 'A' || charAt8 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = charAt8 - 'A';
                                }
                                i4 = i3 + 10;
                            } else {
                                i4 = charAt8 - '0';
                            }
                            j5 = (j5 << 4) | i4;
                        }
                        int i26 = 16;
                        long j6 = 0;
                        for (int i27 = 32; i26 < i27; i27 = 32) {
                            char charAt9 = charAt(i16 + i26);
                            if (charAt9 >= '0' && charAt9 <= '9') {
                                i2 = charAt9 - '0';
                            } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                i2 = (charAt9 - 'a') + 10;
                            } else if (charAt9 < 'A' || charAt9 > 'F') {
                                this.matchStat = -2;
                                return null;
                            } else {
                                i2 = (charAt9 - 'A') + 10;
                            }
                            j6 = (j6 << 4) | i2;
                            i26++;
                        }
                        uuid = new UUID(j5, j6);
                        int i28 = this.bp;
                        int i29 = 1 + (indexOf - (i28 + 1)) + 1;
                        i = i29 + 1;
                        charAt = charAt(i28 + i29);
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            } else {
                throw new JSONException("unclosed str");
            }
        } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            i = 5;
            charAt = charAt(this.bp + 4);
            uuid = null;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            int i30 = this.bp + i;
            this.bp = i30;
            this.ch = charAt(i30);
            this.matchStat = 3;
            return uuid;
        } else if (charAt == ']') {
            int i31 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                int i32 = this.bp + i31;
                this.bp = i32;
                this.ch = charAt(i32);
            } else if (charAt10 == ']') {
                this.token = 15;
                int i33 = this.bp + i31;
                this.bp = i33;
                this.ch = charAt(i33);
            } else if (charAt10 == '}') {
                this.token = 13;
                int i34 = this.bp + i31;
                this.bp = i34;
                this.ch = charAt(i34);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i31 - 1;
                this.ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return uuid;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i) {
        this.token = i;
    }

    public void skipComment() {
        char c2;
        next();
        char c3 = this.ch;
        if (c3 == '/') {
            do {
                next();
                c2 = this.ch;
                if (c2 == '\n') {
                    next();
                    return;
                }
            } while (c2 != 26);
        } else if (c3 == '*') {
            next();
            while (true) {
                char c4 = this.ch;
                if (c4 == 26) {
                    return;
                }
                if (c4 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c2 = this.ch;
            if (c2 > '/') {
                return;
            }
            if (c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                next();
            } else if (c2 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    public abstract char[] sub_chars(int i, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c2) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c2) {
                this.token = 4;
                if (!z) {
                    int i2 = this.np;
                    addSymbol = addSymbol(i2 == -1 ? 0 : i2 + 1, this.sp, i, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return addSymbol;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else {
                if (next == '\\') {
                    if (!z) {
                        int i3 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i3 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i3 <= length) {
                                i3 = length;
                            }
                            char[] cArr2 = new char[i3];
                            char[] cArr3 = this.sbuf;
                            System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                            this.sbuf = cArr2;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                        z = true;
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        i = (i * 31) + 34;
                        putChar(Typography.quote);
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                i = (i * 31) + 92;
                                putChar('\\');
                            } else if (next2 == 'b') {
                                i = (i * 31) + 8;
                                putChar('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    i = (i * 31) + 10;
                                    putChar('\n');
                                } else if (next2 == 'r') {
                                    i = (i * 31) + 13;
                                    putChar('\r');
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case '/':
                                            i = (i * 31) + 47;
                                            putChar('/');
                                            continue;
                                        case '0':
                                            i = (i * 31) + next2;
                                            putChar((char) 0);
                                            continue;
                                        case '1':
                                            i = (i * 31) + next2;
                                            putChar((char) 1);
                                            continue;
                                        case '2':
                                            i = (i * 31) + next2;
                                            putChar((char) 2);
                                            continue;
                                        case '3':
                                            i = (i * 31) + next2;
                                            putChar((char) 3);
                                            continue;
                                        case '4':
                                            i = (i * 31) + next2;
                                            putChar((char) 4);
                                            continue;
                                        case '5':
                                            i = (i * 31) + next2;
                                            putChar((char) 5);
                                            continue;
                                        case '6':
                                            i = (i * 31) + next2;
                                            putChar((char) 6);
                                            continue;
                                        case '7':
                                            i = (i * 31) + next2;
                                            putChar((char) 7);
                                            continue;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    i = (i * 31) + 9;
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                    i = (i * 31) + parseInt;
                                                    putChar((char) parseInt);
                                                    continue;
                                                    continue;
                                                case 'v':
                                                    i = (i * 31) + 11;
                                                    putChar((char) 11);
                                                    continue;
                                                default:
                                                    this.ch = next2;
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    char next3 = next();
                                    this.ch = next3;
                                    char next4 = next();
                                    this.ch = next4;
                                    int[] iArr = digits;
                                    char c3 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                    i = (i * 31) + c3;
                                    putChar(c3);
                                }
                            }
                        }
                        i = (i * 31) + 12;
                        putChar('\f');
                    } else {
                        i = (i * 31) + 39;
                        putChar('\'');
                    }
                } else {
                    i = (i * 31) + next;
                    if (!z) {
                        this.sp++;
                    } else {
                        int i4 = this.sp;
                        char[] cArr4 = this.sbuf;
                        if (i4 == cArr4.length) {
                            putChar(next);
                        } else {
                            this.sp = i4 + 1;
                            cArr4[i4] = next;
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i == 2) {
                char c2 = this.ch;
                if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                }
                char c3 = this.ch;
                if (c3 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c4 = this.ch;
                if (c4 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c4 >= '0' && c4 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else {
                    char c5 = this.ch;
                    if (c5 == '[') {
                        this.token = 14;
                        next();
                        return;
                    } else if (c5 == '{') {
                        this.token = 12;
                        next();
                        return;
                    }
                }
            } else if (i == 12) {
                char c6 = this.ch;
                if (c6 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c6 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c7 = this.ch;
                            if (c7 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c7 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c8 = this.ch;
                            if (c8 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c8 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c8 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c8 == 26) {
                                this.token = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c9 = this.ch;
            if (c9 != ' ' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != '\f' && c9 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c2) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c2) {
                    int i = this.bp + 5;
                    this.bp = i;
                    this.ch = charAt(i);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i2 = 1;
        while (charAt != '\"') {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i2);
                i2++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i3 = this.bp + i2;
        int indexOf = indexOf(Typography.quote, i3);
        if (indexOf != -1) {
            String subString = subString(this.bp + i2, indexOf - i3);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i4 = 0;
                    for (int i5 = indexOf - 1; i5 >= 0 && charAt(i5) == '\\'; i5--) {
                        i4++;
                    }
                    if (i4 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf(Typography.quote, indexOf + 1);
                }
                int i6 = indexOf - i3;
                subString = readString(sub_chars(this.bp + 1, i6), i6);
            }
            int i7 = i2 + (indexOf - i3) + 1;
            int i8 = i7 + 1;
            char charAt2 = charAt(this.bp + i7);
            while (charAt2 != c2) {
                if (isWhitespace(charAt2)) {
                    charAt2 = charAt(this.bp + i8);
                    i8++;
                } else {
                    this.matchStat = -1;
                    return subString;
                }
            }
            int i9 = this.bp + i8;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }
}
