package com.baidu.searchbox.network.outback;
/* loaded from: classes2.dex */
public interface IOutbackClientIPProvider {
    String getClientIP();

    String getClientIPv6();

    void notifyChanged(String str);
}
