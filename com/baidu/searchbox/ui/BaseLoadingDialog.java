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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.LoadingDialogInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BaseLoadingDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISMISS_BACK_KEY = 2;
    public static final int DISMISS_CLOSE_BTN = 4;
    public static final int DISMISS_DEFAULT = 1;
    public static final int DISMISS_TOUCH_OUTSIDE = 3;
    public static final String TAG = "BaseLoadingDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCancelOnBackKey;
    public boolean mCancelOnTouchOutside;
    public boolean mDetached;
    public LoadingDialogInterface.OnDialogDismissListener mDialogDismissListener;
    public int mDismissType;
    public boolean mIsActivity;
    public CharSequence mMsgText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLoadingDialog(@NonNull Context context) {
        super(context, R.style.D20LoadingDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMsgText = "";
        this.mDismissType = 1;
        this.mDetached = false;
        this.mCancelOnBackKey = true;
        this.mCancelOnTouchOutside = true;
        this.mIsActivity = checkContextAvailable(context);
    }

    public static boolean checkContextAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context instanceof Activity) {
                return true;
            }
            if (LoadingDebugUtil.isDebug()) {
                Log.getStackTraceString(new Throwable("context must be activity instance"));
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void subscribeNightModeChangeEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener(this) { // from class: com.baidu.searchbox.ui.BaseLoadingDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseLoadingDialog this$0;

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

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.this$0.setPageResources();
                    }
                }
            });
        }
    }

    private void unSubscribeNightModeChangeEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mDetached) {
            return;
        }
        super.dismiss();
        unSubscribeNightModeChangeEvent();
    }

    public abstract void initView();

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mCancelOnBackKey) {
                this.mDismissType = 2;
            }
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            initView();
            setCancelable(this.mCancelOnBackKey);
            setCanceledOnTouchOutside(this.mCancelOnTouchOutside);
            setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.searchbox.ui.BaseLoadingDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseLoadingDialog this$0;

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

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || this.this$0.mDialogDismissListener == null) {
                        return;
                    }
                    if (LoadingDebugUtil.isDebug()) {
                        String str = "dialog dismiss type: " + this.this$0.mDismissType;
                    }
                    this.this$0.mDialogDismissListener.onDismiss(dialogInterface, this.this$0.mDismissType);
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            this.mDetached = true;
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.mCancelOnTouchOutside) {
                this.mDismissType = 3;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setCancelWhenBackKey(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.mCancelOnBackKey = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setCancelWhenTouchOutside(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.mCancelOnTouchOutside = z;
            return this;
        }
        return (T) invokeZ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setDialogDismissListener(@Nullable LoadingDialogInterface.OnDialogDismissListener onDialogDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onDialogDismissListener)) == null) {
            this.mDialogDismissListener = onDialogDismissListener;
            return this;
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.ui.BaseLoadingDialog */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseLoadingDialog> T setMessage(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
            this.mMsgText = charSequence;
            return this;
        }
        return (T) invokeL.objValue;
    }

    public abstract void setPageResources();

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.mIsActivity && !this.mDetached) {
            super.show();
            this.mDetached = false;
            subscribeNightModeChangeEvent();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseLoadingDialog(@NonNull Context context, @NonNull CharSequence charSequence) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, charSequence};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMsgText = charSequence;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseLoadingDialog(@NonNull Context context, @StringRes int i2) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMsgText = context.getText(i2);
    }
}
