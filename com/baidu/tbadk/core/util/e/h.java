package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aFt;
    private HashMap<String, f> aFu = new HashMap<>();
    private LinkedList<String> aFv = new LinkedList<>();

    private h() {
    }

    public static h ER() {
        if (aFt == null) {
            synchronized (h.class) {
                if (aFt == null) {
                    aFt = new h();
                }
            }
        }
        return aFt;
    }

    public void K(List<String> list) {
        if (this.aFv != null) {
            this.aFv.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.aFu.get(str) == null) {
                    if (this.aFu.size() < e.EP().EQ()) {
                        g.log("put loadingQueue  url: " + str);
                        f gy = gy(str);
                        this.aFu.put(str, gy);
                        gy.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.aFv.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(String str) {
        f remove = this.aFu.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.aFv != null && this.aFv.size() > 0) {
            String pop = this.aFv.pop();
            f gy = gy(pop);
            this.aFu.put(pop, gy);
            g.log("processCallback put loadingQueue  url: " + pop);
            gy.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.aFv.size() + " mLoadingQueue.size()  " + this.aFu.size());
    }

    private f gy(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.e.h.1
            @Override // com.baidu.tbadk.core.util.e.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.gx(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void aD(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.gx(str2);
            }

            @Override // com.baidu.tbadk.core.util.e.b
            public void gv(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.gx(str2);
            }
        });
    }
}
