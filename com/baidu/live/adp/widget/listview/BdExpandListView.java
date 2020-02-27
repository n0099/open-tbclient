package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.live.adp.R;
/* loaded from: classes3.dex */
public class BdExpandListView extends BdListView {
    private static final int DURATION_MS = 200;
    private float currentX;
    private float currentY;
    private final int expandDis;
    private boolean isExpanding;
    private final Context mContext;
    private View mExpandView;
    private int mOriginalHeight;
    public ExpandListRefreshListener mRefreshListener;
    private final Scroller mScroller;
    private float startX;
    private float startY;
    private TouchTool tool;
    private final int touchSlop;

    /* loaded from: classes3.dex */
    public interface ExpandListRefreshListener {
        void onExpandingDegree(float f);

        void onNotExpanding();

        void onRefresh();
    }

    public BdExpandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isExpanding = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sdk_ExpandListView);
        this.expandDis = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view, int i) {
        this.mExpandView = view;
        this.mOriginalHeight = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.currentY = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.mExpandView.getHeight();
                    this.startY = this.currentY;
                    this.startX = this.currentX;
                    this.tool = new TouchTool(0, height, 0, this.expandDis + height);
                    break;
                case 1:
                case 3:
                    if (this.isExpanding) {
                        scrollCallback();
                    } else {
                        this.mRefreshListener.onNotExpanding();
                    }
                    new Handler().postDelayed(new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdExpandListView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdExpandListView.this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(BdExpandListView.this.mExpandView.getWidth(), BdExpandListView.this.mOriginalHeight));
                            BdExpandListView.this.invalidate();
                        }
                    }, 200L);
                    break;
                case 2:
                    float f = this.currentX - this.startX;
                    float f2 = this.currentY - this.startY;
                    this.startX = this.currentX;
                    if (this.mExpandView.getParent() == this && this.tool != null && this.mExpandView.isShown() && this.mExpandView.getTop() >= 0 && Math.abs(f2) >= this.touchSlop && Math.abs(f) < this.touchSlop) {
                        int scrollY = this.tool.getScrollY(this.currentY - this.startY);
                        if (scrollY > this.tool.startY && scrollY <= this.tool.endY) {
                            this.isExpanding = true;
                            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), scrollY));
                            controllTheStaticProgress(scrollY - this.tool.startY);
                            break;
                        } else if (scrollY <= this.tool.startY) {
                            this.isExpanding = false;
                            break;
                        } else if (scrollY > this.tool.endY) {
                            this.isExpanding = true;
                            break;
                        } else {
                            this.isExpanding = false;
                            break;
                        }
                    } else {
                        this.isExpanding = false;
                        break;
                    }
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isExpanding) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isExpanding) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollCallback() {
        if (this.tool != null) {
            if (this.mExpandView.getHeight() >= this.tool.endY - (this.expandDis / 2)) {
                doRefresh();
            } else {
                this.mRefreshListener.onNotExpanding();
            }
            this.mScroller.startScroll(0, this.mExpandView.getHeight(), 0, this.tool.startY - this.mExpandView.getHeight(), 200);
            invalidate();
            this.isExpanding = false;
        }
    }

    public void doRefresh() {
        if (this.mRefreshListener != null) {
            this.mRefreshListener.onRefresh();
        }
    }

    public void setExpandListRefreshListener(ExpandListRefreshListener expandListRefreshListener) {
        this.mRefreshListener = expandListRefreshListener;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.mExpandView.setLayoutParams(new AbsListView.LayoutParams(this.mExpandView.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void controllTheStaticProgress(float f) {
        this.mRefreshListener.onExpandingDegree(360.0f - ((f * 360.0f) / this.expandDis));
    }

    /* loaded from: classes3.dex */
    public static class TouchTool {
        public int endX;
        public int endY;
        public int startX;
        public int startY;

        public TouchTool(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.endY = i4;
        }

        public int getScrollX(float f) {
            return (int) (this.startX + (f / 2.5f));
        }

        public int getScrollY(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
