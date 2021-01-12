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
    private TbImageView bbt;
    private View beQ;
    private TextView beR;
    private ImageView beS;
    private TextView beT;

    public GiftPanelPackageFragmentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(aa.a aVar) {
        if (aVar != null) {
            if (this.bbt != null && (TextUtils.isEmpty(this.bbt.getUrl()) || !this.bbt.getUrl().equals(aVar.pic))) {
                this.bbt.startLoad(!TextUtils.isEmpty(aVar.pic) ? aVar.pic : "", 10, false, false);
            }
            if (this.beR != null) {
                this.beR.setText(!TextUtils.isEmpty(aVar.name) ? aVar.name : "");
            }
            if (this.beS != null) {
                this.beS.setVisibility(aVar.aUU ? 0 : 8);
            }
            if (aVar.num > 0) {
                if (this.beQ != null) {
                    this.beQ.setAlpha(1.0f);
                }
                if (this.beT != null) {
                    this.beT.setText(aVar.num > 99 ? "99+" : String.valueOf(aVar.num));
                    this.beT.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.beQ != null) {
                this.beQ.setAlpha(0.3f);
            }
            if (this.beT != null) {
                this.beT.setVisibility(4);
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.live_gift_panel_package_fragment_item, (ViewGroup) this, true);
        this.beQ = findViewById(a.f.layout_primary);
        this.bbt = (TbImageView) findViewById(a.f.iv_thumb);
        this.beR = (TextView) findViewById(a.f.tv_name);
        this.beS = (ImageView) findViewById(a.f.iv_rare);
        this.beT = (TextView) findViewById(a.f.tv_count);
        this.bbt.setDefaultBgResource(a.c.sdk_transparent);
        this.bbt.setDefaultErrorResource(a.e.sdk_shape_transparent);
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
        this.beT.setBackgroundDrawable(gradientDrawable);
        setSelected(false);
    }
}
