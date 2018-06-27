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
    private static volatile a HH = null;
    private HashMap<String, ArrayList<Message<?>>> HG = null;

    public static a lB() {
        if (HH == null) {
            synchronized (a.class) {
                if (HH == null) {
                    HH = new a();
                }
            }
        }
        return HH;
    }

    public void init() {
        this.HG = new HashMap<>();
        lD();
        lC();
    }

    private void lC() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.HF == 0 && a.this.HG.size() > 0 && (arrayList = (ArrayList) a.this.HG.get(aVar.HE)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.HG.remove(aVar.HE);
                }
            }
        });
    }

    private void lD() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aA = c.mn().aA(message.getCmd());
                if (TextUtils.isEmpty(aA) || c.mn().bT(aA)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aA)) {
                    a.this.a(aA, message);
                    return PluginCenter.getInstance().launch(aA).Gr;
                } else if (PluginCenter.getInstance().isLoaded(aA)) {
                    return false;
                } else {
                    a.this.a(aA, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.HG.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.HG.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
