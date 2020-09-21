package com.baidu.searchbox.network.core;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.network.HttpManager;
import com.baidu.searchbox.network.HttpRuntime;
import com.baidu.searchbox.network.core.Call;
import com.baidu.searchbox.network.core.EventListener;
import com.baidu.searchbox.network.core.connect.HttpURLConnectionDelegator;
import com.baidu.searchbox.network.core.connect.IHttpDelegator;
import com.baidu.searchbox.network.core.internal.Util;
import com.baidu.searchbox.network.core.internal.proxy.NullProxySelector;
import com.baidu.searchbox.network.core.tls.HttpHostnameVerifier;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes14.dex */
public class RequestClient implements Call.Factory, Cloneable {
    public static final int BAD_NETWORK_QUALITY = 2;
    public static final int GOOD_NETWORK_QUALITY = 1;
    public static final int OFFLINE_NETWORK_QUALITY = 3;
    public static final int UNKNOWN_NETWORK_QUALITY = -1;
    final int connectTimeout;
    final Context context;
    final CookieJar cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final EventListener.Factory eventListenerFactory;
    boolean hasSetHttpDelegator;
    final HostnameVerifier hostnameVerifier;
    IHttpDelegator httpDelegator;
    final List<Interceptor> interceptors;
    final List<Interceptor> networkInterceptors;
    final List<Protocol> protocols;
    @Nullable
    final Proxy proxy;
    final ProxySelector proxySelector;
    final int readTimeout;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;
    static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static int sNetworkQuality = -1;
    public static final List<HttpManager.NetworkQualityListener> sNetworkQualityListeners = new ArrayList(2);

    public boolean isHasSetHttpDelegator() {
        return this.hasSetHttpDelegator;
    }

    public void setHttpDelegator(IHttpDelegator iHttpDelegator) {
        if (iHttpDelegator != null) {
            this.httpDelegator = iHttpDelegator;
            this.hasSetHttpDelegator = true;
            this.httpDelegator.setRequestClient(this);
        }
    }

    public Dns getHttpDns() {
        return this.dns;
    }

    public RequestClient() {
        this(new Builder());
    }

    RequestClient(Builder builder) {
        this.hasSetHttpDelegator = false;
        this.context = builder.context;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.dns = builder.dns;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        if (this.interceptors.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        }
        if (this.networkInterceptors.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
        this.httpDelegator = builder.httpDelegator;
    }

    public Context context() {
        return this.context;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public boolean isPreconnectEnable() {
        if (HttpRuntime.getHttpContext() != null) {
            return HttpRuntime.getHttpContext().isPreconnectEnable();
        }
        return false;
    }

    public boolean isNQEEnable() {
        if (HttpRuntime.getHttpContext() != null) {
            return HttpRuntime.getHttpContext().isNQEEnable();
        }
        return false;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public Dns dns() {
        return this.dns;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public IHttpDelegator httpDelegator() {
        return this.httpDelegator;
    }

    @Override // com.baidu.searchbox.network.core.Call.Factory
    public Call newCall(Request request) {
        return RealCall.newRealCall(this, request, false);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    /* loaded from: classes14.dex */
    public static final class Builder {
        int connectTimeout;
        Context context;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        EventListener.Factory eventListenerFactory;
        HostnameVerifier hostnameVerifier;
        IHttpDelegator httpDelegator;
        final List<Interceptor> interceptors;
        final List<Interceptor> networkInterceptors;
        List<Protocol> protocols;
        @Nullable
        Proxy proxy;
        ProxySelector proxySelector;
        int readTimeout;
        SocketFactory socketFactory;
        @Nullable
        SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = RequestClient.DEFAULT_PROTOCOLS;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            this.proxySelector = ProxySelector.getDefault();
            if (this.proxySelector == null) {
                this.proxySelector = new NullProxySelector();
            }
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = HttpHostnameVerifier.INSTANCE;
            this.dns = Dns.SYSTEM;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.httpDelegator = new HttpURLConnectionDelegator();
        }

        Builder(RequestClient requestClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = requestClient.dispatcher;
            this.proxy = requestClient.proxy;
            this.protocols = requestClient.protocols;
            this.interceptors.addAll(requestClient.interceptors);
            this.networkInterceptors.addAll(requestClient.networkInterceptors);
            this.eventListenerFactory = requestClient.eventListenerFactory;
            this.proxySelector = requestClient.proxySelector;
            this.cookieJar = requestClient.cookieJar;
            this.dns = requestClient.dns;
            this.connectTimeout = requestClient.connectTimeout;
            this.readTimeout = requestClient.readTimeout;
            this.writeTimeout = requestClient.writeTimeout;
            this.httpDelegator = requestClient.httpDelegator;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder proxy(@Nullable Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new NullPointerException("proxySelector == null");
            }
            this.proxySelector = proxySelector;
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.cookieJar = cookieJar;
            return this;
        }

        public Builder dns(Dns dns) {
            if (dns == null) {
                throw new NullPointerException("dns == null");
            }
            this.dns = dns;
            return this;
        }

        public Builder context(Context context) {
            if (this.dns == null) {
                throw new NullPointerException("context == null");
            }
            this.context = context;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(Protocol.SPDY_3);
            this.protocols = Collections.unmodifiableList(arrayList);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.interceptors.add(interceptor);
            return this;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.eventListenerFactory = EventListener.factory(eventListener);
            return this;
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory == null) {
                throw new NullPointerException("eventListenerFactory == null");
            }
            this.eventListenerFactory = factory;
            return this;
        }

        public Builder httpDelegator(IHttpDelegator iHttpDelegator) {
            if (this.eventListenerFactory == null) {
                throw new NullPointerException("httpDelegator == null");
            }
            this.httpDelegator = iHttpDelegator;
            return this;
        }

        public RequestClient build() {
            return new RequestClient(this);
        }
    }
}
