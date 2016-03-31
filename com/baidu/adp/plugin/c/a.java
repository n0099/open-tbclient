package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a DW = null;
    private HashMap<String, ArrayList<Message<?>>> DV = null;

    public static a li() {
        if (DW == null) {
            synchronized (a.class) {
                if (DW == null) {
                    DW = new a();
                }
            }
        }
        return DW;
    }

    public void init() {
        this.DV = new HashMap<>();
        lk();
        lj();
    }

    private void lj() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void lk() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.DV.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.DV.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
