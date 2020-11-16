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
    private ImageView eGg;
    private TextView eGh;
    private boolean eGi;
    private a.c eGj;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eGi = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eGh = (TextView) findViewById(R.id.no_tip_again_text);
        this.eGg = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eGg.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eGg) {
            this.eGi = !this.eGi;
            bod();
            if (this.eGj != null) {
                this.eGj.boh();
            }
        }
    }

    public void onChangeSkinType() {
        bod();
        ap.setViewTextColor(this.eGh, R.color.CAM_X0107);
    }

    private void bod() {
        Drawable a2;
        if (this.eGg != null) {
            ImageView imageView = this.eGg;
            if (this.eGi) {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bqB().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean boe() {
        return this.eGi;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eGj = cVar;
    }
}
