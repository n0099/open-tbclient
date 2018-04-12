package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.support.annotation.RestrictTo;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class TransitionPort implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    long mStartDelay = -1;
    long mDuration = -1;
    TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<View> mTargetExcludes = null;
    ArrayList<Class> mTargetTypeExcludes = null;
    ArrayList<Integer> mTargetIdChildExcludes = null;
    ArrayList<View> mTargetChildExcludes = null;
    ArrayList<Class> mTargetTypeChildExcludes = null;
    TransitionSetPort mParent = null;
    ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    int mNumInstances = 0;
    boolean mPaused = false;
    ArrayList<TransitionListener> mListeners = null;
    ArrayList<Animator> mAnimators = new ArrayList<>();
    private String mName = getClass().getName();
    private TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    private TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private boolean mEnded = false;

    /* loaded from: classes2.dex */
    public interface TransitionListener {
        void onTransitionCancel(TransitionPort transitionPort);

        void onTransitionEnd(TransitionPort transitionPort);

        void onTransitionPause(TransitionPort transitionPort);

        void onTransitionResume(TransitionPort transitionPort);

        void onTransitionStart(TransitionPort transitionPort);
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public abstract void captureStartValues(TransitionValues transitionValues);

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
            sRunningAnimators.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public TransitionPort setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public TransitionPort setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionPort setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        Animator createAnimator;
        View view2;
        TransitionValues transitionValues;
        Animator animator;
        TransitionValues transitionValues2;
        ArrayMap arrayMap = new ArrayMap(transitionValuesMaps2.viewValues);
        SparseArray sparseArray = new SparseArray(transitionValuesMaps2.idValues.size());
        for (int i = 0; i < transitionValuesMaps2.idValues.size(); i++) {
            sparseArray.put(transitionValuesMaps2.idValues.keyAt(i), transitionValuesMaps2.idValues.valueAt(i));
        }
        LongSparseArray longSparseArray = new LongSparseArray(transitionValuesMaps2.itemIdValues.size());
        for (int i2 = 0; i2 < transitionValuesMaps2.itemIdValues.size(); i2++) {
            longSparseArray.put(transitionValuesMaps2.itemIdValues.keyAt(i2), transitionValuesMaps2.itemIdValues.valueAt(i2));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (View view3 : transitionValuesMaps.viewValues.keySet()) {
            boolean z = false;
            if (view3.getParent() instanceof ListView) {
                z = true;
            }
            if (!z) {
                int id = view3.getId();
                TransitionValues transitionValues3 = transitionValuesMaps.viewValues.get(view3) != null ? transitionValuesMaps.viewValues.get(view3) : transitionValuesMaps.idValues.get(id);
                if (transitionValuesMaps2.viewValues.get(view3) != null) {
                    transitionValues2 = transitionValuesMaps2.viewValues.get(view3);
                    arrayMap.remove(view3);
                } else if (id == -1) {
                    transitionValues2 = null;
                } else {
                    transitionValues2 = transitionValuesMaps2.idValues.get(id);
                    View view4 = null;
                    for (View view5 : arrayMap.keySet()) {
                        if (view5.getId() != id) {
                            view5 = view4;
                        }
                        view4 = view5;
                    }
                    if (view4 != null) {
                        arrayMap.remove(view4);
                    }
                }
                sparseArray.remove(id);
                if (isValidTarget(view3, id)) {
                    arrayList.add(transitionValues3);
                    arrayList2.add(transitionValues2);
                }
            } else {
                ListView listView = (ListView) view3.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view3));
                    longSparseArray.remove(itemIdAtPosition);
                    arrayList.add(transitionValuesMaps.itemIdValues.get(itemIdAtPosition));
                    arrayList2.add(null);
                }
            }
        }
        int size = transitionValuesMaps.itemIdValues.size();
        for (int i3 = 0; i3 < size; i3++) {
            long keyAt = transitionValuesMaps.itemIdValues.keyAt(i3);
            if (isValidTarget(null, keyAt)) {
                longSparseArray.remove(keyAt);
                arrayList.add(transitionValuesMaps.itemIdValues.get(keyAt));
                arrayList2.add(transitionValuesMaps2.itemIdValues.get(keyAt));
            }
        }
        for (View view6 : arrayMap.keySet()) {
            int id2 = view6.getId();
            if (isValidTarget(view6, id2)) {
                TransitionValues transitionValues4 = transitionValuesMaps.viewValues.get(view6) != null ? transitionValuesMaps.viewValues.get(view6) : transitionValuesMaps.idValues.get(id2);
                sparseArray.remove(id2);
                arrayList.add(transitionValues4);
                arrayList2.add((TransitionValues) arrayMap.get(view6));
            }
        }
        int size2 = sparseArray.size();
        for (int i4 = 0; i4 < size2; i4++) {
            int keyAt2 = sparseArray.keyAt(i4);
            if (isValidTarget(null, keyAt2)) {
                arrayList.add(transitionValuesMaps.idValues.get(keyAt2));
                arrayList2.add((TransitionValues) sparseArray.get(keyAt2));
            }
        }
        int size3 = longSparseArray.size();
        for (int i5 = 0; i5 < size3; i5++) {
            long keyAt3 = longSparseArray.keyAt(i5);
            arrayList.add(transitionValuesMaps.itemIdValues.get(keyAt3));
            arrayList2.add((TransitionValues) longSparseArray.get(keyAt3));
        }
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 < arrayList.size()) {
                TransitionValues transitionValues5 = (TransitionValues) arrayList.get(i7);
                TransitionValues transitionValues6 = (TransitionValues) arrayList2.get(i7);
                if ((transitionValues5 != null || transitionValues6 != null) && ((transitionValues5 == null || !transitionValues5.equals(transitionValues6)) && (createAnimator = createAnimator(viewGroup, transitionValues5, transitionValues6)) != null)) {
                    if (transitionValues6 != null) {
                        View view7 = transitionValues6.f2view;
                        String[] transitionProperties = getTransitionProperties();
                        if (view7 == null || transitionProperties == null || transitionProperties.length <= 0) {
                            transitionValues = null;
                            animator = createAnimator;
                        } else {
                            TransitionValues transitionValues7 = new TransitionValues();
                            transitionValues7.f2view = view7;
                            TransitionValues transitionValues8 = transitionValuesMaps2.viewValues.get(view7);
                            if (transitionValues8 != null) {
                                for (int i8 = 0; i8 < transitionProperties.length; i8++) {
                                    transitionValues7.values.put(transitionProperties[i8], transitionValues8.values.get(transitionProperties[i8]));
                                }
                            }
                            int size4 = runningAnimators.size();
                            int i9 = 0;
                            while (true) {
                                if (i9 >= size4) {
                                    transitionValues = transitionValues7;
                                    animator = createAnimator;
                                    break;
                                }
                                AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i9));
                                if (animationInfo.values == null || animationInfo.f1view != view7 || (((animationInfo.name != null || getName() != null) && !animationInfo.name.equals(getName())) || !animationInfo.values.equals(transitionValues7))) {
                                    i9++;
                                } else {
                                    animator = null;
                                    transitionValues = transitionValues7;
                                    break;
                                }
                            }
                        }
                        createAnimator = animator;
                        view2 = view7;
                    } else {
                        view2 = transitionValues5.f2view;
                        transitionValues = null;
                    }
                    if (createAnimator != null) {
                        runningAnimators.put(createAnimator, new AnimationInfo(view2, getName(), WindowIdPort.getWindowId(viewGroup), transitionValues));
                        this.mAnimators.add(createAnimator);
                    }
                }
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view2, long j) {
        if (this.mTargetIdExcludes == null || !this.mTargetIdExcludes.contains(Integer.valueOf((int) j))) {
            if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view2)) {
                if (this.mTargetTypeExcludes != null && view2 != null) {
                    int size = this.mTargetTypeExcludes.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view2)) {
                            return false;
                        }
                    }
                }
                if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
                    return true;
                }
                if (this.mTargetIds.size() > 0) {
                    for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                        if (this.mTargetIds.get(i2).intValue() == j) {
                            return true;
                        }
                    }
                }
                if (view2 == null || this.mTargets.size() <= 0) {
                    return false;
                }
                for (int i3 = 0; i3 < this.mTargets.size(); i3++) {
                    if (this.mTargets.get(i3) == view2) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void runAnimators() {
        start();
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.TransitionPort.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    TransitionPort.this.mCurrentAnimators.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    TransitionPort.this.mCurrentAnimators.remove(animator2);
                }
            });
            animate(animator);
        }
    }

    public TransitionPort addTarget(int i) {
        if (i > 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort removeTarget(int i) {
        if (i > 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public TransitionPort excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public TransitionPort excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            if (z) {
                return ArrayListManager.add(arrayList, Integer.valueOf(i));
            }
            return ArrayListManager.remove(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    public TransitionPort excludeTarget(View view2, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view2, z);
        return this;
    }

    public TransitionPort excludeChildren(View view2, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view2, z);
        return this;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view2, boolean z) {
        if (view2 != null) {
            if (z) {
                return ArrayListManager.add(arrayList, view2);
            }
            return ArrayListManager.remove(arrayList, view2);
        }
        return arrayList;
    }

    public TransitionPort excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public TransitionPort excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        if (cls != null) {
            if (z) {
                return ArrayListManager.add(arrayList, cls);
            }
            return ArrayListManager.remove(arrayList, cls);
        }
        return arrayList;
    }

    public TransitionPort addTarget(View view2) {
        this.mTargets.add(view2);
        return this;
    }

    public TransitionPort removeTarget(View view2) {
        if (view2 != null) {
            this.mTargets.remove(view2);
        }
        return this;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            if (this.mTargetIds.size() > 0) {
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    int intValue = this.mTargetIds.get(i).intValue();
                    View findViewById = viewGroup.findViewById(intValue);
                    if (findViewById != null) {
                        TransitionValues transitionValues = new TransitionValues();
                        transitionValues.f2view = findViewById;
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        if (z) {
                            this.mStartValues.viewValues.put(findViewById, transitionValues);
                            if (intValue >= 0) {
                                this.mStartValues.idValues.put(intValue, transitionValues);
                            }
                        } else {
                            this.mEndValues.viewValues.put(findViewById, transitionValues);
                            if (intValue >= 0) {
                                this.mEndValues.idValues.put(intValue, transitionValues);
                            }
                        }
                    }
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    View view2 = this.mTargets.get(i2);
                    if (view2 != null) {
                        TransitionValues transitionValues2 = new TransitionValues();
                        transitionValues2.f2view = view2;
                        if (z) {
                            captureStartValues(transitionValues2);
                        } else {
                            captureEndValues(transitionValues2);
                        }
                        if (z) {
                            this.mStartValues.viewValues.put(view2, transitionValues2);
                        } else {
                            this.mEndValues.viewValues.put(view2, transitionValues2);
                        }
                    }
                }
                return;
            }
            return;
        }
        captureHierarchy(viewGroup, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.viewValues.clear();
            this.mStartValues.idValues.clear();
            this.mStartValues.itemIdValues.clear();
            return;
        }
        this.mEndValues.viewValues.clear();
        this.mEndValues.idValues.clear();
        this.mEndValues.itemIdValues.clear();
    }

    private void captureHierarchy(View view2, boolean z) {
        int i;
        long itemIdAtPosition;
        if (view2 != null) {
            boolean z2 = view2.getParent() instanceof ListView;
            if (!z2 || ((ListView) view2.getParent()).getAdapter().hasStableIds()) {
                if (!z2) {
                    i = view2.getId();
                    itemIdAtPosition = -1;
                } else {
                    ListView listView = (ListView) view2.getParent();
                    i = -1;
                    itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view2));
                }
                if (this.mTargetIdExcludes == null || !this.mTargetIdExcludes.contains(Integer.valueOf(i))) {
                    if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view2)) {
                        if (this.mTargetTypeExcludes != null && view2 != null) {
                            int size = this.mTargetTypeExcludes.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                if (this.mTargetTypeExcludes.get(i2).isInstance(view2)) {
                                    return;
                                }
                            }
                        }
                        TransitionValues transitionValues = new TransitionValues();
                        transitionValues.f2view = view2;
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        if (z) {
                            if (!z2) {
                                this.mStartValues.viewValues.put(view2, transitionValues);
                                if (i >= 0) {
                                    this.mStartValues.idValues.put(i, transitionValues);
                                }
                            } else {
                                this.mStartValues.itemIdValues.put(itemIdAtPosition, transitionValues);
                            }
                        } else if (!z2) {
                            this.mEndValues.viewValues.put(view2, transitionValues);
                            if (i >= 0) {
                                this.mEndValues.idValues.put(i, transitionValues);
                            }
                        } else {
                            this.mEndValues.itemIdValues.put(itemIdAtPosition, transitionValues);
                        }
                        if (view2 instanceof ViewGroup) {
                            if (this.mTargetIdChildExcludes == null || !this.mTargetIdChildExcludes.contains(Integer.valueOf(i))) {
                                if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view2)) {
                                    if (this.mTargetTypeChildExcludes != null && view2 != null) {
                                        int size2 = this.mTargetTypeChildExcludes.size();
                                        for (int i3 = 0; i3 < size2; i3++) {
                                            if (this.mTargetTypeChildExcludes.get(i3).isInstance(view2)) {
                                                return;
                                            }
                                        }
                                    }
                                    ViewGroup viewGroup = (ViewGroup) view2;
                                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                        captureHierarchy(viewGroup.getChildAt(i4), z);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public TransitionValues getTransitionValues(View view2, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view2, z);
        }
        TransitionValuesMaps transitionValuesMaps = z ? this.mStartValues : this.mEndValues;
        TransitionValues transitionValues = transitionValuesMaps.viewValues.get(view2);
        if (transitionValues == null) {
            int id = view2.getId();
            if (id >= 0) {
                transitionValues = transitionValuesMaps.idValues.get(id);
            }
            if (transitionValues == null && (view2.getParent() instanceof ListView)) {
                ListView listView = (ListView) view2.getParent();
                return transitionValuesMaps.itemIdValues.get(listView.getItemIdAtPosition(listView.getPositionForView(view2)));
            }
            return transitionValues;
        }
        return transitionValues;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void pause(View view2) {
        if (!this.mEnded) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdPort windowId = WindowIdPort.getWindowId(view2);
            for (int i = size - 1; i >= 0; i--) {
                AnimationInfo valueAt = runningAnimators.valueAt(i);
                if (valueAt.f1view != null && windowId.equals(valueAt.windowId)) {
                    runningAnimators.keyAt(i).cancel();
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((TransitionListener) arrayList.get(i2)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void resume(View view2) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdPort windowId = WindowIdPort.getWindowId(view2);
                for (int i = size - 1; i >= 0; i--) {
                    AnimationInfo valueAt = runningAnimators.valueAt(i);
                    if (valueAt.f1view != null && windowId.equals(valueAt.windowId)) {
                        runningAnimators.keyAt(i).end();
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        boolean z;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        for (int size = runningAnimators.size() - 1; size >= 0; size--) {
            Animator keyAt = runningAnimators.keyAt(size);
            if (keyAt != null && (animationInfo = runningAnimators.get(keyAt)) != null && animationInfo.f1view != null && animationInfo.f1view.getContext() == viewGroup.getContext()) {
                TransitionValues transitionValues = animationInfo.values;
                View view2 = animationInfo.f1view;
                TransitionValues transitionValues2 = this.mEndValues.viewValues != null ? this.mEndValues.viewValues.get(view2) : null;
                TransitionValues transitionValues3 = transitionValues2 == null ? this.mEndValues.idValues.get(view2.getId()) : transitionValues2;
                if (transitionValues != null && transitionValues3 != null) {
                    for (String str : transitionValues.values.keySet()) {
                        Object obj = transitionValues.values.get(str);
                        Object obj2 = transitionValues3.values.get(str);
                        if (obj != null && obj2 != null && !obj.equals(obj2)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        runningAnimators.remove(keyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues);
        runAnimators();
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.TransitionPort.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                TransitionPort.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).onTransitionEnd(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.itemIdValues.size(); i2++) {
                View view2 = this.mStartValues.itemIdValues.valueAt(i2).f2view;
            }
            for (int i3 = 0; i3 < this.mEndValues.itemIdValues.size(); i3++) {
                View view3 = this.mEndValues.itemIdValues.valueAt(i3).f2view;
            }
            this.mEnded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList.get(i)).onTransitionCancel(this);
            }
        }
    }

    public TransitionPort addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public TransitionPort removeListener(TransitionListener transitionListener) {
        if (this.mListeners != null) {
            this.mListeners.remove(transitionListener);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransitionPort setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public TransitionPort m0clone() {
        try {
            TransitionPort transitionPort = (TransitionPort) super.clone();
            try {
                transitionPort.mAnimators = new ArrayList<>();
                transitionPort.mStartValues = new TransitionValuesMaps();
                transitionPort.mEndValues = new TransitionValuesMaps();
                return transitionPort;
            } catch (CloneNotSupportedException e) {
                return transitionPort;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(String str) {
        String str2;
        String str3 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str3 = str3 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str3 = str3 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str3 = str3 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            String str4 = str3 + "tgts(";
            if (this.mTargetIds.size() > 0) {
                str2 = str4;
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    if (i > 0) {
                        str2 = str2 + ", ";
                    }
                    str2 = str2 + this.mTargetIds.get(i);
                }
            } else {
                str2 = str4;
            }
            if (this.mTargets.size() > 0) {
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    if (i2 > 0) {
                        str2 = str2 + ", ";
                    }
                    str2 = str2 + this.mTargets.get(i2);
                }
            }
            return str2 + ")";
        }
        return str3;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* loaded from: classes2.dex */
    public static class TransitionListenerAdapter implements TransitionListener {
        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionStart(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionEnd(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionCancel(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionPause(TransitionPort transitionPort) {
        }

        @Override // android.support.transition.TransitionPort.TransitionListener
        public void onTransitionResume(TransitionPort transitionPort) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AnimationInfo {
        String name;
        TransitionValues values;

        /* renamed from: view  reason: collision with root package name */
        View f1view;
        WindowIdPort windowId;

        AnimationInfo(View view2, String str, WindowIdPort windowIdPort, TransitionValues transitionValues) {
            this.f1view = view2;
            this.name = str;
            this.values = transitionValues;
            this.windowId = windowIdPort;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            if (arrayList != null) {
                arrayList.remove(t);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }
}
