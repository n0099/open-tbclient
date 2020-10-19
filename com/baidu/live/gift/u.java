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
    private Map<String, t> aTZ;
    private Map<String, Integer> aUa;
    private List<i> mDatas;

    public static u Gg() {
        return a.aUb;
    }

    public void H(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        Gj();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, t> Gh() {
        return this.aTZ;
    }

    public Map<String, Integer> Gi() {
        return this.aUa;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aTZ != null) {
            this.aTZ.clear();
        }
        if (this.aUa != null) {
            this.aUa.clear();
        }
    }

    private void Gj() {
        g.b.a aVar;
        if (this.aTZ == null) {
            this.aTZ = new HashMap();
        }
        this.aTZ.clear();
        if (this.aUa == null) {
            this.aUa = new HashMap();
        }
        this.aUa.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> FE = iVar.FE();
                if (FE != null && !FE.isEmpty()) {
                    for (g gVar : FE) {
                        if (gVar.aSt != null && (aVar = gVar.aSt.aSJ) != null && aVar.key == 10 && aVar.aSK != null) {
                            String optString = aVar.aSK.optString("id");
                            if (this.aTZ.get(optString) == null) {
                                this.aTZ.put(optString, new t(gVar.Fd(), gVar.aSt.aSF, gVar.aSk));
                                this.aUa.put(optString, Integer.valueOf(gVar.aSt.aSG));
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
        private static final u aUb = new u();
    }
}
