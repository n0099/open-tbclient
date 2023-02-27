package com.baidu.searchbox.live.shell;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.baidu.live.arch.utils.LiveShellUIUtil;
/* loaded from: classes2.dex */
public class LiveBaseActivity extends FragmentActivity {
    public LayoutInflater mInflater;

    public Activity getActivity() {
        return this;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && LiveShellUIUtil.isTranslucentOrFloating(this)) {
            LiveShellUIUtil.fixOrientation(this);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT == 26 && LiveShellUIUtil.isTranslucentOrFloating(this)) {
            return;
        }
        super.setRequestedOrientation(i);
    }
}
