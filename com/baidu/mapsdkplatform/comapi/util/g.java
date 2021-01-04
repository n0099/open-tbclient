package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f3221a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3222b = false;
    private boolean c = true;
    private final List<f> d = new ArrayList();
    private f e = null;

    private g() {
    }

    public static g a() {
        if (f3221a == null) {
            synchronized (g.class) {
                if (f3221a == null) {
                    f3221a = new g();
                }
            }
        }
        return f3221a;
    }

    private boolean a(String str) {
        boolean z = false;
        try {
            File file = new File(str + "/test.0");
            if (file.exists()) {
                file.delete();
            }
            z = file.createNewFile();
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public void a(Context context) {
        int i = 0;
        if (this.f3222b) {
            return;
        }
        this.f3222b = true;
        try {
            this.c = false;
            this.e = new f(context);
            this.d.clear();
            this.d.add(this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d.size() > 0) {
                f fVar = null;
                for (f fVar2 : this.d) {
                    if (new File(fVar2.b()).exists()) {
                        i++;
                    } else {
                        fVar2 = fVar;
                    }
                    fVar = fVar2;
                }
                if (i == 0) {
                    this.e = b(context);
                    if (this.e == null) {
                        Iterator<f> it = this.d.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            f next = it.next();
                            if (a(context, next)) {
                                this.e = next;
                                break;
                            }
                        }
                    }
                } else if (i != 1) {
                    this.e = b(context);
                } else if (a(context, fVar)) {
                    this.e = fVar;
                }
                if (this.e == null) {
                    this.e = this.d.get(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.e == null || !a(this.e.a())) {
                this.c = false;
                this.e = new f(context);
                this.d.clear();
                this.d.add(this.e);
                return;
            }
            File file = new File(this.e.b());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(this.e.c());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, ".nomedia");
            if (file3.exists()) {
                return;
            }
            file3.createNewFile();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public boolean a(Context context, f fVar) {
        String a2 = fVar.a();
        if (a(a2)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("map_pref", 0).edit();
            edit.putString("PREFFERED_SD_CARD", a2);
            return edit.commit();
        }
        return false;
    }

    public f b() {
        return this.e;
    }

    public f b(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string != null && string.length() > 0) {
            for (f fVar : this.d) {
                if (fVar.a().equals(string)) {
                    return fVar;
                }
            }
        }
        return null;
    }
}
