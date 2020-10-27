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
    private ImageView eBZ;
    private TextView eCa;
    private boolean eCb;
    private a.c eCc;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eCb = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eCa = (TextView) findViewById(R.id.no_tip_again_text);
        this.eBZ = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eBZ.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eBZ) {
            this.eCb = !this.eCb;
            bmz();
            if (this.eCc != null) {
                this.eCc.bmD();
            }
        }
    }

    public void onChangeSkinType() {
        bmz();
        ap.setViewTextColor(this.eCa, R.color.cp_cont_j);
    }

    private void bmz() {
        Drawable a2;
        if (this.eBZ != null) {
            ImageView imageView = this.eBZ;
            if (this.eCb) {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.boN().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean bmA() {
        return this.eCb;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eCc = cVar;
    }
}
