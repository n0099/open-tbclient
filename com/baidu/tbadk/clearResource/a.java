package com.baidu.tbadk.clearResource;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        long j2 = com.baidu.tbadk.core.sharedPref.b.tZ().getLong("key_clear_resource", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        j = ClearResourceStatic.SN;
        if (currentTimeMillis - j2 > j) {
            new b(this).start();
            com.baidu.tbadk.core.sharedPref.b.tZ().putLong("key_clear_resource", currentTimeMillis);
        }
    }
}
