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
    private List<a> dmB;

    public b(List<a> list) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(list.size());
            linkedHashSet.addAll(list);
            if (linkedHashSet.size() != list.size()) {
                list.clear();
                list.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> aFX = com.baidu.swan.pms.database.a.aFV().aFX();
            Map<String, com.baidu.swan.pms.model.f> aFW = com.baidu.swan.pms.database.a.aFV().aFW();
            for (a aVar : list) {
                if (aVar != null && !TextUtils.isEmpty(aVar.getBundleId())) {
                    a(aFX, aFW, aVar);
                }
            }
            this.dmB = list;
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
            Map<String, PMSAppInfo> aFX = com.baidu.swan.pms.database.a.aFV().aFX();
            Map<String, com.baidu.swan.pms.model.f> aFW = com.baidu.swan.pms.database.a.aFV().aFW();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(aFX, aFW, aVar);
                    arrayList.add(aVar);
                }
            }
            this.dmB = arrayList;
        }
    }

    private void a(Map<String, PMSAppInfo> map, Map<String, com.baidu.swan.pms.model.f> map2, a aVar) {
        if (map.containsKey(aVar.getBundleId())) {
            PMSAppInfo pMSAppInfo = map.get(aVar.getBundleId());
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.jf(0);
            } else {
                aVar.jf(pMSAppInfo.versionCode);
            }
            aVar.bN(pMSAppInfo.appSign);
        }
    }

    public List<a> aGN() {
        return this.dmB;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String dmC;
        private int dmD;
        private long dmE;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.dmD = 0;
            this.dmE = 0L;
            this.dmC = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.dmD = 0;
            this.dmE = 0L;
            this.dmC = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.dmC;
        }

        public int aGO() {
            return this.dmD;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aGP() {
            return this.dmE;
        }

        void jf(int i) {
            this.dmD = i;
        }

        void bN(long j) {
            this.dmE = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.dmC, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.dmC) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
