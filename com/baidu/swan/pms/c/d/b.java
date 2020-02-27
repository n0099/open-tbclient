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
    private List<a> cBX;

    public b(Collection<String> collection) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
            linkedHashSet.addAll(collection);
            if (linkedHashSet.size() != collection.size()) {
                collection.clear();
                collection.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> atv = com.baidu.swan.pms.database.a.att().atv();
            Map<String, com.baidu.swan.pms.model.f> atu = com.baidu.swan.pms.database.a.att().atu();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(atv, atu, aVar);
                    arrayList.add(aVar);
                }
            }
            this.cBX = arrayList;
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

    public List<a> auh() {
        return this.cBX;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cBY;
        private int mCategory = -1;
        private int cBZ = 0;
        private long cCa = 0;

        public a(String str) {
            this.cBY = str;
        }

        public String getBundleId() {
            return this.cBY;
        }

        public int aui() {
            return this.cBZ;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long auj() {
            return this.cCa;
        }

        void iI(int i) {
            this.cBZ = i;
        }

        void bk(long j) {
            this.cCa = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.cBY, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.cBY) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
