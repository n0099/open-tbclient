package com.alibaba.fastjson.asm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes3.dex */
public class Type {
    public static /* synthetic */ Interceptable $ic;
    public static final Type BOOLEAN_TYPE;
    public static final Type BYTE_TYPE;
    public static final Type CHAR_TYPE;
    public static final Type DOUBLE_TYPE;
    public static final Type FLOAT_TYPE;
    public static final Type INT_TYPE;
    public static final Type LONG_TYPE;
    public static final Type SHORT_TYPE;
    public static final Type VOID_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public final char[] buf;
    public final int len;
    public final int off;
    public final int sort;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1940295855, "Lcom/alibaba/fastjson/asm/Type;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1940295855, "Lcom/alibaba/fastjson/asm/Type;");
                return;
            }
        }
        VOID_TYPE = new Type(0, null, 1443168256, 1);
        BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
        CHAR_TYPE = new Type(2, null, 1124075009, 1);
        BYTE_TYPE = new Type(3, null, 1107297537, 1);
        SHORT_TYPE = new Type(4, null, 1392510721, 1);
        INT_TYPE = new Type(5, null, 1224736769, 1);
        FLOAT_TYPE = new Type(6, null, 1174536705, 1);
        LONG_TYPE = new Type(7, null, 1241579778, 1);
        DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    }

    public Type(int i2, char[] cArr, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), cArr, Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sort = i2;
        this.buf = cArr;
        this.off = i3;
        this.len = i4;
    }

    public static Type[] getArgumentTypes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            char[] charArray = str.toCharArray();
            int i2 = 1;
            int i3 = 1;
            int i4 = 0;
            while (true) {
                int i5 = i3 + 1;
                char c2 = charArray[i3];
                if (c2 == ')') {
                    break;
                } else if (c2 == 'L') {
                    while (true) {
                        i3 = i5 + 1;
                        if (charArray[i5] == ';') {
                            break;
                        }
                        i5 = i3;
                    }
                    i4++;
                } else {
                    if (c2 != '[') {
                        i4++;
                    }
                    i3 = i5;
                }
            }
            Type[] typeArr = new Type[i4];
            int i6 = 0;
            while (charArray[i2] != ')') {
                typeArr[i6] = getType(charArray, i2);
                i2 += typeArr[i6].len + (typeArr[i6].sort == 10 ? 2 : 0);
                i6++;
            }
            return typeArr;
        }
        return (Type[]) invokeL.objValue;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int i3 = 1;
            int i4 = 1;
            int i5 = 1;
            while (true) {
                i2 = i4 + 1;
                char charAt = str.charAt(i4);
                if (charAt == ')') {
                    break;
                } else if (charAt == 'L') {
                    while (true) {
                        i4 = i2 + 1;
                        if (str.charAt(i2) == ';') {
                            break;
                        }
                        i2 = i4;
                    }
                    i5++;
                } else {
                    i5 = (charAt == 'D' || charAt == 'J') ? i5 + 2 : i5 + 1;
                    i4 = i2;
                }
            }
            char charAt2 = str.charAt(i2);
            int i6 = i5 << 2;
            if (charAt2 == 'V') {
                i3 = 0;
            } else if (charAt2 == 'D' || charAt2 == 'J') {
                i3 = 2;
            }
            return i6 | i3;
        }
        return invokeL.intValue;
    }

    private int getDimensions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i2 = 1;
            while (this.buf[this.off + i2] == '[') {
                i2++;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public static Type getType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? getType(str.toCharArray(), 0) : (Type) invokeL.objValue;
    }

    public String getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            switch (this.sort) {
                case 0:
                    return "void";
                case 1:
                    return "boolean";
                case 2:
                    return "char";
                case 3:
                    return "byte";
                case 4:
                    return "short";
                case 5:
                    return "int";
                case 6:
                    return ShaderParams.VALUE_TYPE_FLOAT;
                case 7:
                    return "long";
                case 8:
                    return "double";
                case 9:
                    StringBuilder sb = new StringBuilder(getType(this.buf, this.off + getDimensions()).getClassName());
                    for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                        sb.append("[]");
                    }
                    return sb.toString();
                default:
                    return new String(this.buf, this.off, this.len).replace(WebvttCueParser.CHAR_SLASH, '.');
            }
        }
        return (String) invokeV.objValue;
    }

    public String getDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new String(this.buf, this.off, this.len) : (String) invokeV.objValue;
    }

    public String getInternalName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new String(this.buf, this.off, this.len) : (String) invokeV.objValue;
    }

    public static Type getType(char[] cArr, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, cArr, i2)) == null) {
            char c2 = cArr[i2];
            if (c2 != 'F') {
                if (c2 != 'S') {
                    if (c2 != 'V') {
                        if (c2 != 'I') {
                            if (c2 != 'J') {
                                if (c2 != 'Z') {
                                    if (c2 != '[') {
                                        switch (c2) {
                                            case 'B':
                                                return BYTE_TYPE;
                                            case 'C':
                                                return CHAR_TYPE;
                                            case 'D':
                                                return DOUBLE_TYPE;
                                            default:
                                                int i4 = 1;
                                                while (cArr[i2 + i4] != ';') {
                                                    i4++;
                                                }
                                                return new Type(10, cArr, i2 + 1, i4 - 1);
                                        }
                                    }
                                    int i5 = 1;
                                    while (true) {
                                        i3 = i2 + i5;
                                        if (cArr[i3] != '[') {
                                            break;
                                        }
                                        i5++;
                                    }
                                    if (cArr[i3] == 'L') {
                                        do {
                                            i5++;
                                        } while (cArr[i2 + i5] != ';');
                                        return new Type(9, cArr, i2, i5 + 1);
                                    }
                                    return new Type(9, cArr, i2, i5 + 1);
                                }
                                return BOOLEAN_TYPE;
                            }
                            return LONG_TYPE;
                        }
                        return INT_TYPE;
                    }
                    return VOID_TYPE;
                }
                return SHORT_TYPE;
            }
            return FLOAT_TYPE;
        }
        return (Type) invokeLI.objValue;
    }
}
