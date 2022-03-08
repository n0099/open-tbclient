package c.a.r0.v.i;

import android.os.Build;
import androidx.annotation.NonNull;
import c.a.d.f.p.l;
import c.a.k.a.i.d;
import c.a.q0.c1.v0;
import c.a.q0.r.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f24206b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f24207c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: c.a.r0.v.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1487a extends BdRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f24208g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f24209h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f24210i;

        /* renamed from: c.a.r0.v.i.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1488a extends BdRunnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONObject f24211g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ C1487a f24212h;

            public C1488a(C1487a c1487a, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1487a, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24212h = c1487a;
                this.f24211g = jSONObject;
            }

            @Override // com.baidu.browser.core.async.BdRunnable
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f24212h.f24210i.a.a(this.f24211g);
                }
            }
        }

        public C1487a(a aVar, Map map, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24210i = aVar;
            this.f24208g = map;
            this.f24209h = str;
        }

        @Override // com.baidu.browser.core.async.BdRunnable
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaType parse = MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE);
                JSONObject jSONObject = new JSONObject();
                try {
                    this.f24210i.d(this.f24208g);
                    this.f24210i.f(this.f24208g, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody create = RequestBody.create(parse, String.valueOf(jSONObject));
                Response response = null;
                try {
                    response = okHttpClient.newCall(new Request.Builder().url(this.f24209h).post(create).build()).execute();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    d.f().h(new C1488a(this, new JSONObject(response.body().string())));
                } catch (IOException e4) {
                    e4.printStackTrace();
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-77752860, "Lc/a/r0/v/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-77752860, "Lc/a/r0/v/i/a;");
                return;
            }
        }
        f24206b = e.e() ? "http://" : "https://";
        f24207c = f24206b + "afdconf.baidu.com/afd/download";
    }

    public a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (l.H()) {
                return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
            }
            return UtilHelper.getGprsIpAddress();
        }
        return (String) invokeV.objValue;
    }

    public final Map<String, String> d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", TbConfig.getVersion());
            map.put("uid", TbadkCoreApplication.getCurrentAccount());
            map.put("cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
            map.put("ua", v0.b());
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(l.I()));
            map.put("imei", TbadkCoreApplication.getInst().getImei());
            map.put(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
            map.put("ip", e());
            map.put("ssl", "1");
            return map;
        }
        return (Map) invokeL.objValue;
    }

    public final JSONObject f(Map<String, String> map, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, jSONObject)) == null) {
            if (c.a.r0.z1.o.k.a.f(map)) {
                return jSONObject;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void g(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, str) == null) {
            d.f().g(new C1487a(this, map, str));
        }
    }
}
