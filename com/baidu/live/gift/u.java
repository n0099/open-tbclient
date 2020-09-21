package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class u {
    private Map<String, t> aQO;
    private Map<String, Integer> aQP;
    private List<i> mDatas;

    public static u Fk() {
        return a.aQQ;
    }

    public void F(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        Fn();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, t> Fl() {
        return this.aQO;
    }

    public Map<String, Integer> Fm() {
        return this.aQP;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aQO != null) {
            this.aQO.clear();
        }
        if (this.aQP != null) {
            this.aQP.clear();
        }
    }

    private void Fn() {
        g.b.a aVar;
        if (this.aQO == null) {
            this.aQO = new HashMap();
        }
        this.aQO.clear();
        if (this.aQP == null) {
            this.aQP = new HashMap();
        }
        this.aQP.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> EI = iVar.EI();
                if (EI != null && !EI.isEmpty()) {
                    for (g gVar : EI) {
                        if (gVar.aPi != null && (aVar = gVar.aPi.aPy) != null && aVar.key == 10 && aVar.aPz != null) {
                            String optString = aVar.aPz.optString("id");
                            if (this.aQO.get(optString) == null) {
                                this.aQO.put(optString, new t(gVar.Eh(), gVar.aPi.aPu, gVar.aOZ));
                                this.aQP.put(optString, Integer.valueOf(gVar.aPi.aPv));
                            }
                        }
                    }
                }
            }
        }
    }

    private u() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final u aQQ = new u();
    }
}
