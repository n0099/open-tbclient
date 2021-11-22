package b.a.q0.s.g0;

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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f13726a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f13727b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f13728c;

    /* renamed from: d  reason: collision with root package name */
    public String f13729d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13730e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f13731f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13732g;

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
        this.f13726a = null;
        this.f13727b = null;
        this.f13729d = null;
        this.f13730e = null;
        this.f13732g = true;
        this.f13726a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f13727b = this.f13726a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, onCancelListener)) == null) {
            if (this.f13727b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f13727b).create();
            this.f13728c = create;
            b.a.e.f.m.g.i(create, this.f13727b);
            View inflate = LayoutInflater.from(this.f13727b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f13730e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f13729d) && (textView = this.f13730e) != null) {
                textView.setText(this.f13729d);
            }
            AlertDialog alertDialog = this.f13728c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f13728c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f13728c.setCancelable(true);
                    this.f13728c.setCanceledOnTouchOutside(true);
                    this.f13728c.setOnCancelListener(onCancelListener);
                } else {
                    this.f13728c.setCanceledOnTouchOutside(false);
                    this.f13728c.setCancelable(false);
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
            if (this.f13727b == null) {
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.f13727b).create();
            this.f13728c = create;
            b.a.e.f.m.g.i(create, this.f13727b);
            View inflate = LayoutInflater.from(this.f13727b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
            this.f13730e = (TextView) inflate.findViewById(R.id.custom_loading_text);
            if (!StringUtils.isNull(this.f13729d) && (textView = this.f13730e) != null) {
                textView.setText(this.f13729d);
            }
            AlertDialog alertDialog = this.f13728c;
            if (alertDialog != null && alertDialog.getWindow() != null) {
                this.f13728c.getWindow().setContentView(inflate);
                if (onCancelListener != null) {
                    this.f13728c.setOnCancelListener(onCancelListener);
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
            AlertDialog alertDialog = this.f13728c;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13732g = z;
        }
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCancelListener) == null) {
            this.f13731f = onCancelListener;
        }
    }

    public void f(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (alertDialog = this.f13728c) == null) {
            return;
        }
        alertDialog.setCancelable(z);
    }

    public void g(boolean z) {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (alertDialog = this.f13728c) == null) {
            return;
        }
        alertDialog.setCanceledOnTouchOutside(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                if (this.f13732g) {
                    a(this.f13731f);
                    return;
                } else {
                    b(this.f13731f);
                    return;
                }
            }
            b.a.e.f.m.g.a(this.f13728c, this.f13727b);
        }
    }

    public void i(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (activity = this.f13727b) == null) {
            return;
        }
        this.f13729d = activity.getString(i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f13729d = str;
            TextView textView = this.f13730e;
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
        this.f13726a = null;
        this.f13727b = null;
        this.f13729d = null;
        this.f13730e = null;
        this.f13732g = true;
        this.f13727b = activity;
    }
}
