package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0462a> drd;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0462a {
        public int category;
        public String dqi;
        public f dre;
        public PMSAppInfo drf;
        public boolean drg;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dre == null || !(obj instanceof C0462a)) {
                return false;
            }
            return this.dre.equals(((C0462a) obj).dre);
        }

        public int hashCode() {
            return this.dre == null ? super.hashCode() : this.dre.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dqi);
            if (this.dre != null) {
                sb.append(",pkgMain=").append(this.dre);
            }
            if (this.drf != null) {
                sb.append(",appInfo=").append(this.drf);
            }
            return sb.toString();
        }
    }
}
