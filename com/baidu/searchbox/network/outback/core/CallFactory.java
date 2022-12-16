package com.baidu.searchbox.network.outback.core;
/* loaded from: classes3.dex */
public interface CallFactory {

    /* loaded from: classes3.dex */
    public interface CallFactoryProducer {
        String getEngineName();

        boolean isAvailable();

        CallFactory produceCallFactory(CallFactoryParams callFactoryParams);
    }

    Call newCall(Request request, boolean z);
}
