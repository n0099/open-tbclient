package com.baidu.searchbox.http.statistics;

import okhttp3.Headers;
/* loaded from: classes12.dex */
public interface NetworkStat<T> {
    void onConnect(T t, long j, String str);

    void onException(T t, Exception exc);

    void onFinish(T t, long j);

    void onFinishReadContent(T t, long j);

    void onReceiveHeader(T t, long j, Headers headers);

    void onReceiveLocalIp(T t, String str);

    void onReceiveRemoteIp(T t, String str);

    void onRedirect(T t, String str);

    void onRequestBodyLength(T t, long j);

    void onResponse(T t, long j);

    void onResponseBodyLength(T t, long j);

    void onSendHeader(T t, long j);

    void onServerErrorHeader(T t, String str);

    void onStartExecute(T t, long j);

    void onStatusCode(T t, int i);

    void setNetEngine(T t, int i);
}
