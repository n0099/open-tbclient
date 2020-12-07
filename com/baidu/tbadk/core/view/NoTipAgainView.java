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
    private ImageView eNj;
    private TextView eNk;
    private boolean eNl;
    private a.c eNm;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eNl = false;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_no_tip_again, this);
        this.eNk = (TextView) findViewById(R.id.no_tip_again_text);
        this.eNj = (ImageView) findViewById(R.id.checkbox);
        onChangeSkinType();
        this.eNj.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNj) {
            this.eNl = !this.eNl;
            brs();
            if (this.eNm != null) {
                this.eNm.brw();
            }
        }
    }

    public void onChangeSkinType() {
        brs();
        ap.setViewTextColor(this.eNk, R.color.CAM_X0107);
    }

    private void brs() {
        Drawable a2;
        if (this.eNj != null) {
            ImageView imageView = this.eNj;
            if (this.eNl) {
                a2 = SvgManager.btW().a(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                a2 = SvgManager.btW().a(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(a2);
        }
    }

    public boolean brt() {
        return this.eNl;
    }

    public void setOnNoTipAgainCheckListener(a.c cVar) {
        this.eNm = cVar;
    }
}
