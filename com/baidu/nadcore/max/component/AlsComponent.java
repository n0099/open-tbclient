package com.baidu.nadcore.max.component;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.component.AlsComponent$alsService$2;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ap0;
import com.baidu.tieba.cj0;
import com.baidu.tieba.dp0;
import com.baidu.tieba.e11;
import com.baidu.tieba.ep0;
import com.baidu.tieba.k61;
import com.baidu.tieba.mp0;
import com.baidu.tieba.po0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.u01;
import com.baidu.tieba.xo0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006."}, d2 = {"Lcom/baidu/nadcore/max/component/AlsComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "injectService", "()V", "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "type", DnsModel.AREA_KEY, "sendActionAls", "(Ljava/lang/String;Ljava/lang/String;)V", "ext1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setWebViewAlsInfo", "adExtInfo", "Ljava/lang/String;", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "adVideoTimeStamp", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "Lcom/baidu/nadcore/max/service/IAlsService;", "alsService$delegate", "Lkotlin/Lazy;", "getAlsService", "()Lcom/baidu/nadcore/max/service/IAlsService;", "alsService", "", "hasCalculationStartTime", "Z", "hasRecordTime", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AlsComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final mp0 e;
    public boolean f;
    public boolean g;
    public final Lazy h;

    public final ap0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (ap0) this.h.getValue() : (ap0) invokeV.objValue;
    }

    public AlsComponent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new mp0();
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<AlsComponent$alsService$2.a>(this) { // from class: com.baidu.nadcore.max.component.AlsComponent$alsService$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlsComponent this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes2.dex */
            public static final class a implements ap0 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlsComponent$alsService$2 a;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public a(AlsComponent$alsService$2 alsComponent$alsService$2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {alsComponent$alsService$2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = alsComponent$alsService$2;
                }

                @Override // com.baidu.tieba.ap0
                public void a(String type, String area) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(1048576, this, type, area) == null) {
                        Intrinsics.checkNotNullParameter(type, "type");
                        Intrinsics.checkNotNullParameter(area, "area");
                        this.a.this$0.h(type, area);
                    }
                }

                @Override // com.baidu.tieba.ap0
                public void c(String type, String area, String ext1) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, area, ext1) == null) {
                        Intrinsics.checkNotNullParameter(type, "type");
                        Intrinsics.checkNotNullParameter(area, "area");
                        Intrinsics.checkNotNullParameter(ext1, "ext1");
                        this.a.this$0.j(type, area, ext1);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this);
                }
                return (a) invokeV.objValue;
            }
        });
    }

    public final void d(ro0 ro0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ro0Var) == null) {
            int i = po0.$EnumSwitchMapping$0[ro0Var.getType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.g = false;
                    return;
                }
                return;
            }
            this.e.l(System.currentTimeMillis());
            this.g = false;
        }
    }

    public final void f(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                this.d = String.valueOf(hashMap.get("ext_info"));
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            f(intent);
        }
    }

    public final void e(xo0 xo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xo0Var) == null) {
            int i = po0.$EnumSwitchMapping$1[xo0Var.getType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    k();
                    return;
                }
                return;
            }
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var != null && !dp0Var.k()) {
                this.e.h(System.currentTimeMillis());
            } else {
                this.e.g(System.currentTimeMillis());
            }
        }
    }

    public final void h(String type, String area) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, type, area) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(area, "area");
            j(type, area, "");
        }
    }

    public final void j(String type, String area, String ext1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, type, area, ext1) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(area, "area");
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            ClogBuilder u = new ClogBuilder().z(type).u(ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP);
            if (!TextUtils.isEmpty(area)) {
                u.j(area);
            }
            if (!TextUtils.isEmpty(this.d)) {
                u.p(this.d);
            }
            if (!TextUtils.isEmpty(ext1)) {
                u.k(ext1);
            }
            e11.b(u);
        }
    }

    public final void k() {
        k61 g;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var == null || dp0Var.k()) {
                long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
                mp0 mp0Var = this.e;
                mp0Var.i(mp0Var.c() + max);
            }
            ep0 ep0Var = (ep0) b().j(ep0.class);
            if (ep0Var != null && (g = ep0Var.b().g()) != null && (jSONObject = g.d) != null) {
                u01.e(jSONObject, "immersive_video_stay_time", this.e.c());
                u01.e(jSONObject, "immersive_webview_first_show_time", this.e.b());
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void o(cj0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.o(event);
            String a = event.a();
            if (Intrinsics.areEqual(a, ro0.class.getSimpleName())) {
                d((ro0) event);
            } else if (Intrinsics.areEqual(a, xo0.class.getSimpleName())) {
                e((xo0) event);
            } else if (Intrinsics.areEqual(a, qo0.class.getSimpleName())) {
                if (this.e.b() == 0) {
                    this.e.h(System.currentTimeMillis());
                }
                if (!this.g) {
                    this.g = true;
                    dp0 dp0Var = (dp0) b().j(dp0.class);
                    if (dp0Var != null && dp0Var.k()) {
                        long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
                        mp0 mp0Var = this.e;
                        mp0Var.i(mp0Var.c() + max);
                    }
                }
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var == null || !dp0Var.k()) {
                return;
            }
            this.e.j(System.currentTimeMillis());
            long max = Math.max(this.e.d() - Math.max(this.e.e(), this.e.f()), 0L);
            mp0 mp0Var = this.e;
            mp0Var.i(mp0Var.c() + max);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            dp0 dp0Var = (dp0) b().j(dp0.class);
            if (dp0Var == null || !dp0Var.k()) {
                return;
            }
            this.e.k(System.currentTimeMillis());
            if (!this.f) {
                this.e.i(Math.max(this.e.e() - this.e.a(), 0L));
                this.f = true;
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.r();
            b().m(ap0.class, c());
        }
    }
}
