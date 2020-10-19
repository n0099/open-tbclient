package com.baidu.swan.pms.c.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes15.dex */
public class b extends g {
    private Set<a> dUs;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.dUs = new LinkedHashSet();
            Map<String, PMSAppInfo> aWQ = com.baidu.swan.pms.database.a.aWO().aWQ();
            Map<String, com.baidu.swan.pms.model.f> aWP = com.baidu.swan.pms.database.a.aWO().aWP();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(aWQ, aWP, aVar2, aVar);
                    this.dUs.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.dUs = new LinkedHashSet();
            Map<String, PMSAppInfo> aWQ = com.baidu.swan.pms.database.a.aWO().aWQ();
            Map<String, com.baidu.swan.pms.model.f> aWP = com.baidu.swan.pms.database.a.aWO().aWP();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(aWQ, aWP, aVar2, aVar);
                    this.dUs.add(aVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull Map<String, PMSAppInfo> map, @NonNull Map<String, com.baidu.swan.pms.model.f> map2, @NonNull a aVar, @Nullable com.baidu.swan.pms.utils.a aVar2) {
        PMSAppInfo pMSAppInfo;
        if (map.containsKey(aVar.getBundleId()) && (pMSAppInfo = map.get(aVar.getBundleId())) != null) {
            if (aVar.getCategory() != -1) {
                aVar.setCategory(pMSAppInfo.appCategory);
            }
            if (!map2.containsKey(aVar.getBundleId())) {
                aVar.cs(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.tV(aVar.getBundleId())) {
                aVar.cs(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.cs(fVar.versionCode);
                } else {
                    aVar.cs(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.ct(pMSAppInfo.appSign);
            } else {
                aVar.ct(0L);
            }
        }
    }

    @Nullable
    public Set<a> aXE() {
        return this.dUs;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private String dUt;
        private long dUu;
        private long dUv;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.dUu = 0L;
            this.dUv = 0L;
            this.dUt = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.dUu = 0L;
            this.dUv = 0L;
            this.dUt = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.dUt;
        }

        public long aXF() {
            return this.dUu;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aXG() {
            return this.dUv;
        }

        void cs(long j) {
            this.dUu = j;
        }

        void ct(long j) {
            this.dUv = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.dUt, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.dUt) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
