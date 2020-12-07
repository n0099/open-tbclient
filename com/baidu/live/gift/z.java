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
    private Map<String, y> aXX;
    private Map<String, Integer> aXY;
    private List<com.baidu.live.data.j> aXZ;
    private List<h> mDatas;

    public static z Ii() {
        return a.aYa;
    }

    public void H(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        Im();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public void a(List<h> list, List<com.baidu.live.data.j> list2, int i) {
        H(list);
        if (this.aXZ == null) {
            this.aXZ = new ArrayList();
        }
        this.aXZ.clear();
        if (list2 != null) {
            this.aXZ.addAll(list2);
        }
        com.baidu.live.d.BM().putInt("gift_package_list_flag", com.baidu.live.d.BM().getInt("gift_package_list_flag", 0) + i);
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, y> Ij() {
        return this.aXX;
    }

    public Map<String, Integer> Ik() {
        return this.aXY;
    }

    public List<com.baidu.live.data.j> Il() {
        return this.aXZ;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aXX != null) {
            this.aXX.clear();
        }
        if (this.aXY != null) {
            this.aXY.clear();
        }
    }

    private void Im() {
        g.b.a aVar;
        if (this.aXX == null) {
            this.aXX = new HashMap();
        }
        this.aXX.clear();
        if (this.aXY == null) {
            this.aXY = new HashMap();
        }
        this.aXY.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> HA = hVar.HA();
                if (HA != null && !HA.isEmpty()) {
                    for (g gVar : HA) {
                        if (gVar.aVZ != null && (aVar = gVar.aVZ.aWr) != null && aVar.key == 10 && aVar.aWs != null) {
                            String optString = aVar.aWs.optString("id");
                            if (this.aXX.get(optString) == null) {
                                this.aXX.put(optString, new y(gVar.GX(), gVar.aVZ.aWn, gVar.aVP));
                                this.aXY.put(optString, Integer.valueOf(gVar.aVZ.aWo));
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
        private static final z aYa = new z();
    }
}
