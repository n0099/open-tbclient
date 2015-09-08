package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a Db = null;
    private HashMap<String, ArrayList<Message<?>>> Da = null;

    public static a lH() {
        if (Db == null) {
            synchronized (a.class) {
                if (Db == null) {
                    Db = new a();
                }
            }
        }
        return Db;
    }

    public void init() {
        this.Da = new HashMap<>();
        lJ();
        lI();
    }

    private void lI() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lJ() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Da.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Da.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
