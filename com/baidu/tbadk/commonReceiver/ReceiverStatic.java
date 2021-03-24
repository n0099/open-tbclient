package com.baidu.tbadk.commonReceiver;

import android.content.IntentFilter;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class ReceiverStatic {
    static {
        ScreenLockReceiver screenLockReceiver = new ScreenLockReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        TbadkCoreApplication.getInst().registerReceiver(screenLockReceiver, intentFilter);
    }
}
