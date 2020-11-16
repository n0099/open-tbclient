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
    private TextView eUA;
    private TextView eUB;
    private GradientDrawable eUC;
    private LinearLayout eUx;
    private TextView eUy;
    private TextView eUz;
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
        this.eUx = new LinearLayout(context);
        this.eUx.setOrientation(1);
        this.eUx.setGravity(17);
        addView(this.eUx, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.eUx.addView(this.title, -1, -2);
        this.eUy = new TextView(context);
        this.eUy.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.eUy.setGravity(17);
        this.eUy.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.eUx.addView(this.eUy, -1, -2);
        this.eUz = new TextView(context);
        this.eUz.setId(R.id.save_draft_dialog_not_save);
        this.eUz.setTextSize(0, dimens);
        this.eUz.setGravity(17);
        this.eUz.setText(R.string.not_save);
        addView(this.eUz, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eUA = new TextView(context);
        this.eUA.setId(R.id.save_draft_dialog_save);
        this.eUA.setTextSize(0, dimens);
        this.eUA.setGravity(17);
        addView(this.eUA, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.eUB = new TextView(context);
        this.eUB.setId(R.id.save_draft_dialog_cancle);
        this.eUB.setTextSize(0, dimens);
        this.eUB.setGravity(17);
        this.eUB.setText(R.string.cancel);
        addView(this.eUB, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        changeSkin();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUz.setOnClickListener(onClickListener);
        this.eUA.setOnClickListener(onClickListener);
        this.eUB.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.eUA.setText(str3);
        if (!au.isEmpty(str2)) {
            this.eUy.setText(str2);
            this.eUy.setVisibility(0);
            return;
        }
        this.eUy.setVisibility(8);
    }

    private void changeSkin() {
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        ap.setViewTextColor(this.eUy, R.color.CAM_X0108);
        ap.setViewTextColor(this.eUz, R.color.CAM_X0105);
        ap.setViewTextColor(this.eUA, R.color.CAM_X0302);
        ap.setViewTextColor(this.eUB, R.color.CAM_X0107);
        if (this.eUC == null) {
            this.eUC = new GradientDrawable();
            this.eUC.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.eUC.setColor(ap.getColor(R.color.CAM_X0211));
        setBackground(this.eUC);
    }
}
