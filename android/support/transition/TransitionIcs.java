package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.transition.TransitionPort;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
class TransitionIcs extends TransitionImpl {
    private CompatListener mCompatListener;
    TransitionInterface mExternalTransition;
    TransitionPort mTransition;

    @Override // android.support.transition.TransitionImpl
    public void init(TransitionInterface transitionInterface, Object obj) {
        this.mExternalTransition = transitionInterface;
        if (obj == null) {
            this.mTransition = new TransitionWrapper(transitionInterface);
        } else {
            this.mTransition = (TransitionPort) obj;
        }
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl addListener(TransitionInterfaceListener transitionInterfaceListener) {
        if (this.mCompatListener == null) {
            this.mCompatListener = new CompatListener();
            this.mTransition.addListener(this.mCompatListener);
        }
        this.mCompatListener.addListener(transitionInterfaceListener);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl removeListener(TransitionInterfaceListener transitionInterfaceListener) {
        if (this.mCompatListener != null) {
            this.mCompatListener.removeListener(transitionInterfaceListener);
            if (this.mCompatListener.isEmpty()) {
                this.mTransition.removeListener(this.mCompatListener);
                this.mCompatListener = null;
            }
        }
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl addTarget(View view2) {
        this.mTransition.addTarget(view2);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl addTarget(int i) {
        this.mTransition.addTarget(i);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public void captureEndValues(TransitionValues transitionValues) {
        this.mTransition.captureEndValues(transitionValues);
    }

    @Override // android.support.transition.TransitionImpl
    public void captureStartValues(TransitionValues transitionValues) {
        this.mTransition.captureStartValues(transitionValues);
    }

    @Override // android.support.transition.TransitionImpl
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return this.mTransition.createAnimator(viewGroup, transitionValues, transitionValues2);
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl excludeChildren(View view2, boolean z) {
        this.mTransition.excludeChildren(view2, z);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl excludeChildren(int i, boolean z) {
        this.mTransition.excludeChildren(i, z);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl excludeChildren(Class cls, boolean z) {
        this.mTransition.excludeChildren(cls, z);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl excludeTarget(View view2, boolean z) {
        this.mTransition.excludeTarget(view2, z);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl excludeTarget(int i, boolean z) {
        this.mTransition.excludeTarget(i, z);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl excludeTarget(Class cls, boolean z) {
        this.mTransition.excludeTarget(cls, z);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public long getDuration() {
        return this.mTransition.getDuration();
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl setDuration(long j) {
        this.mTransition.setDuration(j);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TimeInterpolator getInterpolator() {
        return this.mTransition.getInterpolator();
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl setInterpolator(TimeInterpolator timeInterpolator) {
        this.mTransition.setInterpolator(timeInterpolator);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public String getName() {
        return this.mTransition.getName();
    }

    @Override // android.support.transition.TransitionImpl
    public long getStartDelay() {
        return this.mTransition.getStartDelay();
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl setStartDelay(long j) {
        this.mTransition.setStartDelay(j);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public List<Integer> getTargetIds() {
        return this.mTransition.getTargetIds();
    }

    @Override // android.support.transition.TransitionImpl
    public List<View> getTargets() {
        return this.mTransition.getTargets();
    }

    @Override // android.support.transition.TransitionImpl
    public String[] getTransitionProperties() {
        return this.mTransition.getTransitionProperties();
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionValues getTransitionValues(View view2, boolean z) {
        return this.mTransition.getTransitionValues(view2, z);
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl removeTarget(View view2) {
        this.mTransition.removeTarget(view2);
        return this;
    }

    @Override // android.support.transition.TransitionImpl
    public TransitionImpl removeTarget(int i) {
        this.mTransition.removeTarget(i);
        return this;
    }

    public String toString() {
        return this.mTransition.toString();
    }

    /* loaded from: classes2.dex */
    private static class TransitionWrapper extends TransitionPort {
        private TransitionInterface mTransition;

        public TransitionWrapper(TransitionInterface transitionInterface) {
            this.mTransition = transitionInterface;
        }

        @Override // android.support.transition.TransitionPort
        public void captureStartValues(TransitionValues transitionValues) {
            this.mTransition.captureStartValues(transitionValues);
        }

        @Override // android.support.transition.TransitionPort
        public void captureEndValues(TransitionValues transitionValues) {
            this.mTransition.captureEndValues(transitionValues);
        }

        @Override // android.support.transition.TransitionPort
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.mTransition.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
    }

    /* loaded from: classes2.dex */
    private class CompatListener implements TransitionPort.TransitionListener {
        private final ArrayList<TransitionInterfaceListener> mListeners = new ArrayList<>();

        CompatListener() {
        }

        public void addListener(TransitionInterfaceListener transitionInterfaceListener) {
            this.mListeners.add(transitionInterfaceListener);
        }

        public void removeListener(TransitionInterfaceListener transitionInterfaceListener) {
            this.mListeners.remove(transitionInterfaceListener);
        }

        public boolean isEmpty() {
            return this.mListeners.isEmpty();
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionStart(TransitionPort transitionPort) {
            Iterator<TransitionInterfaceListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStart(TransitionIcs.this.mExternalTransition);
            }
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionEnd(TransitionPort transitionPort) {
            Iterator<TransitionInterfaceListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onTransitionEnd(TransitionIcs.this.mExternalTransition);
            }
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionCancel(TransitionPort transitionPort) {
            Iterator<TransitionInterfaceListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onTransitionCancel(TransitionIcs.this.mExternalTransition);
            }
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionPause(TransitionPort transitionPort) {
            Iterator<TransitionInterfaceListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onTransitionPause(TransitionIcs.this.mExternalTransition);
            }
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionResume(TransitionPort transitionPort) {
            Iterator<TransitionInterfaceListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onTransitionResume(TransitionIcs.this.mExternalTransition);
            }
        }
    }
}
