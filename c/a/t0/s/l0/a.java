package c.a.t0.s.l0;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f13536b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f13537c;

    /* renamed from: d  reason: collision with root package name */
    public String f13538d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13539e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f13540f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13541g;

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f13536b = null;
        this.f13538d = null;
        this.f13539e = null;
        this.f13541g = true;
        this.a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f13536b = this.a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f13536b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f13536b).create();
            this.f13537c = create;
            c.a.d.f.m.g.i(create, this.f13536b);
            View inflate = LayoutInflater.from(this.f13536b).inflate(c.a.u0.a4.h.custom_loading_toast, (ViewGroup) null);
            this.f13539e = (TextView) inflate.findViewById(c.a.u0.a4.g.custom_loading_text);
            if (!StringUtils.isNull(this.f13538d) && (textView = this.f13539e) != null) {
                textView.setText(this.f13538d);
            }
            AlertDialog alertDialog = this.f13537c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f13537c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f13537c.setCancelable(true);
                    this.f13537c.setCanceledOnTouchOutside(true);
                    this.f13537c.setOnCancelListener(onCancelListener);
                } else {
                    this.f13537c.setCanceledOnTouchOutside(false);
                    this.f13537c.setCancelable(false);
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
            if (this.f13536b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f13536b).create();
            this.f13537c = create;
            c.a.d.f.m.g.i(create, this.f13536b);
            View inflate = LayoutInflater.from(this.f13536b).inflate(c.a.u0.a4.h.custom_loading_toast, (ViewGroup) null);
            this.f13539e = (TextView) inflate.findViewById(c.a.u0.a4.g.custom_loading_text);
            if (!StringUtils.isNull(this.f13538d) && (textView = this.f13539e) != null) {
                textView.setText(this.f13538d);
            }
            AlertDialog alertDialog = this.f13537c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f13537c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f13537c.setOnCancelListener(onCancelListener);
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
            AlertDialog alertDialog = this.f13537c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13541g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f13540f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f13537c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f13537c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f13541g) {
                    a(this.f13540f);
                    return;
                } else {
                    b(this.f13540f);
                    return;
                }
            }
            c.a.d.f.m.g.a(this.f13537c, this.f13536b);
        }
    }

    public void i(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (activity = this.f13536b) == null) {
            return;
        }
        this.f13538d = activity.getString(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f13538d = str;
            TextView textView = this.f13539e;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f13536b = null;
        this.f13538d = null;
        this.f13539e = null;
        this.f13541g = true;
        this.f13536b = activity;
    }
}
