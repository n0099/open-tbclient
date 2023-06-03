package com.baidu.searchbox.ui.state;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.CommonConfig;
/* loaded from: classes4.dex */
public abstract class ActivityState implements StateContext {
    public static final boolean DEBUG = CommonConfig.DEBUG & true;
    public static final String TAG = "ActivityState";
    public ActivityContext mContext;
    public Bundle mData;
    public Intent mIntent;
    public ResultEntry mReceivedResults;
    public ResultEntry mResult;
    public View mRootView;
    public boolean mIsInited = false;
    public boolean mDestroyed = false;
    public boolean mIsFinishing = false;
    public boolean mResumed = false;
    public boolean mActivityDestroy = false;

    /* loaded from: classes4.dex */
    public static class ResultEntry {
        public int requestCode;
        public int resultCode = 0;
        public Intent resultData;
    }

    public int getLaunchMode() {
        return 0;
    }

    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void onDestroyView() {
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onLowMemory() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void activityDestroy() {
        if (!this.mActivityDestroy) {
            this.mActivityDestroy = true;
            onActivityDestroy();
        }
    }

    public ActivityContext getActivityContext() {
        return this.mContext;
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public Context getContext() {
        ActivityContext activityContext = this.mContext;
        if (activityContext == null) {
            if (!DEBUG) {
                return null;
            }
            throw new IllegalStateException("The context is null, do you forget initialize this state?");
        }
        return activityContext.getAndroidContext();
    }

    public Bundle getData() {
        return this.mData;
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public Intent getIntent() {
        return this.mIntent;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isFinishing() {
        return this.mIsFinishing;
    }

    public boolean isInitialized() {
        return this.mIsInited;
    }

    public boolean isResumed() {
        return this.mResumed;
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void onActivityDestroy() {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onActivityDestroy()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public void onBackPressed() {
        View rootView = getRootView();
        if (rootView != null) {
            rootView.post(new Runnable() { // from class: com.baidu.searchbox.ui.state.ActivityState.1
                @Override // java.lang.Runnable
                public void run() {
                    ActivityState.this.finish();
                }
            });
        } else {
            finish();
        }
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void onDestroy() {
        this.mIsInited = false;
        this.mDestroyed = true;
        this.mResumed = false;
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onDestroy()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void onPause() {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onPause()----- class = " + ActivityState.class.getCanonicalName());
        }
        this.mResumed = false;
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void onResume() {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onResume()----- class = " + ActivityState.class.getCanonicalName());
        }
        this.mResumed = true;
        this.mDestroyed = false;
    }

    public void pause() {
        onPause();
    }

    public void resume() {
        ResultEntry resultEntry = this.mReceivedResults;
        if (resultEntry != null) {
            this.mReceivedResults = null;
            onStateResult(resultEntry.requestCode, resultEntry.resultCode, resultEntry.resultData);
        }
        onResume();
    }

    public View createView(ViewGroup viewGroup, Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#createView ===== class = " + ActivityState.class.getCanonicalName());
        }
        if (this.mContext != null) {
            View onCreateView = onCreateView(LayoutInflater.from(getContext()), viewGroup, bundle);
            if (onCreateView != null) {
                setRootView(onCreateView);
                return onCreateView;
            }
            throw new IllegalStateException("The onCreateView can NOT return null view.");
        }
        throw new IllegalStateException("The context is null, do you forget initialize this state?");
    }

    public void finish() {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#finish()----- class = " + ActivityState.class.getCanonicalName());
        }
        ActivityContext activityContext = this.mContext;
        if (activityContext != null) {
            this.mIsFinishing = true;
            activityContext.finishState(this);
            return;
        }
        throw new IllegalStateException("The context is null, do you forget initialize this state?");
    }

    public void initialize(ActivityContext activityContext, Bundle bundle) {
        if (activityContext == null) {
            if (!DEBUG) {
                return;
            }
            throw new IllegalStateException("The context is null, do you forget initialize this state?");
        }
        this.mIsInited = true;
        this.mContext = activityContext;
        this.mData = bundle;
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void onCreate(Bundle bundle, Bundle bundle2) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onCreate()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            onBackPressed();
            return true;
        }
        return false;
    }

    public final void overridePendingTransition(int i, int i2) {
        ActivityContext activityContext = this.mContext;
        if (activityContext == null) {
            if (!DEBUG) {
                return;
            }
            throw new IllegalStateException("The context is null, do you forget initialize this state?");
        }
        activityContext.overridePendingTransition(i, i2);
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void setStateResult(int i, Intent intent) {
        ResultEntry resultEntry = this.mResult;
        if (resultEntry == null) {
            return;
        }
        resultEntry.resultCode = i;
        resultEntry.resultData = intent;
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void startState(Class<? extends ActivityState> cls, Bundle bundle) {
        ActivityContext activityContext = this.mContext;
        if (activityContext == null) {
            if (!DEBUG) {
                return;
            }
            throw new IllegalStateException("The context is null, do you forget initialize this state?");
        }
        activityContext.startState(cls, bundle);
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void startStateForResult(Class<? extends ActivityState> cls, int i) {
        startStateForResult(cls, i, null);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onConfigurationChanged()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public void onRestoreState(Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onRestoreState()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public void onSaveState(Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onSaveState()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public void onStateCreated(Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onStateCreated()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onWindowFocusChanged()----- class = " + ActivityState.class.getCanonicalName() + ", hasFocus = " + z);
        }
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setRootView(View view2) {
        this.mRootView = view2;
    }

    public void setVisibility(int i) {
        View rootView = getRootView();
        if (rootView != null) {
            rootView.setVisibility(i);
        }
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void startState(Class<? extends ActivityState> cls) {
        startState(cls, null);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onRequestPermissionsResult()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    public void onStateResult(int i, int i2, Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "ActivityState#onStateResult()----- class = " + ActivityState.class.getCanonicalName());
        }
    }

    @Override // com.baidu.searchbox.ui.state.StateContext
    public void startStateForResult(Class<? extends ActivityState> cls, int i, Bundle bundle) {
        ActivityContext activityContext = this.mContext;
        if (activityContext == null) {
            if (!DEBUG) {
                return;
            }
            throw new IllegalStateException("The context is null, do you forget initialize this state?");
        }
        activityContext.startStateForResult(cls, i, bundle);
    }
}
