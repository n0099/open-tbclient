package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bVd;
    private HashMap<String, f> bVe = new HashMap<>();
    private LinkedList<String> bVf = new LinkedList<>();

    private h() {
    }

    public static h aiX() {
        if (bVd == null) {
            synchronized (h.class) {
                if (bVd == null) {
                    bVd = new h();
                }
            }
        }
        return bVd;
    }

    public void ac(List<String> list) {
        if (this.bVf != null) {
            this.bVf.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bVe.get(str) == null) {
                    if (this.bVe.size() < e.aiV().aiW()) {
                        g.log("put loadingQueue  url: " + str);
                        f ot = ot(str);
                        this.bVe.put(str, ot);
                        ot.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bVf.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void os(String str) {
        f remove = this.bVe.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bVf != null && this.bVf.size() > 0) {
            String pop = this.bVf.pop();
            f ot = ot(pop);
            this.bVe.put(pop, ot);
            g.log("processCallback put loadingQueue  url: " + pop);
            ot.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bVf.size() + " mLoadingQueue.size()  " + this.bVe.size());
    }

    private f ot(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.os(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void bV(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.os(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void oq(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.os(str2);
            }
        });
    }
}
