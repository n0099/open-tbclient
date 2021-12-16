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
    public c.b.b.n.j f28111e;

    /* renamed from: f  reason: collision with root package name */
    public FloatBuffer f28112f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f28113g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28114h;

    /* renamed from: i  reason: collision with root package name */
    public int f28115i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28116j;

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
        this.f28116j = false;
        this.f28115i = c.b.b.f.f27699f.n();
        ByteBuffer e2 = BufferUtils.e(jVar.f27865f * i2);
        e2.limit(0);
        a(e2, true, jVar);
        f(z ? 35044 : 35048);
    }

    public void a(Buffer buffer, boolean z, c.b.b.n.j jVar) {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{buffer, Boolean.valueOf(z), jVar}) == null) {
            if (!this.f28116j) {
                if (this.f28114h && (byteBuffer = this.f28113g) != null) {
                    BufferUtils.b(byteBuffer);
                }
                this.f28111e = jVar;
                if (buffer instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) buffer;
                    this.f28113g = byteBuffer2;
                    this.f28114h = z;
                    int limit = byteBuffer2.limit();
                    ByteBuffer byteBuffer3 = this.f28113g;
                    byteBuffer3.limit(byteBuffer3.capacity());
                    this.f28112f = this.f28113g.asFloatBuffer();
                    this.f28113g.limit(limit);
                    this.f28112f.limit(limit / 4);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28111e : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f28112f.limit() * 4) / this.f28111e.f27865f : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27699f;
            cVar.E(34962, 0);
            cVar.b(this.f28115i);
            this.f28115i = 0;
            if (this.f28114h) {
                BufferUtils.b(this.f28113g);
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.f28116j) {
            throw new GdxRuntimeException("Cannot change usage while VBO is bound");
        }
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28112f : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28115i = c.b.b.f.f27699f.n();
        }
    }
}
