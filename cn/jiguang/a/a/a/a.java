package cn.jiguang.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class a {
    private HashMap<String, Long> a = null;
    private File d = null;
    private static a kr = null;
    private static final Object c = new Object();

    private a() {
    }

    public static long a(Context context) {
        return cn.jiguang.a.b.a.c(context);
    }

    private void b(Context context) {
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        if (this.d != null || context == null) {
            return;
        }
        this.d = new File(context.getCacheDir(), "ArpCache");
        try {
            if (this.d == null || this.a == null || !this.d.exists()) {
                return;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.d));
            this.a = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
        }
    }

    public static a bm() {
        if (kr == null) {
            synchronized (c) {
                kr = new a();
            }
        }
        return kr;
    }

    public final void a(Context context, String str) {
        b(context);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.put(cn.jiguang.g.a.a(str), Long.valueOf(System.currentTimeMillis()));
        try {
            if (this.d == null || this.a == null) {
                return;
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.d));
            objectOutputStream.writeObject(this.a);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
        }
    }

    public final boolean b(Context context, String str) {
        b(context);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Long l = this.a.get(cn.jiguang.g.a.a(str));
        if (l == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = l.longValue();
        long c2 = cn.jiguang.a.b.a.c(context);
        return c2 != 0 && Math.abs(currentTimeMillis - longValue) > c2;
    }
}
