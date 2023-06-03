package com.baidu.searchbox.player.view;

import android.view.MotionEvent;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;)V", "currAngle", "", "focusX", "focusY", "initialAngle", "isInProgress", "", "isRotateDetected", "()Z", "setRotateDetected", "(Z)V", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "prevAngle", "cancelRotation", "", "computeRotation", "event", "Landroid/view/MotionEvent;", "detectRotation", "getFocusX", "getFocusY", "getRotationDelta", "onTouchEvent", "tryStartRotation", "OnRotationGestureListener", "SimpleOnRotationGestureListener", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "", "onRotate", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "onRotationBegin", "onRotationEnd", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnRotationGestureListener {
        boolean onRotate(BdVideoRotateGestureDetector bdVideoRotateGestureDetector);

        boolean onRotationBegin(BdVideoRotateGestureDetector bdVideoRotateGestureDetector);

        void onRotationEnd(BdVideoRotateGestureDetector bdVideoRotateGestureDetector);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$OnRotationGestureListener;", "()V", "onRotate", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "onRotationBegin", "onRotationEnd", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
