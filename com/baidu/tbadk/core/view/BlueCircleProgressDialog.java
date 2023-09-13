package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.kg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BlueCircleProgressDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAutoSetCancelable;
    public Activity mActivity;
    public TbPageContext<?> mContext;
    public DialogInterface.OnCancelListener mOnCancelListner;
    public TextView mTipView;
    public AlertDialog mWaitingDialog;
    public String tipString;

    public BlueCircleProgressDialog(Activity activity) {
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
        this.mContext = null;
        this.mActivity = null;
        this.tipString = null;
        this.mTipView = null;
        this.isAutoSetCancelable = true;
        this.mActivity = activity;
    }

    public BlueCircleProgressDialog(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mActivity = null;
        this.tipString = null;
        this.mTipView = null;
        this.isAutoSetCancelable = true;
        this.mContext = tbPageContext;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            this.mActivity = this.mContext.getPageActivity();
        }
    }

    private BlueCircleProgressDialog create(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, onCancelListener)) == null) {
            if (this.mActivity == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.mActivity).create();
            this.mWaitingDialog = create;
            GreyUtil.grey(create);
            kg.i(this.mWaitingDialog, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.mTipView = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.tipString) && (textView = this.mTipView) != null) {
                textView.setText(this.tipString);
            }
            AlertDialog alertDialog = this.mWaitingDialog;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.mWaitingDialog.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.mWaitingDialog.setCancelable(true);
                    this.mWaitingDialog.setCanceledOnTouchOutside(true);
                    this.mWaitingDialog.setOnCancelListener(onCancelListener);
                } else {
                    this.mWaitingDialog.setCanceledOnTouchOutside(false);
                    this.mWaitingDialog.setCancelable(false);
                }
            }
            return this;
        }
        return (BlueCircleProgressDialog) invokeL.objValue;
    }

    private BlueCircleProgressDialog createCanSetCancelableDialog(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, onCancelListener)) == null) {
            if (this.mActivity == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.mActivity).create();
            this.mWaitingDialog = create;
            GreyUtil.grey(create);
            kg.i(this.mWaitingDialog, this.mActivity);
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.mTipView = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.tipString) && (textView = this.mTipView) != null) {
                textView.setText(this.tipString);
            }
            AlertDialog alertDialog = this.mWaitingDialog;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.mWaitingDialog.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.mWaitingDialog.setOnCancelListener(onCancelListener);
                }
            }
            return this;
        }
        return (BlueCircleProgressDialog) invokeL.objValue;
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mActivity;
        }
        return (Activity) invokeV.objValue;
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AlertDialog alertDialog = this.mWaitingDialog;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setAutoSetCancelable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.isAutoSetCancelable = z;
        }
    }

    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onCancelListener) == null) {
            this.mOnCancelListner = onCancelListener;
        }
    }

    public void setCancelable(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (alertDialog = this.mWaitingDialog) != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (alertDialog = this.mWaitingDialog) != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void setDialogVisiable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                if (this.isAutoSetCancelable) {
                    create(this.mOnCancelListner);
                    return;
                } else {
                    createCanSetCancelableDialog(this.mOnCancelListner);
                    return;
                }
            }
            kg.a(this.mWaitingDialog, this.mActivity);
        }
    }

    public void setTipString(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (activity = this.mActivity) != null) {
            this.tipString = activity.getString(i);
        }
    }

    public void setTipString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.tipString = str;
            TextView textView = this.mTipView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}
