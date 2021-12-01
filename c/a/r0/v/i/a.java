package c.a.r0.v.i;

import android.os.Build;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.j.a.o.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: c.a.r0.v.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1406a extends BdRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f24639g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f24640h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f24641i;

        /* renamed from: c.a.r0.v.i.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1407a extends BdRunnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ JSONObject f24642g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ C1406a f24643h;

            public C1407a(C1406a c1406a, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1406a, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24643h = c1406a;
                this.f24642g = jSONObject;
            }

            @Override // com.baidu.browser.core.async.BdRunnable
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f24643h.f24641i.a.a(this.f24642g);
                }
            }
        }

        public C1406a(a aVar, Map map, String str) {
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
            this.f24641i = aVar;
            this.f24639g = map;
            this.f24640h = str;
        }

        @Override // com.baidu.browser.core.async.BdRunnable
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaType parse = MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE);
                JSONObject jSONObject = new JSONObject();
                try {
                    this.f24641i.d(this.f24639g);
                    this.f24641i.f(this.f24639g, jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody create = RequestBody.create(parse, String.valueOf(jSONObject));
                Response response = null;
                try {
                    response = okHttpClient.newCall(new Request.Builder().url(this.f24640h).post(create).build()).execute();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    d.f().h(new C1407a(this, new JSONObject(response.body().string())));
                } catch (IOException e4) {
                    e4.printStackTrace();
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.a = bVar;
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
            map.put("android_id", TbadkCoreApplication.getInst().getAndroidId());
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
            if (c.a.r0.w1.o.k.a.f(map)) {
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
            d.f().g(new C1406a(this, map, str));
        }
    }
}
