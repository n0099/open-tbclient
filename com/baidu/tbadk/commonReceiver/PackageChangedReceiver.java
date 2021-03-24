package com.baidu.tbadk.commonReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.z0.d;
/* loaded from: classes3.dex */
public class PackageChangedReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL = "android.intent.action.PACKAGE_ADDED";
    public static final String ACTION_UNINSTALL = "android.intent.action.PACKAGE_REMOVED";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if (ACTION_INSTALL.equals(intent.getAction())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002501, intent));
        } else if (ACTION_UNINSTALL.equals(intent.getAction())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002502, intent));
        }
        d.s(intent);
    }
}
