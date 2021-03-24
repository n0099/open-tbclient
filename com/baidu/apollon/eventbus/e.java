package com.baidu.apollon.eventbus;

import java.util.LinkedList;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<d> f3617a = new LinkedList<>();

    public synchronized void a(d dVar) {
        if (dVar != null) {
            this.f3617a.offer(dVar);
            notifyAll();
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized d a() {
        return this.f3617a.poll();
    }

    public synchronized d a(int i) throws InterruptedException {
        d a2;
        a2 = a();
        if (a2 == null) {
            wait(i);
            a2 = a();
        }
        return a2;
    }
}
