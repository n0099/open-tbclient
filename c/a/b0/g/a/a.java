package c.a.b0.g.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.b0.g.f.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<h>> a;

    /* renamed from: b  reason: collision with root package name */
    public final ReentrantReadWriteLock f1481b;

    /* renamed from: c  reason: collision with root package name */
    public final IAdDownloader f1482c;

    /* renamed from: c.a.b0.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0029a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(673960046, "Lc/a/b0/g/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(673960046, "Lc/a/b0/g/a/a$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadAction.values().length];
            a = iArr;
            try {
                iArr[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadAction.INSTALL_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdDownloadAction.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(673960077, "Lc/a/b0/g/a/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(673960077, "Lc/a/b0/g/a/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C0029a c0029a) {
        this();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public static void c(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.b0.g.d.a aVar) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, adDownloadAction, aVar) == null) || TextUtils.isEmpty(aVar.n.a)) {
            return;
        }
        switch (C0029a.a[adDownloadAction.ordinal()]) {
            case 1:
                logType = ClogBuilder.LogType.DOWNLOAD_START;
                break;
            case 2:
                logType = ClogBuilder.LogType.DOWNLOAD_PAUSE;
                break;
            case 3:
                logType = ClogBuilder.LogType.DOWNLOAD_CONTINUE;
                break;
            case 4:
                logType = ClogBuilder.LogType.DOWNLOAD_COMPLETE;
                break;
            case 5:
                logType = ClogBuilder.LogType.DOWNLOAD_INSTALL;
                break;
            case 6:
                logType = ClogBuilder.LogType.INSTALL_COMPLETE;
                break;
            case 7:
                logType = ClogBuilder.LogType.OPEN_APP;
                break;
            case 8:
                logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                break;
            default:
                return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.r(logType).m(aVar.n.a).g(aVar.o.f1511i).h(aVar.f1496d).i(aVar.o.a).j(aVar.o.f1504b).k(aVar.f1499g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(aVar.o.f1505c)) {
            c.a.b0.u.b.d(jSONObject, "ad_download_content_type", aVar.o.f1505c);
        }
        long j2 = aVar.o.f1506d;
        if (j2 > 0) {
            c.a.b0.u.b.c(jSONObject, "ad_download_content_length", j2);
        }
        if (jSONObject.length() > 0) {
            clogBuilder.l(jSONObject.toString());
        }
        c.a.b0.x.a.b(clogBuilder);
    }

    public void a(@NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar.e()) {
            return;
        }
        this.f1482c.d(aVar.f1494b);
        aVar.f1495c = AdDownloadStatus.NONE;
        d(AdDownloadAction.FAIL, aVar);
    }

    public void d(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, aVar) == null) {
            c(adDownloadAction, aVar);
            this.f1481b.readLock().lock();
            try {
                List list = (List) c.a.b0.u.c.b(this.a, aVar.d());
                if (list == null) {
                    return;
                }
                for (int i2 = 0; i2 != c.a.b0.u.a.k(list); i2++) {
                    h hVar = (h) c.a.b0.u.a.d(list, i2);
                    if (hVar != null && hVar.getData() != null) {
                        hVar.getData().h(aVar);
                        hVar.b(adDownloadAction, hVar.getData());
                    }
                }
            } finally {
                this.f1481b.readLock().unlock();
            }
        }
    }

    public void e(@NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f1482c.b(aVar.f1494b);
        }
    }

    public void f(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, hVar) == null) || TextUtils.isEmpty(str) || hVar == null) {
            return;
        }
        this.f1481b.writeLock().lock();
        try {
            List list = (List) c.a.b0.u.c.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                c.a.b0.u.c.e(this.a, str, list);
            }
            c.a.b0.u.a.b(list, hVar);
        } finally {
            this.f1481b.writeLock().unlock();
        }
    }

    public void g(@NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            d(AdDownloadAction.PROGRESS_UPDATE, aVar);
            this.f1482c.c(aVar.f1494b, aVar.f1499g, new c.a.b0.g.a.b(aVar));
        }
    }

    public void h(@NonNull c.a.b0.g.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            d(AdDownloadAction.PROGRESS_UPDATE, aVar);
            aVar.f1494b = this.f1482c.a(aVar.f1499g, new c.a.b0.g.a.b(aVar));
            aVar.f1495c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void i(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, hVar) == null) || TextUtils.isEmpty(str) || hVar == null) {
            return;
        }
        this.f1481b.writeLock().lock();
        try {
            List list = (List) c.a.b0.u.c.b(this.a, str);
            if (list == null) {
                return;
            }
            c.a.b0.u.a.j(list, hVar);
        } finally {
            this.f1481b.writeLock().unlock();
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>(32);
        this.f1481b = new ReentrantReadWriteLock();
        this.f1482c = c.a.b0.g.g.a.b();
    }
}
