package com.baidu.searchbox.ng.ai.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public class AiAppsBottomTabIconView extends RelativeLayout {
    private static int BOTTOM_TITLE_MAX_LENGTH = 5;
    private static int BOTTOM_TITLE_MIN_LENGTH = 0;
    private TextView mBadge;
    private ImageView mIconView;
    private boolean mIsSelect;
    private ImageView mRedDot;
    private TextView mTextView;

    public AiAppsBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.aiapps_bottom_tab_icon, (ViewGroup) this, true);
        this.mIconView = (ImageView) findViewById(R.id.bottom_tab_icon);
        this.mTextView = (TextView) findViewById(R.id.bottom_tab_text);
        this.mRedDot = (ImageView) findViewById(R.id.bottom_tab_red_dot);
        this.mBadge = (TextView) findViewById(R.id.bottom_tab_badge);
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
        if (str.length() > BOTTOM_TITLE_MAX_LENGTH) {
            str = str.substring(BOTTOM_TITLE_MIN_LENGTH, BOTTOM_TITLE_MAX_LENGTH);
        }
        this.mTextView.setText(str);
    }

    public void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public boolean ismIsSelect() {
        return this.mIsSelect;
    }

    public void setmIsSelect(boolean z) {
        this.mIsSelect = z;
    }

    public void setBadgeText(String str) {
        this.mBadge.setText(str);
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
            this.mBadge.setVisibility(0);
        } else {
            this.mBadge.setVisibility(8);
        }
    }
}
