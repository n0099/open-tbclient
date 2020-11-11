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
    private Set<a> eiG;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.eiG = new LinkedHashSet();
            Map<String, PMSAppInfo> bbj = com.baidu.swan.pms.database.a.bbh().bbj();
            Map<String, com.baidu.swan.pms.model.f> bbi = com.baidu.swan.pms.database.a.bbh().bbi();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(bbj, bbi, aVar2, aVar);
                    this.eiG.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.eiG = new LinkedHashSet();
            Map<String, PMSAppInfo> bbj = com.baidu.swan.pms.database.a.bbh().bbj();
            Map<String, com.baidu.swan.pms.model.f> bbi = com.baidu.swan.pms.database.a.bbh().bbi();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(bbj, bbi, aVar2, aVar);
                    this.eiG.add(aVar2);
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
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.uC(aVar.getBundleId())) {
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
    public Set<a> bbX() {
        return this.eiG;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private String eiH;
        private long eiI;
        private long eiJ;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.eiI = 0L;
            this.eiJ = 0L;
            this.eiH = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.eiI = 0L;
            this.eiJ = 0L;
            this.eiH = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.eiH;
        }

        public long bbY() {
            return this.eiI;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bbZ() {
            return this.eiJ;
        }

        void cQ(long j) {
            this.eiI = j;
        }

        void cR(long j) {
            this.eiJ = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.eiH, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.eiH) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
