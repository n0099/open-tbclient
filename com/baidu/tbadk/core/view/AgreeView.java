package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FirstPraiseToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.DisableZanSwitch;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.widget.lottie.TBLazyLottieAnimationView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ab5;
import com.baidu.tieba.at5;
import com.baidu.tieba.bb5;
import com.baidu.tieba.d85;
import com.baidu.tieba.da5;
import com.baidu.tieba.ft5;
import com.baidu.tieba.fw4;
import com.baidu.tieba.ly;
import com.baidu.tieba.oca;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.ua5;
import com.baidu.tieba.uq5;
import com.baidu.tieba.w85;
import com.baidu.tieba.wx9;
import com.baidu.tieba.xi;
import com.baidu.tieba.xi5;
import com.baidu.tieba.y15;
import com.baidu.tieba.yg5;
import com.baidu.tieba.yi;
import com.baidu.tieba.yi5;
import com.baidu.tieba.z15;
import com.baidu.tieba.z95;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import tbclient.CallRobotEntrance;
/* loaded from: classes4.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData A;
    public int B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public int E;
    public LinearLayout F;
    public LinearLayout G;
    public boolean H;
    public boolean I;
    public g J;
    public z95 K;
    public boolean L;
    public boolean M;
    public boolean N;
    public String O;
    public String P;
    public int Q;
    public boolean R;
    public i S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1078T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public h W;
    public int a;
    public j a0;
    public TbPageContext b;
    public View.OnClickListener b0;
    public TBLottieAnimationView c;
    public View.OnClickListener c0;
    public TextView d;
    public TBLottieAnimationView e;
    public TextView f;
    public TBLottieAnimationView g;
    public AgreeData h;
    public oca i;
    public ScaleAnimation j;
    public Animator.AnimatorListener k;
    public boolean l;
    public HeadCustomImageView m;
    public TextView n;
    public FriendBotView o;
    public boolean p;
    public boolean q;
    public z15 r;
    public int s;
    public String t;
    public int u;
    public int v;
    public int w;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes4.dex */
    public interface g {
        void a(View view2, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface i {
        void onLongPress();

        void onRelease();
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(long j, boolean z);
    }

    public static boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    public static int T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 == 2) {
                return 1;
            }
            return i2 == 3 ? 2 : -1;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public a(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.g.setVisibility(8);
                this.a.c.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.g.setVisibility(8);
                this.a.c.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        public b(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (!PraiseSwitch.isOn()) {
                    return false;
                }
                if (this.a.b0 != null) {
                    this.a.b0.onClick(view2);
                    return false;
                }
                this.a.R = true;
                if (this.a.r != null) {
                    this.a.r.d = 3;
                }
                this.a.P();
                if (this.a.S != null && TbadkCoreApplication.isLogin()) {
                    this.a.S.onLongPress();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        public c(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !this.a.R) {
                    return false;
                }
                if (this.a.S != null && TbadkCoreApplication.isLogin()) {
                    this.a.S.onRelease();
                }
                this.a.R = false;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        public d(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !PraiseSwitch.isOn()) {
                return;
            }
            if (this.a.b0 != null) {
                this.a.b0.onClick(view2);
                return;
            }
            w85.a(1, 1);
            if (this.a.A != null && this.a.A.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                w85.a(2, 1);
                return;
            }
            this.a.R(view2);
            View.OnClickListener onClickListener = this.a.D;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            if (this.a.E == 1 || this.a.E == 2) {
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
            this.a.Y();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AgreeView b;

        public e(AgreeView agreeView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = agreeView;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !BreatheTipWidget.f()) {
                ab5 ab5Var = new ab5();
                ab5Var.b = R.raw.lottie_bubble_breath_tip;
                ab5Var.a = BreatheTipWidget.PointType.LOTTIE;
                ab5Var.c = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                bb5 bb5Var = new bb5();
                bb5Var.a = this.b.getContext().getString(R.string.long_click_agree_tip_title);
                bb5Var.b = this.b.getContext().getString(R.string.agree_tip_content);
                bb5Var.e = R.drawable.pic_guidecard;
                bb5Var.f = yi.g(this.b.getContext(), R.dimen.tbds156);
                bb5Var.g = yi.g(this.b.getContext(), R.dimen.tbds489);
                bb5Var.h = yi.g(this.b.getContext(), R.dimen.tbds286);
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.b.getContext());
                breatheTipWidget.j(this.b.getImgAgree());
                breatheTipWidget.h(bb5Var, ab5Var);
                if (breatheTipWidget.k((Activity) this.b.getContext(), 4000L)) {
                    da5 p = da5.p();
                    p.A("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + this.a, true);
                    yg5.d("c14827", this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements xi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        public f(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        @Override // com.baidu.tieba.xi5
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (!StringUtils.isNull(str)) {
                    this.a.c.setImageAssetsFolder(str);
                }
                this.a.c.setAlpha(1.0f);
                if (this.a.Q == i) {
                    return;
                }
                this.a.Q = i;
                this.a.c.cancelAnimation();
                this.a.c.setAnimation(i);
            }
        }

        @Override // com.baidu.tieba.xi5
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.c.setAlpha(1.0f);
                if (this.a.P.equals(str)) {
                    return;
                }
                this.a.P = str;
                this.a.c.cancelAnimation();
                this.a.c.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }

        public h(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(agreeView);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || (agreeView = this.a.get()) == null || activity != agreeView.getContext()) {
                return;
            }
            agreeView.S();
        }
    }

    /* loaded from: classes4.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AgreeView agreeView) {
            super(2016530);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(agreeView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeView agreeView;
            oca ocaVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (agreeView = this.a.get()) == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof oca) || (ocaVar = (oca) customResponsedMessage.getData()) == null || (agreeData = ocaVar.b) == null || agreeView.h == null || TextUtils.isEmpty(agreeView.h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !agreeView.h.postId.equals(agreeData.postId) || agreeView.h.isInThread) {
                return;
            }
            if (agreeView.p) {
                if (agreeView.h.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (agreeView.i.a == ocaVar.a) {
                return;
            }
            agreeView.c0(agreeData);
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(AgreeView agreeView) {
            super(2016528);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(agreeView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeView agreeView;
            oca ocaVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (agreeView = this.a.get()) != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oca) && (ocaVar = (oca) customResponsedMessage.getData()) != null && (agreeData = ocaVar.b) != null && agreeView.h != null && agreeData != null && agreeView.i != null && !agreeView.h.isInPost && agreeView.i.a != ocaVar.a) {
                String str = agreeData.nid;
                if (agreeView.h.baijiahaoData != null && !"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.equals(str, agreeView.h.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    agreeView.c0(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = agreeView.h.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                agreeView.c0(agreeData);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.u = R.raw.lottie_agree;
        this.v = R.raw.lottie_disagree;
        this.w = R.color.CAM_X0107;
        this.z = false;
        this.B = 1;
        this.H = false;
        this.I = false;
        this.M = true;
        this.P = "";
        this.R = false;
        this.f1078T = true;
        this.U = new l(this);
        this.V = new k(this);
        this.W = new h(this);
        this.c0 = new d(this);
        G(context);
    }

    public final void U(StatisticItem statisticItem) {
        z15 z15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, statisticItem) == null) && statisticItem != null && (z15Var = this.r) != null) {
            int i2 = z15Var.b;
            if (i2 == 4 || i2 == 26 || i2 == 2 || i2 == 10 || i2 == 25) {
                int i3 = this.r.d;
                if (i3 == 1) {
                    String i4 = yi5.g().i();
                    if (!StringUtils.isNull(i4)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i4);
                    }
                } else if (i3 == 2) {
                    String f2 = yi5.g().f();
                    if (!StringUtils.isNull(f2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
                    }
                } else if (i3 == 3) {
                    String h2 = yi5.g().h();
                    if (!StringUtils.isNull(h2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, h2);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.u = R.raw.lottie_agree;
        this.v = R.raw.lottie_disagree;
        this.w = R.color.CAM_X0107;
        this.z = false;
        this.B = 1;
        this.H = false;
        this.I = false;
        this.M = true;
        this.P = "";
        this.R = false;
        this.f1078T = true;
        this.U = new l(this);
        this.V = new k(this);
        this.W = new h(this);
        this.c0 = new d(this);
        G(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.u = R.raw.lottie_agree;
        this.v = R.raw.lottie_disagree;
        this.w = R.color.CAM_X0107;
        this.z = false;
        this.B = 1;
        this.H = false;
        this.I = false;
        this.M = true;
        this.P = "";
        this.R = false;
        this.f1078T = true;
        this.U = new l(this);
        this.V = new k(this);
        this.W = new h(this);
        this.c0 = new d(this);
        G(context);
    }

    public final String E(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, agreeData)) == null) {
            return D(agreeData);
        }
        return (String) invokeL.objValue;
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.L = z;
            if (this.f1078T && z) {
                ua5.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void V(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    public final void c0(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, agreeData) == null) && agreeData != null && (agreeData2 = this.h) != null) {
            agreeData2.agreeType = agreeData.agreeType;
            agreeData2.hasAgree = agreeData.hasAgree;
            agreeData2.agreeNum = agreeData.agreeNum;
            d0();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, animator) == null) && (animatorListener = this.k) != null) {
            animatorListener.onAnimationCancel(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, animator) == null) {
            if (!this.N) {
                X();
            }
            Animator.AnimatorListener animatorListener = this.k;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
                if (this.l) {
                    this.k = null;
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, animator) == null) && (animatorListener = this.k) != null) {
            animatorListener.onAnimationRepeat(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, animator) == null) && (animatorListener = this.k) != null) {
            animatorListener.onAnimationStart(animator);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public void setAgreeAnimationListenOnce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.l = z;
        }
    }

    public void setAgreeAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, animatorListener) == null) {
            this.k = animatorListener;
        }
    }

    public void setAgreeClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAgreeLongClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, iVar) == null) {
            this.S = iVar;
            this.c.setOnLongClickListener(new b(this));
            this.c.setOnTouchListener(new c(this));
        }
    }

    public void setAgreeSource(int i2) {
        z15 z15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048633, this, i2) == null) && (z15Var = this.r) != null) {
            z15Var.d = i2;
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, agreeData) != null) || agreeData == null) {
            return;
        }
        this.h = agreeData;
        d0();
        Q(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFriendBotClickCallBack(FriendBotView.d dVar) {
        FriendBotView friendBotView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, dVar) == null) && (friendBotView = this.o) != null) {
            friendBotView.setClickCallBack(dVar);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.E = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setIsAgreeNumClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.I = z;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.p = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.q = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.M = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.w = i2;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setOnAgreeNumUpdateListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, jVar) == null) {
            this.a0 = jVar;
        }
    }

    public void setStatisticData(z15 z15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, z15Var) == null) {
            this.r = z15Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.t = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, threadData) == null) {
            this.A = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            this.x = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.y = str;
        }
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.N = true;
            this.O = str;
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            this.f1078T = z;
        }
    }

    public void setVisibilityListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, gVar) == null) {
            this.J = gVar;
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048646, this, i2, i3) == null) {
            this.u = i2;
            this.v = i3;
            setAgreeAnimationResource();
        }
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, textView) == null) {
            if (this.q) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.p) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.w));
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                I(yi.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.H);
                return;
            }
            I(yi.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.H);
        }
    }

    public void F(boolean z) {
        int i2;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.e;
            int i3 = 8;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setVisibility(i2);
            LinearLayout linearLayout = this.F;
            if (linearLayout != null) {
                if (!z) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            if (this.H != z && (gVar = this.J) != null) {
                gVar.a(this.e, z);
            }
            this.H = z;
        }
    }

    public void setAgreeAlone(boolean z) {
        int i2;
        g gVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.e;
            int i3 = 0;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setVisibility(i2);
            TextView textView = this.f;
            if (z) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (z && (linearLayout = this.F) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.H != z && (gVar = this.J) != null) {
                gVar.a(this.e, z);
            }
            this.H = z;
        }
    }

    public void setDisagreeShow(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.e;
            int i4 = 8;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setVisibility(i2);
            TextView textView = this.f;
            if (z) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
            LinearLayout linearLayout = this.F;
            if (linearLayout != null) {
                if (!z) {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
            }
            this.H = z;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int g2 = yi.g(getContext(), R.dimen.tbds112);
            int g3 = yi.g(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -g3;
            layoutParams.topMargin = yi.g(getContext(), R.dimen.tbds_2);
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, yi.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = yi.g(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = yi.g(getContext(), R.dimen.tbds_2);
            this.d.setLayoutParams(layoutParams2);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void w() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && this.G != null && (tBLottieAnimationView = this.c) != null && this.d != null) {
            V(tBLottieAnimationView);
            V(this.d);
            int g2 = yi.g(getContext(), R.dimen.tbds74);
            this.G.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 0;
            this.G.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(g2, g2));
            this.G.addView(this.d);
            this.G.addView(this.c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AgreeData agreeData2;
        String str6;
        at5 findPageExtraByView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.r != null && (agreeData = this.h) != null) {
            int i2 = 0;
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData != null) {
                i2 = baijiahaoData.oriUgcType;
            }
            int i3 = this.r.a;
            if (i3 == 1) {
                if (StringUtils.isNull(this.x)) {
                    StatisticItem param = new StatisticItem("c12003").param("obj_locate", this.r.b).param("obj_param1", this.r.c).param("obj_source", this.r.d).param("obj_id", this.r.e).param("obj_name", i2).param("post_id", this.h.postId);
                    ThreadData threadData = this.A;
                    if (threadData != null) {
                        param.param("tid", threadData.getId()).param("nid", this.A.getNid()).param("fid", this.A.getFid()).param("card_type", this.B).param("ab_tag", this.A.mRecomAbTag).param("recom_source", this.A.mRecomSource).param("weight", this.A.mRecomWeight).param("thread_type", this.A.threadType).param("extra", this.A.mRecomExtra);
                        if (this.A.getBaijiahaoData() != null) {
                            param.param(TiebaStatic.Params.OBJ_PARAM4, this.A.getBaijiahaoData().oriUgcNid);
                            if (this.A.isBJHVideoThreadType() || this.A.isBJHVideoDynamicThreadType()) {
                                param.param(TiebaStatic.Params.OBJ_PARAM6, this.A.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.A.isBjhDynamicThread()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        } else if (!this.A.isBJHArticleThreadType() && !this.A.isBJHVideoThreadType()) {
                            int i4 = this.A.threadType;
                            if (i4 == 0 || i4 == 40) {
                                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                            }
                        } else {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                        }
                    } else {
                        param.param("tid", this.h.threadId);
                        param.param("nid", this.h.nid);
                        param.param("fid", this.h.forumId);
                        param.param("card_type", this.h.cardType);
                        param.param("ab_tag", this.h.recomAbTag);
                        param.param("recom_source", this.h.recomSource);
                        param.param("weight", this.h.recomWeight);
                        param.param("extra", this.h.recomExtra);
                        BaijiahaoData baijiahaoData2 = this.h.baijiahaoData;
                        if (baijiahaoData2 != null) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2.oriUgcVid);
                        }
                    }
                    if (M(this.r.b) && T(this.r.f) != -1) {
                        param.param(TiebaStatic.Params.OBJ_TO, T(this.r.f));
                    }
                    int i5 = this.E;
                    if (i5 == 1) {
                        str3 = "resource_id";
                        str4 = TiebaStatic.Params.OBJ_TAB;
                        str5 = "a002";
                    } else if (i5 == 2) {
                        str3 = "resource_id";
                        str5 = "a002";
                        str4 = TiebaStatic.Params.OBJ_TAB;
                    } else {
                        if (i5 == 18) {
                            param.param(TiebaStatic.Params.OBJ_TAB, "a099");
                            param.param("resource_id", this.t);
                        } else {
                            param.param("resource_id", this.s);
                        }
                        str5 = "a002";
                        if (getTbPageContext() != null) {
                            ft5.b(getTbPageContext().getPageActivity(), param);
                        }
                        agreeData2 = this.h;
                        if (!agreeData2.isFromImageViewer) {
                            str6 = "index";
                            if (agreeData2.mImageViewerFromPage == str6) {
                                param.param(GuildActivityConfig.FROM_PAGE, str5);
                            }
                        } else {
                            str6 = "index";
                        }
                        if (str6.equals(this.h.keyFromHomePage)) {
                            param.param(TiebaStatic.Params.OBJ_PRE_PAGE, str5);
                            param.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                        }
                        findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                        if (findPageExtraByView != null) {
                            param.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                        }
                        if (TbPageExtraHelper.getPrePageKey() != null) {
                            param.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                        }
                        U(param);
                        TiebaStatic.log(param);
                    }
                    param.param(str4, str5);
                    param.param(str3, this.s);
                    if (getTbPageContext() != null) {
                    }
                    agreeData2 = this.h;
                    if (!agreeData2.isFromImageViewer) {
                    }
                    if (str6.equals(this.h.keyFromHomePage)) {
                    }
                    findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                    if (findPageExtraByView != null) {
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                    }
                    U(param);
                    TiebaStatic.log(param);
                } else if (this.r.b == 4 && this.z) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.h.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.y).param("topic_id", this.x));
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.h.threadId).param("topic_id", this.x));
                }
                Z();
            } else if (i3 == 2) {
                StatisticItem param2 = new StatisticItem("c13271").param("obj_type", this.r.g).param("obj_locate", this.r.h).param(TiebaStatic.Params.OBJ_PARAM2, this.s).param("obj_id", this.r.i).param("obj_name", i2).param("post_id", this.h.postId).param("nid", this.h.nid);
                ThreadData threadData2 = this.A;
                if (threadData2 != null) {
                    param2.param("tid", threadData2.getId()).param("nid", this.A.getNid()).param("fid", this.A.getFid()).param("card_type", this.B).param("ab_tag", this.A.mRecomAbTag).param("recom_source", this.A.mRecomSource).param("weight", this.A.mRecomWeight).param("extra", this.A.mRecomExtra);
                    if (this.A.getBaijiahaoData() != null) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM4, this.A.getBaijiahaoData().oriUgcNid);
                        if (this.A.isBJHVideoThreadType() || this.A.isBJHVideoDynamicThreadType()) {
                            param2.param(TiebaStatic.Params.OBJ_PARAM6, this.A.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.A.isBjhDynamicThread()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.A.isBJHArticleThreadType() && !this.A.isBJHVideoThreadType()) {
                        int i6 = this.A.threadType;
                        if (i6 == 0 || i6 == 40) {
                            param2.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                        }
                    } else {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    }
                } else {
                    param2.param("tid", this.h.threadId);
                    param2.param("nid", this.h.nid);
                    param2.param("fid", this.h.forumId);
                    param2.param("card_type", this.h.cardType);
                    param2.param("ab_tag", this.h.recomAbTag);
                    param2.param("recom_source", this.h.recomSource);
                    param2.param("weight", this.h.recomWeight);
                    param2.param("extra", this.h.recomExtra);
                    BaijiahaoData baijiahaoData3 = this.h.baijiahaoData;
                    if (baijiahaoData3 != null) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData3.oriUgcVid);
                    }
                }
                int i7 = this.E;
                if (i7 != 1) {
                    if (i7 == 2) {
                        str2 = "a002";
                        str = TiebaStatic.Params.OBJ_TAB;
                    } else {
                        if (i7 == 18) {
                            str = TiebaStatic.Params.OBJ_TAB;
                            param2.param(str, "a099");
                            param2.param("resource_id", this.t);
                        } else {
                            str = TiebaStatic.Params.OBJ_TAB;
                        }
                        str2 = "a002";
                        if (getTbPageContext() != null) {
                            ft5.b(getTbPageContext().getPageActivity(), param2);
                        }
                        if (this.h.isFromImageViewer) {
                            param2.param(str, "a008");
                            if (this.h.mImageViewerFromPage == "index") {
                                param2.param(GuildActivityConfig.FROM_PAGE, str2);
                            }
                        }
                        TiebaStatic.log(param2);
                    }
                } else {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                }
                param2.param(str, str2);
                if (getTbPageContext() != null) {
                }
                if (this.h.isFromImageViewer) {
                }
                TiebaStatic.log(param2);
            }
        }
    }

    public final String D(AgreeData agreeData) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, agreeData)) == null) {
            if (agreeData != null) {
                j2 = agreeData.agreeNum;
            } else {
                j2 = 0;
            }
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.c_agree);
            }
            if (i2 > 0) {
                z15 z15Var = this.r;
                if (z15Var != null && z15Var.c == 7) {
                    return StringHelper.numberUniformFormatExtraWithCollect(j2);
                }
                return StringHelper.numFormatOverWanNa(j2);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j2);
        }
        return (String) invokeL.objValue;
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && this.h != null && this.a != i2) {
            this.a = i2;
            SkinManager.setLottieAnimation(this.e, this.v);
            if (this.N) {
                f0();
            } else {
                SkinManager.setLottieAnimation(this.c, this.u);
                if (this.L) {
                    ua5.f(this.c, i2);
                }
            }
            HeadCustomImageView headCustomImageView = this.m;
            if (headCustomImageView != null) {
                headCustomImageView.e(i2);
            }
            TextView textView = this.n;
            if (textView != null) {
                d85 d2 = d85.d(textView);
                d2.C(R.dimen.T_X09);
                d2.x(R.color.CAM_X0107);
            }
            d0();
        }
    }

    public final void G(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.img_agree);
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addAnimatorListener(this);
            this.c.setOnClickListener(this.c0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.g = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.img_firework_agree);
            this.g.setVisibility(8);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, yi.g(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.c0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView3 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView3;
            tBLazyLottieAnimationView3.setId(R.id.img_disagree);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.c0);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.c_disagree);
            this.f.setTextSize(0, yi.g(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.c0);
            HeadCustomImageView headCustomImageView = new HeadCustomImageView(getContext());
            this.m = headCustomImageView;
            headCustomImageView.setId(R.id.bottom_head_custom_image_view);
            FriendBotView friendBotView = new FriendBotView(getContext());
            this.o = friendBotView;
            friendBotView.setId(R.id.pb_img_friend_bot_view);
            oca ocaVar = new oca();
            this.i = ocaVar;
            ocaVar.a = getPageId();
            this.K = new z95();
            H();
            SkinManager.setLottieAnimation(this.e, this.v);
            FirstPraiseToast.getInstance();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.bottom_agree_container);
            this.G = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.c0);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.bottom_disagree_container);
            this.F = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.c0);
            linearLayout2.addView(this.e);
            linearLayout2.addView(this.f);
            B(false);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            this.c.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setAnimation(R.raw.lottie_feed_firework_agree);
            this.g.setRepeatCount(2);
            if (this.g.getParent() == null) {
                this.G.addView(this.g, 0, layoutParams);
            }
            this.g.playAnimation();
            this.g.addAnimatorListener(new a(this));
        }
    }

    public final void f0() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ThreadData threadData = this.A;
            if (threadData != null) {
                if (threadData instanceof AdvertAppInfo) {
                    y15 y15Var = ((AdvertAppInfo) threadData).i;
                    if (y15Var != null) {
                        str3 = y15Var.c;
                    } else {
                        str3 = null;
                    }
                    str2 = str3;
                    str = null;
                } else {
                    String valueOf = String.valueOf(threadData.getFid());
                    str = this.A.getTid();
                    str2 = valueOf;
                }
            } else {
                str = null;
                str2 = null;
            }
            yi5.g().e(this.O, str, str2, this.M, new f(this));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            removeAllViews();
            V(this.c);
            V(this.e);
            V(this.d);
            V(this.f);
            H();
            I(yi.g(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public final void I(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            int i6 = -yi.g(getContext(), R.dimen.tbds24);
            int g2 = yi.g(getContext(), R.dimen.tbds34);
            this.G.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.G.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.d.setLayoutParams(layoutParams2);
            this.F.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.F.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f.setLayoutParams(layoutParams5);
        }
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.R;
        }
        return invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            z15 z15Var = this.r;
            if (z15Var != null && z15Var.d == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !PraiseSwitch.isOn()) {
            return;
        }
        View.OnClickListener onClickListener = this.b0;
        if (onClickListener != null) {
            onClickListener.onClick(this.c);
            return;
        }
        R(this.c);
        z15 z15Var = this.r;
        if (z15Var != null) {
            z15Var.d = 1;
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.R) {
            if (this.S != null && TbadkCoreApplication.isLogin()) {
                this.S.onRelease();
            }
            this.R = false;
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.h;
        }
        return (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @NonNull
    public FriendBotView getFriendBotView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.o;
        }
        return (FriendBotView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public boolean getIsAgreeNumClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public oca getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.i;
        }
        return (oca) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            TbPageContext tbPageContext = getTbPageContext();
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.U);
            MessageManager.getInstance().registerListener(this.V);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.W);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.U);
            MessageManager.getInstance().unRegisterListener(this.V);
            TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.W);
        }
    }

    public void setTextViewMinEmsWhenCard() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && (textView = this.d) != null) {
            textView.setMinEms(2);
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.N = true;
            this.O = "/feed";
        }
    }

    public void setUseDynamicLikeResImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.N = true;
            this.O = "/feed";
            f0();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.h != null && this.c != null) {
            if (this.p && !uq5.a(getContext())) {
                return;
            }
            if (!this.p && !ViewHelper.checkUpIsLogin(getContext())) {
                return;
            }
            this.c.cancelAnimation();
            z15 z15Var = this.r;
            if (z15Var != null) {
                z15Var.a = 1;
            }
            this.z = true;
            this.h.agreeType = 2;
            if (!DisableZanSwitch.getIsOn()) {
                AgreeData agreeData = this.h;
                if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                    this.h.agreeNum++;
                }
                this.h.hasAgree = true;
                d0();
            }
            z15 z15Var2 = this.r;
            if (z15Var2 != null) {
                z15Var2.e = 1;
            }
            at5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                this.h.objSource = findPageExtraByView.a();
            }
            AgreeData agreeData2 = this.h;
            agreeData2.agreeClickType = 1;
            this.K.c(agreeData2, 0, getPageId(), this.p);
            AgreeData agreeData3 = this.h;
            agreeData3.agreeClickType = 0;
            this.K.d(agreeData3, this.i);
            View.OnClickListener onClickListener = this.C;
            if (onClickListener != null) {
                onClickListener.onClick(this.c);
            }
            C();
            z15 z15Var3 = this.r;
            if (z15Var3 != null) {
                z15Var3.d = 1;
            }
        }
    }

    public final void Y() {
        AgreeData agreeData;
        z15 z15Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (agreeData = this.h) != null && agreeData.agreeType == 2 && agreeData.hasAgree && (z15Var = this.r) != null && z15Var.d == 1) {
            String str = null;
            int i3 = z15Var.b;
            if (i3 != 4 && i3 != 26) {
                if ((i3 == 1 && z15Var.c != 7) || (i2 = this.r.b) == 7 || i2 == 9 || i2 == 10 || i2 == 22 || i2 == 2) {
                    str = "card";
                }
            } else {
                str = this.r.b + "";
            }
            if (xi.isEmpty(str)) {
                return;
            }
            if (!da5.p().l("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + str, false)) {
                zg.a().postDelayed(new e(this, str), 1000L);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            String E = E(this.h);
            if (this.h == null) {
                return;
            }
            this.d.setText(E);
            this.c.cancelAnimation();
            AgreeData agreeData = this.h;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.e.setProgress(0.0f);
                    this.c.setProgress(1.0f);
                    this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f);
                } else {
                    this.c.setProgress(0.0f);
                    this.e.setProgress(1.0f);
                    setTextNormalColor(this.d);
                    this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
            } else {
                this.c.setProgress(0.0f);
                this.e.setProgress(0.0f);
                setTextNormalColor(this.d);
                setTextNormalColor(this.f);
                if (this.L) {
                    ua5.c(this.d);
                }
            }
            if (this.L) {
                ua5.d(this.d);
            }
            j jVar = this.a0;
            if (jVar != null) {
                AgreeData agreeData2 = this.h;
                jVar.a(agreeData2.agreeNum, agreeData2.hasAgree);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R(View view2) {
        int i2;
        at5 findPageExtraByView;
        z15 z15Var;
        int i3;
        z15 z15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            int i4 = -1;
            if (this.h != null && view2 != null) {
                if (this.p && !uq5.a(getContext())) {
                    z15 z15Var3 = this.r;
                    if (z15Var3 != null) {
                        i4 = z15Var3.d;
                    }
                    w85.a(4, i4);
                    return;
                } else if (!this.p && !ViewHelper.checkUpIsLogin(getContext())) {
                    z15 z15Var4 = this.r;
                    if (z15Var4 != null) {
                        i4 = z15Var4.d;
                    }
                    w85.a(4, i4);
                    return;
                } else if (!UbsABTestHelper.isAgreeNumberCanClick() && view2 == this.d && !this.I) {
                    z15 z15Var5 = this.r;
                    if (z15Var5 != null) {
                        i4 = z15Var5.d;
                    }
                    w85.a(5, i4);
                    return;
                } else {
                    int i5 = 0;
                    if (view2.getId() == this.m.getId()) {
                        this.z = false;
                        this.m.b();
                    } else if (view2.getId() == this.o.getId()) {
                        this.z = false;
                        this.o.g();
                    } else {
                        int i6 = 1;
                        if (view2.getId() != this.G.getId() && view2.getId() != this.c.getId() && ((!UbsABTestHelper.isAgreeNumberCanClick() && !this.I) || view2.getId() != this.d.getId())) {
                            if (view2.getId() == this.F.getId() || view2.getId() == this.e.getId()) {
                                this.e.cancelAnimation();
                                z15 z15Var6 = this.r;
                                if (z15Var6 != null) {
                                    z15Var6.a = 2;
                                }
                                AgreeData agreeData = this.h;
                                if (agreeData.hasAgree) {
                                    if (agreeData.agreeType == 5) {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = false;
                                        d0();
                                        z15 z15Var7 = this.r;
                                        if (z15Var7 != null) {
                                            z15Var7.i = 0;
                                        }
                                        this.z = false;
                                        findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                        if (findPageExtraByView != null) {
                                            this.h.objSource = findPageExtraByView.a();
                                        }
                                        z15Var = this.r;
                                        if (z15Var == null) {
                                            i3 = z15Var.d;
                                        } else {
                                            i3 = -1;
                                        }
                                        w85.a(6, i3);
                                        this.K.c(this.h, i6, getPageId(), this.p);
                                        z15Var2 = this.r;
                                        if (z15Var2 != null) {
                                            i4 = z15Var2.d;
                                        }
                                        w85.a(7, i4);
                                    } else {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = true;
                                        agreeData.agreeNum--;
                                        e0(false);
                                        z15 z15Var8 = this.r;
                                        if (z15Var8 != null) {
                                            z15Var8.i = 1;
                                        }
                                    }
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    e0(false);
                                    z15 z15Var9 = this.r;
                                    if (z15Var9 != null) {
                                        z15Var9.i = 1;
                                    }
                                }
                                i6 = 0;
                                this.z = false;
                                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                if (findPageExtraByView != null) {
                                }
                                z15Var = this.r;
                                if (z15Var == null) {
                                }
                                w85.a(6, i3);
                                this.K.c(this.h, i6, getPageId(), this.p);
                                z15Var2 = this.r;
                                if (z15Var2 != null) {
                                }
                                w85.a(7, i4);
                            }
                        } else {
                            this.c.cancelAnimation();
                            z15 z15Var10 = this.r;
                            if (z15Var10 != null) {
                                z15Var10.a = 1;
                            }
                            AgreeData agreeData2 = this.h;
                            if (agreeData2.hasAgree) {
                                if (agreeData2.agreeType == 2) {
                                    this.z = false;
                                    agreeData2.agreeType = 2;
                                    if (!DisableZanSwitch.getIsOn()) {
                                        AgreeData agreeData3 = this.h;
                                        agreeData3.hasAgree = false;
                                        agreeData3.agreeNum--;
                                        d0();
                                    }
                                    z15 z15Var11 = this.r;
                                    if (z15Var11 != null) {
                                        z15Var11.e = 1;
                                    }
                                    i5 = 1;
                                } else {
                                    this.z = true;
                                    agreeData2.agreeType = 2;
                                    if (!DisableZanSwitch.getIsOn()) {
                                        AgreeData agreeData4 = this.h;
                                        agreeData4.hasAgree = true;
                                        agreeData4.agreeNum++;
                                        e0(true);
                                        wx9.g().l(getTbPageContext());
                                    }
                                    z15 z15Var12 = this.r;
                                    if (z15Var12 != null) {
                                        z15Var12.e = 0;
                                    }
                                }
                            } else {
                                this.z = true;
                                agreeData2.agreeType = 2;
                                if (!DisableZanSwitch.getIsOn()) {
                                    AgreeData agreeData5 = this.h;
                                    agreeData5.hasAgree = true;
                                    agreeData5.agreeNum++;
                                    e0(true);
                                    wx9.g().l(getTbPageContext());
                                }
                                z15 z15Var13 = this.r;
                                if (z15Var13 != null) {
                                    z15Var13.e = 0;
                                }
                            }
                            at5 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView2 != null) {
                                this.h.objSource = findPageExtraByView2.a();
                            }
                            z15 z15Var14 = this.r;
                            if (z15Var14 != null) {
                                i2 = z15Var14.d;
                            } else {
                                i2 = -1;
                            }
                            w85.a(6, i2);
                            this.K.c(this.h, i5, getPageId(), this.p);
                            z15 z15Var15 = this.r;
                            if (z15Var15 != null) {
                                i4 = z15Var15.d;
                            }
                            w85.a(7, i4);
                        }
                    }
                    this.K.d(this.h, this.i);
                    View.OnClickListener onClickListener = this.C;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    C();
                    return;
                }
            }
            z15 z15Var16 = this.r;
            if (z15Var16 != null) {
                i4 = z15Var16.d;
            }
            w85.a(3, i4);
        }
    }

    public void X() {
        AgreeData agreeData;
        z15 z15Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (agreeData = this.h) == null || agreeData.agreeType != 2 || (z15Var = this.r) == null) {
            return;
        }
        int i2 = z15Var.b;
        if (i2 == 2 || i2 == 4 || i2 == 26 || i2 == 5 || i2 == 12) {
            FirstPraiseToast.getInstance().show();
        }
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.j == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.j = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.j;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.b == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.b = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.b = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.b;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (!this.f1078T) {
                SkinManager.setLottieAnimation(this.e, this.v);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.u);
            SkinManager.setLottieAnimation(this.e, this.v);
            if (this.L) {
                ua5.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.N = true;
            this.O = "/pb";
            f0();
            AgreeData agreeData = this.h;
            if (agreeData != null && agreeData.hasAgree && agreeData.agreeType == 2) {
                this.c.setProgress(1.0f);
            } else {
                this.c.setProgress(0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z() {
        ThreadData threadData;
        z15 z15Var;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (threadData = this.A) != null && (z15Var = this.r) != null && threadData.isTiebaPlusAdThread) {
            int i8 = z15Var.b;
            if (i8 != 1 && i8 != 2 && i8 != 10 && i8 != 25 && i8 != 4) {
                return;
            }
            z15 z15Var2 = this.r;
            if (z15Var2.b == 4 && (i7 = z15Var2.f) != 2 && i7 != 3) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
            int i9 = this.r.b;
            if (i9 == 1) {
                statisticItem.addParam("obj_locate", 1);
            } else if (i9 != 2 && i9 != 25 && i9 != 10) {
                if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
            } else {
                int i10 = this.A.tiePlusFrsStaticLocate;
                if (i10 != 2) {
                    statisticItem.addParam("obj_locate", i10 + 1);
                } else {
                    statisticItem.addParam("obj_locate", 2);
                }
            }
            if (this.A.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.A.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.A.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.A.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.r.j);
            int i11 = this.r.e;
            if (i11 == 0) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
            } else if (i11 == 1) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
            }
            statisticItem.addParam("order_id", this.A.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            int i12 = this.r.e;
            if (i12 == 0) {
                i3 = fw4.g;
            } else if (i12 == 1) {
                i3 = fw4.j;
            } else {
                i2 = 0;
                i4 = this.r.b;
                if (i4 != 1) {
                    i6 = fw4.a;
                } else if (i4 == 2) {
                    i6 = fw4.b;
                } else if (M(i4)) {
                    i6 = fw4.c;
                } else {
                    i5 = 0;
                    ThreadData threadData2 = this.A;
                    fw4.a(i2, i5, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                }
                i5 = i6;
                ThreadData threadData22 = this.A;
                fw4.a(i2, i5, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
            }
            i2 = i3;
            i4 = this.r.b;
            if (i4 != 1) {
            }
            i5 = i6;
            ThreadData threadData222 = this.A;
            fw4.a(i2, i5, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
        }
    }

    public void a0(VirtualImageCustomFigure virtualImageCustomFigure, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, virtualImageCustomFigure, metaData) == null) && virtualImageCustomFigure != null) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.m.setShowHomeIcon(false);
            this.m.setHeadImageViewResource(virtualImageCustomFigure.getFigureUrl());
            this.m.setHeadImageBackgroundColorResource(virtualImageCustomFigure.getBackgroundValue());
            this.m.setVisibility(0);
            this.m.setUserInfo(metaData);
            this.m.setFrom(4);
            this.m.setOnClickListener(this.c0);
            this.m.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds68), UtilHelper.getDimenPixelSize(R.dimen.tbds85));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds68);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds85);
            int g2 = yi.g(getContext(), R.dimen.tbds8);
            int g3 = yi.g(getContext(), R.dimen.tbds13);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = dimenPixelSize;
            layoutParams.height = dimenPixelSize2;
            layoutParams.topMargin = g2;
            if (this.m.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.m.getParent()).removeAllViews();
            }
            this.F.setOnClickListener(null);
            this.F.addView(this.m, layoutParams);
            if (this.n == null) {
                this.n = new EMTextView(getContext());
            }
            this.n.setText(getContext().getString(R.string.pb_first_custom_head_title));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = g3;
            this.F.addView(this.n, layoutParams2);
            ThreadData threadData = this.A;
            if (threadData != null) {
                ly.a(2, threadData.getTid(), ly.d, ly.f, null, this.A.getAuthorId());
            }
        }
    }

    public void b0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, threadData) == null) && !TextUtils.isEmpty(threadData.getTid()) && threadData.getCallRobotEntrance() != null && threadData.getCallRobotEntrance().style_conf != null && !TextUtils.isEmpty(threadData.getCallRobotEntrance().style_conf.day.icon) && !TextUtils.isEmpty(threadData.getCallRobotEntrance().style_conf.dark.icon)) {
            CallRobotEntrance callRobotEntrance = threadData.getCallRobotEntrance();
            String tid = threadData.getTid();
            boolean isForceRefreshCallRobotEntrance = threadData.isForceRefreshCallRobotEntrance();
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.o.setVisibility(0);
            this.o.setTid(tid);
            this.o.m();
            if (this.o.getRobotEntrance() == null) {
                this.o.setRobotEntrance(callRobotEntrance);
            } else if (isForceRefreshCallRobotEntrance) {
                this.o.e(callRobotEntrance);
                threadData.setForceRefreshCallRobotEntrance(false);
            }
            this.o.setOnClickListener(this.c0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.bottomMargin = yi.g(getContext(), R.dimen.tbds18);
            if (this.o.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.o.getParent()).removeAllViews();
            }
            this.F.setOnClickListener(null);
            this.F.addView(this.o, layoutParams);
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048604, this, z) != null) || this.h == null) {
            return;
        }
        this.c.setMinAndMaxProgress(0.0f, 1.0f);
        this.e.setMinAndMaxProgress(0.0f, 1.0f);
        this.d.setText(E(this.h));
        this.c.clearColorFilter();
        this.e.clearColorFilter();
        if (z) {
            this.c.playAnimation();
            this.e.cancelAnimation();
            this.e.setFrame(0);
        } else {
            this.e.playAnimation();
            this.c.cancelAnimation();
            this.c.setFrame(0);
        }
        AgreeData agreeData = this.h;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.f);
            } else {
                setTextNormalColor(this.d);
                this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                if (this.L) {
                    ua5.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.L) {
                ua5.c(this.d);
            }
        }
        if (this.L) {
            ua5.d(this.d);
        }
        j jVar = this.a0;
        if (jVar != null) {
            AgreeData agreeData2 = this.h;
            jVar.a(agreeData2.agreeNum, agreeData2.hasAgree);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z) == null) {
            int g2 = yi.g(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, yi.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -yi.g(getContext(), R.dimen.tbds24);
                int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.d.setPadding(0, g3, g3 * 3, g3);
                this.I = true;
            } else {
                layoutParams2.leftMargin = -yi.g(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = yi.g(getContext(), R.dimen.tbds28);
            }
            this.e.setLayoutParams(layoutParams3);
            this.f.setVisibility(8);
        }
    }

    public void v(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048659, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            if (i4 != 0) {
                layoutParams2.width = i4;
            }
            layoutParams2.leftMargin = i5;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i3);
            layoutParams3.gravity = 16;
            this.e.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams4.leftMargin = i5;
            this.f.setLayoutParams(layoutParams4);
        }
    }

    public void y() {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            int g2 = yi.g(getContext(), R.dimen.tbds120);
            removeAllViews();
            V(this.c);
            V(this.e);
            V(this.d);
            V(this.f);
            int i6 = !UbsABTestHelper.isPbEnterForumStyle() ? 1 : 0;
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                i2 = 16;
            } else {
                i2 = 1;
            }
            Context context = getContext();
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                i3 = R.dimen.T_X07;
            } else {
                i3 = R.dimen.T_X09;
            }
            int g3 = yi.g(context, i3);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.bottom_agree_container);
            linearLayout.setOrientation(i6);
            linearLayout.setGravity(1);
            int i7 = 0;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = yi.g(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            layoutParams.gravity = i2;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.c0);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(g2, g2));
            float f2 = g3;
            this.d.setTextSize(0, f2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = i2;
            int i8 = -yi.g(getContext(), R.dimen.tbds23);
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                i4 = i8;
            } else {
                i4 = 0;
            }
            layoutParams2.leftMargin = i4;
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                i8 = 0;
            }
            layoutParams2.topMargin = i8;
            linearLayout.addView(this.d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.bottom_disagree_container);
            linearLayout2.setOrientation(i6);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = yi.g(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            layoutParams3.gravity = i2;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.c0);
            this.F = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(g2, g2));
            this.f.setTextSize(0, f2);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = i2;
            int i9 = -yi.g(getContext(), R.dimen.tbds25);
            if (UbsABTestHelper.isPbEnterForumStyle()) {
                i5 = i9;
            } else {
                i5 = 0;
            }
            layoutParams4.leftMargin = i5;
            if (!UbsABTestHelper.isPbEnterForumStyle()) {
                i7 = i9;
            }
            layoutParams4.topMargin = i7;
            linearLayout2.addView(this.f, layoutParams4);
        }
    }
}
