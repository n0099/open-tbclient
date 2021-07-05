package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class PayResultActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1760a = "{\"isLogin\":\"false\"}";

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Object> f1761b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f1762c = "hk.alipay.wallet";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1763d = "phonecashier.pay.hash";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1764e = "orderSuffix";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1765f = "externalPkgName";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1766g = "phonecashier.pay.result";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1767h = "phonecashier.pay.resultOrderHash";

    /* renamed from: i  reason: collision with root package name */
    public static String f1768i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile String f1769a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile String f1770b;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(437715701, "Lcom/alipay/sdk/app/PayResultActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(437715701, "Lcom/alipay/sdk/app/PayResultActivity;");
                return;
            }
        }
        f1761b = new HashMap<>();
    }

    public PayResultActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, activity, str, str2, str3) == null) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(f1762c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1893a, "PayTask:payReuslt: UnsupportedEncodingException:" + e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                if (!TextUtils.isEmpty(intent.getStringExtra(f1764e))) {
                    a.f1769a = intent.getStringExtra(f1763d);
                    a(this, a.f1769a, intent.getStringExtra(f1764e), intent.getStringExtra(f1765f));
                    a(this, 300);
                    return;
                }
                String stringExtra = intent.getStringExtra(f1766g);
                int intExtra = intent.getIntExtra(f1767h, 0);
                if (intExtra != 0 && TextUtils.equals(a.f1769a, String.valueOf(intExtra))) {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        a(stringExtra, a.f1769a);
                    } else {
                        a(a.f1769a);
                    }
                    a.f1769a = "";
                    a(this, 300);
                    return;
                }
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.R, "Expected " + a.f1769a + ", got " + intExtra);
                a(a.f1769a);
                a(this, 300);
            } catch (Throwable unused) {
                finish();
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            a.f1770b = j.c();
            a(f1761b, str);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            a.f1770b = str;
            a(f1761b, str2);
        }
    }

    public static void a(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, activity, i2) == null) {
            new Handler().postDelayed(new f(activity), i2);
        }
    }

    public static boolean a(HashMap<String, Object> hashMap, String str) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, hashMap, str)) == null) {
            if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
                return false;
            }
            synchronized (obj) {
                obj.notifyAll();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
