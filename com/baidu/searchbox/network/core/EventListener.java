package com.baidu.searchbox.network.core;

import android.support.annotation.Nullable;
import com.baidu.searchbox.network.core.connect.Connection;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
/* loaded from: classes13.dex */
public abstract class EventListener {
    public static final EventListener NONE = new EventListener() { // from class: com.baidu.searchbox.network.core.EventListener.1
    };

    /* loaded from: classes13.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public static Factory factory(EventListener eventListener) {
        return new Factory() { // from class: com.baidu.searchbox.network.core.EventListener.2
            @Override // com.baidu.searchbox.network.core.EventListener.Factory
            public EventListener create(Call call) {
                return EventListener.this;
            }
        };
    }

    public void callStart(Call call) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void secureConnectStart(Call call) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void requestHeadersEnd(Call call, Request request) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestBodyEnd(Call call, long j) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void responseHeadersEnd(Call call, Response response) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseBodyEnd(Call call, long j) {
    }

    public void callEnd(Call call) {
    }

    public void callFailed(Call call, IOException iOException) {
    }
}
