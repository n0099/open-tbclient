package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aEQ;
    private HashMap<String, f> aER = new HashMap<>();
    private LinkedList<String> aES = new LinkedList<>();

    private h() {
    }

    public static h EE() {
        if (aEQ == null) {
            synchronized (h.class) {
                if (aEQ == null) {
                    aEQ = new h();
                }
            }
        }
        return aEQ;
    }

    public void J(List<String> list) {
        if (this.aES != null) {
            this.aES.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.aER.get(str) == null) {
                    if (this.aER.size() < e.EC().ED()) {
                        g.log("put loadingQueue  url: " + str);
                        f gj = gj(str);
                        this.aER.put(str, gj);
                        gj.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.aES.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(String str) {
        f remove = this.aER.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.aES != null && this.aES.size() > 0) {
            String pop = this.aES.pop();
            f gj = gj(pop);
            this.aER.put(pop, gj);
            g.log("processCallback put loadingQueue  url: " + pop);
            gj.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.aES.size() + " mLoadingQueue.size()  " + this.aER.size());
    }

    private f gj(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.gi(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void aC(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.gi(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void gg(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.gi(str2);
            }
        });
    }
}
