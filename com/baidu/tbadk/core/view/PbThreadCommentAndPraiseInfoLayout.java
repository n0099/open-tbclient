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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes8.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private AntiData dUO;
    private View.OnClickListener dUP;

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
        aWh();
    }

    private void aWh() {
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
        ((ImageView) findViewById(R.id.share_num_img)).setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        TextView textView = (TextView) findViewById(R.id.share_num);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = dimens3;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(0, dimens2);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.thread_info_commont_container);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 0.25f;
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout2.setOrientation(1);
        ((ImageView) findViewById(R.id.thread_info_commont_img)).setLayoutParams(new LinearLayout.LayoutParams(dimens, dimens));
        TextView textView2 = (TextView) findViewById(R.id.thread_info_commont_num);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = dimens3;
        textView2.setLayoutParams(layoutParams5);
        textView2.setTextSize(0, dimens2);
        AgreeView agreeView = (AgreeView) findViewById(R.id.new_agree_view);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
        layoutParams6.topMargin = -com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds15);
        layoutParams6.weight = 0.5f;
        agreeView.setLayoutParams(layoutParams6);
        agreeView.aVO();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        if (this.dUP != null) {
            this.dUP.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aV(View view) {
        if (this.dUP != null) {
            this.dUP.onClick(view);
        }
    }

    public void wU(String str) {
        if (this.aee != null && !TextUtils.isEmpty(str) && str.equals(this.aee.getTid())) {
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dAZ = 4;
            cVar.dBb = 2;
            this.dVU.setStatisticData(cVar);
            this.dVU.aVP();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.dUP = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(bk bkVar) {
        if (bkVar != null) {
            this.dVU.setDisagreeShow(bkVar.aSx());
        }
        if (bkVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dVU.getLayoutParams();
            if (bkVar.aSx()) {
                layoutParams.weight = 0.25f;
            } else {
                layoutParams.weight = 0.5f;
            }
            this.dVU.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x(bk bkVar) {
        super.x(bkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void y(bk bkVar) {
        super.y(bkVar);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
    }

    public boolean a(bk bkVar, AntiData antiData) {
        this.dUO = antiData;
        return setData(bkVar);
    }

    public boolean aWi() {
        return (this.aee == null || !this.aee.aPk() || this.aee.aQQ() == null) ? false : true;
    }

    public boolean aWj() {
        return (this.aee == null || this.aee.aQo() == 0) ? false : true;
    }

    public boolean aWk() {
        if (aWi() && aWj()) {
            return false;
        }
        return AntiHelper.aY(this.aee);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        if (aWk()) {
            if (this.dWn) {
                SvgManager.aUV().a(this.dVW, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            }
            am.setViewTextColor(this.dVV, (int) R.color.cp_cont_e);
            return;
        }
        if (this.dWn) {
            SvgManager.aUV().a(this.dVW, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dVV, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(bk bkVar) {
        if (AntiHelper.aZ(bkVar)) {
            setShareClickable(true);
            SvgManager.aUV().a(this.dVZ, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dVY, (int) R.color.cp_cont_e);
        } else if (bkVar != null && bkVar.dHm != null && this.aee.dHm.dCi) {
            setShareClickable(false);
            SvgManager.aUV().a(this.dVZ, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dVY, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aUV().a(this.dVZ, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dVY, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }
}
