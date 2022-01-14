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
    public static final IntBuffer k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.n.j f27336e;

    /* renamed from: f  reason: collision with root package name */
    public final FloatBuffer f27337f;

    /* renamed from: g  reason: collision with root package name */
    public final ByteBuffer f27338g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f27339h;

    /* renamed from: i  reason: collision with root package name */
    public int f27340i;

    /* renamed from: j  reason: collision with root package name */
    public int f27341j;

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
        k = BufferUtils.d(1);
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
        this.f27341j = -1;
        new c.b.b.q.l();
        this.f27336e = jVar;
        ByteBuffer e2 = BufferUtils.e(jVar.f27099f * i2);
        this.f27338g = e2;
        FloatBuffer asFloatBuffer = e2.asFloatBuffer();
        this.f27337f = asFloatBuffer;
        this.f27339h = true;
        asFloatBuffer.flip();
        this.f27338g.flip();
        this.f27340i = c.b.b.f.f26940f.n();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k.clear();
            c.b.b.f.f26941g.v(1, k);
            this.f27341j = k.get();
        }
    }

    @Override // c.b.b.n.m.l
    public c.b.b.n.j b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27336e : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f27337f.limit() * 4) / this.f27336e.f27099f : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.d dVar = c.b.b.f.f26941g;
            dVar.E(34962, 0);
            dVar.b(this.f27340i);
            this.f27340i = 0;
            if (this.f27339h) {
                BufferUtils.b(this.f27338g);
            }
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f27341j == -1) {
            return;
        }
        k.clear();
        k.put(this.f27341j);
        k.flip();
        c.b.b.f.f26941g.A(1, k);
        this.f27341j = -1;
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27337f : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27340i = c.b.b.f.f26941g.n();
            a();
        }
    }
}
