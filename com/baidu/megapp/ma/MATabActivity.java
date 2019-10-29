package com.baidu.megapp.ma;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class MATabActivity extends TabActivity {
    public static final String TAG = "MATabActivity";

    public Activity getActivity() {
        return this;
    }

    public final Context getMAParent() {
        return super.getParent();
    }

    public Context getCurrentMAActivity() {
        return getCurrentActivity();
    }

    public void remapStartActivityIntent(Intent intent) {
    }

    public MABottomToolBar onGetBottomBar() {
        Log.d(TAG, "onGetBottomBar");
        return null;
    }

    public void setMABottomToolBarVisibility(int i) {
        Log.d(TAG, "setMABottomToolBarVisibility = " + i);
    }
}
