package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void addTarget(Object obj, View view2);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    public abstract Object cloneTransition(Object obj);

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    public abstract void removeTarget(Object obj, View view2);

    public abstract void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void scheduleHideFragmentView(Object obj, View view2, ArrayList<View> arrayList);

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(Object obj, Rect rect);

    public abstract void setEpicenter(Object obj, View view2);

    public abstract void setSharedElementTargets(Object obj, View view2, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);

    public FragmentTransitionImpl() {
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

    public static void bfsAddViewChildren(List<View> list, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, view2) == null) {
            int size = list.size();
            if (containedBeforeIndex(list, view2, size)) {
                return;
            }
            list.add(view2);
            for (int i = size; i < list.size(); i++) {
                View view3 = list.get(i);
                if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!containedBeforeIndex(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static boolean containedBeforeIndex(List<View> list, View view2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, list, view2, i)) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                if (list.get(i2) == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        for (int i = 0; i < size; i++) {
                            View view2 = (View) this.val$sharedElementsIn.get(i);
                            ViewCompat.setTransitionName(view2, (String) this.val$nameOverrides.get(ViewCompat.getTransitionName(view2)));
                        }
                    }
                }
            });
        }
    }

    public void setNameOverridesOrdered(View view2, ArrayList<View> arrayList, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, view2, arrayList, map) == null) {
            OneShotPreDrawListener.add(view2, new Runnable(this, arrayList, map) { // from class: androidx.fragment.app.FragmentTransitionImpl.2
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        for (int i = 0; i < size; i++) {
                            View view3 = (View) this.val$sharedElementsIn.get(i);
                            String transitionName = ViewCompat.getTransitionName(view3);
                            if (transitionName != null) {
                                ViewCompat.setTransitionName(view3, FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, transitionName));
                            }
                        }
                    }
                }
            });
        }
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

    public void captureTransitioningViews(ArrayList<View> arrayList, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, arrayList, view2) == null) && view2.getVisibility() == 0) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    captureTransitioningViews(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view2);
        }
    }

    public void findNamedViews(Map<String, View> map, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, map, view2) == null) && view2.getVisibility() == 0) {
            String transitionName = ViewCompat.getTransitionName(view2);
            if (transitionName != null) {
                map.put(transitionName, view2);
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static boolean isNullOrEmpty(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void getBoundsOnScreen(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, rect) == null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            rect.set(iArr[0], iArr[1], iArr[0] + view2.getWidth(), iArr[1] + view2.getHeight());
        }
    }

    public ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, arrayList)) == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view2 = arrayList.get(i);
                arrayList2.add(ViewCompat.getTransitionName(view2));
                ViewCompat.setTransitionName(view2, null);
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void setListenerForTransitionEnd(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, fragment, obj, cancellationSignal, runnable) == null) {
            runnable.run();
        }
    }

    public void setNameOverridesReordered(View view2, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048596, this, view2, arrayList, arrayList2, arrayList3, map) == null) {
            int size = arrayList2.size();
            ArrayList arrayList4 = new ArrayList();
            for (int i = 0; i < size; i++) {
                View view3 = arrayList.get(i);
                String transitionName = ViewCompat.getTransitionName(view3);
                arrayList4.add(transitionName);
                if (transitionName != null) {
                    ViewCompat.setTransitionName(view3, null);
                    String str = map.get(transitionName);
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (str.equals(arrayList3.get(i2))) {
                            ViewCompat.setTransitionName(arrayList2.get(i2), transitionName);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            OneShotPreDrawListener.add(view2, new Runnable(this, size, arrayList2, arrayList3, arrayList, arrayList4) { // from class: androidx.fragment.app.FragmentTransitionImpl.1
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
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
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
                        for (int i3 = 0; i3 < this.val$numSharedElements; i3++) {
                            ViewCompat.setTransitionName((View) this.val$sharedElementsIn.get(i3), (String) this.val$inNames.get(i3));
                            ViewCompat.setTransitionName((View) this.val$sharedElementsOut.get(i3), (String) this.val$outNames.get(i3));
                        }
                    }
                }
            });
        }
    }
}
