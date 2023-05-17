package com.baidu.searchbox.player.view;

import android.view.MotionEvent;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0016¨\u0006("}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "", "cancelRotation", "()V", "Landroid/view/MotionEvent;", "event", "", "computeRotation", "(Landroid/view/MotionEvent;)F", "", "detectRotation", "()Z", "getFocusX", "()F", "getFocusY", "getRotationDelta", "isInProgress", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "tryStartRotation", "currAngle", "F", "focusX", "focusY", "initialAngle", "Z", "isRotateDetected", "setRotateDetected", "(Z)V", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "prevAngle", "<init>", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;)V", "OnRotationGestureListener", "SimpleOnRotationGestureListener", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class BdVideoRotateGestureDetector implements IKernelGestureDetector {
    public float currAngle;
    public float focusX;
    public float focusY;
    public float initialAngle;
    public boolean isInProgress;
    public boolean isRotateDetected;
    public final OnRotationGestureListener listener;
    public float prevAngle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "Lkotlin/Any;", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "detector", "", "onRotate", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)Z", "onRotationBegin", "", "onRotationEnd", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface OnRotationGestureListener {
        boolean onRotate(BdVideoRotateGestureDetector bdVideoRotateGestureDetector);

        boolean onRotationBegin(BdVideoRotateGestureDetector bdVideoRotateGestureDetector);

        void onRotationEnd(BdVideoRotateGestureDetector bdVideoRotateGestureDetector);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "com/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "detector", "", "onRotate", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)Z", "onRotationBegin", "", "onRotationEnd", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)V", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public boolean onRotate(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            return false;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public boolean onRotationBegin(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            return true;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public void onRotationEnd(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }
    }

    public BdVideoRotateGestureDetector(OnRotationGestureListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    private final float computeRotation(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(1) - motionEvent.getY(0), motionEvent.getX(1) - motionEvent.getX(0)));
    }

    public final void setRotateDetected(boolean z) {
        this.isRotateDetected = z;
    }

    private final void cancelRotation() {
        if (!this.isInProgress) {
            return;
        }
        this.isInProgress = false;
        if (this.isRotateDetected) {
            this.listener.onRotationEnd(this);
            this.isRotateDetected = false;
        }
    }

    private final boolean detectRotation() {
        if (this.isInProgress && this.isRotateDetected && this.listener.onRotate(this)) {
            return true;
        }
        return false;
    }

    private final void tryStartRotation() {
        if (!this.isInProgress && Math.abs(this.initialAngle - this.currAngle) >= 5.0f) {
            this.isInProgress = true;
            this.isRotateDetected = this.listener.onRotationBegin(this);
        }
    }

    public final float getFocusX() {
        return this.focusX;
    }

    public final float getFocusY() {
        return this.focusY;
    }

    public final OnRotationGestureListener getListener() {
        return this.listener;
    }

    public final float getRotationDelta() {
        return this.currAngle - this.prevAngle;
    }

    public final boolean isInProgress() {
        return this.isInProgress;
    }

    public final boolean isRotateDetected() {
        return this.isRotateDetected;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6 && event.getPointerCount() == 2) {
                            cancelRotation();
                        }
                    } else if (event.getPointerCount() == 2) {
                        float computeRotation = computeRotation(event);
                        this.currAngle = computeRotation;
                        this.prevAngle = computeRotation;
                        this.initialAngle = computeRotation;
                    }
                }
            } else if (event.getPointerCount() >= 2 && (!this.isInProgress || this.isRotateDetected)) {
                this.currAngle = computeRotation(event);
                boolean z = false;
                this.focusX = (event.getX(1) + event.getX(0)) * 0.5f;
                this.focusY = (event.getY(1) + event.getY(0)) * 0.5f;
                tryStartRotation();
                if ((!this.isInProgress || detectRotation()) ? true : true) {
                    this.prevAngle = this.currAngle;
                }
            }
            return true;
        }
        cancelRotation();
        return true;
    }
}
