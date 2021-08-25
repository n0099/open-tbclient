package c.a.o0.a.w2.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.o0.a.v2.f;
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
    public FrameLayout f9637a;

    /* renamed from: c.a.o0.a.w2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0451a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f9638e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9639f;

        public RunnableC0451a(a aVar, ViewGroup viewGroup) {
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
            this.f9639f = aVar;
            this.f9638e = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9639f.f9637a == null) {
                    this.f9639f.f9637a = new FrameLayout(this.f9638e.getContext());
                    this.f9639f.f9637a.setBackgroundResource(c.a.o0.a.c.aiapps_night_mode_cover_layer);
                }
                this.f9638e.removeView(this.f9639f.f9637a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.f9638e.addView(this.f9639f.f9637a, layoutParams);
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
        this.f9637a = null;
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
            if (c.a.o0.a.c1.a.H().a()) {
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
        view.post(new RunnableC0451a(this, viewGroup));
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) || viewGroup == null || (frameLayout = this.f9637a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f9637a = null;
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
