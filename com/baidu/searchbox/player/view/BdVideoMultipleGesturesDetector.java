package com.baidu.searchbox.player.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.utils.BdGestureHelper;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.view.BdVideoMoveGestureDetector;
import com.baidu.searchbox.player.view.BdVideoRotateGestureDetector;
import com.baidu.searchbox.player.view.BdVideoScaleGestureDetector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bF\u0010GJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001d\u0010%\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\tR$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001d\u0010/\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010\fR$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u00109\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010#\u001a\u0004\b8\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010:8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0019\u0010B\u001a\u00020A8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "", "flags", "", "clearFlags", "(I)V", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "generateMoveGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "generateRotateGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "generateScaleGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "Landroid/view/MotionEvent;", "event", "", "onAllowTouchEvent", "(Landroid/view/MotionEvent;)Z", "onGestureTouchEvent", "(Landroid/view/MotionEvent;)V", "onTouchEvent", "setFlags", "switchNormal", "()V", "switchNormalWithAnimation", "gestureFlags", "I", "isMoveDetected", "Z", "isRotateDetected", "isScaleDetected", "moveGestureDetector$delegate", "Lkotlin/Lazy;", "getMoveGestureDetector", "moveGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "moveGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "getMoveGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "setMoveGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;)V", "rotateGestureDetector$delegate", "getRotateGestureDetector", "rotateGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "rotateGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "getRotateGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "setRotateGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;)V", "scaleGestureDetector$delegate", "getScaleGestureDetector", "scaleGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "scaleGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "getScaleGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "setScaleGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;)V", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "RotateGestureDetectorListener", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BdVideoMultipleGesturesDetector implements IKernelGestureDetector {
    public int gestureFlags;
    public boolean isMoveDetected;
    public boolean isRotateDetected;
    public boolean isScaleDetected;
    public final Lazy moveGestureDetector$delegate;
    public BdVideoMoveGestureDetector.SimpleOnMoveGestureListener moveGestureListener;
    public final Lazy rotateGestureDetector$delegate;
    public BdVideoRotateGestureDetector.SimpleOnRotationGestureListener rotateGestureListener;
    public final Lazy scaleGestureDetector$delegate;
    public BdVideoScaleGestureDetector.OnScaleGestureListener scaleGestureListener;

    /* renamed from: view  reason: collision with root package name */
    public final View f1040view;

    private final BdVideoMoveGestureDetector getMoveGestureDetector() {
        return (BdVideoMoveGestureDetector) this.moveGestureDetector$delegate.getValue();
    }

    private final BdVideoRotateGestureDetector getRotateGestureDetector() {
        return (BdVideoRotateGestureDetector) this.rotateGestureDetector$delegate.getValue();
    }

    private final BdVideoScaleGestureDetector getScaleGestureDetector() {
        return (BdVideoScaleGestureDetector) this.scaleGestureDetector$delegate.getValue();
    }

    public boolean onAllowTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    public void onGestureTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector$RotateGestureDetectorListener;", "com/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "detector", "", "onRotate", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)Z", "", "onRotationEnd", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)V", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;Landroid/view/View;)V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public class RotateGestureDetectorListener extends BdVideoRotateGestureDetector.SimpleOnRotationGestureListener {
        public final /* synthetic */ BdVideoMultipleGesturesDetector this$0;

        /* renamed from: view  reason: collision with root package name */
        public final View f1041view;

        public RotateGestureDetectorListener(BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector, View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.this$0 = bdVideoMultipleGesturesDetector;
            this.f1041view = view2;
        }

        public final View getView() {
            return this.f1041view;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.SimpleOnRotationGestureListener, com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public boolean onRotate(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            float rotation = this.f1041view.getRotation() + detector.getRotationDelta();
            if (rotation >= 360.0f) {
                rotation -= 360.0f;
            } else if (rotation < 0) {
                rotation += 360.0f;
            }
            View view2 = this.f1041view;
            view2.setPivotX(view2.getWidth() * 0.5f);
            View view3 = this.f1041view;
            view3.setPivotY(view3.getHeight() * 0.5f);
            this.f1041view.setRotation(rotation);
            return true;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.SimpleOnRotationGestureListener, com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public void onRotationEnd(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            int abs = (int) (Math.abs(this.f1041view.getRotation() + 45) / 90);
            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "当前对应的旋转值: " + abs + ", 旋转的角度=" + this.f1041view.getRotation());
            View view2 = this.f1041view;
            ObjectAnimator.ofFloat(view2, View.ROTATION, view2.getRotation(), (float) (abs * 90)).setDuration(300L).start();
        }
    }

    public BdVideoMultipleGesturesDetector(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1040view = view2;
        this.gestureFlags = 7;
        this.scaleGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BdVideoScaleGestureDetector>() { // from class: com.baidu.searchbox.player.view.BdVideoMultipleGesturesDetector$scaleGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BdVideoScaleGestureDetector invoke() {
                return BdVideoMultipleGesturesDetector.this.generateScaleGestureDetector();
            }
        });
        this.moveGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BdVideoMoveGestureDetector>() { // from class: com.baidu.searchbox.player.view.BdVideoMultipleGesturesDetector$moveGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BdVideoMoveGestureDetector invoke() {
                return BdVideoMultipleGesturesDetector.this.generateMoveGestureDetector();
            }
        });
        this.rotateGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new Function0<BdVideoRotateGestureDetector>() { // from class: com.baidu.searchbox.player.view.BdVideoMultipleGesturesDetector$rotateGestureDetector$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BdVideoRotateGestureDetector invoke() {
                return BdVideoMultipleGesturesDetector.this.generateRotateGestureDetector();
            }
        });
    }

    public final void clearFlags(int i) {
        this.gestureFlags = (~i) & this.gestureFlags;
    }

    public final void setFlags(int i) {
        this.gestureFlags = i;
    }

    public void setMoveGestureListener(BdVideoMoveGestureDetector.SimpleOnMoveGestureListener simpleOnMoveGestureListener) {
        this.moveGestureListener = simpleOnMoveGestureListener;
    }

    public void setRotateGestureListener(BdVideoRotateGestureDetector.SimpleOnRotationGestureListener simpleOnRotationGestureListener) {
        this.rotateGestureListener = simpleOnRotationGestureListener;
    }

    public void setScaleGestureListener(BdVideoScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        this.scaleGestureListener = onScaleGestureListener;
    }

    public BdVideoMoveGestureDetector generateMoveGestureDetector() {
        return new BdVideoMoveGestureDetector(this.f1040view, getMoveGestureListener());
    }

    public BdVideoRotateGestureDetector generateRotateGestureDetector() {
        if (getRotateGestureListener() == null) {
            setRotateGestureListener(new RotateGestureDetectorListener(this, this.f1040view));
        }
        BdVideoRotateGestureDetector.SimpleOnRotationGestureListener rotateGestureListener = getRotateGestureListener();
        Intrinsics.checkNotNull(rotateGestureListener);
        return new BdVideoRotateGestureDetector(rotateGestureListener);
    }

    public BdVideoScaleGestureDetector generateScaleGestureDetector() {
        BdVideoScaleGestureDetector bdVideoScaleGestureDetector = new BdVideoScaleGestureDetector(this.f1040view);
        bdVideoScaleGestureDetector.setListener(getScaleGestureListener());
        return bdVideoScaleGestureDetector;
    }

    public BdVideoMoveGestureDetector.SimpleOnMoveGestureListener getMoveGestureListener() {
        return this.moveGestureListener;
    }

    public BdVideoRotateGestureDetector.SimpleOnRotationGestureListener getRotateGestureListener() {
        return this.rotateGestureListener;
    }

    public BdVideoScaleGestureDetector.OnScaleGestureListener getScaleGestureListener() {
        return this.scaleGestureListener;
    }

    public final View getView() {
        return this.f1040view;
    }

    public void switchNormal() {
        View view2 = this.f1040view;
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
        view2.setRotation(0.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!onAllowTouchEvent(event) || event.getPointerCount() < 2) {
            return false;
        }
        this.f1040view.getParent().requestDisallowInterceptTouchEvent(true);
        if ((this.gestureFlags & 4) == 4) {
            getRotateGestureDetector().onTouchEvent(event);
            this.isRotateDetected = getRotateGestureDetector().isRotateDetected();
        }
        if ((this.gestureFlags & 1) == 1) {
            getScaleGestureDetector().onTouchEvent(event);
            this.isScaleDetected = getScaleGestureDetector().isScaleDetected();
        }
        if ((this.gestureFlags & 2) == 2) {
            getMoveGestureDetector().onTouchEvent(event);
            this.isMoveDetected = getMoveGestureDetector().isMoveDetected();
        }
        onGestureTouchEvent(event);
        if (!this.isRotateDetected && !this.isScaleDetected && !this.isMoveDetected) {
            return false;
        }
        return true;
    }

    public void switchNormalWithAnimation() {
        float f;
        AnimatorSet animatorSet = new AnimatorSet();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, this.f1040view.getScaleX(), 1.0f);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, this.f1040view.getScaleY(), 1.0f);
        if (this.f1040view.getRotation() >= 180) {
            f = 360.0f;
        } else {
            f = 0.0f;
        }
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f1040view, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat(View.ROTATION, this.f1040view.getRotation(), f), PropertyValuesHolder.ofFloat(View.TRANSLATION_X, this.f1040view.getTranslationX(), 0.0f), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, this.f1040view.getTranslationY(), 0.0f)).setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofPropert…ation(ANIMATION_DURATION)");
        animatorSet.play(duration);
        animatorSet.start();
    }
}
