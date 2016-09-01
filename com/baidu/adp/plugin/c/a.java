package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a xe = null;
    private HashMap<String, ArrayList<Message<?>>> xd = null;

    public static a ir() {
        if (xe == null) {
            synchronized (a.class) {
                if (xe == null) {
                    xe = new a();
                }
            }
        }
        return xe;
    }

    public void init() {
        this.xd = new HashMap<>();
        it();
        is();
    }

    private void is() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void it() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.xd.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.xd.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
