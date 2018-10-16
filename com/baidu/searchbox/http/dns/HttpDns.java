package com.baidu.searchbox.http.dns;

import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.DnsParseResult;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes2.dex */
public class HttpDns implements Dns {
    private DnsHelper mDnsHelper;
    private HttpDnsListener mDnsListener;
    private DnsParseResult mDnsParseResult;
    private boolean mIsEnable;
    private boolean mIsStatEnable;
    private long mDnsStartTime = -1;
    private long mDnsEndTime = -1;

    /* loaded from: classes2.dex */
    public interface HttpDnsListener {
        void onDnsParse(long j, long j2, DnsParseResult dnsParseResult);
    }

    public HttpDns(DnsHelper dnsHelper, boolean z) {
        this.mIsStatEnable = z;
        this.mDnsHelper = dnsHelper;
        this.mIsEnable = this.mDnsHelper != null && this.mDnsHelper.isHttpDnsEnable();
    }

    public void setHttpDnsEnable(boolean z) {
        this.mIsEnable = z;
        if (this.mDnsHelper != null) {
            this.mDnsHelper.setHttpDnsEnable(this.mIsEnable);
        }
    }

    public long getDnsStartTime() {
        return this.mDnsStartTime;
    }

    public long getDnsEndTime() {
        return this.mDnsEndTime;
    }

    public DnsParseResult getDnsParseResult() {
        return this.mDnsParseResult;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        boolean z = this.mIsStatEnable;
        if (z) {
            this.mDnsStartTime = System.currentTimeMillis();
        }
        List<InetAddress> arrayList = new ArrayList<>();
        try {
            if (this.mIsEnable && this.mDnsHelper != null) {
                DnsParseResult parseResult = this.mDnsHelper.getParseResult(str);
                if (parseResult != null) {
                    arrayList = DnsUtil.parseInetAddressList(parseResult.getIpList());
                }
                if (z) {
                    this.mDnsEndTime = System.currentTimeMillis();
                    this.mDnsParseResult = parseResult;
                    if (this.mDnsListener != null) {
                        this.mDnsListener.onDnsParse(this.mDnsStartTime, this.mDnsEndTime, this.mDnsParseResult);
                    }
                }
            } else {
                arrayList = Arrays.asList(InetAddress.getAllByName(str));
                if (z) {
                    this.mDnsEndTime = System.currentTimeMillis();
                    this.mDnsParseResult = new DnsParseResult(DnsUtil.parseRawAddressList(arrayList), 0, 1);
                    if (this.mDnsListener != null) {
                        this.mDnsListener.onDnsParse(this.mDnsStartTime, this.mDnsEndTime, this.mDnsParseResult);
                    }
                }
            }
            return arrayList;
        } catch (NullPointerException e) {
            if (e.getMessage() != null && e.getMessage().contains("Attempt to get length of null array")) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
            throw e;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof HttpDns) {
            return true;
        }
        return super.equals(obj);
    }

    public void setDnsListener(HttpDnsListener httpDnsListener) {
        this.mDnsListener = httpDnsListener;
    }
}
