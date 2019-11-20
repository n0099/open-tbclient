package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h clq;
    private HashMap<String, f> clr = new HashMap<>();
    private LinkedList<String> cls = new LinkedList<>();

    private h() {
    }

    public static h anp() {
        if (clq == null) {
            synchronized (h.class) {
                if (clq == null) {
                    clq = new h();
                }
            }
        }
        return clq;
    }

    public void aw(List<String> list) {
        if (this.cls != null) {
            this.cls.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.clr.get(str) == null) {
                    if (this.clr.size() < e.ann().ano()) {
                        g.log("put loadingQueue  url: " + str);
                        f os = os(str);
                        this.clr.put(str, os);
                        os.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.cls.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(String str) {
        f remove = this.clr.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.cls != null && this.cls.size() > 0) {
            String pop = this.cls.pop();
            f os = os(pop);
            this.clr.put(pop, os);
            g.log("processCallback put loadingQueue  url: " + pop);
            os.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.cls.size() + " mLoadingQueue.size()  " + this.clr.size());
    }

    private f os(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.g.h.1
            @Override // com.baidu.tbadk.core.util.g.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.or(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void bT(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.or(str2);
            }

            @Override // com.baidu.tbadk.core.util.g.b
            public void op(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.or(str2);
            }
        });
    }
}
