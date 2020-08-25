package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.List;
/* loaded from: classes9.dex */
public interface ISyncDialogListener extends IMListener {
    void onSyncDialogResult(int i, String str, long j, List<ChatMsg> list);
}
