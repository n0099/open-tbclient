package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h dDb;
    private HashMap<String, f> dDc = new HashMap<>();
    private LinkedList<String> dDd = new LinkedList<>();

    private h() {
    }

    public static h aPK() {
        if (dDb == null) {
            synchronized (h.class) {
                if (dDb == null) {
                    dDb = new h();
                }
            }
        }
        return dDb;
    }

    public void aL(List<String> list) {
        if (this.dDd != null) {
            this.dDd.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.dDc.get(str) == null) {
                    if (this.dDc.size() < e.aPI().aPJ()) {
                        g.log("put loadingQueue  url: " + str);
                        f ve = ve(str);
                        this.dDc.put(str, ve);
                        ve.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.dDd.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vd(String str) {
        f remove = this.dDc.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.dDd != null && this.dDd.size() > 0) {
            String pop = this.dDd.pop();
            f ve = ve(pop);
            this.dDc.put(pop, ve);
            g.log("processCallback put loadingQueue  url: " + pop);
            ve.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.dDd.size() + " mLoadingQueue.size()  " + this.dDc.size());
    }

    private f ve(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.f.h.1
            @Override // com.baidu.tbadk.core.util.f.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.vd(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void cJ(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.vd(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void vb(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.vd(str2);
            }
        });
    }
}
