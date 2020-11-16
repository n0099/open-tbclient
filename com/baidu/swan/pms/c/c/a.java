package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public List<C0556a> egQ;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0556a {
        public int category;
        public String efY;
        public f egR;
        public List<g> egS;
        public PMSAppInfo egT;
        public boolean egU;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.egR == null || !(obj instanceof C0556a)) {
                return false;
            }
            return this.egR.equals(((C0556a) obj).egR);
        }

        public int hashCode() {
            return this.egR == null ? super.hashCode() : this.egR.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.efY);
            if (this.egR != null) {
                sb.append(",pkgMain=").append(this.egR);
            }
            if (this.egT != null) {
                sb.append(",appInfo=").append(this.egT);
            }
            return sb.toString();
        }
    }
}
