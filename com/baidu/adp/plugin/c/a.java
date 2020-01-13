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
    private static volatile a xF = null;
    private HashMap<String, ArrayList<Message<?>>> xE = null;

    public static a iT() {
        if (xF == null) {
            synchronized (a.class) {
                if (xF == null) {
                    xF = new a();
                }
            }
        }
        return xF;
    }

    public void init() {
        this.xE = new HashMap<>();
        iV();
        iU();
    }

    private void iU() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.xD == 0 && a.this.xE.size() > 0 && (arrayList = (ArrayList) a.this.xE.get(aVar.xC)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.xE.remove(aVar.xC);
                }
            }
        });
    }

    private void iV() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String ac = c.jG().ac(message.getCmd());
                if (TextUtils.isEmpty(ac) || c.jG().bn(ac)) {
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
            ArrayList<Message<?>> arrayList = this.xE.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.xE.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
