package com.alibaba.fastjson.parser;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public final class JSONScanner extends JSONLexerBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int len;
    public final String text;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean charArrayCompare(String str, int i2, char[] cArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, cArr)) == null) {
            int length = cArr.length;
            if (length + i2 > str.length()) {
                return false;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (cArr[i3] != str.charAt(i2 + i3)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean checkDate(char c2, char c3, char c4, char c5, char c6, char c7, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5), Character.valueOf(c6), Character.valueOf(c7), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9' && c5 >= '0' && c5 <= '9') {
                if (c6 == '0') {
                    if (c7 < '1' || c7 > '9') {
                        return false;
                    }
                } else if (c6 != '1' || (c7 != '0' && c7 != '1' && c7 != '2')) {
                    return false;
                }
                if (i2 == 48) {
                    return i3 >= 49 && i3 <= 57;
                } else if (i2 != 49 && i2 != 50) {
                    return i2 == 51 && (i3 == 48 || i3 == 49);
                } else if (i3 >= 48 && i3 <= 57) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
        if (r6 <= '4') goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean checkTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5), Character.valueOf(c6), Character.valueOf(c7)})) == null) {
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
        return invokeCommon.booleanValue;
    }

    private void setCalendar(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5), Character.valueOf(c6), Character.valueOf(c7), Character.valueOf(c8), Character.valueOf(c9)}) == null) {
            Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
            this.calendar = calendar;
            calendar.set(1, ((c2 - '0') * 1000) + ((c3 - '0') * 100) + ((c4 - '0') * 10) + (c5 - '0'));
            this.calendar.set(2, (((c6 - '0') * 10) + (c7 - '0')) - 1);
            this.calendar.set(5, ((c8 - '0') * 10) + (c9 - '0'));
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i2, int i3, int i4, SymbolTable symbolTable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), symbolTable})) == null) ? symbolTable.addSymbol(this.text, i2, i3, i4) : (String) invokeCommon.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i2, char[] cArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.text.getChars(i2, i4 + i2, cArr, i3);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.token == 26) {
                int i2 = this.np + 1;
                int i3 = this.sp;
                if (i3 % 2 == 0) {
                    int i4 = i3 / 2;
                    byte[] bArr = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = (i5 * 2) + i2;
                        char charAt = this.text.charAt(i6);
                        char charAt2 = this.text.charAt(i6 + 1);
                        char c2 = '0';
                        int i7 = charAt - (charAt <= '9' ? '0' : '7');
                        if (charAt2 > '9') {
                            c2 = '7';
                        }
                        bArr[i5] = (byte) ((i7 << 4) | (charAt2 - c2));
                    }
                    return bArr;
                }
                throw new JSONException("illegal state. " + i3);
            } else if (!this.hasSpecial) {
                return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
            } else {
                return IOUtils.decodeBase64(new String(this.sbuf, 0, this.sp));
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 >= this.len ? JSONLexer.EOI : this.text.charAt(i2) : invokeI.charValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i2, int i3, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, cArr) == null) {
            this.text.getChars(i2, i3 + i2, cArr, 0);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            char charAt = charAt((this.np + this.sp) - 1);
            int i2 = this.sp;
            if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
                i2--;
            }
            if (i2 <= 65535) {
                int i3 = this.np;
                char[] cArr = this.sbuf;
                if (i2 < cArr.length) {
                    this.text.getChars(i3, i3 + i2, cArr, 0);
                    return new BigDecimal(this.sbuf, 0, i2, MathContext.UNLIMITED);
                }
                char[] cArr2 = new char[i2];
                this.text.getChars(i3, i3 + i2, cArr2, 0);
                return new BigDecimal(cArr2, 0, i2, MathContext.UNLIMITED);
            }
            throw new JSONException("decimal overflow");
        }
        return (BigDecimal) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) == null) ? this.text.indexOf(c2, i2) : invokeCommon.intValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 1;
            int i4 = 1;
            while (i2 < this.bp) {
                if (this.text.charAt(i2) == '\n') {
                    i3++;
                    i4 = 1;
                }
                i2++;
                i4++;
            }
            sb.append("pos ");
            sb.append(this.bp);
            sb.append(", line ");
            sb.append(i3);
            sb.append(", column ");
            sb.append(i4);
            if (this.text.length() < 65535) {
                sb.append(this.text);
            } else {
                sb.append(this.text.substring(0, 65535));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.bp;
            int i3 = this.len;
            if (i2 != i3) {
                return this.ch == 26 && i2 + 1 >= i3;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cArr)) == null) {
            while (JSONLexerBase.isWhitespace(this.ch)) {
                next();
            }
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return false;
            }
            int length = this.bp + cArr.length;
            int i2 = length + 1;
            char charAt = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = this.text.charAt(i2);
                i2++;
            }
            if (charAt == ':') {
                this.bp = i2;
                this.ch = charAt(i2);
                return true;
            }
            this.matchStat = -2;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.bp + 1;
            this.bp = i2;
            char charAt = i2 >= this.len ? JSONLexer.EOI : this.text.charAt(i2);
            this.ch = charAt;
            return charAt;
        }
        return invokeV.charValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            char charAt = charAt((this.np + this.sp) - 1);
            int i2 = this.sp;
            if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
                i2--;
            }
            return subString(this.np, i2);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c2) {
        InterceptResult invokeCommon;
        char c3;
        long j;
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Character.valueOf(c2)})) == null) {
            boolean z = false;
            this.matchStat = 0;
            int i3 = this.bp;
            char c4 = this.ch;
            int i4 = i3 + 1;
            char charAt = charAt(i3);
            if (charAt == '\"') {
                int indexOf = indexOf(Typography.quote, i4);
                if (indexOf != -1) {
                    this.bp = i4;
                    if (scanISO8601DateIfMatch(false, indexOf - i4)) {
                        date = this.calendar.getTime();
                        c3 = charAt(indexOf + 1);
                        this.bp = i3;
                        while (c3 != ',' && c3 != ']') {
                            if (JSONLexerBase.isWhitespace(c3)) {
                                indexOf++;
                                c3 = charAt(indexOf + 1);
                            } else {
                                this.bp = i3;
                                this.ch = c4;
                                this.matchStat = -1;
                                return null;
                            }
                        }
                        this.bp = indexOf + 1;
                        this.ch = c3;
                    } else {
                        this.bp = i3;
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
                        int i5 = i4 + 1;
                        if (charAt(i4) == 'u') {
                            int i6 = i5 + 1;
                            if (charAt(i5) == 'l') {
                                int i7 = i6 + 1;
                                if (charAt(i6) == 'l') {
                                    c3 = charAt(i7);
                                    this.bp = i7;
                                    date = null;
                                }
                            }
                        }
                    }
                    this.bp = i3;
                    this.ch = c4;
                    this.matchStat = -1;
                    return null;
                }
                if (charAt == '-') {
                    charAt = charAt(i4);
                    i4++;
                    z = true;
                }
                if (charAt < '0' || charAt > '9') {
                    c3 = charAt;
                    j = 0;
                } else {
                    j = charAt - '0';
                    while (true) {
                        i2 = i4 + 1;
                        c3 = charAt(i4);
                        if (c3 < c6 || c3 > c5) {
                            break;
                        }
                        j = (j * 10) + (c3 - '0');
                        i4 = i2;
                        c5 = '9';
                        c6 = '0';
                    }
                    if (c3 == ',' || c3 == ']') {
                        this.bp = i2 - 1;
                    }
                }
                if (j < 0) {
                    this.bp = i3;
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
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                return date;
            }
            int i9 = this.bp + 1;
            this.bp = i9;
            char charAt2 = charAt(i9);
            if (charAt2 == ',') {
                this.token = 16;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i12 = this.bp + 1;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt2 == 26) {
                this.ch = JSONLexer.EOI;
                this.token = 20;
            } else {
                this.bp = i3;
                this.ch = c4;
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        }
        return (Date) invokeCommon.objValue;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:104:0x017e -> B:93:0x014f */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00c8 -> B:54:0x00b8). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double scanDouble(char c2) {
        InterceptResult invokeCommon;
        int i2;
        char charAt;
        long j;
        int i3;
        int i4;
        double parseDouble;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.matchStat = 0;
            int i6 = this.bp;
            int i7 = i6 + 1;
            char charAt2 = charAt(i6);
            boolean z = charAt2 == '\"';
            if (z) {
                int i8 = i7 + 1;
                char charAt3 = charAt(i7);
                i7 = i8;
                charAt2 = charAt3;
            }
            boolean z2 = charAt2 == '-';
            if (z2) {
                int i9 = i7 + 1;
                char charAt4 = charAt(i7);
                i7 = i9;
                charAt2 = charAt4;
            }
            if (charAt2 >= '0') {
                char c3 = '9';
                if (charAt2 <= '9') {
                    long j2 = charAt2 - '0';
                    while (true) {
                        i2 = i7 + 1;
                        charAt = charAt(i7);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        j2 = (j2 * 10) + (charAt - '0');
                        i7 = i2;
                    }
                    if (charAt == '.') {
                        int i10 = i2 + 1;
                        char charAt5 = charAt(i2);
                        if (charAt5 < '0' || charAt5 > '9') {
                            this.matchStat = -1;
                            return 0.0d;
                        }
                        j2 = (j2 * 10) + (charAt5 - '0');
                        j = 10;
                        while (true) {
                            i5 = i10 + 1;
                            charAt = charAt(i10);
                            if (charAt < '0' || charAt > c3) {
                                break;
                            }
                            j2 = (j2 * 10) + (charAt - '0');
                            j *= 10;
                            i10 = i5;
                            c3 = '9';
                        }
                        i2 = i5;
                    } else {
                        j = 1;
                    }
                    boolean z3 = charAt == 'e' || charAt == 'E';
                    if (z3) {
                        int i11 = i2 + 1;
                        char charAt6 = charAt(i2);
                        if (charAt6 == '+' || charAt6 == '-') {
                            int i12 = i11 + 1;
                            charAt = charAt(i11);
                            i2 = i12;
                            if (charAt >= '0' && charAt <= '9') {
                                i11 = i2 + 1;
                                charAt6 = charAt(i2);
                            }
                        }
                        i2 = i11;
                        charAt = charAt6;
                        if (charAt >= '0') {
                            i11 = i2 + 1;
                            charAt6 = charAt(i2);
                            i2 = i11;
                            charAt = charAt6;
                            if (charAt >= '0') {
                            }
                        }
                    }
                    if (!z) {
                        i3 = this.bp;
                        i4 = (i2 - i3) - 1;
                    } else if (charAt != '\"') {
                        this.matchStat = -1;
                        return 0.0d;
                    } else {
                        int i13 = i2 + 1;
                        char charAt7 = charAt(i2);
                        i3 = this.bp + 1;
                        i4 = (i13 - i3) - 2;
                        i2 = i13;
                        charAt = charAt7;
                    }
                    if (z3 || i4 >= 18) {
                        parseDouble = Double.parseDouble(subString(i3, i4));
                    } else {
                        parseDouble = j2 / j;
                        if (z2) {
                            parseDouble = -parseDouble;
                        }
                    }
                    if (charAt == c2) {
                        this.bp = i2;
                        this.ch = charAt(i2);
                        this.matchStat = 3;
                        this.token = 16;
                        return parseDouble;
                    }
                    this.matchStat = -1;
                    return parseDouble;
                }
            }
            if (charAt2 == 'n') {
                int i14 = i7 + 1;
                if (charAt(i7) == 'u') {
                    int i15 = i14 + 1;
                    if (charAt(i14) == 'l') {
                        int i16 = i15 + 1;
                        if (charAt(i15) == 'l') {
                            this.matchStat = 5;
                            int i17 = i16 + 1;
                            char charAt8 = charAt(i16);
                            if (z && charAt8 == '\"') {
                                int i18 = i17 + 1;
                                char charAt9 = charAt(i17);
                                i17 = i18;
                                charAt8 = charAt9;
                            }
                            while (charAt8 != ',') {
                                if (charAt8 == ']') {
                                    this.bp = i17;
                                    this.ch = charAt(i17);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0.0d;
                                } else if (JSONLexerBase.isWhitespace(charAt8)) {
                                    int i19 = i17 + 1;
                                    char charAt10 = charAt(i17);
                                    i17 = i19;
                                    charAt8 = charAt10;
                                } else {
                                    this.matchStat = -1;
                                    return 0.0d;
                                }
                            }
                            this.bp = i17;
                            this.ch = charAt(i17);
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
        return invokeCommon.doubleValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0156, code lost:
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0108  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scanFieldBoolean(char[] cArr) {
        InterceptResult invokeL;
        char charAt;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048591, this, cArr)) != null) {
            return invokeL.booleanValue;
        }
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i2 = this.bp;
        int length = cArr.length + i2;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        boolean z2 = charAt2 == '\"';
        if (z2) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        if (charAt2 == 't') {
            int i5 = i3 + 1;
            if (charAt(i3) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(i5) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(i6) != 'e') {
                this.matchStat = -1;
                return false;
            }
            if (z2) {
                int i8 = i7 + 1;
                if (charAt(i7) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
                i7 = i8;
            }
            this.bp = i7;
            charAt = charAt(i7);
        } else {
            if (charAt2 == 'f') {
                int i9 = i3 + 1;
                if (charAt(i3) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i10 = i9 + 1;
                if (charAt(i9) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i11 = i10 + 1;
                if (charAt(i10) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i12 = i11 + 1;
                if (charAt(i11) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                if (z2) {
                    int i13 = i12 + 1;
                    if (charAt(i12) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i12 = i13;
                }
                this.bp = i12;
                charAt = charAt(i12);
            } else if (charAt2 == '1') {
                if (z2) {
                    int i14 = i3 + 1;
                    if (charAt(i3) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i3 = i14;
                }
                this.bp = i3;
                charAt = charAt(i3);
            } else if (charAt2 == '0') {
                if (z2) {
                    int i15 = i3 + 1;
                    if (charAt(i3) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i3 = i15;
                }
                this.bp = i3;
                charAt = charAt(i3);
            } else {
                this.matchStat = -1;
                return false;
            }
            z = false;
            while (true) {
                if (charAt != ',') {
                    int i16 = this.bp + 1;
                    this.bp = i16;
                    this.ch = charAt(i16);
                    this.matchStat = 3;
                    this.token = 16;
                    break;
                } else if (charAt == '}') {
                    int i17 = this.bp + 1;
                    this.bp = i17;
                    char charAt4 = charAt(i17);
                    while (true) {
                        if (charAt4 == ',') {
                            this.token = 16;
                            int i18 = this.bp + 1;
                            this.bp = i18;
                            this.ch = charAt(i18);
                            break;
                        } else if (charAt4 == ']') {
                            this.token = 15;
                            int i19 = this.bp + 1;
                            this.bp = i19;
                            this.ch = charAt(i19);
                            break;
                        } else if (charAt4 == '}') {
                            this.token = 13;
                            int i20 = this.bp + 1;
                            this.bp = i20;
                            this.ch = charAt(i20);
                            break;
                        } else if (charAt4 == 26) {
                            this.token = 20;
                            break;
                        } else if (JSONLexerBase.isWhitespace(charAt4)) {
                            int i21 = this.bp + 1;
                            this.bp = i21;
                            charAt4 = charAt(i21);
                        } else {
                            this.matchStat = -1;
                            return false;
                        }
                    }
                    this.matchStat = 4;
                } else if (JSONLexerBase.isWhitespace(charAt)) {
                    int i22 = this.bp + 1;
                    this.bp = i22;
                    charAt = charAt(i22);
                } else {
                    this.bp = i2;
                    charAt(i2);
                    this.matchStat = -1;
                    return false;
                }
            }
        }
        z = true;
        while (true) {
            if (charAt != ',') {
            }
            int i222 = this.bp + 1;
            this.bp = i222;
            charAt = charAt(i222);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        InterceptResult invokeL;
        char c2;
        long j;
        char c3;
        Date date;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cArr)) == null) {
            boolean z = false;
            this.matchStat = 0;
            int i3 = this.bp;
            char c4 = this.ch;
            if (!charArrayCompare(this.text, i3, cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt = charAt(length);
            if (charAt == '\"') {
                int indexOf = indexOf(Typography.quote, i4);
                if (indexOf != -1) {
                    this.bp = i4;
                    if (scanISO8601DateIfMatch(false, indexOf - i4)) {
                        date = this.calendar.getTime();
                        c3 = charAt(indexOf + 1);
                        this.bp = i3;
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
                        this.bp = i3;
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
                    charAt = charAt(i4);
                    i4++;
                    z = true;
                }
                if (charAt < '0' || charAt > '9') {
                    c2 = charAt;
                    j = 0;
                } else {
                    j = charAt - '0';
                    while (true) {
                        i2 = i4 + 1;
                        c2 = charAt(i4);
                        if (c2 < c6 || c2 > c5) {
                            break;
                        }
                        j = (j * 10) + (c2 - '0');
                        i4 = i2;
                        c5 = '9';
                        c6 = '0';
                    }
                    if (c2 == ',' || c2 == '}') {
                        this.bp = i2 - 1;
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
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = charAt(i5);
                this.matchStat = 3;
                this.token = 16;
                return date;
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
                this.bp = i3;
                this.ch = c4;
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        }
        return (Date) invokeL.objValue;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:52:0x0091 -> B:45:0x0080 */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
        if (r15 != '.') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
        if (r3 >= 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r6 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
        if (r15 == '\"') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0077, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
        r11 = r15;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
        if (r15 == ',') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0088, code lost:
        if (r15 != '}') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008f, code lost:
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r15) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
        r15 = r11 + 1;
        r4 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0098, code lost:
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009a, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009b, code lost:
        r11 = r11 - 1;
        r14.bp = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a0, code lost:
        if (r15 != ',') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a2, code lost:
        r11 = r11 + 1;
        r14.bp = r11;
        r14.ch = charAt(r11);
        r14.matchStat = 3;
        r14.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b0, code lost:
        if (r7 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b3, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b4, code lost:
        if (r15 != '}') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b6, code lost:
        r14.bp = r11;
        r11 = r11 + 1;
        r14.bp = r11;
        r15 = charAt(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bf, code lost:
        if (r15 != ',') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c1, code lost:
        r14.token = 16;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d1, code lost:
        if (r15 != ']') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
        r14.token = 15;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e3, code lost:
        if (r15 != '}') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e5, code lost:
        r14.token = 13;
        r15 = r14.bp + 1;
        r14.bp = r15;
        r14.ch = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f7, code lost:
        if (r15 != 26) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f9, code lost:
        r14.token = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fd, code lost:
        r14.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0105, code lost:
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r15) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0107, code lost:
        r15 = r14.bp + 1;
        r14.bp = r15;
        r15 = charAt(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0111, code lost:
        r14.bp = r1;
        r14.ch = r2;
        r14.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0117, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0118, code lost:
        if (r7 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011b, code lost:
        return -r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0080, code lost:
        r11 = r15;
        r15 = r4;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int scanFieldInt(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048593, this, cArr)) != null) {
            return invokeL.intValue;
        }
        this.matchStat = 0;
        int i2 = this.bp;
        char c2 = this.ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char charAt = charAt(length);
        boolean z = charAt == '\"';
        if (z) {
            charAt = charAt(i3);
            i3++;
        }
        boolean z2 = charAt == '-';
        if (z2) {
            charAt = charAt(i3);
            i3++;
        }
        if (charAt < '0' || charAt > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = charAt - '0';
        while (true) {
            int i5 = i3 + 1;
            char charAt2 = charAt(i3);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            int i6 = i4 * 10;
            if (i6 < i4) {
                this.matchStat = -1;
                return 0;
            }
            i4 = i6 + (charAt2 - '0');
            i3 = i5;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        InterceptResult invokeL;
        boolean z;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cArr)) == null) {
            this.matchStat = 0;
            int i3 = this.bp;
            char c2 = this.ch;
            if (!charArrayCompare(this.text, i3, cArr)) {
                this.matchStat = -2;
                return 0L;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char charAt2 = charAt(length);
            boolean z2 = charAt2 == '\"';
            if (z2) {
                charAt2 = charAt(i4);
                i4++;
            }
            if (charAt2 == '-') {
                z = true;
                charAt2 = charAt(i4);
                i4++;
            } else {
                z = false;
            }
            if (charAt2 >= '0') {
                char c3 = '9';
                if (charAt2 <= '9') {
                    long j = charAt2 - '0';
                    while (true) {
                        i2 = i4 + 1;
                        charAt = charAt(i4);
                        if (charAt < '0' || charAt > c3) {
                            break;
                        }
                        j = (j * 10) + (charAt - '0');
                        i4 = i2;
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
                        int i5 = i2 + 1;
                        char charAt3 = charAt(i2);
                        i2 = i5;
                        charAt = charAt3;
                    }
                    if (charAt == ',' || charAt == '}') {
                        this.bp = i2 - 1;
                    }
                    if (!(j >= 0 || (j == Long.MIN_VALUE && z))) {
                        this.bp = i3;
                        this.ch = c2;
                        this.matchStat = -1;
                        return 0L;
                    }
                    while (charAt != ',') {
                        if (charAt == '}') {
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            char charAt4 = charAt(i6);
                            while (true) {
                                if (charAt4 == ',') {
                                    this.token = 16;
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    this.ch = charAt(i7);
                                    break;
                                } else if (charAt4 == ']') {
                                    this.token = 15;
                                    int i8 = this.bp + 1;
                                    this.bp = i8;
                                    this.ch = charAt(i8);
                                    break;
                                } else if (charAt4 == '}') {
                                    this.token = 13;
                                    int i9 = this.bp + 1;
                                    this.bp = i9;
                                    this.ch = charAt(i9);
                                    break;
                                } else if (charAt4 == 26) {
                                    this.token = 20;
                                    break;
                                } else if (JSONLexerBase.isWhitespace(charAt4)) {
                                    int i10 = this.bp + 1;
                                    this.bp = i10;
                                    charAt4 = charAt(i10);
                                } else {
                                    this.bp = i3;
                                    this.ch = c2;
                                    this.matchStat = -1;
                                    return 0L;
                                }
                            }
                            this.matchStat = 4;
                            return z ? -j : j;
                        } else if (JSONLexerBase.isWhitespace(charAt)) {
                            this.bp = i2;
                            int i11 = i2 + 1;
                            char charAt5 = charAt(i2);
                            i2 = i11;
                            charAt = charAt5;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                    }
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.ch = charAt(i12);
                    this.matchStat = 3;
                    this.token = 16;
                    return z ? -j : j;
                }
            }
            this.bp = i3;
            this.ch = c2;
            this.matchStat = -1;
            return 0L;
        }
        return invokeL.longValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cArr)) == null) {
            this.matchStat = 0;
            int i2 = this.bp;
            char c2 = this.ch;
            while (!charArrayCompare(this.text, this.bp, cArr)) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                    while (JSONLexerBase.isWhitespace(this.ch)) {
                        next();
                    }
                } else {
                    this.matchStat = -2;
                    return stringDefaultValue();
                }
            }
            int length = this.bp + cArr.length;
            int i3 = length + 1;
            char charAt = charAt(length);
            int i4 = 0;
            if (charAt != '\"') {
                while (JSONLexerBase.isWhitespace(charAt)) {
                    i4++;
                    int i5 = i3 + 1;
                    char charAt2 = charAt(i3);
                    i3 = i5;
                    charAt = charAt2;
                }
                if (charAt != '\"') {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int indexOf = indexOf(Typography.quote, i3);
            if (indexOf != -1) {
                String subString = subString(i3, indexOf - i3);
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
                    int length2 = indexOf - (((cArr.length + i8) + 1) + i4);
                    subString = JSONLexerBase.readString(sub_chars(i8 + cArr.length + 1 + i4, length2), length2);
                }
                if ((this.features & Feature.TrimStringFieldValue.mask) != 0) {
                    subString = subString.trim();
                }
                char charAt3 = charAt(indexOf + 1);
                while (charAt3 != ',' && charAt3 != '}') {
                    if (JSONLexerBase.isWhitespace(charAt3)) {
                        indexOf++;
                        charAt3 = charAt(indexOf + 1);
                    } else {
                        this.matchStat = -1;
                        return stringDefaultValue();
                    }
                }
                int i9 = indexOf + 1;
                this.bp = i9;
                this.ch = charAt3;
                if (charAt3 == ',') {
                    int i10 = i9 + 1;
                    this.bp = i10;
                    this.ch = charAt(i10);
                    this.matchStat = 3;
                    return subString;
                }
                int i11 = i9 + 1;
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
                    this.token = 20;
                } else {
                    this.bp = i2;
                    this.ch = c2;
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            }
            throw new JSONException("unclosed str");
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00df, code lost:
        if (r9 != ']') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
        if (r3.size() != 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e7, code lost:
        r2 = r1 + 1;
        r1 = charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f1, code lost:
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        char charAt;
        Collection<String> collection;
        boolean z;
        char charAt2;
        char charAt3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, cArr, cls)) == null) {
            this.matchStat = 0;
            while (true) {
                char c2 = this.ch;
                if (c2 != '\n' && c2 != ' ') {
                    break;
                }
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = i5 >= this.len ? JSONLexer.EOI : this.text.charAt(i5);
            }
            if (!charArrayCompare(this.text, this.bp, cArr)) {
                this.matchStat = -2;
                return null;
            }
            Collection<String> newCollectionByType = newCollectionByType(cls);
            int i6 = this.bp;
            char c3 = this.ch;
            int length = cArr.length + i6;
            int i7 = length + 1;
            int i8 = -1;
            if (charAt(length) == '[') {
                int i9 = i7 + 1;
                char charAt4 = charAt(i7);
                while (true) {
                    if (charAt4 == '\"') {
                        int indexOf = indexOf(Typography.quote, i9);
                        if (indexOf != i8) {
                            String subString = subString(i9, indexOf - i9);
                            if (subString.indexOf(92) != i8) {
                                while (true) {
                                    int i10 = 0;
                                    for (int i11 = indexOf - 1; i11 >= 0 && charAt(i11) == '\\'; i11--) {
                                        i10++;
                                    }
                                    if (i10 % 2 == 0) {
                                        break;
                                    }
                                    indexOf = indexOf(Typography.quote, indexOf + 1);
                                }
                                int i12 = indexOf - i9;
                                subString = JSONLexerBase.readString(sub_chars(i9, i12), i12);
                            }
                            int i13 = indexOf + 1;
                            i4 = i13 + 1;
                            charAt3 = charAt(i13);
                            newCollectionByType.add(subString);
                        } else {
                            throw new JSONException("unclosed str");
                        }
                    } else if (charAt4 != 'n' || !this.text.startsWith("ull", i9)) {
                        break;
                    } else {
                        int i14 = i9 + 3;
                        charAt3 = charAt(i14);
                        newCollectionByType.add(null);
                        i4 = i14 + 1;
                    }
                    if (charAt3 == ',') {
                        charAt4 = charAt(i4);
                        i9 = i4 + 1;
                        i8 = -1;
                    } else if (charAt3 == ']') {
                        i3 = i4 + 1;
                        charAt2 = charAt(i4);
                        while (JSONLexerBase.isWhitespace(charAt2)) {
                            int i15 = i3 + 1;
                            char charAt5 = charAt(i3);
                            i3 = i15;
                            charAt2 = charAt5;
                        }
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
                collection = newCollectionByType;
                charAt = charAt2;
                i2 = 3;
            } else if (this.text.startsWith("ull", i7)) {
                i2 = 3;
                int i16 = i7 + 3;
                i3 = i16 + 1;
                charAt = charAt(i16);
                collection = null;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.bp = i3;
            if (charAt == ',') {
                this.ch = charAt(i3);
                this.matchStat = i2;
                return collection;
            } else if (charAt == '}') {
                char charAt6 = charAt(i3);
                do {
                    if (charAt6 == ',') {
                        this.token = 16;
                        int i17 = this.bp + 1;
                        this.bp = i17;
                        this.ch = charAt(i17);
                    } else if (charAt6 == ']') {
                        this.token = 15;
                        int i18 = this.bp + 1;
                        this.bp = i18;
                        this.ch = charAt(i18);
                    } else if (charAt6 == '}') {
                        this.token = 13;
                        int i19 = this.bp + 1;
                        this.bp = i19;
                        this.ch = charAt(i19);
                    } else if (charAt6 == 26) {
                        this.token = 20;
                        this.ch = charAt6;
                    } else {
                        z = false;
                        while (JSONLexerBase.isWhitespace(charAt6)) {
                            int i20 = i3 + 1;
                            char charAt7 = charAt(i3);
                            this.bp = i20;
                            z = true;
                            charAt6 = charAt7;
                            i3 = i20;
                        }
                    }
                    this.matchStat = 4;
                    return collection;
                } while (z);
                this.matchStat = -1;
                return null;
            } else {
                this.ch = c3;
                this.bp = i6;
                this.matchStat = -1;
                return null;
            }
        }
        return (Collection) invokeLL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048598, this, cArr)) != null) {
            return invokeL.longValue;
        }
        this.matchStat = 0;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (JSONLexerBase.isWhitespace(this.ch)) {
                next();
                while (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                }
            } else {
                this.matchStat = -2;
                return 0L;
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char charAt = charAt(length);
        if (charAt != '\"') {
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = charAt(i2);
                i2++;
            }
            if (charAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
        }
        long j = -3750763034362895579L;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = charAt(i2);
            if (charAt2 == '\"') {
                this.bp = i3;
                char charAt3 = charAt(i3);
                this.ch = charAt3;
                while (charAt3 != ',') {
                    if (charAt3 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == ']') {
                            this.token = 15;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == '}') {
                            this.token = 13;
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            this.ch = charAt(i6);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (JSONLexerBase.isWhitespace(charAt3)) {
                        int i7 = this.bp + 1;
                        this.bp = i7;
                        charAt3 = charAt(i7);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                return j;
            } else if (i3 > this.len) {
                this.matchStat = -1;
                return 0L;
            } else {
                j = (j ^ charAt2) * 1099511628211L;
                i2 = i3;
            }
        }
    }

    public boolean scanISO8601DateIfMatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? scanISO8601DateIfMatch(true) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:81:0x0125 -> B:70:0x00f8 */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r3 != '.') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (r3 == '\"') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
        r3 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        if (r4 >= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009e, code lost:
        if (r3 != r17) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
        r16.bp = r13;
        r16.ch = charAt(r13);
        r16.matchStat = 3;
        r16.token = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
        if (r8 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b0, code lost:
        return -r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b5, code lost:
        if (com.alibaba.fastjson.parser.JSONLexerBase.isWhitespace(r3) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b7, code lost:
        r3 = charAt(r13);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bf, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c1, code lost:
        if (r8 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c4, code lost:
        return -r4;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int scanInt(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Character.valueOf(c2)})) != null) {
            return invokeCommon.intValue;
        }
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char charAt = charAt(i2);
        while (JSONLexerBase.isWhitespace(charAt)) {
            charAt = charAt(i3);
            i3++;
        }
        boolean z = charAt == '\"';
        if (z) {
            charAt = charAt(i3);
            i3++;
        }
        boolean z2 = charAt == '-';
        if (z2) {
            charAt = charAt(i3);
            i3++;
        }
        if (charAt < '0' || charAt > '9') {
            if (charAt == 'n') {
                int i4 = i3 + 1;
                if (charAt(i3) == 'u') {
                    int i5 = i4 + 1;
                    if (charAt(i4) == 'l') {
                        int i6 = i5 + 1;
                        if (charAt(i5) == 'l') {
                            this.matchStat = 5;
                            int i7 = i6 + 1;
                            char charAt2 = charAt(i6);
                            if (z && charAt2 == '\"') {
                                int i8 = i7 + 1;
                                char charAt3 = charAt(i7);
                                i7 = i8;
                                charAt2 = charAt3;
                            }
                            while (charAt2 != ',') {
                                if (charAt2 == ']') {
                                    this.bp = i7;
                                    this.ch = charAt(i7);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0;
                                } else if (JSONLexerBase.isWhitespace(charAt2)) {
                                    int i9 = i7 + 1;
                                    char charAt4 = charAt(i7);
                                    i7 = i9;
                                    charAt2 = charAt4;
                                } else {
                                    this.matchStat = -1;
                                    return 0;
                                }
                            }
                            this.bp = i7;
                            this.ch = charAt(i7);
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
        int i10 = charAt - '0';
        while (true) {
            int i11 = i3 + 1;
            char charAt5 = charAt(i3);
            if (charAt5 < '0' || charAt5 > '9') {
                break;
            }
            int i12 = i10 * 10;
            if (i12 < i10) {
                throw new JSONException("parseInt error : " + subString(i2, i11 - 1));
            }
            i10 = i12 + (charAt5 - '0');
            i3 = i11;
        }
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:77:0x011a -> B:66:0x00e7 */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c2) {
        InterceptResult invokeCommon;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Character.valueOf(c2)})) == null) {
            boolean z = false;
            this.matchStat = 0;
            int i3 = this.bp;
            int i4 = i3 + 1;
            char charAt2 = charAt(i3);
            boolean z2 = charAt2 == '\"';
            if (z2) {
                int i5 = i4 + 1;
                char charAt3 = charAt(i4);
                i4 = i5;
                charAt2 = charAt3;
            }
            boolean z3 = charAt2 == '-';
            if (z3) {
                int i6 = i4 + 1;
                char charAt4 = charAt(i4);
                i4 = i6;
                charAt2 = charAt4;
            }
            char c3 = '0';
            if (charAt2 >= '0' && charAt2 <= '9') {
                long j = charAt2 - '0';
                while (true) {
                    i2 = i4 + 1;
                    charAt = charAt(i4);
                    if (charAt < c3 || charAt > '9') {
                        break;
                    }
                    j = (j * 10) + (charAt - '0');
                    i4 = i2;
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
                    charAt = charAt(i2);
                    i2++;
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
                        charAt = charAt(i2);
                        i2++;
                    } else {
                        this.matchStat = -1;
                        return j;
                    }
                }
                this.bp = i2;
                this.ch = charAt(i2);
                this.matchStat = 3;
                this.token = 16;
                return z3 ? -j : j;
            }
            if (charAt2 == 'n') {
                int i7 = i4 + 1;
                if (charAt(i4) == 'u') {
                    int i8 = i7 + 1;
                    if (charAt(i7) == 'l') {
                        int i9 = i8 + 1;
                        if (charAt(i8) == 'l') {
                            this.matchStat = 5;
                            int i10 = i9 + 1;
                            char charAt5 = charAt(i9);
                            if (z2 && charAt5 == '\"') {
                                int i11 = i10 + 1;
                                char charAt6 = charAt(i10);
                                i10 = i11;
                                charAt5 = charAt6;
                            }
                            while (charAt5 != ',') {
                                if (charAt5 == ']') {
                                    this.bp = i10;
                                    this.ch = charAt(i10);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0L;
                                } else if (JSONLexerBase.isWhitespace(charAt5)) {
                                    int i12 = i10 + 1;
                                    char charAt7 = charAt(i10);
                                    i10 = i12;
                                    charAt5 = charAt7;
                                } else {
                                    this.matchStat = -1;
                                    return 0L;
                                }
                            }
                            this.bp = i10;
                            this.ch = charAt(i10);
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
        return invokeCommon.longValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable symbolTable) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, symbolTable)) == null) {
            if (!this.text.startsWith("\"@type\":\"", this.bp) || (indexOf = this.text.indexOf(34, this.bp + 9)) == -1) {
                return null;
            }
            int i2 = this.bp + 9;
            this.bp = i2;
            int i3 = 0;
            while (i2 < indexOf) {
                i3 = (i3 * 31) + this.text.charAt(i2);
                i2++;
            }
            int i4 = this.bp;
            String addSymbol = addSymbol(i4, indexOf - i4, i3, symbolTable);
            char charAt = this.text.charAt(indexOf + 1);
            if (charAt == ',' || charAt == ']') {
                int i5 = indexOf + 2;
                this.bp = i5;
                this.ch = this.text.charAt(i5);
                return addSymbol;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048604, this, i2)) != null) {
            return invokeI.booleanValue;
        }
        if (i2 >= 0) {
            int i3 = this.token;
            if (i3 == 20) {
                return false;
            }
            if (i3 != 14) {
                throw new UnsupportedOperationException();
            }
            int i4 = 0;
            while (true) {
                boolean z = true;
                if (i4 < i2) {
                    skipWhitespace();
                    char c2 = this.ch;
                    if (c2 != '\"' && c2 != '\'') {
                        if (c2 == '{') {
                            next();
                            this.token = 12;
                            skipObject(false);
                        } else if (c2 == '[') {
                            next();
                            this.token = 14;
                            skipArray(false);
                        } else {
                            int i5 = this.bp + 1;
                            while (true) {
                                if (i5 >= this.text.length()) {
                                    z = false;
                                    break;
                                }
                                char charAt = this.text.charAt(i5);
                                if (charAt == ',') {
                                    int i6 = i5 + 1;
                                    this.bp = i6;
                                    this.ch = charAt(i6);
                                    break;
                                } else if (charAt == ']') {
                                    int i7 = i5 + 1;
                                    this.bp = i7;
                                    this.ch = charAt(i7);
                                    nextToken();
                                    return false;
                                } else {
                                    i5++;
                                }
                            }
                            if (!z) {
                                throw new JSONException("illegal json.");
                            }
                        }
                        int i8 = this.token;
                        if (i8 != 16) {
                            if (i8 == 15) {
                                return false;
                            }
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        skipString();
                        char c3 = this.ch;
                        if (c3 != ',') {
                            if (c3 == ']') {
                                next();
                                nextToken(16);
                                return false;
                            }
                            throw new JSONException("illegal json.");
                        }
                        next();
                    }
                    i4++;
                } else {
                    nextToken();
                    return true;
                }
            }
        } else {
            throw new IllegalArgumentException("index must > 0, but " + i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x018f, code lost:
        if (r10 == '1') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0193, code lost:
        if (r10 == '2') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0197, code lost:
        if (r10 == '3') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x019b, code lost:
        if (r10 == '4') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x019f, code lost:
        if (r10 == '5') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a3, code lost:
        if (r10 == '6') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a7, code lost:
        if (r10 == '7') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ab, code lost:
        if (r10 == '8') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01ad, code lost:
        if (r10 == '9') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01af, code lost:
        if (r10 == '+') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01b1, code lost:
        if (r10 == '-') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01b3, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01b6, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01ba, code lost:
        if (r1 == '-') goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01bc, code lost:
        if (r1 == '+') goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01be, code lost:
        if (r1 < '0') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01c0, code lost:
        if (r1 > '9') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01c4, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01c6, code lost:
        if (r1 != '\"') goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01c8, code lost:
        skipString();
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01cd, code lost:
        if (r1 == ',') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01cf, code lost:
        if (r1 == '}') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01d1, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01d6, code lost:
        if (r17.ch != ',') goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01d8, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01e1, code lost:
        if (r1 != 't') goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01e3, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01ea, code lost:
        if (r17.ch != 'r') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01ec, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01f1, code lost:
        if (r17.ch != 'u') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01f3, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01f8, code lost:
        if (r17.ch != 'e') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01fa, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01fd, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01ff, code lost:
        if (r1 == ',') goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0201, code lost:
        if (r1 == '}') goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0203, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0208, code lost:
        if (r17.ch != ',') goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x020a, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0213, code lost:
        if (r1 != 'n') goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0215, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x021a, code lost:
        if (r17.ch != 'u') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x021c, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0221, code lost:
        if (r17.ch != 'l') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0223, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0228, code lost:
        if (r17.ch != 'l') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x022a, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x022d, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x022f, code lost:
        if (r1 == ',') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0231, code lost:
        if (r1 == '}') goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0233, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0238, code lost:
        if (r17.ch != ',') goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x023a, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0241, code lost:
        if (r1 != 'f') goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0243, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x024a, code lost:
        if (r17.ch != 'a') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x024c, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0251, code lost:
        if (r17.ch != 'l') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0253, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x025a, code lost:
        if (r17.ch != 's') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x025c, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0261, code lost:
        if (r17.ch != 'e') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0263, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0266, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0268, code lost:
        if (r1 == ',') goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x026a, code lost:
        if (r1 == '}') goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x026c, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0271, code lost:
        if (r17.ch != ',') goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0273, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0278, code lost:
        if (r1 != '{') goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x027a, code lost:
        r1 = r17.bp + 1;
        r17.bp = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0285, code lost:
        if (r1 < r17.text.length()) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0287, code lost:
        r8 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x028a, code lost:
        r8 = r17.text.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0290, code lost:
        r17.ch = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0292, code lost:
        if (r20 == false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0294, code lost:
        r17.token = 12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0296, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0297, code lost:
        skipObject(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x029c, code lost:
        if (r17.token != 13) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x029e, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x02a1, code lost:
        if (r1 != '[') goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02a3, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x02a6, code lost:
        if (r20 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02a8, code lost:
        r17.token = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x02ad, code lost:
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x02ae, code lost:
        skipArray(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02b3, code lost:
        if (r17.token != 13) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x02b5, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02bb, code lost:
        throw new java.lang.UnsupportedOperationException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x02bc, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02bf, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02c1, code lost:
        if (r1 < '0') goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x02c3, code lost:
        if (r1 > '9') goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02c5, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x02cd, code lost:
        if (r17.ch != '.') goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x02cf, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x02d2, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02d4, code lost:
        if (r1 < '0') goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02d6, code lost:
        if (r1 > '9') goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02d8, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02dc, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02e0, code lost:
        if (r1 == 'E') goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02e2, code lost:
        if (r1 != 'e') goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x02e4, code lost:
        next();
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x02e9, code lost:
        if (r1 == '-') goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02eb, code lost:
        if (r1 != '+') goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x02ed, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02f0, code lost:
        r1 = r17.ch;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02f2, code lost:
        if (r1 < '0') goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x02f4, code lost:
        if (r1 > '9') goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02f6, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x02fc, code lost:
        if (r17.ch == ',') goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02fe, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0303, code lost:
        if (r17.ch != ',') goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0305, code lost:
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0329, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal json, " + info());
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:?, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:?, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:?, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:?, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:?, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c5, code lost:
        if (r10 != r18) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
        if (r17.ch == ':') goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d0, code lost:
        if (r17.ch != ':') goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
        r6 = r17.bp + 1;
        r17.bp = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00dd, code lost:
        if (r6 < r17.text.length()) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00df, code lost:
        r6 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e2, code lost:
        r6 = r17.text.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e8, code lost:
        r17.ch = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ea, code lost:
        if (r6 != ',') goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ec, code lost:
        r1 = r17.bp + 1;
        r17.bp = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f7, code lost:
        if (r1 < r17.text.length()) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f9, code lost:
        r8 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fc, code lost:
        r8 = r17.text.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0102, code lost:
        r17.ch = r8;
        r17.token = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0109, code lost:
        if (r6 != ']') goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010b, code lost:
        r1 = r17.bp + 1;
        r17.bp = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0116, code lost:
        if (r1 < r17.text.length()) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0118, code lost:
        r8 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x011b, code lost:
        r8 = r17.text.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0121, code lost:
        r17.ch = r8;
        r17.token = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0126, code lost:
        if (r6 != '}') goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0128, code lost:
        r1 = r17.bp + 1;
        r17.bp = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0133, code lost:
        if (r1 < r17.text.length()) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0135, code lost:
        r8 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0138, code lost:
        r8 = r17.text.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x013e, code lost:
        r17.ch = r8;
        r17.token = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0143, code lost:
        if (r6 < '0') goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0145, code lost:
        if (r6 > '9') goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0147, code lost:
        r17.sp = 0;
        r17.pos = r17.bp;
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0151, code lost:
        nextToken(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0154, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0158, code lost:
        if (r17.ch == ':') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015a, code lost:
        skipWhitespace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x015f, code lost:
        if (r17.ch != ':') goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0161, code lost:
        r10 = r17.bp + 1;
        r17.bp = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x016c, code lost:
        if (r10 < r17.text.length()) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x016e, code lost:
        r10 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0171, code lost:
        r10 = r17.text.charAt(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0177, code lost:
        r17.ch = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0181, code lost:
        if (r10 == '\"') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0185, code lost:
        if (r10 == '\'') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0187, code lost:
        if (r10 == '{') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0189, code lost:
        if (r10 == '[') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x018b, code lost:
        if (r10 == '0') goto L81;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int seekObjectToField(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            int i2 = this.token;
            int i3 = -1;
            if (i2 == 20) {
                return -1;
            }
            if (i2 != 13) {
                int i4 = 15;
                if (i2 != 15) {
                    int i5 = 16;
                    if (i2 != 12 && i2 != 16) {
                        throw new UnsupportedOperationException(JSONToken.name(this.token));
                    }
                    while (true) {
                        char c2 = this.ch;
                        if (c2 == '}') {
                            next();
                            nextToken();
                            return i3;
                        } else if (c2 == 26) {
                            return i3;
                        } else {
                            if (c2 != '\"') {
                                skipWhitespace();
                            }
                            if (this.ch == '\"') {
                                long j2 = -3750763034362895579L;
                                int i6 = this.bp + 1;
                                while (true) {
                                    if (i6 >= this.text.length()) {
                                        break;
                                    }
                                    char charAt = this.text.charAt(i6);
                                    if (charAt == '\\') {
                                        i6++;
                                        if (i6 != this.text.length()) {
                                            charAt = this.text.charAt(i6);
                                        } else {
                                            throw new JSONException("unclosed str, " + info());
                                        }
                                    }
                                    if (charAt == '\"') {
                                        int i7 = i6 + 1;
                                        this.bp = i7;
                                        this.ch = i7 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.bp);
                                    } else {
                                        j2 = (j2 ^ charAt) * 1099511628211L;
                                        i6++;
                                    }
                                }
                            } else {
                                throw new UnsupportedOperationException();
                            }
                        }
                        i3 = -1;
                        i4 = 15;
                        i5 = 16;
                    }
                }
            }
            nextToken();
            return -1;
        }
        return invokeCommon.intValue;
    }

    public void setTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5), Character.valueOf(c6), Character.valueOf(c7)}) == null) {
            this.calendar.set(11, ((c2 - '0') * 10) + (c3 - '0'));
            this.calendar.set(12, ((c4 - '0') * 10) + (c5 - '0'));
            this.calendar.set(13, ((c6 - '0') * 10) + (c7 - '0'));
        }
    }

    public void setTimeZone(char c2, char c3, char c4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4)}) == null) {
            setTimeZone(c2, c3, c4, '0', '0');
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            skipArray(false);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            skipObject(false);
        }
    }

    public final void skipString() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048614, this) != null) {
            return;
        }
        if (this.ch == '\"') {
            int i2 = this.bp;
            while (true) {
                i2++;
                if (i2 < this.text.length()) {
                    char charAt = this.text.charAt(i2);
                    if (charAt == '\\') {
                        if (i2 < this.len - 1) {
                            i2++;
                        }
                    } else if (charAt == '\"') {
                        String str = this.text;
                        int i3 = i2 + 1;
                        this.bp = i3;
                        this.ch = str.charAt(i3);
                        return;
                    }
                } else {
                    throw new JSONException("unclosed str");
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (!this.hasSpecial) {
                return subString(this.np + 1, this.sp);
            }
            return new String(this.sbuf, 0, this.sp);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048616, this, i2, i3)) == null) {
            if (ASMUtils.IS_ANDROID) {
                char[] cArr = this.sbuf;
                if (i3 < cArr.length) {
                    this.text.getChars(i2, i2 + i3, cArr, 0);
                    return new String(this.sbuf, 0, i3);
                }
                char[] cArr2 = new char[i3];
                this.text.getChars(i2, i3 + i2, cArr2, 0);
                return new String(cArr2);
            }
            return this.text.substring(i2, i3 + i2);
        }
        return (String) invokeII.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048617, this, i2, i3)) == null) {
            if (ASMUtils.IS_ANDROID) {
                char[] cArr = this.sbuf;
                if (i3 < cArr.length) {
                    this.text.getChars(i2, i3 + i2, cArr, 0);
                    return this.sbuf;
                }
            }
            char[] cArr2 = new char[i3];
            this.text.getChars(i2, i3 + i2, cArr2, 0);
            return cArr2;
        }
        return (char[]) invokeII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONScanner(String str, int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) ? scanISO8601DateIfMatch(z, this.len - this.bp) : invokeZ.booleanValue;
    }

    public void setTimeZone(char c2, char c3, char c4, char c5, char c6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5), Character.valueOf(c6)}) == null) {
            int i2 = ((((c3 - '0') * 10) + (c4 - '0')) * 3600 * 1000) + ((((c5 - '0') * 10) + (c6 - '0')) * 60 * 1000);
            if (c2 == '-') {
                i2 = -i2;
            }
            if (this.calendar.getTimeZone().getRawOffset() != i2) {
                this.calendar.setTimeZone(new SimpleTimeZone(i2, Integer.toString(i2)));
            }
        }
    }

    public final void skipArray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            int i2 = this.bp;
            boolean z2 = false;
            int i3 = 0;
            while (i2 < this.text.length()) {
                char charAt = this.text.charAt(i2);
                if (charAt == '\\') {
                    if (i2 >= this.len - 1) {
                        this.ch = charAt;
                        this.bp = i2;
                        throw new JSONException("illegal str, " + info());
                    }
                    i2++;
                } else if (charAt == '\"') {
                    z2 = !z2;
                } else if (charAt != '[') {
                    char c2 = JSONLexer.EOI;
                    if (charAt == '{' && z) {
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        if (i4 < this.text.length()) {
                            c2 = this.text.charAt(i4);
                        }
                        this.ch = c2;
                        skipObject(z);
                    } else if (charAt == ']' && !z2 && i3 - 1 == -1) {
                        int i5 = i2 + 1;
                        this.bp = i5;
                        if (i5 == this.text.length()) {
                            this.ch = JSONLexer.EOI;
                            this.token = 20;
                            return;
                        }
                        this.ch = this.text.charAt(this.bp);
                        nextToken(16);
                        return;
                    }
                } else if (!z2) {
                    i3++;
                }
                i2++;
            }
            if (i2 != this.text.length()) {
                return;
            }
            throw new JSONException("illegal str, " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            int i2 = this.bp;
            boolean z2 = false;
            int i3 = 0;
            while (i2 < this.text.length()) {
                char charAt = this.text.charAt(i2);
                if (charAt == '\\') {
                    if (i2 >= this.len - 1) {
                        this.ch = charAt;
                        this.bp = i2;
                        throw new JSONException("illegal str, " + info());
                    }
                    i2++;
                } else if (charAt == '\"') {
                    z2 = !z2;
                } else if (charAt == '{') {
                    if (!z2) {
                        i3++;
                    }
                } else if (charAt == '}' && !z2 && i3 - 1 == -1) {
                    int i4 = i2 + 1;
                    this.bp = i4;
                    int length = this.text.length();
                    char c2 = JSONLexer.EOI;
                    if (i4 == length) {
                        this.ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    }
                    char charAt2 = this.text.charAt(this.bp);
                    this.ch = charAt2;
                    if (charAt2 == ',') {
                        this.token = 16;
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        if (i5 < this.text.length()) {
                            c2 = this.text.charAt(i5);
                        }
                        this.ch = c2;
                        return;
                    } else if (charAt2 == '}') {
                        this.token = 13;
                        next();
                        return;
                    } else if (charAt2 == ']') {
                        this.token = 15;
                        next();
                        return;
                    } else {
                        nextToken(16);
                        return;
                    }
                }
                i2++;
            }
            for (int i6 = 0; i6 < this.bp; i6++) {
                if (i6 < this.text.length() && this.text.charAt(i6) == ' ') {
                    i2++;
                }
            }
            if (i2 != this.text.length()) {
                return;
            }
            throw new JSONException("illegal str, " + info());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0214 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean scanISO8601DateIfMatch(boolean z, int i2) {
        InterceptResult invokeCommon;
        char charAt;
        char c2;
        char c3;
        char c4;
        int i3;
        int i4;
        int i5;
        int i6;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        int i7;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        int i8;
        char c16;
        char c17;
        int i9;
        char charAt2;
        char c18;
        char charAt3;
        int i10;
        char charAt4;
        char charAt5;
        char charAt6;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) != null) {
            return invokeCommon.booleanValue;
        }
        if (i2 < 8) {
            return false;
        }
        char charAt7 = charAt(this.bp);
        char charAt8 = charAt(this.bp + 1);
        char charAt9 = charAt(this.bp + 2);
        int i11 = 3;
        char charAt10 = charAt(this.bp + 3);
        char charAt11 = charAt(this.bp + 4);
        char charAt12 = charAt(this.bp + 5);
        char charAt13 = charAt(this.bp + 6);
        char charAt14 = charAt(this.bp + 7);
        if (!z) {
            if (i2 > 13) {
                char charAt15 = charAt((this.bp + i2) - 1);
                char charAt16 = charAt((this.bp + i2) - 2);
                if (charAt7 == '/' && charAt8 == 'D' && charAt9 == 'a' && charAt10 == 't' && charAt11 == 'e' && charAt12 == '(' && charAt15 == '/' && charAt16 == ')') {
                    int i12 = -1;
                    for (int i13 = 6; i13 < i2; i13++) {
                        char charAt17 = charAt(this.bp + i13);
                        if (charAt17 != '+') {
                            if (charAt17 < '0' || charAt17 > '9') {
                                break;
                            }
                        } else {
                            i12 = i13;
                        }
                    }
                    if (i12 == -1) {
                        return false;
                    }
                    int i14 = this.bp;
                    int i15 = i14 + 6;
                    long parseLong = Long.parseLong(subString(i15, (i14 + i12) - i15));
                    Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                    this.calendar = calendar;
                    calendar.setTimeInMillis(parseLong);
                    this.token = 5;
                    return true;
                }
            }
        }
        if (i2 == 8 || i2 == 14 || ((i2 == 16 && ((charAt6 = charAt(this.bp + 10)) == 'T' || charAt6 == ' ')) || (i2 == 17 && charAt(this.bp + 6) != '-'))) {
            if (z) {
                return false;
            }
            char charAt18 = charAt(this.bp + 8);
            boolean z2 = charAt11 == '-' && charAt14 == '-';
            boolean z3 = z2 && i2 == 16;
            boolean z4 = z2 && i2 == 17;
            if (z4 || z3) {
                charAt = charAt(this.bp + 9);
                c2 = charAt12;
                c3 = charAt13;
                c4 = charAt18;
            } else if (charAt11 == '-' && charAt13 == '-') {
                c3 = charAt12;
                charAt = charAt14;
                c2 = '0';
                c4 = '0';
            } else {
                c2 = charAt11;
                c3 = charAt12;
                c4 = charAt13;
                charAt = charAt14;
            }
            if (checkDate(charAt7, charAt8, charAt9, charAt10, c2, c3, c4, charAt)) {
                setCalendar(charAt7, charAt8, charAt9, charAt10, c2, c3, c4, charAt);
                if (i2 != 8) {
                    char charAt19 = charAt(this.bp + 9);
                    char charAt20 = charAt(this.bp + 10);
                    char charAt21 = charAt(this.bp + 11);
                    char charAt22 = charAt(this.bp + 12);
                    char charAt23 = charAt(this.bp + 13);
                    if ((z4 && charAt20 == 'T' && charAt23 == ':' && charAt(this.bp + 16) == 'Z') || (z3 && ((charAt20 == ' ' || charAt20 == 'T') && charAt23 == ':'))) {
                        char charAt24 = charAt(this.bp + 14);
                        c7 = charAt(this.bp + 15);
                        c6 = charAt24;
                        c9 = charAt21;
                        c5 = charAt22;
                        c8 = '0';
                        c10 = '0';
                    } else {
                        c5 = charAt19;
                        c6 = charAt20;
                        c7 = charAt21;
                        c8 = charAt22;
                        c9 = charAt18;
                        c10 = charAt23;
                    }
                    if (!checkTime(c9, c5, c6, c7, c8, c10)) {
                        return false;
                    }
                    if (i2 != 17 || z4) {
                        i7 = 0;
                    } else {
                        char charAt25 = charAt(this.bp + 14);
                        char charAt26 = charAt(this.bp + 15);
                        char charAt27 = charAt(this.bp + 16);
                        if (charAt25 < '0' || charAt25 > '9' || charAt26 < '0' || charAt26 > '9' || charAt27 < '0' || charAt27 > '9') {
                            return false;
                        }
                        i7 = ((charAt25 - '0') * 100) + ((charAt26 - '0') * 10) + (charAt27 - '0');
                    }
                    i4 = (c10 - '0') + ((c8 - '0') * 10);
                    i6 = ((c9 - '0') * 10) + (c5 - '0');
                    i5 = i7;
                    i3 = ((c6 - '0') * 10) + (c7 - '0');
                } else {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                }
                this.calendar.set(11, i6);
                this.calendar.set(12, i3);
                this.calendar.set(13, i4);
                this.calendar.set(14, i5);
                this.token = 5;
                return true;
            }
            return false;
        } else if (i2 < 9) {
            return false;
        } else {
            char charAt28 = charAt(this.bp + 8);
            char charAt29 = charAt(this.bp + 9);
            if ((charAt11 != '-' || charAt14 != '-') && (charAt11 != '/' || charAt14 != '/')) {
                if (charAt11 == '-' && charAt13 == '-') {
                    if (charAt28 == ' ') {
                        c16 = charAt9;
                        c17 = charAt12;
                        c13 = charAt7;
                        c14 = charAt8;
                        c11 = '0';
                        i8 = 8;
                        charAt8 = charAt14;
                        c12 = charAt10;
                        c15 = '0';
                    } else {
                        c16 = charAt9;
                        c13 = charAt7;
                        c11 = '0';
                        i8 = 9;
                        c17 = charAt12;
                        c14 = charAt8;
                        charAt8 = charAt28;
                        c15 = charAt14;
                        c12 = charAt10;
                    }
                } else if ((charAt9 == '.' && charAt12 == '.') || (charAt9 == '-' && charAt12 == '-')) {
                    c14 = charAt14;
                    c12 = charAt29;
                    c11 = charAt10;
                    c15 = charAt7;
                    i8 = 10;
                    c17 = charAt11;
                    c13 = charAt13;
                    c16 = charAt28;
                } else if (charAt28 == 'T') {
                    c11 = charAt11;
                    c17 = charAt12;
                    c13 = charAt7;
                    c14 = charAt8;
                    i8 = 8;
                    charAt8 = charAt14;
                    c12 = charAt10;
                    c15 = charAt13;
                    c16 = charAt9;
                } else if (charAt11 != 24180 && charAt11 != 45380) {
                    return false;
                } else {
                    if (charAt14 == 26376 || charAt14 == 50900) {
                        if (charAt29 == 26085 || charAt29 == 51068) {
                            c11 = charAt12;
                            c12 = charAt10;
                            c13 = charAt7;
                            c14 = charAt8;
                            c15 = '0';
                            i8 = 10;
                            charAt8 = charAt28;
                            c17 = charAt13;
                            c16 = charAt9;
                        } else if (charAt(this.bp + 10) != 26085 && charAt(this.bp + 10) != 51068) {
                            return false;
                        } else {
                            c12 = charAt10;
                            c13 = charAt7;
                            i8 = 11;
                            c15 = charAt28;
                            c17 = charAt13;
                            c16 = charAt9;
                            c11 = charAt12;
                            c14 = charAt8;
                            charAt8 = charAt29;
                        }
                    } else if (charAt13 != 26376 && charAt13 != 50900) {
                        return false;
                    } else {
                        if (charAt28 == 26085 || charAt28 == 51068) {
                            c16 = charAt9;
                            c17 = charAt12;
                            c13 = charAt7;
                            c14 = charAt8;
                            c11 = '0';
                            i8 = 10;
                            charAt8 = charAt14;
                            c12 = charAt10;
                            c15 = '0';
                        } else if (charAt29 != 26085 && charAt29 != 51068) {
                            return false;
                        } else {
                            c16 = charAt9;
                            c13 = charAt7;
                            c11 = '0';
                            i8 = 10;
                            c17 = charAt12;
                            c14 = charAt8;
                            charAt8 = charAt28;
                            c15 = charAt14;
                            c12 = charAt10;
                        }
                    }
                }
                if (checkDate(c13, c14, c16, c12, c11, c17, c15, charAt8)) {
                    setCalendar(c13, c14, c16, c12, c11, c17, c15, charAt8);
                    char charAt30 = charAt(this.bp + i8);
                    char c19 = 'T';
                    if (charAt30 == 'T') {
                        if (i2 == 16 && i8 == 8 && charAt(this.bp + 15) == 'Z') {
                            char charAt31 = charAt(this.bp + i8 + 1);
                            char charAt32 = charAt(this.bp + i8 + 2);
                            char charAt33 = charAt(this.bp + i8 + 3);
                            char charAt34 = charAt(this.bp + i8 + 4);
                            char charAt35 = charAt(this.bp + i8 + 5);
                            char charAt36 = charAt(this.bp + i8 + 6);
                            if (checkTime(charAt31, charAt32, charAt33, charAt34, charAt35, charAt36)) {
                                setTime(charAt31, charAt32, charAt33, charAt34, charAt35, charAt36);
                                this.calendar.set(14, 0);
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs = TimeZone.getAvailableIDs(0);
                                    if (availableIDs.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                this.token = 5;
                                return true;
                            }
                            return false;
                        }
                        c19 = 'T';
                    }
                    if (charAt30 != c19 && (charAt30 != ' ' || z)) {
                        if (charAt30 != '\"' && charAt30 != 26 && charAt30 != 26085 && charAt30 != 51068) {
                            if ((charAt30 == '+' || charAt30 == '-') && this.len == i8 + 6 && charAt(this.bp + i8 + 3) == ':' && charAt(this.bp + i8 + 4) == '0' && charAt(this.bp + i8 + 5) == '0') {
                                setTime('0', '0', '0', '0', '0', '0');
                                this.calendar.set(14, 0);
                                setTimeZone(charAt30, charAt(this.bp + i8 + 1), charAt(this.bp + i8 + 2));
                                return true;
                            }
                            return false;
                        }
                        this.calendar.set(11, 0);
                        this.calendar.set(12, 0);
                        this.calendar.set(13, 0);
                        this.calendar.set(14, 0);
                        int i16 = this.bp + i8;
                        this.bp = i16;
                        this.ch = charAt(i16);
                        this.token = 5;
                        return true;
                    } else if (i2 >= i8 + 9 && charAt(this.bp + i8 + 3) == ':' && charAt(this.bp + i8 + 6) == ':') {
                        char charAt37 = charAt(this.bp + i8 + 1);
                        char charAt38 = charAt(this.bp + i8 + 2);
                        char charAt39 = charAt(this.bp + i8 + 4);
                        char charAt40 = charAt(this.bp + i8 + 5);
                        char charAt41 = charAt(this.bp + i8 + 7);
                        char charAt42 = charAt(this.bp + i8 + 8);
                        if (checkTime(charAt37, charAt38, charAt39, charAt40, charAt41, charAt42)) {
                            setTime(charAt37, charAt38, charAt39, charAt40, charAt41, charAt42);
                            int i17 = -1;
                            if (charAt(this.bp + i8 + 9) == '.') {
                                int i18 = i8 + 11;
                                if (i2 < i18 || (charAt3 = charAt(this.bp + i8 + 10)) < '0' || charAt3 > '9') {
                                    return false;
                                }
                                int i19 = charAt3 - '0';
                                if (i2 <= i18 || (charAt5 = charAt(this.bp + i8 + 11)) < '0' || charAt5 > '9') {
                                    i10 = 1;
                                } else {
                                    i19 = (i19 * 10) + (charAt5 - '0');
                                    i10 = 2;
                                }
                                if (i10 != 2 || (charAt4 = charAt(this.bp + i8 + 12)) < '0' || charAt4 > '9') {
                                    i9 = i19;
                                    i17 = i10;
                                } else {
                                    i9 = (charAt4 - '0') + (i19 * 10);
                                    i17 = 3;
                                }
                            } else {
                                i9 = 0;
                            }
                            this.calendar.set(14, i9);
                            char charAt43 = charAt(this.bp + i8 + 10 + i17);
                            if (charAt43 == ' ') {
                                i17++;
                                charAt43 = charAt(this.bp + i8 + 10 + i17);
                            }
                            int i20 = i17;
                            char c20 = charAt43;
                            if (c20 == '+' || c20 == '-') {
                                char charAt44 = charAt(this.bp + i8 + 10 + i20 + 1);
                                if (charAt44 < '0' || charAt44 > '1' || (charAt2 = charAt(this.bp + i8 + 10 + i20 + 2)) < '0' || charAt2 > '9') {
                                    return false;
                                }
                                char charAt45 = charAt(this.bp + i8 + 10 + i20 + 3);
                                char c21 = '3';
                                if (charAt45 == ':') {
                                    char charAt46 = charAt(this.bp + i8 + 10 + i20 + 4);
                                    c18 = charAt(this.bp + i8 + 10 + i20 + 5);
                                    if (charAt46 == '4' && c18 == '5') {
                                        if (charAt44 != '1' || (charAt2 != '2' && charAt2 != '3')) {
                                            if (charAt44 != '0') {
                                                return false;
                                            }
                                            if (charAt2 != '5' && charAt2 != '8') {
                                                return false;
                                            }
                                        }
                                    } else if ((charAt46 != '0' && charAt46 != '3') || c18 != '0') {
                                        return false;
                                    }
                                    c21 = charAt46;
                                    i11 = 6;
                                } else {
                                    if (charAt45 == '0') {
                                        char charAt47 = charAt(this.bp + i8 + 10 + i20 + 4);
                                        if (charAt47 != '0' && charAt47 != '3') {
                                            return false;
                                        }
                                        c21 = charAt47;
                                    } else if (charAt45 != '3' || charAt(this.bp + i8 + 10 + i20 + 4) != '0') {
                                        if (charAt45 == '4' && charAt(this.bp + i8 + 10 + i20 + 4) == '5') {
                                            c21 = '4';
                                            c18 = '5';
                                            i11 = 5;
                                        } else {
                                            c21 = '0';
                                            c18 = '0';
                                        }
                                    }
                                    c18 = '0';
                                    i11 = 5;
                                }
                                setTimeZone(c20, charAt44, charAt2, c21, c18);
                            } else if (c20 == 'Z') {
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                    if (availableIDs2.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                    }
                                }
                                i11 = 1;
                            } else {
                                i11 = 0;
                            }
                            int i21 = i8 + 10 + i20 + i11;
                            char charAt48 = charAt(this.bp + i21);
                            if (charAt48 == 26 || charAt48 == '\"') {
                                int i22 = this.bp + i21;
                                this.bp = i22;
                                this.ch = charAt(i22);
                                this.token = 5;
                                return true;
                            }
                            return false;
                        }
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            } else if (charAt29 == ' ') {
                c11 = charAt12;
                c12 = charAt10;
                c13 = charAt7;
                c14 = charAt8;
                c15 = '0';
                i8 = 9;
                charAt8 = charAt28;
                c17 = charAt13;
                c16 = charAt9;
                if (checkDate(c13, c14, c16, c12, c11, c17, c15, charAt8)) {
                }
            } else {
                c12 = charAt10;
                c13 = charAt7;
                i8 = 10;
                c15 = charAt28;
                c17 = charAt13;
                c16 = charAt9;
                c11 = charAt12;
                c14 = charAt8;
                charAt8 = charAt29;
                if (checkDate(c13, c14, c16, c12, c11, c17, c15, charAt8)) {
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cArr)) == null) ? charArrayCompare(this.text, this.bp, cArr) : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONScanner(char[] cArr, int i2) {
        this(cArr, i2, JSON.DEFAULT_PARSER_FEATURE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((char[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONScanner(char[] cArr, int i2, int i3) {
        this(new String(cArr, 0, i2), i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i2, SymbolTable symbolTable) {
        InterceptResult invokeLIL;
        int i3;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(1048597, this, cArr, i2, symbolTable)) != null) {
            return (String[]) invokeLIL.objValue;
        }
        int i4 = this.bp;
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
            int i5 = length + 1;
            char charAt = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(charAt)) {
                charAt = this.text.charAt(i5);
                i5++;
            }
            if (charAt == ':') {
                i3 = i5 + 1;
                c2 = this.text.charAt(i5);
                while (JSONLexerBase.isWhitespace(c2)) {
                    c2 = this.text.charAt(i3);
                    i3++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i3 = this.bp + 1;
            c2 = this.ch;
        }
        if (c2 == '[') {
            this.bp = i3;
            this.ch = this.text.charAt(i3);
            String[] strArr = i2 >= 0 ? new String[i2] : new String[4];
            int i6 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.ch)) {
                    next();
                } else if (this.ch != '\"') {
                    this.bp = i4;
                    this.ch = c3;
                    this.matchStat = -1;
                    return null;
                } else {
                    String scanSymbol = scanSymbol(symbolTable, Typography.quote);
                    if (i6 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i7 = i6 + 1;
                    strArr[i6] = scanSymbol;
                    while (JSONLexerBase.isWhitespace(this.ch)) {
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
                        while (JSONLexerBase.isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i4;
                        this.ch = c3;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else if (c2 == 'n' && this.text.startsWith("ull", this.bp + 1)) {
            int i8 = this.bp + 4;
            this.bp = i8;
            this.ch = this.text.charAt(i8);
            return null;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048606, this, jArr)) != null) {
            return invokeL.intValue;
        }
        int i2 = this.token;
        if (i2 != 12 && i2 != 16) {
            throw new UnsupportedOperationException();
        }
        while (true) {
            char c2 = this.ch;
            if (c2 == '}') {
                next();
                nextToken();
                this.matchStat = -1;
                return -1;
            }
            char c3 = JSONLexer.EOI;
            if (c2 == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (c2 != '\"') {
                skipWhitespace();
            }
            if (this.ch == '\"') {
                long j = -3750763034362895579L;
                int i3 = this.bp;
                while (true) {
                    i3++;
                    if (i3 >= this.text.length()) {
                        break;
                    }
                    char charAt = this.text.charAt(i3);
                    if (charAt == '\\') {
                        i3++;
                        if (i3 != this.text.length()) {
                            charAt = this.text.charAt(i3);
                        } else {
                            throw new JSONException("unclosed str, " + info());
                        }
                    }
                    if (charAt == '\"') {
                        int i4 = i3 + 1;
                        this.bp = i4;
                        this.ch = i4 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.bp);
                    } else {
                        j = (j ^ charAt) * 1099511628211L;
                    }
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= jArr.length) {
                        i5 = -1;
                        break;
                    } else if (j == jArr[i5]) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 != -1) {
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        char charAt2 = i6 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i6);
                        this.ch = charAt2;
                        if (charAt2 == ',') {
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            if (i7 < this.text.length()) {
                                c3 = this.text.charAt(i7);
                            }
                            this.ch = c3;
                            this.token = 16;
                        } else if (charAt2 == ']') {
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            if (i8 < this.text.length()) {
                                c3 = this.text.charAt(i8);
                            }
                            this.ch = c3;
                            this.token = 15;
                        } else if (charAt2 == '}') {
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            if (i9 < this.text.length()) {
                                c3 = this.text.charAt(i9);
                            }
                            this.ch = c3;
                            this.token = 13;
                        } else if (charAt2 >= '0' && charAt2 <= '9') {
                            this.sp = 0;
                            this.pos = this.bp;
                            scanNumber();
                        } else {
                            nextToken(2);
                        }
                    }
                    this.matchStat = 3;
                    return i5;
                }
                if (this.ch != ':') {
                    skipWhitespace();
                }
                if (this.ch == ':') {
                    int i10 = this.bp + 1;
                    this.bp = i10;
                    char charAt3 = i10 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i10);
                    this.ch = charAt3;
                    if (charAt3 != '\"' && charAt3 != '\'' && charAt3 != '{' && charAt3 != '[' && charAt3 != '0' && charAt3 != '1' && charAt3 != '2' && charAt3 != '3' && charAt3 != '4' && charAt3 != '5' && charAt3 != '6' && charAt3 != '7' && charAt3 != '8' && charAt3 != '9' && charAt3 != '+' && charAt3 != '-') {
                        skipWhitespace();
                    }
                    char c4 = this.ch;
                    if (c4 != '-' && c4 != '+' && (c4 < '0' || c4 > '9')) {
                        char c5 = this.ch;
                        if (c5 == '\"') {
                            skipString();
                            char c6 = this.ch;
                            if (c6 != ',' && c6 != '}') {
                                skipWhitespace();
                            }
                            if (this.ch == ',') {
                                next();
                            }
                        } else if (c5 == '{') {
                            int i11 = this.bp + 1;
                            this.bp = i11;
                            if (i11 < this.text.length()) {
                                c3 = this.text.charAt(i11);
                            }
                            this.ch = c3;
                            skipObject(false);
                        } else if (c5 == '[') {
                            next();
                            skipArray(false);
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        next();
                        while (true) {
                            char c7 = this.ch;
                            if (c7 < '0' || c7 > '9') {
                                break;
                            }
                            next();
                        }
                        if (this.ch == '.') {
                            next();
                            while (true) {
                                char c8 = this.ch;
                                if (c8 < '0' || c8 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c9 = this.ch;
                        if (c9 == 'E' || c9 == 'e') {
                            next();
                            char c10 = this.ch;
                            if (c10 == '-' || c10 == '+') {
                                next();
                            }
                            while (true) {
                                char c11 = this.ch;
                                if (c11 < '0' || c11 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.ch != ',') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    }
                } else {
                    throw new JSONException("illegal json, " + info());
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}
