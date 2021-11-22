package b.a.p0.a.a3.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.p0.a.z2.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements SwanAppAlertDialog.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f4130a;

    /* renamed from: b.a.p0.a.a3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0121a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4131e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4132f;

        public RunnableC0121a(a aVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4132f = aVar;
            this.f4131e = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4132f.f4130a == null) {
                    this.f4132f.f4130a = new FrameLayout(this.f4131e.getContext());
                    this.f4132f.f4130a.setBackgroundResource(b.a.p0.a.c.aiapps_night_mode_cover_layer);
                }
                this.f4131e.removeView(this.f4132f.f4130a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.f4131e.addView(this.f4132f.f4130a, layoutParams);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4130a = null;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog.c
    public void a(SwanAppAlertDialog swanAppAlertDialog, SwanAppAlertDialog.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, swanAppAlertDialog, bVar) == null) || swanAppAlertDialog == null || bVar == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        f(swanAppAlertDialog);
        ViewGroup viewGroup = (ViewGroup) swanAppAlertDialog.findViewById(16908290);
        if (viewGroup != null) {
            if (b.a.p0.a.c1.a.M().a()) {
                d(viewGroup, bVar.r);
            } else {
                e(viewGroup);
            }
        }
    }

    public final void d(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view) == null) || viewGroup == null || view == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        view.post(new RunnableC0121a(this, viewGroup));
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) || viewGroup == null || (frameLayout = this.f4130a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f4130a = null;
    }

    public final void f(SwanAppAlertDialog swanAppAlertDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, swanAppAlertDialog) == null) {
            Context context = swanAppAlertDialog.getContext();
            if (swanAppAlertDialog.getContext() instanceof ContextWrapper) {
                context = ((ContextWrapper) swanAppAlertDialog.getContext()).getBaseContext();
            }
            if (context instanceof Activity) {
                f.b((Activity) context, swanAppAlertDialog);
            }
        }
    }
}
