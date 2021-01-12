package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class z {
    private Map<String, y> aUP;
    private Map<String, Integer> aUQ;
    private List<com.baidu.live.data.k> aUR;
    private List<h> mDatas;

    public static z DO() {
        return a.aUS;
    }

    public void H(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        DS();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public void a(List<h> list, List<com.baidu.live.data.k> list2, int i) {
        H(list);
        if (this.aUR == null) {
            this.aUR = new ArrayList();
        }
        this.aUR.clear();
        if (list2 != null) {
            this.aUR.addAll(list2);
        }
        com.baidu.live.d.xf().putInt("gift_package_list_flag", com.baidu.live.d.xf().getInt("gift_package_list_flag", 0) + i);
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, y> DP() {
        return this.aUP;
    }

    public Map<String, Integer> DQ() {
        return this.aUQ;
    }

    public List<com.baidu.live.data.k> DR() {
        return this.aUR;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aUP != null) {
            this.aUP.clear();
        }
        if (this.aUQ != null) {
            this.aUQ.clear();
        }
    }

    private void DS() {
        g.b.a aVar;
        if (this.aUP == null) {
            this.aUP = new HashMap();
        }
        this.aUP.clear();
        if (this.aUQ == null) {
            this.aUQ = new HashMap();
        }
        this.aUQ.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> Dg = hVar.Dg();
                if (Dg != null && !Dg.isEmpty()) {
                    for (g gVar : Dg) {
                        if (gVar.aSS != null && (aVar = gVar.aSS.aTk) != null && aVar.key == 10 && aVar.aTl != null) {
                            String optString = aVar.aTl.optString("id");
                            if (this.aUP.get(optString) == null) {
                                this.aUP.put(optString, new y(gVar.CC(), gVar.aSS.aTg, gVar.aSI));
                                this.aUQ.put(optString, Integer.valueOf(gVar.aSS.aTh));
                            }
                        }
                    }
                }
            }
        }
    }

    private z() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final z aUS = new z();
    }
}
