package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.g$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.a.ordinal()] = 1;
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

    public static String[] a(Context context, int i2, String str, String str2, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), str, str2, bArr, bArr2})) == null) {
            if (m.a(context, bArr, str2, bArr2)) {
                String[] strArr = new String[2];
                if (i2 == k.f32517b.b() || i2 == k.f32518c.b()) {
                    strArr[0] = new String(bArr2);
                    strArr[1] = null;
                } else if (i2 == k.f32522g.b()) {
                    PublicMsg a = i.a(context, str2, str, bArr2);
                    strArr[0] = a.mDescription;
                    strArr[1] = a.mCustomContent;
                } else if (i2 == k.f32524i.b()) {
                    strArr[0] = new String(bArr2);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("push_ack_msgid", str2);
                        jSONObject.put("push_ack_msgtype", i2);
                    } catch (JSONException unused) {
                    }
                    strArr[1] = jSONObject.toString();
                }
                return strArr;
            }
            return null;
        }
        return (String[]) invokeCommon.objValue;
    }

    @Override // com.baidu.android.pushservice.message.a.c
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        int i2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String e2 = kVar.e();
            String h2 = kVar.h();
            int i3 = kVar.i();
            byte[] k = kVar.k();
            String f2 = kVar.f();
            int b2 = kVar.b();
            com.baidu.android.pushservice.a.d a = com.baidu.android.pushservice.a.d.a(this.a, e2);
            if (TextUtils.isEmpty(f2) || !m.b(this.a, f2)) {
                f2 = a.a() == com.baidu.android.pushservice.a.c.a ? a.a.b() : null;
            }
            if (AnonymousClass1.a[a.a().ordinal()] == 1) {
                String a2 = a(f2);
                try {
                    this.a.getPackageManager().getPackageInfo(a2, 128);
                    PublicMsg a3 = i.a(this.a, h2, e2, bArr);
                    boolean a4 = a(bArr);
                    if (a3 != null) {
                        Intent intent = new Intent();
                        if (a4) {
                            str = "com.baidu.android.pushservice.action.FB_MESSAGE";
                        } else {
                            str = "com.baidu.android.pushservice.action.MESSAGE";
                            intent.putExtra("msg_id", h2);
                        }
                        intent.putExtra("message_string", a3.mDescription);
                        intent.putExtra("message_id", h2);
                        intent.putExtra("baidu_message_type", i3);
                        intent.putExtra("baidu_message_body", bArr);
                        intent.putExtra("app_id", e2);
                        intent.putExtra("baidu_message_secur_info", k);
                        intent.putExtra("notify_id", b2);
                        intent.putExtra("widget_badge_info", kVar.c());
                        if (!TextUtils.isEmpty(a3.mCustomContent)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a3.mCustomContent);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    intent.putExtra(next, jSONObject.getString(next));
                                }
                                intent.putExtra("extra_extra_custom_content", a3.mCustomContent);
                            } catch (JSONException e3) {
                                new b.c(this.a).a(Log.getStackTraceString(e3)).a();
                            }
                        }
                        if (kVar.a() < 1 || !m.q(this.a)) {
                            i2 = m.a(this.a, intent, str, a2);
                            String str2 = ">>> Deliver message to client: " + a2 + " msg: " + a3.mDescription + " result: " + i2;
                        } else {
                            i2 = new d(this.a).a(kVar, bArr).a();
                        }
                    } else {
                        i2 = 0;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    i2 = 8;
                    sb = new StringBuilder();
                    sb.append(">>> NOT deliver to app: ");
                    e2 = a.a.b();
                }
                com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
                gVar.a(i2);
                return gVar;
            }
            i2 = 7;
            sb = new StringBuilder();
            sb.append(">>> NOT found client for privateMessageHandler appid ");
            sb.append(e2);
            sb.toString();
            com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
            gVar2.a(i2);
            return gVar2;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
