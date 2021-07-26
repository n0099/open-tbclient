package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.f0.h;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.f;
import d.a.q0.h3.h0.e;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public LinearLayout B;
    public LinearLayout C;
    public boolean D;
    public boolean E;
    public d F;
    public d.a.p0.s.b0.a G;
    public boolean H;
    public CustomMessageListener I;
    public CustomMessageListener J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public int f12412e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f12413f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f12414g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12415h;

    /* renamed from: i  reason: collision with root package name */
    public TBLottieAnimationView f12416i;
    public TextView j;
    public AgreeData k;
    public e l;
    public ScaleAnimation m;
    public boolean n;
    public boolean o;
    public f p;
    public int q;
    public String r;
    public int s;
    public int t;
    public int u;
    public String v;
    public b2 w;
    public int x;
    public View.OnClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AgreeView f12417a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AgreeView agreeView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12417a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f58547b;
                if (this.f12417a.k == null || agreeData == null || this.f12417a.l == null || this.f12417a.k.isInPost || this.f12417a.l.f58546a == eVar.f58546a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.f12417a.k.baijiahaoData == null || !TextUtils.equals(str, this.f12417a.k.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f12417a.A(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f12417a.k.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f12417a.A(agreeData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AgreeView f12418a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AgreeView agreeView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12418a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f58547b;
                if (this.f12418a.k == null || TextUtils.isEmpty(this.f12418a.k.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.f12418a.k.postId.equals(agreeData.postId) || this.f12418a.k.isInThread) {
                    return;
                }
                if (this.f12418a.n) {
                    if (this.f12418a.k.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.f12418a.l.f58546a == eVar.f58546a) {
                    return;
                }
                this.f12418a.A(agreeData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeView f12419e;

        public c(AgreeView agreeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12419e = agreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f12419e.w == null || this.f12419e.w.getType() != b2.K3) {
                    this.f12419e.w(view);
                    View.OnClickListener onClickListener = this.f12419e.z;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    if (this.f12419e.A == 1 || this.f12419e.A == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(View view, boolean z);
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
        this.f12412e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.I = new a(this, 2016528);
        this.J = new b(this, 2016530);
        this.K = new c(this);
        o(context);
    }

    public static boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, textView) == null) {
            if (this.o) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.n) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.u));
            }
        }
    }

    public static int x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            if (i2 == 2) {
                return 1;
            }
            return i2 == 3 ? 2 : -1;
        }
        return invokeI.intValue;
    }

    public final void A(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, agreeData) == null) || agreeData == null || (agreeData2 = this.k) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        B();
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f12415h.setText(n(this.k));
            this.f12414g.cancelAnimation();
            AgreeData agreeData = this.k;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f12416i.setProgress(0.0f);
                    this.f12414g.setProgress(1.0f);
                    this.f12415h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.j);
                } else {
                    this.f12414g.setProgress(0.0f);
                    this.f12416i.setProgress(1.0f);
                    setTextNormalColor(this.f12415h);
                    this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
            } else {
                this.f12414g.setProgress(0.0f);
                this.f12416i.setProgress(0.0f);
                setTextNormalColor(this.f12415h);
                setTextNormalColor(this.j);
                if (this.H) {
                    h.c(this.f12415h);
                }
            }
            if (this.H) {
                h.d(this.f12415h);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f12414g.setMinAndMaxProgress(0.0f, 1.0f);
            this.f12416i.setMinAndMaxProgress(0.0f, 1.0f);
            this.f12415h.setText(n(this.k));
            this.f12414g.clearColorFilter();
            this.f12416i.clearColorFilter();
            if (z) {
                this.f12414g.playAnimation();
                this.f12416i.cancelAnimation();
                this.f12416i.setFrame(0);
            } else {
                this.f12416i.playAnimation();
                this.f12414g.cancelAnimation();
                this.f12414g.setFrame(0);
            }
            AgreeData agreeData = this.k;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f12415h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.j);
                } else {
                    setTextNormalColor(this.f12415h);
                    this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.H) {
                        h.c(this.f12415h);
                    }
                }
            } else {
                setTextNormalColor(this.f12415h);
                setTextNormalColor(this.j);
                if (this.H) {
                    h.c(this.f12415h);
                }
            }
            if (this.H) {
                h.d(this.f12415h);
            }
        }
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12415h : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12414g : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12416i : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.m == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.m = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.m;
        }
        return (Animation) invokeV.objValue;
    }

    public TbPageContext getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f12413f == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f12413f = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f12413f = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f12413f;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12414g : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f12416i : (TBLottieAnimationView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds120);
            removeAllViews();
            y(this.f12414g);
            y(this.f12416i);
            y(this.f12415h);
            y(this.j);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = l.g(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.addView(this.f12414g, new LinearLayout.LayoutParams(g2, g2));
            this.f12415h.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -l.g(getContext(), R.dimen.tbds16);
            linearLayout.addView(this.f12415h, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = l.g(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            this.B = linearLayout2;
            linearLayout2.addView(this.f12416i, new LinearLayout.LayoutParams(g2, g2));
            this.j.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -l.g(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.j, layoutParams4);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            this.f12414g.setLayoutParams(layoutParams);
            this.f12415h.setTextSize(0, l.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -l.g(getContext(), R.dimen.tbds24);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.f12415h.setPadding(0, g3, g3 * 3, g3);
                this.E = true;
            } else {
                layoutParams2.leftMargin = -l.g(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.f12415h.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = l.g(getContext(), R.dimen.tbds28);
            }
            this.f12416i.setLayoutParams(layoutParams3);
            this.j.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds112);
            int g3 = l.g(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -g3;
            layoutParams.topMargin = l.g(getContext(), R.dimen.tbds_2);
            this.f12414g.setLayoutParams(layoutParams);
            this.f12415h.setTextSize(0, l.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = l.g(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = l.g(getContext(), R.dimen.tbds_2);
            this.f12415h.setLayoutParams(layoutParams2);
            this.f12416i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                q(l.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.D);
                return;
            }
            q(l.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.D);
        }
    }

    public void l() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.p == null || (agreeData = this.k) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i2 = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i3 = this.p.f53310a;
        if (i3 != 1) {
            if (i3 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.p.f53316g).param("obj_locate", this.p.f53317h).param(TiebaStatic.Params.OBJ_PARAM2, this.q).param("obj_id", this.p.f53318i).param("obj_name", i2).param("post_id", this.k.postId).param("nid", this.k.nid);
                b2 b2Var = this.w;
                if (b2Var != null) {
                    param.param("tid", b2Var.d0()).param("nid", this.w.B0()).param("fid", this.w.R()).param("card_type", this.x).param("ab_tag", this.w.V0).param("recom_source", this.w.T0).param("weight", this.w.U0).param("extra", this.w.W0);
                    if (this.w.J() != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM4, this.w.J().oriUgcNid);
                        if (this.w.I1() || this.w.H1()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, this.w.J().oriUgcVid);
                        }
                    }
                    if (this.w.K1()) {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.w.F1() && !this.w.I1()) {
                        int i4 = this.w.Z;
                        if (i4 == 0 || i4 == 40) {
                            param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                        }
                    } else {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                    }
                } else {
                    param.param("tid", this.k.threadId);
                    param.param("nid", this.k.nid);
                    param.param("fid", this.k.forumId);
                    param.param("card_type", this.k.cardType);
                    param.param("ab_tag", this.k.recomAbTag);
                    param.param("recom_source", this.k.recomSource);
                    param.param("weight", this.k.recomWeight);
                    param.param("extra", this.k.recomExtra);
                    BaijiahaoData baijiahaoData2 = this.k.baijiahaoData;
                    if (baijiahaoData2 != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2.oriUgcVid);
                    }
                }
                int i5 = this.A;
                if (i5 == 1 || i5 == 2) {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                    param.param(str, str2);
                } else {
                    if (i5 == 18) {
                        str = TiebaStatic.Params.OBJ_TAB;
                        param.param(str, "a099");
                        param.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                    } else {
                        str = TiebaStatic.Params.OBJ_TAB;
                    }
                    str2 = "a002";
                }
                if (getTbPageContext() != null) {
                    d.a.p0.l0.c.b(getTbPageContext().getPageActivity(), param);
                }
                if (this.k.isFromImageViewer) {
                    param.param(str, "a008");
                    if (this.k.mImageViewerFromPage == "index") {
                        param.param(GuildActivityConfig.FROM_PAGE, str2);
                    }
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        if (StringUtils.isNull(this.v)) {
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.p.f53311b).param("obj_param1", this.p.f53312c).param("obj_source", this.p.f53313d).param("obj_id", this.p.f53314e).param("obj_name", i2).param("post_id", this.k.postId);
            b2 b2Var2 = this.w;
            if (b2Var2 != null) {
                param2.param("tid", b2Var2.d0()).param("nid", this.w.B0()).param("fid", this.w.R()).param("card_type", this.x).param("ab_tag", this.w.V0).param("recom_source", this.w.T0).param("weight", this.w.U0).param("extra", this.w.W0);
                if (this.w.J() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM4, this.w.J().oriUgcNid);
                    if (this.w.I1() || this.w.H1()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, this.w.J().oriUgcVid);
                    }
                }
                if (this.w.K1()) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (!this.w.F1() && !this.w.I1()) {
                    int i6 = this.w.Z;
                    if (i6 == 0 || i6 == 40) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                    }
                } else {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param2.param("tid", this.k.threadId);
                param2.param("nid", this.k.nid);
                param2.param("fid", this.k.forumId);
                param2.param("card_type", this.k.cardType);
                param2.param("ab_tag", this.k.recomAbTag);
                param2.param("recom_source", this.k.recomSource);
                param2.param("weight", this.k.recomWeight);
                param2.param("extra", this.k.recomExtra);
                BaijiahaoData baijiahaoData3 = this.k.baijiahaoData;
                if (baijiahaoData3 != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData3.oriUgcVid);
                }
            }
            if (s(this.p.f53311b) && x(this.p.f53315f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, x(this.p.f53315f));
            }
            int i7 = this.A;
            if (i7 == 1 || i7 == 2) {
                str3 = "a002";
                param2.param(TiebaStatic.Params.OBJ_TAB, str3);
                param2.param(TiebaStatic.Params.RESOURCE_ID, this.q);
            } else {
                if (i7 == 18) {
                    param2.param(TiebaStatic.Params.OBJ_TAB, "a099");
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                } else {
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.q);
                }
                str3 = "a002";
            }
            if (getTbPageContext() != null) {
                d.a.p0.l0.c.b(getTbPageContext().getPageActivity(), param2);
            }
            if (this.k.isFromImageViewer) {
                param2.param(TiebaStatic.Params.OBJ_TAB, "a008");
                str4 = "index";
                if (this.k.mImageViewerFromPage == str4) {
                    param2.param(GuildActivityConfig.FROM_PAGE, str3);
                }
            } else {
                str4 = "index";
            }
            if (str4.equals(this.k.keyFromHomePage)) {
                param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, str3);
                param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
            }
            d.a.p0.k0.c f2 = TbPageExtraHelper.f(this);
            if (f2 != null) {
                param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(param2);
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.k.threadId).param("topic_id", this.v));
        }
        z();
    }

    public final String m(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, agreeData)) == null) {
            long j = agreeData != null ? agreeData.agreeNum : 0L;
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.c_agree);
            }
            if (i2 > 0) {
                return StringHelper.numFormatOverWanNa(j);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j);
        }
        return (String) invokeL.objValue;
    }

    public final String n(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, agreeData)) == null) ? m(agreeData) : (String) invokeL.objValue;
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            setOrientation(0);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            this.f12414g = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.img_agree);
            this.f12414g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f12414g.setOnClickListener(this.K);
            this.f12414g.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.f12415h = textView;
            textView.setTextSize(0, l.g(context, R.dimen.tbfontsize34));
            this.f12415h.setOnClickListener(this.K);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.f12416i = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.img_disagree);
            this.f12416i.addAnimatorListener(this);
            this.f12416i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f12416i.setOnClickListener(this.K);
            TextView textView2 = new TextView(context);
            this.j = textView2;
            textView2.setText(R.string.c_disagree);
            this.j.setTextSize(0, l.g(context, R.dimen.tbfontsize34));
            this.j.setOnClickListener(this.K);
            e eVar = new e();
            this.l = eVar;
            eVar.f58546a = getPageId();
            this.G = new d.a.p0.s.b0.a();
            p();
            setAgreeAnimationResource();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.J);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.J);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.C = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.f12414g);
            linearLayout.addView(this.f12415h);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.B = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f12416i);
            linearLayout2.addView(this.j);
            k(false);
        }
    }

    public final void q(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i2, i3, i4, i5) == null) {
            int i6 = -l.g(getContext(), R.dimen.tbds24);
            int g2 = l.g(getContext(), R.dimen.tbds34);
            this.C.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.C.setLayoutParams(layoutParams);
            this.f12414g.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.f12415h.setLayoutParams(layoutParams2);
            this.B.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.B.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.f12416i.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.j.setLayoutParams(layoutParams5);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f12416i.setVisibility(z ? 8 : 0);
            this.j.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.B) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.D != z && (dVar = this.F) != null) {
                dVar.a(this.f12416i, z);
            }
            this.D = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SkinManager.setLottieAnimation(this.f12414g, this.s);
            SkinManager.setLottieAnimation(this.f12416i, this.t);
            if (this.H) {
                h.f(this.f12414g, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.k = agreeData;
        B();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f12416i.setVisibility(z ? 8 : 0);
            this.j.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.B;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.D = z;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.n = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.o = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.u = i2;
            setTextNormalColor(this.f12415h);
            setTextNormalColor(this.j);
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) {
            this.s = i2;
            this.t = i3;
            setAgreeAnimationResource();
        }
    }

    public void setStatisticData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.r = str;
        }
    }

    public void setThreadData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, b2Var) == null) {
            this.w = b2Var;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.v = str;
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, dVar) == null) {
            this.F = dVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.H = z;
            if (z) {
                h.f(this.f12414g, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            w(this.f12414g);
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || this.k == null || this.f12412e == i2) {
            return;
        }
        this.f12412e = i2;
        SkinManager.setLottieAnimation(this.f12414g, this.s);
        SkinManager.setLottieAnimation(this.f12416i, this.t);
        if (this.H) {
            h.f(this.f12414g, i2);
        }
        B();
    }

    public final void w(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, view) == null) || this.k == null) {
            return;
        }
        if (!this.n || d.a.p0.h0.f.a(getContext())) {
            if (this.n || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f12415h || this.E) {
                    int i2 = 0;
                    if (view.getId() != this.f12414g.getId() && (!this.E || view.getId() != this.f12415h.getId())) {
                        if (view.getId() == this.f12416i.getId()) {
                            this.f12416i.cancelAnimation();
                            f fVar = this.p;
                            if (fVar != null) {
                                fVar.f53310a = 2;
                            }
                            AgreeData agreeData = this.k;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    B();
                                    f fVar2 = this.p;
                                    if (fVar2 != null) {
                                        fVar2.f53318i = 0;
                                    }
                                    i2 = 1;
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    C(false);
                                    f fVar3 = this.p;
                                    if (fVar3 != null) {
                                        fVar3.f53318i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                C(false);
                                f fVar4 = this.p;
                                if (fVar4 != null) {
                                    fVar4.f53318i = 1;
                                }
                            }
                            d.a.p0.k0.c f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                                this.k.objSource = f2.a();
                            }
                            this.G.c(this.k, i2, getPageId(), this.n);
                        }
                    } else {
                        this.f12414g.cancelAnimation();
                        f fVar5 = this.p;
                        if (fVar5 != null) {
                            fVar5.f53310a = 1;
                        }
                        AgreeData agreeData2 = this.k;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                B();
                                f fVar6 = this.p;
                                if (fVar6 != null) {
                                    fVar6.f53314e = 1;
                                }
                                i2 = 1;
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                C(true);
                                d.a.q0.v2.a.g().l(getTbPageContext());
                                f fVar7 = this.p;
                                if (fVar7 != null) {
                                    fVar7.f53314e = 0;
                                }
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            C(true);
                            d.a.q0.v2.a.g().l(getTbPageContext());
                            f fVar8 = this.p;
                            if (fVar8 != null) {
                                fVar8.f53314e = 0;
                            }
                        }
                        d.a.p0.k0.c f3 = TbPageExtraHelper.f(this);
                        if (f3 != null) {
                            this.k.objSource = f3.a();
                        }
                        this.G.c(this.k, i2, getPageId(), this.n);
                    }
                    this.G.d(this.k, this.l);
                    View.OnClickListener onClickListener = this.y;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    l();
                }
            }
        }
    }

    public final void y(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, view) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z() {
        b2 b2Var;
        f fVar;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (b2Var = this.w) == null || (fVar = this.p) == null || !b2Var.N2) {
            return;
        }
        int i8 = fVar.f53311b;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            f fVar2 = this.p;
            if (fVar2.f53311b != 4 || (i7 = fVar2.f53315f) == 2 || i7 == 3) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
                int i9 = this.p.f53311b;
                if (i9 == 1) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (i9 == 2) {
                    statisticItem.addParam("obj_locate", 2);
                } else if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
                if (this.w.t2()) {
                    statisticItem.addParam("obj_type", 3);
                } else if (this.w.s2()) {
                    statisticItem.addParam("obj_type", 2);
                } else {
                    statisticItem.addParam("obj_type", 1);
                }
                statisticItem.addParam("tid", this.w.o1());
                statisticItem.addParam(TiebaStatic.Params.FID_1, this.w.R());
                statisticItem.addParam(TiebaStatic.Params.FID_2, this.p.j);
                int i10 = this.p.f53314e;
                if (i10 == 0) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
                } else if (i10 == 1) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
                }
                TiebaStatic.log(statisticItem);
                int i11 = this.p.f53314e;
                if (i11 == 0) {
                    i3 = d.a.p0.d.a.f52221g;
                } else if (i11 == 1) {
                    i3 = d.a.p0.d.a.f52222h;
                } else {
                    i2 = 0;
                    i4 = this.p.f53311b;
                    if (i4 != 1) {
                        i6 = d.a.p0.d.a.f52215a;
                    } else if (i4 == 2) {
                        i6 = d.a.p0.d.a.f52216b;
                    } else if (s(i4)) {
                        i6 = d.a.p0.d.a.f52217c;
                    } else {
                        i5 = 0;
                        b2 b2Var2 = this.w;
                        d.a.p0.d.a.a(i2, i5, b2Var2.O2, b2Var2.P2, b2Var2.Q2, b2Var2.P1);
                    }
                    i5 = i6;
                    b2 b2Var22 = this.w;
                    d.a.p0.d.a.a(i2, i5, b2Var22.O2, b2Var22.P2, b2Var22.Q2, b2Var22.P1);
                }
                i2 = i3;
                i4 = this.p.f53311b;
                if (i4 != 1) {
                }
                i5 = i6;
                b2 b2Var222 = this.w;
                d.a.p0.d.a.a(i2, i5, b2Var222.O2, b2Var222.P2, b2Var222.Q2, b2Var222.P1);
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
        this.f12412e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.I = new a(this, 2016528);
        this.J = new b(this, 2016530);
        this.K = new c(this);
        o(context);
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
        this.f12412e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.I = new a(this, 2016528);
        this.J = new b(this, 2016530);
        this.K = new c(this);
        o(context);
    }
}
