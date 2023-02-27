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
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u000389:B-\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\b¢\u0006\u0004\b6\u00107J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0011\u0010\u0006R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006;"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", Config.EVENT_PART, "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "changed", "", "left", "top", "right", "bottom", "", "onLayout", "(ZIIII)V", "event", "onTouchEvent", "Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "clickListener", "Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "getClickListener", "()Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "setClickListener", "(Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;)V", "Lcom/baidu/searchbox/floating/config/Config;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "isCreate", "Z", "Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "layoutListener", "Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "getLayoutListener", "()Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "setLayoutListener", "(Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;)V", "Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "touchListener", "Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "getTouchListener", "()Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "setTouchListener", "(Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Lcom/baidu/searchbox/floating/config/Config;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ClickListener", "LayoutListener", "TouchListener", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class FloatContainer extends FrameLayout {
    public HashMap _$_findViewCache;
    public ClickListener clickListener;
    public final com.baidu.searchbox.floating.config.Config config;
    public final GestureDetector gestureDetector;
    public boolean isCreate;
    public LayoutListener layoutListener;
    public TouchListener touchListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer$ClickListener;", "Lkotlin/Any;", "", "onClick", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface ClickListener {
        void onClick();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer$LayoutListener;", "Lkotlin/Any;", "", "onLayout", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface LayoutListener {
        void onLayout();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/floating/widget/FloatContainer$TouchListener;", "Lkotlin/Any;", "Landroid/view/MotionEvent;", "event", "", MissionEvent.MESSAGE_TOUCH, "(Landroid/view/MotionEvent;)V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface TouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatContainer(com.baidu.searchbox.floating.config.Config config, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
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
