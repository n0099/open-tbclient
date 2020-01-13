package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class q {
    private Map<String, p> afw;
    private Map<String, Integer> afx;
    private List<i> mDatas;

    public static q rw() {
        return a.afy;
    }

    public void s(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        rz();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, p> rx() {
        return this.afw;
    }

    public Map<String, Integer> ry() {
        return this.afx;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.afw != null) {
            this.afw.clear();
        }
        if (this.afx != null) {
            this.afx.clear();
        }
    }

    private void rz() {
        g.a.C0079a c0079a;
        if (this.afw == null) {
            this.afw = new HashMap();
        }
        this.afw.clear();
        if (this.afx == null) {
            this.afx = new HashMap();
        }
        this.afx.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> qX = iVar.qX();
                if (qX != null && !qX.isEmpty()) {
                    for (g gVar : qX) {
                        if (gVar.aeg != null && (c0079a = gVar.aeg.aeq) != null && c0079a.key == 10 && c0079a.aes != null) {
                            String optString = c0079a.aes.optString("id");
                            if (this.afw.get(optString) == null) {
                                this.afw.put(optString, new p(gVar.qE(), gVar.aeg.aem, gVar.adZ));
                                this.afx.put(optString, Integer.valueOf(gVar.aeg.aen));
                            }
                        }
                    }
                }
            }
        }
    }

    private q() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final q afy = new q();
    }
}
