package com.baidu.android.ext.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.SwipeCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SwipeListView extends ListView implements SwipeCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "SwipeListView";
    public transient /* synthetic */ FieldHolder $fh;
    public SwipeAdapter mAdapter;
    public boolean mIsOnMeasure;
    public OnChildDrawComplete mOnChildDrawComplete;
    public SwipeHelper mSwipeHelper;
    public SwipeCallback.SwipeScrollListener mSwipeScrollListener;
    public VersionedHelper mVersionedHelper;

    /* loaded from: classes.dex */
    public interface OnChildDrawComplete {
        void onComplete();
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // android.widget.AbsListView, android.view.View
    public int getVerticalScrollbarWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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
        this.mIsOnMeasure = false;
        this.mVersionedHelper = VersionedHelper.getInstance();
        this.mSwipeHelper = new SwipeHelper(0, this, DeviceUtil.ScreenInfo.getDensity(context), this.mVersionedHelper.getScaledPagingTouchSlop(getContext()));
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwipeCallback.SwipeScrollListener swipeScrollListener = this.mSwipeScrollListener;
            if (swipeScrollListener != null) {
                swipeScrollListener.computeScroll();
            }
            super.computeScroll();
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public SwipeAdapter getSwipeAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAdapter;
        }
        return (SwipeAdapter) invokeV.objValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public int getSwipeChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getChildCount();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public int getSwipeFirstVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return getFirstVisiblePosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public int getSwipeLastVisiblePosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return getLastVisiblePosition();
        }
        return invokeV.intValue;
    }

    public boolean isOnMeasure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mIsOnMeasure;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ListView, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onFinishInflate();
            setScrollbarFadingEnabled(true);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            try {
                super.dispatchDraw(canvas);
            } catch (Exception unused) {
            }
            OnChildDrawComplete onChildDrawComplete = this.mOnChildDrawComplete;
            if (onChildDrawComplete != null) {
                onChildDrawComplete.onComplete();
            }
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public View getSwipeChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return getChildAt(i);
        }
        return (View) invokeI.objValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public int getSwipeChildIndex(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            int childCount = getChildCount();
            int headerViewsCount = getHeaderViewsCount();
            for (int i = 0; i < childCount; i++) {
                if (view2 == getChildAt(i)) {
                    return (i + getFirstVisiblePosition()) - headerViewsCount;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public int getSwipeChildLeftAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return getChildAt(i).getLeft();
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public int getSwipeChildTopAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return getChildAt(i).getTop();
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public void onBeginDrag(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            requestDisallowInterceptTouchEvent(true);
            this.mVersionedHelper.setActivated(view2, true);
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public void onChildDismissed(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            this.mVersionedHelper.setAlpha(view2, 1.0f);
            this.mVersionedHelper.setTranslationX(view2, 0.0f);
            int swipeChildIndex = getSwipeChildIndex(view2);
            if (swipeChildIndex < 0) {
                return;
            }
            this.mAdapter.removeAndInsert(swipeChildIndex);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    @TargetApi(8)
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.mSwipeHelper.setDensityScale(DeviceUtil.ScreenInfo.getDensity(getContext()));
            this.mSwipeHelper.setPagingTouchSlop(this.mVersionedHelper.getScaledPagingTouchSlop(getContext()));
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public void onDragCancelled(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.mVersionedHelper.setActivated(view2, false);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, motionEvent)) == null) {
            if (!this.mSwipeHelper.onInterceptTouchEvent(motionEvent) && !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            if (!this.mSwipeHelper.onTouchEvent(motionEvent) && !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            this.mSwipeHelper.dismissChild(view2, 0.0f);
        }
    }

    public void setOnChildDrawCompleteListener(OnChildDrawComplete onChildDrawComplete) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onChildDrawComplete) == null) {
            this.mOnChildDrawComplete = onChildDrawComplete;
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public void setSwipeAdapter(SwipeAdapter swipeAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, swipeAdapter) == null) {
            this.mAdapter = swipeAdapter;
            super.setAdapter((ListAdapter) swipeAdapter);
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public void setSwipeScrollListener(SwipeCallback.SwipeScrollListener swipeScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, swipeScrollListener) == null) {
            this.mSwipeScrollListener = swipeScrollListener;
        }
    }

    @Override // com.baidu.android.ext.widget.SwipeCallback
    public View getSwipeChildAtPosition(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            float scrollX = i + getScrollX();
            float scrollY = i2 + getScrollY();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && scrollX >= childAt.getLeft() && scrollX < childAt.getRight() && scrollY >= childAt.getTop() && scrollY < childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mIsOnMeasure = false;
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            this.mIsOnMeasure = true;
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048598, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            SwipeCallback.SwipeScrollListener swipeScrollListener = this.mSwipeScrollListener;
            if (swipeScrollListener != null) {
                swipeScrollListener.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.mVersionedHelper.isTransitionRunning(this)) {
            }
        }
    }
}
