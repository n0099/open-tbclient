package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    private RelativeLayout fmH;
    private LinearLayout fmI;
    private ImageView fmJ;
    private TextView fmK;
    private TextView fmL;
    private TBSpecificationBtn fmM;
    private TBSpecificationBtn fmN;
    private NoTipAgainView fmO;

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
        this.fmH = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.fmJ = (ImageView) findViewById(R.id.img_youngster_top);
        this.fmK = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.fmL = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.fmI = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.fmM = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pT(R.color.CAM_X0105);
        this.fmM.setConfig(cVar);
        this.fmN = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pR(R.color.CAM_X0302);
        this.fmN.setConfig(cVar2);
        this.fmO = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bqv() {
        if (this.fmO == null) {
            return false;
        }
        return this.fmO.bqv();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.fmK.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.fmL.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.fmO.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fmM != null) {
            this.fmM.setText(getContext().getString(i));
            this.fmM.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fmN != null) {
            this.fmN.setText(getContext().getString(i));
            this.fmN.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fmI.getLayoutParams();
        layoutParams.topMargin = i;
        this.fmI.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.fmJ.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.fmK, R.color.CAM_X0105);
        ap.setViewTextColor(this.fmL, R.color.CAM_X0107);
        this.fmO.onChangeSkinType();
        ap.setBackgroundResource(this.fmH, R.drawable.dialog_background);
        this.fmM.bup();
        this.fmN.bup();
    }
}
