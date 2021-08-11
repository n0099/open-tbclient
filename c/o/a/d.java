package c.o.a;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import java.io.IOException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSink f34195a;

    public d(BufferedSink bufferedSink) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSink};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34195a = bufferedSink;
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (-(i2 & 1)) ^ (i2 >>> 1) : invokeI.intValue;
    }

    public static long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? (-(j2 & 1)) ^ (j2 >>> 1) : invokeJ.longValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? (i2 >> 31) ^ (i2 << 1) : invokeI.intValue;
    }

    public static long d(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) ? (j2 >> 63) ^ (j2 << 1) : invokeJ.longValue;
    }

    public static int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 >= 0) {
                return i(i2);
            }
            return 10;
        }
        return invokeI.intValue;
    }

    public static int f(int i2, FieldEncoding fieldEncoding) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, fieldEncoding)) == null) ? (i2 << 3) | fieldEncoding.value : invokeIL.intValue;
    }

    public static int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i(f(i2, FieldEncoding.VARINT)) : invokeI.intValue;
    }

    public static int h(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                char charAt = str.charAt(i3);
                if (charAt >= 128) {
                    if (charAt < 2048) {
                        i4 += 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i4 += 3;
                    } else if (charAt <= 56319 && (i2 = i3 + 1) < length && str.charAt(i2) >= 56320 && str.charAt(i2) <= 57343) {
                        i4 += 4;
                        i3 = i2;
                    }
                    i3++;
                }
                i4++;
                i3++;
            }
            return i4;
        }
        return invokeL.intValue;
    }

    public static int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            if ((i2 & com.alipay.sdk.encrypt.a.f35772g) == 0) {
                return 1;
            }
            if ((i2 & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i2) == 0) {
                return 3;
            }
            return (i2 & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
        }
        return invokeI.intValue;
    }

    public static int j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) {
            if (((-128) & j2) == 0) {
                return 1;
            }
            if (((-16384) & j2) == 0) {
                return 2;
            }
            if ((CoroutineScheduler.PARKED_VERSION_MASK & j2) == 0) {
                return 3;
            }
            if (((-268435456) & j2) == 0) {
                return 4;
            }
            if (((-34359738368L) & j2) == 0) {
                return 5;
            }
            if (((-4398046511104L) & j2) == 0) {
                return 6;
            }
            if (((-562949953421312L) & j2) == 0) {
                return 7;
            }
            if (((-72057594037927936L) & j2) == 0) {
                return 8;
            }
            return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
        }
        return invokeJ.intValue;
    }

    public void k(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteString) == null) {
            this.f34195a.write(byteString);
        }
    }

    public void l(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f34195a.writeIntLe(i2);
        }
    }

    public void m(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f34195a.writeLongLe(j2);
        }
    }

    public void n(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 >= 0) {
                q(i2);
            } else {
                r(i2);
            }
        }
    }

    public void o(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f34195a.writeUtf8(str);
        }
    }

    public void p(int i2, FieldEncoding fieldEncoding) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, fieldEncoding) == null) {
            q(f(i2, fieldEncoding));
        }
    }

    public void q(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            while ((i2 & com.alipay.sdk.encrypt.a.f35772g) != 0) {
                this.f34195a.writeByte((i2 & 127) | 128);
                i2 >>>= 7;
            }
            this.f34195a.writeByte(i2);
        }
    }

    public void r(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            while (((-128) & j2) != 0) {
                this.f34195a.writeByte((((int) j2) & 127) | 128);
                j2 >>>= 7;
            }
            this.f34195a.writeByte((int) j2);
        }
    }
}
