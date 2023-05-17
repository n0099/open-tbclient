package com.baidu.searchbox.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.searchbox.ui.LoadingDialogInterface;
/* loaded from: classes4.dex */
public class UniversalLoadingDialog {
    public static final String TAG = "UniversalLoadingDialog";
    public Context mContext;
    public LoadingDialogInterface.OnDialogDismissListener mDialogDismissListener;
    public BaseLoadingDialog mLoadingDialog;
    public LoadingTemplate mLoadingTemplate = LoadingTemplate.T1;
    public CharSequence mMsgText = "";
    public boolean mCancelOnBackKey = true;
    public boolean mCancelOnTouchOutside = true;
    public boolean mHasCloseBtn = false;
    public boolean mIsFlagAltFocusableim = false;

    /* renamed from: com.baidu.searchbox.ui.UniversalLoadingDialog$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$LoadingTemplate;

        static {
            int[] iArr = new int[LoadingTemplate.values().length];
            $SwitchMap$com$baidu$searchbox$ui$LoadingTemplate = iArr;
            try {
                iArr[LoadingTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public UniversalLoadingDialog(@NonNull Context context) {
        this.mContext = context;
    }

    public static UniversalLoadingDialog createDialog(@NonNull Context context) {
        return new UniversalLoadingDialog(context);
    }

    public UniversalLoadingDialog setCancelWhenBackKey(boolean z) {
        this.mCancelOnBackKey = z;
        return this;
    }

    public UniversalLoadingDialog setCancelWhenTouchOutside(boolean z) {
        this.mCancelOnTouchOutside = z;
        return this;
    }

    public UniversalLoadingDialog setDialogDismissListener(@Nullable LoadingDialogInterface.OnDialogDismissListener onDialogDismissListener) {
        this.mDialogDismissListener = onDialogDismissListener;
        return this;
    }

    public void setIsFlagAltFocusableim(boolean z) {
        this.mIsFlagAltFocusableim = z;
    }

    public UniversalLoadingDialog setMessage(CharSequence charSequence) {
        this.mMsgText = charSequence;
        return this;
    }

    public UniversalLoadingDialog setTemplate(LoadingTemplate loadingTemplate) {
        this.mLoadingTemplate = loadingTemplate;
        return this;
    }

    public static UniversalLoadingDialog createDialog(@NonNull Context context, @StringRes int i) {
        UniversalLoadingDialog createDialog = createDialog(context);
        createDialog.mMsgText = context.getText(i);
        return createDialog;
    }

    public static UniversalLoadingDialog createDialog(@NonNull Context context, @NonNull CharSequence charSequence) {
        UniversalLoadingDialog createDialog = createDialog(context);
        createDialog.mMsgText = charSequence;
        return createDialog;
    }

    public void dismiss() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.ui.UniversalLoadingDialog.2
            @Override // java.lang.Runnable
            public void run() {
                BaseLoadingDialog baseLoadingDialog = UniversalLoadingDialog.this.mLoadingDialog;
                if (baseLoadingDialog != null) {
                    baseLoadingDialog.dismiss();
                }
            }
        });
    }

    public UniversalLoadingDialog setCloseButton() {
        this.mHasCloseBtn = true;
        return this;
    }

    public void show() {
        if (!(this.mContext instanceof Activity)) {
            if (LoadingDebugUtil.isDebug()) {
                Log.e(TAG, Log.getStackTraceString(new Throwable("context must be activity instance")));
            }
        } else if (TextUtils.isEmpty(this.mMsgText)) {
            if (LoadingDebugUtil.isDebug()) {
                Log.e(TAG, Log.getStackTraceString(new Throwable("has no mMsgText")));
            }
        } else {
            int i = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$LoadingTemplate[this.mLoadingTemplate.ordinal()];
            SimpleLoadingDialog simpleLoadingDialog = (SimpleLoadingDialog) new SimpleLoadingDialog(this.mContext, this.mMsgText).setCancelWhenBackKey(this.mCancelOnBackKey).setCancelWhenTouchOutside(this.mCancelOnTouchOutside).setDialogDismissListener(new LoadingDialogInterface.OnDialogDismissListener() { // from class: com.baidu.searchbox.ui.UniversalLoadingDialog.1
                @Override // com.baidu.searchbox.ui.LoadingDialogInterface.OnDialogDismissListener
                public void onDismiss(DialogInterface dialogInterface, int i2) {
                    UniversalLoadingDialog.this.mLoadingDialog = null;
                    if (UniversalLoadingDialog.this.mDialogDismissListener != null) {
                        UniversalLoadingDialog.this.mDialogDismissListener.onDismiss(dialogInterface, i2);
                    }
                }
            });
            if (this.mHasCloseBtn) {
                simpleLoadingDialog.setCloseButton();
            }
            this.mLoadingDialog = simpleLoadingDialog;
            if (this.mIsFlagAltFocusableim) {
                simpleLoadingDialog.getWindow().setFlags(131072, 131072);
            }
            simpleLoadingDialog.show();
        }
    }
}
