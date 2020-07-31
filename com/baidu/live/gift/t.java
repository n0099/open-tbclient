package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class t {
    private Map<String, Integer> aJA;
    private Map<String, s> aJz;
    private List<i> mDatas;

    public static t zn() {
        return a.aJB;
    }

    public void C(List<i> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        zq();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public List<i> getDatas() {
        return this.mDatas;
    }

    public Map<String, s> zo() {
        return this.aJz;
    }

    public Map<String, Integer> zp() {
        return this.aJA;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aJz != null) {
            this.aJz.clear();
        }
        if (this.aJA != null) {
            this.aJA.clear();
        }
    }

    private void zq() {
        g.a.C0165a c0165a;
        if (this.aJz == null) {
            this.aJz = new HashMap();
        }
        this.aJz.clear();
        if (this.aJA == null) {
            this.aJA = new HashMap();
        }
        this.aJA.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (i iVar : this.mDatas) {
                List<g> yO = iVar.yO();
                if (yO != null && !yO.isEmpty()) {
                    for (g gVar : yO) {
                        if (gVar.aIc != null && (c0165a = gVar.aIc.aIm) != null && c0165a.key == 10 && c0165a.aIo != null) {
                            String optString = c0165a.aIo.optString("id");
                            if (this.aJz.get(optString) == null) {
                                this.aJz.put(optString, new s(gVar.yo(), gVar.aIc.aIi, gVar.aHU));
                                this.aJA.put(optString, Integer.valueOf(gVar.aIc.aIj));
                            }
                        }
                    }
                }
            }
        }
    }

    private t() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final t aJB = new t();
    }
}
