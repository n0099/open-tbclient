package com.baidu.crabsdk.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class p extends n {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f4810f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f4811d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4812e;

    public p(Thread thread, int i2, long j) {
        super(j);
        this.f4811d = a.f4789h;
        this.f4812e = thread;
        this.f4811d = i2;
    }

    public p(Thread thread, long j) {
        this(thread, a.f4789h, j);
    }

    public static ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f4810f) {
            for (Long l : f4810f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(f4810f.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.b("result : " + arrayList.toString());
        return arrayList;
    }

    @Override // com.baidu.crabsdk.a.n
    public final void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f4812e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f4810f) {
            if (f4810f.size() == this.f4811d && this.f4811d > 0) {
                f4810f.remove(f4810f.keySet().iterator().next());
            }
            f4810f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
