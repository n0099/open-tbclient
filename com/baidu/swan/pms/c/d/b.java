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
    private List<a> dbp;

    public b(Collection<String> collection) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
            linkedHashSet.addAll(collection);
            if (linkedHashSet.size() != collection.size()) {
                collection.clear();
                collection.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> aBK = com.baidu.swan.pms.database.a.aBI().aBK();
            Map<String, com.baidu.swan.pms.model.f> aBJ = com.baidu.swan.pms.database.a.aBI().aBJ();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(aBK, aBJ, aVar);
                    arrayList.add(aVar);
                }
            }
            this.dbp = arrayList;
        }
    }

    private void a(Map<String, PMSAppInfo> map, Map<String, com.baidu.swan.pms.model.f> map2, a aVar) {
        if (map.containsKey(aVar.getBundleId())) {
            PMSAppInfo pMSAppInfo = map.get(aVar.getBundleId());
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.iP(0);
            } else {
                aVar.iP(pMSAppInfo.versionCode);
            }
            aVar.bP(pMSAppInfo.appSign);
        }
    }

    public List<a> aCx() {
        return this.dbp;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String dbq;
        private int mCategory = -1;
        private int dbr = 0;
        private long dbs = 0;

        public a(String str) {
            this.dbq = str;
        }

        public String getBundleId() {
            return this.dbq;
        }

        public int aCy() {
            return this.dbr;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aCz() {
            return this.dbs;
        }

        void iP(int i) {
            this.dbr = i;
        }

        void bP(long j) {
            this.dbs = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.dbq, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.dbq) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
