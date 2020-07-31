package com.baidu.minivideo.arface.utils;

import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes6.dex */
public class ThreadPool {

    /* loaded from: classes6.dex */
    private enum QueueProcessingType {
        FIFO,
        LIFO
    }

    /* loaded from: classes6.dex */
    private static class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
        private static final long serialVersionUID = -4114786347960826192L;

        private LIFOLinkedBlockingDeque() {
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            return super.offerFirst(t);
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
        public T remove() {
            return (T) super.removeFirst();
        }
    }
}
