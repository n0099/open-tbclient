package com.baidu.android.pushservice.w.m;
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
    MSG_TYPE_APP_PRIORITY(30),
    MSG_TYPE_LOCAL_PUSH_MESSAGE(31),
    MSG_TYPE_INNERBIND(101),
    MSG_TYPE_APPSTAT_COMMAND(104);
    
    public int a;

    l(int i) {
        this.a = i;
    }

    public static l a(int i) {
        return i != 5 ? i != 6 ? i != 8 ? i != 101 ? i != 104 ? i != 30 ? i != 31 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? MSG_TYPE_INVALID : MSG_TYPE_MULTI_PUBLIC : MSG_TYPE_SINGLE_PUBLIC : MSG_TYPE_MULTI_PRIVATE : MSG_TYPE_SINGLE_PRIVATE : MSG_TYPE_LOCAL_PUSH_MESSAGE : MSG_TYPE_APP_PRIORITY : MSG_TYPE_APPSTAT_COMMAND : MSG_TYPE_INNERBIND : MSG_TYPE_CLEAR_MESSAGE : MSG_TYPE_PRIVATE_MESSAGE : MSG_TYPE_MULTI_PRIVATE_NOTIFICATION;
    }

    public int a() {
        return this.a;
    }
}
