package com.baidu.android.ext.widget.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.View;
import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.toast.R;
import com.baidu.android.util.devices.DeviceUtil;
/* loaded from: classes5.dex */
public class UniversalToast implements PopItem {
    public static final int BOTTOM_ICON_STYLE_RECT = 2;
    public static final int BOTTOM_ICON_STYLE_ROUND = 1;
    public static final int BOTTOM_SHOW_ANIMATION_FADE_IN = 1;
    public static final int BOTTOM_SHOW_ANIMATION_SHIFT_UP = 2;
    public static final int BOTTOM_SHOW_SHIFT_UP_DURATION = 200;
    public static final int BUTTON_STYLE_BG_TEXT = 2;
    public static final int BUTTON_STYLE_LINE_TEXT_ICON = 1;
    private static final String TAG = "UniversalToast";
    private static boolean mIsDebug = false;
    private int mBottomMargin;
    private CharSequence mBtnText;
    private int mBtnTextSize;
    private Drawable mButtonIcon;
    private Context mContext;
    private Drawable mHighlightIcon;
    private Drawable mLeftDrawable;
    private Uri mLeftGifUri;
    private Drawable mLeftIcon;
    private int mMaxLines;
    private OnDismissListener mOnDismissListener;
    private Drawable mRightDrawable;
    private Uri mRigthGifUri;
    private boolean mShowMask;
    private CharSequence mTitleText;
    private ToastCallback mToastCallback;
    private CharSequence mToastText;
    private int mButtonStyle = 2;
    private int mBottomShowAnimationType = 1;
    private int mBottomIconStyle = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes5.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* loaded from: classes5.dex */
    public interface ToastCallback {
        void onToastClick();
    }

    /* loaded from: classes5.dex */
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

    public UniversalToast setShowMask(boolean z) {
        this.mShowMask = z;
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

    public UniversalToast setBottomMargin(int i) {
        this.mBottomMargin = i;
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

    public void showMultiToast() {
        if (checkToastParams()) {
            cancelToast();
            SingleToast.show(this.mContext, this.mToastText, this.mDuration, false, this.mMaxLines, this.mShowMask);
        }
    }

    public void showToast() {
        showToast(false);
    }

    public void showToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                if (mIsDebug) {
                    Log.w(TAG, "给View set 的mOnDismissListener是不是空?" + (this.mOnDismissListener == null));
                }
                if (this.mOnDismissListener != null) {
                    ViewToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                ViewToast.showToast((Activity) this.mContext, this.mToastText, this.mDuration, this.mMaxLines, this.mShowMask);
                return;
            }
            if (this.mOnDismissListener != null) {
                SingleToast.setOnDismissListener(this.mOnDismissListener);
                this.mOnDismissListener = null;
            }
            SingleToast.show(this.mContext, this.mToastText, this.mDuration, true, this.mMaxLines, this.mShowMask);
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
                SingleToast.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration, this.mShowMask);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showHighlight((Activity) this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration, this.mShowMask);
            } else {
                SingleToast.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mDuration, this.mShowMask);
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
                SingleToast.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration, this.mShowMask);
            } else if (this.mContext instanceof Activity) {
                ViewToast.showHighLoadingToast((Activity) this.mContext, this.mToastText, this.mDuration, this.mShowMask);
            } else {
                SingleToast.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration, this.mShowMask);
            }
        }
    }

    public void showClickableToastForFullScreen() {
        showClickableToast(false, true);
    }

    public void showClickableToast() {
        showClickableToast(false, false);
    }

    public void showClickableToast(boolean z, boolean z2) {
        if (checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                if (this.mOnDismissListener != null) {
                    ViewToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                ViewToast.showClickableToast((Activity) this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback, z2);
                return;
            }
            if (this.mOnDismissListener != null) {
                SingleToast.setOnDismissListener(this.mOnDismissListener);
                this.mOnDismissListener = null;
            }
            SingleToast.showClickableToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
        }
    }

    public void showClickablePopToast() {
        showClickablePopToast(false, false);
    }

    public void showClickablePopToast(boolean z, boolean z2) {
        if (checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                if (this.mOnDismissListener != null) {
                    SingleToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                SingleToast.showClickablePopToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
                return;
            }
            if (this.mOnDismissListener != null) {
                SingleToast.setOnDismissListener(this.mOnDismissListener);
                this.mOnDismissListener = null;
            }
            SingleToast.showClickableToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
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

    public void showClickableToastWithLeftIconNoBtn() {
        if (checkToastParams()) {
            if (this.mLeftIcon == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast left drawable is null!!!");
                }
                return;
            }
            cancelToast();
            ViewToast.showClickableToastWithLeftIconNoBtn((Activity) this.mContext, this.mToastText, this.mLeftIcon, this.mDuration, this.mToastCallback);
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

    public void showRightButtonPopToast() {
        showRightButtonPopToast(false);
    }

    public void showRightButtonPopToast(boolean z) {
        if (checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showRightButtonToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                SingleToast.showRightButtonPopToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
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
                SingleToast.showIconTitleMsgBtnToast(this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mDuration, this.mBottomMargin, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                if (this.mOnDismissListener != null) {
                    ViewToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                ViewToast.showIconTitleMsgBtnToast((Activity) this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mBottomShowAnimationType, this.mDuration, this.mBottomMargin, this.mToastCallback);
            } else {
                if (this.mOnDismissListener != null) {
                    SingleToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                SingleToast.showIconTitleMsgBtnToast(this.mContext, this.mLeftGifUri, this.mBottomIconStyle, this.mTitleText, this.mToastText, this.mBtnText, this.mButtonStyle, this.mDuration, this.mBottomMargin, this.mToastCallback);
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
                if (this.mOnDismissListener != null) {
                    ViewToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                ViewToast.showBigPicToast((Activity) this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                if (this.mOnDismissListener != null) {
                    SingleToast.setOnDismissListener(this.mOnDismissListener);
                    this.mOnDismissListener = null;
                }
                SingleToast.showBigPicToast(this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    public void showCustomToast(View view, int i) {
        if (this.mContext != null) {
            cancelToast();
            SingleToast.showCustomToast(this.mContext, view, i);
        }
    }

    public static void cancelToast() {
        SingleToast.cancel();
        ViewToast.cancel();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) {
        setOnDismissListener(new OnDismissListener() { // from class: com.baidu.android.ext.widget.toast.UniversalToast.1
            @Override // com.baidu.android.ext.widget.toast.UniversalToast.OnDismissListener
            public void onDismiss() {
                if (UniversalToast.mIsDebug) {
                    Log.w(MutexPopManager.TAG, "OnDismissListener中调用了doNextTask()");
                }
                MutexPopManager.doNextTask();
            }
        });
        if (str == null) {
            str = "";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1913642710:
                if (str.equals(PopItemMethodConstant.showToast)) {
                    c = 0;
                    break;
                }
                break;
            case -1876363382:
                if (str.equals("showIconTitleMsgBtnToast")) {
                    c = 2;
                    break;
                }
                break;
            case -1396871306:
                if (str.equals("showRightButtonToast")) {
                    c = 3;
                    break;
                }
                break;
            case 463967707:
                if (str.equals("showClickablePopToast")) {
                    c = 5;
                    break;
                }
                break;
            case 764048578:
                if (str.equals("showClickableToast")) {
                    c = 1;
                    break;
                }
                break;
            case 826030240:
                if (str.equals("showBigPicToast")) {
                    c = 4;
                    break;
                }
                break;
            case 1764503207:
                if (str.equals("showRightButtonPopToast")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                showToast();
                return true;
            case 1:
                showClickableToast();
                return true;
            case 2:
                showIconTitleMsgBtnToast();
                return true;
            case 3:
                showRightButtonToast();
                return true;
            case 4:
                showBigPicToast();
                return true;
            case 5:
                showClickablePopToast();
                return true;
            case 6:
                showRightButtonPopToast();
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        setOnDismissListener(null);
        cancelToast();
    }

    public static int getSwanAppStatusBarAndActionBarHeight(Context context) {
        return DeviceUtil.ScreenInfo.getStatusBarHeight() + ((int) context.getResources().getDimension(R.dimen.normal_base_action_bar_height));
    }
}
