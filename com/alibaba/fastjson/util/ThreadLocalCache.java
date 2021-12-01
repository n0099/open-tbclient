package com.alibaba.fastjson.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;
/* loaded from: classes7.dex */
public class ThreadLocalCache {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    public static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal;
    public static final ThreadLocal<SoftReference<char[]>> charsBufLocal;
    public static final ThreadLocal<CharsetDecoder> decoderLocal;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1054946037, "Lcom/alibaba/fastjson/util/ThreadLocalCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1054946037, "Lcom/alibaba/fastjson/util/ThreadLocalCache;");
                return;
            }
        }
        charsBufLocal = new ThreadLocal<>();
        decoderLocal = new ThreadLocal<>();
        bytesBufLocal = new ThreadLocal<>();
    }

    public ThreadLocalCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static char[] allocate(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 > 131072) {
                return new char[i2];
            }
            char[] cArr = new char[getAllocateLengthExp(10, 17, i2)];
            charsBufLocal.set(new SoftReference<>(cArr));
            return cArr;
        }
        return (char[]) invokeI.objValue;
    }

    public static byte[] allocateBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 > 131072) {
                return new byte[i2];
            }
            byte[] bArr = new byte[getAllocateLengthExp(10, 17, i2)];
            bytesBufLocal.set(new SoftReference<>(bArr));
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public static void clearBytes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            bytesBufLocal.set(null);
        }
    }

    public static void clearChars() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            charsBufLocal.set(null);
        }
    }

    public static int getAllocateLengthExp(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i2, i3, i4)) == null) ? (i4 >>> i2) <= 0 ? 1 << i2 : 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1)) : invokeIII.intValue;
    }

    public static byte[] getBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            SoftReference<byte[]> softReference = bytesBufLocal.get();
            if (softReference == null) {
                return allocateBytes(i2);
            }
            byte[] bArr = softReference.get();
            if (bArr == null) {
                return allocateBytes(i2);
            }
            return bArr.length < i2 ? allocateBytes(i2) : bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public static char[] getChars(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            SoftReference<char[]> softReference = charsBufLocal.get();
            if (softReference == null) {
                return allocate(i2);
            }
            char[] cArr = softReference.get();
            if (cArr == null) {
                return allocate(i2);
            }
            return cArr.length < i2 ? allocate(i2) : cArr;
        }
        return (char[]) invokeI.objValue;
    }

    public static CharsetDecoder getUTF8Decoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            CharsetDecoder charsetDecoder = decoderLocal.get();
            if (charsetDecoder == null) {
                UTF8Decoder uTF8Decoder = new UTF8Decoder();
                decoderLocal.set(uTF8Decoder);
                return uTF8Decoder;
            }
            return charsetDecoder;
        }
        return (CharsetDecoder) invokeV.objValue;
    }
}
