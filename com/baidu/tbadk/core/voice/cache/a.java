package com.baidu.tbadk.core.voice.cache;

import android.content.Context;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class a {
    private LinkedList<String> a = new LinkedList<>();
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    public final String a(String str, String str2, c cVar) {
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        d a = f.a().a(this.b, str, str2, new b(this, cVar));
        if (a == null) {
            return null;
        }
        return a.b;
    }

    public final void a() {
        if (this.a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    String str = this.a.get(i2);
                    if (str != null) {
                        f.a().a(this.b, str);
                    }
                    i = i2 + 1;
                } else {
                    this.a.clear();
                    return;
                }
            }
        }
    }
}
