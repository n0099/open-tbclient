package com.baidu.pass.ecommerce.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ScrollLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DRAG_SPEED_MULTIPLIER = 1.2f;
    public static final int DRAG_SPEED_SLOP = 30;
    public static final int FLING_VELOCITY_SLOP = 80;
    public static final int MAX_SCROLL_DURATION = 400;
    public static final int MIN_SCROLL_DURATION = 100;
    public static final int MOTION_DISTANCE_SLOP = 10;
    public static final float SCROLL_TO_CLOSE_OFFSET_FACTOR = 0.5f;
    public static final float SCROLL_TO_EXIT_OFFSET_FACTOR = 0.8f;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView.OnScrollListener associatedRecyclerViewListener;
    public int contentHeight;
    public InnerStatus currentInnerStatus;
    public int exitOffset;
    public GestureDetector gestureDetector;
    public final GestureDetector.OnGestureListener gestureListener;
    public boolean isAllowHorizontalScroll;
    public boolean isAllowPointerIntercepted;
    public boolean isCurrentPointerIntercepted;
    public boolean isDraggable;
    public boolean isEnable;
    public boolean isSupportExit;
    public float lastDownX;
    public float lastDownY;
    public Status lastFlingStatus;
    public float lastY;
    public int maxOffset;
    public OnScrollChangedListener onScrollChangedListener;
    public int openedOffset;
    public Scroller scroller;

    /* renamed from: com.baidu.pass.ecommerce.view.ScrollLayout$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1661783382, "Lcom/baidu/pass/ecommerce/view/ScrollLayout$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1661783382, "Lcom/baidu/pass/ecommerce/view/ScrollLayout$3;");
                    return;
                }
            }
            int[] iArr = new int[InnerStatus.values().length];
            $SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus = iArr;
            try {
                iArr[InnerStatus.OPENED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus[InnerStatus.EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class InnerStatus {
        public static final /* synthetic */ InnerStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InnerStatus EXIT;
        public static final InnerStatus HALF;
        public static final InnerStatus MOVING;
        public static final InnerStatus OPENED;
        public static final InnerStatus SCROLLING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-775397067, "Lcom/baidu/pass/ecommerce/view/ScrollLayout$InnerStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-775397067, "Lcom/baidu/pass/ecommerce/view/ScrollLayout$InnerStatus;");
                    return;
                }
            }
            EXIT = new InnerStatus("EXIT", 0);
            HALF = new InnerStatus(PolyActivity.HALF_PANEL_TYPE, 1);
            OPENED = new InnerStatus("OPENED", 2);
            MOVING = new InnerStatus("MOVING", 3);
            InnerStatus innerStatus = new InnerStatus("SCROLLING", 4);
            SCROLLING = innerStatus;
            $VALUES = new InnerStatus[]{EXIT, HALF, OPENED, MOVING, innerStatus};
        }

        public InnerStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InnerStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (InnerStatus) Enum.valueOf(InnerStatus.class, str) : (InnerStatus) invokeL.objValue;
        }

        public static InnerStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (InnerStatus[]) $VALUES.clone() : (InnerStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface OnScrollChangedListener {
        void onChildScroll(int i2);

        void onScrollFinished(Status status);

        void onScrollProgressChanged(float f2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status EXIT;
        public static final Status HALF;
        public static final Status OPENED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-85134489, "Lcom/baidu/pass/ecommerce/view/ScrollLayout$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-85134489, "Lcom/baidu/pass/ecommerce/view/ScrollLayout$Status;");
                    return;
                }
            }
            EXIT = new Status("EXIT", 0);
            HALF = new Status(PolyActivity.HALF_PANEL_TYPE, 1);
            Status status = new Status("OPENED", 2);
            OPENED = status;
            $VALUES = new Status[]{EXIT, HALF, status};
        }

        public Status(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lastFlingStatus = Status.OPENED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.HALF;
        this.maxOffset = 0;
        this.openedOffset = 0;
        this.exitOffset = 0;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (f3 > 80.0f) {
                        if (this.this$0.lastFlingStatus.equals(Status.HALF) && (-this.this$0.getScrollY()) > this.this$0.maxOffset) {
                            this.this$0.lastFlingStatus = Status.EXIT;
                            this.this$0.scrollToExit();
                        } else {
                            this.this$0.scrollToHalf();
                            this.this$0.lastFlingStatus = Status.HALF;
                        }
                        return true;
                    }
                    int i4 = (f3 > 80.0f ? 1 : (f3 == 80.0f ? 0 : -1));
                    if (i4 >= 0 || this.this$0.getScrollY() > (-this.this$0.maxOffset)) {
                        if (i4 >= 0 || this.this$0.getScrollY() <= (-this.this$0.maxOffset)) {
                            return false;
                        }
                        this.this$0.scrollToOpened();
                        this.this$0.lastFlingStatus = Status.OPENED;
                        return true;
                    }
                    this.this$0.scrollToHalf();
                    this.this$0.lastFlingStatus = Status.HALF;
                    return true;
                }
                return invokeCommon.booleanValue;
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    this.this$0.updateRecyclerViewScrollState(recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    this.this$0.updateRecyclerViewScrollState(recyclerView);
                }
            }
        };
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
    }

    private void completeMove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            float f2 = -((this.maxOffset - this.openedOffset) * 0.5f);
            if (getScrollY() > f2) {
                scrollToOpened();
            } else if (this.isSupportExit) {
                int i2 = this.exitOffset;
                int i3 = this.maxOffset;
                float f3 = -(((i2 - i3) * 0.8f) + i3);
                if (getScrollY() <= f2 && getScrollY() > f3) {
                    scrollToHalf();
                } else {
                    scrollToExit();
                }
            } else {
                scrollToHalf();
            }
        }
    }

    private boolean disposeEdgeValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            if (this.isSupportExit) {
                if (i2 > 0 || getScrollY() < (-this.openedOffset)) {
                    return i2 >= 0 && getScrollY() <= (-this.exitOffset);
                }
                return true;
            } else if (i2 > 0 || getScrollY() < (-this.openedOffset)) {
                return i2 >= 0 && getScrollY() <= (-this.maxOffset);
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet) {
        int dimensionPixelOffset;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SapiSdkScrollLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkHalfOffset) && (dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SapiSdkScrollLayout_SapiSdkHalfOffset, this.maxOffset)) != getContentHeight()) {
                this.maxOffset = getContentHeight() - dimensionPixelOffset;
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkOpenedOffset)) {
                this.openedOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SapiSdkScrollLayout_SapiSdkOpenedOffset, this.openedOffset);
            } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkExitOffset)) {
                int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SapiSdkScrollLayout_SapiSdkExitOffset, getContentHeight());
                if (dimensionPixelOffset2 != getContentHeight()) {
                    this.exitOffset = getContentHeight() - dimensionPixelOffset2;
                }
            } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkAllowHorizontalScroll)) {
                this.isAllowHorizontalScroll = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkScrollLayout_SapiSdkAllowHorizontalScroll, true);
            } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkIsSupportExit)) {
                this.isSupportExit = obtainStyledAttributes.getBoolean(R.styleable.SapiSdkScrollLayout_SapiSdkIsSupportExit, true);
            } else if (obtainStyledAttributes.hasValue(R.styleable.SapiSdkScrollLayout_SapiSdkMode)) {
                int integer = obtainStyledAttributes.getInteger(R.styleable.SapiSdkScrollLayout_SapiSdkMode, 0);
                if (integer == 0) {
                    setHalf();
                } else if (integer != 2) {
                    setToOpen();
                } else {
                    setToExit();
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void onScrollFinished(Status status) {
        OnScrollChangedListener onScrollChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, status) == null) || (onScrollChangedListener = this.onScrollChangedListener) == null) {
            return;
        }
        onScrollChangedListener.onScrollFinished(status);
    }

    private void onScrollProgressChanged(float f2) {
        OnScrollChangedListener onScrollChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65547, this, f2) == null) || (onScrollChangedListener = this.onScrollChangedListener) == null) {
            return;
        }
        onScrollChangedListener.onScrollProgressChanged(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRecyclerViewScrollState(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, recyclerView) == null) {
            if (recyclerView.getChildCount() == 0) {
                setDraggable(true);
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int[] iArr = new int[1];
            if (layoutManager instanceof LinearLayoutManager) {
                iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                iArr = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
            }
            if (iArr[0] == 0 && recyclerView.getChildAt(0).getTop() == recyclerView.getPaddingTop()) {
                setDraggable(true);
            } else {
                setDraggable(false);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
            int currY = this.scroller.getCurrY();
            scrollTo(0, currY);
            if (currY != (-this.openedOffset) && currY != (-this.maxOffset) && (!this.isSupportExit || currY != (-this.exitOffset))) {
                invalidate();
            } else {
                this.scroller.abortAnimation();
            }
        }
    }

    public int getContentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contentHeight : invokeV.intValue;
    }

    public Status getCurrentStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = AnonymousClass3.$SwitchMap$com$baidu$pass$ecommerce$view$ScrollLayout$InnerStatus[this.currentInnerStatus.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return Status.HALF;
                }
                return Status.EXIT;
            }
            return Status.OPENED;
        }
        return (Status) invokeV.objValue;
    }

    public boolean isAllowHorizontalScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isAllowHorizontalScroll : invokeV.booleanValue;
    }

    public boolean isDraggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isDraggable : invokeV.booleanValue;
    }

    public boolean isSupportExit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isSupportExit : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.isEnable) {
                if (this.isDraggable || this.currentInnerStatus != InnerStatus.OPENED) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (this.isAllowPointerIntercepted) {
                                    if (this.isCurrentPointerIntercepted) {
                                        return true;
                                    }
                                    int y = (int) (motionEvent.getY() - this.lastDownY);
                                    int x = (int) (motionEvent.getX() - this.lastDownX);
                                    if (Math.abs(y) < 10) {
                                        return false;
                                    }
                                    if (Math.abs(y) < Math.abs(x) && this.isAllowHorizontalScroll) {
                                        this.isAllowPointerIntercepted = false;
                                        this.isCurrentPointerIntercepted = false;
                                        return false;
                                    }
                                    InnerStatus innerStatus = this.currentInnerStatus;
                                    if (innerStatus == InnerStatus.OPENED) {
                                        if (y < 0) {
                                            return false;
                                        }
                                    } else if (innerStatus == InnerStatus.HALF && !this.isSupportExit && y > 0) {
                                        return false;
                                    }
                                    this.isCurrentPointerIntercepted = true;
                                    return true;
                                }
                                return false;
                            } else if (action != 3) {
                                return false;
                            }
                        }
                        this.isAllowPointerIntercepted = true;
                        this.isCurrentPointerIntercepted = false;
                        if (this.currentInnerStatus == InnerStatus.MOVING) {
                            return true;
                        }
                    } else {
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        this.lastY = y2;
                        this.lastDownX = x2;
                        this.lastDownY = y2;
                        this.isAllowPointerIntercepted = true;
                        this.isCurrentPointerIntercepted = false;
                        if (!this.scroller.isFinished()) {
                            this.scroller.forceFinished(true);
                            this.currentInnerStatus = InnerStatus.MOVING;
                            this.isCurrentPointerIntercepted = true;
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (this.isCurrentPointerIntercepted) {
                this.gestureDetector.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int y = (int) ((motionEvent.getY() - this.lastY) * 1.2f);
                            int signum = ((int) Math.signum(y)) * Math.min(Math.abs(y), 30);
                            if (disposeEdgeValue(signum)) {
                                return true;
                            }
                            this.currentInnerStatus = InnerStatus.MOVING;
                            int scrollY = getScrollY() - signum;
                            int i2 = -this.openedOffset;
                            if (scrollY >= i2) {
                                scrollTo(0, i2);
                            } else {
                                int i3 = -this.maxOffset;
                                if (scrollY <= i3 && !this.isSupportExit) {
                                    scrollTo(0, i3);
                                } else {
                                    scrollTo(0, scrollY);
                                }
                            }
                            this.lastY = motionEvent.getY();
                            return true;
                        } else if (action != 3) {
                            return false;
                        }
                    }
                    if (this.currentInnerStatus == InnerStatus.MOVING) {
                        completeMove();
                        return true;
                    }
                    return false;
                }
                this.lastY = motionEvent.getY();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.scrollTo(i2, i3);
            int i4 = this.maxOffset;
            int i5 = this.openedOffset;
            if (i4 == i5) {
                return;
            }
            int i6 = -i3;
            if (i6 <= i4) {
                onScrollProgressChanged((i6 - i5) / (i4 - i5));
            } else {
                onScrollProgressChanged((i6 - i4) / (i4 - this.exitOffset));
            }
            if (i3 == (-this.openedOffset)) {
                InnerStatus innerStatus = this.currentInnerStatus;
                InnerStatus innerStatus2 = InnerStatus.OPENED;
                if (innerStatus != innerStatus2) {
                    this.currentInnerStatus = innerStatus2;
                    onScrollFinished(Status.OPENED);
                }
            } else if (i3 == (-this.maxOffset)) {
                InnerStatus innerStatus3 = this.currentInnerStatus;
                InnerStatus innerStatus4 = InnerStatus.HALF;
                if (innerStatus3 != innerStatus4) {
                    this.currentInnerStatus = innerStatus4;
                    onScrollFinished(Status.HALF);
                }
            } else if (this.isSupportExit && i3 == (-this.exitOffset)) {
                InnerStatus innerStatus5 = this.currentInnerStatus;
                InnerStatus innerStatus6 = InnerStatus.EXIT;
                if (innerStatus5 != innerStatus6) {
                    this.currentInnerStatus = innerStatus6;
                    onScrollFinished(Status.EXIT);
                }
            }
        }
    }

    public void scrollToExit() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || !this.isSupportExit || this.currentInnerStatus == InnerStatus.EXIT || this.exitOffset == this.maxOffset || (i3 = (-getScrollY()) - (i2 = this.exitOffset)) == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (i2 - this.maxOffset)) + 100);
        invalidate();
    }

    public void scrollToHalf() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.currentInnerStatus == InnerStatus.HALF || this.maxOffset == this.openedOffset || (i3 = (-getScrollY()) - (i2 = this.maxOffset)) == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (i2 - this.openedOffset)) + 100);
        invalidate();
    }

    public void scrollToOpened() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.currentInnerStatus == InnerStatus.OPENED || this.maxOffset == this.openedOffset || (i3 = (-getScrollY()) - (i2 = this.openedOffset)) == 0) {
            return;
        }
        this.currentInnerStatus = InnerStatus.SCROLLING;
        this.scroller.startScroll(0, getScrollY(), 0, i3, Math.abs((i3 * 300) / (this.maxOffset - i2)) + 100);
        invalidate();
    }

    public void setAllowHorizontalScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isAllowHorizontalScroll = z;
        }
    }

    public void setAssociatedRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, recyclerView) == null) {
            recyclerView.addOnScrollListener(this.associatedRecyclerViewListener);
            updateRecyclerViewScrollState(recyclerView);
        }
    }

    public void setContentHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.contentHeight = i2;
        }
    }

    public void setDraggable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.isDraggable = z;
        }
    }

    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isEnable = z;
        }
    }

    public void setExitOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.exitOffset = getContentHeight() - i2;
        }
    }

    public void setHalf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            scrollTo(0, -this.maxOffset);
            this.currentInnerStatus = InnerStatus.HALF;
            this.lastFlingStatus = Status.HALF;
        }
    }

    public void setHalfOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.maxOffset = getContentHeight() - i2;
        }
    }

    public void setIsSupportExit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isSupportExit = z;
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onScrollChangedListener) == null) {
            this.onScrollChangedListener = onScrollChangedListener;
        }
    }

    public void setOpenedOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.openedOffset = i2;
        }
    }

    public void setToExit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.isSupportExit) {
            scrollTo(0, -this.exitOffset);
            this.currentInnerStatus = InnerStatus.EXIT;
        }
    }

    public void setToOpen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            scrollTo(0, -this.openedOffset);
            this.currentInnerStatus = InnerStatus.OPENED;
            this.lastFlingStatus = Status.OPENED;
        }
    }

    public void showOrHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            InnerStatus innerStatus = this.currentInnerStatus;
            if (innerStatus == InnerStatus.HALF) {
                scrollToOpened();
            } else if (innerStatus == InnerStatus.OPENED) {
                scrollToHalf();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.lastFlingStatus = Status.OPENED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.HALF;
        this.maxOffset = 0;
        this.openedOffset = 0;
        this.exitOffset = 0;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (f3 > 80.0f) {
                        if (this.this$0.lastFlingStatus.equals(Status.HALF) && (-this.this$0.getScrollY()) > this.this$0.maxOffset) {
                            this.this$0.lastFlingStatus = Status.EXIT;
                            this.this$0.scrollToExit();
                        } else {
                            this.this$0.scrollToHalf();
                            this.this$0.lastFlingStatus = Status.HALF;
                        }
                        return true;
                    }
                    int i4 = (f3 > 80.0f ? 1 : (f3 == 80.0f ? 0 : -1));
                    if (i4 >= 0 || this.this$0.getScrollY() > (-this.this$0.maxOffset)) {
                        if (i4 >= 0 || this.this$0.getScrollY() <= (-this.this$0.maxOffset)) {
                            return false;
                        }
                        this.this$0.scrollToOpened();
                        this.this$0.lastFlingStatus = Status.OPENED;
                        return true;
                    }
                    this.this$0.scrollToHalf();
                    this.this$0.lastFlingStatus = Status.HALF;
                    return true;
                }
                return invokeCommon.booleanValue;
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i4) == null) {
                    super.onScrollStateChanged(recyclerView, i4);
                    this.this$0.updateRecyclerViewScrollState(recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i4, i5) == null) {
                    super.onScrolled(recyclerView, i4, i5);
                    this.this$0.updateRecyclerViewScrollState(recyclerView);
                }
            }
        };
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
        initFromAttributes(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.lastFlingStatus = Status.OPENED;
        this.isEnable = true;
        this.isSupportExit = false;
        this.isAllowHorizontalScroll = true;
        this.isDraggable = true;
        this.isAllowPointerIntercepted = true;
        this.isCurrentPointerIntercepted = false;
        this.currentInnerStatus = InnerStatus.HALF;
        this.maxOffset = 0;
        this.openedOffset = 0;
        this.exitOffset = 0;
        this.gestureListener = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    if (f3 > 80.0f) {
                        if (this.this$0.lastFlingStatus.equals(Status.HALF) && (-this.this$0.getScrollY()) > this.this$0.maxOffset) {
                            this.this$0.lastFlingStatus = Status.EXIT;
                            this.this$0.scrollToExit();
                        } else {
                            this.this$0.scrollToHalf();
                            this.this$0.lastFlingStatus = Status.HALF;
                        }
                        return true;
                    }
                    int i42 = (f3 > 80.0f ? 1 : (f3 == 80.0f ? 0 : -1));
                    if (i42 >= 0 || this.this$0.getScrollY() > (-this.this$0.maxOffset)) {
                        if (i42 >= 0 || this.this$0.getScrollY() <= (-this.this$0.maxOffset)) {
                            return false;
                        }
                        this.this$0.scrollToOpened();
                        this.this$0.lastFlingStatus = Status.OPENED;
                        return true;
                    }
                    this.this$0.scrollToHalf();
                    this.this$0.lastFlingStatus = Status.HALF;
                    return true;
                }
                return invokeCommon.booleanValue;
            }
        };
        this.associatedRecyclerViewListener = new RecyclerView.OnScrollListener(this) { // from class: com.baidu.pass.ecommerce.view.ScrollLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScrollLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i42) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i42) == null) {
                    super.onScrollStateChanged(recyclerView, i42);
                    this.this$0.updateRecyclerViewScrollState(recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i42, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i42, i5) == null) {
                    super.onScrolled(recyclerView, i42, i5);
                    this.this$0.updateRecyclerViewScrollState(recyclerView);
                }
            }
        };
        this.scroller = new Scroller(getContext(), null, true);
        this.gestureDetector = new GestureDetector(getContext(), this.gestureListener);
        initFromAttributes(context, attributeSet);
    }
}
