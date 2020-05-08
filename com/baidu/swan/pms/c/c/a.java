package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public List<C0415a> dbg;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0415a {
        public int category;
        public String dan;
        public f dbh;
        public PMSAppInfo dbi;
        public boolean dbj;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dbh == null || !(obj instanceof C0415a)) {
                return false;
            }
            return this.dbh.equals(((C0415a) obj).dbh);
        }

        public int hashCode() {
            return this.dbh == null ? super.hashCode() : this.dbh.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dan);
            if (this.dbh != null) {
                sb.append(",pkgMain=").append(this.dbh);
            }
            if (this.dbi != null) {
                sb.append(",appInfo=").append(this.dbi);
            }
            return sb.toString();
        }
    }
}
