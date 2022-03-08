package c.a.p0.a.x.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import c.a.p0.a.f.d.n;
import c.a.p0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8270b;

        public a(Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f8270b = bVar;
        }

        @Override // c.a.p0.a.f.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    c.a.p0.a.u.d.c("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    this.f8270b.a(false, this.a.getString(R.string.aiapps_authenticate_fail));
                    return;
                }
                c.a.p0.a.u.d.c("DeveloperAuthenticateHelper", "Authentication Success");
                this.f8270b.a(true, "");
            }
        }

        @Override // c.a.p0.a.f.d.n.b
        public void b(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c.a.p0.a.u.d.d("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getString(R.string.aiapps_authenticate_fail));
                if (TextUtils.isEmpty(message)) {
                    str = "";
                } else {
                    str = StringUtils.LF + message;
                }
                sb.append(str);
                this.f8270b.a(false, sb.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public static void a(@NonNull e eVar, @NonNull Context context, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, eVar, context, bVar) == null) {
            c.a.p0.a.c.b.b(eVar.N(), new a(context, bVar));
        }
    }

    public static void b(Context context, @StringRes int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i2, str) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
            aVar.U(i2);
            aVar.x(str);
            aVar.n(new c.a.p0.a.q2.h.a());
            aVar.O(R.string.aiapps_confirm, null);
            aVar.X();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            b(context, R.string.aiapps_debug_switch_title, str);
        }
    }
}
