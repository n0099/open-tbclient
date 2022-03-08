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
    public e f2647b;

    /* renamed from: c  reason: collision with root package name */
    public c f2648c;

    /* renamed from: d  reason: collision with root package name */
    public d f2649d;

    /* renamed from: c.a.d.f.j.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0107a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void doRecord(NetworkStatRecord networkStatRecord, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord, i2) == null) {
                a(networkStatRecord);
            }
        }

        public /* synthetic */ c(C0107a c0107a) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(NetworkStatRecord networkStatRecord, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, networkStatRecord, i2) == null) && networkStatRecord != null && i2 == DoRecordManager.FAILED_MSG) {
                JSONObject uBCJson = networkStatRecord.toUBCJson();
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(HttpConfig.UBC_HTTP_EXCEPTION_ID, uBCJson.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord, i2) == null) {
                a(networkStatRecord, i2);
            }
        }

        public /* synthetic */ d(C0107a c0107a) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, networkStatRecord) == null) && networkStatRecord != null && b(networkStatRecord)) {
                JSONObject uBCJson = networkStatRecord.toUBCJson();
                int i2 = AppConfig.isDebug() ? 64 : 0;
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(HttpConfig.UBC_HTTP_ID, uBCJson.toString(), i2);
                }
            }
        }

        public final boolean b(NetworkStatRecord networkStatRecord) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord)) == null) ? networkStatRecord.from == 3 && new Random().nextInt(100) < 20 : invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, networkStatRecord, i2) == null) {
                a(networkStatRecord);
            }
        }

        public /* synthetic */ e(C0107a c0107a) {
            this();
        }
    }

    public /* synthetic */ a(C0107a c0107a) {
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
                if (this.a) {
                    return;
                }
                this.a = true;
                DoRecordManager.getInstance().attach(this.f2647b);
                DoRecordManager.getInstance().attach(this.f2648c);
                DoRecordManager.getInstance().attach(this.f2649d);
            }
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
        this.a = false;
        this.f2647b = new e(null);
        this.f2648c = new c(null);
        this.f2649d = new d(null);
    }
}
