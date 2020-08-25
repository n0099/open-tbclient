package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition = new AutoTransition();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal<>();
    private static ArrayList<ViewGroup> sPendingTransitions = new ArrayList<>();
    private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap<>();
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions = new ArrayMap<>();

    public void setTransition(@NonNull Scene scene, @Nullable Transition transition) {
        this.mSceneTransitions.put(scene, transition);
    }

    public void setTransition(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap<Scene, Transition> arrayMap = this.mScenePairTransitions.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.mScenePairTransitions.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }

    private Transition getTransition(Scene scene) {
        Scene currentScene;
        ArrayMap<Scene, Transition> arrayMap;
        Transition transition;
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (sceneRoot == null || (currentScene = Scene.getCurrentScene(sceneRoot)) == null || (arrayMap = this.mScenePairTransitions.get(scene)) == null || (transition = arrayMap.get(currentScene)) == null) {
            Transition transition2 = this.mSceneTransitions.get(scene);
            return transition2 == null ? sDefaultTransition : transition2;
        }
        return transition;
    }

    private static void changeScene(Scene scene, Transition transition) {
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (!sPendingTransitions.contains(sceneRoot)) {
            if (transition == null) {
                scene.enter();
                return;
            }
            sPendingTransitions.add(sceneRoot);
            Transition m1clone = transition.m1clone();
            m1clone.setSceneRoot(sceneRoot);
            Scene currentScene = Scene.getCurrentScene(sceneRoot);
            if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
                m1clone.setCanRemoveViews(true);
            }
            sceneChangeSetup(sceneRoot, m1clone);
            scene.enter();
            sceneChangeRunTransition(sceneRoot, m1clone);
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = sRunningTransitions.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ArrayMap());
            sRunningTransitions.set(weakReference);
        }
        return weakReference.get();
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
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

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ArrayList<Transition> arrayList;
            ArrayList arrayList2;
            removeListeners();
            if (TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
                final ArrayMap<ViewGroup, ArrayList<Transition>> runningTransitions = TransitionManager.getRunningTransitions();
                ArrayList<Transition> arrayList3 = runningTransitions.get(this.mSceneRoot);
                if (arrayList3 == null) {
                    ArrayList<Transition> arrayList4 = new ArrayList<>();
                    runningTransitions.put(this.mSceneRoot, arrayList4);
                    arrayList = arrayList4;
                    arrayList2 = null;
                } else if (arrayList3.size() <= 0) {
                    arrayList = arrayList3;
                    arrayList2 = null;
                } else {
                    arrayList = arrayList3;
                    arrayList2 = new ArrayList(arrayList3);
                }
                arrayList.add(this.mTransition);
                this.mTransition.addListener(new TransitionListenerAdapter() { // from class: android.support.transition.TransitionManager.MultiListener.1
                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    public void onTransitionEnd(@NonNull Transition transition) {
                        ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition);
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
            }
            return true;
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
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

    public void transitionTo(@NonNull Scene scene) {
        changeScene(scene, getTransition(scene));
    }

    public static void go(@NonNull Scene scene) {
        changeScene(scene, sDefaultTransition);
    }

    public static void go(@NonNull Scene scene, @Nullable Transition transition) {
        changeScene(scene, transition);
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            Transition m1clone = transition.m1clone();
            sceneChangeSetup(viewGroup, m1clone);
            Scene.setCurrentScene(viewGroup, null);
            sceneChangeRunTransition(viewGroup, m1clone);
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
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
