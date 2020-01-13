package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h cYW;
    private HashMap<String, f> cYX = new HashMap<>();
    private LinkedList<String> cYY = new LinkedList<>();

    private h() {
    }

    public static h aEZ() {
        if (cYW == null) {
            synchronized (h.class) {
                if (cYW == null) {
                    cYW = new h();
                }
            }
        }
        return cYW;
    }

    public void aC(List<String> list) {
        if (this.cYY != null) {
            this.cYY.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.cYX.get(str) == null) {
                    if (this.cYX.size() < e.aEX().aEY()) {
                        g.log("put loadingQueue  url: " + str);
                        f tA = tA(str);
                        this.cYX.put(str, tA);
                        tA.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.cYY.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz(String str) {
        f remove = this.cYX.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.cYY != null && this.cYY.size() > 0) {
            String pop = this.cYY.pop();
            f tA = tA(pop);
            this.cYX.put(pop, tA);
            g.log("processCallback put loadingQueue  url: " + pop);
            tA.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.cYY.size() + " mLoadingQueue.size()  " + this.cYX.size());
    }

    private f tA(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.g.h.1
            @Override // com.baidu.tbadk.core.util.g.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.tz(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void cq(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.tz(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void tx(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.tz(str2);
            }
        });
    }
}
