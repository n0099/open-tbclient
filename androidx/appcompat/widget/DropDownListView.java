package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class DropDownListView extends ListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPropertyAnimatorCompat mClickAnimation;
    public boolean mDrawsInPressedState;
    public boolean mHijackFocus;
    public Field mIsChildViewEnabled;
    public boolean mListSelectionHidden;
    public int mMotionPosition;
    public ResolveHoverRunnable mResolveHoverRunnable;
    public ListViewAutoScrollHelper mScrollHelper;
    public int mSelectionBottomPadding;
    public int mSelectionLeftPadding;
    public int mSelectionRightPadding;
    public int mSelectionTopPadding;
    public GateKeeperDrawable mSelector;
    public final Rect mSelectorRect;

    /* loaded from: classes.dex */
    public static class GateKeeperDrawable extends DrawableWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {drawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Drawable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.mEnabled) {
                super.draw(canvas);
            }
        }

        public void setEnabled(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.mEnabled = z;
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
                if (this.mEnabled) {
                    return super.setState(iArr);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && this.mEnabled) {
                super.setHotspot(f, f2);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                if (this.mEnabled) {
                    return super.setVisible(z, z2);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) && this.mEnabled) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ResolveHoverRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DropDownListView this$0;

        public ResolveHoverRunnable(DropDownListView dropDownListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dropDownListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dropDownListView;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DropDownListView dropDownListView = this.this$0;
                dropDownListView.mResolveHoverRunnable = null;
                dropDownListView.removeCallbacks(this);
            }
        }

        public void post() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                DropDownListView dropDownListView = this.this$0;
                dropDownListView.mResolveHoverRunnable = null;
                dropDownListView.drawableStateChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownListView(@NonNull Context context, boolean z) {
        super(context, null, R.attr.obfuscated_res_0x7f040264);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.mIsChildViewEnabled = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void positionSelectorCompat(int i, View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, view2) == null) {
            Rect rect = this.mSelectorRect;
            rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            rect.left -= this.mSelectionLeftPadding;
            rect.top -= this.mSelectionTopPadding;
            rect.right += this.mSelectionRightPadding;
            rect.bottom += this.mSelectionBottomPadding;
            try {
                boolean z2 = this.mIsChildViewEnabled.getBoolean(this);
                if (view2.isEnabled() != z2) {
                    Field field = this.mIsChildViewEnabled;
                    if (!z2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    field.set(this, Boolean.valueOf(z));
                    if (i != -1) {
                        refreshDrawableState();
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public int lookForSelectablePosition(int i, boolean z) {
        InterceptResult invokeCommon;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ListAdapter adapter = getAdapter();
            if (adapter != null && !isInTouchMode()) {
                int count = adapter.getCount();
                if (!getAdapter().areAllItemsEnabled()) {
                    if (z) {
                        min = Math.max(0, i);
                        while (min < count && !adapter.isEnabled(min)) {
                            min++;
                        }
                    } else {
                        min = Math.min(i, count - 1);
                        while (min >= 0 && !adapter.isEnabled(min)) {
                            min--;
                        }
                    }
                    if (min < 0 || min >= count) {
                        return -1;
                    }
                    return min;
                } else if (i >= 0 && i < count) {
                    return i;
                }
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 != 3) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, motionEvent, i)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    z = true;
                }
            } else {
                z = false;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex >= 0) {
                int x = (int) motionEvent.getX(findPointerIndex);
                int y = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, y);
                if (pointToPosition == -1) {
                    z2 = true;
                    if (z || z2) {
                        clearPressedItem();
                    }
                    if (z) {
                        if (this.mScrollHelper == null) {
                            this.mScrollHelper = new ListViewAutoScrollHelper(this);
                        }
                        this.mScrollHelper.setEnabled(true);
                        this.mScrollHelper.onTouch(this, motionEvent);
                    } else {
                        ListViewAutoScrollHelper listViewAutoScrollHelper = this.mScrollHelper;
                        if (listViewAutoScrollHelper != null) {
                            listViewAutoScrollHelper.setEnabled(false);
                        }
                    }
                    return z;
                }
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                setPressedItem(childAt, pointToPosition, x, y);
                if (actionMasked == 1) {
                    clickPressedItem(childAt, pointToPosition);
                }
                z2 = false;
                z = true;
                if (z) {
                }
                clearPressedItem();
                if (z) {
                }
                return z;
            }
            z2 = false;
            z = false;
            if (z) {
            }
            clearPressedItem();
            if (z) {
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    private void clearPressedItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mDrawsInPressedState = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mClickAnimation;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
                this.mClickAnimation = null;
            }
        }
    }

    private void clickPressedItem(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view2, i) == null) {
            performItemClick(view2, i, getItemIdAtPosition(i));
        }
    }

    private void drawSelectorCompat(Canvas canvas) {
        Drawable selector;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, canvas) == null) && !this.mSelectorRect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.mSelectorRect);
            selector.draw(canvas);
        }
    }

    private void setSelectorEnabled(boolean z) {
        GateKeeperDrawable gateKeeperDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && (gateKeeperDrawable = this.mSelector) != null) {
            gateKeeperDrawable.setEnabled(z);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            drawSelectorCompat(canvas);
            super.dispatchDraw(canvas);
        }
    }

    public void setListSelectionHidden(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mListSelectionHidden = z;
        }
    }

    private void positionSelectorLikeFocusCompat(int i, View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, this, i, view2) == null) {
            Drawable selector = getSelector();
            boolean z2 = true;
            if (selector != null && i != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                selector.setVisible(false, false);
            }
            positionSelectorCompat(i, view2);
            if (z) {
                Rect rect = this.mSelectorRect;
                float exactCenterX = rect.exactCenterX();
                float exactCenterY = rect.exactCenterY();
                if (getVisibility() != 0) {
                    z2 = false;
                }
                selector.setVisible(z2, false);
                DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
            }
        }
    }

    private void positionSelectorLikeTouchCompat(int i, View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i), view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            positionSelectorLikeFocusCompat(i, view2);
            Drawable selector = getSelector();
            if (selector != null && i != -1) {
                DrawableCompat.setHotspot(selector, f, f2);
            }
        }
    }

    private void setPressedItem(View view2, int i, float f, float f2) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{view2, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mDrawsInPressedState = true;
            if (Build.VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            int i2 = this.mMotionPosition;
            if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view2 && childAt.isPressed()) {
                childAt.setPressed(false);
            }
            this.mMotionPosition = i;
            float left = f - view2.getLeft();
            float top = f2 - view2.getTop();
            if (Build.VERSION.SDK_INT >= 21) {
                view2.drawableHotspotChanged(left, top);
            }
            if (!view2.isPressed()) {
                view2.setPressed(true);
            }
            positionSelectorLikeTouchCompat(i, view2, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return this.mDrawsInPressedState;
        }
        return invokeV.booleanValue;
    }

    private void updateSelectorStateCompat() {
        Drawable selector;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && (selector = getSelector()) != null && touchModeDrawsInPressedStateCompat() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.mResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.mHijackFocus && !super.hasFocus()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.mHijackFocus && !super.hasWindowFocus()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.mHijackFocus && !super.isFocused()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if ((this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mResolveHoverRunnable = null;
            super.onDetachedFromWindow();
        }
    }

    public int measureHeightOfChildrenCompat(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return listPaddingTop + listPaddingBottom;
            }
            int i6 = listPaddingTop + listPaddingBottom;
            dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
            int count = adapter.getCount();
            View view2 = null;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < count; i9++) {
                int itemViewType = adapter.getItemViewType(i9);
                if (itemViewType != i7) {
                    view2 = null;
                    i7 = itemViewType;
                }
                view2 = adapter.getView(i9, view2, this);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                    view2.setLayoutParams(layoutParams);
                }
                int i10 = layoutParams.height;
                if (i10 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                view2.measure(i, makeMeasureSpec);
                view2.forceLayout();
                if (i9 > 0) {
                    i6 += dividerHeight;
                }
                i6 += view2.getMeasuredHeight();
                if (i6 >= i4) {
                    if (i5 >= 0 && i9 > i5 && i8 > 0 && i6 != i4) {
                        return i8;
                    }
                    return i4;
                }
                if (i5 >= 0 && i9 >= i5) {
                    i8 = i6;
                }
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onHoverEvent(motionEvent);
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
                ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable(this);
                this.mResolveHoverRunnable = resolveHoverRunnable;
                resolveHoverRunnable.post();
            }
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked != 9 && actionMasked != 7) {
                setSelection(-1);
            } else {
                int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    if (childAt.isEnabled()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    }
                    updateSelectorStateCompat();
                }
            }
            return onHoverEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
            if (resolveHoverRunnable != null) {
                resolveHoverRunnable.cancel();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            if (drawable != null) {
                gateKeeperDrawable = new GateKeeperDrawable(drawable);
            } else {
                gateKeeperDrawable = null;
            }
            this.mSelector = gateKeeperDrawable;
            super.setSelector(gateKeeperDrawable);
            Rect rect = new Rect();
            if (drawable != null) {
                drawable.getPadding(rect);
            }
            this.mSelectionLeftPadding = rect.left;
            this.mSelectionTopPadding = rect.top;
            this.mSelectionRightPadding = rect.right;
            this.mSelectionBottomPadding = rect.bottom;
        }
    }
}
