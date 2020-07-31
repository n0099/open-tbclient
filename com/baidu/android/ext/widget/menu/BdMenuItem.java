package com.baidu.android.ext.widget.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class BdMenuItem {
    private static final int NO_ICON = 0;
    protected boolean mChecked;
    protected Context mContext;
    protected long mDismissDelayTime;
    protected boolean mEnabled;
    protected Drawable mIconDrawable;
    protected int mIconResId;
    protected final int mId;
    protected boolean mIsAutoDismiss;
    private BdMenu mMenu;
    protected OnItemClickListener mOnClickListener;
    protected boolean mShowTip;
    protected CharSequence mTitle;

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdMenuItem(Context context, int i, CharSequence charSequence) {
        this.mEnabled = true;
        this.mChecked = false;
        this.mShowTip = false;
        this.mIsAutoDismiss = true;
        this.mDismissDelayTime = 0L;
        this.mIconResId = 0;
        this.mContext = context;
        this.mId = i;
        this.mTitle = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdMenuItem(Context context, int i, CharSequence charSequence, int i2) {
        this.mEnabled = true;
        this.mChecked = false;
        this.mShowTip = false;
        this.mIsAutoDismiss = true;
        this.mDismissDelayTime = 0L;
        this.mIconResId = 0;
        this.mContext = context;
        this.mId = i;
        this.mTitle = charSequence;
        this.mIconResId = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdMenuItem(Context context, int i, CharSequence charSequence, Drawable drawable) {
        this.mEnabled = true;
        this.mChecked = false;
        this.mShowTip = false;
        this.mIsAutoDismiss = true;
        this.mDismissDelayTime = 0L;
        this.mIconResId = 0;
        this.mContext = context;
        this.mId = i;
        this.mTitle = charSequence;
        this.mIconDrawable = drawable;
    }

    public BdMenu getMenu() {
        return this.mMenu;
    }

    public void setMenu(BdMenu bdMenu) {
        this.mMenu = bdMenu;
    }

    public int getItemId() {
        return this.mId;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public boolean showTip() {
        return this.mShowTip;
    }

    public void setShowTip(boolean z) {
        this.mShowTip = z;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    public BdMenuItem setTitle(int i) {
        this.mTitle = this.mContext.getResources().getText(i, this.mTitle);
        return this;
    }

    public boolean isAutoDismiss() {
        return this.mIsAutoDismiss;
    }

    public void setIsAutoDismiss(boolean z) {
        this.mIsAutoDismiss = z;
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

    public BdMenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        return this;
    }

    public BdMenuItem setIcon(int i) {
        this.mIconDrawable = null;
        this.mIconResId = i;
        return this;
    }

    public long getDismissDelayTime() {
        return this.mDismissDelayTime;
    }

    public void setDismissDelayTime(long j) {
        this.mDismissDelayTime = j;
    }

    public OnItemClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.mOnClickListener = onItemClickListener;
    }
}
