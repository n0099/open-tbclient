package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a Ej = null;
    private HashMap<String, ArrayList<Message<?>>> Ei = null;

    public static a jj() {
        if (Ej == null) {
            synchronized (a.class) {
                if (Ej == null) {
                    Ej = new a();
                }
            }
        }
        return Ej;
    }

    public void init() {
        this.Ei = new HashMap<>();
        jl();
        jk();
    }

    private void jk() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void jl() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.Ei.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.Ei.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
