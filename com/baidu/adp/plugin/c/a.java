package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a uq = null;
    private HashMap<String, ArrayList<Message<?>>> up = null;

    public static a hx() {
        if (uq == null) {
            synchronized (a.class) {
                if (uq == null) {
                    uq = new a();
                }
            }
        }
        return uq;
    }

    public void init() {
        this.up = new HashMap<>();
        hz();
        hy();
    }

    private void hy() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void hz() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.up.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.up.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
