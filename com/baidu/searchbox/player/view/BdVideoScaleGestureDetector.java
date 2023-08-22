package com.baidu.searchbox.player.view;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.utils.BdGestureHelper;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0003*+,B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aH\u0016J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "isScaleDetected", "", "()Z", "setScaleDetected", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "setListener", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;)V", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector$delegate", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "computeScale", "", "detector", "getMaxScale", "getMinScale", "onScale", "onScaleBegin", "onScaleEnd", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setPivot", "newPivotX", "newPivotY", "setScale", "scale", "Companion", "OnScaleGestureListener", "SimpleOnScaleGestureListener", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BdVideoScaleGestureDetector extends ScaleGestureDetector.SimpleOnScaleGestureListener implements IKernelGestureDetector {
    public static final Companion Companion = new Companion(null);
    public static final float SCALE_MAX = 3.0f;
    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_NORMAL = 1.0f;
    public boolean isScaleDetected;
    public OnScaleGestureListener listener;
    public final Lazy scaleGestureDetector$delegate;

    /* renamed from: view  reason: collision with root package name */
    public final View f1068view;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "", "onScaleBegin", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "onScaleEnd", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnScaleGestureListener {
        void onScaleBegin(BdVideoScaleGestureDetector bdVideoScaleGestureDetector);

        void onScaleEnd(BdVideoScaleGestureDetector bdVideoScaleGestureDetector);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$SimpleOnScaleGestureListener;", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "()V", "onScaleBegin", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "onScaleEnd", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        @Override // com.baidu.searchbox.player.view.BdVideoScaleGestureDetector.OnScaleGestureListener
        public void onScaleBegin(BdVideoScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }

        @Override // com.baidu.searchbox.player.view.BdVideoScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(BdVideoScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }
    }

    public float getMaxScale() {
        return 3.0f;
    }

    public float getMinScale() {
        return 0.3f;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$Companion;", "", "()V", "SCALE_MAX", "", "SCALE_MIN", "SCALE_NORMAL", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public BdVideoScaleGestureDetector(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1068view = view2;
        this.scaleGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ScaleGestureDetector>() { // from class: com.baidu.searchbox.player.view.BdVideoScaleGestureDetector$scaleGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScaleGestureDetector invoke() {
                return new ScaleGestureDetector(BdVideoScaleGestureDetector.this.getView().getContext(), BdVideoScaleGestureDetector.this);
            }
        });
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "onScale");
        setScale(computeScale(detector));
        return true;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "onScaleBegin");
        this.isScaleDetected = true;
        setPivot(detector.getFocusX(), detector.getFocusY());
        OnScaleGestureListener onScaleGestureListener = this.listener;
        if (onScaleGestureListener != null) {
            onScaleGestureListener.onScaleBegin(this);
        }
        return true;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            this.isScaleDetected = false;
            OnScaleGestureListener onScaleGestureListener = this.listener;
            if (onScaleGestureListener != null) {
                onScaleGestureListener.onScaleEnd(this);
            }
        }
        if (!getScaleGestureDetector().onTouchEvent(event) && !this.isScaleDetected) {
            return false;
        }
        return true;
    }

    public final void setListener(OnScaleGestureListener onScaleGestureListener) {
        this.listener = onScaleGestureListener;
    }

    public final void setScale(float f) {
        this.f1068view.setScaleX(f);
        this.f1068view.setScaleY(f);
    }

    public final void setScaleDetected(boolean z) {
        this.isScaleDetected = z;
    }

    private final ScaleGestureDetector getScaleGestureDetector() {
        return (ScaleGestureDetector) this.scaleGestureDetector$delegate.getValue();
    }

    public final OnScaleGestureListener getListener() {
        return this.listener;
    }

    public final View getView() {
        return this.f1068view;
    }

    public final boolean isScaleDetected() {
        return this.isScaleDetected;
    }

    public float computeScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        float scaleFactor = detector.getScaleFactor();
        float scaleX = this.f1068view.getScaleX();
        if (scaleFactor < 1.0f && scaleX > getMinScale()) {
            float f = scaleX * scaleFactor;
            if (f < getMinScale()) {
                return getMinScale();
            }
            return f;
        } else if (scaleFactor > 1.0f && scaleX < getMaxScale()) {
            float f2 = scaleX * scaleFactor;
            if (f2 > getMaxScale()) {
                return getMaxScale();
            }
            return f2;
        } else {
            return scaleX;
        }
    }

    public void setPivot(float f, float f2) {
        View view2 = this.f1068view;
        float f3 = 1;
        BdGestureHelper.fixScaleTranslate(view2, view2.getTranslationX() + ((this.f1068view.getPivotX() - f) * (f3 - this.f1068view.getScaleX())), this.f1068view.getTranslationY() + ((this.f1068view.getPivotY() - f2) * (f3 - this.f1068view.getScaleY())));
        view2.setPivotX(f);
        view2.setPivotY(f2);
    }
}
