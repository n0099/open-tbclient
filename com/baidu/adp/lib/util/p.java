package com.baidu.adp.lib.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
abstract class p implements Iterator<E> {
    s<E> nB;
    private s<E> nC;
    final /* synthetic */ BlockingLinkedDeque nD;
    E nextItem;

    abstract s<E> c(s<E> sVar);

    abstract s<E> fz();

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: E */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public p(BlockingLinkedDeque blockingLinkedDeque) {
        this.nD = blockingLinkedDeque;
        ReentrantLock reentrantLock = blockingLinkedDeque.lock;
        reentrantLock.lock();
        try {
            this.nB = fz();
            this.nextItem = this.nB == null ? 0 : this.nB.item;
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
    private s<E> d(s<E> sVar) {
        Object obj;
        while (true) {
            s<E> c = c(obj);
            if (c == 0) {
                return null;
            }
            if (c.item == 0) {
                if (c == obj) {
                    return fz();
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
        ReentrantLock reentrantLock = this.nD.lock;
        reentrantLock.lock();
        try {
            this.nB = d(this.nB);
            this.nextItem = this.nB == null ? 0 : this.nB.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nB != null;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.nB == null) {
            throw new NoSuchElementException();
        }
        this.nC = this.nB;
        E e = this.nextItem;
        advance();
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        s<E> sVar = this.nC;
        if (sVar == 0) {
            throw new IllegalStateException();
        }
        this.nC = null;
        ReentrantLock reentrantLock = this.nD.lock;
        reentrantLock.lock();
        try {
            if (sVar.item != 0) {
                this.nD.unlink(sVar);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
