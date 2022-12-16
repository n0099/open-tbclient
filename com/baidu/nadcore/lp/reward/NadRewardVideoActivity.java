package com.baidu.nadcore.lp.reward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.business.uitemplate.NadVideoAdOverContainer;
import com.baidu.nadcore.lp.reward.view.AbsRewardCountDownView;
import com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog;
import com.baidu.nadcore.lp.reward.view.NadVideoRewardCountDownView;
import com.baidu.nadcore.model.AdOperator;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.R;
import com.baidu.tieba.a11;
import com.baidu.tieba.as0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.bo0;
import com.baidu.tieba.bq0;
import com.baidu.tieba.co0;
import com.baidu.tieba.dh0;
import com.baidu.tieba.eq0;
import com.baidu.tieba.es0;
import com.baidu.tieba.ho0;
import com.baidu.tieba.hq0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.io0;
import com.baidu.tieba.iq0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.m31;
import com.baidu.tieba.ng0;
import com.baidu.tieba.s21;
import com.baidu.tieba.t31;
import com.baidu.tieba.wp0;
import com.baidu.tieba.yn0;
import com.baidu.tieba.z01;
import com.baidu.tieba.zn0;
import com.baidu.tieba.zp0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bU\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\tJ\u0019\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\tJC\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\"\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`$H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\tJ\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\tJ\u000f\u0010,\u001a\u00020\u001dH\u0002¢\u0006\u0004\b,\u0010\u001fJ\u0017\u0010/\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u001dH\u0002¢\u0006\u0004\b1\u0010\u001fJ\u000f\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b2\u0010\tJ\u000f\u00103\u001a\u00020\u0007H\u0002¢\u0006\u0004\b3\u0010\tR\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010GR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010S\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bS\u0010BR\u0016\u0010T\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010B¨\u0006V"}, d2 = {"Lcom/baidu/nadcore/lp/reward/NadRewardVideoActivity;", "Lcom/baidu/nadcore/appframework/BaseActivity;", "", "rewardDataJson", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "buildDialog", "(Ljava/lang/String;)Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "chargeClick", "()V", "getSessionInfo", "()Ljava/lang/String;", "initCloseIcon", "initCountDownView", "initSessionCountByTime", "initVideoPlayer", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreateEx", "(Landroid/os/Bundle;)V", "onDestroyEx", "Landroid/content/Intent;", IntentData.KEY, "onNewIntentEx", "(Landroid/content/Intent;)V", "onPauseEx", "onRestart", "onTaskComplete", "", "parseData", "()Z", "pauseVideoPlayAndCountDown", "status", "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "data", "postRewardVideoNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "preCreate", "(Landroid/os/Bundle;)Z", "resumeVideoPlayAndCountDown", "setCountDown", "showDialog", "", "remainSecond", "showRetainDialog", "(J)Z", "showRewardDialog", "updateUserInfoContainer", "updateVideoPlayerData", "Lcom/baidu/nadcore/business/uitemplate/NadVideoAdOverContainer;", "adInfoContainer", "Lcom/baidu/nadcore/business/uitemplate/NadVideoAdOverContainer;", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "adModel", "Lcom/baidu/nadcore/model/AdRewardVideoLpModel;", "Lcom/baidu/nadcore/widget/AdImageView;", "closeIcon", "Lcom/baidu/nadcore/widget/AdImageView;", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "countDownView", "Lcom/baidu/nadcore/lp/reward/view/AbsRewardCountDownView;", "Landroid/widget/FrameLayout;", "flRootView", "Landroid/widget/FrameLayout;", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "retainDialog", "Lcom/baidu/nadcore/lp/reward/view/NadRewardVideoDialog;", "", "rewardCount", "I", "rewardDialog", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "rewardResponse", "Lcom/baidu/nadcore/lp/reward/data/NadTaskRewardResponse;", "", "screenHW", "F", "sessionCount", "tailFrameContainer", "videoContainer", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadRewardVideoActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public wp0 B;
    public as0 C;
    public NadRewardVideoDialog D;
    public NadRewardVideoDialog E;
    public yn0 F;
    public int G;
    public int H;
    public FrameLayout u;
    public FrameLayout v;
    public FrameLayout w;
    public NadVideoAdOverContainer x;
    public AdImageView y;
    public AbsRewardCountDownView z;

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public a(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements NadRewardVideoDialog.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public b(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.nadcore.lp.reward.view.NadRewardVideoDialog.b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.P1();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoDialog a;
        public final /* synthetic */ NadRewardVideoActivity b;

        public c(NadRewardVideoDialog nadRewardVideoDialog, NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoDialog, nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoDialog;
            this.b = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bm0.a().a(new dh0(NadRewardVideoActivity.z1(this.b).l));
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public d(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str2 = NadRewardVideoActivity.z1(this.a).f.d;
                yn0 yn0Var = this.a.F;
                if (yn0Var != null) {
                    str = yn0Var.c();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                io0.d(str2, !z);
                if (this.a.b2()) {
                    return;
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends kz0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kz0, com.baidu.nadcore.player.strategy.IVideoUpdateStrategy
        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (co0.a().a()) {
                    return 2;
                }
                return 1;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public f(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && NadRewardVideoActivity.B1(this.a).getMeasuredWidth() != 0.0f) {
                NadRewardVideoActivity nadRewardVideoActivity = this.a;
                nadRewardVideoActivity.A = NadRewardVideoActivity.B1(nadRewardVideoActivity).getMeasuredHeight() / NadRewardVideoActivity.B1(this.a).getMeasuredWidth();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements bo0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public g(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.tieba.bo0.b
        public void a(yn0 yn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yn0Var) != null) {
                return;
            }
            this.a.F = yn0Var;
            if (yn0Var == null) {
                return;
            }
            boolean z = true;
            this.a.H++;
            if (yn0Var.c().length() <= 0) {
                z = false;
            }
            if (z) {
                AbsRewardCountDownView absRewardCountDownView = this.a.z;
                if (absRewardCountDownView != null) {
                    absRewardCountDownView.e(NadRewardVideoActivity.z1(this.a).d().b(yn0Var.c()));
                }
                io0.c(NadRewardVideoActivity.z1(this.a).f.d, yn0Var.c(), this.a.Q1());
            }
            z01.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COMPLETE_TASK).u(ClogBuilder.Page.WELFAREMAXLP).p(NadRewardVideoActivity.z1(this.a).f.d));
            HashMap hashMap = new HashMap();
            hashMap.put("callBackName", "taskComplete");
            hashMap.put("taskFrom", NadRewardVideoActivity.z1(this.a).d().g());
            this.a.Y1("0", "任务完成回调", hashMap);
        }

        @Override // com.baidu.tieba.bo0.b
        public void onFail(Exception e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e) == null) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.a.F = null;
                z01.b(new ClogBuilder().y(ClogBuilder.LogType.REWARD_COIN_FAIL).u(ClogBuilder.Page.WELFAREMAXLP).p(NadRewardVideoActivity.z1(this.a).f.d));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public h(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !NadRewardVideoActivity.y1(this.a).v()) {
                return;
            }
            NadRewardVideoActivity.y1(this.a).A(false);
            NadRewardVideoActivity.G1(this.a).setVisibility(0);
            as0 as0Var = this.a.C;
            if (as0Var != null) {
                as0Var.start();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        public i(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!NadRewardVideoActivity.z1(this.a).e()) {
                    ii0.b(NadRewardVideoActivity.z1(this.a).c());
                }
                this.a.P1();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends es0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadRewardVideoActivity a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public j(NadRewardVideoActivity nadRewardVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadRewardVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadRewardVideoActivity;
        }

        @Override // com.baidu.tieba.es0, com.baidu.tieba.xr0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                NadRewardVideoActivity.y1(this.a).A(true);
            }
        }

        @Override // com.baidu.tieba.es0, com.baidu.tieba.xr0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NadRewardVideoActivity.y1(this.a).A(false);
            }
        }
    }

    public NadRewardVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0009: IGET  (r1v2 int A[REMOVE]) = (r4v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.G int), ('_' char), (wrap: int : 0x0013: IGET  (r1v4 int A[REMOVE]) = (r4v0 'this' com.baidu.nadcore.lp.reward.NadRewardVideoActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.nadcore.lp.reward.NadRewardVideoActivity.H int)] */
    public final String Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.G);
            sb.append('_');
            sb.append(this.H);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().append(s…d(rewardCount).toString()");
            return sb2;
        }
        return (String) invokeV.objValue;
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            NadVideoRewardCountDownView nadVideoRewardCountDownView = new NadVideoRewardCountDownView(this, null, 0, 6, null);
            FrameLayout frameLayout = this.u;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flRootView");
            }
            AbsRewardCountDownView.b(nadVideoRewardCountDownView, frameLayout, 0, false, null, 14, null);
            Unit unit = Unit.INSTANCE;
            this.z = nadVideoRewardCountDownView;
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int a2 = t31.a("nad_reward_sp", "key_session_count", 1);
            this.G = a2;
            t31.e("nad_reward_sp", "key_session_count", a2 + 1);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            bo0 b2 = co0.b();
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            b2.a(wp0Var, new hq0(this.G, this.H), new g(this));
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            as0 as0Var = this.C;
            if (as0Var != null) {
                as0Var.pause();
            }
            AbsRewardCountDownView absRewardCountDownView = this.z;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.f();
            }
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            as0 as0Var = this.C;
            if (as0Var != null) {
                as0Var.resume();
            }
            AbsRewardCountDownView absRewardCountDownView = this.z;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.c();
            }
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.a1();
            AbsRewardCountDownView absRewardCountDownView = this.z;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.d();
            }
            as0 as0Var = this.C;
            if (as0Var != null) {
                as0Var.release();
            }
            this.C = null;
            NadVideoAdOverContainer nadVideoAdOverContainer = this.x;
            if (nadVideoAdOverContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adInfoContainer");
            }
            nadVideoAdOverContainer.y();
        }
    }

    public final boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AbsRewardCountDownView absRewardCountDownView = this.z;
            if (absRewardCountDownView != null) {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(absRewardCountDownView.getMillisUntilFinished());
                if (seconds <= 0) {
                    return d2();
                }
                return c2(seconds);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.e1();
            AbsRewardCountDownView absRewardCountDownView = this.z;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.f();
            }
            as0 as0Var = this.C;
            if (as0Var != null) {
                as0Var.pause();
            }
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || b2()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onRestart();
            NadRewardVideoDialog nadRewardVideoDialog = this.E;
            if (nadRewardVideoDialog == null || !nadRewardVideoDialog.isVisible()) {
                NadRewardVideoDialog nadRewardVideoDialog2 = this.D;
                if (nadRewardVideoDialog2 != null && nadRewardVideoDialog2.isVisible()) {
                    return;
                }
                Z1();
            }
        }
    }

    public static final /* synthetic */ FrameLayout B1(NadRewardVideoActivity nadRewardVideoActivity) {
        FrameLayout frameLayout = nadRewardVideoActivity.u;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flRootView");
        }
        return frameLayout;
    }

    public static final /* synthetic */ FrameLayout G1(NadRewardVideoActivity nadRewardVideoActivity) {
        FrameLayout frameLayout = nadRewardVideoActivity.w;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        }
        return frameLayout;
    }

    public static final /* synthetic */ NadVideoAdOverContainer y1(NadRewardVideoActivity nadRewardVideoActivity) {
        NadVideoAdOverContainer nadVideoAdOverContainer = nadRewardVideoActivity.x;
        if (nadVideoAdOverContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adInfoContainer");
        }
        return nadVideoAdOverContainer;
    }

    public static final /* synthetic */ wp0 z1(NadRewardVideoActivity nadRewardVideoActivity) {
        wp0 wp0Var = nadRewardVideoActivity.B;
        if (wp0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adModel");
        }
        return wp0Var;
    }

    public final NadRewardVideoDialog O1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            NadRewardVideoDialog.a aVar = NadRewardVideoDialog.p;
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            String str2 = wp0Var.f.d;
            Intrinsics.checkNotNullExpressionValue(str2, "adModel.common.extraParam");
            NadRewardVideoDialog a2 = aVar.a(str, str2);
            a2.O1(new a(this));
            a2.R1(new NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$2(this));
            a2.M1(new b(this));
            a2.P1(new NadRewardVideoActivity$buildDialog$$inlined$apply$lambda$4(this));
            a2.S1(new c(a2, this));
            return a2;
        }
        return (NadRewardVideoDialog) invokeL.objValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void c1(Intent intent) {
        bq0 bq0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            super.c1(intent);
            setIntent(intent);
            if (!W1()) {
                s21.a().a(this, R.string.nad_reward_video_lp_parse_data_error);
                return;
            }
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            zp0 zp0Var = wp0Var.j;
            if (zp0Var != null && (bq0Var = zp0Var.g) != null) {
                bq0Var.s = "再看一个领取更多福利";
            }
            U1();
            e2();
            f2();
            a2();
            this.F = null;
            wp0 wp0Var2 = this.B;
            if (wp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            io0.e(wp0Var2);
        }
    }

    public final boolean c2(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            if (wp0Var.d().e().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            wp0 wp0Var2 = this.B;
            if (wp0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            NadRewardVideoDialog O1 = O1(wp0Var2.d().d(j2));
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            O1.show(supportFragmentManager, (String) null);
            this.D = O1;
            X1();
            return true;
        }
        return invokeJ.booleanValue;
    }

    public final void P1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            List<MonitorUrl> list = wp0Var.e;
            Intrinsics.checkNotNullExpressionValue(list, "adModel.monitorUrls");
            ArrayList<MonitorUrl> arrayList = new ArrayList();
            for (Object obj : list) {
                String str = ((MonitorUrl) obj).clickUrl;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    arrayList.add(obj);
                }
            }
            for (MonitorUrl monitorUrl : arrayList) {
                a11.b(monitorUrl.clickUrl);
            }
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            as0 a2 = as0.a.a(this, 0);
            FrameLayout frameLayout = this.w;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            }
            a2.attachToContainer(frameLayout);
            a2.d(new e());
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            zp0 zp0Var = wp0Var.j;
            if (zp0Var != null && zp0Var.e) {
                a2.setVideoScalingMode(0);
            } else {
                a2.setVideoScalingMode(2);
            }
            Unit unit = Unit.INSTANCE;
            this.C = a2;
        }
    }

    public final boolean d2() {
        InterceptResult invokeV;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            yn0 yn0Var = this.F;
            if (yn0Var != null && yn0Var.b()) {
                return false;
            }
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            iq0 d2 = wp0Var.d();
            yn0 yn0Var2 = this.F;
            if (yn0Var2 != null) {
                str = yn0Var2.d();
            } else {
                str = null;
            }
            String c2 = d2.c(str);
            if (c2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            NadRewardVideoDialog O1 = O1(c2);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            O1.show(supportFragmentManager, (String) null);
            this.E = O1;
            X1();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.y != null) {
            return;
        }
        AdImageView adImageView = new AdImageView(this);
        int a2 = m31.c.a(adImageView.getContext(), 10.0f);
        adImageView.setPadding(a2, a2, a2, a2);
        adImageView.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
        adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        adImageView.setOnClickListener(new d(this));
        Unit unit = Unit.INSTANCE;
        this.y = adImageView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.setMarginEnd(m31.c.a(this, 5.0f));
        layoutParams.height = m31.c.a(this, 39.0f);
        layoutParams.width = m31.c.a(this, 39.0f);
        FrameLayout frameLayout = this.u;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flRootView");
        }
        frameLayout.addView(this.y, layoutParams);
    }

    public final void f2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            zp0 zp0Var = wp0Var.j;
            if (zp0Var != null) {
                Intrinsics.checkNotNullExpressionValue(zp0Var, "adModel.videoInfo ?: return");
                as0 as0Var = this.C;
                if (as0Var != null) {
                    as0Var.c(zp0Var);
                }
                as0 as0Var2 = this.C;
                if (as0Var2 != null) {
                    as0Var2.a(new j(this));
                }
                if (NetUtil.a(this)) {
                    wp0 wp0Var2 = this.B;
                    if (wp0Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    eq0 b2 = wp0Var2.b();
                    if (b2 != null) {
                        z = b2.d();
                    } else {
                        z = false;
                    }
                    as0 as0Var3 = this.C;
                    if (as0Var3 != null) {
                        as0Var3.setLooping(!z);
                    }
                    as0 as0Var4 = this.C;
                    if (as0Var4 != null) {
                        as0Var4.start();
                        return;
                    }
                    return;
                }
                s21.a().a(this, R.string.nad_reward_video_lp_no_network);
            }
        }
    }

    public final boolean W1() {
        Object m708constructorimpl;
        bq0 bq0Var;
        String str;
        String str2;
        Serializable serializable;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                Result.Companion companion = Result.Companion;
                Intent intent = getIntent();
                if (intent != null) {
                    serializable = intent.getSerializableExtra("params");
                } else {
                    serializable = null;
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m708constructorimpl = Result.m708constructorimpl(ResultKt.createFailure(th));
            }
            if (serializable != null) {
                m708constructorimpl = Result.m708constructorimpl(ho0.a.d((HashMap) serializable));
                if (Result.m715isSuccessimpl(m708constructorimpl)) {
                    wp0 wp0Var = (wp0) m708constructorimpl;
                    this.B = wp0Var;
                    if (wp0Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adModel");
                    }
                    zp0 zp0Var = wp0Var.j;
                    if (zp0Var != null && (bq0Var = zp0Var.g) != null) {
                        if (TextUtils.equals(bq0Var.s, "__COINTIPS__")) {
                            bq0Var.s = "再看一个领取更多福利";
                        }
                        String str3 = bq0Var.d;
                        String str4 = "";
                        if (str3 != null) {
                            wp0 wp0Var2 = this.B;
                            if (wp0Var2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adModel");
                            }
                            AdOperator adOperator = wp0Var2.h;
                            if (adOperator == null || (str2 = adOperator.d) == null) {
                                str = "";
                            } else {
                                str = str2;
                            }
                            String replace$default = StringsKt__StringsJVMKt.replace$default(str3, "__BTN_SCHEME__", str, false, 4, (Object) null);
                            if (replace$default != null) {
                                str4 = replace$default;
                            }
                        }
                        bq0Var.d = str4;
                    }
                }
                Throwable m711exceptionOrNullimpl = Result.m711exceptionOrNullimpl(m708constructorimpl);
                if (m711exceptionOrNullimpl != null && ng0.a) {
                    s21.a().showToast(this, m711exceptionOrNullimpl.getMessage());
                }
                return Result.m715isSuccessimpl(m708constructorimpl);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
        }
        return invokeV.booleanValue;
    }

    public final void Y1(String str, String str2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, hashMap) == null) {
            zn0 zn0Var = new zn0();
            zn0Var.a = str;
            zn0Var.b = hashMap;
            bm0.a().a(zn0Var);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void Z0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.Z0(bundle);
            setContentView(R.layout.nad_reward_video_lp_activity);
            View findViewById = findViewById(R.id.ad_info_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_info_container)");
            this.x = (NadVideoAdOverContainer) findViewById;
            View findViewById2 = findViewById(R.id.tail_frame_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tail_frame_container)");
            this.v = (FrameLayout) findViewById2;
            View findViewById3 = findViewById(R.id.fl_video_container);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fl_video_container)");
            this.w = (FrameLayout) findViewById3;
            View findViewById4 = findViewById(R.id.fl_root);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.fl_root)");
            FrameLayout frameLayout = (FrameLayout) findViewById4;
            this.u = frameLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flRootView");
            }
            frameLayout.post(new f(this));
            if (!W1()) {
                finish();
                return;
            }
            U1();
            e2();
            f2();
            S1();
            a2();
            R1();
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            io0.e(wp0Var);
            T1();
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            int f2 = wp0Var.d().f();
            AbsRewardCountDownView absRewardCountDownView = this.z;
            if (absRewardCountDownView != null) {
                absRewardCountDownView.d();
            }
            AbsRewardCountDownView absRewardCountDownView2 = this.z;
            if (absRewardCountDownView2 != null) {
                wp0 wp0Var2 = this.B;
                if (wp0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adModel");
                }
                absRewardCountDownView2.setData(f2, wp0Var2.d(), new NadRewardVideoActivity$setCountDown$1(this));
            }
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            NadVideoAdOverContainer nadVideoAdOverContainer = this.x;
            if (nadVideoAdOverContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adInfoContainer");
            }
            nadVideoAdOverContainer.setAlsLogPage(ClogBuilder.Page.WELFAREMAXLP.type);
            wp0 wp0Var = this.B;
            if (wp0Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adModel");
            }
            nadVideoAdOverContainer.setData(wp0Var);
            nadVideoAdOverContainer.setOnNewTailFrameReplayClickListener(new h(this));
            nadVideoAdOverContainer.setOnUiClickListener(new i(this));
            nadVideoAdOverContainer.setFeedbackBtnVisibility(false);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public boolean k1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bundle)) == null) {
            if (!super.k1(bundle)) {
                return false;
            }
            getWindow().setSoftInputMode(19);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
            return true;
        }
        return invokeL.booleanValue;
    }
}
