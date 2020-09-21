package com.baidu.sumeru.universalimageloader.core.assist.deque;
/* loaded from: classes9.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, com.baidu.sumeru.universalimageloader.core.assist.deque.BlockingDeque, com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean offer(T t) {
        return super.offerFirst(t);
    }

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, com.baidu.sumeru.universalimageloader.core.assist.deque.BlockingDeque, com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    public T remove() {
        return (T) super.removeFirst();
    }
}
