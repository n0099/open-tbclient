package com.baidu.android.pushservice.httpapi;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends com.baidu.android.pushservice.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a f30865b;

    /* renamed from: c  reason: collision with root package name */
    public String f30866c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f30867d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, List<String> list);
    }

    public j(Context context, String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.f30867d = arrayList;
        this.a = context;
        this.f30866c = str;
        this.f30865b = aVar;
        arrayList.clear();
        c("PushService-PushService-HTTPDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0102 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x004a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0112: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:58:0x0112 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.android.pushservice.httpapi.j$a] */
    public void b() {
        InputStream inputStream;
        Closeable closeable;
        String string;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        ?? r0 = -1;
        r0 = -1;
        Closeable closeable2 = null;
        r1 = 0;
        ?? r1 = 0;
        try {
            try {
                String str = "https://180.76.76.112/v6/0025?type=ipv4,ipv6&dn=" + this.f30866c;
                if (!PushSocket.isIPv4Reachable()) {
                    str = "https://[240c:4006::6666]/v6/0025?type=ipv4,ipv6&dn=" + this.f30866c;
                }
                com.baidu.android.pushservice.d.b a2 = com.baidu.android.pushservice.d.c.a(this.a, str, "GET", (HashMap<String, String>) null, (String) null, "httpsdns.baidu.com");
                int b2 = a2.b();
                inputStream = a2.a();
                try {
                    if (b2 == 200) {
                        String a3 = com.baidu.android.pushservice.i.m.a(this.a, inputStream);
                        if (!TextUtils.isEmpty(a3)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a3).getJSONObject("data").getJSONObject(this.f30866c);
                                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                                JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
                                int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                                int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                                if (length2 + length > 0) {
                                    int b3 = com.baidu.android.pushservice.i.i.b(this.a, "key_vip_type", 3);
                                    if (b3 != 1) {
                                        if (b3 == 2) {
                                            if (optJSONArray2 != null && length > 0) {
                                                this.f30867d.add(optJSONArray2.getString(0));
                                            }
                                            if (optJSONArray != null && length2 > 0) {
                                                string = optJSONArray.getString(0);
                                                list = this.f30867d;
                                            }
                                        } else if (b3 != 4) {
                                            if (optJSONArray != null && length2 > 0) {
                                                this.f30867d.add(optJSONArray.getString(0));
                                            }
                                            if (optJSONArray2 != null && length > 0) {
                                                string = optJSONArray2.getString(0);
                                                list = this.f30867d;
                                            }
                                        } else if (optJSONArray != null && length2 > 0) {
                                            string = optJSONArray.getString(0);
                                            list = this.f30867d;
                                        }
                                    } else if (optJSONArray2 != null && length > 0) {
                                        string = optJSONArray2.getString(0);
                                        list = this.f30867d;
                                    }
                                    list.add(string);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        this.f30865b.a(0, this.f30867d);
                    } else {
                        com.baidu.android.pushservice.i.m.a(this.a, inputStream);
                        this.f30865b.a(-1, null);
                    }
                    r0 = this.a;
                    r1 = new Closeable[]{inputStream};
                    com.baidu.android.pushservice.d.c.a((Context) r0, (Closeable[]) r1);
                } catch (Exception unused2) {
                    this.f30865b.a(r0, r1);
                    com.baidu.android.pushservice.d.c.a(this.a, inputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.android.pushservice.d.c.a(this.a, closeable2);
                throw th;
            }
        } catch (Exception unused3) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.d.c.a(this.a, closeable2);
            throw th;
        }
    }
}
