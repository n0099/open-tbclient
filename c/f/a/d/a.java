package c.f.a.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.g.d.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity;
import com.dxmpay.apollon.heartbeat.HeartBeatManager;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.FileCopyUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f32287e = "a";

    /* renamed from: f  reason: collision with root package name */
    public static a f32288f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f32289a;

    /* renamed from: b  reason: collision with root package name */
    public HeartBeatCfgEntity f32290b;

    /* renamed from: c  reason: collision with root package name */
    public Context f32291c;

    /* renamed from: d  reason: collision with root package name */
    public String f32292d;

    /* renamed from: c.f.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1466a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f32293e;

        public RunnableC1466a(a aVar) {
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
            this.f32293e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f32293e;
                HeartBeatCfgEntity m = aVar.m(aVar.f32291c);
                if (m != null) {
                    long c2 = c.c(this.f32293e.f32291c, com.baidu.apollon.heartbeat.c.f37986b, 300L);
                    if (!m.isValidRequestTime(c2)) {
                        this.f32293e.e(m);
                        return;
                    }
                    String str = a.f32287e;
                    LogUtil.i(str, a.f32287e + " onChange lastRequestTime:" + c2 + " execute tryLoadCfg.");
                    this.f32293e.n();
                    return;
                }
                this.f32293e.n();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RestHttpRequestInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
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
                }
            }
        }

        @Override // com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor
        public void a(Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
                dVar.a().e("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1490843212, "Lc/f/a/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1490843212, "Lc/f/a/d/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32289a = "https://www.baifubao.com";
        this.f32290b = null;
        this.f32291c = null;
    }

    public static synchronized a i() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (a.class) {
                if (f32288f == null) {
                    f32288f = new a();
                }
                aVar = f32288f;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public HeartBeatCfgEntity b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (this.f32290b == null) {
                this.f32290b = m(context);
            }
            return this.f32290b;
        }
        return (HeartBeatCfgEntity) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32289a : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(HeartBeatCfgEntity heartBeatCfgEntity) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, heartBeatCfgEntity) != null) {
            return;
        }
        if (heartBeatCfgEntity != null) {
            HeartBeatCfgEntity heartBeatCfgEntity2 = this.f32290b;
            if ((heartBeatCfgEntity2 == null || (heartBeatCfgEntity2 != null && !TextUtils.equals(heartBeatCfgEntity2.toString(), heartBeatCfgEntity.toString()))) && heartBeatCfgEntity.checkResponseValidity()) {
                this.f32290b = heartBeatCfgEntity;
                heartBeatCfgEntity.storeResponse(this.f32291c);
                z = true;
                String str = f32287e;
                LogUtil.i(str, f32287e + " refreshHeartBeatCfg mResponse.");
                if (z) {
                    return;
                }
                HeartBeatManager.getInstance().applyBeating();
                return;
            }
        } else {
            String str2 = f32287e;
            LogUtil.w(str2, f32287e + " refreshHeartBeatCfg resp is null || mResponse = resp.");
        }
        z = false;
        if (z) {
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f32289a = str;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.f32291c = context;
        new Thread(new RunnableC1466a(this)).start();
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f32292d = str;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00bd */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final HeartBeatCfgEntity m(Context context) {
        InterceptResult invokeL;
        FileReader fileReader;
        HeartBeatCfgEntity heartBeatCfgEntity;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, context)) != null) {
            return (HeartBeatCfgEntity) invokeL.objValue;
        }
        ?? sb = new StringBuilder();
        sb.append(context.getCacheDir());
        sb.append(File.separator);
        sb.append("dxmheartbeatcfg.cfg");
        File file = new File(sb.toString());
        FileReader fileReader2 = null;
        HeartBeatCfgEntity heartBeatCfgEntity2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                if (file.exists() && file.isFile()) {
                    fileReader = new FileReader(file);
                    try {
                        String copyToString = FileCopyUtils.copyToString(fileReader);
                        if (!TextUtils.isEmpty(copyToString)) {
                            heartBeatCfgEntity2 = HeartBeatCfgEntity.build(copyToString);
                        } else {
                            LogUtil.w(f32287e, f32287e + " cache:" + file.getPath() + " content json is empty.");
                        }
                        heartBeatCfgEntity = heartBeatCfgEntity2;
                        fileReader2 = fileReader;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (fileReader != null) {
                            fileReader.close();
                            return null;
                        }
                        return null;
                    }
                } else {
                    LogUtil.w(f32287e, f32287e + " cache:" + file.getPath() + " isn't exist.");
                    heartBeatCfgEntity = null;
                }
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return heartBeatCfgEntity;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileReader = null;
        } catch (IOException e7) {
            e = e7;
            fileReader = null;
        } catch (Throwable th2) {
            sb = 0;
            th = th2;
            if (sb != 0) {
                try {
                    sb.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (NetworkUtils.isNetworkAvailable(this.f32291c)) {
                try {
                    String o = o();
                    if (!TextUtils.isEmpty(o)) {
                        String str = f32287e;
                        LogUtil.i(str, f32287e + " execute success,response:" + o);
                        try {
                            String optString = new JSONObject(o).optString("content");
                            if (!TextUtils.isEmpty(optString)) {
                                e(HeartBeatCfgEntity.build(optString));
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        String str2 = f32287e;
                        LogUtil.w(str2, f32287e + " the response is null.");
                    }
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            String str3 = f32287e;
            LogUtil.d(str3, f32287e + " loadCfg current network is't available.");
        }
    }

    public final String o() throws RestRuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Context context = this.f32291c;
            RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "dxm stastics bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("ua", this.f32292d));
            arrayList.add(new RestNameValuePair("nettype", new c.f.a.g.d.b(this.f32291c).a()));
            arrayList.add(new RestNameValuePair("cate[heartbeat]", ""));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new b(this));
            restTemplate.setMessageConverter(new c.f.a.g.b.b());
            restTemplate.setRequestInterceptor(arrayList2);
            return (String) restTemplate.d(this.f32289a + com.baidu.apollon.heartbeat.a.f37962f, arrayList, "utf-8", String.class);
        }
        return (String) invokeV.objValue;
    }
}
