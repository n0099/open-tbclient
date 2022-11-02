package com.baidu.nadcore.player.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.fy0;
import com.baidu.tieba.vz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/baidu/nadcore/player/model/HistoryCache;", "Ljava/util/ArrayList;", "Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;", "element", "", "add", "(Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;)Z", "", "id", TiebaStatic.Params.VID, "findCache", "(Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;", "info", "isSameHistory", "(Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;Ljava/lang/String;Ljava/lang/String;)Z", "removeCache", "<init>", "()V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class HistoryCache extends ArrayList<fy0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryCache() {
        super(20);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public /* bridge */ int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return super.size();
        }
        return invokeV.intValue;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return getSize();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.b(), r6) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSameHistory(fy0 fy0Var, String str, String str2) {
        InterceptResult invokeLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, fy0Var, str, str2)) == null) {
            String b = fy0Var.b();
            if (b != null) {
                if (b.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                }
            }
            String e = fy0Var.e();
            if (e == null) {
                return false;
            }
            if (e.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !Intrinsics.areEqual(fy0Var.e(), str2)) {
                return false;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(fy0 element) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, element)) == null) {
            Intrinsics.checkNotNullParameter(element, "element");
            if (size() >= 50) {
                vz0.a("remove item " + remove(0));
            }
            removeCache(element.b(), element.e());
            return super.add((HistoryCache) element);
        }
        return invokeL.booleanValue;
    }

    public /* bridge */ boolean contains(fy0 fy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fy0Var)) == null) {
            return super.contains((Object) fy0Var);
        }
        return invokeL.booleanValue;
    }

    public /* bridge */ int indexOf(fy0 fy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fy0Var)) == null) {
            return super.indexOf((Object) fy0Var);
        }
        return invokeL.intValue;
    }

    public /* bridge */ int lastIndexOf(fy0 fy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fy0Var)) == null) {
            return super.lastIndexOf((Object) fy0Var);
        }
        return invokeL.intValue;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ fy0 remove(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return removeAt(i);
        }
        return (fy0) invokeI.objValue;
    }

    public /* bridge */ fy0 removeAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            return (fy0) super.remove(i);
        }
        return (fy0) invokeI.objValue;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof fy0) {
                return contains((fy0) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof fy0) {
                return indexOf((fy0) obj);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj instanceof fy0) {
                return lastIndexOf((fy0) obj);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public /* bridge */ boolean remove(fy0 fy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fy0Var)) == null) {
            return super.remove((Object) fy0Var);
        }
        return invokeL.booleanValue;
    }

    public final fy0 findCache(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            for (fy0 fy0Var : this) {
                if (isSameHistory(fy0Var, str, str2)) {
                    return fy0Var;
                }
            }
            return null;
        }
        return (fy0) invokeLL.objValue;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj instanceof fy0) {
                return remove((fy0) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final fy0 removeCache(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            Iterator<fy0> it = iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator()");
            while (it.hasNext()) {
                fy0 next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                fy0 fy0Var = next;
                if (isSameHistory(fy0Var, str, str2)) {
                    it.remove();
                    return fy0Var;
                }
            }
            return null;
        }
        return (fy0) invokeLL.objValue;
    }
}
