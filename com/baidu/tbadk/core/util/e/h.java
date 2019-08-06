package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bWk;
    private HashMap<String, f> bWl = new HashMap<>();
    private LinkedList<String> bWm = new LinkedList<>();

    private h() {
    }

    public static h akd() {
        if (bWk == null) {
            synchronized (h.class) {
                if (bWk == null) {
                    bWk = new h();
                }
            }
        }
        return bWk;
    }

    public void ac(List<String> list) {
        if (this.bWm != null) {
            this.bWm.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bWl.get(str) == null) {
                    if (this.bWl.size() < e.akb().akc()) {
                        g.log("put loadingQueue  url: " + str);
                        f oK = oK(str);
                        this.bWl.put(str, oK);
                        oK.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bWm.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(String str) {
        f remove = this.bWl.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bWm != null && this.bWm.size() > 0) {
            String pop = this.bWm.pop();
            f oK = oK(pop);
            this.bWl.put(pop, oK);
            g.log("processCallback put loadingQueue  url: " + pop);
            oK.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bWm.size() + " mLoadingQueue.size()  " + this.bWl.size());
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
