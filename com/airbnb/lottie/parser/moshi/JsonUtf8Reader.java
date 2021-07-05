package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.apache.http.message.BasicHeaderValueFormatter;
/* loaded from: classes.dex */
public final class JsonUtf8Reader extends JsonReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ByteString CLOSING_BLOCK_COMMENT;
    public static final ByteString DOUBLE_QUOTE_OR_SLASH;
    public static final ByteString LINEFEED_OR_CARRIAGE_RETURN;
    public static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    public static final int NUMBER_CHAR_DECIMAL = 3;
    public static final int NUMBER_CHAR_DIGIT = 2;
    public static final int NUMBER_CHAR_EXP_DIGIT = 7;
    public static final int NUMBER_CHAR_EXP_E = 5;
    public static final int NUMBER_CHAR_EXP_SIGN = 6;
    public static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    public static final int NUMBER_CHAR_NONE = 0;
    public static final int NUMBER_CHAR_SIGN = 1;
    public static final int PEEKED_BEGIN_ARRAY = 3;
    public static final int PEEKED_BEGIN_OBJECT = 1;
    public static final int PEEKED_BUFFERED = 11;
    public static final int PEEKED_BUFFERED_NAME = 15;
    public static final int PEEKED_DOUBLE_QUOTED = 9;
    public static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    public static final int PEEKED_END_ARRAY = 4;
    public static final int PEEKED_END_OBJECT = 2;
    public static final int PEEKED_EOF = 18;
    public static final int PEEKED_FALSE = 6;
    public static final int PEEKED_LONG = 16;
    public static final int PEEKED_NONE = 0;
    public static final int PEEKED_NULL = 7;
    public static final int PEEKED_NUMBER = 17;
    public static final int PEEKED_SINGLE_QUOTED = 8;
    public static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    public static final int PEEKED_TRUE = 5;
    public static final int PEEKED_UNQUOTED = 10;
    public static final int PEEKED_UNQUOTED_NAME = 14;
    public static final ByteString SINGLE_QUOTE_OR_SLASH;
    public static final ByteString UNQUOTED_STRING_TERMINALS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public int peeked;
    public long peekedLong;
    public int peekedNumberLength;
    @Nullable
    public String peekedString;
    public final BufferedSource source;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1712526169, "Lcom/airbnb/lottie/parser/moshi/JsonUtf8Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1712526169, "Lcom/airbnb/lottie/parser/moshi/JsonUtf8Reader;");
                return;
            }
        }
        SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
        DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
        UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
        LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
        CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
    }

    public JsonUtf8Reader(BufferedSource bufferedSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.peeked = 0;
        if (bufferedSource != null) {
            this.source = bufferedSource;
            this.buffer = bufferedSource.buffer();
            pushScope(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void checkLenient() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && !this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int[] iArr = this.scopes;
            int i2 = this.stackSize;
            int i3 = iArr[i2 - 1];
            if (i3 == 1) {
                iArr[i2 - 1] = 2;
            } else if (i3 == 2) {
                int nextNonWhitespace = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace != 44) {
                    if (nextNonWhitespace != 59) {
                        if (nextNonWhitespace == 93) {
                            this.peeked = 4;
                            return 4;
                        }
                        throw syntaxError("Unterminated array");
                    }
                    checkLenient();
                }
            } else if (i3 == 3 || i3 == 5) {
                this.scopes[this.stackSize - 1] = 4;
                if (i3 == 5) {
                    int nextNonWhitespace2 = nextNonWhitespace(true);
                    this.buffer.readByte();
                    if (nextNonWhitespace2 != 44) {
                        if (nextNonWhitespace2 != 59) {
                            if (nextNonWhitespace2 == 125) {
                                this.peeked = 2;
                                return 2;
                            }
                            throw syntaxError("Unterminated object");
                        }
                        checkLenient();
                    }
                }
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 == 34) {
                    this.buffer.readByte();
                    this.peeked = 13;
                    return 13;
                } else if (nextNonWhitespace3 == 39) {
                    this.buffer.readByte();
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                } else if (nextNonWhitespace3 != 125) {
                    checkLenient();
                    if (isLiteral((char) nextNonWhitespace3)) {
                        this.peeked = 14;
                        return 14;
                    }
                    throw syntaxError("Expected name");
                } else if (i3 != 5) {
                    this.buffer.readByte();
                    this.peeked = 2;
                    return 2;
                } else {
                    throw syntaxError("Expected name");
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int nextNonWhitespace4 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace4 != 58) {
                    if (nextNonWhitespace4 == 61) {
                        checkLenient();
                        if (this.source.request(1L) && this.buffer.getByte(0L) == 62) {
                            this.buffer.readByte();
                        }
                    } else {
                        throw syntaxError("Expected ':'");
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 18;
                    return 18;
                }
                checkLenient();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            int nextNonWhitespace5 = nextNonWhitespace(true);
            if (nextNonWhitespace5 == 34) {
                this.buffer.readByte();
                this.peeked = 9;
                return 9;
            } else if (nextNonWhitespace5 == 39) {
                checkLenient();
                this.buffer.readByte();
                this.peeked = 8;
                return 8;
            } else {
                if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                    if (nextNonWhitespace5 == 91) {
                        this.buffer.readByte();
                        this.peeked = 3;
                        return 3;
                    } else if (nextNonWhitespace5 != 93) {
                        if (nextNonWhitespace5 != 123) {
                            int peekKeyword = peekKeyword();
                            if (peekKeyword != 0) {
                                return peekKeyword;
                            }
                            int peekNumber = peekNumber();
                            if (peekNumber != 0) {
                                return peekNumber;
                            }
                            if (isLiteral(this.buffer.getByte(0L))) {
                                checkLenient();
                                this.peeked = 10;
                                return 10;
                            }
                            throw syntaxError("Expected value");
                        }
                        this.buffer.readByte();
                        this.peeked = 1;
                        return 1;
                    } else if (i3 == 1) {
                        this.buffer.readByte();
                        this.peeked = 4;
                        return 4;
                    }
                }
                if (i3 != 1 && i3 != 2) {
                    throw syntaxError("Unexpected value");
                }
                checkLenient();
                this.peeked = 7;
                return 7;
            }
        }
        return invokeV.intValue;
    }

    private int findName(String str, JsonReader.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, str, options)) == null) {
            int length = options.strings.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equals(options.strings[i2])) {
                    this.peeked = 0;
                    this.pathNames[this.stackSize - 1] = str;
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    private int findString(String str, JsonReader.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, options)) == null) {
            int length = options.strings.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equals(options.strings[i2])) {
                    this.peeked = 0;
                    int[] iArr = this.pathIndices;
                    int i3 = this.stackSize - 1;
                    iArr[i3] = iArr[i3] + 1;
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    private boolean isLiteral(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
                return false;
            }
            if (i2 != 35) {
                if (i2 == 44) {
                    return false;
                }
                if (i2 != 47 && i2 != 61) {
                    if (i2 == 123 || i2 == 125 || i2 == 58) {
                        return false;
                    }
                    if (i2 != 59) {
                        switch (i2) {
                            case 91:
                            case 93:
                                return false;
                            case 92:
                                break;
                            default:
                                return true;
                        }
                    }
                }
            }
            checkLenient();
            return false;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
        r6.buffer.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r1 != 47) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r6.source.request(2) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        checkLenient();
        r3 = r6.buffer.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r3 == 42) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (r3 == 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
        r6.buffer.readByte();
        r6.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        r6.buffer.readByte();
        r6.buffer.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (skipToEndOfBlockComment() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0077, code lost:
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        if (r1 != 35) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int nextNonWhitespace(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(65543, this, z)) != null) {
            return invokeZ.intValue;
        }
        while (true) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (!this.source.request(i3)) {
                    if (z) {
                        throw new EOFException("End of input");
                    }
                    return -1;
                }
                byte b2 = this.buffer.getByte(i2);
                if (b2 != 10 && b2 != 32 && b2 != 13 && b2 != 9) {
                    break;
                }
                i2 = i3;
            }
        }
    }

    private String nextQuotedValue(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, this, byteString)) != null) {
            return (String) invokeL.objValue;
        }
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.buffer.getByte(indexOfElement) != 92) {
                    if (sb == null) {
                        String readUtf8 = this.buffer.readUtf8(indexOfElement);
                        this.buffer.readByte();
                        return readUtf8;
                    }
                    sb.append(this.buffer.readUtf8(indexOfElement));
                    this.buffer.readByte();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                sb.append(readEscapeCharacter());
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    private String nextUnquotedValue() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
            return indexOfElement != -1 ? this.buffer.readUtf8(indexOfElement) : this.buffer.readUtf8();
        }
        return (String) invokeV.objValue;
    }

    private int peekKeyword() throws IOException {
        InterceptResult invokeV;
        int i2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            byte b2 = this.buffer.getByte(0L);
            if (b2 == 116 || b2 == 84) {
                i2 = 5;
                str = "true";
                str2 = "TRUE";
            } else if (b2 == 102 || b2 == 70) {
                i2 = 6;
                str = "false";
                str2 = "FALSE";
            } else if (b2 != 110 && b2 != 78) {
                return 0;
            } else {
                i2 = 7;
                str = StringUtil.NULL_STRING;
                str2 = "NULL";
            }
            int length = str.length();
            int i3 = 1;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (!this.source.request(i4)) {
                    return 0;
                }
                byte b3 = this.buffer.getByte(i3);
                if (b3 != str.charAt(i3) && b3 != str2.charAt(i3)) {
                    return 0;
                }
                i3 = i4;
            }
            if (this.source.request(length + 1) && isLiteral(this.buffer.getByte(length))) {
                return 0;
            }
            this.buffer.skip(length);
            this.peeked = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (isLiteral(r11) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
        if (r6 != 2) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        if (r7 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0095, code lost:
        if (r8 != Long.MIN_VALUE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
        if (r10 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r8 != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
        if (r10 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a2, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a3, code lost:
        r16.peekedLong = r8;
        r16.buffer.skip(r5);
        r16.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00af, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b0, code lost:
        if (r6 == 2) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b3, code lost:
        if (r6 == 4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
        if (r6 != 7) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b9, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bb, code lost:
        r16.peekedNumberLength = r5;
        r16.peeked = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c2, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65547, this)) != null) {
            return invokeV.intValue;
        }
        char c2 = 1;
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        char c3 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            int i4 = i3 + 1;
            if (!this.source.request(i4)) {
                break;
            }
            byte b2 = this.buffer.getByte(i3);
            if (b2 != 43) {
                if (b2 == 69 || b2 == 101) {
                    if (c3 != 2 && c3 != 4) {
                        return i2;
                    }
                    c3 = 5;
                } else if (b2 != 45) {
                    if (b2 != 46) {
                        if (b2 < 48 || b2 > 57) {
                            break;
                        } else if (c3 == c2 || c3 == 0) {
                            j = -(b2 - 48);
                            i2 = 0;
                            c3 = 2;
                        } else {
                            if (c3 == 2) {
                                if (j == 0) {
                                    return i2;
                                }
                                long j2 = (10 * j) - (b2 - 48);
                                int i5 = (j > (-922337203685477580L) ? 1 : (j == (-922337203685477580L) ? 0 : -1));
                                z &= i5 > 0 || (i5 == 0 && j2 < j);
                                j = j2;
                            } else if (c3 == 3) {
                                i2 = 0;
                                c3 = 4;
                            } else if (c3 == 5 || c3 == 6) {
                                i2 = 0;
                                c3 = 7;
                            }
                            i2 = 0;
                        }
                    } else if (c3 != 2) {
                        return i2;
                    } else {
                        c3 = 3;
                    }
                } else if (c3 == 0) {
                    c3 = 1;
                    z2 = true;
                } else if (c3 != 5) {
                    return i2;
                }
                i3 = i4;
                c2 = 1;
            } else if (c3 != 5) {
                return i2;
            }
            c3 = 6;
            i3 = i4;
            c2 = 1;
        }
    }

    private char readEscapeCharacter() throws IOException {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.source.request(1L)) {
                byte readByte = this.buffer.readByte();
                if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                    return (char) readByte;
                }
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte != 110) {
                            if (readByte != 114) {
                                if (readByte != 116) {
                                    if (readByte != 117) {
                                        if (this.lenient) {
                                            return (char) readByte;
                                        }
                                        throw syntaxError("Invalid escape sequence: \\" + ((char) readByte));
                                    } else if (this.source.request(4L)) {
                                        char c2 = 0;
                                        for (int i4 = 0; i4 < 4; i4++) {
                                            byte b2 = this.buffer.getByte(i4);
                                            char c3 = (char) (c2 << 4);
                                            if (b2 < 48 || b2 > 57) {
                                                if (b2 >= 97 && b2 <= 102) {
                                                    i2 = b2 - 97;
                                                } else if (b2 < 65 || b2 > 70) {
                                                    throw syntaxError("\\u" + this.buffer.readUtf8(4L));
                                                } else {
                                                    i2 = b2 - 65;
                                                }
                                                i3 = i2 + 10;
                                            } else {
                                                i3 = b2 - 48;
                                            }
                                            c2 = (char) (c3 + i3);
                                        }
                                        this.buffer.skip(4L);
                                        return c2;
                                    } else {
                                        throw new EOFException("Unterminated escape sequence at path " + getPath());
                                    }
                                }
                                return '\t';
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            throw syntaxError("Unterminated escape sequence");
        }
        return invokeV.charValue;
    }

    private void skipQuotedValue(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65549, this, byteString) != null) {
            return;
        }
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.buffer.getByte(indexOfElement) == 92) {
                    this.buffer.skip(indexOfElement + 1);
                    readEscapeCharacter();
                } else {
                    this.buffer.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            long indexOf = this.source.indexOf(CLOSING_BLOCK_COMMENT);
            boolean z = indexOf != -1;
            Buffer buffer = this.buffer;
            buffer.skip(z ? indexOf + CLOSING_BLOCK_COMMENT.size() : buffer.size());
            return z;
        }
        return invokeV.booleanValue;
    }

    private void skipToEndOfLine() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            long indexOfElement = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
            Buffer buffer = this.buffer;
            buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
        }
    }

    private void skipUnquotedValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
            Buffer buffer = this.buffer;
            if (indexOfElement == -1) {
                indexOfElement = buffer.size();
            }
            buffer.skip(indexOfElement);
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                pushScope(1);
                this.pathIndices[this.stackSize - 1] = 0;
                this.peeked = 0;
                return;
            }
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 1) {
                pushScope(3);
                this.peeked = 0;
                return;
            }
            throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.peeked = 0;
            this.scopes[0] = 8;
            this.stackSize = 1;
            this.buffer.clear();
            this.source.close();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endArray() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 4) {
                int i3 = this.stackSize - 1;
                this.stackSize = i3;
                int[] iArr = this.pathIndices;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
                this.peeked = 0;
                return;
            }
            throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void endObject() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 2) {
                int i3 = this.stackSize - 1;
                this.stackSize = i3;
                this.pathNames[i3] = null;
                int[] iArr = this.pathIndices;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
                this.peeked = 0;
                return;
            }
            throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean nextBoolean() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 5) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return true;
            } else if (i2 == 6) {
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return false;
            } else {
                throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 16) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return this.peekedLong;
            }
            if (i2 == 17) {
                this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
            } else if (i2 == 9) {
                this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (i2 == 8) {
                this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (i2 == 10) {
                this.peekedString = nextUnquotedValue();
            } else if (i2 != 11) {
                throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
            }
            this.peeked = 11;
            try {
                double parseDouble = Double.parseDouble(this.peekedString);
                if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                    throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
                }
                this.peekedString = null;
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseDouble;
            } catch (NumberFormatException unused) {
                throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
            }
        }
        return invokeV.doubleValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() throws IOException {
        InterceptResult invokeV;
        String nextQuotedValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 16) {
                long j = this.peekedLong;
                int i3 = (int) j;
                if (j == i3) {
                    this.peeked = 0;
                    int[] iArr = this.pathIndices;
                    int i4 = this.stackSize - 1;
                    iArr[i4] = iArr[i4] + 1;
                    return i3;
                }
                throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
            }
            if (i2 == 17) {
                this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
            } else if (i2 == 9 || i2 == 8) {
                if (i2 == 9) {
                    nextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                } else {
                    nextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
                }
                this.peekedString = nextQuotedValue;
                try {
                    int parseInt = Integer.parseInt(nextQuotedValue);
                    this.peeked = 0;
                    int[] iArr2 = this.pathIndices;
                    int i5 = this.stackSize - 1;
                    iArr2[i5] = iArr2[i5] + 1;
                    return parseInt;
                } catch (NumberFormatException unused) {
                }
            } else if (i2 != 11) {
                throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
            }
            this.peeked = 11;
            try {
                double parseDouble = Double.parseDouble(this.peekedString);
                int i6 = (int) parseDouble;
                if (i6 == parseDouble) {
                    this.peekedString = null;
                    this.peeked = 0;
                    int[] iArr3 = this.pathIndices;
                    int i7 = this.stackSize - 1;
                    iArr3[i7] = iArr3[i7] + 1;
                    return i6;
                }
                throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
            } catch (NumberFormatException unused2) {
                throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
            }
        }
        return invokeV.intValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextName() throws IOException {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 14) {
                str = nextUnquotedValue();
            } else if (i2 == 13) {
                str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (i2 == 12) {
                str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (i2 == 15) {
                str = this.peekedString;
            } else {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextString() throws IOException {
        InterceptResult invokeV;
        String readUtf8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 10) {
                readUtf8 = nextUnquotedValue();
            } else if (i2 == 9) {
                readUtf8 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (i2 == 8) {
                readUtf8 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (i2 == 11) {
                readUtf8 = this.peekedString;
                this.peekedString = null;
            } else if (i2 == 16) {
                readUtf8 = Long.toString(this.peekedLong);
            } else if (i2 == 17) {
                readUtf8 = this.buffer.readUtf8(this.peekedNumberLength);
            } else {
                throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return readUtf8;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            switch (i2) {
                case 1:
                    return JsonReader.Token.BEGIN_OBJECT;
                case 2:
                    return JsonReader.Token.END_OBJECT;
                case 3:
                    return JsonReader.Token.BEGIN_ARRAY;
                case 4:
                    return JsonReader.Token.END_ARRAY;
                case 5:
                case 6:
                    return JsonReader.Token.BOOLEAN;
                case 7:
                    return JsonReader.Token.NULL;
                case 8:
                case 9:
                case 10:
                case 11:
                    return JsonReader.Token.STRING;
                case 12:
                case 13:
                case 14:
                case 15:
                    return JsonReader.Token.NAME;
                case 16:
                case 17:
                    return JsonReader.Token.NUMBER;
                case 18:
                    return JsonReader.Token.END_DOCUMENT;
                default:
                    throw new AssertionError();
            }
        }
        return (JsonReader.Token) invokeV.objValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, options)) == null) {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 < 12 || i2 > 15) {
                return -1;
            }
            if (i2 == 15) {
                return findName(this.peekedString, options);
            }
            int select = this.source.select(options.doubleQuoteSuffix);
            if (select != -1) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = options.strings[select];
                return select;
            }
            String str = this.pathNames[this.stackSize - 1];
            String nextName = nextName();
            int findName = findName(nextName, options);
            if (findName == -1) {
                this.peeked = 15;
                this.peekedString = nextName;
                this.pathNames[this.stackSize - 1] = str;
            }
            return findName;
        }
        return invokeL.intValue;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (!this.failOnUnknown) {
                int i2 = this.peeked;
                if (i2 == 0) {
                    i2 = doPeek();
                }
                if (i2 == 14) {
                    skipUnquotedValue();
                } else if (i2 == 13) {
                    skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                } else if (i2 == 12) {
                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                } else if (i2 != 15) {
                    throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
                }
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = StringUtil.NULL_STRING;
                return;
            }
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!this.failOnUnknown) {
                int i2 = 0;
                do {
                    int i3 = this.peeked;
                    if (i3 == 0) {
                        i3 = doPeek();
                    }
                    if (i3 == 3) {
                        pushScope(1);
                    } else if (i3 == 1) {
                        pushScope(3);
                    } else {
                        if (i3 == 4) {
                            i2--;
                            if (i2 >= 0) {
                                this.stackSize--;
                            } else {
                                throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                            }
                        } else if (i3 == 2) {
                            i2--;
                            if (i2 >= 0) {
                                this.stackSize--;
                            } else {
                                throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                            }
                        } else if (i3 == 14 || i3 == 10) {
                            skipUnquotedValue();
                        } else if (i3 == 9 || i3 == 13) {
                            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                        } else if (i3 == 8 || i3 == 12) {
                            skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                        } else if (i3 == 17) {
                            this.buffer.skip(this.peekedNumberLength);
                        } else if (i3 == 18) {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                        this.peeked = 0;
                    }
                    i2++;
                    this.peeked = 0;
                } while (i2 != 0);
                int[] iArr = this.pathIndices;
                int i4 = this.stackSize;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
                this.pathNames[i4 - 1] = StringUtil.NULL_STRING;
                return;
            }
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "JsonReader(" + this.source + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
