package com.baidu.cyberplayer.sdk;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public abstract class CyberPlayerCoreProvider {
    public abstract long caculateFolderSize();

    public abstract CyberAudioRecorder createCyberAudioRecorder();

    public abstract PlayerProvider createCyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS);

    public abstract void duplayerEncrypt(byte[] bArr, int i, byte[] bArr2);

    public abstract void forceCleanFilecache();

    public abstract String getCoreVersion();

    public abstract String getInitError();

    public abstract HashMap<Integer, Long> getSystemInfraInfo();

    public abstract boolean hasCacheFile(String str);

    public abstract void init(Context context, int i, Map<String, String> map) throws FileNotFoundException;

    public abstract boolean isLoaded(int i);

    public abstract void prefetch(String str, String str2, String str3, int i, int i2, CyberPlayerManager.HttpDNS httpDNS, String str4);

    public abstract void stopPrefetch(String str);

    public abstract void updateCfg();
}
