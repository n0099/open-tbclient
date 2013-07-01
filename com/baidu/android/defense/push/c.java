package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.systemmonitor.localapp.AppManager;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends a {
    public c(String str, Context context) {
        super(str, context);
    }

    private boolean a(com.baidu.android.defense.b.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.a())) {
            return false;
        }
        com.baidu.android.systemmonitor.localapp.a aVar = (com.baidu.android.systemmonitor.localapp.a) AppManager.a(this.d).a().get(cVar.a());
        if (aVar == null || (cVar.b() != 0 && aVar.f != cVar.b())) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.android.defense.push.a, com.baidu.android.defense.push.i
    public boolean b() {
        if (this.c) {
            if (this.f241a != null) {
                Iterator it = this.f241a.iterator();
                while (it.hasNext()) {
                    com.baidu.android.defense.b.c cVar = (com.baidu.android.defense.b.c) it.next();
                    if (a(cVar)) {
                        com.baidu.android.defense.b.e.a(this.d).a(false, cVar);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
