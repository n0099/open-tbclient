package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a Df = null;
    private HashMap<String, ArrayList<Message<?>>> De = null;

    public static a lD() {
        if (Df == null) {
            synchronized (a.class) {
                if (Df == null) {
                    Df = new a();
                }
            }
        }
        return Df;
    }

    public void init() {
        this.De = new HashMap<>();
        lF();
        lE();
    }

    private void lE() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lF() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.De.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.De.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
