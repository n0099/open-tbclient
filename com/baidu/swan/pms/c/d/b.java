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
    private Set<a> eoa;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.eoa = new LinkedHashSet();
            Map<String, PMSAppInfo> bdH = com.baidu.swan.pms.database.a.bdF().bdH();
            Map<String, com.baidu.swan.pms.model.f> bdG = com.baidu.swan.pms.database.a.bdF().bdG();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(bdH, bdG, aVar2, aVar);
                    this.eoa.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.eoa = new LinkedHashSet();
            Map<String, PMSAppInfo> bdH = com.baidu.swan.pms.database.a.bdF().bdH();
            Map<String, com.baidu.swan.pms.model.f> bdG = com.baidu.swan.pms.database.a.bdF().bdG();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(bdH, bdG, aVar2, aVar);
                    this.eoa.add(aVar2);
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
                aVar.dp(0L);
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.ve(aVar.getBundleId())) {
                aVar.dp(0L);
            } else {
                com.baidu.swan.pms.model.f fVar = map2.get(aVar.getBundleId());
                if (fVar != null) {
                    aVar.dp(fVar.versionCode);
                } else {
                    aVar.dp(0L);
                }
            }
            if (pMSAppInfo.csProtocolVersion >= PMSConstants.b.getVersion()) {
                aVar.dq(pMSAppInfo.appSign);
            } else {
                aVar.dq(0L);
            }
        }
    }

    @Nullable
    public Set<a> bev() {
        return this.eoa;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private String eob;
        private long eoc;
        private long eod;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.eoc = 0L;
            this.eod = 0L;
            this.eob = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.eoc = 0L;
            this.eod = 0L;
            this.eob = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.eob;
        }

        public long bew() {
            return this.eoc;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bex() {
            return this.eod;
        }

        void dp(long j) {
            this.eoc = j;
        }

        void dq(long j) {
            this.eod = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.eob, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.eob) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
