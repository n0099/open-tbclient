package androidx.lifecycle;

import androidx.arch.core.util.Function;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001aB\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001aH\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0005H\u0086\b¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"X", "Landroidx/lifecycle/LiveData;", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "Y", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/Function1;)Landroidx/lifecycle/LiveData;", "switchMap", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TransformationsKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveData)) == null) {
            LiveData<X> distinctUntilChanged = Transformations.distinctUntilChanged(liveData);
            Intrinsics.checkExpressionValueIsNotNull(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
            return distinctUntilChanged;
        }
        return (LiveData) invokeL.objValue;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, final Function1<? super X, ? extends Y> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, liveData, function1)) == null) {
            LiveData<Y> map = Transformations.map(liveData, new Function<X, Y>(function1) { // from class: androidx.lifecycle.TransformationsKt$map$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $transform;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$transform = function1;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [Y, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r5v1, types: [Y, java.lang.Object] */
                @Override // androidx.arch.core.util.Function
                public final Y apply(X x) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, x)) == null) {
                        return this.$transform.invoke(x);
                    }
                    return invokeL.objValue;
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(map, "Transformations.map(this) { transform(it) }");
            return map;
        }
        return (LiveData) invokeLL.objValue;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final Function1<? super X, ? extends LiveData<Y>> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, liveData, function1)) == null) {
            LiveData<Y> switchMap = Transformations.switchMap(liveData, new Function<X, LiveData<Y>>(function1) { // from class: androidx.lifecycle.TransformationsKt$switchMap$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $transform;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$transform = function1;
                }

                @Override // androidx.arch.core.util.Function
                public /* bridge */ /* synthetic */ Object apply(Object obj) {
                    return apply((TransformationsKt$switchMap$1<I, O>) obj);
                }

                @Override // androidx.arch.core.util.Function
                public final LiveData<Y> apply(X x) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, x)) == null) {
                        return (LiveData) this.$transform.invoke(x);
                    }
                    return (LiveData) invokeL.objValue;
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMap(this) { transform(it) }");
            return switchMap;
        }
        return (LiveData) invokeLL.objValue;
    }
}
