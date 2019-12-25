package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class e {
    protected ArrayList<a> a = new ArrayList<>();
    protected Context b;
    protected c c;

    public e(Context context, c cVar) {
        this.b = context.getApplicationContext();
        this.c = cVar;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0077 A[Catch: Exception -> 0x0098, TryCatch #0 {Exception -> 0x0098, blocks: (B:9:0x0039, B:11:0x0042, B:12:0x004c, B:14:0x0052, B:16:0x005c, B:17:0x0060, B:19:0x0066, B:20:0x0071, B:22:0x0077, B:24:0x0087, B:28:0x0094), top: B:44:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, ArrayList<a> arrayList) {
        ArrayList<a> a;
        boolean z;
        String str2 = this.b.getPackageName() + ".push_sync";
        for (ResolveInfo resolveInfo : l.D(this.b) ? l.p(this.b) : l.o(this.b)) {
            try {
                String d = "com.baidu.push.sdkr".equals(str) ? com.baidu.android.pushservice.c.d.d(this.b, resolveInfo.activityInfo.packageName) : null;
                if (!TextUtils.isEmpty(d) && (a = a(c(d))) != null) {
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
            } catch (Exception e) {
            }
        }
        if (arrayList.size() > 0) {
            String d2 = d(a(arrayList));
            if ("com.baidu.push.sdkr".equals(str)) {
                com.baidu.android.pushservice.c.c.a(this.b, d2);
            }
            if (l.C(this.b)) {
                m.a(this.b, str2, str, d2);
            }
        }
    }

    public static String c(String str) {
        try {
            byte[] a = com.baidu.android.pushservice.j.b.a(str.getBytes());
            return (a == null || a.length <= 0) ? "" : new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[Catch: all -> 0x0117, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x000f, B:7:0x0015, B:9:0x001b, B:11:0x002b, B:15:0x0047, B:17:0x004e, B:22:0x0059, B:23:0x005e, B:27:0x0076, B:28:0x0086, B:57:0x0111, B:13:0x0039, B:30:0x0088, B:32:0x008e, B:33:0x0094, B:35:0x009a, B:37:0x00aa, B:39:0x00b8, B:41:0x00c2, B:44:0x00d1, B:45:0x00d7, B:47:0x00dd, B:49:0x00ed, B:51:0x00fb), top: B:66:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(a aVar, boolean z) {
        String str;
        boolean z2;
        boolean z3 = true;
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
            switch (this.c) {
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
                String a2 = com.baidu.android.pushservice.j.b.a(BaiduAppSSOJni.encryptAES(a, 0), "utf-8");
                com.baidu.android.pushservice.i.a.a(this.b, str, a2);
                return a2;
            } catch (Exception | UnsatisfiedLinkError e) {
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
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            String[] split = str2.trim().trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        String a = l.C(this.b) ? com.baidu.android.pushservice.i.a.a(this.b, str) : null;
        if (TextUtils.isEmpty(a) && "com.baidu.push.sdkr".equals(str)) {
            a = com.baidu.android.pushservice.c.c.d(this.b);
        }
        if (TextUtils.isEmpty(a)) {
            return;
        }
        try {
            ArrayList<a> a2 = a(c(a));
            if (a2 != null) {
                Iterator<a> it = a2.iterator();
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            }
            a(str, this.a);
        } catch (Exception e) {
        } catch (UnsatisfiedLinkError e2) {
        }
    }

    public synchronized void a(String str, String str2) {
        ArrayList<a> a;
        int i;
        if (!TextUtils.isEmpty(str2) && (a = a(c(str2))) != null) {
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
                String d = d(a(this.a));
                if ("com.baidu.push.sdkr".equals(str)) {
                    com.baidu.android.pushservice.c.c.a(this.b, d);
                }
                if (l.C(this.b)) {
                    m.a(this.b, this.b.getPackageName() + ".push_sync", str, d);
                }
            } catch (Exception e) {
            }
        }
    }

    public a b(String str) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!TextUtils.isEmpty(next.b()) && next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public String d(String str) {
        try {
            return com.baidu.android.pushservice.j.b.a(BaiduAppSSOJni.encryptAES(str, 0), "utf-8");
        } catch (Exception e) {
            return "";
        } catch (UnsatisfiedLinkError e2) {
            return "";
        }
    }
}
