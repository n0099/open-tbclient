package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public List<C0559a> exz;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0559a {
        public int category;
        public int errorCode;
        public String ewI;
        public f exA;
        public List<g> exB;
        public PMSAppInfo exC;
        public boolean exD;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.exA == null || !(obj instanceof C0559a)) {
                return false;
            }
            return this.exA.equals(((C0559a) obj).exA);
        }

        public int hashCode() {
            return this.exA == null ? super.hashCode() : this.exA.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.ewI);
            if (this.exA != null) {
                sb.append(",pkgMain=").append(this.exA);
            }
            if (this.exC != null) {
                sb.append(",appInfo=").append(this.exC);
            }
            return sb.toString();
        }
    }
}
