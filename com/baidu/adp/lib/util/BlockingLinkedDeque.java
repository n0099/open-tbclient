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
public class BlockingLinkedDeque<E> extends AbstractQueue<E> implements o<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient s<E> first;
    transient s<E> last;
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
                if (!b(new s<>(e))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean a(s<E> sVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        s<E> sVar2 = this.first;
        sVar.ny = sVar2;
        this.first = sVar;
        if (this.last == null) {
            this.last = sVar;
        } else {
            sVar2.nB = sVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean b(s<E> sVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        s<E> sVar2 = this.last;
        sVar.nB = sVar2;
        this.last = sVar;
        if (this.first == null) {
            this.first = sVar;
        } else {
            sVar2.ny = sVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        s<E> sVar = this.first;
        if (sVar == null) {
            return null;
        }
        s<E> sVar2 = sVar.ny;
        E e = sVar.item;
        sVar.item = null;
        sVar.ny = sVar;
        this.first = sVar2;
        if (sVar2 == null) {
            this.last = null;
        } else {
            sVar2.nB = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        s<E> sVar = this.last;
        if (sVar == null) {
            return null;
        }
        s<E> sVar2 = sVar.nB;
        E e = sVar.item;
        sVar.item = null;
        sVar.nB = sVar;
        this.last = sVar2;
        if (sVar2 == null) {
            this.first = null;
        } else {
            sVar2.ny = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlink(s<E> sVar) {
        s<E> sVar2 = sVar.nB;
        s<E> sVar3 = sVar.ny;
        if (sVar2 == null) {
            unlinkFirst();
        } else if (sVar3 == null) {
            unlinkLast();
        } else {
            sVar2.ny = sVar3;
            sVar3.nB = sVar2;
            sVar.item = null;
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
        s<E> sVar = new s<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return a(sVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        s<E> sVar = new s<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return b(sVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void putFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        s<E> sVar = new s<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!a(sVar)) {
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
        s<E> sVar = new s<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!b(sVar)) {
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
        s<E> sVar = new s<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!a(sVar)) {
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
        s<E> sVar = new s<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!b(sVar)) {
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
            for (s<E> sVar = this.first; sVar != null; sVar = sVar.ny) {
                if (obj.equals(sVar.item)) {
                    unlink(sVar);
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
            for (s<E> sVar = this.last; sVar != null; sVar = sVar.nB) {
                if (obj.equals(sVar.item)) {
                    unlink(sVar);
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
            for (s<E> sVar = this.first; sVar != null; sVar = sVar.ny) {
                if (obj.equals(sVar.item)) {
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
            s<E> sVar = this.first;
            while (sVar != null) {
                int i2 = i + 1;
                objArr[i] = sVar.item;
                sVar = sVar.ny;
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
            s<E> sVar = this.first;
            while (sVar != null) {
                int i2 = i + 1;
                tArr[i] = sVar.item;
                sVar = sVar.ny;
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
            s<E> sVar = this.first;
            if (sVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                while (true) {
                    s<E> sVar2 = sVar;
                    Object obj = sVar2.item;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb.append(obj);
                    sVar = sVar2.ny;
                    if (sVar == null) {
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
            s<E> sVar = this.first;
            while (sVar != null) {
                sVar.item = null;
                s<E> sVar2 = sVar.ny;
                sVar.nB = null;
                sVar.ny = null;
                sVar = sVar2;
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
        return new r(this, null);
    }

    public Iterator<E> descendingIterator() {
        return new q(this, null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (s<E> sVar = this.first; sVar != null; sVar = sVar.ny) {
                objectOutputStream.writeObject(sVar.item);
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
