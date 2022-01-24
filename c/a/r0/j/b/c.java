package c.a.r0.j.b;

import android.app.Activity;
import android.content.DialogInterface;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppAlertDialog a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f10957e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10958f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10959g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f10960h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f10961i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f10962j;

        public a(c cVar, Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, str, str2, Boolean.valueOf(z), onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10962j = cVar;
            this.f10957e = activity;
            this.f10958f = str;
            this.f10959g = str2;
            this.f10960h = z;
            this.f10961i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10962j.a != null && this.f10962j.a.isShowing()) {
                    this.f10962j.a.dismiss();
                }
                Activity activity = this.f10957e;
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                SwanAppAlertDialog.a d2 = this.f10962j.d(this.f10957e, this.f10958f, this.f10959g, this.f10960h, this.f10961i);
                this.f10962j.a = d2.X();
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final SwanAppAlertDialog.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener})) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
            aVar.x(str);
            aVar.a();
            aVar.n(new c.a.r0.a.a3.h.a());
            aVar.m(z);
            aVar.Q(c.a.r0.h.b.swan_games_antiaddiction_positive);
            aVar.f(true);
            aVar.P(str2, onClickListener);
            return aVar;
        }
        return (SwanAppAlertDialog.a) invokeCommon.objValue;
    }

    public void e() {
        SwanAppAlertDialog swanAppAlertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (swanAppAlertDialog = this.a) == null) {
            return;
        }
        if (swanAppAlertDialog.isShowing()) {
            this.a.dismiss();
        }
        this.a = null;
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener}) == null) {
            q0.a0(new a(this, activity, str, str2, z, onClickListener));
        }
    }
}
