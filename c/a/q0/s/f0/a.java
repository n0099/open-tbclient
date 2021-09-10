package c.a.q0.s.f0;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f13803a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f13804b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f13805c;

    /* renamed from: d  reason: collision with root package name */
    public String f13806d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13807e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f13808f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13809g;

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
        this.f13803a = null;
        this.f13804b = null;
        this.f13806d = null;
        this.f13807e = null;
        this.f13809g = true;
        this.f13803a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f13804b = this.f13803a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f13804b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f13804b).create();
            this.f13805c = create;
            c.a.e.e.m.g.i(create, this.f13804b);
            View inflate = LayoutInflater.from(this.f13804b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f13807e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f13806d) && (textView = this.f13807e) != null) {
                textView.setText(this.f13806d);
            }
            AlertDialog alertDialog = this.f13805c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f13805c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f13805c.setCancelable(true);
                    this.f13805c.setCanceledOnTouchOutside(true);
                    this.f13805c.setOnCancelListener(onCancelListener);
                } else {
                    this.f13805c.setCanceledOnTouchOutside(false);
                    this.f13805c.setCancelable(false);
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
            if (this.f13804b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f13804b).create();
            this.f13805c = create;
            c.a.e.e.m.g.i(create, this.f13804b);
            View inflate = LayoutInflater.from(this.f13804b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f13807e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f13806d) && (textView = this.f13807e) != null) {
                textView.setText(this.f13806d);
            }
            AlertDialog alertDialog = this.f13805c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f13805c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f13805c.setOnCancelListener(onCancelListener);
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
            AlertDialog alertDialog = this.f13805c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13809g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f13808f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f13805c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f13805c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f13809g) {
                    a(this.f13808f);
                    return;
                } else {
                    b(this.f13808f);
                    return;
                }
            }
            c.a.e.e.m.g.a(this.f13805c, this.f13804b);
        }
    }

    public void i(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (activity = this.f13804b) == null) {
            return;
        }
        this.f13806d = activity.getString(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f13806d = str;
            TextView textView = this.f13807e;
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
        this.f13803a = null;
        this.f13804b = null;
        this.f13806d = null;
        this.f13807e = null;
        this.f13809g = true;
        this.f13804b = activity;
    }
}
