package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlipayResultActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f35619a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2, String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1111872439, "Lcom/alipay/sdk/app/AlipayResultActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1111872439, "Lcom/alipay/sdk/app/AlipayResultActivity;");
                return;
            }
        }
        f35619a = new ConcurrentHashMap<>();
    }

    public AlipayResultActivity() {
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

    private void a(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, bundle) == null) {
            a remove = f35619a.remove(str);
            if (remove == null) {
                return;
            }
            try {
                remove.a(bundle.getInt("endCode"), bundle.getString(i.f35880b), bundle.getString("result"));
            } finally {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        JSONObject jSONObject;
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                String stringExtra = intent.getStringExtra("session");
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                com.alipay.sdk.sys.a a2 = a.C1561a.a(stringExtra);
                if (a2 == null) {
                    finish();
                    return;
                }
                com.alipay.sdk.app.statistic.a.b(a2, "biz", "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        jSONObject = jSONObject2.getJSONObject("result");
                        stringExtra = jSONObject2.getString("session");
                        com.alipay.sdk.app.statistic.a.b(a2, "biz", "BSPUriSession", stringExtra);
                        bundle2 = new Bundle();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            bundle2.putString(next, jSONObject.getString(next));
                        }
                        bundleExtra = bundle2;
                    } catch (Throwable th2) {
                        th = th2;
                        bundleExtra = bundle2;
                        com.alipay.sdk.app.statistic.a.a(a2, "biz", "BSPResEx", th);
                        com.alipay.sdk.app.statistic.a.a(a2, "biz", com.alipay.sdk.app.statistic.b.an, th);
                        if (TextUtils.isEmpty(stringExtra)) {
                        }
                        com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                        finish();
                    }
                }
                if (TextUtils.isEmpty(stringExtra) && bundleExtra != null) {
                    com.alipay.sdk.app.statistic.a.b(a2, "biz", com.alipay.sdk.app.statistic.b.P, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.b(a2, "biz", com.alipay.sdk.app.statistic.b.Q, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(i.f35880b, "-"));
                    OpenAuthTask.a(stringExtra, 9000, StatHelper.SENSOR_OK, bundleExtra);
                    com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                    finish();
                    return;
                }
                com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                finish();
            } catch (Throwable unused) {
                finish();
            }
        }
    }
}
