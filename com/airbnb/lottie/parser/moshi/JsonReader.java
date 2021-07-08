package com.airbnb.lottie.parser.moshi;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] REPLACEMENT_CHARS;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean failOnUnknown;
    public boolean lenient;
    public int[] pathIndices;
    public String[] pathNames;
    public int[] scopes;
    public int stackSize;

    /* loaded from: classes.dex */
    public static final class Options {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final okio.Options doubleQuoteSuffix;
        public final String[] strings;

        public Options(String[] strArr, okio.Options options) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, options};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        public static Options of(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
                try {
                    ByteString[] byteStringArr = new ByteString[strArr.length];
                    Buffer buffer = new Buffer();
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        JsonReader.string(buffer, strArr[i2]);
                        buffer.readByte();
                        byteStringArr[i2] = buffer.readByteString();
                    }
                    return new Options((String[]) strArr.clone(), okio.Options.of(byteStringArr));
                } catch (IOException e2) {
                    throw new AssertionError(e2);
                }
            }
            return (Options) invokeL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Token {
        public static final /* synthetic */ Token[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Token BEGIN_ARRAY;
        public static final Token BEGIN_OBJECT;
        public static final Token BOOLEAN;
        public static final Token END_ARRAY;
        public static final Token END_DOCUMENT;
        public static final Token END_OBJECT;
        public static final Token NAME;
        public static final Token NULL;
        public static final Token NUMBER;
        public static final Token STRING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1800006603, "Lcom/airbnb/lottie/parser/moshi/JsonReader$Token;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1800006603, "Lcom/airbnb/lottie/parser/moshi/JsonReader$Token;");
                    return;
                }
            }
            BEGIN_ARRAY = new Token("BEGIN_ARRAY", 0);
            END_ARRAY = new Token("END_ARRAY", 1);
            BEGIN_OBJECT = new Token("BEGIN_OBJECT", 2);
            END_OBJECT = new Token("END_OBJECT", 3);
            NAME = new Token("NAME", 4);
            STRING = new Token("STRING", 5);
            NUMBER = new Token("NUMBER", 6);
            BOOLEAN = new Token("BOOLEAN", 7);
            NULL = new Token("NULL", 8);
            Token token = new Token("END_DOCUMENT", 9);
            END_DOCUMENT = token;
            $VALUES = new Token[]{BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, token};
        }

        public Token(String str, int i2) {
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

        public static Token valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Token) Enum.valueOf(Token.class, str) : (Token) invokeL.objValue;
        }

        public static Token[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Token[]) $VALUES.clone() : (Token[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1239325430, "Lcom/airbnb/lottie/parser/moshi/JsonReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1239325430, "Lcom/airbnb/lottie/parser/moshi/JsonReader;");
                return;
            }
        }
        REPLACEMENT_CHARS = new String[128];
        for (int i2 = 0; i2 <= 31; i2++) {
            REPLACEMENT_CHARS[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public JsonReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.scopes = new int[32];
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
    }

    public static JsonReader of(BufferedSource bufferedSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bufferedSource)) == null) ? new JsonUtf8Reader(bufferedSource) : (JsonReader) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void string(BufferedSink bufferedSink, String str) throws IOException {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bufferedSink, str) == null) {
            String[] strArr = REPLACEMENT_CHARS;
            bufferedSink.writeByte(34);
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    str2 = strArr[charAt];
                    i2 = str2 == null ? i2 + 1 : 0;
                    if (i3 < i2) {
                        bufferedSink.writeUtf8(str, i3, i2);
                    }
                    bufferedSink.writeUtf8(str2);
                    i3 = i2 + 1;
                } else {
                    if (charAt == 8232) {
                        str2 = "\\u2028";
                    } else if (charAt == 8233) {
                        str2 = "\\u2029";
                    }
                    if (i3 < i2) {
                    }
                    bufferedSink.writeUtf8(str2);
                    i3 = i2 + 1;
                }
            }
            if (i3 < length) {
                bufferedSink.writeUtf8(str, i3, length);
            }
            bufferedSink.writeByte(34);
        }
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices) : (String) invokeV.objValue;
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public final void pushScope(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int i3 = this.stackSize;
            int[] iArr = this.scopes;
            if (i3 == iArr.length) {
                if (i3 != 256) {
                    this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.pathNames;
                    this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                    int[] iArr2 = this.pathIndices;
                    this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
                } else {
                    throw new JsonDataException("Nesting too deep at " + getPath());
                }
            }
            int[] iArr3 = this.scopes;
            int i4 = this.stackSize;
            this.stackSize = i4 + 1;
            iArr3[i4] = i2;
        }
    }

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            throw new JsonEncodingException(str + " at path " + getPath());
        }
        return (JsonEncodingException) invokeL.objValue;
    }
}
