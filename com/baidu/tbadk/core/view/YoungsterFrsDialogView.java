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
    private RelativeLayout eXT;
    private LinearLayout eXU;
    private ImageView eXV;
    private TextView eXW;
    private TextView eXX;
    private TBSpecificationBtn eXY;
    private TBSpecificationBtn eXZ;
    private NoTipAgainView eYa;

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
        this.eXT = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.eXV = (ImageView) findViewById(R.id.img_youngster_top);
        this.eXW = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.eXX = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.eXU = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.eXY = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qI(R.color.CAM_X0105);
        this.eXY.setConfig(cVar);
        this.eXZ = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qG(R.color.CAM_X0302);
        this.eXZ.setConfig(cVar2);
        this.eYa = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean boe() {
        if (this.eYa == null) {
            return false;
        }
        return this.eYa.boe();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.eXW.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.eXX.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.eYa.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eXY != null) {
            this.eXY.setText(getContext().getString(i));
            this.eXY.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eXZ != null) {
            this.eXZ.setText(getContext().getString(i));
            this.eXZ.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eXU.getLayoutParams();
        layoutParams.topMargin = i;
        this.eXU.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.eXV.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.eXW, R.color.CAM_X0105);
        ap.setViewTextColor(this.eXX, R.color.CAM_X0107);
        this.eYa.onChangeSkinType();
        ap.setBackgroundResource(this.eXT, R.drawable.dialog_background);
        this.eXY.brT();
        this.eXZ.brT();
    }
}
