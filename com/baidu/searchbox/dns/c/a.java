package com.baidu.searchbox.dns.c;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.searchbox.dns.d.a.a q;
    private com.baidu.searchbox.dns.d.a r;
    private int s;

    private a(com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2, int i) {
        this.r = aVar;
        this.q = aVar2;
        this.s = i;
    }

    public com.baidu.searchbox.dns.d.a.a f() {
        return this.q;
    }

    public com.baidu.searchbox.dns.d.a g() {
        return this.r;
    }

    public int h() {
        return this.s;
    }

    /* renamed from: com.baidu.searchbox.dns.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0103a {
        private final com.baidu.searchbox.dns.d.a r;
        private final com.baidu.searchbox.dns.d.a.a t;
        private final long u;
        private int v;
        private String w;
        private long x;

        public C0103a(long j, com.baidu.searchbox.dns.d.a aVar, com.baidu.searchbox.dns.d.a.a aVar2) {
            this.v = -1;
            this.x = -1L;
            this.u = j;
            this.t = aVar2;
            this.r = aVar;
            if (aVar2 != null) {
                this.v = aVar2.v;
                this.w = aVar2.w;
                this.x = aVar2.x;
            }
        }

        public a i() {
            if (this.t == null) {
                return new a(this.r, null, 1002);
            }
            if (TextUtils.isEmpty(this.w)) {
                return new a(this.r, null, 1005);
            }
            if (this.w.equals(AiAppsBluetoothConstants.ERROR_OK)) {
                if (this.v >= 0 && this.x > 0) {
                    if (this.u - this.x > this.v) {
                        return new a(this.r, null, 1003);
                    }
                    if (this.u - this.x >= 60000) {
                        if (this.r != null) {
                            return new a(this.r, this.t, 1001);
                        }
                        return new a(null, this.t, 2001);
                    }
                    return new a(null, this.t, 2001);
                } else if (this.v < 0 && this.x > 0) {
                    if (this.u - this.x > 60000) {
                        return new a(this.r, null, 1007);
                    }
                    return new a(null, this.t, 2003);
                } else {
                    return new a(this.r, null, 1008);
                }
            } else if (this.w.equals("warning")) {
                if (this.u - this.x >= 60000) {
                    return new a(this.r, null, 1004);
                }
                return new a(null, null, 2);
            } else if (this.w.equals(IntentConfig.STOP)) {
                if (this.u - this.x >= ReportUserInfoModel.TIME_INTERVAL) {
                    return new a(this.r, null, 1004);
                }
                return new a(null, null, 2);
            } else {
                return new a(this.r, null, 1004);
            }
        }
    }
}
