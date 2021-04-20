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
public class BlockingLinkedDeque<E> extends AbstractQueue<E> implements Object<E>, Serializable, Serializable {
    public static final long serialVersionUID = -387911632671998426L;
    public final int capacity;
    public transient int count;
    public transient e<E> first;
    public transient e<E> last;
    public final ReentrantLock lock;
    public final Condition notEmpty;
    public final Condition notFull;

    /* loaded from: classes.dex */
    public abstract class b implements Iterator<E> {

        /* renamed from: e  reason: collision with root package name */
        public e<E> f2207e;

        /* renamed from: f  reason: collision with root package name */
        public E f2208f;

        /* renamed from: g  reason: collision with root package name */
        public e<E> f2209g;

        public b() {
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> b2 = b();
                this.f2207e = b2;
                this.f2208f = b2 == null ? null : b2.f2211a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void a() {
            ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> d2 = d(this.f2207e);
                this.f2207e = d2;
                this.f2208f = d2 == null ? null : d2.f2211a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract e<E> b();

        public abstract e<E> c(e<E> eVar);

        public final e<E> d(e<E> eVar) {
            while (true) {
                e<E> c2 = c(eVar);
                if (c2 == null) {
                    return null;
                }
                if (c2.f2211a != null) {
                    return c2;
                }
                if (c2 == eVar) {
                    return b();
                }
                eVar = c2;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2207e != null;
        }

        @Override // java.util.Iterator
        public E next() {
            e<E> eVar = this.f2207e;
            if (eVar != null) {
                this.f2209g = eVar;
                E e2 = this.f2208f;
                a();
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            e<E> eVar = this.f2209g;
            if (eVar != null) {
                this.f2209g = null;
                ReentrantLock reentrantLock = BlockingLinkedDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (eVar.f2211a != null) {
                        BlockingLinkedDeque.this.unlink(eVar);
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public class c extends BlockingLinkedDeque<E>.b {
        public c() {
            super();
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> b() {
            return BlockingLinkedDeque.this.last;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> c(e<E> eVar) {
            return eVar.f2212b;
        }
    }

    /* loaded from: classes.dex */
    public class d extends BlockingLinkedDeque<E>.b {
        public d() {
            super();
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> b() {
            return BlockingLinkedDeque.this.first;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> c(e<E> eVar) {
            return eVar.f2213c;
        }
    }

    /* loaded from: classes.dex */
    public static final class e<E> {

        /* renamed from: a  reason: collision with root package name */
        public E f2211a;

        /* renamed from: b  reason: collision with root package name */
        public e<E> f2212b;

        /* renamed from: c  reason: collision with root package name */
        public e<E> f2213c;

        public e(E e2) {
            this.f2211a = e2;
        }
    }

    public BlockingLinkedDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(e<E> eVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.first;
        eVar.f2213c = eVar2;
        this.first = eVar;
        if (this.last == null) {
            this.last = eVar;
        } else {
            eVar2.f2212b = eVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(e<E> eVar) {
        if (this.count >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.last;
        eVar.f2212b = eVar2;
        this.last = eVar;
        if (this.first == null) {
            this.first = eVar;
        } else {
            eVar2.f2213c = eVar;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.adp.lib.util.BlockingLinkedDeque<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private E unlinkFirst() {
        e<E> eVar = this.first;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f2213c;
        E e2 = eVar.f2211a;
        eVar.f2211a = null;
        eVar.f2213c = eVar;
        this.first = eVar2;
        if (eVar2 == null) {
            this.last = null;
        } else {
            eVar2.f2212b = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private E unlinkLast() {
        e<E> eVar = this.last;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f2212b;
        E e2 = eVar.f2211a;
        eVar.f2211a = null;
        eVar.f2212b = eVar;
        this.last = eVar2;
        if (eVar2 == null) {
            this.first = null;
        } else {
            eVar2.f2213c = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f2213c) {
                objectOutputStream.writeObject(eVar.f2211a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e2) {
        if (!offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            while (eVar != null) {
                eVar.f2211a = null;
                e<E> eVar2 = eVar.f2213c;
                eVar.f2212b = null;
                eVar.f2213c = null;
                eVar = eVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f2213c) {
                if (obj.equals(eVar.f2211a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new c();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new d();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        return offerLast(e2);
    }

    public boolean offerFirst(E e2) {
        if (e2 != null) {
            e<E> eVar = new e<>(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkFirst(eVar);
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    public boolean offerLast(E e2) {
        if (e2 != null) {
            e<E> eVar = new e<>(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkLast(eVar);
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.f2211a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.f2211a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
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

    public E pop() {
        return removeFirst();
    }

    public void push(E e2) {
        addFirst(e2);
    }

    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    public void putFirst(E e2) throws InterruptedException {
        if (e2 != null) {
            e<E> eVar = new e<>(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkFirst(eVar)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw null;
    }

    public void putLast(E e2) throws InterruptedException {
        if (e2 != null) {
            e<E> eVar = new e<>(e2);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkLast(eVar)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw null;
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f2213c) {
                if (obj.equals(eVar.f2211a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.last; eVar != null; eVar = eVar.f2212b) {
                if (obj.equals(eVar.f2211a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
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

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
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
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                int i2 = i + 1;
                objArr[i] = eVar.f2211a;
                eVar = eVar.f2213c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            if (eVar == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = eVar.f2211a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                eVar = eVar.f2213c;
                if (eVar == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unlink(e<E> eVar) {
        e<E> eVar2 = eVar.f2212b;
        e<E> eVar3 = eVar.f2213c;
        if (eVar2 == null) {
            unlinkFirst();
        } else if (eVar3 == null) {
            unlinkLast();
        } else {
            eVar2.f2213c = eVar3;
            eVar3.f2212b = eVar2;
            eVar.f2211a = null;
            this.count--;
            this.notFull.signal();
        }
    }

    public BlockingLinkedDeque(int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i > 0) {
            this.capacity = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: E, ? super E */
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection != null) {
            if (collection != this) {
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lock();
                try {
                    int min = Math.min(i, this.count);
                    for (int i2 = 0; i2 < min; i2++) {
                        collection.add((E) this.first.f2211a);
                        unlinkFirst();
                    }
                    return min;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    public boolean offer(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e2, j, timeUnit);
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
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
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerFirst(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        if (e2 != null) {
            e<E> eVar = new e<>(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (linkFirst(eVar)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.notFull.awaitNanos(nanos);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw null;
    }

    public boolean offerLast(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        if (e2 != null) {
            e<E> eVar = new e<>(e2);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (linkLast(eVar)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.notFull.awaitNanos(nanos);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw null;
    }

    public BlockingLinkedDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e2 : collection) {
                if (e2 != null) {
                    if (!linkLast(new e<>(e2))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v10, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            int i = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                tArr[i] = eVar.f2211a;
                eVar = eVar.f2213c;
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
}
