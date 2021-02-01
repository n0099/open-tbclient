package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public List<C0539a> euS;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0539a {
        public int category;
        public int errorCode;
        public f euT;
        public List<g> euU;
        public PMSAppInfo euV;
        public boolean euW;
        public String euc;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.euT == null || !(obj instanceof C0539a)) {
                return false;
            }
            return this.euT.equals(((C0539a) obj).euT);
        }

        public int hashCode() {
            return this.euT == null ? super.hashCode() : this.euT.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.euc);
            if (this.euT != null) {
                sb.append(",pkgMain=").append(this.euT);
            }
            if (this.euV != null) {
                sb.append(",appInfo=").append(this.euV);
            }
            return sb.toString();
        }
    }
}
