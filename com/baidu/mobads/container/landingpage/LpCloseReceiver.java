package com.baidu.mobads.container.landingpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class LpCloseReceiver extends BroadcastReceiver {
    public static final String LP_ACTIVITY_CLOSE_ACTION = "lp_close";
    public LpCloseController mController;

    public LpCloseReceiver(LpCloseController lpCloseController) {
        this.mController = lpCloseController;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LpCloseController lpCloseController;
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || !"lp_close".equals(action) || (lpCloseController = this.mController) == null) {
            return;
        }
        lpCloseController.onLpClosed();
    }
}
