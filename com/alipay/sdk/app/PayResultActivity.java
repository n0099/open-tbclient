package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.sys.a;
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
/* loaded from: classes4.dex */
public final class PayResultActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35750a = "{\"isLogin\":\"false\"}";

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Object> f35751b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f35752c = "hk.alipay.wallet";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35753d = "phonecashier.pay.hash";

    /* renamed from: e  reason: collision with root package name */
    public static final String f35754e = "orderSuffix";

    /* renamed from: f  reason: collision with root package name */
    public static final String f35755f = "externalPkgName";

    /* renamed from: g  reason: collision with root package name */
    public static final String f35756g = "phonecashier.pay.result";

    /* renamed from: h  reason: collision with root package name */
    public static final String f35757h = "phonecashier.pay.resultOrderHash";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public com.alipay.sdk.sys.a f35758i;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile String f35760a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile String f35761b;
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
        f35751b = new HashMap<>();
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
                return;
            }
        }
        this.f35758i = null;
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, activity, str, str2, str3) == null) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(f35752c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.util.c.a(e2);
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
                if (!TextUtils.isEmpty(intent.getStringExtra(f35754e))) {
                    a.f35760a = intent.getStringExtra(f35753d);
                    String stringExtra = intent.getStringExtra(f35754e);
                    String stringExtra2 = intent.getStringExtra(f35755f);
                    com.alipay.sdk.sys.a a2 = a.C1565a.a(intent);
                    this.f35758i = a2;
                    if (a2 == null) {
                        finish();
                    }
                    a(this, a.f35760a, stringExtra, stringExtra2);
                    a(this, 300);
                    return;
                }
                if (this.f35758i == null) {
                    finish();
                }
                String stringExtra3 = intent.getStringExtra(f35756g);
                int intExtra = intent.getIntExtra(f35757h, 0);
                if (intExtra != 0 && TextUtils.equals(a.f35760a, String.valueOf(intExtra))) {
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        a(stringExtra3, a.f35760a);
                    } else {
                        a(a.f35760a);
                    }
                    a.f35760a = "";
                    a(this, 300);
                    return;
                }
                com.alipay.sdk.sys.a aVar = this.f35758i;
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.af, "Expected " + a.f35760a + ", got " + intExtra);
                a(a.f35760a);
                a(this, 300);
            } catch (Throwable unused) {
                finish();
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            a.f35761b = b.c();
            a(f35751b, str);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            a.f35761b = str;
            a(f35751b, str2);
        }
    }

    public static void a(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, activity, i2) == null) {
            new Handler().postDelayed(new Runnable(activity) { // from class: com.alipay.sdk.app.PayResultActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Activity f35759a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35759a = activity;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35759a.finish();
                    }
                }
            }, i2);
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
