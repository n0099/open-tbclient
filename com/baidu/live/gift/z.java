package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class z {
    private Map<String, y> aVj;
    private Map<String, Integer> aVk;
    private List<i> mDatas;

    public static z GB() {
        return a.aVl;
    }

    public void G(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        GE();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, y> GC() {
        return this.aVj;
    }

    public Map<String, Integer> GD() {
        return this.aVk;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aVj != null) {
            this.aVj.clear();
        }
        if (this.aVk != null) {
            this.aVk.clear();
        }
    }

    private void GE() {
        g.b.a aVar;
        if (this.aVj == null) {
            this.aVj = new HashMap();
        }
        this.aVj.clear();
        if (this.aVk == null) {
            this.aVk = new HashMap();
        }
        this.aVk.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> FT = iVar.FT();
                if (FT != null && !FT.isEmpty()) {
                    for (g gVar : FT) {
                        if (gVar.aTp != null && (aVar = gVar.aTp.aTF) != null && aVar.key == 10 && aVar.aTG != null) {
                            String optString = aVar.aTG.optString("id");
                            if (this.aVj.get(optString) == null) {
                                this.aVj.put(optString, new y(gVar.Fs(), gVar.aTp.aTB, gVar.aTf));
                                this.aVk.put(optString, Integer.valueOf(gVar.aTp.aTC));
                            }
                        }
                    }
                }
            }
        }
    }

    private z() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final z aVl = new z();
    }
}
