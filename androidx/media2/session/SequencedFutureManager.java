package androidx.media2.session;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.AbstractResolvableFuture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SequencedFutureManager implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SequencedFutureManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mLock;
    @GuardedBy("mLock")
    public int mNextSequenceNumber;
    @GuardedBy("mLock")
    public ArrayMap<Integer, SequencedFuture<?>> mSeqToFutureMap;

    /* loaded from: classes.dex */
    public static final class SequencedFuture<T> extends AbstractResolvableFuture<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T mResultWhenClosed;
        public final int mSequenceNumber;

        public SequencedFuture(int i, @NonNull T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSequenceNumber = i;
            this.mResultWhenClosed = t;
        }

        public static <T> SequencedFuture<T> create(int i, @NonNull T t) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, t)) == null) ? new SequencedFuture<>(i, t) : (SequencedFuture) invokeIL.objValue;
        }

        @NonNull
        public T getResultWhenClosed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultWhenClosed : (T) invokeV.objValue;
        }

        public int getSequenceNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSequenceNumber : invokeV.intValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture
        public boolean set(@Nullable T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) ? super.set(t) : invokeL.booleanValue;
        }

        public void setWithTheValueOfResultWhenClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                set(this.mResultWhenClosed);
            }
        }
    }

    public SequencedFutureManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mSeqToFutureMap = new ArrayMap<>();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ArrayList<SequencedFuture> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.mLock) {
                arrayList = new ArrayList(this.mSeqToFutureMap.values());
                this.mSeqToFutureMap.clear();
            }
            for (SequencedFuture sequencedFuture : arrayList) {
                sequencedFuture.setWithTheValueOfResultWhenClosed();
            }
        }
    }

    public <T> SequencedFuture<T> createSequencedFuture(T t) {
        InterceptResult invokeL;
        SequencedFuture<T> create;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            synchronized (this.mLock) {
                int obtainNextSequenceNumber = obtainNextSequenceNumber();
                create = SequencedFuture.create(obtainNextSequenceNumber, t);
                this.mSeqToFutureMap.put(Integer.valueOf(obtainNextSequenceNumber), create);
            }
            return create;
        }
        return (SequencedFuture) invokeL.objValue;
    }

    public int obtainNextSequenceNumber() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mLock) {
                i = this.mNextSequenceNumber;
                this.mNextSequenceNumber = i + 1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public <T> void setFutureResult(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, t) == null) {
            synchronized (this.mLock) {
                SequencedFuture<?> remove = this.mSeqToFutureMap.remove(Integer.valueOf(i));
                if (remove != null) {
                    if (t != null && remove.getResultWhenClosed().getClass() != t.getClass()) {
                        Log.w(TAG, "Type mismatch, expected " + remove.getResultWhenClosed().getClass() + ", but was " + t.getClass());
                    }
                    remove.set(t);
                }
            }
        }
    }
}
