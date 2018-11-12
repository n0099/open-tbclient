package com.baidu.sofire.core;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class e {
    public static String a = "";

    public static void a(final Context context, final int i, final String str, final String str2, final int... iArr) {
        try {
            new Thread(new Runnable() { // from class: com.baidu.sofire.core.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.a = context;
                        e.a(context);
                        if (!com.baidu.sofire.b.e.a(context, true)) {
                            com.baidu.sofire.b.a("checkComponent failed!");
                        } else if (!com.baidu.sofire.b.e.a(context)) {
                            com.baidu.sofire.b.a("checkProcessAuth failed!");
                        } else {
                            d a2 = d.a(context);
                            com.baidu.sofire.b.g.a(context);
                            if (i > 0) {
                                Thread.sleep(i * 1000);
                            }
                            new com.baidu.sofire.e(context).a(iArr);
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                a2.a(str, str2);
                            }
                            d.b(1);
                            a2.b();
                        }
                    } catch (Throwable th) {
                        com.baidu.sofire.b.e.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public static Pair<Integer, Object> a(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a2;
        try {
            Context context = d.a;
            if (context == null) {
                a2 = new Pair<>(4, null);
            } else if (!com.baidu.sofire.b.e.a(d.a, false)) {
                com.baidu.sofire.b.a("call checkComponent failed!");
                a2 = new Pair<>(11, null);
            } else {
                String b = com.baidu.sofire.b.e.b(d.a);
                if (TextUtils.isEmpty(b)) {
                    if (com.baidu.sofire.b.e.b(d.a.getPackageName())) {
                        a2 = new Pair<>(5, null);
                    } else {
                        com.baidu.sofire.b.a("callSync invoke in main process");
                        a2 = d.a(context).a(i, str, clsArr, objArr);
                    }
                } else if (com.baidu.sofire.b.e.b(b)) {
                    com.baidu.sofire.b.a("callSync invoke in remote process");
                    a2 = a(d.a, i, str, clsArr, objArr);
                } else {
                    com.baidu.sofire.b.a("callSync invoke in provider process");
                    a2 = d.a(context).a(i, str, clsArr, objArr);
                }
            }
            return a2;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return new Pair<>(3, null);
        }
    }

    public static boolean a(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = d.a;
            if (context == null) {
                com.baidu.sofire.b.a("Call check SDK not init!");
                if (callback != null) {
                    callback.onError(4);
                }
                return false;
            } else if (!com.baidu.sofire.b.e.a(d.a, false)) {
                com.baidu.sofire.b.a("call checkComponent failed!");
                if (callback != null) {
                    callback.onError(11);
                }
                return false;
            } else {
                String b = com.baidu.sofire.b.e.b(d.a);
                if (TextUtils.isEmpty(b)) {
                    if (com.baidu.sofire.b.e.b(d.a.getPackageName())) {
                        if (callback != null) {
                            callback.onError(5);
                        }
                        return false;
                    }
                    com.baidu.sofire.b.a("call invoke in main process");
                    d.a(context).a(i, str, callback, clsArr, objArr);
                    return true;
                } else if (com.baidu.sofire.b.e.b(b)) {
                    com.baidu.sofire.b.a("call invoke in remote process");
                    a(d.a, i, str, callback, clsArr, objArr);
                    return true;
                } else {
                    com.baidu.sofire.b.a("call invoke in provider process");
                    d.a(context).a(i, str, callback, clsArr, objArr);
                    return true;
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return false;
        }
    }

    public static String a(Context context, String str, int i, String str2) {
        try {
            if (!TextUtils.isEmpty(a)) {
                if (TextUtils.isEmpty(str2)) {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
                } else {
                    a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
                }
                return a;
            } else if (!com.baidu.sofire.b.e.a(context, false)) {
                com.baidu.sofire.b.a("gzfi checkComponent failed!");
                return "";
            } else {
                String b = com.baidu.sofire.b.e.b(context);
                if (TextUtils.isEmpty(b)) {
                    if (com.baidu.sofire.b.e.b(context.getPackageName())) {
                        return "";
                    }
                    com.baidu.sofire.b.a("gzfi invoke in main process");
                    return b(context, str, i, str2);
                } else if (com.baidu.sofire.b.e.b(b)) {
                    com.baidu.sofire.b.a("gzfi invoke in remote process");
                    Pair<Integer, Object> a2 = a(context, 0, "gzfi", (Class<?>[]) null, str, Integer.valueOf(i), str2);
                    if (a2 != null && ((Integer) a2.first).intValue() == 0) {
                        return (String) a2.second;
                    }
                    return "";
                } else {
                    com.baidu.sofire.b.a("gzfi invoke in provider process");
                    return b(context, str, i, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        return "";
    }

    private static String b(Context context, String str, int i, String str2) {
        if (i != 0) {
            if (TextUtils.isEmpty(str2)) {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
            } else {
                a(1, "ice", (Callback) null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
            }
        }
        return b(context);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0023 -> B:5:0x0011). Please submit an issue!!! */
    private static String b(Context context) {
        com.baidu.sofire.g gVar;
        String a2;
        byte[] re;
        try {
            gVar = new com.baidu.sofire.g(context);
            a2 = gVar.a();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        if (!TextUtils.isEmpty(a2)) {
            a = a2;
            return a2;
        }
        String b = gVar.b();
        if (!TextUtils.isEmpty(b)) {
            a = b;
            return b;
        }
        String a3 = com.baidu.sofire.b.g.a(context);
        if (!TextUtils.isEmpty(a3)) {
            String[] split = a3.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split == null || split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return a;
            }
            if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                String str = split[0] + com.baidu.sofire.b.e.a(re);
                gVar.a(str);
                a = str;
                return a;
            }
        }
        a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        return a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006f -> B:5:0x000a). Please submit an issue!!! */
    public static String a(Context context) {
        try {
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        if (!TextUtils.isEmpty(a)) {
            return a;
        } else if (!com.baidu.sofire.b.e.a(context, false)) {
            return "";
        } else {
            String b = com.baidu.sofire.b.e.b(context);
            if (TextUtils.isEmpty(b)) {
                if (com.baidu.sofire.b.e.b(context.getPackageName())) {
                    return "";
                }
                return b(context);
            } else if (com.baidu.sofire.b.e.b(b)) {
                com.baidu.sofire.b.a("gz invoke in remote process");
                Pair<Integer, Object> a2 = a(context, 0, "gz", (Class<?>[]) null, new Object[0]);
                if (a2 != null) {
                    if (((Integer) a2.first).intValue() == 0) {
                        return (String) a2.second;
                    }
                    return "";
                }
                a = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                return a;
            } else {
                com.baidu.sofire.b.a("gz invoke in provider process");
                return b(context);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0092 A[Catch: Throwable -> 0x00e1, TryCatch #3 {Throwable -> 0x0259, blocks: (B:3:0x0005, B:6:0x002b, B:24:0x00ee, B:27:0x00fb, B:61:0x020b, B:63:0x0216, B:65:0x0220, B:67:0x022b, B:72:0x0268, B:7:0x0033, B:9:0x004b, B:11:0x0051, B:12:0x0084, B:14:0x0092, B:20:0x00b8, B:17:0x009c, B:19:0x00a2, B:28:0x0100, B:30:0x0121, B:31:0x0126, B:33:0x0129, B:35:0x014a, B:37:0x0153, B:39:0x0159, B:40:0x0176, B:41:0x017a, B:47:0x019a, B:49:0x019f, B:51:0x01bb, B:52:0x01bf, B:54:0x01e8, B:56:0x01f9), top: B:75:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b8 A[Catch: Throwable -> 0x00e1, TRY_LEAVE, TryCatch #3 {Throwable -> 0x0259, blocks: (B:3:0x0005, B:6:0x002b, B:24:0x00ee, B:27:0x00fb, B:61:0x020b, B:63:0x0216, B:65:0x0220, B:67:0x022b, B:72:0x0268, B:7:0x0033, B:9:0x004b, B:11:0x0051, B:12:0x0084, B:14:0x0092, B:20:0x00b8, B:17:0x009c, B:19:0x00a2, B:28:0x0100, B:30:0x0121, B:31:0x0126, B:33:0x0129, B:35:0x014a, B:37:0x0153, B:39:0x0159, B:40:0x0176, B:41:0x017a, B:47:0x019a, B:49:0x019f, B:51:0x01bb, B:52:0x01bf, B:54:0x01e8, B:56:0x01f9), top: B:75:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle a(Context context, String str, String str2, Bundle bundle) {
        String str3;
        Integer num;
        String str4;
        String b;
        final Bundle bundle2 = new Bundle();
        try {
            com.baidu.sofire.b.a("Try to invoke method " + str);
            if ("gzfi".equals(str)) {
                if (bundle != null) {
                    c cVar = new c();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    c cVar2 = (c) bundle.getParcelable("args");
                    if (cVar2 != null) {
                        if (cVar2.e.length == 2) {
                            str4 = (String) cVar2.e[0];
                            Integer num2 = (Integer) cVar2.e[1];
                            com.baidu.sofire.b.a("args " + str4 + " " + num2);
                            num = num2;
                            str3 = null;
                        } else if (cVar2.e.length == 3) {
                            str4 = (String) cVar2.e[0];
                            num = (Integer) cVar2.e[1];
                            str3 = (String) cVar2.e[2];
                        }
                        b = b(context, str4, num.intValue(), str3);
                        if (!TextUtils.isEmpty(b)) {
                            bundle2.putInt("status", 8);
                        } else {
                            cVar.f = b;
                            com.baidu.sofire.b.a("gzfi return zid: " + cVar.f);
                            bundle2.putParcelable("result", cVar);
                            bundle2.putInt("status", 0);
                        }
                        return bundle2;
                    }
                    str3 = null;
                    num = null;
                    str4 = null;
                    b = b(context, str4, num.intValue(), str3);
                    if (!TextUtils.isEmpty(b)) {
                    }
                    return bundle2;
                }
            } else if ("invokeMethod".equals(str)) {
                if (bundle != null) {
                    final c cVar3 = new c();
                    bundle.setClassLoader(MyProvider.class.getClassLoader());
                    c cVar4 = (c) bundle.getParcelable("args");
                    int i = cVar4.a;
                    int i2 = cVar4.b;
                    final String str5 = cVar4.c;
                    Object[] objArr = cVar4.d;
                    Class[] clsArr = null;
                    if (objArr != null) {
                        Class[] clsArr2 = new Class[objArr.length];
                        for (int i3 = 0; i3 < objArr.length; i3++) {
                            String str6 = (String) objArr[i3];
                            com.baidu.sofire.b.a("get class name " + str6);
                            if (!TextUtils.isEmpty(str6) && str6.contains("@@")) {
                                Class<?> a2 = com.baidu.sofire.b.e.a(str6);
                                if (a2 != null) {
                                    com.baidu.sofire.b.a("convert back class name " + a2.getCanonicalName());
                                    clsArr2[i3] = a2;
                                }
                            } else {
                                clsArr2[i3] = Class.forName((String) objArr[i3]);
                            }
                        }
                        clsArr = clsArr2;
                    }
                    Object[] objArr2 = cVar4.e;
                    if (i2 == 1) {
                        Pair<Integer, Object> a3 = a(i, str5, clsArr, objArr2);
                        bundle2.putInt("status", ((Integer) a3.first).intValue());
                        if (((Integer) a3.first).intValue() == 0) {
                            cVar3.f = a3.second;
                        }
                    } else if (i2 == 0) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        a(i, str5, new Callback() { // from class: com.baidu.sofire.core.e.2
                            @Override // com.baidu.sofire.ac.Callback
                            public Object onEnd(Object... objArr3) {
                                try {
                                    bundle2.putInt("status", 0);
                                    cVar3.f = objArr3[0];
                                    return null;
                                } catch (Throwable th) {
                                    try {
                                        com.baidu.sofire.b.e.a(th);
                                        return null;
                                    } finally {
                                        countDownLatch.countDown();
                                    }
                                }
                            }

                            @Override // com.baidu.sofire.ac.Callback
                            public Object onError(Object... objArr3) {
                                try {
                                    bundle2.putInt("status", ((Integer) objArr3[0]).intValue());
                                    com.baidu.sofire.b.a(str5 + "onError " + String.valueOf(objArr3[0]));
                                    return null;
                                } catch (Throwable th) {
                                    try {
                                        com.baidu.sofire.b.e.a(th);
                                        return null;
                                    } finally {
                                        countDownLatch.countDown();
                                    }
                                }
                            }
                        }, clsArr, objArr2);
                        countDownLatch.await(180000L, TimeUnit.MILLISECONDS);
                    }
                    com.baidu.sofire.b.a("return bundle" + bundle2.getInt("status"));
                    bundle2.putParcelable("result", cVar3);
                    return bundle2;
                }
            } else if ("gz".equals(str)) {
                String b2 = b(context);
                if (TextUtils.isEmpty(b2)) {
                    bundle2.putInt("status", 8);
                } else {
                    c cVar5 = new c();
                    cVar5.f = b2;
                    com.baidu.sofire.b.a("gz return zid: " + cVar5.f);
                    bundle2.putParcelable("result", cVar5);
                    bundle2.putInt("status", 0);
                }
                return bundle2;
            } else {
                bundle2.putInt("status", 2);
                return bundle2;
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        bundle2.putInt("status", 10);
        return bundle2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.sofire.core.e$3] */
    private static void a(final Context context, final int i, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            if (TextUtils.isEmpty(str)) {
                if (callback != null) {
                    callback.onError(1);
                }
            } else {
                new Thread() { // from class: com.baidu.sofire.core.e.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        super.run();
                        if (Callback.this != null) {
                            Callback.this.onBegin(new Object[0]);
                        }
                        Pair b = e.b(context, i, 0, str, clsArr, objArr);
                        if (Callback.this != null) {
                            if (((Integer) b.first).intValue() != 0) {
                                Callback.this.onError(b.first);
                            } else {
                                Callback.this.onEnd(b.second);
                            }
                        }
                    }
                }.start();
            }
        } catch (Throwable th) {
            if (callback != null) {
                try {
                    callback.onError(3);
                } catch (Throwable th2) {
                }
            }
            com.baidu.sofire.b.e.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<Integer, Object> b(Context context, int i, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        Bundle bundle;
        try {
            if (TextUtils.isEmpty(str)) {
                return Pair.create(1, null);
            }
            String str2 = ("gzfi".equals(str) || "gz".equals(str)) ? str : "invokeMethod";
            c cVar = new c();
            cVar.a = i;
            cVar.c = str;
            cVar.b = i2;
            if (clsArr != null) {
                Object[] objArr2 = new Object[clsArr.length];
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    if (clsArr[i3].isPrimitive()) {
                        String a2 = com.baidu.sofire.b.e.a(clsArr[i3]);
                        if (!TextUtils.isEmpty(a2)) {
                            objArr2[i3] = a2 + "@@";
                        }
                    } else {
                        objArr2[i3] = clsArr[i3].getCanonicalName();
                    }
                }
                cVar.d = objArr2;
            }
            cVar.e = objArr;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("args", cVar);
            StringBuilder sb = new StringBuilder("content://");
            sb.append(context.getPackageName()).append(".").append("sofire").append(".ac.provider");
            Uri parse = Uri.parse(sb.toString());
            Bundle bundle3 = null;
            if (Build.VERSION.SDK_INT >= 11) {
                bundle = context.getContentResolver().call(parse, str2, (String) null, bundle2);
            } else {
                com.baidu.sofire.b.a("callRemoteMethod running in api < 11!");
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return Pair.create(3, null);
                }
                Field declaredField = ContentProviderClient.class.getDeclaredField("mContentProvider");
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(acquireContentProviderClient);
                if (obj != null) {
                    Method declaredMethod = Class.forName("android.content.IContentProvider").getDeclaredMethod(NotificationCompat.CATEGORY_CALL, String.class, String.class, Bundle.class);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    bundle3 = (Bundle) declaredMethod.invoke(obj, str2, null, bundle2);
                }
                acquireContentProviderClient.release();
                bundle = bundle3;
            }
            if (bundle == null) {
                return Pair.create(3, null);
            }
            bundle.setClassLoader(c.class.getClassLoader());
            int i4 = bundle.getInt("status");
            c cVar2 = null;
            com.baidu.sofire.b.a("bundleResult return " + i4);
            if (i4 == 0) {
                cVar2 = (c) bundle.getParcelable("result");
            }
            return Pair.create(Integer.valueOf(i4), cVar2 == null ? null : cVar2.f);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return Pair.create(3, null);
        }
    }

    private static Pair<Integer, Object> a(Context context, int i, String str, Class<?>[] clsArr, Object... objArr) {
        return b(context, i, 1, str, clsArr, objArr);
    }
}
