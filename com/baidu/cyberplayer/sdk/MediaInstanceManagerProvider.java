package com.baidu.cyberplayer.sdk;

import android.os.Bundle;
@Keep
/* loaded from: classes4.dex */
public abstract class MediaInstanceManagerProvider {

    @Keep
    /* loaded from: classes4.dex */
    public interface OnClientInstanceHandler {
        boolean onDestroyInstance();

        boolean onResumeInstance();
    }

    public abstract void activeInstance(int i);

    public abstract String getInstanceOptionByKey(int i, String str);

    public abstract Bundle getInstanceStatusByType(int i, int i2);

    public abstract int registerInstance(OnClientInstanceHandler onClientInstanceHandler);

    public abstract void unRegisterInstance(int i);

    public abstract void updateInstanceTimestamp(int i, long j);

    public abstract void updateStringOption(int i, String str, String str2);
}
