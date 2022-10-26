package com.baidu.sapi2.touchid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FingerprintHelper extends FingerprintManager.AuthenticationCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AUTH_CANCLE = -2;
    public static final int AUTH_CHAGE_LOGIN_TYPE = -3;
    public static final int AUTH_MIS_MATCH_LIMIE = -8;
    public static final int AUTH_SUCCESS = 0;
    public static final int FINGERPRINT_VERIFY_MAX_ERROR_COUNT = 5;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public int authType;
    public CancellationSignal cancellationSignal;
    public Context context;
    public FingerprintManager.CryptoObject cryptoObject;
    public FingerprintCallback fingerprintCallback;
    public FingerprintDialogInterface fingerprintDialog;
    public FingerprintManager fingerprintManager;
    public char maxErrorCount;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-345749552, "Lcom/baidu/sapi2/touchid/FingerprintHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-345749552, "Lcom/baidu/sapi2/touchid/FingerprintHelper;");
                return;
            }
        }
        TAG = FingerprintHelper.class.getSimpleName();
    }

    public FingerprintHelper(Context context, FingerprintDialogInterface fingerprintDialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fingerprintDialogInterface};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxErrorCount = (char) 5;
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

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, charSequence) == null) {
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
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, authenticationResult) == null) {
            super.onAuthenticationSucceeded(authenticationResult);
            Log.i(TAG, "Authentication Succeeded ");
            dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
            FingerprintCallback fingerprintCallback = this.fingerprintCallback;
            if (fingerprintCallback != null) {
                fingerprintCallback.onCall(0);
            }
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, dialog) == null) {
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
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, charSequence) == null) {
            super.onAuthenticationHelp(i, charSequence);
            String str = TAG;
            Log.i(str, "Authentication help:" + i + ((Object) charSequence));
        }
    }

    private void showFirstVerifyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
            this.fingerprintDialog.setTitle("百度帐号 触控ID", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this) { // from class: com.baidu.sapi2.touchid.FingerprintHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FingerprintHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.stopAuthenticate();
                        this.this$0.fingerprintCallback.onCall(-2);
                    }
                }
            }).showDialog();
        }
    }

    private void showTryAgainVerifyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
            this.fingerprintDialog.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(1).setPositiveBtn(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this) { // from class: com.baidu.sapi2.touchid.FingerprintHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FingerprintHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.stopAuthenticate();
                        this.this$0.fingerprintCallback.onCall(-2);
                    }
                }
            }).showDialog();
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    public void stopAuthenticate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Log.i(TAG, "stopAuthenticate");
            dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
            if (Build.VERSION.SDK_INT >= 16) {
                this.cancellationSignal.cancel();
                this.fingerprintManager.authenticate(this.cryptoObject, this.cancellationSignal, 0, this, null);
            }
        }
    }

    private void showTryAgainLoginDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            dismissDialog((Activity) this.context, (Dialog) this.fingerprintDialog);
            StatService.onEvent("fingerprint_try_again_dialog_show", null);
            this.fingerprintDialog.setTitle("再试一次", "请验证已有手机指纹").setBtnCount(2).setNegativeBtn(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this) { // from class: com.baidu.sapi2.touchid.FingerprintHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FingerprintHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.stopAuthenticate();
                        this.this$0.fingerprintCallback.onCall(-2);
                    }
                }
            }).setPositiveBtn("换个登录方式", new View.OnClickListener(this) { // from class: com.baidu.sapi2.touchid.FingerprintHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FingerprintHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.stopAuthenticate();
                        this.this$0.fingerprintCallback.onCall(-3);
                    }
                }
            }).showDialog();
        }
    }

    public void startAuthenticate(int i, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, fingerprintCallback) == null) {
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
}
