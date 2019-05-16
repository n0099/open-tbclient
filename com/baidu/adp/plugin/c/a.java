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
    private static volatile a IC = null;
    private HashMap<String, ArrayList<Message<?>>> IB = null;

    public static a lS() {
        if (IC == null) {
            synchronized (a.class) {
                if (IC == null) {
                    IC = new a();
                }
            }
        }
        return IC;
    }

    public void init() {
        this.IB = new HashMap<>();
        lU();
        lT();
    }

    private void lT() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.IA == 0 && a.this.IB.size() > 0 && (arrayList = (ArrayList) a.this.IB.get(aVar.Iz)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.IB.remove(aVar.Iz);
                }
            }
        });
    }

    private void lU() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aC = c.mG().aC(message.getCmd());
                if (TextUtils.isEmpty(aC) || c.mG().bU(aC)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aC)) {
                    a.this.a(aC, message);
                    return PluginCenter.getInstance().launch(aC).Hi;
                } else if (PluginCenter.getInstance().isLoaded(aC)) {
                    return false;
                } else {
                    a.this.a(aC, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.IB.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.IB.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
