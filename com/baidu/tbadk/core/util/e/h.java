package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aER;
    private HashMap<String, f> aES = new HashMap<>();
    private LinkedList<String> aET = new LinkedList<>();

    private h() {
    }

    public static h EE() {
        if (aER == null) {
            synchronized (h.class) {
                if (aER == null) {
                    aER = new h();
                }
            }
        }
        return aER;
    }

    public void J(List<String> list) {
        if (this.aET != null) {
            this.aET.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.aES.get(str) == null) {
                    if (this.aES.size() < e.EC().ED()) {
                        g.log("put loadingQueue  url: " + str);
                        f gk = gk(str);
                        this.aES.put(str, gk);
                        gk.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.aET.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        f remove = this.aES.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.aET != null && this.aET.size() > 0) {
            String pop = this.aET.pop();
            f gk = gk(pop);
            this.aES.put(pop, gk);
            g.log("processCallback put loadingQueue  url: " + pop);
            gk.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.aET.size() + " mLoadingQueue.size()  " + this.aES.size());
    }

    private f gk(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.gj(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void aC(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.gj(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void gh(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.gj(str2);
            }
        });
    }
}
