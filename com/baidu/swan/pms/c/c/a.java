package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    public List<C0515a> dIi;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static class C0515a {
        public int category;
        public String dHr;
        public f dIj;
        public List<g> dIk;
        public PMSAppInfo dIl;
        public boolean dIm;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dIj == null || !(obj instanceof C0515a)) {
                return false;
            }
            return this.dIj.equals(((C0515a) obj).dIj);
        }

        public int hashCode() {
            return this.dIj == null ? super.hashCode() : this.dIj.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dHr);
            if (this.dIj != null) {
                sb.append(",pkgMain=").append(this.dIj);
            }
            if (this.dIl != null) {
                sb.append(",appInfo=").append(this.dIl);
            }
            return sb.toString();
        }
    }
}
