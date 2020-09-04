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
/* loaded from: classes14.dex */
public class b extends g {
    private Set<a> dGn;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.dGn = new LinkedHashSet();
            Map<String, PMSAppInfo> aTv = com.baidu.swan.pms.database.a.aTt().aTv();
            Map<String, com.baidu.swan.pms.model.f> aTu = com.baidu.swan.pms.database.a.aTt().aTu();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(aTv, aTu, aVar2, aVar);
                    this.dGn.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.dGn = new LinkedHashSet();
            Map<String, PMSAppInfo> aTv = com.baidu.swan.pms.database.a.aTt().aTv();
            Map<String, com.baidu.swan.pms.model.f> aTu = com.baidu.swan.pms.database.a.aTt().aTu();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(aTv, aTu, aVar2, aVar);
                    this.dGn.add(aVar2);
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
                aVar.cj(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.sQ(aVar.getBundleId())) {
                aVar.cj(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.cj(fVar.versionCode);
                } else {
                    aVar.cj(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.ck(pMSAppInfo.appSign);
            } else {
                aVar.ck(0L);
            }
        }
    }

    @Nullable
    public Set<a> aUj() {
        return this.dGn;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private String dGo;
        private long dGp;
        private long dGq;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.dGp = 0L;
            this.dGq = 0L;
            this.dGo = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.dGp = 0L;
            this.dGq = 0L;
            this.dGo = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.dGo;
        }

        public long aUk() {
            return this.dGp;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aUl() {
            return this.dGq;
        }

        void cj(long j) {
            this.dGp = j;
        }

        void ck(long j) {
            this.dGq = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.dGo, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.dGo) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
