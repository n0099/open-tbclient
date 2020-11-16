package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class y {
    private Map<String, x> aUQ;
    private Map<String, Integer> aUR;
    private List<h> mDatas;

    public static y Gt() {
        return a.aUS;
    }

    public void G(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        Gw();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, x> Gu() {
        return this.aUQ;
    }

    public Map<String, Integer> Gv() {
        return this.aUR;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aUQ != null) {
            this.aUQ.clear();
        }
        if (this.aUR != null) {
            this.aUR.clear();
        }
    }

    private void Gw() {
        g.b.a aVar;
        if (this.aUQ == null) {
            this.aUQ = new HashMap();
        }
        this.aUQ.clear();
        if (this.aUR == null) {
            this.aUR = new HashMap();
        }
        this.aUR.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> FL = hVar.FL();
                if (FL != null && !FL.isEmpty()) {
                    for (g gVar : FL) {
                        if (gVar.aSX != null && (aVar = gVar.aSX.aTn) != null && aVar.key == 10 && aVar.aTo != null) {
                            String optString = aVar.aTo.optString("id");
                            if (this.aUQ.get(optString) == null) {
                                this.aUQ.put(optString, new x(gVar.Fk(), gVar.aSX.aTj, gVar.aSN));
                                this.aUR.put(optString, Integer.valueOf(gVar.aSX.aTk));
                            }
                        }
                    }
                }
            }
        }
    }

    private y() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final y aUS = new y();
    }
}
