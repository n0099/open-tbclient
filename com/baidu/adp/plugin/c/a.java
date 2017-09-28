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
    private static volatile a Dk = null;
    private HashMap<String, ArrayList<Message<?>>> Dj = null;

    public static a jl() {
        if (Dk == null) {
            synchronized (a.class) {
                if (Dk == null) {
                    Dk = new a();
                }
            }
        }
        return Dk;
    }

    public void init() {
        this.Dj = new HashMap<>();
        jn();
        jm();
    }

    private void jm() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.errNo == 0 && a.this.Dj.size() > 0 && (arrayList = (ArrayList) a.this.Dj.get(aVar.Di)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Dj.remove(aVar.Di);
                }
            }
        });
    }

    private void jn() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aG = c.jX().aG(message.getCmd());
                if (TextUtils.isEmpty(aG) || c.jX().bA(aG)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aG)) {
                    a.this.a(aG, message);
                    return PluginCenter.getInstance().launch(aG).BY;
                } else if (PluginCenter.getInstance().isLoaded(aG)) {
                    return false;
                } else {
                    a.this.a(aG, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Dj.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Dj.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
