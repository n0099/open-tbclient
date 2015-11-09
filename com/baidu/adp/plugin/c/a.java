package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a De = null;
    private HashMap<String, ArrayList<Message<?>>> Dd = null;

    public static a lJ() {
        if (De == null) {
            synchronized (a.class) {
                if (De == null) {
                    De = new a();
                }
            }
        }
        return De;
    }

    public void init() {
        this.Dd = new HashMap<>();
        lL();
        lK();
    }

    private void lK() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lL() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Dd.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Dd.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
