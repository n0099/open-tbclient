package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdDimDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public View mContentView;
    public AlertDialog mDialog;
    public DialogInterface.OnDismissListener mOnDismissListener;

    public BdDimDialog(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = activity;
    }

    public void setContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.mContentView = view2;
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDismissListener) == null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alertDialog = this.mDialog) != null && alertDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public int getSystemUiVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return 5894;
            }
            return 1280;
        }
        return invokeV.intValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.mActivity == null) {
            return;
        }
        if (this.mDialog == null) {
            AlertDialog create = new AlertDialog.Builder(this.mActivity).create();
            this.mDialog = create;
            create.requestWindowFeature(getSystemUiVisibility());
            GreyUtil.grey(this.mDialog);
        }
        if (this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mDialog.setCancelable(true);
        this.mDialog.setOnDismissListener(this.mOnDismissListener);
        this.mDialog.show();
        Window window = this.mDialog.getWindow();
        window.getDecorView().setSystemUiVisibility(getSystemUiVisibility());
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setNavigationBarColor(0);
        window.setAttributes(attributes);
        window.setDimAmount(0.0f);
        View view2 = this.mContentView;
        if (view2 != null) {
            this.mDialog.setContentView(view2);
        }
    }
}
