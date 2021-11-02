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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.LoadingDialogInterface;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class UniversalLoadingDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UniversalLoadingDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCancelOnBackKey;
    public boolean mCancelOnTouchOutside;
    public Context mContext;
    public LoadingDialogInterface.OnDialogDismissListener mDialogDismissListener;
    public boolean mHasCloseBtn;
    public boolean mIsFlagAltFocusableim;
    public BaseLoadingDialog mLoadingDialog;
    public LoadingTemplate mLoadingTemplate;
    public CharSequence mMsgText;

    /* renamed from: com.baidu.searchbox.ui.UniversalLoadingDialog$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$LoadingTemplate;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1183249906, "Lcom/baidu/searchbox/ui/UniversalLoadingDialog$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1183249906, "Lcom/baidu/searchbox/ui/UniversalLoadingDialog$3;");
                    return;
                }
            }
            int[] iArr = new int[LoadingTemplate.values().length];
            $SwitchMap$com$baidu$searchbox$ui$LoadingTemplate = iArr;
            try {
                iArr[LoadingTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public UniversalLoadingDialog(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLoadingTemplate = LoadingTemplate.T1;
        this.mMsgText = "";
        this.mCancelOnBackKey = true;
        this.mCancelOnTouchOutside = true;
        this.mHasCloseBtn = false;
        this.mIsFlagAltFocusableim = false;
        this.mContext = context;
    }

    public static UniversalLoadingDialog createDialog(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? new UniversalLoadingDialog(context) : (UniversalLoadingDialog) invokeL.objValue;
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.ui.UniversalLoadingDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UniversalLoadingDialog this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    BaseLoadingDialog baseLoadingDialog;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (baseLoadingDialog = this.this$0.mLoadingDialog) == null) {
                        return;
                    }
                    baseLoadingDialog.dismiss();
                }
            });
        }
    }

    public UniversalLoadingDialog setCancelWhenBackKey(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.mCancelOnBackKey = z;
            return this;
        }
        return (UniversalLoadingDialog) invokeZ.objValue;
    }

    public UniversalLoadingDialog setCancelWhenTouchOutside(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.mCancelOnTouchOutside = z;
            return this;
        }
        return (UniversalLoadingDialog) invokeZ.objValue;
    }

    public UniversalLoadingDialog setCloseButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.mHasCloseBtn = true;
            return this;
        }
        return (UniversalLoadingDialog) invokeV.objValue;
    }

    public UniversalLoadingDialog setDialogDismissListener(@Nullable LoadingDialogInterface.OnDialogDismissListener onDialogDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, onDialogDismissListener)) == null) {
            this.mDialogDismissListener = onDialogDismissListener;
            return this;
        }
        return (UniversalLoadingDialog) invokeL.objValue;
    }

    public void setIsFlagAltFocusableim(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mIsFlagAltFocusableim = z;
        }
    }

    public UniversalLoadingDialog setMessage(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, charSequence)) == null) {
            this.mMsgText = charSequence;
            return this;
        }
        return (UniversalLoadingDialog) invokeL.objValue;
    }

    public UniversalLoadingDialog setTemplate(LoadingTemplate loadingTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, loadingTemplate)) == null) {
            this.mLoadingTemplate = loadingTemplate;
            return this;
        }
        return (UniversalLoadingDialog) invokeL.objValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!(this.mContext instanceof Activity)) {
                if (LoadingDebugUtil.isDebug()) {
                    Log.getStackTraceString(new Throwable("context must be activity instance"));
                }
            } else if (TextUtils.isEmpty(this.mMsgText)) {
                if (LoadingDebugUtil.isDebug()) {
                    Log.getStackTraceString(new Throwable("has no mMsgText"));
                }
            } else {
                int i2 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$LoadingTemplate[this.mLoadingTemplate.ordinal()];
                SimpleLoadingDialog simpleLoadingDialog = (SimpleLoadingDialog) new SimpleLoadingDialog(this.mContext, this.mMsgText).setCancelWhenBackKey(this.mCancelOnBackKey).setCancelWhenTouchOutside(this.mCancelOnTouchOutside).setDialogDismissListener(new LoadingDialogInterface.OnDialogDismissListener(this) { // from class: com.baidu.searchbox.ui.UniversalLoadingDialog.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UniversalLoadingDialog this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.ui.LoadingDialogInterface.OnDialogDismissListener
                    public void onDismiss(DialogInterface dialogInterface, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i3) == null) {
                            this.this$0.mLoadingDialog = null;
                            if (this.this$0.mDialogDismissListener != null) {
                                this.this$0.mDialogDismissListener.onDismiss(dialogInterface, i3);
                            }
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

    public static UniversalLoadingDialog createDialog(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, charSequence)) == null) {
            UniversalLoadingDialog createDialog = createDialog(context);
            createDialog.mMsgText = charSequence;
            return createDialog;
        }
        return (UniversalLoadingDialog) invokeLL.objValue;
    }

    public static UniversalLoadingDialog createDialog(@NonNull Context context, @StringRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, context, i2)) == null) {
            UniversalLoadingDialog createDialog = createDialog(context);
            createDialog.mMsgText = context.getText(i2);
            return createDialog;
        }
        return (UniversalLoadingDialog) invokeLI.objValue;
    }
}
