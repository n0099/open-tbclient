package com.baidu.searchbox.dns.transmit.task;
/* loaded from: classes3.dex */
public class TaskDispatcherFactory {
    public static final int PRIORITY_DISPATCHER = 1;
    public static final int SIMPLE_DISPATCHER = 0;

    public static Dispatcher createDispatcher(int i) {
        if (i != 0) {
            if (i != 1) {
                return new SimpleDispatcher();
            }
            return new PriorityDispatcher();
        }
        return new SimpleDispatcher();
    }
}
