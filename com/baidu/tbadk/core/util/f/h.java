package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h ddo;
    private HashMap<String, f> ddp = new HashMap<>();
    private LinkedList<String> ddq = new LinkedList<>();

    private h() {
    }

    public static h aHo() {
        if (ddo == null) {
            synchronized (h.class) {
                if (ddo == null) {
                    ddo = new h();
                }
            }
        }
        return ddo;
    }

    public void aC(List<String> list) {
        if (this.ddq != null) {
            this.ddq.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.ddp.get(str) == null) {
                    if (this.ddp.size() < e.aHm().aHn()) {
                        g.log("put loadingQueue  url: " + str);
                        f tR = tR(str);
                        this.ddp.put(str, tR);
                        tR.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.ddq.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(String str) {
        f remove = this.ddp.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.ddq != null && this.ddq.size() > 0) {
            String pop = this.ddq.pop();
            f tR = tR(pop);
            this.ddp.put(pop, tR);
            g.log("processCallback put loadingQueue  url: " + pop);
            tR.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.ddq.size() + " mLoadingQueue.size()  " + this.ddp.size());
    }

    private f tR(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.f.h.1
            @Override // com.baidu.tbadk.core.util.f.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.tQ(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void cz(String str2, String str3) {
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
