package com.baidu.cyberplayer.sdk;

import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerProxy;
/* loaded from: classes3.dex */
public class PlayerProviderFactory {
    public static PlayerProviderFactory sPlayerFactory;

    public static synchronized PlayerProviderFactory getInstance() {
        PlayerProviderFactory playerProviderFactory;
        synchronized (PlayerProviderFactory.class) {
            if (sPlayerFactory == null) {
                sPlayerFactory = new PlayerProviderFactory();
            }
            playerProviderFactory = sPlayerFactory;
        }
        return playerProviderFactory;
    }

    public PlayerProvider create(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        PlayerProvider playerProvider;
        if (z && !CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_REMOTE_FORBIDDEN, false)) {
            playerProvider = RemotePlayerProxy.create(i, httpDNS);
        } else {
            playerProvider = null;
        }
        if (playerProvider == null) {
            playerProvider = CyberPlayerCoreInvoker.createCyberPlayer(i, httpDNS);
        }
        if (playerProvider == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MEDIAPLAYER_SUB_THREAD, true)) {
                playerProvider = MediaPlayerAsync.create();
            } else {
                playerProvider = new MediaPlayerImpl();
            }
        }
        if (playerProvider == null && Utils.isMainProcess() && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return new MediaPlayerImpl();
        }
        return playerProvider;
    }
}
