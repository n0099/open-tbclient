package c.a.o0.a.p.c;

import android.content.Context;
import android.util.Log;
import c.a.o0.a.v2.q0;
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
public class t implements c.a.o0.a.p.d.l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f7836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f7837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7838g;

        /* renamed from: c.a.o0.a.p.c.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0337a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f7839e;

            /* renamed from: c.a.o0.a.p.c.t$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0338a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ RunnableC0337a f7840e;

                public RunnableC0338a(RunnableC0337a runnableC0337a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0337a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f7840e = runnableC0337a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.f7840e.f7839e;
                        c.a.o0.a.v2.i0.a(aVar.f7838g, aVar.f7837f);
                    }
                }
            }

            public RunnableC0337a(a aVar) {
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
                this.f7839e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        PrintWriter printWriter = new PrintWriter(this.f7839e.f7837f);
                        printWriter.println(c.a.o0.a.v2.k.g(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
                        printWriter.println(this.f7839e.f7836e.toString());
                        printWriter.flush();
                        printWriter.close();
                        q0.X(new RunnableC0338a(this));
                    } catch (FileNotFoundException e2) {
                        c.a.o0.a.e0.d.a("DefaultSwanAppLogManager", Log.getStackTraceString(e2));
                        c.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), this.f7839e.f7838g.getString(c.a.o0.a.h.swan_app_system_error)).F();
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
            this.f7836e = sb;
            this.f7837f = file;
            this.f7838g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7836e.append(str);
                c.a.o0.a.v2.q.j(new RunnableC0337a(this), "");
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

    @Override // c.a.o0.a.p.d.l0
    public void a(Context context) {
        File I2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null || (I2 = c.a.o0.a.h0.g.i.I2()) == null) {
            return;
        }
        if (I2.exists() || I2.mkdirs()) {
            File file = new File(I2, "runninginfo_" + c.a.o0.a.v2.k.g(System.currentTimeMillis(), "yyyyMMdd") + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.o0.a.v2.p.h(context));
            sb.append("===== 启动信息 =====");
            sb.append(StringUtils.LF);
            c.a.o0.a.v2.p.g(context, new a(this, sb, file, context));
        }
    }
}
