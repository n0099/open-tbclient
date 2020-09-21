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
    private static volatile a SO = null;
    private HashMap<String, ArrayList<Message<?>>> SM = null;

    public static a pJ() {
        if (SO == null) {
            synchronized (a.class) {
                if (SO == null) {
                    SO = new a();
                }
            }
        }
        return SO;
    }

    public void init() {
        this.SM = new HashMap<>();
        pL();
        pK();
    }

    private void pK() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.SL == 0 && a.this.SM.size() > 0 && (arrayList = (ArrayList) a.this.SM.get(aVar.SK)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.SM.remove(aVar.SK);
                }
            }
        });
    }

    private void pL() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aF = c.qv().aF(message.getCmd());
                if (TextUtils.isEmpty(aF) || c.qv().cN(aF)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aF)) {
                    a.this.a(aF, message);
                    return PluginCenter.getInstance().launch(aF).isSucc;
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
            ArrayList<Message<?>> arrayList = this.SM.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.SM.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
