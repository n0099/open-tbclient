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
    public c.b.b.n.j f27358e;

    /* renamed from: f  reason: collision with root package name */
    public FloatBuffer f27359f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f27360g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27361h;

    /* renamed from: i  reason: collision with root package name */
    public int f27362i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f27363j;

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
        this.f27363j = false;
        this.f27362i = c.b.b.f.f26968f.n();
        ByteBuffer e2 = BufferUtils.e(jVar.f27127f * i2);
        e2.limit(0);
        a(e2, true, jVar);
        f(z ? 35044 : 35048);
    }

    public void a(Buffer buffer, boolean z, c.b.b.n.j jVar) {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{buffer, Boolean.valueOf(z), jVar}) == null) {
            if (!this.f27363j) {
                if (this.f27361h && (byteBuffer = this.f27360g) != null) {
                    BufferUtils.b(byteBuffer);
                }
                this.f27358e = jVar;
                if (buffer instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) buffer;
                    this.f27360g = byteBuffer2;
                    this.f27361h = z;
                    int limit = byteBuffer2.limit();
                    ByteBuffer byteBuffer3 = this.f27360g;
                    byteBuffer3.limit(byteBuffer3.capacity());
                    this.f27359f = this.f27360g.asFloatBuffer();
                    this.f27360g.limit(limit);
                    this.f27359f.limit(limit / 4);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27358e : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f27359f.limit() * 4) / this.f27358e.f27127f : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f26968f;
            cVar.E(34962, 0);
            cVar.b(this.f27362i);
            this.f27362i = 0;
            if (this.f27361h) {
                BufferUtils.b(this.f27360g);
            }
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.f27363j) {
            throw new GdxRuntimeException("Cannot change usage while VBO is bound");
        }
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27359f : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27362i = c.b.b.f.f26968f.n();
        }
    }
}
