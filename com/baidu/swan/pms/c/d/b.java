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
/* loaded from: classes6.dex */
public class b extends g {
    private Set<a> egZ;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.egZ = new LinkedHashSet();
            Map<String, PMSAppInfo> baC = com.baidu.swan.pms.database.a.baA().baC();
            Map<String, com.baidu.swan.pms.model.f> baB = com.baidu.swan.pms.database.a.baA().baB();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(baC, baB, aVar2, aVar);
                    this.egZ.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.egZ = new LinkedHashSet();
            Map<String, PMSAppInfo> baC = com.baidu.swan.pms.database.a.baA().baC();
            Map<String, com.baidu.swan.pms.model.f> baB = com.baidu.swan.pms.database.a.baA().baB();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(baC, baB, aVar2, aVar);
                    this.egZ.add(aVar2);
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
                aVar.cQ(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.ux(aVar.getBundleId())) {
                aVar.cQ(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.cQ(fVar.versionCode);
                } else {
                    aVar.cQ(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.cR(pMSAppInfo.appSign);
            } else {
                aVar.cR(0L);
            }
        }
    }

    @Nullable
    public Set<a> bbq() {
        return this.egZ;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String eha;
        private long ehb;
        private long ehc;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.ehb = 0L;
            this.ehc = 0L;
            this.eha = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.ehb = 0L;
            this.ehc = 0L;
            this.eha = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.eha;
        }

        public long bbr() {
            return this.ehb;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bbs() {
            return this.ehc;
        }

        void cQ(long j) {
            this.ehb = j;
        }

        void cR(long j) {
            this.ehc = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.eha, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.eha) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
