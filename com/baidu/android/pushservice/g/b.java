package com.baidu.android.pushservice.g;

import java.util.concurrent.PriorityBlockingQueue;
/* loaded from: classes2.dex */
public class b<E> extends PriorityBlockingQueue<E> {
    private static final String a = b.class.getSimpleName();

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        try {
            if (size() >= 20) {
                return false;
            }
            return super.offer(e);
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.a(a, e2);
            return false;
        }
    }
}
