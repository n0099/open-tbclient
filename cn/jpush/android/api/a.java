package cn.jpush.android.api;

import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.Set;
/* loaded from: classes3.dex */
public final class a {
    public String a;
    public Set<String> b;
    public TagAliasCallback c;
    public int d;
    public int e;
    public int f;
    private long g;

    public a(int i, String str, long j, int i2, int i3) {
        this.e = 0;
        this.f = 0;
        this.d = i;
        this.a = str;
        this.g = j;
        this.e = i2;
        this.f = i3;
    }

    public a(int i, Set<String> set, long j, int i2, int i3) {
        this.e = 0;
        this.f = 0;
        this.d = i;
        this.b = set;
        this.g = j;
        this.e = i2;
        this.f = i3;
    }

    public a(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j, int i, int i2) {
        this.e = 0;
        this.f = 0;
        this.a = str;
        this.b = set;
        this.c = tagAliasCallback;
        this.g = j;
        this.e = i;
        this.f = i2;
    }

    public final boolean a(long j) {
        return this.e == 0 && System.currentTimeMillis() - this.g > StatisticConfig.MIN_UPLOAD_INTERVAL;
    }

    public final String toString() {
        return "CallBackParams{sendTime=" + this.g + ", alias='" + this.a + "', tags=" + this.b + ", tagAliasCallBack=" + this.c + ", sequence=" + this.d + ", protoType=" + this.e + ", action=" + this.f + '}';
    }
}
