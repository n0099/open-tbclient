package com.baidu.live.alablmsdk.module;
/* loaded from: classes4.dex */
public enum UserPermission {
    UNKNOWN(0),
    OWNER(1),
    VISITER(2);
    
    int permission;

    UserPermission(int i) {
        this.permission = i;
    }

    public int getPermission() {
        return this.permission;
    }
}
