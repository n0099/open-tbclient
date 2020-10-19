package com.baidu.media.recorder;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, Integer> f2263a = new HashMap();
    private int b = 4;

    static {
        f2263a.put(2, 256);
        f2263a.put(4, 8);
        f2263a.put(8, 286);
        f2263a.put(16, 294);
        f2263a.put(32, 326);
        f2263a.put(64, Integer.valueOf((int) HttpStatus.SC_UNPROCESSABLE_ENTITY));
        f2263a.put(128, 326);
        f2263a.put(256, 20);
    }

    public int a() {
        return this.b;
    }

    public int a(int i) {
        if (this.b == i) {
            return 0;
        }
        if (i != (f2263a.get(Integer.valueOf(this.b)).intValue() & i)) {
            return -1;
        }
        this.b = i;
        return 1;
    }
}
