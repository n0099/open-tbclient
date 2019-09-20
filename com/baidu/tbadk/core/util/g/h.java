package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bXd;
    private HashMap<String, f> bXe = new HashMap<>();
    private LinkedList<String> bXf = new LinkedList<>();

    private h() {
    }

    public static h akp() {
        if (bXd == null) {
            synchronized (h.class) {
                if (bXd == null) {
                    bXd = new h();
                }
            }
        }
        return bXd;
    }

    public void ac(List<String> list) {
        if (this.bXf != null) {
            this.bXf.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bXe.get(str) == null) {
                    if (this.bXe.size() < e.akn().ako()) {
                        g.log("put loadingQueue  url: " + str);
                        f oS = oS(str);
                        this.bXe.put(str, oS);
                        oS.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bXf.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(String str) {
        f remove = this.bXe.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bXf != null && this.bXf.size() > 0) {
            String pop = this.bXf.pop();
            f oS = oS(pop);
            this.bXe.put(pop, oS);
            g.log("processCallback put loadingQueue  url: " + pop);
            oS.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bXf.size() + " mLoadingQueue.size()  " + this.bXe.size());
    }

    private f oS(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.g.h.1
            @Override // com.baidu.tbadk.core.util.g.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.oR(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void bW(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.oR(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void oP(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.oR(str2);
            }
        });
    }
}
