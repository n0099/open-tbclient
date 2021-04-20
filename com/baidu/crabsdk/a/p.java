package com.baidu.crabsdk.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class p extends n {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f4699f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f4700d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4701e;

    public p(Thread thread, int i, long j) {
        super(j);
        this.f4700d = a.f4679h;
        this.f4701e = thread;
        this.f4700d = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.f4679h, j);
    }

    public static ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f4699f) {
            for (Long l : f4699f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(f4699f.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.b("result : " + arrayList.toString());
        return arrayList;
    }

    @Override // com.baidu.crabsdk.a.n
    public final void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f4701e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f4699f) {
            if (f4699f.size() == this.f4700d && this.f4700d > 0) {
                f4699f.remove(f4699f.keySet().iterator().next());
            }
            f4699f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
