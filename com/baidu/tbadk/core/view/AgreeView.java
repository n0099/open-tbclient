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
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.DisableZanSwitch;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.widget.lottie.TBLazyLottieAnimationView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ea5;
import com.baidu.tieba.fa5;
import com.baidu.tieba.gp5;
import com.baidu.tieba.h85;
import com.baidu.tieba.iw4;
import com.baidu.tieba.iy;
import com.baidu.tieba.j95;
import com.baidu.tieba.ll9;
import com.baidu.tieba.m15;
import com.baidu.tieba.mr5;
import com.baidu.tieba.n15;
import com.baidu.tieba.n95;
import com.baidu.tieba.o75;
import com.baidu.tieba.rr5;
import com.baidu.tieba.sf5;
import com.baidu.tieba.sh5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.th5;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.wg;
import com.baidu.tieba.y95;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public int D;
    public LinearLayout E;
    public LinearLayout F;
    public boolean G;
    public boolean H;
    public g I;
    public j95 J;
    public boolean K;
    public boolean L;
    public boolean M;
    public String N;
    public String O;
    public int P;
    public boolean Q;
    public i R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public CustomMessageListener f1077T;
    public CustomMessageListener U;
    public h V;
    public j W;
    public int a;
    public View.OnClickListener a0;
    public TbPageContext b;
    public TBLottieAnimationView c;
    public TextView d;
    public TBLottieAnimationView e;
    public TextView f;
    public TBLottieAnimationView g;
    public AgreeData h;
    public zx9 i;
    public ScaleAnimation j;
    public Animator.AnimatorListener k;
    public boolean l;
    public HeadCustomImageView m;
    public TextView n;
    public boolean o;
    public boolean p;
    public n15 q;
    public int r;
    public String s;
    public int t;
    public int u;
    public int v;
    public String w;
    public String x;
    public boolean y;
    public ThreadData z;

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

    public static boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    public static int S(int i2) {
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
                this.a.Q = true;
                if (this.a.q != null) {
                    this.a.q.d = 3;
                }
                this.a.O();
                if (this.a.R != null && TbadkCoreApplication.isLogin()) {
                    this.a.R.onLongPress();
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
                if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !this.a.Q) {
                    return false;
                }
                if (this.a.R != null && TbadkCoreApplication.isLogin()) {
                    this.a.R.onRelease();
                }
                this.a.Q = false;
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
            h85.a(1, 1);
            if (this.a.z != null && this.a.z.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                h85.a(2, 1);
                return;
            }
            this.a.Q(view2);
            View.OnClickListener onClickListener = this.a.C;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            if (this.a.D == 1 || this.a.D == 2) {
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
            this.a.X();
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
                ea5 ea5Var = new ea5();
                ea5Var.b = R.raw.lottie_bubble_breath_tip;
                ea5Var.a = BreatheTipWidget.PointType.LOTTIE;
                ea5Var.c = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                fa5 fa5Var = new fa5();
                fa5Var.a = this.b.getContext().getString(R.string.long_click_agree_tip_title);
                fa5Var.b = this.b.getContext().getString(R.string.agree_tip_content);
                fa5Var.e = R.drawable.pic_guidecard;
                fa5Var.f = vi.g(this.b.getContext(), R.dimen.tbds156);
                fa5Var.g = vi.g(this.b.getContext(), R.dimen.tbds489);
                fa5Var.h = vi.g(this.b.getContext(), R.dimen.tbds286);
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.b.getContext());
                breatheTipWidget.j(this.b.getImgAgree());
                breatheTipWidget.h(fa5Var, ea5Var);
                if (breatheTipWidget.k((Activity) this.b.getContext(), 4000L)) {
                    n95 m = n95.m();
                    m.w("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + this.a, true);
                    sf5.d("c14827", this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements sh5 {
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

        @Override // com.baidu.tieba.sh5
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (!StringUtils.isNull(str)) {
                    this.a.c.setImageAssetsFolder(str);
                }
                this.a.c.setAlpha(1.0f);
                if (this.a.P == i) {
                    return;
                }
                this.a.P = i;
                this.a.c.cancelAnimation();
                this.a.c.setAnimation(i);
            }
        }

        @Override // com.baidu.tieba.sh5
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.c.setAlpha(1.0f);
                if (this.a.O.equals(str)) {
                    return;
                }
                this.a.O = str;
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
            agreeView.R();
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
            zx9 zx9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (agreeView = this.a.get()) == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof zx9) || (zx9Var = (zx9) customResponsedMessage.getData()) == null || (agreeData = zx9Var.b) == null || agreeView.h == null || TextUtils.isEmpty(agreeView.h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !agreeView.h.postId.equals(agreeData.postId) || agreeView.h.isInThread) {
                return;
            }
            if (agreeView.o) {
                if (agreeView.h.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (agreeView.i.a == zx9Var.a) {
                return;
            }
            agreeView.a0(agreeData);
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
            zx9 zx9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (agreeView = this.a.get()) != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zx9) && (zx9Var = (zx9) customResponsedMessage.getData()) != null && (agreeData = zx9Var.b) != null && agreeView.h != null && agreeData != null && agreeView.i != null && !agreeView.h.isInPost && agreeView.i.a != zx9Var.a) {
                String str = agreeData.nid;
                if (agreeView.h.baijiahaoData != null && !"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.equals(str, agreeView.h.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    agreeView.a0(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = agreeView.h.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                agreeView.a0(agreeData);
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
        this.t = R.raw.lottie_agree;
        this.u = R.raw.lottie_disagree;
        this.v = R.color.CAM_X0107;
        this.y = false;
        this.A = 1;
        this.G = false;
        this.H = false;
        this.L = true;
        this.O = "";
        this.Q = false;
        this.S = true;
        this.f1077T = new l(this);
        this.U = new k(this);
        this.V = new h(this);
        this.a0 = new d(this);
        F(context);
    }

    public final void T(StatisticItem statisticItem) {
        n15 n15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, statisticItem) == null) && statisticItem != null && (n15Var = this.q) != null) {
            int i2 = n15Var.b;
            if (i2 == 4 || i2 == 26 || i2 == 2 || i2 == 10 || i2 == 25) {
                int i3 = this.q.d;
                if (i3 == 1) {
                    String i4 = th5.g().i();
                    if (!StringUtils.isNull(i4)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i4);
                    }
                } else if (i3 == 2) {
                    String f2 = th5.g().f();
                    if (!StringUtils.isNull(f2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
                    }
                } else if (i3 == 3) {
                    String h2 = th5.g().h();
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
        this.t = R.raw.lottie_agree;
        this.u = R.raw.lottie_disagree;
        this.v = R.color.CAM_X0107;
        this.y = false;
        this.A = 1;
        this.G = false;
        this.H = false;
        this.L = true;
        this.O = "";
        this.Q = false;
        this.S = true;
        this.f1077T = new l(this);
        this.U = new k(this);
        this.V = new h(this);
        this.a0 = new d(this);
        F(context);
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
        this.t = R.raw.lottie_agree;
        this.u = R.raw.lottie_disagree;
        this.v = R.color.CAM_X0107;
        this.y = false;
        this.A = 1;
        this.G = false;
        this.H = false;
        this.L = true;
        this.O = "";
        this.Q = false;
        this.S = true;
        this.f1077T = new l(this);
        this.U = new k(this);
        this.V = new h(this);
        this.a0 = new d(this);
        F(context);
    }

    public final String D(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, agreeData)) == null) {
            return C(agreeData);
        }
        return (String) invokeL.objValue;
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.K = z;
            if (this.S && z) {
                y95.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void U(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    public final void a0(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, agreeData) == null) && agreeData != null && (agreeData2 = this.h) != null) {
            agreeData2.agreeType = agreeData.agreeType;
            agreeData2.hasAgree = agreeData.hasAgree;
            agreeData2.agreeNum = agreeData.agreeNum;
            b0();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, animator) == null) && (animatorListener = this.k) != null) {
            animatorListener.onAnimationCancel(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, animator) == null) {
            if (!this.M) {
                W();
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
        if ((interceptable == null || interceptable.invokeL(1048619, this, animator) == null) && (animatorListener = this.k) != null) {
            animatorListener.onAnimationRepeat(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, animator) == null) && (animatorListener = this.k) != null) {
            animatorListener.onAnimationStart(animator);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void setAgreeAnimationListenOnce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.l = z;
        }
    }

    public void setAgreeAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, animatorListener) == null) {
            this.k = animatorListener;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAgreeLongClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, iVar) == null) {
            this.R = iVar;
            this.c.setOnLongClickListener(new b(this));
            this.c.setOnTouchListener(new c(this));
        }
    }

    public void setAgreeSource(int i2) {
        n15 n15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i2) == null) && (n15Var = this.q) != null) {
            n15Var.d = i2;
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, agreeData) != null) || agreeData == null) {
            return;
        }
        this.h = agreeData;
        b0();
        P(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.D = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setIsAgreeNumClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.H = z;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.o = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.p = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.L = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.v = i2;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setOnAgreeNumUpdateListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, jVar) == null) {
            this.W = jVar;
        }
    }

    public void setStatisticData(n15 n15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, n15Var) == null) {
            this.q = n15Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.s = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, threadData) == null) {
            this.z = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.w = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.x = str;
        }
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.M = true;
            this.N = str;
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.S = z;
        }
    }

    public void setVisibilityListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, gVar) == null) {
            this.I = gVar;
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i2, i3) == null) {
            this.t = i2;
            this.u = i3;
            setAgreeAnimationResource();
        }
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, textView) == null) {
            if (this.p) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.o) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.v));
            }
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                H(vi.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.G);
                return;
            }
            H(vi.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.G);
        }
    }

    public void E(boolean z) {
        int i2;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.e;
            int i3 = 8;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setVisibility(i2);
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                if (!z) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            if (this.G != z && (gVar = this.I) != null) {
                gVar.a(this.e, z);
            }
            this.G = z;
        }
    }

    public void setAgreeAlone(boolean z) {
        int i2;
        g gVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
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
            if (z && (linearLayout = this.E) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.G != z && (gVar = this.I) != null) {
                gVar.a(this.e, z);
            }
            this.G = z;
        }
    }

    public void setDisagreeShow(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
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
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                if (!z) {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
            }
            this.G = z;
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
    public void B() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AgreeData agreeData2;
        String str6;
        mr5 findPageExtraByView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.q != null && (agreeData = this.h) != null) {
            int i2 = 0;
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData != null) {
                i2 = baijiahaoData.oriUgcType;
            }
            int i3 = this.q.a;
            if (i3 == 1) {
                if (StringUtils.isNull(this.w)) {
                    StatisticItem param = new StatisticItem("c12003").param("obj_locate", this.q.b).param("obj_param1", this.q.c).param("obj_source", this.q.d).param("obj_id", this.q.e).param("obj_name", i2).param("post_id", this.h.postId);
                    ThreadData threadData = this.z;
                    if (threadData != null) {
                        param.param("tid", threadData.getId()).param("nid", this.z.getNid()).param("fid", this.z.getFid()).param("card_type", this.A).param("ab_tag", this.z.mRecomAbTag).param("recom_source", this.z.mRecomSource).param("weight", this.z.mRecomWeight).param("thread_type", this.z.threadType).param("extra", this.z.mRecomExtra);
                        if (this.z.getBaijiahaoData() != null) {
                            param.param(TiebaStatic.Params.OBJ_PARAM4, this.z.getBaijiahaoData().oriUgcNid);
                            if (this.z.isBJHVideoThreadType() || this.z.isBJHVideoDynamicThreadType()) {
                                param.param(TiebaStatic.Params.OBJ_PARAM6, this.z.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.z.isBjhDynamicThread()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        } else if (!this.z.isBJHArticleThreadType() && !this.z.isBJHVideoThreadType()) {
                            int i4 = this.z.threadType;
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
                    if (L(this.q.b) && S(this.q.f) != -1) {
                        param.param(TiebaStatic.Params.OBJ_TO, S(this.q.f));
                    }
                    int i5 = this.D;
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
                            param.param("resource_id", this.s);
                        } else {
                            param.param("resource_id", this.r);
                        }
                        str5 = "a002";
                        if (getTbPageContext() != null) {
                            rr5.b(getTbPageContext().getPageActivity(), param);
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
                        T(param);
                        TiebaStatic.log(param);
                    }
                    param.param(str4, str5);
                    param.param(str3, this.r);
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
                    T(param);
                    TiebaStatic.log(param);
                } else if (this.q.b == 4 && this.y) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.h.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.x).param("topic_id", this.w));
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.h.threadId).param("topic_id", this.w));
                }
                Y();
            } else if (i3 == 2) {
                StatisticItem param2 = new StatisticItem("c13271").param("obj_type", this.q.g).param("obj_locate", this.q.h).param(TiebaStatic.Params.OBJ_PARAM2, this.r).param("obj_id", this.q.i).param("obj_name", i2).param("post_id", this.h.postId).param("nid", this.h.nid);
                ThreadData threadData2 = this.z;
                if (threadData2 != null) {
                    param2.param("tid", threadData2.getId()).param("nid", this.z.getNid()).param("fid", this.z.getFid()).param("card_type", this.A).param("ab_tag", this.z.mRecomAbTag).param("recom_source", this.z.mRecomSource).param("weight", this.z.mRecomWeight).param("extra", this.z.mRecomExtra);
                    if (this.z.getBaijiahaoData() != null) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM4, this.z.getBaijiahaoData().oriUgcNid);
                        if (this.z.isBJHVideoThreadType() || this.z.isBJHVideoDynamicThreadType()) {
                            param2.param(TiebaStatic.Params.OBJ_PARAM6, this.z.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.z.isBjhDynamicThread()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.z.isBJHArticleThreadType() && !this.z.isBJHVideoThreadType()) {
                        int i6 = this.z.threadType;
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
                int i7 = this.D;
                if (i7 != 1) {
                    if (i7 == 2) {
                        str2 = "a002";
                        str = TiebaStatic.Params.OBJ_TAB;
                    } else {
                        if (i7 == 18) {
                            str = TiebaStatic.Params.OBJ_TAB;
                            param2.param(str, "a099");
                            param2.param("resource_id", this.s);
                        } else {
                            str = TiebaStatic.Params.OBJ_TAB;
                        }
                        str2 = "a002";
                        if (getTbPageContext() != null) {
                            rr5.b(getTbPageContext().getPageActivity(), param2);
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

    public final String C(AgreeData agreeData) {
        InterceptResult invokeL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, agreeData)) == null) {
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
                n15 n15Var = this.q;
                if (n15Var != null && n15Var.c == 7) {
                    return StringHelper.numberUniformFormatExtraWithCollect(j2);
                }
                return StringHelper.numFormatOverWanNa(j2);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j2);
        }
        return (String) invokeL.objValue;
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && this.h != null && this.a != i2) {
            this.a = i2;
            SkinManager.setLottieAnimation(this.e, this.u);
            if (this.M) {
                d0();
            } else {
                SkinManager.setLottieAnimation(this.c, this.t);
                if (this.K) {
                    y95.f(this.c, i2);
                }
            }
            HeadCustomImageView headCustomImageView = this.m;
            if (headCustomImageView != null) {
                headCustomImageView.e(i2);
            }
            TextView textView = this.n;
            if (textView != null) {
                o75 d2 = o75.d(textView);
                d2.B(R.dimen.T_X09);
                d2.w(R.color.CAM_X0107);
            }
            b0();
        }
    }

    public final void F(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.img_agree);
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addAnimatorListener(this);
            this.c.setOnClickListener(this.a0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.g = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.img_firework_agree);
            this.g.setVisibility(8);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, vi.g(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.a0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView3 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView3;
            tBLazyLottieAnimationView3.setId(R.id.img_disagree);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.a0);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.c_disagree);
            this.f.setTextSize(0, vi.g(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.a0);
            HeadCustomImageView headCustomImageView = new HeadCustomImageView(getContext());
            this.m = headCustomImageView;
            headCustomImageView.setId(R.id.bottom_head_custom_image_view);
            zx9 zx9Var = new zx9();
            this.i = zx9Var;
            zx9Var.a = getPageId();
            this.J = new j95();
            G();
            SkinManager.setLottieAnimation(this.e, this.u);
            FirstPraiseToast.getInstance();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.bottom_agree_container);
            this.F = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.a0);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.bottom_disagree_container);
            this.E = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.a0);
            linearLayout2.addView(this.e);
            linearLayout2.addView(this.f);
            A(false);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            this.c.setVisibility(8);
            this.g.setVisibility(0);
            this.g.setAnimation(R.raw.lottie_feed_firework_agree);
            this.g.setRepeatCount(2);
            if (this.g.getParent() == null) {
                this.F.addView(this.g, 0, layoutParams);
            }
            this.g.playAnimation();
            this.g.addAnimatorListener(new a(this));
        }
    }

    public final void d0() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ThreadData threadData = this.z;
            if (threadData != null) {
                if (threadData instanceof AdvertAppInfo) {
                    m15 m15Var = ((AdvertAppInfo) threadData).i;
                    if (m15Var != null) {
                        str3 = m15Var.c;
                    } else {
                        str3 = null;
                    }
                    str2 = str3;
                    str = null;
                } else {
                    String valueOf = String.valueOf(threadData.getFid());
                    str = this.z.getTid();
                    str2 = valueOf;
                }
            } else {
                str = null;
                str2 = null;
            }
            th5.g().e(this.N, str, str2, this.L, new f(this));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            removeAllViews();
            U(this.c);
            U(this.e);
            U(this.d);
            U(this.f);
            G();
            H(vi.g(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public final void H(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            int i6 = -vi.g(getContext(), R.dimen.tbds24);
            int g2 = vi.g(getContext(), R.dimen.tbds34);
            this.F.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.F.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.d.setLayoutParams(layoutParams2);
            this.E.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.E.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f.setLayoutParams(layoutParams5);
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.Q;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n15 n15Var = this.q;
            if (n15Var != null && n15Var.d == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !PraiseSwitch.isOn()) {
            return;
        }
        Q(this.c);
        n15 n15Var = this.q;
        if (n15Var != null) {
            n15Var.d = 1;
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.Q) {
            if (this.R != null && TbadkCoreApplication.isLogin()) {
                this.R.onRelease();
            }
            this.Q = false;
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.h;
        }
        return (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public boolean getIsAgreeNumClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public zx9 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.i;
        }
        return (zx9) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.f1077T);
            MessageManager.getInstance().registerListener(this.U);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.V);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.f1077T);
            MessageManager.getInstance().unRegisterListener(this.U);
            TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.V);
        }
    }

    public void setTextViewMinEmsWhenCard() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048644, this) == null) && (textView = this.d) != null) {
            textView.setMinEms(2);
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.M = true;
            this.N = "/feed";
        }
    }

    public void setUseDynamicLikeResImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.M = true;
            this.N = "/feed";
            d0();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.h != null && this.c != null) {
            if (this.o && !gp5.a(getContext())) {
                return;
            }
            if (!this.o && !ViewHelper.checkUpIsLogin(getContext())) {
                return;
            }
            this.c.cancelAnimation();
            n15 n15Var = this.q;
            if (n15Var != null) {
                n15Var.a = 1;
            }
            this.y = true;
            this.h.agreeType = 2;
            if (!DisableZanSwitch.getIsOn()) {
                AgreeData agreeData = this.h;
                if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                    this.h.agreeNum++;
                }
                this.h.hasAgree = true;
                b0();
            }
            n15 n15Var2 = this.q;
            if (n15Var2 != null) {
                n15Var2.e = 1;
            }
            mr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                this.h.objSource = findPageExtraByView.a();
            }
            AgreeData agreeData2 = this.h;
            agreeData2.agreeClickType = 1;
            this.J.c(agreeData2, 0, getPageId(), this.o);
            AgreeData agreeData3 = this.h;
            agreeData3.agreeClickType = 0;
            this.J.d(agreeData3, this.i);
            View.OnClickListener onClickListener = this.B;
            if (onClickListener != null) {
                onClickListener.onClick(this.c);
            }
            B();
            n15 n15Var3 = this.q;
            if (n15Var3 != null) {
                n15Var3.d = 1;
            }
        }
    }

    public final void X() {
        AgreeData agreeData;
        n15 n15Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (agreeData = this.h) != null && agreeData.agreeType == 2 && agreeData.hasAgree && (n15Var = this.q) != null && n15Var.d == 1) {
            String str = null;
            int i3 = n15Var.b;
            if (i3 != 4 && i3 != 26) {
                if ((i3 == 1 && n15Var.c != 7) || (i2 = this.q.b) == 7 || i2 == 9 || i2 == 10 || i2 == 22 || i2 == 2) {
                    str = "card";
                }
            } else {
                str = this.q.b + "";
            }
            if (ui.isEmpty(str)) {
                return;
            }
            if (!n95.m().i("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + str, false)) {
                wg.a().postDelayed(new e(this, str), 1000L);
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            String D = D(this.h);
            if (this.h == null) {
                return;
            }
            this.d.setText(D);
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
                if (this.K) {
                    y95.c(this.d);
                }
            }
            if (this.K) {
                y95.d(this.d);
            }
            j jVar = this.W;
            if (jVar != null) {
                AgreeData agreeData2 = this.h;
                jVar.a(agreeData2.agreeNum, agreeData2.hasAgree);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(View view2) {
        int i2;
        mr5 findPageExtraByView;
        n15 n15Var;
        int i3;
        n15 n15Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            int i4 = -1;
            if (this.h != null && view2 != null) {
                if (this.o && !gp5.a(getContext())) {
                    n15 n15Var3 = this.q;
                    if (n15Var3 != null) {
                        i4 = n15Var3.d;
                    }
                    h85.a(4, i4);
                    return;
                } else if (!this.o && !ViewHelper.checkUpIsLogin(getContext())) {
                    n15 n15Var4 = this.q;
                    if (n15Var4 != null) {
                        i4 = n15Var4.d;
                    }
                    h85.a(4, i4);
                    return;
                } else if (!UbsABTestHelper.isAgreeNumberCanClick() && view2 == this.d && !this.H) {
                    n15 n15Var5 = this.q;
                    if (n15Var5 != null) {
                        i4 = n15Var5.d;
                    }
                    h85.a(5, i4);
                    return;
                } else {
                    int i5 = 0;
                    if (view2.getId() == this.m.getId()) {
                        this.y = false;
                        this.m.b();
                    } else {
                        int i6 = 1;
                        if (view2.getId() != this.F.getId() && view2.getId() != this.c.getId() && ((!UbsABTestHelper.isAgreeNumberCanClick() && !this.H) || view2.getId() != this.d.getId())) {
                            if (view2.getId() == this.E.getId() || view2.getId() == this.e.getId()) {
                                this.e.cancelAnimation();
                                n15 n15Var6 = this.q;
                                if (n15Var6 != null) {
                                    n15Var6.a = 2;
                                }
                                AgreeData agreeData = this.h;
                                if (agreeData.hasAgree) {
                                    if (agreeData.agreeType == 5) {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = false;
                                        b0();
                                        n15 n15Var7 = this.q;
                                        if (n15Var7 != null) {
                                            n15Var7.i = 0;
                                        }
                                        this.y = false;
                                        findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                        if (findPageExtraByView != null) {
                                            this.h.objSource = findPageExtraByView.a();
                                        }
                                        n15Var = this.q;
                                        if (n15Var == null) {
                                            i3 = n15Var.d;
                                        } else {
                                            i3 = -1;
                                        }
                                        h85.a(6, i3);
                                        this.J.c(this.h, i6, getPageId(), this.o);
                                        n15Var2 = this.q;
                                        if (n15Var2 != null) {
                                            i4 = n15Var2.d;
                                        }
                                        h85.a(7, i4);
                                    } else {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = true;
                                        agreeData.agreeNum--;
                                        c0(false);
                                        n15 n15Var8 = this.q;
                                        if (n15Var8 != null) {
                                            n15Var8.i = 1;
                                        }
                                    }
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    c0(false);
                                    n15 n15Var9 = this.q;
                                    if (n15Var9 != null) {
                                        n15Var9.i = 1;
                                    }
                                }
                                i6 = 0;
                                this.y = false;
                                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                if (findPageExtraByView != null) {
                                }
                                n15Var = this.q;
                                if (n15Var == null) {
                                }
                                h85.a(6, i3);
                                this.J.c(this.h, i6, getPageId(), this.o);
                                n15Var2 = this.q;
                                if (n15Var2 != null) {
                                }
                                h85.a(7, i4);
                            }
                        } else {
                            this.c.cancelAnimation();
                            n15 n15Var10 = this.q;
                            if (n15Var10 != null) {
                                n15Var10.a = 1;
                            }
                            AgreeData agreeData2 = this.h;
                            if (agreeData2.hasAgree) {
                                if (agreeData2.agreeType == 2) {
                                    this.y = false;
                                    agreeData2.agreeType = 2;
                                    if (!DisableZanSwitch.getIsOn()) {
                                        AgreeData agreeData3 = this.h;
                                        agreeData3.hasAgree = false;
                                        agreeData3.agreeNum--;
                                        b0();
                                    }
                                    n15 n15Var11 = this.q;
                                    if (n15Var11 != null) {
                                        n15Var11.e = 1;
                                    }
                                    i5 = 1;
                                } else {
                                    this.y = true;
                                    agreeData2.agreeType = 2;
                                    if (!DisableZanSwitch.getIsOn()) {
                                        AgreeData agreeData4 = this.h;
                                        agreeData4.hasAgree = true;
                                        agreeData4.agreeNum++;
                                        c0(true);
                                        ll9.g().l(getTbPageContext());
                                    }
                                    n15 n15Var12 = this.q;
                                    if (n15Var12 != null) {
                                        n15Var12.e = 0;
                                    }
                                }
                            } else {
                                this.y = true;
                                agreeData2.agreeType = 2;
                                if (!DisableZanSwitch.getIsOn()) {
                                    AgreeData agreeData5 = this.h;
                                    agreeData5.hasAgree = true;
                                    agreeData5.agreeNum++;
                                    c0(true);
                                    ll9.g().l(getTbPageContext());
                                }
                                n15 n15Var13 = this.q;
                                if (n15Var13 != null) {
                                    n15Var13.e = 0;
                                }
                            }
                            mr5 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView2 != null) {
                                this.h.objSource = findPageExtraByView2.a();
                            }
                            n15 n15Var14 = this.q;
                            if (n15Var14 != null) {
                                i2 = n15Var14.d;
                            } else {
                                i2 = -1;
                            }
                            h85.a(6, i2);
                            this.J.c(this.h, i5, getPageId(), this.o);
                            n15 n15Var15 = this.q;
                            if (n15Var15 != null) {
                                i4 = n15Var15.d;
                            }
                            h85.a(7, i4);
                        }
                    }
                    this.J.d(this.h, this.i);
                    View.OnClickListener onClickListener = this.B;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    B();
                    return;
                }
            }
            n15 n15Var16 = this.q;
            if (n15Var16 != null) {
                i4 = n15Var16.d;
            }
            h85.a(3, i4);
        }
    }

    public void W() {
        AgreeData agreeData;
        n15 n15Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (agreeData = this.h) == null || agreeData.agreeType != 2 || (n15Var = this.q) == null) {
            return;
        }
        int i2 = n15Var.b;
        if (i2 == 2 || i2 == 4 || i2 == 26 || i2 == 5 || i2 == 12) {
            FirstPraiseToast.getInstance().show();
        }
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (!this.S) {
                SkinManager.setLottieAnimation(this.e, this.u);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.t);
            SkinManager.setLottieAnimation(this.e, this.u);
            if (this.K) {
                y95.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.M = true;
            this.N = "/pb";
            d0();
            AgreeData agreeData = this.h;
            if (agreeData != null && agreeData.hasAgree && agreeData.agreeType == 2) {
                this.c.setProgress(1.0f);
            } else {
                this.c.setProgress(0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y() {
        ThreadData threadData;
        n15 n15Var;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (threadData = this.z) != null && (n15Var = this.q) != null && threadData.isTiebaPlusAdThread) {
            int i8 = n15Var.b;
            if (i8 != 1 && i8 != 2 && i8 != 10 && i8 != 25 && i8 != 4) {
                return;
            }
            n15 n15Var2 = this.q;
            if (n15Var2.b == 4 && (i7 = n15Var2.f) != 2 && i7 != 3) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
            int i9 = this.q.b;
            if (i9 == 1) {
                statisticItem.addParam("obj_locate", 1);
            } else if (i9 != 2 && i9 != 25 && i9 != 10) {
                if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
            } else {
                int i10 = this.z.tiePlusFrsStaticLocate;
                if (i10 != 2) {
                    statisticItem.addParam("obj_locate", i10 + 1);
                } else {
                    statisticItem.addParam("obj_locate", 2);
                }
            }
            if (this.z.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.z.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.z.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.z.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.q.j);
            int i11 = this.q.e;
            if (i11 == 0) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
            } else if (i11 == 1) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
            }
            statisticItem.addParam("order_id", this.z.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            int i12 = this.q.e;
            if (i12 == 0) {
                i3 = iw4.g;
            } else if (i12 == 1) {
                i3 = iw4.j;
            } else {
                i2 = 0;
                i4 = this.q.b;
                if (i4 != 1) {
                    i6 = iw4.a;
                } else if (i4 == 2) {
                    i6 = iw4.b;
                } else if (L(i4)) {
                    i6 = iw4.c;
                } else {
                    i5 = 0;
                    ThreadData threadData2 = this.z;
                    iw4.a(i2, i5, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                }
                i5 = i6;
                ThreadData threadData22 = this.z;
                iw4.a(i2, i5, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
            }
            i2 = i3;
            i4 = this.q.b;
            if (i4 != 1) {
            }
            i5 = i6;
            ThreadData threadData222 = this.z;
            iw4.a(i2, i5, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
        }
    }

    public void Z(VirtualImageCustomFigure virtualImageCustomFigure, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, virtualImageCustomFigure, metaData) == null) && virtualImageCustomFigure != null) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.m.setShowHomeIcon(false);
            this.m.setHeadImageViewResource(virtualImageCustomFigure.getFigureUrl());
            this.m.setHeadImageBackgroundColorResource(virtualImageCustomFigure.getBackgroundValue());
            this.m.setVisibility(0);
            this.m.setUserInfo(metaData);
            this.m.setFrom(4);
            this.m.setOnClickListener(this.a0);
            this.m.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds68), UtilHelper.getDimenPixelSize(R.dimen.tbds85));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds68);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds85);
            int g2 = vi.g(getContext(), R.dimen.tbds8);
            int g3 = vi.g(getContext(), R.dimen.tbds13);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = dimenPixelSize;
            layoutParams.height = dimenPixelSize2;
            layoutParams.topMargin = g2;
            if (this.m.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.m.getParent()).removeAllViews();
            }
            this.E.setOnClickListener(null);
            this.E.addView(this.m, layoutParams);
            if (this.n == null) {
                this.n = new EMTextView(getContext());
            }
            this.n.setText(getContext().getString(R.string.pb_first_custom_head_title));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = g3;
            this.E.addView(this.n, layoutParams2);
            ThreadData threadData = this.z;
            if (threadData != null) {
                iy.a(2, threadData.getTid(), iy.d, iy.f, null, this.z.getAuthorId());
            }
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048602, this, z) != null) || this.h == null) {
            return;
        }
        this.c.setMinAndMaxProgress(0.0f, 1.0f);
        this.e.setMinAndMaxProgress(0.0f, 1.0f);
        this.d.setText(D(this.h));
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
                if (this.K) {
                    y95.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.K) {
                y95.c(this.d);
            }
        }
        if (this.K) {
            y95.d(this.d);
        }
        j jVar = this.W;
        if (jVar != null) {
            AgreeData agreeData2 = this.h;
            jVar.a(agreeData2.agreeNum, agreeData2.hasAgree);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            int g2 = vi.g(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, vi.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -vi.g(getContext(), R.dimen.tbds24);
                int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.d.setPadding(0, g3, g3 * 3, g3);
                this.H = true;
            } else {
                layoutParams2.leftMargin = -vi.g(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = vi.g(getContext(), R.dimen.tbds28);
            }
            this.e.setLayoutParams(layoutParams3);
            this.f.setVisibility(8);
        }
    }

    public void u(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048654, this, i2, i3, i4, i5) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i3);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams2.width = i4;
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

    public void v() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && this.F != null && (tBLottieAnimationView = this.c) != null && this.d != null) {
            U(tBLottieAnimationView);
            U(this.d);
            int g2 = vi.g(getContext(), R.dimen.tbds74);
            this.F.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 0;
            this.F.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(g2, g2));
            this.F.addView(this.d);
            this.F.addView(this.c);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            int g2 = vi.g(getContext(), R.dimen.tbds112);
            int g3 = vi.g(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -g3;
            layoutParams.topMargin = vi.g(getContext(), R.dimen.tbds_2);
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, vi.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = vi.g(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = vi.g(getContext(), R.dimen.tbds_2);
            this.d.setLayoutParams(layoutParams2);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void x() {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            int g2 = vi.g(getContext(), R.dimen.tbds120);
            removeAllViews();
            U(this.c);
            U(this.e);
            U(this.d);
            U(this.f);
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
            int g3 = vi.g(context, i3);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.bottom_agree_container);
            linearLayout.setOrientation(i6);
            linearLayout.setGravity(1);
            int i7 = 0;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = vi.g(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            layoutParams.gravity = i2;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.a0);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(g2, g2));
            float f2 = g3;
            this.d.setTextSize(0, f2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = i2;
            int i8 = -vi.g(getContext(), R.dimen.tbds23);
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
            layoutParams3.topMargin = vi.g(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            layoutParams3.gravity = i2;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.a0);
            this.E = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(g2, g2));
            this.f.setTextSize(0, f2);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = i2;
            int i9 = -vi.g(getContext(), R.dimen.tbds25);
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
