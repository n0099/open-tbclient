package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class z {
    private Map<String, y> aZC;
    private Map<String, Integer> aZD;
    private List<com.baidu.live.data.k> aZE;
    private List<h> mDatas;

    public static z HJ() {
        return a.aZF;
    }

    public void H(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        HN();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public void a(List<h> list, List<com.baidu.live.data.k> list2, int i) {
        H(list);
        if (this.aZE == null) {
            this.aZE = new ArrayList();
        }
        this.aZE.clear();
        if (list2 != null) {
            this.aZE.addAll(list2);
        }
        com.baidu.live.d.Ba().putInt("gift_package_list_flag", com.baidu.live.d.Ba().getInt("gift_package_list_flag", 0) + i);
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, y> HK() {
        return this.aZC;
    }

    public Map<String, Integer> HL() {
        return this.aZD;
    }

    public List<com.baidu.live.data.k> HM() {
        return this.aZE;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aZC != null) {
            this.aZC.clear();
        }
        if (this.aZD != null) {
            this.aZD.clear();
        }
    }

    private void HN() {
        g.b.a aVar;
        if (this.aZC == null) {
            this.aZC = new HashMap();
        }
        this.aZC.clear();
        if (this.aZD == null) {
            this.aZD = new HashMap();
        }
        this.aZD.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> Hb = hVar.Hb();
                if (Hb != null && !Hb.isEmpty()) {
                    for (g gVar : Hb) {
                        if (gVar.aXF != null && (aVar = gVar.aXF.aXX) != null && aVar.key == 10 && aVar.aXY != null) {
                            String optString = aVar.aXY.optString("id");
                            if (this.aZC.get(optString) == null) {
                                this.aZC.put(optString, new y(gVar.Gx(), gVar.aXF.aXT, gVar.aXv));
                                this.aZD.put(optString, Integer.valueOf(gVar.aXF.aXU));
                            }
                        }
                    }
                }
            }
        }
    }

    private z() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final z aZF = new z();
    }
}
