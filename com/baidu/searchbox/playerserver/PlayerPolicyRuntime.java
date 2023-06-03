package com.baidu.searchbox.playerserver;

import android.content.Context;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public class PlayerPolicyRuntime {
    public static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void init(Context context) {
        if (context != null) {
            sAppContext = context.getApplicationContext();
        }
    }
}
