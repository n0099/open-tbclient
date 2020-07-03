package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SaveDraftDialogView extends LinearLayout {
    private LinearLayout ecF;
    private TextView ecG;
    private TextView ecH;
    private TextView ecI;
    private TextView ecJ;
    private GradientDrawable ecK;
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
        this.ecF = new LinearLayout(context);
        this.ecF.setOrientation(1);
        this.ecF.setGravity(17);
        addView(this.ecF, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.ecF.addView(this.title, -1, -2);
        this.ecG = new TextView(context);
        this.ecG.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.ecG.setGravity(17);
        this.ecG.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.ecF.addView(this.ecG, -1, -2);
        this.ecH = new TextView(context);
        this.ecH.setId(R.id.save_draft_dialog_not_save);
        this.ecH.setTextSize(0, dimens);
        this.ecH.setGravity(17);
        this.ecH.setText(R.string.not_save);
        addView(this.ecH, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.ecI = new TextView(context);
        this.ecI.setId(R.id.save_draft_dialog_save);
        this.ecI.setTextSize(0, dimens);
        this.ecI.setGravity(17);
        addView(this.ecI, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.ecJ = new TextView(context);
        this.ecJ.setId(R.id.save_draft_dialog_cancle);
        this.ecJ.setTextSize(0, dimens);
        this.ecJ.setGravity(17);
        this.ecJ.setText(R.string.cancel);
        addView(this.ecJ, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        aYi();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ecH.setOnClickListener(onClickListener);
        this.ecI.setOnClickListener(onClickListener);
        this.ecJ.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.ecI.setText(str3);
        if (!ar.isEmpty(str2)) {
            this.ecG.setText(str2);
            this.ecG.setVisibility(0);
            return;
        }
        this.ecG.setVisibility(8);
    }

    private void aYi() {
        an.setViewTextColor(this.title, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ecG, (int) R.color.cp_cont_c);
        an.setViewTextColor(this.ecH, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ecI, (int) R.color.cp_link_tip_a);
        an.setViewTextColor(this.ecJ, (int) R.color.cp_cont_j);
        if (this.ecK == null) {
            this.ecK = new GradientDrawable();
            this.ecK.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.ecK.setColor(an.getColor(R.color.cp_bg_line_k));
        setBackground(this.ecK);
    }
}
