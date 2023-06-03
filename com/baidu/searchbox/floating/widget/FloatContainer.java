package com.baidu.searchbox.floating.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.floating.widget.FloatContainer;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0003/01B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J0\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0014J\u0012\u0010-\u001a\u00020\u00162\b\u0010.\u001a\u0004\u0018\u00010%H\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer;", "Landroid/widget/FrameLayout;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Lcom/baidu/searchbox/floating/config/Config;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "getClickListener", "()Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "setClickListener", "(Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;)V", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "gestureDetector", "Landroid/view/GestureDetector;", "isCreate", "", "layoutListener", "Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "getLayoutListener", "()Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "setLayoutListener", "(Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;)V", "touchListener", "Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "getTouchListener", "()Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "setTouchListener", "(Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;)V", "onInterceptTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "onLayout", "", "changed", "left", "top", "right", "bottom", "onTouchEvent", "event", "ClickListener", "LayoutListener", "TouchListener", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class FloatContainer extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    public ClickListener clickListener;
    public final com.baidu.searchbox.floating.config.Config config;
    public final GestureDetector gestureDetector;
    public boolean isCreate;
    public LayoutListener layoutListener;
    public TouchListener touchListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "", "onClick", "", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ClickListener {
        void onClick();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "", "onLayout", "", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface LayoutListener {
        void onLayout();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "", MissionEvent.MESSAGE_TOUCH, "", "event", "Landroid/view/MotionEvent;", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface TouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatContainer(com.baidu.searchbox.floating.config.Config config, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.config = config;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.floating.widget.FloatContainer$gestureDetector$1
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

    public /* synthetic */ FloatContainer(com.baidu.searchbox.floating.config.Config config, Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, context, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    public final ClickListener getClickListener() {
        return this.clickListener;
    }

    public final com.baidu.searchbox.floating.config.Config getConfig() {
        return this.config;
    }

    public final LayoutListener getLayoutListener() {
        return this.layoutListener;
    }

    public final TouchListener getTouchListener() {
        return this.touchListener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchListener touchListener;
        if (motionEvent != null && (touchListener = this.touchListener) != null) {
            touchListener.onTouch(motionEvent);
        }
        if (!this.config.isDragging() && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchListener touchListener;
        if (motionEvent != null && (touchListener = this.touchListener) != null) {
            touchListener.onTouch(motionEvent);
        }
        if (!this.config.isDragging() && !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public final void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public final void setLayoutListener(LayoutListener layoutListener) {
        this.layoutListener = layoutListener;
    }

    public final void setTouchListener(TouchListener touchListener) {
        this.touchListener = touchListener;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.isCreate) {
            this.isCreate = true;
            LayoutListener layoutListener = this.layoutListener;
            if (layoutListener != null) {
                layoutListener.onLayout();
            }
        }
    }
}
