package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.RoundProgressBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ProgressBarDialog extends BoxAlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mContentText;
    public View mContentView;
    public RoundProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public static class Builder extends BoxAlertDialog.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog onCreateDialog(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return new ProgressBarDialog(context, R.style.obfuscated_res_0x7f10014f);
            }
            return (BoxAlertDialog) invokeL.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog.Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, onClickListener)) == null) {
                super.setNegativeButton(charSequence, onClickListener);
                this.mDialogElement.mNegativeButton.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.baidu.android.ext.widget.dialog.ProgressBarDialog.Builder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Builder this$0;
                    public final /* synthetic */ DialogInterface.OnClickListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
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
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.this$0.mDialog.onButtonClick(-2);
                            this.this$0.mDialog.dismiss();
                            DialogInterface.OnClickListener onClickListener2 = this.val$listener;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(this.this$0.mDialog, -2);
                            }
                        }
                    }
                });
                return this;
            }
            return (BoxAlertDialog.Builder) invokeLL.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.BoxAlertDialog.Builder
        public BoxAlertDialog.Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, onClickListener)) == null) {
                super.setPositiveButton(charSequence, onClickListener);
                this.mDialogElement.mPositiveButton.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.baidu.android.ext.widget.dialog.ProgressBarDialog.Builder.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Builder this$0;
                    public final /* synthetic */ DialogInterface.OnClickListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
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
                        this.val$listener = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.this$0.mDialog.onButtonClick(-1);
                            DialogInterface.OnClickListener onClickListener2 = this.val$listener;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(this.this$0.mDialog, -1);
                            }
                        }
                    }
                });
                return this;
            }
            return (BoxAlertDialog.Builder) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarDialog(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarDialog(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private View createContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d083f, (ViewGroup) null);
            this.mContentView = inflate;
            this.mContentText = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090803);
            this.mProgressBar = (RoundProgressBar) this.mContentView.findViewById(R.id.obfuscated_res_0x7f0907ff);
            return this.mContentView;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContentView = createContentView();
            getBuilder().setView(this.mContentView);
        }
    }

    public void setCircleColor(int i) {
        RoundProgressBar roundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        roundProgressBar.setCircleColor(i);
    }

    public void setCircleProgressColor(int i) {
        RoundProgressBar roundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        roundProgressBar.setCircleProgressColor(i);
    }

    public void setContentText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || (textView = this.mContentText) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setMaxProgress(int i) {
        RoundProgressBar roundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        roundProgressBar.setMax(i);
    }

    public void setProgress(int i) {
        RoundProgressBar roundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        roundProgressBar.setProgress(i);
    }

    public void setProgressTextColor(int i) {
        RoundProgressBar roundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        roundProgressBar.setTextColor(i);
    }

    public void setProgressTextSize(float f) {
        RoundProgressBar roundProgressBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048585, this, f) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        roundProgressBar.setTextSize(f);
    }

    public void showProgressBar(boolean z) {
        RoundProgressBar roundProgressBar;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048586, this, z) != null) || (roundProgressBar = this.mProgressBar) == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        roundProgressBar.setVisibility(i);
    }

    public void setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, charSequence, onClickListener) == null) {
            getBuilder().setNegativeButton(charSequence, onClickListener);
        }
    }

    public void setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, charSequence, onClickListener) == null) {
            getBuilder().setPositiveButton(charSequence, onClickListener);
        }
    }
}
