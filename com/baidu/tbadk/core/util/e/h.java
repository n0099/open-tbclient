package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h avQ;
    private HashMap<String, f> avR = new HashMap<>();
    private LinkedList<String> avS = new LinkedList<>();

    private h() {
    }

    public static h Bm() {
        if (avQ == null) {
            synchronized (h.class) {
                if (avQ == null) {
                    avQ = new h();
                }
            }
        }
        return avQ;
    }

    public void A(List<String> list) {
        if (this.avS != null) {
            this.avS.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.avR.get(str) == null) {
                    if (this.avR.size() < e.Bk().Bl()) {
                        g.log("put loadingQueue  url: " + str);
                        f fD = fD(str);
                        this.avR.put(str, fD);
                        fD.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.avS.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC(String str) {
        f remove = this.avR.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.avS != null && this.avS.size() > 0) {
            String pop = this.avS.pop();
            f fD = fD(pop);
            this.avR.put(pop, fD);
            g.log("processCallback put loadingQueue  url: " + pop);
            fD.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.avS.size() + " mLoadingQueue.size()  " + this.avR.size());
    }

    private f fD(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.fC(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void an(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.fC(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void fA(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.fC(str2);
            }
        });
    }
}
