package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.Map;
/* loaded from: classes4.dex */
public interface IIMConfig {
    public static final int HEARBEAT_TIME = 60000;
    public static final int MODEL_SELECTED = 536870937;

    String getBduss(Context context);

    int getHeartBeatType();

    Map<String, Object> getOtherParameters(Context context, ChatMsg chatMsg);

    String getPaidCondition(String str, String str2, long j2);

    String getProductLineName();

    boolean getRootComplete();

    String getSubscribeRefApp();

    String getSubscribeSrcApp();

    String getToken(ChatObject chatObject);

    boolean isCategorySupported();

    boolean isMsgTypeSupported(int i2);

    boolean isNeedPaid();

    ChatObject parseTokenToChatObject(Context context, String str);

    void setRootComplete(boolean z);
}
