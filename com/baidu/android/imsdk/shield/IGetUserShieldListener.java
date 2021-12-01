package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.List;
/* loaded from: classes8.dex */
public interface IGetUserShieldListener extends IMListener {
    void onResult(int i2, String str, List<ChatSession> list);
}
