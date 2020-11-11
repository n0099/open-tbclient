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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private AntiData eUI;
    private View.OnClickListener eUJ;
    private TextView eUK;
    private TextView eUL;

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
        bsw();
    }

    private void bsw() {
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
        this.eUL = (TextView) findViewById(R.id.share_num);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = dimens3;
        this.eUL.setLayoutParams(layoutParams3);
        this.eUL.setTextSize(0, dimens2);
        this.eUL.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.thread_info_commont_container);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 0.25f;
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout2.setOrientation(1);
        ImageView imageView2 = (ImageView) findViewById(R.id.thread_info_commont_img);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        imageView2.setImageResource(R.drawable.icon_share_qq_n);
        this.eUK = (TextView) findViewById(R.id.thread_info_commont_num);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = dimens3;
        this.eUK.setLayoutParams(layoutParams5);
        this.eUK.setTextSize(0, dimens2);
        this.eUK.setText(this.mContext.getString(R.string.share_qq_friends));
        AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams6.weight = 0.5f;
        agreeView.setLayoutParams(layoutParams6);
        agreeView.bsd();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bn(View view) {
        if (this.eUJ != null) {
            this.eUJ.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bo(View view) {
        if (this.eUJ != null) {
            this.eUJ.onClick(view);
        }
    }

    public void Cu(String str) {
        if (this.agx != null && !TextUtils.isEmpty(str) && str.equals(this.agx.getTid())) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ezt = 4;
            cVar.ezv = 2;
            this.eVZ.setStatisticData(cVar);
            this.eVZ.bse();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.eUJ = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(bw bwVar) {
        if (bwVar != null) {
            this.eVZ.setDisagreeShow(bwVar.blk());
        }
        if (bwVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eVZ.getLayoutParams();
            if (bwVar.blk()) {
                layoutParams.weight = 0.25f;
            } else {
                layoutParams.weight = 0.5f;
            }
            this.eVZ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void z(bw bwVar) {
        super.z(bwVar);
        if (this.eWe != null && this.eWc != null && bwVar != null) {
            this.eWe.setVisibility(0);
            this.eWc.setVisibility(0);
            this.eWc.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(bw bwVar) {
        super.A(bwVar);
        if (this.eWb != null && this.ewm != null && bwVar != null) {
            this.eWb.setVisibility(0);
            this.ewm.setVisibility(0);
            this.ewm.setText(this.mContext.getString(R.string.share_qq_friends));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        SvgManager.brn().a(this.eWd, R.drawable.icon_mask_share_wechat40_svg, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.brn().a(this.eWa, R.drawable.icon_mask_share_qq40_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.eUL, R.drawable.selector_comment_and_prise_item_text_color);
        ap.setViewTextColor(this.eUK, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public boolean a(bw bwVar, AntiData antiData) {
        this.eUI = antiData;
        return setData(bwVar);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(bw bwVar) {
    }
}
