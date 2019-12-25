package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class q {
    private Map<String, p> aeN;
    private Map<String, Integer> aeO;
    private List<i> mDatas;

    public static q rk() {
        return a.aeP;
    }

    public void s(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        rn();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, p> rl() {
        return this.aeN;
    }

    public Map<String, Integer> rm() {
        return this.aeO;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aeN != null) {
            this.aeN.clear();
        }
        if (this.aeO != null) {
            this.aeO.clear();
        }
    }

    private void rn() {
        g.a.C0079a c0079a;
        if (this.aeN == null) {
            this.aeN = new HashMap();
        }
        this.aeN.clear();
        if (this.aeO == null) {
            this.aeO = new HashMap();
        }
        this.aeO.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> qQ = iVar.qQ();
                if (qQ != null && !qQ.isEmpty()) {
                    for (g gVar : qQ) {
                        if (gVar.adR != null && (c0079a = gVar.adR.aeb) != null && c0079a.key == 10 && c0079a.aed != null) {
                            String optString = c0079a.aed.optString("id");
                            if (this.aeN.get(optString) == null) {
                                this.aeN.put(optString, new p(gVar.qx(), gVar.adR.adX, gVar.adK));
                                this.aeO.put(optString, Integer.valueOf(gVar.adR.adY));
                            }
                        }
                    }
                }
            }
        }
    }

    private q() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final q aeP = new q();
    }
}
