package com.baidu.cyberplayer.sdk.context;

import android.os.Handler;
import android.os.Message;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public interface ICyberMsgHandler {
    void removeCallbacksAndMessages();

    boolean sendEmptyMessage(Handler handler, int i);

    boolean sendMessage(Message message);
}
