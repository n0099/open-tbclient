package com.baidu.swan.apps.res.widget.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes11.dex */
public class b {
    protected a cnE;
    private com.baidu.swan.apps.res.widget.a.a cnF;
    protected Context mContext;
    protected Drawable mIconDrawable;
    protected final int mId;
    protected CharSequence mTitle;
    protected boolean mEnabled = true;
    protected boolean mChecked = false;
    protected boolean mShowTip = false;
    protected boolean mIsAutoDismiss = true;
    protected long mDismissDelayTime = 0;
    protected int mIconResId = 0;

    /* loaded from: classes11.dex */
    public interface a {
        void c(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, int i, CharSequence charSequence, Drawable drawable) {
        this.mContext = context;
        this.mId = i;
        this.mTitle = charSequence;
        this.mIconDrawable = drawable;
    }

    public void d(com.baidu.swan.apps.res.widget.a.a aVar) {
        this.cnF = aVar;
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

    public boolean isAutoDismiss() {
        return this.mIsAutoDismiss;
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

    public long getDismissDelayTime() {
        return this.mDismissDelayTime;
    }

    public a akC() {
        return this.cnE;
    }

    public void b(a aVar) {
        this.cnE = aVar;
    }
}
