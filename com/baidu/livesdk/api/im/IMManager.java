package com.baidu.livesdk.api.im;

import android.content.Context;
/* loaded from: classes3.dex */
public interface IMManager {
    IMConversation build(Context context, String str, String str2, boolean z);

    void fetchMsgByMsgId(Context context, int i, long j, long j2, long j3, int i2, int i3, FetchMsgByIdListener fetchMsgByIdListener);

    void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, FetchMsgByIdListener fetchMsgByIdListener);

    void login(String str, String str2, int i, String str3, String str4, LoginListener loginListener);

    void logout(LogoutListener logoutListener);

    void produceLine(IMConnectParams iMConnectParams);

    void registerConnectListener(ConnectListener connectListener);

    void tryConnection();

    void unregisterConnectListener();
}
