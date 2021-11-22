package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class APayEntranceActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f34801c = "ap_order_info";

    /* renamed from: d  reason: collision with root package name */
    public static final String f34802d = "ap_target_packagename";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34803e = "ap_session";

    /* renamed from: f  reason: collision with root package name */
    public static final String f34804f = "ap_local_info";

    /* renamed from: g  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f34805g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34806a;

    /* renamed from: b  reason: collision with root package name */
    public String f34807b;

    /* loaded from: classes6.dex */
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
        f34805g = new ConcurrentHashMap<>();
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
            a remove = f34805g.remove(this.f34807b);
            if (TextUtils.isEmpty(this.f34806a)) {
                this.f34806a = b.a();
            }
            if (remove != null) {
                remove.a(this.f34806a);
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
                        this.f34806a = intent.getStringExtra("result");
                    } else {
                        this.f34806a = b.a();
                    }
                } catch (Throwable unused) {
                    this.f34806a = b.a();
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
                    LogUtil.logActivity(this, "onCreate");
                    return;
                }
                String string = extras.getString(f34801c);
                String string2 = extras.getString(f34802d);
                this.f34807b = extras.getString(f34803e);
                String string3 = extras.getString(f34804f, StringUtil.EMPTY_ARRAY);
                Intent intent = new Intent();
                intent.putExtra("order_info", string);
                intent.putExtra("localInfo", string3);
                intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
                try {
                    startActivityForResult(intent, 1000);
                } catch (Throwable unused) {
                    finish();
                }
                LogUtil.logActivity(this, "onCreate");
            } catch (Throwable unused2) {
                finish();
                LogUtil.logActivity(this, "onCreate");
            }
        }
    }
}
