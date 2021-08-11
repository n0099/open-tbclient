package c.a.n0.a.y0.g;

import androidx.annotation.NonNull;
import c.a.n0.a.y0.g.f.a.f;
import c.a.n0.a.y0.g.f.a.g;
import c.a.n0.a.y0.g.f.a.h;
import c.a.n0.a.y0.g.f.a.i;
import c.a.n0.a.y0.g.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.y0.b<c.a.n0.a.y0.g.h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0454a implements a.InterfaceC0455a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0454a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
    public a(@NonNull c.a.n0.a.y0.g.h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.n0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
        this.f9442a.a(new c.a.n0.a.y0.g.f.a.d());
        this.f9442a.a(new c.a.n0.a.y0.g.f.a.e());
        this.f9442a.a(new f());
        this.f9442a.a(new g());
        this.f9442a.a(new h());
        this.f9442a.a(new c.a.n0.a.y0.g.f.a.a());
        this.f9442a.a(new i());
        this.f9442a.a(new c.a.n0.a.y0.g.f.a.b());
        this.f9442a.a(new c.a.n0.a.y0.g.f.a.c());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((c.a.n0.a.y0.g.h.a) this.f9444c).o(new C0454a(this));
        }
    }

    @Override // c.a.n0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((c.a.n0.a.y0.g.h.a) this.f9444c).q()) {
                c.a.n0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            c.a.n0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((c.a.n0.a.y0.g.h.a) this.f9444c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
