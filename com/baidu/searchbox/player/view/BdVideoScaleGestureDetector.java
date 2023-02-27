package com.baidu.searchbox.player.view;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.baidu.searchbox.crius.constants.NativeConstants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0003567B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b3\u00104J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001d\u0010-\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010/\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "android/view/ScaleGestureDetector$SimpleOnScaleGestureListener", "Landroid/view/ScaleGestureDetector;", "detector", "", "computeScale", "(Landroid/view/ScaleGestureDetector;)F", "getMaxScale", "()F", "getMinScale", "", "onScale", "(Landroid/view/ScaleGestureDetector;)Z", "onScaleBegin", "", "onScaleEnd", "(Landroid/view/ScaleGestureDetector;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "newPivotX", "newPivotY", "setPivot", "(FF)V", "scale", "setScale", "(F)V", "isScaleDetected", "Z", "()Z", "setScaleDetected", "(Z)V", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "setListener", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;)V", "scaleGestureDetector$delegate", "Lkotlin/Lazy;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Companion", "OnScaleGestureListener", "SimpleOnScaleGestureListener", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BdVideoScaleGestureDetector extends ScaleGestureDetector.SimpleOnScaleGestureListener implements IKernelGestureDetector {
    public static final Companion Companion = new Companion(null);
    public static final float SCALE_MAX = 3.0f;
    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_NORMAL = 1.0f;
    public boolean isScaleDetected;
    public OnScaleGestureListener listener;
    public final Lazy scaleGestureDetector$delegate;

    /* renamed from: view  reason: collision with root package name */
    public final View f1042view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "Lkotlin/Any;", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "detector", "", "onScaleBegin", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;)V", "onScaleEnd", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnScaleGestureListener {
        void onScaleBegin(BdVideoScaleGestureDetector bdVideoScaleGestureDetector);

        void onScaleEnd(BdVideoScaleGestureDetector bdVideoScaleGestureDetector);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$SimpleOnScaleGestureListener;", "com/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "detector", "", "onScaleBegin", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;)V", "onScaleEnd", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
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

    private final ScaleGestureDetector getScaleGestureDetector() {
        return (ScaleGestureDetector) this.scaleGestureDetector$delegate.getValue();
    }

    public float getMaxScale() {
        return 3.0f;
    }

    public float getMinScale() {
        return 0.3f;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$Companion;", "", "SCALE_MAX", "F", "SCALE_MIN", "SCALE_NORMAL", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BdVideoScaleGestureDetector(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1042view = view2;
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

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.isScaleDetected = false;
        OnScaleGestureListener onScaleGestureListener = this.listener;
        if (onScaleGestureListener != null) {
            onScaleGestureListener.onScaleEnd(this);
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return getScaleGestureDetector().onTouchEvent(event);
    }

    public final void setListener(OnScaleGestureListener onScaleGestureListener) {
        this.listener = onScaleGestureListener;
    }

    public final void setScale(float f) {
        this.f1042view.setScaleX(f);
        this.f1042view.setScaleY(f);
    }

    public final void setScaleDetected(boolean z) {
        this.isScaleDetected = z;
    }

    public float computeScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        float scaleFactor = detector.getScaleFactor();
        float scaleX = this.f1042view.getScaleX();
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

    public final OnScaleGestureListener getListener() {
        return this.listener;
    }

    public final View getView() {
        return this.f1042view;
    }

    public final boolean isScaleDetected() {
        return this.isScaleDetected;
    }

    public void setPivot(float f, float f2) {
        View view2 = this.f1042view;
        float f3 = 1;
        BdGestureHelper.fixScaleTranslate(view2, view2.getTranslationX() + ((this.f1042view.getPivotX() - f) * (f3 - this.f1042view.getScaleX())), this.f1042view.getTranslationY() + ((this.f1042view.getPivotY() - f2) * (f3 - this.f1042view.getScaleY())));
        view2.setPivotX(f);
        view2.setPivotY(f2);
    }
}
