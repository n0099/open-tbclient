package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class r {
    private Map<String, q> ahN;
    private Map<String, Integer> ahO;
    private List<i> mDatas;

    public static r sC() {
        return a.ahP;
    }

    public void s(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        sF();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, q> sD() {
        return this.ahN;
    }

    public Map<String, Integer> sE() {
        return this.ahO;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.ahN != null) {
            this.ahN.clear();
        }
        if (this.ahO != null) {
            this.ahO.clear();
        }
    }

    private void sF() {
        g.a.C0086a c0086a;
        if (this.ahN == null) {
            this.ahN = new HashMap();
        }
        this.ahN.clear();
        if (this.ahO == null) {
            this.ahO = new HashMap();
        }
        this.ahO.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> sd = iVar.sd();
                if (sd != null && !sd.isEmpty()) {
                    for (g gVar : sd) {
                        if (gVar.agx != null && (c0086a = gVar.agx.agH) != null && c0086a.key == 10 && c0086a.agJ != null) {
                            String optString = c0086a.agJ.optString("id");
                            if (this.ahN.get(optString) == null) {
                                this.ahN.put(optString, new q(gVar.rC(), gVar.agx.agD, gVar.ago));
                                this.ahO.put(optString, Integer.valueOf(gVar.agx.agE));
                            }
                        }
                    }
                }
            }
        }
    }

    private r() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final r ahP = new r();
    }
}
