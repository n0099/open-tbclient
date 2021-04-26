package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.a.h0.a.f;
import d.a.h0.a.g;
/* loaded from: classes3.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12197e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12198f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f12199g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12200h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12201i;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f12197e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f12198f = (TextView) findViewById(f.bottom_tab_text);
        this.f12199g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f12200h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean a() {
        return this.f12201i;
    }

    public void setBadgeText(String str) {
        this.f12200h.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.f12200h.setVisibility(0);
        } else {
            this.f12200h.setVisibility(8);
        }
    }

    public void setIconView(int i2) {
        this.f12197e.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.f12199g.setVisibility(0);
        } else {
            this.f12199g.setVisibility(8);
        }
    }

    public void setTextColor(int i2) {
        this.f12198f.setTextColor(i2);
    }

    public void setTextView(String str) {
        this.f12198f.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.f12201i = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.f12197e.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.f12197e.setImageDrawable(drawable);
    }
}
