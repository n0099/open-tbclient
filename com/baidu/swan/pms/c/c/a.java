package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    public List<C0546a> ecF;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0546a {
        public int category;
        public String ebO;
        public f ecG;
        public List<g> ecH;
        public PMSAppInfo ecI;
        public boolean ecJ;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.ecG == null || !(obj instanceof C0546a)) {
                return false;
            }
            return this.ecG.equals(((C0546a) obj).ecG);
        }

        public int hashCode() {
            return this.ecG == null ? super.hashCode() : this.ecG.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.ebO);
            if (this.ecG != null) {
                sb.append(",pkgMain=").append(this.ecG);
            }
            if (this.ecI != null) {
                sb.append(",appInfo=").append(this.ecI);
            }
            return sb.toString();
        }
    }
}
