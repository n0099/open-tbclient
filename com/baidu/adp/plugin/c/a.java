package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a Dd = null;
    private HashMap<String, ArrayList<Message<?>>> Dc = null;

    public static a lI() {
        if (Dd == null) {
            synchronized (a.class) {
                if (Dd == null) {
                    Dd = new a();
                }
            }
        }
        return Dd;
    }

    public void init() {
        this.Dc = new HashMap<>();
        lK();
        lJ();
    }

    private void lJ() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lK() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Dc.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Dc.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
