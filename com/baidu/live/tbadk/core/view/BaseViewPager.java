package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.live.tbadk.widget.TbViewPager;
/* loaded from: classes2.dex */
public class BaseViewPager extends TbViewPager implements GestureDetector.OnGestureListener {
    public static final int SCROLL_NEXT = 0;
    public static final int SCROLL_PRE = 1;
    private GestureDetector mGestureDetector;
    private OnScrollOutListener mOnFlipOutListener;
    private OnScrollOutListener mOnScrollOutListener;
    private boolean scrollFiltter;

    /* loaded from: classes2.dex */
    public interface OnScrollOutListener {
        void onScrollOut(int i);
    }

    public BaseViewPager(Context context) {
        super(context);
        this.mGestureDetector = null;
        this.mOnFlipOutListener = null;
        this.mOnScrollOutListener = null;
        this.scrollFiltter = false;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = null;
        this.mOnFlipOutListener = null;
        this.mOnScrollOutListener = null;
        this.scrollFiltter = false;
        init();
    }

    public void setOnFlipOutListener(OnScrollOutListener onScrollOutListener) {
        this.mOnFlipOutListener = onScrollOutListener;
    }

    public void setOnScrollOutListener(OnScrollOutListener onScrollOutListener) {
        this.mOnScrollOutListener = onScrollOutListener;
    }

    @Override // com.baidu.live.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector == null || getAdapter() == null || getAdapter().getCount() == 0 || (getCurrentItem() != 0 && getAdapter().getCount() != getCurrentItem() + 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private void init() {
        this.mGestureDetector = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mOnFlipOutListener != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.mOnFlipOutListener.onScrollOut(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.mOnFlipOutListener.onScrollOut(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mOnScrollOutListener != null) {
            if (f > 10.0d && getAdapter().getCount() == getCurrentItem() + 1) {
                if (this.scrollFiltter) {
                    this.scrollFiltter = false;
                    this.mOnScrollOutListener.onScrollOut(0);
                    return true;
                }
                this.scrollFiltter = true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.mOnScrollOutListener.onScrollOut(1);
                return true;
            } else {
                this.scrollFiltter = false;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
