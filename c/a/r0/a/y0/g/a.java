package c.a.r0.a.y0.g;

import androidx.annotation.NonNull;
import c.a.r0.a.y0.g.f.a.f;
import c.a.r0.a.y0.g.f.a.g;
import c.a.r0.a.y0.g.f.a.h;
import c.a.r0.a.y0.g.f.a.i;
import c.a.r0.a.y0.g.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class a extends c.a.r0.a.y0.b<c.a.r0.a.y0.g.h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0614a implements a.InterfaceC0615a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0614a(a aVar) {
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
    public a(@NonNull c.a.r0.a.y0.g.h.a aVar) {
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
                super((c.a.r0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
        this.a.a(new c.a.r0.a.y0.g.f.a.d());
        this.a.a(new c.a.r0.a.y0.g.f.a.e());
        this.a.a(new f());
        this.a.a(new g());
        this.a.a(new h());
        this.a.a(new c.a.r0.a.y0.g.f.a.a());
        this.a.a(new i());
        this.a.a(new c.a.r0.a.y0.g.f.a.b());
        this.a.a(new c.a.r0.a.y0.g.f.a.c());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((c.a.r0.a.y0.g.h.a) this.f9801c).o(new C0614a(this));
        }
    }

    @Override // c.a.r0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((c.a.r0.a.y0.g.h.a) this.f9801c).q()) {
                c.a.r0.a.e0.d.i("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            c.a.r0.a.e0.d.i("InlineRtcItemController", "authorize type：" + ((c.a.r0.a.y0.g.h.a) this.f9801c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
