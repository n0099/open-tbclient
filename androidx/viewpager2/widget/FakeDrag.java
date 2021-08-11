package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class FakeDrag {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActualDraggedDistance;
    public long mFakeDragBeginTime;
    public int mMaximumVelocity;
    public final RecyclerView mRecyclerView;
    public float mRequestedDragDistance;
    public final ScrollEventAdapter mScrollEventAdapter;
    public VelocityTracker mVelocityTracker;
    public final ViewPager2 mViewPager;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewPager2, scrollEventAdapter, recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long j2, int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j2, i2, f2, f3, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    private void beginFakeVelocityTracker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
                this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
                return;
            }
            velocityTracker.clear();
        }
    }

    @UiThread
    public boolean beginFakeDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mScrollEventAdapter.isDragging()) {
                return false;
            }
            this.mActualDraggedDistance = 0;
            this.mRequestedDragDistance = 0;
            this.mFakeDragBeginTime = SystemClock.uptimeMillis();
            beginFakeVelocityTracker();
            this.mScrollEventAdapter.notifyBeginFakeDrag();
            if (!this.mScrollEventAdapter.isIdle()) {
                this.mRecyclerView.stopScroll();
            }
            addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
            return true;
        }
        return invokeV.booleanValue;
    }

    @UiThread
    public boolean endFakeDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mScrollEventAdapter.isFakeDragging()) {
                this.mScrollEventAdapter.notifyEndFakeDrag();
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
                    return true;
                }
                this.mViewPager.snapToPage();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @UiThread
    public boolean fakeDragBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            if (this.mScrollEventAdapter.isFakeDragging()) {
                float f3 = this.mRequestedDragDistance - f2;
                this.mRequestedDragDistance = f3;
                int round = Math.round(f3 - this.mActualDraggedDistance);
                this.mActualDraggedDistance += round;
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean z = this.mViewPager.getOrientation() == 0;
                int i2 = z ? round : 0;
                int i3 = z ? 0 : round;
                float f4 = z ? this.mRequestedDragDistance : 0.0f;
                float f5 = z ? 0.0f : this.mRequestedDragDistance;
                this.mRecyclerView.scrollBy(i2, i3);
                addFakeMotionEvent(uptimeMillis, 2, f4, f5);
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }

    public boolean isFakeDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mScrollEventAdapter.isFakeDragging() : invokeV.booleanValue;
    }
}
