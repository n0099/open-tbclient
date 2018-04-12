package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class Transition implements TransitionInterface {
    TransitionImpl mImpl;

    /* loaded from: classes2.dex */
    public interface TransitionListener extends TransitionInterfaceListener<Transition> {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    @Override // android.support.transition.TransitionInterface
    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    @Override // android.support.transition.TransitionInterface
    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    public Transition() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transition(boolean z) {
        if (!z) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.mImpl = new TransitionApi23();
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.mImpl = new TransitionKitKat();
            } else {
                this.mImpl = new TransitionIcs();
            }
            this.mImpl.init(this);
        }
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        this.mImpl.addListener(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view2) {
        this.mImpl.addTarget(view2);
        return this;
    }

    @NonNull
    public Transition addTarget(@IdRes int i) {
        this.mImpl.addTarget(i);
        return this;
    }

    @Override // android.support.transition.TransitionInterface
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view2, boolean z) {
        this.mImpl.excludeChildren(view2, z);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i, boolean z) {
        this.mImpl.excludeChildren(i, z);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class cls, boolean z) {
        this.mImpl.excludeChildren(cls, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view2, boolean z) {
        this.mImpl.excludeTarget(view2, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i, boolean z) {
        this.mImpl.excludeTarget(i, z);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class cls, boolean z) {
        this.mImpl.excludeTarget(cls, z);
        return this;
    }

    public long getDuration() {
        return this.mImpl.getDuration();
    }

    @NonNull
    public Transition setDuration(long j) {
        this.mImpl.setDuration(j);
        return this;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mImpl.setInterpolator(timeInterpolator);
        return this;
    }

    @NonNull
    public String getName() {
        return this.mImpl.getName();
    }

    public long getStartDelay() {
        return this.mImpl.getStartDelay();
    }

    @NonNull
    public Transition setStartDelay(long j) {
        this.mImpl.setStartDelay(j);
        return this;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mImpl.getTargetIds();
    }

    @NonNull
    public List<View> getTargets() {
        return this.mImpl.getTargets();
    }

    @Nullable
    public String[] getTransitionProperties() {
        return this.mImpl.getTransitionProperties();
    }

    @NonNull
    public TransitionValues getTransitionValues(@NonNull View view2, boolean z) {
        return this.mImpl.getTransitionValues(view2, z);
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        this.mImpl.removeListener(transitionListener);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view2) {
        this.mImpl.removeTarget(view2);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i) {
        this.mImpl.removeTarget(i);
        return this;
    }

    public String toString() {
        return this.mImpl.toString();
    }
}
