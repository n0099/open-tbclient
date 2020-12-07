package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public List<C0568a> enR;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0568a {
        public int category;
        public String emZ;
        public f enS;
        public List<g> enT;
        public PMSAppInfo enU;
        public boolean enV;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.enS == null || !(obj instanceof C0568a)) {
                return false;
            }
            return this.enS.equals(((C0568a) obj).enS);
        }

        public int hashCode() {
            return this.enS == null ? super.hashCode() : this.enS.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.emZ);
            if (this.enS != null) {
                sb.append(",pkgMain=").append(this.enS);
            }
            if (this.enU != null) {
                sb.append(",appInfo=").append(this.enU);
            }
            return sb.toString();
        }
    }
}
