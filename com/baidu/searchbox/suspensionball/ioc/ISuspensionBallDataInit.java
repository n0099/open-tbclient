package com.baidu.searchbox.suspensionball.ioc;

import android.app.Activity;
/* loaded from: classes9.dex */
public interface ISuspensionBallDataInit {
    boolean enableInitSuspensionData(Activity activity);

    Activity getTopActivity();

    void init();

    void release();
}
