package com.baidu.searchbox.ng.ai.apps.system.memory;
/* loaded from: classes2.dex */
public class TrimMemoryDispatcher {
    private TrimMemoryConsumer consumer;

    public void setConsumer(TrimMemoryConsumer trimMemoryConsumer) {
        this.consumer = trimMemoryConsumer;
    }

    public void notifyTrimMemory(int i) {
        if (this.consumer != null) {
            this.consumer.consume(i);
        }
    }
}
