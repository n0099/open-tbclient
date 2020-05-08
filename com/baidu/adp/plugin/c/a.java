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
    private static volatile a Rf = null;
    private HashMap<String, ArrayList<Message<?>>> Re = null;

    public static a nL() {
        if (Rf == null) {
            synchronized (a.class) {
                if (Rf == null) {
                    Rf = new a();
                }
            }
        }
        return Rf;
    }

    public void init() {
        this.Re = new HashMap<>();
        nN();
        nM();
    }

    private void nM() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.Rc == 0 && a.this.Re.size() > 0 && (arrayList = (ArrayList) a.this.Re.get(aVar.Rb)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Re.remove(aVar.Rb);
                }
            }
        });
    }

    private void nN() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String ar = c.oz().ar(message.getCmd());
                if (TextUtils.isEmpty(ar) || c.oz().cF(ar)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(ar)) {
                    a.this.a(ar, message);
                    return PluginCenter.getInstance().launch(ar).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(ar)) {
                    return false;
                } else {
                    a.this.a(ar, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Re.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Re.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
