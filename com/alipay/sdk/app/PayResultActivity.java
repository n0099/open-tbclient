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
/* loaded from: classes6.dex */
public final class PayResultActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f34000b = "{\"isLogin\":\"false\"}";

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Object> f34001c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f34002d = "hk.alipay.wallet";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34003e = "phonecashier.pay.hash";

    /* renamed from: f  reason: collision with root package name */
    public static final String f34004f = "orderSuffix";

    /* renamed from: g  reason: collision with root package name */
    public static final String f34005g = "externalPkgName";

    /* renamed from: h  reason: collision with root package name */
    public static final String f34006h = "phonecashier.pay.result";

    /* renamed from: i  reason: collision with root package name */
    public static final String f34007i = "phonecashier.pay.resultOrderHash";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.alipay.sdk.sys.a f34008a;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f34009a;

        public a(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34009a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34009a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile String f34010a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile String f34011b;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        f34001c = new HashMap<>();
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
        this.f34008a = null;
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, activity, str, str2, str3) == null) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(f34002d);
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
                if (!TextUtils.isEmpty(intent.getStringExtra(f34004f))) {
                    b.f34010a = intent.getStringExtra(f34003e);
                    String stringExtra = intent.getStringExtra(f34004f);
                    String stringExtra2 = intent.getStringExtra(f34005g);
                    com.alipay.sdk.sys.a a2 = a.C1522a.a(intent);
                    this.f34008a = a2;
                    if (a2 == null) {
                        finish();
                    }
                    a(this, b.f34010a, stringExtra, stringExtra2);
                    a(this, 300);
                    return;
                }
                if (this.f34008a == null) {
                    finish();
                }
                String stringExtra3 = intent.getStringExtra(f34006h);
                int intExtra = intent.getIntExtra(f34007i, 0);
                if (intExtra != 0 && TextUtils.equals(b.f34010a, String.valueOf(intExtra))) {
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        a(stringExtra3, b.f34010a);
                    } else {
                        a(b.f34010a);
                    }
                    b.f34010a = "";
                    a(this, 300);
                    return;
                }
                com.alipay.sdk.sys.a aVar = this.f34008a;
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", com.alipay.sdk.app.statistic.b.p0, "Expected " + b.f34010a + ", got " + intExtra);
                a(b.f34010a);
                a(this, 300);
            } catch (Throwable unused) {
                finish();
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            b.f34011b = com.alipay.sdk.app.b.a();
            a(f34001c, str);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            b.f34011b = str;
            a(f34001c, str2);
        }
    }

    public static void a(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, activity, i2) == null) {
            new Handler().postDelayed(new a(activity), i2);
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
