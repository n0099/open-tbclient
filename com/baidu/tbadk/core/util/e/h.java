package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aBq;
    private HashMap<String, f> aBr = new HashMap<>();
    private LinkedList<String> aBs = new LinkedList<>();

    private h() {
    }

    public static h DA() {
        if (aBq == null) {
            synchronized (h.class) {
                if (aBq == null) {
                    aBq = new h();
                }
            }
        }
        return aBq;
    }

    public void J(List<String> list) {
        if (this.aBs != null) {
            this.aBs.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.aBr.get(str) == null) {
                    if (this.aBr.size() < e.Dy().Dz()) {
                        g.log("put loadingQueue  url: " + str);
                        f fR = fR(str);
                        this.aBr.put(str, fR);
                        fR.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.aBs.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fQ(String str) {
        f remove = this.aBr.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.aBs != null && this.aBs.size() > 0) {
            String pop = this.aBs.pop();
            f fR = fR(pop);
            this.aBr.put(pop, fR);
            g.log("processCallback put loadingQueue  url: " + pop);
            fR.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.aBs.size() + " mLoadingQueue.size()  " + this.aBr.size());
    }

    private f fR(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.fQ(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void az(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.fQ(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void fO(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.fQ(str2);
            }
        });
    }
}
