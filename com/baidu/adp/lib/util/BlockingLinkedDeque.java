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
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class BlockingLinkedDeque extends AbstractQueue implements BlockingQueue, Queue, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -387911632671998426L;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacity;
    public transient int count;
    public transient e first;
    public transient e last;
    public final ReentrantLock lock;
    public final Condition notEmpty;
    public final Condition notFull;

    /* loaded from: classes.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public abstract class b implements Iterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e a;
        public Object b;
        public e c;
        public final /* synthetic */ BlockingLinkedDeque d;

        public abstract e b();

        public abstract e c(e eVar);

        public b(BlockingLinkedDeque blockingLinkedDeque) {
            Object obj;
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
                e b = b();
                this.a = b;
                if (b == null) {
                    obj = null;
                } else {
                    obj = b.a;
                }
                this.b = obj;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void a() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ReentrantLock reentrantLock = this.d.lock;
                reentrantLock.lock();
                try {
                    e d = d(this.a);
                    this.a = d;
                    if (d == null) {
                        obj = null;
                    } else {
                        obj = d.a;
                    }
                    this.b = obj;
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
        public Object next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                e eVar = this.a;
                if (eVar != null) {
                    this.c = eVar;
                    Object obj = this.b;
                    a();
                    return obj;
                }
                throw new NoSuchElementException();
            }
            return invokeV.objValue;
        }

        public final e d(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, eVar)) != null) {
                return (e) invokeL.objValue;
            }
            while (true) {
                e c = c(eVar);
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
                e eVar = this.c;
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
    public class c extends b {
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
        public e b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.last;
            }
            return (e) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e c(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                return eVar.b;
            }
            return (e) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d extends b {
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
        public e b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.first;
            }
            return (e) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.util.BlockingLinkedDeque.b
        public e c(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                return eVar.c;
            }
            return (e) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public e b;
        public e c;

        public e(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
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

    public Iterator descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new c(this, null);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public Object element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getFirst();
        }
        return invokeV.objValue;
    }

    public Object getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object peekFirst = peekFirst();
            if (peekFirst != null) {
                return peekFirst;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
    }

    public Object getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Object peekLast = peekLast();
            if (peekLast != null) {
                return peekLast;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new d(this, null);
        }
        return (Iterator) invokeV.objValue;
    }

    @Override // java.util.Queue
    public Object peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return peekFirst();
        }
        return invokeV.objValue;
    }

    public Object peekFirst() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.first == null) {
                    obj = null;
                } else {
                    obj = this.first.a;
                }
                return obj;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.objValue;
    }

    public Object peekLast() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.last == null) {
                    obj = null;
                } else {
                    obj = this.last.a;
                }
                return obj;
            } finally {
                reentrantLock.unlock();
            }
        }
        return invokeV.objValue;
    }

    @Override // java.util.Queue
    public Object poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return pollFirst();
        }
        return invokeV.objValue;
    }

    public Object pollFirst() {
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
        return invokeV.objValue;
    }

    public Object pollLast() {
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
        return invokeV.objValue;
    }

    public Object pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return removeFirst();
        }
        return invokeV.objValue;
    }

    @Override // java.util.concurrent.BlockingQueue
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
    public Object remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return removeFirst();
        }
        return invokeV.objValue;
    }

    public Object removeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            Object pollFirst = pollFirst();
            if (pollFirst != null) {
                return pollFirst;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
    }

    public Object removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            Object pollLast = pollLast();
            if (pollLast != null) {
                return pollLast;
            }
            throw new NoSuchElementException();
        }
        return invokeV.objValue;
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

    @Override // java.util.concurrent.BlockingQueue
    public Object take() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return takeFirst();
        }
        return invokeV.objValue;
    }

    public Object takeFirst() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (true) {
                try {
                    Object unlinkFirst = unlinkFirst();
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
            return invokeV.objValue;
        }
    }

    public Object takeLast() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (true) {
                try {
                    Object unlinkLast = unlinkLast();
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
            return invokeV.objValue;
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

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, objArr)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (objArr.length < this.count) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.count);
                }
                int i = 0;
                e eVar = this.first;
                while (eVar != null) {
                    objArr[i] = eVar.a;
                    eVar = eVar.c;
                    i++;
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
            } finally {
                reentrantLock.unlock();
            }
        }
        return (Object[]) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlockingLinkedDeque(Collection collection) {
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
            for (Object obj : collection) {
                if (obj != null) {
                    if (!linkLast(new e(obj))) {
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

    private boolean linkFirst(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, eVar)) == null) {
            if (this.count >= this.capacity) {
                return false;
            }
            e eVar2 = this.first;
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

    private boolean linkLast(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, eVar)) == null) {
            if (this.count >= this.capacity) {
                return false;
            }
            e eVar2 = this.last;
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
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
                for (e eVar = this.first; eVar != null; eVar = eVar.c) {
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
                for (e eVar = this.first; eVar != null; eVar = eVar.c) {
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
                for (e eVar = this.last; eVar != null; eVar = eVar.b) {
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
                for (e eVar = this.first; eVar != null; eVar = eVar.c) {
                    objectOutputStream.writeObject(eVar.a);
                }
                objectOutputStream.writeObject(null);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean add(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            addLast(obj);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void addFirst(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) != null) || offerFirst(obj)) {
            return;
        }
        throw new IllegalStateException("Deque full");
    }

    public void addLast(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) != null) || offerLast(obj)) {
            return;
        }
        throw new IllegalStateException("Deque full");
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, collection)) == null) {
            return drainTo(collection, Integer.MAX_VALUE);
        }
        return invokeL.intValue;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            return offerLast(obj);
        }
        return invokeL.booleanValue;
    }

    public boolean offerFirst(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj != null) {
                e eVar = new e(obj);
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

    public boolean offerLast(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj != null) {
                e eVar = new e(obj);
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

    public void push(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, obj) == null) {
            addFirst(obj);
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(Object obj) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, obj) == null) {
            putLast(obj);
        }
    }

    public void putFirst(Object obj) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, obj) == null) {
            if (obj != null) {
                e eVar = new e(obj);
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

    public void putLast(Object obj) throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, obj) == null) {
            if (obj != null) {
                e eVar = new e(obj);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, obj)) == null) {
            return removeFirstOccurrence(obj);
        }
        return invokeL.booleanValue;
    }

    public void unlink(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, eVar) == null) {
            e eVar2 = eVar.b;
            e eVar3 = eVar.c;
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

    private Object unlinkFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            e eVar = this.first;
            if (eVar == null) {
                return null;
            }
            e eVar2 = eVar.c;
            Object obj = eVar.a;
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
            return obj;
        }
        return invokeV.objValue;
    }

    private Object unlinkLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            e eVar = this.last;
            if (eVar == null) {
                return null;
            }
            e eVar2 = eVar.b;
            Object obj = eVar.a;
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
            return obj;
        }
        return invokeV.objValue;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                e eVar = this.first;
                while (eVar != null) {
                    eVar.a = null;
                    e eVar2 = eVar.c;
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
                e eVar = this.first;
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

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
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
                            collection.add(this.first.a);
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

    public Object pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048600, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    Object unlinkFirst = unlinkFirst();
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
            return invokeJL.objValue;
        }
    }

    public Object pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048602, this, j, timeUnit)) == null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    Object unlinkLast = unlinkLast();
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
            return invokeJL.objValue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(Object obj, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{obj, Long.valueOf(j), timeUnit})) == null) {
            return offerLast(obj, j, timeUnit);
        }
        return invokeCommon.booleanValue;
    }

    public boolean offerFirst(Object obj, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{obj, Long.valueOf(j), timeUnit})) == null) {
            if (obj != null) {
                e eVar = new e(obj);
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

    public boolean offerLast(Object obj, long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{obj, Long.valueOf(j), timeUnit})) == null) {
            if (obj != null) {
                e eVar = new e(obj);
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

    @Override // java.util.concurrent.BlockingQueue
    public Object poll(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048598, this, j, timeUnit)) == null) {
            return pollFirst(j, timeUnit);
        }
        return invokeJL.objValue;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                e eVar = this.first;
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
