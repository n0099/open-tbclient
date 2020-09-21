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
    private TBSpecificationBtn eyA;
    private NoTipAgainView eyB;
    private RelativeLayout eyu;
    private LinearLayout eyv;
    private ImageView eyw;
    private TextView eyx;
    private TextView eyy;
    private TBSpecificationBtn eyz;

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
        this.eyu = (RelativeLayout) findViewById(R.id.youngster_dialog_view);
        this.eyw = (ImageView) findViewById(R.id.img_youngster_top);
        this.eyx = (TextView) findViewById(R.id.txt_youngster_dialog_title);
        this.eyy = (TextView) findViewById(R.id.txt_youngster_dialog_content);
        this.eyv = (LinearLayout) findViewById(R.id.youngster_dialog_group);
        this.eyz = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_left);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pr(R.color.cp_cont_b);
        this.eyz.setConfig(cVar);
        this.eyA = (TBSpecificationBtn) findViewById(R.id.btn_youngster_dialog_right);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pp(R.color.cp_link_tip_a);
        this.eyA.setConfig(cVar2);
        this.eyB = (NoTipAgainView) findViewById(R.id.no_tip_again);
        onChangeSkinType();
    }

    public boolean bhY() {
        if (this.eyB == null) {
            return false;
        }
        return this.eyB.bhY();
    }

    public void setTxtYoungsterDialogTitleText(int i) {
        this.eyx.setText(getContext().getString(i));
    }

    public void setTxtYoungsterDialogContentText(int i) {
        this.eyy.setText(getContext().getString(i));
    }

    public void setNoTipAgainViewVisible(boolean z) {
        this.eyB.setVisibility(z ? 0 : 8);
    }

    public void setLeftOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eyz != null) {
            this.eyz.setText(getContext().getString(i));
            this.eyz.setOnClickListener(onClickListener);
        }
    }

    public void setRightOnClickListener(int i, View.OnClickListener onClickListener) {
        if (this.eyA != null) {
            this.eyA.setText(getContext().getString(i));
            this.eyA.setOnClickListener(onClickListener);
        }
    }

    public void setYoungsterDialogGroupMarginTop(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eyv.getLayoutParams();
        layoutParams.topMargin = i;
        this.eyv.setLayoutParams(layoutParams);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.transparent_bg);
        this.eyw.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.eyx, R.color.cp_cont_b);
        ap.setViewTextColor(this.eyy, R.color.cp_cont_j);
        this.eyB.onChangeSkinType();
        ap.setBackgroundResource(this.eyu, R.drawable.dialog_background);
        this.eyz.blA();
        this.eyA.blA();
    }
}
