package com.baidu.searchbox.player.view;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.utils.BdGestureHelper;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002 !B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "view", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "(Landroid/view/View;Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;)V", "isMoveDetected", "", "()Z", "setMoveDetected", "(Z)V", "lastPointerCount", "", "lastX", "", "lastY", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "setListener", "(Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;)V", "getView", "()Landroid/view/View;", "cancelMove", "", "minPointerCount", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setTranslate", "offsetX", "offsetY", "OnMoveGestureListener", "SimpleOnMoveGestureListener", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BdVideoMoveGestureDetector implements IKernelGestureDetector {
    public boolean isMoveDetected;
    public int lastPointerCount;
    public float lastX;
    public float lastY;
    public OnMoveGestureListener listener;

    /* renamed from: view  reason: collision with root package name */
    public final View f1060view;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "", "onMoveBegin", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "onMoveEnd", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnMoveGestureListener {
        void onMoveBegin(BdVideoMoveGestureDetector bdVideoMoveGestureDetector);

        void onMoveEnd(BdVideoMoveGestureDetector bdVideoMoveGestureDetector);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "()V", "onMoveBegin", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "onMoveEnd", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class SimpleOnMoveGestureListener implements OnMoveGestureListener {
        @Override // com.baidu.searchbox.player.view.BdVideoMoveGestureDetector.OnMoveGestureListener
        public void onMoveBegin(BdVideoMoveGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }

        @Override // com.baidu.searchbox.player.view.BdVideoMoveGestureDetector.OnMoveGestureListener
        public void onMoveEnd(BdVideoMoveGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }
    }

    public int minPointerCount() {
        return 2;
    }

    public BdVideoMoveGestureDetector(View view2, OnMoveGestureListener onMoveGestureListener) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1060view = view2;
        this.listener = onMoveGestureListener;
    }

    public /* synthetic */ BdVideoMoveGestureDetector(View view2, OnMoveGestureListener onMoveGestureListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, (i & 2) != 0 ? null : onMoveGestureListener);
    }

    private final void cancelMove() {
        this.lastPointerCount = 0;
        this.isMoveDetected = false;
        OnMoveGestureListener onMoveGestureListener = this.listener;
        if (onMoveGestureListener != null) {
            onMoveGestureListener.onMoveEnd(this);
        }
        BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->滑动取消");
    }

    public final OnMoveGestureListener getListener() {
        return this.listener;
    }

    public final View getView() {
        return this.f1060view;
    }

    public final boolean isMoveDetected() {
        return this.isMoveDetected;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r0 != 6) goto L24;
     */
    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        int minPointerCount;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(event, "event");
        BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->event: " + event + ".action");
        int pointerCount = event.getPointerCount();
        if (minPointerCount() < 2) {
            minPointerCount = 2;
        } else {
            minPointerCount = minPointerCount();
        }
        boolean z3 = false;
        if (pointerCount < minPointerCount) {
            this.lastPointerCount = 0;
            return false;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f += event.getX(i);
            f2 += event.getY(i);
        }
        float f3 = pointerCount;
        float f4 = f / f3;
        float f5 = f2 / f3;
        if (pointerCount != this.lastPointerCount) {
            this.lastX = f4;
            this.lastY = f5;
        }
        this.lastPointerCount = pointerCount;
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                }
            } else {
                float f6 = f4 - this.lastX;
                float f7 = f5 - this.lastY;
                BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->dx=" + f6 + ", y=" + f7);
                if (!this.isMoveDetected) {
                    if (Math.abs(event.getX(1) - event.getX(0)) <= BdGestureHelper.touchSlop(this.f1060view) && Math.abs(event.getY(1) - event.getY(0)) <= BdGestureHelper.touchSlop(this.f1060view)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    this.isMoveDetected = z2;
                    if (z2) {
                        return false;
                    }
                }
                boolean actionMoveEnabled = BdGestureHelper.actionMoveEnabled(this.f1060view, f6, f7);
                this.isMoveDetected = actionMoveEnabled;
                if (actionMoveEnabled) {
                    if (f6 == 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (f7 == 0.0f) {
                            z3 = true;
                        }
                        if (!z3) {
                            OnMoveGestureListener onMoveGestureListener = this.listener;
                            if (onMoveGestureListener != null) {
                                onMoveGestureListener.onMoveBegin(this);
                            }
                            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->触发滑动");
                            setTranslate(f6, f7);
                            this.lastX = f4;
                            this.lastY = f5;
                        }
                    }
                }
            }
            return true;
        }
        cancelMove();
        return true;
    }

    public final void setListener(OnMoveGestureListener onMoveGestureListener) {
        this.listener = onMoveGestureListener;
    }

    public final void setMoveDetected(boolean z) {
        this.isMoveDetected = z;
    }

    public void setTranslate(float f, float f2) {
        boolean z;
        if (this.f1060view.getScaleX() <= 1.0f) {
            View view2 = this.f1060view;
            view2.setTranslationX(view2.getTranslationX() + f);
            View view3 = this.f1060view;
            view3.setTranslationY(view3.getTranslationY() + f2);
            return;
        }
        PointF scaleMovePointF$default = BdGestureHelper.getScaleMovePointF$default(this.f1060view, f, f2, false, 4, null);
        boolean z2 = true;
        if (scaleMovePointF$default.x == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            View view4 = this.f1060view;
            view4.setTranslationX(view4.getTranslationX() + scaleMovePointF$default.x);
        }
        if (scaleMovePointF$default.y != 0.0f) {
            z2 = false;
        }
        if (!z2) {
            View view5 = this.f1060view;
            view5.setTranslationY(view5.getTranslationY() + scaleMovePointF$default.y);
        }
    }
}
