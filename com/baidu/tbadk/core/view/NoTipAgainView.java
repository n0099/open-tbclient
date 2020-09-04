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
    private ImageView eff;
    private TextView efg;
    private boolean efh;
    private a.c efi;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efh = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.efg = (TextView) findViewById(R.id.no_tip_again_text);
        this.eff = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eff.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eff) {
            this.efh = !this.efh;
            bhd();
            if (this.efi != null) {
                this.efi.bhh();
            }
        }
    }

    public void onChangeSkinType() {
        bhd();
        ap.setViewTextColor(this.efg, R.color.cp_cont_j);
    }

    private void bhd() {
        Drawable a;
        if (this.eff != null) {
            ImageView imageView = this.eff;
            if (this.efh) {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public boolean bhe() {
        return this.efh;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.efi = cVar;
    }
}
