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
    private LinearLayout euR;
    private TextView euS;
    private TextView euT;
    private TextView euU;
    private TextView euV;
    private GradientDrawable euW;
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
        this.euR = new LinearLayout(context);
        this.euR.setOrientation(1);
        this.euR.setGravity(17);
        addView(this.euR, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.euR.addView(this.title, -1, -2);
        this.euS = new TextView(context);
        this.euS.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.euS.setGravity(17);
        this.euS.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.euR.addView(this.euS, -1, -2);
        this.euT = new TextView(context);
        this.euT.setId(R.id.save_draft_dialog_not_save);
        this.euT.setTextSize(0, dimens);
        this.euT.setGravity(17);
        this.euT.setText(R.string.not_save);
        addView(this.euT, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.euU = new TextView(context);
        this.euU.setId(R.id.save_draft_dialog_save);
        this.euU.setTextSize(0, dimens);
        this.euU.setGravity(17);
        addView(this.euU, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.euV = new TextView(context);
        this.euV.setId(R.id.save_draft_dialog_cancle);
        this.euV.setTextSize(0, dimens);
        this.euV.setGravity(17);
        this.euV.setText(R.string.cancel);
        addView(this.euV, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.euT.setOnClickListener(onClickListener);
        this.euU.setOnClickListener(onClickListener);
        this.euV.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.euU.setText(str3);
        if (!at.isEmpty(str2)) {
            this.euS.setText(str2);
            this.euS.setVisibility(0);
            return;
        }
        this.euS.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.cp_cont_b);
        ap.setViewTextColor(this.euS, R.color.cp_cont_c);
        ap.setViewTextColor(this.euT, R.color.cp_cont_b);
        ap.setViewTextColor(this.euU, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.euV, R.color.cp_cont_j);
        if (this.euW == null) {
            this.euW = new GradientDrawable();
            this.euW.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.euW.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackground(this.euW);
    }
}
