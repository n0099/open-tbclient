package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes14.dex */
public class a {
    public List<C0520a> dGa;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0520a {
        public int category;
        public String dFj;
        public f dGb;
        public List<g> dGc;
        public PMSAppInfo dGd;
        public boolean dGe;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dGb == null || !(obj instanceof C0520a)) {
                return false;
            }
            return this.dGb.equals(((C0520a) obj).dGb);
        }

        public int hashCode() {
            return this.dGb == null ? super.hashCode() : this.dGb.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dFj);
            if (this.dGb != null) {
                sb.append(",pkgMain=").append(this.dGb);
            }
            if (this.dGd != null) {
                sb.append(",appInfo=").append(this.dGd);
            }
            return sb.toString();
        }
    }
}
