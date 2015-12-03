package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a Dl = null;
    private HashMap<String, ArrayList<Message<?>>> Dk = null;

    public static a lL() {
        if (Dl == null) {
            synchronized (a.class) {
                if (Dl == null) {
                    Dl = new a();
                }
            }
        }
        return Dl;
    }

    public void init() {
        this.Dk = new HashMap<>();
        lN();
        lM();
    }

    private void lM() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lN() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Dk.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Dk.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
