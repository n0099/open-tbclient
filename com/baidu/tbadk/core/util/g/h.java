package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h dda;
    private HashMap<String, f> ddb = new HashMap<>();
    private LinkedList<String> ddc = new LinkedList<>();

    private h() {
    }

    public static h aHl() {
        if (dda == null) {
            synchronized (h.class) {
                if (dda == null) {
                    dda = new h();
                }
            }
        }
        return dda;
    }

    public void aC(List<String> list) {
        if (this.ddc != null) {
            this.ddc.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.ddb.get(str) == null) {
                    if (this.ddb.size() < e.aHj().aHk()) {
                        g.log("put loadingQueue  url: " + str);
                        f tQ = tQ(str);
                        this.ddb.put(str, tQ);
                        tQ.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.ddc.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(String str) {
        f remove = this.ddb.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.ddc != null && this.ddc.size() > 0) {
            String pop = this.ddc.pop();
            f tQ = tQ(pop);
            this.ddb.put(pop, tQ);
            g.log("processCallback put loadingQueue  url: " + pop);
            tQ.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.ddc.size() + " mLoadingQueue.size()  " + this.ddb.size());
    }

    private f tQ(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.g.h.1
            @Override // com.baidu.tbadk.core.util.g.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.tP(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void cz(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.tP(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void tN(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.tP(str2);
            }
        });
    }
}
