package com.baidu.nadcore.max.component;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fh0;
import com.repackage.fm0;
import com.repackage.im0;
import com.repackage.iy0;
import com.repackage.lm0;
import com.repackage.mm0;
import com.repackage.t21;
import com.repackage.um0;
import com.repackage.xl0;
import com.repackage.yl0;
import com.repackage.yx0;
import com.repackage.zl0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006."}, d2 = {"Lcom/baidu/nadcore/max/component/AlsComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "Lcom/baidu/nadcore/max/event/WebViewEvent;", "handleWebEvent", "(Lcom/baidu/nadcore/max/event/WebViewEvent;)V", "injectService", "()V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "type", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, "sendActionAls", "(Ljava/lang/String;Ljava/lang/String;)V", "ext1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setWebViewAlsInfo", "adExtInfo", "Ljava/lang/String;", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "adVideoTimeStamp", "Lcom/baidu/nadcore/max/utils/AdVideoTimeStamp;", "Lcom/baidu/nadcore/max/service/IAlsService;", "alsService$delegate", "Lkotlin/Lazy;", "getAlsService", "()Lcom/baidu/nadcore/max/service/IAlsService;", "alsService", "", "hasCalculationStartTime", "Z", "hasRecordTime", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AlsComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final um0 e;
    public boolean f;
    public boolean g;
    public final Lazy h;

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
        this.e = new um0();
        this.h = LazyKt__LazyJVMKt.lazy(new AlsComponent$alsService$2(this));
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.b(intent);
            p(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void c(fh0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            String a = event.a();
            if (Intrinsics.areEqual(a, zl0.class.getSimpleName())) {
                n((zl0) event);
            } else if (Intrinsics.areEqual(a, fm0.class.getSimpleName())) {
                o((fm0) event);
            } else if (Intrinsics.areEqual(a, yl0.class.getSimpleName())) {
                if (this.e.b() == 0) {
                    this.e.h(System.currentTimeMillis());
                }
                if (this.g) {
                    return;
                }
                this.g = true;
                lm0 lm0Var = (lm0) l().q(lm0.class);
                if (lm0Var == null || !lm0Var.k()) {
                    return;
                }
                long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
                um0 um0Var = this.e;
                um0Var.i(um0Var.c() + max);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.f();
            l().t(im0.class, m());
        }
    }

    public final im0 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (im0) this.h.getValue() : (im0) invokeV.objValue;
    }

    public final void n(zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zl0Var) == null) {
            int i = xl0.$EnumSwitchMapping$0[zl0Var.getType().ordinal()];
            if (i == 1) {
                this.e.l(System.currentTimeMillis());
                this.g = false;
            } else if (i != 2) {
            } else {
                this.g = false;
            }
        }
    }

    public final void o(fm0 fm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fm0Var) == null) {
            int i = xl0.$EnumSwitchMapping$1[fm0Var.getType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                s();
                return;
            }
            lm0 lm0Var = (lm0) l().q(lm0.class);
            if (lm0Var != null && !lm0Var.k()) {
                this.e.h(System.currentTimeMillis());
            } else {
                this.e.g(System.currentTimeMillis());
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            lm0 lm0Var = (lm0) l().q(lm0.class);
            if (lm0Var == null || !lm0Var.k()) {
                return;
            }
            this.e.j(System.currentTimeMillis());
            long max = Math.max(this.e.d() - Math.max(this.e.e(), this.e.f()), 0L);
            um0 um0Var = this.e;
            um0Var.i(um0Var.c() + max);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            lm0 lm0Var = (lm0) l().q(lm0.class);
            if (lm0Var == null || !lm0Var.k()) {
                return;
            }
            this.e.k(System.currentTimeMillis());
            if (this.f) {
                return;
            }
            this.e.i(Math.max(this.e.e() - this.e.a(), 0L));
            this.f = true;
        }
    }

    public final void p(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
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

    public final void q(String type, String area) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, type, area) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(area, "area");
            r(type, area, "");
        }
    }

    public final void r(String type, String area, String ext1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, type, area, ext1) == null) {
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
            iy0.b(u);
        }
    }

    public final void s() {
        t21 e;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            lm0 lm0Var = (lm0) l().q(lm0.class);
            if (lm0Var == null || lm0Var.k()) {
                long max = Math.max(System.currentTimeMillis() - Math.max(this.e.e(), this.e.f()), 0L);
                um0 um0Var = this.e;
                um0Var.i(um0Var.c() + max);
            }
            mm0 mm0Var = (mm0) l().q(mm0.class);
            if (mm0Var == null || (e = mm0Var.b().e()) == null || (jSONObject = e.d) == null) {
                return;
            }
            yx0.e(jSONObject, "immersive_video_stay_time", this.e.c());
            yx0.e(jSONObject, "immersive_webview_first_show_time", this.e.b());
        }
    }
}
