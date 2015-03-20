package com.baidu.adp.lib.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
abstract class r implements Iterator<E> {
    E nextItem;
    u<E> yY;
    private u<E> yZ;
    final /* synthetic */ BlockingLinkedDeque za;

    abstract u<E> c(u<E> uVar);

    abstract u<E> jc();

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: E */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public r(BlockingLinkedDeque blockingLinkedDeque) {
        this.za = blockingLinkedDeque;
        ReentrantLock reentrantLock = blockingLinkedDeque.lock;
        reentrantLock.lock();
        try {
            this.yY = jc();
            this.nextItem = this.yY == null ? 0 : this.yY.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private u<E> d(u<E> uVar) {
        Object obj;
        while (true) {
            u<E> c = c(obj);
            if (c == 0) {
                return null;
            }
            if (c.item == 0) {
                if (c == obj) {
                    return jc();
                }
                obj = c;
            } else {
                return c;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    void advance() {
        ReentrantLock reentrantLock = this.za.lock;
        reentrantLock.lock();
        try {
            this.yY = d(this.yY);
            this.nextItem = this.yY == null ? 0 : this.yY.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.yY != null;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.yY == null) {
            throw new NoSuchElementException();
        }
        this.yZ = this.yY;
        E e = this.nextItem;
        advance();
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        u<E> uVar = this.yZ;
        if (uVar == 0) {
            throw new IllegalStateException();
        }
        this.yZ = null;
        ReentrantLock reentrantLock = this.za.lock;
        reentrantLock.lock();
        try {
            if (uVar.item != 0) {
                this.za.unlink(uVar);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
