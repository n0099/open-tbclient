package com.baidu.crabsdk.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class p extends n {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f4664f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f4665d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f4666e;

    public p(Thread thread, int i2, long j) {
        super(j);
        this.f4665d = a.f4643h;
        this.f4666e = thread;
        this.f4665d = i2;
    }

    public p(Thread thread, long j) {
        this(thread, a.f4643h, j);
    }

    public static ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f4664f) {
            for (Long l : f4664f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(f4664f.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.b("result : " + arrayList.toString());
        return arrayList;
    }

    @Override // com.baidu.crabsdk.a.n
    public final void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f4666e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f4664f) {
            if (f4664f.size() == this.f4665d && this.f4665d > 0) {
                f4664f.remove(f4664f.keySet().iterator().next());
            }
            f4664f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
