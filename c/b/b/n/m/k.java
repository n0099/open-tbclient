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
/* loaded from: classes3.dex */
public class k implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final IntBuffer f22696g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.n.j a;

    /* renamed from: b  reason: collision with root package name */
    public final FloatBuffer f22697b;

    /* renamed from: c  reason: collision with root package name */
    public final ByteBuffer f22698c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f22699d;

    /* renamed from: e  reason: collision with root package name */
    public int f22700e;

    /* renamed from: f  reason: collision with root package name */
    public int f22701f;

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
        f22696g = BufferUtils.d(1);
    }

    public k(boolean z, int i, c.b.b.n.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22701f = -1;
        new c.b.b.q.l();
        this.a = jVar;
        ByteBuffer e2 = BufferUtils.e(jVar.f22486b * i);
        this.f22698c = e2;
        FloatBuffer asFloatBuffer = e2.asFloatBuffer();
        this.f22697b = asFloatBuffer;
        this.f22699d = true;
        asFloatBuffer.flip();
        this.f22698c.flip();
        this.f22700e = c.b.b.f.f22335f.n();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f22696g.clear();
            c.b.b.f.f22336g.v(1, f22696g);
            this.f22701f = f22696g.get();
        }
    }

    @Override // c.b.b.n.m.l
    public c.b.b.n.j b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f22697b.limit() * 4) / this.a.f22486b : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.d dVar = c.b.b.f.f22336g;
            dVar.E(34962, 0);
            dVar.b(this.f22700e);
            this.f22700e = 0;
            if (this.f22699d) {
                BufferUtils.b(this.f22698c);
            }
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22701f == -1) {
            return;
        }
        f22696g.clear();
        f22696g.put(this.f22701f);
        f22696g.flip();
        c.b.b.f.f22336g.A(1, f22696g);
        this.f22701f = -1;
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22697b : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22700e = c.b.b.f.f22336g.n();
            a();
        }
    }
}
