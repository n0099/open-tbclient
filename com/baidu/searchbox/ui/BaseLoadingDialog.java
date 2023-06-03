package com.baidu.searchbox.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.LoadingDialogInterface;
/* loaded from: classes4.dex */
public abstract class BaseLoadingDialog extends Dialog {
    public static final int DISMISS_BACK_KEY = 2;
    public static final int DISMISS_CLOSE_BTN = 4;
    public static final int DISMISS_DEFAULT = 1;
    public static final int DISMISS_TOUCH_OUTSIDE = 3;
    public static final String TAG = "BaseLoadingDialog";
    public boolean mCancelOnBackKey;
    public boolean mCancelOnTouchOutside;
    public boolean mDetached;
    public LoadingDialogInterface.OnDialogDismissListener mDialogDismissListener;
    public int mDismissType;
    public boolean mIsActivity;
    public CharSequence mMsgText;

    public abstract void initView();

    public abstract void setFontResources();

    public abstract void setPageResources();

    public BaseLoadingDialog(@NonNull Context context) {
        super(context, com.baidu.tieba.R.style.obfuscated_res_0x7f100105);
        this.mMsgText = "";
        this.mDismissType = 1;
        this.mDetached = false;
        this.mCancelOnBackKey = true;
        this.mCancelOnTouchOutside = true;
        this.mIsActivity = checkContextAvailable(context);
    }

    public static boolean checkContextAvailable(Context context) {
        if (context instanceof Activity) {
            return true;
        }
        if (LoadingDebugUtil.isDebug()) {
            Log.e(TAG, Log.getStackTraceString(new Throwable("context must be activity instance")));
            return false;
        }
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setCancelable(this.mCancelOnBackKey);
        setCanceledOnTouchOutside(this.mCancelOnTouchOutside);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.searchbox.ui.BaseLoadingDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BaseLoadingDialog.this.mDialogDismissListener != null) {
                    if (LoadingDebugUtil.isDebug()) {
                        Log.d(BaseLoadingDialog.TAG, "dialog dismiss type: " + BaseLoadingDialog.this.mDismissType);
                    }
                    BaseLoadingDialog.this.mDialogDismissListener.onDismiss(dialogInterface, BaseLoadingDialog.this.mDismissType);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mCancelOnTouchOutside) {
            this.mDismissType = 3;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setCancelWhenBackKey(boolean z) {
        this.mCancelOnBackKey = z;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setCancelWhenTouchOutside(boolean z) {
        this.mCancelOnTouchOutside = z;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setDialogDismissListener(@Nullable LoadingDialogInterface.OnDialogDismissListener onDialogDismissListener) {
        this.mDialogDismissListener = onDialogDismissListener;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setMessage(CharSequence charSequence) {
        this.mMsgText = charSequence;
        return this;
    }

    public BaseLoadingDialog(@NonNull Context context, @StringRes int i) {
        this(context);
        this.mMsgText = context.getText(i);
    }

    public BaseLoadingDialog(@NonNull Context context, @NonNull CharSequence charSequence) {
        this(context);
        this.mMsgText = charSequence;
    }

    private void subscribeFontSizeChangeEvent() {
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.ui.BaseLoadingDialog.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                BaseLoadingDialog.this.setFontResources();
            }
        });
    }

    private void subscribeNightModeChangeEvent() {
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.BaseLoadingDialog.2
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                BaseLoadingDialog.this.setPageResources();
            }
        });
    }

    private void unSubscribeFontSizeChangeEvent() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    private void unSubscribeNightModeChangeEvent() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mDetached) {
            return;
        }
        super.dismiss();
        unSubscribeNightModeChangeEvent();
        unSubscribeFontSizeChangeEvent();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.mCancelOnBackKey) {
            this.mDismissType = 2;
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDetached = true;
    }

    @Override // android.app.Dialog
    public void show() {
        if (!this.mIsActivity || this.mDetached) {
            return;
        }
        super.show();
        this.mDetached = false;
        subscribeNightModeChangeEvent();
        subscribeFontSizeChangeEvent();
    }
}
