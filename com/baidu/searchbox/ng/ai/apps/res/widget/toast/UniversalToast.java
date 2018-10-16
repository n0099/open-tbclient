package com.baidu.searchbox.ng.ai.apps.res.widget.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
/* loaded from: classes2.dex */
public class UniversalToast {
    public static final int BOTTOM_ICON_STYLE_RECT = 2;
    public static final int BOTTOM_ICON_STYLE_ROUND = 1;
    public static final int BOTTOM_SHOW_ANIMATION_FADE_IN = 1;
    public static final int BOTTOM_SHOW_ANIMATION_SHIFT_UP = 2;
    public static final int BOTTOM_SHOW_SHIFT_UP_DURATION = 200;
    public static final int BUTTON_STYLE_BG_TEXT = 2;
    public static final int BUTTON_STYLE_LINE_TEXT_ICON = 1;
    private static final String TAG = "UniversalToast";
    private static boolean mIsDebug = false;
    private CharSequence mBtnText;
    private int mBtnTextSize;
    private Drawable mButtonIcon;
    private Context mContext;
    private Drawable mHighlightIcon;
    private Drawable mLeftDrawable;
    private Uri mLeftGifUri;
    private Drawable mLeftIcon;
    private int mMaxLines;
    private Drawable mRightDrawable;
    private Uri mRigthGifUri;
    private CharSequence mTitleText;
    private ToastCallback mToastCallback;
    private CharSequence mToastText;
    private int mButtonStyle = 2;
    private int mBottomShowAnimationType = 1;
    private int mBottomIconStyle = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface ToastCallback {
        void onToastClick();
    }

    /* loaded from: classes2.dex */
    public interface ToastCallbackWithAction extends ToastCallback {
        public static final int ACTION_CANCEL = -1;
        public static final int ACTION_CONFIRM = 0;
        public static final String PARAMS_RESULT_KEY = "allow";

        void onToastClick(int i);
    }

    private UniversalToast(Context context) {
        this.mContext = context;
    }

    public static UniversalToast makeText(@NonNull Context context) {
        return new UniversalToast(context);
    }

    public static UniversalToast makeText(@NonNull Context context, @NonNull CharSequence charSequence) {
        UniversalToast universalToast = new UniversalToast(context);
        universalToast.mToastText = charSequence;
        return universalToast;
    }

    public static UniversalToast makeText(@NonNull Context context, @StringRes int i) {
        UniversalToast universalToast = new UniversalToast(context);
        universalToast.mToastText = context.getText(i);
        return universalToast;
    }

    public UniversalToast setMaxLines(@NonNull int i) {
        this.mMaxLines = i;
        return this;
    }

    public UniversalToast setText(@NonNull CharSequence charSequence) {
        this.mToastText = charSequence;
        return this;
    }

    public UniversalToast setTitleText(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public UniversalToast setMessageText(@NonNull CharSequence charSequence) {
        this.mToastText = charSequence;
        return this;
    }

    public UniversalToast setButtonStyle(int i) {
        this.mButtonStyle = i;
        return this;
    }

    public UniversalToast setBottomShowAnimationType(int i) {
        this.mBottomShowAnimationType = i;
        return this;
    }

    public UniversalToast setBottomIconStyle(int i) {
        this.mBottomIconStyle = i;
        return this;
    }

    public UniversalToast setTextSize(int i) {
        if (i > 18) {
            this.mTextSize = 18;
        } else if (i < 12) {
            this.mTextSize = 12;
        } else {
            this.mTextSize = i;
        }
        return this;
    }

    public UniversalToast setButtonText(@NonNull CharSequence charSequence) {
        this.mBtnText = charSequence;
        return this;
    }

    public UniversalToast setButtonTextSize(int i) {
        if (i > 18) {
            this.mBtnTextSize = 18;
        } else if (i < 12) {
            this.mBtnTextSize = 12;
        } else {
            this.mBtnTextSize = i;
        }
        return this;
    }

    public UniversalToast setDuration(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public UniversalToast setToastCallback(ToastCallback toastCallback) {
        this.mToastCallback = toastCallback;
        return this;
    }

    public UniversalToast setHighlightDrawable(@NonNull Drawable drawable) {
        this.mHighlightIcon = drawable;
        return this;
    }

    public UniversalToast setHighlightDrawable(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.mHighlightIcon = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public UniversalToast setLeftIcon(@NonNull Drawable drawable) {
        this.mLeftIcon = drawable;
        return this;
    }

    public UniversalToast setLeftIcon(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.mLeftIcon = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public UniversalToast setLeftGif(@NonNull Uri uri) {
        this.mLeftGifUri = uri;
        return this;
    }

    public UniversalToast setRigthGifUri(Uri uri) {
        this.mRigthGifUri = uri;
        return this;
    }

    public UniversalToast setButtonIcon(@Nullable Drawable drawable) {
        this.mButtonIcon = drawable;
        return this;
    }

    public UniversalToast setBigPicLeftDrawable(@NonNull Drawable drawable) {
        this.mLeftDrawable = drawable;
        return this;
    }

    public UniversalToast setBigPicRightDrawable(@NonNull Drawable drawable) {
        this.mRightDrawable = drawable;
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

    public void showToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.show(this.mContext, this.mToastText, this.mDuration, true, this.mMaxLines);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showToast((Activity) this.mContext, this.mToastText, this.mDuration, this.mMaxLines);
            } else {
                SingleToast.show(this.mContext, this.mToastText, this.mDuration, true, this.mMaxLines);
            }
        }
    }

    public void showMultiToast() {
        if (checkToastParams()) {
            cancelToast();
            SingleToast.show(this.mContext, this.mToastText, this.mDuration, false, this.mMaxLines);
        }
    }

    public void showToastBottom() {
        showToastBottom(false);
    }

    public void showToastBottom(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showToastBottom(this.mContext, this.mToastText, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showToastBottom((Activity) this.mContext, this.mToastText, this.mDuration);
            } else {
                SingleToast.showToastBottom(this.mContext, this.mToastText, this.mDuration);
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
                SingleToast.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showHighlight((Activity) this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration);
            } else {
                SingleToast.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration);
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
                SingleToast.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showHighLoadingToast((Activity) this.mContext, this.mToastText, this.mDuration);
            } else {
                SingleToast.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration);
            }
        }
    }

    public void showClickableToast() {
        showClickableToast(false);
    }

    public void showClickableToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showClickableToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showClickableToast((Activity) this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showClickableToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    public void showClickableToastWithLeftGif() {
        showClickableToastWithLeftGif(false);
    }

    public void showClickableToastWithLeftGif(boolean z) {
        if (checkToastParams()) {
            if (this.mLeftGifUri == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast left gif uri is null!!!");
                }
                return;
            }
            cancelToast();
            if (z) {
                SingleToast.showClickableToastWithLeftGif(this.mContext, this.mToastText, this.mLeftGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showClickableToastWithLeftGif((Activity) this.mContext, this.mToastText, this.mLeftGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showClickableToastWithLeftGif(this.mContext, this.mToastText, this.mLeftGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    public void showClickableToastWithLeftIcon() {
        showClickableToastWithLeftIcon(false);
    }

    public void showClickableToastWithLeftIcon(boolean z) {
        if (checkToastParams()) {
            if (this.mLeftIcon == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast left drawable is null!!!");
                }
                return;
            }
            cancelToast();
            if (z) {
                SingleToast.showClickableToastWithLeftIcon(this.mContext, this.mToastText, this.mLeftIcon, this.mBtnText, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showClickableToastWithLeftIcon((Activity) this.mContext, this.mToastText, this.mLeftIcon, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showClickableToastWithLeftIcon(this.mContext, this.mToastText, this.mLeftIcon, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    public void show2Icon2BtnToast() {
        show2Icon2BtnToast(false);
    }

    public void show2Icon2BtnToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (this.mContext instanceof Activity) {
                ViewToast.show2Icon2BtnToast((Activity) this.mContext, this.mLeftGifUri, this.mToastText, this.mRigthGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.show2Icon2BtnToast(this.mContext, this.mLeftGifUri, this.mToastText, this.mRigthGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    public void showRightButtonToast() {
        showRightButtonToast(false);
    }

    public void showRightButtonToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showRightButtonToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showRightButtonToast((Activity) this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showRightButtonToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
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
                SingleToast.showIconTitleMsgBtnToast(this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showIconTitleMsgBtnToast((Activity) this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mBottomShowAnimationType, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showIconTitleMsgBtnToast(this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mDuration, this.mToastCallback);
            }
        }
    }

    public void showBigPicToast() {
        showBigPicToast(false);
    }

    public void showBigPicToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showBigPicToast(this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showBigPicToast((Activity) this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showBigPicToast(this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    public static void cancelToast() {
        SingleToast.cancel();
        ViewToast.cancel();
    }
}
