package com.baidu.adp.lib.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class BlockingLinkedDeque<E> extends AbstractQueue<E> implements q<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient u<E> first;
    transient u<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public BlockingLinkedDeque() {
        this(Integer.MAX_VALUE);
    }

    public BlockingLinkedDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    public BlockingLinkedDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new NullPointerException();
                }
                if (!b(new u<>(e))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean a(u<E> uVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        u<E> uVar2 = this.first;
        uVar.yY = uVar2;
        this.first = uVar;
        if (this.last == null) {
            this.last = uVar;
        } else {
            uVar2.zb = uVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean b(u<E> uVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        u<E> uVar2 = this.last;
        uVar.zb = uVar2;
        this.last = uVar;
        if (this.first == null) {
            this.first = uVar;
        } else {
            uVar2.yY = uVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        u<E> uVar = this.first;
        if (uVar == null) {
            return null;
        }
        u<E> uVar2 = uVar.yY;
        E e = uVar.item;
        uVar.item = null;
        uVar.yY = uVar;
        this.first = uVar2;
        if (uVar2 == null) {
            this.last = null;
        } else {
            uVar2.zb = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        u<E> uVar = this.last;
        if (uVar == null) {
            return null;
        }
        u<E> uVar2 = uVar.zb;
        E e = uVar.item;
        uVar.item = null;
        uVar.zb = uVar;
        this.last = uVar2;
        if (uVar2 == null) {
            this.first = null;
        } else {
            uVar2.yY = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlink(u<E> uVar) {
        u<E> uVar2 = uVar.zb;
        u<E> uVar3 = uVar.yY;
        if (uVar2 == null) {
            unlinkFirst();
        } else if (uVar3 == null) {
            unlinkLast();
        } else {
            uVar2.yY = uVar3;
            uVar3.zb = uVar2;
            uVar.item = null;
            this.count--;
            this.notFull.signal();
        }
    }

    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean offerFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        u<E> uVar = new u<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return a(uVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        u<E> uVar = new u<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return b(uVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void putFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        u<E> uVar = new u<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!a(uVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void putLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        u<E> uVar = new u<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!b(uVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerFirst(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        u<E> uVar = new u<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!a(uVar)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public boolean offerLast(E e, long j, TimeUnit timeUnit) {
        if (e == null) {
            throw new NullPointerException();
        }
        u<E> uVar = new u<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!b(uVar)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst == null) {
            throw new NoSuchElementException();
        }
        return pollFirst;
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast == null) {
            throw new NoSuchElementException();
        }
        return pollLast;
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E takeFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst == null) {
                    this.notEmpty.await();
                } else {
                    return unlinkFirst;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast == null) {
                    this.notEmpty.await();
                } else {
                    return unlinkLast;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollFirst(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst == null) {
                    if (j2 > 0) {
                        nanos = this.notEmpty.awaitNanos(j2);
                    } else {
                        reentrantLock.unlock();
                        return null;
                    }
                } else {
                    return unlinkFirst;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E unlinkLast = unlinkLast();
                if (unlinkLast == null) {
                    if (j2 > 0) {
                        nanos = this.notEmpty.awaitNanos(j2);
                    } else {
                        reentrantLock.unlock();
                        return null;
                    }
                } else {
                    return unlinkLast;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst == null) {
            throw new NoSuchElementException();
        }
        return peekFirst;
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast == null) {
            throw new NoSuchElementException();
        }
        return peekLast;
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (u<E> uVar = this.first; uVar != null; uVar = uVar.yY) {
                if (obj.equals(uVar.item)) {
                    unlink(uVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (u<E> uVar = this.last; uVar != null; uVar = uVar.zb) {
                if (obj.equals(uVar.item)) {
                    unlink(uVar);
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        putLast(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() {
        return takeFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: E, ? super E */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.count);
            for (int i2 = 0; i2 < min; i2++) {
                collection.add((E) this.first.item);
                unlinkFirst();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (u<E> uVar = this.first; uVar != null; uVar = uVar.yY) {
                if (obj.equals(uVar.item)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            u<E> uVar = this.first;
            while (uVar != null) {
                int i2 = i + 1;
                objArr[i] = uVar.item;
                uVar = uVar.yY;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i = 0;
            u<E> uVar = this.first;
            while (uVar != null) {
                int i2 = i + 1;
                tArr[i] = uVar.item;
                uVar = uVar.yY;
                i = i2;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            u<E> uVar = this.first;
            if (uVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                while (true) {
                    u<E> uVar2 = uVar;
                    Object obj = uVar2.item;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb.append(obj);
                    uVar = uVar2.yY;
                    if (uVar == null) {
                        return sb.append(']').toString();
                    }
                    sb.append(',').append(' ');
                }
            } else {
                reentrantLock.unlock();
                return "[]";
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            u<E> uVar = this.first;
            while (uVar != null) {
                uVar.item = null;
                u<E> uVar2 = uVar.yY;
                uVar.zb = null;
                uVar.yY = null;
                uVar = uVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new t(this, null);
    }

    public Iterator<E> descendingIterator() {
        return new s(this, null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (u<E> uVar = this.first; uVar != null; uVar = uVar.yY) {
                objectOutputStream.writeObject(uVar.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.adp.lib.util.BlockingLinkedDeque<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }
}
