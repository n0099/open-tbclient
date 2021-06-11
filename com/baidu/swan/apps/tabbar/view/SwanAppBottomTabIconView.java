package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.l0.a.f;
import d.a.l0.a.g;
/* loaded from: classes3.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11367e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11368f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f11369g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11370h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11371i;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f11367e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f11368f = (TextView) findViewById(f.bottom_tab_text);
        this.f11369g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f11370h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean a() {
        return this.f11371i;
    }

    public void setBadgeText(String str) {
        this.f11370h.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.f11370h.setVisibility(0);
        } else {
            this.f11370h.setVisibility(8);
        }
    }

    public void setIconView(int i2) {
        this.f11367e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.f11369g.setVisibility(0);
        } else {
            this.f11369g.setVisibility(8);
        }
    }

    public void setTextColor(int i2) {
        this.f11368f.setTextColor(i2);
    }

    public void setTextView(String str) {
        this.f11368f.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.f11371i = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.f11367e.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.f11367e.setImageDrawable(drawable);
    }
}
