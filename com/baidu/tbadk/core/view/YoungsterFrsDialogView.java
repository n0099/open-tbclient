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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    private RelativeLayout foY;
    private LinearLayout foZ;
    private ImageView fpa;
    private TextView fpb;
    private TextView fpc;
    private TBSpecificationBtn fpd;
    private TBSpecificationBtn fpe;
    private NoTipAgainView fpf;

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
        this.foY = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.fpa = (ImageView) findViewById(R.id.img_youngster_top);
        this.fpb = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.fpc = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.foZ = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.fpd = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ru(R.color.CAM_X0105);
        this.fpd.setConfig(cVar);
        this.fpe = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rs(R.color.CAM_X0302);
        this.fpe.setConfig(cVar2);
        this.fpf = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean btV() {
        if (this.fpf == null) {
            return false;
        }
        return this.fpf.btV();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.fpb.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.fpc.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.fpf.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fpd != null) {
            this.fpd.setText(getContext().getString(i));
            this.fpd.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fpe != null) {
            this.fpe.setText(getContext().getString(i));
            this.fpe.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foZ.getLayoutParams();
        layoutParams.topMargin = i;
        this.foZ.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.transparent_bg);
        this.fpa.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ao.setViewTextColor(this.fpb, R.color.CAM_X0105);
        ao.setViewTextColor(this.fpc, R.color.CAM_X0107);
        this.fpf.onChangeSkinType();
        ao.setBackgroundResource(this.foY, R.drawable.dialog_background);
        this.fpd.bxO();
        this.fpe.bxO();
    }
}
