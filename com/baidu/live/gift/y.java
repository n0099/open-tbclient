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
    private Map<String, x> aWB;
    private Map<String, Integer> aWC;
    private List<h> mDatas;

    public static y Hc() {
        return a.aWD;
    }

    public void G(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        Hf();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, x> Hd() {
        return this.aWB;
    }

    public Map<String, Integer> He() {
        return this.aWC;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aWB != null) {
            this.aWB.clear();
        }
        if (this.aWC != null) {
            this.aWC.clear();
        }
    }

    private void Hf() {
        g.b.a aVar;
        if (this.aWB == null) {
            this.aWB = new HashMap();
        }
        this.aWB.clear();
        if (this.aWC == null) {
            this.aWC = new HashMap();
        }
        this.aWC.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> Gu = hVar.Gu();
                if (Gu != null && !Gu.isEmpty()) {
                    for (g gVar : Gu) {
                        if (gVar.aUI != null && (aVar = gVar.aUI.aUY) != null && aVar.key == 10 && aVar.aUZ != null) {
                            String optString = aVar.aUZ.optString("id");
                            if (this.aWB.get(optString) == null) {
                                this.aWB.put(optString, new x(gVar.FT(), gVar.aUI.aUU, gVar.aUy));
                                this.aWC.put(optString, Integer.valueOf(gVar.aUI.aUV));
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
        private static final y aWD = new y();
    }
}
