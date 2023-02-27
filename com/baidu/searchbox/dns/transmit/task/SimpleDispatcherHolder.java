package com.baidu.searchbox.dns.transmit.task;
/* loaded from: classes2.dex */
public class SimpleDispatcherHolder {

    /* loaded from: classes2.dex */
    public static class Holder {
        public static final Dispatcher instance = new SimpleDispatcher();
    }

    public static Dispatcher getDispatcher() {
        return Holder.instance;
    }
}
