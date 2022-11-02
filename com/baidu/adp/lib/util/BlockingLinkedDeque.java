package com.baidu.adp.lib.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -387911632671998426L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacity;
    public transient int count;
    public transient e<E> first;
    public transient e<E> last;
    public final ReentrantLock lock;
    public final Condition notEmpty;
    public final Condition notFull;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public abstract class b implements Iterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e<E> a;
        public E b;
        public e<E> c;
        public final /* synthetic */ BlockingLinkedDeque d;

        public abstract e<E> b();

        public abstract e<E> c(e<E> eVar);

        public b(BlockingLinkedDeque blockingLinkedDeque) {
            E e;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {blockingLinkedDeque};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = blockingLinkedDeque;
            ReentrantLock reentrantLock = blockingLinkedDeque.lock;
            reentrantLock.lock();
            try {
                e<E> b = b();
                this.a = b;
                if (b == null) {
                    e = null;
                } else {
                    e = b.a;
                }
                this.b = e;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void a() {
            E e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ReentrantLock reentrantLock = this.d.lock;
                reentrantLock.lock();
                try {
                    e<E> d = d(this.a);
                    this.a = d;
                    if (d == null) {
                        e = null;
                    } else {
                        e = d.a;
                    }
                    this.b = e;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                e<E> eVar = this.a;
                if (eVar != null) {
                    this.c = eVar;
                    E e = this.b;
                    a();
                    return e;
                }
                throw new NoSuchElementException();
            }
            return (E) invokeV.objValue;
        }

        public final e<E> d(e<E> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, eVar)) != null) {
                return (e) invokeL.objValue;
            }
            while (true) {
                e<E> c = c(eVar);
                if (c == null) {
                    return null;
                }
                if (c.a != null) {
                    return c;
                }
                if (c == eVar) {
                    return b();
                }
                eVar = c;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e<E> eVar = this.c;
                if (eVar != null) {
                    this.c = null;
                    ReentrantLock reentrantLock = this.d.lock;
                    reentrantLock.lock();
                    try {
                        if (eVar.a != null) {
                            this.d.unlink(eVar);
                        }
                        return;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends BlockingLinkedDeque<E>.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockingLinkedDeque e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BlockingLinkedDeque blockingLinkedDeque) {
            super(blockingLinkedDeque);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {blockingLinkedDeque};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BlockingLinkedDeque) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = blockingLinkedDeque;
        }

        public /* synthetic */ c(BlockingLinkedDeque blockingLinkedDeque, a aVar) {
            this(blockingLinkedDeque);
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.last;
            }
            return (e) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> c(e<E> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                return eVar.b;
            }
            return (e) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d extends BlockingLinkedDeque<E>.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockingLinkedDeque e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BlockingLinkedDeque blockingLinkedDeque) {
            super(blockingLinkedDeque);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {blockingLinkedDeque};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BlockingLinkedDeque) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = blockingLinkedDeque;
        }

        public /* synthetic */ d(BlockingLinkedDeque blockingLinkedDeque, a aVar) {
            this(blockingLinkedDeque);
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.first;
            }
            return (e) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e<E> c(e<E> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                return eVar.c;
            }
            return (e) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class e<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public E a;
        public e<E> b;
        public e<E> c;

        public e(E e) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlockingLinkedDeque() {
        this(Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public Iterator<E> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new c(this, null);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getFirst();
        }
        return (E) invokeV.objValue;
    }

    public E getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            E peekFirst = peekFirst();
            if (peekFirst != null) {
                return peekFirst;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    public E getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            E peekLast = peekLast();
            if (peekLast != null) {
                return peekLast;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new d(this, null);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.Queue
    public E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return peekFirst();
        }
        return (E) invokeV.objValue;
    }

    public E peekFirst() {
        InterceptResult invokeV;
        E e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.first == null) {
                    e2 = null;
                } else {
                    e2 = this.first.a;
                }
                return e2;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    public E peekLast() {
        InterceptResult invokeV;
        E e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.last == null) {
                    e2 = null;
                } else {
                    e2 = this.last.a;
                }
                return e2;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return pollFirst();
        }
        return (E) invokeV.objValue;
    }

    public E pollFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return unlinkFirst();
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    public E pollLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return unlinkLast();
            } finally {
                reentrantLock.unlock();
            }
        }
        return (E) invokeV.objValue;
    }

    public E pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return removeFirst();
        }
        return (E) invokeV.objValue;
    }

    public int remainingCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.capacity - this.count;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.intValue;
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return removeFirst();
        }
        return (E) invokeV.objValue;
    }

    public E removeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            E pollFirst = pollFirst();
            if (pollFirst != null) {
                return pollFirst;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    public E removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            E pollLast = pollLast();
            if (pollLast != null) {
                return pollLast;
            }
            throw new NoSuchElementException();
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return this.count;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.intValue;
    }

    public E take() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return takeFirst();
        }
        return (E) invokeV.objValue;
    }

    public E takeFirst() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
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
        } else {
            return (E) invokeV.objValue;
        }
    }

    public E takeLast() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
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
        } else {
            return (E) invokeV.objValue;
        }
    }

    public BlockingLinkedDeque(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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

    /* JADX DEBUG: Multi-variable search result rejected for r6v10, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, tArr)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (tArr.length < this.count) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
                }
                int i = 0;
                e<E> eVar = this.first;
                while (eVar != null) {
                    tArr[i] = eVar.a;
                    eVar = eVar.c;
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
        return (T[]) ((Object[]) invokeL.objValue);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlockingLinkedDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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

    private boolean linkFirst(e<E> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, eVar)) == null) {
            if (this.count >= this.capacity) {
                return false;
            }
            e<E> eVar2 = this.first;
            eVar.c = eVar2;
            this.first = eVar;
            if (this.last == null) {
                this.last = eVar;
            } else {
                eVar2.b = eVar;
            }
            this.count++;
            this.notEmpty.signal();
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean linkLast(e<E> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, eVar)) == null) {
            if (this.count >= this.capacity) {
                return false;
            }
            e<E> eVar2 = this.last;
            eVar.b = eVar2;
            this.last = eVar;
            if (this.first == null) {
                this.first = eVar;
            } else {
                eVar2.c = eVar;
            }
            this.count++;
            this.notEmpty.signal();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                for (e<E> eVar = this.first; eVar != null; eVar = eVar.c) {
                    if (obj.equals(eVar.a)) {
                        return true;
                    }
                }
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeL.booleanValue;
    }

    public boolean removeFirstOccurrence(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                for (e<E> eVar = this.first; eVar != null; eVar = eVar.c) {
                    if (obj.equals(eVar.a)) {
                        unlink(eVar);
                        return true;
                    }
                }
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeL.booleanValue;
    }

    public boolean removeLastOccurrence(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                for (e<E> eVar = this.last; eVar != null; eVar = eVar.b) {
                    if (obj.equals(eVar.a)) {
                        unlink(eVar);
                        return true;
                    }
                }
                return false;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.adp.lib.util.BlockingLinkedDeque<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, objectInputStream) == null) {
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
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, objectOutputStream) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                objectOutputStream.defaultWriteObject();
                for (e<E> eVar = this.first; eVar != null; eVar = eVar.c) {
                    objectOutputStream.writeObject(eVar.a);
                }
                objectOutputStream.writeObject(null);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            addLast(e2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void addFirst(E e2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2) != null) || offerFirst(e2)) {
            return;
        }
        throw new IllegalStateException("Deque full");
    }

    public void addLast(E e2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2) != null) || offerLast(e2)) {
            return;
        }
        throw new IllegalStateException("Deque full");
    }

    public int drainTo(Collection<? super E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
            return drainTo(collection, Integer.MAX_VALUE);
        }
        return invokeL.intValue;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e2)) == null) {
            return offerLast(e2);
        }
        return invokeL.booleanValue;
    }

    public boolean offerFirst(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e2)) == null) {
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
        return invokeL.booleanValue;
    }

    public boolean offerLast(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, e2)) == null) {
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
        return invokeL.booleanValue;
    }

    public void push(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, e2) == null) {
            addFirst(e2);
        }
    }

    public void put(E e2) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, e2) == null) {
            putLast(e2);
        }
    }

    public void putFirst(E e2) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, e2) == null) {
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
    }

    public void putLast(E e2) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, e2) == null) {
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
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, obj)) == null) {
            return removeFirstOccurrence(obj);
        }
        return invokeL.booleanValue;
    }

    public void unlink(e<E> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, eVar) == null) {
            e<E> eVar2 = eVar.b;
            e<E> eVar3 = eVar.c;
            if (eVar2 == null) {
                unlinkFirst();
            } else if (eVar3 == null) {
                unlinkLast();
            } else {
                eVar2.c = eVar3;
                eVar3.b = eVar2;
                eVar.a = null;
                this.count--;
                this.notFull.signal();
            }
        }
    }

    private E unlinkFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            e<E> eVar = this.first;
            if (eVar == null) {
                return null;
            }
            e<E> eVar2 = eVar.c;
            E e2 = eVar.a;
            eVar.a = null;
            eVar.c = eVar;
            this.first = eVar2;
            if (eVar2 == null) {
                this.last = null;
            } else {
                eVar2.b = null;
            }
            this.count--;
            this.notFull.signal();
            return e2;
        }
        return (E) invokeV.objValue;
    }

    private E unlinkLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            e<E> eVar = this.last;
            if (eVar == null) {
                return null;
            }
            e<E> eVar2 = eVar.b;
            E e2 = eVar.a;
            eVar.a = null;
            eVar.b = eVar;
            this.last = eVar2;
            if (eVar2 == null) {
                this.first = null;
            } else {
                eVar2.c = null;
            }
            this.count--;
            this.notFull.signal();
            return e2;
        }
        return (E) invokeV.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                e<E> eVar = this.first;
                while (eVar != null) {
                    eVar.a = null;
                    e<E> eVar2 = eVar.c;
                    eVar.b = null;
                    eVar.c = null;
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
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                Object[] objArr = new Object[this.count];
                int i = 0;
                e<E> eVar = this.first;
                while (eVar != null) {
                    int i2 = i + 1;
                    objArr[i] = eVar.a;
                    eVar = eVar.c;
                    i = i2;
                }
                return objArr;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: E, ? super E */
    public int drainTo(Collection<? super E> collection, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, collection, i)) == null) {
            if (collection != null) {
                if (collection != this) {
                    ReentrantLock reentrantLock = this.lock;
                    reentrantLock.lock();
                    try {
                        int min = Math.min(i, this.count);
                        for (int i2 = 0; i2 < min; i2++) {
                            collection.add((E) this.first.a);
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
        return invokeLI.intValue;
    }

    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048600, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    E unlinkFirst = unlinkFirst();
                    if (unlinkFirst == null) {
                        if (nanos <= 0) {
                            return null;
                        }
                        nanos = this.notEmpty.awaitNanos(nanos);
                    } else {
                        return unlinkFirst;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        } else {
            return (E) invokeJL.objValue;
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048602, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    E unlinkLast = unlinkLast();
                    if (unlinkLast == null) {
                        if (nanos <= 0) {
                            return null;
                        }
                        nanos = this.notEmpty.awaitNanos(nanos);
                    } else {
                        return unlinkLast;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        } else {
            return (E) invokeJL.objValue;
        }
    }

    public boolean offer(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{e2, Long.valueOf(j), timeUnit})) == null) {
            return offerLast(e2, j, timeUnit);
        }
        return invokeCommon.booleanValue;
    }

    public boolean offerFirst(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{e2, Long.valueOf(j), timeUnit})) == null) {
            if (e2 != null) {
                e<E> eVar = new e<>(e2);
                long nanos = timeUnit.toNanos(j);
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lockInterruptibly();
                while (true) {
                    try {
                        if (!linkFirst(eVar)) {
                            if (nanos <= 0) {
                                z = false;
                                break;
                            }
                            nanos = this.notFull.awaitNanos(nanos);
                        } else {
                            z = true;
                            break;
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return z;
            }
            throw null;
        }
        return invokeCommon.booleanValue;
    }

    public boolean offerLast(E e2, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{e2, Long.valueOf(j), timeUnit})) == null) {
            if (e2 != null) {
                e<E> eVar = new e<>(e2);
                long nanos = timeUnit.toNanos(j);
                ReentrantLock reentrantLock = this.lock;
                reentrantLock.lockInterruptibly();
                while (true) {
                    try {
                        if (!linkLast(eVar)) {
                            if (nanos <= 0) {
                                z = false;
                                break;
                            }
                            nanos = this.notFull.awaitNanos(nanos);
                        } else {
                            z = true;
                            break;
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return z;
            }
            throw null;
        }
        return invokeCommon.booleanValue;
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048598, this, j, timeUnit)) == null) {
            return pollFirst(j, timeUnit);
        }
        return (E) invokeJL.objValue;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
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
                    Object obj = eVar.a;
                    if (obj == this) {
                        obj = "(this Collection)";
                    }
                    sb.append(obj);
                    eVar = eVar.c;
                    if (eVar == null) {
                        sb.append(']');
                        return sb.toString();
                    }
                    sb.append(',');
                    sb.append(WebvttCueParser.CHAR_SPACE);
                }
            } finally {
                reentrantLock.unlock();
            }
        } else {
            return (String) invokeV.objValue;
        }
    }
}
