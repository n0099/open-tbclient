package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a sD = null;
    private HashMap<String, ArrayList<Message<?>>> sC = null;

    public static a hW() {
        if (sD == null) {
            synchronized (a.class) {
                if (sD == null) {
                    sD = new a();
                }
            }
        }
        return sD;
    }

    public void init() {
        this.sC = new HashMap<>();
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
            ArrayList<Message<?>> arrayList = this.sC.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.sC.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
