package com.baidu.adp.plugin.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static volatile a DN = null;
    private HashMap<String, ArrayList<Message<?>>> DM = null;

    public static a jo() {
        if (DN == null) {
            synchronized (a.class) {
                if (DN == null) {
                    DN = new a();
                }
            }
        }
        return DN;
    }

    public void init() {
        this.DM = new HashMap<>();
        jq();
        jp();
    }

    private void jp() {
        MessageManager.getInstance().registerListener(2000997, new b(this, 0));
    }

    private void jq() {
        MessageManager.getInstance().setNotFindTaskListener(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Message<?> message) {
        if (!TextUtils.isEmpty(str) && message != null) {
            ArrayList<Message<?>> arrayList = this.DM.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.DM.put(str, arrayList);
            }
            arrayList.add(message);
        }
    }
}
