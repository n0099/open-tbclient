package com.baidu.swan.apps.api.pending.queue.operation;
/* loaded from: classes2.dex */
public abstract class BasePendingOperation implements Runnable {

    /* loaded from: classes2.dex */
    public enum OperationType {
        OPERATION_TYPE_REQUEST("Type_Request"),
        OPERATION_TYPE_WORK_THREAD("Type_Work_Thread"),
        OPERATION_TYPE_MAIN_THREAD("Type_Main_Thread");
        
        public String name;

        OperationType(String str) {
            this.name = str;
        }
    }

    public boolean a() {
        return false;
    }

    public String b() {
        return "";
    }

    public String c() {
        return "";
    }

    public OperationType d() {
        return OperationType.OPERATION_TYPE_WORK_THREAD;
    }
}
