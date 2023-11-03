package com.baidu.android.pushservice.z;

import java.util.concurrent.PriorityBlockingQueue;
/* loaded from: classes.dex */
public class b<E> extends PriorityBlockingQueue<E> {
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        try {
            if (size() >= 20) {
                return false;
            }
            return super.offer(e);
        } catch (Exception unused) {
            return false;
        }
    }
}
