package com.baidu.searchbox.playerserver;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public class PlayerPolicyManager {
    public static final String REQ_SOURCE_OPEN_VIDEO = "req_source_open_video";
    public static final String REQ_SOURCE_PREFETCH = "req_source_prefetch";
    public static final PlayerPolicyManager ourInstance = new PlayerPolicyManager();
    public static String sRequestSource = "unknown";
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

    public void updateManually(int i) {
        IPlayerPolicy iPlayerPolicy = this.mPlayerPolicy;
        if (iPlayerPolicy != null) {
            iPlayerPolicy.sendRequestManually(i);
        }
    }
}
