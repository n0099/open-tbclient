package com.baidu.searchbox.dns.stratege;

import android.text.TextUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.searchbox.dns.transmit.DnsTransmitTask;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
/* loaded from: classes2.dex */
public class DnsStrategy {
    public DnsModel cacheDnsModel;
    public DnsTransmitTask dnsTransmitTask;
    public int parseSubType;

    /* loaded from: classes2.dex */
    public static class Factory {
        public static final int DEFAULT_EXPIRE_INTERVAL = 60000;
        public static final int PRE_FETCH_INTERVAL = 180000;
        public static final int STOP_RETRY_INTERVAL = 300000;
        public static final int WARN_RETRY_INTERVAL = 60000;
        public long cacheTime;
        public final long currentTime;
        public final DnsModel dnsModel;
        public final DnsTransmitTask dnsTransmitTask;
        public String msg;
        public int ttl;
        public final boolean useExpire;

        public Factory(long j, DnsTransmitTask dnsTransmitTask, DnsModel dnsModel, boolean z) {
            this.ttl = -1;
            this.cacheTime = -1L;
            this.currentTime = j;
            this.dnsModel = dnsModel;
            this.dnsTransmitTask = dnsTransmitTask;
            this.useExpire = z;
            if (dnsModel != null) {
                this.ttl = dnsModel.ttl;
                this.msg = dnsModel.msg;
                this.cacheTime = dnsModel.cacheTime;
            }
        }

        public DnsStrategy get() {
            if (this.dnsModel == null) {
                return new DnsStrategy(this.dnsTransmitTask, null, 1002);
            }
            if (TextUtils.isEmpty(this.msg)) {
                return new DnsStrategy(this.dnsTransmitTask, null, 1005);
            }
            if (this.msg.equals(DnsModel.MSG_OK)) {
                int i = this.ttl;
                if (i >= 0) {
                    long j = this.cacheTime;
                    if (j > 0) {
                        long j2 = this.currentTime;
                        if (j2 - j > i) {
                            if (this.useExpire) {
                                return new DnsStrategy(this.dnsTransmitTask, this.dnsModel, 2009);
                            }
                            return new DnsStrategy(this.dnsTransmitTask, null, 1003);
                        } else if (j2 - j >= LiveFeedPageSdk.REFRESH_TIME) {
                            DnsTransmitTask dnsTransmitTask = this.dnsTransmitTask;
                            if (dnsTransmitTask != null) {
                                return new DnsStrategy(dnsTransmitTask, this.dnsModel, 1001);
                            }
                            return new DnsStrategy(null, this.dnsModel, 2001);
                        } else {
                            return new DnsStrategy(null, this.dnsModel, 2001);
                        }
                    }
                }
                if (this.ttl < 0) {
                    long j3 = this.cacheTime;
                    if (j3 > 0) {
                        if (this.currentTime - j3 > 60000) {
                            return new DnsStrategy(this.dnsTransmitTask, null, 1007);
                        }
                        return new DnsStrategy(null, this.dnsModel, 2003);
                    }
                }
                return new DnsStrategy(this.dnsTransmitTask, null, 1008);
            } else if (this.msg.equals("warning")) {
                if (this.currentTime - this.cacheTime >= 60000) {
                    return new DnsStrategy(this.dnsTransmitTask, null, 1004);
                }
                return new DnsStrategy(null, null, 2);
            } else if (this.msg.equals("stop")) {
                if (this.currentTime - this.cacheTime >= 300000) {
                    return new DnsStrategy(this.dnsTransmitTask, null, 1004);
                }
                return new DnsStrategy(null, null, 2);
            } else {
                return new DnsStrategy(this.dnsTransmitTask, null, 1004);
            }
        }
    }

    public DnsStrategy(DnsTransmitTask dnsTransmitTask, DnsModel dnsModel, int i) {
        this.dnsTransmitTask = dnsTransmitTask;
        this.cacheDnsModel = dnsModel;
        this.parseSubType = i;
    }

    public DnsModel getCacheDnsModel() {
        return this.cacheDnsModel;
    }

    public DnsTransmitTask getDnsTransmitTask() {
        return this.dnsTransmitTask;
    }

    public int getParseSubType() {
        return this.parseSubType;
    }
}
