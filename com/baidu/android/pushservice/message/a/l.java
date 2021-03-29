package com.baidu.android.pushservice.message.a;
/* loaded from: classes.dex */
public enum l {
    MSG_TYPE_INVALID(-1),
    MSG_TYPE_SINGLE_PRIVATE(0),
    MSG_TYPE_MULTI_PRIVATE(1),
    MSG_TYPE_SINGLE_PUBLIC(2),
    MSG_TYPE_MULTI_PUBLIC(3),
    MSG_TYPE_MULTI_PRIVATE_NOTIFICATION(5),
    MSG_TYPE_PRIVATE_MESSAGE(6),
    MSG_TYPE_CLEAR_MESSAGE(8),
    MSG_TYPE_CROSS_PUSH(20),
    MSG_TYPE_APP_PRIORITY(30),
    MSG_TYPE_INNERBIND(101),
    MSG_TYPE_APPSTAT_COMMAND(104);
    
    public int m;

    l(int i) {
        this.m = i;
    }

    public static l a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? i != 8 ? i != 20 ? i != 30 ? i != 101 ? i != 104 ? MSG_TYPE_INVALID : MSG_TYPE_APPSTAT_COMMAND : MSG_TYPE_INNERBIND : MSG_TYPE_APP_PRIORITY : MSG_TYPE_CROSS_PUSH : MSG_TYPE_CLEAR_MESSAGE : MSG_TYPE_PRIVATE_MESSAGE : MSG_TYPE_MULTI_PRIVATE_NOTIFICATION : MSG_TYPE_MULTI_PUBLIC : MSG_TYPE_SINGLE_PUBLIC : MSG_TYPE_MULTI_PRIVATE : MSG_TYPE_SINGLE_PRIVATE;
    }

    public int b() {
        return this.m;
    }
}
