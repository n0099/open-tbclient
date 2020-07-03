package com.baidu.swan.pms.c.d;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes11.dex */
public class b extends f {
    private List<a> drm;

    public b(List<a> list) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(list.size());
            linkedHashSet.addAll(list);
            if (linkedHashSet.size() != list.size()) {
                list.clear();
                list.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> aHd = com.baidu.swan.pms.database.a.aHb().aHd();
            Map<String, com.baidu.swan.pms.model.f> aHc = com.baidu.swan.pms.database.a.aHb().aHc();
            for (a aVar : list) {
                if (aVar != null && !TextUtils.isEmpty(aVar.getBundleId())) {
                    a(aHd, aHc, aVar);
                }
            }
            this.drm = list;
        }
    }

    public b(Collection<String> collection) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
            linkedHashSet.addAll(collection);
            if (linkedHashSet.size() != collection.size()) {
                collection.clear();
                collection.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> aHd = com.baidu.swan.pms.database.a.aHb().aHd();
            Map<String, com.baidu.swan.pms.model.f> aHc = com.baidu.swan.pms.database.a.aHb().aHc();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(aHd, aHc, aVar);
                    arrayList.add(aVar);
                }
            }
            this.drm = arrayList;
        }
    }

    private void a(Map<String, PMSAppInfo> map, Map<String, com.baidu.swan.pms.model.f> map2, a aVar) {
        if (map.containsKey(aVar.getBundleId())) {
            PMSAppInfo pMSAppInfo = map.get(aVar.getBundleId());
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.js(0);
            } else {
                aVar.js(pMSAppInfo.versionCode);
            }
            aVar.bN(pMSAppInfo.appSign);
        }
    }

    public List<a> aHT() {
        return this.drm;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String drn;
        private int dro;
        private long drp;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.dro = 0;
            this.drp = 0L;
            this.drn = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.dro = 0;
            this.drp = 0L;
            this.drn = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.drn;
        }

        public int aHU() {
            return this.dro;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aHV() {
            return this.drp;
        }

        void js(int i) {
            this.dro = i;
        }

        void bN(long j) {
            this.drp = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.drn, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.drn) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
