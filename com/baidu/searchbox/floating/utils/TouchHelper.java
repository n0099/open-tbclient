package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u0000B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bC\u0010DJ'\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010.R\u0016\u00102\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u001d\u0010<\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010;R\u001d\u0010?\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010)\u001a\u0004\b>\u0010;R\u001d\u0010B\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010)\u001a\u0004\bA\u0010;¨\u0006E"}, d2 = {"Lcom/baidu/searchbox/floating/utils/TouchHelper;", "", "originX", "width", "dx", "calculateX", "(III)I", "originY", "dy", "calculateY", "(II)I", "", "hasStatusBar", "()Z", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "event", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager$LayoutParams;", "params", "", MissionEvent.MESSAGE_TOUCH, "(Landroid/view/View;Landroid/view/MotionEvent;Landroid/view/WindowManager;Landroid/view/WindowManager$LayoutParams;)V", "recordLocation", "(Landroid/view/MotionEvent;)V", "updateDisplayInfo", "(Landroid/view/WindowManager;)V", "Lcom/baidu/searchbox/floating/config/Config;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/graphics/Rect;", "mBlockOffset$delegate", "Lkotlin/Lazy;", "getMBlockOffset", "()Landroid/graphics/Rect;", "mBlockOffset", "mDisplayHeight", "I", "mDisplayRect", "Landroid/graphics/Rect;", "mDisplayWidth", "mEmptyHeight", "mHasStatusBar", "Z", "", "mLastX", "F", "mLastY", "mScreenHeight$delegate", "getMScreenHeight", "()I", "mScreenHeight", "mTouchSlop$delegate", "getMTouchSlop", "mTouchSlop", "navigationBarHeight$delegate", "getNavigationBarHeight", "navigationBarHeight", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/floating/config/Config;)V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class TouchHelper {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TouchHelper.class), "mScreenHeight", "getMScreenHeight()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TouchHelper.class), "navigationBarHeight", "getNavigationBarHeight()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TouchHelper.class), "mTouchSlop", "getMTouchSlop()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TouchHelper.class), "mBlockOffset", "getMBlockOffset()Landroid/graphics/Rect;"))};
    public final Config config;
    public final Context context;
    public int mDisplayHeight;
    public int mDisplayWidth;
    public int mEmptyHeight;
    public float mLastX;
    public float mLastY;
    public Rect mDisplayRect = new Rect();
    public final Lazy mScreenHeight$delegate = LazyKt__LazyJVMKt.lazy(new TouchHelper$mScreenHeight$2(this));
    public final Lazy navigationBarHeight$delegate = LazyKt__LazyJVMKt.lazy(new TouchHelper$navigationBarHeight$2(this));
    public final Lazy mTouchSlop$delegate = LazyKt__LazyJVMKt.lazy(new TouchHelper$mTouchSlop$2(this));
    public boolean mHasStatusBar = true;
    public final Lazy mBlockOffset$delegate = LazyKt__LazyJVMKt.lazy(new TouchHelper$mBlockOffset$2(this));

    public TouchHelper(Context context, Config config) {
        this.context = context;
        this.config = config;
    }

    private final int calculateX(int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = getMBlockOffset().left;
        int i7 = (this.mDisplayWidth - i3) - getMBlockOffset().right;
        return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
    }

    private final int calculateY(int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = getMBlockOffset().top;
        int i6 = this.mEmptyHeight - getMBlockOffset().bottom;
        return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
    }

    private final Rect getMBlockOffset() {
        Lazy lazy = this.mBlockOffset$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (Rect) lazy.getValue();
    }

    private final int getMScreenHeight() {
        Lazy lazy = this.mScreenHeight$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
    }

    private final int getMTouchSlop() {
        Lazy lazy = this.mTouchSlop$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return ((Number) lazy.getValue()).intValue();
    }

    private final int getNavigationBarHeight() {
        Lazy lazy = this.navigationBarHeight$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
    }

    private final boolean hasStatusBar() {
        return this.mDisplayHeight == getMScreenHeight() || this.mDisplayHeight + getNavigationBarHeight() == getMScreenHeight();
    }

    private final void recordLocation(MotionEvent motionEvent) {
        this.mLastX = motionEvent.getRawX();
        this.mLastY = motionEvent.getRawY();
    }

    private final void updateDisplayInfo(WindowManager windowManager) {
        windowManager.getDefaultDisplay().getRectSize(this.mDisplayRect);
        this.mDisplayWidth = this.mDisplayRect.width();
        this.mDisplayHeight = this.mDisplayRect.height();
    }

    public final Config getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void onTouch(View view, MotionEvent motionEvent, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        if (this.config.getCanDrag() && !this.config.isAnimating()) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.config.setDragging(false);
                recordLocation(motionEvent);
                updateDisplayInfo(windowManager);
                this.mHasStatusBar = hasStatusBar();
                this.mEmptyHeight = this.mDisplayHeight - view.getHeight();
                return;
            } else if (action == 1) {
                this.config.setDragging(false);
                return;
            } else if (action != 2) {
                return;
            } else {
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
            }
        }
        this.config.setDragging(false);
    }
}
