package com.baidu.adp.lib.util;

import java.io.IOException;
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
public class BlockingLinkedDeque<E> extends AbstractQueue<E> implements n<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient d<E> first;
    transient d<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d<E> {
        d<E> zH;
        E zL;
        d<E> zM;

        d(E e) {
            this.zL = e;
        }
    }

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
                if (!b(new d<>(e))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean a(d<E> dVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        d<E> dVar2 = this.first;
        dVar.zH = dVar2;
        this.first = dVar;
        if (this.last == null) {
            this.last = dVar;
        } else {
            dVar2.zM = dVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean b(d<E> dVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        d<E> dVar2 = this.last;
        dVar.zM = dVar2;
        this.last = dVar;
        if (this.first == null) {
            this.first = dVar;
        } else {
            dVar2.zH = dVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E hC() {
        d<E> dVar = this.first;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.zH;
        E e = dVar.zL;
        dVar.zL = null;
        dVar.zH = dVar;
        this.first = dVar2;
        if (dVar2 == null) {
            this.last = null;
        } else {
            dVar2.zM = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E hD() {
        d<E> dVar = this.last;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.zM;
        E e = dVar.zL;
        dVar.zL = null;
        dVar.zM = dVar;
        this.last = dVar2;
        if (dVar2 == null) {
            this.first = null;
        } else {
            dVar2.zH = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    void unlink(d<E> dVar) {
        d<E> dVar2 = dVar.zM;
        d<E> dVar3 = dVar.zH;
        if (dVar2 == null) {
            hC();
        } else if (dVar3 == null) {
            hD();
        } else {
            dVar2.zH = dVar3;
            dVar3.zM = dVar2;
            dVar.zL = null;
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
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return a(dVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return b(dVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void putFirst(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!a(dVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void putLast(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        d<E> dVar = new d<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!b(dVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        d<E> dVar = new d<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!a(dVar)) {
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

    public boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        d<E> dVar = new d<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!b(dVar)) {
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
            return hC();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return hD();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E hC = hC();
                if (hC == null) {
                    this.notEmpty.await();
                } else {
                    return hC;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E hD = hD();
                if (hD == null) {
                    this.notEmpty.await();
                } else {
                    return hD;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E hC = hC();
                if (hC == null) {
                    if (j2 > 0) {
                        nanos = this.notEmpty.awaitNanos(j2);
                    } else {
                        reentrantLock.unlock();
                        return null;
                    }
                } else {
                    return hC;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                long j2 = nanos;
                E hD = hD();
                if (hD == null) {
                    if (j2 > 0) {
                        nanos = this.notEmpty.awaitNanos(j2);
                    } else {
                        reentrantLock.unlock();
                        return null;
                    }
                } else {
                    return hD;
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
            return this.first == null ? null : this.first.zL;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.zL;
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
            for (d<E> dVar = this.first; dVar != null; dVar = dVar.zH) {
                if (obj.equals(dVar.zL)) {
                    unlink(dVar);
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
            for (d<E> dVar = this.last; dVar != null; dVar = dVar.zM) {
                if (obj.equals(dVar.zL)) {
                    unlink(dVar);
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
    public void put(E e) throws InterruptedException {
        putLast(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
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
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
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
                collection.add((E) this.first.zL);
                hC();
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
            for (d<E> dVar = this.first; dVar != null; dVar = dVar.zH) {
                if (obj.equals(dVar.zL)) {
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
            d<E> dVar = this.first;
            while (dVar != null) {
                int i2 = i + 1;
                objArr[i] = dVar.zL;
                dVar = dVar.zH;
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
            d<E> dVar = this.first;
            while (dVar != null) {
                int i2 = i + 1;
                tArr[i] = dVar.zL;
                dVar = dVar.zH;
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
            d<E> dVar = this.first;
            if (dVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                while (true) {
                    d<E> dVar2 = dVar;
                    Object obj = dVar2.zL;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb.append(obj);
                    dVar = dVar2.zH;
                    if (dVar == null) {
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
            d<E> dVar = this.first;
            while (dVar != null) {
                dVar.zL = null;
                d<E> dVar2 = dVar.zH;
                dVar.zM = null;
                dVar.zH = null;
                dVar = dVar2;
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
        return new c(this, null);
    }

    public Iterator<E> descendingIterator() {
        return new b(this, null);
    }

    /* loaded from: classes.dex */
    private abstract class a implements Iterator<E> {
        d<E> zH;
        E zI;
        private d<E> zJ;

        abstract d<E> c(d<E> dVar);

        abstract d<E> hE();

        a() {
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                this.zH = hE();
                this.zI = this.zH == null ? null : this.zH.zL;
            } finally {
                reentrantLock.unlock();
            }
        }

        private d<E> d(d<E> dVar) {
            while (true) {
                d<E> c = c(dVar);
                if (c == null) {
                    return null;
                }
                if (c.zL == null) {
                    if (c == dVar) {
                        return hE();
                    }
                    dVar = c;
                } else {
                    return c;
                }
            }
        }

        void advance() {
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                this.zH = d(this.zH);
                this.zI = this.zH == null ? null : this.zH.zL;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.zH != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.zH == null) {
                throw new NoSuchElementException();
            }
            this.zJ = this.zH;
            E e = this.zI;
            advance();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            d<E> dVar = this.zJ;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            this.zJ = null;
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                if (dVar.zL != null) {
                    BlockingLinkedDeque.this.unlink(dVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    private class c extends BlockingLinkedDeque<E>.a {
        private c() {
            super();
        }

        /* synthetic */ c(BlockingLinkedDeque blockingLinkedDeque, c cVar) {
            this();
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> hE() {
            return BlockingLinkedDeque.this.first;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> c(d<E> dVar) {
            return dVar.zH;
        }
    }

    /* loaded from: classes.dex */
    private class b extends BlockingLinkedDeque<E>.a {
        private b() {
            super();
        }

        /* synthetic */ b(BlockingLinkedDeque blockingLinkedDeque, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> hE() {
            return BlockingLinkedDeque.this.last;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> c(d<E> dVar) {
            return dVar.zM;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (d<E> dVar = this.first; dVar != null; dVar = dVar.zH) {
                objectOutputStream.writeObject(dVar.zL);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.adp.lib.util.BlockingLinkedDeque<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
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
