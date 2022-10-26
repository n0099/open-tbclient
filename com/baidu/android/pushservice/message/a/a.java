package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053684059, "Lcom/baidu/android/pushservice/message/a/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053684059, "Lcom/baidu/android/pushservice/message/a/a$1;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.a.c.a().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String e = kVar.e();
            String h = kVar.h();
            int i = kVar.i();
            byte[] k = kVar.k();
            String f = kVar.f();
            int b = kVar.b();
            String str = new String(bArr);
            com.baidu.android.pushservice.a.d a = com.baidu.android.pushservice.a.d.a(this.a, e);
            if (TextUtils.isEmpty(f) || !m.b(this.a, f)) {
                f = a.a() == com.baidu.android.pushservice.a.c.a ? a.a.b() : null;
            }
            if (AnonymousClass1.a[a.a().ordinal()] == 1) {
                String a2 = a(f);
                try {
                    this.a.getPackageManager().getPackageInfo(a2, 128);
                    Intent intent = new Intent();
                    intent.putExtra("app_id", e);
                    intent.putExtra("msg_id", h);
                    intent.putExtra("message", bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("notify_id", b);
                    intent.putExtra("widget_badge_info", kVar.c());
                    intent.putExtra("message_id", h);
                    intent.putExtra("baidu_message_type", i);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", k);
                    m.b(this.a, intent, "com.baidu.android.pushservice.action.MESSAGE", a2);
                    String str2 = ">>> Deliver message to client: " + a.a.b();
                    return null;
                } catch (PackageManager.NameNotFoundException e2) {
                    String str3 = ">>> NOT deliver to app: " + a.a.b() + ", package has been uninstalled.";
                    new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                }
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(7);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
