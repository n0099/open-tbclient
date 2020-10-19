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
    private RelativeLayout eKB;
    private LinearLayout eKC;
    private ImageView eKD;
    private TextView eKE;
    private TextView eKF;
    private TBSpecificationBtn eKG;
    private TBSpecificationBtn eKH;
    private NoTipAgainView eKI;

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
        this.eKB = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.eKD = (ImageView) findViewById(R.id.img_youngster_top);
        this.eKE = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.eKF = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.eKC = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.eKG = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pP(R.color.cp_cont_b);
        this.eKG.setConfig(cVar);
        this.eKH = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pN(R.color.cp_link_tip_a);
        this.eKH.setConfig(cVar2);
        this.eKI = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bkH() {
        if (this.eKI == null) {
            return false;
        }
        return this.eKI.bkH();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.eKE.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.eKF.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.eKI.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eKG != null) {
            this.eKG.setText(getContext().getString(i));
            this.eKG.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eKH != null) {
            this.eKH.setText(getContext().getString(i));
            this.eKH.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKC.getLayoutParams();
        layoutParams.topMargin = i;
        this.eKC.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.eKD.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.eKE, R.color.cp_cont_b);
        ap.setViewTextColor(this.eKF, R.color.cp_cont_j);
        this.eKI.onChangeSkinType();
        ap.setBackgroundResource(this.eKB, R.drawable.dialog_background);
        this.eKG.bok();
        this.eKH.bok();
    }
}
