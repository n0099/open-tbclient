package c.a.q0.r.l0;

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
    public Activity f12952b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f12953c;

    /* renamed from: d  reason: collision with root package name */
    public String f12954d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12955e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f12956f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12957g;

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
        this.f12952b = null;
        this.f12954d = null;
        this.f12955e = null;
        this.f12957g = true;
        this.a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f12952b = this.a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f12952b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f12952b).create();
            this.f12953c = create;
            c.a.d.f.m.g.i(create, this.f12952b);
            View inflate = LayoutInflater.from(this.f12952b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f12955e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f12954d) && (textView = this.f12955e) != null) {
                textView.setText(this.f12954d);
            }
            AlertDialog alertDialog = this.f12953c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f12953c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f12953c.setCancelable(true);
                    this.f12953c.setCanceledOnTouchOutside(true);
                    this.f12953c.setOnCancelListener(onCancelListener);
                } else {
                    this.f12953c.setCanceledOnTouchOutside(false);
                    this.f12953c.setCancelable(false);
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
            if (this.f12952b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f12952b).create();
            this.f12953c = create;
            c.a.d.f.m.g.i(create, this.f12952b);
            View inflate = LayoutInflater.from(this.f12952b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f12955e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f12954d) && (textView = this.f12955e) != null) {
                textView.setText(this.f12954d);
            }
            AlertDialog alertDialog = this.f12953c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f12953c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f12953c.setOnCancelListener(onCancelListener);
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
            AlertDialog alertDialog = this.f12953c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f12957g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f12956f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f12953c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f12953c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f12957g) {
                    a(this.f12956f);
                    return;
                } else {
                    b(this.f12956f);
                    return;
                }
            }
            c.a.d.f.m.g.a(this.f12953c, this.f12952b);
        }
    }

    public void i(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (activity = this.f12952b) == null) {
            return;
        }
        this.f12954d = activity.getString(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f12954d = str;
            TextView textView = this.f12955e;
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
        this.f12952b = null;
        this.f12954d = null;
        this.f12955e = null;
        this.f12957g = true;
        this.f12952b = activity;
    }
}
