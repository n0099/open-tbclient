package com.baidu.android.pushservice.p;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends com.baidu.android.pushservice.z.c {
    public Context c;
    public a d;
    public String e;
    public List<String> f;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, List<String> list);
    }

    public j(Context context, String str, a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        this.c = context;
        this.e = str;
        this.d = aVar;
        arrayList.clear();
        a("PushService-PushService-HTTPDNS");
        a((short) 100);
    }

    @Override // com.baidu.android.pushservice.z.c
    public void a() {
        c();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00f8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0046 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0108: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:56:0x0108 */
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
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.android.pushservice.p.j$a] */
    public void c() {
        InputStream inputStream;
        Closeable closeable;
        String string;
        ?? r0 = -1;
        r0 = -1;
        Closeable closeable2 = null;
        r1 = 0;
        ?? r1 = 0;
        try {
            try {
                String str = "https://180.76.76.112/v6/0025?type=ipv4,ipv6&dn=" + this.e;
                if (!PushSocket.isIPv4Reachable()) {
                    str = "https://[240c:4006::6666]/v6/0025?type=ipv4,ipv6&dn=" + this.e;
                }
                com.baidu.android.pushservice.q.b b = com.baidu.android.pushservice.q.c.b(this.c, str, "GET", null, null, DnsTransmitter.IDC_HOST);
                int a2 = b.a();
                inputStream = b.b();
                try {
                    if (a2 == 200) {
                        String a3 = Utility.a(this.c, inputStream);
                        if (!TextUtils.isEmpty(a3)) {
                            try {
                                JSONObject jSONObject = new JSONObject(a3).getJSONObject("data").getJSONObject(this.e);
                                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                                int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                                int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                                if (length2 + length > 0) {
                                    int a4 = com.baidu.android.pushservice.a0.i.a(this.c, "key_vip_type", 3);
                                    if (a4 != 1) {
                                        if (a4 == 2) {
                                            if (optJSONArray2 != null && length > 0) {
                                                this.f.add(optJSONArray2.getString(0));
                                            }
                                            if (optJSONArray != null && length2 > 0) {
                                                string = optJSONArray.getString(0);
                                            }
                                        } else if (a4 != 4) {
                                            if (optJSONArray != null && length2 > 0) {
                                                this.f.add(optJSONArray.getString(0));
                                            }
                                            if (optJSONArray2 != null && length > 0) {
                                                string = optJSONArray2.getString(0);
                                            }
                                        } else if (optJSONArray != null && length2 > 0) {
                                            string = optJSONArray.getString(0);
                                        }
                                    } else if (optJSONArray2 != null && length > 0) {
                                        string = optJSONArray2.getString(0);
                                    }
                                    this.f.add(string);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        this.d.a(0, this.f);
                    } else {
                        Utility.a(this.c, inputStream);
                        this.d.a(-1, null);
                    }
                    r0 = this.c;
                    r1 = new Closeable[]{inputStream};
                    com.baidu.android.pushservice.q.c.a((Context) r0, (Closeable[]) r1);
                } catch (Exception unused2) {
                    this.d.a(r0, r1);
                    com.baidu.android.pushservice.q.c.a(this.c, inputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                com.baidu.android.pushservice.q.c.a(this.c, closeable2);
                throw th;
            }
        } catch (Exception unused3) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.android.pushservice.q.c.a(this.c, closeable2);
            throw th;
        }
    }
}
