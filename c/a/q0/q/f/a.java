package c.a.q0.q.f;

import android.os.Build;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.k.a.o.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f23628a;

    /* renamed from: c.a.q0.q.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1095a extends BdRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f23629g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f23630h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f23631i;

        /* renamed from: c.a.q0.q.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1096a extends BdRunnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONObject f23632g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ C1095a f23633h;

            public C1096a(C1095a c1095a, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1095a, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23633h = c1095a;
                this.f23632g = jSONObject;
            }

            @Override // com.baidu.browser.core.async.BdRunnable
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f23633h.f23631i.f23628a.a(this.f23632g);
                }
            }
        }

        public C1095a(a aVar, Map map, String str) {
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
            this.f23631i = aVar;
            this.f23629g = map;
            this.f23630h = str;
        }

        @Override // com.baidu.browser.core.async.BdRunnable
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaType parse = MediaType.parse("application/json; charset=utf-8");
                JSONObject jSONObject = new JSONObject();
                try {
                    this.f23631i.d(this.f23629g);
                    this.f23631i.f(this.f23629g, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody create = RequestBody.create(parse, String.valueOf(jSONObject));
                Response response = null;
                try {
                    response = okHttpClient.newCall(new Request.Builder().url(this.f23630h).post(create).build()).execute();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    d.f().h(new C1096a(this, new JSONObject(response.body().string())));
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

    public a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23628a = bVar;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j.H()) {
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
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", WebSettings.getDefaultUserAgent(TbadkCoreApplication.getInst()));
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(j.I()));
            map.put("imei", TbadkCoreApplication.getInst().getImei());
            map.put(IAdRequestParam.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
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
            if (c.a.q0.o1.o.k.a.f(map)) {
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
            d.f().g(new C1095a(this, map, str));
        }
    }
}
