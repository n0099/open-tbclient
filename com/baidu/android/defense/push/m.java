package com.baidu.android.defense.push;

import android.content.Context;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m extends h {
    public m(String str, Context context) {
        super(str, context);
    }

    @Override // com.baidu.android.defense.push.h, com.baidu.android.defense.push.n
    public boolean b() {
        if (this.c) {
            if (this.a != null) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    com.baidu.android.defense.pkgmanager.d.a(this.d).a(this.d, ((com.baidu.android.defense.pkgmanager.c) it.next()).a());
                }
            }
            return true;
        }
        return false;
    }
}
