package b.a.p0.g.p.b.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import b.a.p0.a.h0.s.b;
import b.a.p0.a.k;
import b.a.p0.a.z2.f;
import b.a.p0.g.e;
import b.a.p0.g.p.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
/* loaded from: classes.dex */
public class a implements b.InterfaceC0538b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10309b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10310a;

    /* renamed from: b.a.p0.g.p.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0539a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.s.c f10311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10312f;

        public DialogInterface$OnClickListenerC0539a(a aVar, b.a.p0.a.h0.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10312f = aVar;
            this.f10311e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || -2 == i2) {
                return;
            }
            this.f10312f.j();
            this.f10312f.l(this.f10311e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.s.c f10313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10314f;

        /* renamed from: b.a.p0.g.p.b.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0540a implements b.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f10315a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f10316b;

            public C0540a(b bVar, Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bool};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10316b = bVar;
                this.f10315a = bool;
            }

            @Override // b.a.p0.a.h0.s.b.e
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f10316b;
                    bVar.f10314f.i(this.f10315a, bVar.f10313e);
                }
            }
        }

        public b(a aVar, b.a.p0.a.h0.s.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10314f = aVar;
            this.f10313e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (a.f10309b) {
                    String str = "startDownload onCallback: " + bool;
                }
                if (!bool.booleanValue()) {
                    this.f10314f.i(bool, this.f10313e);
                } else {
                    SwanAppInitHelper.doWebViewInit(b.a.p0.a.d2.d.J(), new C0540a(this, bool));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context appContext = AppRuntime.getAppContext();
                Intent intent = new Intent(appContext, LoadingActivity.class);
                intent.addFlags(268435456);
                intent.putExtra(LoadingActivity.EXT_SO_LIB_NAME, ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
                f.g(appContext, intent);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.d2.d.J().q(LoadingActivity.EVENT_ID_HIDE);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1619221951, "Lb/a/p0/g/p/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1619221951, "Lb/a/p0/g/p/b/d/a;");
                return;
            }
        }
        f10309b = k.f6863a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10310a = false;
    }

    @Override // b.a.p0.g.p.b.b.InterfaceC0538b
    public b.a.p0.q.m.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b.a.p0.a0.b() : (b.a.p0.q.m.b) invokeV.objValue;
    }

    @Override // b.a.p0.g.p.b.b.InterfaceC0538b
    public void b(boolean z, b.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
            if (this.f10310a) {
                if (!z) {
                    j();
                }
                l(cVar);
            } else if (z) {
                l(cVar);
            } else {
                k(new DialogInterface$OnClickListenerC0539a(this, cVar));
            }
        }
    }

    @Override // b.a.p0.g.p.b.b.InterfaceC0538b
    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.p0.a.d2.d.L().post(new d(this));
        }
    }

    public final void i(Boolean bool, b.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bool, cVar) == null) {
            this.f10310a = false;
            h();
            if (cVar != null) {
                if (bool.booleanValue()) {
                    cVar.onSuccess();
                } else {
                    cVar.onFail();
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.p0.a.d2.d.L().post(new c(this));
        }
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
            newBuilder.B(e.aiapps_t7_download_tip_title);
            newBuilder.u(e.aiapps_t7_download_tip_msg);
            newBuilder.w(e.aiapps_t7_download_tip_btn_cancel, onClickListener);
            newBuilder.z(e.aiapps_t7_download_tip_btn_ok, onClickListener);
            newBuilder.D();
        }
    }

    public final void l(b.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f10310a = true;
            boolean z = f10309b;
            b.a.p0.a.n0.k.c cVar2 = b.a.p0.a.n0.k.c.f7172d;
            b.a.p0.a.n0.k.d dVar = new b.a.p0.a.n0.k.d();
            dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(this, cVar));
            cVar2.C(dVar);
        }
    }
}
