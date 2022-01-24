package c.a.r0.a.p.c;

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
public class x implements c.a.r0.a.p.d.o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f8259e;

        /* renamed from: c.a.r0.a.p.c.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0502a implements c.a.r0.a.z2.g1.c<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ File f8260e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f8261f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f8262g;

            /* renamed from: c.a.r0.a.p.c.x$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0503a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ File f8263e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0502a f8264f;

                public RunnableC0503a(C0502a c0502a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0502a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f8264f = c0502a;
                    this.f8263e = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        c.a.r0.a.z2.i0.a(this.f8264f.f8262g.f8259e, this.f8263e);
                    }
                }
            }

            public C0502a(a aVar, File file, String str) {
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
                this.f8262g = aVar;
                this.f8260e = file;
                this.f8261f = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    try {
                        File file = new File(this.f8260e, "report");
                        c.a.r0.w.d.l(file);
                        x.e(file, this.f8261f, str);
                        x.d(file);
                        File file2 = new File(this.f8260e, "report.zip");
                        c.a.r0.w.d.j(file2);
                        c.a.r0.w.d.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        c.a.r0.w.d.L(file);
                        c.a.r0.a.z2.q0.a0(new RunnableC0503a(this, file2));
                    } catch (Exception e2) {
                        c.a.r0.a.e0.d.b("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                        c.a.r0.a.c2.b.f.e.g(AppRuntime.getAppContext(), this.f8262g.f8259e.getString(c.a.r0.a.h.swan_app_system_error)).G();
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
            this.f8259e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File R2 = c.a.r0.a.h0.g.i.R2();
                if (R2 == null) {
                    c.a.r0.a.e0.d.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!R2.exists() && !R2.mkdirs()) {
                    c.a.r0.a.e0.d.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + R2.getAbsolutePath());
                } else {
                    c.a.r0.a.z2.p.i(this.f8259e, new C0502a(this, R2, c.a.r0.a.z2.p.l(this.f8259e) + "===== 启动信息 =====\n"));
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
            c.a.r0.w.d.e(c.a.r0.a.c1.a.p0().a(), file2);
            for (File file3 : c.a.r0.w.d.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : c.a.r0.w.d.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            c.a.r0.w.d.L(file4);
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
            String g2 = c.a.r0.a.z2.k.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g2 + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            String g3 = c.a.r0.a.z2.k.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g3 + StringUtils.LF + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }

    @Override // c.a.r0.a.p.d.o0
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        c.a.r0.a.z2.q.k(new a(this, context), "log上报");
    }
}
