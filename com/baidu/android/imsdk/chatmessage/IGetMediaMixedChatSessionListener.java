package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes.dex */
public interface IGetMediaMixedChatSessionListener extends IMListener {
    void onMediaGetChatSessionResult(int i, int i2, int i3, int i4, boolean z, List<ChatSession> list);
}
