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
/* loaded from: classes10.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.f$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053535104, "Lcom/baidu/android/pushservice/message/a/f$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053535104, "Lcom/baidu/android/pushservice/message/a/f$1;");
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
    public f(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String e2 = kVar.e();
            String h2 = kVar.h();
            int i2 = kVar.i();
            byte[] k = kVar.k();
            String f2 = kVar.f();
            int b2 = kVar.b();
            String str = new String(bArr);
            com.baidu.android.pushservice.a.d a2 = com.baidu.android.pushservice.a.d.a(this.a, e2);
            if (TextUtils.isEmpty(f2) || !m.b(this.a, f2)) {
                f2 = a2.a() == com.baidu.android.pushservice.a.c.a ? a2.a.b() : null;
            }
            int i3 = 7;
            if (AnonymousClass1.a[a2.a().ordinal()] == 1) {
                String a3 = a(f2);
                try {
                    this.a.getPackageManager().getPackageInfo(a3, 128);
                    Intent intent = new Intent();
                    intent.putExtra("app_id", e2);
                    intent.putExtra("msg_id", h2);
                    intent.putExtra("message", bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", h2);
                    intent.putExtra("baidu_message_type", i2);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", k);
                    intent.putExtra("notify_id", b2);
                    intent.putExtra("widget_badge_info", kVar.c());
                    if (kVar.a() < 1 || !m.q(this.a)) {
                        a = m.a(this.a, intent, "com.baidu.android.pushservice.action.MESSAGE", a3);
                        String str2 = ">>> Deliver message to client: " + a2.a.b() + " result: " + a;
                    } else {
                        a = new d(this.a).a(kVar, bArr).a();
                    }
                    i3 = a;
                } catch (PackageManager.NameNotFoundException e3) {
                    String str3 = ">>> NOT deliver to app: " + a2.a.b() + ", package has been uninstalled.";
                    new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                }
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i3);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
