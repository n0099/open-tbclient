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
    private static volatile a Bx = null;
    private HashMap<String, ArrayList<Message<?>>> Bw = null;

    public static a iN() {
        if (Bx == null) {
            synchronized (a.class) {
                if (Bx == null) {
                    Bx = new a();
                }
            }
        }
        return Bx;
    }

    public void init() {
        this.Bw = new HashMap<>();
        iP();
        iO();
    }

    private void iO() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.Bv == 0 && a.this.Bw.size() > 0 && (arrayList = (ArrayList) a.this.Bw.get(aVar.Bu)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Bw.remove(aVar.Bu);
                }
            }
        });
    }

    private void iP() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String az = c.jz().az(message.getCmd());
                if (TextUtils.isEmpty(az) || c.jz().bF(az)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(az)) {
                    a.this.a(az, message);
                    return PluginCenter.getInstance().launch(az).Ai;
                } else if (PluginCenter.getInstance().isLoaded(az)) {
                    return false;
                } else {
                    a.this.a(az, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Bw.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Bw.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
