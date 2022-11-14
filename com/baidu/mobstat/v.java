package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1366709586, "Lcom/baidu/mobstat/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1366709586, "Lcom/baidu/mobstat/v;");
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public com.baidu.mobstat.a b;

        public a(Context context, com.baidu.mobstat.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
        }

        private synchronized void a() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                synchronized (this) {
                    ba.c().a("start get config");
                    Context context = this.a;
                    com.baidu.mobstat.a aVar = this.b;
                    String b = b(context);
                    ba c = ba.c();
                    c.c("update req url is:" + b);
                    HttpURLConnection d = bn.d(context, b);
                    d.connect();
                    String headerField = d.getHeaderField("X-CONFIG");
                    ba c2 = ba.c();
                    c2.a("config is: " + headerField);
                    String headerField2 = d.getHeaderField("X-SIGN");
                    ba c3 = ba.c();
                    c3.a("sign is: " + headerField2);
                    int responseCode = d.getResponseCode();
                    ba c4 = ba.c();
                    c4.a("update response code is: " + responseCode);
                    int contentLength = d.getContentLength();
                    ba c5 = ba.c();
                    c5.a("update response content length is: " + contentLength);
                    if (responseCode == 200) {
                        ba.c().a("request  success");
                    }
                    if (!TextUtils.isEmpty(headerField)) {
                        ba c6 = ba.c();
                        c6.a("save Config " + headerField);
                        aVar.a(context, headerField);
                    }
                    if (!TextUtils.isEmpty(headerField2)) {
                        ba c7 = ba.c();
                        c7.a("save Sign " + headerField2);
                        aVar.b(context, headerField2);
                    }
                    d.disconnect();
                    ba.c().a("finish get config");
                }
            }
        }

        private void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
                this.b.a(context, System.currentTimeMillis());
            }
        }

        private String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
                ArrayList<Pair> arrayList = new ArrayList();
                arrayList.add(new Pair("dynamicVersion", "" + PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK));
                arrayList.add(new Pair("packageName", bw.r(context)));
                arrayList.add(new Pair("appVersion", bw.g(context)));
                arrayList.add(new Pair("cuid", bw.a(context)));
                arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
                arrayList.add(new Pair("m", android.os.Build.MODEL));
                arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
                arrayList.add(new Pair("o", Build.VERSION.RELEASE));
                arrayList.add(new Pair("i", PayUVEventType.PAY_SPLIT_ORDER_LINK_ITME_CLICK));
                StringBuilder sb = new StringBuilder();
                for (Pair pair : arrayList) {
                    try {
                        String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                        String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                        if (TextUtils.isEmpty(sb.toString())) {
                            sb.append(encode + "=" + encode2);
                        } else {
                            sb.append("&" + encode + "=" + encode2);
                        }
                    } catch (Exception unused) {
                    }
                }
                return y.c + "?" + sb.toString();
            }
            return (String) invokeL.objValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (y.a) {
                        i = 3;
                    } else {
                        i = 10;
                    }
                    ba c = ba.c();
                    c.a("start version check in " + i + "s");
                    Thread.sleep((long) (i * 1000));
                    a();
                    a(this.a);
                } catch (Exception e) {
                    ba.c().a(e);
                }
                boolean unused = v.a = false;
            }
        }
    }

    public static synchronized void a(Context context, com.baidu.mobstat.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, aVar) == null) {
            synchronized (v.class) {
                if (a) {
                    return;
                }
                if (!bw.o(context)) {
                    ba.c().a("isWifiAvailable = false, will not to update");
                } else if (!aVar.a(context)) {
                    ba.c().a("check time, will not to update");
                } else {
                    ba.c().a("can start update config");
                    new a(context, aVar).start();
                    a = true;
                }
            }
        }
    }
}
