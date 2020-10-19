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
    private LinearLayout eHb;
    private TextView eHc;
    private TextView eHd;
    private TextView eHe;
    private TextView eHf;
    private GradientDrawable eHg;
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
        this.eHb = new LinearLayout(context);
        this.eHb.setOrientation(1);
        this.eHb.setGravity(17);
        addView(this.eHb, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.eHb.addView(this.title, -1, -2);
        this.eHc = new TextView(context);
        this.eHc.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.eHc.setGravity(17);
        this.eHc.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.eHb.addView(this.eHc, -1, -2);
        this.eHd = new TextView(context);
        this.eHd.setId(R.id.save_draft_dialog_not_save);
        this.eHd.setTextSize(0, dimens);
        this.eHd.setGravity(17);
        this.eHd.setText(R.string.not_save);
        addView(this.eHd, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eHe = new TextView(context);
        this.eHe.setId(R.id.save_draft_dialog_save);
        this.eHe.setTextSize(0, dimens);
        this.eHe.setGravity(17);
        addView(this.eHe, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eHf = new TextView(context);
        this.eHf.setId(R.id.save_draft_dialog_cancle);
        this.eHf.setTextSize(0, dimens);
        this.eHf.setGravity(17);
        this.eHf.setText(R.string.cancel);
        addView(this.eHf, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eHd.setOnClickListener(onClickListener);
        this.eHe.setOnClickListener(onClickListener);
        this.eHf.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.eHe.setText(str3);
        if (!at.isEmpty(str2)) {
            this.eHc.setText(str2);
            this.eHc.setVisibility(0);
            return;
        }
        this.eHc.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.cp_cont_b);
        ap.setViewTextColor(this.eHc, R.color.cp_cont_c);
        ap.setViewTextColor(this.eHd, R.color.cp_cont_b);
        ap.setViewTextColor(this.eHe, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.eHf, R.color.cp_cont_j);
        if (this.eHg == null) {
            this.eHg = new GradientDrawable();
            this.eHg.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.eHg.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackground(this.eHg);
    }
}
