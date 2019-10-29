package com.baidu.tbadk.core.util.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h cmi;
    private HashMap<String, f> cmj = new HashMap<>();
    private LinkedList<String> cmk = new LinkedList<>();

    private h() {
    }

    public static h anr() {
        if (cmi == null) {
            synchronized (h.class) {
                if (cmi == null) {
                    cmi = new h();
                }
            }
        }
        return cmi;
    }

    public void aw(List<String> list) {
        if (this.cmk != null) {
            this.cmk.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.cmj.get(str) == null) {
                    if (this.cmj.size() < e.anp().anq()) {
                        g.log("put loadingQueue  url: " + str);
                        f os = os(str);
                        this.cmj.put(str, os);
                        os.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.cmk.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(String str) {
        f remove = this.cmj.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.cmk != null && this.cmk.size() > 0) {
            String pop = this.cmk.pop();
            f os = os(pop);
            this.cmj.put(pop, os);
            g.log("processCallback put loadingQueue  url: " + pop);
            os.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.cmk.size() + " mLoadingQueue.size()  " + this.cmj.size());
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
