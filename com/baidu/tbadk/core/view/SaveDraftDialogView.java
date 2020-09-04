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
/* loaded from: classes.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout esM;
    private TextView esN;
    private TextView esO;
    private TextView esP;
    private TextView esQ;
    private GradientDrawable esR;
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
        this.esM = new LinearLayout(context);
        this.esM.setOrientation(1);
        this.esM.setGravity(17);
        addView(this.esM, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.esM.addView(this.title, -1, -2);
        this.esN = new TextView(context);
        this.esN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.esN.setGravity(17);
        this.esN.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.esM.addView(this.esN, -1, -2);
        this.esO = new TextView(context);
        this.esO.setId(R.id.save_draft_dialog_not_save);
        this.esO.setTextSize(0, dimens);
        this.esO.setGravity(17);
        this.esO.setText(R.string.not_save);
        addView(this.esO, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.esP = new TextView(context);
        this.esP.setId(R.id.save_draft_dialog_save);
        this.esP.setTextSize(0, dimens);
        this.esP.setGravity(17);
        addView(this.esP, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.esQ = new TextView(context);
        this.esQ.setId(R.id.save_draft_dialog_cancle);
        this.esQ.setTextSize(0, dimens);
        this.esQ.setGravity(17);
        this.esQ.setText(R.string.cancel);
        addView(this.esQ, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.esO.setOnClickListener(onClickListener);
        this.esP.setOnClickListener(onClickListener);
        this.esQ.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.esP.setText(str3);
        if (!at.isEmpty(str2)) {
            this.esN.setText(str2);
            this.esN.setVisibility(0);
            return;
        }
        this.esN.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.cp_cont_b);
        ap.setViewTextColor(this.esN, R.color.cp_cont_c);
        ap.setViewTextColor(this.esO, R.color.cp_cont_b);
        ap.setViewTextColor(this.esP, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.esQ, R.color.cp_cont_j);
        if (this.esR == null) {
            this.esR = new GradientDrawable();
            this.esR.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.esR.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackground(this.esR);
    }
}
