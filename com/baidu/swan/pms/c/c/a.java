package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0364a> cCb;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0364a {
        public String cBk;
        public f cCc;
        public PMSAppInfo cCd;
        public boolean cCe;
        public int category;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.cCc == null || !(obj instanceof C0364a)) {
                return false;
            }
            return this.cCc.equals(((C0364a) obj).cCc);
        }

        public int hashCode() {
            return this.cCc == null ? super.hashCode() : this.cCc.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.cBk);
            if (this.cCc != null) {
                sb.append(",pkgMain=").append(this.cCc);
            }
            if (this.cCd != null) {
                sb.append(",appInfo=").append(this.cCd);
            }
            return sb.toString();
        }
    }
}
