package com.baidu.searchbox.dns.transmit.transmitter;
/* loaded from: classes2.dex */
public interface HttpTransmitter<T> {
    void cancel();

    T sendRequest();
}
