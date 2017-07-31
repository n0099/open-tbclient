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
    private static volatile a Fm = null;
    private HashMap<String, ArrayList<Message<?>>> Fl = null;

    public static a ju() {
        if (Fm == null) {
            synchronized (a.class) {
                if (Fm == null) {
                    Fm = new a();
                }
            }
        }
        return Fm;
    }

    public void init() {
        this.Fl = new HashMap<>();
        jw();
        jv();
    }

    private void jv() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.errNo == 0 && a.this.Fl.size() > 0 && (arrayList = (ArrayList) a.this.Fl.get(aVar.Fk)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.Fl.remove(aVar.Fk);
                }
            }
        });
    }

    private void jw() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aF = c.kh().aF(message.getCmd());
                if (TextUtils.isEmpty(aF) || c.kh().bD(aF)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aF)) {
                    a.this.a(aF, message);
                    return PluginCenter.getInstance().launch(aF).Ea;
                } else if (PluginCenter.getInstance().isLoaded(aF)) {
                    return false;
                } else {
                    a.this.a(aF, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Fl.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Fl.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
