package com.baidu.swan.apps.res.widget.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
/* loaded from: classes10.dex */
public class d {
    private static boolean mIsDebug = com.baidu.swan.apps.b.DEBUG;
    private a bKz;
    private CharSequence mBtnText;
    private Context mContext;
    private Drawable mHighlightIcon;
    private Uri mLeftGifUri;
    private int mMaxLines;
    private boolean mShowMask;
    private CharSequence mTitleText;
    private CharSequence mToastText;
    private int mButtonStyle = 2;
    private int mBottomShowAnimationType = 1;
    private int mBottomIconStyle = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes10.dex */
    public interface a {
        void onToastClick();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d co(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.mToastText = charSequence;
        return dVar;
    }

    public static d q(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.mToastText = context.getText(i);
        return dVar;
    }

    public d fN(@NonNull int i) {
        this.mMaxLines = i;
        return this;
    }

    public d dE(boolean z) {
        this.mShowMask = z;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.mToastText = charSequence;
        return this;
    }

    public d fO(int i) {
        this.mButtonStyle = i;
        return this;
    }

    public d fP(int i) {
        this.mBottomShowAnimationType = i;
        return this;
    }

    public d fQ(int i) {
        this.mBottomIconStyle = i;
        return this;
    }

    public d h(@NonNull CharSequence charSequence) {
        this.mBtnText = charSequence;
        return this;
    }

    public d fR(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.bKz = aVar;
        return this;
    }

    public d d(@NonNull Drawable drawable) {
        this.mHighlightIcon = drawable;
        return this;
    }

    public d fS(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.mHighlightIcon = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d c(@NonNull Uri uri) {
        this.mLeftGifUri = uri;
        return this;
    }

    private boolean checkToastParams() {
        if (this.mContext == null) {
            if (mIsDebug) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.mToastText == null) {
            if (mIsDebug) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void showToast() {
        showToast(false);
    }

    public void showMultiToast() {
        if (checkToastParams()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.show(this.mContext, this.mToastText, this.mDuration, false, this.mMaxLines, this.mShowMask);
        }
    }

    public void showToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.showToast((Activity) this.mContext, this.mToastText, this.mDuration, this.mMaxLines, this.mShowMask);
            } else {
                com.baidu.swan.apps.res.widget.b.a.show(this.mContext, this.mToastText, this.mDuration, true, this.mMaxLines, this.mShowMask);
            }
        }
    }

    public void showToastBottom() {
        showToastBottom(false);
    }

    public void showToastBottom(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.showToastBottom(this.mContext, this.mToastText, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.showToastBottom((Activity) this.mContext, this.mToastText, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.showToastBottom(this.mContext, this.mToastText, this.mDuration);
            }
        }
    }

    public void showHighlightToast() {
        showHighlightToast(false);
    }

    public void showHighlightToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration, this.mShowMask);
            } else if (this.mContext instanceof Activity) {
                e.showHighlight((Activity) this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration, this.mShowMask);
            } else {
                com.baidu.swan.apps.res.widget.b.a.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration, this.mShowMask);
            }
        }
    }

    public void showHighLoadingToast() {
        showHighLoadingToast(false);
    }

    public void showHighLoadingToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration, this.mShowMask);
            } else if (this.mContext instanceof Activity) {
                e.showHighLoadingToast((Activity) this.mContext, this.mToastText, this.mDuration, this.mShowMask);
            } else {
                com.baidu.swan.apps.res.widget.b.a.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration, this.mShowMask);
            }
        }
    }

    public void showClickableToast() {
        dF(false);
    }

    public void dF(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.bKz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.bKz);
            }
        }
    }

    public void showIconTitleMsgBtnToast() {
        showIconTitleMsgBtnToast(false);
    }

    public void showIconTitleMsgBtnToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mDuration, this.bKz);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mBottomShowAnimationType, this.mDuration, this.bKz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mDuration, this.bKz);
            }
        }
    }

    public static void cancelToast() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int getSwanAppStatusBarAndActionBarHeight(Context context) {
        return af.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
