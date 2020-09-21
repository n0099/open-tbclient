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
    private ImageView eht;
    private TextView ehu;
    private boolean ehv;
    private a.c ehw;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ehv = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.ehu = (TextView) findViewById(R.id.no_tip_again_text);
        this.eht = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eht.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eht) {
            this.ehv = !this.ehv;
            bhX();
            if (this.ehw != null) {
                this.ehw.bib();
            }
        }
    }

    public void onChangeSkinType() {
        bhX();
        ap.setViewTextColor(this.ehu, R.color.cp_cont_j);
    }

    private void bhX() {
        Drawable a;
        if (this.eht != null) {
            ImageView imageView = this.eht;
            if (this.ehv) {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bkl().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public boolean bhY() {
        return this.ehv;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.ehw = cVar;
    }
}
