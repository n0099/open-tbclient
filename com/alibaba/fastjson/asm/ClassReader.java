package com.alibaba.fastjson.asm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class ClassReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f35473b;
    public final int header;
    public final int[] items;
    public final int maxStringLength;
    public boolean readAnnotations;
    public final String[] strings;

    public ClassReader(InputStream inputStream, boolean z) throws IOException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.readAnnotations = z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i2 = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f35473b = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[readUnsignedShort(8)];
        this.items = iArr;
        int length = iArr.length;
        this.strings = new String[length];
        int i5 = 10;
        int i6 = 1;
        while (i6 < length) {
            int i7 = i5 + 1;
            this.items[i6] = i7;
            byte b2 = this.f35473b[i5];
            int i8 = 5;
            if (b2 == 1) {
                i8 = readUnsignedShort(i7) + 3;
                if (i8 > i2) {
                    i2 = i8;
                }
            } else if (b2 == 15) {
                i8 = 4;
            } else if (b2 != 18 && b2 != 3 && b2 != 4) {
                if (b2 == 5 || b2 == 6) {
                    i8 = 9;
                    i6++;
                } else {
                    switch (b2) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            i8 = 3;
                            continue;
                    }
                }
            }
            i5 += i8;
            i6++;
        }
        this.maxStringLength = i2;
        this.header = i5;
    }

    private int getAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i2 = this.header;
            int readUnsignedShort = i2 + 8 + (readUnsignedShort(i2 + 6) * 2);
            for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
                for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                    readUnsignedShort += readInt(readUnsignedShort + 12) + 6;
                }
                readUnsignedShort += 8;
            }
            int i3 = readUnsignedShort + 2;
            for (int readUnsignedShort4 = readUnsignedShort(i3); readUnsignedShort4 > 0; readUnsignedShort4--) {
                for (int readUnsignedShort5 = readUnsignedShort(i3 + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                    i3 += readInt(i3 + 12) + 6;
                }
                i3 += 8;
            }
            return i3 + 2;
        }
        return invokeV.intValue;
    }

    private int readInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            byte[] bArr = this.f35473b;
            return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
        }
        return invokeI.intValue;
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, typeCollector, cArr, i2)) == null) {
            int readUnsignedShort = readUnsignedShort(i2);
            String readUTF8 = readUTF8(i2 + 2, cArr);
            String readUTF82 = readUTF8(i2 + 4, cArr);
            int i3 = i2 + 8;
            int i4 = 0;
            int i5 = 0;
            for (int readUnsignedShort2 = readUnsignedShort(i2 + 6); readUnsignedShort2 > 0; readUnsignedShort2--) {
                String readUTF83 = readUTF8(i3, cArr);
                int readInt = readInt(i3 + 2);
                int i6 = i3 + 6;
                if (readUTF83.equals("Code")) {
                    i5 = i6;
                }
                i3 = i6 + readInt;
            }
            MethodCollector visitMethod = typeCollector.visitMethod(readUnsignedShort, readUTF8, readUTF82);
            if (visitMethod != null && i5 != 0) {
                int readInt2 = i5 + 8 + readInt(i5 + 4);
                int i7 = readInt2 + 2;
                for (int readUnsignedShort3 = readUnsignedShort(readInt2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                    i7 += 8;
                }
                int i8 = i7 + 2;
                int i9 = 0;
                for (int readUnsignedShort4 = readUnsignedShort(i7); readUnsignedShort4 > 0; readUnsignedShort4--) {
                    String readUTF84 = readUTF8(i8, cArr);
                    if (readUTF84.equals("LocalVariableTable")) {
                        i4 = i8 + 6;
                    } else if (readUTF84.equals("LocalVariableTypeTable")) {
                        i9 = i8 + 6;
                    }
                    i8 += readInt(i8 + 2) + 6;
                }
                if (i4 != 0) {
                    if (i9 != 0) {
                        int readUnsignedShort5 = readUnsignedShort(i9) * 3;
                        int i10 = i9 + 2;
                        int[] iArr = new int[readUnsignedShort5];
                        while (readUnsignedShort5 > 0) {
                            int i11 = readUnsignedShort5 - 1;
                            iArr[i11] = i10 + 6;
                            int i12 = i11 - 1;
                            iArr[i12] = readUnsignedShort(i10 + 8);
                            readUnsignedShort5 = i12 - 1;
                            iArr[readUnsignedShort5] = readUnsignedShort(i10);
                            i10 += 10;
                        }
                    }
                    int i13 = i4 + 2;
                    for (int readUnsignedShort6 = readUnsignedShort(i4); readUnsignedShort6 > 0; readUnsignedShort6--) {
                        visitMethod.visitLocalVariable(readUTF8(i13 + 4, cArr), readUnsignedShort(i13 + 8));
                        i13 += 10;
                    }
                }
            }
            return i3;
        }
        return invokeLLI.intValue;
    }

    private String readUTF(int i2, int i3, char[] cArr) {
        InterceptResult invokeIIL;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, cArr)) == null) {
            int i5 = i3 + i2;
            byte[] bArr = this.f35473b;
            int i6 = 0;
            char c2 = 0;
            char c3 = 0;
            while (i2 < i5) {
                int i7 = i2 + 1;
                byte b2 = bArr[i2];
                if (c2 != 0) {
                    if (c2 == 1) {
                        cArr[i6] = (char) ((b2 & 63) | (c3 << 6));
                        i6++;
                        c2 = 0;
                    } else if (c2 == 2) {
                        i4 = (b2 & 63) | (c3 << 6);
                        c3 = (char) i4;
                        c2 = 1;
                    }
                    i2 = i7;
                } else {
                    int i8 = b2 & 255;
                    if (i8 < 128) {
                        cArr[i6] = (char) i8;
                        i6++;
                    } else if (i8 >= 224 || i8 <= 191) {
                        c3 = (char) (i8 & 15);
                        c2 = 2;
                    } else {
                        i4 = i8 & 31;
                        c3 = (char) i4;
                        c2 = 1;
                    }
                    i2 = i7;
                }
            }
            return new String(cArr, 0, i6);
        }
        return (String) invokeIIL.objValue;
    }

    private String readUTF8(int i2, char[] cArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, cArr)) == null) {
            int readUnsignedShort = readUnsignedShort(i2);
            String[] strArr = this.strings;
            String str = strArr[readUnsignedShort];
            if (str != null) {
                return str;
            }
            int i3 = this.items[readUnsignedShort];
            String readUTF = readUTF(i3 + 2, readUnsignedShort(i3), cArr);
            strArr[readUnsignedShort] = readUTF;
            return readUTF;
        }
        return (String) invokeIL.objValue;
    }

    private int readUnsignedShort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            byte[] bArr = this.f35473b;
            return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
        }
        return invokeI.intValue;
    }

    public void accept(TypeCollector typeCollector) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, typeCollector) == null) {
            char[] cArr = new char[this.maxStringLength];
            if (this.readAnnotations) {
                int attributes = getAttributes();
                for (int readUnsignedShort = readUnsignedShort(attributes); readUnsignedShort > 0; readUnsignedShort--) {
                    if ("RuntimeVisibleAnnotations".equals(readUTF8(attributes + 2, cArr))) {
                        i2 = attributes + 8;
                        break;
                    }
                    attributes += readInt(attributes + 4) + 6;
                }
            }
            i2 = 0;
            int i3 = this.header;
            int readUnsignedShort2 = readUnsignedShort(i3 + 6);
            int i4 = i3 + 8;
            for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
                i4 += 2;
            }
            int i6 = i4 + 2;
            int i7 = i6;
            for (int readUnsignedShort3 = readUnsignedShort(i4); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i7 += 8;
                for (int readUnsignedShort4 = readUnsignedShort(i7 + 6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                    i7 += readInt(i7 + 2) + 6;
                }
            }
            int i8 = i7 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i7); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i8 += 8;
                for (int readUnsignedShort6 = readUnsignedShort(i8 + 6); readUnsignedShort6 > 0; readUnsignedShort6--) {
                    i8 += readInt(i8 + 2) + 6;
                }
            }
            int i9 = i8 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i8); readUnsignedShort7 > 0; readUnsignedShort7--) {
                i9 += readInt(i9 + 2) + 6;
            }
            if (i2 != 0) {
                int i10 = i2 + 2;
                for (int readUnsignedShort8 = readUnsignedShort(i2); readUnsignedShort8 > 0; readUnsignedShort8--) {
                    typeCollector.visitAnnotation(readUTF8(i10, cArr));
                }
            }
            for (int readUnsignedShort9 = readUnsignedShort(i4); readUnsignedShort9 > 0; readUnsignedShort9--) {
                i6 += 8;
                for (int readUnsignedShort10 = readUnsignedShort(i6 + 6); readUnsignedShort10 > 0; readUnsignedShort10--) {
                    i6 += readInt(i6 + 2) + 6;
                }
            }
            int i11 = i6 + 2;
            for (int readUnsignedShort11 = readUnsignedShort(i6); readUnsignedShort11 > 0; readUnsignedShort11--) {
                i11 = readMethod(typeCollector, cArr, i11);
            }
        }
    }
}
