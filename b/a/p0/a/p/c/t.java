package b.a.p0.a.p.c;

import android.content.Context;
import android.util.Log;
import b.a.p0.a.v2.q0;
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
public class t implements b.a.p0.a.p.d.l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f7166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f7167f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7168g;

        /* renamed from: b.a.p0.a.p.c.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0334a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7169e;

            /* renamed from: b.a.p0.a.p.c.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0335a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0334a f7170e;

                public RunnableC0335a(RunnableC0334a runnableC0334a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0334a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7170e = runnableC0334a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f7170e.f7169e;
                        b.a.p0.a.v2.i0.a(aVar.f7168g, aVar.f7167f);
                    }
                }
            }

            public RunnableC0334a(a aVar) {
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
                this.f7169e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        PrintWriter printWriter = new PrintWriter(this.f7169e.f7167f);
                        printWriter.println(b.a.p0.a.v2.k.g(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                        printWriter.println(this.f7169e.f7166e.toString());
                        printWriter.flush();
                        printWriter.close();
                        q0.X(new RunnableC0335a(this));
                    } catch (FileNotFoundException e2) {
                        b.a.p0.a.e0.d.a("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                        b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f7169e.f7168g.getString(b.a.p0.a.h.swan_app_system_error)).F();
                    }
                }
            }
        }

        public a(t tVar, StringBuilder sb, File file, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, sb, file, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7166e = sb;
            this.f7167f = file;
            this.f7168g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7166e.append(str);
                b.a.p0.a.v2.q.j(new RunnableC0334a(this), "");
            }
        }
    }

    public t() {
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

    @Override // b.a.p0.a.p.d.l0
    public void a(Context context) {
        File E2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null || (E2 = b.a.p0.a.h0.g.i.E2()) == null) {
            return;
        }
        if (E2.exists() || E2.mkdirs()) {
            File file = new File(E2, "runninginfo_" + b.a.p0.a.v2.k.g(System.currentTimeMillis(), "yyyyMMdd") + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            StringBuilder sb = new StringBuilder();
            sb.append(b.a.p0.a.v2.p.h(context));
            sb.append("===== 启动信息 =====");
            sb.append(StringUtils.LF);
            b.a.p0.a.v2.p.g(context, new a(this, sb, file, context));
        }
    }
}
