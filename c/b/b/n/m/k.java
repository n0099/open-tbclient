package c.b.b.n.m;

import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes9.dex */
public class k implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final IntBuffer f28191k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.n.j f28192e;

    /* renamed from: f  reason: collision with root package name */
    public final FloatBuffer f28193f;

    /* renamed from: g  reason: collision with root package name */
    public final ByteBuffer f28194g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f28195h;

    /* renamed from: i  reason: collision with root package name */
    public int f28196i;

    /* renamed from: j  reason: collision with root package name */
    public int f28197j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339288037, "Lc/b/b/n/m/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339288037, "Lc/b/b/n/m/k;");
                return;
            }
        }
        f28191k = BufferUtils.d(1);
    }

    public k(boolean z, int i2, c.b.b.n.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28197j = -1;
        new c.b.b.q.l();
        this.f28192e = jVar;
        ByteBuffer e2 = BufferUtils.e(jVar.f27939f * i2);
        this.f28194g = e2;
        FloatBuffer asFloatBuffer = e2.asFloatBuffer();
        this.f28193f = asFloatBuffer;
        this.f28195h = true;
        asFloatBuffer.flip();
        this.f28194g.flip();
        this.f28196i = c.b.b.f.f27773f.n();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f28191k.clear();
            c.b.b.f.f27774g.v(1, f28191k);
            this.f28197j = f28191k.get();
        }
    }

    @Override // c.b.b.n.m.l
    public c.b.b.n.j b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28192e : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f28193f.limit() * 4) / this.f28192e.f27939f : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.d dVar = c.b.b.f.f27774g;
            dVar.E(34962, 0);
            dVar.b(this.f28196i);
            this.f28196i = 0;
            if (this.f28195h) {
                BufferUtils.b(this.f28194g);
            }
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f28197j == -1) {
            return;
        }
        f28191k.clear();
        f28191k.put(this.f28197j);
        f28191k.flip();
        c.b.b.f.f27774g.A(1, f28191k);
        this.f28197j = -1;
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28193f : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28196i = c.b.b.f.f27774g.n();
            a();
        }
    }
}
