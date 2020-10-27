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
    private TextView ePA;
    private TextView ePB;
    private GradientDrawable ePC;
    private LinearLayout ePx;
    private TextView ePy;
    private TextView ePz;
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
        this.ePx = new LinearLayout(context);
        this.ePx.setOrientation(1);
        this.ePx.setGravity(17);
        addView(this.ePx, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.ePx.addView(this.title, -1, -2);
        this.ePy = new TextView(context);
        this.ePy.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.ePy.setGravity(17);
        this.ePy.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.ePx.addView(this.ePy, -1, -2);
        this.ePz = new TextView(context);
        this.ePz.setId(R.id.save_draft_dialog_not_save);
        this.ePz.setTextSize(0, dimens);
        this.ePz.setGravity(17);
        this.ePz.setText(R.string.not_save);
        addView(this.ePz, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.ePA = new TextView(context);
        this.ePA.setId(R.id.save_draft_dialog_save);
        this.ePA.setTextSize(0, dimens);
        this.ePA.setGravity(17);
        addView(this.ePA, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.ePB = new TextView(context);
        this.ePB.setId(R.id.save_draft_dialog_cancle);
        this.ePB.setTextSize(0, dimens);
        this.ePB.setGravity(17);
        this.ePB.setText(R.string.cancel);
        addView(this.ePB, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ePz.setOnClickListener(onClickListener);
        this.ePA.setOnClickListener(onClickListener);
        this.ePB.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.ePA.setText(str3);
        if (!at.isEmpty(str2)) {
            this.ePy.setText(str2);
            this.ePy.setVisibility(0);
            return;
        }
        this.ePy.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.cp_cont_b);
        ap.setViewTextColor(this.ePy, R.color.cp_cont_c);
        ap.setViewTextColor(this.ePz, R.color.cp_cont_b);
        ap.setViewTextColor(this.ePA, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.ePB, R.color.cp_cont_j);
        if (this.ePC == null) {
            this.ePC = new GradientDrawable();
            this.ePC.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.ePC.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackground(this.ePC);
    }
}
