package com.baidu.android.defense.push;

import android.content.Context;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h extends a {
    public h(String str, Context context) {
        super(str, context);
    }

    @Override // com.baidu.android.defense.push.a, com.baidu.android.defense.push.i
    public boolean b() {
        if (this.c) {
            if (this.a != null) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    com.baidu.android.defense.b.e.a(this.d).a(this.d, ((com.baidu.android.defense.b.c) it.next()).a());
                }
            }
            return true;
        }
        return false;
    }
}
