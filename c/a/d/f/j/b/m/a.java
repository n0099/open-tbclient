package c.a.d.f.j.b.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RecordObserver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final e f2185b;

    /* renamed from: c  reason: collision with root package name */
    public final c f2186c;

    /* renamed from: d  reason: collision with root package name */
    public final d f2187d;

    /* renamed from: c.a.d.f.j.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0096a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-614009878, "Lc/a/d/f/j/b/m/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-614009878, "Lc/a/d/f/j/b/m/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements RecordObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, networkStatRecord) == null) || networkStatRecord == null) {
                return;
            }
            networkStatRecord.from = c.a.d.f.j.b.m.b.a(networkStatRecord.url);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", networkStatRecord.toUBCJson());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent("1625", jSONObject);
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord, i) == null) {
                a(networkStatRecord);
            }
        }

        public /* synthetic */ c(C0096a c0096a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class d implements RecordObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, networkStatRecord, i) == null) && networkStatRecord != null && i == DoRecordManager.FAILED_MSG) {
                networkStatRecord.from = c.a.d.f.j.b.m.b.a(networkStatRecord.url);
                JSONObject uBCJson = networkStatRecord.toUBCJson();
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(HttpConfig.UBC_HTTP_EXCEPTION_ID, uBCJson.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord, i) == null) {
                a(networkStatRecord, i);
            }
        }

        public /* synthetic */ d(C0096a c0096a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class e implements RecordObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, networkStatRecord) == null) && networkStatRecord != null && b(networkStatRecord)) {
                networkStatRecord.from = c.a.d.f.j.b.m.b.a(networkStatRecord.url);
                JSONObject uBCJson = networkStatRecord.toUBCJson();
                int i = AppConfig.isDebug() ? 64 : 0;
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(HttpConfig.UBC_HTTP_ID, uBCJson.toString(), i);
                }
            }
        }

        public final boolean b(NetworkStatRecord networkStatRecord) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord)) == null) ? networkStatRecord.from == 3 && new Random().nextInt(100) < 20 : invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, networkStatRecord, i) == null) {
                a(networkStatRecord);
            }
        }

        public /* synthetic */ e(C0096a c0096a) {
            this();
        }
    }

    public /* synthetic */ a(C0096a c0096a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.a) {
                    this.a = true;
                    DoRecordManager.getInstance().attach(this.f2185b);
                    DoRecordManager.getInstance().attach(this.f2186c);
                    DoRecordManager.getInstance().attach(this.f2187d);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f2185b = new e(null);
        this.f2186c = new c(null);
        this.f2187d = new d(null);
    }
}
