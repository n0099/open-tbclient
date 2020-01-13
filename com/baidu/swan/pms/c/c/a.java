package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public List<C0354a> cxQ;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0354a {
        public int category;
        public String cwZ;
        public f cxR;
        public PMSAppInfo cxS;
        public boolean cxT;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.cxR == null || !(obj instanceof C0354a)) {
                return false;
            }
            return this.cxR.equals(((C0354a) obj).cxR);
        }

        public int hashCode() {
            return this.cxR == null ? super.hashCode() : this.cxR.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.cwZ);
            if (this.cxR != null) {
                sb.append(",pkgMain=").append(this.cxR);
            }
            if (this.cxS != null) {
                sb.append(",appInfo=").append(this.cxS);
            }
            return sb.toString();
        }
    }
}
