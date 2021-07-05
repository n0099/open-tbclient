package androidx.lifecycle;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"T", "Lorg/reactivestreams/Publisher;", "Landroidx/lifecycle/LiveData;", "toLiveData", "(Lorg/reactivestreams/Publisher;)Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "toPublisher", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LifecycleOwner;)Lorg/reactivestreams/Publisher;", "lifecycle-reactivestreams-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class LiveDataReactiveSteamsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T> LiveData<T> toLiveData(Publisher<T> publisher) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, publisher)) == null) {
            LiveData<T> fromPublisher = LiveDataReactiveStreams.fromPublisher(publisher);
            Intrinsics.checkExpressionValueIsNotNull(fromPublisher, "LiveDataReactiveStreams.fromPublisher(this)");
            return fromPublisher;
        }
        return (LiveData) invokeL.objValue;
    }

    public static final <T> Publisher<T> toPublisher(LiveData<T> liveData, LifecycleOwner lifecycleOwner) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, liveData, lifecycleOwner)) == null) {
            Publisher<T> publisher = LiveDataReactiveStreams.toPublisher(lifecycleOwner, liveData);
            Intrinsics.checkExpressionValueIsNotNull(publisher, "LiveDataReactiveStreams.…ublisher(lifecycle, this)");
            return publisher;
        }
        return (Publisher) invokeLL.objValue;
    }
}
