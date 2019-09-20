package com.baidu.media.recorder;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class a {
    private static Map<Integer, Integer> a = new HashMap();
    private int b = 4;

    static {
        a.put(2, 256);
        a.put(4, 8);
        a.put(8, 286);
        a.put(16, 294);
        a.put(32, 326);
        a.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        a.put(128, 326);
        a.put(256, 20);
    }

    public int a() {
        return this.b;
    }

    public int a(int i) {
        if (this.b == i) {
            return 0;
        }
        if (i != (a.get(Integer.valueOf(this.b)).intValue() & i)) {
            return -1;
        }
        this.b = i;
        return 1;
    }
}
