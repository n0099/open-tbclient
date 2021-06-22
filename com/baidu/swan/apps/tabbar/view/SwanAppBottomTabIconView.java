package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.m0.a.f;
import d.a.m0.a.g;
/* loaded from: classes3.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11449e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11450f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f11451g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11452h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11453i;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f11449e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f11450f = (TextView) findViewById(f.bottom_tab_text);
        this.f11451g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f11452h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean a() {
        return this.f11453i;
    }

    public void setBadgeText(String str) {
        this.f11452h.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.f11452h.setVisibility(0);
        } else {
            this.f11452h.setVisibility(8);
        }
    }

    public void setIconView(int i2) {
        this.f11449e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.f11451g.setVisibility(0);
        } else {
            this.f11451g.setVisibility(8);
        }
    }

    public void setTextColor(int i2) {
        this.f11450f.setTextColor(i2);
    }

    public void setTextView(String str) {
        this.f11450f.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.f11453i = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.f11449e.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.f11449e.setImageDrawable(drawable);
    }
}
