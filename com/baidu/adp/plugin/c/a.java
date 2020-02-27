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
    private static volatile a xX = null;
    private HashMap<String, ArrayList<Message<?>>> xW = null;

    public static a ji() {
        if (xX == null) {
            synchronized (a.class) {
                if (xX == null) {
                    xX = new a();
                }
            }
        }
        return xX;
    }

    public void init() {
        this.xW = new HashMap<>();
        jk();
        jj();
    }

    private void jj() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.xV == 0 && a.this.xW.size() > 0 && (arrayList = (ArrayList) a.this.xW.get(aVar.xU)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.xW.remove(aVar.xU);
                }
            }
        });
    }

    private void jk() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String af = c.jV().af(message.getCmd());
                if (TextUtils.isEmpty(af) || c.jV().bp(af)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(af)) {
                    a.this.a(af, message);
                    return PluginCenter.getInstance().launch(af).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(af)) {
                    return false;
                } else {
                    a.this.a(af, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.xW.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.xW.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
