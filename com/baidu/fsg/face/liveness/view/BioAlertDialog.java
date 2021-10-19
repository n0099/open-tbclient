package com.baidu.fsg.face.liveness.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BioAlertDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewSwitcher f40354a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f40355b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40356c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40357d;

    /* renamed from: e  reason: collision with root package name */
    public Button f40358e;

    /* renamed from: f  reason: collision with root package name */
    public Button f40359f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40360g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f40361h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f40362i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f40363j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BioAlertDialog(Context context) {
        super(context, R.style.BeautyDialog);
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setContentView(R.layout.layout_sapi_liveness_alert_dialog);
            setCanceledOnTouchOutside(false);
            this.f40354a = (ViewSwitcher) findViewById(R.id.view_switcher);
            this.f40355b = (TextView) findViewById(R.id.dialog_title);
            this.f40356c = (TextView) findViewById(R.id.dialog_msg);
            this.f40357d = (TextView) findViewById(R.id.msg_text);
            this.f40358e = (Button) findViewById(R.id.positive_btn);
            this.f40359f = (Button) findViewById(R.id.negative_btn);
            this.f40360g = (TextView) findViewById(R.id.neutral_btn);
            this.f40361h = (LinearLayout) findViewById(R.id.unrecognized_dialog);
            this.f40362i = (TextView) findViewById(R.id.tv_recog_msg1);
            this.f40363j = (LinearLayout) findViewById(R.id.time_out_dialog_msg);
        }
    }

    public void setBtnCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 2) {
                i2 = 2;
            }
            if (i2 == 2) {
                this.f40354a.setDisplayedChild(0);
            } else {
                this.f40354a.setDisplayedChild(1);
            }
        }
    }

    public void setDialogMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f40356c.setVisibility(0);
            this.f40356c.setText(str);
        }
    }

    public void setDialogMsgColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f40356c.setTextColor(i2);
        }
    }

    public void setMessageIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f40357d.setText(i2);
        }
    }

    public void setMessageText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f40357d.setVisibility(0);
            this.f40357d.setText(str);
        }
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, onClickListener) == null) {
            this.f40359f.setText(str);
            this.f40359f.setOnClickListener(onClickListener);
        }
    }

    public void setNeutralBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, onClickListener) == null) {
            this.f40360g.setText(str);
            this.f40360g.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, onClickListener) == null) {
            this.f40358e.setText(str);
            this.f40358e.setOnClickListener(onClickListener);
        }
    }

    public void setRecognizedFailMsg1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f40362i.setText(str);
        }
    }

    public void setRecognizedFailVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f40361h.setVisibility(i2);
        }
    }

    public void setTimeOutVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f40363j.setVisibility(0);
        }
    }

    public void setTitleMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f40355b.setText(str);
        }
    }

    public void setTitleVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f40355b.setVisibility(0);
            } else {
                this.f40355b.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BioAlertDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    public void setNegativeBtn(String str, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, str, i2, onClickListener) == null) {
            this.f40359f.setText(str);
            this.f40359f.setTextColor(i2);
            this.f40359f.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BioAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), onCancelListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (DialogInterface.OnCancelListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
