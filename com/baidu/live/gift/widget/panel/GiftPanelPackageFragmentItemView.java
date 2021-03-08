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
/* loaded from: classes10.dex */
public class GiftPanelPackageFragmentItemView extends RelativeLayout {
    private TbImageView bgc;
    private View bjA;
    private TextView bjB;
    private ImageView bjC;
    private TextView bjD;

    public GiftPanelPackageFragmentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(aa.a aVar) {
        if (aVar != null) {
            if (this.bgc != null && (TextUtils.isEmpty(this.bgc.getUrl()) || !this.bgc.getUrl().equals(aVar.pic))) {
                this.bgc.startLoad(!TextUtils.isEmpty(aVar.pic) ? aVar.pic : "", 10, false, false);
            }
            if (this.bjB != null) {
                this.bjB.setText(!TextUtils.isEmpty(aVar.name) ? aVar.name : "");
            }
            if (this.bjC != null) {
                this.bjC.setVisibility(aVar.aZC ? 0 : 8);
            }
            if (aVar.num > 0) {
                if (this.bjA != null) {
                    this.bjA.setAlpha(1.0f);
                }
                if (this.bjD != null) {
                    this.bjD.setText(aVar.num > 99 ? "99+" : String.valueOf(aVar.num));
                    this.bjD.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.bjA != null) {
                this.bjA.setAlpha(0.3f);
            }
            if (this.bjD != null) {
                this.bjD.setVisibility(4);
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_package_fragment_item, (ViewGroup) this, true);
        this.bjA = findViewById(a.f.layout_primary);
        this.bgc = (TbImageView) findViewById(a.f.iv_thumb);
        this.bjB = (TextView) findViewById(a.f.tv_name);
        this.bjC = (ImageView) findViewById(a.f.iv_rare);
        this.bjD = (TextView) findViewById(a.f.tv_count);
        this.bgc.setDefaultBgResource(a.c.sdk_transparent);
        this.bgc.setDefaultErrorResource(a.e.sdk_shape_transparent);
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
        this.bjD.setBackgroundDrawable(gradientDrawable);
        setSelected(false);
    }
}
