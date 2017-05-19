package com.baidu.android.pushservice.b;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.r;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.h.v;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class e {
    protected ArrayList<a> a = new ArrayList<>();
    protected Context b;
    protected c c;

    public e(Context context, c cVar) {
        this.b = context.getApplicationContext();
        this.c = cVar;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:9:0x0038, B:11:0x0040, B:12:0x004a, B:14:0x0050, B:16:0x005a, B:17:0x005e, B:19:0x0064, B:20:0x006f, B:22:0x0075, B:24:0x0085, B:28:0x0092, B:33:0x00bd, B:36:0x00c7, B:38:0x00cf), top: B:56:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, ArrayList<a> arrayList) {
        ArrayList<a> a;
        boolean z;
        String str2 = this.b.getPackageName() + ".push_sync";
        for (ResolveInfo resolveInfo : u.E(this.b) ? u.n(this.b) : u.m(this.b)) {
            try {
                String e = "com.baidu.push.webr".equals(str) ? r.e(this.b, resolveInfo.activityInfo.packageName) : "com.baidu.push.lappr".equals(str) ? null : "com.baidu.push.sdkr".equals(str) ? r.f(this.b, resolveInfo.activityInfo.packageName) : null;
                if (!TextUtils.isEmpty(e) && (a = a(d(e))) != null) {
                    Iterator<a> it = a.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        Iterator<a> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            a next2 = it2.next();
                            if (TextUtils.equals(next.c, next2.c) || TextUtils.equals(next.a, next2.a)) {
                                z = true;
                                break;
                            }
                            while (it2.hasNext()) {
                            }
                        }
                        z = false;
                        if (!z) {
                            arrayList.add(next);
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.e("IClientManager", "syncRegisterDataImpl Exception: " + e2.getMessage());
            }
        }
        if (arrayList.size() > 0) {
            String e3 = e(a(arrayList));
            if ("com.baidu.push.webr".equals(str)) {
                q.c(this.b, e3);
            } else if (!"com.baidu.push.lappr".equals(str) && "com.baidu.push.sdkr".equals(str)) {
                q.d(this.b, e3);
            }
            if (u.D(this.b)) {
                v.a(this.b, str2, str, e3);
            }
        }
    }

    public static String d(String str) {
        try {
            byte[] a = com.baidu.android.pushservice.i.b.a(str.getBytes());
            return (a == null || a.length <= 0) ? "" : new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("IClientManager", e);
            return "";
        } catch (UnsatisfiedLinkError e2) {
            com.baidu.android.pushservice.e.a.a("IClientManager", e2);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003d A[Catch: all -> 0x015f, TryCatch #2 {, blocks: (B:4:0x0027, B:6:0x0031, B:7:0x0037, B:9:0x003d, B:11:0x004d, B:15:0x0069, B:17:0x0070, B:22:0x007b, B:23:0x0080, B:27:0x00af, B:28:0x00be, B:58:0x014e, B:59:0x0153, B:62:0x0159, B:13:0x005b, B:30:0x00c0, B:32:0x00c6, B:33:0x00cc, B:35:0x00d2, B:37:0x00e2, B:39:0x00f0, B:41:0x00fa, B:44:0x010a, B:45:0x0110, B:47:0x0116, B:49:0x0126, B:51:0x0134), top: B:68:0x0027, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(a aVar, boolean z) {
        String str;
        boolean z2;
        boolean z3 = true;
        com.baidu.android.pushservice.e.a.c("IClientManager", "client sync addOrRemove:" + z + ", " + aVar);
        synchronized (this.a) {
            if (!TextUtils.isEmpty(aVar.a())) {
                Iterator<a> it = this.a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if ((!TextUtils.isEmpty(aVar.b()) && TextUtils.equals(next.b(), aVar.b())) || aVar.a().equals(next.a())) {
                        this.a.remove(next);
                        if (z) {
                            this.a.add(aVar);
                        }
                        z2 = true;
                        z3 = z2;
                    }
                    while (it.hasNext()) {
                    }
                }
                z2 = false;
                z3 = z2;
            } else if (this.c == c.SDK_CLIENT) {
                Iterator<a> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (!TextUtils.isEmpty(aVar.b()) && TextUtils.equals(next2.b(), aVar.b()) && !TextUtils.isEmpty(aVar.c()) && TextUtils.equals(next2.c(), aVar.c())) {
                        break;
                    }
                }
                z3 = false;
            } else {
                Iterator<a> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    a next3 = it3.next();
                    if (!TextUtils.isEmpty(aVar.b())) {
                        if (TextUtils.equals(next3.b(), aVar.b())) {
                            break;
                        }
                    }
                    if (TextUtils.isEmpty(next3.a())) {
                        break;
                    }
                }
                z3 = false;
            }
            if (!z3 && z) {
                this.a.add(aVar);
            }
            String a = a(this.a);
            com.baidu.android.pushservice.e.a.c("IClientManager", "sync  strApps: " + a);
            switch (this.c) {
                case WEBAPP_CLIENT:
                    str = "com.baidu.push.webr";
                    break;
                case SDK_CLIENT:
                    str = "com.baidu.push.sdkr";
                    break;
                case PUSH_CLIENT:
                    str = "";
                    break;
                default:
                    str = "";
                    break;
            }
            try {
                String a2 = com.baidu.android.pushservice.i.b.a(BaiduAppSSOJni.encryptAES(a, 0), "utf-8");
                com.baidu.android.pushservice.h.b.a(this.b, str, a2);
                return a2;
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a("IClientManager", e);
                return "";
            } catch (UnsatisfiedLinkError e2) {
                com.baidu.android.pushservice.e.a.a("IClientManager", e2);
                return "";
            }
        }
    }

    protected String a(List<a> list) {
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
            stringBuffer.append(",");
            stringBuffer.append(aVar.a());
            if (i2 != list.size() - 1) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
            i = i2 + 1;
        }
    }

    protected ArrayList<a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        for (String str2 : str.trim().split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            String[] split = str2.trim().trim().split(",");
            if (split.length == 1 || split.length == 2) {
                a aVar = new a(split[0]);
                if (split.length == 2) {
                    aVar.a(split[1]);
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    protected void a() {
        String str;
        switch (this.c) {
            case WEBAPP_CLIENT:
                str = "com.baidu.push.webr";
                break;
            case SDK_CLIENT:
                str = "com.baidu.push.sdkr";
                break;
            case PUSH_CLIENT:
                str = "";
                break;
            default:
                str = "";
                break;
        }
        String a = u.D(this.b) ? com.baidu.android.pushservice.h.b.a(this.b, str) : null;
        if (TextUtils.isEmpty(a)) {
            if ("com.baidu.push.webr".equals(str)) {
                a = q.e(this.b);
            } else if ("com.baidu.push.sdkr".equals(str)) {
                a = q.f(this.b);
            }
        }
        if (TextUtils.isEmpty(a)) {
            com.baidu.android.pushservice.e.a.b("IClientManager", "ClientManager init strApps empty.");
            return;
        }
        try {
            String d = d(a);
            com.baidu.android.pushservice.e.a.b("IClientManager", "ClientManager init strApps : " + d);
            ArrayList<a> a2 = a(d);
            if (a2 != null) {
                Iterator<a> it = a2.iterator();
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
            a(str, this.a);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("IClientManager", e);
        } catch (UnsatisfiedLinkError e2) {
            com.baidu.android.pushservice.e.a.a("IClientManager", e2);
        }
    }

    public synchronized void a(String str, String str2) {
        int i;
        if (TextUtils.isEmpty(str2)) {
            com.baidu.android.pushservice.e.a.c("IClientManager", "ClientManager init strApps empty.");
        } else {
            ArrayList<a> a = a(d(str2));
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<a> it = a.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().c);
                }
                int i2 = 0;
                while (i2 < this.a.size()) {
                    if (arrayList.contains(this.a.get(i2).c)) {
                        this.a.remove(i2);
                        i = i2 - 1;
                    } else {
                        i = i2;
                    }
                    i2 = i + 1;
                }
                this.a.addAll(a);
                try {
                    String e = e(a(this.a));
                    if ("com.baidu.push.webr".equals(str)) {
                        q.c(this.b, e);
                    } else if ("com.baidu.push.sdkr".equals(str)) {
                        q.d(this.b, e);
                    }
                    if (u.D(this.b)) {
                        v.a(this.b, this.b.getPackageName() + ".push_sync", str, e);
                    }
                } catch (Exception e2) {
                    com.baidu.android.pushservice.e.a.a("IClientManager", e2);
                }
            }
        }
    }

    public a b(String str) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!TextUtils.isEmpty(next.a()) && next.a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public a c(String str) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!TextUtils.isEmpty(next.b()) && next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public String e(String str) {
        try {
            return com.baidu.android.pushservice.i.b.a(BaiduAppSSOJni.encryptAES(str, 0), "utf-8");
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.e("IClientManager", "encrypted init strApps exception.");
            return "";
        } catch (UnsatisfiedLinkError e2) {
            com.baidu.android.pushservice.e.a.a("IClientManager", e2);
            return "";
        }
    }
}
