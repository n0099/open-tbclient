package c.a.p0.a.v1;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.n2.h;
import c.a.p0.a.v1.g;
import c.a.p0.a.z2.a0;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.res.widget.dialog.PermissionHoverDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
/* loaded from: classes.dex */
public final class b implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8639b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8640c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8641d;

    /* renamed from: e  reason: collision with root package name */
    public final f f8642e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f8643f;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8645f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8645f = bVar;
            this.f8644e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f8645f.a) {
                if (!this.f8645f.f8639b) {
                    this.f8645f.h(this.f8644e, i2, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.v1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0512b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8647f;

        public DialogInterface$OnClickListenerC0512b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8647f = bVar;
            this.f8646e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f8647f.i(this.f8646e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8649f;

        public c(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8649f = bVar;
            this.f8648e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f8649f.h(this.f8648e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8650e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8650e = bVar;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f8650e.a = true;
                this.f8650e.j("show");
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8651e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f8652f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8653g;

        public e(b bVar, String str, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8653g = bVar;
            this.f8651e = str;
            this.f8652f = fVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f8653g.p(this.f8651e, this.f8652f);
                this.f8653g.a = false;
            }
        }
    }

    public b(Context context, int i2, @NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f8639b = false;
        this.f8640c = false;
        this.f8643f = context;
        this.f8641d = i2;
        this.f8642e = fVar;
    }

    public final void h(String str, int i2, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, dialogInterface) == null) {
            boolean z = i2 == 1;
            r(str, z);
            if (z) {
                j("deny_mute");
            } else {
                j("deny");
            }
            dialogInterface.dismiss();
        }
    }

    public final void i(String str, int i2, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, dialogInterface) == null) {
            boolean z = i2 == 1;
            r(str, z);
            if (z) {
                j("skip_mute");
            } else {
                j(FreeSpaceBox.TYPE);
            }
            this.f8639b = true;
            dialogInterface.dismiss();
            a0.g(this.f8643f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c.a.p0.a.d2.d J = c.a.p0.a.d2.d.J();
            String appId = J.getAppId();
            c.a.p0.a.n2.s.e eVar = new c.a.p0.a.n2.s.e();
            eVar.f7117f = appId;
            eVar.a = "swan";
            eVar.f7114c = c.a.p0.a.v1.c.a(this.f8641d);
            eVar.f7118g = "minipnl";
            eVar.f7113b = str;
            eVar.f7116e = c.a.p0.a.v1.c.b(this.f8640c);
            eVar.a("appid", appId);
            eVar.a("appname", J.r().Y());
            eVar.a("host", c.a.p0.a.c1.a.n().a());
            h.onEvent(eVar);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? c.a.p0.a.o2.g.h.a().getBoolean(str, false) : invokeL.booleanValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String N = c.a.p0.a.d2.d.J().r().N();
            return "permission/" + str + "/" + N;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = c.a.p0.a.d2.d.J().getApplicationContext();
            return applicationContext.getString(c.a.p0.a.h.swanapp_perm_hover_dialog_tip, q0.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? c.a.p0.a.d2.d.J().getApplicationContext().getString(c.a.p0.a.h.swanapp_perm_hover_dialog_title, str) : (String) invokeL.objValue;
    }

    public final PermissionHoverDialog o(Context context, String str, String str2, String str3, String str4, f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{context, str, str2, str3, str4, fVar})) == null) {
            PermissionHoverDialog.a aVar = new PermissionHoverDialog.a(context);
            aVar.f0(str);
            aVar.e0(str2);
            aVar.i0(new e(this, str4, fVar));
            aVar.j0(new d(this));
            aVar.g0(new c(this, str3));
            aVar.k0(new DialogInterface$OnClickListenerC0512b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (PermissionHoverDialog) invokeCommon.objValue;
    }

    @Override // c.a.p0.a.v1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, strArr, iArr) == null) {
            if (i2 != this.f8641d) {
                this.f8642e.b(2, "request permission fail");
            } else if (strArr.length == 0 && iArr.length == 0) {
                this.f8642e.a("permission granted successful");
            } else if (strArr.length != iArr.length) {
                this.f8642e.b(2, "request permission fail");
            } else if (!(this.f8643f instanceof SwanAppBaseActivity)) {
                this.f8642e.b(2, "request permission fail");
            } else {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    String str = strArr[i3];
                    if (iArr[i3] == -1) {
                        if (!c.a.p0.r.a.a.a.j((SwanAppBaseActivity) this.f8643f, str)) {
                            q(str, this.f8642e);
                            return;
                        } else {
                            this.f8642e.b(1, "user denied");
                            return;
                        }
                    }
                }
                this.f8642e.a("permission granted successful");
            }
        }
    }

    public final void p(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, fVar) == null) {
            Context context = this.f8643f;
            boolean z = context != null && c.a.p0.x.d.c.a(context, str);
            this.f8640c = z;
            if (z) {
                fVar.a("permission granted successful");
            } else {
                fVar.b(1, "user denied");
            }
        }
    }

    public final void q(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, fVar) == null) {
            if (!(this.f8643f instanceof SwanAppBaseActivity)) {
                this.f8642e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.f8642e.b(2, "request permission fail");
                return;
            }
            String m = a0.m(str);
            if (m != null && m.trim().length() != 0) {
                o(this.f8643f, n(m), m(m), l, str, fVar).show();
                return;
            }
            this.f8642e.b(2, "request permission fail");
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || str == null) {
            return;
        }
        c.a.p0.a.o2.g.h.a().putBoolean(str, z);
    }

    public g.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new c.a.p0.a.v1.a(this.f8641d, this.f8642e) : (g.a) invokeV.objValue;
    }
}
