package com.baidu.sumeru.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public interface BlockingDeque<E> extends Deque<E>, BlockingQueue<E> {
    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Queue, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean add(E e);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    void addFirst(E e);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    void addLast(E e);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean contains(Object obj);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Queue
    E element();

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Queue
    E peek();

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e) throws InterruptedException;

    void putFirst(E e) throws InterruptedException;

    void putLast(E e) throws InterruptedException;

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Queue
    E remove();

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Collection, java.util.concurrent.BlockingQueue
    boolean remove(Object obj);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // com.baidu.sumeru.universalimageloader.core.assist.deque.Deque, java.util.Collection
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
