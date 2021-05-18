package com.baidu.android.pushservice.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends com.baidu.android.pushservice.h.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f3017a;

    /* renamed from: b  reason: collision with root package name */
    public a f3018b;

    /* renamed from: c  reason: collision with root package name */
    public String f3019c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f3020d;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, List<String> list);
    }

    public j(Context context, String str, a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f3020d = arrayList;
        this.f3017a = context;
        this.f3019c = str;
        this.f3018b = aVar;
        arrayList.clear();
        c("PushService-PushService-HTTPDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.h.c
    public void a() {
        b();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00fe */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0046 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.android.pushservice.d.j$a] */
    public void b() {
        InputStream inputStream;
        String string;
        List<String> list;
        ?? r0 = -1;
        r0 = -1;
        InputStream inputStream2 = null;
        r1 = 0;
        ?? r1 = 0;
        try {
            try {
                String str = "https://180.76.76.112/v6/0025?type=ipv4,ipv6&dn=" + this.f3019c;
                if (!PushSocket.isIPv4Reachable()) {
                    str = "https://[240c:4006::6666]/v6/0025?type=ipv4,ipv6&dn=" + this.f3019c;
                }
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(this.f3017a, str, "GET", (HashMap<String, String>) null, (String) null, "httpsdns.baidu.com");
                int b2 = a2.b();
                inputStream = a2.a();
                try {
                    if (b2 == 200) {
                        String a3 = com.baidu.android.pushservice.j.m.a(this.f3017a, inputStream);
                        if (!TextUtils.isEmpty(a3)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a3).getJSONObject("data").getJSONObject(this.f3019c);
                                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                                JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
                                int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                                int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                                if (length2 + length > 0) {
                                    int b3 = com.baidu.android.pushservice.j.i.b(this.f3017a, "key_vip_type", 3);
                                    if (b3 != 1) {
                                        if (b3 == 2) {
                                            if (optJSONArray2 != null && length > 0) {
                                                this.f3020d.add(optJSONArray2.getString(0));
                                            }
                                            if (optJSONArray != null && length2 > 0) {
                                                string = optJSONArray.getString(0);
                                                list = this.f3020d;
                                            }
                                        } else if (b3 != 4) {
                                            if (optJSONArray != null && length2 > 0) {
                                                this.f3020d.add(optJSONArray.getString(0));
                                            }
                                            if (optJSONArray2 != null && length > 0) {
                                                string = optJSONArray2.getString(0);
                                                list = this.f3020d;
                                            }
                                        } else if (optJSONArray != null && length2 > 0) {
                                            string = optJSONArray.getString(0);
                                            list = this.f3020d;
                                        }
                                    } else if (optJSONArray2 != null && length > 0) {
                                        string = optJSONArray2.getString(0);
                                        list = this.f3020d;
                                    }
                                    list.add(string);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        this.f3018b.a(0, this.f3020d);
                    } else {
                        com.baidu.android.pushservice.j.m.a(this.f3017a, inputStream);
                        this.f3018b.a(-1, null);
                    }
                    r0 = this.f3017a;
                    r1 = new Closeable[]{inputStream};
                    com.baidu.android.pushservice.e.c.a((Context) r0, (Closeable[]) r1);
                } catch (Exception unused2) {
                    this.f3018b.a(r0, r1);
                    com.baidu.android.pushservice.e.c.a(this.f3017a, inputStream);
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                com.baidu.android.pushservice.e.c.a(this.f3017a, inputStream2);
                throw th;
            }
        } catch (Exception unused3) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.e.c.a(this.f3017a, inputStream2);
            throw th;
        }
    }
}
