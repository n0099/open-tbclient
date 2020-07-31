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
    private static volatile a RP = null;
    private HashMap<String, ArrayList<Message<?>>> RO = null;

    public static a oe() {
        if (RP == null) {
            synchronized (a.class) {
                if (RP == null) {
                    RP = new a();
                }
            }
        }
        return RP;
    }

    public void init() {
        this.RO = new HashMap<>();
        oh();
        og();
    }

    private void og() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.RL == 0 && a.this.RO.size() > 0 && (arrayList = (ArrayList) a.this.RO.get(aVar.RK)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.RO.remove(aVar.RK);
                }
            }
        });
    }

    private void oh() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aA = c.oR().aA(message.getCmd());
                if (TextUtils.isEmpty(aA) || c.oR().cF(aA)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aA)) {
                    a.this.a(aA, message);
                    return PluginCenter.getInstance().launch(aA).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(aA)) {
                    return false;
                } else {
                    a.this.a(aA, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.RO.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.RO.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
