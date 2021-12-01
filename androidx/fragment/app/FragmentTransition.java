package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTransition {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] INVERSE_OPS;
    public static final FragmentTransitionImpl PLATFORM_IMPL;
    public static final FragmentTransitionImpl SUPPORT_IMPL;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Callback {
        void onComplete(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal);

        void onStart(@NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal);
    }

    /* loaded from: classes.dex */
    public static class FragmentContainerTransition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        public FragmentContainerTransition() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-679676957, "Landroidx/fragment/app/FragmentTransition;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-679676957, "Landroidx/fragment/app/FragmentTransition;");
                return;
            }
        }
        INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
        PLATFORM_IMPL = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        SUPPORT_IMPL = resolveSupportImpl();
    }

    public FragmentTransition() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, arrayList, arrayMap, collection) == null) {
            for (int size = arrayMap.size() - 1; size >= 0; size--) {
                View valueAt = arrayMap.valueAt(size);
                if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                    arrayList.add(valueAt);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x003d, code lost:
        if (r0.mAdded != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0072, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x008e, code lost:
        if (r0.mHidden == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0090, code lost:
        r9 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00dd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void addToFirstInLastOut(BackStackRecord backStackRecord, FragmentTransaction.Op op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        Fragment fragment;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        FragmentContainerTransition fragmentContainerTransition;
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{backStackRecord, op, sparseArray, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (fragment = op.mFragment) == null || (i2 = fragment.mContainerId) == 0) {
            return;
        }
        int i3 = z ? INVERSE_OPS[op.mCmd] : op.mCmd;
        boolean z7 = false;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 == 4) {
                    boolean z8 = !z2 ? false : false;
                    z5 = z8;
                    z4 = false;
                    z6 = true;
                    fragmentContainerTransition = sparseArray.get(i2);
                    if (z7) {
                    }
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                } else if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            z4 = false;
                            z6 = false;
                            z5 = false;
                            fragmentContainerTransition = sparseArray.get(i2);
                            if (z7) {
                                fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i2);
                                fragmentContainerTransition.lastIn = fragment;
                                fragmentContainerTransition.lastInIsPop = z;
                                fragmentContainerTransition.lastInTransaction = backStackRecord;
                            }
                            if (!z2 && z4) {
                                if (fragmentContainerTransition != null && fragmentContainerTransition.firstOut == fragment) {
                                    fragmentContainerTransition.firstOut = null;
                                }
                                fragmentManager = backStackRecord.mManager;
                                if (fragment.mState < 1 && fragmentManager.mCurState >= 1 && !backStackRecord.mReorderingAllowed) {
                                    fragmentManager.makeActive(fragment);
                                    fragmentManager.moveToState(fragment, 1);
                                }
                            }
                            if (z5 && (fragmentContainerTransition == null || fragmentContainerTransition.firstOut == null)) {
                                fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i2);
                                fragmentContainerTransition.firstOut = fragment;
                                fragmentContainerTransition.firstOutIsPop = z;
                                fragmentContainerTransition.firstOutTransaction = backStackRecord;
                            }
                            if (z2 || !z6 || fragmentContainerTransition == null || fragmentContainerTransition.lastIn != fragment) {
                                return;
                            }
                            fragmentContainerTransition.lastIn = null;
                            return;
                        }
                    }
                } else if (z2) {
                    if (fragment.mHiddenChanged) {
                        if (!fragment.mHidden) {
                        }
                    }
                    z3 = false;
                    z7 = z3;
                    z4 = true;
                    z6 = false;
                    z5 = false;
                    fragmentContainerTransition = sparseArray.get(i2);
                    if (z7) {
                    }
                    if (!z2) {
                        if (fragmentContainerTransition != null) {
                            fragmentContainerTransition.firstOut = null;
                        }
                        fragmentManager = backStackRecord.mManager;
                        if (fragment.mState < 1) {
                            fragmentManager.makeActive(fragment);
                            fragmentManager.moveToState(fragment, 1);
                        }
                    }
                    if (z5) {
                        fragmentContainerTransition = ensureContainer(fragmentContainerTransition, sparseArray, i2);
                        fragmentContainerTransition.firstOut = fragment;
                        fragmentContainerTransition.firstOutIsPop = z;
                        fragmentContainerTransition.firstOutTransaction = backStackRecord;
                    }
                    if (z2) {
                        return;
                    }
                    return;
                } else {
                    z3 = fragment.mHidden;
                    z7 = z3;
                    z4 = true;
                    z6 = false;
                    z5 = false;
                    fragmentContainerTransition = sparseArray.get(i2);
                    if (z7) {
                    }
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                }
            }
            if (!z2) {
            }
            z5 = z8;
            z4 = false;
            z6 = true;
            fragmentContainerTransition = sparseArray.get(i2);
            if (z7) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
        if (z2) {
            z3 = fragment.mIsNewlyAdded;
            z7 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
            fragmentContainerTransition = sparseArray.get(i2);
            if (z7) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        } else {
            if (!fragment.mAdded) {
            }
            z3 = false;
            z7 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
            fragmentContainerTransition = sparseArray.get(i2);
            if (z7) {
            }
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, backStackRecord, sparseArray, z) == null) {
            int size = backStackRecord.mOps.size();
            for (int i2 = 0; i2 < size; i2++) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i2), sparseArray, false, z);
            }
        }
    }

    public static ArrayMap<String, String> calculateNameOverrides(int i2, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        InterceptResult invokeCommon;
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), arrayList, arrayList2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            for (int i5 = i4 - 1; i5 >= i3; i5--) {
                BackStackRecord backStackRecord = arrayList.get(i5);
                if (backStackRecord.interactsWith(i2)) {
                    boolean booleanValue = arrayList2.get(i5).booleanValue();
                    ArrayList<String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                    if (arrayList5 != null) {
                        int size = arrayList5.size();
                        if (booleanValue) {
                            arrayList3 = backStackRecord.mSharedElementSourceNames;
                            arrayList4 = backStackRecord.mSharedElementTargetNames;
                        } else {
                            ArrayList<String> arrayList6 = backStackRecord.mSharedElementSourceNames;
                            arrayList3 = backStackRecord.mSharedElementTargetNames;
                            arrayList4 = arrayList6;
                        }
                        for (int i6 = 0; i6 < size; i6++) {
                            String str = arrayList4.get(i6);
                            String str2 = arrayList3.get(i6);
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
        return (ArrayMap) invokeCommon.objValue;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65542, null, backStackRecord, sparseArray, z) == null) && backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{fragment, fragment2, Boolean.valueOf(z), arrayMap, Boolean.valueOf(z2)}) == null) {
            if (z) {
                enterTransitionCallback = fragment2.getEnterTransitionCallback();
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
            }
            if (enterTransitionCallback != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size = arrayMap == null ? 0 : arrayMap.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList2.add(arrayMap.keyAt(i2));
                    arrayList.add(arrayMap.valueAt(i2));
                }
                if (z2) {
                    enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
                } else {
                    enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
                }
            }
        }
    }

    public static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, fragmentTransitionImpl, list)) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!fragmentTransitionImpl.canHandle(list.get(i2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        InterceptResult invokeLLLL;
        SharedElementCallback enterTransitionCallback;
        ArrayList<String> arrayList;
        String findKeyForValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, fragmentTransitionImpl, arrayMap, obj, fragmentContainerTransition)) == null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            View view = fragment.getView();
            if (!arrayMap.isEmpty() && obj != null && view != null) {
                ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
                fragmentTransitionImpl.findNamedViews(arrayMap2, view);
                BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
                if (fragmentContainerTransition.lastInIsPop) {
                    enterTransitionCallback = fragment.getExitTransitionCallback();
                    arrayList = backStackRecord.mSharedElementSourceNames;
                } else {
                    enterTransitionCallback = fragment.getEnterTransitionCallback();
                    arrayList = backStackRecord.mSharedElementTargetNames;
                }
                if (arrayList != null) {
                    arrayMap2.retainAll(arrayList);
                    arrayMap2.retainAll(arrayMap.values());
                }
                if (enterTransitionCallback != null) {
                    enterTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
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
            arrayMap.clear();
            return null;
        }
        return (ArrayMap) invokeLLLL.objValue;
    }

    public static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        InterceptResult invokeLLLL;
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, fragmentTransitionImpl, arrayMap, obj, fragmentContainerTransition)) == null) {
            if (!arrayMap.isEmpty() && obj != null) {
                Fragment fragment = fragmentContainerTransition.firstOut;
                ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
                fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.requireView());
                BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
                if (fragmentContainerTransition.firstOutIsPop) {
                    exitTransitionCallback = fragment.getEnterTransitionCallback();
                    arrayList = backStackRecord.mSharedElementTargetNames;
                } else {
                    exitTransitionCallback = fragment.getExitTransitionCallback();
                    arrayList = backStackRecord.mSharedElementSourceNames;
                }
                if (arrayList != null) {
                    arrayMap2.retainAll(arrayList);
                }
                if (exitTransitionCallback != null) {
                    exitTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
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
            arrayMap.clear();
            return null;
        }
        return (ArrayMap) invokeLLLL.objValue;
    }

    public static FragmentTransitionImpl chooseImpl(Fragment fragment, Fragment fragment2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, fragment, fragment2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (fragment != null) {
                Object exitTransition = fragment.getExitTransition();
                if (exitTransition != null) {
                    arrayList.add(exitTransition);
                }
                Object returnTransition = fragment.getReturnTransition();
                if (returnTransition != null) {
                    arrayList.add(returnTransition);
                }
                Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
                if (sharedElementReturnTransition != null) {
                    arrayList.add(sharedElementReturnTransition);
                }
            }
            if (fragment2 != null) {
                Object enterTransition = fragment2.getEnterTransition();
                if (enterTransition != null) {
                    arrayList.add(enterTransition);
                }
                Object reenterTransition = fragment2.getReenterTransition();
                if (reenterTransition != null) {
                    arrayList.add(reenterTransition);
                }
                Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
                if (sharedElementEnterTransition != null) {
                    arrayList.add(sharedElementEnterTransition);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && canHandleAll(fragmentTransitionImpl, arrayList)) {
                return PLATFORM_IMPL;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && canHandleAll(fragmentTransitionImpl2, arrayList)) {
                return SUPPORT_IMPL;
            }
            if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
                return null;
            }
            throw new IllegalArgumentException("Invalid Transition types");
        }
        return (FragmentTransitionImpl) invokeLL.objValue;
    }

    public static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, fragmentTransitionImpl, obj, fragment, arrayList, view)) == null) {
            if (obj != null) {
                ArrayList<View> arrayList2 = new ArrayList<>();
                View view2 = fragment.getView();
                if (view2 != null) {
                    fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
                }
                if (arrayList != null) {
                    arrayList2.removeAll(arrayList);
                }
                if (arrayList2.isEmpty()) {
                    return arrayList2;
                }
                arrayList2.add(view);
                fragmentTransitionImpl.addTargets(obj, arrayList2);
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeLLLLL.objValue;
    }

    public static Object configureSharedElementsOrdered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        InterceptResult invokeCommon;
        Object sharedElementTransition;
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{fragmentTransitionImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, obj, obj2})) == null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            Fragment fragment2 = fragmentContainerTransition.firstOut;
            if (fragment == null || fragment2 == null) {
                return null;
            }
            boolean z = fragmentContainerTransition.lastInIsPop;
            if (arrayMap.isEmpty()) {
                arrayMap2 = arrayMap;
                sharedElementTransition = null;
            } else {
                sharedElementTransition = getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z);
                arrayMap2 = arrayMap;
            }
            ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, arrayMap2, sharedElementTransition, fragmentContainerTransition);
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
                fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
                setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
                if (obj != null) {
                    fragmentTransitionImpl.setEpicenter(obj, rect);
                }
            } else {
                rect = null;
            }
            OneShotPreDrawListener.add(viewGroup, new Runnable(fragmentTransitionImpl, arrayMap, obj3, fragmentContainerTransition, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect) { // from class: androidx.fragment.app.FragmentTransition.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object val$enterTransition;
                public final /* synthetic */ Object val$finalSharedElementTransition;
                public final /* synthetic */ FragmentContainerTransition val$fragments;
                public final /* synthetic */ FragmentTransitionImpl val$impl;
                public final /* synthetic */ Rect val$inEpicenter;
                public final /* synthetic */ Fragment val$inFragment;
                public final /* synthetic */ boolean val$inIsPop;
                public final /* synthetic */ ArrayMap val$nameOverrides;
                public final /* synthetic */ View val$nonExistentView;
                public final /* synthetic */ Fragment val$outFragment;
                public final /* synthetic */ ArrayList val$sharedElementsIn;
                public final /* synthetic */ ArrayList val$sharedElementsOut;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {fragmentTransitionImpl, arrayMap, obj3, fragmentContainerTransition, arrayList2, view, fragment, fragment2, Boolean.valueOf(z), arrayList, obj, rect};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$impl = fragmentTransitionImpl;
                    this.val$nameOverrides = arrayMap;
                    this.val$finalSharedElementTransition = obj3;
                    this.val$fragments = fragmentContainerTransition;
                    this.val$sharedElementsIn = arrayList2;
                    this.val$nonExistentView = view;
                    this.val$inFragment = fragment;
                    this.val$outFragment = fragment2;
                    this.val$inIsPop = z;
                    this.val$sharedElementsOut = arrayList;
                    this.val$enterTransition = obj;
                    this.val$inEpicenter = rect;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ArrayMap<String, View> captureInSharedElements = FragmentTransition.captureInSharedElements(this.val$impl, this.val$nameOverrides, this.val$finalSharedElementTransition, this.val$fragments);
                        if (captureInSharedElements != null) {
                            this.val$sharedElementsIn.addAll(captureInSharedElements.values());
                            this.val$sharedElementsIn.add(this.val$nonExistentView);
                        }
                        FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, captureInSharedElements, false);
                        Object obj4 = this.val$finalSharedElementTransition;
                        if (obj4 != null) {
                            this.val$impl.swapSharedElementTargets(obj4, this.val$sharedElementsOut, this.val$sharedElementsIn);
                            View inEpicenterView = FragmentTransition.getInEpicenterView(captureInSharedElements, this.val$fragments, this.val$enterTransition, this.val$inIsPop);
                            if (inEpicenterView != null) {
                                this.val$impl.getBoundsOnScreen(inEpicenterView, this.val$inEpicenter);
                            }
                        }
                    }
                }
            });
            return obj3;
        }
        return invokeCommon.objValue;
    }

    public static Object configureSharedElementsReordered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        InterceptResult invokeCommon;
        Object obj3;
        View view2;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{fragmentTransitionImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, obj, obj2})) == null) {
            Fragment fragment = fragmentContainerTransition.lastIn;
            Fragment fragment2 = fragmentContainerTransition.firstOut;
            if (fragment != null) {
                fragment.requireView().setVisibility(0);
            }
            if (fragment == null || fragment2 == null) {
                return null;
            }
            boolean z = fragmentContainerTransition.lastInIsPop;
            Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z);
            ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, arrayMap, sharedElementTransition, fragmentContainerTransition);
            ArrayMap<String, View> captureInSharedElements = captureInSharedElements(fragmentTransitionImpl, arrayMap, sharedElementTransition, fragmentContainerTransition);
            if (arrayMap.isEmpty()) {
                if (captureOutSharedElements != null) {
                    captureOutSharedElements.clear();
                }
                if (captureInSharedElements != null) {
                    captureInSharedElements.clear();
                }
                obj3 = null;
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
                fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
                setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
                Rect rect2 = new Rect();
                View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z);
                if (inEpicenterView != null) {
                    fragmentTransitionImpl.setEpicenter(obj, rect2);
                }
                rect = rect2;
                view2 = inEpicenterView;
            } else {
                view2 = null;
                rect = null;
            }
            OneShotPreDrawListener.add(viewGroup, new Runnable(fragment, fragment2, z, captureInSharedElements, view2, fragmentTransitionImpl, rect) { // from class: androidx.fragment.app.FragmentTransition.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Rect val$epicenter;
                public final /* synthetic */ View val$epicenterView;
                public final /* synthetic */ FragmentTransitionImpl val$impl;
                public final /* synthetic */ Fragment val$inFragment;
                public final /* synthetic */ boolean val$inIsPop;
                public final /* synthetic */ ArrayMap val$inSharedElements;
                public final /* synthetic */ Fragment val$outFragment;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fragment, fragment2, Boolean.valueOf(z), captureInSharedElements, view2, fragmentTransitionImpl, rect};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$inFragment = fragment;
                    this.val$outFragment = fragment2;
                    this.val$inIsPop = z;
                    this.val$inSharedElements = captureInSharedElements;
                    this.val$epicenterView = view2;
                    this.val$impl = fragmentTransitionImpl;
                    this.val$epicenter = rect;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FragmentTransition.callSharedElementStartEnd(this.val$inFragment, this.val$outFragment, this.val$inIsPop, this.val$inSharedElements, false);
                        View view3 = this.val$epicenterView;
                        if (view3 != null) {
                            this.val$impl.getBoundsOnScreen(view3, this.val$epicenter);
                        }
                    }
                }
            });
            return obj3;
        }
        return invokeCommon.objValue;
    }

    public static void configureTransitionsOrdered(FragmentManager fragmentManager, int i2, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, Callback callback) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl chooseImpl;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{fragmentManager, Integer.valueOf(i2), fragmentContainerTransition, view, arrayMap, callback}) == null) {
            ViewGroup viewGroup = fragmentManager.mContainer.onHasView() ? (ViewGroup) fragmentManager.mContainer.onFindViewById(i2) : null;
            if (viewGroup == null || (chooseImpl = chooseImpl((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
                return;
            }
            boolean z = fragmentContainerTransition.lastInIsPop;
            boolean z2 = fragmentContainerTransition.firstOutIsPop;
            Object enterTransition = getEnterTransition(chooseImpl, fragment, z);
            Object exitTransition = getExitTransition(chooseImpl, fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object configureSharedElementsOrdered = configureSharedElementsOrdered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
            if (enterTransition == null && configureSharedElementsOrdered == null) {
                obj = exitTransition;
                if (obj == null) {
                    return;
                }
            } else {
                obj = exitTransition;
            }
            ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl, obj, fragment2, arrayList, view);
            Object obj2 = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : obj;
            chooseImpl.addTarget(enterTransition, view);
            Object mergeTransitions = mergeTransitions(chooseImpl, enterTransition, obj2, configureSharedElementsOrdered, fragment, fragmentContainerTransition.lastInIsPop);
            if (fragment2 != null && configureEnteringExitingViews != null && (configureEnteringExitingViews.size() > 0 || arrayList.size() > 0)) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                callback.onStart(fragment2, cancellationSignal);
                chooseImpl.setListenerForTransitionEnd(fragment2, mergeTransitions, cancellationSignal, new Runnable(callback, fragment2, cancellationSignal) { // from class: androidx.fragment.app.FragmentTransition.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Callback val$callback;
                    public final /* synthetic */ Fragment val$outFragment;
                    public final /* synthetic */ CancellationSignal val$signal;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {callback, fragment2, cancellationSignal};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = callback;
                        this.val$outFragment = fragment2;
                        this.val$signal = cancellationSignal;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$callback.onComplete(this.val$outFragment, this.val$signal);
                        }
                    }
                });
            }
            if (mergeTransitions != null) {
                ArrayList<View> arrayList3 = new ArrayList<>();
                chooseImpl.scheduleRemoveTargets(mergeTransitions, enterTransition, arrayList3, obj2, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
                scheduleTargetChange(chooseImpl, viewGroup, fragment, view, arrayList2, enterTransition, arrayList3, obj2, configureEnteringExitingViews);
                chooseImpl.setNameOverridesOrdered(viewGroup, arrayList2, arrayMap);
                chooseImpl.beginDelayedTransition(viewGroup, mergeTransitions);
                chooseImpl.scheduleNameReset(viewGroup, arrayList2, arrayMap);
            }
        }
    }

    public static void configureTransitionsReordered(FragmentManager fragmentManager, int i2, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, Callback callback) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl chooseImpl;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{fragmentManager, Integer.valueOf(i2), fragmentContainerTransition, view, arrayMap, callback}) == null) {
            ViewGroup viewGroup = fragmentManager.mContainer.onHasView() ? (ViewGroup) fragmentManager.mContainer.onFindViewById(i2) : null;
            if (viewGroup == null || (chooseImpl = chooseImpl((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
                return;
            }
            boolean z = fragmentContainerTransition.lastInIsPop;
            boolean z2 = fragmentContainerTransition.firstOutIsPop;
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object enterTransition = getEnterTransition(chooseImpl, fragment, z);
            Object exitTransition = getExitTransition(chooseImpl, fragment2, z2);
            Object configureSharedElementsReordered = configureSharedElementsReordered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
            if (enterTransition == null && configureSharedElementsReordered == null) {
                obj = exitTransition;
                if (obj == null) {
                    return;
                }
            } else {
                obj = exitTransition;
            }
            ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl, obj, fragment2, arrayList2, view);
            ArrayList<View> configureEnteringExitingViews2 = configureEnteringExitingViews(chooseImpl, enterTransition, fragment, arrayList, view);
            setViewVisibility(configureEnteringExitingViews2, 4);
            Object mergeTransitions = mergeTransitions(chooseImpl, enterTransition, obj, configureSharedElementsReordered, fragment, z);
            if (fragment2 != null && configureEnteringExitingViews != null && (configureEnteringExitingViews.size() > 0 || arrayList2.size() > 0)) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                callback.onStart(fragment2, cancellationSignal);
                chooseImpl.setListenerForTransitionEnd(fragment2, mergeTransitions, cancellationSignal, new Runnable(callback, fragment2, cancellationSignal) { // from class: androidx.fragment.app.FragmentTransition.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Callback val$callback;
                    public final /* synthetic */ Fragment val$outFragment;
                    public final /* synthetic */ CancellationSignal val$signal;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {callback, fragment2, cancellationSignal};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$callback = callback;
                        this.val$outFragment = fragment2;
                        this.val$signal = cancellationSignal;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$callback.onComplete(this.val$outFragment, this.val$signal);
                        }
                    }
                });
            }
            if (mergeTransitions != null) {
                replaceHide(chooseImpl, obj, fragment2, configureEnteringExitingViews);
                ArrayList<String> prepareSetNameOverridesReordered = chooseImpl.prepareSetNameOverridesReordered(arrayList);
                chooseImpl.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, obj, configureEnteringExitingViews, configureSharedElementsReordered, arrayList);
                chooseImpl.beginDelayedTransition(viewGroup, mergeTransitions);
                chooseImpl.setNameOverridesReordered(viewGroup, arrayList2, arrayList, prepareSetNameOverridesReordered, arrayMap);
                setViewVisibility(configureEnteringExitingViews2, 0);
                chooseImpl.swapSharedElementTargets(configureSharedElementsReordered, arrayList2, arrayList);
            }
        }
    }

    public static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65553, null, fragmentContainerTransition, sparseArray, i2)) == null) {
            if (fragmentContainerTransition == null) {
                FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
                sparseArray.put(i2, fragmentContainerTransition2);
                return fragmentContainerTransition2;
            }
            return fragmentContainerTransition;
        }
        return (FragmentContainerTransition) invokeLLI.objValue;
    }

    public static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, arrayMap, str)) == null) {
            int size = arrayMap.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (str.equals(arrayMap.valueAt(i2))) {
                    return arrayMap.keyAt(i2);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Object enterTransition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65555, null, fragmentTransitionImpl, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            if (z) {
                enterTransition = fragment.getReenterTransition();
            } else {
                enterTransition = fragment.getEnterTransition();
            }
            return fragmentTransitionImpl.cloneTransition(enterTransition);
        }
        return invokeLLZ.objValue;
    }

    public static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        InterceptResult invokeLLZ;
        Object exitTransition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65556, null, fragmentTransitionImpl, fragment, z)) == null) {
            if (fragment == null) {
                return null;
            }
            if (z) {
                exitTransition = fragment.getReturnTransition();
            } else {
                exitTransition = fragment.getExitTransition();
            }
            return fragmentTransitionImpl.cloneTransition(exitTransition);
        }
        return invokeLLZ.objValue;
    }

    public static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        InterceptResult invokeCommon;
        ArrayList<String> arrayList;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{arrayMap, fragmentContainerTransition, obj, Boolean.valueOf(z)})) == null) {
            BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
            if (obj == null || arrayMap == null || (arrayList = backStackRecord.mSharedElementSourceNames) == null || arrayList.isEmpty()) {
                return null;
            }
            if (z) {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            } else {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            }
            return arrayMap.get(str);
        }
        return (View) invokeCommon.objValue;
    }

    public static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        InterceptResult invokeCommon;
        Object sharedElementEnterTransition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{fragmentTransitionImpl, fragment, fragment2, Boolean.valueOf(z)})) == null) {
            if (fragment == null || fragment2 == null) {
                return null;
            }
            if (z) {
                sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
            } else {
                sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
            }
            return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(sharedElementEnterTransition));
        }
        return invokeCommon.objValue;
    }

    public static Object mergeTransitions(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{fragmentTransitionImpl, obj, obj2, obj3, fragment, Boolean.valueOf(z)})) == null) {
            if (obj == null || obj2 == null || fragment == null) {
                z2 = true;
            } else if (z) {
                z2 = fragment.getAllowReturnTransitionOverlap();
            } else {
                z2 = fragment.getAllowEnterTransitionOverlap();
            }
            if (z2) {
                return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
            }
            return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
        }
        return invokeCommon.objValue;
    }

    public static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65560, null, fragmentTransitionImpl, obj, fragment, arrayList) == null) && fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable(arrayList) { // from class: androidx.fragment.app.FragmentTransition.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayList val$exitingViews;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$exitingViews = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FragmentTransition.setViewVisibility(this.val$exitingViews, 4);
                    }
                }
            });
        }
    }

    public static FragmentTransitionImpl resolveSupportImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return (FragmentTransitionImpl) invokeV.objValue;
    }

    public static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, arrayMap, arrayMap2) == null) {
            for (int size = arrayMap.size() - 1; size >= 0; size--) {
                if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                    arrayMap.removeAt(size);
                }
            }
        }
    }

    public static void scheduleTargetChange(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{fragmentTransitionImpl, viewGroup, fragment, view, arrayList, obj, arrayList2, obj2, arrayList3}) == null) {
            OneShotPreDrawListener.add(viewGroup, new Runnable(obj, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, obj2) { // from class: androidx.fragment.app.FragmentTransition.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Object val$enterTransition;
                public final /* synthetic */ ArrayList val$enteringViews;
                public final /* synthetic */ Object val$exitTransition;
                public final /* synthetic */ ArrayList val$exitingViews;
                public final /* synthetic */ FragmentTransitionImpl val$impl;
                public final /* synthetic */ Fragment val$inFragment;
                public final /* synthetic */ View val$nonExistentView;
                public final /* synthetic */ ArrayList val$sharedElementsIn;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {obj, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, obj2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$enterTransition = obj;
                    this.val$impl = fragmentTransitionImpl;
                    this.val$nonExistentView = view;
                    this.val$inFragment = fragment;
                    this.val$sharedElementsIn = arrayList;
                    this.val$enteringViews = arrayList2;
                    this.val$exitingViews = arrayList3;
                    this.val$exitTransition = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Object obj3 = this.val$enterTransition;
                        if (obj3 != null) {
                            this.val$impl.removeTarget(obj3, this.val$nonExistentView);
                            this.val$enteringViews.addAll(FragmentTransition.configureEnteringExitingViews(this.val$impl, this.val$enterTransition, this.val$inFragment, this.val$sharedElementsIn, this.val$nonExistentView));
                        }
                        if (this.val$exitingViews != null) {
                            if (this.val$exitTransition != null) {
                                ArrayList<View> arrayList4 = new ArrayList<>();
                                arrayList4.add(this.val$nonExistentView);
                                this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, arrayList4);
                            }
                            this.val$exitingViews.clear();
                            this.val$exitingViews.add(this.val$nonExistentView);
                        }
                    }
                }
            });
        }
    }

    public static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        ArrayList<String> arrayList;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{fragmentTransitionImpl, obj, obj2, arrayMap, Boolean.valueOf(z), backStackRecord}) == null) || (arrayList = backStackRecord.mSharedElementSourceNames) == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = backStackRecord.mSharedElementTargetNames.get(0);
        } else {
            str = backStackRecord.mSharedElementSourceNames.get(0);
        }
        View view = arrayMap.get(str);
        fragmentTransitionImpl.setEpicenter(obj, view);
        if (obj2 != null) {
            fragmentTransitionImpl.setEpicenter(obj2, view);
        }
    }

    public static void setViewVisibility(ArrayList<View> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65565, null, arrayList, i2) == null) || arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    public static void startTransitions(FragmentManager fragmentManager, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z, Callback callback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{fragmentManager, arrayList, arrayList2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), callback}) == null) || fragmentManager.mCurState < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                calculatePopFragments(backStackRecord, sparseArray, z);
            } else {
                calculateFragments(backStackRecord, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(fragmentManager.mHost.getContext());
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                ArrayMap<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i2, i3);
                FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i5);
                if (z) {
                    configureTransitionsReordered(fragmentManager, keyAt, fragmentContainerTransition, view, calculateNameOverrides, callback);
                } else {
                    configureTransitionsOrdered(fragmentManager, keyAt, fragmentContainerTransition, view, calculateNameOverrides, callback);
                }
            }
        }
    }

    public static boolean supportsTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true : invokeV.booleanValue;
    }
}
