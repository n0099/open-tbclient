package com.baidu.cyberplayer.sdk.context;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public interface ICyberMediaContext {
    ICyberMediaAbTest getAbTestInterface();

    ICyberGlobalOptions getCyberGlobalOptions();

    ICyberMsgHandler getCyberMsgHandler();

    ICyberPlayConfig getCyberPlayConfig();
}
