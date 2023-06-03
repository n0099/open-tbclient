package com.baidu.searchbox.ui.state;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.CommonConfig;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.ui.state.ActivityState;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes4.dex */
public class StateManager implements ActivityContext {
    public static final boolean DEBUG = CommonConfig.DEBUG & true;
    public static final String KEY_CLASS = "class";
    public static final String KEY_DATA = "data";
    public static final String KEY_MAIN = "activity-state";
    public static final String KEY_STATE = "bundle";
    public static final String TAG = "StateManager";
    public final ActivityContext mActivityContext;
    public final Context mContext;
    public int mEnterAnim;
    public AnimateView mEnterAnimView;
    public int mExitAnim;
    public AnimateView mExitAnimView;
    public final boolean mFinishActivity;
    public boolean mIsResumed;
    public ActivityState.ResultEntry mResult;
    public final Stack<StateEntry> mStack;
    public final StateContainer mStateContainer;
    public long mTransitionAnimDuration;
    public boolean mTransitionAnimEnd;

    public ActivityState createState(Class<? extends ActivityState> cls) {
        return null;
    }

    public StateManager getStateManager() {
        return this;
    }

    /* loaded from: classes4.dex */
    public static class StateEntry {
        public final ActivityState activityState;
        public final Bundle data;

        public StateEntry(Bundle bundle, ActivityState activityState) {
            this.data = bundle;
            this.activityState = activityState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout getRootContainer() {
        return this.mStateContainer.getStateContainer();
    }

    private boolean isTransitionAnimEnd() {
        if (getStateCount() == 0) {
            this.mTransitionAnimEnd = true;
        }
        return this.mTransitionAnimEnd;
    }

    public boolean backPressed() {
        if (DEBUG) {
            Log.i(TAG, "StateManager#onBackPressed()=====");
        }
        if (!this.mStack.isEmpty()) {
            getTopState().onBackPressed();
            return true;
        }
        return false;
    }

    public void destroyView() {
        if (DEBUG) {
            Log.i(TAG, "StateManager#destroyView()=====");
        }
        for (int size = this.mStack.size() - 1; size >= 0; size--) {
            this.mStack.get(size).activityState.onDestroyView();
        }
    }

    @Override // com.baidu.searchbox.ui.state.ActivityContext
    public Context getAndroidContext() {
        return this.mContext;
    }

    public ActivityState getBottomState() {
        if (!this.mStack.isEmpty()) {
            return this.mStack.get(0).activityState;
        }
        return null;
    }

    public int getStateCount() {
        return this.mStack.size();
    }

    public ActivityState getTopState() {
        if (!this.mStack.isEmpty()) {
            return this.mStack.peek().activityState;
        }
        return null;
    }

    public boolean isResumed() {
        return this.mIsResumed;
    }

    public void lowMemory() {
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            it.next().activityState.onLowMemory();
        }
    }

    public void pause() {
        if (!this.mIsResumed) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "StateManager#pause()=====");
        }
        this.mIsResumed = false;
        if (!this.mStack.isEmpty()) {
            getTopState().onPause();
        }
    }

    public void resume() {
        if (this.mIsResumed) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "StateManager#resume()=====");
        }
        this.mIsResumed = true;
        if (!this.mStack.isEmpty()) {
            getTopState().onResume();
        }
    }

    public StateManager(Context context, StateContainer stateContainer) {
        this(context, stateContainer, false);
    }

    private final void performTransition(Runnable runnable, boolean z) {
        if (z) {
            getRootContainer().post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleTransitionAnimEnd(boolean z, final Runnable runnable) {
        if (z) {
            getRootContainer().postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.state.StateManager.3
                @Override // java.lang.Runnable
                public void run() {
                    StateManager.this.mTransitionAnimEnd = true;
                    StateManager.this.mTransitionAnimDuration = 0L;
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, this.mTransitionAnimDuration);
            return;
        }
        this.mTransitionAnimEnd = true;
        this.mTransitionAnimDuration = 0L;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.baidu.searchbox.ui.state.ActivityContext
    public final void overridePendingTransition(int i, int i2) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
    }

    public StateManager(Context context, StateContainer stateContainer, boolean z) {
        this.mTransitionAnimEnd = true;
        this.mTransitionAnimDuration = 0L;
        this.mStack = new Stack<>();
        this.mContext = context;
        this.mStateContainer = stateContainer;
        this.mFinishActivity = z;
        this.mActivityContext = this;
    }

    public void activityResult(int i, int i2, Intent intent) {
        if (DEBUG) {
            Log.i(TAG, "StateManager#activityResult()=====");
        }
        getTopState().onStateResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (DEBUG) {
            Log.i(TAG, "StateManager#onRequestPermissionsResult()=====");
        }
        getTopState().onRequestPermissionsResult(i, strArr, iArr);
    }

    private StateEntry findStateEntry(ActivityState activityState) {
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            StateEntry next = it.next();
            if (next.activityState == activityState) {
                return next;
            }
        }
        return null;
    }

    private StateEntry getStateEntry(Class<? extends ActivityState> cls) {
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            StateEntry next = it.next();
            if (cls.isInstance(next.activityState)) {
                return next;
            }
        }
        return null;
    }

    private void post(Runnable runnable) {
        getRootContainer().post(runnable);
    }

    @Override // com.baidu.searchbox.ui.state.ActivityContext
    public void finishState(ActivityState activityState) {
        finishState(activityState, true);
    }

    public int getStateIndex(Class<? extends ActivityState> cls) {
        for (int size = this.mStack.size() - 1; size >= 0; size--) {
            if (cls.isInstance(this.mStack.get(size).activityState)) {
                return size;
            }
        }
        return -1;
    }

    public boolean hasStateClass(Class<? extends ActivityState> cls) {
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            if (cls.isInstance(it.next().activityState)) {
                return true;
            }
        }
        return false;
    }

    public void newIntent(Intent intent) {
        if (DEBUG) {
            Log.i(TAG, "StateManager#onNewIntent(), intent = " + intent);
        }
        if (!this.mStack.isEmpty()) {
            getTopState().onNewIntent(intent);
        }
    }

    public void setVisibility(int i) {
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            it.next().activityState.setVisibility(i);
        }
    }

    public void windowFocusChanged(boolean z) {
        if (DEBUG) {
            Log.i(TAG, "StateManager#onWindowFocusChanged(), hasFocus = " + z);
        }
        if (!this.mStack.isEmpty()) {
            getTopState().onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doAnimation(final View view2, int i, final AnimateView animateView) {
        if (DEBUG) {
            Log.d(TAG, "StateManager#doAnimation, animId = " + i + ", view = " + view2);
        }
        if (i == 0 || view2 == null) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "StateManager#doAnimation, do the state transition animation.");
        }
        final int visibility = view2.getVisibility();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mActivityContext.getAndroidContext(), i);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.searchbox.ui.state.StateManager.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                if (StateManager.DEBUG) {
                    int visibility2 = view2.getVisibility();
                    if (visibility == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.e(StateManager.TAG, "    StateManager#doAnimation,  onAnimationEnd()  , set view visibility,  visible = " + z + ", current visibility = " + visibility2 + ", old visibility = " + visibility + ",   view = " + view2);
                }
                StateManager.this.getRootContainer().post(new Runnable() { // from class: com.baidu.searchbox.ui.state.StateManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StateManager.this.getRootContainer().removeView(animateView);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (animateView == StateManager.this.mExitAnimView) {
                            StateManager.this.mExitAnimView = null;
                            return;
                        }
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        if (animateView == StateManager.this.mEnterAnimView) {
                            StateManager.this.mEnterAnimView = null;
                        }
                    }
                });
                StateManager.this.mTransitionAnimEnd = true;
            }
        });
        long duration = loadAnimation.getDuration();
        if (duration >= this.mTransitionAnimDuration) {
            this.mTransitionAnimDuration = duration;
        }
        this.mTransitionAnimEnd = false;
        animateView.startAnimation(loadAnimation);
        return true;
    }

    @Deprecated
    public void switchState(ActivityState activityState, ActivityState activityState2, Bundle bundle) {
        ActivityState topState;
        if (DEBUG) {
            Log.d(TAG, "StateManager#switchState, oldState = " + activityState + ", newState = " + activityState2 + ", data = " + bundle);
        }
        if (activityState != null && (topState = getTopState()) != null && topState == activityState) {
            this.mStack.pop();
            if (this.mIsResumed) {
                activityState.pause();
            }
            activityState.onDestroy();
        }
        activityState2.initialize(this.mActivityContext, bundle);
        this.mStack.push(new StateEntry(bundle, activityState2));
        activityState2.onCreate(bundle, null);
        pushStateView(activityState, activityState2, null);
        if (this.mIsResumed) {
            activityState2.resume();
        }
    }

    private boolean handleLaunchMode(Class<? extends ActivityState> cls, Bundle bundle) {
        StateEntry peek;
        int launchMode;
        if (!hasStateClass(cls)) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "StateManager#handleLaunchMode, klass = " + cls.getCanonicalName());
        }
        ActivityState topState = getTopState();
        if (topState != null && cls.isInstance(topState) && (1 == (launchMode = topState.getLaunchMode()) || 2 == launchMode)) {
            Intent intent = topState.getIntent();
            if (intent == null) {
                intent = new Intent();
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            topState.onNewIntent(intent);
            topState.resume();
            if (DEBUG) {
                Log.i(TAG, "The top state is LAUNCH_SINGLE_TOP or LAUNCH_SINGLE_TASK, state = " + topState);
            }
            printStack();
            return true;
        }
        StateEntry stateEntry = getStateEntry(cls);
        if (stateEntry != null) {
            ActivityState activityState = stateEntry.activityState;
            if (2 == activityState.getLaunchMode()) {
                activityState.onNewIntent(activityState.getIntent());
                activityState.resume();
                if (DEBUG) {
                    Log.i(TAG, "The state launch mode is LAUNCH_SINGLE_TASK, state = " + activityState + ", pop these states out stack.");
                }
                while (!this.mStack.isEmpty() && (peek = this.mStack.peek()) != stateEntry) {
                    if (DEBUG) {
                        Log.i(TAG, "Pop state out stack, state = " + peek.activityState);
                    }
                    popState(peek.activityState);
                }
                printStack();
                return true;
            }
        }
        return false;
    }

    private void init(Context context) {
        this.mEnterAnimView = new AnimateView(context);
        this.mExitAnimView = new AnimateView(context);
        FrameLayout rootContainer = getRootContainer();
        rootContainer.addView(this.mEnterAnimView, new FrameLayout.LayoutParams(-1, -1));
        rootContainer.addView(this.mExitAnimView, new FrameLayout.LayoutParams(-1, -1));
        rootContainer.setAnimationCacheEnabled(true);
        this.mEnterAnimView.setVisibility(8);
        this.mExitAnimView.setVisibility(8);
    }

    public void configurationChange(Configuration configuration) {
        if (DEBUG) {
            Log.i(TAG, "StateManager#onConfigurationChange(), config = " + configuration);
        }
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            it.next().activityState.onConfigurationChanged(configuration);
        }
    }

    private void popState(ActivityState activityState) {
        if (DEBUG) {
            Log.v(TAG, "StateManager#popState(), state " + activityState);
        }
        if (activityState != this.mStack.peek().activityState) {
            if (activityState.isDestroyed()) {
                if (DEBUG) {
                    Log.d(TAG, "StateManager#finishState(), The state is already destroyed");
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("The stateview to be finished is not at the top of the stack: " + activityState + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mStack.peek().activityState);
        }
        this.mStack.pop();
        if (this.mIsResumed) {
            activityState.pause();
        }
        activityState.onDestroy();
        popStateView(activityState, getTopState(), true);
    }

    public final void clearStates(ActivityState activityState) {
        if (getStateCount() == 0) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "StateManager#clearStates(exceptState) begin =========== ");
        }
        this.mExitAnim = 0;
        this.mEnterAnim = 0;
        StateEntry stateEntry = null;
        while (!this.mStack.isEmpty()) {
            StateEntry peek = this.mStack.peek();
            if (stateEntry == null && peek.activityState == activityState) {
                if (DEBUG) {
                    Log.i(TAG, "    StateManager#clearStates,  Pop the except state, do NOT call state's leftcycle");
                }
                this.mStack.pop();
                stateEntry = peek;
            } else {
                if (DEBUG) {
                    Log.i(TAG, "    StateManager#clearStates,  Pop state out stack, state = " + peek.activityState);
                }
                popState(peek.activityState);
            }
        }
        if (stateEntry != null) {
            if (DEBUG) {
                Log.i(TAG, "    StateManager#clearStates,  Push the except state ======");
            }
            this.mStack.push(stateEntry);
        }
        printStack();
        if (DEBUG) {
            Log.i(TAG, "StateManager#clearStates(exceptState) end =========== ");
        }
    }

    public void restoreState(Bundle bundle) throws Exception {
        if (DEBUG) {
            Log.v(TAG, "StateManager#onRestoreState(), inState = " + bundle);
        }
        for (Parcelable parcelable : bundle.getParcelableArray(KEY_MAIN)) {
            Bundle bundle2 = (Bundle) parcelable;
            Class<? extends ActivityState> cls = (Class) bundle2.getSerializable("class");
            Bundle bundle3 = bundle2.getBundle("data");
            Bundle bundle4 = bundle2.getBundle(KEY_STATE);
            if (bundle3 != null) {
                bundle3.setClassLoader(bundle.getClassLoader());
            }
            if (bundle4 != null) {
                bundle4.setClassLoader(bundle.getClassLoader());
            }
            ActivityState createState = createState(cls);
            if (createState == null) {
                createState = cls.newInstance();
            }
            createState.initialize(this.mActivityContext, bundle3);
            createState.onCreate(bundle3, bundle4);
            this.mStack.push(new StateEntry(bundle3, createState));
            pushStateView(null, createState, bundle4);
        }
    }

    public void saveState(Bundle bundle) {
        if (DEBUG) {
            Log.v(TAG, "StateManager#onSaveState(), outState = " + bundle);
        }
        Parcelable[] parcelableArr = new Parcelable[this.mStack.size()];
        int i = 0;
        Iterator<StateEntry> it = this.mStack.iterator();
        while (it.hasNext()) {
            StateEntry next = it.next();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("class", next.activityState.getClass());
            bundle2.putBundle("data", next.data);
            Bundle bundle3 = new Bundle();
            next.activityState.onSaveState(bundle3);
            bundle2.putBundle(KEY_STATE, bundle3);
            if (DEBUG) {
                Log.v(TAG, "StateManager#onSaveState(), " + next.activityState.getClass());
            }
            parcelableArr[i] = bundle2;
            i++;
        }
        bundle.putParcelableArray(KEY_MAIN, parcelableArr);
    }

    private void popStateView(ActivityState activityState, ActivityState activityState2, boolean z) {
        View view2;
        if (DEBUG) {
            Log.d(TAG, "StateManager#popStateView  exitState = " + activityState + ",  enterState = " + activityState2);
        }
        View rootView = activityState.getRootView();
        if (activityState2 != null) {
            view2 = activityState2.getRootView();
        } else {
            view2 = null;
        }
        processStateView(rootView, view2, null, z);
    }

    private void printStack() {
        if (DEBUG) {
            Log.e(TAG, "===== Print state stack begin =====");
            Log.e(TAG, "      StateManager = " + this);
            for (int size = this.mStack.size() + (-1); size >= 0; size += -1) {
                Log.i(TAG, "      state #" + (size + 1) + ZeusCrashHandler.NAME_SEPERATOR + this.mStack.get(size).activityState);
            }
            Log.e(TAG, "===== Print state stack end =====");
        }
    }

    public final void clearStates() {
        if (getStateCount() == 0) {
            return;
        }
        if (DEBUG) {
            Log.i(TAG, "StateManager#clearStates() begin =========== ");
        }
        this.mExitAnim = 0;
        this.mEnterAnim = 0;
        while (!this.mStack.isEmpty()) {
            StateEntry peek = this.mStack.peek();
            if (DEBUG) {
                Log.i(TAG, "    StateManager#clearStates,  Pop state out stack, state = " + peek.activityState);
            }
            popState(peek.activityState);
        }
        printStack();
        if (DEBUG) {
            Log.i(TAG, "StateManager#clearStates() end =========== ");
        }
    }

    @DebugTrace
    private void processStateView(final View view2, final View view3, ViewGroup.LayoutParams layoutParams, boolean z) {
        boolean z2;
        final FrameLayout rootContainer = getRootContainer();
        if (view3 != null) {
            if (view3.getParent() instanceof ViewGroup) {
                ((ViewGroup) view3.getParent()).removeView(view3);
            }
            if (layoutParams != null) {
                rootContainer.addView(view3, layoutParams);
            } else {
                rootContainer.addView(view3);
            }
        }
        if (this.mExitAnim == 0 && this.mEnterAnim == 0 && z) {
            z2 = true;
        } else {
            z2 = false;
        }
        performTransition(new Runnable() { // from class: com.baidu.searchbox.ui.state.StateManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z3 = false;
                if (StateManager.this.mExitAnim != 0) {
                    StateManager.this.mExitAnimView = new AnimateView(StateManager.this.mContext);
                    StateManager.this.getRootContainer().addView(StateManager.this.mExitAnimView, new FrameLayout.LayoutParams(-1, -1));
                    StateManager.this.mExitAnimView.setDrawingView(view2);
                    StateManager.this.mExitAnimView.setVisibility(0);
                }
                if (StateManager.this.mEnterAnim != 0) {
                    StateManager.this.mEnterAnimView = new AnimateView(StateManager.this.mContext);
                    StateManager.this.getRootContainer().addView(StateManager.this.mEnterAnimView, new FrameLayout.LayoutParams(-1, -1));
                    StateManager.this.mEnterAnimView.setDrawingView(view3);
                    StateManager.this.mEnterAnimView.setVisibility(0);
                }
                rootContainer.removeView(view2);
                StateManager stateManager = StateManager.this;
                boolean doAnimation = stateManager.doAnimation(view2, stateManager.mExitAnim, StateManager.this.mExitAnimView);
                StateManager stateManager2 = StateManager.this;
                boolean doAnimation2 = stateManager2.doAnimation(view3, stateManager2.mEnterAnim, StateManager.this.mEnterAnimView);
                StateManager.this.mExitAnim = 0;
                StateManager.this.mEnterAnim = 0;
                StateManager.this.scheduleTransitionAnimEnd((doAnimation || doAnimation2) ? true : true, null);
            }
        }, z2);
    }

    private void pushStateView(ActivityState activityState, ActivityState activityState2, Bundle bundle) {
        View view2;
        if (DEBUG) {
            Log.d(TAG, "StateManager#pushStateView  exitState = " + activityState + ",  enterState = " + activityState2);
        }
        View createView = activityState2.createView(getRootContainer(), bundle);
        if (activityState != null) {
            view2 = activityState.getRootView();
        } else {
            view2 = null;
        }
        activityState2.onStateCreated(null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        if (DEBUG) {
            Log.d(TAG, "StateManager#pushStateView  add view ===== mExitAnim = " + this.mExitAnim + ",  mEnterAnim = " + this.mEnterAnim);
        }
        processStateView(view2, createView, layoutParams, false);
    }

    @Override // com.baidu.searchbox.ui.state.ActivityContext
    public void startStateForResult(Class<? extends ActivityState> cls, int i, Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "StateManager#startStateForResult(), class = " + cls.getCanonicalName());
        }
        if (!isTransitionAnimEnd()) {
            if (DEBUG) {
                Log.e(TAG, "StateManager#startState(),  transition animation does NOT finished ");
            }
        } else if (handleLaunchMode(cls, bundle)) {
        } else {
            try {
                ActivityState newInstance = cls.newInstance();
                newInstance.initialize(this.mActivityContext, bundle);
                ActivityState.ResultEntry resultEntry = new ActivityState.ResultEntry();
                newInstance.mResult = resultEntry;
                resultEntry.requestCode = i;
                ActivityState topState = getTopState();
                if (topState != null) {
                    topState.mReceivedResults = newInstance.mResult;
                    if (this.mIsResumed) {
                        topState.pause();
                    }
                } else {
                    this.mResult = newInstance.mResult;
                }
                newInstance.onCreate(bundle, null);
                pushStateView(topState, newInstance, null);
                this.mStack.push(new StateEntry(bundle, newInstance));
                if (this.mIsResumed) {
                    newInstance.resume();
                }
                printStack();
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }
    }

    public void destroy() {
        if (DEBUG) {
            Log.i(TAG, "StateManager#destroy()=====");
        }
        FrameLayout rootContainer = getRootContainer();
        while (!this.mStack.isEmpty()) {
            ActivityState activityState = this.mStack.pop().activityState;
            activityState.onDestroy();
            activityState.activityDestroy();
            View rootView = activityState.getRootView();
            if (rootView != null) {
                rootContainer.removeView(rootView);
            }
        }
        this.mStack.clear();
    }

    public void finishState(ActivityState activityState, boolean z) {
        if (activityState == null) {
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "StateManager#finishState(),  begin ========  class = " + activityState.getClass());
        }
        if (!isTransitionAnimEnd()) {
            if (DEBUG) {
                Log.e(TAG, "StateManager#finishState(),  transition animation does NOT finished ");
            }
        } else if (this.mStack.isEmpty()) {
            if (DEBUG) {
                Log.d(TAG, "StateManager#finishState   stack is empty, size = 0");
            }
        } else {
            if (this.mFinishActivity && this.mStack.size() == 1) {
                Activity activity = (Activity) this.mActivityContext.getAndroidContext();
                ActivityState.ResultEntry resultEntry = this.mResult;
                if (resultEntry != null) {
                    activity.setResult(resultEntry.resultCode, resultEntry.resultData);
                }
                activity.finish();
                if (!activity.isFinishing()) {
                    if (DEBUG) {
                        Log.w(TAG, "StateManager#finishState(), finish is rejected, keep the last state");
                        return;
                    }
                    return;
                } else if (DEBUG) {
                    Log.v(TAG, "no more state, finish activity");
                }
            }
            if (DEBUG) {
                Log.v(TAG, "StateManager#finishState(), finishState " + activityState);
            }
            if (activityState != this.mStack.peek().activityState) {
                if (activityState.isDestroyed()) {
                    if (DEBUG) {
                        Log.d(TAG, "StateManager#finishState(), The state is already destroyed");
                        return;
                    }
                    return;
                } else if (!DEBUG) {
                    return;
                } else {
                    throw new IllegalArgumentException("The stateview to be finished is not at the top of the stack. finished state = " + activityState + ", current top state = " + this.mStack.peek().activityState);
                }
            }
            this.mStack.pop();
            if (this.mIsResumed) {
                activityState.pause();
            }
            activityState.onDestroy();
            if (!this.mStack.isEmpty()) {
                ActivityState activityState2 = this.mStack.peek().activityState;
                if (DEBUG) {
                    Log.d(TAG, "StateManager#finishState(),  after pop, the top state = " + activityState2);
                }
                if (this.mIsResumed) {
                    activityState2.resume();
                }
            }
            popStateView(activityState, getTopState(), z);
            printStack();
            if (DEBUG) {
                Log.d(TAG, "StateManager#finishState(),  end ========  class = " + activityState.getClass());
            }
        }
    }

    public boolean keyDown(int i, KeyEvent keyEvent) {
        ActivityState topState;
        if (DEBUG) {
            Log.d(TAG, "StateManager#keyDown, keyCode = " + i);
        }
        if (!this.mStack.isEmpty() && (topState = getTopState()) != null && topState.isResumed()) {
            return topState.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public boolean keyUp(int i, KeyEvent keyEvent) {
        ActivityState topState;
        if (DEBUG) {
            Log.d(TAG, "StateManager#keyDown, keyUp = " + i);
        }
        if (!this.mStack.isEmpty() && (topState = getTopState()) != null && topState.isResumed()) {
            return topState.onKeyUp(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.state.ActivityContext
    public void startState(Class<? extends ActivityState> cls, Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "StateManager#startActivityState(), class = " + cls.getCanonicalName());
        }
        if (!isTransitionAnimEnd()) {
            if (DEBUG) {
                Log.e(TAG, "StateManager#startState(),  transition animation does NOT finished ");
            }
        } else if (handleLaunchMode(cls, bundle)) {
        } else {
            try {
                startState(cls.newInstance(), bundle);
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.searchbox.ui.state.StateManager */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.ui.state.ActivityContext
    public void startState(ActivityState activityState, Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "StateManager#startState(),  begin ========  class = " + activityState.getClass());
        }
        if (!isTransitionAnimEnd()) {
            if (DEBUG) {
                Log.e(TAG, "StateManager#startState(),  transition animation does NOT finished ");
            }
        } else if (handleLaunchMode(activityState.getClass(), bundle)) {
        } else {
            ActivityState topState = getTopState();
            if (DEBUG) {
                Log.d(TAG, "    StateManager#startState(), top state = " + topState + ",   mIsResumed = " + this.mIsResumed);
            }
            if (topState != null && this.mIsResumed) {
                topState.pause();
            }
            activityState.initialize(this.mActivityContext, bundle);
            activityState.onCreate(bundle, null);
            pushStateView(topState, activityState, null);
            this.mStack.push(new StateEntry(bundle, activityState));
            if (this.mIsResumed) {
                activityState.resume();
            }
            printStack();
            if (DEBUG) {
                Log.d(TAG, "StateManager#startState(),  end ========  class = " + activityState.getClass());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.searchbox.ui.state.StateManager */
    /* JADX WARN: Multi-variable type inference failed */
    public void startState(ActivityState activityState, Bundle bundle, ActivityState... activityStateArr) {
        StateEntry findStateEntry;
        if (DEBUG) {
            Log.d(TAG, "StateManager#startState(),  begin ========  class = " + activityState.getClass());
        }
        if (!isTransitionAnimEnd()) {
            if (DEBUG) {
                Log.e(TAG, "StateManager#startState(),  transition animation does NOT finished ");
            }
        } else if (!handleLaunchMode(activityState.getClass(), bundle)) {
            activityState.initialize(this.mActivityContext, bundle);
            activityState.onCreate(bundle, null);
            pushStateView(null, activityState, null);
            this.mStack.push(new StateEntry(bundle, activityState));
            if (this.mIsResumed) {
                activityState.resume();
            }
            printStack();
            if (DEBUG) {
                Log.d(TAG, "StateManager#startState(),  end ========  class = " + activityState.getClass());
            }
            if (activityStateArr != null) {
                for (ActivityState activityState2 : activityStateArr) {
                    if (activityState2 != null && (findStateEntry = findStateEntry(activityState2)) != null) {
                        this.mStack.remove(findStateEntry);
                        if (this.mIsResumed) {
                            activityState2.onPause();
                        }
                        activityState2.onDestroy();
                        getRootContainer().removeView(activityState2.getRootView());
                        printStack();
                    }
                }
            }
        }
    }
}
