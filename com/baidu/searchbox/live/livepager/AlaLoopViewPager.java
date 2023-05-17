package com.baidu.searchbox.live.livepager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    public static final boolean DEFAULT_BOUNDARY_CASHING = false;
    public AlaLoopPagerAdapterWrapper mAdapter;
    public boolean mBoundaryCaching;
    public ViewPager.OnPageChangeListener mOuterPageChangeListener;
    public ViewPager.OnPageChangeListener onPageChangeListener;
    public IScrollControl scrollControl;
    public float startY;

    /* loaded from: classes3.dex */
    public interface IScrollControl {
        boolean isEnableScrollDown(MotionEvent motionEvent);

        boolean isEnableScrollUp(MotionEvent motionEvent);
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.mBoundaryCaching = false;
        this.onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.live.livepager.AlaLoopViewPager.1
            public float mPreviousOffset = -1.0f;
            public float mPreviousPosition = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int realPosition = AlaLoopViewPager.this.mAdapter.toRealPosition(i);
                float f = realPosition;
                if (this.mPreviousPosition != f) {
                    this.mPreviousPosition = f;
                    ViewPager.OnPageChangeListener onPageChangeListener = AlaLoopViewPager.this.mOuterPageChangeListener;
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageSelected(realPosition);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.mAdapter != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int realPosition = AlaLoopViewPager.this.mAdapter.toRealPosition(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.mAdapter.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(realPosition, true);
                    }
                }
                ViewPager.OnPageChangeListener onPageChangeListener = AlaLoopViewPager.this.mOuterPageChangeListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.mAdapter != null) {
                    int realPosition = AlaLoopViewPager.this.mAdapter.toRealPosition(i);
                    if (f == 0.0f && this.mPreviousOffset == 0.0f && (i == 0 || i == AlaLoopViewPager.this.mAdapter.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(realPosition, true);
                    }
                    i = realPosition;
                }
                this.mPreviousOffset = f;
                ViewPager.OnPageChangeListener onPageChangeListener = AlaLoopViewPager.this.mOuterPageChangeListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        };
        this.startY = 0.0f;
        init();
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.mAdapter = alaLoopPagerAdapterWrapper;
        alaLoopPagerAdapterWrapper.setBoundaryCaching(this.mBoundaryCaching);
        super.setAdapter(this.mAdapter);
        setCurrentItem(0, false);
    }

    public void setBoundaryCaching(boolean z) {
        this.mBoundaryCaching = z;
        AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = this.mAdapter;
        if (alaLoopPagerAdapterWrapper != null) {
            alaLoopPagerAdapterWrapper.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOuterPageChangeListener = onPageChangeListener;
    }

    public void setScrollControl(IScrollControl iScrollControl) {
        this.scrollControl = iScrollControl;
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBoundaryCaching = false;
        this.onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.live.livepager.AlaLoopViewPager.1
            public float mPreviousOffset = -1.0f;
            public float mPreviousPosition = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int realPosition = AlaLoopViewPager.this.mAdapter.toRealPosition(i);
                float f = realPosition;
                if (this.mPreviousPosition != f) {
                    this.mPreviousPosition = f;
                    ViewPager.OnPageChangeListener onPageChangeListener = AlaLoopViewPager.this.mOuterPageChangeListener;
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageSelected(realPosition);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.mAdapter != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int realPosition = AlaLoopViewPager.this.mAdapter.toRealPosition(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.mAdapter.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(realPosition, true);
                    }
                }
                ViewPager.OnPageChangeListener onPageChangeListener = AlaLoopViewPager.this.mOuterPageChangeListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.mAdapter != null) {
                    int realPosition = AlaLoopViewPager.this.mAdapter.toRealPosition(i);
                    if (f == 0.0f && this.mPreviousOffset == 0.0f && (i == 0 || i == AlaLoopViewPager.this.mAdapter.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(realPosition, true);
                    }
                    i = realPosition;
                }
                this.mPreviousOffset = f;
                ViewPager.OnPageChangeListener onPageChangeListener = AlaLoopViewPager.this.mOuterPageChangeListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        };
        this.startY = 0.0f;
        init();
    }

    public static int toRealPosition(int i, int i2) {
        int i3 = i - 1;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3 % i2;
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.mAdapter.toInnerPosition(i), z);
    }

    private void init() {
        super.setOnPageChangeListener(this.onPageChangeListener);
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = this.mAdapter;
        if (alaLoopPagerAdapterWrapper != null) {
            return alaLoopPagerAdapterWrapper.getRealAdapter();
        }
        return alaLoopPagerAdapterWrapper;
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        AlaLoopPagerAdapterWrapper alaLoopPagerAdapterWrapper = this.mAdapter;
        if (alaLoopPagerAdapterWrapper != null) {
            return alaLoopPagerAdapterWrapper.toRealPosition(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.searchbox.live.livepager.AlaVerticalViewPagerNew, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IScrollControl iScrollControl;
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
}
