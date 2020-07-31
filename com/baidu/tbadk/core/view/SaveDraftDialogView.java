package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout eiP;
    private TextView eiQ;
    private TextView eiR;
    private TextView eiS;
    private TextView eiT;
    private GradientDrawable eiU;
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
        this.eiP = new LinearLayout(context);
        this.eiP.setOrientation(1);
        this.eiP.setGravity(17);
        addView(this.eiP, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.eiP.addView(this.title, -1, -2);
        this.eiQ = new TextView(context);
        this.eiQ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.eiQ.setGravity(17);
        this.eiQ.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.eiP.addView(this.eiQ, -1, -2);
        this.eiR = new TextView(context);
        this.eiR.setId(R.id.save_draft_dialog_not_save);
        this.eiR.setTextSize(0, dimens);
        this.eiR.setGravity(17);
        this.eiR.setText(R.string.not_save);
        addView(this.eiR, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eiS = new TextView(context);
        this.eiS.setId(R.id.save_draft_dialog_save);
        this.eiS.setTextSize(0, dimens);
        this.eiS.setGravity(17);
        addView(this.eiS, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eiT = new TextView(context);
        this.eiT.setId(R.id.save_draft_dialog_cancle);
        this.eiT.setTextSize(0, dimens);
        this.eiT.setGravity(17);
        this.eiT.setText(R.string.cancel);
        addView(this.eiT, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eiR.setOnClickListener(onClickListener);
        this.eiS.setOnClickListener(onClickListener);
        this.eiT.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.eiS.setText(str3);
        if (!as.isEmpty(str2)) {
            this.eiQ.setText(str2);
            this.eiQ.setVisibility(0);
            return;
        }
        this.eiQ.setVisibility(8);
    }

    private void changeSkin() {
        ao.setViewTextColor(this.title, R.color.cp_cont_b);
        ao.setViewTextColor(this.eiQ, R.color.cp_cont_c);
        ao.setViewTextColor(this.eiR, R.color.cp_cont_b);
        ao.setViewTextColor(this.eiS, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.eiT, R.color.cp_cont_j);
        if (this.eiU == null) {
            this.eiU = new GradientDrawable();
            this.eiU.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.eiU.setColor(ao.getColor(R.color.cp_bg_line_k));
        setBackground(this.eiU);
    }
}
