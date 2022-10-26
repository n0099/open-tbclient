package com.baidu.searchbox.http.statistics;

import okhttp3.Headers;
/* loaded from: classes2.dex */
public interface NetworkStat {
    void onConnect(Object obj, long j, String str);

    void onException(Object obj, Exception exc);

    void onFinish(Object obj, long j);

    void onFinishReadContent(Object obj, long j);

    void onReceiveHeader(Object obj, long j, Headers headers);

    void onReceiveLocalIp(Object obj, String str);

    void onReceiveRemoteIp(Object obj, String str);

    void onRedirect(Object obj, String str);

    void onRequestBodyLength(Object obj, long j);

    void onResponse(Object obj, long j);

    void onResponseBodyLength(Object obj, long j);

    void onSendHeader(Object obj, long j);

    void onServerErrorHeader(Object obj, String str);

    void onStartExecute(Object obj, long j);

    void onStatusCode(Object obj, int i);

    void setNetEngine(Object obj, int i);
}
