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
    private Map<String, s> aOK;
    private Map<String, Integer> aOL;
    private List<i> mDatas;

    public static t EQ() {
        return a.aOM;
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
        return this.aOK;
    }

    public Map<String, Integer> ES() {
        return this.aOL;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aOK != null) {
            this.aOK.clear();
        }
        if (this.aOL != null) {
            this.aOL.clear();
        }
    }

    private void ET() {
        g.a.C0173a c0173a;
        if (this.aOK == null) {
            this.aOK = new HashMap();
        }
        this.aOK.clear();
        if (this.aOL == null) {
            this.aOL = new HashMap();
        }
        this.aOL.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> Er = iVar.Er();
                if (Er != null && !Er.isEmpty()) {
                    for (g gVar : Er) {
                        if (gVar.aNn != null && (c0173a = gVar.aNn.aNx) != null && c0173a.key == 10 && c0173a.aNz != null) {
                            String optString = c0173a.aNz.optString("id");
                            if (this.aOK.get(optString) == null) {
                                this.aOK.put(optString, new s(gVar.DR(), gVar.aNn.aNt, gVar.aNf));
                                this.aOL.put(optString, Integer.valueOf(gVar.aNn.aNu));
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
        private static final t aOM = new t();
    }
}
