package com.baidu.android.defense.push;

import android.content.Context;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends h {
    public c(String str, Context context) {
        super(str, context);
    }

    @Override // com.baidu.android.defense.push.h, com.baidu.android.defense.push.a
    public boolean a() {
        if (this.b) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                com.baidu.android.defense.a.c.a().a(new com.baidu.android.defense.a.a(this.c, (com.baidu.android.defense.a.b) it.next()));
            }
            return true;
        }
        return false;
    }
}
