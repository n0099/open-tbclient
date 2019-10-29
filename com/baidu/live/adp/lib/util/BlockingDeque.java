package com.baidu.live.adp.lib.util;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public interface BlockingDeque<E> extends Deque<E>, BlockingQueue<E> {
    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e);

    @Override // com.baidu.live.adp.lib.util.Deque
    void addFirst(E e);

    @Override // com.baidu.live.adp.lib.util.Deque
    void addLast(E e);

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Queue
    E element();

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.live.adp.lib.util.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.live.adp.lib.util.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Queue
    E peek();

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.live.adp.lib.util.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e) throws InterruptedException;

    void putFirst(E e) throws InterruptedException;

    void putLast(E e) throws InterruptedException;

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Queue
    E remove();

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.baidu.live.adp.lib.util.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.baidu.live.adp.lib.util.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // com.baidu.live.adp.lib.util.Deque, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
