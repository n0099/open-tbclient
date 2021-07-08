package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FragmentTransitionImpl() {
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

    public static void bfsAddViewChildren(List<View> list, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, view) == null) {
            int size = list.size();
            if (containedBeforeIndex(list, view, size)) {
                return;
            }
            list.add(view);
            for (int i2 = size; i2 < list.size(); i2++) {
                View view2 = list.get(i2);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (!containedBeforeIndex(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static boolean containedBeforeIndex(List<View> list, View view, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, list, view, i2)) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (list.get(i3) == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static String findKeyForValue(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, str)) == null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (str.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isNullOrEmpty(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) ? list == null || list.isEmpty() : invokeL.booleanValue;
    }

    public abstract void addTarget(Object obj, View view);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, view) == null) && view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    captureTransitioningViews(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public abstract Object cloneTransition(Object obj);

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, map, view) == null) && view.getVisibility() == 0) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    findNamedViews(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public void getBoundsOnScreen(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, rect) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        }
    }

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    public ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                arrayList2.add(ViewCompat.getTransitionName(view));
                ViewCompat.setTransitionName(view, null);
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public abstract void removeTarget(Object obj, View view);

    public abstract void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList);

    public void scheduleNameReset(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, viewGroup, arrayList, map) == null) {
            OneShotPreDrawListener.add(viewGroup, new Runnable(this, arrayList, map) { // from class: androidx.fragment.app.FragmentTransitionImpl.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentTransitionImpl this$0;
                public final /* synthetic */ Map val$nameOverrides;
                public final /* synthetic */ ArrayList val$sharedElementsIn;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sharedElementsIn = arrayList;
                    this.val$nameOverrides = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int size = this.val$sharedElementsIn.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            View view = (View) this.val$sharedElementsIn.get(i2);
                            ViewCompat.setTransitionName(view, (String) this.val$nameOverrides.get(ViewCompat.getTransitionName(view)));
                        }
                    }
                }
            });
        }
    }

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(Object obj, Rect rect);

    public abstract void setEpicenter(Object obj, View view);

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, fragment, obj, cancellationSignal, runnable) == null) {
            runnable.run();
        }
    }

    public void setNameOverridesOrdered(View view, ArrayList<View> arrayList, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, view, arrayList, map) == null) {
            OneShotPreDrawListener.add(view, new Runnable(this, arrayList, map) { // from class: androidx.fragment.app.FragmentTransitionImpl.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentTransitionImpl this$0;
                public final /* synthetic */ Map val$nameOverrides;
                public final /* synthetic */ ArrayList val$sharedElementsIn;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sharedElementsIn = arrayList;
                    this.val$nameOverrides = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int size = this.val$sharedElementsIn.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            View view2 = (View) this.val$sharedElementsIn.get(i2);
                            String transitionName = ViewCompat.getTransitionName(view2);
                            if (transitionName != null) {
                                ViewCompat.setTransitionName(view2, FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, transitionName));
                            }
                        }
                    }
                }
            });
        }
    }

    public void setNameOverridesReordered(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048596, this, view, arrayList, arrayList2, arrayList3, map) == null) {
            int size = arrayList2.size();
            ArrayList arrayList4 = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = arrayList.get(i2);
                String transitionName = ViewCompat.getTransitionName(view2);
                arrayList4.add(transitionName);
                if (transitionName != null) {
                    ViewCompat.setTransitionName(view2, null);
                    String str = map.get(transitionName);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (str.equals(arrayList3.get(i3))) {
                            ViewCompat.setTransitionName(arrayList2.get(i3), transitionName);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            OneShotPreDrawListener.add(view, new Runnable(this, size, arrayList2, arrayList3, arrayList, arrayList4) { // from class: androidx.fragment.app.FragmentTransitionImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentTransitionImpl this$0;
                public final /* synthetic */ ArrayList val$inNames;
                public final /* synthetic */ int val$numSharedElements;
                public final /* synthetic */ ArrayList val$outNames;
                public final /* synthetic */ ArrayList val$sharedElementsIn;
                public final /* synthetic */ ArrayList val$sharedElementsOut;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(size), arrayList2, arrayList3, arrayList, arrayList4};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$numSharedElements = size;
                    this.val$sharedElementsIn = arrayList2;
                    this.val$inNames = arrayList3;
                    this.val$sharedElementsOut = arrayList;
                    this.val$outNames = arrayList4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (int i4 = 0; i4 < this.val$numSharedElements; i4++) {
                            ViewCompat.setTransitionName((View) this.val$sharedElementsIn.get(i4), (String) this.val$inNames.get(i4));
                            ViewCompat.setTransitionName((View) this.val$sharedElementsOut.get(i4), (String) this.val$outNames.get(i4));
                        }
                    }
                }
            });
        }
    }

    public abstract void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);
}
