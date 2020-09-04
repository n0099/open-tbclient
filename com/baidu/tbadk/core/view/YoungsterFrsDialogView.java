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
    private RelativeLayout ewn;
    private LinearLayout ewo;
    private ImageView ewp;
    private TextView ewq;
    private TextView ewr;
    private TBSpecificationBtn ews;
    private TBSpecificationBtn ewt;
    private NoTipAgainView ewu;

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
        this.ewn = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.ewp = (ImageView) findViewById(R.id.img_youngster_top);
        this.ewq = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.ewr = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.ewo = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.ews = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pd(R.color.cp_cont_b);
        this.ews.setConfig(cVar);
        this.ewt = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_link_tip_a);
        this.ewt.setConfig(cVar2);
        this.ewu = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bhe() {
        if (this.ewu == null) {
            return false;
        }
        return this.ewu.bhe();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.ewq.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.ewr.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.ewu.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.ews != null) {
            this.ews.setText(getContext().getString(i));
            this.ews.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.ewt != null) {
            this.ewt.setText(getContext().getString(i));
            this.ewt.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewo.getLayoutParams();
        layoutParams.topMargin = i;
        this.ewo.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.ewp.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.ewq, R.color.cp_cont_b);
        ap.setViewTextColor(this.ewr, R.color.cp_cont_j);
        this.ewu.onChangeSkinType();
        ap.setBackgroundResource(this.ewn, R.drawable.dialog_background);
        this.ews.bkF();
        this.ewt.bkF();
    }
}
