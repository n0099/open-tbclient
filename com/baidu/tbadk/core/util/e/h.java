package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h bNn;
    private HashMap<String, f> bNo = new HashMap<>();
    private LinkedList<String> bNp = new LinkedList<>();

    private h() {
    }

    public static h aeb() {
        if (bNn == null) {
            synchronized (h.class) {
                if (bNn == null) {
                    bNn = new h();
                }
            }
        }
        return bNn;
    }

    public void V(List<String> list) {
        if (this.bNp != null) {
            this.bNp.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.bNo.get(str) == null) {
                    if (this.bNo.size() < e.adZ().aea()) {
                        g.log("put loadingQueue  url: " + str);
                        f nj = nj(str);
                        this.bNo.put(str, nj);
                        nj.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.bNp.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(String str) {
        f remove = this.bNo.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.bNp != null && this.bNp.size() > 0) {
            String pop = this.bNp.pop();
            f nj = nj(pop);
            this.bNo.put(pop, nj);
            g.log("processCallback put loadingQueue  url: " + pop);
            nj.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.bNp.size() + " mLoadingQueue.size()  " + this.bNo.size());
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
