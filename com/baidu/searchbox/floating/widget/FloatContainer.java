package com.baidu.searchbox.floating.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.searchbox.floating.widget.FloatContainer;
import java.util.HashMap;
import kotlin.e;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes14.dex */
public final class FloatContainer extends FrameLayout {
    private HashMap _$_findViewCache;
    private ClickListener clickListener;
    private final Config config;
    private final GestureDetector gestureDetector;
    private boolean isCreate;
    private LayoutListener layoutListener;
    private TouchListener touchListener;

    @e
    /* loaded from: classes14.dex */
    public interface ClickListener {
        void onClick();
    }

    @e
    /* loaded from: classes14.dex */
    public interface LayoutListener {
        void onLayout();
    }

    @e
    /* loaded from: classes14.dex */
    public interface TouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public final Config getConfig() {
        return this.config;
    }

    public /* synthetic */ FloatContainer(Config config, Context context, AttributeSet attributeSet, int i, int i2, o oVar) {
        this(config, context, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatContainer(Config config, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        p.p(config, "config");
        p.p(context, "context");
        this.config = config;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.floating.widget.FloatContainer$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                FloatContainer.ClickListener clickListener = FloatContainer.this.getClickListener();
                if (clickListener != null) {
                    clickListener.onClick();
                    return true;
                }
                return true;
            }
        });
    }

    public final TouchListener getTouchListener() {
        return this.touchListener;
    }

    public final void setTouchListener(TouchListener touchListener) {
        this.touchListener = touchListener;
    }

    public final LayoutListener getLayoutListener() {
        return this.layoutListener;
    }

    public final void setLayoutListener(LayoutListener layoutListener) {
        this.layoutListener = layoutListener;
    }

    public final ClickListener getClickListener() {
        return this.clickListener;
    }

    public final void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.isCreate) {
            this.isCreate = true;
            LayoutListener layoutListener = this.layoutListener;
            if (layoutListener != null) {
                layoutListener.onLayout();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchListener touchListener;
        if (motionEvent != null && (touchListener = this.touchListener) != null) {
            touchListener.onTouch(motionEvent);
        }
        return this.config.isDragging() || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchListener touchListener;
        if (motionEvent != null && (touchListener = this.touchListener) != null) {
            touchListener.onTouch(motionEvent);
        }
        return this.config.isDragging() || super.onTouchEvent(motionEvent);
    }
}
