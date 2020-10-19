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
    private ImageView etA;
    private TextView etB;
    private boolean etC;
    private a.c etD;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etC = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.etB = (TextView) findViewById(R.id.no_tip_again_text);
        this.etA = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.etA.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.etA) {
            this.etC = !this.etC;
            bkG();
            if (this.etD != null) {
                this.etD.bkK();
            }
        }
    }

    public void onChangeSkinType() {
        bkG();
        ap.setViewTextColor(this.etB, R.color.cp_cont_j);
    }

    private void bkG() {
        Drawable a2;
        if (this.etA != null) {
            ImageView imageView = this.etA;
            if (this.etC) {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.bmU().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean bkH() {
        return this.etC;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.etD = cVar;
    }
}
