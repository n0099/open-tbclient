package c.i.d.d;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public abstract class b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public HashCode hashBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) ? hashBytes(bArr, 0, bArr.length) : (HashCode) invokeL.objValue;
    }

    public HashCode hashInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? newHasher(4).a(i2).e() : (HashCode) invokeI.objValue;
    }

    public HashCode hashLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) ? newHasher(8).b(j2).e() : (HashCode) invokeJ.objValue;
    }

    @Override // c.i.d.d.e
    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, t, funnel)) == null) {
            f newHasher = newHasher();
            newHasher.g(t, funnel);
            return newHasher.e();
        }
        return (HashCode) invokeLL.objValue;
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, charSequence, charset)) == null) ? newHasher().d(charSequence, charset).e() : (HashCode) invokeLL.objValue;
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
            f newHasher = newHasher(charSequence.length() * 2);
            newHasher.c(charSequence);
            return newHasher.e();
        }
        return (HashCode) invokeL.objValue;
    }

    public f newHasher(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            n.f(i2 >= 0, "expectedInputSize must be >= 0 but was %s", i2);
            return newHasher();
        }
        return (f) invokeI.objValue;
    }

    public HashCode hashBytes(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
            n.v(i2, i2 + i3, bArr.length);
            return newHasher(i3).h(bArr, i2, i3).e();
        }
        return (HashCode) invokeLII.objValue;
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) ? newHasher(byteBuffer.remaining()).i(byteBuffer).e() : (HashCode) invokeL.objValue;
    }
}
