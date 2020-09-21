package com.android.support.appcompat.storage.permission;

import com.android.support.appcompat.storage.b;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    private static volatile a Hp;
    private HashMap<String, b> Hq = new HashMap<>();

    public static a le() {
        if (Hp == null) {
            synchronized (a.class) {
                if (Hp == null) {
                    Hp = new a();
                }
            }
        }
        return Hp;
    }

    public void bo(String str) {
        if (this.Hq.containsKey(str)) {
            this.Hq.remove(str);
        }
    }

    public b bp(String str) {
        if (this.Hq.containsKey(str)) {
            return this.Hq.get(str);
        }
        return null;
    }
}
