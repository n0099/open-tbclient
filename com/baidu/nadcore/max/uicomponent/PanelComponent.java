package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.PanelEventTypeEnum;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ap0;
import com.baidu.tieba.bp0;
import com.baidu.tieba.do0;
import com.baidu.tieba.g21;
import com.baidu.tieba.ho0;
import com.baidu.tieba.jh0;
import com.baidu.tieba.jn0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.ko0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.ln0;
import com.baidu.tieba.lo0;
import com.baidu.tieba.m21;
import com.baidu.tieba.mo0;
import com.baidu.tieba.oo0;
import com.baidu.tieba.p71;
import com.baidu.tieba.qn0;
import com.baidu.tieba.r71;
import com.baidu.tieba.rn0;
import com.baidu.tieba.sn0;
import com.baidu.tieba.tn0;
import com.baidu.tieba.un0;
import com.baidu.tieba.vh0;
import com.baidu.tieba.vn0;
import com.baidu.tieba.vo0;
import com.baidu.tieba.y21;
import com.baidu.tieba.zn0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\\\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010'\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u0010.R\u001e\u00105\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bE\u0010AR\u0016\u0010F\u001a\u00020=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010M\u001a\u00020H8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010AR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010.R\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006^"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PanelComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "initClickListener", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initEnhanceData", "(Lorg/json/JSONObject;)V", "initPanelInfo", "initPanelPosition", "initPanelUI", "injectService", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", MissionEvent.MESSAGE_DESTROY, "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "duration", "", "visible", "setUserInfoAreaVisible", "(JZ)V", "Lcom/baidu/nadcore/widget/AdImageView;", "authorAvatar", "Lcom/baidu/nadcore/widget/AdImageView;", "Landroid/widget/TextView;", "authorAvatarText", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "authorContainer", "Landroid/widget/LinearLayout;", "authorName", "Lcom/baidu/nadcore/widget/uiwidget/IEnhancementBtnView;", "Landroid/view/View;", "enhanceButtonView", "Lcom/baidu/nadcore/widget/uiwidget/IEnhancementBtnView;", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "enhanceModel", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "isFinishEnhanceAnim", "Z", "isNagivationBarChange", "", "navigationBarHeight", "Ljava/lang/Integer;", "panelBgView", "Landroid/view/View;", "Lcom/baidu/nadcore/model/AdLpParams$PanelModel;", "panelModel", "Lcom/baidu/nadcore/model/AdLpParams$PanelModel;", "panelRoot", "panelRootBottom", "I", "Lcom/baidu/nadcore/max/service/IPanelService;", "panelService$delegate", "Lkotlin/Lazy;", "getPanelService", "()Lcom/baidu/nadcore/max/service/IPanelService;", "panelService", "parentRoot", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "title", "Landroid/view/animation/AlphaAnimation;", "userInfoAreaAnimation", "Landroid/view/animation/AlphaAnimation;", "Landroid/widget/RelativeLayout;", "userInfoContainer", "Landroid/widget/RelativeLayout;", "<init>", "EnhanceBtnListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PanelComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bp0 d;
    public mo0 e;
    public lo0 f;
    public View g;
    public TextView h;
    public RelativeLayout i;
    public LinearLayout j;
    public AdImageView k;
    public TextView l;
    public TextView m;
    public View n;
    public r71<View> o;
    public boolean p;
    public AlphaAnimation q;
    public y21 r;
    public int s;
    public boolean t;
    public Integer u;
    public View v;
    public final Lazy w;

    /* loaded from: classes2.dex */
    public final class a extends p71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(PanelComponent panelComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelComponent;
        }

        @Override // com.baidu.tieba.p71
        public void a(String str) {
            sn0 sn0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (sn0Var = (sn0) this.a.j().p(sn0.class)) == null) {
                return;
            }
            String str2 = ClogBuilder.LogType.FREE_CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
            if (str == null) {
                str = "";
            }
            sn0Var.a(str2, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.p71
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(vo0 clickBean) {
            boolean z;
            sn0 sn0Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickBean) != null) {
                return;
            }
            Intrinsics.checkNotNullParameter(clickBean, "clickBean");
            if (!clickBean.c) {
                this.a.j().k(new ln0(PanelEventTypeEnum.CLICK_PANEL_UI));
                return;
            }
            lo0 lo0Var = this.a.f;
            if (lo0Var == null || lo0Var.a != 1) {
                bp0 bp0Var = this.a.d;
                if (!(bp0Var != null ? bp0Var.d() : false)) {
                    z = false;
                    if (!z) {
                        lo0 lo0Var2 = this.a.f;
                        vh0.c(lo0Var2 != null ? lo0Var2.i : null, this.a.getContext());
                    } else {
                        tn0 tn0Var = (tn0) this.a.j().p(tn0.class);
                        if (tn0Var != null) {
                            tn0Var.j(false, true, false);
                        }
                    }
                    this.a.j().k(new ln0(PanelEventTypeEnum.CLICK_PANEL_UI));
                    sn0Var = (sn0) this.a.j().p(sn0.class);
                    if (sn0Var == null) {
                        String str = ClogBuilder.LogType.FREE_CLICK.type;
                        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                        sn0Var.a(str, NativeConstants.ID_BUTTON);
                        return;
                    }
                    return;
                }
            }
            z = true;
            if (!z) {
            }
            this.a.j().k(new ln0(PanelEventTypeEnum.CLICK_PANEL_UI));
            sn0Var = (sn0) this.a.j().p(sn0.class);
            if (sn0Var == null) {
            }
        }

        @Override // com.baidu.tieba.p71
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.p = true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelComponent a;

        public b(PanelComponent panelComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelComponent;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            String str;
            tn0 tn0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                Intrinsics.checkNotNullExpressionValue(v, "v");
                int id = v.getId();
                if (id == R.id.obfuscated_res_0x7f090108) {
                    str = "title";
                } else if (id == R.id.obfuscated_res_0x7f09008a || id == R.id.obfuscated_res_0x7f09008b) {
                    str = "icon";
                } else if (id != R.id.obfuscated_res_0x7f09008e) {
                    return;
                } else {
                    str = "name";
                }
                bp0 bp0Var = this.a.d;
                if (bp0Var != null && !bp0Var.d() && (tn0Var = (tn0) this.a.j().p(tn0.class)) != null) {
                    tn0Var.j(false, true, false);
                }
                this.a.j().k(new ln0(PanelEventTypeEnum.CLICK_PANEL_UI));
                sn0 sn0Var = (sn0) this.a.j().p(sn0.class);
                if (sn0Var != null) {
                    String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                    Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                    sn0Var.a(str2, str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends y21.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c(PanelComponent panelComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelComponent;
        }

        @Override // com.baidu.tieba.y21.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.y21.b
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                float rint = (float) Math.rint(((float) (100000 - j)) / 1000);
                if (this.a.p) {
                    y21 y21Var = this.a.r;
                    if (y21Var != null) {
                        y21Var.a();
                    }
                    this.a.r = null;
                    return;
                }
                r71 r71Var = this.a.o;
                if (r71Var != null) {
                    r71Var.update((int) rint);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnApplyWindowInsetsListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelComponent a;

        public d(PanelComponent panelComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelComponent;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
            InterceptResult invokeLL;
            View r;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, windowInsets)) == null) {
                Integer num = this.a.u;
                if (num != null) {
                    if (num.intValue() == m21.d(this.a.h())) {
                        this.a.t = true;
                    } else {
                        PanelComponent panelComponent = this.a;
                        panelComponent.u = Integer.valueOf(m21.d(panelComponent.h()));
                        if (this.a.t && (r = PanelComponent.r(this.a)) != null) {
                            int paddingLeft = r.getPaddingLeft();
                            int paddingTop = r.getPaddingTop();
                            int paddingRight = r.getPaddingRight();
                            int i = this.a.s;
                            Integer num2 = this.a.u;
                            r.setPadding(paddingLeft, paddingTop, paddingRight, i + (num2 != null ? num2.intValue() : 0));
                        }
                    }
                } else {
                    PanelComponent panelComponent2 = this.a;
                    panelComponent2.u = Integer.valueOf(m21.d(panelComponent2.h()));
                }
                return view2.onApplyWindowInsets(windowInsets);
            }
            return (WindowInsets) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PanelComponent a;

        public e(PanelComponent panelComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {panelComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = panelComponent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
                y21 y21Var = this.a.r;
                if (y21Var != null) {
                    y21Var.e();
                }
            }
        }
    }

    public PanelComponent() {
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
        this.w = LazyKt__LazyJVMKt.lazy(new PanelComponent$panelService$2(this));
    }

    public static final /* synthetic */ View r(PanelComponent panelComponent) {
        View view2 = panelComponent.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        return view2;
    }

    public final void C() {
        vn0 vn0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vn0Var = (vn0) j().p(vn0.class)) == null) {
            return;
        }
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        jh0.e(view2);
        FrameLayout h = vn0Var.h();
        if (h != null) {
            h.addView(view2);
        }
    }

    public final un0 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (un0) this.w.getValue() : (un0) invokeV.objValue;
    }

    public final void E(jn0 jn0Var) {
        y21 y21Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jn0Var) == null) {
            int i = zn0.$EnumSwitchMapping$0[jn0Var.getType().ordinal()];
            if (i != 1) {
                if (i == 2 && (y21Var = this.r) != null) {
                    y21Var.b();
                    return;
                }
                return;
            }
            y21 y21Var2 = this.r;
            if (y21Var2 != null) {
                y21Var2.c();
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = new b(this);
            AdImageView adImageView = this.k;
            if (adImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
            }
            adImageView.setOnClickListener(bVar);
            TextView textView = this.l;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
            }
            textView.setOnClickListener(bVar);
            TextView textView2 = this.m;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorName");
            }
            textView2.setOnClickListener(bVar);
            TextView textView3 = this.h;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            }
            textView3.setOnClickListener(bVar);
            View view2 = this.g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            view2.setOnClickListener(bVar);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y21 y21Var = new y21(100000L, 1000L);
            y21Var.d(new c(this));
            this.r = y21Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(JSONObject jSONObject) {
        lo0 a2;
        int i;
        ho0 c2;
        List<oo0> list;
        View view2;
        r71<View> r71Var;
        r71<View> r71Var2;
        r71<View> r71Var3;
        r71<View> r71Var4;
        String appStr;
        r71<View> r71Var5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || (a2 = lo0.j.a(jSONObject)) == null) {
            return;
        }
        this.f = a2;
        if (a2 == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode == -1335224239) {
                optString.equals("detail");
            } else {
                if (hashCode != -1183693704) {
                    if (hashCode == 1427818632 && optString.equals("download")) {
                        i = 2;
                    }
                } else if (optString.equals("invoke")) {
                    i = 1;
                }
                a2.a = i;
                c2 = ho0.c(kz0.c(jSONObject.optString("download")));
                a2.e = c2;
                if (c2 != null) {
                    c2.b = jSONObject.optString("deferred_cmd");
                }
                ko0 ko0Var = new ko0();
                ko0Var.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
                ko0Var.d = jSONObject.optString("ext_info");
                Unit unit = Unit.INSTANCE;
                a2.f = ko0Var;
                list = a2.d;
                if (list != null || list.isEmpty()) {
                    this.p = true;
                }
                view2 = this.g;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                }
                r71Var = (r71) view2.findViewById(R.id.obfuscated_res_0x7f0914cf);
                this.o = r71Var;
                if (r71Var != null) {
                    View view3 = this.g;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                    }
                    r71Var.setBtnPlaceholder(view3.findViewById(R.id.obfuscated_res_0x7f0900fe));
                }
                r71Var2 = this.o;
                if (r71Var2 != null) {
                    r71Var2.setVisible(0);
                }
                r71Var3 = this.o;
                if (r71Var3 != null) {
                    r71Var3.setBtnIconNightModeEnable(false);
                }
                r71Var4 = this.o;
                if (r71Var4 != null) {
                    r71Var4.setEnhanceBtnListener(new a(this));
                }
                appStr = jSONObject.optString("app_info");
                Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
                if (appStr.length() > 0) {
                    a2.h = ap0.c(kz0.c(appStr));
                }
                r71Var5 = this.o;
                if (r71Var5 == null) {
                    r71Var5.setData(a2);
                    return;
                }
                return;
            }
        }
        i = 0;
        a2.a = i;
        c2 = ho0.c(kz0.c(jSONObject.optString("download")));
        a2.e = c2;
        if (c2 != null) {
        }
        ko0 ko0Var2 = new ko0();
        ko0Var2.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
        ko0Var2.d = jSONObject.optString("ext_info");
        Unit unit2 = Unit.INSTANCE;
        a2.f = ko0Var2;
        list = a2.d;
        if (list != null || list.isEmpty()) {
        }
        view2 = this.g;
        if (view2 == null) {
        }
        r71Var = (r71) view2.findViewById(R.id.obfuscated_res_0x7f0914cf);
        this.o = r71Var;
        if (r71Var != null) {
        }
        r71Var2 = this.o;
        if (r71Var2 != null) {
        }
        r71Var3 = this.o;
        if (r71Var3 != null) {
        }
        r71Var4 = this.o;
        if (r71Var4 != null) {
        }
        appStr = jSONObject.optString("app_info");
        Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
        if (appStr.length() > 0) {
        }
        r71Var5 = this.o;
        if (r71Var5 == null) {
        }
    }

    public final void I() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            mo0 mo0Var = this.e;
            if (mo0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(mo0Var.c)) {
                TextView textView = this.l;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                }
                textView.setVisibility(8);
                AdImageView adImageView = this.k;
                if (adImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                mo0 mo0Var2 = this.e;
                if (mo0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                adImageView.g(mo0Var2.c);
                AdImageView adImageView2 = this.k;
                if (adImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                adImageView2.setVisibility(0);
            } else {
                mo0 mo0Var3 = this.e;
                if (mo0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                if (!TextUtils.isEmpty(mo0Var3.b)) {
                    AdImageView adImageView3 = this.k;
                    if (adImageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                    }
                    adImageView3.setVisibility(8);
                    TextView textView2 = this.l;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                    }
                    mo0 mo0Var4 = this.e;
                    if (mo0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                    }
                    String str2 = mo0Var4.b;
                    if (str2 == null) {
                        str = null;
                    } else if (str2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    } else {
                        str = str2.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    textView2.setText(str);
                    TextView textView3 = this.l;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                    }
                    textView3.setVisibility(0);
                } else {
                    AdImageView adImageView4 = this.k;
                    if (adImageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                    }
                    adImageView4.setVisibility(8);
                    TextView textView4 = this.l;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                    }
                    textView4.setVisibility(8);
                }
            }
            mo0 mo0Var5 = this.e;
            if (mo0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(mo0Var5.b)) {
                TextView textView5 = this.m;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorName");
                }
                mo0 mo0Var6 = this.e;
                if (mo0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                textView5.setText(mo0Var6.b);
            }
            mo0 mo0Var7 = this.e;
            if (mo0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(mo0Var7.a)) {
                TextView textView6 = this.h;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                }
                mo0 mo0Var8 = this.e;
                if (mo0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                textView6.setText(mo0Var8.a);
                return;
            }
            TextView textView7 = this.h;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            }
            textView7.setVisibility(8);
        }
    }

    public final void J(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            String optString = jSONObject.optString(WriteActivityConfig.VIDEO_INFO);
            if (optString == null || optString.length() == 0) {
                return;
            }
            int f = do0.a.f(g21.c.c(getContext()) / g21.c.e(getContext()), Intrinsics.areEqual("1", new JSONObject(optString).optString("video_stretch_switch", "0")));
            View view2 = this.n;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelBgView");
            }
            view2.getLayoutParams().height = f;
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qn0 a2 = rn0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
            a2.c();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…).inflate(layoutId, null)");
            this.g = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            this.s = inflate.getPaddingBottom();
            View view2 = this.g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f090108);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_video_title)");
            this.h = (TextView) findViewById;
            View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f090101);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ad_video_info)");
            this.i = (RelativeLayout) findViewById2;
            View findViewById3 = view2.findViewById(R.id.obfuscated_res_0x7f09008c);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ad_author_container)");
            this.j = (LinearLayout) findViewById3;
            View findViewById4 = view2.findViewById(R.id.obfuscated_res_0x7f09008a);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ad_author_avatar)");
            this.k = (AdImageView) findViewById4;
            View findViewById5 = view2.findViewById(R.id.obfuscated_res_0x7f09008b);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ad_author_avatar_txt)");
            this.l = (TextView) findViewById5;
            View findViewById6 = view2.findViewById(R.id.obfuscated_res_0x7f09008e);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ad_author_name)");
            this.m = (TextView) findViewById6;
            View findViewById7 = view2.findViewById(R.id.obfuscated_res_0x7f0900df);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.ad_panel_constant_bg)");
            this.n = findViewById7;
        }
    }

    public final void L(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject(hashMap);
                mo0 a2 = mo0.d.a(jSONObject);
                if (a2 != null) {
                    this.e = a2;
                    Object obj = hashMap.get("cmd_policy");
                    String str = obj instanceof String ? obj : null;
                    if (!TextUtils.isEmpty(str)) {
                        this.d = bp0.f.a(kz0.c(str));
                    }
                    J(jSONObject);
                    I();
                    H(jSONObject);
                    F();
                    G();
                    return;
                }
                j().u(this);
            }
        }
    }

    public final void M(long j, boolean z) {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            AlphaAnimation alphaAnimation2 = this.q;
            if (alphaAnimation2 != null) {
                alphaAnimation2.cancel();
            }
            this.q = null;
            if (z) {
                alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            } else {
                alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            }
            this.q = alphaAnimation;
            if (alphaAnimation != null) {
                alphaAnimation.setDuration(j);
            }
            AlphaAnimation alphaAnimation3 = this.q;
            if (alphaAnimation3 != null) {
                alphaAnimation3.setFillAfter(true);
            }
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userInfoContainer");
            }
            relativeLayout.startAnimation(this.q);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(ki0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            if (Intrinsics.areEqual(event.a(), jn0.class.getSimpleName())) {
                E((jn0) event);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.d();
            j().s(un0.class, D());
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void g(ViewGroup parent) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.v = parent;
            if (m21.f() && Build.VERSION.SDK_INT >= 20 && (view2 = this.v) != null) {
                view2.setOnApplyWindowInsetsListener(new d(this));
            }
            parent.post(new e(this));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onDestroy() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            if (!m21.f() || Build.VERSION.SDK_INT < 20 || (view2 = this.v) == null) {
                return;
            }
            view2.setOnApplyWindowInsetsListener(null);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.onNewIntent(intent);
            K();
            L(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            y21 y21Var = this.r;
            if (y21Var != null) {
                y21Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onRelease();
            r71<View> r71Var = this.o;
            if (r71Var != null) {
                r71Var.a();
            }
            this.o = null;
            AlphaAnimation alphaAnimation = this.q;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.q = null;
            View view2 = this.g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            jh0.e(view2);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        y21 y21Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            vn0 vn0Var = (vn0) j().p(vn0.class);
            if (vn0Var == null || !vn0Var.k() || (y21Var = this.r) == null) {
                return;
            }
            y21Var.c();
        }
    }
}
