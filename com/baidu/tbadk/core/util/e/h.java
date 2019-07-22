package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bWe;
    private HashMap<String, f> bWf = new HashMap<>();
    private LinkedList<String> bWg = new LinkedList<>();

    private h() {
    }

    public static h akb() {
        if (bWe == null) {
            synchronized (h.class) {
                if (bWe == null) {
                    bWe = new h();
                }
            }
        }
        return bWe;
    }

    public void ac(List<String> list) {
        if (this.bWg != null) {
            this.bWg.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bWf.get(str) == null) {
                    if (this.bWf.size() < e.ajZ().aka()) {
                        g.log("put loadingQueue  url: " + str);
                        f oK = oK(str);
                        this.bWf.put(str, oK);
                        oK.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bWg.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(String str) {
        f remove = this.bWf.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bWg != null && this.bWg.size() > 0) {
            String pop = this.bWg.pop();
            f oK = oK(pop);
            this.bWf.put(pop, oK);
            g.log("processCallback put loadingQueue  url: " + pop);
            oK.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bWg.size() + " mLoadingQueue.size()  " + this.bWf.size());
    }

    private f oK(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.oJ(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void bW(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.oJ(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void oH(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.oJ(str2);
            }
        });
    }
}
