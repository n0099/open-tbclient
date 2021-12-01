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
/* loaded from: classes7.dex */
public class k implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final IntBuffer f27742k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.n.j f27743e;

    /* renamed from: f  reason: collision with root package name */
    public final FloatBuffer f27744f;

    /* renamed from: g  reason: collision with root package name */
    public final ByteBuffer f27745g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f27746h;

    /* renamed from: i  reason: collision with root package name */
    public int f27747i;

    /* renamed from: j  reason: collision with root package name */
    public int f27748j;

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
        f27742k = BufferUtils.d(1);
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
        this.f27748j = -1;
        new c.b.b.q.l();
        this.f27743e = jVar;
        ByteBuffer e2 = BufferUtils.e(jVar.f27490f * i2);
        this.f27745g = e2;
        FloatBuffer asFloatBuffer = e2.asFloatBuffer();
        this.f27744f = asFloatBuffer;
        this.f27746h = true;
        asFloatBuffer.flip();
        this.f27745g.flip();
        this.f27747i = c.b.b.f.f27324f.n();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f27742k.clear();
            c.b.b.f.f27325g.v(1, f27742k);
            this.f27748j = f27742k.get();
        }
    }

    @Override // c.b.b.n.m.l
    public c.b.b.n.j b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27743e : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f27744f.limit() * 4) / this.f27743e.f27490f : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.d dVar = c.b.b.f.f27325g;
            dVar.E(34962, 0);
            dVar.b(this.f27747i);
            this.f27747i = 0;
            if (this.f27746h) {
                BufferUtils.b(this.f27745g);
            }
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f27748j == -1) {
            return;
        }
        f27742k.clear();
        f27742k.put(this.f27748j);
        f27742k.flip();
        c.b.b.f.f27325g.A(1, f27742k);
        this.f27748j = -1;
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27744f : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27747i = c.b.b.f.f27325g.n();
            a();
        }
    }
}
