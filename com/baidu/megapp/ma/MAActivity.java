package com.baidu.megapp.ma;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
/* loaded from: classes15.dex */
public abstract class MAActivity extends Activity {
    public static final String TAG = "MAActivity";

    public Activity getActivity() {
        return this;
    }

    public final Context getMAParent() {
        return super.getParent();
    }

    public MABottomToolBar onGetBottomBar() {
        Log.d(TAG, "onGetBottomBar");
        return null;
    }

    public void setMABottomToolBarVisibility(int i) {
        Log.d(TAG, "setMABottomToolBarVisibility = " + i);
    }
}
