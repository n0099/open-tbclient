package com.baidu.megapp.ma;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceActivity;
/* loaded from: classes2.dex */
public abstract class MAPreferenceActivity extends PreferenceActivity {
    public Activity getActivity() {
        return this;
    }

    public final Context getMAParent() {
        return super.getParent();
    }
}
