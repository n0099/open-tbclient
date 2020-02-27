package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0364a> cBO;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0364a {
        public String cAX;
        public f cBP;
        public PMSAppInfo cBQ;
        public boolean cBR;
        public int category;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.cBP == null || !(obj instanceof C0364a)) {
                return false;
            }
            return this.cBP.equals(((C0364a) obj).cBP);
        }

        public int hashCode() {
            return this.cBP == null ? super.hashCode() : this.cBP.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.cAX);
            if (this.cBP != null) {
                sb.append(",pkgMain=").append(this.cBP);
            }
            if (this.cBQ != null) {
                sb.append(",appInfo=").append(this.cBQ);
            }
            return sb.toString();
        }
    }
}
