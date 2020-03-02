package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class BaseViewPager extends TbViewPager implements GestureDetector.OnGestureListener {
    private a ddR;
    private a ddS;
    private GestureDetector mGestureDetector;
    private boolean scrollFiltter;

    /* loaded from: classes.dex */
    public interface a {
        void onScrollOut(int i);
    }

    public BaseViewPager(Context context) {
        super(context);
        this.mGestureDetector = null;
        this.ddR = null;
        this.ddS = null;
        this.scrollFiltter = false;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = null;
        this.ddR = null;
        this.ddS = null;
        this.scrollFiltter = false;
        init();
    }

    public void setOnFlipOutListener(a aVar) {
        this.ddR = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.ddS = aVar;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
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
        if (this.ddR != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.ddR.onScrollOut(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.ddR.onScrollOut(1);
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
        if (this.ddS != null) {
            if (f > 10.0d && getAdapter().getCount() == getCurrentItem() + 1) {
                if (this.scrollFiltter) {
                    this.scrollFiltter = false;
                    this.ddS.onScrollOut(0);
                    return true;
                }
                this.scrollFiltter = true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.ddS.onScrollOut(1);
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
