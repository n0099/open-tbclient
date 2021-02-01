package com.baidu.android.pushservice.message.a;
/* loaded from: classes5.dex */
public enum j {
    MSG_TYPE_INVALID(-1),
    MSG_TYPE_SINGLE_PRIVATE(0),
    MSG_TYPE_MULTI_PRIVATE(1),
    MSG_TYPE_SINGLE_PUBLIC(2),
    MSG_TYPE_MULTI_PUBLIC(3),
    MSG_TYPE_MULTI_PRIVATE_NOTIFICATION(5),
    MSG_TYPE_PRIVATE_MESSAGE(6),
    MSG_TYPE_CROSS_PUSH(20),
    MSG_TYPE_INNERBIND(101),
    MSG_TYPE_APPSTAT_COMMAND(104);
    
    private int k;

    j(int i) {
        this.k = i;
    }

    public static j a(int i) {
        switch (i) {
            case 0:
                return MSG_TYPE_SINGLE_PRIVATE;
            case 1:
                return MSG_TYPE_MULTI_PRIVATE;
            case 2:
                return MSG_TYPE_SINGLE_PUBLIC;
            case 3:
                return MSG_TYPE_MULTI_PUBLIC;
            case 5:
                return MSG_TYPE_MULTI_PRIVATE_NOTIFICATION;
            case 6:
                return MSG_TYPE_PRIVATE_MESSAGE;
            case 20:
                return MSG_TYPE_CROSS_PUSH;
            case 101:
                return MSG_TYPE_INNERBIND;
            case 104:
                return MSG_TYPE_APPSTAT_COMMAND;
            default:
                return MSG_TYPE_INVALID;
        }
    }

    public int b() {
        return this.k;
    }
}
