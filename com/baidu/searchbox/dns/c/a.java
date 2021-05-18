package com.baidu.searchbox.dns.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class a {
    public com.baidu.searchbox.dns.d.a.a w;
    public com.baidu.searchbox.dns.d.a x;
    public int y;

    /* renamed from: com.baidu.searchbox.dns.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0133a {
        public final long A;
        public int B;
        public String C;
        public long D;
        public final com.baidu.searchbox.dns.d.a x;
        public final com.baidu.searchbox.dns.d.a.a z;

        public C0133a(long j, com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2) {
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
                int i2 = this.B;
                if (i2 >= 0) {
                    long j = this.D;
                    if (j > 0) {
                        long j2 = this.A;
                        if (j2 - j > i2) {
                            return new a(this.x, null, 1003);
                        }
                        if (j2 - j >= 180000) {
                            com.baidu.searchbox.dns.d.a aVar = this.x;
                            if (aVar != null) {
                                return new a(aVar, this.z, 1001);
                            }
                            return new a(null, this.z, 2001);
                        }
                        return new a(null, this.z, 2001);
                    }
                }
                if (this.B < 0) {
                    long j3 = this.D;
                    if (j3 > 0) {
                        if (this.A - j3 > 60000) {
                            return new a(this.x, null, 1007);
                        }
                        return new a(null, this.z, 2003);
                    }
                }
                return new a(this.x, null, 1008);
            } else if (this.C.equals("warning")) {
                if (this.A - this.D >= 60000) {
                    return new a(this.x, null, 1004);
                }
                return new a(null, null, 2);
            } else if (this.C.equals(IntentConfig.STOP)) {
                if (this.A - this.D >= 300000) {
                    return new a(this.x, null, 1004);
                }
                return new a(null, null, 2);
            } else {
                return new a(this.x, null, 1004);
            }
        }
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

    public a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i2) {
        this.x = aVar;
        this.w = aVar2;
        this.y = i2;
    }
}
