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
    private static volatile a xB = null;
    private HashMap<String, ArrayList<Message<?>>> xA = null;

    public static a iU() {
        if (xB == null) {
            synchronized (a.class) {
                if (xB == null) {
                    xB = new a();
                }
            }
        }
        return xB;
    }

    public void init() {
        this.xA = new HashMap<>();
        iW();
        iV();
    }

    private void iV() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.xz == 0 && a.this.xA.size() > 0 && (arrayList = (ArrayList) a.this.xA.get(aVar.xy)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.xA.remove(aVar.xy);
                }
            }
        });
    }

    private void iW() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String ac = c.jH().ac(message.getCmd());
                if (TextUtils.isEmpty(ac) || c.jH().bn(ac)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(ac)) {
                    a.this.a(ac, message);
                    return PluginCenter.getInstance().launch(ac).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(ac)) {
                    return false;
                } else {
                    a.this.a(ac, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.xA.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.xA.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
