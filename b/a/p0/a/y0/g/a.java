package b.a.p0.a.y0.g;

import androidx.annotation.NonNull;
import b.a.p0.a.y0.g.f.a.f;
import b.a.p0.a.y0.g.f.a.g;
import b.a.p0.a.y0.g.f.a.h;
import b.a.p0.a.y0.g.f.a.i;
import b.a.p0.a.y0.g.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.y0.b<b.a.p0.a.y0.g.h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0459a implements a.InterfaceC0460a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0459a(a aVar) {
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
    public a(@NonNull b.a.p0.a.y0.g.h.a aVar) {
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
                super((b.a.p0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
        this.f8960a.a(new b.a.p0.a.y0.g.f.a.d());
        this.f8960a.a(new b.a.p0.a.y0.g.f.a.e());
        this.f8960a.a(new f());
        this.f8960a.a(new g());
        this.f8960a.a(new h());
        this.f8960a.a(new b.a.p0.a.y0.g.f.a.a());
        this.f8960a.a(new i());
        this.f8960a.a(new b.a.p0.a.y0.g.f.a.b());
        this.f8960a.a(new b.a.p0.a.y0.g.f.a.c());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((b.a.p0.a.y0.g.h.a) this.f8962c).o(new C0459a(this));
        }
    }

    @Override // b.a.p0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((b.a.p0.a.y0.g.h.a) this.f8962c).q()) {
                b.a.p0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            b.a.p0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((b.a.p0.a.y0.g.h.a) this.f8962c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
