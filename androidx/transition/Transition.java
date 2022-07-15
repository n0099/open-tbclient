package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DBG = false;
    public static final int[] DEFAULT_MATCH_ORDER;
    public static final String LOG_TAG = "Transition";
    public static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    public static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    public static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    public static final String MATCH_ITEM_ID_STR = "itemId";
    public static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    public static final String MATCH_NAME_STR = "name";
    public static final PathMotion STRAIGHT_PATH_MOTION;
    public static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Animator> mAnimators;
    public boolean mCanRemoveViews;
    public ArrayList<Animator> mCurrentAnimators;
    public long mDuration;
    public TransitionValuesMaps mEndValues;
    public ArrayList<TransitionValues> mEndValuesList;
    public boolean mEnded;
    public EpicenterCallback mEpicenterCallback;
    public TimeInterpolator mInterpolator;
    public ArrayList<TransitionListener> mListeners;
    public int[] mMatchOrder;
    public String mName;
    public ArrayMap<String, String> mNameOverrides;
    public int mNumInstances;
    public TransitionSet mParent;
    public PathMotion mPathMotion;
    public boolean mPaused;
    public TransitionPropagation mPropagation;
    public ViewGroup mSceneRoot;
    public long mStartDelay;
    public TransitionValuesMaps mStartValues;
    public ArrayList<TransitionValues> mStartValuesList;
    public ArrayList<View> mTargetChildExcludes;
    public ArrayList<View> mTargetExcludes;
    public ArrayList<Integer> mTargetIdChildExcludes;
    public ArrayList<Integer> mTargetIdExcludes;
    public ArrayList<Integer> mTargetIds;
    public ArrayList<String> mTargetNameExcludes;
    public ArrayList<String> mTargetNames;
    public ArrayList<Class<?>> mTargetTypeChildExcludes;
    public ArrayList<Class<?>> mTargetTypeExcludes;
    public ArrayList<Class<?>> mTargetTypes;
    public ArrayList<View> mTargets;

    /* loaded from: classes.dex */
    public static class AnimationInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mName;
        public Transition mTransition;
        public TransitionValues mValues;
        public View mView;
        public WindowIdImpl mWindowId;

        public AnimationInfo(View view2, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, str, transition, windowIdImpl, transitionValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mView = view2;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowIdImpl;
            this.mTransition = transition;
        }
    }

    /* loaded from: classes.dex */
    public static class ArrayListManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ArrayListManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, arrayList, t)) == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.contains(t)) {
                    arrayList.add(t);
                }
                return arrayList;
            }
            return (ArrayList) invokeLL.objValue;
        }

        public static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, t)) == null) {
                if (arrayList != null) {
                    arrayList.remove(t);
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return arrayList;
                }
                return arrayList;
            }
            return (ArrayList) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class EpicenterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EpicenterCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface MatchOrder {
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-214236474, "Landroidx/transition/Transition;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-214236474, "Landroidx/transition/Transition;");
                return;
            }
        }
        DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        STRAIGHT_PATH_MOTION = new PathMotion() { // from class: androidx.transition.Transition.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // androidx.transition.PathMotion
            public Path getPath(float f, float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                    Path path = new Path();
                    path.moveTo(f, f2);
                    path.lineTo(f3, f4);
                    return path;
                }
                return (Path) invokeCommon.objValue;
            }
        };
        sRunningAnimators = new ThreadLocal<>();
    }

    public Transition() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mName = getClass().getName();
        this.mStartDelay = -1L;
        this.mDuration = -1L;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList<>();
        this.mTargets = new ArrayList<>();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList<>();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList<>();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, arrayMap, arrayMap2) == null) {
            for (int i = 0; i < arrayMap.size(); i++) {
                TransitionValues valueAt = arrayMap.valueAt(i);
                if (isValidTarget(valueAt.f1747view)) {
                    this.mStartValuesList.add(valueAt);
                    this.mEndValuesList.add(null);
                }
            }
            for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
                TransitionValues valueAt2 = arrayMap2.valueAt(i2);
                if (isValidTarget(valueAt2.f1747view)) {
                    this.mEndValuesList.add(valueAt2);
                    this.mStartValuesList.add(null);
                }
            }
        }
    }

    public static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view2, TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, transitionValuesMaps, view2, transitionValues) == null) {
            transitionValuesMaps.mViewValues.put(view2, transitionValues);
            int id = view2.getId();
            if (id >= 0) {
                if (transitionValuesMaps.mIdValues.indexOfKey(id) >= 0) {
                    transitionValuesMaps.mIdValues.put(id, null);
                } else {
                    transitionValuesMaps.mIdValues.put(id, view2);
                }
            }
            String transitionName = ViewCompat.getTransitionName(view2);
            if (transitionName != null) {
                if (transitionValuesMaps.mNameValues.containsKey(transitionName)) {
                    transitionValuesMaps.mNameValues.put(transitionName, null);
                } else {
                    transitionValuesMaps.mNameValues.put(transitionName, view2);
                }
            }
            if (view2.getParent() instanceof ListView) {
                ListView listView = (ListView) view2.getParent();
                if (listView.getAdapter().hasStableIds()) {
                    long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view2));
                    if (transitionValuesMaps.mItemIdValues.indexOfKey(itemIdAtPosition) >= 0) {
                        View view3 = transitionValuesMaps.mItemIdValues.get(itemIdAtPosition);
                        if (view3 != null) {
                            ViewCompat.setHasTransientState(view3, false);
                            transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, null);
                            return;
                        }
                        return;
                    }
                    ViewCompat.setHasTransientState(view2, true);
                    transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, view2);
                }
            }
        }
    }

    public static boolean alreadyContains(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, iArr, i)) == null) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < i; i3++) {
                if (iArr[i3] == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private void captureHierarchy(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65542, this, view2, z) == null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view2)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view2)) {
                            return;
                        }
                    }
                }
                if (view2.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues(view2);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, view2, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, view2, transitionValues);
                    }
                }
                if (view2 instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view2)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view2)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view2;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{arrayList, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i > 0) {
                if (z) {
                    return ArrayListManager.add(arrayList, Integer.valueOf(i));
                }
                return ArrayListManager.remove(arrayList, Integer.valueOf(i));
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, arrayList, t, z)) == null) {
            if (t != null) {
                if (z) {
                    return ArrayListManager.add(arrayList, t);
                }
                return ArrayListManager.remove(arrayList, t);
            }
            return arrayList;
        }
        return (ArrayList) invokeLLZ.objValue;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, this, arrayList, cls, z)) == null) {
            if (cls != null) {
                if (z) {
                    return ArrayListManager.add(arrayList, cls);
                }
                return ArrayListManager.remove(arrayList, cls);
            }
            return arrayList;
        }
        return (ArrayList) invokeLLZ.objValue;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, this, arrayList, view2, z)) == null) {
            if (view2 != null) {
                if (z) {
                    return ArrayListManager.add(arrayList, view2);
                }
                return ArrayListManager.remove(arrayList, view2);
            }
            return arrayList;
        }
        return (ArrayList) invokeLLZ.objValue;
    }

    public static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
            if (arrayMap == null) {
                ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
                sRunningAnimators.set(arrayMap2);
                return arrayMap2;
            }
            return arrayMap;
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static boolean isValidMatch(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) ? i >= 1 && i <= 4 : invokeI.booleanValue;
    }

    public static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, transitionValues, transitionValues2, str)) == null) {
            Object obj = transitionValues.values.get(str);
            Object obj2 = transitionValues2.values.get(str);
            if (obj == null && obj2 == null) {
                return false;
            }
            if (obj == null || obj2 == null) {
                return true;
            }
            return true ^ obj.equals(obj2);
        }
        return invokeLLL.booleanValue;
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, this, arrayMap, arrayMap2, sparseArray, sparseArray2) == null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null && isValidTarget(valueAt) && (view2 = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view2)) {
                    TransitionValues transitionValues = arrayMap.get(valueAt);
                    TransitionValues transitionValues2 = arrayMap2.get(view2);
                    if (transitionValues != null && transitionValues2 != null) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(valueAt);
                        arrayMap2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, arrayMap, arrayMap2) == null) {
            for (int size = arrayMap.size() - 1; size >= 0; size--) {
                View keyAt = arrayMap.keyAt(size);
                if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.f1747view)) {
                    this.mStartValuesList.add(arrayMap.removeAt(size));
                    this.mEndValuesList.add(remove);
                }
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, this, arrayMap, arrayMap2, longSparseArray, longSparseArray2) == null) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = longSparseArray.valueAt(i);
                if (valueAt != null && isValidTarget(valueAt) && (view2 = longSparseArray2.get(longSparseArray.keyAt(i))) != null && isValidTarget(view2)) {
                    TransitionValues transitionValues = arrayMap.get(valueAt);
                    TransitionValues transitionValues2 = arrayMap2.get(view2);
                    if (transitionValues != null && transitionValues2 != null) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(valueAt);
                        arrayMap2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, this, arrayMap, arrayMap2, arrayMap3, arrayMap4) == null) {
            int size = arrayMap3.size();
            for (int i = 0; i < size; i++) {
                View valueAt = arrayMap3.valueAt(i);
                if (valueAt != null && isValidTarget(valueAt) && (view2 = arrayMap4.get(arrayMap3.keyAt(i))) != null && isValidTarget(view2)) {
                    TransitionValues transitionValues = arrayMap.get(valueAt);
                    TransitionValues transitionValues2 = arrayMap2.get(view2);
                    if (transitionValues != null && transitionValues2 != null) {
                        this.mStartValuesList.add(transitionValues);
                        this.mEndValuesList.add(transitionValues2);
                        arrayMap.remove(valueAt);
                        arrayMap2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65554, this, transitionValuesMaps, transitionValuesMaps2) != null) {
            return;
        }
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.mViewValues);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.mViewValues);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.mNameValues, transitionValuesMaps2.mNameValues);
                } else if (i2 == 3) {
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.mIdValues, transitionValuesMaps2.mIdValues);
                } else if (i2 == 4) {
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.mItemIdValues, transitionValuesMaps2.mItemIdValues);
                }
                i++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    public static int[] parseMatchOrder(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            int[] iArr = new int[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if ("id".equalsIgnoreCase(trim)) {
                    iArr[i] = 3;
                } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                    iArr[i] = 1;
                } else if ("name".equalsIgnoreCase(trim)) {
                    iArr[i] = 2;
                } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                    iArr[i] = 4;
                } else if (trim.isEmpty()) {
                    int[] iArr2 = new int[iArr.length - 1];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    i--;
                    iArr = iArr2;
                } else {
                    throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
                }
                i++;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    private void runAnimator(Animator animator, ArrayMap<Animator, AnimationInfo> arrayMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, this, animator, arrayMap) == null) || animator == null) {
            return;
        }
        animator.addListener(new AnimatorListenerAdapter(this, arrayMap) { // from class: androidx.transition.Transition.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Transition this$0;
            public final /* synthetic */ ArrayMap val$runningAnimators;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, arrayMap};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$runningAnimators = arrayMap;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                    this.val$runningAnimators.remove(animator2);
                    this.this$0.mCurrentAnimators.remove(animator2);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator2) == null) {
                    this.this$0.mCurrentAnimators.add(animator2);
                }
            }
        });
        animate(animator);
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, transitionListener)) == null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList<>();
            }
            this.mListeners.add(transitionListener);
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @NonNull
    public Transition addTarget(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            this.mTargets.add(view2);
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animator) == null) {
            if (animator == null) {
                end();
                return;
            }
            if (getDuration() >= 0) {
                animator.setDuration(getDuration());
            }
            if (getStartDelay() >= 0) {
                animator.setStartDelay(getStartDelay() + animator.getStartDelay());
            }
            if (getInterpolator() != null) {
                animator.setInterpolator(getInterpolator());
            }
            animator.addListener(new AnimatorListenerAdapter(this) { // from class: androidx.transition.Transition.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Transition this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                        this.this$0.end();
                        animator2.removeListener(this);
                    }
                }
            });
            animator.start();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
                this.mCurrentAnimators.get(size).cancel();
            }
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList2.get(i)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, transitionValues) == null) || this.mPropagation == null || transitionValues.values.isEmpty() || (propagationProperties = this.mPropagation.getPropagationProperties()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= propagationProperties.length) {
                z = true;
                break;
            } else if (!transitionValues.values.containsKey(propagationProperties[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.captureValues(transitionValues);
    }

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ArrayMap<String, String> arrayMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, viewGroup, z) == null) {
            clearValues(z);
            if ((this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) || (((arrayList = this.mTargetNames) != null && !arrayList.isEmpty()) || ((arrayList2 = this.mTargetTypes) != null && !arrayList2.isEmpty()))) {
                captureHierarchy(viewGroup, z);
            } else {
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                    if (findViewById != null) {
                        TransitionValues transitionValues = new TransitionValues(findViewById);
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.mTargetedTransitions.add(this);
                        capturePropagationValues(transitionValues);
                        if (z) {
                            addViewValues(this.mStartValues, findViewById, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, findViewById, transitionValues);
                        }
                    }
                }
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    View view2 = this.mTargets.get(i2);
                    TransitionValues transitionValues2 = new TransitionValues(view2);
                    if (z) {
                        captureStartValues(transitionValues2);
                    } else {
                        captureEndValues(transitionValues2);
                    }
                    transitionValues2.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues2);
                    if (z) {
                        addViewValues(this.mStartValues, view2, transitionValues2);
                    } else {
                        addViewValues(this.mEndValues, view2, transitionValues2);
                    }
                }
            }
            if (z || (arrayMap = this.mNameOverrides) == null) {
                return;
            }
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = (View) arrayList3.get(i4);
                if (view3 != null) {
                    this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(i4), view3);
                }
            }
        }
    }

    public void clearValues(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.mStartValues.mViewValues.clear();
                this.mStartValues.mIdValues.clear();
                this.mStartValues.mItemIdValues.clear();
                return;
            }
            this.mEndValues.mViewValues.clear();
            this.mEndValues.mIdValues.clear();
            this.mEndValues.mItemIdValues.clear();
        }
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, viewGroup, transitionValues, transitionValues2)) == null) {
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Animator createAnimator;
        int i;
        int i2;
        View view2;
        Animator animator;
        TransitionValues transitionValues;
        Animator animator2;
        TransitionValues transitionValues2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048591, this, viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2) == null) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            SparseIntArray sparseIntArray = new SparseIntArray();
            int size = arrayList.size();
            long j = Long.MAX_VALUE;
            int i3 = 0;
            while (i3 < size) {
                TransitionValues transitionValues3 = arrayList.get(i3);
                TransitionValues transitionValues4 = arrayList2.get(i3);
                if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                    transitionValues3 = null;
                }
                if (transitionValues4 != null && !transitionValues4.mTargetedTransitions.contains(this)) {
                    transitionValues4 = null;
                }
                if (transitionValues3 != null || transitionValues4 != null) {
                    if ((transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) && (createAnimator = createAnimator(viewGroup, transitionValues3, transitionValues4)) != null) {
                        if (transitionValues4 != null) {
                            view2 = transitionValues4.f1747view;
                            String[] transitionProperties = getTransitionProperties();
                            if (transitionProperties != null && transitionProperties.length > 0) {
                                transitionValues2 = new TransitionValues(view2);
                                i = size;
                                TransitionValues transitionValues5 = transitionValuesMaps2.mViewValues.get(view2);
                                if (transitionValues5 != null) {
                                    int i4 = 0;
                                    while (i4 < transitionProperties.length) {
                                        transitionValues2.values.put(transitionProperties[i4], transitionValues5.values.get(transitionProperties[i4]));
                                        i4++;
                                        i3 = i3;
                                        transitionValues5 = transitionValues5;
                                    }
                                }
                                i2 = i3;
                                int size2 = runningAnimators.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size2) {
                                        animator2 = createAnimator;
                                        break;
                                    }
                                    AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(i5));
                                    if (animationInfo.mValues != null && animationInfo.mView == view2 && animationInfo.mName.equals(getName()) && animationInfo.mValues.equals(transitionValues2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                i = size;
                                i2 = i3;
                                animator2 = createAnimator;
                                transitionValues2 = null;
                            }
                            animator = animator2;
                            transitionValues = transitionValues2;
                        } else {
                            i = size;
                            i2 = i3;
                            view2 = transitionValues3.f1747view;
                            animator = createAnimator;
                            transitionValues = null;
                        }
                        if (animator != null) {
                            TransitionPropagation transitionPropagation = this.mPropagation;
                            if (transitionPropagation != null) {
                                long startDelay = transitionPropagation.getStartDelay(viewGroup, this, transitionValues3, transitionValues4);
                                sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                                j = Math.min(startDelay, j);
                            }
                            runningAnimators.put(animator, new AnimationInfo(view2, getName(), this, ViewUtils.getWindowId(viewGroup), transitionValues));
                            this.mAnimators.add(animator);
                            j = j;
                        }
                        i3 = i2 + 1;
                        size = i;
                    }
                }
                i = size;
                i2 = i3;
                i3 = i2 + 1;
                size = i;
            }
            if (sparseIntArray.size() != 0) {
                for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                    Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                    animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int i = this.mNumInstances - 1;
            this.mNumInstances = i;
            if (i == 0) {
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((TransitionListener) arrayList2.get(i2)).onTransitionEnd(this);
                    }
                }
                for (int i3 = 0; i3 < this.mStartValues.mItemIdValues.size(); i3++) {
                    View valueAt = this.mStartValues.mItemIdValues.valueAt(i3);
                    if (valueAt != null) {
                        ViewCompat.setHasTransientState(valueAt, false);
                    }
                }
                for (int i4 = 0; i4 < this.mEndValues.mItemIdValues.size(); i4++) {
                    View valueAt2 = this.mEndValues.mItemIdValues.valueAt(i4);
                    if (valueAt2 != null) {
                        ViewCompat.setHasTransientState(valueAt2, false);
                    }
                }
                this.mEnded = true;
            }
        }
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, view2, z)) == null) {
            this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view2, z);
            return this;
        }
        return (Transition) invokeLZ.objValue;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, view2, z)) == null) {
            this.mTargetExcludes = excludeView(this.mTargetExcludes, view2, z);
            return this;
        }
        return (Transition) invokeLZ.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, viewGroup) == null) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            if (viewGroup == null || size == 0) {
                return;
            }
            WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
            ArrayMap arrayMap = new ArrayMap(runningAnimators);
            runningAnimators.clear();
            for (int i = size - 1; i >= 0; i--) {
                AnimationInfo animationInfo = (AnimationInfo) arrayMap.valueAt(i);
                if (animationInfo.mView != null && windowId != null && windowId.equals(animationInfo.mWindowId)) {
                    ((Animator) arrayMap.keyAt(i)).end();
                }
            }
        }
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mDuration : invokeV.longValue;
    }

    @Nullable
    public Rect getEpicenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            EpicenterCallback epicenterCallback = this.mEpicenterCallback;
            if (epicenterCallback == null) {
                return null;
            }
            return epicenterCallback.onGetEpicenter(this);
        }
        return (Rect) invokeV.objValue;
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mEpicenterCallback : (EpicenterCallback) invokeV.objValue;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mInterpolator : (TimeInterpolator) invokeV.objValue;
    }

    public TransitionValues getMatchedTransitionValues(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048605, this, view2, z)) == null) {
            TransitionSet transitionSet = this.mParent;
            if (transitionSet != null) {
                return transitionSet.getMatchedTransitionValues(view2, z);
            }
            ArrayList<TransitionValues> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                TransitionValues transitionValues = arrayList.get(i2);
                if (transitionValues == null) {
                    return null;
                }
                if (transitionValues.f1747view == view2) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
            }
            return null;
        }
        return (TransitionValues) invokeLZ.objValue;
    }

    @NonNull
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mName : (String) invokeV.objValue;
    }

    @NonNull
    public PathMotion getPathMotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mPathMotion : (PathMotion) invokeV.objValue;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPropagation : (TransitionPropagation) invokeV.objValue;
    }

    public long getStartDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mStartDelay : invokeV.longValue;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mTargetIds : (List) invokeV.objValue;
    }

    @Nullable
    public List<String> getTargetNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mTargetNames : (List) invokeV.objValue;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mTargetTypes : (List) invokeV.objValue;
    }

    @NonNull
    public List<View> getTargets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mTargets : (List) invokeV.objValue;
    }

    @Nullable
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048615, this, view2, z)) == null) {
            TransitionSet transitionSet = this.mParent;
            if (transitionSet != null) {
                return transitionSet.getTransitionValues(view2, z);
            }
            return (z ? this.mStartValues : this.mEndValues).mViewValues.get(view2);
        }
        return (TransitionValues) invokeLZ.objValue;
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null || transitionValues2 == null) {
                return false;
            }
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String str : transitionProperties) {
                    if (!isValueChanged(transitionValues, transitionValues2, str)) {
                    }
                }
                return false;
            }
            for (String str2 : transitionValues.values.keySet()) {
                if (isValueChanged(transitionValues, transitionValues2, str2)) {
                }
            }
            return false;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isValidTarget(View view2) {
        InterceptResult invokeL;
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, view2)) == null) {
            int id = view2.getId();
            ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
            if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList4 = this.mTargetExcludes;
                if (arrayList4 == null || !arrayList4.contains(view2)) {
                    ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
                    if (arrayList5 != null) {
                        int size = arrayList5.size();
                        for (int i = 0; i < size; i++) {
                            if (this.mTargetTypeExcludes.get(i).isInstance(view2)) {
                                return false;
                            }
                        }
                    }
                    if (this.mTargetNameExcludes == null || ViewCompat.getTransitionName(view2) == null || !this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view2))) {
                        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view2)) {
                            return true;
                        }
                        ArrayList<String> arrayList6 = this.mTargetNames;
                        if (arrayList6 == null || !arrayList6.contains(ViewCompat.getTransitionName(view2))) {
                            if (this.mTargetTypes != null) {
                                for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                                    if (this.mTargetTypes.get(i2).isInstance(view2)) {
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, view2) == null) || this.mEnded) {
            return;
        }
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        WindowIdImpl windowId = ViewUtils.getWindowId(view2);
        for (int i = size - 1; i >= 0; i--) {
            AnimationInfo valueAt = runningAnimators.valueAt(i);
            if (valueAt.mView != null && windowId.equals(valueAt.mWindowId)) {
                AnimatorUtils.pause(runningAnimators.keyAt(i));
            }
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((TransitionListener) arrayList2.get(i2)).onTransitionPause(this);
            }
        }
        this.mPaused = true;
    }

    public void playTransition(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, viewGroup) == null) {
            this.mStartValuesList = new ArrayList<>();
            this.mEndValuesList = new ArrayList<>();
            matchStartAndEnd(this.mStartValues, this.mEndValues);
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            WindowIdImpl windowId = ViewUtils.getWindowId(viewGroup);
            for (int i = size - 1; i >= 0; i--) {
                Animator keyAt = runningAnimators.keyAt(i);
                if (keyAt != null && (animationInfo = runningAnimators.get(keyAt)) != null && animationInfo.mView != null && windowId.equals(animationInfo.mWindowId)) {
                    TransitionValues transitionValues = animationInfo.mValues;
                    View view2 = animationInfo.mView;
                    TransitionValues transitionValues2 = getTransitionValues(view2, true);
                    TransitionValues matchedTransitionValues = getMatchedTransitionValues(view2, true);
                    if (transitionValues2 == null && matchedTransitionValues == null) {
                        matchedTransitionValues = this.mEndValues.mViewValues.get(view2);
                    }
                    if (!(transitionValues2 == null && matchedTransitionValues == null) && animationInfo.mTransition.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                        if (!keyAt.isRunning() && !keyAt.isStarted()) {
                            runningAnimators.remove(keyAt);
                        } else {
                            keyAt.cancel();
                        }
                    }
                }
            }
            createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
            runAnimators();
        }
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, transitionListener)) == null) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList == null) {
                return this;
            }
            arrayList.remove(transitionListener);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, view2)) == null) {
            this.mTargets.remove(view2);
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, view2) == null) && this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                WindowIdImpl windowId = ViewUtils.getWindowId(view2);
                for (int i = size - 1; i >= 0; i--) {
                    AnimationInfo valueAt = runningAnimators.valueAt(i);
                    if (valueAt.mView != null && windowId.equals(valueAt.mWindowId)) {
                        AnimatorUtils.resume(runningAnimators.keyAt(i));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList2.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
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
    }

    public void setCanRemoveViews(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.mCanRemoveViews = z;
        }
    }

    @NonNull
    public Transition setDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048628, this, j)) == null) {
            this.mDuration = j;
            return this;
        }
        return (Transition) invokeJ.objValue;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, epicenterCallback) == null) {
            this.mEpicenterCallback = epicenterCallback;
        }
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, timeInterpolator)) == null) {
            this.mInterpolator = timeInterpolator;
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    public void setMatchOrder(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                for (int i = 0; i < iArr.length; i++) {
                    if (isValidMatch(iArr[i])) {
                        if (alreadyContains(iArr, i)) {
                            throw new IllegalArgumentException("matches contains a duplicate value");
                        }
                    } else {
                        throw new IllegalArgumentException("matches contains invalid value");
                    }
                }
                this.mMatchOrder = (int[]) iArr.clone();
                return;
            }
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
        }
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, pathMotion) == null) {
            if (pathMotion == null) {
                this.mPathMotion = STRAIGHT_PATH_MOTION;
            } else {
                this.mPathMotion = pathMotion;
            }
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, transitionPropagation) == null) {
            this.mPropagation = transitionPropagation;
        }
    }

    public Transition setSceneRoot(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, viewGroup)) == null) {
            this.mSceneRoot = viewGroup;
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @NonNull
    public Transition setStartDelay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048635, this, j)) == null) {
            this.mStartDelay = j;
            return this;
        }
        return (Transition) invokeJ.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (this.mNumInstances == 0) {
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        ((TransitionListener) arrayList2.get(i)).onTransitionStart(this);
                    }
                }
                this.mEnded = false;
            }
            this.mNumInstances++;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? toString("") : (String) invokeV.objValue;
    }

    @NonNull
    public Transition addTarget(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i != 0) {
                this.mTargetIds.add(Integer.valueOf(i));
            }
            return this;
        }
        return (Transition) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Transition m5clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            try {
                Transition transition = (Transition) super.clone();
                transition.mAnimators = new ArrayList<>();
                transition.mStartValues = new TransitionValuesMaps();
                transition.mEndValues = new TransitionValuesMaps();
                transition.mStartValuesList = null;
                transition.mEndValuesList = null;
                return transition;
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
        return (Transition) invokeV.objValue;
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
            return this;
        }
        return (Transition) invokeCommon.objValue;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
            return this;
        }
        return (Transition) invokeCommon.objValue;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
            if (i != 0) {
                this.mTargetIds.remove(Integer.valueOf(i));
            }
            return this;
        }
        return (Transition) invokeI.objValue;
    }

    public String toString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
            String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
            if (this.mDuration != -1) {
                str2 = str2 + "dur(" + this.mDuration + ") ";
            }
            if (this.mStartDelay != -1) {
                str2 = str2 + "dly(" + this.mStartDelay + ") ";
            }
            if (this.mInterpolator != null) {
                str2 = str2 + "interp(" + this.mInterpolator + ") ";
            }
            if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
                String str3 = str2 + "tgts(";
                if (this.mTargetIds.size() > 0) {
                    for (int i = 0; i < this.mTargetIds.size(); i++) {
                        if (i > 0) {
                            str3 = str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR;
                        }
                        str3 = str3 + this.mTargetIds.get(i);
                    }
                }
                if (this.mTargets.size() > 0) {
                    for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                        if (i2 > 0) {
                            str3 = str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR;
                        }
                        str3 = str3 + this.mTargets.get(i2);
                    }
                }
                return str3 + SmallTailInfo.EMOTION_SUFFIX;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.mTargetNames == null) {
                this.mTargetNames = new ArrayList<>();
            }
            this.mTargetNames.add(str);
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048595, this, cls, z)) == null) {
            this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
            return this;
        }
        return (Transition) invokeLZ.objValue;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, str, z)) == null) {
            this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
            return this;
        }
        return (Transition) invokeLZ.objValue;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            ArrayList<String> arrayList = this.mTargetNames;
            if (arrayList != null) {
                arrayList.remove(str);
            }
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, cls, z)) == null) {
            this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
            return this;
        }
        return (Transition) invokeLZ.objValue;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, cls)) == null) {
            ArrayList<Class<?>> arrayList = this.mTargetTypes;
            if (arrayList != null) {
                arrayList.remove(cls);
            }
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            if (this.mTargetTypes == null) {
                this.mTargetTypes = new ArrayList<>();
            }
            this.mTargetTypes.add(cls);
            return this;
        }
        return (Transition) invokeL.objValue;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mName = getClass().getName();
        this.mStartDelay = -1L;
        this.mDuration = -1L;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList<>();
        this.mTargets = new ArrayList<>();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList<>();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList<>();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }
}
