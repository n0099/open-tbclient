package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoTipAgainView extends LinearLayout implements View.OnClickListener {
    private ImageView eHO;
    private TextView eHP;
    private boolean eHQ;
    private a.c eHR;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHQ = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eHP = (TextView) findViewById(R.id.no_tip_again_text);
        this.eHO = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eHO.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eHO) {
            this.eHQ = !this.eHQ;
            boZ();
            if (this.eHR != null) {
                this.eHR.bpd();
            }
        }
    }

    public void onChangeSkinType() {
        boZ();
        ap.setViewTextColor(this.eHP, R.color.cp_cont_j);
    }

    private void boZ() {
        Drawable a2;
        if (this.eHO != null) {
            ImageView imageView = this.eHO;
            if (this.eHQ) {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.brn().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean bpa() {
        return this.eHQ;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eHR = cVar;
    }
}
