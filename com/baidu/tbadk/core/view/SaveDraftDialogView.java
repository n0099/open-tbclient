package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout fbT;
    private TextView fbU;
    private TextView fbV;
    private TextView fbW;
    private TextView fbX;
    private GradientDrawable fbY;
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
        this.fbT = new LinearLayout(context);
        this.fbT.setOrientation(1);
        this.fbT.setGravity(17);
        addView(this.fbT, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.fbT.addView(this.title, -1, -2);
        this.fbU = new TextView(context);
        this.fbU.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.fbU.setGravity(17);
        this.fbU.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.fbT.addView(this.fbU, -1, -2);
        this.fbV = new TextView(context);
        this.fbV.setId(R.id.save_draft_dialog_not_save);
        this.fbV.setTextSize(0, dimens);
        this.fbV.setGravity(17);
        this.fbV.setText(R.string.not_save);
        addView(this.fbV, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fbW = new TextView(context);
        this.fbW.setId(R.id.save_draft_dialog_save);
        this.fbW.setTextSize(0, dimens);
        this.fbW.setGravity(17);
        addView(this.fbW, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fbX = new TextView(context);
        this.fbX.setId(R.id.save_draft_dialog_cancle);
        this.fbX.setTextSize(0, dimens);
        this.fbX.setGravity(17);
        this.fbX.setText(R.string.cancel);
        addView(this.fbX, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        bvs();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fbV.setOnClickListener(onClickListener);
        this.fbW.setOnClickListener(onClickListener);
        this.fbX.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.fbW.setText(str3);
        if (!au.isEmpty(str2)) {
            this.fbU.setText(str2);
            this.fbU.setVisibility(0);
            return;
        }
        this.fbU.setVisibility(8);
    }

    private void bvs() {
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        ap.setViewTextColor(this.fbU, R.color.CAM_X0108);
        ap.setViewTextColor(this.fbV, R.color.CAM_X0105);
        ap.setViewTextColor(this.fbW, R.color.CAM_X0302);
        ap.setViewTextColor(this.fbX, R.color.CAM_X0107);
        if (this.fbY == null) {
            this.fbY = new GradientDrawable();
            this.fbY.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.fbY.setColor(ap.getColor(R.color.CAM_X0211));
        setBackground(this.fbY);
    }
}
