package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class t {
    private Map<String, s> aIc;
    private Map<String, Integer> aId;
    private List<i> mDatas;

    public static t yL() {
        return a.aIe;
    }

    public void A(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        yO();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, s> yM() {
        return this.aIc;
    }

    public Map<String, Integer> yN() {
        return this.aId;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aIc != null) {
            this.aIc.clear();
        }
        if (this.aId != null) {
            this.aId.clear();
        }
    }

    private void yO() {
        g.a.C0166a c0166a;
        if (this.aIc == null) {
            this.aIc = new HashMap();
        }
        this.aIc.clear();
        if (this.aId == null) {
            this.aId = new HashMap();
        }
        this.aId.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> ym = iVar.ym();
                if (ym != null && !ym.isEmpty()) {
                    for (g gVar : ym) {
                        if (gVar.aGH != null && (c0166a = gVar.aGH.aGR) != null && c0166a.key == 10 && c0166a.aGT != null) {
                            String optString = c0166a.aGT.optString("id");
                            if (this.aIc.get(optString) == null) {
                                this.aIc.put(optString, new s(gVar.xM(), gVar.aGH.aGN, gVar.aGz));
                                this.aId.put(optString, Integer.valueOf(gVar.aGH.aGO));
                            }
                        }
                    }
                }
            }
        }
    }

    private t() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final t aIe = new t();
    }
}
