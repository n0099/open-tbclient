package com.baidu.sapi2.touchid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
/* loaded from: classes3.dex */
public class FingerprintHelper extends FingerprintManager.AuthenticationCallback {
    public static final int AUTH_CANCLE = -2;
    public static final int AUTH_CHAGE_LOGIN_TYPE = -3;
    public static final int AUTH_MIS_MATCH_LIMIE = -8;
    public static final int AUTH_SUCCESS = 0;
    public static final int FINGERPRINT_VERIFY_MAX_ERROR_COUNT = 5;
    public static final String TAG = FingerprintHelper.class.getSimpleName();
    public int authType;
    public CancellationSignal cancellationSignal;
    public Context context;
    public FingerprintManager.CryptoObject cryptoObject;
    public FingerprintCallback fingerprintCallback;
    public FingerprintDialogInterface fingerprintDialog;
    public FingerprintManager fingerprintManager;
    public char maxErrorCount = 5;

    private void showFirstVerifyDialog() {
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        this.fingerprintDialog.setTitle("百度帐号 触控ID", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.touchid.FingerprintHelper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-2);
            }
        }).showDialog();
    }

    private void showTryAgainVerifyDialog() {
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        this.fingerprintDialog.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.touchid.FingerprintHelper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-2);
            }
        }).showDialog();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Log.i(TAG, "Authentication failed ");
        char c = (char) (this.maxErrorCount - 1);
        this.maxErrorCount = c;
        if (c > 0) {
            if (this.authType == 3) {
                showTryAgainLoginDialog();
                return;
            } else {
                showTryAgainVerifyDialog();
                return;
            }
        }
        stopAuthenticate();
        this.maxErrorCount = (char) 5;
    }

    public void stopAuthenticate() {
        Log.i(TAG, "stopAuthenticate");
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        if (Build.VERSION.SDK_INT >= 16) {
            this.cancellationSignal.cancel();
            this.fingerprintManager.authenticate(this.cryptoObject, this.cancellationSignal, 0, this, null);
        }
    }

    public FingerprintHelper(Context context, FingerprintDialogInterface fingerprintDialogInterface) {
        this.cryptoObject = null;
        this.cancellationSignal = null;
        this.context = context;
        this.fingerprintDialog = fingerprintDialogInterface;
        this.fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        this.cryptoObject = null;
        if (Build.VERSION.SDK_INT >= 16) {
            this.cancellationSignal = new CancellationSignal();
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e) {
                    Log.e(e);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Activity must not be null");
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        super.onAuthenticationHelp(i, charSequence);
        String str = TAG;
        Log.i(str, "Authentication help:" + i + ((Object) charSequence));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Log.i(TAG, "Authentication Succeeded ");
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        FingerprintCallback fingerprintCallback = this.fingerprintCallback;
        if (fingerprintCallback != null) {
            fingerprintCallback.onCall(0);
        }
    }

    private void showTryAgainLoginDialog() {
        dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
        StatService.onEvent("fingerprint_try_again_dialog_show", null);
        this.fingerprintDialog.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(2).setNegativeBtn("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.touchid.FingerprintHelper.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-2);
            }
        }).setPositiveBtn("换个登录方式", new View.OnClickListener() { // from class: com.baidu.sapi2.touchid.FingerprintHelper.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FingerprintHelper.this.stopAuthenticate();
                FingerprintHelper.this.fingerprintCallback.onCall(-3);
            }
        }).showDialog();
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        super.onAuthenticationError(i, charSequence);
        String str = TAG;
        Log.i(str, "Authentication error:" + i + ((Object) charSequence));
        stopAuthenticate();
        this.maxErrorCount = (char) 5;
        if (i == 7) {
            FingerprintCallback fingerprintCallback = this.fingerprintCallback;
            if (fingerprintCallback != null) {
                fingerprintCallback.onCall(-8);
                return;
            }
            return;
        }
        FingerprintCallback fingerprintCallback2 = this.fingerprintCallback;
        if (fingerprintCallback2 != null) {
            fingerprintCallback2.onCall(i);
        }
    }

    public void startAuthenticate(int i, FingerprintCallback fingerprintCallback) {
        Log.i(TAG, "startAuthenticate");
        this.authType = i;
        this.fingerprintCallback = fingerprintCallback;
        if (Build.VERSION.SDK_INT >= 16 && this.cancellationSignal.isCanceled()) {
            this.cancellationSignal = new CancellationSignal();
        }
        this.fingerprintManager.authenticate(this.cryptoObject, this.cancellationSignal, 0, this, null);
        showFirstVerifyDialog();
    }
}
