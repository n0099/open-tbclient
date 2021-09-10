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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes5.dex */
public abstract class CyberPlayerCoreProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes5.dex */
    public static final class LibsVersionType {
        public static /* synthetic */ Interceptable $ic;
        public static final LibsVersionType ALL_VERSION;
        public static final LibsVersionType SUCCESS_LOADED_VERSION;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ LibsVersionType[] f38935a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-938912791, "Lcom/baidu/cyberplayer/sdk/CyberPlayerCoreProvider$LibsVersionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-938912791, "Lcom/baidu/cyberplayer/sdk/CyberPlayerCoreProvider$LibsVersionType;");
                    return;
                }
            }
            ALL_VERSION = new LibsVersionType("ALL_VERSION", 0);
            LibsVersionType libsVersionType = new LibsVersionType("SUCCESS_LOADED_VERSION", 1);
            SUCCESS_LOADED_VERSION = libsVersionType;
            f38935a = new LibsVersionType[]{ALL_VERSION, libsVersionType};
        }

        public LibsVersionType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LibsVersionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LibsVersionType) Enum.valueOf(LibsVersionType.class, str) : (LibsVersionType) invokeL.objValue;
        }

        public static LibsVersionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LibsVersionType[]) f38935a.clone() : (LibsVersionType[]) invokeV.objValue;
        }
    }

    public CyberPlayerCoreProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract long caculateFolderSize();

    public abstract void cancelDownload(String str);

    public abstract void cleanFilecacheWithTimeExpired(long j2);

    public abstract CaptureManagerProvider createCaptureManager(Context context, int i2, int i3, int i4, int i5, int i6);

    public abstract CyberAudioRecorder createCyberAudioRecorder();

    public abstract ExtractorProvider createCyberExtractor();

    public abstract PlayerProvider createCyberPlayer(int i2, CyberPlayerManager.HttpDNS httpDNS);

    public abstract DlnaProvider createDlna();

    public abstract MediaInstanceManagerProvider createInstanceManager();

    public abstract RTCRoomProvider createRTCRoom();

    public abstract RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet);

    public abstract void deleteDownload(String str);

    public abstract boolean downgrade();

    public abstract void duplayerEncrypt(byte[] bArr, int i2, byte[] bArr2);

    public abstract void enableRTCCaptureDebug(boolean z);

    public abstract String getCoreVersion();

    public abstract int getDevicePlayQualityScore(String str, int i2, int i3, int i4, Map<String, String> map);

    public abstract String[] getLibsSearchPath();

    public abstract Map<String, String> getLibsVersion(LibsVersionType libsVersionType);

    public abstract HashMap<Integer, Long> getSystemInfraInfo();

    public abstract boolean hasCacheFile(String str);

    public abstract void init(Context context, String str);

    public abstract boolean isLoaded(int i2);

    public abstract void loadlibs(int i2, Map<String, String> map) throws FileNotFoundException, UnsatisfiedLinkError, SecurityException;

    public abstract int nativeKernelNetInit(long j2);

    public abstract void pauseDownload(String str);

    public abstract void prefetch(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions);

    public abstract void resumeDownload(String str);

    public abstract void setDownloadListener(CyberVideoDownloader.DownloadListener downloadListener);

    public abstract void setInstallListener(CyberPlayerManager.InstallListener2 installListener2);

    public abstract void setRTCVerbose(boolean z);

    public abstract void setWorkDir(String str);

    public abstract String startDownload(String str, VideoSourceBean videoSourceBean);

    public abstract void stopPrefetch(String str);

    public abstract void updateCfg();

    public abstract void updatePlayerConfig(String str);

    public abstract void updateStorageQuota(long j2);
}
