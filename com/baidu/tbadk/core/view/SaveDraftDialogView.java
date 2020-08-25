package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout esI;
    private TextView esJ;
    private TextView esK;
    private TextView esL;
    private TextView esM;
    private GradientDrawable esN;
    private TextView title;

    public SaveDraftDialogView(Context context) {
        super(context);
        init(context);
    }

    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SaveDraftDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21));
        this.esI = new LinearLayout(context);
        this.esI.setOrientation(1);
        this.esI.setGravity(17);
        addView(this.esI, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.esI.addView(this.title, -1, -2);
        this.esJ = new TextView(context);
        this.esJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.esJ.setGravity(17);
        this.esJ.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.esI.addView(this.esJ, -1, -2);
        this.esK = new TextView(context);
        this.esK.setId(R.id.save_draft_dialog_not_save);
        this.esK.setTextSize(0, dimens);
        this.esK.setGravity(17);
        this.esK.setText(R.string.not_save);
        addView(this.esK, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.esL = new TextView(context);
        this.esL.setId(R.id.save_draft_dialog_save);
        this.esL.setTextSize(0, dimens);
        this.esL.setGravity(17);
        addView(this.esL, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.esM = new TextView(context);
        this.esM.setId(R.id.save_draft_dialog_cancle);
        this.esM.setTextSize(0, dimens);
        this.esM.setGravity(17);
        this.esM.setText(R.string.cancel);
        addView(this.esM, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.esK.setOnClickListener(onClickListener);
        this.esL.setOnClickListener(onClickListener);
        this.esM.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.esL.setText(str3);
        if (!at.isEmpty(str2)) {
            this.esJ.setText(str2);
            this.esJ.setVisibility(0);
            return;
        }
        this.esJ.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.cp_cont_b);
        ap.setViewTextColor(this.esJ, R.color.cp_cont_c);
        ap.setViewTextColor(this.esK, R.color.cp_cont_b);
        ap.setViewTextColor(this.esL, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.esM, R.color.cp_cont_j);
        if (this.esN == null) {
            this.esN = new GradientDrawable();
            this.esN.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.esN.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackground(this.esN);
    }
}
