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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.b.b.e.p.l;
import d.b.h0.f0.f;
import d.b.h0.r.q.a2;
import d.b.i0.c3.h0.e;
/* loaded from: classes3.dex */
public class AgreeView extends LinearLayout implements Animator.AnimatorListener {
    public int A;
    public LinearLayout B;
    public LinearLayout C;
    public boolean D;
    public boolean E;
    public d F;
    public d.b.h0.r.b0.a G;
    public CustomMessageListener H;
    public CustomMessageListener I;
    public View.OnClickListener J;

    /* renamed from: e  reason: collision with root package name */
    public int f13328e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f13329f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f13330g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13331h;
    public TBLottieAnimationView i;
    public TextView j;
    public AgreeData k;
    public e l;
    public ScaleAnimation m;
    public boolean n;
    public boolean o;
    public d.b.h0.r.q.e p;
    public int q;
    public String r;
    public int s;
    public int t;
    public int u;
    public String v;
    public a2 w;
    public int x;
    public View.OnClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            AgreeData agreeData = eVar.f53377b;
            if (AgreeView.this.k == null || agreeData == null || AgreeView.this.l == null || AgreeView.this.k.isInPost || AgreeView.this.l.f53376a == eVar.f53376a) {
                return;
            }
            String str = agreeData.nid;
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (AgreeView.this.k.baijiahaoData == null || !TextUtils.equals(str, AgreeView.this.k.baijiahaoData.oriUgcNid)) {
                    return;
                }
                AgreeView.this.x(agreeData);
                return;
            }
            String str2 = agreeData.threadId;
            String str3 = AgreeView.this.k.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
            AgreeView.this.x(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e)) {
                return;
            }
            e eVar = (e) customResponsedMessage.getData();
            AgreeData agreeData = eVar.f53377b;
            if (AgreeView.this.k == null || TextUtils.isEmpty(AgreeView.this.k.postId) || agreeData == null || TextUtils.isEmpty(agreeData.postId) || !AgreeView.this.k.postId.equals(agreeData.postId) || AgreeView.this.k.isInThread) {
                return;
            }
            if (AgreeView.this.n) {
                if (AgreeView.this.k.indexOfPic == agreeData.indexOfPic) {
                    return;
                }
            } else if (AgreeView.this.l.f53376a == eVar.f53376a) {
                return;
            }
            AgreeView.this.x(agreeData);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AgreeView.this.w == null || AgreeView.this.w.getType() != a2.x3) {
                AgreeView.this.u(view);
                View.OnClickListener onClickListener = AgreeView.this.z;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(View view, boolean z);
    }

    public AgreeView(Context context) {
        super(context);
        this.f13328e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.H = new a(2016528);
        this.I = new b(2016530);
        this.J = new c();
        n(context);
    }

    public static boolean r(int i) {
        return i == 4 || i == 5 || i == 12;
    }

    private void setTextNormalColor(TextView textView) {
        if (this.o) {
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
        } else if (this.n) {
            textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            textView.setTextColor(SkinManager.getColor(this.u));
        }
    }

    public static int v(int i) {
        if (i == 2) {
            return 1;
        }
        return i == 3 ? 2 : -1;
    }

    public void g() {
        int g2 = l.g(getContext(), R.dimen.tbds120);
        removeAllViews();
        w(this.f13330g);
        w(this.i);
        w(this.f13331h);
        w(this.j);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.tbds2);
        layoutParams.weight = 0.5f;
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        linearLayout.addView(this.f13330g, new LinearLayout.LayoutParams(g2, g2));
        this.f13331h.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = -l.g(getContext(), R.dimen.tbds16);
        linearLayout.addView(this.f13331h, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.topMargin = l.g(getContext(), R.dimen.tbds3);
        layoutParams3.weight = 0.5f;
        linearLayout2.setLayoutParams(layoutParams3);
        addView(linearLayout2);
        this.B = linearLayout2;
        linearLayout2.addView(this.i, new LinearLayout.LayoutParams(g2, g2));
        this.j.setTextSize(0, l.g(getContext(), R.dimen.T_X09));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = -l.g(getContext(), R.dimen.tbds18);
        linearLayout2.addView(this.j, layoutParams4);
    }

    public TextView getAgreeNumView() {
        return this.f13331h;
    }

    public AgreeData getData() {
        return this.k;
    }

    public TextView getDisagreeNumView() {
        return this.j;
    }

    public TBLottieAnimationView getImgAgree() {
        return this.f13330g;
    }

    public TBLottieAnimationView getImgDisagree() {
        return this.i;
    }

    public BdUniqueId getPageId() {
        TbPageContext tbPageContext = getTbPageContext();
        if (tbPageContext != null) {
            return tbPageContext.getUniqueId();
        }
        return null;
    }

    public Animation getScaleAnimation() {
        if (this.m == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.m = scaleAnimation;
            scaleAnimation.setDuration(200L);
        }
        return this.m;
    }

    public TbPageContext getTbPageContext() {
        if (this.f13329f == null) {
            Context context = getContext();
            if (context instanceof BaseActivity) {
                this.f13329f = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.f13329f = ((BaseFragmentActivity) context).getPageContext();
            }
        }
        return this.f13329f;
    }

    public TBLottieAnimationView getmImgAgree() {
        return this.f13330g;
    }

    public TBLottieAnimationView getmImgDisagree() {
        return this.i;
    }

    public void h(boolean z) {
        int g2 = l.g(getContext(), R.dimen.tbds104);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.gravity = 16;
        this.f13330g.setLayoutParams(layoutParams);
        this.f13331h.setTextSize(0, l.g(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams2.leftMargin = -l.g(getContext(), R.dimen.tbds24);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.f13331h.setPadding(0, g3, g3 * 3, g3);
            this.E = true;
        } else {
            layoutParams2.leftMargin = -l.g(getContext(), R.dimen.tbds22);
        }
        layoutParams2.gravity = 16;
        this.f13331h.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
        layoutParams3.gravity = 16;
        if (!z) {
            layoutParams3.leftMargin = l.g(getContext(), R.dimen.tbds28);
        }
        this.i.setLayoutParams(layoutParams3);
        this.j.setVisibility(8);
    }

    public void i() {
        int g2 = l.g(getContext(), R.dimen.tbds112);
        int g3 = l.g(getContext(), R.dimen.tbds19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.gravity = 16;
        layoutParams.rightMargin = -g3;
        layoutParams.topMargin = l.g(getContext(), R.dimen.tbds_2);
        this.f13330g.setLayoutParams(layoutParams);
        this.f13331h.setTextSize(0, l.g(getContext(), R.dimen.tbfontsize34));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = l.g(getContext(), R.dimen.tbds6);
        layoutParams2.topMargin = l.g(getContext(), R.dimen.tbds_2);
        this.f13331h.setLayoutParams(layoutParams2);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void j(boolean z) {
        if (z) {
            p(l.g(getContext(), R.dimen.tbds126), 0, 1, 17);
            setAgreeAlone(this.D);
            return;
        }
        p(l.g(getContext(), R.dimen.tbds126), -2, 0, 16);
        setAgreeAlone(this.D);
    }

    public void k() {
        AgreeData agreeData;
        String str;
        String str2;
        String str3;
        String str4;
        if (this.p == null || (agreeData = this.k) == null) {
            return;
        }
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        int i = baijiahaoData != null ? baijiahaoData.oriUgcType : 0;
        int i2 = this.p.f50762a;
        if (i2 != 1) {
            if (i2 == 2) {
                StatisticItem param = new StatisticItem("c13271").param("obj_type", this.p.f50768g).param("obj_locate", this.p.f50769h).param(TiebaStatic.Params.OBJ_PARAM2, this.q).param("obj_id", this.p.i).param("obj_name", i).param("post_id", this.k.postId).param("nid", this.k.nid);
                a2 a2Var = this.w;
                if (a2Var != null) {
                    param.param("tid", a2Var.o0()).param("nid", this.w.L0()).param("fid", this.w.c0()).param("card_type", this.x).param("ab_tag", this.w.T0).param("recom_source", this.w.R0).param("weight", this.w.S0).param("extra", this.w.U0);
                    if (this.w.V() != null) {
                        param.param(TiebaStatic.Params.OBJ_PARAM4, this.w.V().oriUgcNid);
                        if (this.w.R1() || this.w.Q1()) {
                            param.param(TiebaStatic.Params.OBJ_PARAM6, this.w.V().oriUgcVid);
                        }
                    }
                    if (this.w.T1()) {
                        param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                    } else if (!this.w.O1() && !this.w.R1()) {
                        int i3 = this.w.Z;
                        if (i3 == 0 || i3 == 40) {
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
                int i4 = this.A;
                if (i4 == 1 || i4 == 2) {
                    str = TiebaStatic.Params.OBJ_TAB;
                    str2 = "a002";
                    param.param(str, str2);
                } else {
                    if (i4 == 18) {
                        str = TiebaStatic.Params.OBJ_TAB;
                        param.param(str, "a099");
                        param.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                    } else {
                        str = TiebaStatic.Params.OBJ_TAB;
                    }
                    str2 = "a002";
                }
                if (getTbPageContext() != null) {
                    d.b.h0.j0.c.b(getTbPageContext().getPageActivity(), param);
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
            StatisticItem param2 = new StatisticItem("c12003").param("obj_locate", this.p.f50763b).param("obj_param1", this.p.f50764c).param("obj_source", this.p.f50765d).param("obj_id", this.p.f50766e).param("obj_name", i).param("post_id", this.k.postId);
            a2 a2Var2 = this.w;
            if (a2Var2 != null) {
                param2.param("tid", a2Var2.o0()).param("nid", this.w.L0()).param("fid", this.w.c0()).param("card_type", this.x).param("ab_tag", this.w.T0).param("recom_source", this.w.R0).param("weight", this.w.S0).param("extra", this.w.U0);
                if (this.w.V() != null) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM4, this.w.V().oriUgcNid);
                    if (this.w.R1() || this.w.Q1()) {
                        param2.param(TiebaStatic.Params.OBJ_PARAM6, this.w.V().oriUgcVid);
                    }
                }
                if (this.w.T1()) {
                    param2.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (!this.w.O1() && !this.w.R1()) {
                    int i5 = this.w.Z;
                    if (i5 == 0 || i5 == 40) {
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
            if (r(this.p.f50763b) && v(this.p.f50767f) != -1) {
                param2.param(TiebaStatic.Params.OBJ_TO, v(this.p.f50767f));
            }
            int i6 = this.A;
            if (i6 == 1 || i6 == 2) {
                str3 = "a002";
                param2.param(TiebaStatic.Params.OBJ_TAB, str3);
                param2.param(TiebaStatic.Params.RESOURCE_ID, this.q);
            } else {
                if (i6 == 18) {
                    param2.param(TiebaStatic.Params.OBJ_TAB, "a099");
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                } else {
                    param2.param(TiebaStatic.Params.RESOURCE_ID, this.q);
                }
                str3 = "a002";
            }
            if (getTbPageContext() != null) {
                d.b.h0.j0.c.b(getTbPageContext().getPageActivity(), param2);
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
            d.b.h0.i0.c f2 = TbPageExtraHelper.f(this);
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
        long j = agreeData != null ? agreeData.agreeNum : 0L;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            return getContext().getString(R.string.c_agree);
        }
        if (i > 0) {
            return StringHelper.numFormatOverWanNa(j);
        }
        return "-" + StringHelper.numFormatOverWanNa(-j);
    }

    public final String m(AgreeData agreeData) {
        return l(agreeData);
    }

    public final void n(Context context) {
        setOrientation(0);
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(context);
        this.f13330g = tBLottieAnimationView;
        tBLottieAnimationView.setId(R.id.img_agree);
        this.f13330g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f13330g.setOnClickListener(this.J);
        this.f13330g.addAnimatorListener(this);
        TextView textView = new TextView(context);
        this.f13331h = textView;
        textView.setTextSize(0, l.g(context, R.dimen.tbfontsize34));
        this.f13331h.setOnClickListener(this.J);
        TBLottieAnimationView tBLottieAnimationView2 = new TBLottieAnimationView(context);
        this.i = tBLottieAnimationView2;
        tBLottieAnimationView2.setId(R.id.img_disagree);
        this.i.addAnimatorListener(this);
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setOnClickListener(this.J);
        TextView textView2 = new TextView(context);
        this.j = textView2;
        textView2.setText(R.string.c_disagree);
        this.j.setTextSize(0, l.g(context, R.dimen.tbfontsize34));
        this.j.setOnClickListener(this.J);
        e eVar = new e();
        this.l = eVar;
        eVar.f53376a = getPageId();
        this.G = new d.b.h0.r.b0.a();
        o();
        setAgreeAnimationResource();
    }

    public final void o() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.C = linearLayout;
        linearLayout.setOrientation(0);
        addView(linearLayout);
        linearLayout.addView(this.f13330g);
        linearLayout.addView(this.f13331h);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.B = linearLayout2;
        linearLayout2.setOrientation(0);
        addView(linearLayout2);
        linearLayout2.addView(this.i);
        linearLayout2.addView(this.j);
        j(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.H);
        MessageManager.getInstance().registerListener(this.I);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.H);
        MessageManager.getInstance().unRegisterListener(this.I);
    }

    public final void p(int i, int i2, int i3, int i4) {
        int i5 = -l.g(getContext(), R.dimen.tbds24);
        int g2 = l.g(getContext(), R.dimen.tbds34);
        this.C.setGravity(i4);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        float f2 = i3;
        layoutParams.weight = f2;
        this.C.setLayoutParams(layoutParams);
        this.f13330g.setLayoutParams(new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = i5;
        this.f13331h.setLayoutParams(layoutParams2);
        this.B.setGravity(i4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -1);
        layoutParams3.weight = f2;
        this.B.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
        layoutParams4.leftMargin = g2;
        this.i.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = i5;
        this.j.setLayoutParams(layoutParams5);
    }

    public boolean q() {
        return this.D;
    }

    public void s() {
        u(this.f13330g);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void setAgreeAlone(boolean z) {
        d dVar;
        LinearLayout linearLayout;
        this.i.setVisibility(z ? 8 : 0);
        this.j.setVisibility(z ? 8 : 0);
        if (z && (linearLayout = this.B) != null) {
            linearLayout.setVisibility(8);
        }
        if (this.D != z && (dVar = this.F) != null) {
            dVar.a(this.i, z);
        }
        this.D = z;
    }

    public void setAgreeAnimationResource() {
        SkinManager.setLottieAnimation(this.f13330g, this.s);
        SkinManager.setLottieAnimation(this.i, this.t);
    }

    public void setCardType(int i) {
        this.x = i;
    }

    public void setData(AgreeData agreeData) {
        if (agreeData == null) {
            return;
        }
        this.k = agreeData;
        y();
    }

    public void setDisagreeShow(boolean z) {
        this.i.setVisibility(z ? 8 : 0);
        this.j.setVisibility(z ? 8 : 0);
        LinearLayout linearLayout = this.B;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 8 : 0);
        }
        this.D = z;
    }

    public void setFrom(int i) {
        this.A = i;
    }

    public void setGameId(int i) {
        this.q = i;
    }

    public void setIsFromBigpic(boolean z) {
        this.n = z;
    }

    public void setIsFromMiddlePage(boolean z) {
        this.o = z;
    }

    public void setNormalColorResourceId(int i) {
        this.u = i;
        setTextNormalColor(this.f13331h);
        setTextNormalColor(this.j);
    }

    public void setResourceId(int i, int i2) {
        this.s = i;
        this.t = i2;
        setAgreeAnimationResource();
    }

    public void setStatisticData(d.b.h0.r.q.e eVar) {
        this.p = eVar;
    }

    public void setTabName(String str) {
        this.r = str;
    }

    public void setThreadData(a2 a2Var) {
        this.w = a2Var;
    }

    public void setTopicId(String str) {
        this.v = str;
    }

    public void setVisibilityListener(d dVar) {
        this.F = dVar;
    }

    public void t(int i) {
        if (this.k == null || this.f13328e == i) {
            return;
        }
        this.f13328e = i;
        SkinManager.setLottieAnimation(this.f13330g, this.s);
        SkinManager.setLottieAnimation(this.i, this.t);
        y();
    }

    public final void u(View view) {
        if (this.k == null) {
            return;
        }
        if (!this.n || f.a(getContext())) {
            if (this.n || ViewHelper.checkUpIsLogin(getContext())) {
                if (view != this.f13331h || this.E) {
                    int i = 0;
                    if (view.getId() != this.f13330g.getId() && (!this.E || view.getId() != this.f13331h.getId())) {
                        if (view.getId() == this.i.getId()) {
                            this.i.cancelAnimation();
                            d.b.h0.r.q.e eVar = this.p;
                            if (eVar != null) {
                                eVar.f50762a = 2;
                            }
                            AgreeData agreeData = this.k;
                            if (agreeData.hasAgree) {
                                if (agreeData.agreeType == 5) {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = false;
                                    y();
                                    d.b.h0.r.q.e eVar2 = this.p;
                                    if (eVar2 != null) {
                                        eVar2.i = 0;
                                    }
                                    i = 1;
                                } else {
                                    agreeData.agreeType = 5;
                                    agreeData.hasAgree = true;
                                    agreeData.agreeNum--;
                                    z(false);
                                    d.b.h0.r.q.e eVar3 = this.p;
                                    if (eVar3 != null) {
                                        eVar3.i = 1;
                                    }
                                }
                            } else {
                                agreeData.agreeType = 5;
                                agreeData.hasAgree = true;
                                z(false);
                                d.b.h0.r.q.e eVar4 = this.p;
                                if (eVar4 != null) {
                                    eVar4.i = 1;
                                }
                            }
                            d.b.h0.i0.c f2 = TbPageExtraHelper.f(this);
                            if (f2 != null) {
                                this.k.objSource = f2.a();
                            }
                            this.G.c(this.k, i, getPageId(), this.n);
                        }
                    } else {
                        this.f13330g.cancelAnimation();
                        d.b.h0.r.q.e eVar5 = this.p;
                        if (eVar5 != null) {
                            eVar5.f50762a = 1;
                        }
                        AgreeData agreeData2 = this.k;
                        if (agreeData2.hasAgree) {
                            if (agreeData2.agreeType == 2) {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = false;
                                agreeData2.agreeNum--;
                                y();
                                d.b.h0.r.q.e eVar6 = this.p;
                                if (eVar6 != null) {
                                    eVar6.f50766e = 1;
                                }
                                i = 1;
                            } else {
                                agreeData2.agreeType = 2;
                                agreeData2.hasAgree = true;
                                agreeData2.agreeNum++;
                                z(true);
                                d.b.i0.q2.a.g().l(getTbPageContext());
                                d.b.h0.r.q.e eVar7 = this.p;
                                if (eVar7 != null) {
                                    eVar7.f50766e = 0;
                                }
                            }
                        } else {
                            agreeData2.agreeType = 2;
                            agreeData2.hasAgree = true;
                            agreeData2.agreeNum++;
                            z(true);
                            d.b.i0.q2.a.g().l(getTbPageContext());
                            d.b.h0.r.q.e eVar8 = this.p;
                            if (eVar8 != null) {
                                eVar8.f50766e = 0;
                            }
                        }
                        d.b.h0.i0.c f3 = TbPageExtraHelper.f(this);
                        if (f3 != null) {
                            this.k.objSource = f3.a();
                        }
                        this.G.c(this.k, i, getPageId(), this.n);
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

    public final void w(View view) {
        if (view == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public final void x(AgreeData agreeData) {
        AgreeData agreeData2;
        if (agreeData == null || (agreeData2 = this.k) == null) {
            return;
        }
        agreeData2.agreeType = agreeData.agreeType;
        agreeData2.hasAgree = agreeData.hasAgree;
        agreeData2.agreeNum = agreeData.agreeNum;
        y();
    }

    public void y() {
        this.f13331h.setText(m(this.k));
        AgreeData agreeData = this.k;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.i.setProgress(0.0f);
                this.f13330g.setProgress(1.0f);
                this.f13331h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.j);
                return;
            }
            this.f13330g.setProgress(0.0f);
            this.i.setProgress(1.0f);
            setTextNormalColor(this.f13331h);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            return;
        }
        this.f13330g.setProgress(0.0f);
        this.i.setProgress(0.0f);
        setTextNormalColor(this.f13331h);
        setTextNormalColor(this.j);
    }

    public void z(boolean z) {
        this.f13330g.setMinAndMaxProgress(0.0f, 1.0f);
        this.i.setMinAndMaxProgress(0.0f, 1.0f);
        this.f13331h.setText(m(this.k));
        this.f13330g.clearColorFilter();
        this.i.clearColorFilter();
        if (z) {
            this.f13330g.playAnimation();
            this.i.cancelAnimation();
            this.i.setFrame(0);
        } else {
            this.i.playAnimation();
            this.f13330g.cancelAnimation();
            this.f13330g.setFrame(0);
        }
        AgreeData agreeData = this.k;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                this.f13331h.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                setTextNormalColor(this.j);
                return;
            }
            setTextNormalColor(this.f13331h);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            return;
        }
        setTextNormalColor(this.f13331h);
        setTextNormalColor(this.j);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13328e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.H = new a(2016528);
        this.I = new b(2016530);
        this.J = new c();
        n(context);
    }

    public AgreeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13328e = 3;
        this.s = R.raw.lottie_agree;
        this.t = R.raw.lottie_disagree;
        this.u = R.color.CAM_X0107;
        this.x = 1;
        this.D = false;
        this.E = false;
        this.H = new a(2016528);
        this.I = new b(2016530);
        this.J = new c();
        n(context);
    }
}
