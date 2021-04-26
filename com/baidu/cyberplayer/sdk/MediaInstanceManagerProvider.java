package com.baidu.cyberplayer.sdk;

import android.os.Bundle;
@Keep
/* loaded from: classes2.dex */
public abstract class MediaInstanceManagerProvider {

    @Keep
    /* loaded from: classes2.dex */
    public interface OnClientInstanceHandler {
        boolean onDestroyInstance();

        boolean onResumeInstance();
    }

    public abstract void activeInstance(int i2);

    public abstract String getInstanceOptionByKey(int i2, String str);

    public abstract Bundle getInstanceStatusByType(int i2, int i3);

    public abstract int registerInstance(OnClientInstanceHandler onClientInstanceHandler);

    public abstract void unRegisterInstance(int i2);

    public abstract void updateInstanceTimestamp(int i2, long j);

    public abstract void updateStringOption(int i2, String str, String str2);
}
