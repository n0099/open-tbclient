package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {
    private static int aXK = 5;
    private static int aXL = 0;
    private ImageView aXH;
    private TextView aXI;
    private boolean aXJ;
    private ImageView mIconView;
    private TextView mTextView;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(a.g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.mIconView = (ImageView) findViewById(a.f.bottom_tab_icon);
        this.mTextView = (TextView) findViewById(a.f.bottom_tab_text);
        this.aXH = (ImageView) findViewById(a.f.bottom_tab_red_dot);
        this.aXI = (TextView) findViewById(a.f.bottom_tab_badge);
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
        if (str.length() > aXK) {
            str = str.substring(aXL, aXK);
        }
        this.mTextView.setText(str);
    }

    public void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public boolean NW() {
        return this.aXJ;
    }

    public void setmIsSelect(boolean z) {
        this.aXJ = z;
    }

    public void setBadgeText(String str) {
        this.aXI.setText(str);
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.aXH.setVisibility(0);
        } else {
            this.aXH.setVisibility(8);
        }
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.aXI.setVisibility(0);
        } else {
            this.aXI.setVisibility(8);
        }
    }
}
