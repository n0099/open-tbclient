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
    private Map<String, s> aFG;
    private Map<String, Integer> aFH;
    private List<i> mDatas;

    public static t yl() {
        return a.aFI;
    }

    public void w(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        yo();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, s> ym() {
        return this.aFG;
    }

    public Map<String, Integer> yn() {
        return this.aFH;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aFG != null) {
            this.aFG.clear();
        }
        if (this.aFH != null) {
            this.aFH.clear();
        }
    }

    private void yo() {
        g.a.C0164a c0164a;
        if (this.aFG == null) {
            this.aFG = new HashMap();
        }
        this.aFG.clear();
        if (this.aFH == null) {
            this.aFH = new HashMap();
        }
        this.aFH.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> xM = iVar.xM();
                if (xM != null && !xM.isEmpty()) {
                    for (g gVar : xM) {
                        if (gVar.aEl != null && (c0164a = gVar.aEl.aEv) != null && c0164a.key == 10 && c0164a.aEx != null) {
                            String optString = c0164a.aEx.optString("id");
                            if (this.aFG.get(optString) == null) {
                                this.aFG.put(optString, new s(gVar.xl(), gVar.aEl.aEr, gVar.aEd));
                                this.aFH.put(optString, Integer.valueOf(gVar.aEl.aEs));
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
        private static final t aFI = new t();
    }
}
