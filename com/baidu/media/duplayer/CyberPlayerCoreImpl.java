package com.baidu.media.duplayer;

import android.content.Context;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.media.recorder.DuAudioRecorder;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public class CyberPlayerCoreImpl extends CyberPlayerCoreProvider {
    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public long caculateFolderSize() {
        if (isLoaded(1)) {
            return Utils.d();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public CyberAudioRecorder createCyberAudioRecorder() {
        return new DuAudioRecorder();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public PlayerProvider createCyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        return CyberPlayerImpl.create(i, httpDNS);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void duplayerEncrypt(byte[] bArr, int i, byte[] bArr2) {
        Utils.a(bArr, i, bArr2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void forceCleanFilecache() {
        Utils.c();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public String getCoreVersion() {
        return SDKVersion.VERSION;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public String getInitError() {
        return a.b();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public HashMap<Integer, Long> getSystemInfraInfo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        SystemInfraInfo systemInfraInfo = new SystemInfraInfo();
        systemInfraInfo.a();
        hashMap.put(0, Long.valueOf(systemInfraInfo.c()));
        hashMap.put(1, Long.valueOf(systemInfraInfo.d()));
        hashMap.put(6, Long.valueOf(systemInfraInfo.e()));
        hashMap.put(7, Long.valueOf(systemInfraInfo.f()));
        hashMap.put(8, Long.valueOf(systemInfraInfo.g()));
        systemInfraInfo.b();
        hashMap.put(9, Long.valueOf(systemInfraInfo.h()));
        return hashMap;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public boolean hasCacheFile(String str) {
        return Prefetch.hasCacheFile(str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void init(Context context, int i, Map<String, String> map) {
        a.a(context, i, map);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public boolean isLoaded(int i) {
        return a.a(i);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void prefetch(String str, String str2, String str3, int i, int i2, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        Prefetch.add(str, str2, str3, i, i2, httpDNS, str4);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void stopPrefetch(String str) {
        Prefetch.stopPrefetch(str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void updateCfg() {
        Utils.f();
    }
}
