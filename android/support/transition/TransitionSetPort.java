package android.support.transition;

import android.animation.TimeInterpolator;
import android.support.annotation.RestrictTo;
import android.support.transition.TransitionPort;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TransitionSetPort extends TransitionPort {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    int mCurrentListeners;
    ArrayList<TransitionPort> mTransitions = new ArrayList<>();
    boolean mStarted = false;
    private boolean mPlayTogether = true;

    public int getOrdering() {
        return this.mPlayTogether ? 0 : 1;
    }

    public TransitionSetPort setOrdering(int i) {
        switch (i) {
            case 0:
                this.mPlayTogether = true;
                break;
            case 1:
                this.mPlayTogether = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public TransitionSetPort addTransition(TransitionPort transitionPort) {
        if (transitionPort != null) {
            this.mTransitions.add(transitionPort);
            transitionPort.mParent = this;
            if (this.mDuration >= 0) {
                transitionPort.setDuration(this.mDuration);
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0) {
            int size = this.mTransitions.size();
            for (int i = 0; i < size; i++) {
                this.mTransitions.get(i).setDuration(j);
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort setStartDelay(long j) {
        return (TransitionSetPort) super.setStartDelay(j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort setInterpolator(TimeInterpolator timeInterpolator) {
        return (TransitionSetPort) super.setInterpolator(timeInterpolator);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort addTarget(View view2) {
        return (TransitionSetPort) super.addTarget(view2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort addTarget(int i) {
        return (TransitionSetPort) super.addTarget(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort addListener(TransitionPort.TransitionListener transitionListener) {
        return (TransitionSetPort) super.addListener(transitionListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort removeTarget(int i) {
        return (TransitionSetPort) super.removeTarget(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort removeTarget(View view2) {
        return (TransitionSetPort) super.removeTarget(view2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort removeListener(TransitionPort.TransitionListener transitionListener) {
        return (TransitionSetPort) super.removeListener(transitionListener);
    }

    public TransitionSetPort removeTransition(TransitionPort transitionPort) {
        this.mTransitions.remove(transitionPort);
        transitionPort.mParent = null;
        return this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<TransitionPort> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // android.support.transition.TransitionPort
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        Iterator<TransitionPort> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2);
        }
    }

    @Override // android.support.transition.TransitionPort
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (!this.mPlayTogether) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.mTransitions.size()) {
                    break;
                }
                final TransitionPort transitionPort = this.mTransitions.get(i2);
                this.mTransitions.get(i2 - 1).addListener(new TransitionPort.TransitionListenerAdapter() { // from class: android.support.transition.TransitionSetPort.1
                    @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                    public void onTransitionEnd(TransitionPort transitionPort2) {
                        transitionPort.runAnimators();
                        transitionPort2.removeListener(this);
                    }
                });
                i = i2 + 1;
            }
            TransitionPort transitionPort2 = this.mTransitions.get(0);
            if (transitionPort2 != null) {
                transitionPort2.runAnimators();
                return;
            }
            return;
        }
        Iterator<TransitionPort> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // android.support.transition.TransitionPort
    public void captureStartValues(TransitionValues transitionValues) {
        int id = transitionValues.f2view.getId();
        if (isValidTarget(transitionValues.f2view, id)) {
            Iterator<TransitionPort> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                TransitionPort next = it.next();
                if (next.isValidTarget(transitionValues.f2view, id)) {
                    next.captureStartValues(transitionValues);
                }
            }
        }
    }

    @Override // android.support.transition.TransitionPort
    public void captureEndValues(TransitionValues transitionValues) {
        int id = transitionValues.f2view.getId();
        if (isValidTarget(transitionValues.f2view, id)) {
            Iterator<TransitionPort> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                TransitionPort next = it.next();
                if (next.isValidTarget(transitionValues.f2view, id)) {
                    next.captureEndValues(transitionValues);
                }
            }
        }
    }

    @Override // android.support.transition.TransitionPort
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void pause(View view2) {
        super.pause(view2);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).pause(view2);
        }
    }

    @Override // android.support.transition.TransitionPort
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void resume(View view2) {
        super.resume(view2);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).resume(view2);
        }
    }

    @Override // android.support.transition.TransitionPort
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    protected void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).cancel();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // android.support.transition.TransitionPort
    void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setCanRemoveViews(z);
        }
    }

    @Override // android.support.transition.TransitionPort
    String toString(String str) {
        String transitionPort = super.toString(str);
        int i = 0;
        while (i < this.mTransitions.size()) {
            String str2 = transitionPort + "\n" + this.mTransitions.get(i).toString(str + "  ");
            i++;
            transitionPort = str2;
        }
        return transitionPort;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionPort
    public TransitionSetPort clone() {
        TransitionSetPort transitionSetPort = (TransitionSetPort) super.m0clone();
        transitionSetPort.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionSetPort.addTransition(this.mTransitions.get(i).m0clone());
        }
        return transitionSetPort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TransitionSetListener extends TransitionPort.TransitionListenerAdapter {
        TransitionSetPort mTransitionSet;

        TransitionSetListener(TransitionSetPort transitionSetPort) {
            this.mTransitionSet = transitionSetPort;
        }

        @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
        public void onTransitionStart(TransitionPort transitionPort) {
            if (!this.mTransitionSet.mStarted) {
                this.mTransitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }

        @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
        public void onTransitionEnd(TransitionPort transitionPort) {
            TransitionSetPort transitionSetPort = this.mTransitionSet;
            transitionSetPort.mCurrentListeners--;
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transitionPort.removeListener(this);
        }
    }
}
