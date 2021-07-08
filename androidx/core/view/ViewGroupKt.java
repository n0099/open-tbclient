package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\u000b\u001a\u00020\t*\u00020\u00002!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\t0\u0006H\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001aL\u0010\u0010\u001a\u00020\t*\u00020\u000026\u0010\n\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\t0\rH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001c\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001c\u0010\u001b\u001a\u001e\u0010\u001f\u001a\u00020\t*\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u001f\u0010 \u001a<\u0010%\u001a\u00020\t*\u00020\u001d2\b\b\u0003\u0010!\u001a\u00020\u000e2\b\b\u0003\u0010\"\u001a\u00020\u000e2\b\b\u0003\u0010#\u001a\u00020\u000e2\b\b\u0003\u0010$\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b%\u0010&\u001a<\u0010)\u001a\u00020\t*\u00020\u001d2\b\b\u0003\u0010'\u001a\u00020\u000e2\b\b\u0003\u0010\"\u001a\u00020\u000e2\b\b\u0003\u0010(\u001a\u00020\u000e2\b\b\u0003\u0010$\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b)\u0010&\"\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010**\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0018\u0010\u001e\u001a\u00020\u000e*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Landroid/view/ViewGroup;", "Landroid/view/View;", "view", "", "contains", "(Landroid/view/ViewGroup;Landroid/view/View;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Landroid/view/ViewGroup;Lkotlin/Function1;)V", "Lkotlin/Function2;", "", "index", "forEachIndexed", "(Landroid/view/ViewGroup;Lkotlin/Function2;)V", "get", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "isEmpty", "(Landroid/view/ViewGroup;)Z", "isNotEmpty", "", "iterator", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "minusAssign", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "plusAssign", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "setMargins", "(Landroid/view/ViewGroup$MarginLayoutParams;I)V", CustomDialogData.POS_LEFT, "top", "right", TipsConfigItem.TipConfigData.BOTTOM, "updateMargins", "(Landroid/view/ViewGroup$MarginLayoutParams;IIII)V", "start", "end", "updateMarginsRelative", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "children", "getSize", "(Landroid/view/ViewGroup;)I", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ViewGroupKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean contains(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, viewGroup, view)) == null) ? viewGroup.indexOfChild(view) != -1 : invokeLL.booleanValue;
    }

    public static final void forEach(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, viewGroup, function1) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
                function1.invoke(childAt);
            }
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, viewGroup, function2) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Integer valueOf = Integer.valueOf(i2);
                View childAt = viewGroup.getChildAt(i2);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(index)");
                function2.invoke(valueOf, childAt);
            }
        }
    }

    public static final View get(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, viewGroup, i2)) == null) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
        }
        return (View) invokeLI.objValue;
    }

    public static final Sequence<View> getChildren(final ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) ? new Sequence<View>(viewGroup) { // from class: androidx.core.view.ViewGroupKt$children$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewGroup $this_children;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {viewGroup};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.$this_children = viewGroup;
            }

            @Override // kotlin.sequences.Sequence
            public Iterator<View> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? ViewGroupKt.iterator(this.$this_children) : (Iterator) invokeV.objValue;
            }
        } : (Sequence) invokeL.objValue;
    }

    public static final int getSize(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, viewGroup)) == null) ? viewGroup.getChildCount() : invokeL.intValue;
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, viewGroup)) == null) ? viewGroup.getChildCount() == 0 : invokeL.booleanValue;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, viewGroup)) == null) ? viewGroup.getChildCount() != 0 : invokeL.booleanValue;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, viewGroup)) == null) ? new ViewGroupKt$iterator$1(viewGroup) : (Iterator) invokeL.objValue;
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, viewGroup, view) == null) {
            viewGroup.removeView(view);
        }
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, viewGroup, view) == null) {
            viewGroup.addView(view);
        }
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, marginLayoutParams, i2) == null) {
            marginLayoutParams.setMargins(i2, i2, i2, i2);
        }
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{marginLayoutParams, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            marginLayoutParams.setMargins(i2, i3, i4, i5);
        }
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{marginLayoutParams, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            marginLayoutParams.setMarginStart(i2);
            marginLayoutParams.topMargin = i3;
            marginLayoutParams.setMarginEnd(i4);
            marginLayoutParams.bottomMargin = i5;
        }
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
