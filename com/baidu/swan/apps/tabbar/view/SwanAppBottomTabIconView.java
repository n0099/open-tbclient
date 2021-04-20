package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import d.b.g0.a.f;
import d.b.g0.a.g;
/* loaded from: classes3.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12317e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12318f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f12319g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12320h;
    public boolean i;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.f12317e = (ImageView) findViewById(f.bottom_tab_icon);
        this.f12318f = (TextView) findViewById(f.bottom_tab_text);
        this.f12319g = (ImageView) findViewById(f.bottom_tab_red_dot);
        this.f12320h = (TextView) findViewById(f.bottom_tab_badge);
    }

    public boolean a() {
        return this.i;
    }

    public void setBadgeText(String str) {
        this.f12320h.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.f12320h.setVisibility(0);
        } else {
            this.f12320h.setVisibility(8);
        }
    }

    public void setIconView(int i) {
        this.f12317e.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.f12319g.setVisibility(0);
        } else {
            this.f12319g.setVisibility(8);
        }
    }

    public void setTextColor(int i) {
        this.f12318f.setTextColor(i);
    }

    public void setTextView(String str) {
        this.f12318f.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.i = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.f12317e.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.f12317e.setImageDrawable(drawable);
    }
}
