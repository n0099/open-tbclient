package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SafeIterableMap<LiveData<?>, Source<?>> mSources;

    /* loaded from: classes.dex */
    public static class Source<V> implements Observer<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LiveData<V> mLiveData;
        public final Observer<? super V> mObserver;
        public int mVersion;

        public Source(LiveData<V> liveData, Observer<? super V> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveData, observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mVersion = -1;
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable V v) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, v) == null) && this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }

        public void plug() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mLiveData.observeForever(this);
            }
        }

        public void unplug() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mLiveData.removeObserver(this);
            }
        }
    }

    public MediatorLiveData() {
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
        this.mSources = new SafeIterableMap<>();
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onActive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
            while (it.hasNext()) {
                it.next().getValue().plug();
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    @CallSuper
    public void onInactive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
            while (it.hasNext()) {
                it.next().getValue().unplug();
            }
        }
    }

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, liveData, observer) == null) {
            Source<?> source = new Source<>(liveData, observer);
            Source<?> putIfAbsent = this.mSources.putIfAbsent(liveData, source);
            if (putIfAbsent != null && putIfAbsent.mObserver != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            }
            if (putIfAbsent == null && hasActiveObservers()) {
                source.plug();
            }
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> liveData) {
        Source<?> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, liveData) == null) && (remove = this.mSources.remove(liveData)) != null) {
            remove.unplug();
        }
    }
}
