package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.g$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37688a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053505313, "Lcom/baidu/android/pushservice/message/a/g$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053505313, "Lcom/baidu/android/pushservice/message/a/g$1;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.a.c.a().length];
            f37688a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.f36871a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
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

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String c2 = kVar.c();
            String f2 = kVar.f();
            int g2 = kVar.g();
            byte[] i2 = kVar.i();
            String d2 = kVar.d();
            int a2 = kVar.a();
            String str = new String(bArr);
            com.baidu.android.pushservice.a.d a3 = com.baidu.android.pushservice.a.d.a(this.f37680a, c2);
            if (TextUtils.isEmpty(d2) || !m.b(this.f37680a, d2)) {
                d2 = a3.a() == com.baidu.android.pushservice.a.c.f36871a ? a3.f36874a.b() : null;
            }
            int i3 = 7;
            if (AnonymousClass1.f37688a[a3.a().ordinal()] != 1) {
                m.a(">>> Don't found app  in OldPrivateMessage " + str, this.f37680a);
            } else {
                String a4 = a(d2);
                try {
                    this.f37680a.getPackageManager().getPackageInfo(a4, 128);
                    Intent intent = new Intent();
                    intent.putExtra("app_id", c2);
                    intent.putExtra("msg_id", f2);
                    intent.putExtra("message", bArr);
                    intent.putExtra("message_string", str);
                    intent.putExtra("message_id", f2);
                    intent.putExtra("baidu_message_type", g2);
                    intent.putExtra("baidu_message_body", bArr);
                    intent.putExtra("baidu_message_secur_info", i2);
                    intent.putExtra("notify_id", a2);
                    int a5 = m.a(this.f37680a, intent, "com.baidu.android.pushservice.action.MESSAGE", a4);
                    m.a(">>> Deliver message to client: " + a3.f36874a.b() + " result: " + a5, this.f37680a);
                    i3 = a5;
                } catch (PackageManager.NameNotFoundException e2) {
                    m.a(">>> NOT deliver to app: " + a3.f36874a.b() + ", package has been uninstalled.", this.f37680a);
                    new b.c(this.f37680a).a(Log.getStackTraceString(e2)).a();
                }
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i3);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
