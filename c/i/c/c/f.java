package c.i.c.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Range;
import java.lang.Comparable;
/* loaded from: classes3.dex */
public abstract class f<C extends Comparable> implements b1<C> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void add(Range<C> range);

    public void addAll(b1<C> b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b1Var) == null) {
            addAll(b1Var.asRanges());
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            remove(Range.all());
        }
    }

    public boolean contains(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c2)) == null) ? rangeContaining(c2) != null : invokeL.booleanValue;
    }

    @Override // c.i.c.c.b1
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(b1<C> b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, b1Var)) == null) ? enclosesAll(b1Var.asRanges()) : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b1) {
                return asRanges().equals(((b1) obj).asRanges());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? asRanges().hashCode() : invokeV.intValue;
    }

    public abstract boolean intersects(Range<C> range);

    @Override // c.i.c.c.b1
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? asRanges().isEmpty() : invokeV.booleanValue;
    }

    public abstract Range<C> rangeContaining(C c2);

    public abstract void remove(Range<C> range);

    @Override // c.i.c.c.b1
    public void removeAll(b1<C> b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b1Var) == null) {
            removeAll(b1Var.asRanges());
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? asRanges().toString() : (String) invokeV.objValue;
    }

    public void addAll(Iterable<Range<C>> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable) == null) {
            for (Range<C> range : iterable) {
                add(range);
            }
        }
    }

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iterable)) == null) {
            for (Range<C> range : iterable) {
                if (!encloses(range)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeAll(Iterable<Range<C>> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iterable) == null) {
            for (Range<C> range : iterable) {
                remove(range);
            }
        }
    }
}
