package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class s {
    private Map<String, r> aAh;
    private Map<String, Integer> aAi;
    private List<i> mDatas;

    public static s wV() {
        return a.aAj;
    }

    public void w(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        wY();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, r> wW() {
        return this.aAh;
    }

    public Map<String, Integer> wX() {
        return this.aAi;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aAh != null) {
            this.aAh.clear();
        }
        if (this.aAi != null) {
            this.aAi.clear();
        }
    }

    private void wY() {
        g.a.C0112a c0112a;
        if (this.aAh == null) {
            this.aAh = new HashMap();
        }
        this.aAh.clear();
        if (this.aAi == null) {
            this.aAi = new HashMap();
        }
        this.aAi.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> ww = iVar.ww();
                if (ww != null && !ww.isEmpty()) {
                    for (g gVar : ww) {
                        if (gVar.ayN != null && (c0112a = gVar.ayN.ayX) != null && c0112a.key == 10 && c0112a.ayZ != null) {
                            String optString = c0112a.ayZ.optString("id");
                            if (this.aAh.get(optString) == null) {
                                this.aAh.put(optString, new r(gVar.vV(), gVar.ayN.ayT, gVar.ayE));
                                this.aAi.put(optString, Integer.valueOf(gVar.ayN.ayU));
                            }
                        }
                    }
                }
            }
        }
    }

    private s() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final s aAj = new s();
    }
}
