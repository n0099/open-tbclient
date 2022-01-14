package c.b.b.n.m;

import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes9.dex */
public class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ShortBuffer f27310e;

    /* renamed from: f  reason: collision with root package name */
    public final ByteBuffer f27311f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f27312g;

    /* renamed from: h  reason: collision with root package name */
    public int f27313h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f27314i;

    public d(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z2 = i2 == 0;
        this.f27314i = z2;
        ByteBuffer e2 = BufferUtils.e((z2 ? 1 : i2) * 2);
        this.f27311f = e2;
        ShortBuffer asShortBuffer = e2.asShortBuffer();
        this.f27310e = asShortBuffer;
        this.f27312g = true;
        asShortBuffer.flip();
        this.f27311f.flip();
        this.f27313h = c.b.b.f.f26940f.n();
    }

    @Override // c.b.b.n.m.e, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.f.f26940f.E(34963, 0);
            c.b.b.f.f26940f.b(this.f27313h);
            this.f27313h = 0;
            if (this.f27312g) {
                BufferUtils.b(this.f27311f);
            }
        }
    }

    @Override // c.b.b.n.m.e
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f27314i) {
                return 0;
            }
            return this.f27310e.limit();
        }
        return invokeV.intValue;
    }

    @Override // c.b.b.n.m.e
    public ShortBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27310e : (ShortBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.e
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27313h = c.b.b.f.f26940f.n();
        }
    }
}
