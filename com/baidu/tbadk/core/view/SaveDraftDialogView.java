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
    private LinearLayout flC;
    private TextView flD;
    private TextView flE;
    private TextView flF;
    private TextView flG;
    private GradientDrawable flH;
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
        this.flC = new LinearLayout(context);
        this.flC.setOrientation(1);
        this.flC.setGravity(17);
        addView(this.flC, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.flC.addView(this.title, -1, -2);
        this.flD = new TextView(context);
        this.flD.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.flD.setGravity(17);
        this.flD.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.flC.addView(this.flD, -1, -2);
        this.flE = new TextView(context);
        this.flE.setId(R.id.save_draft_dialog_not_save);
        this.flE.setTextSize(0, dimens);
        this.flE.setGravity(17);
        this.flE.setText(R.string.not_save);
        addView(this.flE, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.flF = new TextView(context);
        this.flF.setId(R.id.save_draft_dialog_save);
        this.flF.setTextSize(0, dimens);
        this.flF.setGravity(17);
        addView(this.flF, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.flG = new TextView(context);
        this.flG.setId(R.id.save_draft_dialog_cancle);
        this.flG.setTextSize(0, dimens);
        this.flG.setGravity(17);
        this.flG.setText(R.string.cancel);
        addView(this.flG, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        bxN();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.flE.setOnClickListener(onClickListener);
        this.flF.setOnClickListener(onClickListener);
        this.flG.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.flF.setText(str3);
        if (!at.isEmpty(str2)) {
            this.flD.setText(str2);
            this.flD.setVisibility(0);
            return;
        }
        this.flD.setVisibility(8);
    }

    private void bxN() {
        ao.setViewTextColor(this.title, R.color.CAM_X0105);
        ao.setViewTextColor(this.flD, R.color.CAM_X0108);
        ao.setViewTextColor(this.flE, R.color.CAM_X0105);
        ao.setViewTextColor(this.flF, R.color.CAM_X0302);
        ao.setViewTextColor(this.flG, R.color.CAM_X0107);
        if (this.flH == null) {
            this.flH = new GradientDrawable();
            this.flH.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.flH.setColor(ao.getColor(R.color.CAM_X0211));
        setBackground(this.flH);
    }
}
