package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h ddC;
    private HashMap<String, f> ddD = new HashMap<>();
    private LinkedList<String> ddE = new LinkedList<>();

    private h() {
    }

    public static h aHs() {
        if (ddC == null) {
            synchronized (h.class) {
                if (ddC == null) {
                    ddC = new h();
                }
            }
        }
        return ddC;
    }

    public void aC(List<String> list) {
        if (this.ddE != null) {
            this.ddE.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.ddD.get(str) == null) {
                    if (this.ddD.size() < e.aHq().aHr()) {
                        g.log("put loadingQueue  url: " + str);
                        f tR = tR(str);
                        this.ddD.put(str, tR);
                        tR.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.ddE.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(String str) {
        f remove = this.ddD.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.ddE != null && this.ddE.size() > 0) {
            String pop = this.ddE.pop();
            f tR = tR(pop);
            this.ddD.put(pop, tR);
            g.log("processCallback put loadingQueue  url: " + pop);
            tR.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.ddE.size() + " mLoadingQueue.size()  " + this.ddD.size());
    }

    private f tR(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.f.h.1
            @Override // com.baidu.tbadk.core.util.f.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.tQ(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void cy(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.tQ(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void tO(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.tQ(str2);
            }
        });
    }
}
