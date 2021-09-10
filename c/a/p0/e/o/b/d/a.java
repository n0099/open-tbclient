package c.a.p0.e.o.b.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import c.a.p0.a.h0.s.b;
import c.a.p0.a.k;
import c.a.p0.a.v2.f;
import c.a.p0.e.e;
import c.a.p0.e.o.b.b;
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
public class a implements b.InterfaceC0517b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10432b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10433a;

    /* renamed from: c.a.p0.e.o.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnClickListenerC0518a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.s.c f10434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10435f;

        public DialogInterface$OnClickListenerC0518a(a aVar, c.a.p0.a.h0.s.c cVar) {
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
            this.f10435f = aVar;
            this.f10434e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || -2 == i2) {
                return;
            }
            this.f10435f.j();
            this.f10435f.l(this.f10434e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.s.c f10436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10437f;

        /* renamed from: c.a.p0.e.o.b.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0519a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f10438a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f10439b;

            public C0519a(b bVar, Boolean bool) {
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
                this.f10439b = bVar;
                this.f10438a = bool;
            }

            @Override // c.a.p0.a.h0.s.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f10439b;
                    bVar.f10437f.i(this.f10438a, bVar.f10436e);
                }
            }
        }

        public b(a aVar, c.a.p0.a.h0.s.c cVar) {
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
            this.f10437f = aVar;
            this.f10436e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (a.f10432b) {
                    String str = "startDownload onCallback: " + bool;
                }
                if (!bool.booleanValue()) {
                    this.f10437f.i(bool, this.f10436e);
                } else {
                    SwanAppInitHelper.doWebViewInit(c.a.p0.a.a2.d.g(), new C0519a(this, bool));
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
                c.a.p0.a.a2.d.g().q(LoadingActivity.EVENT_ID_HIDE);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1615695579, "Lc/a/p0/e/o/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1615695579, "Lc/a/p0/e/o/b/d/a;");
                return;
            }
        }
        f10432b = k.f7077a;
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
        this.f10433a = false;
    }

    @Override // c.a.p0.e.o.b.b.InterfaceC0517b
    public c.a.p0.n.l.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.p0.w.c() : (c.a.p0.n.l.b) invokeV.objValue;
    }

    @Override // c.a.p0.e.o.b.b.InterfaceC0517b
    public void b(boolean z, c.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
            if (this.f10433a) {
                if (!z) {
                    j();
                }
                l(cVar);
            } else if (z) {
                l(cVar);
            } else {
                k(new DialogInterface$OnClickListenerC0518a(this, cVar));
            }
        }
    }

    @Override // c.a.p0.e.o.b.b.InterfaceC0517b
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
            c.a.p0.a.a2.d.i().post(new d(this));
        }
    }

    public final void i(Boolean bool, c.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bool, cVar) == null) {
            this.f10433a = false;
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
            c.a.p0.a.a2.d.i().post(new c(this));
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

    public final void l(c.a.p0.a.h0.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f10433a = true;
            boolean z = f10432b;
            c.a.p0.a.n0.k.c cVar2 = c.a.p0.a.n0.k.c.f7530d;
            c.a.p0.a.n0.k.d dVar = new c.a.p0.a.n0.k.d();
            dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(this, cVar));
            cVar2.C(dVar);
        }
    }
}
