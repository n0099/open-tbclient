package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    public List<C0558a> eix;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0558a {
        public int category;
        public String ehG;
        public PMSAppInfo eiA;
        public boolean eiB;
        public f eiy;
        public List<g> eiz;
        public int errorCode;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.eiy == null || !(obj instanceof C0558a)) {
                return false;
            }
            return this.eiy.equals(((C0558a) obj).eiy);
        }

        public int hashCode() {
            return this.eiy == null ? super.hashCode() : this.eiy.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.ehG);
            if (this.eiy != null) {
                sb.append(",pkgMain=").append(this.eiy);
            }
            if (this.eiA != null) {
                sb.append(",appInfo=").append(this.eiA);
            }
            return sb.toString();
        }
    }
}
