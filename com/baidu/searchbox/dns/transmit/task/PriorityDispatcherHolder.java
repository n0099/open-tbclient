package com.baidu.searchbox.dns.transmit.task;
/* loaded from: classes2.dex */
public class PriorityDispatcherHolder {

    /* loaded from: classes2.dex */
    public static class Holder {
        public static final Dispatcher INSTANCE = new PriorityDispatcher();
    }

    public static Dispatcher getDispatcher() {
        return Holder.INSTANCE;
    }
}
