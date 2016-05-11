package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a uo = null;
    private HashMap<String, ArrayList<Message<?>>> um = null;

    public static a hv() {
        if (uo == null) {
            synchronized (a.class) {
                if (uo == null) {
                    uo = new a();
                }
            }
        }
        return uo;
    }

    public void init() {
        this.um = new HashMap<>();
        hx();
        hw();
    }

    private void hw() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void hx() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.um.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.um.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
