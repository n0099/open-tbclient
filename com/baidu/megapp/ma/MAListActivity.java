package com.baidu.megapp.ma;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
/* loaded from: classes16.dex */
public abstract class MAListActivity extends ListActivity {
    public Activity getActivity() {
        return this;
    }

    public final Context getMAParent() {
        return super.getParent();
    }
}
