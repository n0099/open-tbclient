package com.baidu.swan.apps.res.widget.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class b {
    protected a aMS;
    protected boolean mChecked;
    protected Context mContext;
    protected boolean mEnabled;
    protected Drawable mIconDrawable;
    protected int mIconResId;
    protected final int mId;
    protected CharSequence mTitle;

    /* loaded from: classes2.dex */
    public interface a {
        void b(b bVar);
    }

    public int getItemId() {
        return this.mId;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public Drawable getIcon() {
        if (this.mIconDrawable != null) {
            return this.mIconDrawable;
        }
        if (this.mIconResId != 0) {
            Drawable drawable = this.mContext.getResources().getDrawable(this.mIconResId);
            this.mIconResId = 0;
            this.mIconDrawable = drawable;
            return drawable;
        }
        return null;
    }

    public a IC() {
        return this.aMS;
    }
}
