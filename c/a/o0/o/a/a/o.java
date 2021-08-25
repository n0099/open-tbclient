package c.a.o0.o.a.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends Transition.EpicenterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f12102a;

        public a(Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12102a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, transition)) == null) ? this.f12102a : (Rect) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f12103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Transition f12104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f12105g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f12106h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f12107i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Map f12108j;
        public final /* synthetic */ ArrayList k;

        public b(View view, Transition transition, View view2, f fVar, Map map, Map map2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, transition, view2, fVar, map, map2, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12103e = view;
            this.f12104f = transition;
            this.f12105g = view2;
            this.f12106h = fVar;
            this.f12107i = map;
            this.f12108j = map2;
            this.k = arrayList;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f12103e.getViewTreeObserver().removeOnPreDrawListener(this);
                Transition transition = this.f12104f;
                if (transition != null) {
                    transition.removeTarget(this.f12105g);
                }
                View view = this.f12106h.getView();
                if (view != null) {
                    if (!this.f12107i.isEmpty()) {
                        o.m(this.f12108j, view);
                        this.f12108j.keySet().retainAll(this.f12107i.values());
                        for (Map.Entry entry : this.f12107i.entrySet()) {
                            View view2 = (View) this.f12108j.get((String) entry.getValue());
                            if (view2 != null) {
                                view2.setTransitionName((String) entry.getKey());
                            }
                        }
                    }
                    if (this.f12104f != null) {
                        o.h(this.k, view);
                        this.k.removeAll(this.f12108j.values());
                        this.k.add(this.f12105g);
                        o.c(this.f12104f, this.k);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Transition.EpicenterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Rect f12109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f12110b;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12110b = eVar;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            InterceptResult invokeL;
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, transition)) == null) {
                if (this.f12109a == null && (view = this.f12110b.f12117a) != null) {
                    this.f12109a = o.n(view);
                }
                return this.f12109a;
            }
            return (Rect) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f12111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Transition f12112f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12113g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Transition f12114h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12115i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Transition f12116j;
        public final /* synthetic */ ArrayList k;
        public final /* synthetic */ Map l;
        public final /* synthetic */ ArrayList m;
        public final /* synthetic */ Transition n;
        public final /* synthetic */ View o;

        public d(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12111e = view;
            this.f12112f = transition;
            this.f12113g = arrayList;
            this.f12114h = transition2;
            this.f12115i = arrayList2;
            this.f12116j = transition3;
            this.k = arrayList3;
            this.l = map;
            this.m = arrayList4;
            this.n = transition4;
            this.o = view2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f12111e.getViewTreeObserver().removeOnPreDrawListener(this);
                Transition transition = this.f12112f;
                if (transition != null) {
                    o.s(transition, this.f12113g);
                }
                Transition transition2 = this.f12114h;
                if (transition2 != null) {
                    o.s(transition2, this.f12115i);
                }
                Transition transition3 = this.f12116j;
                if (transition3 != null) {
                    o.s(transition3, this.k);
                }
                for (Map.Entry entry : this.l.entrySet()) {
                    ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                }
                int size = this.m.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.n.excludeTarget((View) this.m.get(i2), false);
                }
                this.n.excludeTarget(this.o, false);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f12117a;

        public e() {
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

    /* loaded from: classes3.dex */
    public interface f {
        View getView();
    }

    public static void c(Object obj, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, obj, arrayList) == null) {
            Transition transition = (Transition) obj;
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i2 < transitionCount) {
                    c(transitionSet.getTransitionAt(i2), arrayList);
                    i2++;
                }
            } else if (p(transition) || !q(transition.getTargets())) {
            } else {
                int size = arrayList.size();
                while (i2 < size) {
                    transition.addTarget(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public static void d(Object obj, Object obj2, View view, f fVar, View view2, e eVar, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{obj, obj2, view, fVar, view2, eVar, map, arrayList, map2, map3, arrayList2}) == null) {
            if (obj == null && obj2 == null) {
                return;
            }
            Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                v(obj2, view2, map2, arrayList2);
            }
            if (fVar != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new b(view, transition, view2, fVar, map, map3, arrayList));
            }
            u(transition, eVar);
        }
    }

    public static void e(ViewGroup viewGroup, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, obj) == null) {
            TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
        }
    }

    public static void f(List<View> list, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, view) == null) {
            int size = list.size();
            if (k(list, view, size)) {
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
                        if (!k(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static Object g(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, view, arrayList, map, view2)) == null) {
            if (obj != null) {
                h(arrayList, view);
                if (map != null) {
                    arrayList.removeAll(map.values());
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                arrayList.add(view2);
                c((Transition) obj, arrayList);
                return obj;
            }
            return obj;
        }
        return invokeLLLLL.objValue;
    }

    public static void h(ArrayList<View> arrayList, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, arrayList, view) == null) && view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.isTransitionGroup()) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    h(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public static void i(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{view, view2, obj, arrayList, obj2, arrayList2, obj3, arrayList3, obj4, arrayList4, map}) == null) {
            Transition transition = (Transition) obj;
            Transition transition2 = (Transition) obj2;
            Transition transition3 = (Transition) obj3;
            Transition transition4 = (Transition) obj4;
            if (transition4 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new d(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
            }
        }
    }

    public static Object j(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, obj)) == null) ? obj != null ? ((Transition) obj).clone() : obj : invokeL.objValue;
    }

    public static boolean k(List<View> list, View view, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, list, view, i2)) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (list.get(i3) == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void l(Object obj, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65547, null, obj, view, z) == null) {
            ((Transition) obj).excludeTarget(view, z);
        }
    }

    public static void m(Map<String, View> map, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, map, view) == null) && view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    m(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public static Rect n(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view)) == null) {
            Rect rect = new Rect();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public static String o(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view)) == null) ? view.getTransitionName() : (String) invokeL.objValue;
    }

    public static boolean p(Transition transition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, transition)) == null) ? (q(transition.getTargetIds()) && q(transition.getTargetNames()) && q(transition.getTargetTypes())) ? false : true : invokeL.booleanValue;
    }

    public static boolean q(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, list)) == null) ? list == null || list.isEmpty() : invokeL.booleanValue;
    }

    public static Object r(Object obj, Object obj2, Object obj3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{obj, obj2, obj3, Boolean.valueOf(z)})) == null) {
            Transition transition = (Transition) obj;
            Transition transition2 = (Transition) obj2;
            Transition transition3 = (Transition) obj3;
            if ((transition == null || transition2 == null) ? true : true) {
                TransitionSet transitionSet = new TransitionSet();
                if (transition != null) {
                    transitionSet.addTransition(transition);
                }
                if (transition2 != null) {
                    transitionSet.addTransition(transition2);
                }
                if (transition3 != null) {
                    transitionSet.addTransition(transition3);
                    return transitionSet;
                }
                return transitionSet;
            }
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                TransitionSet transitionSet2 = new TransitionSet();
                if (transition != null) {
                    transitionSet2.addTransition(transition);
                }
                transitionSet2.addTransition(transition3);
                return transitionSet2;
            }
            return transition;
        }
        return invokeCommon.objValue;
    }

    public static void s(Object obj, ArrayList<View> arrayList) {
        List<View> targets;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, obj, arrayList) == null) {
            Transition transition = (Transition) obj;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                for (int i2 = 0; i2 < transitionCount; i2++) {
                    s(transitionSet.getTransitionAt(i2), arrayList);
                }
            } else if (!p(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.removeTarget(arrayList.get(size));
                }
            }
        }
    }

    public static void t(Object obj, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, obj, view) == null) {
            ((Transition) obj).setEpicenterCallback(new a(n(view)));
        }
    }

    public static void u(Transition transition, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, transition, eVar) == null) || transition == null) {
            return;
        }
        transition.setEpicenterCallback(new c(eVar));
    }

    public static void v(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65557, null, obj, view, map, arrayList) == null) {
            TransitionSet transitionSet = (TransitionSet) obj;
            arrayList.clear();
            arrayList.addAll(map.values());
            List<View> targets = transitionSet.getTargets();
            targets.clear();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                f(targets, arrayList.get(i2));
            }
            arrayList.add(view);
            c(transitionSet, arrayList);
        }
    }

    public static Object w(Object obj) {
        InterceptResult invokeL;
        Transition transition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, obj)) == null) {
            if (obj == null || (transition = (Transition) obj) == null) {
                return null;
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(transition);
            return transitionSet;
        }
        return invokeL.objValue;
    }
}
