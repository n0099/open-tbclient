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
import c.a.d.f.p.n;
import c.a.s0.s.j0.h;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.f;
import c.a.t0.w3.j0.e;
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
import com.baidu.tbadk.widget.lottie.TBLazyLottieAnimationView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_AGREE = 1;
    public static final int TYPE_AGREE_AND_DISAGREE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public int B;
    public LinearLayout C;
    public LinearLayout D;
    public boolean E;
    public boolean F;
    public d G;
    public c.a.s0.s.e0.a H;
    public boolean I;
    public CustomMessageListener J;
    public CustomMessageListener K;
    public View.OnClickListener L;

    /* renamed from: e  reason: collision with root package name */
    public int f40287e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f40288f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f40289g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40290h;

    /* renamed from: i  reason: collision with root package name */
    public TBLottieAnimationView f40291i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f40292j;
    public AgreeData k;
    public e l;
    public ScaleAnimation m;
    public View.OnClickListener mAfterManualClickListener;
    public boolean n;
    public boolean o;
    public f p;
    public int q;
    public String r;
    public int s;
    public int t;
    public int u;
    public String v;
    public String w;
    public boolean x;
    public e2 y;
    public int z;

    /* loaded from: classes11.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

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
            this.a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (eVar = (e) customResponsedMessage.getData()) == null || (agreeData = eVar.f24836b) == null || this.a.k == null || agreeData == null || this.a.l == null || this.a.k.isInPost || this.a.l.a == eVar.a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (this.a.k.baijiahaoData == null || !TextUtils.equals(str, this.a.k.baijiahaoData.oriUgcNid)) {
                    return;
                }
                this.a.p(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = this.a.k.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            this.a.p(agreeData);
        }
    }

    /* loaded from: classes11.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeView a;

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
            this.a = agreeView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (eVar = (e) customResponsedMessage.getData()) == null || (agreeData = eVar.f24836b) == null || this.a.k == null || TextUtils.isEmpty(this.a.k.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !this.a.k.postId.equals(agreeData.postId) || this.a.k.isInThread) {
                return;
            }
            if (this.a.n) {
                if (this.a.k.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (this.a.l.a == eVar.a) {
                return;
            }
            this.a.p(agreeData);
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeView f40293e;

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
            this.f40293e = agreeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f40293e.y == null || this.f40293e.y.getType() != e2.Y3) {
                    this.f40293e.m(view);
                    View.OnClickListener onClickListener = this.f40293e.mAfterManualClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    if (this.f40293e.B == 1 || this.f40293e.B == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
        this.f40287e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = false;
        this.z = 1;
        this.E = false;
        this.F = false;
        this.J = new a(this, 2016528);
        this.K = new b(this, 2016530);
        this.L = new c(this);
        j(context);
    }

    public static boolean isLocateFromPb(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? i2 == 4 || i2 == 5 || i2 == 12 : invokeI.booleanValue;
    }

    public static int pbPageFromConvertToStaticParam(int i2) {
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

    private void setTextNormalColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, textView) == null) {
            if (this.o) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            } else if (this.n) {
                textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                textView.setTextColor(SkinManager.getColor(this.u));
            }
        }
    }

    public void adjustLayoutForCardVideoMiddle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds96);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            this.f40289g.setLayoutParams(layoutParams);
            int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            this.f40290h.setPadding(f3, 0, 0, 0);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams2.gravity = 16;
            this.f40291i.setLayoutParams(layoutParams2);
            this.f40292j.setPadding(f3, 0, 0, 0);
        }
    }

    public void adjustLayoutForPbFirstFloor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds120);
            removeAllViews();
            n(this.f40289g);
            n(this.f40291i);
            n(this.f40290h);
            n(this.f40292j);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.topMargin = n.f(getContext(), R.dimen.tbds2);
            layoutParams.weight = 0.5f;
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            linearLayout.addView(this.f40289g, new LinearLayout.LayoutParams(f2, f2));
            this.f40290h.setTextSize(0, n.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = -n.f(getContext(), R.dimen.tbds16);
            linearLayout.addView(this.f40290h, layoutParams2);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
            layoutParams3.topMargin = n.f(getContext(), R.dimen.tbds3);
            layoutParams3.weight = 0.5f;
            linearLayout2.setLayoutParams(layoutParams3);
            addView(linearLayout2);
            this.C = linearLayout2;
            linearLayout2.addView(this.f40291i, new LinearLayout.LayoutParams(f2, f2));
            this.f40292j.setTextSize(0, n.f(getContext(), R.dimen.T_X09));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = -n.f(getContext(), R.dimen.tbds18);
            linearLayout2.addView(this.f40292j, layoutParams4);
        }
    }

    public void adjustLayoutForPbFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds104);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            this.f40289g.setLayoutParams(layoutParams);
            this.f40290h.setTextSize(0, n.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.leftMargin = -n.f(getContext(), R.dimen.tbds24);
                int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
                this.f40290h.setPadding(0, f3, f3 * 3, f3);
                this.F = true;
            } else {
                layoutParams2.leftMargin = -n.f(getContext(), R.dimen.tbds22);
            }
            layoutParams2.gravity = 16;
            this.f40290h.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.gravity = 16;
            if (!z) {
                layoutParams3.leftMargin = n.f(getContext(), R.dimen.tbds28);
            }
            this.f40291i.setLayoutParams(layoutParams3);
            this.f40292j.setVisibility(8);
        }
    }

    public void adjustLayoutForTopicDetail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int f2 = n.f(getContext(), R.dimen.tbds112);
            int f3 = n.f(getContext(), R.dimen.tbds19);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
            layoutParams.gravity = 16;
            layoutParams.rightMargin = -f3;
            layoutParams.topMargin = n.f(getContext(), R.dimen.tbds_2);
            this.f40289g.setLayoutParams(layoutParams);
            this.f40290h.setTextSize(0, n.f(getContext(), R.dimen.tbfontsize34));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.rightMargin = n.f(getContext(), R.dimen.tbds6);
            layoutParams2.topMargin = n.f(getContext(), R.dimen.tbds_2);
            this.f40290h.setLayoutParams(layoutParams2);
            this.f40291i.setVisibility(8);
            this.f40292j.setVisibility(8);
        }
    }

    public void adjustLayoutForWeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                l(n.f(getContext(), R.dimen.tbds126), 0, 1, 17);
                setAgreeAlone(this.E);
                return;
            }
            l(n.f(getContext(), R.dimen.tbds126), -2, 0, 16);
            setAgreeAlone(this.E);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0245  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doStatistic() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        c.a.s0.o0.c f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.p == null || (agreeData = this.k) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i2 = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i3 = this.p.a;
        if (i3 != 1) {
            if (i3 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.p.f13376g).param("obj_locate", this.p.f13377h).param(TiebaStatic.Params.OBJ_PARAM2, this.q).param("obj_id", this.p.f13378i).param("obj_name", i2).param("post_id", this.k.postId).param("nid", this.k.nid);
                e2 e2Var = this.y;
                if (e2Var != null) {
                    param.param("tid", e2Var.g0()).param("nid", this.y.G0()).param("fid", this.y.U()).param("card_type", this.z).param("ab_tag", this.y.b1).param("recom_source", this.y.Z0).param("weight", this.y.a1).param("extra", this.y.c1);
                    if (this.y.L() != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM4, this.y.L().oriUgcNid);
                        if (this.y.S1() || this.y.R1()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, this.y.L().oriUgcVid);
                        }
                    }
                    if (this.y.U1()) {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.y.P1() && !this.y.S1()) {
                        int i4 = this.y.d0;
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
                int i5 = this.B;
                if (i5 == 1) {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                } else if (i5 != 2) {
                    if (i5 == 18) {
                        str = TiebaStatic.Params.OBJ_TAB;
                        param.param(str, "a099");
                        param.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                    } else {
                        str = TiebaStatic.Params.OBJ_TAB;
                    }
                    str2 = "a002";
                    if (getTbPageContext() != null) {
                        c.a.s0.p0.c.b(getTbPageContext().getPageActivity(), param);
                    }
                    if (this.k.isFromImageViewer) {
                        param.param(str, "a008");
                        if (this.k.mImageViewerFromPage == "index") {
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
                if (this.k.isFromImageViewer) {
                }
                TiebaStatic.log(param);
                return;
            }
            return;
        }
        if (StringUtils.isNull(this.v)) {
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.p.f13371b).param("obj_param1", this.p.f13372c).param("obj_source", this.p.f13373d).param("obj_id", this.p.f13374e).param("obj_name", i2).param("post_id", this.k.postId);
            e2 e2Var2 = this.y;
            if (e2Var2 != null) {
                param2.param("tid", e2Var2.g0()).param("nid", this.y.G0()).param("fid", this.y.U()).param("card_type", this.z).param("ab_tag", this.y.b1).param("recom_source", this.y.Z0).param("weight", this.y.a1).param("thread_type", this.y.d0).param("extra", this.y.c1);
                if (this.y.L() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM4, this.y.L().oriUgcNid);
                    if (this.y.S1() || this.y.R1()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, this.y.L().oriUgcVid);
                    }
                }
                if (this.y.U1()) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (!this.y.P1() && !this.y.S1()) {
                    int i6 = this.y.d0;
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
            if (isLocateFromPb(this.p.f13371b) && pbPageFromConvertToStaticParam(this.p.f13375f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, pbPageFromConvertToStaticParam(this.p.f13375f));
            }
            int i7 = this.B;
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
                    str4 = TiebaStatic.Params.OBJ_TAB;
                    param2.param(str4, "a099");
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                } else {
                    str4 = TiebaStatic.Params.OBJ_TAB;
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.q);
                }
                str5 = "a002";
                if (getTbPageContext() != null) {
                    c.a.s0.p0.c.b(getTbPageContext().getPageActivity(), param2);
                }
                if (this.k.isFromImageViewer) {
                    str6 = "index";
                } else {
                    param2.param(str4, "a008");
                    str6 = "index";
                    if (this.k.mImageViewerFromPage == str6) {
                        param2.param(GuildActivityConfig.FROM_PAGE, str5);
                    }
                }
                if (str6.equals(this.k.keyFromHomePage)) {
                    param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, str5);
                    param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                }
                f2 = TbPageExtraHelper.f(this);
                if (f2 != null) {
                    param2.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(param2);
            }
            param2.param(str4, str5);
            param2.param(str3, this.q);
            if (getTbPageContext() != null) {
            }
            if (this.k.isFromImageViewer) {
            }
            if (str6.equals(this.k.keyFromHomePage)) {
            }
            f2 = TbPageExtraHelper.f(this);
            if (f2 != null) {
            }
            if (TbPageExtraHelper.m() != null) {
            }
            TiebaStatic.log(param2);
        } else if (this.p.f13371b == 4 && this.x) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_TO_PB_AGREE_CLICK).param("tid", this.k.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.TOPIC_TYPE, this.w).param("topic_id", this.v));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_TOPIC_DETAIL_CARD_AGREE_CLICK).param("tid", this.k.threadId).param("topic_id", this.v));
        }
        o();
    }

    public TextView getAgreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40290h : (TextView) invokeV.objValue;
    }

    public AgreeData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (AgreeData) invokeV.objValue;
    }

    public TextView getDisagreeNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40292j : (TextView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40289g : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f40291i : (TBLottieAnimationView) invokeV.objValue;
    }

    public BdUniqueId getPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f40288f == null) {
                Context context = getContext();
                if (context instanceof BaseActivity) {
                    this.f40288f = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.f40288f = ((BaseFragmentActivity) context).getPageContext();
                }
            }
            return this.f40288f;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f40289g : (TBLottieAnimationView) invokeV.objValue;
    }

    public TBLottieAnimationView getmImgDisagree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f40291i : (TBLottieAnimationView) invokeV.objValue;
    }

    public final String h(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, agreeData)) == null) {
            long j2 = agreeData != null ? agreeData.agreeNum : 0L;
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 == 0) {
                return getContext().getString(R.string.c_agree);
            }
            if (i2 > 0) {
                return StringHelper.numFormatOverWanNa(j2);
            }
            return "-" + StringHelper.numFormatOverWanNa(-j2);
        }
        return (String) invokeL.objValue;
    }

    public final String i(AgreeData agreeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, agreeData)) == null) ? h(agreeData) : (String) invokeL.objValue;
    }

    public boolean isAgreeAlone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public void isUseHomePageStyleAb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.I = z;
            if (z) {
                h.f(this.f40289g, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            setOrientation(0);
            TBLazyLottieAnimationView tBLazyLottieAnimationView = new TBLazyLottieAnimationView(context);
            this.f40289g = tBLazyLottieAnimationView;
            tBLazyLottieAnimationView.setId(R.id.img_agree);
            this.f40289g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f40289g.setOnClickListener(this.L);
            this.f40289g.addAnimatorListener(this);
            TextView textView = new TextView(context);
            this.f40290h = textView;
            textView.setTextSize(0, n.f(context, R.dimen.tbfontsize34));
            this.f40290h.setOnClickListener(this.L);
            TBLazyLottieAnimationView tBLazyLottieAnimationView2 = new TBLazyLottieAnimationView(context);
            this.f40291i = tBLazyLottieAnimationView2;
            tBLazyLottieAnimationView2.setId(R.id.img_disagree);
            this.f40291i.addAnimatorListener(this);
            this.f40291i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f40291i.setOnClickListener(this.L);
            TextView textView2 = new TextView(context);
            this.f40292j = textView2;
            textView2.setText(R.string.c_disagree);
            this.f40292j.setTextSize(0, n.f(context, R.dimen.tbfontsize34));
            this.f40292j.setOnClickListener(this.L);
            e eVar = new e();
            this.l = eVar;
            eVar.a = getPageId();
            this.H = new c.a.s0.s.e0.a();
            k();
            setAgreeAnimationResource();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.D = linearLayout;
            linearLayout.setOrientation(0);
            addView(linearLayout);
            linearLayout.addView(this.f40289g);
            linearLayout.addView(this.f40290h);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.C = linearLayout2;
            linearLayout2.setOrientation(0);
            addView(linearLayout2);
            linearLayout2.addView(this.f40291i);
            linearLayout2.addView(this.f40292j);
            adjustLayoutForWeight(false);
        }
    }

    public final void l(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048598, this, i2, i3, i4, i5) == null) {
            int i6 = -n.f(getContext(), R.dimen.tbds24);
            int f2 = n.f(getContext(), R.dimen.tbds34);
            this.D.setGravity(i5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -1);
            float f3 = i4;
            layoutParams.weight = f3;
            this.D.setLayoutParams(layoutParams);
            this.f40289g.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = i6;
            this.f40290h.setLayoutParams(layoutParams2);
            this.C.setGravity(i5);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, -1);
            layoutParams3.weight = f3;
            this.C.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams4.leftMargin = f2;
            this.f40291i.setLayoutParams(layoutParams4);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 16;
            layoutParams5.leftMargin = i6;
            this.f40292j.setLayoutParams(layoutParams5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(View view) {
        c.a.s0.o0.c f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, view) == null) || this.k == null || view == null) {
            return;
        }
        if (!this.n || c.a.s0.k0.f.a(getContext())) {
            if (this.n || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f40290h || this.F) {
                    int i2 = 0;
                    int i3 = 1;
                    if (view.getId() != this.f40289g.getId() && (!this.F || view.getId() != this.f40290h.getId())) {
                        if (view.getId() == this.f40291i.getId()) {
                            this.f40291i.cancelAnimation();
                            f fVar = this.p;
                            if (fVar != null) {
                                fVar.a = 2;
                            }
                            AgreeData agreeData = this.k;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    updateUI();
                                    f fVar2 = this.p;
                                    if (fVar2 != null) {
                                        fVar2.f13378i = 0;
                                    }
                                    this.x = false;
                                    f2 = TbPageExtraHelper.f(this);
                                    if (f2 != null) {
                                        this.k.objSource = f2.a();
                                    }
                                    this.H.c(this.k, i3, getPageId(), this.n);
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    updateUiWithAnimation(false);
                                    f fVar3 = this.p;
                                    if (fVar3 != null) {
                                        fVar3.f13378i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                updateUiWithAnimation(false);
                                f fVar4 = this.p;
                                if (fVar4 != null) {
                                    fVar4.f13378i = 1;
                                }
                            }
                            i3 = 0;
                            this.x = false;
                            f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                            }
                            this.H.c(this.k, i3, getPageId(), this.n);
                        }
                    } else {
                        this.f40289g.cancelAnimation();
                        f fVar5 = this.p;
                        if (fVar5 != null) {
                            fVar5.a = 1;
                        }
                        AgreeData agreeData2 = this.k;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                this.x = false;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                updateUI();
                                f fVar6 = this.p;
                                if (fVar6 != null) {
                                    fVar6.f13374e = 1;
                                }
                                i2 = 1;
                            } else {
                                this.x = true;
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                updateUiWithAnimation(true);
                                c.a.t0.i3.a.g().l(getTbPageContext());
                                f fVar7 = this.p;
                                if (fVar7 != null) {
                                    fVar7.f13374e = 0;
                                }
                            }
                        } else {
                            this.x = true;
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            updateUiWithAnimation(true);
                            c.a.t0.i3.a.g().l(getTbPageContext());
                            f fVar8 = this.p;
                            if (fVar8 != null) {
                                fVar8.f13374e = 0;
                            }
                        }
                        c.a.s0.o0.c f3 = TbPageExtraHelper.f(this);
                        if (f3 != null) {
                            this.k.objSource = f3.a();
                        }
                        this.H.c(this.k, i2, getPageId(), this.n);
                    }
                    this.H.d(this.k, this.l);
                    View.OnClickListener onClickListener = this.A;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                    doStatistic();
                }
            }
        }
    }

    public final void n(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, view) == null) && view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o() {
        e2 e2Var;
        f fVar;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (e2Var = this.y) == null || (fVar = this.p) == null || !e2Var.U2) {
            return;
        }
        int i8 = fVar.f13371b;
        if (i8 == 1 || i8 == 2 || i8 == 10 || i8 == 25 || i8 == 4) {
            f fVar2 = this.p;
            if (fVar2.f13371b != 4 || (i7 = fVar2.f13375f) == 2 || i7 == 3) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_AGREE);
                int i9 = this.p.f13371b;
                if (i9 == 1) {
                    statisticItem.addParam("obj_locate", 1);
                } else if (i9 == 2 || i9 == 25 || i9 == 10) {
                    int i10 = this.y.b3;
                    if (i10 != 2) {
                        statisticItem.addParam("obj_locate", i10 + 1);
                    } else {
                        statisticItem.addParam("obj_locate", 2);
                    }
                } else if (i9 == 4) {
                    statisticItem.addParam("obj_locate", 3);
                }
                if (this.y.I2()) {
                    statisticItem.addParam("obj_type", 3);
                } else if (this.y.H2()) {
                    statisticItem.addParam("obj_type", 2);
                } else {
                    statisticItem.addParam("obj_type", 1);
                }
                statisticItem.addParam("tid", this.y.v1());
                statisticItem.addParam(TiebaStatic.Params.FID_1, this.y.U());
                statisticItem.addParam(TiebaStatic.Params.FID_2, this.p.f13379j);
                int i11 = this.p.f13374e;
                if (i11 == 0) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 1);
                } else if (i11 == 1) {
                    statisticItem.addParam(TiebaStatic.Params.LIKE_TYPE, 2);
                }
                TiebaStatic.log(statisticItem);
                int i12 = this.p.f13374e;
                if (i12 == 0) {
                    i3 = c.a.s0.d.a.f12282g;
                } else if (i12 == 1) {
                    i3 = c.a.s0.d.a.f12285j;
                } else {
                    i2 = 0;
                    i4 = this.p.f13371b;
                    if (i4 != 1) {
                        i6 = c.a.s0.d.a.a;
                    } else if (i4 == 2) {
                        i6 = c.a.s0.d.a.f12277b;
                    } else if (isLocateFromPb(i4)) {
                        i6 = c.a.s0.d.a.f12278c;
                    } else {
                        i5 = 0;
                        e2 e2Var2 = this.y;
                        c.a.s0.d.a.a(i2, i5, e2Var2.V2, e2Var2.W2, e2Var2.X2, e2Var2.T1);
                    }
                    i5 = i6;
                    e2 e2Var22 = this.y;
                    c.a.s0.d.a.a(i2, i5, e2Var22.V2, e2Var22.W2, e2Var22.X2, e2Var22.T1);
                }
                i2 = i3;
                i4 = this.p.f13371b;
                if (i4 != 1) {
                }
                i5 = i6;
                e2 e2Var222 = this.y;
                c.a.s0.d.a.a(i2, i5, e2Var222.V2, e2Var222.W2, e2Var222.X2, e2Var222.T1);
            }
        }
    }

    public void onAgreeClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            m(this.f40289g);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, animator) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.J);
            MessageManager.getInstance().registerListener(this.K);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || this.k == null || this.f40287e == i2) {
            return;
        }
        this.f40287e = i2;
        SkinManager.setLottieAnimation(this.f40289g, this.s);
        SkinManager.setLottieAnimation(this.f40291i, this.t);
        if (this.I) {
            h.f(this.f40289g, i2);
        }
        updateUI();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.K);
        }
    }

    public final void p(AgreeData agreeData) {
        AgreeData agreeData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, agreeData) == null) || agreeData == null || (agreeData2 = this.k) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        updateUI();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f40291i.setVisibility(z ? 8 : 0);
            this.f40292j.setVisibility(z ? 8 : 0);
            if (z && (linearLayout = this.C) != null) {
                linearLayout.setVisibility(8);
            }
            if (this.E != z && (dVar = this.G) != null) {
                dVar.a(this.f40291i, z);
            }
            this.E = z;
        }
    }

    public void setAgreeAnimationResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            SkinManager.setLottieAnimation(this.f40289g, this.s);
            SkinManager.setLottieAnimation(this.f40291i, this.t);
            if (this.I) {
                h.f(this.f40289g, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void setCardType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setData(AgreeData agreeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, agreeData) == null) || agreeData == null) {
            return;
        }
        this.k = agreeData;
        updateUI();
    }

    public void setDisagreeShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.f40291i.setVisibility(z ? 8 : 0);
            this.f40292j.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout = this.C;
            if (linearLayout != null) {
                linearLayout.setVisibility(z ? 8 : 0);
            }
            this.E = z;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.B = i2;
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setIsFromBigpic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.n = z;
        }
    }

    public void setIsFromMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.o = z;
        }
    }

    public void setNormalColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.u = i2;
            setTextNormalColor(this.f40290h);
            setTextNormalColor(this.f40292j);
        }
    }

    public void setResourceId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048622, this, i2, i3) == null) {
            this.s = i2;
            this.t = i3;
            setAgreeAnimationResource();
        }
    }

    public void setStatisticData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.r = str;
        }
    }

    public void setThreadData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, e2Var) == null) {
            this.y = e2Var;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.v = str;
        }
    }

    public void setTopicSubjectName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.w = str;
        }
    }

    public void setVisibilityListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, dVar) == null) {
            this.G = dVar;
        }
    }

    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            String i2 = i(this.k);
            if (this.k == null) {
                return;
            }
            this.f40290h.setText(i2);
            this.f40289g.cancelAnimation();
            AgreeData agreeData = this.k;
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    this.f40291i.setProgress(0.0f);
                    this.f40289g.setProgress(1.0f);
                    this.f40290h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    setTextNormalColor(this.f40292j);
                } else {
                    this.f40289g.setProgress(0.0f);
                    this.f40291i.setProgress(1.0f);
                    setTextNormalColor(this.f40290h);
                    this.f40292j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
            } else {
                this.f40289g.setProgress(0.0f);
                this.f40291i.setProgress(0.0f);
                setTextNormalColor(this.f40290h);
                setTextNormalColor(this.f40292j);
                if (this.I) {
                    h.c(this.f40290h);
                }
            }
            if (this.I) {
                h.d(this.f40290h);
            }
        }
    }

    public void updateUiWithAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || this.k == null) {
            return;
        }
        this.f40289g.setMinAndMaxProgress(0.0f, 1.0f);
        this.f40291i.setMinAndMaxProgress(0.0f, 1.0f);
        this.f40290h.setText(i(this.k));
        this.f40289g.clearColorFilter();
        this.f40291i.clearColorFilter();
        if (z) {
            this.f40289g.playAnimation();
            this.f40291i.cancelAnimation();
            this.f40291i.setFrame(0);
        } else {
            this.f40291i.playAnimation();
            this.f40289g.cancelAnimation();
            this.f40289g.setFrame(0);
        }
        AgreeData agreeData = this.k;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.f40290h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.f40292j);
            } else {
                setTextNormalColor(this.f40290h);
                this.f40292j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                if (this.I) {
                    h.c(this.f40290h);
                }
            }
        } else {
            setTextNormalColor(this.f40290h);
            setTextNormalColor(this.f40292j);
            if (this.I) {
                h.c(this.f40290h);
            }
        }
        if (this.I) {
            h.d(this.f40290h);
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
        this.f40287e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = false;
        this.z = 1;
        this.E = false;
        this.F = false;
        this.J = new a(this, 2016528);
        this.K = new b(this, 2016530);
        this.L = new c(this);
        j(context);
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
        this.f40287e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = false;
        this.z = 1;
        this.E = false;
        this.F = false;
        this.J = new a(this, 2016528);
        this.K = new b(this, 2016530);
        this.L = new c(this);
        j(context);
    }
}
