package com.baidu.tbadk.commonReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class PackageChangedReceiver extends BroadcastReceiver {
    private static final String ACTION_INSTALL = "android.intent.action.PACKAGE_ADDED";
    private static final String ACTION_UNINSTALL = "android.intent.action.PACKAGE_REMOVED";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (ACTION_INSTALL.equals(intent.getAction())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PACKAGE_ADDED, intent));
            } else if (ACTION_UNINSTALL.equals(intent.getAction())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PACKAGE_REMOVED, intent));
            }
        }
    }
}
