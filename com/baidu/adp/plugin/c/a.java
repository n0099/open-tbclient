package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a DQ = null;
    private HashMap<String, ArrayList<Message<?>>> DP = null;

    public static a lt() {
        if (DQ == null) {
            synchronized (a.class) {
                if (DQ == null) {
                    DQ = new a();
                }
            }
        }
        return DQ;
    }

    public void init() {
        this.DP = new HashMap<>();
        lv();
        lu();
    }

    private void lu() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lv() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.DP.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.DP.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
