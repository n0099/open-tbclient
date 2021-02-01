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
    private ImageView eUK;
    private TextView eUL;
    private boolean eUM;
    private a.c eUN;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUM = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eUL = (TextView) findViewById(R.id.no_tip_again_text);
        this.eUK = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eUK.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eUK) {
            this.eUM = !this.eUM;
            bqu();
            if (this.eUN != null) {
                this.eUN.bqy();
            }
        }
    }

    public void onChangeSkinType() {
        bqu();
        ap.setViewTextColor(this.eUL, R.color.CAM_X0107);
    }

    private void bqu() {
        Drawable a2;
        if (this.eUK != null) {
            ImageView imageView = this.eUK;
            if (this.eUM) {
                a2 = SvgManager.bsR().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bsR().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean bqv() {
        return this.eUM;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eUN = cVar;
    }
}
