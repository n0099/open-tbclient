package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a Do = null;
    private HashMap<String, ArrayList<Message<?>>> Dn = null;

    public static a lj() {
        if (Do == null) {
            synchronized (a.class) {
                if (Do == null) {
                    Do = new a();
                }
            }
        }
        return Do;
    }

    public void init() {
        this.Dn = new HashMap<>();
        ll();
        lk();
    }

    private void lk() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void ll() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Dn.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Dn.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
