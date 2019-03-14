package cn.jiguang.d.b;

import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
final class k {
    String a;
    int b;

    public k(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            throw new Exception("Port is needed for a valid address, split by :");
        }
        this.a = str.substring(0, indexOf);
        if (!j.c(this.a)) {
            throw new Exception("Invalid ip - " + this.a);
        }
        String substring = str.substring(indexOf + 1);
        try {
            this.b = Integer.parseInt(substring);
            if (this.b == 0) {
                throw new Exception("Invalid port - 0");
            }
        } catch (Exception e) {
            throw new Exception("Invalid port - " + substring);
        }
    }

    public final String toString() {
        return this.a + Config.TRACE_TODAY_VISIT_SPLIT + this.b;
    }
}
