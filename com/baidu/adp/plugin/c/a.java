package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a su = null;
    private HashMap<String, ArrayList<Message<?>>> st = null;

    public static a hW() {
        if (su == null) {
            synchronized (a.class) {
                if (su == null) {
                    su = new a();
                }
            }
        }
        return su;
    }

    public void init() {
        this.st = new HashMap<>();
        hY();
        hX();
    }

    private void hX() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void hY() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.st.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.st.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
