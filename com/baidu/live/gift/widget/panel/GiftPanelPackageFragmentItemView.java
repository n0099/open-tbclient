package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.gift.aa;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class GiftPanelPackageFragmentItemView extends RelativeLayout {
    private TbImageView bey;
    private View bhY;
    private TextView bhZ;
    private ImageView bia;
    private TextView bib;

    public GiftPanelPackageFragmentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(aa.a aVar) {
        if (aVar != null) {
            if (this.bey != null && (TextUtils.isEmpty(this.bey.getUrl()) || !this.bey.getUrl().equals(aVar.pic))) {
                this.bey.startLoad(!TextUtils.isEmpty(aVar.pic) ? aVar.pic : "", 10, false, false);
            }
            if (this.bhZ != null) {
                this.bhZ.setText(!TextUtils.isEmpty(aVar.name) ? aVar.name : "");
            }
            if (this.bia != null) {
                this.bia.setVisibility(aVar.aYc ? 0 : 8);
            }
            if (aVar.num > 0) {
                if (this.bhY != null) {
                    this.bhY.setAlpha(1.0f);
                }
                if (this.bib != null) {
                    this.bib.setText(aVar.num > 99 ? "99+" : String.valueOf(aVar.num));
                    this.bib.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.bhY != null) {
                this.bhY.setAlpha(0.3f);
            }
            if (this.bib != null) {
                this.bib.setVisibility(4);
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_package_fragment_item, (ViewGroup) this, true);
        this.bhY = findViewById(a.f.layout_primary);
        this.bey = (TbImageView) findViewById(a.f.iv_thumb);
        this.bhZ = (TextView) findViewById(a.f.tv_name);
        this.bia = (ImageView) findViewById(a.f.iv_rare);
        this.bib = (TextView) findViewById(a.f.tv_count);
        this.bey.setDefaultBgResource(a.c.sdk_transparent);
        this.bey.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{-49865, -40664});
        } else {
            gradientDrawable.setColor(-49865);
        }
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds12));
        this.bib.setBackgroundDrawable(gradientDrawable);
        setSelected(false);
    }
}
