package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.b;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.message.PluginLoadedMessage;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static volatile a CV = null;
    private HashMap<String, ArrayList<Message<?>>> CU = null;

    public static a ji() {
        if (CV == null) {
            synchronized (a.class) {
                if (CV == null) {
                    CV = new a();
                }
            }
        }
        return CV;
    }

    public void init() {
        this.CU = new HashMap<>();
        jk();
        jj();
    }

    private void jj() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.errNo == 0 && a.this.CU.size() > 0 && (arrayList = (ArrayList) a.this.CU.get(aVar.CT)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.CU.remove(aVar.CT);
                }
            }
        });
    }

    private void jk() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aF = c.jU().aF(message.getCmd());
                if (TextUtils.isEmpty(aF) || c.jU().bA(aF)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aF)) {
                    a.this.a(aF, message);
                    return PluginCenter.getInstance().launch(aF).BI;
                } else if (PluginCenter.getInstance().isLoaded(aF)) {
                    return false;
                } else {
                    a.this.a(aF, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.CU.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.CU.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
