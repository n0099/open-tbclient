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
/* loaded from: classes8.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {
    private TextView dPd;
    private boolean dPe;
    private ImageView mIconView;
    private ImageView mRedDot;
    private TextView mTextView;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(a.g.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.mIconView = (ImageView) findViewById(a.f.bottom_tab_icon);
        this.mTextView = (TextView) findViewById(a.f.bottom_tab_text);
        this.mRedDot = (ImageView) findViewById(a.f.bottom_tab_red_dot);
        this.dPd = (TextView) findViewById(a.f.bottom_tab_badge);
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
        this.mTextView.setText(str);
    }

    public void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public boolean aMZ() {
        return this.dPe;
    }

    public void setmIsSelect(boolean z) {
        this.dPe = z;
    }

    public void setBadgeText(String str) {
        this.dPd.setText(str);
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.mRedDot.setVisibility(0);
        } else {
            this.mRedDot.setVisibility(8);
        }
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.dPd.setVisibility(0);
        } else {
            this.dPd.setVisibility(8);
        }
    }
}
