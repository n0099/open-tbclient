package com.baidu.android.defense.push;

import android.content.Context;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l extends g {
    public l(String str, Context context) {
        super(str, context);
    }

    @Override // com.baidu.android.defense.push.g, com.baidu.android.defense.push.i
    public boolean b() {
        if (this.c) {
            Iterator it = this.f246a.iterator();
            while (it.hasNext()) {
                com.baidu.android.defense.a.b.a().a(new com.baidu.android.defense.a.d(this.d, (com.baidu.android.defense.a.c) it.next()));
            }
            return true;
        }
        return false;
    }
}
