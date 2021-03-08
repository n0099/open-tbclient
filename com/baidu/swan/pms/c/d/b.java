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
/* loaded from: classes3.dex */
public class b extends g {
    private Set<a> ewC;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.ewC = new LinkedHashSet();
            Map<String, PMSAppInfo> bcz = com.baidu.swan.pms.database.a.bcx().bcz();
            Map<String, com.baidu.swan.pms.model.f> bcy = com.baidu.swan.pms.database.a.bcx().bcy();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(bcz, bcy, aVar2, aVar);
                    this.ewC.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.ewC = new LinkedHashSet();
            Map<String, PMSAppInfo> bcz = com.baidu.swan.pms.database.a.bcx().bcz();
            Map<String, com.baidu.swan.pms.model.f> bcy = com.baidu.swan.pms.database.a.bcx().bcy();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(bcz, bcy, aVar2, aVar);
                    this.ewC.add(aVar2);
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
                aVar.dw(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.us(aVar.getBundleId())) {
                aVar.dw(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.dw(fVar.versionCode);
                } else {
                    aVar.dw(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.dx(pMSAppInfo.appSign);
            } else {
                aVar.dx(0L);
            }
        }
    }

    @Nullable
    public Set<a> bdm() {
        return this.ewC;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String ewD;
        private long ewE;
        private long ewF;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.ewE = 0L;
            this.ewF = 0L;
            this.ewD = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.ewE = 0L;
            this.ewF = 0L;
            this.ewD = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.ewD;
        }

        public long bdn() {
            return this.ewE;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bdo() {
            return this.ewF;
        }

        void dw(long j) {
            this.ewE = j;
        }

        void dx(long j) {
            this.ewF = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.ewD, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.ewD) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
