package com.baidu.android.defense.push;

import android.content.Context;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends c {
    public f(String str, Context context) {
        super(str, context);
    }

    @Override // com.baidu.android.defense.push.c, com.baidu.android.defense.push.n
    public boolean b() {
        if (this.c) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                com.baidu.android.defense.a.d.a().a(new com.baidu.android.defense.a.b(this.d, (com.baidu.android.defense.a.a) it.next()));
            }
            return true;
        }
        return false;
    }
}
