package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
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
import com.repackage.eu4;
import com.repackage.g05;
import com.repackage.h05;
import com.repackage.m55;
import com.repackage.m98;
import com.repackage.oi;
import com.repackage.p75;
import com.repackage.rt4;
import com.repackage.sk4;
import com.repackage.sk8;
import com.repackage.u75;
import com.repackage.un4;
import com.repackage.vn4;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public boolean B;
    public boolean C;
    public g D;
    public rt4 E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I;
    public String J;
    public int K;
    public boolean L;
    public h M;
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
    public sk8 h;
    public ScaleAnimation i;
    public boolean j;
    public boolean k;
    public vn4 l;
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
            sk8 sk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sk8) || (sk8Var = (sk8) customResponsedMessage.getData()) == null || (agreeData = sk8Var.b) == null || this.a.g == null || agreeData == null || this.a.h == null || this.a.g.isInPost || this.a.h.a == sk8Var.a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (this.a.g.baijiahaoData == null || !TextUtils.equals(str, this.a.g.baijiahaoData.oriUgcNid)) {
                    return;
                }
                this.a.P(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = this.a.g.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            this.a.P(agreeData);
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
            sk8 sk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sk8) || (sk8Var = (sk8) customResponsedMessage.getData()) == null || (agreeData = sk8Var.b) == null || this.a.g == null || TextUtils.isEmpty(this.a.g.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.g.postId.equals(agreeData.postId) || this.a.g.isInThread) {
                return;
            }
            if (this.a.j) {
                if (this.a.g.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (this.a.h.a == sk8Var.a) {
                return;
            }
            this.a.P(agreeData);
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
                this.a.I();
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
                if (this.a.u == null || this.a.u.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                    this.a.K(view2);
                    View.OnClickListener onClickListener = this.a.x;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    if (this.a.y == 1 || this.a.y == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements g05 {
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

        @Override // com.repackage.g05
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

        @Override // com.repackage.g05
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
    public interface g {
        void a(View view2, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface h {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        z(context);
    }

    public static boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 4 || i == 5 || i == 12 : invokeI.booleanValue;
    }

    public static int L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i == 2) {
                return 1;
            }
            return i == 3 ? 2 : -1;
        }
        return invokeI.intValue;
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, textView) == null) {
            if (this.k) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.j) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.q));
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903bf);
            this.A = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.Q);
            linearLayout.addView(this.c);
            linearLayout.addView(this.d);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903ca);
            this.z = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.Q);
            linearLayout2.addView(this.e);
            linearLayout2.addView(this.f);
            v(false);
        }
    }

    public final void B(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            int i5 = -oi.f(getContext(), R.dimen.tbds24);
            int f2 = oi.f(getContext(), R.dimen.tbds34);
            this.A.setGravity(i4);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
            float f3 = i3;
            layoutParams.weight = f3;
            this.A.setLayoutParams(layoutParams);
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i5;
            this.d.setLayoutParams(layoutParams2);
            this.z.setGravity(i4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
            layoutParams3.weight = f3;
            this.z.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
            layoutParams4.leftMargin = f2;
            this.e.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i5;
            this.f.setLayoutParams(layoutParams5);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            vn4 vn4Var = this.l;
            return vn4Var != null && vn4Var.d == 2;
        }
        return invokeV.booleanValue;
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.F = z;
            if ((!UbsABTestHelper.isLikeModifyTestA() || this.N) && z) {
                eu4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            K(this.c);
            vn4 vn4Var = this.l;
            if (vn4Var != null) {
                vn4Var.d = 1;
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.g == null || this.c == null) {
            return;
        }
        if (!this.j || m55.a(getContext())) {
            if (this.j || ViewHelper.checkUpIsLogin(getContext())) {
                this.c.cancelAnimation();
                vn4 vn4Var = this.l;
                if (vn4Var != null) {
                    vn4Var.a = 1;
                }
                this.t = true;
                AgreeData agreeData = this.g;
                if (agreeData.agreeType != 2 || !agreeData.hasAgree) {
                    this.g.agreeNum++;
                }
                AgreeData agreeData2 = this.g;
                agreeData2.agreeType = 2;
                agreeData2.hasAgree = true;
                Q();
                vn4 vn4Var2 = this.l;
                if (vn4Var2 != null) {
                    vn4Var2.e = 1;
                }
                p75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                if (findPageExtraByView != null) {
                    this.g.objSource = findPageExtraByView.a();
                }
                this.E.c(this.g, 0, getPageId(), this.j);
                this.E.d(this.g, this.h);
                View.OnClickListener onClickListener = this.w;
                if (onClickListener != null) {
                    onClickListener.onClick(this.c);
                }
                w();
                vn4 vn4Var3 = this.l;
                if (vn4Var3 != null) {
                    vn4Var3.d = 1;
                }
            }
        }
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.g == null || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setLottieAnimation(this.e, this.p);
        if (this.H) {
            S();
        } else {
            SkinManager.setLottieAnimation(this.c, this.o);
            if (this.F) {
                eu4.f(this.c, i);
            }
        }
        Q();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(View view2) {
        p75 findPageExtraByView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || this.g == null || view2 == null) {
            return;
        }
        if (!this.j || m55.a(getContext())) {
            if (this.j || ViewHelper.checkUpIsLogin(getContext())) {
                if (view2 != this.d || this.C) {
                    int i = 0;
                    int i2 = 1;
                    if (view2.getId() != this.A.getId() && view2.getId() != this.c.getId() && (!this.C || view2.getId() != this.d.getId())) {
                        if (view2.getId() == this.z.getId() || view2.getId() == this.e.getId()) {
                            this.e.cancelAnimation();
                            vn4 vn4Var = this.l;
                            if (vn4Var != null) {
                                vn4Var.a = 2;
                            }
                            AgreeData agreeData = this.g;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    Q();
                                    vn4 vn4Var2 = this.l;
                                    if (vn4Var2 != null) {
                                        vn4Var2.i = 0;
                                    }
                                    this.t = false;
                                    findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                                    if (findPageExtraByView != null) {
                                        this.g.objSource = findPageExtraByView.a();
                                    }
                                    this.E.c(this.g, i2, getPageId(), this.j);
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    R(false);
                                    vn4 vn4Var3 = this.l;
                                    if (vn4Var3 != null) {
                                        vn4Var3.i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                R(false);
                                vn4 vn4Var4 = this.l;
                                if (vn4Var4 != null) {
                                    vn4Var4.i = 1;
                                }
                            }
                            i2 = 0;
                            this.t = false;
                            findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                            if (findPageExtraByView != null) {
                            }
                            this.E.c(this.g, i2, getPageId(), this.j);
                        }
                    } else {
                        this.c.cancelAnimation();
                        vn4 vn4Var5 = this.l;
                        if (vn4Var5 != null) {
                            vn4Var5.a = 1;
                        }
                        AgreeData agreeData2 = this.g;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                this.t = false;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                Q();
                                vn4 vn4Var6 = this.l;
                                if (vn4Var6 != null) {
                                    vn4Var6.e = 1;
                                }
                                i = 1;
                            } else {
                                this.t = true;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                R(true);
                                m98.g().l(getTbPageContext());
                                vn4 vn4Var7 = this.l;
                                if (vn4Var7 != null) {
                                    vn4Var7.e = 0;
                                }
                            }
                        } else {
                            this.t = true;
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            R(true);
                            m98.g().l(getTbPageContext());
                            vn4 vn4Var8 = this.l;
                            if (vn4Var8 != null) {
                                vn4Var8.e = 0;
                            }
                        }
                        p75 findPageExtraByView2 = TbPageExtraHelper.findPageExtraByView(this);
                        if (findPageExtraByView2 != null) {
                            this.g.objSource = findPageExtraByView2.a();
                        }
                        this.E.c(this.g, i, getPageId(), this.j);
                    }
                    this.E.d(this.g, this.h);
                    View.OnClickListener onClickListener = this.w;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    w();
                }
            }
        }
    }

    public final void M(StatisticItem statisticItem) {
        vn4 vn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, statisticItem) == null) || statisticItem == null || (vn4Var = this.l) == null) {
            return;
        }
        int i = vn4Var.b;
        if ((i == 4 || i == 26 || i == 2 || i == 10 || i == 25) && UbsABTestHelper.isLikeModifyTestA()) {
            int i2 = this.l.d;
            if (i2 == 1) {
                String i3 = h05.g().i();
                if (StringUtils.isNull(i3)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, i3);
            } else if (i2 == 2) {
                String f2 = h05.g().f();
                if (StringUtils.isNull(f2)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, f2);
            } else if (i2 == 3) {
                String h2 = h05.g().h();
                if (StringUtils.isNull(h2)) {
                    return;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, h2);
            }
        }
    }

    public final void N(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && view2 != null && (view2.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O() {
        ThreadData threadData;
        vn4 vn4Var;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (threadData = this.u) == null || (vn4Var = this.l) == null || !threadData.isTiebaPlusAdThread) {
            return;
        }
        int i7 = vn4Var.b;
        if (i7 == 1 || i7 == 2 || i7 == 10 || i7 == 25 || i7 == 4) {
            vn4 vn4Var2 = this.l;
            if (vn4Var2.b != 4 || (i6 = vn4Var2.f) == 2 || i6 == 3) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
                int i8 = this.l.b;
                if (i8 == 1) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (i8 == 2 || i8 == 25 || i8 == 10) {
                    int i9 = this.u.tiePlusFrsStaticLocate;
                    if (i9 != 2) {
                        statisticItem.addParam("obj_locate", i9 + 1);
                    } else {
                        statisticItem.addParam("obj_locate", 2);
                    }
                } else if (i8 == 4) {
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
                int i10 = this.l.e;
                if (i10 == 0) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
                } else if (i10 == 1) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
                }
                statisticItem.addParam("order_id", this.u.tiebaPlusOrderId);
                TiebaStatic.log(statisticItem);
                int i11 = this.l.e;
                if (i11 == 0) {
                    i2 = sk4.g;
                } else if (i11 == 1) {
                    i2 = sk4.j;
                } else {
                    i = 0;
                    i3 = this.l.b;
                    if (i3 != 1) {
                        i5 = sk4.a;
                    } else if (i3 == 2) {
                        i5 = sk4.b;
                    } else if (F(i3)) {
                        i5 = sk4.c;
                    } else {
                        i4 = 0;
                        ThreadData threadData2 = this.u;
                        sk4.a(i, i4, threadData2.tiebaPlusOrderId, threadData2.tiebaPlusToken, threadData2.tiebaPlusExtraParam, threadData2.statFloor);
                    }
                    i4 = i5;
                    ThreadData threadData22 = this.u;
                    sk4.a(i, i4, threadData22.tiebaPlusOrderId, threadData22.tiebaPlusToken, threadData22.tiebaPlusExtraParam, threadData22.statFloor);
                }
                i = i2;
                i3 = this.l.b;
                if (i3 != 1) {
                }
                i4 = i5;
                ThreadData threadData222 = this.u;
                sk4.a(i, i4, threadData222.tiebaPlusOrderId, threadData222.tiebaPlusToken, threadData222.tiebaPlusExtraParam, threadData222.statFloor);
            }
        }
    }

    public final void P(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, agreeData) == null) || agreeData == null || (agreeData2 = this.g) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        Q();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String y = y(this.g);
            if (this.g == null) {
                return;
            }
            this.d.setText(y);
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
                    eu4.c(this.d);
                }
            }
            if (this.F) {
                eu4.d(this.d);
            }
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.g == null) {
            return;
        }
        this.c.setMinAndMaxProgress(0.0f, 1.0f);
        this.e.setMinAndMaxProgress(0.0f, 1.0f);
        this.d.setText(y(this.g));
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
                    eu4.c(this.d);
                }
            }
        } else {
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
            if (this.F) {
                eu4.c(this.d);
            }
        }
        if (this.F) {
            eu4.d(this.d);
        }
    }

    public final void S() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ThreadData threadData = this.u;
            if (threadData == null) {
                str = null;
                str2 = null;
            } else if (threadData instanceof AdvertAppInfo) {
                un4 un4Var = ((AdvertAppInfo) threadData).j;
                str2 = un4Var != null ? un4Var.d : null;
                str = null;
            } else {
                String valueOf = String.valueOf(threadData.getFid());
                str = this.u.getTid();
                str2 = valueOf;
            }
            h05.g().e(this.I, str, str2, this.G, new f(this));
        }
    }

    public boolean getAgreeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.g : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.c : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.e : (TBLottieAnimationView) invokeV.objValue;
    }

    public sk8 getMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h : (sk8) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.c : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.e : (TBLottieAnimationView) invokeV.objValue;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.O);
            MessageManager.getInstance().registerListener(this.P);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.O);
            MessageManager.getInstance().unRegisterListener(this.P);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            removeAllViews();
            N(this.c);
            N(this.e);
            N(this.d);
            N(this.f);
            A();
            B(oi.f(getContext(), R.dimen.tbds120), -2, 0, 16);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int f2 = oi.f(getContext(), R.dimen.tbds120);
            removeAllViews();
            N(this.c);
            N(this.e);
            N(this.d);
            N(this.f);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(R.id.obfuscated_res_0x7f0903bf);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = oi.f(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.setOnClickListener(this.Q);
            linearLayout.addView(this.c, new LinearLayout.LayoutParams(f2, f2));
            this.d.setTextSize(0, oi.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -oi.f(getContext(), R.dimen.tbds16);
            linearLayout.addView(this.d, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setId(R.id.obfuscated_res_0x7f0903ca);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = oi.f(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            linearLayout2.setOnClickListener(this.Q);
            this.z = linearLayout2;
            linearLayout2.addView(this.e, new LinearLayout.LayoutParams(f2, f2));
            this.f.setTextSize(0, oi.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -oi.f(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f, layoutParams4);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        g gVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.e.setVisibility(z ? 8 : 0);
            this.f.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.z) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.B != z && (gVar = this.D) != null) {
                gVar.a(this.e, z);
            }
            this.B = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (UbsABTestHelper.isLikeModifyTestA() && !this.N) {
                SkinManager.setLottieAnimation(this.e, this.p);
                return;
            }
            SkinManager.setLottieAnimation(this.c, this.o);
            SkinManager.setLottieAnimation(this.e, this.p);
            if (this.F) {
                eu4.f(this.c, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setAgreeLongClickListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hVar) == null) {
            this.M = hVar;
            this.c.setOnLongClickListener(new c(this));
            this.c.setOnTouchListener(new d(this));
        }
    }

    public void setCardType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.v = i;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.g = agreeData;
        Q();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.e.setVisibility(z ? 8 : 0);
            this.f.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.z;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.B = z;
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.y = i;
        }
    }

    public void setGameId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.m = i;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.j = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.k = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.G = z;
        }
    }

    public void setNormalColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.q = i;
            setTextNormalColor(this.d);
            setTextNormalColor(this.f);
        }
    }

    public void setResourceId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048626, this, i, i2) == null) {
            this.o = i;
            this.p = i2;
            setAgreeAnimationResource();
        }
    }

    public void setStatisticData(vn4 vn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, vn4Var) == null) {
            this.l = vn4Var;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.n = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, threadData) == null) {
            this.u = threadData;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.r = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.s = str;
        }
    }

    public void setUseDynamicLikeRes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.H = true;
            this.I = "/feed";
        }
    }

    public void setUseDynamicLikeResForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.H = true;
            this.I = "/pb";
            S();
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
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.H = true;
            this.I = "/feed";
            S();
        }
    }

    public void setUseLikeDefaultRes(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.N = z;
        }
    }

    public void setVisibilityListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, gVar) == null) {
            this.D = gVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            int f2 = oi.f(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, oi.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -oi.f(getContext(), R.dimen.tbds24);
                int f3 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.d.setPadding(0, f3, f3 * 3, f3);
                this.C = true;
            } else {
                layoutParams2.leftMargin = -oi.f(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.d.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = oi.f(getContext(), R.dimen.tbds28);
            }
            this.e.setLayoutParams(layoutParams3);
            this.f.setVisibility(8);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            int f2 = oi.f(getContext(), R.dimen.tbds112);
            int f3 = oi.f(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -f3;
            layoutParams.topMargin = oi.f(getContext(), R.dimen.tbds_2);
            this.c.setLayoutParams(layoutParams);
            this.d.setTextSize(0, oi.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = oi.f(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = oi.f(getContext(), R.dimen.tbds_2);
            this.d.setLayoutParams(layoutParams2);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            if (z) {
                B(oi.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.B);
                return;
            }
            B(oi.f(getContext(), R.dimen.tbds126), -2, 0, 16);
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
    public void w() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        AgreeData agreeData2;
        String str6;
        p75 findPageExtraByView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || this.l == null || (agreeData = this.g) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i2 = this.l.a;
        if (i2 != 1) {
            if (i2 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.l.g).param("obj_locate", this.l.h).param(TiebaStatic.Params.OBJ_PARAM2, this.m).param("obj_id", this.l.i).param("obj_name", i).param("post_id", this.g.postId).param("nid", this.g.nid);
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
                        int i3 = this.u.threadType;
                        if (i3 == 0 || i3 == 40) {
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
                int i4 = this.y;
                if (i4 == 1) {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                } else if (i4 != 2) {
                    if (i4 == 18) {
                        str = TiebaStatic.Params.OBJ_TAB;
                        param.param(str, "a099");
                        param.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                    } else {
                        str = TiebaStatic.Params.OBJ_TAB;
                    }
                    str2 = "a002";
                    if (getTbPageContext() != null) {
                        u75.b(getTbPageContext().getPageActivity(), param);
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
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.l.b).param("obj_param1", this.l.c).param("obj_source", this.l.d).param("obj_id", this.l.e).param("obj_name", i).param("post_id", this.g.postId);
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
                    int i5 = this.u.threadType;
                    if (i5 == 0 || i5 == 40) {
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
            if (F(this.l.b) && L(this.l.f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, L(this.l.f));
            }
            int i6 = this.y;
            if (i6 == 1) {
                str3 = TiebaStatic.Params.RESOURCE_ID;
                str4 = TiebaStatic.Params.OBJ_TAB;
                str5 = "a002";
            } else if (i6 == 2) {
                str3 = TiebaStatic.Params.RESOURCE_ID;
                str5 = "a002";
                str4 = TiebaStatic.Params.OBJ_TAB;
            } else {
                if (i6 == 18) {
                    param2.param(TiebaStatic.Params.OBJ_TAB, "a099");
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.n);
                } else {
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.m);
                }
                str5 = "a002";
                if (getTbPageContext() != null) {
                    u75.b(getTbPageContext().getPageActivity(), param2);
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
                M(param2);
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
            M(param2);
            TiebaStatic.log(param2);
        } else if (this.l.b == 4 && this.t) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.g.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.s).param("topic_id", this.r));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.g.threadId).param("topic_id", this.r));
        }
        O();
    }

    public final String x(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                return getContext().getString(R.string.obfuscated_res_0x7f0f035a);
            }
            if (i > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public final String y(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, agreeData)) == null) ? x(agreeData) : (String) invokeL.objValue;
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.c = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.obfuscated_res_0x7f090e97);
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.c.addAnimatorListener(this);
            this.c.setOnClickListener(this.Q);
            TextView textView = new TextView(context);
            this.d = textView;
            textView.setTextSize(0, oi.f(context, R.dimen.tbfontsize34));
            this.d.setOnClickListener(this.Q);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.e = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.obfuscated_res_0x7f090ead);
            this.e.addAnimatorListener(this);
            this.e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.e.setOnClickListener(this.Q);
            TextView textView2 = new TextView(context);
            this.f = textView2;
            textView2.setText(R.string.obfuscated_res_0x7f0f035c);
            this.f.setTextSize(0, oi.f(context, R.dimen.tbfontsize34));
            this.f.setOnClickListener(this.Q);
            sk8 sk8Var = new sk8();
            this.h = sk8Var;
            sk8Var.a = getPageId();
            this.E = new rt4();
            A();
            if (UbsABTestHelper.isLikeModifyTestA()) {
                SkinManager.setLottieAnimation(this.e, this.p);
            } else {
                setAgreeAnimationResource();
            }
        }
    }

    public void setUseDynamicLikeRes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        z(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        z(context);
    }
}
