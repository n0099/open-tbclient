package c.a.n0.a.o0.g;

import androidx.annotation.NonNull;
import c.a.n0.a.o0.g.f.a.f;
import c.a.n0.a.o0.g.f.a.g;
import c.a.n0.a.o0.g.f.a.h;
import c.a.n0.a.o0.g.f.a.i;
import c.a.n0.a.o0.g.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.o0.b<c.a.n0.a.o0.g.h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.o0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0388a implements a.InterfaceC0389a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0388a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.o0.g.h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.o0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
        this.a.a(new c.a.n0.a.o0.g.f.a.d());
        this.a.a(new c.a.n0.a.o0.g.f.a.e());
        this.a.a(new f());
        this.a.a(new g());
        this.a.a(new h());
        this.a.a(new c.a.n0.a.o0.g.f.a.a());
        this.a.a(new i());
        this.a.a(new c.a.n0.a.o0.g.f.a.b());
        this.a.a(new c.a.n0.a.o0.g.f.a.c());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((c.a.n0.a.o0.g.h.a) this.f5511c).o(new C0388a(this));
        }
    }

    @Override // c.a.n0.a.o0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((c.a.n0.a.o0.g.h.a) this.f5511c).q()) {
                c.a.n0.a.u.d.i("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            c.a.n0.a.u.d.i("InlineRtcItemController", "authorize type：" + ((c.a.n0.a.o0.g.h.a) this.f5511c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
