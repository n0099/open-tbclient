package com.baidu.android.defense.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.systemmonitor.localapp.AppManager;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends f {
    public e(String str, Context context) {
        super(str, context);
    }

    private boolean a(com.baidu.android.defense.b.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a())) {
            return false;
        }
        com.baidu.android.systemmonitor.localapp.a aVar2 = (com.baidu.android.systemmonitor.localapp.a) AppManager.a(this.c).a().get(aVar.a());
        if (aVar2 == null || (aVar.b() != 0 && aVar2.f != aVar.b())) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.android.defense.push.f, com.baidu.android.defense.push.a
    public boolean a() {
        if (this.b) {
            if (this.d != null) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    com.baidu.android.defense.b.a aVar = (com.baidu.android.defense.b.a) it.next();
                    if (a(aVar)) {
                        com.baidu.android.defense.b.b.a(this.c).a(this.c, aVar.a());
                    }
                }
            }
            return true;
        }
        return false;
    }
}
