package com.baidu.searchbox.player.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.MotionEvent;
import android.view.View;
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
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0006J\b\u00104\u001a\u00020\u000eH\u0016J\b\u00105\u001a\u00020\u001aH\u0016J\b\u00106\u001a\u00020%H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u00108\u001a\u000209H\u0016J\u000e\u0010<\u001a\u0002022\u0006\u00103\u001a\u00020\u0006J\b\u0010=\u001a\u000202H\u0016J\b\u0010>\u001a\u000202H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006@"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "gestureFlags", "", "hasHandleDetected", "", "getHasHandleDetected", "()Z", "setHasHandleDetected", "(Z)V", "moveGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "getMoveGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "moveGestureDetector$delegate", "Lkotlin/Lazy;", "moveGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "getMoveGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "setMoveGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;)V", "rotateGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "getRotateGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "rotateGestureDetector$delegate", "rotateGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "getRotateGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "setRotateGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;)V", "scaleGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "getScaleGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "scaleGestureDetector$delegate", "scaleGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "getScaleGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "setScaleGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;)V", "getView", "()Landroid/view/View;", "clearFlags", "", "flags", "generateMoveGestureDetector", "generateRotateGestureDetector", "generateScaleGestureDetector", "onAllowTouchEvent", "event", "Landroid/view/MotionEvent;", "onGestureTouchEvent", "onTouchEvent", "setFlags", "switchNormal", "switchNormalWithAnimation", "RotateGestureDetectorListener", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BdVideoMultipleGesturesDetector implements IKernelGestureDetector {
    public int gestureFlags;
    public boolean hasHandleDetected;
    public final Lazy moveGestureDetector$delegate;
    public BdVideoMoveGestureDetector.SimpleOnMoveGestureListener moveGestureListener;
    public final Lazy rotateGestureDetector$delegate;
    public BdVideoRotateGestureDetector.SimpleOnRotationGestureListener rotateGestureListener;
    public final Lazy scaleGestureDetector$delegate;
    public BdVideoScaleGestureDetector.OnScaleGestureListener scaleGestureListener;

    /* renamed from: view  reason: collision with root package name */
    public final View f1064view;

    public boolean onAllowTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    public void onGestureTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector$RotateGestureDetectorListener;", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "view", "Landroid/view/View;", "(Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;Landroid/view/View;)V", "getView", "()Landroid/view/View;", "onRotate", "", "detector", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "onRotationEnd", "", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public class RotateGestureDetectorListener extends BdVideoRotateGestureDetector.SimpleOnRotationGestureListener {
        public final /* synthetic */ BdVideoMultipleGesturesDetector this$0;

        /* renamed from: view  reason: collision with root package name */
        public final View f1065view;

        public RotateGestureDetectorListener(BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector, View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.this$0 = bdVideoMultipleGesturesDetector;
            this.f1065view = view2;
        }

        public final View getView() {
            return this.f1065view;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.SimpleOnRotationGestureListener, com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public boolean onRotate(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            float rotation = this.f1065view.getRotation() + detector.getRotationDelta();
            if (rotation >= 360.0f) {
                rotation -= 360.0f;
            } else if (rotation < 0.0f) {
                rotation += 360.0f;
            }
            View view2 = this.f1065view;
            view2.setPivotX(view2.getWidth() * 0.5f);
            View view3 = this.f1065view;
            view3.setPivotY(view3.getHeight() * 0.5f);
            this.f1065view.setRotation(rotation);
            return true;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.SimpleOnRotationGestureListener, com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public void onRotationEnd(BdVideoRotateGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            int abs = (int) (Math.abs(this.f1065view.getRotation() + 45) / 90);
            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "当前对应的旋转值: " + abs + ", 旋转的角度=" + this.f1065view.getRotation());
            View view2 = this.f1065view;
            ObjectAnimator.ofFloat(view2, View.ROTATION, view2.getRotation(), (float) (abs * 90)).setDuration(240L).start();
        }
    }

    public BdVideoMultipleGesturesDetector(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1064view = view2;
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

    public final void setHasHandleDetected(boolean z) {
        this.hasHandleDetected = z;
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

    private final BdVideoMoveGestureDetector getMoveGestureDetector() {
        return (BdVideoMoveGestureDetector) this.moveGestureDetector$delegate.getValue();
    }

    private final BdVideoRotateGestureDetector getRotateGestureDetector() {
        return (BdVideoRotateGestureDetector) this.rotateGestureDetector$delegate.getValue();
    }

    private final BdVideoScaleGestureDetector getScaleGestureDetector() {
        return (BdVideoScaleGestureDetector) this.scaleGestureDetector$delegate.getValue();
    }

    public BdVideoMoveGestureDetector generateMoveGestureDetector() {
        return new BdVideoMoveGestureDetector(this.f1064view, getMoveGestureListener());
    }

    public BdVideoRotateGestureDetector generateRotateGestureDetector() {
        if (getRotateGestureListener() == null) {
            setRotateGestureListener(new RotateGestureDetectorListener(this, this.f1064view));
        }
        BdVideoRotateGestureDetector.SimpleOnRotationGestureListener rotateGestureListener = getRotateGestureListener();
        Intrinsics.checkNotNull(rotateGestureListener);
        return new BdVideoRotateGestureDetector(rotateGestureListener);
    }

    public BdVideoScaleGestureDetector generateScaleGestureDetector() {
        BdVideoScaleGestureDetector bdVideoScaleGestureDetector = new BdVideoScaleGestureDetector(this.f1064view);
        bdVideoScaleGestureDetector.setListener(getScaleGestureListener());
        return bdVideoScaleGestureDetector;
    }

    public final boolean getHasHandleDetected() {
        return this.hasHandleDetected;
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
        return this.f1064view;
    }

    public void switchNormal() {
        View view2 = this.f1064view;
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
        view2.setRotation(0.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((!onAllowTouchEvent(event) || event.getPointerCount() < 2) && !this.hasHandleDetected) {
            return false;
        }
        this.f1064view.getParent().requestDisallowInterceptTouchEvent(true);
        if ((this.gestureFlags & 4) == 4) {
            getRotateGestureDetector().onTouchEvent(event);
            if (getRotateGestureDetector().isRotateDetected()) {
                this.hasHandleDetected = true;
            }
        }
        if ((this.gestureFlags & 1) == 1) {
            getScaleGestureDetector().onTouchEvent(event);
            if (getScaleGestureDetector().isScaleDetected()) {
                this.hasHandleDetected = true;
            }
        }
        if ((this.gestureFlags & 2) == 2) {
            getMoveGestureDetector().onTouchEvent(event);
            if (getMoveGestureDetector().isMoveDetected()) {
                this.hasHandleDetected = true;
            }
        }
        onGestureTouchEvent(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            this.hasHandleDetected = false;
        }
        return this.hasHandleDetected;
    }

    public void switchNormalWithAnimation() {
        float f;
        AnimatorSet animatorSet = new AnimatorSet();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.SCALE_X, this.f1064view.getScaleX(), 1.0f);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.SCALE_Y, this.f1064view.getScaleY(), 1.0f);
        if (this.f1064view.getRotation() >= 180.0f) {
            f = 360.0f;
        } else {
            f = 0.0f;
        }
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f1064view, ofFloat, ofFloat2, PropertyValuesHolder.ofFloat(View.ROTATION, this.f1064view.getRotation(), f), PropertyValuesHolder.ofFloat(View.TRANSLATION_X, this.f1064view.getTranslationX(), 0.0f), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, this.f1064view.getTranslationY(), 0.0f)).setDuration(240L);
        Intrinsics.checkNotNullExpressionValue(duration, "ofPropertyValuesHolder(v…ation(ANIMATION_DURATION)");
        animatorSet.play(duration);
        animatorSet.start();
    }
}
