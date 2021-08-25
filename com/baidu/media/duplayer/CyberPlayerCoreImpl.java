package com.baidu.media.duplayer;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.c;
import c.a.z.a.e;
import c.a.z.b.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.rtc.CaptureManagerProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.cyberplayer.sdk.rtc.RTCVideoViewProvider;
import com.baidu.media.dlna.DlnaProviderImpl;
import com.baidu.media.duplayer.monitor.DuplayerQualityMonitorManager;
import com.baidu.media.kernelnet.KernelNetApi;
import com.baidu.media.playerconfig.PlayerConfigManagerInternal;
import com.baidu.media.recorder.DuAudioRecorder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes5.dex */
public class CyberPlayerCoreImpl extends CyberPlayerCoreProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CyberPlayerCoreImpl() {
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

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public long caculateFolderSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isLoaded(1)) {
                return Utils.n();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void cleanFilecacheWithTimeExpired(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            Utils.d(j2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public CaptureManagerProvider createCaptureManager(Context context, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? a.a(context, i2, i3, i4, i5, i6) : (CaptureManagerProvider) invokeCommon.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public CyberAudioRecorder createCyberAudioRecorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new DuAudioRecorder() : (CyberAudioRecorder) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public ExtractorProvider createCyberExtractor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.z.c.a.a() : (ExtractorProvider) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public PlayerProvider createCyberPlayer(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, httpDNS)) == null) ? CyberPlayerImpl.create(i2, httpDNS) : (PlayerProvider) invokeIL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public DlnaProvider createDlna() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? DlnaProviderImpl.create() : (DlnaProvider) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public MediaInstanceManagerProvider createInstanceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new MediaInstanceManagerImpl() : (MediaInstanceManagerProvider) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public RTCRoomProvider createRTCRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a.f() : (RTCRoomProvider) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, attributeSet)) == null) ? a.b(context, attributeSet) : (RTCVideoViewProvider) invokeLL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public boolean downgrade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? e.b().v() : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void duplayerEncrypt(byte[] bArr, int i2, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, bArr, i2, bArr2) == null) {
            Utils.i(bArr, i2, bArr2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void enableRTCCaptureDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            a.g(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public String getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? SDKVersion.VERSION : (String) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public int getDevicePlayQualityScore(String str, int i2, int i3, int i4, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) ? DuplayerQualityMonitorManager.getInstance().getPlayQualityScore(str, i2, i3, i4, map) : invokeCommon.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public String[] getLibsSearchPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? c.g() : (String[]) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public Map<String, String> getLibsVersion(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, libsVersionType)) == null) ? e.b().e(libsVersionType) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public HashMap<Integer, Long> getSystemInfraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public boolean hasCacheFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? Prefetch.hasCacheFile(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void init(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, context, str) == null) {
            c.b(context, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public boolean isLoaded(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? c.d(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void loadlibs(int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, map) == null) {
            c.a(i2, map);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public int nativeKernelNetInit(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) ? KernelNetApi.nativeKernelNetInit(j2) : invokeJ.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void prefetch(String str, String str2, String str3, int i2, int i3, int i4, CyberPlayerManager.HttpDNS httpDNS, String str4, int i5, int i6, int i7, int i8, PrefetchOptions prefetchOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), httpDNS, str4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), prefetchOptions}) == null) {
            if (prefetchOptions != null) {
                for (Map.Entry<String, String> entry : prefetchOptions.getOptions().entrySet()) {
                    CyberLog.i("PlayerServer-CyberPlayerCoreImpl", entry.getKey() + ZeusCrashHandler.NAME_SEPERATOR + entry.getValue());
                }
            }
            Prefetch.add(str, str2, str3, i2, i3, i4, httpDNS, str4, i5, i6, i7, i8, prefetchOptions);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void setRTCVerbose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            a.c(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void stopPrefetch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            Prefetch.stopPrefetch(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void updateCfg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            Utils.q();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void updatePlayerConfig(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            PlayerConfigManagerInternal.getInstance().updatePlayerConfig(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider
    public void updateStorageQuota(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            Utils.l(j2);
        }
    }
}
