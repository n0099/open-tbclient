package c.a.r0.a.e0;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import c.a.r0.a.h;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0305a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f5725e;

        public DialogInterface$OnClickListenerC0305a(c.a.r0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5725e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                SwanAppActivity x = this.f5725e.x();
                if (x != null && Build.VERSION.SDK_INT >= 21) {
                    x.finishAndRemoveTask();
                }
                System.exit(0);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : invokeV.booleanValue;
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            a = z;
        }
    }

    public static void c(Context context, boolean z) {
        c.a.r0.a.d2.e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) || (L = c.a.r0.a.d2.e.L()) == null) {
            return;
        }
        b.c(z);
        int i2 = z ? h.aiapps_open_debug : h.aiapps_close_debug;
        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
        aVar.V(context.getString(h.aiapps_debug_switch_title));
        aVar.x(context.getString(i2));
        aVar.n(new c.a.r0.a.a3.h.a());
        aVar.m(false);
        aVar.O(h.aiapps_confirm, new DialogInterface$OnClickListenerC0305a(L));
        aVar.X();
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            c(context, !a());
        }
    }
}
