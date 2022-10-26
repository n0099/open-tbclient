package com.baidu.tbadk.core.view;

import android.animation.Animator;
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
import com.baidu.tbadk.widget.lottie.TBLazyLottieAnimationView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.fr4;
import com.baidu.tieba.gr4;
import com.baidu.tieba.gy4;
import com.baidu.tieba.hh;
import com.baidu.tieba.hn8;
import com.baidu.tieba.hw4;
import com.baidu.tieba.j55;
import com.baidu.tieba.k55;
import com.baidu.tieba.my4;
import com.baidu.tieba.n35;
import com.baidu.tieba.ny4;
import com.baidu.tieba.od8;
import com.baidu.tieba.pa5;
import com.baidu.tieba.qx4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tc5;
import com.baidu.tieba.ux;
import com.baidu.tieba.ux4;
import com.baidu.tieba.wn4;
import com.baidu.tieba.yc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public boolean C;
    public boolean D;
    public h E;
    public qx4 F;
    public boolean G;
    public boolean H;
    public boolean I;
    public String J;
    public String K;
    public int L;
    public boolean M;
    public i N;
    public boolean O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public View.OnClickListener R;
    public int a;
    public TbPageContext b;
    public TBLottieAnimationView c;
    public TextView d;
    public TBLottieAnimationView e;
    public TextView f;
    public AgreeData g;
    public hn8 h;
    public ScaleAnimation i;
    public HeadCustomImageView j;
    public boolean k;
    public boolean l;
    public gr4 m;
    public int n;
    public String o;
    public int p;
    public int q;
    public int r;
    public String s;
    public String t;
    public boolean u;
    public ThreadData v;
    public int w;
    public View.OnClickListener x;
    public View.OnClickListener y;
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

    public static boolean H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    public static int N(int i2) {
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

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, animator) == null) {
        }
    }

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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            hn8 hn8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof hn8) && (hn8Var = (hn8) customResponsedMessage.getData()) != null && (agreeData = hn8Var.b) != null && this.a.g != null && agreeData != null && this.a.h != null && !this.a.g.isInPost && this.a.h.a != hn8Var.a) {
                String str = agreeData.nid;
                if (this.a.g.baijiahaoData != null && !"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.equals(str, this.a.g.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.a.U(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.g.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.U(agreeData);
            }
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            hn8 hn8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof hn8) || (hn8Var = (hn8) customResponsedMessage.getData()) == null || (agreeData = hn8Var.b) == null || this.a.g == null || TextUtils.isEmpty(this.a.g.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.g.postId.equals(agreeData.postId) || this.a.g.isInThread) {
                return;
            }
            if (this.a.k) {
                if (this.a.g.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (this.a.h.a == hn8Var.a) {
                return;
            }
            this.a.U(agreeData);
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
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.M = true;
            if (this.a.m != null) {
                this.a.m.d = 3;
            }
            this.a.K();
            if (this.a.N != null && TbadkCoreApplication.isLogin()) {
                this.a.N.onLongPress();
                return false;
            }
            return false;
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
                if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !this.a.M) {
                    return false;
                }
                if (this.a.N != null && TbadkCoreApplication.isLogin()) {
                    this.a.N.onRelease();
                }
                this.a.M = false;
                return true;
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
                hw4.a(1, 1);
                if (this.a.v != null && this.a.v.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    hw4.a(2, 1);
                    return;
                }
                this.a.M(view2);
                View.OnClickListener onClickListener = this.a.y;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
                if (this.a.z == 1 || this.a.z == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
                this.a.R();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !BreatheTipWidget.e()) {
                my4 my4Var = new my4();
                my4Var.b = R.raw.obfuscated_res_0x7f110027;
                my4Var.a = BreatheTipWidget.PointType.LOTTIE;
                my4Var.c = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                ny4 ny4Var = new ny4();
                ny4Var.a = this.b.getContext().getString(R.string.obfuscated_res_0x7f0f0a91);
                ny4Var.b = this.b.getContext().getString(R.string.obfuscated_res_0x7f0f00eb);
                ny4Var.e = R.drawable.pic_guidecard;
                ny4Var.f = fj.f(this.b.getContext(), R.dimen.tbds156);
                ny4Var.g = fj.f(this.b.getContext(), R.dimen.tbds489);
                ny4Var.h = fj.f(this.b.getContext(), R.dimen.tbds286);
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.b.getContext());
                breatheTipWidget.g(this.b.getImgAgree());
                breatheTipWidget.f(ny4Var, my4Var);
                if (breatheTipWidget.h((Activity) this.b.getContext())) {
                    ux4 k = ux4.k();
                    k.u("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + this.a, true);
                    n35.b("c14827", this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements j55 {
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

        @Override // com.baidu.tieba.j55
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
                if (this.a.L == i) {
                    return;
                }
                this.a.L = i;
                this.a.c.cancelAnimation();
                this.a.c.setAnimation(i);
            }
        }

        @Override // com.baidu.tieba.j55
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.a.c.setAlpha(0.8f);
                } else {
                    this.a.c.setAlpha(1.0f);
                }
                if (this.a.K.equals(str)) {
                    return;
                }
                this.a.K = str;
                this.a.c.cancelAnimation();
                this.a.c.setAnimationDir(str);
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
        this.p = R.raw.lottie_agree;
        this.q = R.raw.lottie_disagree;
        this.r = R.color.CAM_X0107;
        this.u = false;
        this.w = 1;
        this.C = false;
        this.D = false;
        this.H = true;
        this.K = "";
        this.M = false;
        this.O = true;
        this.P = new a(this, 2016528);
        this.Q = new b(this, 2016530);
        this.R = new e(this);
        B(context);
    }

    public final void O(StatisticItem statisticItem) {
        gr4 gr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, statisticItem) == null) && statisticItem != null && (gr4Var = this.m) != null) {
            int i2 = gr4Var.b;
            if (i2 == 4 || i2 == 26 || i2 == 2 || i2 == 10 || i2 == 25) {
                int i3 = this.m.d;
                if (i3 == 1) {
                    String i4 = k55.g().i();
                    if (!StringUtils.isNull(i4)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i4);
                    }
                } else if (i3 == 2) {
                    String f2 = k55.g().f();
                    if (!StringUtils.isNull(f2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
                    }
                } else if (i3 == 3) {
                    String h2 = k55.g().h();
                    if (!StringUtils.isNull(h2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, h2);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, AttributeSet attributeSet) {
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
        this.p = R.raw.lottie_agree;
        this.q = R.raw.lottie_disagree;
        this.r = R.color.CAM_X0107;
        this.u = false;
        this.w = 1;
        this.C = false;
        this.D = false;
        this.H = true;
        this.K = "";
        this.M = false;
        this.O = true;
        this.P = new a(this, 2016528);
        this.Q = new b(this, 2016530);
        this.R = new e(this);
        B(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, AttributeSet attributeSet, int i2) {
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
        this.p = R.raw.lottie_agree;
        this.q = R.raw.lottie_disagree;
        this.r = R.color.CAM_X0107;
        this.u = false;
        this.w = 1;
        this.C = false;
        this.D = false;
        this.H = true;
        this.K = "";
        this.M = false;
        this.O = true;
        this.P = new a(this, 2016528);
        this.Q = new b(this, 2016530);
        this.R = new e(this);
        B(context);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.G = z;
            if (this.O && z) {
                gy4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void P(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    public final void U(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, agreeData) == null) && agreeData != null && (agreeData2 = this.g) != null) {
            agreeData2.agreeType = agreeData.agreeType;
            agreeData2.hasAgree = agreeData.hasAgree;
            agreeData2.agreeNum = agreeData.agreeNum;
            V();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, animator) == null) && !this.I) {
            Q();
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setAgreeLongClickListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, iVar) == null) {
            this.N = iVar;
            this.c.setOnLongClickListener(new c(this));
            this.c.setOnTouchListener(new d(this));
        }
    }

    public void setAgreeSource(int i2) {
        gr4 gr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i2) == null) && (gr4Var = this.m) != null) {
            gr4Var.d = i2;
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, agreeData) != null) || agreeData == null) {
            return;
        }
        this.g = agreeData;
        V();
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.n = i2;
        }
    }

    public void setIsAgreeNumClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.D = z;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.k = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.l = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.H = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.r = i2;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setStatisticData(gr4 gr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, gr4Var) == null) {
            this.m = gr4Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.o = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, threadData) == null) {
            this.v = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.s = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.t = str;
        }
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.I = true;
            this.J = str;
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.O = z;
        }
    }

    public void setVisibilityListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, hVar) == null) {
            this.E = hVar;
        }
    }

    public final String z(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, agreeData)) == null) {
            return y(agreeData);
        }
        return (String) invokeL.objValue;
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048633, this, i2, i3) == null) {
            this.p = i2;
            this.q = i3;
            setAgreeAnimationResource();
        }
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, textView) == null) {
            if (this.l) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.k) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.r));
            }
        }
    }

    public void A(boolean z) {
        int i2;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.e;
            int i3 = 8;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setVisibility(i2);
            LinearLayout linearLayout = this.A;
            if (linearLayout != null) {
                if (!z) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            if (this.C != z && (hVar = this.E) != null) {
                hVar.a(this.e, z);
            }
            this.C = z;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && this.g != null && this.a != i2) {
            this.a = i2;
            SkinManager.setLottieAnimation(this.e, this.q);
            if (this.I) {
                X();
            } else {
                SkinManager.setLottieAnimation(this.c, this.p);
                if (this.G) {
                    gy4.f(this.c, i2);
                }
            }
            V();
        }
    }

    public void setAgreeAlone(boolean z) {
        int i2;
        h hVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
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
            if (z && (linearLayout = this.A) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.C != z && (hVar = this.E) != null) {
                hVar.a(this.e, z);
            }
            this.C = z;
        }
    }

    public void setDisagreeShow(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
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
            LinearLayout linearLayout = this.A;
            if (linearLayout != null) {
                if (!z) {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
            }
            this.C = z;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            if (z) {
                D(fj.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.C);
                return;
            }
            D(fj.f(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.C);
        }
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.obfuscated_res_0x7f090eba);
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addAnimatorListener(this);
            this.c.setOnClickListener(this.R);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, fj.f(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.R);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090ed3);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.R);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f0363);
            this.f.setTextSize(0, fj.f(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.R);
            HeadCustomImageView headCustomImageView = new HeadCustomImageView(getContext());
            this.j = headCustomImageView;
            headCustomImageView.setId(R.id.obfuscated_res_0x7f0903f3);
            hn8 hn8Var = new hn8();
            this.h = hn8Var;
            hn8Var.a = getPageId();
            this.F = new qx4();
            C();
            SkinManager.setLottieAnimation(this.e, this.q);
            FirstPraiseToast.getInstance();
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048596, this, z) != null) || this.g == null) {
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
                if (this.G) {
                    gy4.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.G) {
                gy4.c(this.d);
            }
        }
        if (this.G) {
            gy4.d(this.d);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            int f2 = fj.f(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, fj.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -fj.f(getContext(), R.dimen.tbds24);
                int f3 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.d.setPadding(0, f3, f3 * 3, f3);
                this.D = true;
            } else {
                layoutParams2.leftMargin = -fj.f(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = fj.f(getContext(), R.dimen.tbds28);
            }
            this.e.setLayoutParams(layoutParams3);
            this.f.setVisibility(8);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903e3);
            this.B = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.R);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903ee);
            this.A = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.R);
            linearLayout2.addView(this.e);
            linearLayout2.addView(this.f);
            w(false);
        }
    }

    public final void X() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ThreadData threadData = this.v;
            if (threadData != null) {
                if (threadData instanceof AdvertAppInfo) {
                    fr4 fr4Var = ((AdvertAppInfo) threadData).i;
                    if (fr4Var != null) {
                        str3 = fr4Var.c;
                    } else {
                        str3 = null;
                    }
                    str2 = str3;
                    str = null;
                } else {
                    String valueOf = String.valueOf(threadData.getFid());
                    str = this.v.getTid();
                    str2 = valueOf;
                }
            } else {
                str = null;
                str2 = null;
            }
            k55.g().e(this.J, str, str2, this.H, new g(this));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            removeAllViews();
            P(this.c);
            P(this.e);
            P(this.d);
            P(this.f);
            C();
            D(fj.f(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public final void D(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            int i6 = -fj.f(getContext(), R.dimen.tbds24);
            int f2 = fj.f(getContext(), R.dimen.tbds34);
            this.B.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f3 = i4;
            layoutParams.weight = f3;
            this.B.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.d.setLayoutParams(layoutParams2);
            this.A.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f3;
            this.A.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = f2;
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f.setLayoutParams(layoutParams5);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.C;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            gr4 gr4Var = this.m;
            if (gr4Var != null && gr4Var.d == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            M(this.c);
            gr4 gr4Var = this.m;
            if (gr4Var != null) {
                gr4Var.d = 1;
            }
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.g;
        }
        return (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public boolean getIsAgreeNumClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.D;
        }
        return invokeV.booleanValue;
    }

    public hn8 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.h;
        }
        return (hn8) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.P);
            MessageManager.getInstance().registerListener(this.Q);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.P);
            MessageManager.getInstance().unRegisterListener(this.Q);
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.I = true;
            this.J = "/feed";
        }
    }

    public void setUseDynamicLikeResImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.I = true;
            this.J = "/feed";
            X();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.g != null && this.c != null) {
            if (this.k && !pa5.a(getContext())) {
                return;
            }
            if (!this.k && !ViewHelper.checkUpIsLogin(getContext())) {
                return;
            }
            this.c.cancelAnimation();
            gr4 gr4Var = this.m;
            if (gr4Var != null) {
                gr4Var.a = 1;
            }
            this.u = true;
            AgreeData agreeData = this.g;
            if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                this.g.agreeNum++;
            }
            AgreeData agreeData2 = this.g;
            agreeData2.agreeType = 2;
            agreeData2.hasAgree = true;
            V();
            gr4 gr4Var2 = this.m;
            if (gr4Var2 != null) {
                gr4Var2.e = 1;
            }
            tc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                this.g.objSource = findPageExtraByView.a();
            }
            this.F.c(this.g, 0, getPageId(), this.k);
            this.F.d(this.g, this.h);
            View.OnClickListener onClickListener = this.x;
            if (onClickListener != null) {
                onClickListener.onClick(this.c);
            }
            x();
            gr4 gr4Var3 = this.m;
            if (gr4Var3 != null) {
                gr4Var3.d = 1;
            }
        }
    }

    public final void R() {
        AgreeData agreeData;
        gr4 gr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (agreeData = this.g) != null && agreeData.agreeType == 2 && agreeData.hasAgree && (gr4Var = this.m) != null && gr4Var.d == 1) {
            String str = null;
            int i2 = gr4Var.b;
            if (i2 != 4 && i2 != 26) {
                if (i2 == 1 || i2 == 7 || i2 == 9 || i2 == 10 || i2 == 22 || i2 == 2) {
                    str = "card";
                }
            } else {
                str = this.m.b + "";
            }
            if (ej.isEmpty(str)) {
                return;
            }
            if (!ux4.k().h("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + str, false)) {
                hh.a().postDelayed(new f(this, str), 1000L);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M(View view2) {
        int i2;
        tc5 findPageExtraByView;
        gr4 gr4Var;
        int i3;
        gr4 gr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            int i4 = -1;
            if (this.g != null && view2 != null) {
                if (this.k && !pa5.a(getContext())) {
                    gr4 gr4Var3 = this.m;
                    if (gr4Var3 != null) {
                        i4 = gr4Var3.d;
                    }
                    hw4.a(4, i4);
                    return;
                } else if (!this.k && !ViewHelper.checkUpIsLogin(getContext())) {
                    gr4 gr4Var4 = this.m;
                    if (gr4Var4 != null) {
                        i4 = gr4Var4.d;
                    }
                    hw4.a(4, i4);
                    return;
                } else if (!UbsABTestHelper.isAgreeNumberCanClick() && view2 == this.d && !this.D) {
                    gr4 gr4Var5 = this.m;
                    if (gr4Var5 != null) {
                        i4 = gr4Var5.d;
                    }
                    hw4.a(5, i4);
                    return;
                } else {
                    if (view2.getId() == this.j.getId()) {
                        this.j.b();
                    } else {
                        int i5 = 0;
                        int i6 = 1;
                        if (view2.getId() != this.B.getId() && view2.getId() != this.c.getId() && ((!UbsABTestHelper.isAgreeNumberCanClick() && !this.D) || view2.getId() != this.d.getId())) {
                            if (view2.getId() == this.A.getId() || view2.getId() == this.e.getId()) {
                                this.e.cancelAnimation();
                                gr4 gr4Var6 = this.m;
                                if (gr4Var6 != null) {
                                    gr4Var6.a = 2;
                                }
                                AgreeData agreeData = this.g;
                                if (agreeData.hasAgree) {
                                    if (agreeData.agreeType == 5) {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = false;
                                        V();
                                        gr4 gr4Var7 = this.m;
                                        if (gr4Var7 != null) {
                                            gr4Var7.i = 0;
                                        }
                                        this.u = false;
                                        findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                        if (findPageExtraByView != null) {
                                            this.g.objSource = findPageExtraByView.a();
                                        }
                                        gr4Var = this.m;
                                        if (gr4Var == null) {
                                            i3 = gr4Var.d;
                                        } else {
                                            i3 = -1;
                                        }
                                        hw4.a(6, i3);
                                        this.F.c(this.g, i6, getPageId(), this.k);
                                        gr4Var2 = this.m;
                                        if (gr4Var2 != null) {
                                            i4 = gr4Var2.d;
                                        }
                                        hw4.a(7, i4);
                                    } else {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = true;
                                        agreeData.agreeNum--;
                                        W(false);
                                        gr4 gr4Var8 = this.m;
                                        if (gr4Var8 != null) {
                                            gr4Var8.i = 1;
                                        }
                                    }
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    W(false);
                                    gr4 gr4Var9 = this.m;
                                    if (gr4Var9 != null) {
                                        gr4Var9.i = 1;
                                    }
                                }
                                i6 = 0;
                                this.u = false;
                                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                if (findPageExtraByView != null) {
                                }
                                gr4Var = this.m;
                                if (gr4Var == null) {
                                }
                                hw4.a(6, i3);
                                this.F.c(this.g, i6, getPageId(), this.k);
                                gr4Var2 = this.m;
                                if (gr4Var2 != null) {
                                }
                                hw4.a(7, i4);
                            }
                        } else {
                            this.c.cancelAnimation();
                            gr4 gr4Var10 = this.m;
                            if (gr4Var10 != null) {
                                gr4Var10.a = 1;
                            }
                            AgreeData agreeData2 = this.g;
                            if (agreeData2.hasAgree) {
                                if (agreeData2.agreeType == 2) {
                                    this.u = false;
                                    agreeData2.agreeType = 2;
                                    agreeData2.hasAgree = false;
                                    agreeData2.agreeNum--;
                                    V();
                                    gr4 gr4Var11 = this.m;
                                    if (gr4Var11 != null) {
                                        gr4Var11.e = 1;
                                    }
                                    i5 = 1;
                                } else {
                                    this.u = true;
                                    agreeData2.agreeType = 2;
                                    agreeData2.hasAgree = true;
                                    agreeData2.agreeNum++;
                                    W(true);
                                    od8.g().l(getTbPageContext());
                                    gr4 gr4Var12 = this.m;
                                    if (gr4Var12 != null) {
                                        gr4Var12.e = 0;
                                    }
                                }
                            } else {
                                this.u = true;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                W(true);
                                od8.g().l(getTbPageContext());
                                gr4 gr4Var13 = this.m;
                                if (gr4Var13 != null) {
                                    gr4Var13.e = 0;
                                }
                            }
                            tc5 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView2 != null) {
                                this.g.objSource = findPageExtraByView2.a();
                            }
                            gr4 gr4Var14 = this.m;
                            if (gr4Var14 != null) {
                                i2 = gr4Var14.d;
                            } else {
                                i2 = -1;
                            }
                            hw4.a(6, i2);
                            this.F.c(this.g, i5, getPageId(), this.k);
                            gr4 gr4Var15 = this.m;
                            if (gr4Var15 != null) {
                                i4 = gr4Var15.d;
                            }
                            hw4.a(7, i4);
                        }
                    }
                    this.F.d(this.g, this.h);
                    View.OnClickListener onClickListener = this.x;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    x();
                    return;
                }
            }
            gr4 gr4Var16 = this.m;
            if (gr4Var16 != null) {
                i4 = gr4Var16.d;
            }
            hw4.a(3, i4);
        }
    }

    public void Q() {
        AgreeData agreeData;
        gr4 gr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (agreeData = this.g) == null || agreeData.agreeType != 2 || (gr4Var = this.m) == null) {
            return;
        }
        int i2 = gr4Var.b;
        if (i2 == 2 || i2 == 4 || i2 == 26 || i2 == 5 || i2 == 12) {
            FirstPraiseToast.getInstance().show();
        }
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (!this.O) {
                SkinManager.setLottieAnimation(this.e, this.q);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.p);
            SkinManager.setLottieAnimation(this.e, this.q);
            if (this.G) {
                gy4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.I = true;
            this.J = "/pb";
            X();
            AgreeData agreeData = this.g;
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
    public final void S() {
        ThreadData threadData;
        gr4 gr4Var;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (threadData = this.v) != null && (gr4Var = this.m) != null && threadData.isTiebaPlusAdThread) {
            int i8 = gr4Var.b;
            if (i8 != 1 && i8 != 2 && i8 != 10 && i8 != 25 && i8 != 4) {
                return;
            }
            gr4 gr4Var2 = this.m;
            if (gr4Var2.b == 4 && (i7 = gr4Var2.f) != 2 && i7 != 3) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
            int i9 = this.m.b;
            if (i9 == 1) {
                statisticItem.addParam("obj_locate", 1);
            } else if (i9 != 2 && i9 != 25 && i9 != 10) {
                if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
            } else {
                int i10 = this.v.tiePlusFrsStaticLocate;
                if (i10 != 2) {
                    statisticItem.addParam("obj_locate", i10 + 1);
                } else {
                    statisticItem.addParam("obj_locate", 2);
                }
            }
            if (this.v.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.v.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.v.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.v.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.m.j);
            int i11 = this.m.e;
            if (i11 == 0) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
            } else if (i11 == 1) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
            }
            statisticItem.addParam("order_id", this.v.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            int i12 = this.m.e;
            if (i12 == 0) {
                i3 = wn4.g;
            } else if (i12 == 1) {
                i3 = wn4.j;
            } else {
                i2 = 0;
                i4 = this.m.b;
                if (i4 != 1) {
                    i6 = wn4.a;
                } else if (i4 == 2) {
                    i6 = wn4.b;
                } else if (H(i4)) {
                    i6 = wn4.c;
                } else {
                    i5 = 0;
                    ThreadData threadData2 = this.v;
                    wn4.a(i2, i5, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                }
                i5 = i6;
                ThreadData threadData22 = this.v;
                wn4.a(i2, i5, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
            }
            i2 = i3;
            i4 = this.m.b;
            if (i4 != 1) {
            }
            i5 = i6;
            ThreadData threadData222 = this.v;
            wn4.a(i2, i5, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            int f2 = fj.f(getContext(), R.dimen.tbds120);
            removeAllViews();
            P(this.c);
            P(this.e);
            P(this.d);
            P(this.f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903e3);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = fj.f(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            layoutParams.gravity = 1;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.R);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(f2, f2));
            this.d.setTextSize(0, fj.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -fj.f(getContext(), R.dimen.tbds16);
            this.d.setGravity(1);
            linearLayout.addView(this.d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903ee);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = fj.f(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.R);
            this.A = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(f2, f2));
            this.f.setTextSize(0, fj.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -fj.f(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f, layoutParams4);
        }
    }

    public void T(VirtualImageCustomFigure virtualImageCustomFigure, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, virtualImageCustomFigure, metaData) == null) && virtualImageCustomFigure != null) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.j.setShowHomeIcon(false);
            this.j.setHeadImageViewResource(virtualImageCustomFigure.getFigureUrl());
            this.j.setHeadImageBackgroundColorResource(virtualImageCustomFigure.getBackgroundValue());
            this.j.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.j.setVisibility(0);
            this.j.setUserInfo(metaData);
            this.j.setFrom(4);
            this.j.setOnClickListener(this.R);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds94);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int f2 = fj.f(getContext(), R.dimen.tbds10);
            int f3 = fj.f(getContext(), R.dimen.tbds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = dimenPixelSize;
            layoutParams.height = dimenPixelSize2;
            layoutParams.topMargin = f2;
            layoutParams.bottomMargin = f3;
            if (this.j.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.j.getParent()).removeAllViews();
            }
            this.A.setOnClickListener(null);
            this.A.addView(this.j, layoutParams);
            ThreadData threadData = this.v;
            if (threadData != null) {
                ux.a(2, threadData.getTid(), ux.d, ux.f, null, this.v.getAuthorId());
            }
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
                if (this.G) {
                    gy4.c(this.d);
                }
            }
            if (this.G) {
                gy4.d(this.d);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            int f2 = fj.f(getContext(), R.dimen.tbds112);
            int f3 = fj.f(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -f3;
            layoutParams.topMargin = fj.f(getContext(), R.dimen.tbds_2);
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, fj.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = fj.f(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = fj.f(getContext(), R.dimen.tbds_2);
            this.d.setLayoutParams(layoutParams2);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
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
        tc5 findPageExtraByView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && this.m != null && (agreeData = this.g) != null) {
            int i2 = 0;
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData != null) {
                i2 = baijiahaoData.oriUgcType;
            }
            int i3 = this.m.a;
            if (i3 == 1) {
                if (StringUtils.isNull(this.s)) {
                    StatisticItem param = new StatisticItem("c12003").param("obj_locate", this.m.b).param("obj_param1", this.m.c).param("obj_source", this.m.d).param("obj_id", this.m.e).param("obj_name", i2).param("post_id", this.g.postId);
                    ThreadData threadData = this.v;
                    if (threadData != null) {
                        param.param("tid", threadData.getId()).param("nid", this.v.getNid()).param("fid", this.v.getFid()).param("card_type", this.w).param("ab_tag", this.v.mRecomAbTag).param("recom_source", this.v.mRecomSource).param("weight", this.v.mRecomWeight).param("thread_type", this.v.threadType).param("extra", this.v.mRecomExtra);
                        if (this.v.getBaijiahaoData() != null) {
                            param.param(TiebaStatic.Params.OBJ_PARAM4, this.v.getBaijiahaoData().oriUgcNid);
                            if (this.v.isBJHVideoThreadType() || this.v.isBJHVideoDynamicThreadType()) {
                                param.param(TiebaStatic.Params.OBJ_PARAM6, this.v.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.v.isBjhDynamicThread()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        } else if (!this.v.isBJHArticleThreadType() && !this.v.isBJHVideoThreadType()) {
                            int i4 = this.v.threadType;
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
                    if (H(this.m.b) && N(this.m.f) != -1) {
                        param.param(TiebaStatic.Params.OBJ_TO, N(this.m.f));
                    }
                    int i5 = this.z;
                    if (i5 != 1) {
                        if (i5 == 2) {
                            str3 = TiebaStatic.Params.RESOURCE_ID;
                            str5 = "a002";
                            str4 = TiebaStatic.Params.OBJ_TAB;
                        } else {
                            if (i5 == 18) {
                                param.param(TiebaStatic.Params.OBJ_TAB, "a099");
                                param.param(TiebaStatic.Params.RESOURCE_ID, this.o);
                            } else {
                                param.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                            }
                            str5 = "a002";
                            if (getTbPageContext() != null) {
                                yc5.b(getTbPageContext().getPageActivity(), param);
                            }
                            agreeData2 = this.g;
                            if (!agreeData2.isFromImageViewer) {
                                str6 = "index";
                                if (agreeData2.mImageViewerFromPage == str6) {
                                    param.param(GuildActivityConfig.FROM_PAGE, str5);
                                }
                            } else {
                                str6 = "index";
                            }
                            if (str6.equals(this.g.keyFromHomePage)) {
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
                            O(param);
                            TiebaStatic.log(param);
                        }
                    } else {
                        str3 = TiebaStatic.Params.RESOURCE_ID;
                        str4 = TiebaStatic.Params.OBJ_TAB;
                        str5 = "a002";
                    }
                    param.param(str4, str5);
                    param.param(str3, this.n);
                    if (getTbPageContext() != null) {
                    }
                    agreeData2 = this.g;
                    if (!agreeData2.isFromImageViewer) {
                    }
                    if (str6.equals(this.g.keyFromHomePage)) {
                    }
                    findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                    if (findPageExtraByView != null) {
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                    }
                    O(param);
                    TiebaStatic.log(param);
                } else if (this.m.b == 4 && this.u) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.g.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.t).param("topic_id", this.s));
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.g.threadId).param("topic_id", this.s));
                }
                S();
            } else if (i3 == 2) {
                StatisticItem param2 = new StatisticItem("c13271").param("obj_type", this.m.g).param("obj_locate", this.m.h).param(TiebaStatic.Params.OBJ_PARAM2, this.n).param("obj_id", this.m.i).param("obj_name", i2).param("post_id", this.g.postId).param("nid", this.g.nid);
                ThreadData threadData2 = this.v;
                if (threadData2 != null) {
                    param2.param("tid", threadData2.getId()).param("nid", this.v.getNid()).param("fid", this.v.getFid()).param("card_type", this.w).param("ab_tag", this.v.mRecomAbTag).param("recom_source", this.v.mRecomSource).param("weight", this.v.mRecomWeight).param("extra", this.v.mRecomExtra);
                    if (this.v.getBaijiahaoData() != null) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM4, this.v.getBaijiahaoData().oriUgcNid);
                        if (this.v.isBJHVideoThreadType() || this.v.isBJHVideoDynamicThreadType()) {
                            param2.param(TiebaStatic.Params.OBJ_PARAM6, this.v.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.v.isBjhDynamicThread()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.v.isBJHArticleThreadType() && !this.v.isBJHVideoThreadType()) {
                        int i6 = this.v.threadType;
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
                int i7 = this.z;
                if (i7 != 1) {
                    if (i7 == 2) {
                        str2 = "a002";
                        str = TiebaStatic.Params.OBJ_TAB;
                    } else {
                        if (i7 == 18) {
                            str = TiebaStatic.Params.OBJ_TAB;
                            param2.param(str, "a099");
                            param2.param(TiebaStatic.Params.RESOURCE_ID, this.o);
                        } else {
                            str = TiebaStatic.Params.OBJ_TAB;
                        }
                        str2 = "a002";
                        if (getTbPageContext() != null) {
                            yc5.b(getTbPageContext().getPageActivity(), param2);
                        }
                        if (this.g.isFromImageViewer) {
                            param2.param(str, "a008");
                            if (this.g.mImageViewerFromPage == "index") {
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
                if (this.g.isFromImageViewer) {
                }
                TiebaStatic.log(param2);
            }
        }
    }

    public final String y(AgreeData agreeData) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, agreeData)) == null) {
            if (agreeData != null) {
                j = agreeData.agreeNum;
            } else {
                j = 0;
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f0361);
            }
            if (i2 > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }
}
