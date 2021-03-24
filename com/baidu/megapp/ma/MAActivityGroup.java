package com.baidu.megapp.ma;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public abstract class MAActivityGroup extends ActivityGroup {
    public Activity getActivity() {
        return this;
    }

    public Context getCurrentMAActivity() {
        return getCurrentActivity();
    }

    public final Context getMAParent() {
        return super.getParent();
    }

    public void remapStartActivityIntent(Intent intent) {
    }
}
