package com.baidu.searchbox.http;
/* loaded from: classes2.dex */
public interface IClientIPProvider {
    String getClientIP();

    String getClientIPv6();

    void notifyChanged(String str);
}
