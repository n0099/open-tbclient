package com.baidu.adp.lib.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
abstract class s implements Iterator<E> {
    E nextItem;
    v<E> yN;
    private v<E> yO;
    final /* synthetic */ BlockingLinkedDeque yP;

    abstract v<E> c(v<E> vVar);

    abstract v<E> jt();

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: E */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public s(BlockingLinkedDeque blockingLinkedDeque) {
        this.yP = blockingLinkedDeque;
        ReentrantLock reentrantLock = blockingLinkedDeque.lock;
        reentrantLock.lock();
        try {
            this.yN = jt();
            this.nextItem = this.yN == null ? 0 : this.yN.item;
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
    private v<E> d(v<E> vVar) {
        Object obj;
        while (true) {
            v<E> c = c(obj);
            if (c == 0) {
                return null;
            }
            if (c.item == 0) {
                if (c == obj) {
                    return jt();
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
        ReentrantLock reentrantLock = this.yP.lock;
        reentrantLock.lock();
        try {
            this.yN = d(this.yN);
            this.nextItem = this.yN == null ? 0 : this.yN.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.yN != null;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.yN == null) {
            throw new NoSuchElementException();
        }
        this.yO = this.yN;
        E e = this.nextItem;
        advance();
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        v<E> vVar = this.yO;
        if (vVar == 0) {
            throw new IllegalStateException();
        }
        this.yO = null;
        ReentrantLock reentrantLock = this.yP.lock;
        reentrantLock.lock();
        try {
            if (vVar.item != 0) {
                this.yP.unlink(vVar);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
