package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h dRm;
    private HashMap<String, f> dRn = new HashMap<>();
    private LinkedList<String> dRo = new LinkedList<>();

    private h() {
    }

    public static h aVL() {
        if (dRm == null) {
            synchronized (h.class) {
                if (dRm == null) {
                    dRm = new h();
                }
            }
        }
        return dRm;
    }

    public void aG(List<String> list) {
        if (this.dRo != null) {
            this.dRo.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.dRn.get(str) == null) {
                    if (this.dRn.size() < e.aVJ().aVK()) {
                        g.log("put loadingQueue  url: " + str);
                        f wN = wN(str);
                        this.dRn.put(str, wN);
                        wN.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.dRo.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(String str) {
        f remove = this.dRn.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.dRo != null && this.dRo.size() > 0) {
            String pop = this.dRo.pop();
            f wN = wN(pop);
            this.dRn.put(pop, wN);
            g.log("processCallback put loadingQueue  url: " + pop);
            wN.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.dRo.size() + " mLoadingQueue.size()  " + this.dRn.size());
    }

    private f wN(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.f.h.1
            @Override // com.baidu.tbadk.core.util.f.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.wM(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void di(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.wM(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void wK(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.wM(str2);
            }
        });
    }
}
