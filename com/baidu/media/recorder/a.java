package com.baidu.media.recorder;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, Integer> f3214a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f3215b = 4;

    static {
        f3214a.put(2, 256);
        f3214a.put(4, 8);
        f3214a.put(8, 286);
        f3214a.put(16, 294);
        f3214a.put(32, 326);
        f3214a.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        f3214a.put(128, 326);
        f3214a.put(256, 20);
    }

    public int a() {
        return this.f3215b;
    }

    public int a(int i) {
        if (this.f3215b == i) {
            return 0;
        }
        if (i != (f3214a.get(Integer.valueOf(this.f3215b)).intValue() & i)) {
            return -1;
        }
        this.f3215b = i;
        return 1;
    }
}
