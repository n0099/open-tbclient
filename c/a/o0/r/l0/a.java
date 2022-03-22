package c.a.o0.r.l0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f10611b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f10612c;

    /* renamed from: d  reason: collision with root package name */
    public String f10613d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f10614e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f10615f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10616g;

    public a(TbPageContext<?> tbPageContext) {
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
        this.a = null;
        this.f10611b = null;
        this.f10613d = null;
        this.f10614e = null;
        this.f10616g = true;
        this.a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f10611b = this.a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f10611b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f10611b).create();
            this.f10612c = create;
            c.a.d.f.m.g.i(create, this.f10611b);
            View inflate = LayoutInflater.from(this.f10611b).inflate(R.layout.obfuscated_res_0x7f0d0212, (ViewGroup) null);
            this.f10614e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090741);
            if (!StringUtils.isNull(this.f10613d) && (textView = this.f10614e) != null) {
                textView.setText(this.f10613d);
            }
            AlertDialog alertDialog = this.f10612c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f10612c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f10612c.setCancelable(true);
                    this.f10612c.setCanceledOnTouchOutside(true);
                    this.f10612c.setOnCancelListener(onCancelListener);
                } else {
                    this.f10612c.setCanceledOnTouchOutside(false);
                    this.f10612c.setCancelable(false);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onCancelListener)) == null) {
            if (this.f10611b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f10611b).create();
            this.f10612c = create;
            c.a.d.f.m.g.i(create, this.f10611b);
            View inflate = LayoutInflater.from(this.f10611b).inflate(R.layout.obfuscated_res_0x7f0d0212, (ViewGroup) null);
            this.f10614e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090741);
            if (!StringUtils.isNull(this.f10613d) && (textView = this.f10614e) != null) {
                textView.setText(this.f10613d);
            }
            AlertDialog alertDialog = this.f10612c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f10612c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f10612c.setOnCancelListener(onCancelListener);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlertDialog alertDialog = this.f10612c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f10616g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f10615f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f10612c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f10612c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f10616g) {
                    a(this.f10615f);
                    return;
                } else {
                    b(this.f10615f);
                    return;
                }
            }
            c.a.d.f.m.g.a(this.f10612c, this.f10611b);
        }
    }

    public void i(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (activity = this.f10611b) == null) {
            return;
        }
        this.f10613d = activity.getString(i);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f10613d = str;
            TextView textView = this.f10614e;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public a(Activity activity) {
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
        this.a = null;
        this.f10611b = null;
        this.f10613d = null;
        this.f10614e = null;
        this.f10616g = true;
        this.f10611b = activity;
    }
}
