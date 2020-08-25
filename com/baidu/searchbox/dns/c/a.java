package com.baidu.searchbox.dns.c;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.searchbox.dns.d.a.a w;
    private com.baidu.searchbox.dns.d.a x;
    private int y;

    private a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i) {
        this.x = aVar;
        this.w = aVar2;
        this.y = i;
    }

    public com.baidu.searchbox.dns.d.a.a h() {
        return this.w;
    }

    public com.baidu.searchbox.dns.d.a i() {
        return this.x;
    }

    public int j() {
        return this.y;
    }

    /* renamed from: com.baidu.searchbox.dns.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0311a {
        private final long A;
        private int B;
        private String C;
        private long D;
        private final com.baidu.searchbox.dns.d.a x;
        private final com.baidu.searchbox.dns.d.a.a z;

        public C0311a(long j, com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2) {
            this.B = -1;
            this.D = -1L;
            this.A = j;
            this.z = aVar2;
            this.x = aVar;
            if (aVar2 != null) {
                this.B = aVar2.B;
                this.C = aVar2.C;
                this.D = aVar2.D;
            }
        }

        public a k() {
            if (this.z == null) {
                return new a(this.x, null, 1002);
            }
            if (TextUtils.isEmpty(this.C)) {
                return new a(this.x, null, 1005);
            }
            if (this.C.equals("ok")) {
                if (this.B >= 0 && this.D > 0) {
                    if (this.A - this.D > this.B) {
                        return new a(this.x, null, 1003);
                    }
                    if (this.A - this.D >= 180000) {
                        if (this.x != null) {
                            return new a(this.x, this.z, 1001);
                        }
                        return new a(null, this.z, 2001);
                    }
                    return new a(null, this.z, 2001);
                } else if (this.B < 0 && this.D > 0) {
                    if (this.A - this.D > 60000) {
                        return new a(this.x, null, 1007);
                    }
                    return new a(null, this.z, 2003);
                } else {
                    return new a(this.x, null, 1008);
                }
            } else if (this.C.equals("warning")) {
                if (this.A - this.D >= 60000) {
                    return new a(this.x, null, 1004);
                }
                return new a(null, null, 2);
            } else if (this.C.equals("stop")) {
                if (this.A - this.D >= 300000) {
                    return new a(this.x, null, 1004);
                }
                return new a(null, null, 2);
            } else {
                return new a(this.x, null, 1004);
            }
        }
    }
}
