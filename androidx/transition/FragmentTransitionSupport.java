package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"RestrictedApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FragmentTransitionSupport() {
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

    public static boolean hasSimpleTarget(Transition transition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transition)) == null) ? (FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) ? false : true : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, obj, view2) == null) || obj == null) {
            return;
        }
        ((Transition) obj).addTarget(view2);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, arrayList) == null) || (transition = (Transition) obj) == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                addTargets(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (hasSimpleTarget(transition) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                transition.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, obj) == null) {
            TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj instanceof Transition : invokeL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj != null) {
                return ((Transition) obj).m5clone();
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, obj, obj2, obj3)) == null) {
            Transition transition = (Transition) obj;
            Transition transition2 = (Transition) obj2;
            Transition transition3 = (Transition) obj3;
            if (transition != null && transition2 != null) {
                transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
            } else if (transition == null) {
                transition = transition2 != null ? transition2 : null;
            }
            if (transition3 != null) {
                TransitionSet transitionSet = new TransitionSet();
                if (transition != null) {
                    transitionSet.addTransition(transition);
                }
                transitionSet.addTransition(transition3);
                return transitionSet;
            }
            return transition;
        }
        return invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, obj, obj2, obj3)) == null) {
            TransitionSet transitionSet = new TransitionSet();
            if (obj != null) {
                transitionSet.addTransition((Transition) obj);
            }
            if (obj2 != null) {
                transitionSet.addTransition((Transition) obj2);
            }
            if (obj3 != null) {
                transitionSet.addTransition((Transition) obj3);
            }
            return transitionSet;
        }
        return invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, obj, view2) == null) || obj == null) {
            return;
        }
        ((Transition) obj).removeTarget(view2);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, arrayList, arrayList2) == null) {
            Transition transition = (Transition) obj;
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    replaceTargets(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                    i++;
                }
            } else if (!hasSimpleTarget(transition)) {
                List<View> targets = transition.getTargets();
                if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                    int size = arrayList2 == null ? 0 : arrayList2.size();
                    while (i < size) {
                        transition.addTarget(arrayList2.get(i));
                        i++;
                    }
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        transition.removeTarget(arrayList.get(size2));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, View view2, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, obj, view2, arrayList) == null) {
            ((Transition) obj).addListener(new Transition.TransitionListener(this, view2, arrayList) { // from class: androidx.transition.FragmentTransitionSupport.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentTransitionSupport this$0;
                public final /* synthetic */ ArrayList val$exitingViews;
                public final /* synthetic */ View val$fragmentView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2, arrayList};
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
                    this.val$fragmentView = view2;
                    this.val$exitingViews = arrayList;
                }

                @Override // androidx.transition.Transition.TransitionListener
                public void onTransitionCancel(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                    }
                }

                @Override // androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                        transition.removeListener(this);
                        this.val$fragmentView.setVisibility(8);
                        int size = this.val$exitingViews.size();
                        for (int i = 0; i < size; i++) {
                            ((View) this.val$exitingViews.get(i)).setVisibility(0);
                        }
                    }
                }

                @Override // androidx.transition.Transition.TransitionListener
                public void onTransitionPause(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition) == null) {
                    }
                }

                @Override // androidx.transition.Transition.TransitionListener
                public void onTransitionResume(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition) == null) {
                    }
                }

                @Override // androidx.transition.Transition.TransitionListener
                public void onTransitionStart(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, transition) == null) {
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{obj, obj2, arrayList, obj3, arrayList2, obj4, arrayList3}) == null) {
            ((Transition) obj).addListener(new TransitionListenerAdapter(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3) { // from class: androidx.transition.FragmentTransitionSupport.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentTransitionSupport this$0;
                public final /* synthetic */ Object val$enterTransition;
                public final /* synthetic */ ArrayList val$enteringViews;
                public final /* synthetic */ Object val$exitTransition;
                public final /* synthetic */ ArrayList val$exitingViews;
                public final /* synthetic */ Object val$sharedElementTransition;
                public final /* synthetic */ ArrayList val$sharedElementsIn;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3};
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
                    this.val$enterTransition = obj2;
                    this.val$enteringViews = arrayList;
                    this.val$exitTransition = obj3;
                    this.val$exitingViews = arrayList2;
                    this.val$sharedElementTransition = obj4;
                    this.val$sharedElementsIn = arrayList3;
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                        transition.removeListener(this);
                    }
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionStart(@NonNull Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                        Object obj5 = this.val$enterTransition;
                        if (obj5 != null) {
                            this.this$0.replaceTargets(obj5, this.val$enteringViews, null);
                        }
                        Object obj6 = this.val$exitTransition;
                        if (obj6 != null) {
                            this.this$0.replaceTargets(obj6, this.val$exitingViews, null);
                        }
                        Object obj7 = this.val$sharedElementTransition;
                        if (obj7 != null) {
                            this.this$0.replaceTargets(obj7, this.val$sharedElementsIn, null);
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, obj, view2) == null) || view2 == null) {
            return;
        }
        Rect rect = new Rect();
        getBoundsOnScreen(view2, rect);
        ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback(this, rect) { // from class: androidx.transition.FragmentTransitionSupport.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentTransitionSupport this$0;
            public final /* synthetic */ Rect val$epicenter;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, rect};
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
                this.val$epicenter = rect;
            }

            @Override // androidx.transition.Transition.EpicenterCallback
            public Rect onGetEpicenter(@NonNull Transition transition) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, transition)) == null) ? this.val$epicenter : (Rect) invokeL.objValue;
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view2, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, obj, view2, arrayList) == null) {
            TransitionSet transitionSet = (TransitionSet) obj;
            List<View> targets = transitionSet.getTargets();
            targets.clear();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i));
            }
            targets.add(view2);
            arrayList.add(view2);
            addTargets(transitionSet, arrayList);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, obj, arrayList, arrayList2) == null) || (transitionSet = (TransitionSet) obj) == null) {
            return;
        }
        transitionSet.getTargets().clear();
        transitionSet.getTargets().addAll(arrayList2);
        replaceTargets(transitionSet, arrayList, arrayList2);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition((Transition) obj);
            return transitionSet;
        }
        return invokeL.objValue;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, obj, rect) == null) || obj == null) {
            return;
        }
        ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback(this, rect) { // from class: androidx.transition.FragmentTransitionSupport.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FragmentTransitionSupport this$0;
            public final /* synthetic */ Rect val$epicenter;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, rect};
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
                this.val$epicenter = rect;
            }

            @Override // androidx.transition.Transition.EpicenterCallback
            public Rect onGetEpicenter(@NonNull Transition transition) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, transition)) == null) {
                    Rect rect2 = this.val$epicenter;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return this.val$epicenter;
                }
                return (Rect) invokeL.objValue;
            }
        });
    }
}
