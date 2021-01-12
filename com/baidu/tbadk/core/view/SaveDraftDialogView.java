package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout fgR;
    private TextView fgS;
    private TextView fgT;
    private TextView fgU;
    private TextView fgV;
    private GradientDrawable fgW;
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
        this.fgR = new LinearLayout(context);
        this.fgR.setOrientation(1);
        this.fgR.setGravity(17);
        addView(this.fgR, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.fgR.addView(this.title, -1, -2);
        this.fgS = new TextView(context);
        this.fgS.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.fgS.setGravity(17);
        this.fgS.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.fgR.addView(this.fgS, -1, -2);
        this.fgT = new TextView(context);
        this.fgT.setId(R.id.save_draft_dialog_not_save);
        this.fgT.setTextSize(0, dimens);
        this.fgT.setGravity(17);
        this.fgT.setText(R.string.not_save);
        addView(this.fgT, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fgU = new TextView(context);
        this.fgU.setId(R.id.save_draft_dialog_save);
        this.fgU.setTextSize(0, dimens);
        this.fgU.setGravity(17);
        addView(this.fgU, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fgV = new TextView(context);
        this.fgV.setId(R.id.save_draft_dialog_cancle);
        this.fgV.setTextSize(0, dimens);
        this.fgV.setGravity(17);
        this.fgV.setText(R.string.cancel);
        addView(this.fgV, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        btU();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fgT.setOnClickListener(onClickListener);
        this.fgU.setOnClickListener(onClickListener);
        this.fgV.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.fgU.setText(str3);
        if (!at.isEmpty(str2)) {
            this.fgS.setText(str2);
            this.fgS.setVisibility(0);
            return;
        }
        this.fgS.setVisibility(8);
    }

    private void btU() {
        ao.setViewTextColor(this.title, R.color.CAM_X0105);
        ao.setViewTextColor(this.fgS, R.color.CAM_X0108);
        ao.setViewTextColor(this.fgT, R.color.CAM_X0105);
        ao.setViewTextColor(this.fgU, R.color.CAM_X0302);
        ao.setViewTextColor(this.fgV, R.color.CAM_X0107);
        if (this.fgW == null) {
            this.fgW = new GradientDrawable();
            this.fgW.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.fgW.setColor(ao.getColor(R.color.CAM_X0211));
        setBackground(this.fgW);
    }
}
