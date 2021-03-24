package com.baidu.megapp.ma;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
/* loaded from: classes2.dex */
public abstract class MAFragmentActivity extends FragmentActivity {
    public static final String TAG = "MAFragmentActivity";

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
