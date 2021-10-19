package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class OpenAuthTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, Callback> f35883e;

    /* renamed from: f  reason: collision with root package name */
    public static long f35884f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f35885g = 122;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f35886a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f35887b;

    /* renamed from: c  reason: collision with root package name */
    public Callback f35888c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f35889d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class BizType {
        public static final /* synthetic */ BizType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BizType AccountAuth;
        public static final BizType Deduct;
        public static final BizType Invoice;
        public transient /* synthetic */ FieldHolder $fh;
        public String appId;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1879266637, "Lcom/alipay/sdk/app/OpenAuthTask$BizType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1879266637, "Lcom/alipay/sdk/app/OpenAuthTask$BizType;");
                    return;
                }
            }
            Invoice = new BizType("Invoice", 0, "20000920");
            AccountAuth = new BizType("AccountAuth", 1, "20000067");
            BizType bizType = new BizType("Deduct", 2, "60000157");
            Deduct = bizType;
            $VALUES = new BizType[]{Invoice, AccountAuth, bizType};
        }

        public BizType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.appId = str2;
        }

        public static BizType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (BizType) Enum.valueOf(BizType.class, str) : (BizType) invokeL.objValue;
        }

        public static BizType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (BizType[]) $VALUES.clone() : (BizType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface Callback {
        void onResult(int i2, String str, Bundle bundle);
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35890a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1470219911, "Lcom/alipay/sdk/app/OpenAuthTask$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1470219911, "Lcom/alipay/sdk/app/OpenAuthTask$a;");
                    return;
                }
            }
            int[] iArr = new int[BizType.values().length];
            f35890a = iArr;
            try {
                iArr[BizType.Deduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35890a[BizType.AccountAuth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35890a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f35891a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35892b;

        /* renamed from: c  reason: collision with root package name */
        public final Bundle f35893c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OpenAuthTask f35894d;

        public /* synthetic */ b(OpenAuthTask openAuthTask, int i2, String str, Bundle bundle, a aVar) {
            this(openAuthTask, i2, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35894d.f35888c == null) {
                return;
            }
            this.f35894d.f35888c.onResult(this.f35891a, this.f35892b, this.f35893c);
        }

        public b(OpenAuthTask openAuthTask, int i2, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {openAuthTask, Integer.valueOf(i2), str, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35894d = openAuthTask;
            this.f35891a = i2;
            this.f35892b = str;
            this.f35893c = bundle;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-256278186, "Lcom/alipay/sdk/app/OpenAuthTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-256278186, "Lcom/alipay/sdk/app/OpenAuthTask;");
                return;
            }
        }
        f35883e = new ConcurrentHashMap();
        f35884f = -1L;
    }

    public OpenAuthTask(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35886a = false;
        this.f35889d = new Handler(Looper.getMainLooper());
        this.f35887b = activity;
        com.alipay.sdk.sys.b.d().a(activity);
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, bizType, map, callback, Boolean.valueOf(z)}) == null) {
            Activity activity = this.f35887b;
            String valueOf = String.valueOf(map);
            com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(activity, valueOf, "oa-" + bizType);
            this.f35888c = callback;
            if (a(aVar, str, bizType, map, z)) {
                com.alipay.sdk.app.statistic.a.b(this.f35887b, aVar, "", aVar.f36072d);
            }
        }
    }

    private boolean a(com.alipay.sdk.sys.a aVar, String str, BizType bizType, Map<String, String> map, boolean z) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{aVar, str, bizType, map, Boolean.valueOf(z)})) == null) {
            if (this.f35886a) {
                this.f35889d.post(new b(this, 4000, "该 OpenAuthTask 已在执行", null, null));
                return true;
            }
            this.f35886a = true;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - f35884f <= 3000) {
                this.f35889d.post(new b(this, 5000, "3s 内重复支付", null, null));
                return true;
            }
            f35884f = elapsedRealtime;
            com.alipay.sdk.app.a.a("");
            String a2 = l.a(32);
            HashMap hashMap = new HashMap(map);
            hashMap.put("mqpPkgName", this.f35887b.getPackageName());
            hashMap.put("mqpScene", "sdk");
            List<a.b> k = com.alipay.sdk.data.a.u().k();
            if (!com.alipay.sdk.data.a.u().f35997g || k == null) {
                k = com.alipay.sdk.app.a.f35930d;
            }
            l.b a3 = l.a(aVar, this.f35887b, k);
            if (a3 == null || a3.a(aVar) || a3.a() || (packageInfo = a3.f36147a) == null || packageInfo.versionCode < 122) {
                if (z) {
                    hashMap.put("mqpScheme", String.valueOf(str));
                    hashMap.put("mqpNotifyName", a2);
                    hashMap.put("mqpScene", "landing");
                    String a4 = a(bizType, hashMap);
                    Intent intent = new Intent(this.f35887b, H5OpenAuthActivity.class);
                    intent.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(a4)));
                    a.C1568a.a(aVar, intent);
                    this.f35887b.startActivity(intent);
                    return false;
                }
                this.f35889d.post(new b(this, 4001, "支付宝未安装或签名错误", null, null));
                return true;
            }
            try {
                HashMap<String, String> a5 = com.alipay.sdk.sys.a.a(aVar);
                a5.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
                hashMap.put("mqpLoc", new JSONObject(a5).toString());
                String a6 = a(bizType, hashMap);
                f35883e.put(a2, this.f35888c);
                String str2 = null;
                try {
                    str2 = a(elapsedRealtime, a2, bizType, a6);
                } catch (JSONException e2) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.v0, e2);
                }
                String str3 = str2;
                if (TextUtils.isEmpty(str3)) {
                    this.f35889d.post(new b(this, 4000, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, null, null));
                    return true;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "20001129").appendQueryParameter("payload", str3).build());
                intent2.addFlags(268435456);
                intent2.setPackage(a3.f36147a.packageName);
                try {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.c0, "" + elapsedRealtime);
                    a.C1568a.a(aVar, a2);
                    this.f35887b.startActivity(intent2);
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "biz", "StartWalletEx", th);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    private String a(BizType bizType, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bizType, map)) == null) {
            if (bizType != null) {
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bizType.appId);
                if (a.f35890a[bizType.ordinal()] == 1) {
                    appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
                }
                return appendQueryParameter.build().toString();
            }
            throw new RuntimeException("missing bizType");
        }
        return (String) invokeLL.objValue;
    }

    private String a(long j2, String str, BizType bizType, String str2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j2), str, bizType, str2})) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", String.valueOf(j2));
            jSONObject.put("session", str);
            jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, this.f35887b.getPackageName());
            if (bizType != null) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, bizType.appId);
            }
            jSONObject.put(CommandMessage.SDK_VERSION, "h.a.3.8.02");
            jSONObject.put("mqpURL", str2);
            return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(String str, int i2, String str2, Bundle bundle) {
        Callback remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(AdIconUtil.AD_TEXT_ID, null, str, i2, str2, bundle) == null) || (remove = f35883e.remove(str)) == null) {
            return;
        }
        try {
            remove.onResult(i2, str2, bundle);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
