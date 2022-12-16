package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GENERATED_ITEM_PADDING = 4;
    public static final int MIN_CELL_SIZE = 56;
    public static final String TAG = "ActionMenuView";
    public transient /* synthetic */ FieldHolder $fh;
    public MenuPresenter.Callback mActionMenuPresenterCallback;
    public boolean mFormatItems;
    public int mFormatItemsWidth;
    public int mGeneratedItemPadding;
    public MenuBuilder mMenu;
    public MenuBuilder.Callback mMenuBuilderCallback;
    public int mMinCellSize;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public Context mPopupContext;
    public int mPopupTheme;
    public ActionMenuPresenter mPresenter;
    public boolean mReserveOverflow;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accessibilityEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, menuBuilder, z) == null) {
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public ActionMenuPresenterCallback() {
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
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        public boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isOverflowButton = false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.isOverflowButton = z;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.isOverflowButton = layoutParams.isOverflowButton;
        }
    }

    /* loaded from: classes.dex */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActionMenuView this$0;

        public MenuBuilderCallback(ActionMenuView actionMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = actionMenuView;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder) == null) && (callback = this.this$0.mMenuBuilderCallback) != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, menuBuilder, menuItem)) == null) {
                OnMenuItemClickListener onMenuItemClickListener = this.this$0.mOnMenuItemClickListener;
                if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem)) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionMenuView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, layoutParams)) == null) {
            if (layoutParams != null) {
                if (layoutParams instanceof LayoutParams) {
                    layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
                } else {
                    layoutParams2 = new LayoutParams(layoutParams);
                }
                if (layoutParams2.gravity <= 0) {
                    layoutParams2.gravity = 16;
                }
                return layoutParams2;
            }
            return generateDefaultLayoutParams();
        }
        return (LayoutParams) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean hasSupportDividerBeforeChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            boolean z = false;
            if (i == 0) {
                return false;
            }
            View childAt = getChildAt(i - 1);
            View childAt2 = getChildAt(i);
            if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
                z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
            }
            if (i > 0 && (childAt2 instanceof ActionMenuChildView)) {
                return z | ((ActionMenuChildView) childAt2).needsDividerBefore();
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        MenuBuilder menuBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) {
            boolean z2 = this.mFormatItems;
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                z = true;
            } else {
                z = false;
            }
            this.mFormatItems = z;
            if (z2 != z) {
                this.mFormatItemsWidth = 0;
            }
            int size = View.MeasureSpec.getSize(i);
            if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
                this.mFormatItemsWidth = size;
                menuBuilder.onItemsChanged(true);
            }
            int childCount = getChildCount();
            if (this.mFormatItems && childCount > 0) {
                onMeasureExactFormat(i, i2);
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
            }
            super.onMeasure(i, i2);
        }
    }

    public static int measureChildForCells(View view2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        ActionMenuItemView actionMenuItemView;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
            if (view2 instanceof ActionMenuItemView) {
                actionMenuItemView = (ActionMenuItemView) view2;
            } else {
                actionMenuItemView = null;
            }
            boolean z2 = true;
            if (actionMenuItemView != null && actionMenuItemView.hasText()) {
                z = true;
            } else {
                z = false;
            }
            int i5 = 2;
            if (i2 > 0 && (!z || i2 >= 2)) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view2.getMeasuredWidth();
                int i6 = measuredWidth / i;
                if (measuredWidth % i != 0) {
                    i6++;
                }
                if (!z || i6 >= 2) {
                    i5 = i6;
                }
            } else {
                i5 = 0;
            }
            layoutParams.expandable = (layoutParams.isOverflowButton || !z) ? false : false;
            layoutParams.cellsUsed = i5;
            view2.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
            return i5;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [int, boolean] */
    private void onMeasureExactFormat(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        ?? r14;
        boolean z6;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
            int i10 = size - paddingLeft;
            int i11 = this.mMinCellSize;
            int i12 = i10 / i11;
            int i13 = i10 % i11;
            if (i12 == 0) {
                setMeasuredDimension(i10, 0);
                return;
            }
            int i14 = i11 + (i13 / i12);
            int childCount = getChildCount();
            int i15 = 0;
            int i16 = 0;
            boolean z7 = false;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            long j = 0;
            while (i16 < childCount) {
                View childAt = getChildAt(i16);
                int i20 = size2;
                if (childAt.getVisibility() != 8) {
                    boolean z8 = childAt instanceof ActionMenuItemView;
                    int i21 = i17 + 1;
                    if (z8) {
                        int i22 = this.mGeneratedItemPadding;
                        i8 = i21;
                        r14 = 0;
                        childAt.setPadding(i22, 0, i22, 0);
                    } else {
                        i8 = i21;
                        r14 = 0;
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.expanded = r14;
                    layoutParams.extraPixels = r14;
                    layoutParams.cellsUsed = r14;
                    layoutParams.expandable = r14;
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = r14;
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = r14;
                    if (z8 && ((ActionMenuItemView) childAt).hasText()) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    layoutParams.preventEdgeOffset = z6;
                    if (layoutParams.isOverflowButton) {
                        i9 = 1;
                    } else {
                        i9 = i12;
                    }
                    int measureChildForCells = measureChildForCells(childAt, i14, i9, childMeasureSpec, paddingTop);
                    i18 = Math.max(i18, measureChildForCells);
                    if (layoutParams.expandable) {
                        i19++;
                    }
                    if (layoutParams.isOverflowButton) {
                        z7 = true;
                    }
                    i12 -= measureChildForCells;
                    i15 = Math.max(i15, childAt.getMeasuredHeight());
                    if (measureChildForCells == 1) {
                        j |= 1 << i16;
                        i15 = i15;
                    }
                    i17 = i8;
                }
                i16++;
                size2 = i20;
            }
            int i23 = size2;
            if (z7 && i17 == 2) {
                z = true;
            } else {
                z = false;
            }
            boolean z9 = false;
            while (i19 > 0 && i12 > 0) {
                int i24 = 0;
                int i25 = 0;
                int i26 = Integer.MAX_VALUE;
                long j2 = 0;
                while (i25 < childCount) {
                    boolean z10 = z9;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i25).getLayoutParams();
                    int i27 = i15;
                    if (layoutParams2.expandable) {
                        int i28 = layoutParams2.cellsUsed;
                        if (i28 < i26) {
                            j2 = 1 << i25;
                            i26 = i28;
                            i24 = 1;
                        } else if (i28 == i26) {
                            i24++;
                            j2 |= 1 << i25;
                        }
                    }
                    i25++;
                    i15 = i27;
                    z9 = z10;
                }
                z2 = z9;
                i5 = i15;
                j |= j2;
                if (i24 > i12) {
                    i3 = mode;
                    i4 = i10;
                    break;
                }
                int i29 = i26 + 1;
                int i30 = 0;
                while (i30 < childCount) {
                    View childAt2 = getChildAt(i30);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i31 = i10;
                    int i32 = mode;
                    long j3 = 1 << i30;
                    if ((j2 & j3) == 0) {
                        if (layoutParams3.cellsUsed == i29) {
                            j |= j3;
                        }
                        z5 = z;
                    } else {
                        if (z && layoutParams3.preventEdgeOffset && i12 == 1) {
                            int i33 = this.mGeneratedItemPadding;
                            z5 = z;
                            childAt2.setPadding(i33 + i14, 0, i33, 0);
                        } else {
                            z5 = z;
                        }
                        layoutParams3.cellsUsed++;
                        layoutParams3.expanded = true;
                        i12--;
                    }
                    i30++;
                    mode = i32;
                    i10 = i31;
                    z = z5;
                }
                i15 = i5;
                z9 = true;
            }
            i3 = mode;
            i4 = i10;
            z2 = z9;
            i5 = i15;
            if (!z7 && i17 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (i12 > 0 && j != 0 && (i12 < i17 - 1 || z3 || i18 > 1)) {
                float bitCount = Long.bitCount(j);
                if (!z3) {
                    if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                    int i34 = childCount - 1;
                    if ((j & (1 << i34)) != 0 && !((LayoutParams) getChildAt(i34).getLayoutParams()).preventEdgeOffset) {
                        bitCount -= 0.5f;
                    }
                }
                if (bitCount > 0.0f) {
                    i7 = (int) ((i12 * i14) / bitCount);
                } else {
                    i7 = 0;
                }
                z4 = z2;
                for (int i35 = 0; i35 < childCount; i35++) {
                    if ((j & (1 << i35)) != 0) {
                        View childAt3 = getChildAt(i35);
                        LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            layoutParams4.extraPixels = i7;
                            layoutParams4.expanded = true;
                            if (i35 == 0 && !layoutParams4.preventEdgeOffset) {
                                ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (-i7) / 2;
                            }
                        } else if (layoutParams4.isOverflowButton) {
                            layoutParams4.extraPixels = i7;
                            layoutParams4.expanded = true;
                            ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (-i7) / 2;
                        } else {
                            if (i35 != 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = i7 / 2;
                            }
                            if (i35 != childCount - 1) {
                                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = i7 / 2;
                            }
                        }
                        z4 = true;
                    }
                }
            } else {
                z4 = z2;
            }
            if (z4) {
                for (int i36 = 0; i36 < childCount; i36++) {
                    View childAt4 = getChildAt(i36);
                    LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                    if (layoutParams5.expanded) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i14) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                    }
                }
            }
            if (i3 != 1073741824) {
                i6 = i5;
            } else {
                i6 = i23;
            }
            setMeasuredDimension(i4, i6);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void initialize(MenuBuilder menuBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, menuBuilder) == null) {
            this.mMenu = menuBuilder;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, menuItemImpl)) == null) {
            return this.mMenu.performItemAction(menuItemImpl, 0);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.updateMenuView(false);
                if (this.mPresenter.isOverflowMenuShowing()) {
                    this.mPresenter.hideOverflowMenu();
                    this.mPresenter.showOverflowMenu();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mPresenter.setExpandedActionViewsExclusive(z);
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onMenuItemClickListener) == null) {
            this.mOnMenuItemClickListener = onMenuItemClickListener;
        }
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) {
            getMenu();
            this.mPresenter.setOverflowIcon(drawable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.mReserveOverflow = z;
        }
    }

    public void setPopupTheme(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, actionMenuPresenter) == null) {
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setMenuView(this);
        }
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (actionMenuPresenter = this.mPresenter) != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams generateOverflowButtonLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.isOverflowButton = true;
            return generateDefaultLayoutParams;
        }
        return (LayoutParams) invokeV.objValue;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            getMenu();
            return this.mPresenter.getOverflowIcon();
        }
        return (Drawable) invokeV.objValue;
    }

    public int getPopupTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mPopupTheme;
        }
        return invokeV.intValue;
    }

    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            if (actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            if (actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            if (actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowReserved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mReserveOverflow;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDetachedFromWindow();
            dismissPopupMenus();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder peekMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.mMenu;
        }
        return (MenuBuilder) invokeV.objValue;
    }

    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            if (actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            return layoutParams;
        }
        return (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) invokeL.objValue;
    }

    public Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mMenu == null) {
                Context context = getContext();
                MenuBuilder menuBuilder = new MenuBuilder(context);
                this.mMenu = menuBuilder;
                menuBuilder.setCallback(new MenuBuilderCallback(this));
                ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
                this.mPresenter = actionMenuPresenter;
                actionMenuPresenter.setReserveOverflow(true);
                ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
                MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
                if (callback == null) {
                    callback = new ActionMenuPresenterCallback();
                }
                actionMenuPresenter2.setCallback(callback);
                this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
                this.mPresenter.setMenuView(this);
            }
            return this.mMenu;
        }
        return (Menu) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (!this.mFormatItems) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = i3 - i;
            int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isOverflowButton) {
                        int measuredWidth = childAt.getMeasuredWidth();
                        if (hasSupportDividerBeforeChildAt(i11)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (isLayoutRtl) {
                            i6 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                            width = i6 + measuredWidth;
                        } else {
                            width = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            i6 = width - measuredWidth;
                        }
                        int i12 = i7 - (measuredHeight / 2);
                        childAt.layout(i6, i12, width, measuredHeight + i12);
                        paddingRight -= measuredWidth;
                        i9 = 1;
                    } else {
                        paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        hasSupportDividerBeforeChildAt(i11);
                        i10++;
                    }
                }
            }
            if (childCount == 1 && i9 == 0) {
                View childAt2 = getChildAt(0);
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i13 = (i8 / 2) - (measuredWidth2 / 2);
                int i14 = i7 - (measuredHeight2 / 2);
                childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
                return;
            }
            int i15 = i10 - (i9 ^ 1);
            if (i15 > 0) {
                i5 = paddingRight / i15;
            } else {
                i5 = 0;
            }
            int max = Math.max(0, i5);
            if (isLayoutRtl) {
                int width2 = getWidth() - getPaddingRight();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt3 = getChildAt(i16);
                    LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                        int i17 = width2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        int measuredWidth3 = childAt3.getMeasuredWidth();
                        int measuredHeight3 = childAt3.getMeasuredHeight();
                        int i18 = i7 - (measuredHeight3 / 2);
                        childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                        width2 = i17 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + max);
                    }
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt4 = getChildAt(i19);
                LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                    int i20 = paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i21 = i7 - (measuredHeight4 / 2);
                    childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                    paddingLeft = i20 + measuredWidth4 + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + max;
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, callback, callback2) == null) {
            this.mActionMenuPresenterCallback = callback;
            this.mMenuBuilderCallback = callback2;
        }
    }
}
