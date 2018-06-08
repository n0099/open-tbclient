package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.transition.Transition;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mCurrentListeners;
    private boolean mPlayTogether;
    private boolean mStarted;
    private ArrayList<Transition> mTransitions;

    static /* synthetic */ int access$106(TransitionSet transitionSet) {
        int i = transitionSet.mCurrentListeners - 1;
        transitionSet.mCurrentListeners = i;
        return i;
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @NonNull
    public TransitionSet setOrdering(int i) {
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

    public int getOrdering() {
        return this.mPlayTogether ? 0 : 1;
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
        if (this.mDuration >= 0) {
            transition.setDuration(this.mDuration);
        }
        return this;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    public Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j) {
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
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).addTarget(view);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.addTarget(view);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mTransitions.size()) {
                this.mTransitions.get(i3).addTarget(i);
                i2 = i3 + 1;
            } else {
                return (TransitionSet) super.addTarget(i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).addTarget(str);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.addTarget(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).addTarget(cls);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.addTarget(cls);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mTransitions.size()) {
                this.mTransitions.get(i3).removeTarget(i);
                i2 = i3 + 1;
            } else {
                return (TransitionSet) super.removeTarget(i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).removeTarget(view);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.removeTarget(view);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class cls) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).removeTarget(cls);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.removeTarget(cls);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).removeTarget(str);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.removeTarget(str);
            }
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).excludeTarget(view, z);
                i = i2 + 1;
            } else {
                return super.excludeTarget(view, z);
            }
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).excludeTarget(str, z);
                i = i2 + 1;
            } else {
                return super.excludeTarget(str, z);
            }
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(int i, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mTransitions.size()) {
                this.mTransitions.get(i3).excludeTarget(i, z);
                i2 = i3 + 1;
            } else {
                return super.excludeTarget(i, z);
            }
        }
    }

    @Override // android.support.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class cls, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).excludeTarget(cls, z);
                i = i2 + 1;
            } else {
                return super.excludeTarget(cls, z);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // android.support.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mTransitions.size()) {
                this.mTransitions.get(i2).setPathMotion(pathMotion);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            if (!this.mTransitionSet.mStarted) {
                this.mTransitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet.access$106(this.mTransitionSet);
            if (this.mTransitionSet.mCurrentListeners == 0) {
                this.mTransitionSet.mStarted = false;
                this.mTransitionSet.end();
            }
            transition.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.mTransitions.get(i);
            if (startDelay > 0 && (this.mPlayTogether || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void runAnimators() {
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
                final Transition transition = this.mTransitions.get(i2);
                this.mTransitions.get(i2 - 1).addListener(new TransitionListenerAdapter() { // from class: android.support.transition.TransitionSet.1
                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    public void onTransitionEnd(@NonNull Transition transition2) {
                        transition.runAnimators();
                        transition2.removeListener(this);
                    }
                });
                i = i2 + 1;
            }
            Transition transition2 = this.mTransitions.get(0);
            if (transition2 != null) {
                transition2.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // android.support.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).capturePropagationValues(transitionValues);
        }
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).pause(view);
        }
    }

    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).resume(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).forceToEnd(viewGroup);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setCanRemoveViews(z);
        }
    }

    @Override // android.support.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            this.mTransitions.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        int i = 0;
        while (i < this.mTransitions.size()) {
            String str2 = transition + "\n" + this.mTransitions.get(i).toString(str + "  ");
            i++;
            transition = str2;
        }
        return transition;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.Transition
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.m0clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            transitionSet.addTransition(this.mTransitions.get(i).m0clone());
        }
        return transitionSet;
    }
}
