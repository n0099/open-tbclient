package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes19.dex */
public class a {
    public List<C0474a> dwV;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0474a {
        public int category;
        public String dvZ;
        public f dwW;
        public List<g> dwX;
        public PMSAppInfo dwY;
        public boolean dwZ;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.dwW == null || !(obj instanceof C0474a)) {
                return false;
            }
            return this.dwW.equals(((C0474a) obj).dwW);
        }

        public int hashCode() {
            return this.dwW == null ? super.hashCode() : this.dwW.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.dvZ);
            if (this.dwW != null) {
                sb.append(",pkgMain=").append(this.dwW);
            }
            if (this.dwY != null) {
                sb.append(",appInfo=").append(this.dwY);
            }
            return sb.toString();
        }
    }
}
