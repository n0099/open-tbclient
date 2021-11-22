package b.a.p0.a.p.c;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class x implements b.a.p0.a.p.d.o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7559e;

        /* renamed from: b.a.p0.a.p.c.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0344a implements b.a.p0.a.z2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ File f7560e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f7561f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f7562g;

            /* renamed from: b.a.p0.a.p.c.x$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0345a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ File f7563e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0344a f7564f;

                public RunnableC0345a(C0344a c0344a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0344a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7564f = c0344a;
                    this.f7563e = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b.a.p0.a.z2.i0.a(this.f7564f.f7562g.f7559e, this.f7563e);
                    }
                }
            }

            public C0344a(a aVar, File file, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, file, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7562g = aVar;
                this.f7560e = file;
                this.f7561f = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    try {
                        File file = new File(this.f7560e, "report");
                        b.a.p0.w.d.l(file);
                        x.e(file, this.f7561f, str);
                        x.d(file);
                        File file2 = new File(this.f7560e, "report.zip");
                        b.a.p0.w.d.j(file2);
                        b.a.p0.w.d.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        b.a.p0.w.d.L(file);
                        b.a.p0.a.z2.q0.a0(new RunnableC0345a(this, file2));
                    } catch (Exception e2) {
                        b.a.p0.a.e0.d.b("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                        b.a.p0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f7562g.f7559e.getString(b.a.p0.a.h.swan_app_system_error)).G();
                    }
                }
            }
        }

        public a(x xVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7559e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File U2 = b.a.p0.a.h0.g.i.U2();
                if (U2 == null) {
                    b.a.p0.a.e0.d.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!U2.exists() && !U2.mkdirs()) {
                    b.a.p0.a.e0.d.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + U2.getAbsolutePath());
                } else {
                    b.a.p0.a.z2.p.i(this.f7559e, new C0344a(this, U2, b.a.p0.a.z2.p.l(this.f7559e) + "===== 启动信息 =====\n"));
                }
            }
        }
    }

    public x() {
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

    public static void d(File file) {
        File[] C;
        File[] C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            File file2 = new File(file, "swan");
            b.a.p0.w.d.e(b.a.p0.a.c1.a.p0().a(), file2);
            for (File file3 : b.a.p0.w.d.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : b.a.p0.w.d.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            b.a.p0.w.d.L(file4);
                        }
                    }
                }
            }
        }
    }

    public static void e(File file, String str, String str2) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str, str2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String g2 = b.a.p0.a.z2.k.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g2 + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            String g3 = b.a.p0.a.z2.k.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g3 + StringUtils.LF + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }

    @Override // b.a.p0.a.p.d.o0
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        b.a.p0.a.z2.q.k(new a(this, context), "log上报");
    }
}
