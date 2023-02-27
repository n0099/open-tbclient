package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.cyberplayer.sdk.videodownload.VideoSourceBean;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public abstract class CyberPlayerCoreProvider {

    @Keep
    /* loaded from: classes2.dex */
    public enum LibsVersionType {
        ALL_VERSION,
        SUCCESS_LOADED_VERSION
    }

    public abstract long caculateFolderSize();

    public abstract void cancelDownload(String str);

    public abstract void cleanFilecacheWithTimeExpired(long j);

    public abstract CaptureManagerProvider createCaptureManager(Context context, int i, int i2, int i3, int i4, int i5);

    public abstract CyberAudioRecorder createCyberAudioRecorder();

    public abstract ExtractorProvider createCyberExtractor();

    public abstract PlayerProvider createCyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS);

    public abstract DlnaProvider createDlna();

    public abstract MediaInstanceManagerProvider createInstanceManager();

    public abstract RTCRoomProvider createRTCRoom();

    public abstract RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet);

    public abstract void deleteDownload(String str);

    public abstract boolean downgrade();

    public abstract void duplayerEncrypt(byte[] bArr, int i, byte[] bArr2);

    public abstract void enableRTCCaptureDebug(boolean z);

    public abstract String getCoreVersion();

    public abstract int getDevicePlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map);

    public abstract String[] getLibsSearchPath();

    public abstract Map<String, String> getLibsVersion(LibsVersionType libsVersionType);

    public abstract HashMap<Integer, Long> getSystemInfraInfo();

    public abstract boolean hasCacheFile(String str);

    public abstract void init(Context context, String str);

    public abstract boolean isLoaded(int i);

    public abstract int kernelNetInit(long j);

    public abstract void loadlibs(int i, Map<String, String> map) throws FileNotFoundException, UnsatisfiedLinkError, SecurityException;

    public abstract void pauseDownload(String str);

    public abstract int pcdnNetInit(long j);

    public abstract void prefetch(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions);

    public abstract void resumeDownload(String str);

    public abstract void setDownloadListener(CyberVideoDownloader.DownloadListener downloadListener);

    public abstract void setInstallListener(CyberPlayerManager.InstallListener2 installListener2);

    public abstract void setRTCVerbose(boolean z);

    public abstract void setWorkDir(String str);

    public abstract String startDownload(String str, VideoSourceBean videoSourceBean);

    public abstract void stopPrefetch(String str);

    public abstract void updateCfg();

    public abstract void updatePlayerConfig(String str);

    public abstract void updateStorageQuota(long j);
}
