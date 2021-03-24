package com.baidu.crabsdk.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public final class p extends n {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f4663f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f4664d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4665e;

    public p(Thread thread, int i, long j) {
        super(j);
        this.f4664d = a.f4643h;
        this.f4665e = thread;
        this.f4664d = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.f4643h, j);
    }

    public static ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f4663f) {
            for (Long l : f4663f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(f4663f.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.b("result : " + arrayList.toString());
        return arrayList;
    }

    @Override // com.baidu.crabsdk.a.n
    public final void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f4665e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f4663f) {
            if (f4663f.size() == this.f4664d && this.f4664d > 0) {
                f4663f.remove(f4663f.keySet().iterator().next());
            }
            f4663f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
