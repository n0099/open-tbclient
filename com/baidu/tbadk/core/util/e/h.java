package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bVc;
    private HashMap<String, f> bVd = new HashMap<>();
    private LinkedList<String> bVe = new LinkedList<>();

    private h() {
    }

    public static h aiX() {
        if (bVc == null) {
            synchronized (h.class) {
                if (bVc == null) {
                    bVc = new h();
                }
            }
        }
        return bVc;
    }

    public void ac(List<String> list) {
        if (this.bVe != null) {
            this.bVe.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bVd.get(str) == null) {
                    if (this.bVd.size() < e.aiV().aiW()) {
                        g.log("put loadingQueue  url: " + str);
                        f ou = ou(str);
                        this.bVd.put(str, ou);
                        ou.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bVe.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(String str) {
        f remove = this.bVd.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bVe != null && this.bVe.size() > 0) {
            String pop = this.bVe.pop();
            f ou = ou(pop);
            this.bVd.put(pop, ou);
            g.log("processCallback put loadingQueue  url: " + pop);
            ou.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bVe.size() + " mLoadingQueue.size()  " + this.bVd.size());
    }

    private f ou(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.ot(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void bV(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.ot(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void or(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.ot(str2);
            }
        });
    }
}
