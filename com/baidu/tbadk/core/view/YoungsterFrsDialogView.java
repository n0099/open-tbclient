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
    private RelativeLayout fog;
    private LinearLayout foh;
    private ImageView foi;
    private TextView foj;
    private TextView fok;
    private TBSpecificationBtn fol;
    private TBSpecificationBtn fom;
    private NoTipAgainView fon;

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
        this.fog = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.foi = (ImageView) findViewById(R.id.img_youngster_top);
        this.foj = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.fok = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.foh = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.fol = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pU(R.color.CAM_X0105);
        this.fol.setConfig(cVar);
        this.fom = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pS(R.color.CAM_X0302);
        this.fom.setConfig(cVar2);
        this.fon = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bqx() {
        if (this.fon == null) {
            return false;
        }
        return this.fon.bqx();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.foj.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.fok.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.fon.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fol != null) {
            this.fol.setText(getContext().getString(i));
            this.fol.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.fom != null) {
            this.fom.setText(getContext().getString(i));
            this.fom.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foh.getLayoutParams();
        layoutParams.topMargin = i;
        this.foh.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.foi.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.foj, R.color.CAM_X0105);
        ap.setViewTextColor(this.fok, R.color.CAM_X0107);
        this.fon.onChangeSkinType();
        ap.setBackgroundResource(this.fog, R.drawable.dialog_background);
        this.fol.bus();
        this.fom.bus();
    }
}
