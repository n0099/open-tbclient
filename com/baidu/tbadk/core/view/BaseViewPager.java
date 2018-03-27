package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes.dex */
public class BaseViewPager extends TbViewPager implements GestureDetector.OnGestureListener {
    private a aZs;
    private a aZt;
    private boolean aZu;
    private GestureDetector mGestureDetector;

    /* loaded from: classes.dex */
    public interface a {
        void fZ(int i);
    }

    public BaseViewPager(Context context) {
        super(context);
        this.mGestureDetector = null;
        this.aZs = null;
        this.aZt = null;
        this.aZu = false;
        init();
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = null;
        this.aZs = null;
        this.aZt = null;
        this.aZu = false;
        init();
    }

    public void setOnFlipOutListener(a aVar) {
        this.aZs = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.aZt = aVar;
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
        if (this.aZs != null) {
            if (f < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.aZs.fZ(0);
                return true;
            } else if (f > 0.0f && getCurrentItem() == 0) {
                this.aZs.fZ(1);
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
        if (this.aZt != null) {
            if (f > 10.0d && getAdapter().getCount() == getCurrentItem() + 1) {
                if (this.aZu) {
                    this.aZu = false;
                    this.aZt.fZ(0);
                    return true;
                }
                this.aZu = true;
            } else if (f < 0.0f && getCurrentItem() == 0) {
                this.aZt.fZ(1);
                return true;
            } else {
                this.aZu = false;
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
