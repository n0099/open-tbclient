package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
/* loaded from: classes2.dex */
public interface ISailorUrlPushService extends INoProGuard {
    boolean getSwitchByKey(String str);

    String getUrl(String str);

    boolean isNeedUpdate(String str);

    void updateFingerprint(String str, String str2);
}
