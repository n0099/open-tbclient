package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    public List<C0532a> dUj;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0532a {
        public int category;
        public String dTs;
        public f dUk;
        public List<g> dUl;
        public PMSAppInfo dUm;
        public boolean dUn;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dUk == null || !(obj instanceof C0532a)) {
                return false;
            }
            return this.dUk.equals(((C0532a) obj).dUk);
        }

        public int hashCode() {
            return this.dUk == null ? super.hashCode() : this.dUk.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dTs);
            if (this.dUk != null) {
                sb.append(",pkgMain=").append(this.dUk);
            }
            if (this.dUm != null) {
                sb.append(",appInfo=").append(this.dUm);
            }
            return sb.toString();
        }
    }
}
