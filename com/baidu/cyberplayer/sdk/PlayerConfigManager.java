package com.baidu.cyberplayer.sdk;

import android.net.Uri;
import com.baidu.cyberplayer.sdk.ab.CyberAbTestManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.searchbox.playerserver.PlayerPolicyCfgManager;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
@Keep
/* loaded from: classes3.dex */
public class PlayerConfigManager {
    public static final PlayerConfigManager ourInstance = new PlayerConfigManager();

    @Keep
    /* loaded from: classes3.dex */
    public static class AdjustInfo {
        public int adjustSize;
        public String adjustUrl;

        public AdjustInfo(String str, int i) {
            this.adjustSize = i;
            this.adjustUrl = str;
        }
    }

    public static PlayerConfigManager getInstance() {
        return ourInstance;
    }

    public String getPlayConfigMerged() {
        return PlayerPolicyCfgManager.getInstance().getPlayConfigMerged();
    }

    public static void setRequestSource(String str) {
        PlayerPolicyManager.sRequestSource = str;
    }

    public void updatePlayerConfig(String str) {
        CyberPlayerCoreInvoker.updatePlayerConfig(str);
    }

    public static void startRequestPlayerServerCfg() {
        if (!Utils.isMainProcess() || !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, true)) {
            return;
        }
        if (CyberAbTestManager.getAbSwitchInt("request_ps_after_cyber_loaded", 1) == 1 && !CyberPlayerCoreInvoker.isLoaded(1)) {
            return;
        }
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_AUTO_REQ_PS, false)) {
            PlayerPolicyManager.getInstance().update();
            return;
        }
        PlayerPolicyManager.getInstance().updateManually(CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_FST_STAGE_REQ_INTERVAL, 20));
    }

    public Uri rebuildUrlForPlay(Uri uri, String str, int i, int i2) {
        return PlayerPolicyCfgManager.getInstance().rebuildUrlForPlay(uri, str, i, i2);
    }

    public AdjustInfo rebuildUrlForPrefetch(String str, String str2, int i, int i2) {
        PlayerPolicyCfgManager.AdjustInfo rebuildUrlForPrefetch = PlayerPolicyCfgManager.getInstance().rebuildUrlForPrefetch(str, str2, i, i2);
        if (rebuildUrlForPrefetch == null) {
            return null;
        }
        return new AdjustInfo(rebuildUrlForPrefetch.adjustUrl, rebuildUrlForPrefetch.adjustSize);
    }

    public Uri rebuildUrlForPlay(String str, String str2, int i, int i2) {
        return PlayerPolicyCfgManager.getInstance().rebuildUrlForPlay(str, str2, i, i2);
    }
}
