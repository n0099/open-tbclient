package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public List<C0542a> esL;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0542a {
        public int category;
        public String erV;
        public int errorCode;
        public f esM;
        public List<g> esN;
        public PMSAppInfo esO;
        public boolean esP;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.esM == null || !(obj instanceof C0542a)) {
                return false;
            }
            return this.esM.equals(((C0542a) obj).esM);
        }

        public int hashCode() {
            return this.esM == null ? super.hashCode() : this.esM.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.erV);
            if (this.esM != null) {
                sb.append(",pkgMain=").append(this.esM);
            }
            if (this.esO != null) {
                sb.append(",appInfo=").append(this.esO);
            }
            return sb.toString();
        }
    }
}
