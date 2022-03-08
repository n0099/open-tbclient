package com.baidu.browser.core.permission;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.k.a.k.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdPermissionGoSettingDialog extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static String n = "package";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f31659e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f31660f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f31661g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f31662h;

    /* renamed from: i  reason: collision with root package name */
    public String f31663i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f31664j;
    public TextView k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-747328031, "Lcom/baidu/browser/core/permission/BdPermissionGoSettingDialog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-747328031, "Lcom/baidu/browser/core/permission/BdPermissionGoSettingDialog;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdPermissionGoSettingDialog(Context context) {
        super(context, R.style.BdPermissionGotoSettingDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f31659e = context;
        this.l = context.getPackageName();
    }

    public final void a(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onCancelListener) == null) {
            this.f31660f = onCancelListener;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f31663i = str;
        }
    }

    public final void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f31661g = onClickListener;
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.m = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.f31664j) {
                this.f31660f.onCancel(this);
            } else if (view != this.k || this.f31659e == null) {
            } else {
                if (this.m) {
                    dismiss();
                    View.OnClickListener onClickListener = this.f31661g;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                        return;
                    }
                    return;
                }
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(n, this.l, null));
                intent.setFlags(268435456);
                intent.setFlags(8388608);
                intent.setFlags(1073741824);
                this.f31659e.startActivity(intent);
                dismiss();
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (a.c()) {
                requestWindowFeature(1);
                a.b(getWindow().getDecorView());
            }
            View inflate = LayoutInflater.from(this.f31659e).inflate(R.layout.core_permission_go_setting, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.core_permission_go_setting_message);
            this.f31662h = textView;
            textView.setText(this.f31663i);
            TextView textView2 = (TextView) inflate.findViewById(R.id.core_permission_go_setting_cancel_button);
            this.f31664j = textView2;
            textView2.setOnClickListener(this);
            TextView textView3 = (TextView) inflate.findViewById(R.id.core_permission_go_setting_button);
            this.k = textView3;
            textView3.setOnClickListener(this);
            if (this.m) {
                this.k.setText(this.f31659e.getResources().getString(R.string.core_permission_show_permission_cycle));
            } else {
                this.k.setText(this.f31659e.getResources().getString(R.string.core_permission_go_setting));
            }
            setContentView(inflate, new ViewGroup.LayoutParams((int) this.f31659e.getResources().getDimension(R.dimen.core_permission_dialog_width), -2));
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -2;
                attributes.height = -2;
                window.setAttributes(attributes);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f31664j = null;
            this.f31660f = null;
            this.f31661g = null;
            this.f31659e = null;
            this.f31662h = null;
        }
    }

    public void show(Context context, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Boolean.valueOf(z), onCancelListener}) == null) {
            show(context, str, z, onCancelListener, false, null);
        }
    }

    public void show(Context context, String str, boolean z, DialogInterface.OnCancelListener onCancelListener, boolean z2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, str, Boolean.valueOf(z), onCancelListener, Boolean.valueOf(z2), onClickListener}) == null) || context == null) {
            return;
        }
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        a(onCancelListener);
        c(onClickListener);
        b(str);
        d(z2);
        setTitle(context.getResources().getString(R.string.core_permission_go_setting_title));
        show();
    }
}
