package c.p.a.d;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.f.c;
import c.p.a.d.b.c;
import c.p.a.d.b.d;
import c.p.a.d.b.l;
import c.p.a.d.e;
import c.p.a.d.h;
import c.p.a.e.a.d;
import c.p.a.e.b.a.a;
import c.p.a.e.b.f.q;
import c.p.a.e.b.f.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements d.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f34803a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
                l.p().a(5, l.a(), null, "无网络，请检查网络设置", null, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.e.b.j.a f34804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.d f34805f;

        public b(d dVar, c.p.a.e.b.j.a aVar, c.p.a.a.a.d.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34804e = aVar;
            this.f34805f = dVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.p().a(2, l.a(), this.f34805f, this.f34804e.h("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.p.a.b.a.c.b f34806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f34807f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f34808g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f34809h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f34810i;

        public c(d dVar, c.p.a.b.a.c.b bVar, long j2, long j3, double d2, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, Long.valueOf(j2), Long.valueOf(j3), Double.valueOf(d2), downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34806e = bVar;
            this.f34807f = j2;
            this.f34808g = j3;
            this.f34809h = d2;
            this.f34810i = downloadInfo;
        }

        @Override // c.p.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!h.r.C(this.f34806e)) {
                    long j2 = this.f34807f;
                    if (j2 <= -1 || this.f34808g <= -1 || j2 >= this.f34809h) {
                        return;
                    }
                    e.c.a().r("clean_space_install", c.p.a.d.b.f.d("install_no_enough_space"), this.f34806e);
                    if (c.p.a.d.b.f.p(this.f34810i, ((long) this.f34809h) - this.f34807f)) {
                        c.p.a.e.b.a.a.c().i(this);
                        this.f34806e.I0(true);
                        return;
                    }
                    return;
                }
                c.p.a.e.b.a.a.c().i(this);
            }
        }

        @Override // c.p.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // c.p.a.e.b.f.r
        public void a(DownloadInfo downloadInfo) throws BaseException {
            PackageInfo h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || (h2 = c.p.a.e.a.d.h(l.a(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName())) == null) {
                return;
            }
            downloadInfo.setAppVersionCode(h2.versionCode);
        }

        @Override // c.p.a.e.b.f.r
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? downloadInfo != null && h.k.h() && downloadInfo.getPackageInfo() == null : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements c.p.a.e.b.e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // c.p.a.e.b.e.c
        public void a(int i2, String str, JSONObject jSONObject) {
            DownloadInfo f2;
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) || (f2 = c.p.a.e.b.g.a.H(l.a()).f(i2)) == null || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            e.c.a().r(str, jSONObject, c2);
        }

        @Override // c.p.a.e.b.e.c
        public void b(int i2, String str, JSONObject jSONObject) {
            DownloadInfo f2;
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, jSONObject) == null) || (f2 = c.p.a.e.b.g.a.H(l.a()).f(i2)) == null || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            if ("install_view_result".equals(str)) {
                jSONObject = h.r.n(jSONObject);
                c.p.a.d.a.g(jSONObject, f2);
                h.r.q(jSONObject, "model_id", Long.valueOf(c2.b()));
            }
            e.c.a().w(str, jSONObject, c2);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f34812a;

        public i(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34812a = context.getApplicationContext();
        }

        @Override // c.p.a.e.a.d.f
        public void a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
                c.p.a.d.a.d().p(str);
            }
        }

        @Override // c.p.a.e.a.d.f
        public void b(int i2, int i3, String str, int i4, long j2) {
            Context context;
            DownloadInfo f2;
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Long.valueOf(j2)}) == null) || (context = this.f34812a) == null || (f2 = c.p.a.e.b.g.a.H(context).f(i2)) == null || f2.getStatus() == 0 || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            if (i3 == 1) {
                c.p.a.d.a.n(f2, c2);
                if ("application/vnd.android.package-archive".equals(f2.getMimeType())) {
                    c.p.a.d.b.b.a().c(f2, c2.b(), c2.l(), c2.e(), f2.getTitle(), c2.d(), f2.getTargetFilePath());
                }
            } else if (i3 == 3) {
                JSONObject jSONObject = new JSONObject();
                c.p.a.d.a.t(jSONObject, f2);
                e.c.a().p("download_notification", "download_notification_install", jSONObject, c2);
            } else if (i3 == 5) {
                e.c.a().n("download_notification", "download_notification_pause", c2);
            } else if (i3 == 6) {
                e.c.a().n("download_notification", "download_notification_continue", c2);
            } else if (i3 != 7) {
            } else {
                e.c.a().n("download_notification", "download_notification_click", c2);
            }
        }

        @Override // c.p.a.e.a.d.f
        public boolean a(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (l.A() != null) {
                    return l.A().a(z);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // c.p.a.e.a.d.f
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) || downloadInfo == null) {
                return;
            }
            c.p.a.d.g.b().g(downloadInfo);
            if (c.p.a.e.b.j.a.d(downloadInfo.getId()).b("report_download_cancel", 1) == 1) {
                e.c.a().i(downloadInfo, new BaseException(1012, ""));
            } else {
                e.c.a().u(downloadInfo, new BaseException(1012, ""));
            }
        }

        @Override // c.p.a.e.a.d.f
        public void a(int i2, int i3, String str, String str2, String str3) {
            Context context;
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3}) == null) || (context = this.f34812a) == null || (f2 = c.p.a.e.b.g.a.H(context).f(i2)) == null || f2.getStatus() != -3) {
                return;
            }
            f2.setPackageName(str2);
            c.p.a.d.b.c.a().b(this.f34812a, f2);
        }

        @Override // c.p.a.e.a.d.f
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.p.a.d.b.c.a().c() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static String f34813a = "d$j";
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements d.n {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public c.b f34814a;

            /* renamed from: b  reason: collision with root package name */
            public DialogInterface.OnClickListener f34815b;

            /* renamed from: c  reason: collision with root package name */
            public DialogInterface.OnClickListener f34816c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnCancelListener f34817d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f34818e;

            /* renamed from: c.p.a.d.d$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C1535a implements c.InterfaceC1518c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34819a;

                public C1535a(a aVar) {
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
                            return;
                        }
                    }
                    this.f34819a = aVar;
                }

                @Override // c.p.a.a.a.f.c.InterfaceC1518c
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f34819a.f34815b == null) {
                        return;
                    }
                    this.f34819a.f34815b.onClick(dialogInterface, -1);
                }

                @Override // c.p.a.a.a.f.c.InterfaceC1518c
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) || this.f34819a.f34816c == null) {
                        return;
                    }
                    this.f34819a.f34816c.onClick(dialogInterface, -2);
                }

                @Override // c.p.a.a.a.f.c.InterfaceC1518c
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) || this.f34819a.f34817d == null || dialogInterface == null) {
                        return;
                    }
                    this.f34819a.f34817d.onCancel(dialogInterface);
                }
            }

            public a(j jVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34818e = context;
                this.f34814a = new c.b(this.f34818e);
            }

            @Override // c.p.a.e.a.d.n
            public d.n a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f34814a.e(this.f34818e.getResources().getString(i2));
                    return this;
                }
                return (d.n) invokeI.objValue;
            }

            @Override // c.p.a.e.a.d.n
            public d.n b(int i2, DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, onClickListener)) == null) {
                    this.f34814a.j(this.f34818e.getResources().getString(i2));
                    this.f34815b = onClickListener;
                    return this;
                }
                return (d.n) invokeIL.objValue;
            }

            @Override // c.p.a.e.a.d.n
            public d.n c(DialogInterface.OnCancelListener onCancelListener) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onCancelListener)) == null) {
                    this.f34817d = onCancelListener;
                    return this;
                }
                return (d.n) invokeL.objValue;
            }

            @Override // c.p.a.e.a.d.n
            public d.n a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    this.f34814a.h(str);
                    return this;
                }
                return (d.n) invokeL.objValue;
            }

            @Override // c.p.a.e.a.d.n
            public d.n a(int i2, DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onClickListener)) == null) {
                    this.f34814a.l(this.f34818e.getResources().getString(i2));
                    this.f34816c = onClickListener;
                    return this;
                }
                return (d.n) invokeIL.objValue;
            }

            @Override // c.p.a.e.a.d.n
            public d.n a(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                    this.f34814a.f(z);
                    return this;
                }
                return (d.n) invokeZ.objValue;
            }

            @Override // c.p.a.e.a.d.n
            public d.m a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f34814a.d(new C1535a(this));
                    h.q.b(j.f34813a, "getThemedAlertDlgBuilder", null);
                    this.f34814a.b(3);
                    return new b(l.p().b(this.f34814a.g()));
                }
                return (d.m) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public static class b implements d.m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public Dialog f34820a;

            public b(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialog};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                if (dialog != null) {
                    this.f34820a = dialog;
                    a();
                }
            }

            @Override // c.p.a.e.a.d.m
            public void a() {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dialog = this.f34820a) == null) {
                    return;
                }
                dialog.show();
            }

            @Override // c.p.a.e.a.d.m
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    Dialog dialog = this.f34820a;
                    if (dialog != null) {
                        return dialog.isShowing();
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-146314303, "Lc/p/a/d/d$j;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-146314303, "Lc/p/a/d/d$j;");
            }
        }

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // c.p.a.e.a.d.c, c.p.a.e.a.d.e
        public d.n a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new a(this, context) : (d.n) invokeL.objValue;
        }

        @Override // c.p.a.e.a.d.c, c.p.a.e.a.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f34821e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34822f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f34823g;

            public a(k kVar, int i2, c.p.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34823g = kVar;
                this.f34821e = i2;
                this.f34822f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(this.f34821e);
                    JSONObject jSONObject = new JSONObject();
                    h.r.q(jSONObject, "ttdownloader_type", 1);
                    h.l.g(f2, jSONObject);
                    if (f2 != null && -2 == f2.getRealStatus() && !f2.isPauseReserveOnWifi()) {
                        this.f34823g.c(this.f34821e, this.f34822f, jSONObject);
                    } else {
                        h.r.q(jSONObject, "error_code", 1001);
                    }
                    e.c.a().w("download_notification_try_show", jSONObject, this.f34822f);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f34824e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34825f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f34826g;

            public b(k kVar, int i2, c.p.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34826g = kVar;
                this.f34824e = i2;
                this.f34825f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(this.f34824e);
                    JSONObject jSONObject = new JSONObject();
                    h.r.q(jSONObject, "ttdownloader_type", 2);
                    h.l.g(f2, jSONObject);
                    if (!h.r.C(this.f34825f)) {
                        this.f34826g.c(this.f34824e, this.f34825f, jSONObject);
                    } else {
                        h.r.q(jSONObject, "error_code", 1002);
                    }
                    e.c.a().w("download_notification_try_show", jSONObject, this.f34825f);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f34827e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.p.a.b.a.c.b f34828f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f34829g;

            public c(k kVar, int i2, c.p.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34829g = kVar;
                this.f34827e = i2;
                this.f34828f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(this.f34827e);
                    JSONObject jSONObject = new JSONObject();
                    h.r.q(jSONObject, "ttdownloader_type", 3);
                    h.l.g(f2, jSONObject);
                    if (!h.r.F(this.f34828f.e())) {
                        this.f34829g.c(this.f34827e, this.f34828f, jSONObject);
                    } else {
                        h.r.q(jSONObject, "error_code", 1003);
                    }
                    e.c.a().w("download_notification_try_show", jSONObject, this.f34828f);
                }
            }
        }

        /* renamed from: c.p.a.d.d$k$d  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1536d {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static k f34830a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1125886432, "Lc/p/a/d/d$k$d;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1125886432, "Lc/p/a/d/d$k$d;");
                        return;
                    }
                }
                f34830a = new k(null);
            }
        }

        public /* synthetic */ k(a aVar) {
            this();
        }

        public static k a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1536d.f34830a : (k) invokeV.objValue;
        }

        public void b(int i2) {
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && com.ss.android.socialbase.appdownloader.e.c.d().b(i2) == null && (f2 = c.p.a.e.b.g.a.H(l.a()).f(i2)) != null) {
                com.ss.android.socialbase.appdownloader.e.c.d().f(i2, f2.getIconUrl());
            }
        }

        public final void c(int i2, c.p.a.b.a.c.b bVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bVar, jSONObject) == null) {
                if (!c.p.a.e.a.f.c.d()) {
                    h.r.q(jSONObject, "error_code", 1004);
                    return;
                }
                DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(i2);
                if (f2 == null) {
                    h.r.q(jSONObject, "error_code", 1005);
                    return;
                }
                if (c.p.a.e.b.p.b.a().l(i2) != null) {
                    c.p.a.e.b.p.b.a().m(i2);
                }
                c.p.a.e.a.f.a aVar = new c.p.a.e.a.f.a(l.a(), i2, f2.getTitle(), f2.getSavePath(), f2.getName(), f2.getExtra());
                aVar.d(f2.getCurBytes());
                aVar.k(f2.getTotalBytes());
                aVar.c(f2.getStatus(), null, false, false);
                c.p.a.e.b.p.b.a().e(aVar);
                aVar.g(null, false);
                e.c.a().w("download_notification_show", jSONObject, bVar);
            }
        }

        public void d(c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                h(bVar, 5L);
            }
        }

        public void e(@NonNull c.p.a.b.a.c.b bVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, bVar, j2) == null) {
                int s = bVar.s();
                if (c.p.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                    return;
                }
                b(s);
                c.p.a.d.e.a().c(new c(this, s, bVar), j2 * 1000);
            }
        }

        public void g(c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
                return;
            }
            h(bVar, c.p.a.e.b.j.a.d(bVar.s()).b("noti_continue_delay_secs", 5));
        }

        public final void h(@NonNull c.p.a.b.a.c.b bVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, bVar, j2) == null) {
                int s = bVar.s();
                if (c.p.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                    return;
                }
                b(s);
                c.p.a.d.e.a().c(new a(this, s, bVar), j2 * 1000);
            }
        }

        public void i(@NonNull c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
                j(bVar, 5L);
            }
        }

        public final void j(@NonNull c.p.a.b.a.c.b bVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048583, this, bVar, j2) == null) {
                int s = bVar.s();
                if (c.p.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                    return;
                }
                b(s);
                c.p.a.d.e.a().c(new b(this, s, bVar), j2 * 1000);
            }
        }

        public void k(@NonNull c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                j(bVar, c.p.a.e.b.j.a.d(bVar.s()).b("noti_install_delay_secs", 5));
            }
        }

        public void l(@NonNull c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                e(bVar, 5L);
            }
        }

        public void m(@NonNull c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                e(bVar, c.p.a.e.b.j.a.d(bVar.s()).b("noti_open_delay_secs", 5));
            }
        }

        public k() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1242608953, "Lc/p/a/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1242608953, "Lc/p/a/d/d;");
        }
    }

    public d() {
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
        this.f34803a = new Handler(Looper.getMainLooper());
    }

    @Override // c.p.a.e.a.d.j
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        c.p.a.a.a.d.d a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            h.l.g(downloadInfo, jSONObject);
            c.p.a.d.a.g(jSONObject, downloadInfo);
            h.q.a("download_failed", jSONObject.toString());
        }
        c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
        if (c2 == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    c.p.a.d.a.n(downloadInfo, c2);
                    return;
                } else if (i2 == 2001) {
                    c.p.a.d.a.d().o(downloadInfo, c2, 2001);
                    return;
                } else if (i2 == 11) {
                    c.p.a.d.a.d().o(downloadInfo, c2, 2000);
                    if (c2.P()) {
                        return;
                    }
                    b(downloadInfo, c2);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (c.p.a.e.b.j.a.d(downloadInfo.getId()).b("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f34803a.post(new a(this));
                }
                if (c.p.a.e.b.l.f.V0(baseException)) {
                    if (l.y() != null) {
                        l.y().a(c2.b());
                    }
                    e.c.a().m("download_failed_for_space", c2);
                    if (!c2.N()) {
                        e.c.a().m("download_can_restart", c2);
                        a(downloadInfo);
                    }
                    if ((l.y() == null || !l.y().d()) && (a2 = c.g.e().a(c2.b())) != null && a2.k()) {
                        c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(downloadInfo.getId());
                        if (d2.b("show_no_enough_space_toast", 0) == 1) {
                            this.f34803a.post(new b(this, d2, a2));
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), h.r.l(baseException.getMessage(), l.v().optInt("exception_msg_length", 500)));
            }
            e.c.a().u(downloadInfo, baseException2);
            c.p.a.d.g.b().h(downloadInfo, baseException, "");
        } catch (Exception e2) {
            l.F().a(e2, "onAppDownloadMonitorSend");
        }
    }

    public final void b(DownloadInfo downloadInfo, c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, bVar) == null) {
            long f2 = h.r.f(Environment.getDataDirectory(), -1L);
            long min = Math.min(524288000L, h.r.e(Environment.getDataDirectory()) / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = (totalBytes * 2.5d) + min;
            if (f2 > -1 && totalBytes > -1) {
                double d3 = f2;
                if (d3 < d2 && d2 - d3 > c.p.a.d.b.f.q()) {
                    c.p.a.d.b.f.e(downloadInfo.getId());
                }
            }
            c.p.a.e.b.a.a.c().f(new c(this, bVar, f2, totalBytes, d2, downloadInfo));
        }
    }

    /* renamed from: c.p.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1534d implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c.p.a.d.d$d$a */
        /* loaded from: classes4.dex */
        public class a implements MediaScannerConnection.OnScanCompletedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f34811a;

            public a(C1534d c1534d, DownloadInfo downloadInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1534d, downloadInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34811a = downloadInfo;
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, uri) == null) || uri == null) {
                    return;
                }
                this.f34811a.safePutToDBJsonData("file_content_uri", uri.toString());
                c.p.a.e.b.g.e.M0().a(this.f34811a);
            }
        }

        public C1534d() {
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

        @Override // c.p.a.e.b.f.r
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) && downloadInfo != null && c(downloadInfo)) {
                a(l.a(), downloadInfo);
            }
        }

        @Override // c.p.a.e.b.f.r
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo != null) {
                    return h.k.j(c.p.a.e.b.j.a.d(downloadInfo.getId()));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final boolean c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, downloadInfo)) == null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                String d2 = c.p.a.e.a.h.a.d.d(l.a(), c.p.a.e.a.d.i(downloadInfo, file), str);
                boolean z = false;
                if (!TextUtils.isEmpty(d2)) {
                    String str2 = d2 + ".apk";
                    if (str2.equals(downloadInfo.getName())) {
                        return true;
                    }
                    try {
                        z = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                        if (z) {
                            downloadInfo.setName(str2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public final void a(Context context, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, downloadInfo) == null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
                if (query != null && query.moveToFirst()) {
                    downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri(LaunchStatsUtils.EXTERNAL_LAUNCH), query.getInt(query.getColumnIndex("_id"))).toString());
                } else {
                    MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new a(this, downloadInfo));
                }
                c.p.a.e.b.l.f.D(query);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // c.p.a.e.b.f.r
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                c.p.a.a.a.c.l w = l.w();
                if (downloadInfo == null || w == null) {
                    return;
                }
                String packageName = downloadInfo.getPackageName();
                String targetFilePath = downloadInfo.getTargetFilePath();
                File a2 = a(packageName, targetFilePath);
                c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                w.a(packageName, targetFilePath, a2, c2 != null ? h.r.n(c2.g()) : null);
                downloadInfo.setMimeType("application/vnd.android.package-archive");
                downloadInfo.setName(a2.getName());
                downloadInfo.setMd5(null);
            }
        }

        @Override // c.p.a.e.b.f.r
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo != null) {
                    return c.p.a.a.a.g.b.f(c.p.a.e.b.j.a.d(downloadInfo.getId()), downloadInfo.getMimeType());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final File a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                File file = new File(str2);
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    str = name.substring(0, lastIndexOf);
                }
                return new File(file.getParent(), str + ".apk");
            }
            return (File) invokeLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.i, q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
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
                DownloadInfo f2;
                int spIntVal;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.g.e().q();
                    for (c.p.a.b.a.c.b bVar : c.g.e().t().values()) {
                        int s = bVar.s();
                        if (s != 0) {
                            c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(s);
                            if (d2.m("notification_opt_2") == 1 && (f2 = c.p.a.e.b.g.a.H(l.a()).f(s)) != null) {
                                if (h.r.C(bVar) && !h.r.F(bVar.e())) {
                                    int spIntVal2 = f2.getSpIntVal("restart_notify_open_app_count");
                                    if (spIntVal2 < d2.b("noti_open_restart_times", 1)) {
                                        k.a().l(bVar);
                                        f2.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                    }
                                } else if (f2.getRealStatus() == -2) {
                                    int spIntVal3 = f2.getSpIntVal("restart_notify_continue_count");
                                    if (spIntVal3 < d2.b("noti_continue_restart_times", 1)) {
                                        k.a().d(bVar);
                                        f2.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                    }
                                } else if (f2.getRealStatus() == -3 && c.p.a.e.b.l.f.t0(f2) && !h.r.C(bVar) && (spIntVal = f2.getSpIntVal("restart_notify_install_count")) < d2.b("noti_install_restart_times", 1)) {
                                    k.a().i(bVar);
                                    f2.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                                }
                            }
                        }
                    }
                }
            }
        }

        public g() {
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

        @Override // c.p.a.e.b.f.q
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.p.a.e.a.d.i
        public void a(DownloadInfo downloadInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, z) == null) || downloadInfo == null) {
                return;
            }
            b(downloadInfo, downloadInfo.getRealStatus(), z);
        }

        @Override // c.p.a.e.a.d.i
        public void a(List<DownloadInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            }
        }

        @WorkerThread
        public void b(DownloadInfo downloadInfo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.g.e().q();
                c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                if (c2 == null) {
                    return;
                }
                try {
                    if (z) {
                        c2.p0(downloadInfo.getFailedResumeCount());
                    } else if (c2.A() == -1) {
                        return;
                    } else {
                        c2.p0(-1);
                    }
                    c.j.b().c(c2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("url", downloadInfo.getUrl());
                    jSONObject.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject.put("download_status", i2);
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    int i3 = 1;
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    if (!z) {
                        i3 = 2;
                    }
                    jSONObject.put("launch_resumed", i3);
                    jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                    e.c.a().p("embeded_ad", "download_uncompleted", jSONObject, c2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // c.p.a.e.b.f.q
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                c.p.a.d.e.a().c(new a(this), 5000L);
            }
        }
    }

    public final void a(@NonNull DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) && h.k.r(downloadInfo.getId())) {
            c.p.a.d.e.a().f(new d.c(downloadInfo));
        }
    }
}
