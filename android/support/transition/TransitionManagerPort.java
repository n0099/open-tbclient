package android.support.transition;

import android.support.annotation.RestrictTo;
import android.support.transition.TransitionPort;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
class TransitionManagerPort {
    private static final String[] EMPTY_STRINGS = new String[0];
    private static String LOG_TAG = "TransitionManager";
    private static TransitionPort sDefaultTransition = new AutoTransitionPort();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<TransitionPort>>>> sRunningTransitions = new ThreadLocal<>();
    static ArrayList<ViewGroup> sPendingTransitions = new ArrayList<>();
    ArrayMap<ScenePort, TransitionPort> mSceneTransitions = new ArrayMap<>();
    ArrayMap<ScenePort, ArrayMap<ScenePort, TransitionPort>> mScenePairTransitions = new ArrayMap<>();
    ArrayMap<ScenePort, ArrayMap<String, TransitionPort>> mSceneNameTransitions = new ArrayMap<>();
    ArrayMap<String, ArrayMap<ScenePort, TransitionPort>> mNameSceneTransitions = new ArrayMap<>();

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public static TransitionPort getDefaultTransition() {
        return sDefaultTransition;
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public void setDefaultTransition(TransitionPort transitionPort) {
        sDefaultTransition = transitionPort;
    }

    private static void changeScene(ScenePort scenePort, TransitionPort transitionPort) {
        ViewGroup sceneRoot = scenePort.getSceneRoot();
        TransitionPort transitionPort2 = null;
        if (transitionPort != null) {
            transitionPort2 = transitionPort.m0clone();
            transitionPort2.setSceneRoot(sceneRoot);
        }
        ScenePort currentScene = ScenePort.getCurrentScene(sceneRoot);
        if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
            transitionPort2.setCanRemoveViews(true);
        }
        sceneChangeSetup(sceneRoot, transitionPort2);
        scenePort.enter();
        sceneChangeRunTransition(sceneRoot, transitionPort2);
    }

    static ArrayMap<ViewGroup, ArrayList<TransitionPort>> getRunningTransitions() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<TransitionPort>>> weakReference = sRunningTransitions.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ArrayMap());
            sRunningTransitions.set(weakReference);
        }
        return weakReference.get();
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, TransitionPort transitionPort) {
        if (transitionPort != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transitionPort, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, TransitionPort transitionPort) {
        ArrayList<TransitionPort> arrayList = getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<TransitionPort> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transitionPort != null) {
            transitionPort.captureValues(viewGroup, true);
        }
        ScenePort currentScene = ScenePort.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public static void go(ScenePort scenePort) {
        changeScene(scenePort, sDefaultTransition);
    }

    public static void go(ScenePort scenePort, TransitionPort transitionPort) {
        changeScene(scenePort, transitionPort);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, TransitionPort transitionPort) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transitionPort == null) {
                transitionPort = sDefaultTransition;
            }
            TransitionPort m0clone = transitionPort.m0clone();
            sceneChangeSetup(viewGroup, m0clone);
            ScenePort.setCurrentScene(viewGroup, null);
            sceneChangeRunTransition(viewGroup, m0clone);
        }
    }

    public void setTransition(ScenePort scenePort, TransitionPort transitionPort) {
        this.mSceneTransitions.put(scenePort, transitionPort);
    }

    public void setTransition(ScenePort scenePort, ScenePort scenePort2, TransitionPort transitionPort) {
        ArrayMap<ScenePort, TransitionPort> arrayMap = this.mScenePairTransitions.get(scenePort2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.mScenePairTransitions.put(scenePort2, arrayMap);
        }
        arrayMap.put(scenePort, transitionPort);
    }

    private TransitionPort getTransition(ScenePort scenePort) {
        ScenePort currentScene;
        ArrayMap<ScenePort, TransitionPort> arrayMap;
        TransitionPort transitionPort;
        ViewGroup sceneRoot = scenePort.getSceneRoot();
        if (sceneRoot == null || (currentScene = ScenePort.getCurrentScene(sceneRoot)) == null || (arrayMap = this.mScenePairTransitions.get(scenePort)) == null || (transitionPort = arrayMap.get(currentScene)) == null) {
            TransitionPort transitionPort2 = this.mSceneTransitions.get(scenePort);
            return transitionPort2 == null ? sDefaultTransition : transitionPort2;
        }
        return transitionPort;
    }

    public TransitionPort getNamedTransition(String str, ScenePort scenePort) {
        ArrayMap<ScenePort, TransitionPort> arrayMap = this.mNameSceneTransitions.get(str);
        if (arrayMap != null) {
            return arrayMap.get(scenePort);
        }
        return null;
    }

    public TransitionPort getNamedTransition(ScenePort scenePort, String str) {
        ArrayMap<String, TransitionPort> arrayMap = this.mSceneNameTransitions.get(scenePort);
        if (arrayMap != null) {
            return arrayMap.get(str);
        }
        return null;
    }

    public String[] getTargetSceneNames(ScenePort scenePort) {
        ArrayMap<String, TransitionPort> arrayMap = this.mSceneNameTransitions.get(scenePort);
        if (arrayMap == null) {
            return EMPTY_STRINGS;
        }
        int size = arrayMap.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayMap.keyAt(i);
        }
        return strArr;
    }

    public void setTransition(ScenePort scenePort, String str, TransitionPort transitionPort) {
        ArrayMap<String, TransitionPort> arrayMap = this.mSceneNameTransitions.get(scenePort);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.mSceneNameTransitions.put(scenePort, arrayMap);
        }
        arrayMap.put(str, transitionPort);
    }

    public void setTransition(String str, ScenePort scenePort, TransitionPort transitionPort) {
        ArrayMap<ScenePort, TransitionPort> arrayMap = this.mNameSceneTransitions.get(str);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.mNameSceneTransitions.put(str, arrayMap);
        }
        arrayMap.put(scenePort, transitionPort);
    }

    public void transitionTo(ScenePort scenePort) {
        changeScene(scenePort, getTransition(scenePort));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        ViewGroup mSceneRoot;
        TransitionPort mTransition;

        MultiListener(TransitionPort transitionPort, ViewGroup viewGroup) {
            this.mTransition = transitionPort;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            removeListeners();
            TransitionManagerPort.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList<TransitionPort> arrayList = TransitionManagerPort.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<TransitionPort> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ArrayList<TransitionPort> arrayList;
            ArrayList arrayList2;
            removeListeners();
            TransitionManagerPort.sPendingTransitions.remove(this.mSceneRoot);
            final ArrayMap<ViewGroup, ArrayList<TransitionPort>> runningTransitions = TransitionManagerPort.getRunningTransitions();
            ArrayList<TransitionPort> arrayList3 = runningTransitions.get(this.mSceneRoot);
            if (arrayList3 == null) {
                ArrayList<TransitionPort> arrayList4 = new ArrayList<>();
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
            this.mTransition.addListener(new TransitionPort.TransitionListenerAdapter() { // from class: android.support.transition.TransitionManagerPort.MultiListener.1
                @Override // android.support.transition.TransitionPort.TransitionListenerAdapter, android.support.transition.TransitionPort.TransitionListener
                public void onTransitionEnd(TransitionPort transitionPort) {
                    ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transitionPort);
                }
            });
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((TransitionPort) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        }
    }
}
