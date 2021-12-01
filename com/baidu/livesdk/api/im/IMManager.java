package com.baidu.livesdk.api.im;

import android.content.Context;
/* loaded from: classes8.dex */
public interface IMManager {
    IMConversation build(Context context, String str, String str2, boolean z);

    void fetchMsgByMsgId(Context context, int i2, long j2, long j3, long j4, int i3, int i4, FetchMsgByIdListener fetchMsgByIdListener);

    void fetchMsgRequest(Context context, long j2, long j3, int i2, long j4, long j5, long j6, int i3, int i4, FetchMsgByIdListener fetchMsgByIdListener);

    void login(String str, String str2, int i2, String str3, String str4, LoginListener loginListener);

    void logout(LogoutListener logoutListener);

    void produceLine(IMConnectParams iMConnectParams);

    void registerConnectListener(ConnectListener connectListener);

    void tryConnection();

    void unregisterConnectListener();
}
