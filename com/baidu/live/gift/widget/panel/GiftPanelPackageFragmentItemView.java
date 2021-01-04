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
/* loaded from: classes11.dex */
public class GiftPanelPackageFragmentItemView extends RelativeLayout {
    private TbImageView bgj;
    private View bjH;
    private TextView bjI;
    private ImageView bjJ;
    private TextView bjK;

    public GiftPanelPackageFragmentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(aa.a aVar) {
        if (aVar != null) {
            if (this.bgj != null && (TextUtils.isEmpty(this.bgj.getUrl()) || !this.bgj.getUrl().equals(aVar.pic))) {
                this.bgj.startLoad(!TextUtils.isEmpty(aVar.pic) ? aVar.pic : "", 10, false, false);
            }
            if (this.bjI != null) {
                this.bjI.setText(!TextUtils.isEmpty(aVar.name) ? aVar.name : "");
            }
            if (this.bjJ != null) {
                this.bjJ.setVisibility(aVar.aZH ? 0 : 8);
            }
            if (aVar.num > 0) {
                if (this.bjH != null) {
                    this.bjH.setAlpha(1.0f);
                }
                if (this.bjK != null) {
                    this.bjK.setText(aVar.num > 99 ? "99+" : String.valueOf(aVar.num));
                    this.bjK.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.bjH != null) {
                this.bjH.setAlpha(0.3f);
            }
            if (this.bjK != null) {
                this.bjK.setVisibility(4);
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_package_fragment_item, (ViewGroup) this, true);
        this.bjH = findViewById(a.f.layout_primary);
        this.bgj = (TbImageView) findViewById(a.f.iv_thumb);
        this.bjI = (TextView) findViewById(a.f.tv_name);
        this.bjJ = (ImageView) findViewById(a.f.iv_rare);
        this.bjK = (TextView) findViewById(a.f.tv_count);
        this.bgj.setDefaultBgResource(a.c.sdk_transparent);
        this.bgj.setDefaultErrorResource(a.e.sdk_shape_transparent);
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
        this.bjK.setBackgroundDrawable(gradientDrawable);
        setSelected(false);
    }
}
