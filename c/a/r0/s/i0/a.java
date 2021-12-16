package c.a.r0.s.i0;

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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f12991b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f12992c;

    /* renamed from: d  reason: collision with root package name */
    public String f12993d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12994e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f12995f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12996g;

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
        this.f12991b = null;
        this.f12993d = null;
        this.f12994e = null;
        this.f12996g = true;
        this.a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f12991b = this.a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f12991b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f12991b).create();
            this.f12992c = create;
            c.a.d.f.m.g.i(create, this.f12991b);
            View inflate = LayoutInflater.from(this.f12991b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f12994e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f12993d) && (textView = this.f12994e) != null) {
                textView.setText(this.f12993d);
            }
            AlertDialog alertDialog = this.f12992c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f12992c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f12992c.setCancelable(true);
                    this.f12992c.setCanceledOnTouchOutside(true);
                    this.f12992c.setOnCancelListener(onCancelListener);
                } else {
                    this.f12992c.setCanceledOnTouchOutside(false);
                    this.f12992c.setCancelable(false);
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
            if (this.f12991b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f12991b).create();
            this.f12992c = create;
            c.a.d.f.m.g.i(create, this.f12991b);
            View inflate = LayoutInflater.from(this.f12991b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f12994e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f12993d) && (textView = this.f12994e) != null) {
                textView.setText(this.f12993d);
            }
            AlertDialog alertDialog = this.f12992c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f12992c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f12992c.setOnCancelListener(onCancelListener);
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
            AlertDialog alertDialog = this.f12992c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f12996g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f12995f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f12992c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f12992c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f12996g) {
                    a(this.f12995f);
                    return;
                } else {
                    b(this.f12995f);
                    return;
                }
            }
            c.a.d.f.m.g.a(this.f12992c, this.f12991b);
        }
    }

    public void i(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (activity = this.f12991b) == null) {
            return;
        }
        this.f12993d = activity.getString(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f12993d = str;
            TextView textView = this.f12994e;
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
        this.f12991b = null;
        this.f12993d = null;
        this.f12994e = null;
        this.f12996g = true;
        this.f12991b = activity;
    }
}
