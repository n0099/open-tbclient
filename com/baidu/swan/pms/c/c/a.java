package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0364a> cBQ;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0364a {
        public String cAZ;
        public f cBR;
        public PMSAppInfo cBS;
        public boolean cBT;
        public int category;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.cBR == null || !(obj instanceof C0364a)) {
                return false;
            }
            return this.cBR.equals(((C0364a) obj).cBR);
        }

        public int hashCode() {
            return this.cBR == null ? super.hashCode() : this.cBR.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.cAZ);
            if (this.cBR != null) {
                sb.append(",pkgMain=").append(this.cBR);
            }
            if (this.cBS != null) {
                sb.append(",appInfo=").append(this.cBS);
            }
            return sb.toString();
        }
    }
}
