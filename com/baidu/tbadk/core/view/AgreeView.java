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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
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
import d.a.c.e.p.l;
import d.a.o0.r.f0.h;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.f;
import d.a.p0.h3.h0.e;
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
    public d.a.o0.r.b0.a G;
    public boolean H;
    public CustomMessageListener I;
    public CustomMessageListener J;
    public View.OnClickListener K;

    /* renamed from: e  reason: collision with root package name */
    public int f12382e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f12383f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f12384g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12385h;

    /* renamed from: i  reason: collision with root package name */
    public TBLottieAnimationView f12386i;
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
        public final /* synthetic */ AgreeView f12387a;

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
            this.f12387a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f57972b;
                if (this.f12387a.k == null || agreeData == null || this.f12387a.l == null || this.f12387a.k.isInPost || this.f12387a.l.f57971a == eVar.f57971a) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (this.f12387a.k.baijiahaoData == null || !TextUtils.equals(str, this.f12387a.k.baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f12387a.y(agreeData);
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f12387a.k.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f12387a.y(agreeData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AgreeView f12388a;

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
            this.f12388a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                AgreeData agreeData = eVar.f57972b;
                if (this.f12388a.k == null || TextUtils.isEmpty(this.f12388a.k.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.f12388a.k.postId.equals(agreeData.postId) || this.f12388a.k.isInThread) {
                    return;
                }
                if (this.f12388a.n) {
                    if (this.f12388a.k.indexOfPic == agreeData.indexOfPic) {
                        return;
                    }
                } else if (this.f12388a.l.f57971a == eVar.f57971a) {
                    return;
                }
                this.f12388a.y(agreeData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeView f12389e;

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
            this.f12389e = agreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f12389e.w == null || this.f12389e.w.getType() != b2.E3) {
                    this.f12389e.v(view);
                    View.OnClickListener onClickListener = this.f12389e.z;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
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
        this.f12382e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.I = new a(this, 2016528);
        this.J = new b(this, 2016530);
        this.K = new c(this);
        n(context);
    }

    public static boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, textView) == null) {
            if (this.o) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.n) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.u));
            }
        }
    }

    public static int w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 == 2) {
                return 1;
            }
            return i2 == 3 ? 2 : -1;
        }
        return invokeI.intValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f12384g.setMinAndMaxProgress(0.0f, 1.0f);
            this.f12386i.setMinAndMaxProgress(0.0f, 1.0f);
            this.f12385h.setText(m(this.k));
            this.f12384g.clearColorFilter();
            this.f12386i.clearColorFilter();
            if (z) {
                this.f12384g.playAnimation();
                this.f12386i.cancelAnimation();
                this.f12386i.setFrame(0);
            } else {
                this.f12386i.playAnimation();
                this.f12384g.cancelAnimation();
                this.f12384g.setFrame(0);
            }
            AgreeData agreeData = this.k;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f12385h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.j);
                } else {
                    setTextNormalColor(this.f12385h);
                    this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                    if (this.H) {
                        h.c(this.f12385h);
                    }
                }
            } else {
                setTextNormalColor(this.f12385h);
                setTextNormalColor(this.j);
                if (this.H) {
                    h.c(this.f12385h);
                }
            }
            if (this.H) {
                h.d(this.f12385h);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds120);
            removeAllViews();
            x(this.f12384g);
            x(this.f12386i);
            x(this.f12385h);
            x(this.j);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = l.g(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.addView(this.f12384g, new LinearLayout.LayoutParams(g2, g2));
            this.f12385h.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -l.g(getContext(), R.dimen.tbds16);
            linearLayout.addView(this.f12385h, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = l.g(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            this.B = linearLayout2;
            linearLayout2.addView(this.f12386i, new LinearLayout.LayoutParams(g2, g2));
            this.j.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -l.g(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.j, layoutParams4);
        }
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12385h : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12384g : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12386i : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f12383f == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f12383f = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f12383f = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f12383f;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12384g : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12386i : (TBLottieAnimationView) invokeV.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            this.f12384g.setLayoutParams(layoutParams);
            this.f12385h.setTextSize(0, l.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -l.g(getContext(), R.dimen.tbds24);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.f12385h.setPadding(0, g3, g3 * 3, g3);
                this.E = true;
            } else {
                layoutParams2.leftMargin = -l.g(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.f12385h.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = l.g(getContext(), R.dimen.tbds28);
            }
            this.f12386i.setLayoutParams(layoutParams3);
            this.j.setVisibility(8);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds112);
            int g3 = l.g(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -g3;
            layoutParams.topMargin = l.g(getContext(), R.dimen.tbds_2);
            this.f12384g.setLayoutParams(layoutParams);
            this.f12385h.setTextSize(0, l.g(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = l.g(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = l.g(getContext(), R.dimen.tbds_2);
            this.f12385h.setLayoutParams(layoutParams2);
            this.f12386i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                p(l.g(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.D);
                return;
            }
            p(l.g(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.D);
        }
    }

    public void k() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.p == null || (agreeData = this.k) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i2 = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i3 = this.p.f52646a;
        if (i3 != 1) {
            if (i3 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.p.f52652g).param("obj_locate", this.p.f52653h).param(TiebaStatic.Params.OBJ_PARAM2, this.q).param("obj_id", this.p.f52654i).param("obj_name", i2).param("post_id", this.k.postId).param("nid", this.k.nid);
                b2 b2Var = this.w;
                if (b2Var != null) {
                    param.param("tid", b2Var.c0()).param("nid", this.w.A0()).param("fid", this.w.Q()).param("card_type", this.x).param("ab_tag", this.w.V0).param("recom_source", this.w.T0).param("weight", this.w.U0).param("extra", this.w.W0);
                    if (this.w.J() != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM4, this.w.J().oriUgcNid);
                        if (this.w.H1() || this.w.G1()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, this.w.J().oriUgcVid);
                        }
                    }
                    if (this.w.J1()) {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.w.E1() && !this.w.H1()) {
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
                    d.a.o0.j0.c.b(getTbPageContext().getPageActivity(), param);
                }
                if (this.k.isFromImageViewer) {
                    param.param(str, "a008");
                    if (this.k.mImageViewerFromPage == "index") {
                        param.param(GuildActivityConfig.FROM_PAGE, str2);
                    }
                }
                TiebaStatic.log(param);
            }
        } else if (StringUtils.isNull(this.v)) {
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.p.f52647b).param("obj_param1", this.p.f52648c).param("obj_source", this.p.f52649d).param("obj_id", this.p.f52650e).param("obj_name", i2).param("post_id", this.k.postId);
            b2 b2Var2 = this.w;
            if (b2Var2 != null) {
                param2.param("tid", b2Var2.c0()).param("nid", this.w.A0()).param("fid", this.w.Q()).param("card_type", this.x).param("ab_tag", this.w.V0).param("recom_source", this.w.T0).param("weight", this.w.U0).param("extra", this.w.W0);
                if (this.w.J() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM4, this.w.J().oriUgcNid);
                    if (this.w.H1() || this.w.G1()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, this.w.J().oriUgcVid);
                    }
                }
                if (this.w.J1()) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (!this.w.E1() && !this.w.H1()) {
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
            if (r(this.p.f52647b) && w(this.p.f52651f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, w(this.p.f52651f));
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
                d.a.o0.j0.c.b(getTbPageContext().getPageActivity(), param2);
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
            d.a.o0.i0.c f2 = TbPageExtraHelper.f(this);
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
    }

    public final String l(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, agreeData)) == null) {
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

    public final String m(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, agreeData)) == null) ? l(agreeData) : (String) invokeL.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            setOrientation(0);
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
            this.f12384g = tBLottieAnimationView;
            tBLottieAnimationView.setId(R.id.img_agree);
            this.f12384g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f12384g.setOnClickListener(this.K);
            this.f12384g.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.f12385h = textView;
            textView.setTextSize(0, l.g(context, R.dimen.tbfontsize34));
            this.f12385h.setOnClickListener(this.K);
            TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
            this.f12386i = tBLottieAnimationView2;
            tBLottieAnimationView2.setId(R.id.img_disagree);
            this.f12386i.addAnimatorListener(this);
            this.f12386i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f12386i.setOnClickListener(this.K);
            TextView textView2 = new TextView(context);
            this.j = textView2;
            textView2.setText(R.string.c_disagree);
            this.j.setTextSize(0, l.g(context, R.dimen.tbfontsize34));
            this.j.setOnClickListener(this.K);
            e eVar = new e();
            this.l = eVar;
            eVar.f57971a = getPageId();
            this.G = new d.a.o0.r.b0.a();
            o();
            setAgreeAnimationResource();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.C = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.f12384g);
            linearLayout.addView(this.f12385h);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.B = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f12386i);
            linearLayout2.addView(this.j);
            j(false);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.I);
            MessageManager.getInstance().registerListener(this.J);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.J);
        }
    }

    public final void p(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i2, i3, i4, i5) == null) {
            int i6 = -l.g(getContext(), R.dimen.tbds24);
            int g2 = l.g(getContext(), R.dimen.tbds34);
            this.C.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f2 = i4;
            layoutParams.weight = f2;
            this.C.setLayoutParams(layoutParams);
            this.f12384g.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.f12385h.setLayoutParams(layoutParams2);
            this.B.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f2;
            this.B.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = g2;
            this.f12386i.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.j.setLayoutParams(layoutParams5);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.H = z;
            if (z) {
                h.f(this.f12384g, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f12386i.setVisibility(z ? 8 : 0);
            this.j.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.B) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.D != z && (dVar = this.F) != null) {
                dVar.a(this.f12386i, z);
            }
            this.D = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SkinManager.setLottieAnimation(this.f12384g, this.s);
            SkinManager.setLottieAnimation(this.f12386i, this.t);
            if (this.H) {
                h.f(this.f12384g, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.k = agreeData;
        z();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f12386i.setVisibility(z ? 8 : 0);
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
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.n = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.o = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.u = i2;
            setTextNormalColor(this.f12385h);
            setTextNormalColor(this.j);
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048616, this, i2, i3) == null) {
            this.s = i2;
            this.t = i3;
            setAgreeAnimationResource();
        }
    }

    public void setStatisticData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.r = str;
        }
    }

    public void setThreadData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, b2Var) == null) {
            this.w = b2Var;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.v = str;
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, dVar) == null) {
            this.F = dVar;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            v(this.f12384g);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048623, this, i2) == null) || this.k == null || this.f12382e == i2) {
            return;
        }
        this.f12382e = i2;
        SkinManager.setLottieAnimation(this.f12384g, this.s);
        SkinManager.setLottieAnimation(this.f12386i, this.t);
        if (this.H) {
            h.f(this.f12384g, i2);
        }
        z();
    }

    public final void v(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, view) == null) || this.k == null) {
            return;
        }
        if (!this.n || d.a.o0.f0.f.a(getContext())) {
            if (this.n || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f12385h || this.E) {
                    int i2 = 0;
                    if (view.getId() != this.f12384g.getId() && (!this.E || view.getId() != this.f12385h.getId())) {
                        if (view.getId() == this.f12386i.getId()) {
                            this.f12386i.cancelAnimation();
                            f fVar = this.p;
                            if (fVar != null) {
                                fVar.f52646a = 2;
                            }
                            AgreeData agreeData = this.k;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    z();
                                    f fVar2 = this.p;
                                    if (fVar2 != null) {
                                        fVar2.f52654i = 0;
                                    }
                                    i2 = 1;
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    A(false);
                                    f fVar3 = this.p;
                                    if (fVar3 != null) {
                                        fVar3.f52654i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                A(false);
                                f fVar4 = this.p;
                                if (fVar4 != null) {
                                    fVar4.f52654i = 1;
                                }
                            }
                            d.a.o0.i0.c f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                                this.k.objSource = f2.a();
                            }
                            this.G.c(this.k, i2, getPageId(), this.n);
                        }
                    } else {
                        this.f12384g.cancelAnimation();
                        f fVar5 = this.p;
                        if (fVar5 != null) {
                            fVar5.f52646a = 1;
                        }
                        AgreeData agreeData2 = this.k;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                z();
                                f fVar6 = this.p;
                                if (fVar6 != null) {
                                    fVar6.f52650e = 1;
                                }
                                i2 = 1;
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                A(true);
                                d.a.p0.v2.a.g().l(getTbPageContext());
                                f fVar7 = this.p;
                                if (fVar7 != null) {
                                    fVar7.f52650e = 0;
                                }
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            A(true);
                            d.a.p0.v2.a.g().l(getTbPageContext());
                            f fVar8 = this.p;
                            if (fVar8 != null) {
                                fVar8.f52650e = 0;
                            }
                        }
                        d.a.o0.i0.c f3 = TbPageExtraHelper.f(this);
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
                    k();
                }
            }
        }
    }

    public final void x(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, view) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public final void y(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, agreeData) == null) || agreeData == null || (agreeData2 = this.k) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        z();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.f12385h.setText(m(this.k));
            this.f12384g.cancelAnimation();
            AgreeData agreeData = this.k;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f12386i.setProgress(0.0f);
                    this.f12384g.setProgress(1.0f);
                    this.f12385h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.j);
                } else {
                    this.f12384g.setProgress(0.0f);
                    this.f12386i.setProgress(1.0f);
                    setTextNormalColor(this.f12385h);
                    this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
            } else {
                this.f12384g.setProgress(0.0f);
                this.f12386i.setProgress(0.0f);
                setTextNormalColor(this.f12385h);
                setTextNormalColor(this.j);
                if (this.H) {
                    h.c(this.f12385h);
                }
            }
            if (this.H) {
                h.d(this.f12385h);
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
        this.f12382e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.I = new a(this, 2016528);
        this.J = new b(this, 2016530);
        this.K = new c(this);
        n(context);
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
        this.f12382e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.I = new a(this, 2016528);
        this.J = new b(this, 2016530);
        this.K = new c(this);
        n(context);
    }
}
