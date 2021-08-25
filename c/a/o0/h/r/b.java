package c.a.o0.h.r;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import c.a.o0.a.e;
import c.a.o0.f.g;
import c.a.o0.h.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FullScreenFloatView f11505a;

    /* loaded from: classes3.dex */
    public class a implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f11506a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f11507b;

        public a(b bVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11507b = bVar;
            this.f11506a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f11507b.d(this.f11506a);
            }
        }
    }

    public b() {
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

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            FullScreenFloatView a2 = c.a.o0.a.z1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.f11505a = a2;
            a2.setFloatButtonText(activity.getString(g.aiapps_game_inspector_info_button));
            this.f11505a.setFloatImageBackground(e.aiapps_float_view_button_shape);
            this.f11505a.setAutoAttachEnable(false);
            this.f11505a.setDragImageListener(new a(this, activity));
            this.f11505a.setVisibility(0);
        }
    }

    public void c(a.c cVar, Activity activity) {
        c.a.o0.h.c0.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, activity) == null) && activity != null && this.f11505a == null) {
            if (c.a.o0.h.r.a.f((cVar == null || (aVar = cVar.f11514c) == null) ? null : aVar.f11094f).b()) {
                b(activity);
            }
        }
    }

    public final void d(Activity activity) {
        c.a.o0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (i2 = c.a.o0.a.a2.e.i()) == null || i2.N() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
        aVar.V(resources.getString(g.aiapps_swan_inspector_info_title));
        aVar.x(u);
        aVar.n(new c.a.o0.a.w2.h.a());
        aVar.m(false);
        aVar.O(g.aiapps_ok, null);
        aVar.X();
    }
}
