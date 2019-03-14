package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bNo;
    private HashMap<String, f> bNp = new HashMap<>();
    private LinkedList<String> bNq = new LinkedList<>();

    private h() {
    }

    public static h aeb() {
        if (bNo == null) {
            synchronized (h.class) {
                if (bNo == null) {
                    bNo = new h();
                }
            }
        }
        return bNo;
    }

    public void V(List<String> list) {
        if (this.bNq != null) {
            this.bNq.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bNp.get(str) == null) {
                    if (this.bNp.size() < e.adZ().aea()) {
                        g.log("put loadingQueue  url: " + str);
                        f nj = nj(str);
                        this.bNp.put(str, nj);
                        nj.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bNq.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(String str) {
        f remove = this.bNp.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bNq != null && this.bNq.size() > 0) {
            String pop = this.bNq.pop();
            f nj = nj(pop);
            this.bNp.put(pop, nj);
            g.log("processCallback put loadingQueue  url: " + pop);
            nj.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bNq.size() + " mLoadingQueue.size()  " + this.bNp.size());
    }

    private f nj(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.ni(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void bL(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.ni(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void ng(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.ni(str2);
            }
        });
    }
}
