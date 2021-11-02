package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/LiveDataScopeImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", "source", "Lkotlinx/coroutines/DisposableHandle;", "emitSource", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getLatestValue", "()Ljava/lang/Object;", "latestValue", "Landroidx/lifecycle/CoroutineLiveData;", "target", "Landroidx/lifecycle/CoroutineLiveData;", "getTarget$lifecycle_livedata_ktx_release", "()Landroidx/lifecycle/CoroutineLiveData;", "setTarget$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/CoroutineLiveData;)V", "context", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/coroutines/CoroutineContext;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CoroutineContext coroutineContext;
    public CoroutineLiveData<T> target;

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, CoroutineContext coroutineContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {coroutineLiveData, coroutineContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.target = coroutineLiveData;
        this.coroutineContext = coroutineContext.plus(Dispatchers.getMain().getImmediate());
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emit(T t, Continuation<? super Unit> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, continuation)) == null) ? BuildersKt.withContext(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t, null), continuation) : invokeLL.objValue;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> liveData, Continuation<? super DisposableHandle> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveData, continuation)) == null) ? BuildersKt.withContext(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, null), continuation) : invokeLL.objValue;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.target.getValue() : (T) invokeV.objValue;
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.target : (CoroutineLiveData) invokeV.objValue;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(CoroutineLiveData<T> coroutineLiveData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, coroutineLiveData) == null) {
            this.target = coroutineLiveData;
        }
    }
}
