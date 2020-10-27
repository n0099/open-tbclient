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
    private RelativeLayout eSX;
    private LinearLayout eSY;
    private ImageView eSZ;
    private TextView eTa;
    private TextView eTb;
    private TBSpecificationBtn eTc;
    private TBSpecificationBtn eTd;
    private NoTipAgainView eTe;

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
        this.eSX = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.eSZ = (ImageView) findViewById(R.id.img_youngster_top);
        this.eTa = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.eTb = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.eSY = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.eTc = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qa(R.color.cp_cont_b);
        this.eTc.setConfig(cVar);
        this.eTd = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pY(R.color.cp_link_tip_a);
        this.eTd.setConfig(cVar2);
        this.eTe = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bmA() {
        if (this.eTe == null) {
            return false;
        }
        return this.eTe.bmA();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.eTa.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.eTb.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.eTe.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eTc != null) {
            this.eTc.setText(getContext().getString(i));
            this.eTc.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eTd != null) {
            this.eTd.setText(getContext().getString(i));
            this.eTd.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSY.getLayoutParams();
        layoutParams.topMargin = i;
        this.eSY.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.eSZ.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.eTa, R.color.cp_cont_b);
        ap.setViewTextColor(this.eTb, R.color.cp_cont_j);
        this.eTe.onChangeSkinType();
        ap.setBackgroundResource(this.eSX, R.drawable.dialog_background);
        this.eTc.bqd();
        this.eTd.bqd();
    }
}
