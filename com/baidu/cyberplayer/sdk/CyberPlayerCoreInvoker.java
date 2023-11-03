package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.loader.CyberClassLoader;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import com.baidu.cyberplayer.sdk.statistics.YalogWrap;
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.cyberplayer.sdk.videodownload.DownloaderProvider;
import com.baidu.cyberplayer.sdk.videodownload.VideoSourceBean;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class CyberPlayerCoreInvoker {
    public static final String TAG = "CyberPlayerCoreInvoker";
    public static volatile boolean mSetCorNetHandle;
    public static volatile boolean mSetPcdnHandle;
    public static CyberPlayerCoreProvider sCoreProvider;
    public static Class<?> sCyberVRRenderProviderImplClass;
    public static CyberPlayerManager.OnPrefetchListener sPrefetchListener;
    public static String PACKAGE_PATH_NAME_MEDIA_DUPLAYER = "com.baidu.media.duplayer";
    public static final String CLASS_NAME_CYVER_VR_RENDER_PROVIDER_IMPL = PACKAGE_PATH_NAME_MEDIA_DUPLAYER + ".CyberVRRenderProviderImpl";
    public static final String CLASS_NAME_MEDIA_INSTANCE_MANAGER_IMPL = PACKAGE_PATH_NAME_MEDIA_DUPLAYER + ".MediaInstanceManagerImpl";
    public static final String CLASS_NAME_CYBER_PLAYER_CORE_IMPL = PACKAGE_PATH_NAME_MEDIA_DUPLAYER + ".CyberPlayerCoreImpl";

    public static long caculateFolderSize() {
        if (isLoaded(1)) {
            return sCoreProvider.caculateFolderSize();
        }
        return 0L;
    }

    public static CyberAudioRecorder createCyberAudioRecorder() {
        if (isLoaded(5)) {
            return sCoreProvider.createCyberAudioRecorder();
        }
        return null;
    }

    public static ExtractorProvider createCyberExtractor() {
        if (isLoaded(1)) {
            return sCoreProvider.createCyberExtractor();
        }
        return null;
    }

    public static DlnaProvider createDLNA() {
        if (isLoaded(1)) {
            return sCoreProvider.createDlna();
        }
        return null;
    }

    public static MediaInstanceManagerProvider createInstanceManager() {
        if (isLoaded(1)) {
            return sCoreProvider.createInstanceManager();
        }
        return null;
    }

    public static RTCRoomProvider createRTCRoom() {
        if (isLoaded(33)) {
            return sCoreProvider.createRTCRoom();
        }
        return null;
    }

    public static boolean downgrade() {
        if (isLoaded(1)) {
            return sCoreProvider.downgrade();
        }
        return false;
    }

    public static void filecacheConfigSave() {
        if (isLoaded(1)) {
            sCoreProvider.filecacheConfigSave();
        }
    }

    public static String getCoreVersion() {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = sCoreProvider;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.getCoreVersion();
        }
        return "";
    }

    public static HashMap<Integer, Long> getSystemInfraInfo() {
        if (isLoaded(1)) {
            return sCoreProvider.getSystemInfraInfo();
        }
        return null;
    }

    public static long getVideoCacheSizeCanBeCleared() {
        long videoCacheSizeCanBeCleared = RemotePlayerFactory.getInstance().getVideoCacheSizeCanBeCleared();
        if (videoCacheSizeCanBeCleared < 0) {
            if (!isLoaded(1)) {
                return 0L;
            }
            return sCoreProvider.calculateFolderSizeCanBeCleared();
        }
        return videoCacheSizeCanBeCleared;
    }

    public static boolean isCoreDexLoaded() {
        if (sCoreProvider != null) {
            return true;
        }
        return false;
    }

    public static void kernelNetInit() {
        if (!mSetCorNetHandle && isLoaded(1) && CyberPlayerManager.getNetHandleListener() != null) {
            long longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
            if (longValue != 0 && sCoreProvider.kernelNetInit(longValue) == 0) {
                mSetCorNetHandle = true;
            }
        }
    }

    public static void pcdnNetInit() {
        if (!mSetPcdnHandle && isLoaded(1) && CyberPlayerManager.getNetHandleListener() != null) {
            long longValue = CyberPlayerManager.getNetHandleListener().getPcdnNetHandle().longValue();
            if (longValue != 0 && sCoreProvider.pcdnNetInit(longValue) == 0) {
                mSetPcdnHandle = true;
            }
        }
    }

    public static void updateCfg() {
        if (isLoaded(1)) {
            sCoreProvider.updateCfg();
        }
    }

    public static void cancelDownload(String str) {
        if (isLoaded(1)) {
            sCoreProvider.cancelDownload(str);
        }
    }

    public static void cleanFileCacheWithThreshold(long j) {
        if (isLoaded(1)) {
            sCoreProvider.cleanFileCacheWithThreshold(j);
        }
    }

    public static void cleanFilecacheWithTimeExpired(long j) {
        if (isLoaded(1)) {
            sCoreProvider.cleanFilecacheWithTimeExpired(j);
        }
    }

    public static void deleteDownload(String str) {
        if (isLoaded(1)) {
            sCoreProvider.deleteDownload(str);
        }
    }

    public static void enableRTCCaptureDebug(boolean z) {
        if (isLoaded(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            sCoreProvider.enableRTCCaptureDebug(z);
        }
    }

    public static Map<String, String> getLibsVersion(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        if (isLoaded(1)) {
            return sCoreProvider.getLibsVersion(libsVersionType);
        }
        return null;
    }

    public static boolean hasCacheFile(String str) {
        int hasCacheFile = RemotePlayerFactory.getInstance().hasCacheFile(str);
        if (hasCacheFile < 0) {
            if (!isLoaded(1)) {
                return false;
            }
            return sCoreProvider.hasCacheFile(str);
        } else if (hasCacheFile != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isLoaded(int i) {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = sCoreProvider;
        if (cyberPlayerCoreProvider != null) {
            return cyberPlayerCoreProvider.isLoaded(i);
        }
        return false;
    }

    public static void pauseDownload(String str) {
        if (isLoaded(1)) {
            sCoreProvider.pauseDownload(str);
        }
    }

    public static void resumeDownload(String str) {
        if (isLoaded(1)) {
            sCoreProvider.resumeDownload(str);
        }
    }

    public static void setDownloadListener(CyberVideoDownloader.DownloadListener downloadListener) {
        if (isLoaded(1)) {
            sCoreProvider.setDownloadListener(downloadListener);
        }
    }

    public static void setPrefetchListener(CyberPlayerManager.OnPrefetchListener onPrefetchListener) {
        if (Utils.isMainProcess()) {
            sPrefetchListener = onPrefetchListener;
            return;
        }
        CyberPlayerCoreProvider cyberPlayerCoreProvider = sCoreProvider;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.addPrefetchListener(onPrefetchListener);
        }
    }

    public static void setRTCVerbose(boolean z) {
        if (isLoaded(33) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
            sCoreProvider.setRTCVerbose(z);
        }
    }

    public static void setWorkDir(String str) {
        if (isLoaded(1)) {
            sCoreProvider.setWorkDir(str);
        }
    }

    public static void stopPrefetch(String str) {
        if (isLoaded(1)) {
            sCoreProvider.stopPrefetch(str);
        }
    }

    public static void updatePlayerConfig(String str) {
        if (!RemotePlayerFactory.getInstance().updatePlayerConfig(str) && isLoaded(1)) {
            sCoreProvider.updatePlayerConfig(str);
        }
    }

    public static void updateStorageQuota(long j) {
        if (isLoaded(1)) {
            sCoreProvider.updateStorageQuota(j);
        }
    }

    public static CaptureManagerProvider createCaptureManager(Context context, int i, int i2, int i3, int i4, int i5) {
        if (isLoaded(33)) {
            return sCoreProvider.createCaptureManager(context, i, i2, i3, i4, i5);
        }
        return null;
    }

    public static DownloaderProvider createCyberDownloader(int i, String str, PrefetchOptions prefetchOptions) {
        if (isLoaded(1)) {
            return sCoreProvider.createCyberDownloader(i, str, prefetchOptions);
        }
        return null;
    }

    public static boolean duplayerEncrypt(byte[] bArr, int i, byte[] bArr2) {
        if (isLoaded(1)) {
            sCoreProvider.duplayerEncrypt(bArr, i, bArr2);
            return true;
        }
        return false;
    }

    public static int getDeviceHDRSupported(int i, int i2, int i3) {
        if (isLoaded(1)) {
            return sCoreProvider.getDeviceHDRSupported(i, i2, i3);
        }
        return -1;
    }

    public static PlayerProvider createCyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        if (isLoaded(1)) {
            return sCoreProvider.createCyberPlayer(i, httpDNS);
        }
        return null;
    }

    public static RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet) {
        if (isLoaded(33)) {
            return sCoreProvider.createRTCVideoView(context, attributeSet);
        }
        return null;
    }

    public static int filecacheRemoveReserveUrl(String str, boolean z) {
        if (isLoaded(1)) {
            return sCoreProvider.filecacheRemoveReserveUrl(str, z);
        }
        return -1;
    }

    public static boolean loadLibs(int i, Map<String, String> map) throws FileNotFoundException {
        CyberPlayerCoreProvider cyberPlayerCoreProvider = sCoreProvider;
        if (cyberPlayerCoreProvider != null) {
            cyberPlayerCoreProvider.loadlibs(i, map);
        }
        return isLoaded(i);
    }

    public static void setOption(String str, String str2) {
        if (isLoaded(1)) {
            sCoreProvider.setOption(str, str2);
        }
    }

    public static String startDownload(String str, VideoSourceBean videoSourceBean) {
        if (isLoaded(1)) {
            return sCoreProvider.startDownload(str, videoSourceBean);
        }
        return str;
    }

    public static CyberVRRenderProvider createCyberVRRender(Context context) {
        if (sCyberVRRenderProviderImplClass == null) {
            try {
                sCyberVRRenderProviderImplClass = Class.forName(CLASS_NAME_CYVER_VR_RENDER_PROVIDER_IMPL, false, context.getClassLoader());
            } catch (Exception e) {
                e.printStackTrace();
                sCyberVRRenderProviderImplClass = null;
            }
        }
        Class<?> cls = sCyberVRRenderProviderImplClass;
        if (cls == null) {
            return null;
        }
        try {
            return (CyberVRRenderProvider) cls.getConstructor(Context.class).newInstance(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            CyberLog.e(TAG, "create CyberVRRender failed");
            return null;
        }
    }

    public static int getDevicePlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map) {
        if (isLoaded(1)) {
            return sCoreProvider.getDevicePlayQualityScore(str, i, i2, i3, map);
        }
        if (i2 * i3 < 921600) {
            return 100;
        }
        return -1;
    }

    public static void sendGlobalCommond(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) {
        if (isLoaded(1)) {
            sCoreProvider.sendGlobalCommond(str, i, j, str2, prefetchOptions);
        }
    }

    public static synchronized void init(Context context, ClassLoader classLoader, String str, CyberPlayerManager.InstallListener2 installListener2) throws Exception {
        synchronized (CyberPlayerCoreInvoker.class) {
            if (sCoreProvider == null) {
                try {
                    CyberPlayerCoreProvider cyberPlayerCoreProvider = (CyberPlayerCoreProvider) Class.forName(CLASS_NAME_CYBER_PLAYER_CORE_IMPL, true, classLoader).newInstance();
                    sCoreProvider = cyberPlayerCoreProvider;
                    cyberPlayerCoreProvider.init(context, str);
                    sCoreProvider.setInstallListener(installListener2);
                    if (sCoreProvider != null) {
                        CyberClassLoader.addNativeLibraryDirectories(classLoader, sCoreProvider.getLibsSearchPath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    sCoreProvider = null;
                    throw e;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: Exception -> 0x0087, TryCatch #0 {Exception -> 0x0087, blocks: (B:3:0x0002, B:6:0x0026, B:8:0x002d, B:16:0x0058, B:18:0x0064, B:19:0x006b, B:12:0x0037, B:14:0x0040), top: B:22:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void prefetch(String str, String str2, String str3, int i, int i2, int i3, CyberPlayerManager.HttpDNS httpDNS, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
        String str5;
        String str6;
        try {
            if (!RemotePlayerFactory.getInstance().prefetch(str, str2, str3, i, i2, i3, str4, i4, i5, i6, i7, prefetchOptions, sPrefetchListener) && isLoaded(1)) {
                if (TextUtils.isEmpty(str2)) {
                    str6 = "dumedia/7.41.99.35";
                } else if (str2.indexOf(YalogWrap.YALOG_SPACE) == -1) {
                    str6 = str2 + " dumedia/" + SDKVersion.VERSION;
                } else {
                    str5 = str2;
                    kernelNetInit();
                    pcdnNetInit();
                    if (Utils.isMainProcess()) {
                        sCoreProvider.addPrefetchListener(sPrefetchListener);
                    }
                    sCoreProvider.prefetch(str, str5, str3, i, i2, i3, httpDNS, str4, i4, i5, i6, i7, prefetchOptions);
                }
                str5 = str6;
                kernelNetInit();
                pcdnNetInit();
                if (Utils.isMainProcess()) {
                }
                sCoreProvider.prefetch(str, str5, str3, i, i2, i3, httpDNS, str4, i4, i5, i6, i7, prefetchOptions);
            }
        } catch (Exception unused) {
        }
    }
}
