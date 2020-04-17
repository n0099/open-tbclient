package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0394a> dbb;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0394a {
        public int category;
        public String dai;
        public f dbc;
        public PMSAppInfo dbd;
        public boolean dbe;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dbc == null || !(obj instanceof C0394a)) {
                return false;
            }
            return this.dbc.equals(((C0394a) obj).dbc);
        }

        public int hashCode() {
            return this.dbc == null ? super.hashCode() : this.dbc.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dai);
            if (this.dbc != null) {
                sb.append(",pkgMain=").append(this.dbc);
            }
            if (this.dbd != null) {
                sb.append(",appInfo=").append(this.dbd);
            }
            return sb.toString();
        }
    }
}
