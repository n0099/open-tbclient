package com.baidu.swan.pms.c.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes19.dex */
public class b extends g {
    private Set<a> dxe;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.f.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.dxe = new LinkedHashSet();
            Map<String, PMSAppInfo> aKU = com.baidu.swan.pms.database.a.aKS().aKU();
            Map<String, com.baidu.swan.pms.model.f> aKT = com.baidu.swan.pms.database.a.aKS().aKT();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(aKU, aKT, aVar2, aVar);
                    this.dxe.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.f.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.dxe = new LinkedHashSet();
            Map<String, PMSAppInfo> aKU = com.baidu.swan.pms.database.a.aKS().aKU();
            Map<String, com.baidu.swan.pms.model.f> aKT = com.baidu.swan.pms.database.a.aKS().aKT();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(aKU, aKT, aVar2, aVar);
                    this.dxe.add(aVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull a aVar, @Nullable com.baidu.swan.pms.f.a aVar2) {
        PMSAppInfo pMSAppInfo;
        if (map.containsKey(aVar.getBundleId()) && (pMSAppInfo = map.get(aVar.getBundleId())) != null) {
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.jL(0);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.qN(aVar.getBundleId())) {
                aVar.jL(0);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.jL(fVar.versionCode);
                } else {
                    aVar.jL(0);
                }
            }
            aVar.cd(pMSAppInfo.appSign);
        }
    }

    @Nullable
    public Set<a> aLK() {
        return this.dxe;
    }

    /* loaded from: classes19.dex */
    public static class a {
        private String dxf;
        private int dxg;
        private long dxh;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.dxg = 0;
            this.dxh = 0L;
            this.dxf = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.dxg = 0;
            this.dxh = 0L;
            this.dxf = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.dxf;
        }

        public int aLL() {
            return this.dxg;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aLM() {
            return this.dxh;
        }

        void jL(int i) {
            this.dxg = i;
        }

        void cd(long j) {
            this.dxh = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.dxf, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.dxf) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
