package com.baidu.live.gift;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.gift.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class z {
    private Map<String, y> aZx;
    private Map<String, Integer> aZy;
    private List<com.baidu.live.data.l> aZz;
    private List<h> mDatas;

    public static z Fh() {
        return a.aZA;
    }

    public void H(List<h> list) {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.mDatas.clear();
        if (list != null) {
            this.mDatas.addAll(list);
        }
        Fl();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913122));
    }

    public void a(List<h> list, List<com.baidu.live.data.l> list2, int i) {
        H(list);
        if (this.aZz == null) {
            this.aZz = new ArrayList();
        }
        this.aZz.clear();
        if (list2 != null) {
            this.aZz.addAll(list2);
        }
        com.baidu.live.d.xf().putInt("gift_package_list_flag", com.baidu.live.d.xf().getInt("gift_package_list_flag", 0) + i);
    }

    public List<h> getDatas() {
        return this.mDatas;
    }

    public Map<String, y> Fi() {
        return this.aZx;
    }

    public Map<String, Integer> Fj() {
        return this.aZy;
    }

    public List<com.baidu.live.data.l> Fk() {
        return this.aZz;
    }

    public void release() {
        if (this.mDatas != null) {
            this.mDatas.clear();
        }
        if (this.aZx != null) {
            this.aZx.clear();
        }
        if (this.aZy != null) {
            this.aZy.clear();
        }
    }

    private void Fl() {
        g.b.a aVar;
        if (this.aZx == null) {
            this.aZx = new HashMap();
        }
        this.aZx.clear();
        if (this.aZy == null) {
            this.aZy = new HashMap();
        }
        this.aZy.clear();
        if (this.mDatas != null && this.mDatas.size() > 0) {
            for (h hVar : this.mDatas) {
                List<g> Ez = hVar.Ez();
                if (Ez != null && !Ez.isEmpty()) {
                    for (g gVar : Ez) {
                        if (gVar.aXx != null && (aVar = gVar.aXx.aXP) != null && aVar.key == 10 && aVar.aXQ != null) {
                            String optString = aVar.aXQ.optString("id");
                            if (this.aZx.get(optString) == null) {
                                this.aZx.put(optString, new y(gVar.DU(), gVar.aXx.aXL, gVar.aXn));
                                this.aZy.put(optString, Integer.valueOf(gVar.aXx.aXM));
                            }
                        }
                    }
                }
            }
        }
    }

    private z() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final z aZA = new z();
    }
}
