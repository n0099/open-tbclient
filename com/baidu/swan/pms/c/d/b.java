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
/* loaded from: classes24.dex */
public class b extends g {
    private Set<a> dIr;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.dIr = new LinkedHashSet();
            Map<String, PMSAppInfo> aUh = com.baidu.swan.pms.database.a.aUf().aUh();
            Map<String, com.baidu.swan.pms.model.f> aUg = com.baidu.swan.pms.database.a.aUf().aUg();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(aUh, aUg, aVar2, aVar);
                    this.dIr.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.dIr = new LinkedHashSet();
            Map<String, PMSAppInfo> aUh = com.baidu.swan.pms.database.a.aUf().aUh();
            Map<String, com.baidu.swan.pms.model.f> aUg = com.baidu.swan.pms.database.a.aUf().aUg();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(aUh, aUg, aVar2, aVar);
                    this.dIr.add(aVar2);
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
                aVar.ck(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.tj(aVar.getBundleId())) {
                aVar.ck(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.ck(fVar.versionCode);
                } else {
                    aVar.ck(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.cl(pMSAppInfo.appSign);
            } else {
                aVar.cl(0L);
            }
        }
    }

    @Nullable
    public Set<a> aUV() {
        return this.dIr;
    }

    /* loaded from: classes24.dex */
    public static class a {
        private String dIs;
        private long dIt;
        private long dIu;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.dIt = 0L;
            this.dIu = 0L;
            this.dIs = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.dIt = 0L;
            this.dIu = 0L;
            this.dIs = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.dIs;
        }

        public long aUW() {
            return this.dIt;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long aUX() {
            return this.dIu;
        }

        void ck(long j) {
            this.dIt = j;
        }

        void cl(long j) {
            this.dIu = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.dIs, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.dIs) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
