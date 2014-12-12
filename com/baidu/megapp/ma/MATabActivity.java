package com.baidu.megapp.ma;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public abstract class MATabActivity extends TabActivity {
    public void remapStartActivityIntent(Intent intent) {
    }

    public Context getCurrentMAActivity() {
        return getCurrentActivity();
    }
}
