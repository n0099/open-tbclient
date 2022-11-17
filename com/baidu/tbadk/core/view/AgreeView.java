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
import com.baidu.tieba.ah;
import com.baidu.tieba.ce5;
import com.baidu.tieba.cp8;
import com.baidu.tieba.cz4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.j65;
import com.baidu.tieba.jz4;
import com.baidu.tieba.k65;
import com.baidu.tieba.kf8;
import com.baidu.tieba.kx4;
import com.baidu.tieba.l45;
import com.baidu.tieba.my4;
import com.baidu.tieba.nx;
import com.baidu.tieba.po4;
import com.baidu.tieba.qy4;
import com.baidu.tieba.sb5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.xd5;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.tieba.yr4;
import com.baidu.tieba.zr4;
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
    public int B;
    public LinearLayout C;
    public LinearLayout D;
    public boolean E;
    public boolean F;
    public f G;
    public my4 H;
    public boolean I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public int N;
    public boolean O;
    public g P;
    public boolean Q;
    public CustomMessageListener R;
    public CustomMessageListener S;
    public View.OnClickListener T;
    public int a;
    public TbPageContext b;
    public TBLottieAnimationView c;
    public TextView d;
    public TBLottieAnimationView e;
    public TextView f;
    public AgreeData g;
    public cp8 h;
    public ScaleAnimation i;
    public Animator.AnimatorListener j;
    public boolean k;
    public HeadCustomImageView l;
    public boolean m;
    public boolean n;
    public zr4 o;
    public int p;
    public String q;
    public int r;
    public int s;
    public int t;
    public String u;
    public String v;
    public boolean w;
    public ThreadData x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public interface f {
        void a(View view2, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void onLongPress();

        void onRelease();
    }

    public static boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    public static int O(int i2) {
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
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.O = true;
            if (this.a.o != null) {
                this.a.o.d = 3;
            }
            this.a.L();
            if (this.a.P != null && TbadkCoreApplication.isLogin()) {
                this.a.P.onLongPress();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 3) || !this.a.O) {
                    return false;
                }
                if (this.a.P != null && TbadkCoreApplication.isLogin()) {
                    this.a.P.onRelease();
                }
                this.a.O = false;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                kx4.a(1, 1);
                if (this.a.x != null && this.a.x.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    kx4.a(2, 1);
                    return;
                }
                this.a.N(view2);
                View.OnClickListener onClickListener = this.a.A;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
                if (this.a.B == 1 || this.a.B == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
                this.a.S();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AgreeView b;

        public d(AgreeView agreeView, String str) {
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
                iz4 iz4Var = new iz4();
                iz4Var.b = R.raw.obfuscated_res_0x7f110028;
                iz4Var.a = BreatheTipWidget.PointType.LOTTIE;
                iz4Var.c = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                jz4 jz4Var = new jz4();
                jz4Var.a = this.b.getContext().getString(R.string.obfuscated_res_0x7f0f0a9f);
                jz4Var.b = this.b.getContext().getString(R.string.obfuscated_res_0x7f0f00eb);
                jz4Var.e = R.drawable.pic_guidecard;
                jz4Var.f = yi.g(this.b.getContext(), R.dimen.tbds156);
                jz4Var.g = yi.g(this.b.getContext(), R.dimen.tbds489);
                jz4Var.h = yi.g(this.b.getContext(), R.dimen.tbds286);
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.b.getContext());
                breatheTipWidget.g(this.b.getImgAgree());
                breatheTipWidget.f(jz4Var, iz4Var);
                if (breatheTipWidget.h((Activity) this.b.getContext())) {
                    qy4 k = qy4.k();
                    k.u("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + this.a, true);
                    l45.b("c14827", this.a);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements j65 {
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

        @Override // com.baidu.tieba.j65
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
                if (this.a.N == i) {
                    return;
                }
                this.a.N = i;
                this.a.c.cancelAnimation();
                this.a.c.setAnimation(i);
            }
        }

        @Override // com.baidu.tieba.j65
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.a.c.setAlpha(0.8f);
                } else {
                    this.a.c.setAlpha(1.0f);
                }
                if (this.a.M.equals(str)) {
                    return;
                }
                this.a.M = str;
                this.a.c.cancelAnimation();
                this.a.c.setAnimationDir(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AgreeView agreeView) {
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
            cp8 cp8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (agreeView = this.a.get()) == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof cp8) || (cp8Var = (cp8) customResponsedMessage.getData()) == null || (agreeData = cp8Var.b) == null || agreeView.g == null || TextUtils.isEmpty(agreeView.g.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !agreeView.g.postId.equals(agreeData.postId) || agreeView.g.isInThread) {
                return;
            }
            if (agreeView.m) {
                if (agreeView.g.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (agreeView.h.a == cp8Var.a) {
                return;
            }
            agreeView.V(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AgreeView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AgreeView agreeView) {
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
            cp8 cp8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (agreeView = this.a.get()) != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cp8) && (cp8Var = (cp8) customResponsedMessage.getData()) != null && (agreeData = cp8Var.b) != null && agreeView.g != null && agreeData != null && agreeView.h != null && !agreeView.g.isInPost && agreeView.h.a != cp8Var.a) {
                String str = agreeData.nid;
                if (agreeView.g.baijiahaoData != null && !"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (!TextUtils.equals(str, agreeView.g.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    agreeView.V(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = agreeView.g.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                agreeView.V(agreeData);
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
        this.r = R.raw.lottie_agree;
        this.s = R.raw.lottie_disagree;
        this.t = R.color.CAM_X0107;
        this.w = false;
        this.y = 1;
        this.E = false;
        this.F = false;
        this.J = true;
        this.M = "";
        this.O = false;
        this.Q = true;
        this.R = new i(this);
        this.S = new h(this);
        this.T = new c(this);
        C(context);
    }

    public final void P(StatisticItem statisticItem) {
        zr4 zr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, statisticItem) == null) && statisticItem != null && (zr4Var = this.o) != null) {
            int i2 = zr4Var.b;
            if (i2 == 4 || i2 == 26 || i2 == 2 || i2 == 10 || i2 == 25) {
                int i3 = this.o.d;
                if (i3 == 1) {
                    String i4 = k65.g().i();
                    if (!StringUtils.isNull(i4)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i4);
                    }
                } else if (i3 == 2) {
                    String f2 = k65.g().f();
                    if (!StringUtils.isNull(f2)) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
                    }
                } else if (i3 == 3) {
                    String h2 = k65.g().h();
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
        this.r = R.raw.lottie_agree;
        this.s = R.raw.lottie_disagree;
        this.t = R.color.CAM_X0107;
        this.w = false;
        this.y = 1;
        this.E = false;
        this.F = false;
        this.J = true;
        this.M = "";
        this.O = false;
        this.Q = true;
        this.R = new i(this);
        this.S = new h(this);
        this.T = new c(this);
        C(context);
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
        this.r = R.raw.lottie_agree;
        this.s = R.raw.lottie_disagree;
        this.t = R.color.CAM_X0107;
        this.w = false;
        this.y = 1;
        this.E = false;
        this.F = false;
        this.J = true;
        this.M = "";
        this.O = false;
        this.Q = true;
        this.R = new i(this);
        this.S = new h(this);
        this.T = new c(this);
        C(context);
    }

    public final String A(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, agreeData)) == null) {
            return z(agreeData);
        }
        return (String) invokeL.objValue;
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.I = z;
            if (this.Q && z) {
                cz4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void Q(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    public final void V(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, agreeData) == null) && agreeData != null && (agreeData2 = this.g) != null) {
            agreeData2.agreeType = agreeData.agreeType;
            agreeData2.hasAgree = agreeData.hasAgree;
            agreeData2.agreeNum = agreeData.agreeNum;
            W();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, animator) == null) && (animatorListener = this.j) != null) {
            animatorListener.onAnimationCancel(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, animator) == null) {
            if (!this.K) {
                R();
            }
            Animator.AnimatorListener animatorListener = this.j;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
                if (this.k) {
                    this.j = null;
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, animator) == null) && (animatorListener = this.j) != null) {
            animatorListener.onAnimationRepeat(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animator.AnimatorListener animatorListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, animator) == null) && (animatorListener = this.j) != null) {
            animatorListener.onAnimationStart(animator);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public void setAgreeAnimationListenOnce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.k = z;
        }
    }

    public void setAgreeAnimationListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, animatorListener) == null) {
            this.j = animatorListener;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAgreeLongClickListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, gVar) == null) {
            this.P = gVar;
            this.c.setOnLongClickListener(new a(this));
            this.c.setOnTouchListener(new b(this));
        }
    }

    public void setAgreeSource(int i2) {
        zr4 zr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && (zr4Var = this.o) != null) {
            zr4Var.d = i2;
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, agreeData) != null) || agreeData == null) {
            return;
        }
        this.g = agreeData;
        W();
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setIsAgreeNumClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.F = z;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.n = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.J = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.t = i2;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setStatisticData(zr4 zr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, zr4Var) == null) {
            this.o = zr4Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.q = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, threadData) == null) {
            this.x = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.u = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.v = str;
        }
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.K = true;
            this.L = str;
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.Q = z;
        }
    }

    public void setVisibilityListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, fVar) == null) {
            this.G = fVar;
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048636, this, i2, i3) == null) {
            this.r = i2;
            this.s = i3;
            setAgreeAnimationResource();
        }
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, textView) == null) {
            if (this.n) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.m) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.t));
            }
        }
    }

    public void B(boolean z) {
        int i2;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.e;
            int i3 = 8;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setVisibility(i2);
            LinearLayout linearLayout = this.C;
            if (linearLayout != null) {
                if (!z) {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            if (this.E != z && (fVar = this.G) != null) {
                fVar.a(this.e, z);
            }
            this.E = z;
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && this.g != null && this.a != i2) {
            this.a = i2;
            SkinManager.setLottieAnimation(this.e, this.s);
            if (this.K) {
                Y();
            } else {
                SkinManager.setLottieAnimation(this.c, this.r);
                if (this.I) {
                    cz4.f(this.c, i2);
                }
            }
            W();
        }
    }

    public void setAgreeAlone(boolean z) {
        int i2;
        f fVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
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
            if (z && (linearLayout = this.C) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.E != z && (fVar = this.G) != null) {
                fVar.a(this.e, z);
            }
            this.E = z;
        }
    }

    public void setDisagreeShow(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
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
            LinearLayout linearLayout = this.C;
            if (linearLayout != null) {
                if (!z) {
                    i4 = 0;
                }
                linearLayout.setVisibility(i4);
            }
            this.E = z;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            if (z) {
                E(yi.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.E);
                return;
            }
            E(yi.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.E);
        }
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.obfuscated_res_0x7f090ef6);
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addAnimatorListener(this);
            this.c.setOnClickListener(this.T);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, yi.g(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.T);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090f0f);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.T);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f0364);
            this.f.setTextSize(0, yi.g(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.T);
            HeadCustomImageView headCustomImageView = new HeadCustomImageView(getContext());
            this.l = headCustomImageView;
            headCustomImageView.setId(R.id.obfuscated_res_0x7f090400);
            cp8 cp8Var = new cp8();
            this.h = cp8Var;
            cp8Var.a = getPageId();
            this.H = new my4();
            D();
            SkinManager.setLottieAnimation(this.e, this.s);
            FirstPraiseToast.getInstance();
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048597, this, z) != null) || this.g == null) {
            return;
        }
        this.c.setMinAndMaxProgress(0.0f, 1.0f);
        this.e.setMinAndMaxProgress(0.0f, 1.0f);
        this.d.setText(A(this.g));
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
                if (this.I) {
                    cz4.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.I) {
                cz4.c(this.d);
            }
        }
        if (this.I) {
            cz4.d(this.d);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
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
                this.F = true;
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

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903ef);
            this.D = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.T);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903fb);
            this.C = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.T);
            linearLayout2.addView(this.e);
            linearLayout2.addView(this.f);
            x(false);
        }
    }

    public final void Y() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ThreadData threadData = this.x;
            if (threadData != null) {
                if (threadData instanceof AdvertAppInfo) {
                    yr4 yr4Var = ((AdvertAppInfo) threadData).i;
                    if (yr4Var != null) {
                        str3 = yr4Var.c;
                    } else {
                        str3 = null;
                    }
                    str2 = str3;
                    str = null;
                } else {
                    String valueOf = String.valueOf(threadData.getFid());
                    str = this.x.getTid();
                    str2 = valueOf;
                }
            } else {
                str = null;
                str2 = null;
            }
            k65.g().e(this.L, str, str2, this.J, new e(this));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            removeAllViews();
            Q(this.c);
            Q(this.e);
            Q(this.d);
            Q(this.f);
            D();
            E(yi.g(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public final void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            int i6 = -yi.g(getContext(), R.dimen.tbds24);
            int g2 = yi.g(getContext(), R.dimen.tbds34);
            this.D.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.D.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.d.setLayoutParams(layoutParams2);
            this.C.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.C.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f.setLayoutParams(layoutParams5);
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.E;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.O;
        }
        return invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            zr4 zr4Var = this.o;
            if (zr4Var != null && zr4Var.d == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            N(this.c);
            zr4 zr4Var = this.o;
            if (zr4Var != null) {
                zr4Var.d = 1;
            }
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.g;
        }
        return (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public boolean getIsAgreeNumClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.F;
        }
        return invokeV.booleanValue;
    }

    public cp8 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.h;
        }
        return (cp8) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.c;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.e;
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.R);
            MessageManager.getInstance().registerListener(this.S);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.R);
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.K = true;
            this.L = "/feed";
        }
    }

    public void setUseDynamicLikeResImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.K = true;
            this.L = "/feed";
            Y();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.g != null && this.c != null) {
            if (this.m && !sb5.a(getContext())) {
                return;
            }
            if (!this.m && !ViewHelper.checkUpIsLogin(getContext())) {
                return;
            }
            this.c.cancelAnimation();
            zr4 zr4Var = this.o;
            if (zr4Var != null) {
                zr4Var.a = 1;
            }
            this.w = true;
            AgreeData agreeData = this.g;
            if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                this.g.agreeNum++;
            }
            AgreeData agreeData2 = this.g;
            agreeData2.agreeType = 2;
            agreeData2.hasAgree = true;
            W();
            zr4 zr4Var2 = this.o;
            if (zr4Var2 != null) {
                zr4Var2.e = 1;
            }
            xd5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                this.g.objSource = findPageExtraByView.a();
            }
            this.H.c(this.g, 0, getPageId(), this.m);
            this.H.d(this.g, this.h);
            View.OnClickListener onClickListener = this.z;
            if (onClickListener != null) {
                onClickListener.onClick(this.c);
            }
            y();
            zr4 zr4Var3 = this.o;
            if (zr4Var3 != null) {
                zr4Var3.d = 1;
            }
        }
    }

    public final void S() {
        AgreeData agreeData;
        zr4 zr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (agreeData = this.g) != null && agreeData.agreeType == 2 && agreeData.hasAgree && (zr4Var = this.o) != null && zr4Var.d == 1) {
            String str = null;
            int i2 = zr4Var.b;
            if (i2 != 4 && i2 != 26) {
                if (i2 == 1 || i2 == 7 || i2 == 9 || i2 == 10 || i2 == 22 || i2 == 2) {
                    str = "card";
                }
            } else {
                str = this.o.b + "";
            }
            if (xi.isEmpty(str)) {
                return;
            }
            if (!qy4.k().h("key_long_click_agree_" + TbadkCoreApplication.getCurrentAccount() + "_" + str, false)) {
                ah.a().postDelayed(new d(this, str), 1000L);
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
    public final void N(View view2) {
        int i2;
        xd5 findPageExtraByView;
        zr4 zr4Var;
        int i3;
        zr4 zr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            int i4 = -1;
            if (this.g != null && view2 != null) {
                if (this.m && !sb5.a(getContext())) {
                    zr4 zr4Var3 = this.o;
                    if (zr4Var3 != null) {
                        i4 = zr4Var3.d;
                    }
                    kx4.a(4, i4);
                    return;
                } else if (!this.m && !ViewHelper.checkUpIsLogin(getContext())) {
                    zr4 zr4Var4 = this.o;
                    if (zr4Var4 != null) {
                        i4 = zr4Var4.d;
                    }
                    kx4.a(4, i4);
                    return;
                } else if (!UbsABTestHelper.isAgreeNumberCanClick() && view2 == this.d && !this.F) {
                    zr4 zr4Var5 = this.o;
                    if (zr4Var5 != null) {
                        i4 = zr4Var5.d;
                    }
                    kx4.a(5, i4);
                    return;
                } else {
                    if (view2.getId() == this.l.getId()) {
                        this.l.b();
                    } else {
                        int i5 = 0;
                        int i6 = 1;
                        if (view2.getId() != this.D.getId() && view2.getId() != this.c.getId() && ((!UbsABTestHelper.isAgreeNumberCanClick() && !this.F) || view2.getId() != this.d.getId())) {
                            if (view2.getId() == this.C.getId() || view2.getId() == this.e.getId()) {
                                this.e.cancelAnimation();
                                zr4 zr4Var6 = this.o;
                                if (zr4Var6 != null) {
                                    zr4Var6.a = 2;
                                }
                                AgreeData agreeData = this.g;
                                if (agreeData.hasAgree) {
                                    if (agreeData.agreeType == 5) {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = false;
                                        W();
                                        zr4 zr4Var7 = this.o;
                                        if (zr4Var7 != null) {
                                            zr4Var7.i = 0;
                                        }
                                        this.w = false;
                                        findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                        if (findPageExtraByView != null) {
                                            this.g.objSource = findPageExtraByView.a();
                                        }
                                        zr4Var = this.o;
                                        if (zr4Var == null) {
                                            i3 = zr4Var.d;
                                        } else {
                                            i3 = -1;
                                        }
                                        kx4.a(6, i3);
                                        this.H.c(this.g, i6, getPageId(), this.m);
                                        zr4Var2 = this.o;
                                        if (zr4Var2 != null) {
                                            i4 = zr4Var2.d;
                                        }
                                        kx4.a(7, i4);
                                    } else {
                                        agreeData.agreeType = 5;
                                        agreeData.hasAgree = true;
                                        agreeData.agreeNum--;
                                        X(false);
                                        zr4 zr4Var8 = this.o;
                                        if (zr4Var8 != null) {
                                            zr4Var8.i = 1;
                                        }
                                    }
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    X(false);
                                    zr4 zr4Var9 = this.o;
                                    if (zr4Var9 != null) {
                                        zr4Var9.i = 1;
                                    }
                                }
                                i6 = 0;
                                this.w = false;
                                findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                if (findPageExtraByView != null) {
                                }
                                zr4Var = this.o;
                                if (zr4Var == null) {
                                }
                                kx4.a(6, i3);
                                this.H.c(this.g, i6, getPageId(), this.m);
                                zr4Var2 = this.o;
                                if (zr4Var2 != null) {
                                }
                                kx4.a(7, i4);
                            }
                        } else {
                            this.c.cancelAnimation();
                            zr4 zr4Var10 = this.o;
                            if (zr4Var10 != null) {
                                zr4Var10.a = 1;
                            }
                            AgreeData agreeData2 = this.g;
                            if (agreeData2.hasAgree) {
                                if (agreeData2.agreeType == 2) {
                                    this.w = false;
                                    agreeData2.agreeType = 2;
                                    agreeData2.hasAgree = false;
                                    agreeData2.agreeNum--;
                                    W();
                                    zr4 zr4Var11 = this.o;
                                    if (zr4Var11 != null) {
                                        zr4Var11.e = 1;
                                    }
                                    i5 = 1;
                                } else {
                                    this.w = true;
                                    agreeData2.agreeType = 2;
                                    agreeData2.hasAgree = true;
                                    agreeData2.agreeNum++;
                                    X(true);
                                    kf8.g().l(getTbPageContext());
                                    zr4 zr4Var12 = this.o;
                                    if (zr4Var12 != null) {
                                        zr4Var12.e = 0;
                                    }
                                }
                            } else {
                                this.w = true;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                X(true);
                                kf8.g().l(getTbPageContext());
                                zr4 zr4Var13 = this.o;
                                if (zr4Var13 != null) {
                                    zr4Var13.e = 0;
                                }
                            }
                            xd5 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView2 != null) {
                                this.g.objSource = findPageExtraByView2.a();
                            }
                            zr4 zr4Var14 = this.o;
                            if (zr4Var14 != null) {
                                i2 = zr4Var14.d;
                            } else {
                                i2 = -1;
                            }
                            kx4.a(6, i2);
                            this.H.c(this.g, i5, getPageId(), this.m);
                            zr4 zr4Var15 = this.o;
                            if (zr4Var15 != null) {
                                i4 = zr4Var15.d;
                            }
                            kx4.a(7, i4);
                        }
                    }
                    this.H.d(this.g, this.h);
                    View.OnClickListener onClickListener = this.z;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    y();
                    return;
                }
            }
            zr4 zr4Var16 = this.o;
            if (zr4Var16 != null) {
                i4 = zr4Var16.d;
            }
            kx4.a(3, i4);
        }
    }

    public void R() {
        AgreeData agreeData;
        zr4 zr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (agreeData = this.g) == null || agreeData.agreeType != 2 || (zr4Var = this.o) == null) {
            return;
        }
        int i2 = zr4Var.b;
        if (i2 == 2 || i2 == 4 || i2 == 26 || i2 == 5 || i2 == 12) {
            FirstPraiseToast.getInstance().show();
        }
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (!this.Q) {
                SkinManager.setLottieAnimation(this.e, this.s);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.r);
            SkinManager.setLottieAnimation(this.e, this.s);
            if (this.I) {
                cz4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.K = true;
            this.L = "/pb";
            Y();
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
    public final void T() {
        ThreadData threadData;
        zr4 zr4Var;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (threadData = this.x) != null && (zr4Var = this.o) != null && threadData.isTiebaPlusAdThread) {
            int i8 = zr4Var.b;
            if (i8 != 1 && i8 != 2 && i8 != 10 && i8 != 25 && i8 != 4) {
                return;
            }
            zr4 zr4Var2 = this.o;
            if (zr4Var2.b == 4 && (i7 = zr4Var2.f) != 2 && i7 != 3) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
            int i9 = this.o.b;
            if (i9 == 1) {
                statisticItem.addParam("obj_locate", 1);
            } else if (i9 != 2 && i9 != 25 && i9 != 10) {
                if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
            } else {
                int i10 = this.x.tiePlusFrsStaticLocate;
                if (i10 != 2) {
                    statisticItem.addParam("obj_locate", i10 + 1);
                } else {
                    statisticItem.addParam("obj_locate", 2);
                }
            }
            if (this.x.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.x.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.x.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.x.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.o.j);
            int i11 = this.o.e;
            if (i11 == 0) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
            } else if (i11 == 1) {
                statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
            }
            statisticItem.addParam("order_id", this.x.tiebaPlusOrderId);
            TiebaStatic.log(statisticItem);
            int i12 = this.o.e;
            if (i12 == 0) {
                i3 = po4.g;
            } else if (i12 == 1) {
                i3 = po4.j;
            } else {
                i2 = 0;
                i4 = this.o.b;
                if (i4 != 1) {
                    i6 = po4.a;
                } else if (i4 == 2) {
                    i6 = po4.b;
                } else if (I(i4)) {
                    i6 = po4.c;
                } else {
                    i5 = 0;
                    ThreadData threadData2 = this.x;
                    po4.a(i2, i5, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                }
                i5 = i6;
                ThreadData threadData22 = this.x;
                po4.a(i2, i5, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
            }
            i2 = i3;
            i4 = this.o.b;
            if (i4 != 1) {
            }
            i5 = i6;
            ThreadData threadData222 = this.x;
            po4.a(i2, i5, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            int g2 = yi.g(getContext(), R.dimen.tbds120);
            removeAllViews();
            Q(this.c);
            Q(this.e);
            Q(this.d);
            Q(this.f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903ef);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = yi.g(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            layoutParams.gravity = 1;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.T);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(g2, g2));
            this.d.setTextSize(0, yi.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -yi.g(getContext(), R.dimen.tbds16);
            this.d.setGravity(1);
            linearLayout.addView(this.d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903fb);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = yi.g(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.T);
            this.C = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(g2, g2));
            this.f.setTextSize(0, yi.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -yi.g(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f, layoutParams4);
        }
    }

    public void U(VirtualImageCustomFigure virtualImageCustomFigure, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, virtualImageCustomFigure, metaData) == null) && virtualImageCustomFigure != null) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.l.setShowHomeIcon(false);
            this.l.setHeadImageViewResource(virtualImageCustomFigure.getFigureUrl());
            this.l.setHeadImageBackgroundColorResource(virtualImageCustomFigure.getBackgroundValue());
            this.l.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.l.setVisibility(0);
            this.l.setUserInfo(metaData);
            this.l.setFrom(4);
            this.l.setOnClickListener(this.T);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds94);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int g2 = yi.g(getContext(), R.dimen.tbds10);
            int g3 = yi.g(getContext(), R.dimen.tbds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = dimenPixelSize;
            layoutParams.height = dimenPixelSize2;
            layoutParams.topMargin = g2;
            layoutParams.bottomMargin = g3;
            if (this.l.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.l.getParent()).removeAllViews();
            }
            this.C.setOnClickListener(null);
            this.C.addView(this.l, layoutParams);
            ThreadData threadData = this.x;
            if (threadData != null) {
                nx.a(2, threadData.getTid(), nx.d, nx.f, null, this.x.getAuthorId());
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            String A = A(this.g);
            if (this.g == null) {
                return;
            }
            this.d.setText(A);
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
                if (this.I) {
                    cz4.c(this.d);
                }
            }
            if (this.I) {
                cz4.d(this.d);
            }
        }
    }

    public void s() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.D != null && (tBLottieAnimationView = this.c) != null && this.d != null) {
            Q(tBLottieAnimationView);
            Q(this.d);
            int g2 = yi.g(getContext(), R.dimen.tbds74);
            this.D.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 0;
            this.D.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(g2, g2));
            this.D.addView(this.d);
            this.D.addView(this.c);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
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
    public void y() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AgreeData agreeData2;
        String str6;
        xd5 findPageExtraByView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && this.o != null && (agreeData = this.g) != null) {
            int i2 = 0;
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData != null) {
                i2 = baijiahaoData.oriUgcType;
            }
            int i3 = this.o.a;
            if (i3 == 1) {
                if (StringUtils.isNull(this.u)) {
                    StatisticItem param = new StatisticItem("c12003").param("obj_locate", this.o.b).param("obj_param1", this.o.c).param("obj_source", this.o.d).param("obj_id", this.o.e).param("obj_name", i2).param("post_id", this.g.postId);
                    ThreadData threadData = this.x;
                    if (threadData != null) {
                        param.param("tid", threadData.getId()).param("nid", this.x.getNid()).param("fid", this.x.getFid()).param("card_type", this.y).param("ab_tag", this.x.mRecomAbTag).param("recom_source", this.x.mRecomSource).param("weight", this.x.mRecomWeight).param("thread_type", this.x.threadType).param("extra", this.x.mRecomExtra);
                        if (this.x.getBaijiahaoData() != null) {
                            param.param(TiebaStatic.Params.OBJ_PARAM4, this.x.getBaijiahaoData().oriUgcNid);
                            if (this.x.isBJHVideoThreadType() || this.x.isBJHVideoDynamicThreadType()) {
                                param.param(TiebaStatic.Params.OBJ_PARAM6, this.x.getBaijiahaoData().oriUgcVid);
                            }
                        }
                        if (this.x.isBjhDynamicThread()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                        } else if (!this.x.isBJHArticleThreadType() && !this.x.isBJHVideoThreadType()) {
                            int i4 = this.x.threadType;
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
                    if (I(this.o.b) && O(this.o.f) != -1) {
                        param.param(TiebaStatic.Params.OBJ_TO, O(this.o.f));
                    }
                    int i5 = this.B;
                    if (i5 != 1) {
                        if (i5 == 2) {
                            str3 = TiebaStatic.Params.RESOURCE_ID;
                            str5 = "a002";
                            str4 = TiebaStatic.Params.OBJ_TAB;
                        } else {
                            if (i5 == 18) {
                                param.param(TiebaStatic.Params.OBJ_TAB, "a099");
                                param.param(TiebaStatic.Params.RESOURCE_ID, this.q);
                            } else {
                                param.param(TiebaStatic.Params.RESOURCE_ID, this.p);
                            }
                            str5 = "a002";
                            if (getTbPageContext() != null) {
                                ce5.b(getTbPageContext().getPageActivity(), param);
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
                            P(param);
                            TiebaStatic.log(param);
                        }
                    } else {
                        str3 = TiebaStatic.Params.RESOURCE_ID;
                        str4 = TiebaStatic.Params.OBJ_TAB;
                        str5 = "a002";
                    }
                    param.param(str4, str5);
                    param.param(str3, this.p);
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
                    P(param);
                    TiebaStatic.log(param);
                } else if (this.o.b == 4 && this.w) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.g.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.v).param("topic_id", this.u));
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.g.threadId).param("topic_id", this.u));
                }
                T();
            } else if (i3 == 2) {
                StatisticItem param2 = new StatisticItem("c13271").param("obj_type", this.o.g).param("obj_locate", this.o.h).param(TiebaStatic.Params.OBJ_PARAM2, this.p).param("obj_id", this.o.i).param("obj_name", i2).param("post_id", this.g.postId).param("nid", this.g.nid);
                ThreadData threadData2 = this.x;
                if (threadData2 != null) {
                    param2.param("tid", threadData2.getId()).param("nid", this.x.getNid()).param("fid", this.x.getFid()).param("card_type", this.y).param("ab_tag", this.x.mRecomAbTag).param("recom_source", this.x.mRecomSource).param("weight", this.x.mRecomWeight).param("extra", this.x.mRecomExtra);
                    if (this.x.getBaijiahaoData() != null) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM4, this.x.getBaijiahaoData().oriUgcNid);
                        if (this.x.isBJHVideoThreadType() || this.x.isBJHVideoDynamicThreadType()) {
                            param2.param(TiebaStatic.Params.OBJ_PARAM6, this.x.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (this.x.isBjhDynamicThread()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.x.isBJHArticleThreadType() && !this.x.isBJHVideoThreadType()) {
                        int i6 = this.x.threadType;
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
                int i7 = this.B;
                if (i7 != 1) {
                    if (i7 == 2) {
                        str2 = "a002";
                        str = TiebaStatic.Params.OBJ_TAB;
                    } else {
                        if (i7 == 18) {
                            str = TiebaStatic.Params.OBJ_TAB;
                            param2.param(str, "a099");
                            param2.param(TiebaStatic.Params.RESOURCE_ID, this.q);
                        } else {
                            str = TiebaStatic.Params.OBJ_TAB;
                        }
                        str2 = "a002";
                        if (getTbPageContext() != null) {
                            ce5.b(getTbPageContext().getPageActivity(), param2);
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

    public final String z(AgreeData agreeData) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, agreeData)) == null) {
            if (agreeData != null) {
                j = agreeData.agreeNum;
            } else {
                j = 0;
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f0362);
            }
            if (i2 > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }
}
