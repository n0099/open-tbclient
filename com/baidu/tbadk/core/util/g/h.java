package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h cYM;
    private HashMap<String, f> cYN = new HashMap<>();
    private LinkedList<String> cYO = new LinkedList<>();

    private h() {
    }

    public static h aEG() {
        if (cYM == null) {
            synchronized (h.class) {
                if (cYM == null) {
                    cYM = new h();
                }
            }
        }
        return cYM;
    }

    public void aD(List<String> list) {
        if (this.cYO != null) {
            this.cYO.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.cYN.get(str) == null) {
                    if (this.cYN.size() < e.aEE().aEF()) {
                        g.log("put loadingQueue  url: " + str);
                        f tw = tw(str);
                        this.cYN.put(str, tw);
                        tw.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.cYO.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(String str) {
        f remove = this.cYN.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.cYO != null && this.cYO.size() > 0) {
            String pop = this.cYO.pop();
            f tw = tw(pop);
            this.cYN.put(pop, tw);
            g.log("processCallback put loadingQueue  url: " + pop);
            tw.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.cYO.size() + " mLoadingQueue.size()  " + this.cYN.size());
    }

    private f tw(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.g.h.1
            @Override // com.baidu.tbadk.core.util.g.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.tv(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void cq(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.tv(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void tt(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.tv(str2);
            }
        });
    }
}
