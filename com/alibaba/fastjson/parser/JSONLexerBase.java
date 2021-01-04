package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
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
/* loaded from: classes6.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    protected abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public abstract int indexOf(char c, int i);

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i, int i2);

    protected abstract char[] sub_chars(int i, int i2);

    protected void lexError(String str, Object... objArr) {
        this.token = 1;
    }

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
        if ((Feature.InitStringFieldAsEmpty.mask & i) != 0) {
            this.stringDefaultValue = "";
        }
        this.sbuf = SBUF_LOCAL.get();
        if (this.sbuf == null) {
            this.sbuf = new char[512];
        }
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public void setToken(int i) {
        this.token = i;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            if (this.ch == '/') {
                skipComment();
            } else if (this.ch == '\"') {
                scanString();
                return;
            } else if (this.ch == ',') {
                next();
                this.token = 16;
                return;
            } else if (this.ch >= '0' && this.ch <= '9') {
                scanNumber();
                return;
            } else if (this.ch == '-') {
                scanNumber();
                return;
            } else {
                switch (this.ch) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        continue;
                    case '\'':
                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        scanStringSingleQuote();
                        return;
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
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.token = 20;
                            int i = this.eofPos;
                            this.bp = i;
                            this.pos = i;
                            return;
                        } else if (this.ch <= 31 || this.ch == 127) {
                            next();
                            continue;
                        } else {
                            lexError("illegal.char", String.valueOf((int) this.ch));
                            next();
                            return;
                        }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0116 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0030 A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            switch (i) {
                case 2:
                    if (this.ch >= '0' && this.ch <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (this.ch == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (this.ch == '[') {
                        this.token = 14;
                        next();
                        return;
                    } else {
                        if (this.ch == '{') {
                            this.token = 12;
                            next();
                            return;
                        }
                        if (this.ch != ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
                            next();
                        } else {
                            nextToken();
                            return;
                        }
                    }
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 13:
                case 17:
                case 19:
                default:
                    if (this.ch != ' ') {
                        break;
                    }
                    next();
                case 4:
                    if (this.ch == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (this.ch >= '0' && this.ch <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (this.ch == '[') {
                        this.token = 14;
                        next();
                        return;
                    } else {
                        if (this.ch == '{') {
                            this.token = 12;
                            next();
                            return;
                        }
                        if (this.ch != ' ') {
                        }
                        next();
                    }
                    break;
                case 12:
                    if (this.ch == '{') {
                        this.token = 12;
                        next();
                        return;
                    }
                    if (this.ch == '[') {
                        this.token = 14;
                        next();
                        return;
                    }
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
                case 14:
                    if (this.ch == '[') {
                        this.token = 14;
                        next();
                        return;
                    }
                    if (this.ch == '{') {
                        this.token = 12;
                        next();
                        return;
                    }
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
                case 15:
                    if (this.ch == ']') {
                        this.token = 15;
                        next();
                        return;
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                        return;
                    }
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
                case 16:
                    if (this.ch == ',') {
                        this.token = 16;
                        next();
                        return;
                    } else if (this.ch == '}') {
                        this.token = 13;
                        next();
                        return;
                    } else if (this.ch == ']') {
                        this.token = 15;
                        next();
                        return;
                    } else {
                        if (this.ch == 26) {
                            this.token = 20;
                            return;
                        }
                        if (this.ch != ' ') {
                        }
                        next();
                    }
                    break;
                case 18:
                    nextIdent();
                    return;
                case 20:
                    if (this.ch == 26) {
                    }
                    if (this.ch != ' ') {
                    }
                    next();
                    break;
            }
        }
    }

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        if (this.ch == '_' || this.ch == '$' || Character.isLetter(this.ch)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (this.ch != c) {
            if (this.ch == ' ' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
                next();
            } else {
                throw new JSONException("not match " + c + " - " + this.ch + ", info : " + info());
            }
        }
        next();
        nextToken();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j;
        boolean z;
        int i;
        long j2 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i2 = this.np;
        int i3 = this.sp + this.np;
        char c = ' ';
        switch (charAt(i3 - 1)) {
            case 'B':
                i3--;
                c = 'B';
                break;
            case 'L':
                i3--;
                c = 'L';
                break;
            case 'S':
                i3--;
                c = 'S';
                break;
        }
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i2 < i3) {
            i = i2 + 1;
            j2 = -(charAt(i2) - '0');
        } else {
            i = i2;
        }
        while (i < i3) {
            int i4 = i + 1;
            int charAt = charAt(i) - '0';
            if (j2 < MULTMIN_RADIX_TEN) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            if (j3 < charAt + j) {
                return new BigInteger(numberString());
            }
            j2 = j3 - charAt;
            i = i4;
        }
        if (z) {
            if (i > this.np + 1) {
                if (j2 >= -2147483648L && c != 'L') {
                    if (c == 'S') {
                        return Short.valueOf((short) j2);
                    }
                    if (c == 'B') {
                        return Byte.valueOf((byte) j2);
                    }
                    return Integer.valueOf((int) j2);
                }
                return Long.valueOf(j2);
            }
            throw new NumberFormatException(numberString());
        }
        long j4 = -j2;
        if (j4 <= 2147483647L && c != 'L') {
            if (c == 'S') {
                return Short.valueOf((short) j4);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j4);
            }
            return Integer.valueOf((int) j4);
        }
        return Long.valueOf(j4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
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

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        this.features = Feature.config(this.features, feature, z);
        if ((this.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i) {
        return (this.features & i) != 0;
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    protected void skipComment() {
        next();
        if (this.ch == '/') {
            do {
                next();
                if (this.ch == '\n') {
                    next();
                    return;
                }
            } while (this.ch != 26);
        } else if (this.ch == '*') {
            next();
            while (this.ch != 26) {
                if (this.ch == '*') {
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
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        if (this.ch == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (this.ch == '\'') {
            if (!isEnabled(Feature.AllowSingleQuotes)) {
                throw new JSONException("syntax error");
            }
            return scanSymbol(symbolTable, '\'');
        } else if (this.ch == '}') {
            next();
            this.token = 13;
            return null;
        } else if (this.ch == ',') {
            next();
            this.token = 16;
            return null;
        } else if (this.ch == 26) {
            this.token = 20;
            return null;
        } else if (!isEnabled(Feature.AllowUnQuotedFieldNames)) {
            throw new JSONException("syntax error");
        } else {
            return scanSymbolUnQuoted(symbolTable);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next != c) {
                if (next == 26) {
                    throw new JSONException("unclosed.str");
                }
                if (next == '\\') {
                    if (!z) {
                        if (this.sp >= this.sbuf.length) {
                            int length = this.sbuf.length * 2;
                            if (this.sp > length) {
                                length = this.sp;
                            }
                            char[] cArr = new char[length];
                            System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
                            this.sbuf = cArr;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                        z = true;
                    }
                    char next2 = next();
                    switch (next2) {
                        case '\"':
                            i = (i * 31) + 34;
                            putChar('\"');
                            continue;
                        case '\'':
                            i = (i * 31) + 39;
                            putChar('\'');
                            continue;
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
                        case 'F':
                        case 'f':
                            i = (i * 31) + 12;
                            putChar('\f');
                            continue;
                        case '\\':
                            i = (i * 31) + 92;
                            putChar('\\');
                            continue;
                        case 'b':
                            i = (i * 31) + 8;
                            putChar('\b');
                            continue;
                        case 'n':
                            i = (i * 31) + 10;
                            putChar('\n');
                            continue;
                        case 'r':
                            i = (i * 31) + 13;
                            putChar('\r');
                            continue;
                        case 't':
                            i = (i * 31) + 9;
                            putChar('\t');
                            continue;
                        case 'u':
                            int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                            i = (i * 31) + parseInt;
                            putChar((char) parseInt);
                            continue;
                        case 'v':
                            i = (i * 31) + 11;
                            putChar((char) 11);
                            continue;
                        case 'x':
                            char next3 = next();
                            this.ch = next3;
                            char next4 = next();
                            this.ch = next4;
                            char c2 = (char) ((digits[next3] * 16) + digits[next4]);
                            i = (i * 31) + c2;
                            putChar(c2);
                            continue;
                        default:
                            this.ch = next2;
                            throw new JSONException("unclosed.str.lit");
                    }
                } else {
                    i = (i * 31) + next;
                    if (!z) {
                        this.sp++;
                    } else if (this.sp == this.sbuf.length) {
                        putChar(next);
                    } else {
                        char[] cArr2 = this.sbuf;
                        int i2 = this.sp;
                        this.sp = i2 + 1;
                        cArr2[i2] = next;
                    }
                }
            } else {
                this.token = 4;
                if (!z) {
                    addSymbol = addSymbol(this.np == -1 ? 0 : this.np + 1, this.sp, i, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i);
                }
                this.sp = 0;
                next();
                return addSymbol;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean z = false;
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.ch;
        if (this.ch >= zArr.length || zArr[i]) {
            z = true;
        }
        if (!z) {
            throw new JSONException("illegal identifier : " + this.ch + info());
        }
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next != '\"') {
                if (next == 26) {
                    if (!isEOF()) {
                        putChar(JSONLexer.EOI);
                    } else {
                        throw new JSONException("unclosed string : " + next);
                    }
                } else if (next == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        if (this.sp >= this.sbuf.length) {
                            int length = this.sbuf.length * 2;
                            if (this.sp > length) {
                                length = this.sp;
                            }
                            char[] cArr = new char[length];
                            System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
                            this.sbuf = cArr;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char next2 = next();
                    switch (next2) {
                        case '\"':
                            putChar('\"');
                            continue;
                        case '\'':
                            putChar('\'');
                            continue;
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
                        case 'F':
                        case 'f':
                            putChar('\f');
                            continue;
                        case '\\':
                            putChar('\\');
                            continue;
                        case 'b':
                            putChar('\b');
                            continue;
                        case 'n':
                            putChar('\n');
                            continue;
                        case 'r':
                            putChar('\r');
                            continue;
                        case 't':
                            putChar('\t');
                            continue;
                        case 'u':
                            putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                            continue;
                        case 'v':
                            putChar((char) 11);
                            continue;
                        case 'x':
                            putChar((char) ((digits[next()] * 16) + digits[next()]));
                            continue;
                        default:
                            this.ch = next2;
                            throw new JSONException("unclosed string : " + next2);
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else if (this.sp == this.sbuf.length) {
                    putChar(next);
                } else {
                    char[] cArr2 = this.sbuf;
                    int i = this.sp;
                    this.sp = i + 1;
                    cArr2[i] = next;
                }
            } else {
                this.token = 4;
                this.ch = next();
                return;
            }
        }
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1 <= (r10.np + 1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
        throw new java.lang.NumberFormatException(numberString());
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int intValue() {
        int i;
        boolean z;
        int i2;
        int i3;
        int i4 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i5 = this.np;
        int i6 = this.np + this.sp;
        if (charAt(this.np) == '-') {
            z = true;
            i5++;
            i = Integer.MIN_VALUE;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i5 < i6) {
            i2 = i5 + 1;
            i4 = -(charAt(i5) - '0');
        } else {
            i2 = i5;
        }
        while (true) {
            if (i2 >= i6) {
                i3 = i2;
                break;
            }
            i3 = i2 + 1;
            char charAt = charAt(i2);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                break;
            }
            int i7 = charAt - '0';
            if (i4 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i8 = i4 * 10;
            if (i8 < i + i7) {
                throw new NumberFormatException(numberString());
            }
            i4 = i8 - i7;
            i2 = i3;
        }
        return -i4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.sbuf.length <= 8192) {
            SBUF_LOCAL.set(this.sbuf);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        if (!charArrayCompare(typeFieldName)) {
            return -2;
        }
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
        this.ch = charAt(i3);
        if (this.ch == ',') {
            int i4 = i3 + 1;
            this.ch = charAt(i4);
            this.bp = i4;
            this.token = 16;
            return 3;
        }
        if (this.ch == '}') {
            i3++;
            this.ch = charAt(i3);
            if (this.ch == ',') {
                this.token = 16;
                i3++;
                this.ch = charAt(i3);
            } else if (this.ch == ']') {
                this.token = 15;
                i3++;
                this.ch = charAt(i3);
            } else if (this.ch == '}') {
                this.token = 13;
                i3++;
                this.ch = charAt(i3);
            } else if (this.ch != 26) {
                return -1;
            } else {
                this.token = 20;
            }
            this.matchStat = 4;
        }
        this.bp = i3;
        return this.matchStat;
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (isWhitespace(this.ch)) {
                next();
            } else {
                return false;
            }
        }
        this.bp += cArr.length;
        this.ch = charAt(this.bp);
        if (this.ch == '{') {
            next();
            this.token = 12;
        } else if (this.ch == '[') {
            next();
            this.token = 14;
        } else if (this.ch == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            this.bp += 3;
            this.ch = charAt(this.bp);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(length + this.bp) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
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
                indexOf = indexOf('\"', indexOf + 1);
            }
            int length3 = indexOf - ((this.bp + cArr.length) + 1);
            subString = readString(sub_chars(this.bp + cArr.length + 1, length3), length3);
        }
        int length4 = (indexOf - ((this.bp + cArr.length) + 1)) + 1 + i;
        int i4 = length4 + 1;
        char charAt = charAt(length4 + this.bp);
        if (charAt == ',') {
            this.bp += i4;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return subString;
        } else if (charAt == '}') {
            int i5 = i4 + 1;
            char charAt2 = charAt(this.bp + i4);
            if (charAt2 == ',') {
                this.token = 16;
                this.bp += i5;
                this.ch = charAt(this.bp);
            } else if (charAt2 == ']') {
                this.token = 15;
                this.bp += i5;
                this.ch = charAt(this.bp);
            } else if (charAt2 == '}') {
                this.token = 13;
                this.bp += i5;
                this.ch = charAt(this.bp);
            } else if (charAt2 == 26) {
                this.token = 20;
                this.bp += i5 - 1;
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) == c) {
                this.bp += 5;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        int i = 1;
        while (charAt != '\"') {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i2 = this.bp + i;
        int indexOf = indexOf('\"', i2);
        if (indexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String subString = subString(this.bp + i, indexOf - i2);
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
            int i5 = indexOf - i2;
            subString = readString(sub_chars(this.bp + 1, i5), i5);
        }
        int i6 = (indexOf - i2) + 1 + i;
        int i7 = i6 + 1;
        char charAt2 = charAt(i6 + this.bp);
        while (charAt2 != c) {
            if (isWhitespace(charAt2)) {
                charAt2 = charAt(this.bp + i7);
                i7++;
            } else {
                this.matchStat = -1;
                return subString;
            }
        }
        this.bp += i7;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        return subString;
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i = length + 1;
        if (charAt(length + this.bp) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i + this.bp);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.bp + i2);
                if (charAt2 == ',') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i4 = i3 + 1;
                    char charAt3 = charAt(this.bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        this.bp += i4;
                        this.ch = charAt(this.bp);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        this.bp += i4;
                        this.ch = charAt(this.bp);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        this.bp += i4;
                        this.ch = charAt(this.bp);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i4 - 1;
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i;
        int i2 = 0;
        this.matchStat = 0;
        int i3 = 1;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 1 + 1) != 'l' || charAt(this.bp + 1 + 2) != 'l') {
                this.matchStat = -1;
                return null;
            } else if (charAt(this.bp + 4) == c) {
                this.bp += 5;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(i3 + this.bp);
                if (charAt2 == '\"') {
                    String addSymbol = addSymbol(this.bp + 0 + 1, ((this.bp + i4) - i) - 1, i2, symbolTable);
                    char charAt3 = charAt(this.bp + i4);
                    int i5 = i4 + 1;
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i5);
                            i5++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    this.bp += i5;
                    this.ch = charAt(this.bp);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i2 = (i2 * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
            }
        }
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
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e7, code lost:
        if (r3.size() != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e9, code lost:
        r1 = r5 + 1;
        r0 = charAt(r12.bp + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f2, code lost:
        if (r0 != ',') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f4, code lost:
        r12.bp += r1;
        r12.ch = charAt(r12.bp);
        r12.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010f, code lost:
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0123, code lost:
        if (r0 != '}') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0125, code lost:
        r4 = r1 + 1;
        r0 = charAt(r12.bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012e, code lost:
        if (r0 != ',') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0130, code lost:
        r12.token = 16;
        r12.bp += r4;
        r12.ch = charAt(r12.bp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0141, code lost:
        r12.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0147, code lost:
        if (r0 != ']') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0149, code lost:
        r12.token = 15;
        r12.bp += r4;
        r12.ch = charAt(r12.bp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015d, code lost:
        if (r0 != '}') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015f, code lost:
        r12.token = 13;
        r12.bp += r4;
        r12.ch = charAt(r12.bp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0173, code lost:
        if (r0 != 26) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
        r12.bp += r4 - 1;
        r12.token = 20;
        r12.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0185, code lost:
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x018a, code lost:
        r12.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return null;
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
        if (charAt(length + this.bp) != '[') {
            this.matchStat = -1;
            return null;
        }
        char charAt2 = charAt(this.bp + i2);
        int i3 = i2 + 1;
        while (true) {
            if (charAt2 == '\"') {
                int indexOf = indexOf('\"', this.bp + i3);
                if (indexOf == -1) {
                    throw new JSONException("unclosed str");
                }
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
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i7 = indexOf - (this.bp + i3);
                    subString = readString(sub_chars(this.bp + i3, i7), i7);
                }
                int i8 = (indexOf - (this.bp + i3)) + 1 + i3;
                i = i8 + 1;
                charAt = charAt(i8 + this.bp);
                newCollectionByType.add(subString);
            } else if (charAt2 != 'n' || charAt(this.bp + i3) != 'u' || charAt(this.bp + i3 + 1) != 'l' || charAt(this.bp + i3 + 2) != 'l') {
                break;
            } else {
                int i9 = i3 + 3;
                int i10 = i9 + 1;
                charAt = charAt(i9 + this.bp);
                newCollectionByType.add(null);
                i = i10;
            }
            if (charAt == ',') {
                charAt2 = charAt(this.bp + i);
                i3 = i + 1;
            } else if (charAt == ']') {
                int i11 = i + 1;
                char charAt3 = charAt(this.bp + i);
            } else {
                this.matchStat = -1;
                return null;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void scanStringArray(Collection<String> collection, char c) {
        int i;
        char charAt;
        int i2;
        char charAt2;
        this.matchStat = 0;
        char charAt3 = charAt(this.bp + 0);
        if (charAt3 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l' && charAt(this.bp + 1 + 3) == c) {
            this.bp += 5;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
        } else if (charAt3 != '[') {
            this.matchStat = -1;
        } else {
            int i3 = 2;
            char charAt4 = charAt(this.bp + 1);
            while (true) {
                int i4 = i3;
                if (charAt4 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                    int i5 = i4 + 3;
                    int i6 = i5 + 1;
                    charAt = charAt(i5 + this.bp);
                    collection.add(null);
                    i = i6;
                } else if (charAt4 == ']' && collection.size() == 0) {
                    i2 = i4 + 1;
                    charAt2 = charAt(this.bp + i4);
                    break;
                } else if (charAt4 != '\"') {
                    this.matchStat = -1;
                    return;
                } else {
                    int i7 = this.bp + i4;
                    int indexOf = indexOf('\"', i7);
                    if (indexOf == -1) {
                        throw new JSONException("unclosed str");
                    }
                    String subString = subString(this.bp + i4, indexOf - i7);
                    if (subString.indexOf(92) != -1) {
                        while (true) {
                            int i8 = 0;
                            for (int i9 = indexOf - 1; i9 >= 0 && charAt(i9) == '\\'; i9--) {
                                i8++;
                            }
                            if (i8 % 2 == 0) {
                                break;
                            }
                            indexOf = indexOf('\"', indexOf + 1);
                        }
                        int i10 = indexOf - i7;
                        subString = readString(sub_chars(this.bp + i4, i10), i10);
                    }
                    int i11 = (indexOf - (this.bp + i4)) + 1 + i4;
                    i = i11 + 1;
                    charAt = charAt(i11 + this.bp);
                    collection.add(subString);
                }
                if (charAt == ',') {
                    i3 = i + 1;
                    charAt4 = charAt(this.bp + i);
                } else if (charAt == ']') {
                    i2 = i + 1;
                    charAt2 = charAt(this.bp + i);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            if (charAt2 == c) {
                this.bp += i2;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                return;
            }
            this.matchStat = -1;
        }
    }

    public int scanFieldInt(char[] cArr) {
        int i;
        int i2;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length + this.bp);
        boolean z = charAt2 == '-';
        if (z) {
            i = i3 + 1;
            charAt2 = charAt(this.bp + i3);
        } else {
            i = i3;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i4 = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(i + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i4 = (i4 * 10) + (charAt - '0');
                i = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if ((i4 < 0 || i2 > cArr.length + 14) && (i4 != Integer.MIN_VALUE || i2 != 17 || !z)) {
                this.matchStat = -1;
                return 0;
            } else if (charAt == ',') {
                this.bp += i2;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return z ? -i4 : i4;
            } else if (charAt == '}') {
                int i5 = i2 + 1;
                char charAt3 = charAt(this.bp + i2);
                if (charAt3 == ',') {
                    this.token = 16;
                    this.bp += i5;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    this.bp += i5;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    this.bp += i5;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == 26) {
                    this.token = 20;
                    this.bp += i5 - 1;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
                this.matchStat = 4;
                return z ? -i4 : i4;
            } else {
                this.matchStat = -1;
                return 0;
            }
        }
        this.matchStat = -1;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c0, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z;
        char c;
        int i;
        int i2;
        char charAt;
        int[] iArr;
        int i3;
        char charAt2;
        int i4;
        int[] iArr2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i5 = length + 1;
        if (charAt(length + this.bp) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i6 = i5 + 1;
        char charAt3 = charAt(this.bp + i5);
        int[] iArr3 = new int[16];
        if (charAt3 == ']') {
            charAt2 = charAt(this.bp + i6);
            i4 = 0;
            i3 = i6 + 1;
        } else {
            int i7 = 0;
            int[] iArr4 = iArr3;
            while (true) {
                if (charAt3 == '-') {
                    i = i6 + 1;
                    c = charAt(this.bp + i6);
                    z = true;
                } else {
                    z = false;
                    c = charAt3;
                    i = i6;
                }
                if (c < '0' || c > '9') {
                    break;
                }
                int i8 = c - '0';
                while (true) {
                    i2 = i + 1;
                    charAt = charAt(i + this.bp);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i8 = (i8 * 10) + (charAt - '0');
                    i = i2;
                }
                if (i7 >= iArr4.length) {
                    iArr = new int[(iArr4.length * 3) / 2];
                    System.arraycopy(iArr4, 0, iArr, 0, i7);
                } else {
                    iArr = iArr4;
                }
                int i9 = i7 + 1;
                if (z) {
                    i8 = -i8;
                }
                iArr[i7] = i8;
                if (charAt == ',') {
                    charAt3 = charAt(this.bp + i2);
                    i2++;
                } else if (charAt == ']') {
                    i3 = i2 + 1;
                    charAt2 = charAt(this.bp + i2);
                    i4 = i9;
                    iArr3 = iArr;
                    break;
                } else {
                    charAt3 = charAt;
                }
                i7 = i9;
                iArr4 = iArr;
                i6 = i2;
            }
        }
        if (i4 != iArr3.length) {
            int[] iArr5 = new int[i4];
            System.arraycopy(iArr3, 0, iArr5, 0, i4);
            iArr2 = iArr5;
        } else {
            iArr2 = iArr3;
        }
        if (charAt2 == ',') {
            this.bp += i3 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (charAt2 == '}') {
            int i10 = i3 + 1;
            char charAt4 = charAt(this.bp + i3);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i10 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i10 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i10 - 1;
                next();
            } else if (charAt4 == 26) {
                this.bp += i10 - 1;
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0045 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanBoolean(char c) {
        int i = 2;
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                i = 5;
                charAt = charAt(this.bp + 4);
                z = true;
                while (true) {
                    if (charAt != c) {
                        this.bp += i;
                        this.ch = charAt(this.bp);
                        this.matchStat = 3;
                        break;
                    } else if (isWhitespace(charAt)) {
                        charAt = charAt(this.bp + i);
                        i++;
                    } else {
                        this.matchStat = -1;
                        break;
                    }
                }
            } else {
                this.matchStat = -1;
            }
        } else {
            if (charAt == 'f') {
                if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
                    i = 6;
                    charAt = charAt(this.bp + 5);
                } else {
                    this.matchStat = -1;
                }
            } else if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i = 1;
            }
            while (true) {
                if (charAt != c) {
                }
                charAt = charAt(this.bp + i);
                i++;
            }
        }
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            i = 2;
            charAt2 = charAt(this.bp + 1);
        } else {
            i = 1;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i5 = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i5 = (i5 * 10) + (charAt - '0');
                i2 = i4;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if (i5 < 0) {
                this.matchStat = -1;
                return 0;
            } else {
                while (charAt != c) {
                    if (isWhitespace(charAt)) {
                        charAt = charAt(this.bp + i4);
                        i4++;
                    } else {
                        this.matchStat = -1;
                        return z2 ? -i5 : i5;
                    }
                }
                this.bp += i4;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return z2 ? -i5 : i5;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i6 = i2 + 3;
            int i7 = i6 + 1;
            char charAt3 = charAt(i6 + this.bp);
            if (z && charAt3 == '\"') {
                i3 = i7 + 1;
                charAt3 = charAt(this.bp + i7);
            } else {
                i3 = i7;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0;
                } else if (isWhitespace(charAt3)) {
                    charAt3 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return 0;
        } else {
            this.matchStat = -1;
            return 0;
        }
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
        char charAt = charAt(length + this.bp);
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
            i = i7 + 1;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i8 = i + 1;
        char charAt2 = charAt(i + this.bp);
        if (charAt2 == ',') {
            this.bp += i8;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i9 = i8 + 1;
            char charAt3 = charAt(this.bp + i8);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i9;
                this.ch = charAt(this.bp);
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i9;
                this.ch = charAt(this.bp);
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i9;
                this.ch = charAt(this.bp);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i9 - 1;
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

    public long scanFieldLong(char[] cArr) {
        boolean z;
        int i;
        int i2;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length + this.bp);
        if (charAt2 == '-') {
            i = i3 + 1;
            charAt2 = charAt(this.bp + i3);
            z = true;
        } else {
            z = false;
            i = i3;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i2 = i + 1;
                charAt = charAt(i + this.bp);
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
            if (!(i2 - cArr.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z)))) {
                this.matchStat = -1;
                return 0L;
            } else if (charAt == ',') {
                this.bp += i2;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return z ? -j : j;
            } else if (charAt == '}') {
                int i4 = i2 + 1;
                char charAt3 = charAt(this.bp + i2);
                if (charAt3 == ',') {
                    this.token = 16;
                    this.bp += i4;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    this.bp += i4;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    this.bp += i4;
                    this.ch = charAt(this.bp);
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
        this.matchStat = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            i = 2;
            charAt2 = charAt(this.bp + 1);
        } else {
            i = 1;
        }
        boolean z3 = charAt2 == '-';
        if (z3) {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
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
            if (j >= 0 || (j == Long.MIN_VALUE && z3)) {
                z = true;
            }
            if (!z) {
                throw new NumberFormatException(subString(this.bp, i4 - 1));
            }
            if (z2) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                charAt = charAt(this.bp + i4);
                i4++;
            }
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.bp += i4;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j : j;
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i5 = i2 + 3;
            int i6 = i5 + 1;
            char charAt3 = charAt(i5 + this.bp);
            if (z2 && charAt3 == '\"') {
                i3 = i6 + 1;
                charAt3 = charAt(this.bp + i6);
            } else {
                i3 = i6;
            }
            while (charAt3 != ',') {
                if (charAt3 == ']') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0L;
                } else if (isWhitespace(charAt3)) {
                    charAt3 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return 0L;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public final float scanFieldFloat(char[] cArr) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        int i5;
        int i6;
        int i7;
        char c;
        int length;
        int i8;
        int i9;
        float parseFloat;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i10 = length2 + 1;
        char charAt2 = charAt(length2 + this.bp);
        boolean z = charAt2 == '\"';
        if (z) {
            i = i10 + 1;
            charAt2 = charAt(this.bp + i10);
        } else {
            i = i10;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i11 = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i11 = (i11 * 10) + (charAt - '0');
                i2 = i4;
            }
            if (!(charAt == '.')) {
                i5 = 1;
                i6 = i11;
                i7 = i4;
            } else {
                int i12 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    int i13 = (charAt3 - '0') + (i11 * 10);
                    int i14 = 10;
                    while (true) {
                        int i15 = i12;
                        i12 = i15 + 1;
                        charAt = charAt(i15 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i13 = (i13 * 10) + (charAt - '0');
                        i14 *= 10;
                    }
                    i5 = i14;
                    i6 = i13;
                    i7 = i12;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i16 = i7 + 1;
                c = charAt(this.bp + i7);
                if (c == '+' || c == '-') {
                    i7 = i16 + 1;
                    c = charAt(i16 + this.bp);
                } else {
                    i7 = i16;
                }
                while (c >= '0' && c <= '9') {
                    c = charAt(this.bp + i7);
                    i7++;
                }
            } else {
                c = charAt;
            }
            if (z) {
                if (c != '\"') {
                    this.matchStat = -1;
                    return 0.0f;
                }
                i9 = i7 + 1;
                c = charAt(this.bp + i7);
                length = this.bp + cArr.length + 1;
                i8 = ((this.bp + i9) - length) - 2;
            } else {
                length = cArr.length + this.bp;
                i8 = ((this.bp + i7) - length) - 1;
                i9 = i7;
            }
            if (!z3 && i8 < 20) {
                parseFloat = i6 / i5;
                if (z2) {
                    parseFloat = -parseFloat;
                }
            } else {
                parseFloat = Float.parseFloat(subString(length, i8));
            }
            if (c == ',') {
                this.bp += i9;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            } else if (c == '}') {
                int i17 = i9 + 1;
                char charAt4 = charAt(this.bp + i9);
                if (charAt4 == ',') {
                    this.token = 16;
                    this.bp += i17;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    this.bp += i17;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    this.bp += i17;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == 26) {
                    this.bp += i17 - 1;
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
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i18 = i2 + 3;
            int i19 = i18 + 1;
            char charAt5 = charAt(i18 + this.bp);
            if (z && charAt5 == '\"') {
                i3 = i19 + 1;
                charAt5 = charAt(this.bp + i19);
            } else {
                i3 = i19;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0f;
                } else if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return 0.0f;
        } else {
            this.matchStat = -1;
            return 0.0f;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char c) {
        int i;
        int i2;
        int i3;
        char charAt;
        long j;
        int i4;
        char c2;
        int i5;
        int i6;
        int i7;
        float parseFloat;
        int i8;
        this.matchStat = 0;
        int i9 = 1;
        char charAt2 = charAt(0 + this.bp);
        boolean z = charAt2 == '\"';
        if (z) {
            i9 = 2;
            charAt2 = charAt(this.bp + 1);
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i = i9 + 1;
            charAt2 = charAt(this.bp + i9);
        } else {
            i = i9;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j2 = charAt2 - '0';
            while (true) {
                i3 = i + 1;
                charAt = charAt(i + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i = i3;
            }
            long j3 = 1;
            if (charAt == '.') {
                int i10 = i3 + 1;
                char charAt3 = charAt(this.bp + i3);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    long j4 = (charAt3 - '0') + (j2 * 10);
                    long j5 = 10;
                    while (true) {
                        i8 = i10 + 1;
                        charAt = charAt(i10 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j4 = (j4 * 10) + (charAt - '0');
                        j5 *= 10;
                        i10 = i8;
                    }
                    j3 = j5;
                    j = j4;
                    i4 = i8;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            } else {
                j = j2;
                i4 = i3;
            }
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i11 = i4 + 1;
                c2 = charAt(this.bp + i4);
                if (c2 == '+' || c2 == '-') {
                    i4 = i11 + 1;
                    c2 = charAt(i11 + this.bp);
                } else {
                    i4 = i11;
                }
                while (c2 >= '0' && c2 <= '9') {
                    c2 = charAt(this.bp + i4);
                    i4++;
                }
            } else {
                c2 = charAt;
            }
            if (z) {
                if (c2 != '\"') {
                    this.matchStat = -1;
                    return 0.0f;
                }
                i7 = i4 + 1;
                c2 = charAt(this.bp + i4);
                i5 = this.bp + 1;
                i6 = ((this.bp + i7) - i5) - 2;
            } else {
                i5 = this.bp;
                i6 = ((this.bp + i4) - i5) - 1;
                i7 = i4;
            }
            if (!z3 && i6 < 20) {
                parseFloat = ((float) j) / ((float) j3);
                if (z2) {
                    parseFloat = -parseFloat;
                }
            } else {
                parseFloat = Float.parseFloat(subString(i5, i6));
            }
            if (c2 == c) {
                this.bp += i7;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            }
            this.matchStat = -1;
            return parseFloat;
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i + 3;
            int i13 = i12 + 1;
            char charAt4 = charAt(i12 + this.bp);
            if (z && charAt4 == '\"') {
                i2 = i13 + 1;
                charAt4 = charAt(this.bp + i13);
            } else {
                i2 = i13;
            }
            while (charAt4 != ',') {
                if (charAt4 == ']') {
                    this.bp += i2;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0.0f;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i2);
                    i2++;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            this.bp += i2;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return 0.0f;
        } else {
            this.matchStat = -1;
            return 0.0f;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char c) {
        int i;
        int i2;
        int i3;
        char charAt;
        long j;
        int i4;
        char c2;
        int i5;
        int i6;
        int i7;
        double parseDouble;
        int i8;
        this.matchStat = 0;
        int i9 = 1;
        char charAt2 = charAt(0 + this.bp);
        boolean z = charAt2 == '\"';
        if (z) {
            i9 = 2;
            charAt2 = charAt(this.bp + 1);
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i = i9 + 1;
            charAt2 = charAt(this.bp + i9);
        } else {
            i = i9;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j2 = charAt2 - '0';
            while (true) {
                i3 = i + 1;
                charAt = charAt(i + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i = i3;
            }
            long j3 = 1;
            if (charAt == '.') {
                int i10 = i3 + 1;
                char charAt3 = charAt(this.bp + i3);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    long j4 = (charAt3 - '0') + (j2 * 10);
                    long j5 = 10;
                    while (true) {
                        i8 = i10 + 1;
                        charAt = charAt(i10 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j4 = (j4 * 10) + (charAt - '0');
                        j5 *= 10;
                        i10 = i8;
                    }
                    j3 = j5;
                    j = j4;
                    i4 = i8;
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
            } else {
                j = j2;
                i4 = i3;
            }
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i11 = i4 + 1;
                c2 = charAt(this.bp + i4);
                if (c2 == '+' || c2 == '-') {
                    i4 = i11 + 1;
                    c2 = charAt(i11 + this.bp);
                } else {
                    i4 = i11;
                }
                while (c2 >= '0' && c2 <= '9') {
                    c2 = charAt(this.bp + i4);
                    i4++;
                }
            } else {
                c2 = charAt;
            }
            if (z) {
                if (c2 != '\"') {
                    this.matchStat = -1;
                    return 0.0d;
                }
                i7 = i4 + 1;
                c2 = charAt(this.bp + i4);
                i5 = this.bp + 1;
                i6 = ((this.bp + i7) - i5) - 2;
            } else {
                i5 = this.bp;
                i6 = ((this.bp + i4) - i5) - 1;
                i7 = i4;
            }
            if (!z3 && i6 < 20) {
                parseDouble = j / j3;
                if (z2) {
                    parseDouble = -parseDouble;
                }
            } else {
                parseDouble = Double.parseDouble(subString(i5, i6));
            }
            if (c2 == c) {
                this.bp += i7;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            this.matchStat = -1;
            return parseDouble;
        } else if (charAt2 == 'n' && charAt(this.bp + i) == 'u' && charAt(this.bp + i + 1) == 'l' && charAt(this.bp + i + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i + 3;
            int i13 = i12 + 1;
            char charAt4 = charAt(i12 + this.bp);
            if (z && charAt4 == '\"') {
                i2 = i13 + 1;
                charAt4 = charAt(this.bp + i13);
            } else {
                i2 = i13;
            }
            while (charAt4 != ',') {
                if (charAt4 == ']') {
                    this.bp += i2;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 15;
                    return 0.0d;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i2);
                    i2++;
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
            }
            this.bp += i2;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return 0.0d;
        } else {
            this.matchStat = -1;
            return 0.0d;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public BigDecimal scanDecimal(char c) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        int i5;
        int i6;
        int i7;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        boolean z = charAt2 == '\"';
        if (z) {
            i = 2;
            charAt2 = charAt(this.bp + 1);
        } else {
            i = 1;
        }
        if (charAt2 == '-') {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2 = i4;
            }
            if (charAt == '.') {
                int i8 = i4 + 1;
                char charAt3 = charAt(i4 + this.bp);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i4 = i8 + 1;
                        charAt = charAt(i8 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i8 = i4;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i9 = i4;
            if (charAt == 'e' || charAt == 'E') {
                int i10 = i9 + 1;
                charAt = charAt(this.bp + i9);
                if (charAt == '+' || charAt == '-') {
                    i9 = i10 + 1;
                    charAt = charAt(i10 + this.bp);
                } else {
                    i9 = i10;
                }
                while (charAt >= '0' && charAt <= '9') {
                    charAt = charAt(this.bp + i9);
                    i9++;
                }
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                }
                i7 = i9 + 1;
                charAt = charAt(this.bp + i9);
                i5 = this.bp + 1;
                i6 = ((this.bp + i7) - i5) - 2;
            } else {
                i5 = this.bp;
                i6 = ((this.bp + i9) - i5) - 1;
                i7 = i9;
            }
            BigDecimal bigDecimal = new BigDecimal(sub_chars(i5, i6));
            if (charAt == ',') {
                this.bp += i7;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return bigDecimal;
            } else if (charAt == ']') {
                int i11 = i7 + 1;
                char charAt4 = charAt(this.bp + i7);
                if (charAt4 == ',') {
                    this.token = 16;
                    this.bp += i11;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    this.bp += i11;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    this.bp += i11;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.bp += i11 - 1;
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
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i2 + 3;
            int i13 = i12 + 1;
            char charAt5 = charAt(i12 + this.bp);
            if (z && charAt5 == '\"') {
                i3 = i13 + 1;
                charAt5 = charAt(this.bp + i13);
            } else {
                i3 = i13;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ab, code lost:
        r11.matchStat = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] scanFieldFloatArray(char[] cArr) {
        int i;
        int i2;
        int i3;
        float parseFloat;
        float[] fArr;
        int i4;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i5 = length + 1;
        if (charAt(length + this.bp) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i6 = i5 + 1;
        char charAt = charAt(this.bp + i5);
        int i7 = 0;
        float[] fArr2 = new float[16];
        while (true) {
            int i8 = (this.bp + i6) - 1;
            boolean z = charAt == '-';
            if (z) {
                charAt = charAt(this.bp + i6);
                i6++;
            }
            if (charAt < '0' || charAt > '9') {
                break;
            }
            int i9 = charAt - '0';
            while (true) {
                int i10 = i6;
                i6 = i10 + 1;
                charAt = charAt(i10 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i9 = (i9 * 10) + (charAt - '0');
            }
            if (!(charAt == '.')) {
                i = 1;
                i2 = i9;
                i3 = i6;
            } else {
                int i11 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                int i12 = (charAt2 - '0') + (i9 * 10);
                int i13 = 10;
                while (true) {
                    i4 = i11 + 1;
                    charAt = charAt(this.bp + i11);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i13 *= 10;
                    i12 = (charAt - '0') + (i12 * 10);
                    i11 = i4;
                }
                i = i13;
                i2 = i12;
                i3 = i4;
            }
            boolean z2 = charAt == 'e' || charAt == 'E';
            if (z2) {
                i6 = i3 + 1;
                char charAt3 = charAt(this.bp + i3);
                if (charAt3 == '+' || charAt3 == '-') {
                    charAt3 = charAt(this.bp + i6);
                    i6++;
                }
                while (charAt3 >= '0' && charAt3 <= '9') {
                    charAt3 = charAt(this.bp + i6);
                    i6++;
                }
                charAt = charAt3;
            } else {
                i6 = i3;
            }
            int i14 = ((this.bp + i6) - i8) - 1;
            if (!z2 && i14 < 10) {
                float f = i2 / i;
                parseFloat = z ? -f : f;
            } else {
                parseFloat = Float.parseFloat(subString(i8, i14));
            }
            if (i7 >= fArr2.length) {
                float[] fArr3 = new float[(fArr2.length * 3) / 2];
                System.arraycopy(fArr2, 0, fArr3, 0, i7);
                fArr2 = fArr3;
            }
            int i15 = i7 + 1;
            fArr2[i7] = parseFloat;
            if (charAt == ',') {
                charAt = charAt(this.bp + i6);
                i6++;
            } else if (charAt == ']') {
                int i16 = i6 + 1;
                char charAt4 = charAt(this.bp + i6);
                if (i15 != fArr2.length) {
                    fArr = new float[i15];
                    System.arraycopy(fArr2, 0, fArr, 0, i15);
                } else {
                    fArr = fArr2;
                }
                if (charAt4 == ',') {
                    this.bp += i16 - 1;
                    next();
                    this.matchStat = 3;
                    this.token = 16;
                    return fArr;
                } else if (charAt4 == '}') {
                    int i17 = i16 + 1;
                    char charAt5 = charAt(this.bp + i16);
                    if (charAt5 == ',') {
                        this.token = 16;
                        this.bp += i17 - 1;
                        next();
                    } else if (charAt5 == ']') {
                        this.token = 15;
                        this.bp += i17 - 1;
                        next();
                    } else if (charAt5 == '}') {
                        this.token = 13;
                        this.bp += i17 - 1;
                        next();
                    } else if (charAt5 == 26) {
                        this.bp += i17 - 1;
                        this.token = 20;
                        this.ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                    this.matchStat = 4;
                    return fArr;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            i7 = i15;
        }
        this.matchStat = -1;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0182, code lost:
        r13.matchStat = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[][] scanFieldFloatArray2(char[] cArr) {
        char charAt;
        int i;
        int i2;
        float parseFloat;
        float[][] fArr;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        if (charAt(length + this.bp) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i4 = i3 + 1;
        char charAt2 = charAt(this.bp + i3);
        float[][] fArr2 = new float[16];
        int i5 = 0;
        loop0: while (true) {
            if (charAt2 == '[') {
                int i6 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                int i7 = 0;
                float[] fArr3 = new float[16];
                while (true) {
                    int i8 = (this.bp + i6) - 1;
                    boolean z = charAt3 == '-';
                    if (z) {
                        charAt3 = charAt(this.bp + i6);
                        i6++;
                    }
                    if (charAt3 < '0' || charAt3 > '9') {
                        break loop0;
                    }
                    int i9 = charAt3 - '0';
                    while (true) {
                        int i10 = i6;
                        i6 = i10 + 1;
                        charAt = charAt(i10 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i9 = (i9 * 10) + (charAt - '0');
                    }
                    if (charAt != '.') {
                        i = 1;
                        i2 = i9;
                    } else {
                        int i11 = i6 + 1;
                        char charAt4 = charAt(this.bp + i6);
                        if (charAt4 < '0' || charAt4 > '9') {
                            break loop0;
                        }
                        int i12 = (charAt4 - '0') + (i9 * 10);
                        int i13 = 10;
                        while (true) {
                            int i14 = i11;
                            i11 = i14 + 1;
                            charAt = charAt(i14 + this.bp);
                            if (charAt < '0' || charAt > '9') {
                                break;
                            }
                            i12 = (i12 * 10) + (charAt - '0');
                            i13 *= 10;
                        }
                        i = i13;
                        i2 = i12;
                        i6 = i11;
                    }
                    boolean z2 = charAt == 'e' || charAt == 'E';
                    if (z2) {
                        int i15 = i6 + 1;
                        char charAt5 = charAt(this.bp + i6);
                        if (charAt5 == '+' || charAt5 == '-') {
                            i6 = i15 + 1;
                            charAt5 = charAt(this.bp + i15);
                        } else {
                            i6 = i15;
                        }
                        while (charAt5 >= '0' && charAt5 <= '9') {
                            charAt5 = charAt(this.bp + i6);
                            i6++;
                        }
                        charAt3 = charAt5;
                    } else {
                        charAt3 = charAt;
                    }
                    int i16 = ((this.bp + i6) - i8) - 1;
                    if (!z2 && i16 < 10) {
                        float f = i2 / i;
                        parseFloat = z ? -f : f;
                    } else {
                        parseFloat = Float.parseFloat(subString(i8, i16));
                    }
                    if (i7 >= fArr3.length) {
                        float[] fArr4 = new float[(fArr3.length * 3) / 2];
                        System.arraycopy(fArr3, 0, fArr4, 0, i7);
                        fArr3 = fArr4;
                    }
                    int i17 = i7 + 1;
                    fArr3[i7] = parseFloat;
                    if (charAt3 == ',') {
                        charAt3 = charAt(this.bp + i6);
                        i6++;
                    } else if (charAt3 == ']') {
                        int i18 = i6 + 1;
                        char charAt6 = charAt(this.bp + i6);
                        if (i17 != fArr3.length) {
                            float[] fArr5 = new float[i17];
                            System.arraycopy(fArr3, 0, fArr5, 0, i17);
                            fArr3 = fArr5;
                        }
                        if (i5 >= fArr2.length) {
                            fArr = new float[(fArr2.length * 3) / 2];
                            System.arraycopy(fArr3, 0, fArr, 0, i17);
                        } else {
                            fArr = fArr2;
                        }
                        int i19 = i5 + 1;
                        fArr[i5] = fArr3;
                        if (charAt6 == ',') {
                            i4 = i18 + 1;
                            charAt2 = charAt(this.bp + i18);
                        } else if (charAt6 == ']') {
                            int i20 = i18 + 1;
                            char charAt7 = charAt(this.bp + i18);
                            if (i19 != fArr.length) {
                                float[][] fArr6 = new float[i19];
                                System.arraycopy(fArr, 0, fArr6, 0, i19);
                                fArr = fArr6;
                            }
                            if (charAt7 == ',') {
                                this.bp += i20 - 1;
                                next();
                                this.matchStat = 3;
                                this.token = 16;
                                return fArr;
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
                                return fArr;
                            } else {
                                this.matchStat = -1;
                                return null;
                            }
                        } else {
                            charAt2 = charAt6;
                            i4 = i18;
                        }
                        i5 = i19;
                        fArr2 = fArr;
                    }
                    i7 = i17;
                }
            }
        }
        this.matchStat = -1;
        return null;
    }

    public final double scanFieldDouble(char[] cArr) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        long j;
        int i5;
        char c;
        int length;
        int i6;
        int i7;
        double parseDouble;
        int i8;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i9 = length2 + 1;
        char charAt2 = charAt(length2 + this.bp);
        boolean z = charAt2 == '\"';
        if (z) {
            i = i9 + 1;
            charAt2 = charAt(this.bp + i9);
        } else {
            i = i9;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j2 = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i2 = i4;
            }
            long j3 = 1;
            if (charAt == '.') {
                int i10 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    long j4 = (charAt3 - '0') + (j2 * 10);
                    long j5 = 10;
                    while (true) {
                        i8 = i10 + 1;
                        charAt = charAt(i10 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j4 = (j4 * 10) + (charAt - '0');
                        j5 *= 10;
                        i10 = i8;
                    }
                    j3 = j5;
                    j = j4;
                    i5 = i8;
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
                int i11 = i5 + 1;
                c = charAt(this.bp + i5);
                if (c == '+' || c == '-') {
                    i5 = i11 + 1;
                    c = charAt(i11 + this.bp);
                } else {
                    i5 = i11;
                }
                while (c >= '0' && c <= '9') {
                    c = charAt(this.bp + i5);
                    i5++;
                }
            } else {
                c = charAt;
            }
            if (z) {
                if (c != '\"') {
                    this.matchStat = -1;
                    return 0.0d;
                }
                i7 = i5 + 1;
                c = charAt(this.bp + i5);
                length = this.bp + cArr.length + 1;
                i6 = ((this.bp + i7) - length) - 2;
            } else {
                length = cArr.length + this.bp;
                i6 = ((this.bp + i5) - length) - 1;
                i7 = i5;
            }
            if (!z3 && i6 < 20) {
                parseDouble = j / j3;
                if (z2) {
                    parseDouble = -parseDouble;
                }
            } else {
                parseDouble = Double.parseDouble(subString(length, i6));
            }
            if (c == ',') {
                this.bp += i7;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            } else if (c == '}') {
                int i12 = i7 + 1;
                char charAt4 = charAt(this.bp + i7);
                if (charAt4 == ',') {
                    this.token = 16;
                    this.bp += i12;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    this.bp += i12;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    this.bp += i12;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.bp += i12 - 1;
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
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i13 = i2 + 3;
            int i14 = i13 + 1;
            char charAt5 = charAt(i13 + this.bp);
            if (z && charAt5 == '\"') {
                i3 = i14 + 1;
                charAt5 = charAt(this.bp + i14);
            } else {
                i3 = i14;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0d;
                } else if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return 0.0d;
        } else {
            this.matchStat = -1;
            return 0.0d;
        }
    }

    public BigDecimal scanFieldDecimal(char[] cArr) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        int length;
        int i5;
        int i6;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i7 = length2 + 1;
        char charAt2 = charAt(length2 + this.bp);
        boolean z = charAt2 == '\"';
        if (z) {
            i = i7 + 1;
            charAt2 = charAt(i7 + this.bp);
        } else {
            i = i7;
        }
        if (charAt2 == '-') {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2 = i4;
            }
            if (charAt == '.') {
                int i8 = i4 + 1;
                char charAt3 = charAt(i4 + this.bp);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i4 = i8 + 1;
                        charAt = charAt(i8 + this.bp);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i8 = i4;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            int i9 = i4;
            if (charAt == 'e' || charAt == 'E') {
                int i10 = i9 + 1;
                charAt = charAt(this.bp + i9);
                if (charAt == '+' || charAt == '-') {
                    i9 = i10 + 1;
                    charAt = charAt(i10 + this.bp);
                } else {
                    i9 = i10;
                }
                while (charAt >= '0' && charAt <= '9') {
                    charAt = charAt(this.bp + i9);
                    i9++;
                }
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                }
                i6 = i9 + 1;
                charAt = charAt(this.bp + i9);
                length = this.bp + cArr.length + 1;
                i5 = ((this.bp + i6) - length) - 2;
            } else {
                length = cArr.length + this.bp;
                i5 = ((this.bp + i9) - length) - 1;
                i6 = i9;
            }
            BigDecimal bigDecimal = new BigDecimal(sub_chars(length, i5));
            if (charAt == ',') {
                this.bp += i6;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return bigDecimal;
            } else if (charAt == '}') {
                int i11 = i6 + 1;
                char charAt4 = charAt(this.bp + i6);
                if (charAt4 == ',') {
                    this.token = 16;
                    this.bp += i11;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    this.bp += i11;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    this.bp += i11;
                    this.ch = charAt(this.bp);
                } else if (charAt4 == 26) {
                    this.token = 20;
                    this.bp += i11 - 1;
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
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i12 = i2 + 3;
            int i13 = i12 + 1;
            char charAt5 = charAt(i12 + this.bp);
            if (z && charAt5 == '\"') {
                i3 = i13 + 1;
                charAt5 = charAt(this.bp + i13);
            } else {
                i3 = i13;
            }
            while (charAt5 != ',') {
                if (charAt5 == '}') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt5)) {
                    charAt5 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i;
        int i2;
        int i3;
        int i4;
        char charAt;
        int length;
        int i5;
        int i6;
        BigInteger valueOf;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i7 = length2 + 1;
        char charAt2 = charAt(length2 + this.bp);
        boolean z = charAt2 == '\"';
        if (z) {
            i = i7 + 1;
            charAt2 = charAt(this.bp + i7);
        } else {
            i = i7;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            i2 = i + 1;
            charAt2 = charAt(this.bp + i);
        } else {
            i2 = i;
        }
        if (charAt2 >= '0' && charAt2 <= '9') {
            long j = charAt2 - '0';
            while (true) {
                i4 = i2 + 1;
                charAt = charAt(i2 + this.bp);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i2 = i4;
            }
            if (z) {
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return null;
                }
                i6 = i4 + 1;
                charAt = charAt(this.bp + i4);
                int length3 = this.bp + cArr.length + 1;
                i5 = ((this.bp + i6) - length3) - 2;
                length = length3;
            } else {
                length = cArr.length + this.bp;
                i5 = ((this.bp + i4) - length) - 1;
                i6 = i4;
            }
            if (i5 < 20 || (z2 && i5 < 21)) {
                if (z2) {
                    j = -j;
                }
                valueOf = BigInteger.valueOf(j);
            } else {
                valueOf = new BigInteger(subString(length, i5));
            }
            if (charAt == ',') {
                this.bp += i6;
                this.ch = charAt(this.bp);
                this.matchStat = 3;
                this.token = 16;
                return valueOf;
            } else if (charAt == '}') {
                int i8 = i6 + 1;
                char charAt3 = charAt(this.bp + i6);
                if (charAt3 == ',') {
                    this.token = 16;
                    this.bp += i8;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    this.bp += i8;
                    this.ch = charAt(this.bp);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    this.bp += i8;
                    this.ch = charAt(this.bp);
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
        } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
            this.matchStat = 5;
            int i9 = i2 + 3;
            int i10 = i9 + 1;
            char charAt4 = charAt(i9 + this.bp);
            if (z && charAt4 == '\"') {
                i3 = i10 + 1;
                charAt4 = charAt(this.bp + i10);
            } else {
                i3 = i10;
            }
            while (charAt4 != ',') {
                if (charAt4 == '}') {
                    this.bp += i3;
                    this.ch = charAt(this.bp);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                } else if (isWhitespace(charAt4)) {
                    charAt4 = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            this.bp += i3;
            this.ch = charAt(this.bp);
            this.matchStat = 5;
            this.token = 16;
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public Date scanFieldDate(char[] cArr) {
        boolean z;
        int i;
        int i2;
        Date date;
        char c;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i3 = length + 1;
        char charAt = charAt(length + this.bp);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
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
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int length3 = indexOf - ((this.bp + cArr.length) + 1);
                subString = readString(sub_chars(this.bp + cArr.length + 1, length3), length3);
            }
            int length4 = (indexOf - ((this.bp + cArr.length) + 1)) + 1 + i3;
            i2 = length4 + 1;
            char charAt2 = charAt(length4 + this.bp);
            JSONScanner jSONScanner = new JSONScanner(subString);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    date = jSONScanner.getCalendar().getTime();
                    jSONScanner.close();
                    c = charAt2;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } finally {
                jSONScanner.close();
            }
        } else if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
            long j = 0;
            if (charAt == '-') {
                i = i3 + 1;
                charAt = charAt(this.bp + i3);
                z = true;
            } else {
                z = false;
                i = i3;
            }
            if (charAt >= '0' && charAt <= '9') {
                j = charAt - '0';
                while (true) {
                    i2 = i + 1;
                    charAt = charAt(i + this.bp);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i = i2;
                }
            } else {
                i2 = i;
            }
            if (j < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new Date(j);
            c = charAt;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c == ',') {
            this.bp += i2;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return date;
        } else if (c == '}') {
            int i6 = i2 + 1;
            char charAt3 = charAt(this.bp + i2);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i6;
                this.ch = charAt(this.bp);
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i6;
                this.ch = charAt(this.bp);
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i6;
                this.ch = charAt(this.bp);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i6 - 1;
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

    public Date scanDate(char c) {
        boolean z;
        int i;
        Date date;
        char c2;
        this.matchStat = 0;
        int i2 = 1;
        char charAt = charAt(this.bp + 0);
        if (charAt == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
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
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i6 = indexOf - (this.bp + 1);
                subString = readString(sub_chars(this.bp + 1, i6), i6);
            }
            int i7 = (indexOf - (this.bp + 1)) + 1 + 1;
            i = i7 + 1;
            char charAt2 = charAt(i7 + this.bp);
            JSONScanner jSONScanner = new JSONScanner(subString);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    date = jSONScanner.getCalendar().getTime();
                    jSONScanner.close();
                    c2 = charAt2;
                } else {
                    this.matchStat = -1;
                    return null;
                }
            } finally {
                jSONScanner.close();
            }
        } else if (charAt == '-' || (charAt >= '0' && charAt <= '9')) {
            long j = 0;
            if (charAt == '-') {
                i2 = 2;
                charAt = charAt(this.bp + 1);
                z = true;
            } else {
                z = false;
            }
            if (charAt >= '0' && charAt <= '9') {
                j = charAt - '0';
                while (true) {
                    i = i2 + 1;
                    charAt = charAt(i2 + this.bp);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i2 = i;
                }
            } else {
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
            c2 = charAt;
        } else if (charAt == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
            this.matchStat = 5;
            c2 = charAt(this.bp + 4);
            date = null;
            i = 5;
        } else {
            this.matchStat = -1;
            return null;
        }
        if (c2 == ',') {
            this.bp += i;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (c2 == ']') {
            int i8 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                this.bp += i8;
                this.ch = charAt(this.bp);
            } else if (charAt3 == ']') {
                this.token = 15;
                this.bp += i8;
                this.ch = charAt(this.bp);
            } else if (charAt3 == '}') {
                this.token = 13;
                this.bp += i8;
                this.ch = charAt(this.bp);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i8 - 1;
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

    /* JADX WARN: Code restructure failed: missing block: B:139:0x01ec, code lost:
        r12.matchStat = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x022b, code lost:
        r12.matchStat = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:?, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UUID scanFieldUUID(char[] cArr) {
        UUID uuid;
        int i;
        char charAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i9 = length + 1;
        char charAt2 = charAt(length + this.bp);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int length2 = this.bp + cArr.length + 1;
            int i10 = indexOf - length2;
            if (i10 == 36) {
                long j = 0;
                long j2 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 < 8) {
                        char charAt3 = charAt(length2 + i12);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            i8 = charAt3 - '0';
                        } else if (charAt3 >= 'a' && charAt3 <= 'f') {
                            i8 = (charAt3 - 'a') + 10;
                        } else if (charAt3 < 'A' || charAt3 > 'F') {
                            break;
                        } else {
                            i8 = (charAt3 - 'A') + 10;
                        }
                        j = (j << 4) | i8;
                        i11 = i12 + 1;
                    } else {
                        int i13 = 9;
                        while (true) {
                            int i14 = i13;
                            if (i14 < 13) {
                                char charAt4 = charAt(length2 + i14);
                                if (charAt4 >= '0' && charAt4 <= '9') {
                                    i7 = charAt4 - '0';
                                } else if (charAt4 >= 'a' && charAt4 <= 'f') {
                                    i7 = (charAt4 - 'a') + 10;
                                } else if (charAt4 < 'A' || charAt4 > 'F') {
                                    break;
                                } else {
                                    i7 = (charAt4 - 'A') + 10;
                                }
                                j = (j << 4) | i7;
                                i13 = i14 + 1;
                            } else {
                                int i15 = 14;
                                while (true) {
                                    int i16 = i15;
                                    if (i16 < 18) {
                                        char charAt5 = charAt(length2 + i16);
                                        if (charAt5 >= '0' && charAt5 <= '9') {
                                            i6 = charAt5 - '0';
                                        } else if (charAt5 >= 'a' && charAt5 <= 'f') {
                                            i6 = (charAt5 - 'a') + 10;
                                        } else if (charAt5 < 'A' || charAt5 > 'F') {
                                            break;
                                        } else {
                                            i6 = (charAt5 - 'A') + 10;
                                        }
                                        j = (j << 4) | i6;
                                        i15 = i16 + 1;
                                    } else {
                                        int i17 = 19;
                                        while (true) {
                                            int i18 = i17;
                                            if (i18 < 23) {
                                                char charAt6 = charAt(length2 + i18);
                                                if (charAt6 >= '0' && charAt6 <= '9') {
                                                    i5 = charAt6 - '0';
                                                } else if (charAt6 >= 'a' && charAt6 <= 'f') {
                                                    i5 = (charAt6 - 'a') + 10;
                                                } else if (charAt6 < 'A' || charAt6 > 'F') {
                                                    break;
                                                } else {
                                                    i5 = (charAt6 - 'A') + 10;
                                                }
                                                j2 = (j2 << 4) | i5;
                                                i17 = i18 + 1;
                                            } else {
                                                int i19 = 24;
                                                while (true) {
                                                    int i20 = i19;
                                                    if (i20 < 36) {
                                                        char charAt7 = charAt(length2 + i20);
                                                        if (charAt7 >= '0' && charAt7 <= '9') {
                                                            i4 = charAt7 - '0';
                                                        } else if (charAt7 >= 'a' && charAt7 <= 'f') {
                                                            i4 = (charAt7 - 'a') + 10;
                                                        } else if (charAt7 < 'A' || charAt7 > 'F') {
                                                            break;
                                                        } else {
                                                            i4 = (charAt7 - 'A') + 10;
                                                        }
                                                        j2 = (j2 << 4) | i4;
                                                        i19 = i20 + 1;
                                                    } else {
                                                        uuid = new UUID(j, j2);
                                                        int length3 = (indexOf - ((this.bp + cArr.length) + 1)) + 1 + i9;
                                                        i = length3 + 1;
                                                        charAt = charAt(length3 + this.bp);
                                                        break;
                                                    }
                                                }
                                                this.matchStat = -2;
                                                return null;
                                            }
                                        }
                                        this.matchStat = -2;
                                        return null;
                                    }
                                }
                                this.matchStat = -2;
                                return null;
                            }
                        }
                        this.matchStat = -2;
                        return null;
                    }
                }
                this.matchStat = -2;
                return null;
            } else if (i10 == 32) {
                long j3 = 0;
                long j4 = 0;
                int i21 = 0;
                while (true) {
                    int i22 = i21;
                    if (i22 < 16) {
                        char charAt8 = charAt(length2 + i22);
                        if (charAt8 >= '0' && charAt8 <= '9') {
                            i3 = charAt8 - '0';
                        } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                            i3 = (charAt8 - 'a') + 10;
                        } else if (charAt8 < 'A' || charAt8 > 'F') {
                            break;
                        } else {
                            i3 = (charAt8 - 'A') + 10;
                        }
                        j3 = (j3 << 4) | i3;
                        i21 = i22 + 1;
                    } else {
                        int i23 = 16;
                        while (true) {
                            int i24 = i23;
                            if (i24 < 32) {
                                char charAt9 = charAt(length2 + i24);
                                if (charAt9 >= '0' && charAt9 <= '9') {
                                    i2 = charAt9 - '0';
                                } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                    i2 = (charAt9 - 'a') + 10;
                                } else if (charAt9 < 'A' || charAt9 > 'F') {
                                    break;
                                } else {
                                    i2 = (charAt9 - 'A') + 10;
                                }
                                j4 = (j4 << 4) | i2;
                                i23 = i24 + 1;
                            } else {
                                uuid = new UUID(j3, j4);
                                int length4 = (indexOf - ((this.bp + cArr.length) + 1)) + 1 + i9;
                                i = length4 + 1;
                                charAt = charAt(length4 + this.bp);
                                break;
                            }
                        }
                    }
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            if (charAt2 == 'n') {
                int i25 = i9 + 1;
                if (charAt(this.bp + i9) == 'u') {
                    int i26 = i25 + 1;
                    if (charAt(this.bp + i25) == 'l') {
                        int i27 = i26 + 1;
                        if (charAt(this.bp + i26) == 'l') {
                            uuid = null;
                            i = i27 + 1;
                            charAt = charAt(i27 + this.bp);
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            this.bp += i;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return uuid;
        } else if (charAt == '}') {
            int i28 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                this.bp += i28;
                this.ch = charAt(this.bp);
            } else if (charAt10 == ']') {
                this.token = 15;
                this.bp += i28;
                this.ch = charAt(this.bp);
            } else if (charAt10 == '}') {
                this.token = 13;
                this.bp += i28;
                this.ch = charAt(this.bp);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i28 - 1;
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

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
        r10.matchStat = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UUID scanUUID(char c) {
        UUID uuid;
        int i;
        char charAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.matchStat = 0;
        char charAt2 = charAt(0 + this.bp);
        if (charAt2 == '\"') {
            int indexOf = indexOf('\"', this.bp + 1);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i9 = this.bp + 1;
            int i10 = indexOf - i9;
            if (i10 == 36) {
                long j = 0;
                long j2 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 < 8) {
                        char charAt3 = charAt(i9 + i12);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            i8 = charAt3 - '0';
                        } else if (charAt3 >= 'a' && charAt3 <= 'f') {
                            i8 = (charAt3 - 'a') + 10;
                        } else if (charAt3 < 'A' || charAt3 > 'F') {
                            break;
                        } else {
                            i8 = (charAt3 - 'A') + 10;
                        }
                        j = (j << 4) | i8;
                        i11 = i12 + 1;
                    } else {
                        int i13 = 9;
                        while (true) {
                            int i14 = i13;
                            if (i14 < 13) {
                                char charAt4 = charAt(i9 + i14);
                                if (charAt4 >= '0' && charAt4 <= '9') {
                                    i7 = charAt4 - '0';
                                } else if (charAt4 >= 'a' && charAt4 <= 'f') {
                                    i7 = (charAt4 - 'a') + 10;
                                } else if (charAt4 < 'A' || charAt4 > 'F') {
                                    break;
                                } else {
                                    i7 = (charAt4 - 'A') + 10;
                                }
                                j = (j << 4) | i7;
                                i13 = i14 + 1;
                            } else {
                                int i15 = 14;
                                while (true) {
                                    int i16 = i15;
                                    if (i16 < 18) {
                                        char charAt5 = charAt(i9 + i16);
                                        if (charAt5 >= '0' && charAt5 <= '9') {
                                            i6 = charAt5 - '0';
                                        } else if (charAt5 >= 'a' && charAt5 <= 'f') {
                                            i6 = (charAt5 - 'a') + 10;
                                        } else if (charAt5 < 'A' || charAt5 > 'F') {
                                            break;
                                        } else {
                                            i6 = (charAt5 - 'A') + 10;
                                        }
                                        j = (j << 4) | i6;
                                        i15 = i16 + 1;
                                    } else {
                                        int i17 = 19;
                                        while (true) {
                                            int i18 = i17;
                                            if (i18 < 23) {
                                                char charAt6 = charAt(i9 + i18);
                                                if (charAt6 >= '0' && charAt6 <= '9') {
                                                    i5 = charAt6 - '0';
                                                } else if (charAt6 >= 'a' && charAt6 <= 'f') {
                                                    i5 = (charAt6 - 'a') + 10;
                                                } else if (charAt6 < 'A' || charAt6 > 'F') {
                                                    break;
                                                } else {
                                                    i5 = (charAt6 - 'A') + 10;
                                                }
                                                j2 = (j2 << 4) | i5;
                                                i17 = i18 + 1;
                                            } else {
                                                int i19 = 24;
                                                while (true) {
                                                    int i20 = i19;
                                                    if (i20 < 36) {
                                                        char charAt7 = charAt(i9 + i20);
                                                        if (charAt7 >= '0' && charAt7 <= '9') {
                                                            i4 = charAt7 - '0';
                                                        } else if (charAt7 >= 'a' && charAt7 <= 'f') {
                                                            i4 = (charAt7 - 'a') + 10;
                                                        } else if (charAt7 < 'A' || charAt7 > 'F') {
                                                            break;
                                                        } else {
                                                            i4 = (charAt7 - 'A') + 10;
                                                        }
                                                        j2 = (j2 << 4) | i4;
                                                        i19 = i20 + 1;
                                                    } else {
                                                        uuid = new UUID(j, j2);
                                                        int i21 = (indexOf - (this.bp + 1)) + 1 + 1;
                                                        i = i21 + 1;
                                                        charAt = charAt(i21 + this.bp);
                                                        break;
                                                    }
                                                }
                                                this.matchStat = -2;
                                                return null;
                                            }
                                        }
                                        this.matchStat = -2;
                                        return null;
                                    }
                                }
                                this.matchStat = -2;
                                return null;
                            }
                        }
                        this.matchStat = -2;
                        return null;
                    }
                }
            } else if (i10 == 32) {
                long j3 = 0;
                long j4 = 0;
                int i22 = 0;
                while (true) {
                    int i23 = i22;
                    if (i23 < 16) {
                        char charAt8 = charAt(i9 + i23);
                        if (charAt8 >= '0' && charAt8 <= '9') {
                            i3 = charAt8 - '0';
                        } else if (charAt8 >= 'a' && charAt8 <= 'f') {
                            i3 = (charAt8 - 'a') + 10;
                        } else if (charAt8 < 'A' || charAt8 > 'F') {
                            break;
                        } else {
                            i3 = (charAt8 - 'A') + 10;
                        }
                        j3 = (j3 << 4) | i3;
                        i22 = i23 + 1;
                    } else {
                        int i24 = 16;
                        while (true) {
                            int i25 = i24;
                            if (i25 < 32) {
                                char charAt9 = charAt(i9 + i25);
                                if (charAt9 >= '0' && charAt9 <= '9') {
                                    i2 = charAt9 - '0';
                                } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                    i2 = (charAt9 - 'a') + 10;
                                } else if (charAt9 < 'A' || charAt9 > 'F') {
                                    break;
                                } else {
                                    i2 = (charAt9 - 'A') + 10;
                                }
                                j4 = (j4 << 4) | i2;
                                i24 = i25 + 1;
                            } else {
                                uuid = new UUID(j3, j4);
                                int i26 = (indexOf - (this.bp + 1)) + 1 + 1;
                                i = i26 + 1;
                                charAt = charAt(i26 + this.bp);
                                break;
                            }
                        }
                        this.matchStat = -2;
                        return null;
                    }
                }
                this.matchStat = -2;
                return null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
            uuid = null;
            i = 5;
            charAt = charAt(this.bp + 4);
        } else {
            this.matchStat = -1;
            return null;
        }
        if (charAt == ',') {
            this.bp += i;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return uuid;
        } else if (charAt == ']') {
            int i27 = i + 1;
            char charAt10 = charAt(this.bp + i);
            if (charAt10 == ',') {
                this.token = 16;
                this.bp += i27;
                this.ch = charAt(this.bp);
            } else if (charAt10 == ']') {
                this.token = 15;
                this.bp += i27;
                this.ch = charAt(this.bp);
            } else if (charAt10 == '}') {
                this.token = 13;
                this.bp += i27;
                this.ch = charAt(this.bp);
            } else if (charAt10 == 26) {
                this.token = 20;
                this.bp += i27 - 1;
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

    public final void scanTrue() {
        if (this.ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b' || this.ch == ':' || this.ch == '/') {
            this.token = 6;
            return;
        }
        throw new JSONException("scan true error");
    }

    public final void scanNullOrNew() {
        if (this.ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        if (this.ch == 'u') {
            next();
            if (this.ch != 'l') {
                throw new JSONException("error parse null");
            }
            next();
            if (this.ch != 'l') {
                throw new JSONException("error parse null");
            }
            next();
            if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b') {
                this.token = 8;
                return;
            }
            throw new JSONException("scan null error");
        } else if (this.ch != 'e') {
            throw new JSONException("error parse new");
        } else {
            next();
            if (this.ch != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b') {
                this.token = 9;
                return;
            }
            throw new JSONException("scan new error");
        }
    }

    public final void scanFalse() {
        if (this.ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.ch == ' ' || this.ch == ',' || this.ch == '}' || this.ch == ']' || this.ch == '\n' || this.ch == '\r' || this.ch == '\t' || this.ch == 26 || this.ch == '\f' || this.ch == '\b' || this.ch == ':' || this.ch == '/') {
            this.token = 7;
            return;
        }
        throw new JSONException("scan false error");
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
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

    public static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                i2 = i4 + 1;
                cArr2[i4] = c;
            } else {
                i3++;
                switch (cArr[i3]) {
                    case '\"':
                        i2 = i4 + 1;
                        cArr2[i4] = '\"';
                        continue;
                    case '\'':
                        i2 = i4 + 1;
                        cArr2[i4] = '\'';
                        continue;
                    case '/':
                        i2 = i4 + 1;
                        cArr2[i4] = '/';
                        continue;
                    case '0':
                        i2 = i4 + 1;
                        cArr2[i4] = 0;
                        continue;
                    case '1':
                        i2 = i4 + 1;
                        cArr2[i4] = 1;
                        continue;
                    case '2':
                        i2 = i4 + 1;
                        cArr2[i4] = 2;
                        continue;
                    case '3':
                        i2 = i4 + 1;
                        cArr2[i4] = 3;
                        continue;
                    case '4':
                        i2 = i4 + 1;
                        cArr2[i4] = 4;
                        continue;
                    case '5':
                        i2 = i4 + 1;
                        cArr2[i4] = 5;
                        continue;
                    case '6':
                        i2 = i4 + 1;
                        cArr2[i4] = 6;
                        continue;
                    case '7':
                        i2 = i4 + 1;
                        cArr2[i4] = 7;
                        continue;
                    case 'F':
                    case 'f':
                        i2 = i4 + 1;
                        cArr2[i4] = '\f';
                        continue;
                    case '\\':
                        i2 = i4 + 1;
                        cArr2[i4] = '\\';
                        continue;
                    case 'b':
                        i2 = i4 + 1;
                        cArr2[i4] = '\b';
                        continue;
                    case 'n':
                        i2 = i4 + 1;
                        cArr2[i4] = '\n';
                        continue;
                    case 'r':
                        i2 = i4 + 1;
                        cArr2[i4] = '\r';
                        continue;
                    case 't':
                        i2 = i4 + 1;
                        cArr2[i4] = '\t';
                        continue;
                    case 'u':
                        i2 = i4 + 1;
                        int i5 = i3 + 1;
                        int i6 = i5 + 1;
                        int i7 = i6 + 1;
                        i3 = i7 + 1;
                        cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                        continue;
                    case 'v':
                        i2 = i4 + 1;
                        cArr2[i4] = 11;
                        continue;
                    case 'x':
                        i2 = i4 + 1;
                        int i8 = i3 + 1;
                        i3 = i8 + 1;
                        cArr2[i4] = (char) ((digits[cArr[i8]] * 16) + digits[cArr[i3]]);
                        continue;
                    default:
                        throw new JSONException("unclosed.str.lit");
                }
            }
            i3++;
            i4 = i2;
        }
        return new String(cArr2, 0, i4);
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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (this.ch <= '/') {
            if (this.ch == ' ' || this.ch == '\r' || this.ch == '\n' || this.ch == '\t' || this.ch == '\f' || this.ch == '\b') {
                next();
            } else if (this.ch == '/') {
                skipComment();
            } else {
                return;
            }
        }
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next != '\'') {
                if (next == 26) {
                    if (!isEOF()) {
                        putChar(JSONLexer.EOI);
                    } else {
                        throw new JSONException("unclosed single-quote string");
                    }
                } else if (next == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        if (this.sp > this.sbuf.length) {
                            char[] cArr = new char[this.sp * 2];
                            System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
                            this.sbuf = cArr;
                        }
                        copyTo(this.np + 1, this.sp, this.sbuf);
                    }
                    char next2 = next();
                    switch (next2) {
                        case '\"':
                            putChar('\"');
                            continue;
                        case '\'':
                            putChar('\'');
                            continue;
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
                        case 'F':
                        case 'f':
                            putChar('\f');
                            continue;
                        case '\\':
                            putChar('\\');
                            continue;
                        case 'b':
                            putChar('\b');
                            continue;
                        case 'n':
                            putChar('\n');
                            continue;
                        case 'r':
                            putChar('\r');
                            continue;
                        case 't':
                            putChar('\t');
                            continue;
                        case 'u':
                            putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                            continue;
                        case 'v':
                            putChar((char) 11);
                            continue;
                        case 'x':
                            putChar((char) ((digits[next()] * 16) + digits[next()]));
                            continue;
                        default:
                            this.ch = next2;
                            throw new JSONException("unclosed single-quote string");
                    }
                } else if (!this.hasSpecial) {
                    this.sp++;
                } else if (this.sp == this.sbuf.length) {
                    putChar(next);
                } else {
                    char[] cArr2 = this.sbuf;
                    int i = this.sp;
                    this.sp = i + 1;
                    cArr2[i] = next;
                }
            } else {
                this.token = 4;
                next();
                return;
            }
        }
    }

    protected final void putChar(char c) {
        if (this.sp == this.sbuf.length) {
            char[] cArr = new char[this.sbuf.length * 2];
            System.arraycopy(this.sbuf, 0, cArr, 0, this.sbuf.length);
            this.sbuf = cArr;
        }
        char[] cArr2 = this.sbuf;
        int i = this.sp;
        this.sp = i + 1;
        cArr2[i] = c;
    }

    public final void scanHex() {
        char next;
        if (this.ch != 'x') {
            throw new JSONException("illegal state. " + this.ch);
        }
        next();
        if (this.ch != '\'') {
            throw new JSONException("illegal state. " + this.ch);
        }
        this.np = this.bp;
        next();
        int i = 0;
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            }
            this.sp++;
            i++;
        }
        if (next == '\'') {
            this.sp++;
            next();
            this.token = 26;
            return;
        }
        throw new JSONException("illegal state. " + next);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        this.np = this.bp;
        if (this.ch == '-') {
            this.sp++;
            next();
        }
        while (this.ch >= '0' && this.ch <= '9') {
            this.sp++;
            next();
        }
        boolean z = false;
        if (this.ch == '.') {
            this.sp++;
            next();
            while (this.ch >= '0' && this.ch <= '9') {
                this.sp++;
                next();
            }
            z = true;
        }
        if (this.ch == 'L') {
            this.sp++;
            next();
        } else if (this.ch == 'S') {
            this.sp++;
            next();
        } else if (this.ch == 'B') {
            this.sp++;
            next();
        } else if (this.ch == 'F') {
            this.sp++;
            next();
            z = true;
        } else if (this.ch == 'D') {
            this.sp++;
            next();
            z = true;
        } else if (this.ch == 'e' || this.ch == 'E') {
            this.sp++;
            next();
            if (this.ch == '+' || this.ch == '-') {
                this.sp++;
                next();
            }
            while (this.ch >= '0' && this.ch <= '9') {
                this.sp++;
                next();
            }
            if (this.ch == 'D' || this.ch == 'F') {
                this.sp++;
                next();
            }
            z = true;
        }
        if (z) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r2 <= (r12.np + 1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
        throw new java.lang.NumberFormatException(numberString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
        return -r0;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long longValue() throws NumberFormatException {
        long j;
        boolean z;
        int i;
        int i2;
        long j2 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i3 = this.np;
        int i4 = this.np + this.sp;
        if (charAt(this.np) == '-') {
            j = Long.MIN_VALUE;
            i3++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i3 < i4) {
            i = i3 + 1;
            j2 = -(charAt(i3) - '0');
        } else {
            i = i3;
        }
        while (true) {
            if (i >= i4) {
                i2 = i;
                break;
            }
            i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                break;
            }
            int i5 = charAt - '0';
            if (j2 < MULTMIN_RADIX_TEN) {
                throw new NumberFormatException(numberString());
            }
            long j3 = j2 * 10;
            if (j3 < i5 + j) {
                throw new NumberFormatException(numberString());
            }
            j2 = j3 - i5;
            i = i2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.np + this.sp) - 1);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            } else if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            } else {
                if (z) {
                    return decimalValue();
                }
                return Double.valueOf(doubleValue());
            }
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info());
        }
    }

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    public String[] scanFieldStringArray(char[] cArr, int i, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }
}
