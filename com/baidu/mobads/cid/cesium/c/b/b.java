package com.baidu.mobads.cid.cesium.c.b;

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
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f8307a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final int f8308b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1962282511, "Lcom/baidu/mobads/cid/cesium/c/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1962282511, "Lcom/baidu/mobads/cid/cesium/c/b/b;");
                return;
            }
        }
        f8307a = c(new byte[]{Constants.SHORT_PING_CMD_TYPE, 120, 112, 97, 110, 100, 32, 51, 50, UtilsBlink.VER_TYPE_SEPARATOR, 98, 121, 116, Constants.SHORT_PING_CMD_TYPE, 32, 107});
    }

    public b(int i2) {
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
        this.f8308b = i2;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? (i2 >>> (-i3)) | (i2 << i3) : invokeII.intValue;
    }

    private void a(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, this, bArr, bArr2, byteBuffer, byteBuffer2) == null) {
            int remaining = byteBuffer2.remaining();
            int i2 = (remaining / 64) + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                ByteBuffer a2 = a(bArr, bArr2, this.f8308b + i3);
                if (i3 == i2 - 1) {
                    a.a(byteBuffer, byteBuffer2, a2, remaining % 64);
                } else {
                    a.a(byteBuffer, byteBuffer2, a2, 64);
                }
            }
        }
    }

    public static void a(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr) == null) {
            for (int i2 = 0; i2 < 10; i2++) {
                a(iArr, 0, 4, 8, 12);
                a(iArr, 1, 5, 9, 13);
                a(iArr, 2, 6, 10, 14);
                a(iArr, 3, 7, 11, 15);
                a(iArr, 0, 5, 10, 15);
                a(iArr, 1, 6, 11, 12);
                a(iArr, 2, 7, 8, 13);
                a(iArr, 3, 4, 9, 14);
            }
        }
    }

    public static void a(int[] iArr, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{iArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            iArr[i2] = iArr[i2] + iArr[i3];
            iArr[i5] = a(iArr[i5] ^ iArr[i2], 16);
            iArr[i4] = iArr[i4] + iArr[i5];
            iArr[i3] = a(iArr[i3] ^ iArr[i4], 12);
            iArr[i2] = iArr[i2] + iArr[i3];
            iArr[i5] = a(iArr[i2] ^ iArr[i5], 8);
            iArr[i4] = iArr[i4] + iArr[i5];
            iArr[i3] = a(iArr[i3] ^ iArr[i4], 7);
        }
    }

    public static void a(int[] iArr, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, iArr, iArr2) == null) {
            int[] iArr3 = f8307a;
            System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
            System.arraycopy(iArr2, 0, iArr, f8307a.length, 8);
        }
    }

    public static int[] c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
            int[] iArr = new int[asIntBuffer.remaining()];
            asIntBuffer.get(iArr);
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }

    public ByteBuffer a(byte[] bArr, byte[] bArr2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2, i2)) == null) {
            int[] a2 = a(c(bArr), c(bArr2), i2);
            int[] iArr = (int[]) a2.clone();
            a(iArr);
            for (int i3 = 0; i3 < a2.length; i3++) {
                a2[i3] = a2[i3] + iArr[i3];
            }
            ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
            order.asIntBuffer().put(a2, 0, 16);
            return order;
        }
        return (ByteBuffer) invokeLLI.objValue;
    }

    public void a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer, bArr, bArr2) == null) {
            if (byteBuffer.remaining() - a() < bArr.length) {
                throw new IllegalArgumentException("data output is too small");
            }
            if (bArr2 == null) {
                bArr2 = new byte[a()];
                new Random().nextBytes(bArr2);
            }
            byteBuffer.put(bArr2);
            a(bArr2, com.baidu.mobads.cid.cesium.c.c.b.a(), byteBuffer, ByteBuffer.wrap(bArr));
        }
    }

    public byte[] a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            if (byteBuffer.remaining() >= a()) {
                byte[] bArr = new byte[a()];
                byteBuffer.get(bArr);
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
                a(bArr, com.baidu.mobads.cid.cesium.c.c.b.b(), allocate, byteBuffer);
                return allocate.array();
            }
            throw new GeneralSecurityException("data too short");
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) ? a(bArr, (byte[]) null) : (byte[]) invokeL.objValue;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bArr, bArr2)) == null) {
            if (bArr.length <= Integer.MAX_VALUE - a()) {
                ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
                a(allocate, bArr, bArr2);
                return allocate.array();
            }
            throw new GeneralSecurityException("data too long");
        }
        return (byte[]) invokeLL.objValue;
    }

    public int[] a(int[] iArr, int[] iArr2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, iArr, iArr2, i2)) == null) {
            if (iArr.length == a() / 4) {
                int[] iArr3 = new int[16];
                a(iArr3, iArr2);
                iArr3[12] = i2;
                System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
                return iArr3;
            }
            throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
        }
        return (int[]) invokeLLI.objValue;
    }

    public byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) ? a(ByteBuffer.wrap(bArr)) : (byte[]) invokeL.objValue;
    }
}
