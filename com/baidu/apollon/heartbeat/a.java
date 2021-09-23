package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37953a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37954b = "heartbeatcfg.cfg";

    /* renamed from: c  reason: collision with root package name */
    public static final String f37955c = "stastics bean http request";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37956d = "publish_data";

    /* renamed from: e  reason: collision with root package name */
    public static final String f37957e = "sign";

    /* renamed from: f  reason: collision with root package name */
    public static final String f37958f = "/odp/wireless/sdk/heartbeat";

    /* renamed from: h  reason: collision with root package name */
    public static final String f37959h = "utf-8";

    /* renamed from: i  reason: collision with root package name */
    public static a f37960i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f37961g;

    /* renamed from: j  reason: collision with root package name */
    public HeartBeatCfgEntity f37962j;
    public Context k;
    public String l;
    public String m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-793707381, "Lcom/baidu/apollon/heartbeat/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-793707381, "Lcom/baidu/apollon/heartbeat/a;");
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
        this.f37961g = "https://www.baifubao.com";
        this.f37962j = null;
        this.k = null;
    }

    public static synchronized a c() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (a.class) {
                if (f37960i == null) {
                    f37960i = new a();
                }
                aVar = f37960i;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (NetworkUtils.isNetworkAvailable(this.k)) {
                try {
                    String e2 = e();
                    if (!TextUtils.isEmpty(e2)) {
                        String str = f37953a;
                        LogUtil.i(str, f37953a + " execute success,response:" + e2);
                        try {
                            String optString = new JSONObject(e2).optString("content");
                            if (!TextUtils.isEmpty(optString)) {
                                a(HeartBeatCfgEntity.build(optString));
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    } else {
                        String str2 = f37953a;
                        LogUtil.w(str2, f37953a + " the response is null.");
                    }
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            String str3 = f37953a;
            LogUtil.d(str3, f37953a + " loadCfg current network is't available.");
        }
    }

    private String e() throws RestRuntimeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Context context = this.k;
            RestTemplate restTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "stastics bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("ua", this.l));
            arrayList.add(new RestNameValuePair("nettype", new com.baidu.apollon.restnet.rest.b(this.k).e()));
            arrayList.add(new RestNameValuePair("cate[heartbeat]", ""));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new RestHttpRequestInterceptor(this) { // from class: com.baidu.apollon.heartbeat.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f37964a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37964a = this;
                }

                @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
                public void intercept(Context context2, d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, dVar) == null) {
                        dVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    }
                }
            });
            restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.b());
            restTemplate.setRequestInterceptor(arrayList2);
            return (String) restTemplate.a(this.f37961g + f37958f, arrayList, "utf-8", String.class);
        }
        return (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f37961g = str;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00bd */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public HeartBeatCfgEntity c(Context context) {
        InterceptResult invokeL;
        FileReader fileReader;
        HeartBeatCfgEntity heartBeatCfgEntity;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65543, this, context)) != null) {
            return (HeartBeatCfgEntity) invokeL.objValue;
        }
        ?? sb = new StringBuilder();
        sb.append(context.getCacheDir());
        sb.append(File.separator);
        sb.append(f37954b);
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
                            LogUtil.w(f37953a, f37953a + " cache:" + file.getPath() + " content json is empty.");
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
                    LogUtil.w(f37953a, f37953a + " cache:" + file.getPath() + " isn't exist.");
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37961g : (String) invokeV.objValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.k = context;
        new Thread(new Runnable(this) { // from class: com.baidu.apollon.heartbeat.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37963a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f37963a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    a aVar = this.f37963a;
                    HeartBeatCfgEntity c2 = aVar.c(aVar.k);
                    if (c2 != null) {
                        long b2 = c.b(this.f37963a.k, c.f37982b, 300L);
                        if (!c2.isValidRequestTime(b2)) {
                            this.f37963a.a(c2);
                            return;
                        }
                        String str = a.f37953a;
                        LogUtil.i(str, a.f37953a + " onChange lastRequestTime:" + b2 + " execute tryLoadCfg.");
                        this.f37963a.d();
                        return;
                    }
                    this.f37963a.d();
                }
            }
        }).start();
    }

    public HeartBeatCfgEntity a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (this.f37962j == null) {
                this.f37962j = c(context);
            }
            return this.f37962j;
        }
        return (HeartBeatCfgEntity) invokeL.objValue;
    }

    public void a(Context context, HeartBeatCfgEntity heartBeatCfgEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, heartBeatCfgEntity) == null) || context == null || heartBeatCfgEntity == null) {
            return;
        }
        this.k = context;
        a(heartBeatCfgEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HeartBeatCfgEntity heartBeatCfgEntity) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, heartBeatCfgEntity) != null) {
            return;
        }
        if (heartBeatCfgEntity != null) {
            HeartBeatCfgEntity heartBeatCfgEntity2 = this.f37962j;
            if ((heartBeatCfgEntity2 == null || (heartBeatCfgEntity2 != null && !TextUtils.equals(heartBeatCfgEntity2.toString(), heartBeatCfgEntity.toString()))) && heartBeatCfgEntity.checkResponseValidity()) {
                this.f37962j = heartBeatCfgEntity;
                heartBeatCfgEntity.storeResponse(this.k);
                z = true;
                String str = f37953a;
                LogUtil.i(str, f37953a + " refreshHeartBeatCfg mResponse.");
                if (z) {
                    return;
                }
                HeartBeatManager.getInstance().applyBeating();
                return;
            }
        } else {
            String str2 = f37953a;
            LogUtil.w(str2, f37953a + " refreshHeartBeatCfg resp is null || mResponse = resp.");
        }
        z = false;
        if (z) {
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }
}
