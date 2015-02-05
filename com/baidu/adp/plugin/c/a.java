package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a sA = null;
    private HashMap<String, ArrayList<Message<?>>> sz = null;

    public static a hP() {
        if (sA == null) {
            synchronized (a.class) {
                if (sA == null) {
                    sA = new a();
                }
            }
        }
        return sA;
    }

    public void init() {
        this.sz = new HashMap<>();
        hR();
        hQ();
    }

    private void hQ() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void hR() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.sz.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.sz.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
