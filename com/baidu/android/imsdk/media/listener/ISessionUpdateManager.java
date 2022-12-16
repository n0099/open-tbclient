package com.baidu.android.imsdk.media.listener;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.List;
/* loaded from: classes.dex */
public interface ISessionUpdateManager extends IMListener {
    List<ChatSession> filterMediaSessionUpdate(int i, int i2, List<ChatSession> list);

    List<ChatSession> filterNotifyAggVirtualSession(int i, int i2, List<ChatSession> list);

    List<ChatSession> filterNotifyStrangerFolder(int i, int i2, List<ChatSession> list);

    List<ChatSession> filterSendToMediaSession(int i, int i2, List<ChatSession> list);

    List<ChatSession> filterUserSessionUpdate(int i, int i2, List<ChatSession> list);
}
