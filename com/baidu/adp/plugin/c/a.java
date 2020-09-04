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
import com.baidu.live.adp.framework.MessageConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static volatile a St = null;
    private HashMap<String, ArrayList<Message<?>>> Ss = null;

    public static a pE() {
        if (St == null) {
            synchronized (a.class) {
                if (St == null) {
                    St = new a();
                }
            }
        }
        return St;
    }

    public void init() {
        this.Ss = new HashMap<>();
        pG();
        pF();
    }

    private void pF() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.Sr == 0 && a.this.Ss.size() > 0 && (arrayList = (ArrayList) a.this.Ss.get(aVar.Sq)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Ss.remove(aVar.Sq);
                }
            }
        });
    }

    private void pG() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aC = c.qq().aC(message.getCmd());
                if (TextUtils.isEmpty(aC) || c.qq().cL(aC)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aC)) {
                    a.this.a(aC, message);
                    return PluginCenter.getInstance().launch(aC).isSucc;
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
            ArrayList<Message<?>> arrayList = this.Ss.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Ss.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
