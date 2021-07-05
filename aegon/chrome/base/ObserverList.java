package aegon.chrome.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class ObserverList<E> implements Iterable<E> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCount;
    public int mIterationDepth;
    public boolean mNeedsCompact;
    public final List<E> mObservers;

    /* renamed from: aegon.chrome.base.ObserverList$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class ObserverListIterator implements RewindableIterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIndex;
        public boolean mIsExhausted;
        public int mListEndMarker;

        public /* synthetic */ ObserverListIterator(AnonymousClass1 anonymousClass1) {
            ObserverList.access$100(ObserverList.this);
            this.mListEndMarker = ObserverList.access$200(ObserverList.this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.mIndex;
                while (i2 < this.mListEndMarker && ObserverList.access$300(ObserverList.this, i2) == null) {
                    i2++;
                }
                if (i2 < this.mListEndMarker) {
                    return true;
                }
                if (this.mIsExhausted) {
                    return false;
                }
                this.mIsExhausted = true;
                ObserverList.access$400(ObserverList.this);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                while (true) {
                    int i2 = this.mIndex;
                    if (i2 >= this.mListEndMarker || ObserverList.access$300(ObserverList.this, i2) != null) {
                        break;
                    }
                    this.mIndex++;
                }
                int i3 = this.mIndex;
                if (i3 < this.mListEndMarker) {
                    ObserverList observerList = ObserverList.this;
                    this.mIndex = i3 + 1;
                    return (E) ObserverList.access$300(observerList, i3);
                }
                if (!this.mIsExhausted) {
                    this.mIsExhausted = true;
                    ObserverList.access$400(ObserverList.this);
                }
                throw new NoSuchElementException();
            }
            return (E) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface RewindableIterator<E> extends Iterator<E> {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1845173573, "Laegon/chrome/base/ObserverList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1845173573, "Laegon/chrome/base/ObserverList;");
            }
        }
    }

    public ObserverList() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mObservers = new ArrayList();
    }

    public static /* synthetic */ void access$100(ObserverList observerList) {
        observerList.mIterationDepth++;
    }

    public static /* synthetic */ int access$200(ObserverList observerList) {
        return observerList.mObservers.size();
    }

    public static /* synthetic */ Object access$300(ObserverList observerList, int i2) {
        return observerList.mObservers.get(i2);
    }

    public static /* synthetic */ void access$400(ObserverList observerList) {
        int i2 = observerList.mIterationDepth - 1;
        observerList.mIterationDepth = i2;
        if (i2 <= 0 && observerList.mNeedsCompact) {
            observerList.mNeedsCompact = false;
            for (int size = observerList.mObservers.size() - 1; size >= 0; size--) {
                if (observerList.mObservers.get(size) == null) {
                    observerList.mObservers.remove(size);
                }
            }
        }
    }

    public boolean addObserver(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            if (e2 == null || this.mObservers.contains(e2)) {
                return false;
            }
            this.mObservers.add(e2);
            this.mCount++;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ObserverListIterator(null) : (Iterator) invokeV.objValue;
    }

    public boolean removeObserver(E e2) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2)) == null) {
            if (e2 == null || (indexOf = this.mObservers.indexOf(e2)) == -1) {
                return false;
            }
            if (this.mIterationDepth == 0) {
                this.mObservers.remove(indexOf);
            } else {
                this.mNeedsCompact = true;
                this.mObservers.set(indexOf, null);
            }
            this.mCount--;
            return true;
        }
        return invokeL.booleanValue;
    }
}
