package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a DK = null;
    private HashMap<String, ArrayList<Message<?>>> DJ = null;

    public static a jn() {
        if (DK == null) {
            synchronized (a.class) {
                if (DK == null) {
                    DK = new a();
                }
            }
        }
        return DK;
    }

    public void init() {
        this.DJ = new HashMap<>();
        jp();
        jo();
    }

    private void jo() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void jp() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.DJ.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.DJ.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
