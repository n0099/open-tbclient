package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class APayEntranceActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f35862c = "ap_order_info";

    /* renamed from: d  reason: collision with root package name */
    public static final String f35863d = "ap_target_packagename";

    /* renamed from: e  reason: collision with root package name */
    public static final String f35864e = "ap_session";

    /* renamed from: f  reason: collision with root package name */
    public static final String f35865f = "ap_local_info";

    /* renamed from: g  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f35866g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f35867a;

    /* renamed from: b  reason: collision with root package name */
    public String f35868b;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-997922015, "Lcom/alipay/sdk/app/APayEntranceActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-997922015, "Lcom/alipay/sdk/app/APayEntranceActivity;");
                return;
            }
        }
        f35866g = new ConcurrentHashMap<>();
    }

    public APayEntranceActivity() {
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

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a remove = f35866g.remove(this.f35868b);
            if (TextUtils.isEmpty(this.f35867a)) {
                this.f35867a = b.a();
            }
            if (remove != null) {
                remove.a(this.f35867a);
            }
            try {
                super.finish();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 1000) {
                try {
                    if (intent != null) {
                        this.f35867a = intent.getStringExtra("result");
                    } else {
                        this.f35867a = b.a();
                    }
                } catch (Throwable unused) {
                    this.f35867a = b.a();
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    finish();
                    return;
                }
                String string = extras.getString(f35862c);
                String string2 = extras.getString(f35863d);
                this.f35868b = extras.getString(f35864e);
                String string3 = extras.getString(f35865f, StringUtil.EMPTY_ARRAY);
                Intent intent = new Intent();
                intent.putExtra("order_info", string);
                intent.putExtra("localInfo", string3);
                intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
                try {
                    startActivityForResult(intent, 1000);
                } catch (Throwable unused) {
                    finish();
                }
            } catch (Throwable unused2) {
                finish();
            }
        }
    }
}
