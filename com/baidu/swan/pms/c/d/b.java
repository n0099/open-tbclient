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
    private Set<a> ecO;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.ecO = new LinkedHashSet();
            Map<String, PMSAppInfo> aYJ = com.baidu.swan.pms.database.a.aYH().aYJ();
            Map<String, com.baidu.swan.pms.model.f> aYI = com.baidu.swan.pms.database.a.aYH().aYI();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(aYJ, aYI, aVar2, aVar);
                    this.ecO.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.ecO = new LinkedHashSet();
            Map<String, PMSAppInfo> aYJ = com.baidu.swan.pms.database.a.aYH().aYJ();
            Map<String, com.baidu.swan.pms.model.f> aYI = com.baidu.swan.pms.database.a.aYH().aYI();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(aYJ, aYI, aVar2, aVar);
                    this.ecO.add(aVar2);
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
                aVar.cu(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.uo(aVar.getBundleId())) {
                aVar.cu(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.cu(fVar.versionCode);
                } else {
                    aVar.cu(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.cv(pMSAppInfo.appSign);
            } else {
                aVar.cv(0L);
            }
        }
    }

    @Nullable
    public Set<a> aZx() {
        return this.ecO;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private String ecP;
        private long ecQ;
        private long ecR;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.ecQ = 0L;
            this.ecR = 0L;
            this.ecP = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.ecQ = 0L;
            this.ecR = 0L;
            this.ecP = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.ecP;
        }

        public long aZy() {
            return this.ecQ;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aZz() {
            return this.ecR;
        }

        void cu(long j) {
            this.ecQ = j;
        }

        void cv(long j) {
            this.ecR = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.ecP, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.ecP) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
