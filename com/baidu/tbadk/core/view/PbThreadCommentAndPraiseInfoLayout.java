package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PbThreadCommentAndPraiseInfoLayout extends ThreadCommentAndPraiseInfoLayout {
    private View.OnClickListener dcw;

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
        aFv();
    }

    private void aFv() {
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
        agreeView.aFd();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aS(View view) {
        if (this.dcw != null) {
            this.dcw.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    protected void aT(View view) {
        if (this.dcw != null) {
            this.dcw.onClick(view);
        }
    }

    public void tH(String str) {
        if (this.Kn != null && !TextUtils.isEmpty(str) && str.equals(this.Kn.getTid())) {
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.cJx = 4;
            dVar.cJz = 2;
            this.dda.setStatisticData(dVar);
            this.dda.aFe();
        }
    }

    public void setPostId(String str) {
    }

    public void setOnClickOutListener(View.OnClickListener onClickListener) {
        this.dcw = onClickListener;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void setAgreeViewType(bj bjVar) {
        super.setAgreeViewType(bjVar);
        if (bjVar != null && bjVar.aBV()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dda.getLayoutParams();
            layoutParams.weight = 0.25f;
            this.dda.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void v(bj bjVar) {
        super.v(bjVar);
        if (bjVar.cPN != null && bjVar.cPN.cKG) {
            SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void w(bj bjVar) {
        super.w(bjVar);
        if (this.dds) {
            SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        super.onChangeSkinType();
        if (this.ddb != null && this.dds && this.ddF > 0) {
            SvgManager.aEp().a(this.ddc, R.drawable.icon_pure_pb_reply26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.Kn != null && this.Kn.cPN != null && this.Kn.cPN.cKG) {
            SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.aEp().a(this.ddf, R.drawable.icon_pure_pb_share26_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
