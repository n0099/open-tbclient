package com.baidu.tbadk.core.util.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aFu;
    private HashMap<String, f> aFv = new HashMap<>();
    private LinkedList<String> aFw = new LinkedList<>();

    private h() {
    }

    public static h ER() {
        if (aFu == null) {
            synchronized (h.class) {
                if (aFu == null) {
                    aFu = new h();
                }
            }
        }
        return aFu;
    }

    public void K(List<String> list) {
        if (this.aFw != null) {
            this.aFw.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.aFv.get(str) == null) {
                    if (this.aFv.size() < e.EP().EQ()) {
                        g.log("put loadingQueue  url: " + str);
                        f gy = gy(str);
                        this.aFv.put(str, gy);
                        gy.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.aFw.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(String str) {
        f remove = this.aFv.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.aFw != null && this.aFw.size() > 0) {
            String pop = this.aFw.pop();
            f gy = gy(pop);
            this.aFv.put(pop, gy);
            g.log("processCallback put loadingQueue  url: " + pop);
            gy.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.aFw.size() + " mLoadingQueue.size()  " + this.aFv.size());
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
