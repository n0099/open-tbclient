package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class z {
    private Map<String, y> aXX;
    private Map<String, Integer> aXY;
    private List<com.baidu.live.data.l> aXZ;
    private List<h> mDatas;

    public static z Fe() {
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
        Fi();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public void a(List<h> list, List<com.baidu.live.data.l> list2, int i) {
        H(list);
        if (this.aXZ == null) {
            this.aXZ = new ArrayList();
        }
        this.aXZ.clear();
        if (list2 != null) {
            this.aXZ.addAll(list2);
        }
        com.baidu.live.d.xc().putInt("gift_package_list_flag", com.baidu.live.d.xc().getInt("gift_package_list_flag", 0) + i);
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, y> Ff() {
        return this.aXX;
    }

    public Map<String, Integer> Fg() {
        return this.aXY;
    }

    public List<com.baidu.live.data.l> Fh() {
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

    private void Fi() {
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
                List<g> Ew = hVar.Ew();
                if (Ew != null && !Ew.isEmpty()) {
                    for (g gVar : Ew) {
                        if (gVar.aVX != null && (aVar = gVar.aVX.aWp) != null && aVar.key == 10 && aVar.aWq != null) {
                            String optString = aVar.aWq.optString("id");
                            if (this.aXX.get(optString) == null) {
                                this.aXX.put(optString, new y(gVar.DR(), gVar.aVX.aWl, gVar.aVN));
                                this.aXY.put(optString, Integer.valueOf(gVar.aVX.aWm));
                            }
                        }
                    }
                }
            }
        }
    }

    private z() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final z aYa = new z();
    }
}
