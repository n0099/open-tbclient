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
    private static volatile a Rp = null;
    private HashMap<String, ArrayList<Message<?>>> Ro = null;

    public static a nN() {
        if (Rp == null) {
            synchronized (a.class) {
                if (Rp == null) {
                    Rp = new a();
                }
            }
        }
        return Rp;
    }

    public void init() {
        this.Ro = new HashMap<>();
        nP();
        nO();
    }

    private void nO() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.Rn == 0 && a.this.Ro.size() > 0 && (arrayList = (ArrayList) a.this.Ro.get(aVar.Rm)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Ro.remove(aVar.Rm);
                }
            }
        });
    }

    private void nP() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String as = c.oA().as(message.getCmd());
                if (TextUtils.isEmpty(as) || c.oA().cG(as)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(as)) {
                    a.this.a(as, message);
                    return PluginCenter.getInstance().launch(as).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(as)) {
                    return false;
                } else {
                    a.this.a(as, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Ro.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Ro.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
