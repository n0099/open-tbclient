package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
public abstract class CyberPlayerCoreProvider {
    public abstract long caculateFolderSize();

    public abstract CaptureManagerProvider createCaptureManager(Context context, int i, int i2, int i3, int i4, int i5);

    public abstract CyberAudioRecorder createCyberAudioRecorder();

    public abstract ExtractorProvider createCyberExtractor();

    public abstract PlayerProvider createCyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS);

    public abstract MediaInstanceManagerProvider createInstanceManager();

    public abstract RTCRoomProvider createRTCRoom();

    public abstract RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet);

    public abstract void duplayerEncrypt(byte[] bArr, int i, byte[] bArr2);

    public abstract void enableRTCCaptureDebug(boolean z);

    public abstract void forceCleanFilecache();

    public abstract String getCoreVersion();

    public abstract int getDevicePlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map);

    public abstract String[] getLibsSearchPath();

    public abstract HashMap<Integer, Long> getSystemInfraInfo();

    public abstract boolean hasCacheFile(String str);

    public abstract void init(Context context, String str);

    public abstract boolean isLoaded(int i);

    public abstract void loadlibs(int i, Map<String, String> map) throws FileNotFoundException, UnsatisfiedLinkError, SecurityException;

    public abstract void prefetch(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4);

    public abstract void setRTCVerbose(boolean z);

    public abstract void stopPrefetch(String str);

    public abstract void updateCfg();
}
