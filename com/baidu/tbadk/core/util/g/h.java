package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h ddb;
    private HashMap<String, f> ddc = new HashMap<>();
    private LinkedList<String> ddd = new LinkedList<>();

    private h() {
    }

    public static h aHn() {
        if (ddb == null) {
            synchronized (h.class) {
                if (ddb == null) {
                    ddb = new h();
                }
            }
        }
        return ddb;
    }

    public void aC(List<String> list) {
        if (this.ddd != null) {
            this.ddd.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.ddc.get(str) == null) {
                    if (this.ddc.size() < e.aHl().aHm()) {
                        g.log("put loadingQueue  url: " + str);
                        f tQ = tQ(str);
                        this.ddc.put(str, tQ);
                        tQ.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.ddd.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(String str) {
        f remove = this.ddc.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.ddd != null && this.ddd.size() > 0) {
            String pop = this.ddd.pop();
            f tQ = tQ(pop);
            this.ddc.put(pop, tQ);
            g.log("processCallback put loadingQueue  url: " + pop);
            tQ.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.ddd.size() + " mLoadingQueue.size()  " + this.ddc.size());
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
