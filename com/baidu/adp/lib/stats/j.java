package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, e eVar) {
        this.b = hVar;
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String a;
        String str2;
        ArrayList<String> b;
        String f;
        try {
            if (this.a.c() == null || !this.a.c().equals("omp")) {
                a = this.b.a(true);
                str2 = a;
            } else {
                f = this.b.f();
                str2 = f;
            }
            if (this.a.d()) {
                ArrayList<String> j = this.a.j();
                this.a.k();
                ArrayList<String> a2 = this.a.a(j);
                if (a2 != null && a2.size() > 0) {
                    this.b.a(this.a, str2, a2, (String) null);
                }
            } else {
                ArrayList<String> b2 = this.a.b();
                if (b2 != null && b2.size() > 0) {
                    Iterator<String> it = b2.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            b = this.b.b(next);
                            ArrayList<String> a3 = this.a.a(b);
                            if (a3 != null && a3.size() != 0) {
                                this.b.a(this.a, str2, a3, next);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "upload", e);
        }
        this.a.e(false);
        this.a.a();
        e eVar = this.a;
        str = this.b.g;
        eVar.a(str);
    }
}
