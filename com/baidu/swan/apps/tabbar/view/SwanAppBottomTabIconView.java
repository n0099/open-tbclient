package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.i0.a.f;
import d.a.i0.a.g;
/* loaded from: classes3.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11404e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11405f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f11406g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11407h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11408i;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f11404e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f11405f = (TextView) findViewById(f.bottom_tab_text);
        this.f11406g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f11407h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean a() {
        return this.f11408i;
    }

    public void setBadgeText(String str) {
        this.f11407h.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.f11407h.setVisibility(0);
        } else {
            this.f11407h.setVisibility(8);
        }
    }

    public void setIconView(int i2) {
        this.f11404e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.f11406g.setVisibility(0);
        } else {
            this.f11406g.setVisibility(8);
        }
    }

    public void setTextColor(int i2) {
        this.f11405f.setTextColor(i2);
    }

    public void setTextView(String str) {
        this.f11405f.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.f11408i = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.f11404e.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.f11404e.setImageDrawable(drawable);
    }
}
