package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h dYe;
    private HashMap<String, f> dYf = new HashMap<>();
    private LinkedList<String> dYg = new LinkedList<>();

    private h() {
    }

    public static h aXG() {
        if (dYe == null) {
            synchronized (h.class) {
                if (dYe == null) {
                    dYe = new h();
                }
            }
        }
        return dYe;
    }

    public void aO(List<String> list) {
        if (this.dYg != null) {
            this.dYg.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.dYf.get(str) == null) {
                    if (this.dYf.size() < e.aXE().aXF()) {
                        g.log("put loadingQueue  url: " + str);
                        f xe = xe(str);
                        this.dYf.put(str, xe);
                        xe.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.dYg.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(String str) {
        f remove = this.dYf.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.dYg != null && this.dYg.size() > 0) {
            String pop = this.dYg.pop();
            f xe = xe(pop);
            this.dYf.put(pop, xe);
            g.log("processCallback put loadingQueue  url: " + pop);
            xe.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.dYg.size() + " mLoadingQueue.size()  " + this.dYf.size());
    }

    private f xe(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.f.h.1
            @Override // com.baidu.tbadk.core.util.f.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.xd(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void dl(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.xd(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void xb(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.xd(str2);
            }
        });
    }
}
