package com.baidu.searchbox.http.statistics;

import okhttp3.Headers;
/* loaded from: classes11.dex */
public interface NetworkStat<T> {
    void onConnect(T t, long j2, String str);

    void onException(T t, Exception exc);

    void onFinish(T t, long j2);

    void onFinishReadContent(T t, long j2);

    void onReceiveHeader(T t, long j2, Headers headers);

    void onReceiveLocalIp(T t, String str);

    void onReceiveRemoteIp(T t, String str);

    void onRedirect(T t, String str);

    void onRequestBodyLength(T t, long j2);

    void onResponse(T t, long j2);

    void onResponseBodyLength(T t, long j2);

    void onSendHeader(T t, long j2);

    void onServerErrorHeader(T t, String str);

    void onStartExecute(T t, long j2);

    void onStatusCode(T t, int i2);

    void setNetEngine(T t, int i2);
}
