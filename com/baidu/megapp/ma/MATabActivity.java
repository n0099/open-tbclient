package com.baidu.megapp.ma;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes2.dex */
public abstract class MATabActivity extends TabActivity {
    public static final String TAG = "MATabActivity";

    public Activity getActivity() {
        return this;
    }

    public Context getCurrentMAActivity() {
        return getCurrentActivity();
    }

    public final Context getMAParent() {
        return super.getParent();
    }

    public MABottomToolBar onGetBottomBar() {
        Log.d(TAG, "onGetBottomBar");
        return null;
    }

    public void remapStartActivityIntent(Intent intent) {
    }

    public void setMABottomToolBarVisibility(int i2) {
        Log.d(TAG, "setMABottomToolBarVisibility = " + i2);
    }
}
