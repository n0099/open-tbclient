package c.a.o0.a.s1;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k2.g.h;
import c.a.o0.a.s1.g;
import c.a.o0.a.v2.a0;
import c.a.o0.a.v2.q0;
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

    /* renamed from: a  reason: collision with root package name */
    public boolean f8552a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8553b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8554c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8555d;

    /* renamed from: e  reason: collision with root package name */
    public final f f8556e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f8557f;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8559f;

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
            this.f8559f = bVar;
            this.f8558e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f8559f.f8552a) {
                if (!this.f8559f.f8553b) {
                    this.f8559f.h(this.f8558e, i2, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* renamed from: c.a.o0.a.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0369b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8561f;

        public DialogInterface$OnClickListenerC0369b(b bVar, String str) {
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
            this.f8561f = bVar;
            this.f8560e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f8561f.i(this.f8560e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f8563f;

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
            this.f8563f = bVar;
            this.f8562e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f8563f.h(this.f8562e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f8564a;

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
            this.f8564a = bVar;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f8564a.f8552a = true;
                this.f8564a.j("show");
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f8566f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8567g;

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
            this.f8567g = bVar;
            this.f8565e = str;
            this.f8566f = fVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f8567g.p(this.f8565e, this.f8566f);
                this.f8567g.f8552a = false;
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
        this.f8552a = false;
        this.f8553b = false;
        this.f8554c = false;
        this.f8557f = context;
        this.f8555d = i2;
        this.f8556e = fVar;
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
            this.f8553b = true;
            dialogInterface.dismiss();
            a0.g(this.f8557f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            c.a.o0.a.a2.d g2 = c.a.o0.a.a2.d.g();
            String appId = g2.getAppId();
            c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
            eVar.f7040f = appId;
            eVar.f7035a = "swan";
            eVar.f7037c = c.a.o0.a.s1.c.a(this.f8555d);
            eVar.f7041g = "minipnl";
            eVar.f7036b = str;
            eVar.f7039e = c.a.o0.a.s1.c.b(this.f8554c);
            eVar.a("appid", appId);
            eVar.a("appname", g2.r().O());
            eVar.a("host", c.a.o0.a.c1.a.m().a());
            c.a.o0.a.j2.g.onEvent(eVar);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? h.a().getBoolean(str, false) : invokeL.booleanValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String D = c.a.o0.a.a2.d.g().r().D();
            return "permission/" + str + "/" + D;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = c.a.o0.a.a2.d.g().getApplicationContext();
            return applicationContext.getString(c.a.o0.a.h.swanapp_perm_hover_dialog_tip, q0.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? c.a.o0.a.a2.d.g().getApplicationContext().getString(c.a.o0.a.h.swanapp_perm_hover_dialog_title, str) : (String) invokeL.objValue;
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
            aVar.k0(new DialogInterface$OnClickListenerC0369b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (PermissionHoverDialog) invokeCommon.objValue;
    }

    @Override // c.a.o0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, strArr, iArr) == null) {
            if (i2 != this.f8555d) {
                this.f8556e.b(2, "request permission fail");
            } else if (strArr.length == 0 && iArr.length == 0) {
                this.f8556e.a("permission granted successful");
            } else if (strArr.length != iArr.length) {
                this.f8556e.b(2, "request permission fail");
            } else if (!(this.f8557f instanceof SwanAppBaseActivity)) {
                this.f8556e.b(2, "request permission fail");
            } else {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    String str = strArr[i3];
                    if (iArr[i3] == -1) {
                        if (!c.a.o0.o.a.a.a.k((SwanAppBaseActivity) this.f8557f, str)) {
                            q(str, this.f8556e);
                            return;
                        } else {
                            this.f8556e.b(1, "user denied");
                            return;
                        }
                    }
                }
                this.f8556e.a("permission granted successful");
            }
        }
    }

    public final void p(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, fVar) == null) {
            Context context = this.f8557f;
            boolean z = context != null && c.a.o0.u.d.c.a(context, str);
            this.f8554c = z;
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
            if (!(this.f8557f instanceof SwanAppBaseActivity)) {
                this.f8556e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.f8556e.b(2, "request permission fail");
                return;
            }
            String n = a0.n(str);
            if (n != null && n.trim().length() != 0) {
                o(this.f8557f, n(n), m(n), l, str, fVar).show();
                return;
            }
            this.f8556e.b(2, "request permission fail");
        }
    }

    public final void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) || str == null) {
            return;
        }
        h.a().putBoolean(str, z);
    }

    public g.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new c.a.o0.a.s1.a(this.f8555d, this.f8556e) : (g.a) invokeV.objValue;
    }
}
