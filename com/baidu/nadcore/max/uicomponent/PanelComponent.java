package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.an0;
import com.repackage.cm0;
import com.repackage.gg0;
import com.repackage.gm0;
import com.repackage.hx0;
import com.repackage.il0;
import com.repackage.jm0;
import com.repackage.kl0;
import com.repackage.km0;
import com.repackage.lm0;
import com.repackage.n01;
import com.repackage.nm0;
import com.repackage.o41;
import com.repackage.pl0;
import com.repackage.q41;
import com.repackage.ql0;
import com.repackage.rl0;
import com.repackage.sl0;
import com.repackage.tl0;
import com.repackage.uf0;
import com.repackage.ul0;
import com.repackage.um0;
import com.repackage.vg0;
import com.repackage.yl0;
import com.repackage.zm0;
import com.repackage.zz0;
import com.tachikoma.core.component.TKBase;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u0010-R\u001e\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010<R\u001d\u0010F\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010-R\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006V"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/PanelComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "", "attachToParent", "()V", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "handleNestedEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "initClickListener", "initCountDownTimer", "Lorg/json/JSONObject;", "paramJson", "initEnhanceData", "(Lorg/json/JSONObject;)V", "initPanelInfo", "initPanelPosition", "initPanelUI", "injectService", "Landroid/view/ViewGroup;", "parent", "onCreateView", "(Landroid/view/ViewGroup;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "duration", "", TKBase.VISIBILITY_VISIBLE, "setUserInfoAreaVisible", "(JZ)V", "Lcom/baidu/nadcore/widget/AdImageView;", "authorAvatar", "Lcom/baidu/nadcore/widget/AdImageView;", "Landroid/widget/TextView;", "authorAvatarText", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "authorContainer", "Landroid/widget/LinearLayout;", "authorName", "Lcom/baidu/nadcore/widget/uiwidget/IEnhancementBtnView;", "Landroid/view/View;", "enhanceButtonView", "Lcom/baidu/nadcore/widget/uiwidget/IEnhancementBtnView;", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "enhanceModel", "Lcom/baidu/nadcore/model/AdLpParams$EnhanceModel;", "isFinishEnhanceAnim", "Z", "panelBgView", "Landroid/view/View;", "Lcom/baidu/nadcore/model/AdLpParams$PanelModel;", "panelModel", "Lcom/baidu/nadcore/model/AdLpParams$PanelModel;", "panelRoot", "Lcom/baidu/nadcore/max/service/IPanelService;", "panelService$delegate", "Lkotlin/Lazy;", "getPanelService", "()Lcom/baidu/nadcore/max/service/IPanelService;", "panelService", "Lcom/baidu/nadcore/model/CmdPolicy;", "switchModel", "Lcom/baidu/nadcore/model/CmdPolicy;", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "timeoutTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "title", "Landroid/view/animation/AlphaAnimation;", "userInfoAreaAnimation", "Landroid/view/animation/AlphaAnimation;", "Landroid/widget/RelativeLayout;", "userInfoContainer", "Landroid/widget/RelativeLayout;", "<init>", "EnhanceBtnListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PanelComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public an0 d;
    public lm0 e;
    public km0 f;
    public View g;
    public TextView h;
    public RelativeLayout i;
    public LinearLayout j;
    public AdImageView k;
    public TextView l;
    public TextView m;
    public View n;
    public q41<View> o;
    public boolean p;
    public AlphaAnimation q;
    public n01 r;
    public final Lazy s;

    /* loaded from: classes2.dex */
    public final class a extends o41 {
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

        @Override // com.repackage.o41
        public void a(String str) {
            rl0 rl0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (rl0Var = (rl0) this.a.j().q(rl0.class)) == null) {
                return;
            }
            String str2 = ClogBuilder.LogType.FREE_CLICK.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
            if (str == null) {
                str = "";
            }
            rl0Var.a(str2, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.o41
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(um0 clickBean) {
            boolean z;
            rl0 rl0Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickBean) != null) {
                return;
            }
            Intrinsics.checkNotNullParameter(clickBean, "clickBean");
            if (!clickBean.c) {
                this.a.j().l(new kl0(PanelEventTypeEnum.CLICK_PANEL_UI));
                return;
            }
            km0 km0Var = this.a.f;
            if (km0Var == null || km0Var.a != 1) {
                an0 an0Var = this.a.d;
                if (!(an0Var != null ? an0Var.d() : false)) {
                    z = false;
                    if (!z) {
                        km0 km0Var2 = this.a.f;
                        gg0.c(km0Var2 != null ? km0Var2.i : null, this.a.getContext());
                    } else {
                        sl0 sl0Var = (sl0) this.a.j().q(sl0.class);
                        if (sl0Var != null) {
                            sl0Var.j(false, true, false);
                        }
                    }
                    this.a.j().l(new kl0(PanelEventTypeEnum.CLICK_PANEL_UI));
                    rl0Var = (rl0) this.a.j().q(rl0.class);
                    if (rl0Var == null) {
                        String str = ClogBuilder.LogType.FREE_CLICK.type;
                        Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.LogType.FREE_CLICK.type");
                        rl0Var.a(str, NativeConstants.ID_BUTTON);
                        return;
                    }
                    return;
                }
            }
            z = true;
            if (!z) {
            }
            this.a.j().l(new kl0(PanelEventTypeEnum.CLICK_PANEL_UI));
            rl0Var = (rl0) this.a.j().q(rl0.class);
            if (rl0Var == null) {
            }
        }

        @Override // com.repackage.o41
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
            sl0 sl0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                Intrinsics.checkNotNullExpressionValue(v, "v");
                int id = v.getId();
                if (id == R.id.obfuscated_res_0x7f0900fe) {
                    str = "title";
                } else if (id == R.id.obfuscated_res_0x7f090085 || id == R.id.obfuscated_res_0x7f090086) {
                    str = "icon";
                } else if (id != R.id.obfuscated_res_0x7f090089) {
                    return;
                } else {
                    str = "name";
                }
                an0 an0Var = this.a.d;
                if (an0Var != null && !an0Var.d() && (sl0Var = (sl0) this.a.j().q(sl0.class)) != null) {
                    sl0Var.j(false, true, false);
                }
                this.a.j().l(new kl0(PanelEventTypeEnum.CLICK_PANEL_UI));
                rl0 rl0Var = (rl0) this.a.j().q(rl0.class);
                if (rl0Var != null) {
                    String str2 = ClogBuilder.LogType.FREE_CLICK.type;
                    Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.LogType.FREE_CLICK.type");
                    rl0Var.a(str2, str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends n01.b {
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

        @Override // com.repackage.n01.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.n01.b
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                float rint = (float) Math.rint(((float) (100000 - j)) / 1000);
                if (this.a.p) {
                    n01 n01Var = this.a.r;
                    if (n01Var != null) {
                        n01Var.a();
                    }
                    this.a.r = null;
                    return;
                }
                q41 q41Var = this.a.o;
                if (q41Var != null) {
                    q41Var.update((int) rint);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements Runnable {
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

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u();
                n01 n01Var = this.a.r;
                if (n01Var != null) {
                    n01Var.e();
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
        this.s = LazyKt__LazyJVMKt.lazy(new PanelComponent$panelService$2(this));
    }

    public final void A() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            lm0 lm0Var = this.e;
            if (lm0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(lm0Var.c)) {
                TextView textView = this.l;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                }
                textView.setVisibility(8);
                AdImageView adImageView = this.k;
                if (adImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                lm0 lm0Var2 = this.e;
                if (lm0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                adImageView.n(lm0Var2.c);
                AdImageView adImageView2 = this.k;
                if (adImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                }
                adImageView2.setVisibility(0);
            } else {
                lm0 lm0Var3 = this.e;
                if (lm0Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                if (!TextUtils.isEmpty(lm0Var3.b)) {
                    AdImageView adImageView3 = this.k;
                    if (adImageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatar");
                    }
                    adImageView3.setVisibility(8);
                    TextView textView2 = this.l;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("authorAvatarText");
                    }
                    lm0 lm0Var4 = this.e;
                    if (lm0Var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                    }
                    String str2 = lm0Var4.b;
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
            lm0 lm0Var5 = this.e;
            if (lm0Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(lm0Var5.b)) {
                TextView textView5 = this.m;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authorName");
                }
                lm0 lm0Var6 = this.e;
                if (lm0Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                textView5.setText(lm0Var6.b);
            }
            lm0 lm0Var7 = this.e;
            if (lm0Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelModel");
            }
            if (!TextUtils.isEmpty(lm0Var7.a)) {
                TextView textView6 = this.h;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                }
                lm0 lm0Var8 = this.e;
                if (lm0Var8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelModel");
                }
                textView6.setText(lm0Var8.a);
                return;
            }
            TextView textView7 = this.h;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
            }
            textView7.setVisibility(8);
        }
    }

    public final void B(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            String optString = jSONObject.optString(WriteActivityConfig.VIDEO_INFO);
            if (optString == null || optString.length() == 0) {
                return;
            }
            int f = cm0.a.f(zz0.c.c(getContext()) / zz0.c.e(getContext()), Intrinsics.areEqual("1", new JSONObject(optString).optString("video_stretch_switch", "0")));
            View view2 = this.n;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelBgView");
            }
            view2.getLayoutParams().height = f;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pl0 a2 = ql0.a();
            Intrinsics.checkNotNullExpressionValue(a2, "NadMaxRuntime.getUIProvider()");
            a2.c();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05a4, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…).inflate(layoutId, null)");
            this.g = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0900fe);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_video_title)");
            this.h = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f0900f7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.ad_video_info)");
            this.i = (RelativeLayout) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.obfuscated_res_0x7f090087);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ad_author_container)");
            this.j = (LinearLayout) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.obfuscated_res_0x7f090085);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ad_author_avatar)");
            this.k = (AdImageView) findViewById4;
            View findViewById5 = inflate.findViewById(R.id.obfuscated_res_0x7f090086);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ad_author_avatar_txt)");
            this.l = (TextView) findViewById5;
            View findViewById6 = inflate.findViewById(R.id.obfuscated_res_0x7f090089);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ad_author_name)");
            this.m = (TextView) findViewById6;
            View findViewById7 = inflate.findViewById(R.id.obfuscated_res_0x7f0900d5);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.ad_panel_constant_bg)");
            this.n = findViewById7;
        }
    }

    public final void D(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                JSONObject jSONObject = new JSONObject(hashMap);
                lm0 a2 = lm0.d.a(jSONObject);
                if (a2 != null) {
                    this.e = a2;
                    Object obj = hashMap.get("cmd_policy");
                    String str = obj instanceof String ? obj : null;
                    if (!TextUtils.isEmpty(str)) {
                        this.d = an0.g.a(hx0.c(str));
                    }
                    B(jSONObject);
                    A();
                    z(jSONObject);
                    x();
                    y();
                    return;
                }
                j().v(this);
            }
        }
    }

    public final void E(long j, boolean z) {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
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
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            super.b(intent);
            C();
            D(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void c(vg0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            if (Intrinsics.areEqual(event.a(), il0.class.getSimpleName())) {
                w((il0) event);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.e();
            j().t(tl0.class, v());
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void h(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new d(this));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            n01 n01Var = this.r;
            if (n01Var != null) {
                n01Var.b();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onRelease();
            q41<View> q41Var = this.o;
            if (q41Var != null) {
                q41Var.a();
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
            uf0.f(view2);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        n01 n01Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            ul0 ul0Var = (ul0) j().q(ul0.class);
            if (ul0Var == null || !ul0Var.k() || (n01Var = this.r) == null) {
                return;
            }
            n01Var.c();
        }
    }

    public final void u() {
        ul0 ul0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (ul0Var = (ul0) j().q(ul0.class)) == null) {
            return;
        }
        View view2 = this.g;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
        }
        uf0.f(view2);
        FrameLayout h = ul0Var.h();
        if (h != null) {
            h.addView(view2);
        }
    }

    public final tl0 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (tl0) this.s.getValue() : (tl0) invokeV.objValue;
    }

    public final void w(il0 il0Var) {
        n01 n01Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, il0Var) == null) {
            int i = yl0.$EnumSwitchMapping$0[il0Var.getType().ordinal()];
            if (i != 1) {
                if (i == 2 && (n01Var = this.r) != null) {
                    n01Var.b();
                    return;
                }
                return;
            }
            n01 n01Var2 = this.r;
            if (n01Var2 != null) {
                n01Var2.c();
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            n01 n01Var = new n01(100000L, 1000L);
            n01Var.d(new c(this));
            this.r = n01Var;
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
    public final void z(JSONObject jSONObject) {
        km0 a2;
        int i;
        gm0 c2;
        List<nm0> list;
        View view2;
        q41<View> q41Var;
        q41<View> q41Var2;
        q41<View> q41Var3;
        q41<View> q41Var4;
        String appStr;
        q41<View> q41Var5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) || (a2 = km0.j.a(jSONObject)) == null) {
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
                c2 = gm0.c(hx0.c(jSONObject.optString("download")));
                a2.e = c2;
                if (c2 != null) {
                    c2.b = jSONObject.optString("deferred_cmd");
                }
                jm0 jm0Var = new jm0();
                jm0Var.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
                jm0Var.d = jSONObject.optString("ext_info");
                Unit unit = Unit.INSTANCE;
                a2.f = jm0Var;
                list = a2.d;
                if (list != null || list.isEmpty()) {
                    this.p = true;
                }
                view2 = this.g;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                }
                q41Var = (q41) view2.findViewById(R.id.obfuscated_res_0x7f091388);
                this.o = q41Var;
                if (q41Var != null) {
                    View view3 = this.g;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelRoot");
                    }
                    q41Var.setBtnPlaceholder(view3.findViewById(R.id.obfuscated_res_0x7f0900f4));
                }
                q41Var2 = this.o;
                if (q41Var2 != null) {
                    q41Var2.setVisible(0);
                }
                q41Var3 = this.o;
                if (q41Var3 != null) {
                    q41Var3.setBtnIconNightModeEnable(false);
                }
                q41Var4 = this.o;
                if (q41Var4 != null) {
                    q41Var4.setEnhanceBtnListener(new a(this));
                }
                appStr = jSONObject.optString("app_info");
                Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
                if (appStr.length() > 0) {
                    a2.h = zm0.c(hx0.c(appStr));
                }
                q41Var5 = this.o;
                if (q41Var5 == null) {
                    q41Var5.setData(a2);
                    return;
                }
                return;
            }
        }
        i = 0;
        a2.a = i;
        c2 = gm0.c(hx0.c(jSONObject.optString("download")));
        a2.e = c2;
        if (c2 != null) {
        }
        jm0 jm0Var2 = new jm0();
        jm0Var2.a = ClogBuilder.Page.PAGE_VIDEO_IMMERSIVE_LP.type;
        jm0Var2.d = jSONObject.optString("ext_info");
        Unit unit2 = Unit.INSTANCE;
        a2.f = jm0Var2;
        list = a2.d;
        if (list != null || list.isEmpty()) {
        }
        view2 = this.g;
        if (view2 == null) {
        }
        q41Var = (q41) view2.findViewById(R.id.obfuscated_res_0x7f091388);
        this.o = q41Var;
        if (q41Var != null) {
        }
        q41Var2 = this.o;
        if (q41Var2 != null) {
        }
        q41Var3 = this.o;
        if (q41Var3 != null) {
        }
        q41Var4 = this.o;
        if (q41Var4 != null) {
        }
        appStr = jSONObject.optString("app_info");
        Intrinsics.checkNotNullExpressionValue(appStr, "appStr");
        if (appStr.length() > 0) {
        }
        q41Var5 = this.o;
        if (q41Var5 == null) {
        }
    }
}
