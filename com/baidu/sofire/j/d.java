package com.baidu.sofire.j;

import android.hardware.Camera;
import com.baidu.sofire.j.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes11.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        BufferedInputStream bufferedInputStream = null;
        if (!file.exists()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream2.read(bArr, 0, 1024);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused) {
                    com.baidu.sofire.utility.c.a();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused2) {
                    com.baidu.sofire.utility.c.a();
                }
                return byteArray;
            } catch (Throwable unused3) {
                bufferedInputStream = bufferedInputStream2;
                try {
                    com.baidu.sofire.utility.c.a();
                    return new byte[0];
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused5) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
            }
        } catch (Throwable unused6) {
        }
    }

    public static c.a a(Camera.Parameters parameters, c.a aVar) {
        InterceptResult invokeLL;
        List<Camera.Size> list;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, parameters, aVar)) == null) {
            List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedVideoSizes == null || supportedVideoSizes.size() == 0 || supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                return aVar;
            }
            float f2 = aVar.f38475b / aVar.a;
            c.a aVar2 = new c.a(0, 0);
            c.a aVar3 = new c.a(0, 0);
            c.a aVar4 = new c.a(0, 0);
            c.a aVar5 = new c.a(0, 0);
            c.a aVar6 = new c.a(0, 0);
            c.a aVar7 = new c.a(0, 0);
            int i4 = 0;
            while (i4 < supportedVideoSizes.size()) {
                Camera.Size size = supportedVideoSizes.get(i4);
                int i5 = size.width;
                aVar3.a = i5;
                int i6 = size.height;
                aVar3.f38475b = i6;
                if (i5 == aVar.a && i6 == aVar.f38475b) {
                    aVar2.a = i5;
                    aVar2.f38475b = i6;
                    return aVar2;
                }
                float f3 = 0.01f;
                if (Math.abs((size.height / size.width) - f2) < 0.01f && (i2 = aVar3.a) >= aVar2.a && (i3 = aVar3.f38475b) >= aVar2.f38475b && i2 * i3 <= 921600) {
                    aVar2.a = i2;
                    aVar2.f38475b = i3;
                }
                int i7 = 0;
                while (i7 < supportedPreviewSizes.size()) {
                    Camera.Size size2 = supportedPreviewSizes.get(i7);
                    int i8 = size2.width;
                    aVar4.a = i8;
                    int i9 = size2.height;
                    aVar4.f38475b = i9;
                    if (!(aVar3.a == i8 && aVar3.f38475b == i9) && Math.abs((aVar4.f38475b / aVar4.a) - (aVar3.f38475b / aVar3.a)) >= f3) {
                        list = supportedVideoSizes;
                    } else {
                        int i10 = aVar3.a;
                        int i11 = aVar3.f38475b;
                        list = supportedVideoSizes;
                        if (i10 * i11 >= aVar5.a * aVar5.f38475b && i10 * i11 <= 921600) {
                            aVar5.a = i10;
                            aVar5.f38475b = i11;
                            aVar6.f38475b = aVar4.f38475b;
                            aVar6.a = aVar4.a;
                        }
                    }
                    i7++;
                    supportedVideoSizes = list;
                    f3 = 0.01f;
                }
                List<Camera.Size> list2 = supportedVideoSizes;
                int i12 = aVar3.a;
                int i13 = aVar3.f38475b;
                if (i12 * i13 >= aVar7.a * aVar7.f38475b && i12 * i13 <= 921600) {
                    aVar7.a = i12;
                    aVar7.f38475b = i13;
                }
                i4++;
                supportedVideoSizes = list2;
            }
            return aVar2.a > 0 ? aVar2 : aVar5.a > 0 ? aVar5 : aVar7;
        }
        return (c.a) invokeLL.objValue;
    }
}
