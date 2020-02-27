package com.baidu.android.pushservice.h;

import java.util.concurrent.PriorityBlockingQueue;
/* loaded from: classes8.dex */
public class b<E> extends PriorityBlockingQueue<E> {
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        try {
            if (size() >= 20) {
                return false;
            }
            return super.offer(e);
        } catch (Exception e2) {
            return false;
        }
    }
}
