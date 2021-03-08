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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NoTipAgainView extends LinearLayout implements View.OnClickListener {
    private ImageView eWj;
    private TextView eWk;
    private boolean eWl;
    private a.c eWm;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWl = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eWk = (TextView) findViewById(R.id.no_tip_again_text);
        this.eWj = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eWj.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWj) {
            this.eWl = !this.eWl;
            bqw();
            if (this.eWm != null) {
                this.eWm.bqA();
            }
        }
    }

    public void onChangeSkinType() {
        bqw();
        ap.setViewTextColor(this.eWk, R.color.CAM_X0107);
    }

    private void bqw() {
        Drawable a2;
        if (this.eWj != null) {
            ImageView imageView = this.eWj;
            if (this.eWl) {
                a2 = SvgManager.bsU().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsU().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean bqx() {
        return this.eWl;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eWm = cVar;
    }
}
