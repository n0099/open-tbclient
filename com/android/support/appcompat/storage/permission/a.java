package com.android.support.appcompat.storage.permission;

import com.android.support.appcompat.storage.b;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class a {
    private static volatile a HF;
    private HashMap<String, b> HG = new HashMap<>();

    public static a lf() {
        if (HF == null) {
            synchronized (a.class) {
                if (HF == null) {
                    HF = new a();
                }
            }
        }
        return HF;
    }

    public void bo(String str) {
        if (this.HG.containsKey(str)) {
            this.HG.remove(str);
        }
    }

    public b bp(String str) {
        if (this.HG.containsKey(str)) {
            return this.HG.get(str);
        }
        return null;
    }
}
