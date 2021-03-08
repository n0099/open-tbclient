package com.baidu.swan.pms.c.c;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public List<C0545a> ewt;

    /* renamed from: com.baidu.swan.pms.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0545a {
        public int category;
        public int errorCode;
        public String evD;
        public f ewu;
        public List<g> ewv;
        public PMSAppInfo eww;
        public boolean ewx;

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || this.ewu == null || !(obj instanceof C0545a)) {
                return false;
            }
            return this.ewu.equals(((C0545a) obj).ewu);
        }

        public int hashCode() {
            return this.ewu == null ? super.hashCode() : this.ewu.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PMS Item: ").append(this.evD);
            if (this.ewu != null) {
                sb.append(",pkgMain=").append(this.ewu);
            }
            if (this.eww != null) {
                sb.append(",appInfo=").append(this.eww);
            }
            return sb.toString();
        }
    }
}
