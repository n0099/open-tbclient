package com.baidu.browser.core;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class BdRootActivity extends Activity {
    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b.sI().getResources();
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return b.sI().getSharedPreferences(str, i);
    }
}
