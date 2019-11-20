package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class o {
    private Map<String, n> Xc;
    private Map<String, Integer> Xd;
    private List<h> mDatas;

    public static o pI() {
        return a.Xe;
    }

    public void t(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        pL();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, n> pJ() {
        return this.Xc;
    }

    public Map<String, Integer> pK() {
        return this.Xd;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.Xc != null) {
            this.Xc.clear();
        }
        if (this.Xd != null) {
            this.Xd.clear();
        }
    }

    private void pL() {
        g.a.C0065a c0065a;
        if (this.Xc == null) {
            this.Xc = new HashMap();
        }
        this.Xc.clear();
        if (this.Xd == null) {
            this.Xd = new HashMap();
        }
        this.Xd.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> pt = hVar.pt();
                if (pt != null && !pt.isEmpty()) {
                    for (g gVar : pt) {
                        if (gVar.Wo != null && (c0065a = gVar.Wo.Wv) != null && c0065a.key == 10 && c0065a.Wx != null) {
                            String optString = c0065a.Wx.optString("id");
                            if (this.Xc.get(optString) == null) {
                                this.Xc.put(optString, new n(gVar.pc(), gVar.Wo.Wr, gVar.Wi));
                                this.Xd.put(optString, Integer.valueOf(gVar.Wo.Ws));
                            }
                        }
                    }
                }
            }
        }
    }

    private o() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final o Xe = new o();
    }
}
