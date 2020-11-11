package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f2252a = null;
    private boolean b = false;
    private boolean c = true;
    private final List<f> d = new ArrayList();
    private f e = null;

    private g() {
    }

    public static g a() {
        if (f2252a == null) {
            synchronized (g.class) {
                if (f2252a == null) {
                    f2252a = new g();
                }
            }
        }
        return f2252a;
    }

    private boolean a(String str) {
        boolean z;
        Exception e;
        try {
            File file = new File(str + "/test.0");
            if (file.exists()) {
                file.delete();
            }
            z = file.createNewFile();
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            z = false;
            e = e3;
        }
        return z;
    }

    public void a(Context context) {
        int i;
        f fVar;
        int i2 = 0;
        if (this.b) {
            return;
        }
        this.b = true;
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
                f fVar2 = null;
                for (f fVar3 : this.d) {
                    if (new File(fVar3.b()).exists()) {
                        int i3 = i2 + 1;
                        fVar = fVar3;
                        i = i3;
                    } else {
                        i = i2;
                        fVar = fVar2;
                    }
                    fVar2 = fVar;
                    i2 = i;
                }
                if (i2 == 0) {
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
                } else if (i2 != 1) {
                    this.e = b(context);
                } else if (a(context, fVar2)) {
                    this.e = fVar2;
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
