package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class o {
    private Map<String, n> Xu;
    private Map<String, Integer> Xv;
    private List<h> mDatas;

    public static o pI() {
        return a.Xw;
    }

    public void t(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        pL();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, n> pJ() {
        return this.Xu;
    }

    public Map<String, Integer> pK() {
        return this.Xv;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.Xu != null) {
            this.Xu.clear();
        }
        if (this.Xv != null) {
            this.Xv.clear();
        }
    }

    private void pL() {
        g.a.C0065a c0065a;
        if (this.Xu == null) {
            this.Xu = new HashMap();
        }
        this.Xu.clear();
        if (this.Xv == null) {
            this.Xv = new HashMap();
        }
        this.Xv.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> pt = hVar.pt();
                if (pt != null && !pt.isEmpty()) {
                    for (g gVar : pt) {
                        if (gVar.WH != null && (c0065a = gVar.WH.WO) != null && c0065a.key == 10 && c0065a.WQ != null) {
                            String optString = c0065a.WQ.optString("id");
                            if (this.Xu.get(optString) == null) {
                                this.Xu.put(optString, new n(gVar.pc(), gVar.WH.WK, gVar.WB));
                                this.Xv.put(optString, Integer.valueOf(gVar.WH.WL));
                            }
                        }
                    }
                }
            }
        }
    }

    private o() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final o Xw = new o();
    }
}
