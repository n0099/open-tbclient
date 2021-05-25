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
    public ImageView f11305e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11306f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f11307g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11308h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11309i;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f11305e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f11306f = (TextView) findViewById(f.bottom_tab_text);
        this.f11307g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f11308h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean a() {
        return this.f11309i;
    }

    public void setBadgeText(String str) {
        this.f11308h.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.f11308h.setVisibility(0);
        } else {
            this.f11308h.setVisibility(8);
        }
    }

    public void setIconView(int i2) {
        this.f11305e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.f11307g.setVisibility(0);
        } else {
            this.f11307g.setVisibility(8);
        }
    }

    public void setTextColor(int i2) {
        this.f11306f.setTextColor(i2);
    }

    public void setTextView(String str) {
        this.f11306f.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.f11309i = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.f11305e.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.f11305e.setImageDrawable(drawable);
    }
}
