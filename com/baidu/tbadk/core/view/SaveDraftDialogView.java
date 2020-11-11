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
    private LinearLayout eVm;
    private TextView eVn;
    private TextView eVo;
    private TextView eVp;
    private TextView eVq;
    private GradientDrawable eVr;
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
        this.eVm = new LinearLayout(context);
        this.eVm.setOrientation(1);
        this.eVm.setGravity(17);
        addView(this.eVm, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.eVm.addView(this.title, -1, -2);
        this.eVn = new TextView(context);
        this.eVn.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.eVn.setGravity(17);
        this.eVn.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.eVm.addView(this.eVn, -1, -2);
        this.eVo = new TextView(context);
        this.eVo.setId(R.id.save_draft_dialog_not_save);
        this.eVo.setTextSize(0, dimens);
        this.eVo.setGravity(17);
        this.eVo.setText(R.string.not_save);
        addView(this.eVo, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eVp = new TextView(context);
        this.eVp.setId(R.id.save_draft_dialog_save);
        this.eVp.setTextSize(0, dimens);
        this.eVp.setGravity(17);
        addView(this.eVp, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eVq = new TextView(context);
        this.eVq.setId(R.id.save_draft_dialog_cancle);
        this.eVq.setTextSize(0, dimens);
        this.eVq.setGravity(17);
        this.eVq.setText(R.string.cancel);
        addView(this.eVq, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eVo.setOnClickListener(onClickListener);
        this.eVp.setOnClickListener(onClickListener);
        this.eVq.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.eVp.setText(str3);
        if (!at.isEmpty(str2)) {
            this.eVn.setText(str2);
            this.eVn.setVisibility(0);
            return;
        }
        this.eVn.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.cp_cont_b);
        ap.setViewTextColor(this.eVn, R.color.cp_cont_c);
        ap.setViewTextColor(this.eVo, R.color.cp_cont_b);
        ap.setViewTextColor(this.eVp, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.eVq, R.color.cp_cont_j);
        if (this.eVr == null) {
            this.eVr = new GradientDrawable();
            this.eVr.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.eVr.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackground(this.eVr);
    }
}
