package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FirstPraiseToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLazyLottieAnimationView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ei8;
import com.repackage.i15;
import com.repackage.iu4;
import com.repackage.j15;
import com.repackage.mz4;
import com.repackage.oi;
import com.repackage.os4;
import com.repackage.ou4;
import com.repackage.pi;
import com.repackage.pu4;
import com.repackage.q65;
import com.repackage.q85;
import com.repackage.qg;
import com.repackage.qk4;
import com.repackage.tn4;
import com.repackage.un4;
import com.repackage.ut4;
import com.repackage.v85;
import com.repackage.v88;
import com.repackage.yt4;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public boolean B;
    public boolean C;
    public h D;
    public ut4 E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I;
    public String J;
    public int K;
    public boolean L;
    public i M;
    public boolean N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public View.OnClickListener Q;
    public int a;
    public TbPageContext b;
    public TBLottieAnimationView c;
    public TextView d;
    public TBLottieAnimationView e;
    public TextView f;
    public AgreeData g;
    public ei8 h;
    public ScaleAnimation i;
    public boolean j;
    public boolean k;
    public un4 l;
    public int m;
    public String n;
    public int o;
    public int p;
    public int q;
    public String r;
    public String s;
    public boolean t;
    public ThreadData u;
    public int v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public int y;
    public LinearLayout z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AgreeView agreeView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ei8 ei8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ei8) || (ei8Var = (ei8) customResponsedMessage.getData()) == null || (agreeData = ei8Var.b) == null || this.a.g == null || agreeData == null || this.a.h == null || this.a.g.isInPost || this.a.h.a == ei8Var.a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (this.a.g.baijiahaoData == null || !TextUtils.equals(str, this.a.g.baijiahaoData.oriUgcNid)) {
                    return;
                }
                this.a.S(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = this.a.g.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            this.a.S(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AgreeView agreeView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ei8 ei8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ei8) || (ei8Var = (ei8) customResponsedMessage.getData()) == null || (agreeData = ei8Var.b) == null || this.a.g == null || TextUtils.isEmpty(this.a.g.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.g.postId.equals(agreeData.postId) || this.a.g.isInThread) {
                return;
            }
            if (this.a.j) {
                if (this.a.g.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (this.a.h.a == ei8Var.a) {
                return;
            }
            this.a.S(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.L = true;
                if (this.a.l != null) {
                    this.a.l.d = 3;
                }
                this.a.J();
                if (this.a.M == null || !TbadkCoreApplication.isLogin()) {
                    return false;
                }
                this.a.M.onLongPress();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.a.L) {
                    if (this.a.M != null && TbadkCoreApplication.isLogin()) {
                        this.a.M.onRelease();
                    }
                    this.a.L = false;
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

        public e(AgreeView agreeView) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                os4.a(1, 1);
                if (this.a.u == null || this.a.u.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    this.a.L(view2);
                    View.OnClickListener onClickListener = this.a.x;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    if (this.a.y == 1 || this.a.y == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                    this.a.Q();
                    return;
                }
                os4.a(2, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AgreeView b;

        public f(AgreeView agreeView, String str) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || BreatheTipWidget.e()) {
                return;
            }
            ou4 ou4Var = new ou4();
            ou4Var.b = R.raw.obfuscated_res_0x7f110025;
            ou4Var.a = BreatheTipWidget.PointType.LOTTIE;
            ou4Var.c = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            pu4 pu4Var = new pu4();
            pu4Var.a = this.b.getContext().getString(R.string.obfuscated_res_0x7f0f0a46);
            pu4Var.b = this.b.getContext().getString(R.string.obfuscated_res_0x7f0f00e6);
            pu4Var.e = R.drawable.pic_guidecard;
            pu4Var.f = pi.f(this.b.getContext(), R.dimen.tbds156);
            pu4Var.g = pi.f(this.b.getContext(), R.dimen.tbds489);
            pu4Var.h = pi.f(this.b.getContext(), R.dimen.tbds286);
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.b.getContext());
            breatheTipWidget.g(this.b.getImgAgree());
            breatheTipWidget.f(pu4Var, ou4Var);
            if (breatheTipWidget.h((Activity) this.b.getContext())) {
                yt4 k = yt4.k();
                k.u("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + this.a, true);
                mz4.b("c14827", this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i15 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

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

        @Override // com.repackage.i15
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
                if (this.a.K == i) {
                    return;
                }
                this.a.K = i;
                this.a.c.cancelAnimation();
                this.a.c.setAnimation(i);
            }
        }

        @Override // com.repackage.i15
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.a.c.setAlpha(0.8f);
                } else {
                    this.a.c.setAlpha(1.0f);
                }
                if (this.a.J.equals(str)) {
                    return;
                }
                this.a.J = str;
                this.a.c.cancelAnimation();
                this.a.c.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(View view2, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void onLongPress();

        void onRelease();
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
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.t = false;
        this.v = 1;
        this.B = false;
        this.C = false;
        this.G = true;
        this.J = "";
        this.L = false;
        this.N = true;
        this.O = new a(this, 2016528);
        this.P = new b(this, 2016530);
        this.Q = new e(this);
        A(context);
    }

    public static boolean G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    public static int M(int i2) {
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

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, textView) == null) {
            if (this.k) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.j) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.q));
            }
        }
    }

    public final void A(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.obfuscated_res_0x7f090e5e);
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addAnimatorListener(this);
            this.c.setOnClickListener(this.Q);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setMinEms(2);
            this.d.setTextSize(0, pi.f(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.Q);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090e76);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.Q);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f0358);
            this.f.setTextSize(0, pi.f(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.Q);
            ei8 ei8Var = new ei8();
            this.h = ei8Var;
            ei8Var.a = getPageId();
            this.E = new ut4();
            B();
            SkinManager.setLottieAnimation(this.e, this.p);
            FirstPraiseToast.getInstance();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903b7);
            this.A = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.Q);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903c2);
            this.z = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.Q);
            linearLayout2.addView(this.e);
            linearLayout2.addView(this.f);
            w(false);
        }
    }

    public final void C(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            int i6 = -pi.f(getContext(), R.dimen.tbds24);
            int f2 = pi.f(getContext(), R.dimen.tbds34);
            this.A.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f3 = i4;
            layoutParams.weight = f3;
            this.A.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.d.setLayoutParams(layoutParams2);
            this.z.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f3;
            this.z.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = f2;
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f.setLayoutParams(layoutParams5);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            un4 un4Var = this.l;
            return un4Var != null && un4Var.d == 2;
        }
        return invokeV.booleanValue;
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.F = z;
            if (this.N && z) {
                iu4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            L(this.c);
            un4 un4Var = this.l;
            if (un4Var != null) {
                un4Var.d = 1;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.g == null || this.c == null) {
            return;
        }
        if (!this.j || q65.a(getContext())) {
            if (this.j || ViewHelper.checkUpIsLogin(getContext())) {
                this.c.cancelAnimation();
                un4 un4Var = this.l;
                if (un4Var != null) {
                    un4Var.a = 1;
                }
                this.t = true;
                AgreeData agreeData = this.g;
                if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                    this.g.agreeNum++;
                }
                AgreeData agreeData2 = this.g;
                agreeData2.agreeType = 2;
                agreeData2.hasAgree = true;
                T();
                un4 un4Var2 = this.l;
                if (un4Var2 != null) {
                    un4Var2.e = 1;
                }
                q85 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                if (findPageExtraByView != null) {
                    this.g.objSource = findPageExtraByView.a();
                }
                this.E.c(this.g, 0, getPageId(), this.j);
                this.E.d(this.g, this.h);
                View.OnClickListener onClickListener = this.w;
                if (onClickListener != null) {
                    onClickListener.onClick(this.c);
                }
                x();
                un4 un4Var3 = this.l;
                if (un4Var3 != null) {
                    un4Var3.d = 1;
                }
            }
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.g == null || this.a == i2) {
            return;
        }
        this.a = i2;
        SkinManager.setLottieAnimation(this.e, this.p);
        if (this.H) {
            V();
        } else {
            SkinManager.setLottieAnimation(this.c, this.o);
            if (this.F) {
                iu4.f(this.c, i2);
            }
        }
        T();
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L(View view2) {
        q85 findPageExtraByView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (this.g != null && view2 != null) {
                if (this.j && !q65.a(getContext())) {
                    un4 un4Var = this.l;
                    os4.a(4, un4Var != null ? un4Var.d : -1);
                    return;
                } else if (!this.j && !ViewHelper.checkUpIsLogin(getContext())) {
                    un4 un4Var2 = this.l;
                    os4.a(4, un4Var2 != null ? un4Var2.d : -1);
                    return;
                } else if (view2 == this.d && !this.C) {
                    un4 un4Var3 = this.l;
                    os4.a(5, un4Var3 != null ? un4Var3.d : -1);
                    return;
                } else {
                    int i2 = 0;
                    int i3 = 1;
                    if (view2.getId() != this.A.getId() && view2.getId() != this.c.getId() && (!this.C || view2.getId() != this.d.getId())) {
                        if (view2.getId() == this.z.getId() || view2.getId() == this.e.getId()) {
                            this.e.cancelAnimation();
                            un4 un4Var4 = this.l;
                            if (un4Var4 != null) {
                                un4Var4.a = 2;
                            }
                            AgreeData agreeData = this.g;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    T();
                                    un4 un4Var5 = this.l;
                                    if (un4Var5 != null) {
                                        un4Var5.i = 0;
                                    }
                                    this.t = false;
                                    findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                    if (findPageExtraByView != null) {
                                        this.g.objSource = findPageExtraByView.a();
                                    }
                                    un4 un4Var6 = this.l;
                                    os4.a(6, un4Var6 == null ? un4Var6.d : -1);
                                    this.E.c(this.g, i3, getPageId(), this.j);
                                    un4 un4Var7 = this.l;
                                    os4.a(7, un4Var7 != null ? un4Var7.d : -1);
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    U(false);
                                    un4 un4Var8 = this.l;
                                    if (un4Var8 != null) {
                                        un4Var8.i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                U(false);
                                un4 un4Var9 = this.l;
                                if (un4Var9 != null) {
                                    un4Var9.i = 1;
                                }
                            }
                            i3 = 0;
                            this.t = false;
                            findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView != null) {
                            }
                            un4 un4Var62 = this.l;
                            os4.a(6, un4Var62 == null ? un4Var62.d : -1);
                            this.E.c(this.g, i3, getPageId(), this.j);
                            un4 un4Var72 = this.l;
                            os4.a(7, un4Var72 != null ? un4Var72.d : -1);
                        }
                    } else {
                        this.c.cancelAnimation();
                        un4 un4Var10 = this.l;
                        if (un4Var10 != null) {
                            un4Var10.a = 1;
                        }
                        AgreeData agreeData2 = this.g;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                this.t = false;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                T();
                                un4 un4Var11 = this.l;
                                if (un4Var11 != null) {
                                    un4Var11.e = 1;
                                }
                                i2 = 1;
                            } else {
                                this.t = true;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                U(true);
                                v88.g().l(getTbPageContext());
                                un4 un4Var12 = this.l;
                                if (un4Var12 != null) {
                                    un4Var12.e = 0;
                                }
                            }
                        } else {
                            this.t = true;
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            U(true);
                            v88.g().l(getTbPageContext());
                            un4 un4Var13 = this.l;
                            if (un4Var13 != null) {
                                un4Var13.e = 0;
                            }
                        }
                        q85 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                        if (findPageExtraByView2 != null) {
                            this.g.objSource = findPageExtraByView2.a();
                        }
                        un4 un4Var14 = this.l;
                        os4.a(6, un4Var14 != null ? un4Var14.d : -1);
                        this.E.c(this.g, i2, getPageId(), this.j);
                        un4 un4Var15 = this.l;
                        os4.a(7, un4Var15 != null ? un4Var15.d : -1);
                    }
                    this.E.d(this.g, this.h);
                    View.OnClickListener onClickListener = this.w;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    x();
                    return;
                }
            }
            un4 un4Var16 = this.l;
            os4.a(3, un4Var16 != null ? un4Var16.d : -1);
        }
    }

    public final void N(StatisticItem statisticItem) {
        un4 un4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, statisticItem) == null) || statisticItem == null || (un4Var = this.l) == null) {
            return;
        }
        int i2 = un4Var.b;
        if (i2 == 4 || i2 == 26 || i2 == 2 || i2 == 10 || i2 == 25) {
            int i3 = this.l.d;
            if (i3 == 1) {
                String i4 = j15.g().i();
                if (StringUtils.isNull(i4)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i4);
            } else if (i3 == 2) {
                String f2 = j15.g().f();
                if (StringUtils.isNull(f2)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
            } else if (i3 == 3) {
                String h2 = j15.g().h();
                if (StringUtils.isNull(h2)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, h2);
            }
        }
    }

    public final void O(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view2) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    public void P() {
        AgreeData agreeData;
        un4 un4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (agreeData = this.g) == null || agreeData.agreeType != 2 || (un4Var = this.l) == null) {
            return;
        }
        int i2 = un4Var.b;
        if (i2 == 2 || i2 == 4 || i2 == 26 || i2 == 5 || i2 == 12) {
            FirstPraiseToast.getInstance().show();
        }
    }

    public final void Q() {
        AgreeData agreeData;
        un4 un4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (agreeData = this.g) != null && agreeData.agreeType == 2 && agreeData.hasAgree && (un4Var = this.l) != null && un4Var.d == 1) {
            String str = null;
            int i2 = un4Var.b;
            if (i2 == 4 || i2 == 26) {
                str = this.l.b + "";
            } else if (i2 == 1 || i2 == 7 || i2 == 9 || i2 == 10 || i2 == 22 || i2 == 2) {
                str = "card";
            }
            if (oi.isEmpty(str)) {
                return;
            }
            if (yt4.k().h("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + str, false)) {
                return;
            }
            qg.a().postDelayed(new f(this, str), 1000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R() {
        ThreadData threadData;
        un4 un4Var;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (threadData = this.u) == null || (un4Var = this.l) == null || !threadData.isTiebaPlusAdThread) {
            return;
        }
        int i8 = un4Var.b;
        if (i8 == 1 || i8 == 2 || i8 == 10 || i8 == 25 || i8 == 4) {
            un4 un4Var2 = this.l;
            if (un4Var2.b != 4 || (i7 = un4Var2.f) == 2 || i7 == 3) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
                int i9 = this.l.b;
                if (i9 == 1) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (i9 == 2 || i9 == 25 || i9 == 10) {
                    int i10 = this.u.tiePlusFrsStaticLocate;
                    if (i10 != 2) {
                        statisticItem.addParam("obj_locate", i10 + 1);
                    } else {
                        statisticItem.addParam("obj_locate", 2);
                    }
                } else if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
                if (this.u.isVideoWorksInfo()) {
                    statisticItem.addParam("obj_type", 3);
                } else if (this.u.isVideoThreadType()) {
                    statisticItem.addParam("obj_type", 2);
                } else {
                    statisticItem.addParam("obj_type", 1);
                }
                statisticItem.addParam("tid", this.u.getTid());
                statisticItem.addParam(TiebaStatic.Params.FID_1, this.u.getFid());
                statisticItem.addParam(TiebaStatic.Params.FID_2, this.l.j);
                int i11 = this.l.e;
                if (i11 == 0) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
                } else if (i11 == 1) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
                }
                statisticItem.addParam("order_id", this.u.tiebaPlusOrderId);
                TiebaStatic.log(statisticItem);
                int i12 = this.l.e;
                if (i12 == 0) {
                    i3 = qk4.g;
                } else if (i12 == 1) {
                    i3 = qk4.j;
                } else {
                    i2 = 0;
                    i4 = this.l.b;
                    if (i4 != 1) {
                        i6 = qk4.a;
                    } else if (i4 == 2) {
                        i6 = qk4.b;
                    } else if (G(i4)) {
                        i6 = qk4.c;
                    } else {
                        i5 = 0;
                        ThreadData threadData2 = this.u;
                        qk4.a(i2, i5, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                    }
                    i5 = i6;
                    ThreadData threadData22 = this.u;
                    qk4.a(i2, i5, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
                }
                i2 = i3;
                i4 = this.l.b;
                if (i4 != 1) {
                }
                i5 = i6;
                ThreadData threadData222 = this.u;
                qk4.a(i2, i5, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
            }
        }
    }

    public final void S(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, agreeData) == null) || agreeData == null || (agreeData2 = this.g) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        T();
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String z = z(this.g);
            if (this.g == null) {
                return;
            }
            this.d.setText(z);
            this.c.cancelAnimation();
            AgreeData agreeData = this.g;
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
                if (this.F) {
                    iu4.c(this.d);
                }
            }
            if (this.F) {
                iu4.d(this.d);
            }
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.g == null) {
            return;
        }
        this.c.setMinAndMaxProgress(0.0f, 1.0f);
        this.e.setMinAndMaxProgress(0.0f, 1.0f);
        this.d.setText(z(this.g));
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
        AgreeData agreeData = this.g;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.f);
            } else {
                setTextNormalColor(this.d);
                this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                if (this.F) {
                    iu4.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.F) {
                iu4.c(this.d);
            }
        }
        if (this.F) {
            iu4.d(this.d);
        }
    }

    public final void V() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ThreadData threadData = this.u;
            if (threadData == null) {
                str = null;
                str2 = null;
            } else if (threadData instanceof AdvertAppInfo) {
                tn4 tn4Var = ((AdvertAppInfo) threadData).i;
                str2 = tn4Var != null ? tn4Var.c : null;
                str = null;
            } else {
                String valueOf = String.valueOf(threadData.getFid());
                str = this.u.getTid();
                str2 = valueOf;
            }
            j15.g().e(this.I, str, str2, this.G, new g(this));
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.d : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.g : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.c : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.e : (TBLottieAnimationView) invokeV.objValue;
    }

    public boolean getIsAgreeNumClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public ei8 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.h : (ei8) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            TbPageContext tbPageContext = getTbPageContext();
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.i == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.i = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.i;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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

    public TBLottieAnimationView getmImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.c : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, animator) == null) || this.H) {
            return;
        }
        P();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.O);
            MessageManager.getInstance().registerListener(this.P);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.P);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeAllViews();
            O(this.c);
            O(this.e);
            O(this.d);
            O(this.f);
            B();
            C(pi.f(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        h hVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.e.setVisibility(z ? 8 : 0);
            this.f.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.z) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.B != z && (hVar = this.D) != null) {
                hVar.a(this.e, z);
            }
            this.B = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (!this.N) {
                SkinManager.setLottieAnimation(this.e, this.p);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.o);
            SkinManager.setLottieAnimation(this.e, this.p);
            if (this.F) {
                iu4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAgreeLongClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iVar) == null) {
            this.M = iVar;
            this.c.setOnLongClickListener(new c(this));
            this.c.setOnTouchListener(new d(this));
        }
    }

    public void setAgreeSource(int i2) {
        un4 un4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048620, this, i2) == null) || (un4Var = this.l) == null) {
            return;
        }
        un4Var.d = i2;
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.v = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.g = agreeData;
        T();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.e.setVisibility(z ? 8 : 0);
            this.f.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.z;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.B = z;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setIsAgreeNumClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.C = z;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.j = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.k = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.G = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.q = i2;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i2, i3) == null) {
            this.o = i2;
            this.p = i3;
            setAgreeAnimationResource();
        }
    }

    public void setStatisticData(un4 un4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, un4Var) == null) {
            this.l = un4Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.n = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, threadData) == null) {
            this.u = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.r = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.s = str;
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.H = true;
            this.I = "/feed";
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.H = true;
            this.I = "/pb";
            V();
            AgreeData agreeData = this.g;
            if (agreeData != null && agreeData.hasAgree && agreeData.agreeType == 2) {
                this.c.setProgress(1.0f);
            } else {
                this.c.setProgress(0.0f);
            }
        }
    }

    public void setUseDynamicLikeResImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.H = true;
            this.I = "/feed";
            V();
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.N = z;
        }
    }

    public void setVisibilityListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, hVar) == null) {
            this.D = hVar;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            int f2 = pi.f(getContext(), R.dimen.tbds120);
            removeAllViews();
            O(this.c);
            O(this.e);
            O(this.d);
            O(this.f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903b7);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = pi.f(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            layoutParams.gravity = 1;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.Q);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(f2, f2));
            this.d.setTextSize(0, pi.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -pi.f(getContext(), R.dimen.tbds16);
            this.d.setGravity(1);
            linearLayout.addView(this.d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903c2);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = pi.f(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.Q);
            this.z = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(f2, f2));
            this.f.setTextSize(0, pi.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -pi.f(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f, layoutParams4);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            int f2 = pi.f(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, pi.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -pi.f(getContext(), R.dimen.tbds24);
                int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.d.setPadding(0, f3, f3 * 3, f3);
                this.C = true;
            } else {
                layoutParams2.leftMargin = -pi.f(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = pi.f(getContext(), R.dimen.tbds28);
            }
            this.e.setLayoutParams(layoutParams3);
            this.f.setVisibility(8);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            int f2 = pi.f(getContext(), R.dimen.tbds112);
            int f3 = pi.f(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -f3;
            layoutParams.topMargin = pi.f(getContext(), R.dimen.tbds_2);
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, pi.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = pi.f(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = pi.f(getContext(), R.dimen.tbds_2);
            this.d.setLayoutParams(layoutParams2);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            if (z) {
                C(pi.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.B);
                return;
            }
            C(pi.f(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.B);
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
    public void x() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AgreeData agreeData2;
        String str6;
        q85 findPageExtraByView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || this.l == null || (agreeData = this.g) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i2 = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i3 = this.l.a;
        if (i3 != 1) {
            if (i3 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.l.g).param("obj_locate", this.l.h).param(TiebaStatic.Params.OBJ_PARAM2, this.m).param("obj_id", this.l.i).param("obj_name", i2).param("post_id", this.g.postId).param("nid", this.g.nid);
                ThreadData threadData = this.u;
                if (threadData != null) {
                    param.param("tid", threadData.getId()).param("nid", this.u.getNid()).param("fid", this.u.getFid()).param("card_type", this.v).param("ab_tag", this.u.mRecomAbTag).param("recom_source", this.u.mRecomSource).param("weight", this.u.mRecomWeight).param("extra", this.u.mRecomExtra);
                    if (this.u.getBaijiahaoData() != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM4, this.u.getBaijiahaoData().oriUgcNid);
                        if (this.u.isBJHVideoThreadType() || this.u.isBJHVideoDynamicThreadType()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, this.u.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.u.isBjhDynamicThread()) {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.u.isBJHArticleThreadType() && !this.u.isBJHVideoThreadType()) {
                        int i4 = this.u.threadType;
                        if (i4 == 0 || i4 == 40) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                        }
                    } else {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    }
                } else {
                    param.param("tid", this.g.threadId);
                    param.param("nid", this.g.nid);
                    param.param("fid", this.g.forumId);
                    param.param("card_type", this.g.cardType);
                    param.param("ab_tag", this.g.recomAbTag);
                    param.param("recom_source", this.g.recomSource);
                    param.param("weight", this.g.recomWeight);
                    param.param("extra", this.g.recomExtra);
                    BaijiahaoData baijiahaoData2 = this.g.baijiahaoData;
                    if (baijiahaoData2 != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2.oriUgcVid);
                    }
                }
                int i5 = this.y;
                if (i5 == 1) {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                } else if (i5 != 2) {
                    if (i5 == 18) {
                        str = TiebaStatic.Params.OBJ_TAB;
                        param.param(str, "a099");
                        param.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                    } else {
                        str = TiebaStatic.Params.OBJ_TAB;
                    }
                    str2 = "a002";
                    if (getTbPageContext() != null) {
                        v85.b(getTbPageContext().getPageActivity(), param);
                    }
                    if (this.g.isFromImageViewer) {
                        param.param(str, "a008");
                        if (this.g.mImageViewerFromPage == "index") {
                            param.param(GuildActivityConfig.FROM_PAGE, str2);
                        }
                    }
                    TiebaStatic.log(param);
                    return;
                } else {
                    str2 = "a002";
                    str = TiebaStatic.Params.OBJ_TAB;
                }
                param.param(str, str2);
                if (getTbPageContext() != null) {
                }
                if (this.g.isFromImageViewer) {
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        if (StringUtils.isNull(this.r)) {
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.l.b).param("obj_param1", this.l.c).param("obj_source", this.l.d).param("obj_id", this.l.e).param("obj_name", i2).param("post_id", this.g.postId);
            ThreadData threadData2 = this.u;
            if (threadData2 != null) {
                param2.param("tid", threadData2.getId()).param("nid", this.u.getNid()).param("fid", this.u.getFid()).param("card_type", this.v).param("ab_tag", this.u.mRecomAbTag).param("recom_source", this.u.mRecomSource).param("weight", this.u.mRecomWeight).param("thread_type", this.u.threadType).param("extra", this.u.mRecomExtra);
                if (this.u.getBaijiahaoData() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM4, this.u.getBaijiahaoData().oriUgcNid);
                    if (this.u.isBJHVideoThreadType() || this.u.isBJHVideoDynamicThreadType()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, this.u.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (this.u.isBjhDynamicThread()) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (!this.u.isBJHArticleThreadType() && !this.u.isBJHVideoThreadType()) {
                    int i6 = this.u.threadType;
                    if (i6 == 0 || i6 == 40) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                } else {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param2.param("tid", this.g.threadId);
                param2.param("nid", this.g.nid);
                param2.param("fid", this.g.forumId);
                param2.param("card_type", this.g.cardType);
                param2.param("ab_tag", this.g.recomAbTag);
                param2.param("recom_source", this.g.recomSource);
                param2.param("weight", this.g.recomWeight);
                param2.param("extra", this.g.recomExtra);
                BaijiahaoData baijiahaoData3 = this.g.baijiahaoData;
                if (baijiahaoData3 != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData3.oriUgcVid);
                }
            }
            if (G(this.l.b) && M(this.l.f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, M(this.l.f));
            }
            int i7 = this.y;
            if (i7 == 1) {
                str3 = TiebaStatic.Params.RESOURCE_ID;
                str4 = TiebaStatic.Params.OBJ_TAB;
                str5 = "a002";
            } else if (i7 == 2) {
                str3 = TiebaStatic.Params.RESOURCE_ID;
                str5 = "a002";
                str4 = TiebaStatic.Params.OBJ_TAB;
            } else {
                if (i7 == 18) {
                    param2.param(TiebaStatic.Params.OBJ_TAB, "a099");
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                } else {
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.m);
                }
                str5 = "a002";
                if (getTbPageContext() != null) {
                    v85.b(getTbPageContext().getPageActivity(), param2);
                }
                agreeData2 = this.g;
                if (agreeData2.isFromImageViewer) {
                    str6 = "index";
                } else {
                    str6 = "index";
                    if (agreeData2.mImageViewerFromPage == str6) {
                        param2.param(GuildActivityConfig.FROM_PAGE, str5);
                    }
                }
                if (str6.equals(this.g.keyFromHomePage)) {
                    param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, str5);
                    param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                }
                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                if (findPageExtraByView != null) {
                    param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                N(param2);
                TiebaStatic.log(param2);
            }
            param2.param(str4, str5);
            param2.param(str3, this.m);
            if (getTbPageContext() != null) {
            }
            agreeData2 = this.g;
            if (agreeData2.isFromImageViewer) {
            }
            if (str6.equals(this.g.keyFromHomePage)) {
            }
            findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
            }
            N(param2);
            TiebaStatic.log(param2);
        } else if (this.l.b == 4 && this.t) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.g.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.s).param("topic_id", this.r));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.g.threadId).param("topic_id", this.r));
        }
        R();
    }

    public final String y(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f0356);
            }
            if (i2 > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public final String z(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, agreeData)) == null) ? y(agreeData) : (String) invokeL.objValue;
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.H = true;
            this.I = str;
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
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.t = false;
        this.v = 1;
        this.B = false;
        this.C = false;
        this.G = true;
        this.J = "";
        this.L = false;
        this.N = true;
        this.O = new a(this, 2016528);
        this.P = new b(this, 2016530);
        this.Q = new e(this);
        A(context);
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
        this.o = R.raw.lottie_agree;
        this.p = R.raw.lottie_disagree;
        this.q = R.color.CAM_X0107;
        this.t = false;
        this.v = 1;
        this.B = false;
        this.C = false;
        this.G = true;
        this.J = "";
        this.L = false;
        this.N = true;
        this.O = new a(this, 2016528);
        this.P = new b(this, 2016530);
        this.Q = new e(this);
        A(context);
    }
}
