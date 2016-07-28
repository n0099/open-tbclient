package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a uS = null;
    private HashMap<String, ArrayList<Message<?>>> uR = null;

    public static a hw() {
        if (uS == null) {
            synchronized (a.class) {
                if (uS == null) {
                    uS = new a();
                }
            }
        }
        return uS;
    }

    public void init() {
        this.uR = new HashMap<>();
        hy();
        hx();
    }

    private void hx() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void hy() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.uR.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.uR.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
