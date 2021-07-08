package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
/* loaded from: classes.dex */
public abstract class JSONValidator implements Cloneable, Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public char ch;
    public int count;
    public boolean eof;
    public int pos;
    public boolean supportMultiValue;
    public Type type;
    public Boolean valiateResult;

    /* loaded from: classes.dex */
    public static class ReaderValidator extends JSONValidator {
        public static /* synthetic */ Interceptable $ic;
        public static final ThreadLocal<char[]> bufLocal;
        public transient /* synthetic */ FieldHolder $fh;
        public char[] buf;
        public int end;
        public final Reader r;
        public int readCount;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1990974812, "Lcom/alibaba/fastjson/JSONValidator$ReaderValidator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1990974812, "Lcom/alibaba/fastjson/JSONValidator$ReaderValidator;");
                    return;
                }
            }
            bufLocal = new ThreadLocal<>();
        }

        public ReaderValidator(Reader reader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {reader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.end = -1;
            this.readCount = 0;
            this.r = reader;
            char[] cArr = bufLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                bufLocal.set(null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bufLocal.set(this.buf);
                this.r.close();
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.pos;
                if (i2 < this.end) {
                    char[] cArr = this.buf;
                    int i3 = i2 + 1;
                    this.pos = i3;
                    this.ch = cArr[i3];
                } else if (this.eof) {
                } else {
                    try {
                        int read = this.r.read(this.buf, 0, this.buf.length);
                        this.readCount++;
                        if (read > 0) {
                            this.ch = this.buf[0];
                            this.pos = 0;
                            this.end = read - 1;
                        } else if (read == -1) {
                            this.pos = 0;
                            this.end = 0;
                            this.buf = null;
                            this.ch = (char) 0;
                            this.eof = true;
                        } else {
                            this.pos = 0;
                            this.end = 0;
                            this.buf = null;
                            this.ch = (char) 0;
                            this.eof = true;
                            throw new JSONException("read error");
                        }
                    } catch (IOException unused) {
                        throw new JSONException("read error");
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type Array;
        public static final Type Object;
        public static final Type Value;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(936147177, "Lcom/alibaba/fastjson/JSONValidator$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(936147177, "Lcom/alibaba/fastjson/JSONValidator$Type;");
                    return;
                }
            }
            Object = new Type("Object", 0);
            Array = new Type("Array", 1);
            Type type = new Type("Value", 2);
            Value = type;
            $VALUES = new Type[]{Object, Array, type};
        }

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class UTF16Validator extends JSONValidator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String str;

        public UTF16Validator(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.str = str;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public final void fieldName() {
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.pos;
                do {
                    i2++;
                    if (i2 >= this.str.length() || (charAt = this.str.charAt(i2)) == '\\') {
                        next();
                        while (true) {
                            char c2 = this.ch;
                            if (c2 == '\\') {
                                next();
                                if (this.ch == 'u') {
                                    next();
                                    next();
                                    next();
                                    next();
                                    next();
                                } else {
                                    next();
                                }
                            } else if (c2 == '\"') {
                                next();
                                return;
                            } else {
                                next();
                            }
                        }
                    }
                } while (charAt != '\"');
                int i3 = i2 + 1;
                this.ch = this.str.charAt(i3);
                this.pos = i3;
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.pos + 1;
                this.pos = i2;
                if (i2 >= this.str.length()) {
                    this.ch = (char) 0;
                    this.eof = true;
                    return;
                }
                this.ch = this.str.charAt(this.pos);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UTF8InputStreamValidator extends JSONValidator {
        public static /* synthetic */ Interceptable $ic;
        public static final ThreadLocal<byte[]> bufLocal;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] buf;
        public int end;
        public final InputStream is;
        public int readCount;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1399436182, "Lcom/alibaba/fastjson/JSONValidator$UTF8InputStreamValidator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1399436182, "Lcom/alibaba/fastjson/JSONValidator$UTF8InputStreamValidator;");
                    return;
                }
            }
            bufLocal = new ThreadLocal<>();
        }

        public UTF8InputStreamValidator(InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.end = -1;
            this.readCount = 0;
            this.is = inputStream;
            byte[] bArr = bufLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                bufLocal.set(null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bufLocal.set(this.buf);
                this.is.close();
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i2 = this.pos;
                if (i2 < this.end) {
                    byte[] bArr = this.buf;
                    int i3 = i2 + 1;
                    this.pos = i3;
                    this.ch = (char) bArr[i3];
                } else if (this.eof) {
                } else {
                    try {
                        int read = this.is.read(this.buf, 0, this.buf.length);
                        this.readCount++;
                        if (read > 0) {
                            this.ch = (char) this.buf[0];
                            this.pos = 0;
                            this.end = read - 1;
                        } else if (read == -1) {
                            this.pos = 0;
                            this.end = 0;
                            this.buf = null;
                            this.ch = (char) 0;
                            this.eof = true;
                        } else {
                            this.pos = 0;
                            this.end = 0;
                            this.buf = null;
                            this.ch = (char) 0;
                            this.eof = true;
                            throw new JSONException("read error");
                        }
                    } catch (IOException unused) {
                        throw new JSONException("read error");
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UTF8Validator extends JSONValidator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.pos + 1;
                this.pos = i2;
                byte[] bArr = this.bytes;
                if (i2 >= bArr.length) {
                    this.ch = (char) 0;
                    this.eof = true;
                    return;
                }
                this.ch = (char) bArr[i2];
            }
        }
    }

    public JSONValidator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pos = -1;
        this.count = 0;
        this.supportMultiValue = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0179, code lost:
        if (r0 <= '9') goto L132;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean any() {
        InterceptResult invokeV;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            char c10 = this.ch;
            if (c10 != '\"') {
                if (c10 != '+' && c10 != '-') {
                    if (c10 == '[') {
                        next();
                        skipWhiteSpace();
                        if (this.ch == ']') {
                            next();
                            this.type = Type.Array;
                            return true;
                        }
                        while (any()) {
                            skipWhiteSpace();
                            char c11 = this.ch;
                            if (c11 != ',') {
                                if (c11 == ']') {
                                    next();
                                    this.type = Type.Array;
                                    return true;
                                }
                                return false;
                            }
                            next();
                            skipWhiteSpace();
                        }
                        return false;
                    } else if (c10 == 'f') {
                        next();
                        if (this.ch != 'a') {
                            return false;
                        }
                        next();
                        if (this.ch != 'l') {
                            return false;
                        }
                        next();
                        if (this.ch != 's') {
                            return false;
                        }
                        next();
                        if (this.ch != 'e') {
                            return false;
                        }
                        next();
                        if (isWhiteSpace(this.ch) || (c7 = this.ch) == ',' || c7 == ']' || c7 == '}' || c7 == 0) {
                            this.type = Type.Value;
                            return true;
                        }
                        return false;
                    } else if (c10 == 'n') {
                        next();
                        if (this.ch != 'u') {
                            return false;
                        }
                        next();
                        if (this.ch != 'l') {
                            return false;
                        }
                        next();
                        if (this.ch != 'l') {
                            return false;
                        }
                        next();
                        if (isWhiteSpace(this.ch) || (c8 = this.ch) == ',' || c8 == ']' || c8 == '}' || c8 == 0) {
                            this.type = Type.Value;
                            return true;
                        }
                        return false;
                    } else if (c10 == 't') {
                        next();
                        if (this.ch != 'r') {
                            return false;
                        }
                        next();
                        if (this.ch != 'u') {
                            return false;
                        }
                        next();
                        if (this.ch != 'e') {
                            return false;
                        }
                        next();
                        if (isWhiteSpace(this.ch) || (c9 = this.ch) == ',' || c9 == ']' || c9 == '}' || c9 == 0) {
                            this.type = Type.Value;
                            return true;
                        }
                        return false;
                    } else if (c10 == '{') {
                        next();
                        while (isWhiteSpace(this.ch)) {
                            next();
                        }
                        if (this.ch == '}') {
                            next();
                            this.type = Type.Object;
                            return true;
                        }
                        while (this.ch == '\"') {
                            fieldName();
                            skipWhiteSpace();
                            if (this.ch != ':') {
                                break;
                            }
                            next();
                            skipWhiteSpace();
                            if (!any()) {
                                return false;
                            }
                            skipWhiteSpace();
                            char c12 = this.ch;
                            if (c12 == ',') {
                                next();
                                skipWhiteSpace();
                            } else if (c12 == '}') {
                                next();
                                this.type = Type.Object;
                                return true;
                            }
                        }
                        return false;
                    } else {
                        switch (c10) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                return false;
                        }
                    }
                }
                char c13 = this.ch;
                if (c13 == '-' || c13 == '+') {
                    next();
                    skipWhiteSpace();
                    char c14 = this.ch;
                    if (c14 >= '0') {
                    }
                    return false;
                }
                do {
                    next();
                    c2 = this.ch;
                    if (c2 >= '0') {
                    }
                    if (this.ch == '.') {
                        next();
                        char c15 = this.ch;
                        if (c15 < '0' || c15 > '9') {
                            return false;
                        }
                        while (true) {
                            char c16 = this.ch;
                            if (c16 >= '0' && c16 <= '9') {
                                next();
                            }
                        }
                    }
                    c3 = this.ch;
                    if (c3 != 'e' || c3 == 'E') {
                        next();
                        c4 = this.ch;
                        if (c4 != '-' || c4 == '+') {
                            next();
                        }
                        c5 = this.ch;
                        if (c5 >= '0' && c5 <= '9') {
                            next();
                            while (true) {
                                c6 = this.ch;
                                if (c6 >= '0' && c6 <= '9') {
                                    next();
                                }
                            }
                        }
                        return false;
                    }
                    this.type = Type.Value;
                    return true;
                } while (c2 <= '9');
                if (this.ch == '.') {
                }
                c3 = this.ch;
                if (c3 != 'e') {
                }
                next();
                c4 = this.ch;
                if (c4 != '-') {
                }
                next();
                c5 = this.ch;
                if (c5 >= '0') {
                    next();
                    while (true) {
                        c6 = this.ch;
                        if (c6 >= '0') {
                            next();
                        }
                    }
                    this.type = Type.Value;
                    return true;
                }
                return false;
            }
            next();
            while (!this.eof) {
                char c17 = this.ch;
                if (c17 == '\\') {
                    next();
                    if (this.ch == 'u') {
                        next();
                        next();
                        next();
                        next();
                        next();
                    } else {
                        next();
                    }
                } else if (c17 == '\"') {
                    next();
                    this.type = Type.Value;
                    return true;
                } else {
                    next();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static JSONValidator from(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? new UTF16Validator(str) : (JSONValidator) invokeL.objValue;
    }

    public static JSONValidator fromUtf8(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) ? new UTF8Validator(bArr) : (JSONValidator) invokeL.objValue;
    }

    public static final boolean isWhiteSpace(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n' || c2 == '\f' || c2 == '\b' : invokeCommon.booleanValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void fieldName() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        next();
        while (true) {
            char c2 = this.ch;
            if (c2 == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else if (c2 == '\"') {
                next();
                return;
            } else {
                next();
            }
        }
    }

    public Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.type == null) {
                validate();
            }
            return this.type;
        }
        return (Type) invokeV.objValue;
    }

    public boolean isSupportMultiValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.supportMultiValue : invokeV.booleanValue;
    }

    public abstract void next();

    public JSONValidator setSupportMultiValue(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.supportMultiValue = z;
            return this;
        }
        return (JSONValidator) invokeZ.objValue;
    }

    public void skipWhiteSpace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            while (isWhiteSpace(this.ch)) {
                next();
            }
        }
    }

    public boolean string() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            next();
            while (!this.eof) {
                char c2 = this.ch;
                if (c2 == '\\') {
                    next();
                    if (this.ch == 'u') {
                        next();
                        next();
                        next();
                        next();
                        next();
                    } else {
                        next();
                    }
                } else if (c2 == '\"') {
                    next();
                    return true;
                } else {
                    next();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean validate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Boolean bool = this.valiateResult;
            if (bool != null) {
                return bool.booleanValue();
            }
            while (any()) {
                this.count++;
                if (this.eof) {
                    this.valiateResult = Boolean.TRUE;
                    return true;
                } else if (this.supportMultiValue) {
                    skipWhiteSpace();
                    if (this.eof) {
                        this.valiateResult = Boolean.TRUE;
                        return true;
                    }
                } else {
                    this.valiateResult = Boolean.FALSE;
                    return false;
                }
            }
            this.valiateResult = Boolean.FALSE;
            return false;
        }
        return invokeV.booleanValue;
    }

    public static JSONValidator from(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, reader)) == null) ? new ReaderValidator(reader) : (JSONValidator) invokeL.objValue;
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) ? new UTF8InputStreamValidator(inputStream) : (JSONValidator) invokeL.objValue;
    }
}
