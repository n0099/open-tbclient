package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.floating.config.Config;
import kotlin.c;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@e
/* loaded from: classes14.dex */
public final class TouchHelper {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(TouchHelper.class), "mScreenHeight", "getMScreenHeight()I")), s.a(new PropertyReference1Impl(s.G(TouchHelper.class), "navigationBarHeight", "getNavigationBarHeight()I")), s.a(new PropertyReference1Impl(s.G(TouchHelper.class), "mTouchSlop", "getMTouchSlop()I")), s.a(new PropertyReference1Impl(s.G(TouchHelper.class), "mBlockOffset", "getMBlockOffset()Landroid/graphics/Rect;"))};
    private final Config config;
    private final Context context;
    private final c mBlockOffset$delegate;
    private int mDisplayHeight;
    private Rect mDisplayRect;
    private int mDisplayWidth;
    private int mEmptyHeight;
    private boolean mHasStatusBar;
    private float mLastX;
    private float mLastY;
    private final c mScreenHeight$delegate;
    private final c mTouchSlop$delegate;
    private final c navigationBarHeight$delegate;

    private final Rect getMBlockOffset() {
        c cVar = this.mBlockOffset$delegate;
        j jVar = $$delegatedProperties[3];
        return (Rect) cVar.getValue();
    }

    private final int getMScreenHeight() {
        c cVar = this.mScreenHeight$delegate;
        j jVar = $$delegatedProperties[0];
        return ((Number) cVar.getValue()).intValue();
    }

    private final int getMTouchSlop() {
        c cVar = this.mTouchSlop$delegate;
        j jVar = $$delegatedProperties[2];
        return ((Number) cVar.getValue()).intValue();
    }

    private final int getNavigationBarHeight() {
        c cVar = this.navigationBarHeight$delegate;
        j jVar = $$delegatedProperties[1];
        return ((Number) cVar.getValue()).intValue();
    }

    public TouchHelper(Context context, Config config) {
        p.p(context, "context");
        p.p(config, "config");
        this.context = context;
        this.config = config;
        this.mDisplayRect = new Rect();
        this.mScreenHeight$delegate = d.b(new TouchHelper$mScreenHeight$2(this));
        this.navigationBarHeight$delegate = d.b(new TouchHelper$navigationBarHeight$2(this));
        this.mTouchSlop$delegate = d.b(new TouchHelper$mTouchSlop$2(this));
        this.mHasStatusBar = true;
        this.mBlockOffset$delegate = d.b(new TouchHelper$mBlockOffset$2(this));
    }

    public final Config getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void onTouch(View view, MotionEvent motionEvent, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        p.p(view, "view");
        p.p(motionEvent, "event");
        p.p(windowManager, "windowManager");
        p.p(layoutParams, "params");
        if (!this.config.getCanDrag() || this.config.isAnimating()) {
            this.config.setDragging(false);
            return;
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.config.setDragging(false);
                recordLocation(motionEvent);
                updateDisplayInfo(windowManager);
                this.mHasStatusBar = hasStatusBar();
                this.mEmptyHeight = this.mDisplayHeight - view.getHeight();
                return;
            case 1:
                this.config.setDragging(false);
                return;
            case 2:
                float rawX = motionEvent.getRawX() - this.mLastX;
                float rawY = motionEvent.getRawY() - this.mLastY;
                if (this.config.isDragging() || (rawX * rawX) + (rawY * rawY) >= getMTouchSlop()) {
                    this.config.setDragging(true);
                    layoutParams.x = calculateX(layoutParams.x, view.getWidth(), (int) rawX);
                    layoutParams.y = calculateY(layoutParams.y, (int) rawY);
                    windowManager.updateViewLayout(view, layoutParams);
                    recordLocation(motionEvent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final int calculateY(int i, int i2) {
        int i3 = i + i2;
        int i4 = getMBlockOffset().top;
        int i5 = this.mEmptyHeight - getMBlockOffset().bottom;
        if (i3 < i4) {
            return i4;
        }
        return i3 > i5 ? i5 : i3;
    }

    private final int calculateX(int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = getMBlockOffset().left;
        int i6 = (this.mDisplayWidth - i2) - getMBlockOffset().right;
        if (i4 < i5) {
            return i5;
        }
        return i4 > i6 ? i6 : i4;
    }

    private final boolean hasStatusBar() {
        return this.mDisplayHeight == getMScreenHeight() || this.mDisplayHeight + getNavigationBarHeight() == getMScreenHeight();
    }

    private final void updateDisplayInfo(WindowManager windowManager) {
        windowManager.getDefaultDisplay().getRectSize(this.mDisplayRect);
        this.mDisplayWidth = this.mDisplayRect.width();
        this.mDisplayHeight = this.mDisplayRect.height();
    }

    private final void recordLocation(MotionEvent motionEvent) {
        this.mLastX = motionEvent.getRawX();
        this.mLastY = motionEvent.getRawY();
    }
}
