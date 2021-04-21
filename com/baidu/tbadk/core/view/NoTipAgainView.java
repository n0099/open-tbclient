package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.i0.r.s.a;
/* loaded from: classes3.dex */
public class NoTipAgainView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f13111e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13112f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13113g;

    /* renamed from: h  reason: collision with root package name */
    public a.f f13114h;

    public NoTipAgainView(Context context) {
        this(context, null);
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.view_no_tip_again, this);
        this.f13111e = (TextView) findViewById(R.id.no_tip_again_text);
        this.f13112f = (ImageView) findViewById(R.id.checkbox);
        c();
        this.f13112f.setOnClickListener(this);
    }

    public boolean b() {
        return this.f13113g;
    }

    public void c() {
        d();
        SkinManager.setViewTextColor(this.f13111e, R.color.CAM_X0107);
    }

    public final void d() {
        Drawable maskDrawable;
        ImageView imageView = this.f13112f;
        if (imageView == null) {
            return;
        }
        if (this.f13113g) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f13112f) {
            this.f13113g = !this.f13113g;
            d();
            a.f fVar = this.f13114h;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public void setOnNoTipAgainCheckListener(a.f fVar) {
        this.f13114h = fVar;
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoTipAgainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13113g = false;
        a();
    }
}
