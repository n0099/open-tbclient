package com.alibaba.fastjson.parser;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes3.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<char[]> BUF_LOCAL;
    public transient /* synthetic */ FieldHolder $fh;
    public char[] buf;
    public int bufLength;
    public Reader reader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(610445306, "Lcom/alibaba/fastjson/parser/JSONReaderScanner;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(610445306, "Lcom/alibaba/fastjson/parser/JSONReaderScanner;");
                return;
            }
        }
        BUF_LOCAL = new ThreadLocal<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i2, int i3, int i4, SymbolTable symbolTable) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), symbolTable})) == null) ? symbolTable.addSymbol(this.buf, i2, i3, i4) : (String) invokeCommon.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i2, char[] cArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), cArr, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            System.arraycopy(this.buf, i2, cArr, i3, i4);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.token != 26) {
                return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
            }
            throw new JSONException("TODO");
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cArr)) == null) {
            for (int i2 = 0; i2 < cArr.length; i2++) {
                if (charAt(this.bp + i2) != cArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = this.bufLength;
            if (i2 >= i3) {
                if (i3 == -1) {
                    return i2 < this.sp ? this.buf[i2] : JSONLexer.EOI;
                }
                int i4 = this.bp;
                if (i4 == 0) {
                    char[] cArr = this.buf;
                    int length = (cArr.length * 3) / 2;
                    char[] cArr2 = new char[length];
                    System.arraycopy(cArr, i4, cArr2, 0, i3);
                    int i5 = this.bufLength;
                    try {
                        this.bufLength += this.reader.read(cArr2, i5, length - i5);
                        this.buf = cArr2;
                    } catch (IOException e2) {
                        throw new JSONException(e2.getMessage(), e2);
                    }
                } else {
                    int i6 = i3 - i4;
                    if (i6 > 0) {
                        char[] cArr3 = this.buf;
                        System.arraycopy(cArr3, i4, cArr3, 0, i6);
                    }
                    try {
                        int read = this.reader.read(this.buf, i6, this.buf.length - i6);
                        this.bufLength = read;
                        if (read == 0) {
                            throw new JSONException("illegal state, textLength is zero");
                        }
                        if (read == -1) {
                            return JSONLexer.EOI;
                        }
                        this.bufLength = read + i6;
                        int i7 = this.bp;
                        i2 -= i7;
                        this.np -= i7;
                        this.bp = 0;
                    } catch (IOException e3) {
                        throw new JSONException(e3.getMessage(), e3);
                    }
                }
            }
            return this.buf[i2];
        }
        return invokeI.charValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.close();
            char[] cArr = this.buf;
            if (cArr.length <= 65536) {
                BUF_LOCAL.set(cArr);
            }
            this.buf = null;
            IOUtils.close(this.reader);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i2, int i3, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, cArr) == null) {
            System.arraycopy(this.buf, i2, cArr, 0, i3);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.np;
            if (i2 == -1) {
                i2 = 0;
            }
            char charAt = charAt((this.sp + i2) - 1);
            int i3 = this.sp;
            if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
                i3--;
            }
            if (i3 <= 65535) {
                return new BigDecimal(this.buf, i2, i3, MathContext.UNLIMITED);
            }
            throw new JSONException("decimal overflow");
        }
        return (BigDecimal) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i2)})) != null) {
            return invokeCommon.intValue;
        }
        int i3 = i2 - this.bp;
        while (true) {
            char charAt = charAt(this.bp + i3);
            if (c2 == charAt) {
                return i3 + this.bp;
            }
            if (charAt == 26) {
                return -1;
            }
            i3++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048585, this)) != null) {
            return invokeV.booleanValue;
        }
        int i2 = 0;
        while (true) {
            char c2 = this.buf[i2];
            if (c2 == 26) {
                this.token = 20;
                return true;
            } else if (!JSONLexerBase.isWhitespace(c2)) {
                return false;
            } else {
                i2++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.bufLength != -1) {
                int i2 = this.bp;
                char[] cArr = this.buf;
                if (i2 != cArr.length) {
                    return this.ch == 26 && i2 + 1 >= cArr.length;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.bp + 1;
            this.bp = i2;
            int i3 = this.bufLength;
            if (i2 >= i3) {
                if (i3 == -1) {
                    return JSONLexer.EOI;
                }
                int i4 = this.sp;
                if (i4 > 0) {
                    int i5 = i3 - i4;
                    if (this.ch == '\"' && i5 > 0) {
                        i5--;
                    }
                    char[] cArr = this.buf;
                    System.arraycopy(cArr, i5, cArr, 0, this.sp);
                }
                this.np = -1;
                int i6 = this.sp;
                this.bp = i6;
                try {
                    int length = this.buf.length - i6;
                    if (length == 0) {
                        char[] cArr2 = new char[this.buf.length * 2];
                        System.arraycopy(this.buf, 0, cArr2, 0, this.buf.length);
                        this.buf = cArr2;
                        length = cArr2.length - i6;
                    }
                    int read = this.reader.read(this.buf, this.bp, length);
                    this.bufLength = read;
                    if (read == 0) {
                        throw new JSONException("illegal stat, textLength is zero");
                    }
                    if (read == -1) {
                        this.ch = JSONLexer.EOI;
                        return JSONLexer.EOI;
                    }
                    this.bufLength = read + this.bp;
                    i2 = i6;
                } catch (IOException e2) {
                    throw new JSONException(e2.getMessage(), e2);
                }
            }
            char c2 = this.buf[i2];
            this.ch = c2;
            return c2;
        }
        return invokeV.charValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.np;
            if (i2 == -1) {
                i2 = 0;
            }
            char charAt = charAt((this.sp + i2) - 1);
            int i3 = this.sp;
            if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
                i3--;
            }
            return new String(this.buf, i2, i3);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.hasSpecial) {
                int i2 = this.np + 1;
                if (i2 >= 0) {
                    if (i2 <= this.buf.length - this.sp) {
                        return new String(this.buf, i2, this.sp);
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
            return new String(this.sbuf, 0, this.sp);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            if (i3 >= 0) {
                return new String(this.buf, i2, i3);
            }
            throw new StringIndexOutOfBoundsException(i3);
        }
        return (String) invokeII.objValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) {
            if (i3 >= 0) {
                if (i2 == 0) {
                    return this.buf;
                }
                char[] cArr = new char[i3];
                System.arraycopy(this.buf, i2, cArr, 0, i3);
                return cArr;
            }
            throw new StringIndexOutOfBoundsException(i3);
        }
        return (char[]) invokeII.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReaderScanner(String str, int i2) {
        this(new StringReader(str), i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Reader) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReaderScanner(char[] cArr, int i2) {
        this(cArr, i2, JSON.DEFAULT_PARSER_FEATURE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((char[]) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Reader) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONReaderScanner(Reader reader, int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.reader = reader;
        char[] cArr = BUF_LOCAL.get();
        this.buf = cArr;
        if (cArr != null) {
            BUF_LOCAL.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONReaderScanner(char[] cArr, int i2, int i3) {
        this(new CharArrayReader(cArr, 0, i2), i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Reader) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }
}
