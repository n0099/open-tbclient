package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public List<C0352a> cxF;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0352a {
        public int category;
        public String cwO;
        public f cxG;
        public PMSAppInfo cxH;
        public boolean cxI;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.cxG == null || !(obj instanceof C0352a)) {
                return false;
            }
            return this.cxG.equals(((C0352a) obj).cxG);
        }

        public int hashCode() {
            return this.cxG == null ? super.hashCode() : this.cxG.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.cwO);
            if (this.cxG != null) {
                sb.append(",pkgMain=").append(this.cxG);
            }
            if (this.cxH != null) {
                sb.append(",appInfo=").append(this.cxH);
            }
            return sb.toString();
        }
    }
}
