package com.baidu.browser.webkit.sys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.baidu.browser.webkit.BdWebView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class BdSysTitleBarWebView16 extends BdSysWebView16 {
    private static final String TAG = "TitleBarWebView";
    private Rect mClipBounds;
    private Matrix mMatrix;
    private Method mNativeGetVisibleTitleHeightMethod;
    private View mTitleBar;
    private int mTitleBarOffs;
    private boolean mTouchInTitleBar;
    private boolean mTouchMove;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TouchBlockView extends FrameLayout {
        public TouchBlockView(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (BdSysTitleBarWebView16.this.mTouchInTitleBar) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        BdSysTitleBarWebView16.this.mTouchInTitleBar = false;
                        break;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public BdSysTitleBarWebView16(BdWebView bdWebView, Context context) {
        super(bdWebView, context);
        this.mClipBounds = new Rect();
        this.mMatrix = new Matrix();
        init();
    }

    public BdSysTitleBarWebView16(BdWebView bdWebView, Context context, AttributeSet attributeSet) {
        super(bdWebView, context, attributeSet);
        this.mClipBounds = new Rect();
        this.mMatrix = new Matrix();
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mTitleBar != null) {
            int scrollY = getScrollY();
            int visibleTitleHeightCompat = getVisibleTitleHeightCompat();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    if (y <= visibleTitleHeightCompat) {
                        this.mTouchInTitleBar = true;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    this.mTouchMove = false;
                    break;
                case 2:
                    this.mTouchMove = true;
                    break;
            }
            if (this.mTouchInTitleBar) {
                motionEvent.setLocation(x, scrollY + y);
                return this.mTitleBar.dispatchTouchEvent(motionEvent);
            }
            if (!this.mTouchMove) {
                this.mTitleBarOffs = getVisibleTitleHeightCompat();
            }
            float f = y - this.mTitleBarOffs;
            motionEvent.setLocation(x, f >= 0.0f ? f : 0.0f);
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void setEmbeddedTitleBar(View view) {
        setEmbeddedTitleBarJellyBean(view);
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        return this.mTitleBar == null ? super.computeVerticalScrollExtent() : getViewHeightWithTitle() - getVisibleTitleHeightCompat();
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return this.mTitleBar == null ? super.computeVerticalScrollOffset() : Math.max(getScrollY() - getTitleHeight(), 0);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebView, android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        if (view == this.mTitleBar) {
            this.mTitleBar.offsetLeftAndRight(getScrollX() - this.mTitleBar.getLeft());
            this.mMatrix.set(canvas.getMatrix());
            this.mMatrix.postTranslate(0.0f, -getScrollY());
            canvas.setMatrix(this.mMatrix);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (this.mTitleBar != null) {
            int scrollY = getScrollY();
            int scrollX = getScrollX();
            this.mClipBounds.top = scrollY;
            this.mClipBounds.left = scrollX;
            this.mClipBounds.right = this.mClipBounds.left + getWidth();
            this.mClipBounds.bottom = this.mClipBounds.top + getHeight();
            canvas.clipRect(this.mClipBounds);
            this.mMatrix.set(canvas.getMatrix());
            int visibleTitleHeightCompat = getVisibleTitleHeightCompat();
            if (visibleTitleHeightCompat < 0) {
                visibleTitleHeightCompat = 0;
            }
            this.mMatrix.postTranslate(0.0f, visibleTitleHeightCompat);
            canvas.setMatrix(this.mMatrix);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        if (scrollY < 0) {
            i2 -= scrollY;
        }
        drawable.setBounds(i, getVisibleTitleHeightCompat() + i2, i3, i4);
        drawable.draw(canvas);
    }

    private int getTitleHeight() {
        if (this.mTitleBar != null) {
            return this.mTitleBar.getHeight();
        }
        return 0;
    }

    private int getViewHeightWithTitle() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            return height - getHorizontalScrollbarHeight();
        }
        return height;
    }

    private int getVisibleTitleHeightCompat() {
        if (this.mTitleBar == null && this.mNativeGetVisibleTitleHeightMethod != null) {
            try {
                return ((Integer) this.mNativeGetVisibleTitleHeightMethod.invoke(this, new Object[0])).intValue();
            } catch (Exception e) {
            }
        }
        return Math.max(getTitleHeight() - Math.max(0, getScrollY()), 0);
    }

    private void init() {
        try {
            this.mNativeGetVisibleTitleHeightMethod = WebView.class.getDeclaredMethod("getVisibleTitleHeight", new Class[0]);
        } catch (NoSuchMethodException e) {
            Log.w(TAG, "Could not retrieve native hidden getVisibleTitleHeight method");
        }
    }

    private void setEmbeddedTitleBarJellyBean(View view) {
        if (this.mTitleBar != view) {
            if (this.mTitleBar != null) {
                removeView(this.mTitleBar);
            }
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(-1, -2, 0, 0);
                TouchBlockView touchBlockView = new TouchBlockView(getContext());
                touchBlockView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                addView(touchBlockView, layoutParams);
                view = touchBlockView;
            }
            this.mTitleBar = view;
        }
    }
}
