package com.alibaba.fastjson.parser;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INT_MULTMIN_RADIX_TEN = -214748364;
    public static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    public static final ThreadLocal<char[]> SBUF_LOCAL;
    public static final int[] digits;
    public static final char[] typeFieldName;
    public transient /* synthetic */ FieldHolder $fh;
    public int bp;
    public Calendar calendar;
    public char ch;
    public int eofPos;
    public int features;
    public boolean hasSpecial;
    public Locale locale;
    public int matchStat;
    public int nanos;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public TimeZone timeZone;
    public int token;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1693779720, "Lcom/alibaba/fastjson/parser/JSONLexerBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1693779720, "Lcom/alibaba/fastjson/parser/JSONLexerBase;");
                return;
            }
        }
        SBUF_LOCAL = new ThreadLocal<>();
        typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
        digits = new int[103];
        for (int i2 = 48; i2 <= 57; i2++) {
            digits[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            digits[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            digits[i4] = (i4 - 65) + 10;
        }
    }

    public JSONLexerBase(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.calendar = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.matchStat = 0;
        this.stringDefaultValue = null;
        this.nanos = 0;
        this.features = i2;
        if ((i2 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 <= ' ' && (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b') : invokeCommon.booleanValue;
    }

    public static String readString(char[] cArr, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, cArr, i2)) == null) {
            char[] cArr2 = new char[i2];
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                char c2 = cArr[i4];
                if (c2 != '\\') {
                    cArr2[i5] = c2;
                    i5++;
                } else {
                    i4++;
                    char c3 = cArr[i4];
                    if (c3 == '\"') {
                        i3 = i5 + 1;
                        cArr2[i5] = Typography.quote;
                    } else if (c3 != '\'') {
                        if (c3 != 'F') {
                            if (c3 == '\\') {
                                i3 = i5 + 1;
                                cArr2[i5] = '\\';
                            } else if (c3 == 'b') {
                                i3 = i5 + 1;
                                cArr2[i5] = '\b';
                            } else if (c3 != 'f') {
                                if (c3 == 'n') {
                                    i3 = i5 + 1;
                                    cArr2[i5] = '\n';
                                } else if (c3 == 'r') {
                                    i3 = i5 + 1;
                                    cArr2[i5] = '\r';
                                } else if (c3 != 'x') {
                                    switch (c3) {
                                        case '/':
                                            i3 = i5 + 1;
                                            cArr2[i5] = '/';
                                            break;
                                        case '0':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 0;
                                            break;
                                        case '1':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 1;
                                            break;
                                        case '2':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 2;
                                            break;
                                        case '3':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 3;
                                            break;
                                        case '4':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 4;
                                            break;
                                        case '5':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 5;
                                            break;
                                        case '6':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 6;
                                            break;
                                        case '7':
                                            i3 = i5 + 1;
                                            cArr2[i5] = 7;
                                            break;
                                        default:
                                            switch (c3) {
                                                case 't':
                                                    i3 = i5 + 1;
                                                    cArr2[i5] = '\t';
                                                    break;
                                                case 'u':
                                                    i3 = i5 + 1;
                                                    int i6 = i4 + 1;
                                                    int i7 = i6 + 1;
                                                    int i8 = i7 + 1;
                                                    i4 = i8 + 1;
                                                    cArr2[i5] = (char) Integer.parseInt(new String(new char[]{cArr[i6], cArr[i7], cArr[i8], cArr[i4]}), 16);
                                                    break;
                                                case 'v':
                                                    i3 = i5 + 1;
                                                    cArr2[i5] = 11;
                                                    break;
                                                default:
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    i3 = i5 + 1;
                                    int[] iArr = digits;
                                    int i9 = i4 + 1;
                                    i4 = i9 + 1;
                                    cArr2[i5] = (char) ((iArr[cArr[i9]] * 16) + iArr[cArr[i4]]);
                                }
                            }
                        }
                        i3 = i5 + 1;
                        cArr2[i5] = '\f';
                    } else {
                        i3 = i5 + 1;
                        cArr2[i5] = '\'';
                    }
                    i5 = i3;
                }
                i4++;
            }
            return new String(cArr2, 0, i5);
        }
        return (String) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x014e, code lost:
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r1 + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void scanStringSingleQuote() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65540, this) != null) {
            return;
        }
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next != 26) {
                boolean z = true;
                if (next == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        int i2 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i2 > cArr.length) {
                            char[] cArr2 = new char[i2 * 2];
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
                                    char next3 = next();
                                    char next4 = next();
                                    boolean z2 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                    if ((next4 < '0' || next4 > '9') && ((next4 < 'a' || next4 > 'f') && (next4 < 'A' || next4 > 'F'))) {
                                        z = false;
                                    }
                                    if (z2 && z) {
                                        int[] iArr = digits;
                                        putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                                    }
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
                    int i3 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i3 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i3 + 1;
                        cArr3[i3] = next;
                    }
                }
            } else if (!isEOF()) {
                putChar(JSONLexer.EOI);
            } else {
                throw new JSONException("unclosed single-quote string");
            }
        }
    }

    public abstract String addSymbol(int i2, int i3, int i4, SymbolTable symbolTable);

    public abstract void arrayCopy(int i2, char[] cArr, int i3, int i4);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            char[] cArr = this.sbuf;
            if (cArr.length <= 8192) {
                SBUF_LOCAL.set(cArr);
            }
            this.sbuf = null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, feature, z) == null) {
            int config = Feature.config(this.features, feature, z);
            this.features = config;
            if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
                this.stringDefaultValue = "";
            }
        }
    }

    public abstract void copyTo(int i2, int i3, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
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
        return (Number) invokeZ.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Double.parseDouble(numberString()) : invokeV.doubleValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        InterceptResult invokeV;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String numberString = numberString();
            float parseFloat = Float.parseFloat(numberString);
            if ((parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) && (charAt = numberString.charAt(0)) > '0' && charAt <= '9') {
                throw new JSONException("float overflow : " + numberString);
            }
            return parseFloat;
        }
        return invokeV.floatValue;
    }

    public Calendar getCalendar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.calendar : (Calendar) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.ch : invokeV.charValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.features : invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.locale : (Locale) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.timeZone : (TimeZone) invokeV.objValue;
    }

    public abstract int indexOf(char c2, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        InterceptResult invokeV;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i3 = 0;
            if (this.np == -1) {
                this.np = 0;
            }
            int i4 = this.np;
            int i5 = this.sp + i4;
            if (charAt(i4) == '-') {
                i2 = Integer.MIN_VALUE;
                i4++;
                z = true;
            } else {
                i2 = -2147483647;
                z = false;
            }
            if (i4 < i5) {
                i3 = -(charAt(i4) - '0');
                i4++;
            }
            while (i4 < i5) {
                int i6 = i4 + 1;
                char charAt = charAt(i4);
                if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                    i4 = i6;
                    break;
                }
                int i7 = charAt - '0';
                if (i3 < -214748364) {
                    throw new NumberFormatException(numberString());
                }
                int i8 = i3 * 10;
                if (i8 < i2 + i7) {
                    throw new NumberFormatException(numberString());
                }
                i3 = i8 - i7;
                i4 = i6;
            }
            if (z) {
                if (i4 > this.np + 1) {
                    return i3;
                }
                throw new NumberFormatException(numberString());
            }
            return -i3;
        }
        return invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        InterceptResult invokeV;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            boolean z = false;
            if (this.np == -1) {
                this.np = 0;
            }
            int i2 = this.np;
            int i3 = this.sp + i2;
            char c2 = ' ';
            char charAt = charAt(i3 - 1);
            if (charAt == 'B') {
                i3--;
                c2 = 'B';
            } else if (charAt == 'L') {
                i3--;
                c2 = 'L';
            } else if (charAt == 'S') {
                i3--;
                c2 = 'S';
            }
            if (charAt(this.np) == '-') {
                j = Long.MIN_VALUE;
                i2++;
                z = true;
            } else {
                j = -9223372036854775807L;
            }
            long j3 = -922337203685477580L;
            if (i2 < i3) {
                j2 = -(charAt(i2) - '0');
                i2++;
            } else {
                j2 = 0;
            }
            while (i2 < i3) {
                int i4 = i2 + 1;
                int charAt2 = charAt(i2) - '0';
                if (j2 < j3) {
                    return new BigInteger(numberString(), 10);
                }
                long j4 = j2 * 10;
                long j5 = charAt2;
                if (j4 < j + j5) {
                    return new BigInteger(numberString(), 10);
                }
                j2 = j4 - j5;
                i2 = i4;
                j3 = -922337203685477580L;
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
            } else if (i2 > this.np + 1) {
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
        return (Number) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048597, this)) != null) {
            return invokeV.booleanValue;
        }
        int i2 = 0;
        while (true) {
            char charAt = charAt(i2);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i2++;
            }
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, feature)) == null) ? isEnabled(feature.mask) : invokeL.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f' : invokeV.booleanValue;
    }

    public void lexError(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, objArr) == null) {
            this.token = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0060 -> B:14:0x0036). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long longValue() throws NumberFormatException {
        InterceptResult invokeV;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048604, this)) != null) {
            return invokeV.longValue;
        }
        boolean z = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i2 = this.np;
        int i3 = this.sp + i2;
        if (charAt(i2) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        if (i2 < i3) {
            int i4 = i2 + 1;
            j2 = -(charAt(i2) - '0');
            i2 = i4;
            if (i2 < i3) {
                i4 = i2 + 1;
                char charAt = charAt(i2);
                if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                    i2 = i4;
                } else {
                    int i5 = charAt - '0';
                    if (j2 < -922337203685477580L) {
                        throw new NumberFormatException(numberString());
                    }
                    long j3 = j2 * 10;
                    long j4 = i5;
                    if (j3 < j + j4) {
                        throw new NumberFormatException(numberString());
                    }
                    j2 = j3 - j4;
                    i2 = i4;
                    if (i2 < i3) {
                    }
                }
            }
            if (z) {
                return -j2;
            }
            if (i2 > this.np + 1) {
                return j2;
            }
            throw new NumberFormatException(numberString());
        }
        j2 = 0;
        if (i2 < i3) {
        }
        if (z) {
        }
    }

    public final boolean matchField(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, cArr)) == null) {
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
                int i2 = this.bp + 3;
                this.bp = i2;
                this.ch = charAt(i2);
                this.token = 21;
            } else {
                nextToken();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean matchField2(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, cArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    public final int matchStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.matchStat : invokeV.intValue;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, cls)) == null) {
            if (cls.isAssignableFrom(HashSet.class)) {
                return new HashSet();
            }
            if (cls.isAssignableFrom(ArrayList.class)) {
                return new ArrayList();
            }
            if (cls.isAssignableFrom(LinkedList.class)) {
                return new LinkedList();
            }
            try {
                return (Collection) cls.newInstance();
            } catch (Exception e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        }
        return (Collection) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
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
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048612, this) != null) {
            return;
        }
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
                    case '{':
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
                                int i2 = this.bp;
                                this.pos = i2;
                                this.eofPos = i2;
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
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048614, this, new Object[]{Character.valueOf(c2)}) != null) {
            return;
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            nextTokenWithChar(':');
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.pos : invokeV.intValue;
    }

    public final void putChar(char c2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Character.valueOf(c2)}) == null) {
            int i2 = this.sp;
            char[] cArr = this.sbuf;
            if (i2 == cArr.length) {
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.sbuf = cArr2;
            }
            char[] cArr3 = this.sbuf;
            int i3 = this.sp;
            this.sp = i3 + 1;
            cArr3[i3] = c2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.sp = 0;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{Character.valueOf(c2)})) == null) {
            boolean z = false;
            this.matchStat = 0;
            char charAt = charAt(this.bp + 0);
            int i2 = 5;
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
                    i2 = 1;
                }
                i2 = 2;
            } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
                charAt = charAt(this.bp + 5);
                i2 = 6;
            } else {
                this.matchStat = -1;
                return false;
            }
            while (charAt != c2) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i2);
                    i2++;
                } else {
                    this.matchStat = -1;
                    return z;
                }
            }
            int i3 = this.bp + i2;
            this.bp = i3;
            this.ch = charAt(i3);
            this.matchStat = 3;
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public Date scanDate(char c2) {
        InterceptResult invokeCommon;
        long j;
        int i2;
        Date date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Character.valueOf(c2)})) == null) {
            boolean z = false;
            this.matchStat = 0;
            char charAt = charAt(this.bp + 0);
            int i3 = 5;
            if (charAt == '\"') {
                int indexOf = indexOf(Typography.quote, this.bp + 1);
                if (indexOf != -1) {
                    int i4 = this.bp + 1;
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
                        int i8 = indexOf - (i7 + 1);
                        subString = readString(sub_chars(i7 + 1, i8), i8);
                    }
                    int i9 = this.bp;
                    int i10 = (indexOf - (i9 + 1)) + 1 + 1;
                    int i11 = i10 + 1;
                    charAt = charAt(i9 + i10);
                    JSONScanner jSONScanner = new JSONScanner(subString);
                    try {
                        if (jSONScanner.scanISO8601DateIfMatch(false)) {
                            date = jSONScanner.getCalendar().getTime();
                            jSONScanner.close();
                            i3 = i11;
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
                int i12 = 2;
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
                        i12 = 1;
                    }
                    if (charAt >= '0' && charAt <= '9') {
                        j = charAt - '0';
                        while (true) {
                            i2 = i12 + 1;
                            charAt = charAt(this.bp + i12);
                            if (charAt < '0' || charAt > c3) {
                                break;
                            }
                            j = (j * 10) + (charAt - '0');
                            i12 = i2;
                            c3 = '9';
                        }
                    } else {
                        j = 0;
                        i2 = i12;
                    }
                    if (j < 0) {
                        this.matchStat = -1;
                        return null;
                    }
                    if (z) {
                        j = -j;
                    }
                    date = new Date(j);
                    i3 = i2;
                }
            }
            if (charAt == ',') {
                int i13 = this.bp + i3;
                this.bp = i13;
                this.ch = charAt(i13);
                this.matchStat = 3;
                this.token = 16;
                return date;
            } else if (charAt == ']') {
                int i14 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i15 = this.bp + i14;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i16 = this.bp + i14;
                    this.bp = i16;
                    this.ch = charAt(i16);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i17 = this.bp + i14;
                    this.bp = i17;
                    this.ch = charAt(i17);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i14 - 1;
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
        return (Date) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00b3 -> B:52:0x00a1). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal scanDecimal(char c2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        char charAt;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            char charAt2 = charAt(this.bp + 0);
            boolean z = charAt2 == '\"';
            if (z) {
                charAt2 = charAt(this.bp + 1);
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i2);
                i2++;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
                    this.matchStat = 5;
                    int i6 = i2 + 3;
                    int i7 = i6 + 1;
                    char charAt3 = charAt(this.bp + i6);
                    if (z && charAt3 == '\"') {
                        charAt3 = charAt(this.bp + i7);
                        i7++;
                    }
                    while (charAt3 != ',') {
                        if (charAt3 == '}') {
                            int i8 = this.bp + i7;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            this.matchStat = 5;
                            this.token = 13;
                            return null;
                        } else if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    int i9 = this.bp + i7;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 5;
                    this.token = 16;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            while (true) {
                i3 = i2 + 1;
                charAt = charAt(this.bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2 = i3;
            }
            if (charAt == '.') {
                int i10 = i3 + 1;
                char charAt4 = charAt(this.bp + i3);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    while (true) {
                        i3 = i10 + 1;
                        charAt = charAt(this.bp + i10);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i10 = i3;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            if (charAt == 'e' || charAt == 'E') {
                int i11 = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt == '+' || charAt == '-') {
                    charAt = charAt(this.bp + i11);
                    i3 = i11 + 1;
                    if (charAt >= '0' && charAt <= '9') {
                        i11 = i3 + 1;
                        charAt = charAt(this.bp + i3);
                    }
                }
                i3 = i11;
                if (charAt >= '0') {
                    i11 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    i3 = i11;
                    if (charAt >= '0') {
                    }
                }
            }
            if (!z) {
                i4 = this.bp;
                i5 = ((i4 + i3) - i4) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return null;
            } else {
                int i12 = i3 + 1;
                charAt = charAt(this.bp + i3);
                int i13 = this.bp;
                i4 = i13 + 1;
                i5 = ((i13 + i12) - i4) - 2;
                i3 = i12;
            }
            if (i5 <= 65535) {
                char[] sub_chars = sub_chars(i4, i5);
                BigDecimal bigDecimal = new BigDecimal(sub_chars, 0, sub_chars.length, MathContext.UNLIMITED);
                if (charAt == ',') {
                    int i14 = this.bp + i3;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigDecimal;
                } else if (charAt == ']') {
                    int i15 = i3 + 1;
                    char charAt5 = charAt(this.bp + i3);
                    if (charAt5 == ',') {
                        this.token = 16;
                        int i16 = this.bp + i15;
                        this.bp = i16;
                        this.ch = charAt(i16);
                    } else if (charAt5 == ']') {
                        this.token = 15;
                        int i17 = this.bp + i15;
                        this.bp = i17;
                        this.ch = charAt(i17);
                    } else if (charAt5 == '}') {
                        this.token = 13;
                        int i18 = this.bp + i15;
                        this.bp = i18;
                        this.ch = charAt(i18);
                    } else if (charAt5 == 26) {
                        this.token = 20;
                        this.bp += i15 - 1;
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
            }
            throw new JSONException("decimal overflow");
        }
        return (BigDecimal) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00cd -> B:55:0x00bb). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double scanDouble(char c2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        char charAt;
        long j;
        int i4;
        int i5;
        double parseDouble;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            char charAt3 = charAt(this.bp + 0);
            boolean z = charAt3 == '\"';
            if (z) {
                charAt3 = charAt(this.bp + 1);
                i2 = 2;
            } else {
                i2 = 1;
            }
            boolean z2 = charAt3 == '-';
            if (z2) {
                charAt3 = charAt(this.bp + i2);
                i2++;
            }
            if (charAt3 < '0' || charAt3 > '9') {
                if (charAt3 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
                    this.matchStat = 5;
                    int i6 = i2 + 3;
                    int i7 = i6 + 1;
                    char charAt4 = charAt(this.bp + i6);
                    if (z && charAt4 == '\"') {
                        charAt4 = charAt(this.bp + i7);
                        i7++;
                    }
                    while (charAt4 != ',') {
                        if (charAt4 == ']') {
                            int i8 = this.bp + i7;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            this.matchStat = 5;
                            this.token = 15;
                            return 0.0d;
                        } else if (isWhitespace(charAt4)) {
                            charAt4 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return 0.0d;
                        }
                    }
                    int i9 = this.bp + i7;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 5;
                    this.token = 16;
                    return 0.0d;
                }
                this.matchStat = -1;
                return 0.0d;
            }
            long j2 = charAt3 - '0';
            while (true) {
                i3 = i2 + 1;
                charAt = charAt(this.bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + (charAt - '0');
                i2 = i3;
            }
            if (charAt == '.') {
                int i10 = i3 + 1;
                char charAt5 = charAt(this.bp + i3);
                if (charAt5 < '0' || charAt5 > '9') {
                    this.matchStat = -1;
                    return 0.0d;
                }
                j2 = (j2 * 10) + (charAt5 - '0');
                long j3 = 10;
                while (true) {
                    i3 = i10 + 1;
                    charAt2 = charAt(this.bp + i10);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    j2 = (j2 * 10) + (charAt2 - '0');
                    j3 *= 10;
                    i10 = i3;
                }
                j = j3;
                charAt = charAt2;
            } else {
                j = 1;
            }
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i11 = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt == '+' || charAt == '-') {
                    charAt = charAt(this.bp + i11);
                    i3 = i11 + 1;
                    if (charAt >= '0' && charAt <= '9') {
                        i11 = i3 + 1;
                        charAt = charAt(this.bp + i3);
                    }
                }
                i3 = i11;
                if (charAt >= '0') {
                    i11 = i3 + 1;
                    charAt = charAt(this.bp + i3);
                    i3 = i11;
                    if (charAt >= '0') {
                    }
                }
            }
            if (!z) {
                i4 = this.bp;
                i5 = ((i4 + i3) - i4) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return 0.0d;
            } else {
                int i12 = i3 + 1;
                char charAt6 = charAt(this.bp + i3);
                int i13 = this.bp;
                i4 = i13 + 1;
                i5 = ((i13 + i12) - i4) - 2;
                i3 = i12;
                charAt = charAt6;
            }
            if (z3 || i5 >= 17) {
                parseDouble = Double.parseDouble(subString(i4, i5));
            } else {
                parseDouble = j2 / j;
                if (z2) {
                    parseDouble = -parseDouble;
                }
            }
            if (charAt == c2) {
                int i14 = this.bp + i3;
                this.bp = i14;
                this.ch = charAt(i14);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            this.matchStat = -1;
            return parseDouble;
        }
        return invokeCommon.doubleValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{cls, symbolTable, Character.valueOf(c2)})) == null) {
            String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c2);
            if (scanSymbolWithSeperator == null) {
                return null;
            }
            return Enum.valueOf(cls, scanSymbolWithSeperator);
        }
        return (Enum) invokeCommon.objValue;
    }

    public long scanEnumSymbol(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048626, this, cArr)) != null) {
            return invokeL.longValue;
        }
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i3 = i2 + 1;
            char charAt = charAt(this.bp + i2);
            if (charAt == '\"') {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == ',') {
                    int i5 = this.bp + i4;
                    this.bp = i5;
                    this.ch = charAt(i5);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i6 = i4 + 1;
                    char charAt3 = charAt(this.bp + i4);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i7 = this.bp + i6;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i8 = this.bp + i6;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i9 = this.bp + i6;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i6 - 1;
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
            j = (j ^ ((charAt < 'A' || charAt > 'Z') ? charAt : charAt + ' ')) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i2 = i3;
        }
    }

    public final void scanFalse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
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
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        boolean z;
        int length;
        int i3;
        BigInteger bigInteger;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length2 = cArr.length;
            int i4 = length2 + 1;
            char charAt2 = charAt(this.bp + length2);
            boolean z2 = charAt2 == '\"';
            if (z2) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            boolean z3 = charAt2 == '-';
            if (z3) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            if (charAt2 >= '0') {
                char c2 = '9';
                if (charAt2 <= '9') {
                    long j = charAt2 - '0';
                    while (true) {
                        i2 = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > c2) {
                            break;
                        }
                        long j2 = (10 * j) + (charAt - '0');
                        if (j2 < j) {
                            z = true;
                            break;
                        }
                        j = j2;
                        i4 = i2;
                        c2 = '9';
                    }
                    z = false;
                    if (!z2) {
                        int i5 = this.bp;
                        length = cArr.length + i5;
                        i3 = ((i5 + i2) - length) - 1;
                    } else if (charAt != '\"') {
                        this.matchStat = -1;
                        return null;
                    } else {
                        int i6 = i2 + 1;
                        charAt = charAt(this.bp + i2);
                        int i7 = this.bp;
                        length = cArr.length + i7 + 1;
                        i3 = ((i7 + i6) - length) - 2;
                        i2 = i6;
                    }
                    if (!z && (i3 < 20 || (z3 && i3 < 21))) {
                        if (z3) {
                            j = -j;
                        }
                        bigInteger = BigInteger.valueOf(j);
                    } else if (i3 <= 65535) {
                        bigInteger = new BigInteger(subString(length, i3), 10);
                    } else {
                        throw new JSONException("scanInteger overflow");
                    }
                    if (charAt == ',') {
                        int i8 = this.bp + i2;
                        this.bp = i8;
                        this.ch = charAt(i8);
                        this.matchStat = 3;
                        this.token = 16;
                        return bigInteger;
                    } else if (charAt == '}') {
                        int i9 = i2 + 1;
                        char charAt3 = charAt(this.bp + i2);
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
                        return bigInteger;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
            if (charAt2 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                this.matchStat = 5;
                int i13 = i4 + 3;
                int i14 = i13 + 1;
                char charAt4 = charAt(this.bp + i13);
                if (z2 && charAt4 == '\"') {
                    charAt4 = charAt(this.bp + i14);
                    i14++;
                }
                while (charAt4 != ',') {
                    if (charAt4 == '}') {
                        int i15 = this.bp + i14;
                        this.bp = i15;
                        this.ch = charAt(i15);
                        this.matchStat = 5;
                        this.token = 13;
                        return null;
                    } else if (isWhitespace(charAt4)) {
                        charAt4 = charAt(this.bp + i14);
                        i14++;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
                int i16 = this.bp + i14;
                this.bp = i16;
                this.ch = charAt(i16);
                this.matchStat = 5;
                this.token = 16;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        return (BigInteger) invokeL.objValue;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return false;
            }
            int length = cArr.length;
            int i3 = length + 1;
            char charAt = charAt(this.bp + length);
            if (charAt == 't') {
                int i4 = i3 + 1;
                if (charAt(this.bp + i3) != 'r') {
                    this.matchStat = -1;
                    return false;
                }
                int i5 = i4 + 1;
                if (charAt(this.bp + i4) != 'u') {
                    this.matchStat = -1;
                    return false;
                }
                i2 = i5 + 1;
                if (charAt(this.bp + i5) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                z = true;
            } else if (charAt == 'f') {
                int i6 = i3 + 1;
                if (charAt(this.bp + i3) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i7 = i6 + 1;
                if (charAt(this.bp + i6) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i8 = i7 + 1;
                if (charAt(this.bp + i7) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i9 = i8 + 1;
                if (charAt(this.bp + i8) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                i2 = i9;
                z = false;
            } else {
                this.matchStat = -1;
                return false;
            }
            int i10 = i2 + 1;
            char charAt2 = charAt(this.bp + i2);
            if (charAt2 == ',') {
                int i11 = this.bp + i10;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return z;
            } else if (charAt2 == '}') {
                int i12 = i10 + 1;
                char charAt3 = charAt(this.bp + i10);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i13 = this.bp + i12;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i14 = this.bp + i12;
                    this.bp = i14;
                    this.ch = charAt(i14);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i15 = this.bp + i12;
                    this.bp = i15;
                    this.ch = charAt(i15);
                } else if (charAt3 == 26) {
                    this.token = 20;
                    this.bp += i12 - 1;
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
        return invokeL.booleanValue;
    }

    public Date scanFieldDate(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        long j;
        Date date;
        int i3;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, cArr)) == null) {
            boolean z = false;
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = cArr.length;
            int i4 = length + 1;
            char charAt2 = charAt(this.bp + length);
            if (charAt2 == '\"') {
                int indexOf = indexOf(Typography.quote, this.bp + cArr.length + 1);
                if (indexOf != -1) {
                    int length2 = this.bp + cArr.length + 1;
                    String subString = subString(length2, indexOf - length2);
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
                        int length3 = indexOf - ((cArr.length + i7) + 1);
                        subString = readString(sub_chars(i7 + cArr.length + 1, length3), length3);
                    }
                    int i8 = this.bp;
                    int length4 = i4 + (indexOf - ((cArr.length + i8) + 1)) + 1;
                    i2 = length4 + 1;
                    charAt2 = charAt(i8 + length4);
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
                    charAt2 = charAt(this.bp + i4);
                    i4++;
                    z = true;
                }
                if (charAt2 < '0' || charAt2 > '9') {
                    i2 = i4;
                    j = 0;
                } else {
                    j = charAt2 - '0';
                    while (true) {
                        i3 = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j = (j * 10) + (charAt - '0');
                        i4 = i3;
                    }
                    charAt2 = charAt;
                    i2 = i3;
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
                int i9 = this.bp + i2;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                return date;
            } else if (charAt2 == '}') {
                int i10 = i2 + 1;
                char charAt3 = charAt(this.bp + i2);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i12 = this.bp + i10;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i13 = this.bp + i10;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt3 == 26) {
                    this.token = 20;
                    this.bp += i10 - 1;
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
        return (Date) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00be -> B:54:0x00ac). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal scanFieldDecimal(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        int length;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length2 = cArr.length;
            int i4 = length2 + 1;
            char charAt2 = charAt(this.bp + length2);
            boolean z = charAt2 == '\"';
            if (z) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                    this.matchStat = 5;
                    int i5 = i4 + 3;
                    int i6 = i5 + 1;
                    char charAt3 = charAt(this.bp + i5);
                    if (z && charAt3 == '\"') {
                        charAt3 = charAt(this.bp + i6);
                        i6++;
                    }
                    while (charAt3 != ',') {
                        if (charAt3 == '}') {
                            int i7 = this.bp + i6;
                            this.bp = i7;
                            this.ch = charAt(i7);
                            this.matchStat = 5;
                            this.token = 13;
                            return null;
                        } else if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i6);
                            i6++;
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                    int i8 = this.bp + i6;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 5;
                    this.token = 16;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            while (true) {
                i2 = i4 + 1;
                charAt = charAt(this.bp + i4);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i4 = i2;
            }
            if (charAt == '.') {
                int i9 = i2 + 1;
                char charAt4 = charAt(this.bp + i2);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    while (true) {
                        i2 = i9 + 1;
                        charAt = charAt(this.bp + i9);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i9 = i2;
                    }
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            if (charAt == 'e' || charAt == 'E') {
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
                int i11 = this.bp;
                length = cArr.length + i11;
                i3 = ((i11 + i2) - length) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return null;
            } else {
                int i12 = i2 + 1;
                charAt = charAt(this.bp + i2);
                int i13 = this.bp;
                length = cArr.length + i13 + 1;
                i3 = ((i13 + i12) - length) - 2;
                i2 = i12;
            }
            if (i3 <= 65535) {
                char[] sub_chars = sub_chars(length, i3);
                BigDecimal bigDecimal = new BigDecimal(sub_chars, 0, sub_chars.length, MathContext.UNLIMITED);
                if (charAt == ',') {
                    int i14 = this.bp + i2;
                    this.bp = i14;
                    this.ch = charAt(i14);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigDecimal;
                } else if (charAt == '}') {
                    int i15 = i2 + 1;
                    char charAt5 = charAt(this.bp + i2);
                    if (charAt5 == ',') {
                        this.token = 16;
                        int i16 = this.bp + i15;
                        this.bp = i16;
                        this.ch = charAt(i16);
                    } else if (charAt5 == ']') {
                        this.token = 15;
                        int i17 = this.bp + i15;
                        this.bp = i17;
                        this.ch = charAt(i17);
                    } else if (charAt5 == '}') {
                        this.token = 13;
                        int i18 = this.bp + i15;
                        this.bp = i18;
                        this.ch = charAt(i18);
                    } else if (charAt5 == 26) {
                        this.token = 20;
                        this.bp += i15 - 1;
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
            }
            throw new JSONException("scan decimal overflow");
        }
        return (BigDecimal) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00e2 -> B:57:0x00ce). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double scanFieldDouble(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        boolean z;
        int length;
        int i3;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return 0.0d;
            }
            int length2 = cArr.length;
            int i4 = length2 + 1;
            char charAt2 = charAt(this.bp + length2);
            boolean z2 = charAt2 == '\"';
            if (z2) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            boolean z3 = charAt2 == '-';
            if (z3) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                boolean z4 = z2;
                if (charAt2 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                    this.matchStat = 5;
                    int i5 = i4 + 3;
                    int i6 = i5 + 1;
                    char charAt3 = charAt(this.bp + i5);
                    if (z4 && charAt3 == '\"') {
                        charAt3 = charAt(this.bp + i6);
                        i6++;
                    }
                    while (charAt3 != ',') {
                        if (charAt3 == '}') {
                            int i7 = this.bp + i6;
                            this.bp = i7;
                            this.ch = charAt(i7);
                            this.matchStat = 5;
                            this.token = 13;
                            return 0.0d;
                        } else if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i6);
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
            long j = charAt2 - '0';
            while (true) {
                i2 = i4 + 1;
                charAt = charAt(this.bp + i4);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i4 = i2;
            }
            long j2 = 1;
            if (charAt == '.') {
                int i9 = i2 + 1;
                char charAt4 = charAt(this.bp + i2);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    z = z2;
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
                    return 0.0d;
                }
            } else {
                z = z2;
            }
            long j3 = j2;
            boolean z5 = charAt == 'e' || charAt == 'E';
            if (z5) {
                int i10 = i2 + 1;
                char charAt5 = charAt(this.bp + i2);
                if (charAt5 == '+' || charAt5 == '-') {
                    int i11 = i10 + 1;
                    charAt = charAt(this.bp + i10);
                    i2 = i11;
                    if (charAt >= '0' && charAt <= '9') {
                        i10 = i2 + 1;
                        charAt5 = charAt(this.bp + i2);
                    }
                }
                i2 = i10;
                charAt = charAt5;
                if (charAt >= '0') {
                    i10 = i2 + 1;
                    charAt5 = charAt(this.bp + i2);
                    i2 = i10;
                    charAt = charAt5;
                    if (charAt >= '0') {
                    }
                }
            }
            if (!z) {
                int i12 = this.bp;
                length = cArr.length + i12;
                i3 = ((i12 + i2) - length) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return 0.0d;
            } else {
                int i13 = i2 + 1;
                char charAt6 = charAt(this.bp + i2);
                int i14 = this.bp;
                length = cArr.length + i14 + 1;
                i3 = ((i14 + i13) - length) - 2;
                i2 = i13;
                charAt = charAt6;
            }
            if (z5 || i3 >= 17) {
                parseDouble = Double.parseDouble(subString(length, i3));
            } else {
                parseDouble = j / j3;
                if (z3) {
                    parseDouble = -parseDouble;
                }
            }
            if (charAt == ',') {
                int i15 = this.bp + i2;
                this.bp = i15;
                this.ch = charAt(i15);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            } else if (charAt == '}') {
                int i16 = i2 + 1;
                char charAt7 = charAt(this.bp + i2);
                if (charAt7 == ',') {
                    this.token = 16;
                    int i17 = this.bp + i16;
                    this.bp = i17;
                    this.ch = charAt(i17);
                } else if (charAt7 == ']') {
                    this.token = 15;
                    int i18 = this.bp + i16;
                    this.bp = i18;
                    this.ch = charAt(i18);
                } else if (charAt7 == '}') {
                    this.token = 13;
                    int i19 = this.bp + i16;
                    this.bp = i19;
                    this.ch = charAt(i19);
                } else if (charAt7 == 26) {
                    this.token = 20;
                    this.bp += i16 - 1;
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
        return invokeL.doubleValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00dd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00d9 -> B:60:0x00db). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float scanFieldFloat(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        boolean z;
        long j;
        int length;
        int i3;
        float parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return 0.0f;
            }
            int length2 = cArr.length;
            int i4 = length2 + 1;
            char charAt2 = charAt(this.bp + length2);
            boolean z2 = charAt2 == '\"';
            if (z2) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            boolean z3 = charAt2 == '-';
            if (z3) {
                charAt2 = charAt(this.bp + i4);
                i4++;
            }
            if (charAt2 >= '0') {
                char c2 = '9';
                if (charAt2 <= '9') {
                    long j2 = charAt2 - '0';
                    while (true) {
                        i2 = i4 + 1;
                        charAt = charAt(this.bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j2 = (j2 * 10) + (charAt - '0');
                        i4 = i2;
                    }
                    if (charAt == '.') {
                        int i5 = i2 + 1;
                        char charAt3 = charAt(this.bp + i2);
                        if (charAt3 >= '0' && charAt3 <= '9') {
                            z = z2;
                            j2 = (j2 * 10) + (charAt3 - '0');
                            j = 10;
                            while (true) {
                                i2 = i5 + 1;
                                charAt = charAt(this.bp + i5);
                                if (charAt < '0' || charAt > c2) {
                                    break;
                                }
                                j2 = (j2 * 10) + (charAt - '0');
                                j *= 10;
                                i5 = i2;
                                c2 = '9';
                            }
                        } else {
                            this.matchStat = -1;
                            return 0.0f;
                        }
                    } else {
                        z = z2;
                        j = 1;
                    }
                    boolean z4 = charAt == 'e' || charAt == 'E';
                    if (z4) {
                        int i6 = i2 + 1;
                        charAt = charAt(this.bp + i2);
                        if (charAt == '+' || charAt == '-') {
                            int i7 = i6 + 1;
                            charAt = charAt(this.bp + i6);
                            i2 = i7;
                            if (charAt >= '0' && charAt <= '9') {
                                i7 = i2 + 1;
                                charAt = charAt(this.bp + i2);
                                i2 = i7;
                                if (charAt >= '0') {
                                    i7 = i2 + 1;
                                    charAt = charAt(this.bp + i2);
                                    i2 = i7;
                                    if (charAt >= '0') {
                                    }
                                }
                            }
                        } else {
                            i2 = i6;
                            if (charAt >= '0') {
                            }
                        }
                    }
                    if (!z) {
                        int i8 = this.bp;
                        length = cArr.length + i8;
                        i3 = ((i8 + i2) - length) - 1;
                    } else if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0.0f;
                    } else {
                        int i9 = i2 + 1;
                        charAt = charAt(this.bp + i2);
                        int i10 = this.bp;
                        length = cArr.length + i10 + 1;
                        i3 = ((i10 + i9) - length) - 2;
                        i2 = i9;
                    }
                    if (z4 || i3 >= 17) {
                        parseFloat = Float.parseFloat(subString(length, i3));
                    } else {
                        parseFloat = (float) (j2 / j);
                        if (z3) {
                            parseFloat = -parseFloat;
                        }
                    }
                    if (charAt == ',') {
                        int i11 = this.bp + i2;
                        this.bp = i11;
                        this.ch = charAt(i11);
                        this.matchStat = 3;
                        this.token = 16;
                        return parseFloat;
                    } else if (charAt == '}') {
                        int i12 = i2 + 1;
                        char charAt4 = charAt(this.bp + i2);
                        if (charAt4 == ',') {
                            this.token = 16;
                            int i13 = this.bp + i12;
                            this.bp = i13;
                            this.ch = charAt(i13);
                        } else if (charAt4 == ']') {
                            this.token = 15;
                            int i14 = this.bp + i12;
                            this.bp = i14;
                            this.ch = charAt(i14);
                        } else if (charAt4 == '}') {
                            this.token = 13;
                            int i15 = this.bp + i12;
                            this.bp = i15;
                            this.ch = charAt(i15);
                        } else if (charAt4 == 26) {
                            this.bp += i12 - 1;
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
            }
            boolean z5 = z2;
            if (charAt2 == 'n' && charAt(this.bp + i4) == 'u' && charAt(this.bp + i4 + 1) == 'l' && charAt(this.bp + i4 + 2) == 'l') {
                this.matchStat = 5;
                int i16 = i4 + 3;
                int i17 = i16 + 1;
                char charAt5 = charAt(this.bp + i16);
                if (z5 && charAt5 == '\"') {
                    charAt5 = charAt(this.bp + i17);
                    i17++;
                }
                while (charAt5 != ',') {
                    if (charAt5 == '}') {
                        int i18 = this.bp + i17;
                        this.bp = i18;
                        this.ch = charAt(i18);
                        this.matchStat = 5;
                        this.token = 13;
                        return 0.0f;
                    } else if (isWhitespace(charAt5)) {
                        charAt5 = charAt(this.bp + i17);
                        i17++;
                    } else {
                        this.matchStat = -1;
                        return 0.0f;
                    }
                }
                int i19 = this.bp + i17;
                this.bp = i19;
                this.ch = charAt(i19);
                this.matchStat = 5;
                this.token = 16;
                return 0.0f;
            }
            this.matchStat = -1;
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00de A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00da -> B:61:0x00dc). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[] scanFieldFloatArray(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        int i3;
        float parseFloat;
        float[] fArr;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, cArr)) == null) {
            this.matchStat = 0;
            float[] fArr2 = null;
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
            float[] fArr3 = new float[16];
            int i6 = 0;
            while (true) {
                int i7 = (this.bp + i5) - 1;
                boolean z = charAt3 == '-';
                if (z) {
                    charAt3 = charAt(this.bp + i5);
                    i5++;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i8 = charAt3 - '0';
                while (true) {
                    i2 = i5 + 1;
                    charAt = charAt(this.bp + i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i8 = (i8 * 10) + (charAt - '0');
                    i5 = i2;
                }
                if (charAt == '.') {
                    int i9 = i2 + 1;
                    char charAt4 = charAt(this.bp + i2);
                    if (charAt4 < '0' || charAt4 > '9') {
                        break;
                    }
                    i8 = (i8 * 10) + (charAt4 - '0');
                    int i10 = 10;
                    while (true) {
                        i2 = i9 + 1;
                        charAt2 = charAt(this.bp + i9);
                        if (charAt2 < '0' || charAt2 > '9') {
                            break;
                        }
                        i8 = (i8 * 10) + (charAt2 - '0');
                        i10 *= 10;
                        i9 = i2;
                    }
                    int i11 = i10;
                    charAt = charAt2;
                    i3 = i11;
                } else {
                    i3 = 1;
                }
                boolean z2 = charAt == 'e' || charAt == 'E';
                if (z2) {
                    int i12 = i2 + 1;
                    charAt = charAt(this.bp + i2);
                    if (charAt == '+' || charAt == '-') {
                        int i13 = i12 + 1;
                        charAt = charAt(this.bp + i12);
                        i2 = i13;
                        if (charAt >= '0' && charAt <= '9') {
                            i13 = i2 + 1;
                            charAt = charAt(this.bp + i2);
                            i2 = i13;
                            if (charAt >= '0') {
                                i13 = i2 + 1;
                                charAt = charAt(this.bp + i2);
                                i2 = i13;
                                if (charAt >= '0') {
                                }
                            }
                        }
                    } else {
                        i2 = i12;
                        if (charAt >= '0') {
                        }
                    }
                }
                int i14 = ((this.bp + i2) - i7) - 1;
                if (z2 || i14 >= 10) {
                    parseFloat = Float.parseFloat(subString(i7, i14));
                } else {
                    parseFloat = i8 / i3;
                    if (z) {
                        parseFloat = -parseFloat;
                    }
                }
                if (i6 >= fArr3.length) {
                    float[] fArr4 = new float[(fArr3.length * 3) / 2];
                    System.arraycopy(fArr3, 0, fArr4, 0, i6);
                    fArr3 = fArr4;
                }
                int i15 = i6 + 1;
                fArr3[i6] = parseFloat;
                if (charAt == ',') {
                    i5 = i2 + 1;
                    charAt3 = charAt(this.bp + i2);
                    fArr = null;
                } else if (charAt == ']') {
                    int i16 = i2 + 1;
                    char charAt5 = charAt(this.bp + i2);
                    if (i15 != fArr3.length) {
                        float[] fArr5 = new float[i15];
                        System.arraycopy(fArr3, 0, fArr5, 0, i15);
                        fArr3 = fArr5;
                    }
                    if (charAt5 == ',') {
                        this.bp += i16 - 1;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                        return fArr3;
                    } else if (charAt5 == '}') {
                        int i17 = i16 + 1;
                        char charAt6 = charAt(this.bp + i16);
                        if (charAt6 == ',') {
                            this.token = 16;
                            this.bp += i17 - 1;
                            next();
                        } else if (charAt6 == ']') {
                            this.token = 15;
                            this.bp += i17 - 1;
                            next();
                        } else if (charAt6 == '}') {
                            this.token = 13;
                            this.bp += i17 - 1;
                            next();
                        } else if (charAt6 == 26) {
                            this.bp += i17 - 1;
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
                    i5 = i2;
                }
                fArr2 = fArr;
                i6 = i15;
            }
            float[] fArr6 = fArr2;
            this.matchStat = -1;
            return fArr6;
        }
        return (float[]) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b5, code lost:
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x013a, code lost:
        r4 = r18 + 1;
        r1 = charAt(r21.bp + r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0145, code lost:
        if (r2 == r3.length) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0147, code lost:
        r5 = new float[r2];
        r6 = 0;
        java.lang.System.arraycopy(r3, 0, r5, 0, r2);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014f, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0151, code lost:
        if (r8 < r7.length) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0153, code lost:
        r5 = new float[(r7.length * 3) / 2];
        java.lang.System.arraycopy(r3, r6, r5, r6, r2);
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015f, code lost:
        r5 = r8 + 1;
        r7[r8] = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0165, code lost:
        if (r1 != ',') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0167, code lost:
        r3 = r4 + 1;
        r2 = charAt(r21.bp + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0175, code lost:
        if (r1 != ']') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0177, code lost:
        r3 = r4 + 1;
        r2 = charAt(r21.bp + r4);
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0182, code lost:
        r2 = r1;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0197, code lost:
        r21.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019a, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00e6 -> B:60:0x00e8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float[][] scanFieldFloatArray2(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        int i3;
        int i4;
        float parseFloat;
        int i5;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, cArr)) == null) {
            this.matchStat = 0;
            float[][] fArr = null;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = cArr.length;
            int i6 = length + 1;
            char c2 = '[';
            if (charAt(this.bp + length) != '[') {
                this.matchStat = -2;
                return null;
            }
            int i7 = i6 + 1;
            char charAt3 = charAt(this.bp + i6);
            int i8 = 16;
            float[][] fArr2 = new float[16];
            int i9 = 0;
            loop0: while (true) {
                if (charAt3 != c2) {
                    break;
                }
                int i10 = i7 + 1;
                char charAt4 = charAt(this.bp + i7);
                float[] fArr3 = new float[i8];
                int i11 = 0;
                while (true) {
                    int i12 = (this.bp + i10) - 1;
                    boolean z = charAt4 == '-';
                    if (z) {
                        charAt4 = charAt(this.bp + i10);
                        i10++;
                    }
                    if (charAt4 < '0' || charAt4 > '9') {
                        break loop0;
                    }
                    int i13 = charAt4 - '0';
                    while (true) {
                        i2 = i10 + 1;
                        charAt = charAt(this.bp + i10);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i13 = (i13 * 10) + (charAt - '0');
                        i10 = i2;
                    }
                    if (charAt == '.') {
                        int i14 = i2 + 1;
                        char charAt5 = charAt(this.bp + i2);
                        if (charAt5 < '0' || charAt5 > '9') {
                            break loop0;
                        }
                        int i15 = (i13 * 10) + (charAt5 - '0');
                        int i16 = 10;
                        while (true) {
                            i2 = i14 + 1;
                            charAt2 = charAt(this.bp + i14);
                            if (charAt2 < '0' || charAt2 > '9') {
                                break;
                            }
                            i15 = (i15 * 10) + (charAt2 - '0');
                            i16 *= 10;
                            i14 = i2;
                        }
                        int i17 = i15;
                        i4 = i16;
                        charAt = charAt2;
                        i3 = i17;
                    } else {
                        i3 = i13;
                        i4 = 1;
                    }
                    boolean z2 = charAt == 'e' || charAt == 'E';
                    if (z2) {
                        int i18 = i2 + 1;
                        charAt = charAt(this.bp + i2);
                        if (charAt == '+' || charAt == '-') {
                            int i19 = i18 + 1;
                            charAt = charAt(this.bp + i18);
                            i2 = i19;
                            if (charAt >= '0' && charAt <= '9') {
                                i19 = i2 + 1;
                                charAt = charAt(this.bp + i2);
                                i2 = i19;
                                if (charAt >= '0') {
                                    i19 = i2 + 1;
                                    charAt = charAt(this.bp + i2);
                                    i2 = i19;
                                    if (charAt >= '0') {
                                    }
                                }
                            }
                        } else {
                            i2 = i18;
                            if (charAt >= '0') {
                            }
                        }
                    }
                    int i20 = ((this.bp + i2) - i12) - 1;
                    if (z2 || i20 >= 10) {
                        parseFloat = Float.parseFloat(subString(i12, i20));
                    } else {
                        parseFloat = i3 / i4;
                        if (z) {
                            parseFloat = -parseFloat;
                        }
                    }
                    if (i11 >= fArr3.length) {
                        float[] fArr4 = new float[(fArr3.length * 3) / 2];
                        System.arraycopy(fArr3, 0, fArr4, 0, i11);
                        fArr3 = fArr4;
                    }
                    int i21 = i11 + 1;
                    fArr3[i11] = parseFloat;
                    if (charAt == ',') {
                        charAt = charAt(this.bp + i2);
                        i10 = i2 + 1;
                    } else if (charAt == ']') {
                        break;
                    } else {
                        i10 = i2;
                    }
                    i11 = i21;
                    fArr = null;
                    charAt4 = charAt;
                }
                i9 = i5;
                fArr = null;
                c2 = '[';
                i8 = 16;
            }
            if (i9 != fArr2.length) {
                float[][] fArr5 = new float[i9];
                System.arraycopy(fArr2, 0, fArr5, 0, i9);
                fArr2 = fArr5;
            }
            if (charAt3 == ',') {
                this.bp += i7 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return fArr2;
            } else if (charAt3 == '}') {
                int i22 = i7 + 1;
                char charAt6 = charAt(this.bp + i7);
                if (charAt6 == ',') {
                    this.token = 16;
                    this.bp += i22 - 1;
                    next();
                } else if (charAt6 == ']') {
                    this.token = 15;
                    this.bp += i22 - 1;
                    next();
                } else if (charAt6 == '}') {
                    this.token = 13;
                    this.bp += i22 - 1;
                    next();
                } else if (charAt6 == 26) {
                    this.bp += i22 - 1;
                    this.token = 20;
                    this.ch = JSONLexer.EOI;
                } else {
                    this.matchStat = -1;
                    return null;
                }
                this.matchStat = 4;
                return fArr2;
            } else {
                this.matchStat = -1;
                return null;
            }
        }
        return (float[][]) invokeL.objValue;
    }

    public int scanFieldInt(char[] cArr) {
        InterceptResult invokeL;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return 0;
            }
            int length = cArr.length;
            int i3 = length + 1;
            char charAt2 = charAt(this.bp + length);
            boolean z = charAt2 == '-';
            if (z) {
                charAt2 = charAt(this.bp + i3);
                i3++;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                this.matchStat = -1;
                return 0;
            }
            int i4 = charAt2 - '0';
            while (true) {
                i2 = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i4 = (i4 * 10) + (charAt - '0');
                i3 = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0;
            } else if ((i4 < 0 || i2 > cArr.length + 14) && !(i4 == Integer.MIN_VALUE && i2 == 17 && z)) {
                this.matchStat = -1;
                return 0;
            } else if (charAt == ',') {
                int i5 = this.bp + i2;
                this.bp = i5;
                this.ch = charAt(i5);
                this.matchStat = 3;
                this.token = 16;
                return z ? -i4 : i4;
            } else if (charAt == '}') {
                int i6 = i2 + 1;
                char charAt3 = charAt(this.bp + i2);
                if (charAt3 == ',') {
                    this.token = 16;
                    int i7 = this.bp + i6;
                    this.bp = i7;
                    this.ch = charAt(i7);
                } else if (charAt3 == ']') {
                    this.token = 15;
                    int i8 = this.bp + i6;
                    this.bp = i8;
                    this.ch = charAt(i8);
                } else if (charAt3 == '}') {
                    this.token = 13;
                    int i9 = this.bp + i6;
                    this.bp = i9;
                    this.ch = charAt(i9);
                } else if (charAt3 == 26) {
                    this.token = 20;
                    this.bp += i6 - 1;
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
        return invokeL.intValue;
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        InterceptResult invokeL;
        boolean z;
        int i2;
        char charAt;
        int i3;
        int i4;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, cArr)) == null) {
            this.matchStat = 0;
            int[] iArr = null;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = cArr.length;
            int i5 = length + 1;
            if (charAt(this.bp + length) != '[') {
                this.matchStat = -2;
                return null;
            }
            int i6 = i5 + 1;
            char charAt3 = charAt(this.bp + i5);
            int[] iArr2 = new int[16];
            if (charAt3 == ']') {
                i4 = i6 + 1;
                charAt2 = charAt(this.bp + i6);
                i3 = 0;
            } else {
                int i7 = 0;
                while (true) {
                    if (charAt3 == '-') {
                        charAt3 = charAt(this.bp + i6);
                        i6++;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (charAt3 < '0' || charAt3 > '9') {
                        break;
                    }
                    int i8 = charAt3 - '0';
                    while (true) {
                        i2 = i6 + 1;
                        charAt = charAt(this.bp + i6);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i8 = (i8 * 10) + (charAt - '0');
                        i6 = i2;
                    }
                    if (i7 >= iArr2.length) {
                        int[] iArr3 = new int[(iArr2.length * 3) / 2];
                        System.arraycopy(iArr2, 0, iArr3, 0, i7);
                        iArr2 = iArr3;
                    }
                    i3 = i7 + 1;
                    if (z) {
                        i8 = -i8;
                    }
                    iArr2[i7] = i8;
                    if (charAt == ',') {
                        i2++;
                        charAt = charAt(this.bp + i2);
                    } else if (charAt == ']') {
                        i4 = i2 + 1;
                        charAt2 = charAt(this.bp + i2);
                        break;
                    }
                    i7 = i3;
                    iArr = null;
                    charAt3 = charAt;
                    i6 = i2;
                }
                int[] iArr4 = iArr;
                this.matchStat = -1;
                return iArr4;
            }
            if (i3 != iArr2.length) {
                int[] iArr5 = new int[i3];
                System.arraycopy(iArr2, 0, iArr5, 0, i3);
                iArr2 = iArr5;
            }
            if (charAt2 == ',') {
                this.bp += i4 - 1;
                next();
                this.matchStat = 3;
                this.token = 16;
                return iArr2;
            } else if (charAt2 == '}') {
                int i9 = i4 + 1;
                char charAt4 = charAt(this.bp + i4);
                if (charAt4 == ',') {
                    this.token = 16;
                    this.bp += i9 - 1;
                    next();
                } else if (charAt4 == ']') {
                    this.token = 15;
                    this.bp += i9 - 1;
                    next();
                } else if (charAt4 == '}') {
                    this.token = 13;
                    this.bp += i9 - 1;
                    next();
                } else if (charAt4 == 26) {
                    this.bp += i9 - 1;
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
        return (int[]) invokeL.objValue;
    }

    public long scanFieldLong(char[] cArr) {
        InterceptResult invokeL;
        boolean z;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return 0L;
            }
            int length = cArr.length;
            int i3 = length + 1;
            char charAt2 = charAt(this.bp + length);
            if (charAt2 == '-') {
                charAt2 = charAt(this.bp + i3);
                i3++;
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
                i2 = i3 + 1;
                charAt = charAt(this.bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i3 = i2;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (!(i2 - cArr.length < 21 && (j >= 0 || (j == Long.MIN_VALUE && z)))) {
                this.matchStat = -1;
                return 0L;
            } else if (charAt == ',') {
                int i4 = this.bp + i2;
                this.bp = i4;
                this.ch = charAt(i4);
                this.matchStat = 3;
                this.token = 16;
                return z ? -j : j;
            } else if (charAt == '}') {
                int i5 = i2 + 1;
                char charAt3 = charAt(this.bp + i2);
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
                return z ? -j : j;
            } else {
                this.matchStat = -1;
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public String scanFieldString(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return stringDefaultValue();
            }
            int length = cArr.length;
            int i2 = length + 1;
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
                    int length3 = indexOf - ((cArr.length + i5) + 1);
                    subString = readString(sub_chars(i5 + cArr.length + 1, length3), length3);
                }
                int i6 = this.bp;
                int length4 = i2 + (indexOf - ((cArr.length + i6) + 1)) + 1;
                int i7 = length4 + 1;
                char charAt = charAt(i6 + length4);
                if (charAt == ',') {
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.ch = charAt(i8);
                    this.matchStat = 3;
                    return subString;
                } else if (charAt == '}') {
                    int i9 = i7 + 1;
                    char charAt2 = charAt(this.bp + i7);
                    if (charAt2 == ',') {
                        this.token = 16;
                        int i10 = this.bp + i9;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt2 == ']') {
                        this.token = 15;
                        int i11 = this.bp + i9;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt2 == '}') {
                        this.token = 13;
                        int i12 = this.bp + i9;
                        this.bp = i12;
                        this.ch = charAt(i12);
                    } else if (charAt2 == 26) {
                        this.token = 20;
                        this.bp += i9 - 1;
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
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f2, code lost:
        if (r13.size() != 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f4, code lost:
        r12 = charAt(r11.bp + r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fe, code lost:
        if (r12 != ',') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0100, code lost:
        r12 = r11.bp + r1;
        r11.bp = r12;
        r11.ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010e, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0111, code lost:
        if (r12 != '}') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0113, code lost:
        r6 = r1 + 1;
        r12 = charAt(r11.bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011c, code lost:
        if (r12 != ',') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011e, code lost:
        r11.token = 16;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012e, code lost:
        if (r12 != ']') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0130, code lost:
        r11.token = 15;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
        if (r12 != '}') goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0142, code lost:
        r11.token = 13;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0154, code lost:
        if (r12 != 26) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0156, code lost:
        r11.bp += r6 - 1;
        r11.token = 20;
        r11.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0166, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0167, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0169, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016a, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016c, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        InterceptResult invokeLL;
        char charAt;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048640, this, cArr, cls)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            Collection<String> newCollectionByType = newCollectionByType(cls);
            int length = cArr.length;
            int i3 = length + 1;
            if (charAt(this.bp + length) != '[') {
                this.matchStat = -1;
                return null;
            }
            int i4 = i3 + 1;
            char charAt2 = charAt(this.bp + i3);
            while (true) {
                if (charAt2 == '\"') {
                    int indexOf = indexOf(Typography.quote, this.bp + i4);
                    if (indexOf != -1) {
                        int i5 = this.bp + i4;
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
                                indexOf = indexOf(Typography.quote, indexOf + 1);
                            }
                            int i8 = this.bp;
                            int i9 = indexOf - (i8 + i4);
                            subString = readString(sub_chars(i8 + i4, i9), i9);
                        }
                        int i10 = this.bp;
                        int i11 = i4 + (indexOf - (i10 + i4)) + 1;
                        i2 = i11 + 1;
                        charAt = charAt(i10 + i11);
                        newCollectionByType.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                } else if (charAt2 != 'n' || charAt(this.bp + i4) != 'u' || charAt(this.bp + i4 + 1) != 'l' || charAt(this.bp + i4 + 2) != 'l') {
                    break;
                } else {
                    int i12 = i4 + 3;
                    int i13 = i12 + 1;
                    charAt = charAt(this.bp + i12);
                    newCollectionByType.add(null);
                    i2 = i13;
                }
                if (charAt == ',') {
                    int i14 = i2 + 1;
                    charAt2 = charAt(this.bp + i2);
                    i4 = i14;
                } else if (charAt == ']') {
                    int i15 = i2 + 1;
                    char charAt3 = charAt(this.bp + i2);
                } else {
                    this.matchStat = -1;
                    return null;
                }
            }
            throw new JSONException("illega str");
        }
        return (Collection) invokeLL.objValue;
    }

    public long scanFieldSymbol(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048642, this, cArr)) != null) {
            return invokeL.longValue;
        }
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -3750763034362895579L;
        while (true) {
            int i3 = i2 + 1;
            char charAt = charAt(this.bp + i2);
            if (charAt == '\"') {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.bp + i3);
                if (charAt2 == ',') {
                    int i5 = this.bp + i4;
                    this.bp = i5;
                    this.ch = charAt(i5);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i6 = i4 + 1;
                    char charAt3 = charAt(this.bp + i4);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i7 = this.bp + i6;
                        this.bp = i7;
                        this.ch = charAt(i7);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i8 = this.bp + i6;
                        this.bp = i8;
                        this.ch = charAt(i8);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i9 = this.bp + i6;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i6 - 1;
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
            i2 = i3;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        InterceptResult invokeL;
        char charAt;
        int i2;
        UUID uuid;
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
        int i15;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, cArr)) == null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = cArr.length;
            int i16 = length + 1;
            char charAt2 = charAt(this.bp + length);
            char c2 = 4;
            if (charAt2 == '\"') {
                int indexOf = indexOf(Typography.quote, this.bp + cArr.length + 1);
                if (indexOf != -1) {
                    int length2 = this.bp + cArr.length + 1;
                    int i17 = indexOf - length2;
                    char c3 = 'F';
                    char c4 = 'f';
                    char c5 = 'A';
                    char c6 = '0';
                    if (i17 == 36) {
                        int i18 = 0;
                        long j = 0;
                        while (i18 < 8) {
                            char charAt3 = charAt(length2 + i18);
                            if (charAt3 < '0' || charAt3 > '9') {
                                if (charAt3 >= 'a' && charAt3 <= 'f') {
                                    i14 = charAt3 - 'a';
                                } else if (charAt3 < 'A' || charAt3 > c3) {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i14 = charAt3 - 'A';
                                }
                                i15 = i14 + 10;
                            } else {
                                i15 = charAt3 - '0';
                            }
                            j = (j << 4) | i15;
                            i18++;
                            indexOf = indexOf;
                            c3 = 'F';
                        }
                        int i19 = indexOf;
                        int i20 = 9;
                        int i21 = 13;
                        while (i20 < i21) {
                            char charAt4 = charAt(length2 + i20);
                            if (charAt4 < '0' || charAt4 > '9') {
                                if (charAt4 >= 'a' && charAt4 <= 'f') {
                                    i12 = charAt4 - 'a';
                                } else if (charAt4 < c5 || charAt4 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i12 = charAt4 - 'A';
                                }
                                i13 = i12 + 10;
                            } else {
                                i13 = charAt4 - '0';
                            }
                            j = (j << c2) | i13;
                            i20++;
                            i21 = 13;
                            c5 = 'A';
                            c2 = 4;
                        }
                        long j2 = j;
                        for (int i22 = 14; i22 < 18; i22++) {
                            char charAt5 = charAt(length2 + i22);
                            if (charAt5 < '0' || charAt5 > '9') {
                                if (charAt5 >= 'a' && charAt5 <= 'f') {
                                    i10 = charAt5 - 'a';
                                } else if (charAt5 < 'A' || charAt5 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i10 = charAt5 - 'A';
                                }
                                i11 = i10 + 10;
                            } else {
                                i11 = charAt5 - '0';
                            }
                            j2 = (j2 << 4) | i11;
                        }
                        long j3 = 0;
                        for (int i23 = 19; i23 < 23; i23++) {
                            char charAt6 = charAt(length2 + i23);
                            if (charAt6 < '0' || charAt6 > '9') {
                                if (charAt6 >= 'a' && charAt6 <= 'f') {
                                    i8 = charAt6 - 'a';
                                } else if (charAt6 < 'A' || charAt6 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i8 = charAt6 - 'A';
                                }
                                i9 = i8 + 10;
                            } else {
                                i9 = charAt6 - '0';
                            }
                            j3 = (j3 << 4) | i9;
                        }
                        int i24 = 24;
                        long j4 = j3;
                        int i25 = 36;
                        while (i24 < i25) {
                            char charAt7 = charAt(length2 + i24);
                            if (charAt7 < c6 || charAt7 > '9') {
                                if (charAt7 >= 'a' && charAt7 <= c4) {
                                    i6 = charAt7 - 'a';
                                } else if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i6 = charAt7 - 'A';
                                }
                                i7 = i6 + 10;
                            } else {
                                i7 = charAt7 - '0';
                            }
                            j4 = (j4 << 4) | i7;
                            i24++;
                            i16 = i16;
                            i25 = 36;
                            c6 = '0';
                            c4 = 'f';
                        }
                        uuid = new UUID(j2, j4);
                        int i26 = this.bp;
                        int length3 = i16 + (i19 - ((cArr.length + i26) + 1)) + 1;
                        i2 = length3 + 1;
                        charAt = charAt(i26 + length3);
                    } else {
                        if (i17 == 32) {
                            long j5 = 0;
                            for (int i27 = 0; i27 < 16; i27++) {
                                char charAt8 = charAt(length2 + i27);
                                if (charAt8 < '0' || charAt8 > '9') {
                                    if (charAt8 >= 'a' && charAt8 <= 'f') {
                                        i4 = charAt8 - 'a';
                                    } else if (charAt8 < 'A' || charAt8 > 'F') {
                                        this.matchStat = -2;
                                        return null;
                                    } else {
                                        i4 = charAt8 - 'A';
                                    }
                                    i5 = i4 + 10;
                                } else {
                                    i5 = charAt8 - '0';
                                }
                                j5 = (j5 << 4) | i5;
                            }
                            int i28 = 16;
                            long j6 = 0;
                            for (int i29 = 32; i28 < i29; i29 = 32) {
                                char charAt9 = charAt(length2 + i28);
                                if (charAt9 >= '0' && charAt9 <= '9') {
                                    i3 = charAt9 - '0';
                                } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                    i3 = (charAt9 - 'a') + 10;
                                } else if (charAt9 < 'A' || charAt9 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = (charAt9 - 'A') + 10;
                                    j6 = (j6 << 4) | i3;
                                    i28++;
                                }
                                j6 = (j6 << 4) | i3;
                                i28++;
                            }
                            uuid = new UUID(j5, j6);
                            int i30 = this.bp;
                            int length4 = i16 + (indexOf - ((cArr.length + i30) + 1)) + 1;
                            i2 = length4 + 1;
                            charAt = charAt(i30 + length4);
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
                    int i31 = i16 + 1;
                    if (charAt(this.bp + i16) == 'u') {
                        int i32 = i31 + 1;
                        if (charAt(this.bp + i31) == 'l') {
                            int i33 = i32 + 1;
                            if (charAt(this.bp + i32) == 'l') {
                                charAt = charAt(this.bp + i33);
                                i2 = i33 + 1;
                                uuid = null;
                            }
                        }
                    }
                }
                this.matchStat = -1;
                return null;
            }
            if (charAt == ',') {
                int i34 = this.bp + i2;
                this.bp = i34;
                this.ch = charAt(i34);
                this.matchStat = 3;
                return uuid;
            } else if (charAt == '}') {
                int i35 = i2 + 1;
                char charAt10 = charAt(this.bp + i2);
                if (charAt10 == ',') {
                    this.token = 16;
                    int i36 = this.bp + i35;
                    this.bp = i36;
                    this.ch = charAt(i36);
                } else if (charAt10 == ']') {
                    this.token = 15;
                    int i37 = this.bp + i35;
                    this.bp = i37;
                    this.ch = charAt(i37);
                } else if (charAt10 == '}') {
                    this.token = 13;
                    int i38 = this.bp + i35;
                    this.bp = i38;
                    this.ch = charAt(i38);
                } else if (charAt10 == 26) {
                    this.token = 20;
                    this.bp += i35 - 1;
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
        return (UUID) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c7 -> B:56:0x00c9). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float scanFloat(char c2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        char charAt;
        int i4;
        int i5;
        float parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048644, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            char charAt2 = charAt(this.bp + 0);
            boolean z = charAt2 == '\"';
            if (z) {
                charAt2 = charAt(this.bp + 1);
                i2 = 2;
            } else {
                i2 = 1;
            }
            boolean z2 = charAt2 == '-';
            if (z2) {
                charAt2 = charAt(this.bp + i2);
                i2++;
            }
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
                    this.matchStat = 5;
                    int i6 = i2 + 3;
                    int i7 = i6 + 1;
                    char charAt3 = charAt(this.bp + i6);
                    if (z && charAt3 == '\"') {
                        charAt3 = charAt(this.bp + i7);
                        i7++;
                    }
                    while (charAt3 != ',') {
                        if (charAt3 == ']') {
                            int i8 = this.bp + i7;
                            this.bp = i8;
                            this.ch = charAt(i8);
                            this.matchStat = 5;
                            this.token = 15;
                            return 0.0f;
                        } else if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return 0.0f;
                        }
                    }
                    int i9 = this.bp + i7;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 5;
                    this.token = 16;
                    return 0.0f;
                }
                this.matchStat = -1;
                return 0.0f;
            }
            long j = charAt2 - '0';
            while (true) {
                i3 = i2 + 1;
                charAt = charAt(this.bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j = (j * 10) + (charAt - '0');
                i2 = i3;
            }
            long j2 = 1;
            if (charAt == '.') {
                int i10 = i3 + 1;
                char charAt4 = charAt(this.bp + i3);
                if (charAt4 >= '0' && charAt4 <= '9') {
                    j = (j * 10) + (charAt4 - '0');
                    j2 = 10;
                    while (true) {
                        i3 = i10 + 1;
                        charAt = charAt(this.bp + i10);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j = (j * 10) + (charAt - '0');
                        j2 *= 10;
                        i10 = i3;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            long j3 = j2;
            boolean z3 = charAt == 'e' || charAt == 'E';
            if (z3) {
                int i11 = i3 + 1;
                char charAt5 = charAt(this.bp + i3);
                if (charAt5 == '+' || charAt5 == '-') {
                    int i12 = i11 + 1;
                    charAt = charAt(this.bp + i11);
                    i3 = i12;
                    if (charAt >= '0' && charAt <= '9') {
                        i12 = i3 + 1;
                        charAt = charAt(this.bp + i3);
                        i3 = i12;
                        if (charAt >= '0') {
                            i12 = i3 + 1;
                            charAt = charAt(this.bp + i3);
                            i3 = i12;
                            if (charAt >= '0') {
                            }
                        }
                    }
                } else {
                    i3 = i11;
                    charAt = charAt5;
                    if (charAt >= '0') {
                    }
                }
            }
            if (!z) {
                i4 = this.bp;
                i5 = ((i4 + i3) - i4) - 1;
            } else if (charAt != '\"') {
                this.matchStat = -1;
                return 0.0f;
            } else {
                int i13 = i3 + 1;
                charAt = charAt(this.bp + i3);
                int i14 = this.bp;
                i4 = i14 + 1;
                i5 = ((i14 + i13) - i4) - 2;
                i3 = i13;
            }
            if (z3 || i5 >= 17) {
                parseFloat = Float.parseFloat(subString(i4, i5));
            } else {
                parseFloat = (float) (j / j3);
                if (z2) {
                    parseFloat = -parseFloat;
                }
            }
            if (charAt == c2) {
                int i15 = this.bp + i3;
                this.bp = i15;
                this.ch = charAt(i15);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            }
            this.matchStat = -1;
            return parseFloat;
        }
        return invokeCommon.floatValue;
    }

    public final void scanHex() {
        char next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            if (this.ch == 'x') {
                next();
                if (this.ch == '\'') {
                    this.np = this.bp;
                    next();
                    if (this.ch == '\'') {
                        next();
                        this.token = 26;
                        return;
                    }
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
    }

    public final void scanIdent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
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
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:69:0x0100 -> B:58:0x00cf */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            char charAt2 = charAt(this.bp + 0);
            boolean z = charAt2 == '\"';
            if (z) {
                charAt2 = charAt(this.bp + 1);
                i2 = 2;
            } else {
                i2 = 1;
            }
            boolean z2 = charAt2 == '-';
            if (z2) {
                charAt2 = charAt(this.bp + i2);
                i2++;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                int i4 = charAt2 - '0';
                while (true) {
                    i3 = i2 + 1;
                    charAt = charAt(this.bp + i2);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i4 = (i4 * 10) + (charAt - '0');
                    i2 = i3;
                }
                if (charAt == '.') {
                    this.matchStat = -1;
                    return 0;
                } else if (i4 < 0) {
                    this.matchStat = -1;
                    return 0;
                } else {
                    while (charAt != c2) {
                        if (isWhitespace(charAt)) {
                            i3++;
                            charAt = charAt(this.bp + i3);
                        } else {
                            this.matchStat = -1;
                            return z2 ? -i4 : i4;
                        }
                    }
                    int i5 = this.bp + i3;
                    this.bp = i5;
                    this.ch = charAt(i5);
                    this.matchStat = 3;
                    this.token = 16;
                    return z2 ? -i4 : i4;
                }
            } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
                this.matchStat = 5;
                int i6 = i2 + 3;
                int i7 = i6 + 1;
                char charAt3 = charAt(this.bp + i6);
                if (z && charAt3 == '\"') {
                    int i8 = i7 + 1;
                    charAt3 = charAt(this.bp + i7);
                    i7 = i8;
                }
                while (charAt3 != ',') {
                    if (charAt3 == ']') {
                        int i9 = this.bp + i7;
                        this.bp = i9;
                        this.ch = charAt(i9);
                        this.matchStat = 5;
                        this.token = 15;
                        return 0;
                    } else if (isWhitespace(charAt3)) {
                        int i10 = i7 + 1;
                        charAt3 = charAt(this.bp + i7);
                        i7 = i10;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                }
                int i11 = this.bp + i7;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 5;
                this.token = 16;
                return 0;
            } else {
                this.matchStat = -1;
                return 0;
            }
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:81:0x013d -> B:70:0x010c */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c2) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        char charAt;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            char charAt2 = charAt(this.bp + 0);
            boolean z = charAt2 == '\"';
            if (z) {
                charAt2 = charAt(this.bp + 1);
                i2 = 2;
            } else {
                i2 = 1;
            }
            boolean z2 = charAt2 == '-';
            if (z2) {
                charAt2 = charAt(this.bp + i2);
                i2++;
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                long j = charAt2 - '0';
                while (true) {
                    i3 = i2 + 1;
                    charAt = charAt(this.bp + i2);
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
                if (j >= 0 || (j == Long.MIN_VALUE && z2)) {
                    if (!z) {
                        c3 = c2;
                    } else if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0L;
                    } else {
                        charAt = charAt(this.bp + i3);
                        c3 = c2;
                        i3++;
                    }
                    while (charAt != c3) {
                        if (isWhitespace(charAt)) {
                            charAt = charAt(this.bp + i3);
                            i3++;
                        } else {
                            this.matchStat = -1;
                            return j;
                        }
                    }
                    int i4 = this.bp + i3;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    this.token = 16;
                    return z2 ? -j : j;
                }
                throw new NumberFormatException(subString(this.bp, i3 - 1));
            } else if (charAt2 == 'n' && charAt(this.bp + i2) == 'u' && charAt(this.bp + i2 + 1) == 'l' && charAt(this.bp + i2 + 2) == 'l') {
                this.matchStat = 5;
                int i5 = i2 + 3;
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
                        return 0L;
                    } else if (isWhitespace(charAt3)) {
                        int i9 = i6 + 1;
                        charAt3 = charAt(this.bp + i6);
                        i6 = i9;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i10 = this.bp + i6;
                this.bp = i10;
                this.ch = charAt(i10);
                this.matchStat = 5;
                this.token = 16;
                return 0L;
            } else {
                this.matchStat = -1;
                return 0L;
            }
        }
        return invokeCommon.longValue;
    }

    public final void scanNullOrNew() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            scanNullOrNew(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void scanNumber() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048651, this) != null) {
            return;
        }
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
        int i2 = this.sp;
        if (i2 <= 65535) {
            char c4 = this.ch;
            if (c4 == 'L') {
                this.sp = i2 + 1;
                next();
            } else if (c4 == 'S') {
                this.sp = i2 + 1;
                next();
            } else if (c4 != 'B') {
                if (c4 == 'F') {
                    this.sp = i2 + 1;
                    next();
                } else if (c4 == 'D') {
                    this.sp = i2 + 1;
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
                this.sp = i2 + 1;
                next();
            }
            z = z2;
            if (!z) {
            }
        } else {
            throw new JSONException("scanNumber overflow");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0176, code lost:
        throw new com.alibaba.fastjson.JSONException("invalid escape character \\x" + r1 + r2);
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void scanString() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048653, this) != null) {
            return;
        }
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next != 26) {
                boolean z = true;
                if (next == '\\') {
                    if (!this.hasSpecial) {
                        this.hasSpecial = true;
                        int i2 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i2 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i2 <= length) {
                                i2 = length;
                            }
                            char[] cArr2 = new char[i2];
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
                                    boolean z2 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                    if ((next4 < '0' || next4 > '9') && ((next4 < 'a' || next4 > 'f') && (next4 < 'A' || next4 > 'F'))) {
                                        z = false;
                                    }
                                    if (z2 && z) {
                                        int[] iArr = digits;
                                        putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                                    }
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
                    int i3 = this.sp;
                    char[] cArr4 = this.sbuf;
                    if (i3 == cArr4.length) {
                        putChar(next);
                    } else {
                        this.sp = i3 + 1;
                        cArr4[i3] = next;
                    }
                }
            } else if (!isEOF()) {
                putChar(JSONLexer.EOI);
            } else {
                throw new JSONException("unclosed string : " + next);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x012f, code lost:
        if (r1 != r18) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0131, code lost:
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x013f, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scanStringArray(Collection<String> collection, char c2) {
        int i2;
        char charAt;
        int i3;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048654, this, new Object[]{collection, Character.valueOf(c2)}) != null) {
            return;
        }
        this.matchStat = 0;
        char charAt3 = charAt(this.bp + 0);
        char c3 = 'u';
        char c4 = 'n';
        if (charAt3 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l' && charAt(this.bp + 1 + 3) == c2) {
            int i4 = this.bp + 5;
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 5;
        } else if (charAt3 != '[') {
            this.matchStat = -1;
        } else {
            char charAt4 = charAt(this.bp + 1);
            int i5 = 2;
            while (true) {
                if (charAt4 == c4 && charAt(this.bp + i5) == c3 && charAt(this.bp + i5 + 1) == 'l' && charAt(this.bp + i5 + 2) == 'l') {
                    int i6 = i5 + 3;
                    i2 = i6 + 1;
                    charAt = charAt(this.bp + i6);
                    collection.add(null);
                } else if (charAt4 == ']' && collection.size() == 0) {
                    i3 = i5 + 1;
                    charAt2 = charAt(this.bp + i5);
                    break;
                } else if (charAt4 != '\"') {
                    this.matchStat = -1;
                    return;
                } else {
                    int i7 = this.bp + i5;
                    int indexOf = indexOf(Typography.quote, i7);
                    if (indexOf != -1) {
                        String subString = subString(this.bp + i5, indexOf - i7);
                        if (subString.indexOf(92) != -1) {
                            while (true) {
                                int i8 = 0;
                                for (int i9 = indexOf - 1; i9 >= 0 && charAt(i9) == '\\'; i9--) {
                                    i8++;
                                }
                                if (i8 % 2 == 0) {
                                    break;
                                }
                                indexOf = indexOf(Typography.quote, indexOf + 1);
                            }
                            int i10 = indexOf - i7;
                            subString = readString(sub_chars(this.bp + i5, i10), i10);
                        }
                        int i11 = this.bp;
                        int i12 = i5 + (indexOf - (i11 + i5)) + 1;
                        i2 = i12 + 1;
                        charAt = charAt(i11 + i12);
                        collection.add(subString);
                    } else {
                        throw new JSONException("unclosed str");
                    }
                }
                if (charAt == ',') {
                    i5 = i2 + 1;
                    charAt4 = charAt(this.bp + i2);
                    c3 = 'u';
                    c4 = 'n';
                } else if (charAt == ']') {
                    i3 = i2 + 1;
                    charAt2 = charAt(this.bp + i2);
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, symbolTable)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, symbolTable)) == null) {
            boolean z = false;
            if (this.token == 1 && this.pos == 0 && this.bp == 1) {
                this.bp = 0;
            }
            boolean[] zArr = IOUtils.firstIdentifierFlags;
            int i2 = this.ch;
            if ((i2 >= zArr.length || zArr[i2]) ? true : true) {
                boolean[] zArr2 = IOUtils.identifierFlags;
                this.np = this.bp;
                this.sp = 1;
                while (true) {
                    char next = next();
                    if (next < zArr2.length && !zArr2[next]) {
                        break;
                    }
                    i2 = (i2 * 31) + next;
                    this.sp++;
                }
                this.ch = charAt(this.bp);
                this.token = 18;
                if (this.sp == 4 && i2 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                    return null;
                }
                if (symbolTable == null) {
                    return subString(this.np, this.sp);
                }
                return addSymbol(this.np, this.sp, i2, symbolTable);
            }
            throw new JSONException("illegal identifier : " + this.ch + info());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{symbolTable, Character.valueOf(c2)})) != null) {
            return (String) invokeCommon.objValue;
        }
        int i2 = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c2) {
                    int i3 = this.bp + 5;
                    this.bp = i3;
                    this.ch = charAt(i3);
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
            int i4 = 1;
            while (true) {
                int i5 = i4 + 1;
                char charAt2 = charAt(this.bp + i4);
                if (charAt2 == '\"') {
                    int i6 = this.bp;
                    int i7 = i6 + 0 + 1;
                    String addSymbol = addSymbol(i7, ((i6 + i5) - i7) - 1, i2, symbolTable);
                    int i8 = i5 + 1;
                    char charAt3 = charAt(this.bp + i5);
                    while (charAt3 != c2) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i8);
                            i8++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.ch = charAt(i9);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i2 = (i2 * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i4 = i5;
            }
        }
    }

    public final void scanTrue() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
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
    }

    public final int scanType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, str)) == null) {
            this.matchStat = 0;
            if (charArrayCompare(typeFieldName)) {
                int length = this.bp + typeFieldName.length;
                int length2 = str.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    if (str.charAt(i2) != charAt(length + i2)) {
                        return -1;
                    }
                }
                int i3 = length + length2;
                if (charAt(i3) != '\"') {
                    return -1;
                }
                int i4 = i3 + 1;
                char charAt = charAt(i4);
                this.ch = charAt;
                if (charAt == ',') {
                    int i5 = i4 + 1;
                    this.ch = charAt(i5);
                    this.bp = i5;
                    this.token = 16;
                    return 3;
                }
                if (charAt == '}') {
                    i4++;
                    char charAt2 = charAt(i4);
                    this.ch = charAt2;
                    if (charAt2 == ',') {
                        this.token = 16;
                        i4++;
                        this.ch = charAt(i4);
                    } else if (charAt2 == ']') {
                        this.token = 15;
                        i4++;
                        this.ch = charAt(i4);
                    } else if (charAt2 == '}') {
                        this.token = 13;
                        i4++;
                        this.ch = charAt(i4);
                    } else if (charAt2 != 26) {
                        return -1;
                    } else {
                        this.token = 20;
                    }
                    this.matchStat = 4;
                }
                this.bp = i4;
                return this.matchStat;
            }
            return -2;
        }
        return invokeL.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, symbolTable)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public UUID scanUUID(char c2) {
        InterceptResult invokeCommon;
        int i2;
        char charAt;
        UUID uuid;
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
        int i15;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048662, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            char charAt2 = charAt(this.bp + 0);
            int i16 = 13;
            char c3 = 4;
            if (charAt2 == '\"') {
                int indexOf = indexOf(Typography.quote, this.bp + 1);
                if (indexOf != -1) {
                    int i17 = this.bp + 1;
                    int i18 = indexOf - i17;
                    char c4 = 'f';
                    char c5 = 'A';
                    char c6 = 'a';
                    if (i18 == 36) {
                        int i19 = 0;
                        long j = 0;
                        while (i19 < 8) {
                            char charAt3 = charAt(i17 + i19);
                            if (charAt3 < '0' || charAt3 > '9') {
                                if (charAt3 >= 'a' && charAt3 <= c4) {
                                    i14 = charAt3 - 'a';
                                } else if (charAt3 < 'A' || charAt3 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i14 = charAt3 - 'A';
                                }
                                i15 = i14 + 10;
                            } else {
                                i15 = charAt3 - '0';
                            }
                            j = (j << 4) | i15;
                            i19++;
                            c4 = 'f';
                        }
                        int i20 = 9;
                        while (i20 < i16) {
                            char charAt4 = charAt(i17 + i20);
                            if (charAt4 < '0' || charAt4 > '9') {
                                if (charAt4 >= 'a' && charAt4 <= 'f') {
                                    i12 = charAt4 - 'a';
                                } else if (charAt4 < c5 || charAt4 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i12 = charAt4 - 'A';
                                }
                                i13 = i12 + 10;
                            } else {
                                i13 = charAt4 - '0';
                            }
                            j = (j << 4) | i13;
                            i20++;
                            i16 = 13;
                            c5 = 'A';
                        }
                        long j2 = j;
                        for (int i21 = 14; i21 < 18; i21++) {
                            char charAt5 = charAt(i17 + i21);
                            if (charAt5 < '0' || charAt5 > '9') {
                                if (charAt5 >= 'a' && charAt5 <= 'f') {
                                    i10 = charAt5 - 'a';
                                } else if (charAt5 < 'A' || charAt5 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i10 = charAt5 - 'A';
                                }
                                i11 = i10 + 10;
                            } else {
                                i11 = charAt5 - '0';
                            }
                            j2 = (j2 << 4) | i11;
                        }
                        int i22 = 19;
                        long j3 = 0;
                        while (i22 < 23) {
                            char charAt6 = charAt(i17 + i22);
                            if (charAt6 < '0' || charAt6 > '9') {
                                if (charAt6 >= c6 && charAt6 <= 'f') {
                                    i8 = charAt6 - 'a';
                                } else if (charAt6 < 'A' || charAt6 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i8 = charAt6 - 'A';
                                }
                                i9 = i8 + 10;
                            } else {
                                i9 = charAt6 - '0';
                            }
                            j3 = (j3 << c3) | i9;
                            i22++;
                            c6 = 'a';
                            c3 = 4;
                        }
                        long j4 = j3;
                        for (int i23 = 24; i23 < 36; i23++) {
                            char charAt7 = charAt(i17 + i23);
                            if (charAt7 < '0' || charAt7 > '9') {
                                if (charAt7 >= 'a' && charAt7 <= 'f') {
                                    i6 = charAt7 - 'a';
                                } else if (charAt7 < 'A' || charAt7 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i6 = charAt7 - 'A';
                                }
                                i7 = i6 + 10;
                            } else {
                                i7 = charAt7 - '0';
                            }
                            j4 = (j4 << 4) | i7;
                        }
                        uuid = new UUID(j2, j4);
                        int i24 = this.bp;
                        int i25 = 1 + (indexOf - (i24 + 1)) + 1;
                        i2 = i25 + 1;
                        charAt = charAt(i24 + i25);
                    } else {
                        if (i18 == 32) {
                            long j5 = 0;
                            for (int i26 = 0; i26 < 16; i26++) {
                                char charAt8 = charAt(i17 + i26);
                                if (charAt8 < '0' || charAt8 > '9') {
                                    if (charAt8 >= 'a' && charAt8 <= 'f') {
                                        i4 = charAt8 - 'a';
                                    } else if (charAt8 < 'A' || charAt8 > 'F') {
                                        this.matchStat = -2;
                                        return null;
                                    } else {
                                        i4 = charAt8 - 'A';
                                    }
                                    i5 = i4 + 10;
                                } else {
                                    i5 = charAt8 - '0';
                                }
                                j5 = (j5 << 4) | i5;
                            }
                            int i27 = 16;
                            long j6 = 0;
                            for (int i28 = 32; i27 < i28; i28 = 32) {
                                char charAt9 = charAt(i17 + i27);
                                if (charAt9 >= '0' && charAt9 <= '9') {
                                    i3 = charAt9 - '0';
                                } else if (charAt9 >= 'a' && charAt9 <= 'f') {
                                    i3 = (charAt9 - 'a') + 10;
                                } else if (charAt9 < 'A' || charAt9 > 'F') {
                                    this.matchStat = -2;
                                    return null;
                                } else {
                                    i3 = (charAt9 - 'A') + 10;
                                }
                                j6 = (j6 << 4) | i3;
                                i27++;
                            }
                            uuid = new UUID(j5, j6);
                            int i29 = this.bp;
                            int i30 = 1 + (indexOf - (i29 + 1)) + 1;
                            i2 = i30 + 1;
                            charAt = charAt(i29 + i30);
                        } else {
                            this.matchStat = -1;
                            return null;
                        }
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            } else if (charAt2 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                i2 = 5;
                charAt = charAt(this.bp + 4);
                uuid = null;
            } else {
                this.matchStat = -1;
                return null;
            }
            if (charAt == ',') {
                int i31 = this.bp + i2;
                this.bp = i31;
                this.ch = charAt(i31);
                this.matchStat = 3;
                return uuid;
            } else if (charAt == ']') {
                int i32 = i2 + 1;
                char charAt10 = charAt(this.bp + i2);
                if (charAt10 == ',') {
                    this.token = 16;
                    int i33 = this.bp + i32;
                    this.bp = i33;
                    this.ch = charAt(i33);
                } else if (charAt10 == ']') {
                    this.token = 15;
                    int i34 = this.bp + i32;
                    this.bp = i34;
                    this.ch = charAt(i34);
                } else if (charAt10 == '}') {
                    this.token = 13;
                    int i35 = this.bp + i32;
                    this.bp = i35;
                    this.ch = charAt(i35);
                } else if (charAt10 == 26) {
                    this.token = 20;
                    this.bp += i32 - 1;
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
        return (UUID) invokeCommon.objValue;
    }

    public boolean seekArrayToItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048663, this, i2)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeI.booleanValue;
    }

    public int seekObjectToField(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048664, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeCommon.intValue;
    }

    public int seekObjectToFieldDeepScan(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048666, this, j)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeJ.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setFeatures(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i2) == null) {
            this.features = i2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, locale) == null) {
            this.locale = locale;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, timeZone) == null) {
            this.timeZone = timeZone;
        }
    }

    public void setToken(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i2) == null) {
            this.token = i2;
        }
    }

    public void skipArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public void skipComment() {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048672, this) != null) {
            return;
        }
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

    public void skipObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048675, this) != null) {
            return;
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.stringDefaultValue : (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i2, int i3);

    public abstract char[] sub_chars(int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.token : invokeV.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? JSONToken.name(this.token) : (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? (i2 & this.features) != 0 : invokeI.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            nextTokenWithChar(':');
        }
    }

    public final void scanNullOrNew(boolean z) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            if (this.ch == 'n') {
                next();
                char c3 = this.ch;
                if (c3 != 'u') {
                    if (c3 == 'e') {
                        next();
                        if (this.ch == 'w') {
                            next();
                            char c4 = this.ch;
                            if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b') {
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
                        char c5 = this.ch;
                        if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && ((c5 != ':' || !z) && (c2 = this.ch) != '\f' && c2 != '\b')) {
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
    }

    public int seekObjectToField(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, jArr)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.intValue;
    }

    public void skipObject(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean isEnabled(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048600, this, i2, i3)) == null) ? ((this.features & i3) == 0 && (i2 & i3) == 0) ? false : true : invokeII.booleanValue;
    }

    public int matchField(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048605, this, j)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeJ.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c2) {
        InterceptResult invokeCommon;
        String addSymbol;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{symbolTable, Character.valueOf(c2)})) != null) {
            return (String) invokeCommon.objValue;
        }
        this.np = this.bp;
        this.sp = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            char next = next();
            if (next == c2) {
                this.token = 4;
                if (!z) {
                    int i3 = this.np;
                    addSymbol = addSymbol(i3 == -1 ? 0 : i3 + 1, this.sp, i2, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i2);
                }
                this.sp = 0;
                next();
                return addSymbol;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else {
                if (next == '\\') {
                    if (!z) {
                        int i4 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i4 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i4 <= length) {
                                i4 = length;
                            }
                            char[] cArr2 = new char[i4];
                            char[] cArr3 = this.sbuf;
                            System.arraycopy(cArr3, 0, cArr2, 0, cArr3.length);
                            this.sbuf = cArr2;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                        z = true;
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        i2 = (i2 * 31) + 34;
                        putChar(Typography.quote);
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                i2 = (i2 * 31) + 92;
                                putChar('\\');
                            } else if (next2 == 'b') {
                                i2 = (i2 * 31) + 8;
                                putChar('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    i2 = (i2 * 31) + 10;
                                    putChar('\n');
                                } else if (next2 == 'r') {
                                    i2 = (i2 * 31) + 13;
                                    putChar('\r');
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case '/':
                                            i2 = (i2 * 31) + 47;
                                            putChar('/');
                                            continue;
                                        case '0':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 0);
                                            continue;
                                        case '1':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 1);
                                            continue;
                                        case '2':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 2);
                                            continue;
                                        case '3':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 3);
                                            continue;
                                        case '4':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 4);
                                            continue;
                                        case '5':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 5);
                                            continue;
                                        case '6':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 6);
                                            continue;
                                        case '7':
                                            i2 = (i2 * 31) + next2;
                                            putChar((char) 7);
                                            continue;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    i2 = (i2 * 31) + 9;
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                    i2 = (i2 * 31) + parseInt;
                                                    putChar((char) parseInt);
                                                    continue;
                                                    continue;
                                                case 'v':
                                                    i2 = (i2 * 31) + 11;
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
                                    i2 = (i2 * 31) + c3;
                                    putChar(c3);
                                }
                            }
                        }
                        i2 = (i2 * 31) + 12;
                        putChar('\f');
                    } else {
                        i2 = (i2 * 31) + 39;
                        putChar('\'');
                    }
                } else {
                    i2 = (i2 * 31) + next;
                    if (!z) {
                        this.sp++;
                    } else {
                        int i5 = this.sp;
                        char[] cArr4 = this.sbuf;
                        if (i5 == cArr4.length) {
                            putChar(next);
                        } else {
                            this.sp = i5 + 1;
                            cArr4[i5] = next;
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048613, this, i2) != null) {
            return;
        }
        this.sp = 0;
        while (true) {
            if (i2 == 2) {
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
            } else if (i2 == 4) {
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
            } else if (i2 == 12) {
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
            } else if (i2 != 18) {
                if (i2 != 20) {
                    switch (i2) {
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
                            } else if (c8 == 'n') {
                                scanNullOrNew(false);
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
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048652, this, new Object[]{Character.valueOf(c2)})) == null) {
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
            }
            int i3 = 1;
            while (charAt != '\"') {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i3);
                    i3++;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i4 = this.bp + i3;
            int indexOf = indexOf(Typography.quote, i4);
            if (indexOf != -1) {
                String subString = subString(this.bp + i3, indexOf - i4);
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
                    subString = readString(sub_chars(this.bp + 1, i7), i7);
                }
                int i8 = i3 + (indexOf - i4) + 1;
                int i9 = i8 + 1;
                char charAt2 = charAt(this.bp + i8);
                while (charAt2 != c2) {
                    if (!isWhitespace(charAt2)) {
                        if (charAt2 == ']') {
                            int i10 = this.bp + i9;
                            this.bp = i10;
                            this.ch = charAt(i10);
                            this.matchStat = -1;
                        }
                        return subString;
                    }
                    charAt2 = charAt(this.bp + i9);
                    i9++;
                }
                int i11 = this.bp + i9;
                this.bp = i11;
                this.ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return subString;
            }
            throw new JSONException("unclosed str");
        }
        return (String) invokeCommon.objValue;
    }

    public String[] scanFieldStringArray(char[] cArr, int i2, SymbolTable symbolTable) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048641, this, cArr, i2, symbolTable)) == null) {
            throw new UnsupportedOperationException();
        }
        return (String[]) invokeLIL.objValue;
    }
}
