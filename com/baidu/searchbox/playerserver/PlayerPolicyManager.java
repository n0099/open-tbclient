package com.baidu.searchbox.playerserver;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes2.dex */
public class PlayerPolicyManager {
    public static final PlayerPolicyManager ourInstance = new PlayerPolicyManager();
    public IPlayerPolicy mPlayerPolicy;

    public PlayerPolicyManager() {
        this.mPlayerPolicy = null;
        this.mPlayerPolicy = new PlayerPolicyImplement();
    }

    public static PlayerPolicyManager getInstance() {
        return ourInstance;
    }

    public void stop() {
        IPlayerPolicy iPlayerPolicy = this.mPlayerPolicy;
        if (iPlayerPolicy != null) {
            iPlayerPolicy.stop();
        }
    }

    public void update() {
        IPlayerPolicy iPlayerPolicy = this.mPlayerPolicy;
        if (iPlayerPolicy != null) {
            iPlayerPolicy.start();
        }
    }

    public void notify(String str) {
        IPlayerPolicy iPlayerPolicy = this.mPlayerPolicy;
        if (iPlayerPolicy != null) {
            iPlayerPolicy.notify(str);
        }
    }

    public void register(IPlayerConfig iPlayerConfig) {
        IPlayerPolicy iPlayerPolicy = this.mPlayerPolicy;
        if (iPlayerPolicy != null) {
            iPlayerPolicy.register(iPlayerConfig);
        }
    }

    public void unregister(IPlayerConfig iPlayerConfig) {
        IPlayerPolicy iPlayerPolicy = this.mPlayerPolicy;
        if (iPlayerPolicy != null) {
            iPlayerPolicy.unregister(iPlayerConfig);
        }
    }
}
