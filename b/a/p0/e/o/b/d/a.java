package b.a.p0.e.o.b.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import b.a.p0.a.h0.s.b;
import b.a.p0.a.k;
import b.a.p0.a.v2.f;
import b.a.p0.e.e;
import b.a.p0.e.o.b.b;
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
public class a implements b.InterfaceC0512b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9660b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f9661a;

    /* renamed from: b.a.p0.e.o.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0513a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.s.c f9662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9663f;

        public DialogInterface$OnClickListenerC0513a(a aVar, b.a.p0.a.h0.s.c cVar) {
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
            this.f9663f = aVar;
            this.f9662e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || -2 == i2) {
                return;
            }
            this.f9663f.j();
            this.f9663f.l(this.f9662e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.s.c f9664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9665f;

        /* renamed from: b.a.p0.e.o.b.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0514a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f9666a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f9667b;

            public C0514a(b bVar, Boolean bool) {
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
                this.f9667b = bVar;
                this.f9666a = bool;
            }

            @Override // b.a.p0.a.h0.s.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f9667b;
                    bVar.f9665f.i(this.f9666a, bVar.f9664e);
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
            this.f9665f = aVar;
            this.f9664e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (a.f9660b) {
                    String str = "startDownload onCallback: " + bool;
                }
                if (!bool.booleanValue()) {
                    this.f9665f.i(bool, this.f9664e);
                } else {
                    SwanAppInitHelper.doWebViewInit(b.a.p0.a.a2.d.g(), new C0514a(this, bool));
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
                b.a.p0.a.a2.d.g().q(LoadingActivity.EVENT_ID_HIDE);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1325962020, "Lb/a/p0/e/o/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1325962020, "Lb/a/p0/e/o/b/d/a;");
                return;
            }
        }
        f9660b = k.f6397a;
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
        this.f9661a = false;
    }

    @Override // b.a.p0.e.o.b.b.InterfaceC0512b
    public b.a.p0.n.l.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b.a.p0.w.c() : (b.a.p0.n.l.b) invokeV.objValue;
    }

    @Override // b.a.p0.e.o.b.b.InterfaceC0512b
    public void b(boolean z, b.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
            if (this.f9661a) {
                if (!z) {
                    j();
                }
                l(cVar);
            } else if (z) {
                l(cVar);
            } else {
                k(new DialogInterface$OnClickListenerC0513a(this, cVar));
            }
        }
    }

    @Override // b.a.p0.e.o.b.b.InterfaceC0512b
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
            b.a.p0.a.a2.d.i().post(new d(this));
        }
    }

    public final void i(Boolean bool, b.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bool, cVar) == null) {
            this.f9661a = false;
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
            b.a.p0.a.a2.d.i().post(new c(this));
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
            this.f9661a = true;
            boolean z = f9660b;
            b.a.p0.a.n0.k.c cVar2 = b.a.p0.a.n0.k.c.f6843d;
            b.a.p0.a.n0.k.d dVar = new b.a.p0.a.n0.k.d();
            dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(this, cVar));
            cVar2.C(dVar);
        }
    }
}
