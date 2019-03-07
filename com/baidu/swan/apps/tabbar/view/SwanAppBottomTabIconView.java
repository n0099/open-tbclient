package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {
    private static int aUJ = 5;
    private static int aUK = 0;
    private ImageView aUG;
    private TextView aUH;
    private boolean aUI;
    private ImageView mIconView;
    private TextView mTextView;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(b.g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.mIconView = (ImageView) findViewById(b.f.bottom_tab_icon);
        this.mTextView = (TextView) findViewById(b.f.bottom_tab_text);
        this.aUG = (ImageView) findViewById(b.f.bottom_tab_red_dot);
        this.aUH = (TextView) findViewById(b.f.bottom_tab_badge);
    }

    public void setIconView(int i) {
        this.mIconView.setImageDrawable(getResources().getDrawable(i));
    }

    public void setIconView(Bitmap bitmap) {
        this.mIconView.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.mIconView.setImageDrawable(drawable);
    }

    public void setTextView(String str) {
        if (str.length() > aUJ) {
            str = str.substring(aUK, aUJ);
        }
        this.mTextView.setText(str);
    }

    public void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public boolean Lv() {
        return this.aUI;
    }

    public void setmIsSelect(boolean z) {
        this.aUI = z;
    }

    public void setBadgeText(String str) {
        this.aUH.setText(str);
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.aUG.setVisibility(0);
        } else {
            this.aUG.setVisibility(8);
        }
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.aUH.setVisibility(0);
        } else {
            this.aUH.setVisibility(8);
        }
    }
}
