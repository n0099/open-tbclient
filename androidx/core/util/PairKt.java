package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a4\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0005\u001a8\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001aH\u0010\n\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"F", ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "kotlin.jvm.PlatformType", "component1", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "Lkotlin/Pair;", "toAndroidPair", "(Lkotlin/Pair;)Landroid/util/Pair;", "toKotlinPair", "(Landroid/util/Pair;)Lkotlin/Pair;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class PairKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pair)) == null) ? (F) pair.first : (F) invokeL.objValue;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pair)) == null) ? (S) pair.second : (S) invokeL.objValue;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pair)) == null) ? new android.util.Pair<>(pair.getFirst(), pair.getSecond()) : (android.util.Pair) invokeL.objValue;
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pair)) == null) ? new kotlin.Pair<>(pair.first, pair.second) : (kotlin.Pair) invokeL.objValue;
    }
}
