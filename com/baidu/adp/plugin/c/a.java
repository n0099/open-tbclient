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
    private static volatile a KE = null;
    private HashMap<String, ArrayList<Message<?>>> KD = null;

    public static a mR() {
        if (KE == null) {
            synchronized (a.class) {
                if (KE == null) {
                    KE = new a();
                }
            }
        }
        return KE;
    }

    public void init() {
        this.KD = new HashMap<>();
        mT();
        mS();
    }

    private void mS() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.KC == 0 && a.this.KD.size() > 0 && (arrayList = (ArrayList) a.this.KD.get(aVar.KA)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.KD.remove(aVar.KA);
                }
            }
        });
    }

    private void mT() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String ba = c.nD().ba(message.getCmd());
                if (TextUtils.isEmpty(ba) || c.nD().ck(ba)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(ba)) {
                    a.this.a(ba, message);
                    return PluginCenter.getInstance().launch(ba).Jr;
                } else if (PluginCenter.getInstance().isLoaded(ba)) {
                    return false;
                } else {
                    a.this.a(ba, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.KD.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.KD.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
