package c.a.a0.j.j;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.j.d.g;
import com.baidu.nadcore.download.view.AdDownloadDlgView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.j.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class View$OnClickListenerC0036a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f1286b;

        public View$OnClickListenerC0036a(AlertDialog alertDialog, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alertDialog, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
            this.f1286b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a.a(this.a, this.f1286b);
            }
        }
    }

    public static boolean a(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing() || activity.getWindow() == null || !b(activity.getWindow().getDecorView())) {
                return false;
            }
            dialog.dismiss();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(View view) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (view == null || (windowToken = view.getWindowToken()) == null) {
                return false;
            }
            try {
                if (windowToken.isBinderAlive()) {
                    return windowToken.pingBinder();
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Dialog c(@NonNull g gVar, @NonNull View view, @NonNull Activity activity, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnShowListener onShowListener) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, gVar, view, activity, onDismissListener, onShowListener)) == null) {
            AlertDialog create = new AlertDialog.Builder(activity, R.style.obfuscated_res_0x7f100131).create();
            create.setCanceledOnTouchOutside(true);
            create.setOnDismissListener(onDismissListener);
            create.setOnShowListener(onShowListener);
            AdDownloadDlgView adDownloadDlgView = new AdDownloadDlgView(activity);
            adDownloadDlgView.b(gVar);
            adDownloadDlgView.setDownloadView(view);
            adDownloadDlgView.setOnCloseClickListener(new View$OnClickListenerC0036a(create, activity));
            d(create, activity);
            Window window = create.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(adDownloadDlgView);
            }
            return create;
        }
        return (Dialog) invokeLLLLL.objValue;
    }

    public static boolean d(Dialog dialog, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dialog, activity)) == null) {
            if (dialog == null || activity == null || activity.isFinishing()) {
                return false;
            }
            if (activity.getWindow() != null && !activity.getWindow().isActive()) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (activity.getWindow() != null && b(activity.getWindow().getDecorView())) {
                try {
                    dialog.show();
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
