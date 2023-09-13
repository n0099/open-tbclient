package com.baidu.cyberplayer.sdk;

import com.baidu.searchbox.playerserver.IPlayerConfig;
@Keep
/* loaded from: classes3.dex */
public class CyberPlayerConfig implements IPlayerConfig {
    public static final String TAG = "PlayerServer-CyberPlayerConfig";

    @Override // com.baidu.searchbox.playerserver.IPlayerConfig
    public void update(String str) {
        PlayerConfigManager.getInstance().updatePlayerConfig(str);
    }
}
