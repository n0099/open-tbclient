package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Dh;
    private d Di;
    private ArrayList<c> Dj = new ArrayList<>();
    private b Dk;

    private a() {
    }

    public static a lG() {
        if (Dh == null) {
            synchronized (a.class) {
                if (Dh == null) {
                    Dh = new a();
                }
            }
        }
        return Dh;
    }

    public void a(ArrayList<c> arrayList, d dVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Di = dVar;
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<c> it2 = this.Dj.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        } else if (a(it2.next(), next)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.Dj.add(next);
                    }
                }
            }
            lH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH() {
        if (this.Dj.size() != 0 && this.Dk == null) {
            this.Dk = new b(this, this.Dj.get(0));
            this.Dk.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, c cVar2) {
        return (cVar == null || cVar2 == null || TextUtils.isEmpty(cVar2.apkPath) || TextUtils.isEmpty(cVar2.packageName) || TextUtils.isEmpty(cVar.apkPath) || TextUtils.isEmpty(cVar.packageName) || !cVar2.packageName.equals(cVar.packageName) || !cVar2.apkPath.equals(cVar.apkPath)) ? false : true;
    }
}
