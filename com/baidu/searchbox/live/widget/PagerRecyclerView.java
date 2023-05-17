package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes3.dex */
public class PagerRecyclerView extends RecyclerView {
    public CanScrollListener listener;
    public int mInitMotionX;
    public int mInitMotionY;
    public boolean mIsCanSwitchPage;
    public View.OnTouchListener mTouchListener;

    /* loaded from: classes3.dex */
    public interface CanScrollListener {
        boolean isCanScrollable(MotionEvent motionEvent);
    }

    public PagerRecyclerView(Context context) {
        super(context);
        this.mIsCanSwitchPage = true;
    }

    public boolean isCanScrollable(MotionEvent motionEvent) {
        CanScrollListener canScrollListener = this.listener;
        if (canScrollListener != null) {
            return canScrollListener.isCanScrollable(motionEvent);
        }
        return true;
    }

    public void setCanScrollListener(CanScrollListener canScrollListener) {
        this.listener = canScrollListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (layoutManager instanceof View.OnTouchListener) {
            this.mTouchListener = (View.OnTouchListener) layoutManager;
        }
    }

    public PagerRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsCanSwitchPage = true;
    }

    public PagerRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsCanSwitchPage = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!isCanScrollable(motionEvent)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                if (Math.abs(((int) motionEvent.getY()) - this.mInitMotionY) * 0.5f > Math.abs(((int) motionEvent.getX()) - this.mInitMotionX)) {
                    z = true;
                    if (!z && super.onInterceptTouchEvent(motionEvent)) {
                        return true;
                    }
                }
            }
            z = false;
            return !z ? false : false;
        }
        this.mIsCanSwitchPage = true;
        this.mInitMotionY = (int) motionEvent.getY();
        this.mInitMotionX = (int) motionEvent.getX();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && !this.mIsCanSwitchPage) {
                View.OnTouchListener onTouchListener = this.mTouchListener;
                if (onTouchListener instanceof PagerLayoutManager) {
                    smoothScrollToPosition(((PagerLayoutManager) onTouchListener).getPosition());
                    return true;
                }
            }
        } else {
            this.mIsCanSwitchPage = true;
        }
        if (!isCanScrollable(motionEvent)) {
            this.mIsCanSwitchPage = false;
            return false;
        }
        View.OnTouchListener onTouchListener2 = this.mTouchListener;
        if (onTouchListener2 != null) {
            onTouchListener2.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }
}
