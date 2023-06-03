package com.baidu.searchbox.network.outback.core;

import com.baidu.searchbox.network.outback.cookie.CookieManager;
import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class CallFactoryParams {
    public CookieManager cookieManager;
    public int mConnectTimeoutMs;
    public long mConnectionPoolKeepAliveDurationNs;
    public int mConnectionPoolMaxIdleConnections;
    public TimeUnit mConnectionPoolTimeUnit;
    public ProxySelector mProxySelector;
    public int mReadTimeoutMs;
    public int mWriteTimeoutMs;

    /* loaded from: classes4.dex */
    public static class Builder {
        public CookieManager cookieManager;
        public ProxySelector mProxySelector;
        public int mConnectTimeoutMs = 30000;
        public int mReadTimeoutMs = 30000;
        public int mWriteTimeoutMs = 30000;
        public int mConnectionPoolMaxIdleConnections = -1;
        public long mConnectionPoolKeepAliveDurationNs = -1;
        public TimeUnit mConnectionPoolTimeUnit = TimeUnit.MINUTES;

        public CallFactoryParams build() {
            return new CallFactoryParams(this);
        }

        public Builder setConnectTimeoutMs(int i) {
            this.mConnectTimeoutMs = i;
            return this;
        }

        public Builder setCookieManager(CookieManager cookieManager) {
            this.cookieManager = cookieManager;
            return this;
        }

        public Builder setProxySelector(ProxySelector proxySelector) {
            this.mProxySelector = proxySelector;
            return this;
        }

        public Builder setReadTimeoutMs(int i) {
            this.mReadTimeoutMs = i;
            return this;
        }

        public Builder setWriteTimeoutMs(int i) {
            this.mWriteTimeoutMs = i;
            return this;
        }

        public Builder setOkHttpConnectionPool(int i, long j, TimeUnit timeUnit) {
            this.mConnectionPoolMaxIdleConnections = i;
            this.mConnectionPoolKeepAliveDurationNs = j;
            this.mConnectionPoolTimeUnit = timeUnit;
            return this;
        }
    }

    public CallFactoryParams(Builder builder) {
        this.mConnectTimeoutMs = 30000;
        this.mReadTimeoutMs = 30000;
        this.mWriteTimeoutMs = 30000;
        this.mConnectionPoolMaxIdleConnections = -1;
        this.mConnectionPoolKeepAliveDurationNs = -1L;
        this.mConnectionPoolTimeUnit = TimeUnit.MINUTES;
        this.mConnectTimeoutMs = builder.mConnectTimeoutMs;
        this.mReadTimeoutMs = builder.mReadTimeoutMs;
        this.mWriteTimeoutMs = builder.mWriteTimeoutMs;
        this.mConnectionPoolMaxIdleConnections = builder.mConnectionPoolMaxIdleConnections;
        this.mConnectionPoolKeepAliveDurationNs = builder.mConnectionPoolKeepAliveDurationNs;
        this.mConnectionPoolTimeUnit = builder.mConnectionPoolTimeUnit;
        this.mProxySelector = builder.mProxySelector;
        this.cookieManager = builder.cookieManager;
    }

    public int getConnectTimeoutMs() {
        return this.mConnectTimeoutMs;
    }

    public long getConnectionPoolKeepAliveDurationNs() {
        return this.mConnectionPoolKeepAliveDurationNs;
    }

    public int getConnectionPoolMaxIdleConnections() {
        return this.mConnectionPoolMaxIdleConnections;
    }

    public TimeUnit getConnectionPoolTimeUnit() {
        return this.mConnectionPoolTimeUnit;
    }

    public CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public ProxySelector getProxySelector() {
        return this.mProxySelector;
    }

    public int getReadTimeoutMs() {
        return this.mReadTimeoutMs;
    }

    public int getWriteTimeoutMs() {
        return this.mWriteTimeoutMs;
    }
}
