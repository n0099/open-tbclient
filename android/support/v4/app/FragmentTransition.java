package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.BackStackRecord;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    FragmentTransition() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState >= 1 && Build.VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    ArrayMap<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsReordered(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    } else {
                        configureTransitionsOrdered(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList<String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    @RequiresApi(21)
    private static void configureTransitionsReordered(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        ViewGroup viewGroup = null;
        if (fragmentManagerImpl.mContainer.onHasView()) {
            viewGroup = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(i);
        }
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            Fragment fragment2 = fragmentContainerTransition.firstOut;
            boolean z = fragmentContainerTransition.lastInIsPop;
            boolean z2 = fragmentContainerTransition.firstOutIsPop;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            Object configureSharedElementsReordered = configureSharedElementsReordered(viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
            if (enterTransition != null || configureSharedElementsReordered != null || exitTransition != null) {
                ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(exitTransition, fragment2, arrayList2, view);
                ArrayList<View> configureEnteringExitingViews2 = configureEnteringExitingViews(enterTransition, fragment, arrayList, view);
                setViewVisibility(configureEnteringExitingViews2, 4);
                Object mergeTransitions = mergeTransitions(enterTransition, exitTransition, configureSharedElementsReordered, fragment, z);
                if (mergeTransitions != null) {
                    replaceHide(exitTransition, fragment2, configureEnteringExitingViews);
                    ArrayList<String> prepareSetNameOverridesReordered = FragmentTransitionCompat21.prepareSetNameOverridesReordered(arrayList);
                    FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, exitTransition, configureEnteringExitingViews, configureSharedElementsReordered, arrayList);
                    FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
                    FragmentTransitionCompat21.setNameOverridesReordered(viewGroup, arrayList2, arrayList, prepareSetNameOverridesReordered, arrayMap);
                    setViewVisibility(configureEnteringExitingViews2, 0);
                    FragmentTransitionCompat21.swapSharedElementTargets(configureSharedElementsReordered, arrayList2, arrayList);
                }
            }
        }
    }

    @RequiresApi(21)
    private static void replaceHide(Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            FragmentTransitionCompat21.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() { // from class: android.support.v4.app.FragmentTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    @RequiresApi(21)
    private static void configureTransitionsOrdered(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        ViewGroup viewGroup = null;
        if (fragmentManagerImpl.mContainer.onHasView()) {
            viewGroup = (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(i);
        }
        if (viewGroup != null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            Fragment fragment2 = fragmentContainerTransition.firstOut;
            boolean z = fragmentContainerTransition.lastInIsPop;
            boolean z2 = fragmentContainerTransition.firstOutIsPop;
            Object enterTransition = getEnterTransition(fragment, z);
            Object exitTransition = getExitTransition(fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object configureSharedElementsOrdered = configureSharedElementsOrdered(viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
            if (enterTransition != null || configureSharedElementsOrdered != null || exitTransition != null) {
                ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(exitTransition, fragment2, arrayList, view);
                Object obj = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : exitTransition;
                FragmentTransitionCompat21.addTarget(enterTransition, view);
                Object mergeTransitions = mergeTransitions(enterTransition, obj, configureSharedElementsOrdered, fragment, fragmentContainerTransition.lastInIsPop);
                if (mergeTransitions != null) {
                    ArrayList arrayList3 = new ArrayList();
                    FragmentTransitionCompat21.scheduleRemoveTargets(mergeTransitions, enterTransition, arrayList3, obj, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
                    scheduleTargetChange(viewGroup, fragment, view, arrayList2, enterTransition, arrayList3, obj, configureEnteringExitingViews);
                    FragmentTransitionCompat21.setNameOverridesOrdered(viewGroup, arrayList2, arrayMap);
                    FragmentTransitionCompat21.beginDelayedTransition(viewGroup, mergeTransitions);
                    FragmentTransitionCompat21.scheduleNameReset(viewGroup, arrayList2, arrayMap);
                }
            }
        }
    }

    @RequiresApi(21)
    private static void scheduleTargetChange(ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    FragmentTransitionCompat21.removeTarget(obj, view);
                    arrayList2.addAll(FragmentTransition.configureEnteringExitingViews(obj, fragment, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(view);
                        FragmentTransitionCompat21.replaceTargets(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    @RequiresApi(21)
    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(sharedElementEnterTransition));
    }

    @RequiresApi(21)
    private static Object getEnterTransition(Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(enterTransition);
    }

    @RequiresApi(21)
    private static Object getExitTransition(Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return FragmentTransitionCompat21.cloneTransition(exitTransition);
    }

    @RequiresApi(21)
    private static Object configureSharedElementsReordered(ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2 = null;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        final ArrayMap<String, View> captureInSharedElements = captureInSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
                obj3 = null;
            } else {
                obj3 = null;
            }
        } else {
            addSharedElementsWithMatchingNames(arrayList, captureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList2, captureInSharedElements, arrayMap.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            arrayList2.add(view);
            FragmentTransitionCompat21.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            rect = new Rect();
            view2 = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
            if (view2 != null) {
                FragmentTransitionCompat21.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.callSharedElementStartEnd(Fragment.this, fragment2, z, captureInSharedElements, false);
                if (view2 != null) {
                    FragmentTransitionCompat21.getBoundsOnScreen(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    @RequiresApi(21)
    private static Object configureSharedElementsOrdered(ViewGroup viewGroup, final View view, final ArrayMap<String, String> arrayMap, final FragmentContainerTransition fragmentContainerTransition, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        final Object obj3;
        final Rect rect;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragment, fragment2, z);
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(captureOutSharedElements.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            rect = new Rect();
            FragmentTransitionCompat21.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                FragmentTransitionCompat21.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayMap captureInSharedElements = FragmentTransition.captureInSharedElements(ArrayMap.this, obj3, fragmentContainerTransition);
                if (captureInSharedElements != null) {
                    arrayList2.addAll(captureInSharedElements.values());
                    arrayList2.add(view);
                }
                FragmentTransition.callSharedElementStartEnd(fragment, fragment2, z, captureInSharedElements, false);
                if (obj3 != null) {
                    FragmentTransitionCompat21.swapSharedElementTargets(obj3, arrayList, arrayList2);
                    View inEpicenterView = FragmentTransition.getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
                    if (inEpicenterView != null) {
                        FragmentTransitionCompat21.getBoundsOnScreen(inEpicenterView, rect);
                    }
                }
            }
        });
        return obj3;
    }

    @RequiresApi(21)
    private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        SharedElementCallback sharedElementCallback;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, fragment.getView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            SharedElementCallback enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
            sharedElementCallback = enterTransitionCallback;
        } else {
            SharedElementCallback exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
            sharedElementCallback = exitTransitionCallback;
        }
        arrayMap2.retainAll(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        SharedElementCallback sharedElementCallback;
        String findKeyForValue;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            SharedElementCallback exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
            sharedElementCallback = exitTransitionCallback;
        } else {
            SharedElementCallback enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
            sharedElementCallback = enterTransitionCallback;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String findKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (findKeyForValue2 != null) {
                        arrayMap.remove(findKeyForValue2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (findKeyForValue = findKeyForValue(arrayMap, str)) != null) {
                    arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj != null && arrayMap != null && backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            if (z) {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            } else {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            }
            return arrayMap.get(str);
        }
        return null;
    }

    @RequiresApi(21)
    private static void setOutEpicenter(Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            if (z) {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            } else {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            }
            View view = arrayMap.get(str);
            FragmentTransitionCompat21.setEpicenter(obj, view);
            if (obj2 != null) {
                FragmentTransitionCompat21.setEpicenter(obj2, view);
            }
        }
    }

    private static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    public static ArrayList<View> configureEnteringExitingViews(Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                FragmentTransitionCompat21.captureTransitioningViews(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                FragmentTransitionCompat21.addTargets(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    @RequiresApi(21)
    private static Object mergeTransitions(Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (obj != null && obj2 != null && fragment != null) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return FragmentTransitionCompat21.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return FragmentTransitionCompat21.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    private static void addToFirstInLastOut(BackStackRecord backStackRecord, BackStackRecord.Op op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        FragmentContainerTransition fragmentContainerTransition;
        FragmentContainerTransition fragmentContainerTransition2;
        Fragment fragment = op.fragment;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            switch (z ? INVERSE_OPS[op.cmd] : op.cmd) {
                case 1:
                case 7:
                    if (z2) {
                        z9 = fragment.mIsNewlyAdded;
                    } else {
                        z9 = (fragment.mAdded || fragment.mHidden) ? false : true;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z9;
                    break;
                case 2:
                default:
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    z7 = false;
                    break;
                case 3:
                case 6:
                    if (z2) {
                        z3 = !fragment.mAdded && fragment.mView != null && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f;
                    } else {
                        z3 = fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = false;
                    z5 = z3;
                    z6 = true;
                    z7 = false;
                    break;
                case 4:
                    if (z2) {
                        z8 = fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden;
                    } else {
                        z8 = fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = false;
                    z5 = z8;
                    z6 = true;
                    z7 = false;
                    break;
                case 5:
                    if (z2) {
                        z10 = fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded;
                    } else {
                        z10 = fragment.mHidden;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z10;
                    break;
            }
            FragmentContainerTransition fragmentContainerTransition3 = sparseArray.get(i);
            if (z7) {
                fragmentContainerTransition = ensureContainer(fragmentContainerTransition3, sparseArray, i);
                fragmentContainerTransition.lastIn = fragment;
                fragmentContainerTransition.lastInIsPop = z;
                fragmentContainerTransition.lastInTransaction = backStackRecord;
            } else {
                fragmentContainerTransition = fragmentContainerTransition3;
            }
            if (!z2 && z4) {
                if (fragmentContainerTransition != null && fragmentContainerTransition.firstOut == fragment) {
                    fragmentContainerTransition.firstOut = null;
                }
                FragmentManagerImpl fragmentManagerImpl = backStackRecord.mManager;
                if (fragment.mState < 1 && fragmentManagerImpl.mCurState >= 1 && !backStackRecord.mReorderingAllowed) {
                    fragmentManagerImpl.makeActive(fragment);
                    fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                }
            }
            if (z5 && (fragmentContainerTransition == null || fragmentContainerTransition.firstOut == null)) {
                fragmentContainerTransition2 = ensureContainer(fragmentContainerTransition, sparseArray, i);
                fragmentContainerTransition2.firstOut = fragment;
                fragmentContainerTransition2.firstOutIsPop = z;
                fragmentContainerTransition2.firstOutTransaction = backStackRecord;
            } else {
                fragmentContainerTransition2 = fragmentContainerTransition;
            }
            if (!z2 && z6 && fragmentContainerTransition2 != null && fragmentContainerTransition2.lastIn == fragment) {
                fragmentContainerTransition2.lastIn = null;
            }
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition == null) {
            FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
            sparseArray.put(i, fragmentContainerTransition2);
            return fragmentContainerTransition2;
        }
        return fragmentContainerTransition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }
}
