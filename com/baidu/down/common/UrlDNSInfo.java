package com.baidu.down.common;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class UrlDNSInfo implements Comparable<UrlDNSInfo> {
    public long dnsTime;
    public String host;
    public String ip;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(UrlDNSInfo urlDNSInfo) {
        return (TextUtils.equals(this.host, urlDNSInfo.host) && TextUtils.equals(this.ip, urlDNSInfo.ip)) ? 0 : 1;
    }
}
