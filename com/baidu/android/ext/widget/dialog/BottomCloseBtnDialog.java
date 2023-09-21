package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BottomCloseBtnDialog extends BaseDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mCloseBtn;
    public OnCloseListener mOnCloseListener;
    public ViewGroup mUpperContainer;

    /* loaded from: classes.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BottomCloseBtnDialog mDialog;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDialog = new BottomCloseBtnDialog(context);
        }

        public Builder setCloseBtnTopMargin(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mDialog.mCloseBtn.getLayoutParams();
                layoutParams.topMargin = i;
                this.mDialog.mCloseBtn.setLayoutParams(layoutParams);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setOnCloseListener(OnCloseListener onCloseListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onCloseListener)) != null) {
                return (Builder) invokeL.objValue;
            }
            this.mDialog.mOnCloseListener = onCloseListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onDismissListener)) == null) {
                this.mDialog.setOnDismissListener(onDismissListener);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setUpperView(@LayoutRes int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.mDialog.setUpperView(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUpperView(View view2, ViewGroup.LayoutParams layoutParams) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, layoutParams)) == null) {
                this.mDialog.setUpperView(view2, layoutParams);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public BottomCloseBtnDialog show() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                BottomCloseBtnDialog bottomCloseBtnDialog = this.mDialog;
                if (bottomCloseBtnDialog != null && !bottomCloseBtnDialog.isShowing()) {
                    this.mDialog.show();
                }
                return this.mDialog;
            }
            return (BottomCloseBtnDialog) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomCloseBtnDialog(@NonNull Context context) {
        super(context, R.style.obfuscated_res_0x7f100151);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initView();
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setCancelable(true);
            setCanceledOnTouchOutside(false);
            setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.android.ext.widget.dialog.BottomCloseBtnDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomCloseBtnDialog this$0;

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

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.this$0.mOnCloseListener != null) {
                        this.this$0.mOnCloseListener.onClose();
                    }
                }
            });
        }
    }

    public void setUpperView(@LayoutRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.mUpperContainer.removeAllViews();
            LayoutInflater.from(getContext()).inflate(i, this.mUpperContainer, true);
        }
    }

    public void setUpperView(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, layoutParams) == null) {
            this.mUpperContainer.removeAllViews();
            this.mUpperContainer.addView(view2, layoutParams);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setContentView(R.layout.bottom_close_btn_dialog_layout);
            this.mUpperContainer = (ViewGroup) findViewById(R.id.upper_container);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090725);
            this.mCloseBtn = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.BottomCloseBtnDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BottomCloseBtnDialog this$0;

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
                        this.this$0.dismiss();
                        if (this.this$0.mOnCloseListener != null) {
                            this.this$0.mOnCloseListener.onClose();
                        }
                    }
                }
            });
        }
    }

    public View getUpperView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mUpperContainer.getChildCount() > 0) {
                return this.mUpperContainer.getChildAt(0);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }
}
