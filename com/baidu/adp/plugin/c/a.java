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
    private static volatile a RT = null;
    private HashMap<String, ArrayList<Message<?>>> RR = null;

    public static a od() {
        if (RT == null) {
            synchronized (a.class) {
                if (RT == null) {
                    RT = new a();
                }
            }
        }
        return RT;
    }

    public void init() {
        this.RR = new HashMap<>();
        og();
        oe();
    }

    private void oe() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.RQ == 0 && a.this.RR.size() > 0 && (arrayList = (ArrayList) a.this.RR.get(aVar.RP)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.RR.remove(aVar.RP);
                }
            }
        });
    }

    private void og() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String ay = c.oQ().ay(message.getCmd());
                if (TextUtils.isEmpty(ay) || c.oQ().cH(ay)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(ay)) {
                    a.this.a(ay, message);
                    return PluginCenter.getInstance().launch(ay).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(ay)) {
                    return false;
                } else {
                    a.this.a(ay, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.RR.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.RR.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
