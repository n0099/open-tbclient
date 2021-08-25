package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
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
/* loaded from: classes4.dex */
public class h extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.h$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37570a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053475522, "Lcom/baidu/android/pushservice/message/a/h$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053475522, "Lcom/baidu/android/pushservice/message/a/h$1;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.a.c.a().length];
            f37570a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.f36752a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
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
                if (i2 == l.f37574b.b() || i2 == l.f37575c.b()) {
                    strArr[0] = new String(bArr2);
                    strArr[1] = null;
                } else if (i2 == l.f37579g.b()) {
                    PublicMsg a2 = j.a(context, str2, str, bArr2);
                    strArr[0] = a2.mDescription;
                    strArr[1] = a2.mCustomContent;
                } else if (i2 == l.f37582j.b()) {
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

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        int i2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String c2 = kVar.c();
            String f2 = kVar.f();
            int g2 = kVar.g();
            byte[] i3 = kVar.i();
            String d2 = kVar.d();
            int a2 = kVar.a();
            com.baidu.android.pushservice.a.d a3 = com.baidu.android.pushservice.a.d.a(this.f37561a, c2);
            if (TextUtils.isEmpty(d2) || !m.b(this.f37561a, d2)) {
                d2 = a3.a() == com.baidu.android.pushservice.a.c.f36752a ? a3.f36755a.b() : null;
            }
            if (AnonymousClass1.f37570a[a3.a().ordinal()] == 1) {
                String a4 = a(d2);
                try {
                    this.f37561a.getPackageManager().getPackageInfo(a4, 128);
                    PublicMsg a5 = j.a(this.f37561a, f2, c2, bArr);
                    boolean a6 = a(bArr);
                    if (a5 != null) {
                        Intent intent = new Intent();
                        if (a6) {
                            str = "com.baidu.android.pushservice.action.FB_MESSAGE";
                        } else {
                            str = "com.baidu.android.pushservice.action.MESSAGE";
                            intent.putExtra("msg_id", f2);
                        }
                        intent.putExtra("message_string", a5.mDescription);
                        intent.putExtra("message_id", f2);
                        intent.putExtra("baidu_message_type", g2);
                        intent.putExtra("baidu_message_body", bArr);
                        intent.putExtra("app_id", c2);
                        intent.putExtra("baidu_message_secur_info", i3);
                        intent.putExtra("notify_id", a2);
                        if (!TextUtils.isEmpty(a5.mCustomContent)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a5.mCustomContent);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    intent.putExtra(next, jSONObject.getString(next));
                                }
                                intent.putExtra("extra_extra_custom_content", a5.mCustomContent);
                            } catch (JSONException e2) {
                                new b.c(this.f37561a).a(Log.getStackTraceString(e2)).a();
                            }
                        }
                        i2 = m.a(this.f37561a, intent, str, a4);
                        m.a(">>> Deliver message to client: " + a4 + " msg: " + a5.mDescription + " result: " + i2, this.f37561a);
                    } else {
                        i2 = 0;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    i2 = 8;
                    sb = new StringBuilder();
                    sb.append(">>> NOT deliver to app: ");
                    c2 = a3.f36755a.b();
                }
                com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
                gVar.a(i2);
                return gVar;
            }
            i2 = 7;
            sb = new StringBuilder();
            sb.append(">>> NOT found client for privateMessageHandler appid ");
            sb.append(c2);
            m.a(sb.toString(), this.f37561a);
            com.baidu.android.pushservice.message.g gVar2 = new com.baidu.android.pushservice.message.g();
            gVar2.a(i2);
            return gVar2;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}
