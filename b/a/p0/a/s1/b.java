package b.a.p0.a.s1;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k2.g.h;
import b.a.p0.a.s1.g;
import b.a.p0.a.v2.a0;
import b.a.p0.a.v2.q0;
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
    public boolean f7856a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7857b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7858c;

    /* renamed from: d  reason: collision with root package name */
    public final int f7859d;

    /* renamed from: e  reason: collision with root package name */
    public final f f7860e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f7861f;

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7863f;

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
            this.f7863f = bVar;
            this.f7862e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) && this.f7863f.f7856a) {
                if (!this.f7863f.f7857b) {
                    this.f7863f.h(this.f7862e, i2, dialogInterface);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.s1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0366b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7865f;

        public DialogInterface$OnClickListenerC0366b(b bVar, String str) {
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
            this.f7865f = bVar;
            this.f7864e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f7865f.i(this.f7864e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f7867f;

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
            this.f7867f = bVar;
            this.f7866e = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f7867f.h(this.f7866e, i2, dialogInterface);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f7868e;

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
            this.f7868e = bVar;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f7868e.f7856a = true;
                this.f7868e.j("show");
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f7870f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f7871g;

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
            this.f7871g = bVar;
            this.f7869e = str;
            this.f7870f = fVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f7871g.p(this.f7869e, this.f7870f);
                this.f7871g.f7856a = false;
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
        this.f7856a = false;
        this.f7857b = false;
        this.f7858c = false;
        this.f7861f = context;
        this.f7859d = i2;
        this.f7860e = fVar;
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
            this.f7857b = true;
            dialogInterface.dismiss();
            a0.g(this.f7861f);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            String appId = g2.getAppId();
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6388f = appId;
            eVar.f6383a = "swan";
            eVar.f6385c = b.a.p0.a.s1.c.a(this.f7859d);
            eVar.f6389g = "minipnl";
            eVar.f6384b = str;
            eVar.f6387e = b.a.p0.a.s1.c.b(this.f7858c);
            eVar.a("appid", appId);
            eVar.a("appname", g2.r().N());
            eVar.a("host", b.a.p0.a.c1.a.m().a());
            b.a.p0.a.j2.g.onEvent(eVar);
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
            String k = b.a.p0.a.a2.d.g().r().k();
            return "permission/" + str + "/" + k;
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context applicationContext = b.a.p0.a.a2.d.g().getApplicationContext();
            return applicationContext.getString(b.a.p0.a.h.swanapp_perm_hover_dialog_tip, q0.l(applicationContext), str);
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? b.a.p0.a.a2.d.g().getApplicationContext().getString(b.a.p0.a.h.swanapp_perm_hover_dialog_title, str) : (String) invokeL.objValue;
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
            aVar.k0(new DialogInterface$OnClickListenerC0366b(this, str3));
            aVar.h0(new a(this, str3));
            return aVar.c();
        }
        return (PermissionHoverDialog) invokeCommon.objValue;
    }

    @Override // b.a.p0.a.s1.g.a
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, strArr, iArr) == null) {
            if (i2 != this.f7859d) {
                this.f7860e.b(2, "request permission fail");
            } else if (strArr.length == 0 && iArr.length == 0) {
                this.f7860e.a("permission granted successful");
            } else if (strArr.length != iArr.length) {
                this.f7860e.b(2, "request permission fail");
            } else if (!(this.f7861f instanceof SwanAppBaseActivity)) {
                this.f7860e.b(2, "request permission fail");
            } else {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    String str = strArr[i3];
                    if (iArr[i3] == -1) {
                        if (!b.a.p0.o.a.a.a.j((SwanAppBaseActivity) this.f7861f, str)) {
                            q(str, this.f7860e);
                            return;
                        } else {
                            this.f7860e.b(1, "user denied");
                            return;
                        }
                    }
                }
                this.f7860e.a("permission granted successful");
            }
        }
    }

    public final void p(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, fVar) == null) {
            Context context = this.f7861f;
            boolean z = context != null && b.a.p0.u.d.c.a(context, str);
            this.f7858c = z;
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
            if (!(this.f7861f instanceof SwanAppBaseActivity)) {
                this.f7860e.b(2, "request permission fail");
                return;
            }
            String l = l(str);
            if (k(l)) {
                this.f7860e.b(2, "request permission fail");
                return;
            }
            String m = a0.m(str);
            if (m != null && m.trim().length() != 0) {
                o(this.f7861f, n(m), m(m), l, str, fVar).show();
                return;
            }
            this.f7860e.b(2, "request permission fail");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new b.a.p0.a.s1.a(this.f7859d, this.f7860e) : (g.a) invokeV.objValue;
    }
}
