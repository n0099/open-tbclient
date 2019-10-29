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
    private static volatile a vz = null;
    private HashMap<String, ArrayList<Message<?>>> vy = null;

    public static a iB() {
        if (vz == null) {
            synchronized (a.class) {
                if (vz == null) {
                    vz = new a();
                }
            }
        }
        return vz;
    }

    public void init() {
        this.vy = new HashMap<>();
        iD();
        iC();
    }

    private void iC() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.vx == 0 && a.this.vy.size() > 0 && (arrayList = (ArrayList) a.this.vy.get(aVar.vw)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.vy.remove(aVar.vw);
                }
            }
        });
    }

    private void iD() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String Z = c.jp().Z(message.getCmd());
                if (TextUtils.isEmpty(Z) || c.jp().bd(Z)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(Z)) {
                    a.this.a(Z, message);
                    return PluginCenter.getInstance().launch(Z).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(Z)) {
                    return false;
                } else {
                    a.this.a(Z, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.vy.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.vy.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
