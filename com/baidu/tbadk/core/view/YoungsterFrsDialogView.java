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
    private RelativeLayout ffq;
    private LinearLayout ffr;
    private ImageView ffs;
    private TextView fft;
    private TextView ffu;
    private TBSpecificationBtn ffv;
    private TBSpecificationBtn ffw;
    private NoTipAgainView ffx;

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
        this.ffq = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.ffs = (ImageView) findViewById(R.id.img_youngster_top);
        this.fft = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.ffu = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.ffr = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.ffv = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rj(R.color.CAM_X0105);
        this.ffv.setConfig(cVar);
        this.ffw = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rh(R.color.CAM_X0302);
        this.ffw.setConfig(cVar2);
        this.ffx = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean brt() {
        if (this.ffx == null) {
            return false;
        }
        return this.ffx.brt();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.fft.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.ffu.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.ffx.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.ffv != null) {
            this.ffv.setText(getContext().getString(i));
            this.ffv.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.ffw != null) {
            this.ffw.setText(getContext().getString(i));
            this.ffw.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffr.getLayoutParams();
        layoutParams.topMargin = i;
        this.ffr.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.ffs.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.fft, R.color.CAM_X0105);
        ap.setViewTextColor(this.ffu, R.color.CAM_X0107);
        this.ffx.onChangeSkinType();
        ap.setBackgroundResource(this.ffq, R.drawable.dialog_background);
        this.ffv.bvt();
        this.ffw.bvt();
    }
}
