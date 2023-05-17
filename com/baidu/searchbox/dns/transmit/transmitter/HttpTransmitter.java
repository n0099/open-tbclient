package com.baidu.searchbox.dns.transmit.transmitter;
/* loaded from: classes3.dex */
public interface HttpTransmitter<T> {
    void cancel();

    T sendRequest();
}
