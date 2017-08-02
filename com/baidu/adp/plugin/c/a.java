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
    private static volatile a DN = null;
    private HashMap<String, ArrayList<Message<?>>> DM = null;

    public static a jk() {
        if (DN == null) {
            synchronized (a.class) {
                if (DN == null) {
                    DN = new a();
                }
            }
        }
        return DN;
    }

    public void init() {
        this.DM = new HashMap<>();
        jm();
        jl();
    }

    private void jl() {
        MessageManager.getInstance().registerListener(2000997, new CustomMessageListener(0) { // from class: com.baidu.adp.plugin.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data;
                ArrayList arrayList;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000997 && (data = customResponsedMessage.getData()) != null && (data instanceof PluginLoadedMessage.a)) {
                    PluginLoadedMessage.a aVar = (PluginLoadedMessage.a) data;
                    if (aVar.errNo == 0 && a.this.DM.size() > 0 && (arrayList = (ArrayList) a.this.DM.get(aVar.DL)) != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().sendMessage((Message) it.next());
                        }
                    }
                    a.this.DM.remove(aVar.DL);
                }
            }
        });
    }

    private void jm() {
        MessageManager.getInstance().setNotFindTaskListener(new b<Message<?>>() { // from class: com.baidu.adp.plugin.c.a.2
            @Override // com.baidu.adp.framework.listener.b
            public boolean a(Message<?> message) {
                if (message == null) {
                    return false;
                }
                String aD = c.jX().aD(message.getCmd());
                if (TextUtils.isEmpty(aD) || c.jX().bx(aD)) {
                    return false;
                }
                if (!PluginCenter.getInstance().hasInstance(aD)) {
                    a.this.a(aD, message);
                    return PluginCenter.getInstance().launch(aD).CB;
                } else if (PluginCenter.getInstance().isLoaded(aD)) {
                    return false;
                } else {
                    a.this.a(aD, message);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.DM.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.DM.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
