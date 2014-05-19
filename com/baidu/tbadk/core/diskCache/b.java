package com.baidu.tbadk.core.diskCache;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Handler handler;
        boolean z;
        Handler handler2;
        if (customResponsedMessage instanceof BackgroundSwitchMessage) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                z = ImagesInvalidService.a;
                if (!z) {
                    handler2 = ImagesInvalidService.b;
                    handler2.sendEmptyMessageDelayed(1, 10000L);
                    return;
                }
                return;
            }
            handler = ImagesInvalidService.b;
            handler.removeMessages(1);
            ImagesInvalidService.f();
        }
    }
}
