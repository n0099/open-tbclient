package com.baidu.media.duplayer;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import com.baidu.media.duplayer.monitor.DuplayerQualityMonitorManager;
import com.baidu.media.recorder.DuAudioRecorder;
import d.b.w.a.c;
import d.b.w.b.a;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class CyberPlayerCoreImpl extends CyberPlayerCoreProvider {
    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public long caculateFolderSize() {
        if (isLoaded(1)) {
            return Utils.m();
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public CaptureManagerProvider createCaptureManager(Context context, int i, int i2, int i3, int i4, int i5) {
        return a.a(context, i, i2, i3, i4, i5);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public CyberAudioRecorder createCyberAudioRecorder() {
        return new DuAudioRecorder();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public ExtractorProvider createCyberExtractor() {
        return d.b.w.c.a.a();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public PlayerProvider createCyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        return CyberPlayerImpl.create(i, httpDNS);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public MediaInstanceManagerProvider createInstanceManager() {
        return new MediaInstanceManagerImpl();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public RTCRoomProvider createRTCRoom() {
        return a.f();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet) {
        return a.b(context, attributeSet);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void duplayerEncrypt(byte[] bArr, int i, byte[] bArr2) {
        Utils.h(bArr, i, bArr2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void enableRTCCaptureDebug(boolean z) {
        a.g(z);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void forceCleanFilecache() {
        Utils.k();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public String getCoreVersion() {
        return SDKVersion.VERSION;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public int getDevicePlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map) {
        return DuplayerQualityMonitorManager.getInstance().getPlayQualityScore(str, i, i2, i3, map);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public String[] getLibsSearchPath() {
        return c.f();
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
    public void init(Context context, String str) {
        c.b(context, str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public boolean isLoaded(int i) {
        return c.d(i);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void loadlibs(int i, Map<String, String> map) {
        c.a(i, map);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void prefetch(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4) {
        Prefetch.add(str, str2, str3, i, i2, i3, httpDNS, str4);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void setRTCVerbose(boolean z) {
        a.c(z);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void stopPrefetch(String str) {
        Prefetch.stopPrefetch(str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void updateCfg() {
        Utils.o();
    }
}
