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
    private Map<String, q> ahD;
    private Map<String, Integer> ahE;
    private List<i> mDatas;

    public static r sx() {
        return a.ahF;
    }

    public void s(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        sA();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, q> sy() {
        return this.ahD;
    }

    public Map<String, Integer> sz() {
        return this.ahE;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.ahD != null) {
            this.ahD.clear();
        }
        if (this.ahE != null) {
            this.ahE.clear();
        }
    }

    private void sA() {
        g.a.C0086a c0086a;
        if (this.ahD == null) {
            this.ahD = new HashMap();
        }
        this.ahD.clear();
        if (this.ahE == null) {
            this.ahE = new HashMap();
        }
        this.ahE.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> rY = iVar.rY();
                if (rY != null && !rY.isEmpty()) {
                    for (g gVar : rY) {
                        if (gVar.agn != null && (c0086a = gVar.agn.agx) != null && c0086a.key == 10 && c0086a.agz != null) {
                            String optString = c0086a.agz.optString("id");
                            if (this.ahD.get(optString) == null) {
                                this.ahD.put(optString, new q(gVar.rx(), gVar.agn.agt, gVar.agd));
                                this.ahE.put(optString, Integer.valueOf(gVar.agn.agu));
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
        private static final r ahF = new r();
    }
}
