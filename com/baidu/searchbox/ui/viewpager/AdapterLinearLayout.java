package com.baidu.searchbox.ui.viewpager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.widget.RecyclePool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AdapterLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POSITION = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public Adapter mAdapter;
    public final Rect mBound;
    public Drawable mDivider;
    public int mDividerSize;
    public GestureDetector mGestureDetector;
    public GestureDetector.SimpleOnGestureListener mGestureListener;
    public boolean mIsPendingCheckTap;
    public OnItemClickListener mItemClickListener;
    public int mMontionIndex;
    public int mMotionDownY;
    public int mMotionUpY;
    public ItemDataSetObserver mObserver;
    public CheckForTap mPendingCheckForTap;
    public Runnable mPendingCheckForUp;
    public int mSelectedPosition;
    public Drawable mSelector;
    public boolean mShowLastDivider;
    public int mSpace;
    public final Rect mTempRect;
    public int mTouchSlop;
    public RecyclePool<View> mViewRecycle;

    /* loaded from: classes7.dex */
    public abstract class CheckForTap implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mPosition;
        public final /* synthetic */ AdapterLinearLayout this$0;

        public CheckForTap(AdapterLinearLayout adapterLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adapterLinearLayout;
            this.mPosition = -1;
        }

        public int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPosition : invokeV.intValue;
        }

        public void setPostion(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.mPosition = i2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class ItemDataSetObserver extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdapterLinearLayout this$0;

        public ItemDataSetObserver(AdapterLinearLayout adapterLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapterLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adapterLinearLayout;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.layoutChildren();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnItemClickListener {
        void onItemClick(AdapterLinearLayout adapterLinearLayout, View view, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterLinearLayout(Context context) {
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
        this.mSpace = 0;
        this.mDividerSize = 0;
        this.mMontionIndex = -1;
        this.mTouchSlop = 0;
        this.mMotionDownY = 0;
        this.mMotionUpY = 0;
        this.mSelectedPosition = -1;
        this.mIsPendingCheckTap = false;
        this.mTempRect = new Rect();
        this.mBound = new Rect();
        this.mDivider = null;
        this.mSelector = null;
        this.mAdapter = null;
        this.mPendingCheckForTap = null;
        this.mPendingCheckForUp = null;
        this.mObserver = new ItemDataSetObserver();
        this.mViewRecycle = new RecyclePool<>(100);
        this.mGestureDetector = null;
        this.mItemClickListener = null;
        this.mShowLastDivider = false;
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdapterLinearLayout this$0;

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
            public boolean onDown(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) ? this.this$0.onDown(motionEvent) : invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.this$0.onSingleTapUp(motionEvent) : invokeL.booleanValue;
            }
        };
        init(context);
    }

    private void drawDivider(Canvas canvas, Rect rect) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, canvas, rect) == null) || (drawable = this.mDivider) == null) {
            return;
        }
        canvas.save();
        canvas.clipRect(rect);
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    private void drawHorizontalDividers(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
            int childCount = this.mShowLastDivider ? getChildCount() : getChildCount() - 1;
            if (this.mDivider == null || childCount <= 0) {
                return;
            }
            int i2 = this.mDividerSize;
            int i3 = (this.mSpace - i2) / 2;
            Rect rect = this.mTempRect;
            int paddingTop = getPaddingTop();
            rect.top = paddingTop;
            rect.bottom = (paddingTop + getHeight()) - getPaddingBottom();
            for (int i4 = 0; i4 < childCount; i4++) {
                int right = getChildAt(i4).getRight() + i3;
                rect.left = right;
                rect.right = right + i2;
                drawDivider(canvas, rect);
            }
        }
    }

    private void drawSelector(Canvas canvas) {
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, canvas) == null) || this.mSelector == null || (childAt = getChildAt(this.mMontionIndex)) == null) {
            return;
        }
        Rect rect = this.mTempRect;
        rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        this.mSelector.setBounds(rect);
        this.mSelector.draw(canvas);
    }

    private void drawVerticalDividers(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, canvas) == null) {
            int childCount = this.mShowLastDivider ? getChildCount() : getChildCount() - 1;
            if (this.mDivider == null || childCount <= 0) {
                return;
            }
            int i2 = this.mDividerSize;
            int i3 = (this.mSpace - i2) / 2;
            Rect rect = this.mTempRect;
            int paddingLeft = getPaddingLeft();
            rect.left = paddingLeft;
            rect.right = (paddingLeft + getWidth()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                int bottom = getChildAt(i4).getBottom() + i3;
                rect.top = bottom;
                rect.bottom = bottom + i2;
                drawDivider(canvas, rect);
            }
        }
    }

    private ViewGroup.LayoutParams getChildLayoutParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (getOrientation() == 0) {
                return new LayoutParams(-2, -1);
            }
            return new LayoutParams(-1, -2);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            float f2 = context.getResources().getDisplayMetrics().density;
            this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener);
            int i2 = (int) (f2 * 1.0f);
            this.mDividerSize = i2;
            this.mSpace = i2;
            this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
    }

    private void performItemClick(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, this, view, i2) == null) {
            postDelayed(new Runnable(this, i2, view) { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdapterLinearLayout this$0;
                public final /* synthetic */ int val$position;
                public final /* synthetic */ View val$v;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$position = i2;
                    this.val$v = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.onItemClick(this.val$position);
                        this.this$0.playSoundEffect(0);
                        if (this.this$0.mItemClickListener != null) {
                            this.this$0.mItemClickListener.onItemClick(this.this$0, this.val$v, this.val$position);
                        }
                    }
                }
            }, ViewConfiguration.getPressedStateDuration());
        }
    }

    private void recycleChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mViewRecycle.clear();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mViewRecycle.recycle(getChildAt(i2));
            }
            removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mIsPendingCheckTap = false;
            positionSelector(-1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (getOrientation() == 0) {
                drawHorizontalDividers(canvas);
            } else {
                drawVerticalDividers(canvas);
            }
            drawSelector(canvas);
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 2) {
                onMove(5);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public Adapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdapter : (Adapter) invokeV.objValue;
    }

    public int getSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSelectedPosition : invokeV.intValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSelector : (Drawable) invokeV.objValue;
    }

    public int getSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSpace : invokeV.intValue;
    }

    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.mAdapter == null) {
                removeAllViews();
                return;
            }
            recycleChildren();
            int count = this.mAdapter.getCount();
            int i2 = this.mSpace;
            int i3 = 0;
            while (i3 < count) {
                View view = this.mAdapter.getView(i3, this.mViewRecycle.get(), this);
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = getChildLayoutParameter();
                    } else if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                        throw new IllegalArgumentException("The type of layout parameter must be LinearLayout.LayoutParams");
                    }
                    if (!this.mShowLastDivider && i3 == count - 1) {
                        i2 = 0;
                    }
                    if (getOrientation() == 0) {
                        ((LinearLayout.LayoutParams) layoutParams).rightMargin = i2;
                    } else {
                        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i2;
                    }
                    view.setSelected(this.mSelectedPosition == i3);
                    addView(view, layoutParams);
                    i3++;
                } else {
                    throw new NullPointerException("The view can not be null.");
                }
            }
            this.mViewRecycle.clear();
        }
    }

    public void onCancel(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent) == null) {
            onUp(motionEvent);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            this.mMotionDownY = (int) motionEvent.getY();
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition >= 0 && pointToPosition < this.mAdapter.getCount() && (childAt = getChildAt(pointToPosition)) != null) {
                if (this.mPendingCheckForTap == null) {
                    this.mPendingCheckForTap = new CheckForTap(this) { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdapterLinearLayout this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) newInitContext.callArgs[0];
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.setPressed(true);
                                this.this$0.positionSelector(getPosition());
                                this.this$0.invalidate();
                                this.this$0.mIsPendingCheckTap = false;
                            }
                        }
                    };
                }
                childAt.setPressed(true);
                this.mPendingCheckForTap.setPostion(pointToPosition);
                postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                this.mIsPendingCheckTap = true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onItemClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public void onMove(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || Math.abs(i2) <= this.mTouchSlop) {
            return;
        }
        removeCallbacks(this.mPendingCheckForTap);
        reset();
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition < 0 || pointToPosition >= this.mAdapter.getCount()) {
                return true;
            }
            performItemClick(getChildAt(pointToPosition), pointToPosition);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 1) {
                onUp(motionEvent);
            } else if (action == 3) {
                onCancel(motionEvent);
            }
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void onUp(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, motionEvent) == null) {
            int y = (int) motionEvent.getY();
            this.mMotionUpY = y;
            int i2 = y - this.mMotionDownY;
            if (Math.abs(i2) > this.mTouchSlop) {
                onMove(i2);
            }
            if (this.mPendingCheckForUp == null) {
                this.mPendingCheckForUp = new Runnable(this) { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdapterLinearLayout this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.reset();
                            this.this$0.positionSelector(-1);
                            this.this$0.setPressed(false);
                            this.this$0.invalidate();
                        }
                    }
                };
            }
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.setPressed(false);
                }
            }
            if (this.mIsPendingCheckTap) {
                postDelayed(this.mPendingCheckForUp, ViewConfiguration.getTapTimeout());
            } else {
                this.mPendingCheckForUp.run();
            }
            this.mIsPendingCheckTap = false;
        }
    }

    public int pointToPosition(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) {
            Rect rect = this.mBound;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt.getVisibility() == 0) {
                    childAt.getHitRect(rect);
                    if (rect.contains(i2, i3)) {
                        return childCount;
                    }
                }
            }
            return -1;
        }
        return invokeII.intValue;
    }

    public void positionSelector(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mMontionIndex = i2;
        }
    }

    public void selectChild(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mSelectedPosition = i2;
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != null) {
                    childAt.setSelected(i3 == i2);
                }
                i3++;
            }
        }
    }

    public void setAdapter(Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, adapter) == null) {
            Adapter adapter2 = this.mAdapter;
            if (adapter2 != null) {
                adapter2.unregisterDataSetObserver(this.mObserver);
            }
            this.mAdapter = adapter;
            if (adapter != null) {
                adapter.registerDataSetObserver(this.mObserver);
            }
            layoutChildren();
        }
    }

    @Override // android.widget.LinearLayout
    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public void setDividerDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, drawable) == null) {
            this.mDivider = drawable;
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (getOrientation() == 0) {
                    setDividerSize(bitmapDrawable.getIntrinsicWidth());
                } else {
                    setDividerSize(bitmapDrawable.getIntrinsicHeight());
                }
            }
            invalidate();
        }
    }

    public void setDividerSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mDividerSize = i2;
            if (this.mSpace != i2) {
                this.mSpace = i2;
                layoutChildren();
            }
            invalidate();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onItemClickListener) == null) {
            this.mItemClickListener = onItemClickListener;
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, drawable) == null) {
            this.mSelector = drawable;
            invalidate();
        }
    }

    public void setSpace(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || this.mSpace == i2) {
            return;
        }
        this.mSpace = i2;
        layoutChildren();
    }

    public void showLastDivider(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.mShowLastDivider = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterLinearLayout(Context context, AttributeSet attributeSet) {
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
        this.mSpace = 0;
        this.mDividerSize = 0;
        this.mMontionIndex = -1;
        this.mTouchSlop = 0;
        this.mMotionDownY = 0;
        this.mMotionUpY = 0;
        this.mSelectedPosition = -1;
        this.mIsPendingCheckTap = false;
        this.mTempRect = new Rect();
        this.mBound = new Rect();
        this.mDivider = null;
        this.mSelector = null;
        this.mAdapter = null;
        this.mPendingCheckForTap = null;
        this.mPendingCheckForUp = null;
        this.mObserver = new ItemDataSetObserver();
        this.mViewRecycle = new RecyclePool<>(100);
        this.mGestureDetector = null;
        this.mItemClickListener = null;
        this.mShowLastDivider = false;
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdapterLinearLayout this$0;

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
            public boolean onDown(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) ? this.this$0.onDown(motionEvent) : invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.this$0.onSingleTapUp(motionEvent) : invokeL.booleanValue;
            }
        };
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public AdapterLinearLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.mSpace = 0;
        this.mDividerSize = 0;
        this.mMontionIndex = -1;
        this.mTouchSlop = 0;
        this.mMotionDownY = 0;
        this.mMotionUpY = 0;
        this.mSelectedPosition = -1;
        this.mIsPendingCheckTap = false;
        this.mTempRect = new Rect();
        this.mBound = new Rect();
        this.mDivider = null;
        this.mSelector = null;
        this.mAdapter = null;
        this.mPendingCheckForTap = null;
        this.mPendingCheckForUp = null;
        this.mObserver = new ItemDataSetObserver();
        this.mViewRecycle = new RecyclePool<>(100);
        this.mGestureDetector = null;
        this.mItemClickListener = null;
        this.mShowLastDivider = false;
        this.mGestureListener = new GestureDetector.SimpleOnGestureListener(this) { // from class: com.baidu.searchbox.ui.viewpager.AdapterLinearLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdapterLinearLayout this$0;

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
            public boolean onDown(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) ? this.this$0.onDown(motionEvent) : invokeL.booleanValue;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.this$0.onSingleTapUp(motionEvent) : invokeL.booleanValue;
            }
        };
        init(context);
    }
}
