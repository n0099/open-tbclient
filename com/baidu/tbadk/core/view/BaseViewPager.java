package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tbadk.widget.TbViewPager;
/* loaded from: classes3.dex */
public class BaseViewPager extends TbViewPager implements GestureDetector.OnGestureListener {

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector f12182i;
    public a j;
    public a k;
    public boolean l;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2);
    }

    public BaseViewPager(Context context) {
        super(context);
        this.f12182i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        b();
    }

    private void b() {
        this.f12182i = new GestureDetector(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (this.j != null) {
            if (f2 < 0.0f && getAdapter().getCount() == getCurrentItem() + 1) {
                this.j.a(0);
                return true;
            } else if (f2 > 0.0f && getCurrentItem() == 0) {
                this.j.a(1);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (this.k != null) {
            if (f2 > 10.0d && getAdapter().getCount() == getCurrentItem() + 1) {
                if (this.l) {
                    this.l = false;
                    this.k.a(0);
                    return true;
                }
                this.l = true;
            } else if (f2 < 0.0f && getCurrentItem() == 0) {
                this.k.a(1);
                return true;
            } else {
                this.l = false;
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

    @Override // com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12182i != null && getAdapter() != null && getAdapter().getCount() != 0 && (getCurrentItem() == 0 || getAdapter().getCount() == getCurrentItem() + 1)) {
            this.f12182i.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnFlipOutListener(a aVar) {
        this.j = aVar;
    }

    public void setOnScrollOutListener(a aVar) {
        this.k = aVar;
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12182i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        b();
    }
}
