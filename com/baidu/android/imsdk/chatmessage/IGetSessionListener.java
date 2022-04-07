package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import java.util.List;
/* loaded from: classes.dex */
public interface IGetSessionListener extends IMListener {
    void onGetSessionResult(List<ChatSession> list);
}
