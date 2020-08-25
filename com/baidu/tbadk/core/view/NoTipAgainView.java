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
/* loaded from: classes2.dex */
public class NoTipAgainView extends LinearLayout implements View.OnClickListener {
    private ImageView efb;
    private TextView efc;
    private boolean efd;
    private a.c efe;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efd = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.efc = (TextView) findViewById(R.id.no_tip_again_text);
        this.efb = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.efb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.efb) {
            this.efd = !this.efd;
            bhd();
            if (this.efe != null) {
                this.efe.bhh();
            }
        }
    }

    public void onChangeSkinType() {
        bhd();
        ap.setViewTextColor(this.efc, R.color.cp_cont_j);
    }

    private void bhd() {
        Drawable a;
        if (this.efb != null) {
            ImageView imageView = this.efb;
            if (this.efd) {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a = SvgManager.bjq().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a);
        }
    }

    public boolean bhe() {
        return this.efd;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.efe = cVar;
    }
}
