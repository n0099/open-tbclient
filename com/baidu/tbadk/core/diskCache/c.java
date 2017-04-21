package com.baidu.tbadk.core.diskCache;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Handler handler;
        boolean z;
        Handler handler2;
        if (customResponsedMessage instanceof BackgroundSwitchMessage) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                z = a.abw;
                if (!z) {
                    handler2 = a.oz;
                    handler2.sendEmptyMessageDelayed(1, 10000L);
                    return;
                }
                return;
            }
            handler = a.oz;
            handler.removeMessages(1);
            a.stopService();
        }
    }
}
