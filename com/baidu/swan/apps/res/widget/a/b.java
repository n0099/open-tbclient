package com.baidu.swan.apps.res.widget.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class b {
    protected a aQh;
    private com.baidu.swan.apps.res.widget.a.a aQi;
    protected Context mContext;
    protected Drawable mIconDrawable;
    protected final int mId;
    protected CharSequence mTitle;
    protected boolean mEnabled = true;
    protected boolean mChecked = false;
    protected boolean aQe = false;
    protected boolean aQf = true;
    protected long aQg = 0;
    protected int mIconResId = 0;

    /* loaded from: classes2.dex */
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
        this.aQi = aVar;
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

    public boolean LK() {
        return this.aQf;
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

    public long LL() {
        return this.aQg;
    }

    public a LM() {
        return this.aQh;
    }

    public void b(a aVar) {
        this.aQh = aVar;
    }
}
