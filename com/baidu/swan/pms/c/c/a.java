package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0456a> dms;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0456a {
        public int category;
        public String dlx;
        public f dmt;
        public PMSAppInfo dmu;
        public boolean dmv;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dmt == null || !(obj instanceof C0456a)) {
                return false;
            }
            return this.dmt.equals(((C0456a) obj).dmt);
        }

        public int hashCode() {
            return this.dmt == null ? super.hashCode() : this.dmt.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dlx);
            if (this.dmt != null) {
                sb.append(",pkgMain=").append(this.dmt);
            }
            if (this.dmu != null) {
                sb.append(",appInfo=").append(this.dmu);
            }
            return sb.toString();
        }
    }
}
