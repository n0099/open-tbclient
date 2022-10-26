package com.baidu.searchbox.live.livepager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEFAULT_BOUNDARY_CASHING = false;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaLoopPagerAdapterWrapper mAdapter;
    public boolean mBoundaryCaching;
    public ViewPager.OnPageChangeListener mOuterPageChangeListener;
    public ViewPager.OnPageChangeListener onPageChangeListener;
    public IScrollControl scrollControl;
    public float startY;

    /* loaded from: classes2.dex */
    public interface IScrollControl {
        boolean isEnableScrollDown(MotionEvent motionEvent);

        boolean isEnableScrollUp(MotionEvent motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLoopViewPager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBoundaryCaching = false;
        this.onPageChangeListener = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.searchbox.live.livepager.AlaLoopViewPager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float mPreviousOffset;
            public float mPreviousPosition;
            public final /* synthetic */ AlaLoopViewPager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
                this.mPreviousOffset = -1.0f;
                this.mPreviousPosition = -1.0f;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    if (this.this$0.mAdapter != null) {
                        int currentItem = AlaLoopViewPager.super.getCurrentItem();
                        int realPosition = this.this$0.mAdapter.toRealPosition(currentItem);
                        if (i3 == 0 && (currentItem == 0 || currentItem == this.this$0.mAdapter.getCount() - 1)) {
                            this.this$0.setCurrentItem(realPosition, true);
                        }
                    }
                    ViewPager.OnPageChangeListener onPageChangeListener = this.this$0.mOuterPageChangeListener;
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageScrollStateChanged(i3);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) {
                    if (this.this$0.mAdapter != null) {
                        int realPosition = this.this$0.mAdapter.toRealPosition(i3);
                        if (f == 0.0f && this.mPreviousOffset == 0.0f && (i3 == 0 || i3 == this.this$0.mAdapter.getCount() - 1)) {
                            this.this$0.setCurrentItem(realPosition, true);
                        }
                        i3 = realPosition;
                    }
                    this.mPreviousOffset = f;
                    ViewPager.OnPageChangeListener onPageChangeListener = this.this$0.mOuterPageChangeListener;
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageScrolled(i3, f, i4);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                    int realPosition = this.this$0.mAdapter.toRealPosition(i3);
                    float f = realPosition;
                    if (this.mPreviousPosition != f) {
                        this.mPreviousPosition = f;
                        ViewPager.OnPageChangeListener onPageChangeListener = this.this$0.mOuterPageChangeListener;
                        if (onPageChangeListener != null) {
                            onPageChangeListener.onPageSelected(realPosition);
                        }
                    }
                }
            }
        };
        this.startY = 0.0f;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
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
        this.mBoundaryCaching = false;
        this.onPageChangeListener = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.searchbox.live.livepager.AlaLoopViewPager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float mPreviousOffset;
            public float mPreviousPosition;
            public final /* synthetic */ AlaLoopViewPager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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
                this.mPreviousOffset = -1.0f;
                this.mPreviousPosition = -1.0f;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                    if (this.this$0.mAdapter != null) {
                        int currentItem = AlaLoopViewPager.super.getCurrentItem();
                        int realPosition = this.this$0.mAdapter.toRealPosition(currentItem);
                        if (i3 == 0 && (currentItem == 0 || currentItem == this.this$0.mAdapter.getCount() - 1)) {
                            this.this$0.setCurrentItem(realPosition, true);
                        }
                    }
                    ViewPager.OnPageChangeListener onPageChangeListener = this.this$0.mOuterPageChangeListener;
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageScrollStateChanged(i3);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i3), Float.valueOf(f), Integer.valueOf(i4)}) == null) {
                    if (this.this$0.mAdapter != null) {
                        int realPosition = this.this$0.mAdapter.toRealPosition(i3);
                        if (f == 0.0f && this.mPreviousOffset == 0.0f && (i3 == 0 || i3 == this.this$0.mAdapter.getCount() - 1)) {
                            this.this$0.setCurrentItem(realPosition, true);
                        }
                        i3 = realPosition;
                    }
                    this.mPreviousOffset = f;
                    ViewPager.OnPageChangeListener onPageChangeListener = this.this$0.mOuterPageChangeListener;
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageScrolled(i3, f, i4);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                    int realPosition = this.this$0.mAdapter.toRealPosition(i3);
                    float f = realPosition;
                    if (this.mPreviousPosition != f) {
                        this.mPreviousPosition = f;
                        ViewPager.OnPageChangeListener onPageChangeListener = this.this$0.mOuterPageChangeListener;
                        if (onPageChangeListener != null) {
                            onPageChangeListener.onPageSelected(realPosition);
                        }
                    }
                }
            }
        };
        this.startY = 0.0f;
        init();
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pagerAdapter) == null) {
            AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = new AlaLoopPagerAdapterWrapper(pagerAdapter);
            this.mAdapter = alaLoopPagerAdapterWrapper;
            alaLoopPagerAdapterWrapper.setBoundaryCaching(this.mBoundaryCaching);
            super.setAdapter(this.mAdapter);
            setCurrentItem(0, false);
        }
    }

    public void setBoundaryCaching(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mBoundaryCaching = z;
            AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = this.mAdapter;
            if (alaLoopPagerAdapterWrapper != null) {
                alaLoopPagerAdapterWrapper.setBoundaryCaching(z);
            }
        }
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onPageChangeListener) == null) {
            this.mOuterPageChangeListener = onPageChangeListener;
        }
    }

    public void setScrollControl(IScrollControl iScrollControl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iScrollControl) == null) {
            this.scrollControl = iScrollControl;
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            super.setOnPageChangeListener(this.onPageChangeListener);
        }
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = this.mAdapter;
            if (alaLoopPagerAdapterWrapper != null) {
                return alaLoopPagerAdapterWrapper.getRealAdapter();
            }
            return alaLoopPagerAdapterWrapper;
        }
        return (PagerAdapter) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = this.mAdapter;
            if (alaLoopPagerAdapterWrapper != null) {
                return alaLoopPagerAdapterWrapper.toRealPosition(super.getCurrentItem());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static int toRealPosition(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            int i3 = i - 1;
            if (i3 < 0) {
                return i3 + i2;
            }
            return i3 % i2;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.setCurrentItem(this.mAdapter.toInnerPosition(i), z);
        }
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        IScrollControl iScrollControl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 2) {
                if (motionEvent.getY() > this.startY) {
                    IScrollControl iScrollControl2 = this.scrollControl;
                    if (iScrollControl2 != null && !iScrollControl2.isEnableScrollDown(motionEvent)) {
                        return false;
                    }
                } else if (motionEvent.getY() < this.startY && (iScrollControl = this.scrollControl) != null && !iScrollControl.isEnableScrollUp(motionEvent)) {
                    return false;
                }
            } else if (motionEvent.getAction() == 0) {
                this.startY = motionEvent.getY();
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 4) {
                this.startY = 0.0f;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
