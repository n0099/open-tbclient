package com.baidu.tbadk.core.diskCache;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes.dex */
public class a {
    private static boolean bOs = false;
    private static Handler sHandler = new Handler() { // from class: com.baidu.tbadk.core.diskCache.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.startService();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void startService() {
        f.e(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void stopService() {
        f.f(BdBaseApplication.getInst().getContext(), new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidService.class));
    }

    public static void dY(boolean z) {
        bOs = z;
    }

    public static void init() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.core.diskCache.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        if (!a.bOs) {
                            a.sHandler.sendEmptyMessageDelayed(1, 10000L);
                            return;
                        }
                        return;
                    }
                    a.sHandler.removeMessages(1);
                    a.stopService();
                }
            }
        });
    }
}
