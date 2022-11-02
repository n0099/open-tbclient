package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes2.dex */
public class PagerLayoutManager extends LinearLayoutManager implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEFAULT_SPEED = 70.0f;
    public static final float VERTICAL_OFFSET_DOWN = -10.0f;
    public static final float VERTICAL_OFFSET_UP = 10.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasDownTriggerSlide;
    public boolean hasForceSetPosition;
    public boolean hasUpTriggerSlide;
    public boolean isCanScroll;
    public int mFlipY;
    public int mLastMoveY;
    public PagerListener mPagerListener;
    public PagerHelper mPagerSnapHelper;
    public int mPosition;
    public RecyclerView mRecyclerView;
    public int mState;
    public RecyclerView.OnChildAttachStateChangeListener mStateChangeListener;
    public TouchListener mTouchListener;
    public boolean scroll;
    public int slideOffset;

    /* loaded from: classes2.dex */
    public interface TouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface PagerListener {
        void onAttachedToWindow(View view2);

        void onDetachedToWindow(View view2);

        void onPageScrolled(boolean z, int i, boolean z2, boolean z3);

        void onPageSelected(PageAction pageAction, int i, @Nullable View view2);

        void onScrollStateChanged(int i, int i2);

        void onStartPageScrolledOffset(boolean z, int i);

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes2.dex */
        public static final class PageAction {
            public static final /* synthetic */ PageAction[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final PageAction DOWN;
            public static final PageAction NONE;
            public static final PageAction UP;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-245902521, "Lcom/baidu/searchbox/live/widget/PagerLayoutManager$PagerListener$PageAction;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-245902521, "Lcom/baidu/searchbox/live/widget/PagerLayoutManager$PagerListener$PageAction;");
                        return;
                    }
                }
                UP = new PageAction("UP", 0);
                DOWN = new PageAction("DOWN", 1);
                PageAction pageAction = new PageAction(HlsPlaylistParser.METHOD_NONE, 2);
                NONE = pageAction;
                $VALUES = new PageAction[]{UP, DOWN, pageAction};
            }

            public PageAction(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static PageAction valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (PageAction) Enum.valueOf(PageAction.class, str);
                }
                return (PageAction) invokeL.objValue;
            }

            public static PageAction[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (PageAction[]) $VALUES.clone();
                }
                return (PageAction[]) invokeV.objValue;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class PagerHelper extends PagerSnapHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OrientationHelper mHorizontalHelper;
        public OrientationHelper mVerticalHelper;
        public final /* synthetic */ PagerLayoutManager this$0;

        public PagerHelper(PagerLayoutManager pagerLayoutManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerLayoutManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pagerLayoutManager;
        }

        private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, layoutManager)) == null) {
                if (this.mHorizontalHelper == null) {
                    this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
                }
                return this.mHorizontalHelper;
            }
            return (OrientationHelper) invokeL.objValue;
        }

        private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, layoutManager)) == null) {
                if (this.mVerticalHelper == null) {
                    this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
                }
                return this.mVerticalHelper;
            }
            return (OrientationHelper) invokeL.objValue;
        }

        private int distanceToCenter(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2, OrientationHelper orientationHelper) {
            InterceptResult invokeLLL;
            int end;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, layoutManager, view2, orientationHelper)) == null) {
                int decoratedStart = orientationHelper.getDecoratedStart(view2) + (orientationHelper.getDecoratedMeasurement(view2) / 2);
                if (layoutManager.getClipToPadding()) {
                    end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
                } else {
                    end = orientationHelper.getEnd() / 2;
                }
                return decoratedStart - end;
            }
            return invokeLLL.intValue;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, layoutManager, view2)) == null) {
                int[] iArr = new int[2];
                if (layoutManager.canScrollHorizontally()) {
                    iArr[0] = distanceToCenter(layoutManager, view2, getHorizontalHelper(layoutManager));
                } else {
                    iArr[0] = 0;
                }
                if (layoutManager.canScrollVertically()) {
                    iArr[1] = distanceToCenter(layoutManager, view2, getVerticalHelper(layoutManager));
                } else {
                    iArr[1] = 0;
                }
                this.this$0.mLastMoveY = iArr[1];
                return iArr;
            }
            return (int[]) invokeLL.objValue;
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutManager, i, i2)) == null) {
                int findTargetSnapPosition = super.findTargetSnapPosition(layoutManager, i, i2);
                if (findTargetSnapPosition <= 0 && this.this$0.mPosition == 0) {
                    return -1;
                }
                return findTargetSnapPosition;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class SimplePagerListener implements PagerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onDetachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onPageScrolled(boolean z, int i, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onPageSelected(PagerListener.PageAction pageAction, int i, @Nullable View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, pageAction, i, view2) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onScrollStateChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.live.widget.PagerLayoutManager.PagerListener
        public void onStartPageScrolledOffset(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        public SimplePagerListener() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerLayoutManager(Context context) {
        super(context, 1, false);
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
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPosition = -1;
        this.hasForceSetPosition = false;
        this.mLastMoveY = 0;
        this.scroll = true;
        this.isCanScroll = true;
        this.mState = 0;
        this.hasUpTriggerSlide = false;
        this.hasDownTriggerSlide = false;
        this.slideOffset = 0;
        this.mStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener(this) { // from class: com.baidu.searchbox.live.widget.PagerLayoutManager.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PagerLayoutManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && this.this$0.mPagerListener != null) {
                    this.this$0.mPagerListener.onDetachedToWindow(view2);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.this$0.mPagerListener != null) {
                    this.this$0.mPagerListener.onAttachedToWindow(view2);
                    if (this.this$0.getChildCount() == 1) {
                        this.this$0.mPagerListener.onPageSelected(PagerListener.PageAction.NONE, 0, view2);
                    }
                }
            }
        };
        init();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, recycler, state) == null) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnScrollChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, this, i) == null) {
            this.mState = i;
            if (i == 0) {
                this.hasDownTriggerSlide = false;
                this.hasUpTriggerSlide = false;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, recyclerView) == null) {
            super.onAttachedToWindow(recyclerView);
            this.mRecyclerView = recyclerView;
            this.mPosition = 0;
            this.mPagerSnapHelper.attachToRecyclerView(recyclerView);
            this.mRecyclerView.addOnChildAttachStateChangeListener(this.mStateChangeListener);
            this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.baidu.searchbox.live.widget.PagerLayoutManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PagerLayoutManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView2, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView2, i) == null) {
                        super.onScrollStateChanged(recyclerView2, i);
                        this.this$0.dispatchOnScrollChanged(i);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView2, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView2, i, i2) == null) {
                        super.onScrolled(recyclerView2, i, i2);
                        if (this.this$0.mState == 0 || this.this$0.mState == 2) {
                            this.this$0.slideOffset = 0;
                            return;
                        }
                        this.this$0.slideOffset += i2;
                        if (this.this$0.slideOffset > 10.0f && !this.this$0.hasUpTriggerSlide) {
                            this.this$0.hasUpTriggerSlide = true;
                            this.this$0.mPagerListener.onStartPageScrolledOffset(true, this.this$0.mPosition);
                        }
                        if (this.this$0.slideOffset <= -10.0f && !this.this$0.hasDownTriggerSlide) {
                            this.this$0.hasDownTriggerSlide = true;
                            this.this$0.mPagerListener.onStartPageScrolledOffset(false, this.this$0.mPosition);
                        }
                    }
                }
            });
        }
    }

    public void setIsCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.isCanScroll = z;
        }
    }

    public void setOnPagerListener(PagerListener pagerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pagerListener) == null) {
            this.mPagerListener = pagerListener;
        }
    }

    public void setScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.scroll = z;
        }
    }

    public void setTouchListener(TouchListener touchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, touchListener) == null) {
            this.mTouchListener = touchListener;
        }
    }

    public void updatePosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mPosition = i;
        }
    }

    private void dispatchScrollEvent() {
        int i;
        boolean z;
        boolean z2;
        PagerListener.PageAction pageAction;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65549, this) != null) || this.mPagerListener == null) {
            return;
        }
        View findSnapView = this.mPagerSnapHelper.findSnapView(this);
        boolean z3 = false;
        if (findSnapView != null) {
            i = getPosition(findSnapView);
        } else {
            i = 0;
        }
        PagerListener pagerListener = this.mPagerListener;
        if (this.mFlipY > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mPosition != i) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.mLastMoveY == 0) {
            z3 = true;
        }
        pagerListener.onPageScrolled(z, i, z2, z3);
        if (this.mLastMoveY == 0 && !canScrollVertically()) {
            return;
        }
        this.mPosition = i;
        if (this.mFlipY > 0) {
            pageAction = PagerListener.PageAction.UP;
        } else {
            pageAction = PagerListener.PageAction.DOWN;
        }
        this.mPagerListener.onPageSelected(pageAction, this.mPosition, findSnapView);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mPagerSnapHelper = new PagerHelper();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.scroll && this.isCanScroll) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void clearPageListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mPagerListener = null;
        }
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mPosition;
        }
        return invokeV.intValue;
    }

    public boolean isScrollerIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mState == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void snapToNext() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.mPosition + 1 < getItemCount()) {
            this.mLastMoveY = -1;
            this.mRecyclerView.smoothScrollToPosition(this.mPosition + 1);
        }
    }

    public void snapToPre() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i = this.mPosition;
            if (i - 1 >= 0) {
                this.mLastMoveY = -1;
                this.mRecyclerView.smoothScrollToPosition(i - 1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mState = i;
            if (this.mPagerListener == null) {
                return;
            }
            if (i != 0) {
                if (i == 2 && findFirstVisibleItemPosition() == 0 && this.mPosition > 0) {
                    this.mPosition = 0;
                    this.hasForceSetPosition = true;
                }
            } else {
                dispatchScrollEvent();
            }
            this.mPagerListener.onScrollStateChanged(i, this.mPosition);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view2, motionEvent)) == null) {
            if (canScrollVertically() && ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.mRecyclerView.getScrollState() != 0)) {
                dispatchScrollEvent();
            }
            TouchListener touchListener = this.mTouchListener;
            if (touchListener != null) {
                touchListener.onTouch(motionEvent);
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, recycler, state)) == null) {
            this.mFlipY = i;
            try {
                return super.scrollVerticallyBy(i, recycler, state);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeILL.intValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, recyclerView, state, i) == null) {
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, recyclerView.getContext()) { // from class: com.baidu.searchbox.live.widget.PagerLayoutManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PagerLayoutManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Context) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, displayMetrics)) == null) {
                        return 70.0f / displayMetrics.densityDpi;
                    }
                    return invokeL.floatValue;
                }
            };
            linearSmoothScroller.setTargetPosition(i);
            startSmoothScroll(linearSmoothScroller);
        }
    }
}
