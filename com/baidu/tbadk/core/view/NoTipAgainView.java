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
    private ImageView eSv;
    private TextView eSw;
    private boolean eSx;
    private a.c eSy;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSx = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eSw = (TextView) findViewById(R.id.no_tip_again_text);
        this.eSv = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eSv.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eSv) {
            this.eSx = !this.eSx;
            bqb();
            if (this.eSy != null) {
                this.eSy.bqf();
            }
        }
    }

    public void onChangeSkinType() {
        bqb();
        ao.setViewTextColor(this.eSw, R.color.CAM_X0107);
    }

    private void bqb() {
        Drawable a2;
        if (this.eSv != null) {
            ImageView imageView = this.eSv;
            if (this.eSx) {
                a2 = SvgManager.bsx().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsx().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean bqc() {
        return this.eSx;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eSy = cVar;
    }
}
