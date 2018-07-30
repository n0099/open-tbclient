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
    private static volatile a HE = null;
    private HashMap<String, ArrayList<Message<?>>> HD = null;

    public static a lD() {
        if (HE == null) {
            synchronized (a.class) {
                if (HE == null) {
                    HE = new a();
                }
            }
        }
        return HE;
    }

    public void init() {
        this.HD = new HashMap<>();
        lF();
        lE();
    }

    private void lE() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.HC == 0 && a.this.HD.size() > 0 && (arrayList = (ArrayList) a.this.HD.get(aVar.HB)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.HD.remove(aVar.HB);
                }
            }
        });
    }

    private void lF() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aB = c.mp().aB(message.getCmd());
                if (TextUtils.isEmpty(aB) || c.mp().bU(aB)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aB)) {
                    a.this.a(aB, message);
                    return PluginCenter.getInstance().launch(aB).Gp;
                } else if (PluginCenter.getInstance().isLoaded(aB)) {
                    return false;
                } else {
                    a.this.a(aB, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.HD.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.HD.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
