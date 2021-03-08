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
    private LinearLayout fkJ;
    private TextView fkK;
    private TextView fkL;
    private TextView fkM;
    private TextView fkN;
    private GradientDrawable fkO;
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
        this.fkJ = new LinearLayout(context);
        this.fkJ.setOrientation(1);
        this.fkJ.setGravity(17);
        addView(this.fkJ, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds182));
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        this.title = new TextView(context);
        this.title.setTextSize(0, dimens);
        this.title.setGravity(17);
        this.fkJ.addView(this.title, -1, -2);
        this.fkK = new TextView(context);
        this.fkK.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds34));
        this.fkK.setGravity(17);
        this.fkK.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10), 0, 0);
        this.fkJ.addView(this.fkK, -1, -2);
        this.fkL = new TextView(context);
        this.fkL.setId(R.id.save_draft_dialog_not_save);
        this.fkL.setTextSize(0, dimens);
        this.fkL.setGravity(17);
        this.fkL.setText(R.string.not_save);
        addView(this.fkL, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fkM = new TextView(context);
        this.fkM.setId(R.id.save_draft_dialog_save);
        this.fkM.setTextSize(0, dimens);
        this.fkM.setGravity(17);
        addView(this.fkM, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        this.fkN = new TextView(context);
        this.fkN.setId(R.id.save_draft_dialog_cancle);
        this.fkN.setTextSize(0, dimens);
        this.fkN.setGravity(17);
        this.fkN.setText(R.string.cancel);
        addView(this.fkN, -1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136));
        bur();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fkL.setOnClickListener(onClickListener);
        this.fkM.setOnClickListener(onClickListener);
        this.fkN.setOnClickListener(onClickListener);
    }

    public void setText(String str, @Nullable String str2, String str3) {
        this.title.setText(str);
        this.fkM.setText(str3);
        if (!au.isEmpty(str2)) {
            this.fkK.setText(str2);
            this.fkK.setVisibility(0);
            return;
        }
        this.fkK.setVisibility(8);
    }

    private void bur() {
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        ap.setViewTextColor(this.fkK, R.color.CAM_X0108);
        ap.setViewTextColor(this.fkL, R.color.CAM_X0105);
        ap.setViewTextColor(this.fkM, R.color.CAM_X0302);
        ap.setViewTextColor(this.fkN, R.color.CAM_X0107);
        if (this.fkO == null) {
            this.fkO = new GradientDrawable();
            this.fkO.setCornerRadii(new float[]{com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds31), 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.fkO.setColor(ap.getColor(R.color.CAM_X0211));
        setBackground(this.fkO);
    }
}
