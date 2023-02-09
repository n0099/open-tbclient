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
import com.baidu.tieba.a29;
import com.baidu.tieba.a45;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.ft4;
import com.baidu.tieba.g45;
import com.baidu.tieba.gh;
import com.baidu.tieba.h45;
import com.baidu.tieba.i25;
import com.baidu.tieba.jb5;
import com.baidu.tieba.jh5;
import com.baidu.tieba.kb5;
import com.baidu.tieba.l35;
import com.baidu.tieba.l95;
import com.baidu.tieba.p35;
import com.baidu.tieba.pj5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tr8;
import com.baidu.tieba.uj5;
import com.baidu.tieba.ux;
import com.baidu.tieba.xw4;
import com.baidu.tieba.yw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public View.OnClickListener B;
    public int C;
    public LinearLayout D;
    public LinearLayout E;
    public boolean F;
    public boolean G;
    public h H;
    public l35 I;
    public boolean J;
    public boolean K;
    public boolean L;
    public String M;
    public String N;
    public int O;
    public boolean P;
    public i Q;
    public boolean R;
    public CustomMessageListener S;
    public CustomMessageListener T;
    public View.OnClickListener U;
    public Application.ActivityLifecycleCallbacks V;
    public int a;
    public TbPageContext b;
    public TBLottieAnimationView c;
    public TextView d;
    public TBLottieAnimationView e;
    public TextView f;
    public TBLottieAnimationView g;
    public AgreeData h;
    public a29 i;
    public ScaleAnimation j;
    public Animator.AnimatorListener k;
    public boolean l;
    public HeadCustomImageView m;
    public boolean n;
    public boolean o;
    public yw4 p;
    public int q;
    public String r;
    public int s;
    public int t;
    public int u;
    public String v;
    public String w;
    public boolean x;
    public ThreadData y;
    public int z;

    /* loaded from: classes3.dex */
    public interface h {
        void a(View view2, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void onLongPress();

        void onRelease();
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                this.a.P = true;
                if (this.a.p != null) {
                    this.a.p.d = 3;
                }
                this.a.O();
                if (this.a.Q != null && TbadkCoreApplication.isLogin()) {
                    this.a.Q.onLongPress();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !this.a.P) {
                    return false;
                }
                if (this.a.Q != null && TbadkCoreApplication.isLogin()) {
                    this.a.Q.onRelease();
                }
                this.a.P = false;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            i25.a(1, 1);
            if (this.a.y != null && this.a.y.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                i25.a(2, 1);
                return;
            }
            this.a.Q(view2);
            View.OnClickListener onClickListener = this.a.B;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            if (this.a.C == 1 || this.a.C == 2) {
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
            this.a.X();
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !BreatheTipWidget.e()) {
                g45 g45Var = new g45();
                g45Var.b = R.raw.lottie_bubble_breath_tip;
                g45Var.a = BreatheTipWidget.PointType.LOTTIE;
                g45Var.c = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                h45 h45Var = new h45();
                h45Var.a = this.b.getContext().getString(R.string.long_click_agree_tip_title);
                h45Var.b = this.b.getContext().getString(R.string.agree_tip_content);
                h45Var.e = R.drawable.pic_guidecard;
                h45Var.f = ej.g(this.b.getContext(), R.dimen.tbds156);
                h45Var.g = ej.g(this.b.getContext(), R.dimen.tbds489);
                h45Var.h = ej.g(this.b.getContext(), R.dimen.tbds286);
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.b.getContext());
                breatheTipWidget.g(this.b.getImgAgree());
                breatheTipWidget.f(h45Var, g45Var);
                if (breatheTipWidget.h((Activity) this.b.getContext())) {
                    p35 m = p35.m();
                    m.w("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + this.a, true);
                    l95.b("c14827", this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements jb5 {
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

        @Override // com.baidu.tieba.jb5
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (!StringUtils.isNull(str)) {
                    this.a.c.setImageAssetsFolder(str);
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.a.c.setAlpha(0.8f);
                } else {
                    this.a.c.setAlpha(1.0f);
                }
                if (this.a.O == i) {
                    return;
                }
                this.a.O = i;
                this.a.c.cancelAnimation();
                this.a.c.setAnimation(i);
            }
        }

        @Override // com.baidu.tieba.jb5
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.a.c.setAlpha(0.8f);
                } else {
                    this.a.c.setAlpha(1.0f);
                }
                if (this.a.N.equals(str)) {
                    return;
                }
                this.a.N = str;
                this.a.c.cancelAnimation();
                this.a.c.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

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

        public g(AgreeView agreeView) {
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) != null) || activity != this.a.getContext()) {
                return;
            }
            this.a.R();
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AgreeView agreeView) {
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
            a29 a29Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (agreeView = this.a.get()) == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof a29) || (a29Var = (a29) customResponsedMessage.getData()) == null || (agreeData = a29Var.b) == null || agreeView.h == null || TextUtils.isEmpty(agreeView.h.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !agreeView.h.postId.equals(agreeData.postId) || agreeView.h.isInThread) {
                return;
            }
            if (agreeView.n) {
                if (agreeView.h.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (agreeView.i.a == a29Var.a) {
                return;
            }
            agreeView.a0(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AgreeView agreeView) {
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
            a29 a29Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (agreeView = this.a.get()) != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a29) && (a29Var = (a29) customResponsedMessage.getData()) != null && (agreeData = a29Var.b) != null && agreeView.h != null && agreeData != null && agreeView.i != null && !agreeView.h.isInPost && agreeView.i.a != a29Var.a) {
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
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = false;
        this.z = 1;
        this.F = false;
        this.G = false;
        this.K = true;
        this.N = "";
        this.P = false;
        this.R = true;
        this.S = new k(this);
        this.T = new j(this);
        this.U = new d(this);
        this.V = new g(this);
        F(context);
    }

    public final void T(StatisticItem statisticItem) {
        yw4 yw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, statisticItem) == null) && statisticItem != null && (yw4Var = this.p) != null) {
            int i2 = yw4Var.b;
            if (i2 == 4 || i2 == 26 || i2 == 2 || i2 == 10 || i2 == 25) {
                int i3 = this.p.d;
                if (i3 == 1) {
                    String i4 = kb5.g().i();
                    if (!StringUtils.isNull(i4)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i4);
                    }
                } else if (i3 == 2) {
                    String f2 = kb5.g().f();
                    if (!StringUtils.isNull(f2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
                    }
                } else if (i3 == 3) {
                    String h2 = kb5.g().h();
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
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = false;
        this.z = 1;
        this.F = false;
        this.G = false;
        this.K = true;
        this.N = "";
        this.P = false;
        this.R = true;
        this.S = new k(this);
        this.T = new j(this);
        this.U = new d(this);
        this.V = new g(this);
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
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = false;
        this.z = 1;
        this.F = false;
        this.G = false;
        this.K = true;
        this.N = "";
        this.P = false;
        this.R = true;
        this.S = new k(this);
        this.T = new j(this);
        this.U = new d(this);
        this.V = new g(this);
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
            this.J = z;
            if (this.R && z) {
                a45.f(this.c, TbadkCoreApplication.getInst().getSkinType());
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
            if (!this.L) {
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
            this.A = onClickListener;
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
            this.Q = iVar;
            this.c.setOnLongClickListener(new b(this));
            this.c.setOnTouchListener(new c(this));
        }
    }

    public void setAgreeSource(int i2) {
        yw4 yw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048629, this, i2) == null) && (yw4Var = this.p) != null) {
            yw4Var.d = i2;
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, agreeData) != null) || agreeData == null) {
            return;
        }
        this.h = agreeData;
        b0();
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.C = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setIsAgreeNumClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.G = z;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.n = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.o = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.K = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.u = i2;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setStatisticData(yw4 yw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, yw4Var) == null) {
            this.p = yw4Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.r = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, threadData) == null) {
            this.y = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.v = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.w = str;
        }
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.L = true;
            this.M = str;
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.R = z;
        }
    }

    public void setVisibilityListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, hVar) == null) {
            this.H = hVar;
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i2, i3) == null) {
            this.s = i2;
            this.t = i3;
            setAgreeAnimationResource();
        }
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, textView) == null) {
            if (this.o) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.n) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.u));
            }
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                H(ej.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.F);
                return;
            }
            H(ej.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.F);
        }
    }

    public void E(boolean z) {
        int i2;
        h hVar;
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
            LinearLayout linearLayout = this.D;
            if (linearLayout != null) {
                if (!z) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            if (this.F != z && (hVar = this.H) != null) {
                hVar.a(this.e, z);
            }
            this.F = z;
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && this.h != null && this.a != i2) {
            this.a = i2;
            SkinManager.setLottieAnimation(this.e, this.t);
            if (this.L) {
                d0();
            } else {
                SkinManager.setLottieAnimation(this.c, this.s);
                if (this.J) {
                    a45.f(this.c, i2);
                }
            }
            b0();
        }
    }

    public void setAgreeAlone(boolean z) {
        int i2;
        h hVar;
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
            if (z && (linearLayout = this.D) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.F != z && (hVar = this.H) != null) {
                hVar.a(this.e, z);
            }
            this.F = z;
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
            LinearLayout linearLayout = this.D;
            if (linearLayout != null) {
                if (!z) {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
            }
            this.F = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0239  */
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
        pj5 findPageExtraByView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.p != null && (agreeData = this.h) != null) {
            int i2 = 0;
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData != null) {
                i2 = baijiahaoData.oriUgcType;
            }
            int i3 = this.p.a;
            if (i3 == 1) {
                if (StringUtils.isNull(this.v)) {
                    StatisticItem param = new StatisticItem("c12003").param("obj_locate", this.p.b).param("obj_param1", this.p.c).param("obj_source", this.p.d).param("obj_id", this.p.e).param("obj_name", i2).param("post_id", this.h.postId);
                    ThreadData threadData = this.y;
                    if (threadData != null) {
                        param.param("tid", threadData.getId()).param("nid", this.y.getNid()).param("fid", this.y.getFid()).param("card_type", this.z).param("ab_tag", this.y.mRecomAbTag).param("recom_source", this.y.mRecomSource).param("weight", this.y.mRecomWeight).param("thread_type", this.y.threadType).param("extra", this.y.mRecomExtra);
                        if (this.y.getBaijiahaoData() != null) {
                            param.param(TiebaStatic.Params.OBJ_PARAM4, this.y.getBaijiahaoData().oriUgcNid);
                            if (this.y.isBJHVideoThreadType() || this.y.isBJHVideoDynamicThreadType()) {
                                param.param(TiebaStatic.Params.OBJ_PARAM6, this.y.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.y.isBjhDynamicThread()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        } else if (!this.y.isBJHArticleThreadType() && !this.y.isBJHVideoThreadType()) {
                            int i4 = this.y.threadType;
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
                    if (L(this.p.b) && S(this.p.f) != -1) {
                        param.param(TiebaStatic.Params.OBJ_TO, S(this.p.f));
                    }
                    int i5 = this.C;
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
                            param.param("resource_id", this.r);
                        } else {
                            param.param("resource_id", this.q);
                        }
                        str5 = "a002";
                        if (getTbPageContext() != null) {
                            uj5.b(getTbPageContext().getPageActivity(), param);
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
                    param.param(str3, this.q);
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
                } else if (this.p.b == 4 && this.x) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.h.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.w).param("topic_id", this.v));
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.h.threadId).param("topic_id", this.v));
                }
                Y();
            } else if (i3 == 2) {
                StatisticItem param2 = new StatisticItem("c13271").param("obj_type", this.p.g).param("obj_locate", this.p.h).param(TiebaStatic.Params.OBJ_PARAM2, this.q).param("obj_id", this.p.i).param("obj_name", i2).param("post_id", this.h.postId).param("nid", this.h.nid);
                ThreadData threadData2 = this.y;
                if (threadData2 != null) {
                    param2.param("tid", threadData2.getId()).param("nid", this.y.getNid()).param("fid", this.y.getFid()).param("card_type", this.z).param("ab_tag", this.y.mRecomAbTag).param("recom_source", this.y.mRecomSource).param("weight", this.y.mRecomWeight).param("extra", this.y.mRecomExtra);
                    if (this.y.getBaijiahaoData() != null) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM4, this.y.getBaijiahaoData().oriUgcNid);
                        if (this.y.isBJHVideoThreadType() || this.y.isBJHVideoDynamicThreadType()) {
                            param2.param(TiebaStatic.Params.OBJ_PARAM6, this.y.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.y.isBjhDynamicThread()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.y.isBJHArticleThreadType() && !this.y.isBJHVideoThreadType()) {
                        int i6 = this.y.threadType;
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
                int i7 = this.C;
                if (i7 != 1) {
                    if (i7 == 2) {
                        str2 = "a002";
                        str = TiebaStatic.Params.OBJ_TAB;
                    } else {
                        if (i7 == 18) {
                            str = TiebaStatic.Params.OBJ_TAB;
                            param2.param(str, "a099");
                            param2.param("resource_id", this.r);
                        } else {
                            str = TiebaStatic.Params.OBJ_TAB;
                        }
                        str2 = "a002";
                        if (getTbPageContext() != null) {
                            uj5.b(getTbPageContext().getPageActivity(), param2);
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
                yw4 yw4Var = this.p;
                if (yw4Var != null && yw4Var.c == 7) {
                    return StringHelper.numberUniformFormatExtraWithCollect(j2);
                }
                return StringHelper.numFormatOverWanNa(j2);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j2);
        }
        return (String) invokeL.objValue;
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
            this.c.setOnClickListener(this.U);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.g = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.img_firework_agree);
            this.g.setVisibility(8);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, ej.g(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.U);
            TBLazyLottieAnimationView tBLazyLottieAnimationView3 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView3;
            tBLazyLottieAnimationView3.setId(R.id.img_disagree);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.U);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.c_disagree);
            this.f.setTextSize(0, ej.g(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.U);
            HeadCustomImageView headCustomImageView = new HeadCustomImageView(getContext());
            this.m = headCustomImageView;
            headCustomImageView.setId(R.id.bottom_head_custom_image_view);
            a29 a29Var = new a29();
            this.i = a29Var;
            a29Var.a = getPageId();
            this.I = new l35();
            G();
            SkinManager.setLottieAnimation(this.e, this.t);
            FirstPraiseToast.getInstance();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.bottom_agree_container);
            this.E = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.U);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.bottom_disagree_container);
            this.D = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.U);
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
                this.E.addView(this.g, 0, layoutParams);
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
            ThreadData threadData = this.y;
            if (threadData != null) {
                if (threadData instanceof AdvertAppInfo) {
                    xw4 xw4Var = ((AdvertAppInfo) threadData).i;
                    if (xw4Var != null) {
                        str3 = xw4Var.c;
                    } else {
                        str3 = null;
                    }
                    str2 = str3;
                    str = null;
                } else {
                    String valueOf = String.valueOf(threadData.getFid());
                    str = this.y.getTid();
                    str2 = valueOf;
                }
            } else {
                str = null;
                str2 = null;
            }
            kb5.g().e(this.M, str, str2, this.K, new f(this));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            removeAllViews();
            U(this.c);
            U(this.e);
            U(this.d);
            U(this.f);
            G();
            H(ej.g(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public final void H(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            int i6 = -ej.g(getContext(), R.dimen.tbds24);
            int g2 = ej.g(getContext(), R.dimen.tbds34);
            this.E.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.E.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.d.setLayoutParams(layoutParams2);
            this.D.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.D.setLayoutParams(layoutParams3);
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
            return this.F;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.P;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            yw4 yw4Var = this.p;
            if (yw4Var != null && yw4Var.d == 2) {
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
        yw4 yw4Var = this.p;
        if (yw4Var != null) {
            yw4Var.d = 1;
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.P) {
            if (this.Q != null && TbadkCoreApplication.isLogin()) {
                this.Q.onRelease();
            }
            this.P = false;
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.x;
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
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public a29 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.i;
        }
        return (a29) invokeV.objValue;
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
            MessageManager.getInstance().registerListener(this.S);
            MessageManager.getInstance().registerListener(this.T);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.V);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.S);
            MessageManager.getInstance().unRegisterListener(this.T);
            TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.V);
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.L = true;
            this.M = "/feed";
        }
    }

    public void setUseDynamicLikeResImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.L = true;
            this.M = "/feed";
            d0();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.h != null && this.c != null) {
            if (this.n && !jh5.a(getContext())) {
                return;
            }
            if (!this.n && !ViewHelper.checkUpIsLogin(getContext())) {
                return;
            }
            this.c.cancelAnimation();
            yw4 yw4Var = this.p;
            if (yw4Var != null) {
                yw4Var.a = 1;
            }
            this.x = true;
            this.h.agreeType = 2;
            if (!DisableZanSwitch.getIsOn()) {
                AgreeData agreeData = this.h;
                if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                    this.h.agreeNum++;
                }
                this.h.hasAgree = true;
                b0();
            }
            yw4 yw4Var2 = this.p;
            if (yw4Var2 != null) {
                yw4Var2.e = 1;
            }
            pj5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                this.h.objSource = findPageExtraByView.a();
            }
            AgreeData agreeData2 = this.h;
            agreeData2.agreeClickType = 1;
            this.I.c(agreeData2, 0, getPageId(), this.n);
            AgreeData agreeData3 = this.h;
            agreeData3.agreeClickType = 0;
            this.I.d(agreeData3, this.i);
            View.OnClickListener onClickListener = this.A;
            if (onClickListener != null) {
                onClickListener.onClick(this.c);
            }
            B();
            yw4 yw4Var3 = this.p;
            if (yw4Var3 != null) {
                yw4Var3.d = 1;
            }
        }
    }

    public final void X() {
        AgreeData agreeData;
        yw4 yw4Var;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (agreeData = this.h) != null && agreeData.agreeType == 2 && agreeData.hasAgree && (yw4Var = this.p) != null && yw4Var.d == 1) {
            String str = null;
            int i3 = yw4Var.b;
            if (i3 != 4 && i3 != 26) {
                if ((i3 == 1 && yw4Var.c != 7) || (i2 = this.p.b) == 7 || i2 == 9 || i2 == 10 || i2 == 22 || i2 == 2) {
                    str = "card";
                }
            } else {
                str = this.p.b + "";
            }
            if (dj.isEmpty(str)) {
                return;
            }
            if (!p35.m().i("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + str, false)) {
                gh.a().postDelayed(new e(this, str), 1000L);
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
        pj5 findPageExtraByView;
        yw4 yw4Var;
        int i3;
        yw4 yw4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            int i4 = -1;
            if (this.h != null && view2 != null) {
                if (this.n && !jh5.a(getContext())) {
                    yw4 yw4Var3 = this.p;
                    if (yw4Var3 != null) {
                        i4 = yw4Var3.d;
                    }
                    i25.a(4, i4);
                    return;
                } else if (!this.n && !ViewHelper.checkUpIsLogin(getContext())) {
                    yw4 yw4Var4 = this.p;
                    if (yw4Var4 != null) {
                        i4 = yw4Var4.d;
                    }
                    i25.a(4, i4);
                    return;
                } else if (!UbsABTestHelper.isAgreeNumberCanClick() && view2 == this.d && !this.G) {
                    yw4 yw4Var5 = this.p;
                    if (yw4Var5 != null) {
                        i4 = yw4Var5.d;
                    }
                    i25.a(5, i4);
                    return;
                } else {
                    int i5 = 0;
                    if (view2.getId() == this.m.getId()) {
                        this.x = false;
                        this.m.b();
                    } else {
                        int i6 = 1;
                        if (view2.getId() != this.E.getId() && view2.getId() != this.c.getId() && ((!UbsABTestHelper.isAgreeNumberCanClick() && !this.G) || view2.getId() != this.d.getId())) {
                            if (view2.getId() == this.D.getId() || view2.getId() == this.e.getId()) {
                                this.e.cancelAnimation();
                                yw4 yw4Var6 = this.p;
                                if (yw4Var6 != null) {
                                    yw4Var6.a = 2;
                                }
                                AgreeData agreeData = this.h;
                                if (agreeData.hasAgree) {
                                    if (agreeData.agreeType == 5) {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = false;
                                        b0();
                                        yw4 yw4Var7 = this.p;
                                        if (yw4Var7 != null) {
                                            yw4Var7.i = 0;
                                        }
                                        this.x = false;
                                        findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                        if (findPageExtraByView != null) {
                                            this.h.objSource = findPageExtraByView.a();
                                        }
                                        yw4Var = this.p;
                                        if (yw4Var == null) {
                                            i3 = yw4Var.d;
                                        } else {
                                            i3 = -1;
                                        }
                                        i25.a(6, i3);
                                        this.I.c(this.h, i6, getPageId(), this.n);
                                        yw4Var2 = this.p;
                                        if (yw4Var2 != null) {
                                            i4 = yw4Var2.d;
                                        }
                                        i25.a(7, i4);
                                    } else {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = true;
                                        agreeData.agreeNum--;
                                        c0(false);
                                        yw4 yw4Var8 = this.p;
                                        if (yw4Var8 != null) {
                                            yw4Var8.i = 1;
                                        }
                                    }
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    c0(false);
                                    yw4 yw4Var9 = this.p;
                                    if (yw4Var9 != null) {
                                        yw4Var9.i = 1;
                                    }
                                }
                                i6 = 0;
                                this.x = false;
                                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                if (findPageExtraByView != null) {
                                }
                                yw4Var = this.p;
                                if (yw4Var == null) {
                                }
                                i25.a(6, i3);
                                this.I.c(this.h, i6, getPageId(), this.n);
                                yw4Var2 = this.p;
                                if (yw4Var2 != null) {
                                }
                                i25.a(7, i4);
                            }
                        } else {
                            this.c.cancelAnimation();
                            yw4 yw4Var10 = this.p;
                            if (yw4Var10 != null) {
                                yw4Var10.a = 1;
                            }
                            AgreeData agreeData2 = this.h;
                            if (agreeData2.hasAgree) {
                                if (agreeData2.agreeType == 2) {
                                    this.x = false;
                                    agreeData2.agreeType = 2;
                                    if (!DisableZanSwitch.getIsOn()) {
                                        AgreeData agreeData3 = this.h;
                                        agreeData3.hasAgree = false;
                                        agreeData3.agreeNum--;
                                        b0();
                                    }
                                    yw4 yw4Var11 = this.p;
                                    if (yw4Var11 != null) {
                                        yw4Var11.e = 1;
                                    }
                                    i5 = 1;
                                } else {
                                    this.x = true;
                                    agreeData2.agreeType = 2;
                                    if (!DisableZanSwitch.getIsOn()) {
                                        AgreeData agreeData4 = this.h;
                                        agreeData4.hasAgree = true;
                                        agreeData4.agreeNum++;
                                        c0(true);
                                        tr8.g().l(getTbPageContext());
                                    }
                                    yw4 yw4Var12 = this.p;
                                    if (yw4Var12 != null) {
                                        yw4Var12.e = 0;
                                    }
                                }
                            } else {
                                this.x = true;
                                agreeData2.agreeType = 2;
                                if (!DisableZanSwitch.getIsOn()) {
                                    AgreeData agreeData5 = this.h;
                                    agreeData5.hasAgree = true;
                                    agreeData5.agreeNum++;
                                    c0(true);
                                    tr8.g().l(getTbPageContext());
                                }
                                yw4 yw4Var13 = this.p;
                                if (yw4Var13 != null) {
                                    yw4Var13.e = 0;
                                }
                            }
                            pj5 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView2 != null) {
                                this.h.objSource = findPageExtraByView2.a();
                            }
                            yw4 yw4Var14 = this.p;
                            if (yw4Var14 != null) {
                                i2 = yw4Var14.d;
                            } else {
                                i2 = -1;
                            }
                            i25.a(6, i2);
                            this.I.c(this.h, i5, getPageId(), this.n);
                            yw4 yw4Var15 = this.p;
                            if (yw4Var15 != null) {
                                i4 = yw4Var15.d;
                            }
                            i25.a(7, i4);
                        }
                    }
                    this.I.d(this.h, this.i);
                    View.OnClickListener onClickListener = this.A;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    B();
                    return;
                }
            }
            yw4 yw4Var16 = this.p;
            if (yw4Var16 != null) {
                i4 = yw4Var16.d;
            }
            i25.a(3, i4);
        }
    }

    public void W() {
        AgreeData agreeData;
        yw4 yw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (agreeData = this.h) == null || agreeData.agreeType != 2 || (yw4Var = this.p) == null) {
            return;
        }
        int i2 = yw4Var.b;
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
            if (!this.R) {
                SkinManager.setLottieAnimation(this.e, this.t);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.s);
            SkinManager.setLottieAnimation(this.e, this.t);
            if (this.J) {
                a45.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.L = true;
            this.M = "/pb";
            d0();
            AgreeData agreeData = this.h;
            if (agreeData != null && agreeData.hasAgree && agreeData.agreeType == 2) {
                this.c.setProgress(1.0f);
            } else {
                this.c.setProgress(0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Y() {
        ThreadData threadData;
        yw4 yw4Var;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (threadData = this.y) != null && (yw4Var = this.p) != null && threadData.isTiebaPlusAdThread) {
            int i8 = yw4Var.b;
            if (i8 != 1 && i8 != 2 && i8 != 10 && i8 != 25 && i8 != 4) {
                return;
            }
            yw4 yw4Var2 = this.p;
            if (yw4Var2.b == 4 && (i7 = yw4Var2.f) != 2 && i7 != 3) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
            int i9 = this.p.b;
            if (i9 == 1) {
                statisticItem.addParam("obj_locate", 1);
            } else if (i9 != 2 && i9 != 25 && i9 != 10) {
                if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
            } else {
                int i10 = this.y.tiePlusFrsStaticLocate;
                if (i10 != 2) {
                    statisticItem.addParam("obj_locate", i10 + 1);
                } else {
                    statisticItem.addParam("obj_locate", 2);
                }
            }
            if (this.y.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.y.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.y.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.y.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.p.j);
            int i11 = this.p.e;
            if (i11 == 0) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
            } else if (i11 == 1) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
            }
            statisticItem.addParam("order_id", this.y.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            int i12 = this.p.e;
            if (i12 == 0) {
                i3 = ft4.g;
            } else if (i12 == 1) {
                i3 = ft4.j;
            } else {
                i2 = 0;
                i4 = this.p.b;
                if (i4 != 1) {
                    i6 = ft4.a;
                } else if (i4 == 2) {
                    i6 = ft4.b;
                } else if (L(i4)) {
                    i6 = ft4.c;
                } else {
                    i5 = 0;
                    ThreadData threadData2 = this.y;
                    ft4.a(i2, i5, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                }
                i5 = i6;
                ThreadData threadData22 = this.y;
                ft4.a(i2, i5, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
            }
            i2 = i3;
            i4 = this.p.b;
            if (i4 != 1) {
            }
            i5 = i6;
            ThreadData threadData222 = this.y;
            ft4.a(i2, i5, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            int g2 = ej.g(getContext(), R.dimen.tbds120);
            removeAllViews();
            U(this.c);
            U(this.e);
            U(this.d);
            U(this.f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.bottom_agree_container);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = ej.g(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            layoutParams.gravity = 1;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.U);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(g2, g2));
            this.d.setTextSize(0, ej.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -ej.g(getContext(), R.dimen.tbds16);
            this.d.setGravity(1);
            linearLayout.addView(this.d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.bottom_disagree_container);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = ej.g(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.U);
            this.D = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(g2, g2));
            this.f.setTextSize(0, ej.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -ej.g(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f, layoutParams4);
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
            this.m.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.m.setVisibility(0);
            this.m.setUserInfo(metaData);
            this.m.setFrom(4);
            this.m.setOnClickListener(this.U);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds94);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int g2 = ej.g(getContext(), R.dimen.tbds10);
            int g3 = ej.g(getContext(), R.dimen.tbds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = dimenPixelSize;
            layoutParams.height = dimenPixelSize2;
            layoutParams.topMargin = g2;
            layoutParams.bottomMargin = g3;
            if (this.m.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.m.getParent()).removeAllViews();
            }
            this.D.setOnClickListener(null);
            this.D.addView(this.m, layoutParams);
            ThreadData threadData = this.y;
            if (threadData != null) {
                ux.a(2, threadData.getTid(), ux.d, ux.f, null, this.y.getAuthorId());
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
                if (this.J) {
                    a45.c(this.d);
                }
            }
            if (this.J) {
                a45.d(this.d);
            }
        }
    }

    public void v() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && this.E != null && (tBLottieAnimationView = this.c) != null && this.d != null) {
            U(tBLottieAnimationView);
            U(this.d);
            int g2 = ej.g(getContext(), R.dimen.tbds74);
            this.E.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 0;
            this.E.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(g2, g2));
            this.E.addView(this.d);
            this.E.addView(this.c);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            int g2 = ej.g(getContext(), R.dimen.tbds112);
            int g3 = ej.g(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -g3;
            layoutParams.topMargin = ej.g(getContext(), R.dimen.tbds_2);
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, ej.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = ej.g(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = ej.g(getContext(), R.dimen.tbds_2);
            this.d.setLayoutParams(layoutParams2);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
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
                if (this.J) {
                    a45.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.J) {
                a45.c(this.d);
            }
        }
        if (this.J) {
            a45.d(this.d);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            int g2 = ej.g(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, ej.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -ej.g(getContext(), R.dimen.tbds24);
                int g3 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.d.setPadding(0, g3, g3 * 3, g3);
                this.G = true;
            } else {
                layoutParams2.leftMargin = -ej.g(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = ej.g(getContext(), R.dimen.tbds28);
            }
            this.e.setLayoutParams(layoutParams3);
            this.f.setVisibility(8);
        }
    }

    public void u(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048652, this, i2, i3, i4, i5) == null) {
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
}
