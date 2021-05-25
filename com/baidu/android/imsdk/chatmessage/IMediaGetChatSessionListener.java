package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes.dex */
public interface IMediaGetChatSessionListener extends IMListener {
    void onMediaGetChatSessionResult(int i2, int i3, int i4, boolean z, List<ChatSession> list);
}
