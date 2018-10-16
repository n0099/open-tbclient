package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aAB;
    private HashMap<String, f> aAC = new HashMap<>();
    private LinkedList<String> aAD = new LinkedList<>();

    private h() {
    }

    public static h Dt() {
        if (aAB == null) {
            synchronized (h.class) {
                if (aAB == null) {
                    aAB = new h();
                }
            }
        }
        return aAB;
    }

    public void K(List<String> list) {
        if (this.aAD != null) {
            this.aAD.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.aAC.get(str) == null) {
                    if (this.aAC.size() < e.Dr().Ds()) {
                        g.log("put loadingQueue  url: " + str);
                        f fR = fR(str);
                        this.aAC.put(str, fR);
                        fR.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.aAD.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fQ(String str) {
        f remove = this.aAC.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.aAD != null && this.aAD.size() > 0) {
            String pop = this.aAD.pop();
            f fR = fR(pop);
            this.aAC.put(pop, fR);
            g.log("processCallback put loadingQueue  url: " + pop);
            fR.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.aAD.size() + " mLoadingQueue.size()  " + this.aAC.size());
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
