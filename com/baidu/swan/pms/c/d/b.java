package com.baidu.swan.pms.c.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    private Set<a> exI;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.exI = new LinkedHashSet();
            Map<String, PMSAppInfo> bge = com.baidu.swan.pms.database.a.bgc().bge();
            Map<String, com.baidu.swan.pms.model.f> bgd = com.baidu.swan.pms.database.a.bgc().bgd();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(bge, bgd, aVar2, aVar);
                    this.exI.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.exI = new LinkedHashSet();
            Map<String, PMSAppInfo> bge = com.baidu.swan.pms.database.a.bgc().bge();
            Map<String, com.baidu.swan.pms.model.f> bgd = com.baidu.swan.pms.database.a.bgc().bgd();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(bge, bgd, aVar2, aVar);
                    this.exI.add(aVar2);
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
                aVar.dq(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.vd(aVar.getBundleId())) {
                aVar.dq(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.dq(fVar.versionCode);
                } else {
                    aVar.dq(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.dr(pMSAppInfo.appSign);
            } else {
                aVar.dr(0L);
            }
        }
    }

    @Nullable
    public Set<a> bgR() {
        return this.exI;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String exJ;
        private long exK;
        private long exL;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.exK = 0L;
            this.exL = 0L;
            this.exJ = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.exK = 0L;
            this.exL = 0L;
            this.exJ = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.exJ;
        }

        public long bgS() {
            return this.exK;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bgT() {
            return this.exL;
        }

        void dq(long j) {
            this.exK = j;
        }

        void dr(long j) {
            this.exL = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.exJ, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.exJ) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
