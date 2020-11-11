package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    private RelativeLayout eYM;
    private LinearLayout eYN;
    private ImageView eYO;
    private TextView eYP;
    private TextView eYQ;
    private TBSpecificationBtn eYR;
    private TBSpecificationBtn eYS;
    private NoTipAgainView eYT;

    public YoungsterFrsDialogView(Context context) {
        this(context, null);
    }

    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterFrsDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.youngster_frs_dialog_view, this);
        this.eYM = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.eYO = (ImageView) findViewById(R.id.img_youngster_top);
        this.eYP = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.eYQ = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.eYN = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.eYR = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qk(R.color.cp_cont_b);
        this.eYR.setConfig(cVar);
        this.eYS = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qi(R.color.cp_link_tip_a);
        this.eYS.setConfig(cVar2);
        this.eYT = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bpa() {
        if (this.eYT == null) {
            return false;
        }
        return this.eYT.bpa();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.eYP.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.eYQ.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.eYT.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eYR != null) {
            this.eYR.setText(getContext().getString(i));
            this.eYR.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eYS != null) {
            this.eYS.setText(getContext().getString(i));
            this.eYS.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eYN.getLayoutParams();
        layoutParams.topMargin = i;
        this.eYN.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.eYO.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.eYP, R.color.cp_cont_b);
        ap.setViewTextColor(this.eYQ, R.color.cp_cont_j);
        this.eYT.onChangeSkinType();
        ap.setBackgroundResource(this.eYM, R.drawable.dialog_background);
        this.eYR.bsD();
        this.eYS.bsD();
    }
}
