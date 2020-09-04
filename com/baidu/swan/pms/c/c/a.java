package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes14.dex */
public class a {
    public List<C0520a> dGe;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0520a {
        public int category;
        public String dFn;
        public f dGf;
        public List<g> dGg;
        public PMSAppInfo dGh;
        public boolean dGi;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dGf == null || !(obj instanceof C0520a)) {
                return false;
            }
            return this.dGf.equals(((C0520a) obj).dGf);
        }

        public int hashCode() {
            return this.dGf == null ? super.hashCode() : this.dGf.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dFn);
            if (this.dGf != null) {
                sb.append(",pkgMain=").append(this.dGf);
            }
            if (this.dGh != null) {
                sb.append(",appInfo=").append(this.dGh);
            }
            return sb.toString();
        }
    }
}
