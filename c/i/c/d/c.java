package c.i.c.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.hash.Funnel;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public abstract class c implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.i.c.d.f, c.i.c.d.j
    public /* bridge */ /* synthetic */ j c(CharSequence charSequence) {
        c(charSequence);
        return this;
    }

    @Override // c.i.c.d.f
    public <T> f g(T t, Funnel<? super T> funnel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, t, funnel)) == null) {
            funnel.funnel(t, this);
            return this;
        }
        return (f) invokeLL.objValue;
    }

    @Override // c.i.c.d.f
    public abstract f h(byte[] bArr, int i2, int i3);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.c.d.j
    /* renamed from: j */
    public f f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) ? h(bArr, 0, bArr.length) : (f) invokeL.objValue;
    }

    public abstract f k(char c2);

    @Override // c.i.c.d.f, c.i.c.d.j
    public f c(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                k(charSequence.charAt(i2));
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.c.d.f, c.i.c.d.j
    public f d(CharSequence charSequence, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, charset)) == null) ? f(charSequence.toString().getBytes(charset)) : (f) invokeLL.objValue;
    }
}
