package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\u000b\u001a\u00020\t*\u00020\u00002!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\t0\u0006H\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001aL\u0010\u0010\u001a\u00020\t*\u00020\u000026\u0010\n\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\t0\rH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001a\u0010\u001b\"\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0018\u0010\"\u001a\u00020\u000e*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroid/view/Menu;", "Landroid/view/MenuItem;", "item", "", "contains", "(Landroid/view/Menu;Landroid/view/MenuItem;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/view/Menu;Lkotlin/Function1;)V", "Lkotlin/Function2;", "", "index", "forEachIndexed", "(Landroid/view/Menu;Lkotlin/Function2;)V", "get", "(Landroid/view/Menu;I)Landroid/view/MenuItem;", "isEmpty", "(Landroid/view/Menu;)Z", "isNotEmpty", "", "iterator", "(Landroid/view/Menu;)Ljava/util/Iterator;", "minusAssign", "(Landroid/view/Menu;Landroid/view/MenuItem;)V", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", CriusAttrConstants.CHILDREN, "getSize", "(Landroid/view/Menu;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class MenuKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, menu, menuItem)) == null) {
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(menu.getItem(i), menuItem)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, menu, function1) == null) {
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
                function1.invoke(item);
            }
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, menu, function2) == null) {
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                Integer valueOf = Integer.valueOf(i);
                MenuItem item = menu.getItem(i);
                Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
                function2.invoke(valueOf, item);
            }
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, menu, i)) == null) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            return item;
        }
        return (MenuItem) invokeLI.objValue;
    }

    public static final Sequence<MenuItem> getChildren(final Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, menu)) == null) ? new Sequence<MenuItem>(menu) { // from class: androidx.core.view.MenuKt$children$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Menu $this_children;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {menu};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$this_children = menu;
            }

            @Override // kotlin.sequences.Sequence
            public Iterator<MenuItem> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? MenuKt.iterator(this.$this_children) : (Iterator) invokeV.objValue;
            }
        } : (Sequence) invokeL.objValue;
    }

    public static final int getSize(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, menu)) == null) ? menu.size() : invokeL.intValue;
    }

    public static final boolean isEmpty(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, menu)) == null) ? menu.size() == 0 : invokeL.booleanValue;
    }

    public static final boolean isNotEmpty(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, menu)) == null) ? menu.size() != 0 : invokeL.booleanValue;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, menu)) == null) ? new MenuKt$iterator$1(menu) : (Iterator) invokeL.objValue;
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, menu, menuItem) == null) {
            menu.removeItem(menuItem.getItemId());
        }
    }
}
