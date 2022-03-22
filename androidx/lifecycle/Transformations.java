package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Transformations {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Transformations() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveData)) == null) {
            MediatorLiveData mediatorLiveData = new MediatorLiveData();
            mediatorLiveData.addSource(liveData, new Observer<X>(mediatorLiveData) { // from class: androidx.lifecycle.Transformations.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean mFirstTime;
                public final /* synthetic */ MediatorLiveData val$outputLiveData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mediatorLiveData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$outputLiveData = mediatorLiveData;
                    this.mFirstTime = true;
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(X x) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, x) == null) {
                        T value = this.val$outputLiveData.getValue();
                        if (this.mFirstTime || ((value == 0 && x != 0) || !(value == 0 || value.equals(x)))) {
                            this.mFirstTime = false;
                            this.val$outputLiveData.setValue(x);
                        }
                    }
                }
            });
            return mediatorLiveData;
        }
        return (LiveData) invokeL.objValue;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull Function<X, Y> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, liveData, function)) == null) {
            MediatorLiveData mediatorLiveData = new MediatorLiveData();
            mediatorLiveData.addSource(liveData, new Observer<X>(mediatorLiveData, function) { // from class: androidx.lifecycle.Transformations.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function val$mapFunction;
                public final /* synthetic */ MediatorLiveData val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {mediatorLiveData, function};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$result = mediatorLiveData;
                    this.val$mapFunction = function;
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable X x) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, x) == null) {
                        this.val$result.setValue(this.val$mapFunction.apply(x));
                    }
                }
            });
            return mediatorLiveData;
        }
        return (LiveData) invokeLL.objValue;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull Function<X, LiveData<Y>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, liveData, function)) == null) {
            MediatorLiveData mediatorLiveData = new MediatorLiveData();
            mediatorLiveData.addSource(liveData, new Observer<X>(function, mediatorLiveData) { // from class: androidx.lifecycle.Transformations.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public LiveData<Y> mSource;
                public final /* synthetic */ MediatorLiveData val$result;
                public final /* synthetic */ Function val$switchMapFunction;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function, mediatorLiveData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$switchMapFunction = function;
                    this.val$result = mediatorLiveData;
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable X x) {
                    LiveData<Y> liveData2;
                    Object obj;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, x) == null) || (obj = this.mSource) == (liveData2 = (LiveData) this.val$switchMapFunction.apply(x))) {
                        return;
                    }
                    if (obj != null) {
                        this.val$result.removeSource(obj);
                    }
                    this.mSource = liveData2;
                    if (liveData2 != 0) {
                        this.val$result.addSource(liveData2, new Observer<Y>(this) { // from class: androidx.lifecycle.Transformations.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$0;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // androidx.lifecycle.Observer
                            public void onChanged(@Nullable Y y) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, y) == null) {
                                    this.this$0.val$result.setValue(y);
                                }
                            }
                        });
                    }
                }
            });
            return mediatorLiveData;
        }
        return (LiveData) invokeLL.objValue;
    }
}
