package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout fjk;
    private TextView fjl;
    private TextView fjm;
    private TextView fjn;
    private TextView fjo;
    private GradientDrawable fjp;
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
        this.fjk = new LinearLayout(context);
        this.fjk.setOrientation(1);
        this.fjk.setGravity(17);
        addView(this.fjk, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.fjk.addView(this.title, -1, -2);
        this.fjl = new TextView(context);
        this.fjl.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.fjl.setGravity(17);
        this.fjl.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.fjk.addView(this.fjl, -1, -2);
        this.fjm = new TextView(context);
        this.fjm.setId(R.id.save_draft_dialog_not_save);
        this.fjm.setTextSize(0, dimens);
        this.fjm.setGravity(17);
        this.fjm.setText(R.string.not_save);
        addView(this.fjm, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fjn = new TextView(context);
        this.fjn.setId(R.id.save_draft_dialog_save);
        this.fjn.setTextSize(0, dimens);
        this.fjn.setGravity(17);
        addView(this.fjn, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fjo = new TextView(context);
        this.fjo.setId(R.id.save_draft_dialog_cancle);
        this.fjo.setTextSize(0, dimens);
        this.fjo.setGravity(17);
        this.fjo.setText(R.string.cancel);
        addView(this.fjo, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        buo();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fjm.setOnClickListener(onClickListener);
        this.fjn.setOnClickListener(onClickListener);
        this.fjo.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.fjn.setText(str3);
        if (!au.isEmpty(str2)) {
            this.fjl.setText(str2);
            this.fjl.setVisibility(0);
            return;
        }
        this.fjl.setVisibility(8);
    }

    private void buo() {
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        ap.setViewTextColor(this.fjl, R.color.CAM_X0108);
        ap.setViewTextColor(this.fjm, R.color.CAM_X0105);
        ap.setViewTextColor(this.fjn, R.color.CAM_X0302);
        ap.setViewTextColor(this.fjo, R.color.CAM_X0107);
        if (this.fjp == null) {
            this.fjp = new GradientDrawable();
            this.fjp.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.fjp.setColor(ap.getColor(R.color.CAM_X0211));
        setBackground(this.fjp);
    }
}
