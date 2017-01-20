package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a wV = null;
    private HashMap<String, ArrayList<Message<?>>> wU = null;

    public static a ip() {
        if (wV == null) {
            synchronized (a.class) {
                if (wV == null) {
                    wV = new a();
                }
            }
        }
        return wV;
    }

    public void init() {
        this.wU = new HashMap<>();
        ir();
        iq();
    }

    private void iq() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void ir() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.wU.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.wU.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
