package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class t {
    private Map<String, s> aOM;
    private Map<String, Integer> aON;
    private List<i> mDatas;

    public static t EQ() {
        return a.aOO;
    }

    public void D(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        ET();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, s> ER() {
        return this.aOM;
    }

    public Map<String, Integer> ES() {
        return this.aON;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aOM != null) {
            this.aOM.clear();
        }
        if (this.aON != null) {
            this.aON.clear();
        }
    }

    private void ET() {
        g.a.C0173a c0173a;
        if (this.aOM == null) {
            this.aOM = new HashMap();
        }
        this.aOM.clear();
        if (this.aON == null) {
            this.aON = new HashMap();
        }
        this.aON.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> Er = iVar.Er();
                if (Er != null && !Er.isEmpty()) {
                    for (g gVar : Er) {
                        if (gVar.aNp != null && (c0173a = gVar.aNp.aNz) != null && c0173a.key == 10 && c0173a.aNB != null) {
                            String optString = c0173a.aNB.optString("id");
                            if (this.aOM.get(optString) == null) {
                                this.aOM.put(optString, new s(gVar.DR(), gVar.aNp.aNv, gVar.aNh));
                                this.aON.put(optString, Integer.valueOf(gVar.aNp.aNw));
                            }
                        }
                    }
                }
            }
        }
    }

    private t() {
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final t aOO = new t();
    }
}
