package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0364a> cBP;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0364a {
        public String cAY;
        public f cBQ;
        public PMSAppInfo cBR;
        public boolean cBS;
        public int category;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.cBQ == null || !(obj instanceof C0364a)) {
                return false;
            }
            return this.cBQ.equals(((C0364a) obj).cBQ);
        }

        public int hashCode() {
            return this.cBQ == null ? super.hashCode() : this.cBQ.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.cAY);
            if (this.cBQ != null) {
                sb.append(",pkgMain=").append(this.cBQ);
            }
            if (this.cBR != null) {
                sb.append(",appInfo=").append(this.cBR);
            }
            return sb.toString();
        }
    }
}
