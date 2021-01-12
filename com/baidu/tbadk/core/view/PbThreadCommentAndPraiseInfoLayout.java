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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private AntiData fgg;
    private View.OnClickListener fgh;
    private TextView fgi;
    private TextView fgj;

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
        btM();
    }

    private void btM() {
        View findViewById = findViewById(R.id.thread_comment_layout_root);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = -1;
        findViewById.setLayoutParams(layoutParams);
        int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds68);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.T_X09);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.share_num_container);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 0.25f;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        ImageView imageView = (ImageView) findViewById(R.id.share_num_img);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        imageView.setImageResource(R.drawable.icon_share_wechat_n);
        this.fgj = (TextView) findViewById(R.id.share_num);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = dimens3;
        this.fgj.setLayoutParams(layoutParams3);
        this.fgj.setTextSize(0, dimens2);
        this.fgj.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.thread_info_commont_container);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 0.25f;
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout2.setOrientation(1);
        ImageView imageView2 = (ImageView) findViewById(R.id.thread_info_commont_img);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        imageView2.setImageResource(R.drawable.icon_share_qq_n);
        this.fgi = (TextView) findViewById(R.id.thread_info_commont_num);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = dimens3;
        this.fgi.setLayoutParams(layoutParams5);
        this.fgi.setTextSize(0, dimens2);
        this.fgi.setText(this.mContext.getString(R.string.share_qq_friends));
        AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds12);
        layoutParams6.weight = 0.5f;
        agreeView.setLayoutParams(layoutParams6);
        agreeView.btq();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bC(View view) {
        if (this.fgh != null) {
            this.fgh.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void bD(View view) {
        if (this.fgh != null) {
            this.fgh.onClick(view);
        }
    }

    public void Bn(String str) {
        if (this.ahu != null && !TextUtils.isEmpty(str) && str.equals(this.ahu.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 4;
            dVar.eJQ = 2;
            this.fhD.setStatisticData(dVar);
            this.fhD.btr();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.fgh = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(bz bzVar) {
        if (bzVar != null) {
            this.fhD.setDisagreeShow(bzVar.bmg());
        }
        if (bzVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fhD.getLayoutParams();
            if (bzVar.bmg()) {
                layoutParams.weight = 0.25f;
            } else {
                layoutParams.weight = 0.5f;
            }
            this.fhD.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void B(bz bzVar) {
        super.B(bzVar);
        if (this.fhJ != null && this.fhH != null && bzVar != null) {
            this.fhJ.setVisibility(0);
            this.fhH.setVisibility(0);
            this.fhH.setText(this.mContext.getString(R.string.share_weixin_friend_new));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void C(bz bzVar) {
        super.C(bzVar);
        if (this.fhG != null && this.fhE != null && bzVar != null) {
            this.fhG.setVisibility(0);
            this.fhE.setVisibility(0);
            this.fhE.setText(this.mContext.getString(R.string.share_qq_friends));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        WebPManager.a(this.fhI, R.drawable.icon_mask_bottom_share_wechat26, (WebPManager.ResourceStateType) null);
        WebPManager.a(this.fhF, R.drawable.icon_mask_bottom_share_qq28, (WebPManager.ResourceStateType) null);
        ao.setViewTextColor(this.fgj, R.drawable.selector_comment_and_prise_item_text_color);
        ao.setViewTextColor(this.fgi, R.drawable.selector_comment_and_prise_item_text_color);
    }

    public boolean a(bz bzVar, AntiData antiData) {
        this.fgg = antiData;
        return setData(bzVar);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(bz bzVar) {
    }
}
