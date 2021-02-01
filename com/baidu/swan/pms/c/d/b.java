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
    private Set<a> evb;

    public b(List<? extends a> list, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (list != null && !list.isEmpty()) {
            this.evb = new LinkedHashSet();
            Map<String, PMSAppInfo> bcx = com.baidu.swan.pms.database.a.bcv().bcx();
            Map<String, com.baidu.swan.pms.model.f> bcw = com.baidu.swan.pms.database.a.bcv().bcw();
            for (a aVar2 : list) {
                if (aVar2 != null && !TextUtils.isEmpty(aVar2.getBundleId())) {
                    a(bcx, bcw, aVar2, aVar);
                    this.evb.add(aVar2);
                }
            }
        }
    }

    public b(Collection<String> collection, @Nullable com.baidu.swan.pms.utils.a aVar) {
        super(-1);
        if (collection != null && !collection.isEmpty()) {
            this.evb = new LinkedHashSet();
            Map<String, PMSAppInfo> bcx = com.baidu.swan.pms.database.a.bcv().bcx();
            Map<String, com.baidu.swan.pms.model.f> bcw = com.baidu.swan.pms.database.a.bcv().bcw();
            for (String str : collection) {
                if (!TextUtils.isEmpty(str)) {
                    a aVar2 = new a(str);
                    a(bcx, bcw, aVar2, aVar);
                    this.evb.add(aVar2);
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
            } else if (aVar2 != null && pMSAppInfo.versionCode != 0 && !aVar2.ul(aVar.getBundleId())) {
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
    public Set<a> bdk() {
        return this.evb;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private String evc;
        private long evd;
        private long eve;
        private int mCategory;

        public a(String str) {
            this.mCategory = -1;
            this.evd = 0L;
            this.eve = 0L;
            this.evc = str;
        }

        public a(String str, int i) {
            this.mCategory = -1;
            this.evd = 0L;
            this.eve = 0L;
            this.evc = str;
            this.mCategory = i;
        }

        public String getBundleId() {
            return this.evc;
        }

        public long bdl() {
            return this.evd;
        }

        public int getCategory() {
            return this.mCategory;
        }

        public long bdm() {
            return this.eve;
        }

        void dw(long j) {
            this.evd = j;
        }

        void dx(long j) {
            this.eve = j;
        }

        void setCategory(int i) {
            this.mCategory = i;
        }

        public int hashCode() {
            return Objects.hash(this.evc, Integer.valueOf(this.mCategory));
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return TextUtils.equals(aVar.getBundleId(), this.evc) && aVar.getCategory() == this.mCategory;
            }
            return false;
        }
    }
}
