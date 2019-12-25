package com.baidu.swan.pms.c.d;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes9.dex */
public class b extends f {
    private List<a> cxO;

    public b(Collection<String> collection) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
            linkedHashSet.addAll(collection);
            if (linkedHashSet.size() != collection.size()) {
                collection.clear();
                collection.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> aqO = com.baidu.swan.pms.database.a.aqM().aqO();
            Map<String, com.baidu.swan.pms.model.f> aqN = com.baidu.swan.pms.database.a.aqM().aqN();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(aqO, aqN, aVar);
                    arrayList.add(aVar);
                }
            }
            this.cxO = arrayList;
        }
    }

    private void a(Map<String, PMSAppInfo> map, Map<String, com.baidu.swan.pms.model.f> map2, a aVar) {
        if (map.containsKey(aVar.getBundleId())) {
            PMSAppInfo pMSAppInfo = map.get(aVar.getBundleId());
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.ir(0);
            } else {
                aVar.ir(pMSAppInfo.versionCode);
            }
            aVar.bd(pMSAppInfo.appSign);
        }
    }

    public List<a> arA() {
        return this.cxO;
    }

    /* loaded from: classes9.dex */
    public static class a {
        private String cxP;
        private int mCategory = -1;
        private int cxQ = 0;
        private long cxR = 0;

        public a(String str) {
            this.cxP = str;
        }

        public String getBundleId() {
            return this.cxP;
        }

        public int arB() {
            return this.cxQ;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long arC() {
            return this.cxR;
        }

        void ir(int i) {
            this.cxQ = i;
        }

        void bd(long j) {
            this.cxR = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.cxP, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.cxP) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
