package c.a.o0.a.y0.g;

import androidx.annotation.NonNull;
import c.a.o0.a.y0.g.f.b.a0;
import c.a.o0.a.y0.g.f.b.b0;
import c.a.o0.a.y0.g.f.b.c0;
import c.a.o0.a.y0.g.f.b.d0;
import c.a.o0.a.y0.g.f.b.e0;
import c.a.o0.a.y0.g.f.b.f;
import c.a.o0.a.y0.g.f.b.f0;
import c.a.o0.a.y0.g.f.b.g;
import c.a.o0.a.y0.g.f.b.g0;
import c.a.o0.a.y0.g.f.b.h;
import c.a.o0.a.y0.g.f.b.h0;
import c.a.o0.a.y0.g.f.b.i;
import c.a.o0.a.y0.g.f.b.j;
import c.a.o0.a.y0.g.f.b.k;
import c.a.o0.a.y0.g.f.b.l;
import c.a.o0.a.y0.g.f.b.m;
import c.a.o0.a.y0.g.f.b.n;
import c.a.o0.a.y0.g.f.b.o;
import c.a.o0.a.y0.g.f.b.p;
import c.a.o0.a.y0.g.f.b.q;
import c.a.o0.a.y0.g.f.b.r;
import c.a.o0.a.y0.g.f.b.s;
import c.a.o0.a.y0.g.f.b.t;
import c.a.o0.a.y0.g.f.b.u;
import c.a.o0.a.y0.g.f.b.v;
import c.a.o0.a.y0.g.f.b.w;
import c.a.o0.a.y0.g.f.b.x;
import c.a.o0.a.y0.g.f.b.y;
import c.a.o0.a.y0.g.f.b.z;
import c.a.o0.a.y0.g.h.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class b extends c.a.o0.a.y0.b<c.a.o0.a.y0.g.h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b.a f9737h;

    /* loaded from: classes.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.o0.a.y0.g.h.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.o0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.f9737h = aVar;
        bVar.Z(aVar);
        this.f9688a.a(new c.a.o0.a.y0.g.f.b.a());
        this.f9688a.a(new c.a.o0.a.y0.g.f.b.b());
        this.f9688a.a(new c.a.o0.a.y0.g.f.b.c());
        this.f9688a.a(new c.a.o0.a.y0.g.f.b.e());
        this.f9688a.a(new g());
        this.f9688a.a(new h());
        this.f9688a.a(new i());
        this.f9688a.a(new j());
        this.f9688a.a(new k());
        this.f9688a.a(new l());
        this.f9688a.a(new c.a.o0.a.y0.g.f.b.d());
        this.f9688a.a(new f());
        this.f9688a.a(new n());
        this.f9688a.a(new o());
        this.f9688a.a(new p());
        this.f9688a.a(new r());
        this.f9688a.a(new q());
        this.f9688a.a(new s());
        this.f9688a.a(new t());
        this.f9688a.a(new u());
        this.f9688a.a(new v());
        this.f9688a.a(new w());
        this.f9688a.a(new x());
        this.f9688a.a(new y());
        this.f9688a.a(new z());
        this.f9688a.a(new a0());
        this.f9688a.a(new b0());
        this.f9688a.a(new c0());
        this.f9688a.a(new d0());
        this.f9688a.a(new e0());
        this.f9688a.a(new f0());
        this.f9688a.a(new h0());
        this.f9688a.a(new g0());
        this.f9688a.a(new m());
    }

    @Override // c.a.o0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((c.a.o0.a.y0.g.h.b) this.f9690c).q()) {
                c.a.o0.a.e0.d.g("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            c.a.o0.a.e0.d.g("InlineRtcRoomController", "authorize type：" + ((c.a.o0.a.y0.g.h.b) this.f9690c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
