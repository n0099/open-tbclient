package com.baidu.adp.lib.util;

import android.support.v7.widget.ActivityChooserView;
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
public class BlockingLinkedDeque<E> extends AbstractQueue<E> implements m<E>, Serializable {
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
        E DC;
        d<E> DD;
        d<E> Dy;

        d(E e) {
            this.DC = e;
        }
    }

    public BlockingLinkedDeque() {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
        dVar.Dy = dVar2;
        this.first = dVar;
        if (this.last == null) {
            this.last = dVar;
        } else {
            dVar2.DD = dVar;
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
        dVar.DD = dVar2;
        this.last = dVar;
        if (this.first == null) {
            this.first = dVar;
        } else {
            dVar2.Dy = dVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E kb() {
        d<E> dVar = this.first;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.Dy;
        E e = dVar.DC;
        dVar.DC = null;
        dVar.Dy = dVar;
        this.first = dVar2;
        if (dVar2 == null) {
            this.last = null;
        } else {
            dVar2.DD = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E kc() {
        d<E> dVar = this.last;
        if (dVar == null) {
            return null;
        }
        d<E> dVar2 = dVar.DD;
        E e = dVar.DC;
        dVar.DC = null;
        dVar.DD = dVar;
        this.last = dVar2;
        if (dVar2 == null) {
            this.first = null;
        } else {
            dVar2.Dy = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    void unlink(d<E> dVar) {
        d<E> dVar2 = dVar.DD;
        d<E> dVar3 = dVar.Dy;
        if (dVar2 == null) {
            kb();
        } else if (dVar3 == null) {
            kc();
        } else {
            dVar2.Dy = dVar3;
            dVar3.DD = dVar2;
            dVar.DC = null;
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
                    return false;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
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
                    return false;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
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
            return kb();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return kc();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E kb = kb();
                if (kb != null) {
                    return kb;
                }
                this.notEmpty.await();
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
                E kc = kc();
                if (kc != null) {
                    return kc;
                }
                this.notEmpty.await();
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
                E kb = kb();
                if (kb != null) {
                    return kb;
                }
                if (j2 > 0) {
                    nanos = this.notEmpty.awaitNanos(j2);
                } else {
                    return null;
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
                E kc = kc();
                if (kc != null) {
                    return kc;
                }
                if (j2 > 0) {
                    nanos = this.notEmpty.awaitNanos(j2);
                } else {
                    return null;
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
            return this.first == null ? null : this.first.DC;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.DC;
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
            for (d<E> dVar = this.first; dVar != null; dVar = dVar.Dy) {
                if (obj.equals(dVar.DC)) {
                    unlink(dVar);
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
            for (d<E> dVar = this.last; dVar != null; dVar = dVar.DD) {
                if (obj.equals(dVar.DC)) {
                    unlink(dVar);
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
        return drainTo(collection, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
                collection.add((E) this.first.DC);
                kb();
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
            for (d<E> dVar = this.first; dVar != null; dVar = dVar.Dy) {
                if (obj.equals(dVar.DC)) {
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
                objArr[i] = dVar.DC;
                dVar = dVar.Dy;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object[]] */
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
                tArr[i] = dVar.DC;
                dVar = dVar.Dy;
                i++;
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
        String sb;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            d<E> dVar = this.first;
            if (dVar == null) {
                sb = "[]";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('[');
                while (true) {
                    d<E> dVar2 = dVar;
                    Object obj = dVar2.DC;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb2.append(obj);
                    dVar = dVar2.Dy;
                    if (dVar == null) {
                        break;
                    }
                    sb2.append(',').append(' ');
                }
                sb = sb2.append(']').toString();
            }
            return sb;
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
                dVar.DC = null;
                d<E> dVar2 = dVar.Dy;
                dVar.DD = null;
                dVar.Dy = null;
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
        return new c();
    }

    public Iterator<E> descendingIterator() {
        return new b();
    }

    /* loaded from: classes.dex */
    private abstract class a implements Iterator<E> {
        private d<E> DA;
        d<E> Dy;
        E Dz;

        abstract d<E> c(d<E> dVar);

        abstract d<E> kd();

        a() {
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                this.Dy = kd();
                this.Dz = this.Dy == null ? null : this.Dy.DC;
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
                if (c.DC == null) {
                    if (c == dVar) {
                        return kd();
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
                this.Dy = d(this.Dy);
                this.Dz = this.Dy == null ? null : this.Dy.DC;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.Dy != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.Dy == null) {
                throw new NoSuchElementException();
            }
            this.DA = this.Dy;
            E e = this.Dz;
            advance();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            d<E> dVar = this.DA;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            this.DA = null;
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                if (dVar.DC != null) {
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

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> kd() {
            return BlockingLinkedDeque.this.first;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> c(d<E> dVar) {
            return dVar.Dy;
        }
    }

    /* loaded from: classes.dex */
    private class b extends BlockingLinkedDeque<E>.a {
        private b() {
            super();
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> kd() {
            return BlockingLinkedDeque.this.last;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.a
        d<E> c(d<E> dVar) {
            return dVar.DD;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (d<E> dVar = this.first; dVar != null; dVar = dVar.Dy) {
                objectOutputStream.writeObject(dVar.DC);
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
