package c.a.n0.a.u;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import c.a.n0.a.s1.b.b.h;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
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

    /* renamed from: c.a.n0.a.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class DialogInterface$OnClickListenerC0462a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        public DialogInterface$OnClickListenerC0462a(c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                SwanAppActivity x = this.a.x();
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
        c.a.n0.a.t1.e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) || (L = c.a.n0.a.t1.e.L()) == null) {
            return;
        }
        b.c(z);
        int i = z ? R.string.obfuscated_res_0x7f0f0198 : R.string.obfuscated_res_0x7f0f010c;
        h.a aVar = new h.a(context);
        aVar.V(context.getString(R.string.obfuscated_res_0x7f0f0148));
        aVar.x(context.getString(i));
        aVar.n(new c.a.n0.a.q2.h.a());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f010f, new DialogInterface$OnClickListenerC0462a(L));
        aVar.X();
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            c(context, !a());
        }
    }
}
