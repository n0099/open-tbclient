package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TransitionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "TransitionManager";
    public static Transition sDefaultTransition;
    public static ArrayList<ViewGroup> sPendingTransitions;
    public static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions;
    public ArrayMap<Scene, Transition> mSceneTransitions;

    /* loaded from: classes.dex */
    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup mSceneRoot;
        public Transition mTransition;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            }
        }

        public MultiListener(Transition transition, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transition, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
                this.mSceneRoot.removeOnAttachStateChangeListener(this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                removeListeners();
                if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
                    return true;
                }
                ArrayMap<ViewGroup, ArrayList<Transition>> runningTransitions = TransitionManager.getRunningTransitions();
                ArrayList<Transition> arrayList = runningTransitions.get(this.mSceneRoot);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    runningTransitions.put(this.mSceneRoot, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.mTransition);
                this.mTransition.addListener(new TransitionListenerAdapter(this, runningTransitions) { // from class: androidx.transition.TransitionManager.MultiListener.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiListener this$0;
                    public final /* synthetic */ ArrayMap val$runningTransitions;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, runningTransitions};
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
                        this.val$runningTransitions = runningTransitions;
                    }

                    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                            ((ArrayList) this.val$runningTransitions.get(this.this$0.mSceneRoot)).remove(transition);
                            transition.removeListener(this);
                        }
                    }
                });
                this.mTransition.captureValues(this.mSceneRoot, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).resume(this.mSceneRoot);
                    }
                }
                this.mTransition.playTransition(this.mSceneRoot);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                removeListeners();
                TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
                ArrayList<Transition> arrayList = TransitionManager.getRunningTransitions().get(this.mSceneRoot);
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<Transition> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().resume(this.mSceneRoot);
                    }
                }
                this.mTransition.clearValues(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(959800675, "Landroidx/transition/TransitionManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(959800675, "Landroidx/transition/TransitionManager;");
                return;
            }
        }
        sDefaultTransition = new AutoTransition();
        sRunningTransitions = new ThreadLocal<>();
        sPendingTransitions = new ArrayList<>();
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        InterceptResult invokeV;
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = sRunningTransitions.get();
            if (weakReference != null && (arrayMap = weakReference.get()) != null) {
                return arrayMap;
            }
            ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
            sRunningTransitions.set(new WeakReference<>(arrayMap2));
            return arrayMap2;
        }
        return (ArrayMap) invokeV.objValue;
    }

    public TransitionManager() {
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
        this.mSceneTransitions = new ArrayMap<>();
        this.mScenePairTransitions = new ArrayMap<>();
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, viewGroup) == null) {
            beginDelayedTransition(viewGroup, null);
        }
    }

    public static void go(Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, scene) == null) {
            changeScene(scene, sDefaultTransition);
        }
    }

    public void transitionTo(Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, scene) == null) {
            changeScene(scene, getTransition(scene));
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, viewGroup, transition) == null) && !sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            Transition m5clone = transition.m5clone();
            sceneChangeSetup(viewGroup, m5clone);
            Scene.setCurrentScene(viewGroup, null);
            sceneChangeRunTransition(viewGroup, m5clone);
        }
    }

    public static void changeScene(Scene scene, Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, scene, transition) == null) {
            ViewGroup sceneRoot = scene.getSceneRoot();
            if (!sPendingTransitions.contains(sceneRoot)) {
                Scene currentScene = Scene.getCurrentScene(sceneRoot);
                if (transition == null) {
                    if (currentScene != null) {
                        currentScene.exit();
                    }
                    scene.enter();
                    return;
                }
                sPendingTransitions.add(sceneRoot);
                Transition m5clone = transition.m5clone();
                m5clone.setSceneRoot(sceneRoot);
                if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
                    m5clone.setCanRemoveViews(true);
                }
                sceneChangeSetup(sceneRoot, m5clone);
                scene.enter();
                sceneChangeRunTransition(sceneRoot, m5clone);
            }
        }
    }

    public static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, viewGroup, transition) == null) {
            ArrayList<Transition> arrayList = getRunningTransitions().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().pause(viewGroup);
                }
            }
            if (transition != null) {
                transition.captureValues(viewGroup, true);
            }
            Scene currentScene = Scene.getCurrentScene(viewGroup);
            if (currentScene != null) {
                currentScene.exit();
            }
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, viewGroup) == null) {
            sPendingTransitions.remove(viewGroup);
            ArrayList<Transition> arrayList = getRunningTransitions().get(viewGroup);
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(arrayList);
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ((Transition) arrayList2.get(size)).forceToEnd(viewGroup);
                }
            }
        }
    }

    private Transition getTransition(Scene scene) {
        InterceptResult invokeL;
        Scene currentScene;
        ArrayMap<Scene, Transition> arrayMap;
        Transition transition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, scene)) == null) {
            ViewGroup sceneRoot = scene.getSceneRoot();
            if (sceneRoot != null && (currentScene = Scene.getCurrentScene(sceneRoot)) != null && (arrayMap = this.mScenePairTransitions.get(scene)) != null && (transition = arrayMap.get(currentScene)) != null) {
                return transition;
            }
            Transition transition2 = this.mSceneTransitions.get(scene);
            if (transition2 == null) {
                return sDefaultTransition;
            }
            return transition2;
        }
        return (Transition) invokeL.objValue;
    }

    public static void go(Scene scene, Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, scene, transition) == null) {
            changeScene(scene, transition);
        }
    }

    public static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, viewGroup, transition) == null) && transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    public void setTransition(Scene scene, Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scene, transition) == null) {
            this.mSceneTransitions.put(scene, transition);
        }
    }

    public void setTransition(Scene scene, Scene scene2, Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, scene, scene2, transition) == null) {
            ArrayMap<Scene, Transition> arrayMap = this.mScenePairTransitions.get(scene2);
            if (arrayMap == null) {
                arrayMap = new ArrayMap<>();
                this.mScenePairTransitions.put(scene2, arrayMap);
            }
            arrayMap.put(scene, transition);
        }
    }
}
