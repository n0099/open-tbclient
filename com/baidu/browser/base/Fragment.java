package com.baidu.browser.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
/* loaded from: classes.dex */
public abstract class Fragment {
    private static final boolean DEBUG = false;
    private static final String TAG = Fragment.class.getSimpleName();
    protected Activity mActivity;
    private RunningState mRunningState = RunningState.None;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum RunningState {
        None,
        OnCreate,
        OnRestart,
        OnStart,
        OnResume,
        OnPause,
        OnStop,
        OnDestroy;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static RunningState[] valuesCustom() {
            RunningState[] valuesCustom = values();
            int length = valuesCustom.length;
            RunningState[] runningStateArr = new RunningState[length];
            System.arraycopy(valuesCustom, 0, runningStateArr, 0, length);
            return runningStateArr;
        }
    }

    public Fragment(Activity activity) {
        this.mActivity = activity;
    }

    public void resume(Bundle bundle) {
        RunningState runningState = this.mRunningState;
        if (runningState.compareTo(RunningState.OnDestroy) >= 0) {
            throw new RuntimeException("Fragment has been destroyed!");
        }
        if (runningState.compareTo(RunningState.OnCreate) < 0) {
            onCreate(bundle);
        } else if (runningState.compareTo(RunningState.OnRestart) < 0 || runningState.compareTo(RunningState.OnStop) >= 0) {
            onRestart();
        }
        if (runningState.compareTo(RunningState.OnStart) < 0 || runningState.compareTo(RunningState.OnStop) >= 0) {
            onStart();
        }
        if (runningState.compareTo(RunningState.OnCreate) < 0 && bundle != null) {
            onRestoreInstanceState(bundle);
        }
        if (runningState.compareTo(RunningState.OnResume) < 0 || runningState.compareTo(RunningState.OnPause) >= 0) {
            onResume();
        }
    }

    public void stop() {
        if (this.mRunningState.compareTo(RunningState.OnDestroy) >= 0) {
            throw new RuntimeException("Fragment has been destroyed!");
        }
        if (this.mRunningState.compareTo(RunningState.OnResume) >= 0 && this.mRunningState.compareTo(RunningState.OnPause) < 0) {
            onPause();
        }
        if (this.mRunningState.compareTo(RunningState.OnStart) >= 0 && this.mRunningState.compareTo(RunningState.OnStop) < 0) {
            onStop();
        }
    }

    public void finish() {
        stop();
        if (this.mRunningState.compareTo(RunningState.OnCreate) >= 0 && this.mRunningState.compareTo(RunningState.OnDestroy) < 0) {
            onDestroy();
        }
    }

    public boolean isInForeground() {
        return this.mRunningState.compareTo(RunningState.OnResume) == 0;
    }

    public void onCreate(Bundle bundle) {
        this.mRunningState = RunningState.OnCreate;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onRestart() {
        this.mRunningState = RunningState.OnRestart;
    }

    public void onStart() {
        this.mRunningState = RunningState.OnStart;
    }

    public void onResume() {
        this.mRunningState = RunningState.OnResume;
    }

    public void onPause() {
        this.mRunningState = RunningState.OnPause;
    }

    public void onStop() {
        this.mRunningState = RunningState.OnStop;
    }

    public void onDestroy() {
        this.mRunningState = RunningState.OnDestroy;
    }

    public void onLowMemory() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return false;
    }
}
