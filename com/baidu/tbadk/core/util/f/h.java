package com.baidu.tbadk.core.util.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h dDf;
    private HashMap<String, f> dDg = new HashMap<>();
    private LinkedList<String> dDh = new LinkedList<>();

    private h() {
    }

    public static h aPH() {
        if (dDf == null) {
            synchronized (h.class) {
                if (dDf == null) {
                    dDf = new h();
                }
            }
        }
        return dDf;
    }

    public void aL(List<String> list) {
        if (this.dDh != null) {
            this.dDh.clear();
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                if (this.dDg.get(str) == null) {
                    if (this.dDg.size() < e.aPF().aPG()) {
                        g.log("put loadingQueue  url: " + str);
                        f vh = vh(str);
                        this.dDg.put(str, vh);
                        vh.load();
                    } else {
                        g.log("put waitingQueue  url: " + str);
                        this.dDh.push(str);
                    }
                } else {
                    g.log("has loading  : " + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg(String str) {
        f remove = this.dDg.remove(str);
        g.log("processCallback remove loadingQueue  url: " + str);
        if (remove != null) {
            remove.release();
        }
        if (this.dDh != null && this.dDh.size() > 0) {
            String pop = this.dDh.pop();
            f vh = vh(pop);
            this.dDg.put(pop, vh);
            g.log("processCallback put loadingQueue  url: " + pop);
            vh.load();
        }
        g.log("processCallback  mWaitingQueue.size() =  " + this.dDh.size() + " mLoadingQueue.size()  " + this.dDg.size());
    }

    private f vh(String str) {
        return new f(str, new b() { // from class: com.baidu.tbadk.core.util.f.h.1
            @Override // com.baidu.tbadk.core.util.f.b
            public void onSuccess(String str2) {
                g.log("onSuccess  url = " + str2);
                h.this.vg(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void cJ(String str2, String str3) {
                g.log("onFail  url = " + str2);
                h.this.vg(str2);
            }

            @Override // com.baidu.tbadk.core.util.f.b
            public void ve(String str2) {
                g.log("onCancle  url = " + str2);
                h.this.vg(str2);
            }
        });
    }
}
