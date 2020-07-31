package com.baidu.live.tbadk.account;
/* loaded from: classes4.dex */
public class AccountHelper {
    private static OnSyncAccountCallback onSyncAccountCallback;

    public static OnSyncAccountCallback getOnSyncAccountCallback() {
        return onSyncAccountCallback;
    }

    public static void setOnSyncAccountCallback(OnSyncAccountCallback onSyncAccountCallback2) {
        onSyncAccountCallback = onSyncAccountCallback2;
    }
}
