package com.baidu.searchbox.ui.state;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.NoProGuard;
/* loaded from: classes4.dex */
public interface ActivityContext extends NoProGuard {
    void finishState(ActivityState activityState);

    Context getAndroidContext();

    void overridePendingTransition(int i, int i2);

    void startState(ActivityState activityState, Bundle bundle);

    void startState(Class<? extends ActivityState> cls, Bundle bundle);

    void startStateForResult(Class<? extends ActivityState> cls, int i, Bundle bundle);
}
