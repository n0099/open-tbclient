package com.android.support.appcompat.storage.permission;

import com.android.support.appcompat.storage.b;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {
    private static volatile a Iz;
    private HashMap<String, b> IB = new HashMap<>();

    public static a lf() {
        if (Iz == null) {
            synchronized (a.class) {
                if (Iz == null) {
                    Iz = new a();
                }
            }
        }
        return Iz;
    }

    public void br(String str) {
        if (this.IB.containsKey(str)) {
            this.IB.remove(str);
        }
    }

    public b bs(String str) {
        if (this.IB.containsKey(str)) {
            return this.IB.get(str);
        }
        return null;
    }
}
