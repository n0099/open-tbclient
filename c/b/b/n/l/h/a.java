package c.b.b.n.l.h;

import c.b.b.f;
import c.b.b.q.a;
import c.b.b.q.o;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a implements o.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.b.b.n.l.h.g.a f28039e;

    /* renamed from: f  reason: collision with root package name */
    public c.b.b.q.a<c.b.b.n.l.h.h.a> f28040f;

    /* renamed from: g  reason: collision with root package name */
    public c.b.b.n.l.h.i.b<?, ?> f28041g;

    /* renamed from: h  reason: collision with root package name */
    public float f28042h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new Matrix4();
        new Vector3(1.0f, 1.0f, 1.0f);
        this.f28040f = new c.b.b.q.a<>(true, 3, c.b.b.n.l.h.h.a.class);
        d(0.016666668f);
    }

    @Override // c.b.b.q.o.c
    public void a(o oVar, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oVar, jsonValue) == null) {
            String str = (String) oVar.l("name", String.class, jsonValue);
            this.f28039e = (c.b.b.n.l.h.g.a) oVar.l("emitter", c.b.b.n.l.h.g.a.class, jsonValue);
            this.f28040f.b((c.b.b.q.a) oVar.m("influencers", c.b.b.q.a.class, c.b.b.n.l.h.h.a.class, jsonValue));
            this.f28041g = (c.b.b.n.l.h.i.b) oVar.l("renderer", c.b.b.n.l.h.i.b.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28039e.dispose();
            a.b<c.b.b.n.l.h.h.a> it = this.f28040f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void c(c.b.b.j.e eVar, e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, eVar2) == null) {
            this.f28039e.f(eVar, eVar2);
            a.b<c.b.b.n.l.h.h.a> it = this.f28040f.iterator();
            while (it.hasNext()) {
                it.next().f(eVar, eVar2);
            }
            this.f28041g.f(eVar, eVar2);
        }
    }

    public final void d(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.f28042h = f2;
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(f.f27695b.e());
        }
    }

    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            d(f2);
            this.f28039e.update();
            a.b<c.b.b.n.l.h.h.a> it = this.f28040f.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
