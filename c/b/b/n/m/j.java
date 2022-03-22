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
/* loaded from: classes3.dex */
public class j implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.b.b.n.j a;

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f22691b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f22692c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22693d;

    /* renamed from: e  reason: collision with root package name */
    public int f22694e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22695f;

    public j(boolean z, int i, c.b.b.n.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22695f = false;
        this.f22694e = c.b.b.f.f22335f.n();
        ByteBuffer e2 = BufferUtils.e(jVar.f22486b * i);
        e2.limit(0);
        a(e2, true, jVar);
        f(z ? 35044 : 35048);
    }

    public void a(Buffer buffer, boolean z, c.b.b.n.j jVar) {
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{buffer, Boolean.valueOf(z), jVar}) == null) {
            if (!this.f22695f) {
                if (this.f22693d && (byteBuffer = this.f22692c) != null) {
                    BufferUtils.b(byteBuffer);
                }
                this.a = jVar;
                if (buffer instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) buffer;
                    this.f22692c = byteBuffer2;
                    this.f22693d = z;
                    int limit = byteBuffer2.limit();
                    ByteBuffer byteBuffer3 = this.f22692c;
                    byteBuffer3.limit(byteBuffer3.capacity());
                    this.f22691b = this.f22692c.asFloatBuffer();
                    this.f22692c.limit(limit);
                    this.f22691b.limit(limit / 4);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.b.b.n.j) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f22691b.limit() * 4) / this.a.f22486b : invokeV.intValue;
    }

    @Override // c.b.b.n.m.l, c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f22335f;
            cVar.E(34962, 0);
            cVar.b(this.f22694e);
            this.f22694e = 0;
            if (this.f22693d) {
                BufferUtils.b(this.f22692c);
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && this.f22695f) {
            throw new GdxRuntimeException("Cannot change usage while VBO is bound");
        }
    }

    @Override // c.b.b.n.m.l
    public FloatBuffer getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22691b : (FloatBuffer) invokeV.objValue;
    }

    @Override // c.b.b.n.m.l
    public void invalidate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22694e = c.b.b.f.f22335f.n();
        }
    }
}
