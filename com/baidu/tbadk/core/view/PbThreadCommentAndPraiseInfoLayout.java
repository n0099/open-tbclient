package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.e;
import d.b.i0.r.u.c;
/* loaded from: classes3.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    public View.OnClickListener k0;
    public TextView l0;
    public TextView m0;
    public TextView n0;
    public TextView o0;

    public PbThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        T();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(View view) {
        View.OnClickListener onClickListener = this.k0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J() {
        setVisibility(0);
        R();
        onChangeSkinType();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void M(a2 a2Var) {
        super.M(a2Var);
        if (a2Var == null || this.k == null || !a2Var.A2()) {
            return;
        }
        if (a2Var.Z0() == 0) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void Q(a2 a2Var) {
        super.Q(a2Var);
        View view = this.o;
        if (view == null || this.m == null || a2Var == null) {
            return;
        }
        view.setVisibility(0);
        this.m.setVisibility(0);
        this.m.setText(this.F.getString(R.string.share_weixin_friend_new));
    }

    public final void R() {
        View findViewById = findViewById(R.id.thread_comment_layout_root);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = -1;
        findViewById.setLayoutParams(layoutParams);
        int g2 = l.g(getContext(), R.dimen.tbds68);
        int g3 = l.g(getContext(), R.dimen.T_X09);
        int g4 = l.g(getContext(), R.dimen.tbds15);
        int g5 = l.g(getContext(), R.dimen.tbds10);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.share_num_container);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = V() ? 0.2f : 0.25f;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        ImageView imageView = (ImageView) findViewById(R.id.share_num_img);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
        layoutParams3.topMargin = g4;
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageResource(R.drawable.icon_share_wechat_n);
        this.m0 = (TextView) findViewById(R.id.share_num);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = g5;
        this.m0.setLayoutParams(layoutParams4);
        float f2 = g3;
        this.m0.setTextSize(0, f2);
        this.m0.setText(this.F.getString(R.string.share_weixin_friend_new));
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.qq_share_container);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
        layoutParams5.weight = V() ? 0.2f : 0.25f;
        linearLayout2.setLayoutParams(layoutParams5);
        linearLayout2.setOrientation(1);
        ImageView imageView2 = (ImageView) findViewById(R.id.qq_share_image);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(g2, g2);
        layoutParams6.topMargin = g4;
        imageView2.setLayoutParams(layoutParams6);
        imageView2.setImageResource(R.drawable.icon_share_qq_n);
        this.n0 = (TextView) findViewById(R.id.qq_share_text);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.topMargin = g5;
        this.n0.setLayoutParams(layoutParams7);
        this.n0.setTextSize(0, f2);
        this.n0.setText(this.F.getString(R.string.share_qq_friends));
        if (V()) {
            this.L = true;
            setNeedAddReplyIcon(true);
            LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.thread_info_commont_container);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1);
            layoutParams8.weight = 0.2f;
            linearLayout3.setLayoutParams(layoutParams8);
            linearLayout3.setOrientation(1);
            ImageView imageView3 = (ImageView) findViewById(R.id.thread_info_commont_img);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams9.topMargin = l.g(getContext(), R.dimen.tbds25);
            layoutParams9.addRule(13, -1);
            imageView3.setLayoutParams(layoutParams9);
            WebPManager.setPureDrawable(imageView3, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            this.l0 = (TextView) findViewById(R.id.thread_info_commont_num);
            this.l0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.l0.setTextSize(0, f2);
        } else {
            this.L = false;
            setNeedAddReplyIcon(false);
        }
        if (V()) {
            setCollectVisible(true);
            LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.collect_num_container);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1);
            layoutParams10.weight = 0.2f;
            linearLayout4.setLayoutParams(layoutParams10);
            linearLayout4.setOrientation(1);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams11.topMargin = g4;
            ((ImageView) findViewById(R.id.collect_num_image)).setLayoutParams(layoutParams11);
            this.o0 = (TextView) findViewById(R.id.collect_num_text);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams12.topMargin = g5;
            this.o0.setLayoutParams(layoutParams12);
            this.o0.setTextSize(0, f2);
        } else {
            setCollectVisible(false);
        }
        AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, -1);
        layoutParams13.topMargin = l.g(getContext(), R.dimen.tbds18);
        layoutParams2.weight = V() ? 0.2f : 0.25f;
        agreeView.setLayoutParams(layoutParams13);
        agreeView.g();
    }

    public void S(String str) {
        if (this.E == null || TextUtils.isEmpty(str) || !str.equals(this.E.w1())) {
            return;
        }
        e eVar = new e();
        eVar.f51506b = 4;
        eVar.f51508d = 2;
        this.f13162h.setStatisticData(eVar);
        this.f13162h.s();
    }

    public void T() {
        setVisibility(8);
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setManageVisible(false);
        setInFrsAllThread(false);
        this.L = false;
        setNeedAddReplyIcon(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setShareVisible(true);
        setQQShareVisible(true);
    }

    public boolean U() {
        a2 a2Var = this.E;
        return (a2Var == null || !a2Var.z2() || this.E.u1() == null) ? false : true;
    }

    public boolean V() {
        a2 a2Var;
        WorksInfoData worksInfoData;
        return U() && (a2Var = this.E) != null && (worksInfoData = a2Var.E2) != null && worksInfoData.isWorks;
    }

    public boolean W(a2 a2Var, AntiData antiData) {
        return setData(a2Var);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        if (V()) {
            WebPManager.setMaskDrawable(this.n, R.drawable.icon_mask_bottom_share_new_wechat26, null);
            WebPManager.setMaskDrawable(this.w, R.drawable.icon_mask_bottom_share_new_qq28, null);
        } else {
            WebPManager.setMaskDrawable(this.n, R.drawable.icon_mask_bottom_share_wechat26, null);
            WebPManager.setMaskDrawable(this.w, R.drawable.icon_mask_bottom_share_qq28, null);
        }
        WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_pb_operate_commen, R.color.CAM_X0107, null);
        EMTextView eMTextView = this.k;
        if (eMTextView != null) {
            c d2 = c.d(eMTextView);
            d2.v(R.string.F_X02);
            d2.q(R.color.CAM_X0107);
            EMTextView eMTextView2 = this.k;
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
            int i = R.color.CAM_X0207;
            SkinManager.setBackgroundShapeDrawable(eMTextView2, g2, i, i);
        }
        SkinManager.setViewTextColor(this.m0, R.drawable.selector_comment_and_prise_item_text_color);
        SkinManager.setViewTextColor(this.n0, R.drawable.selector_comment_and_prise_item_text_color);
        SkinManager.setViewTextColor(this.l0, R.drawable.selector_comment_and_prise_item_text_color);
        SkinManager.setViewTextColor(this.o0, R.drawable.selector_comment_and_prise_item_text_color);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(a2 a2Var) {
        if (a2Var != null) {
            this.f13162h.setDisagreeShow(a2Var.y2());
        }
        if (a2Var != null && a2Var.A2()) {
            this.f13162h.setDisagreeShow(true);
        }
        if (a2Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13162h.getLayoutParams();
            if (a2Var.A2()) {
                layoutParams.weight = 0.2f;
            } else if (a2Var.y2()) {
                layoutParams.weight = 0.25f;
            } else {
                layoutParams.weight = 0.5f;
            }
            this.f13162h.setLayoutParams(layoutParams);
        }
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.k0 = onClickListener;
    }

    public void setPostId(String str) {
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void u(View view) {
        View.OnClickListener onClickListener = this.k0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(a2 a2Var) {
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(View view) {
        View.OnClickListener onClickListener = this.k0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(View view) {
        View.OnClickListener onClickListener = this.k0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public PbThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        T();
    }
}
