package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends e {
    private static volatile h d;
    private static String e = "SDKClientManager";

    private h(Context context) {
        super(context, c.SDK_CLIENT);
    }

    private g a(String str, ArrayList<a> arrayList) {
        a aVar = null;
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!TextUtils.isEmpty(next.a()) && next.a().equals(str) && q.c(this.b, next.c()) && (0 == 0 || aVar.d() < next.d())) {
                g gVar = (g) next;
                this.a.add(gVar);
                return gVar;
            }
        }
        return null;
    }

    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (d == null) {
                d = new h(context);
            } else {
                d.b = context.getApplicationContext();
            }
            hVar = d;
        }
        return hVar;
    }

    public String a(g gVar) {
        boolean z;
        synchronized (this.a) {
            if (!TextUtils.isEmpty(gVar.a())) {
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.b().equals(gVar.b())) {
                        next.b(gVar.c);
                        next.a(gVar.a());
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                try {
                    String a = com.baidu.android.pushservice.k.b.a(BaiduAppSSOJni.encryptAES(a(this.a), 0), "utf-8");
                    com.baidu.android.pushservice.j.b.a(this.b, "com.baidu.push.sdkr", a);
                    return a;
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.e(e, "error : " + e2.getMessage());
                } catch (UnsatisfiedLinkError e3) {
                    com.baidu.android.pushservice.g.a.a(e, e3);
                }
            }
            return null;
        }
    }

    @Override // com.baidu.android.pushservice.b.e
    public String a(List<a> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return stringBuffer.toString();
            }
            a aVar = list.get(i2);
            stringBuffer.append(aVar.b());
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(aVar.c());
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(aVar.d());
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(aVar.a());
            if (i2 != list.size() - 1) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.android.pushservice.b.e
    public ArrayList<a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : str.trim().split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            String[] split = str2.trim().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length >= 2) {
                g gVar = new g(split[0], split[1]);
                try {
                    if (split.length == 3) {
                        gVar.a(Integer.parseInt(split[2]));
                    } else if (split.length == 4) {
                        gVar.a(Integer.parseInt(split[2]));
                        gVar.a(split[3]);
                    }
                } catch (Exception e2) {
                    com.baidu.android.pushservice.g.a.c(e, "str2Clients E: " + e2);
                }
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.android.pushservice.b.e
    /* renamed from: f */
    public g b(String str) {
        g a = a(str, this.a);
        if (a == null) {
            try {
                String a2 = com.baidu.android.pushservice.j.b.a(this.b, "com.baidu.push.sdkr");
                if (TextUtils.isEmpty(a2)) {
                    com.baidu.android.pushservice.g.a.b(e, "ClientManager init strApps empty.");
                } else {
                    byte[] a3 = com.baidu.android.pushservice.k.b.a(a2.getBytes());
                    a = a(str, a(new String(BaiduAppSSOJni.decryptAES(a3, a3.length, 0))));
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.e(e, "error : " + e2.getMessage());
            } catch (UnsatisfiedLinkError e3) {
                com.baidu.android.pushservice.g.a.a(e, e3);
            }
        }
        return a;
    }
}
