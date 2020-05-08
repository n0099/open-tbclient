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
    private Map<String, r> aAn;
    private Map<String, Integer> aAo;
    private List<i> mDatas;

    public static s wU() {
        return a.aAp;
    }

    public void w(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        wX();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, r> wV() {
        return this.aAn;
    }

    public Map<String, Integer> wW() {
        return this.aAo;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aAn != null) {
            this.aAn.clear();
        }
        if (this.aAo != null) {
            this.aAo.clear();
        }
    }

    private void wX() {
        g.a.C0133a c0133a;
        if (this.aAn == null) {
            this.aAn = new HashMap();
        }
        this.aAn.clear();
        if (this.aAo == null) {
            this.aAo = new HashMap();
        }
        this.aAo.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> wv = iVar.wv();
                if (wv != null && !wv.isEmpty()) {
                    for (g gVar : wv) {
                        if (gVar.ayT != null && (c0133a = gVar.ayT.azd) != null && c0133a.key == 10 && c0133a.azf != null) {
                            String optString = c0133a.azf.optString("id");
                            if (this.aAn.get(optString) == null) {
                                this.aAn.put(optString, new r(gVar.vU(), gVar.ayT.ayZ, gVar.ayK));
                                this.aAo.put(optString, Integer.valueOf(gVar.ayT.aza));
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
        private static final s aAp = new s();
    }
}
