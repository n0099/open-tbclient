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
    private static volatile a ara = null;
    private HashMap<String, ArrayList<Message<?>>> aqZ = null;

    public static a qH() {
        if (ara == null) {
            synchronized (a.class) {
                if (ara == null) {
                    ara = new a();
                }
            }
        }
        return ara;
    }

    public void init() {
        this.aqZ = new HashMap<>();
        qJ();
        qI();
    }

    private void qI() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.errNo == 0 && a.this.aqZ.size() > 0 && (arrayList = (ArrayList) a.this.aqZ.get(aVar.aqY)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.aqZ.remove(aVar.aqY);
                }
            }
        });
    }

    private void qJ() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String dz = c.rt().dz(message.getCmd());
                if (TextUtils.isEmpty(dz) || c.rt().bI(dz)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(dz)) {
                    a.this.a(dz, message);
                    return PluginCenter.getInstance().launch(dz).apO;
                } else if (PluginCenter.getInstance().isLoaded(dz)) {
                    return false;
                } else {
                    a.this.a(dz, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.aqZ.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.aqZ.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
