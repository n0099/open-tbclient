package com.baidu.swan.pms.c.d;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes10.dex */
public class b extends f {
    private List<a> cxZ;

    public b(Collection<String> collection) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(collection.size());
            linkedHashSet.addAll(collection);
            if (linkedHashSet.size() != collection.size()) {
                collection.clear();
                collection.addAll(linkedHashSet);
            }
            Map<String, PMSAppInfo> arh = com.baidu.swan.pms.database.a.arf().arh();
            Map<String, com.baidu.swan.pms.model.f> arg = com.baidu.swan.pms.database.a.arf().arg();
            ArrayList arrayList = new ArrayList();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar = new a(str);
                    a(arh, arg, aVar);
                    arrayList.add(aVar);
                }
            }
            this.cxZ = arrayList;
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
            aVar.bg(pMSAppInfo.appSign);
        }
    }

    public List<a> arT() {
        return this.cxZ;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private String cya;
        private int mCategory = -1;
        private int cyb = 0;
        private long cyc = 0;

        public a(String str) {
            this.cya = str;
        }

        public String getBundleId() {
            return this.cya;
        }

        public int arU() {
            return this.cyb;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long arV() {
            return this.cyc;
        }

        void ir(int i) {
            this.cyb = i;
        }

        void bg(long j) {
            this.cyc = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.cya, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.cya) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
