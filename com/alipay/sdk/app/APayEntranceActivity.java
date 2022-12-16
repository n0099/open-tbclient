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
/* loaded from: classes.dex */
public class APayEntranceActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String c = "ap_order_info";
    public static final String d = "ap_target_packagename";
    public static final String e = "ap_session";
    public static final String f = "ap_local_info";
    public static final ConcurrentHashMap<String, a> g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

    /* loaded from: classes.dex */
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
        g = new ConcurrentHashMap<>();
    }

    public APayEntranceActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a remove = g.remove(this.b);
            if (TextUtils.isEmpty(this.a)) {
                this.a = b.a();
            }
            if (remove != null) {
                remove.a(this.a);
            }
            try {
                super.finish();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1000) {
                try {
                    if (intent != null) {
                        this.a = intent.getStringExtra("result");
                    } else {
                        this.a = b.a();
                    }
                } catch (Throwable unused) {
                    this.a = b.a();
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
                String string = extras.getString(c);
                String string2 = extras.getString(d);
                this.b = extras.getString(e);
                String string3 = extras.getString(f, StringUtil.EMPTY_ARRAY);
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
