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
    private Set<a> esU;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.esU = new LinkedHashSet();
            Map<String, PMSAppInfo> bck = com.baidu.swan.pms.database.a.bci().bck();
            Map<String, com.baidu.swan.pms.model.f> bcj = com.baidu.swan.pms.database.a.bci().bcj();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(bck, bcj, aVar2, aVar);
                    this.esU.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.esU = new LinkedHashSet();
            Map<String, PMSAppInfo> bck = com.baidu.swan.pms.database.a.bci().bck();
            Map<String, com.baidu.swan.pms.model.f> bcj = com.baidu.swan.pms.database.a.bci().bcj();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(bck, bcj, aVar2, aVar);
                    this.esU.add(aVar2);
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
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.tS(aVar.getBundleId())) {
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
    public Set<a> bcX() {
        return this.esU;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String esV;
        private long esW;
        private long esX;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.esW = 0L;
            this.esX = 0L;
            this.esV = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.esW = 0L;
            this.esX = 0L;
            this.esV = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.esV;
        }

        public long bcY() {
            return this.esW;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bcZ() {
            return this.esX;
        }

        void dq(long j) {
            this.esW = j;
        }

        void dr(long j) {
            this.esX = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.esV, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.esV) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
