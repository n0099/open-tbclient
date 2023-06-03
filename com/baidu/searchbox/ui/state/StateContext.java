package com.baidu.searchbox.ui.state;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.NoProGuard;
/* loaded from: classes4.dex */
public interface StateContext extends NoProGuard {
    Context getContext();

    Intent getIntent();

    void onActivityDestroy();

    void onCreate(Bundle bundle, Bundle bundle2);

    void onDestroy();

    void onPause();

    void onResume();

    void setIntent(Intent intent);

    void setStateResult(int i, Intent intent);

    void startState(Class<? extends ActivityState> cls);

    void startState(Class<? extends ActivityState> cls, Bundle bundle);

    void startStateForResult(Class<? extends ActivityState> cls, int i);

    void startStateForResult(Class<? extends ActivityState> cls, int i, Bundle bundle);
}
