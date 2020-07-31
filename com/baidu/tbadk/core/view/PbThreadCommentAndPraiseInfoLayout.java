package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private AntiData ein;
    private View.OnClickListener eio;
    private TextView eip;
    private TextView eiq;

    public PbThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        init();
    }

    public PbThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {
        setReplyTimeVisible(false);
        setIsBarViewVisible(false);
        setManageVisible(false);
        setInFrsAllThread(false);
        setShowPraiseNum(true);
        setNeedAddPraiseIcon(true);
        setNeedAddReplyIcon(true);
        setShareVisible(true);
        bcc();
    }

    private void bcc() {
        View findViewById = findViewById(R.id.thread_comment_layout_root);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = -1;
        findViewById.setLayoutParams(layoutParams);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds68);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize34);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.share_num_container);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 0.25f;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        ImageView imageView = (ImageView) findViewById(R.id.share_num_img);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        imageView.setImageResource(R.drawable.icon_share_wechat_n);
        this.eiq = (TextView) findViewById(R.id.share_num);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = dimens3;
        this.eiq.setLayoutParams(layoutParams3);
        this.eiq.setTextSize(0, dimens2);
        this.eiq.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.thread_info_commont_container);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 0.25f;
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout2.setOrientation(1);
        ImageView imageView2 = (ImageView) findViewById(R.id.thread_info_commont_img);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        imageView2.setImageResource(R.drawable.icon_share_qq_n);
        this.eip = (TextView) findViewById(R.id.thread_info_commont_num);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = dimens3;
        this.eip.setLayoutParams(layoutParams5);
        this.eip.setTextSize(0, dimens2);
        this.eip.setText(this.mContext.getString(R.string.share_qq_friends));
        AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams6.weight = 0.5f;
        agreeView.setLayoutParams(layoutParams6);
        agreeView.bbJ();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void ba(View view) {
        if (this.eio != null) {
            this.eio.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bb(View view) {
        if (this.eio != null) {
            this.eio.onClick(view);
        }
    }

    public void yq(String str) {
        if (this.aeA != null && !TextUtils.isEmpty(str) && str.equals(this.aeA.getTid())) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 4;
            cVar.dND = 2;
            this.ejB.setStatisticData(cVar);
            this.ejB.bbK();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.eio = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(bv bvVar) {
        if (bvVar != null) {
            this.ejB.setDisagreeShow(bvVar.aUV());
        }
        if (bvVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejB.getLayoutParams();
            if (bvVar.aUV()) {
                layoutParams.weight = 0.25f;
            } else {
                layoutParams.weight = 0.5f;
            }
            this.ejB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void y(bv bvVar) {
        super.y(bvVar);
        if (this.ejG != null && this.ejE != null && bvVar != null) {
            this.ejG.setVisibility(0);
            this.ejE.setVisibility(0);
            this.ejE.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(bv bvVar) {
        super.z(bvVar);
        if (this.ejD != null && this.dKx != null && bvVar != null) {
            this.ejD.setVisibility(0);
            this.dKx.setVisibility(0);
            this.dKx.setText(this.mContext.getString(R.string.share_qq_friends));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        SvgManager.baR().a(this.ejF, R.drawable.icon_mask_share_wechat40_svg, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a(this.ejC, R.drawable.icon_mask_share_qq40_svg, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.eiq, R.drawable.selector_comment_and_prise_item_text_color);
        ao.setViewTextColor(this.eip, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public boolean a(bv bvVar, AntiData antiData) {
        this.ein = antiData;
        return setData(bvVar);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(bv bvVar) {
    }
}
