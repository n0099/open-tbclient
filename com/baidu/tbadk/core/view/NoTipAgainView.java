package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoTipAgainView extends LinearLayout implements View.OnClickListener {
    private ImageView eXg;
    private TextView eXh;
    private boolean eXi;
    private a.c eXj;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eXi = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eXh = (TextView) findViewById(R.id.no_tip_again_text);
        this.eXg = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eXg.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXg) {
            this.eXi = !this.eXi;
            btV();
            if (this.eXj != null) {
                this.eXj.btZ();
            }
        }
    }

    public void onChangeSkinType() {
        btV();
        ao.setViewTextColor(this.eXh, R.color.CAM_X0107);
    }

    private void btV() {
        Drawable a2;
        if (this.eXg != null) {
            ImageView imageView = this.eXg;
            if (this.eXi) {
                a2 = SvgManager.bwr().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bwr().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean btW() {
        return this.eXi;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eXj = cVar;
    }
}
