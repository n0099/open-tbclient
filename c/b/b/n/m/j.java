package c.b.b.n.m;

import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes9.dex */
public class j implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.b.b.n.j f28185e;

    /* renamed from: f  reason: collision with root package name */
    public FloatBuffer f28186f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f28187g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28188h;

    /* renamed from: i  reason: collision with root package name */
    public int f28189i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28190j;

    public j(boolean z, int i2, c.b.b.n.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28190j = false;
        this.f28189i = c.b.b.f.f27773f.n();
        ByteBuffer e2 = BufferUtils.e(jVar.f27939f * i2);
        e2.limit(0);
        a(e2, true, jVar);
        f(z ? 35044 : 35048);
    }

    public void a(Buffer buffer, boolean z, c.b.b.n.j jVar) {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{buffer, Boolean.valueOf(z), jVar}) == null) {
            if (!this.f28190j) {
                if (this.f28188h && (byteBuffer = this.f28187g) != null) {
                    BufferUtils.b(byteBuffer);
                }
                this.f28185e = jVar;
                if (buffer instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) buffer;
                    this.f28187g = byteBuffer2;
                    this.f28188h = z;
                    int limit = byteBuffer2.limit();
                    ByteBuffer byteBuffer3 = this.f28187g;
                    byteBuffer3.limit(byteBuffer3.capacity());
                    this.f28186f = this.f28187g.asFloatBuffer();
                    this.f28187g.limit(limit);
                    this.f28186f.limit(limit / 4);
                    return;
                }
                throw new GdxRuntimeException("Only ByteBuffer is currently supported");
            }
            throw new GdxRuntimeException("Cannot change attributes while VBO is bound");
        }
    }

    @Override // c.b.b.n.m.l
    public c.b.b.n.j b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28185e : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f28186f.limit() * 4) / this.f28185e.f27939f : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27773f;
            cVar.E(34962, 0);
            cVar.b(this.f28189i);
            this.f28189i = 0;
            if (this.f28188h) {
                BufferUtils.b(this.f28187g);
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.f28190j) {
            throw new GdxRuntimeException("Cannot change usage while VBO is bound");
        }
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28186f : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28189i = c.b.b.f.f27773f.n();
        }
    }
}
