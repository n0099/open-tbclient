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
    private static volatile a uY = null;
    private HashMap<String, ArrayList<Message<?>>> uX = null;

    public static a iB() {
        if (uY == null) {
            synchronized (a.class) {
                if (uY == null) {
                    uY = new a();
                }
            }
        }
        return uY;
    }

    public void init() {
        this.uX = new HashMap<>();
        iD();
        iC();
    }

    private void iC() {
        MessageManager.getInstance().registerListener(MessageConfig.PLUGIN_LOADED, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.uW == 0 && a.this.uX.size() > 0 && (arrayList = (ArrayList) a.this.uX.get(aVar.uV)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.uX.remove(aVar.uV);
                }
            }
        });
    }

    private void iD() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String Z = c.jp().Z(message.getCmd());
                if (TextUtils.isEmpty(Z) || c.jp().bd(Z)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(Z)) {
                    a.this.a(Z, message);
                    return PluginCenter.getInstance().launch(Z).isSucc;
                } else if (PluginCenter.getInstance().isLoaded(Z)) {
                    return false;
                } else {
                    a.this.a(Z, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.uX.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.uX.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
