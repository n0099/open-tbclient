package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bNr;
    private HashMap<String, f> bNs = new HashMap<>();
    private LinkedList<String> bNt = new LinkedList<>();

    private h() {
    }

    public static h adY() {
        if (bNr == null) {
            synchronized (h.class) {
                if (bNr == null) {
                    bNr = new h();
                }
            }
        }
        return bNr;
    }

    public void V(List<String> list) {
        if (this.bNt != null) {
            this.bNt.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bNs.get(str) == null) {
                    if (this.bNs.size() < e.adW().adX()) {
                        g.log("put loadingQueue  url: " + str);
                        f nk = nk(str);
                        this.bNs.put(str, nk);
                        nk.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bNt.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(String str) {
        f remove = this.bNs.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bNt != null && this.bNt.size() > 0) {
            String pop = this.bNt.pop();
            f nk = nk(pop);
            this.bNs.put(pop, nk);
            g.log("processCallback put loadingQueue  url: " + pop);
            nk.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bNt.size() + " mLoadingQueue.size()  " + this.bNs.size());
    }

    private f nk(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.nj(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void bL(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.nj(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void nh(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.nj(str2);
            }
        });
    }
}
