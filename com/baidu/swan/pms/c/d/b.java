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
    private List<a> cBY;

    public b(Collection<String> collection) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
            linkedHashSet.addAll(collection);
            if (linkedHashSet.size() != collection.size()) {
                collection.clear();
                collection.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> atx = com.baidu.swan.pms.database.a.atv().atx();
            Map<String, com.baidu.swan.pms.model.f> atw = com.baidu.swan.pms.database.a.atv().atw();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(atx, atw, aVar);
                    arrayList.add(aVar);
                }
            }
            this.cBY = arrayList;
        }
    }

    private void a(Map<String, PMSAppInfo> map, Map<String, com.baidu.swan.pms.model.f> map2, a aVar) {
        if (map.containsKey(aVar.getBundleId())) {
            PMSAppInfo pMSAppInfo = map.get(aVar.getBundleId());
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.iI(0);
            } else {
                aVar.iI(pMSAppInfo.versionCode);
            }
            aVar.bk(pMSAppInfo.appSign);
        }
    }

    public List<a> auj() {
        return this.cBY;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cBZ;
        private int mCategory = -1;
        private int cCa = 0;
        private long cCb = 0;

        public a(String str) {
            this.cBZ = str;
        }

        public String getBundleId() {
            return this.cBZ;
        }

        public int auk() {
            return this.cCa;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aul() {
            return this.cCb;
        }

        void iI(int i) {
            this.cCa = i;
        }

        void bk(long j) {
            this.cCb = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.cBZ, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.cBZ) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
