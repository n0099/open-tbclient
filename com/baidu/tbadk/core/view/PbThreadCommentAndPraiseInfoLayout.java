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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes8.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private AntiData dGy;
    private View.OnClickListener dGz;

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
        aQg();
    }

    private void aQg() {
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
        agreeView.aPO();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aT(View view) {
        if (this.dGz != null) {
            this.dGz.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aU(View view) {
        if (this.dGz != null) {
            this.dGz.onClick(view);
        }
    }

    public void vl(String str) {
        if (this.adG != null && !TextUtils.isEmpty(str) && str.equals(this.adG.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.dmT = 4;
            dVar.dmV = 2;
            this.dHB.setStatisticData(dVar);
            this.dHB.aPP();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.dGz = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(bj bjVar) {
        super.setAgreeViewType(bjVar);
        if (bjVar != null && bjVar.aMA()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHB.getLayoutParams();
            layoutParams.weight = 0.25f;
            this.dHB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void x(bj bjVar) {
        super.x(bjVar);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
    }

    public boolean a(bj bjVar, AntiData antiData) {
        this.dGy = antiData;
        return setData(bjVar);
    }

    public boolean aQh() {
        return (this.adG == null || !this.adG.aJr() || this.adG.aKV() == null) ? false : true;
    }

    public boolean aQi() {
        return (this.adG == null || this.adG.aKv() == 0) ? false : true;
    }

    public boolean aQj() {
        if (aQh() && aQi()) {
            return false;
        }
        return AntiHelper.aZ(this.adG);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateReplyStateUI() {
        if (aQj()) {
            if (this.dHU) {
                SvgManager.aOU().a(this.dHD, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            }
            am.setViewTextColor(this.dHC, (int) R.color.cp_cont_e);
            return;
        }
        if (this.dHU) {
            SvgManager.aOU().a(this.dHD, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.dHC, (int) R.drawable.selector_comment_and_prise_item_text_color);
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateShareStateUI(bj bjVar) {
        if (AntiHelper.ba(bjVar)) {
            setShareClickable(true);
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dHF, (int) R.color.cp_cont_e);
        } else if (bjVar != null && bjVar.dto != null && this.adG.dto.doe) {
            setShareClickable(false);
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dHF, (int) R.color.cp_cont_e);
        } else {
            setShareClickable(true);
            SvgManager.aOU().a(this.dHG, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            am.setViewTextColor(this.dHF, (int) R.drawable.selector_comment_and_prise_item_text_color);
        }
    }
}
