package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Dq;
    private d Dr;
    private ArrayList<c> Ds = new ArrayList<>();
    private b Dt;

    private a() {
    }

    public static a lm() {
        if (Dq == null) {
            synchronized (a.class) {
                if (Dq == null) {
                    Dq = new a();
                }
            }
        }
        return Dq;
    }

    public void a(ArrayList<c> arrayList, d dVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Dr = dVar;
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<c> it2 = this.Ds.iterator();
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
                        this.Ds.add(next);
                    }
                }
            }
            ln();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln() {
        if (this.Ds.size() != 0 && this.Dt == null) {
            this.Dt = new b(this, this.Ds.get(0));
            this.Dt.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(c cVar, c cVar2) {
        return (cVar == null || cVar2 == null || TextUtils.isEmpty(cVar2.apkPath) || TextUtils.isEmpty(cVar2.packageName) || TextUtils.isEmpty(cVar.apkPath) || TextUtils.isEmpty(cVar.packageName) || !cVar2.packageName.equals(cVar.packageName) || !cVar2.apkPath.equals(cVar.apkPath)) ? false : true;
    }
}
