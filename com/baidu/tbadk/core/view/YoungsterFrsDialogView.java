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
/* loaded from: classes2.dex */
public class YoungsterFrsDialogView extends LinearLayout {
    private RelativeLayout ewj;
    private LinearLayout ewk;
    private ImageView ewl;
    private TextView ewm;
    private TextView ewn;
    private TBSpecificationBtn ewo;
    private TBSpecificationBtn ewp;
    private NoTipAgainView ewq;

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
        this.ewj = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.ewl = (ImageView) findViewById(R.id.img_youngster_top);
        this.ewm = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.ewn = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.ewk = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.ewo = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pd(R.color.cp_cont_b);
        this.ewo.setConfig(cVar);
        this.ewp = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_link_tip_a);
        this.ewp.setConfig(cVar2);
        this.ewq = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bhe() {
        if (this.ewq == null) {
            return false;
        }
        return this.ewq.bhe();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.ewm.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.ewn.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.ewq.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.ewo != null) {
            this.ewo.setText(getContext().getString(i));
            this.ewo.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.ewp != null) {
            this.ewp.setText(getContext().getString(i));
            this.ewp.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ewk.getLayoutParams();
        layoutParams.topMargin = i;
        this.ewk.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.ewl.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.ewm, R.color.cp_cont_b);
        ap.setViewTextColor(this.ewn, R.color.cp_cont_j);
        this.ewq.onChangeSkinType();
        ap.setBackgroundResource(this.ewj, R.drawable.dialog_background);
        this.ewo.bkF();
        this.ewp.bkF();
    }
}
