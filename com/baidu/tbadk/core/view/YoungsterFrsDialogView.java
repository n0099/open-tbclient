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
    private RelativeLayout fkp;
    private LinearLayout fkq;
    private ImageView fkr;
    private TextView fks;
    private TextView fkt;
    private TBSpecificationBtn fku;
    private TBSpecificationBtn fkv;
    private NoTipAgainView fkw;

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
        this.fkp = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.fkr = (ImageView) findViewById(R.id.img_youngster_top);
        this.fks = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.fkt = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.fkq = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.fku = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pO(R.color.CAM_X0105);
        this.fku.setConfig(cVar);
        this.fkv = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pM(R.color.CAM_X0302);
        this.fkv.setConfig(cVar2);
        this.fkw = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bqc() {
        if (this.fkw == null) {
            return false;
        }
        return this.fkw.bqc();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.fks.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.fkt.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.fkw.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fku != null) {
            this.fku.setText(getContext().getString(i));
            this.fku.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fkv != null) {
            this.fkv.setText(getContext().getString(i));
            this.fkv.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fkq.getLayoutParams();
        layoutParams.topMargin = i;
        this.fkq.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.transparent_bg);
        this.fkr.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ao.setViewTextColor(this.fks, R.color.CAM_X0105);
        ao.setViewTextColor(this.fkt, R.color.CAM_X0107);
        this.fkw.onChangeSkinType();
        ao.setBackgroundResource(this.fkp, R.drawable.dialog_background);
        this.fku.btV();
        this.fkv.btV();
    }
}
