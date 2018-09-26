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
    private static volatile a Kb = null;
    private HashMap<String, ArrayList<Message<?>>> Ka = null;

    public static a mJ() {
        if (Kb == null) {
            synchronized (a.class) {
                if (Kb == null) {
                    Kb = new a();
                }
            }
        }
        return Kb;
    }

    public void init() {
        this.Ka = new HashMap<>();
        mL();
        mK();
    }

    private void mK() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.JZ == 0 && a.this.Ka.size() > 0 && (arrayList = (ArrayList) a.this.Ka.get(aVar.JY)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Ka.remove(aVar.JY);
                }
            }
        });
    }

    private void mL() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aJ = c.nv().aJ(message.getCmd());
                if (TextUtils.isEmpty(aJ) || c.nv().cl(aJ)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aJ)) {
                    a.this.a(aJ, message);
                    return PluginCenter.getInstance().launch(aJ).IM;
                } else if (PluginCenter.getInstance().isLoaded(aJ)) {
                    return false;
                } else {
                    a.this.a(aJ, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Ka.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Ka.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
