package com.baidu.adp.plugin.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a sv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.sv = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof com.baidu.adp.plugin.message.a)) {
            com.baidu.adp.plugin.message.a aVar = (com.baidu.adp.plugin.message.a) data;
            if (aVar.errNo == 0) {
                hashMap2 = this.sv.st;
                if (hashMap2.size() > 0) {
                    hashMap3 = this.sv.st;
                    ArrayList arrayList = (ArrayList) hashMap3.get(aVar.ss);
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                }
            }
            hashMap = this.sv.st;
            hashMap.remove(aVar.ss);
        }
    }
}
