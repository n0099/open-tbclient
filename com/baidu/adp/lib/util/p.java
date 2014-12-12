package com.baidu.adp.lib.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
abstract class p implements Iterator<E> {
    final /* synthetic */ BlockingLinkedDeque nA;
    E nextItem;
    s<E> ny;
    private s<E> nz;

    abstract s<E> c(s<E> sVar);

    abstract s<E> fA();

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: E */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public p(BlockingLinkedDeque blockingLinkedDeque) {
        this.nA = blockingLinkedDeque;
        ReentrantLock reentrantLock = blockingLinkedDeque.lock;
        reentrantLock.lock();
        try {
            this.ny = fA();
            this.nextItem = this.ny == null ? 0 : this.ny.item;
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
                    return fA();
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
        ReentrantLock reentrantLock = this.nA.lock;
        reentrantLock.lock();
        try {
            this.ny = d(this.ny);
            this.nextItem = this.ny == null ? 0 : this.ny.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.ny != null;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.ny == null) {
            throw new NoSuchElementException();
        }
        this.nz = this.ny;
        E e = this.nextItem;
        advance();
        return e;
    }

    @Override // java.util.Iterator
    public void remove() {
        s<E> sVar = this.nz;
        if (sVar == 0) {
            throw new IllegalStateException();
        }
        this.nz = null;
        ReentrantLock reentrantLock = this.nA.lock;
        reentrantLock.lock();
        try {
            if (sVar.item != 0) {
                this.nA.unlink(sVar);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
