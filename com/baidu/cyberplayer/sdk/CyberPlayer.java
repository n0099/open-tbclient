package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlayerProvider a;
    public boolean b;
    public boolean c;
    public int d;
    public MediaInstanceState e;
    public CyberPlayerManager.OnErrorListener f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberPlayer() {
        this(0, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), (CyberPlayerManager.HttpDNS) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberPlayer(int i) {
        this(i, null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (CyberPlayerManager.HttpDNS) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS) {
        this(i, httpDNS, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), httpDNS};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (CyberPlayerManager.HttpDNS) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public CyberPlayer(int i, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), httpDNS, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = true;
        this.d = 0;
        this.a = m.a().a(i, httpDNS, z);
        if (z && a() && MultiInstanceManager.getInstance() != null) {
            this.d = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] register instance: " + this.d);
            if (this.d > 0) {
                MediaInstanceState mediaInstanceState = new MediaInstanceState();
                this.e = mediaInstanceState;
                mediaInstanceState.updateInstanceState(0);
                this.e.updateDns(httpDNS);
                this.e.updateDecoderMode(i);
                this.e.updateRemote(z);
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, true) : invokeV.booleanValue;
    }

    private boolean a(boolean z) {
        InterceptResult invokeZ;
        MediaInstanceState mediaInstanceState;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, this, z)) == null) {
            if (this.e != null) {
                this.a = m.a().a(this.e.getDecoderMode(), this.e.dns(), z);
            }
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null && (mediaInstanceState = this.e) != null) {
                if (!z) {
                    playerProvider.setOnPreparedListener(mediaInstanceState.getOnPreparedListener());
                }
                this.a.setOnCompletionListener(this.e.getOnCompletionListener());
                this.a.setOnBufferingUpdateListener(this.e.getOnBufferingUpdateListener());
                this.a.setOnSeekCompleteListener(this.e.getOnSeekCompleteListener());
                this.a.setOnVideoSizeChangedListener(this.e.getOnVideoSizeChangedListener());
                this.a.setOnErrorListener(this);
                this.a.setOnInfoListener(this.e.getOnInfoListener());
                this.a.setOnMediaSourceChangedListener(this.e.getOnMediaSourceChangedListener());
                Bundle instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.d, 0);
                if (instanceStatusByType != null) {
                    for (String str : instanceStatusByType.keySet()) {
                        setOption(str, instanceStatusByType.getString(str));
                    }
                }
                float lRVolume = this.e.getLRVolume();
                if (lRVolume >= 0.0f) {
                    setVolume(lRVolume, lRVolume);
                }
                this.a.muteOrUnmuteAudio(this.e.getPlayStateByType(0));
                this.a.setLooping(this.e.getPlayStateByType(1));
                this.a.setEnableDumediaUA(this.b);
                if (this.e.getInstanceUrl() != null) {
                    if (this.e.isProcessDied()) {
                        z2 = this.e.getInstanceUrl().startsWith("http://") || this.e.getInstanceUrl().startsWith("https://") || this.e.getInstanceUrl().startsWith("file://");
                        this.e.setProcessDied(false);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        setDataSource(this.e.getInstanceUrl(), this.e.getInstanceHeader());
                    }
                } else if (this.e.getInstanceUri() != null) {
                    setDataSource(this.e.getInstanceContext(), this.e.getInstanceUri(), this.e.getInstanceHeader());
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("media_process_resume_abnormal", this.e.getInstanceUrl());
                        sendCommand(1003, 0, 0L, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                if (this.e.getClarityInfo() != null) {
                    setClarityInfo(this.e.getClarityInfo());
                }
                if (this.e.getPlayJson() != null) {
                    setPlayJson(this.e.getPlayJson());
                }
                if (this.e.getMediaSourceRank() != Integer.MIN_VALUE) {
                    switchMediaSource(this.e.getMediaSourceRank());
                }
                this.a.setSurface(this.e.getInstanceSurface());
                this.a.prepareAsync();
                if (this.e.getCurrentPosition() >= 0) {
                    seekTo(this.e.getCurrentPosition());
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.changeProxyDynamic(str, z);
    }

    public void cleanFilecacheAsyn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o.j();
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getCurrentPosition();
            }
            if (this.d > 0) {
                return this.e.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getCurrentPositionSync();
            }
            if (this.d > 0) {
                return this.e.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getDecodeMode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getDownloadSpeed();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getPlayedTime();
            }
            if (this.d > 0) {
                return this.e.getPlayedTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getVideoHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.getVideoWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PlayerProvider playerProvider = this.a;
            return playerProvider != null && playerProvider.isLooping();
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PlayerProvider playerProvider = this.a;
            return playerProvider != null && playerProvider.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public boolean isRemotePlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                return playerProvider.isRemotePlayer();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void muteOrUnmuteAudio(boolean z) {
        MediaInstanceState mediaInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.muteOrUnmuteAudio(z);
            }
            if (this.d <= 0 || (mediaInstanceState = this.e) == null) {
                return;
            }
            mediaInstanceState.updatePlayStateByType(0, z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        InterceptResult invokeV;
        MediaInstanceState mediaInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.d);
            if (this.a == null || this.d <= 0 || (mediaInstanceState = this.e) == null) {
                return false;
            }
            mediaInstanceState.updateSeekPos(getCurrentPosition(), getDuration());
            this.e.updatePlayedTime(getPlayedTime());
            this.e.updateDownLoadSpeed(getDownloadSpeed());
            this.e.updateDecoderMode(getDecodeMode());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("multi_instance_destroy", this.e.getInstanceStaticsCount(true));
                sendCommand(1003, 0, 0L, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a.stop();
            this.a.release();
            this.a = null;
            this.e.updateInstanceState(0);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048591, this, i, i2, obj)) == null) {
            if (this.d > 0 && !CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, false) && (i == -30000 || i == -30001)) {
                MediaInstanceState mediaInstanceState = this.e;
                if (mediaInstanceState != null) {
                    mediaInstanceState.setProcessDied(true);
                }
                PlayerProvider playerProvider = this.a;
                if (playerProvider != null) {
                    playerProvider.stop();
                    this.a.release();
                    if (a(true)) {
                        MediaInstanceState mediaInstanceState2 = this.e;
                        if (mediaInstanceState2 != null) {
                            if (mediaInstanceState2.getPlayingStatus()) {
                                start();
                            } else {
                                pause();
                            }
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("multi_instance_resume_process", "1");
                            sendCommand(1003, 0, 0L, jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                }
            }
            if (this.d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
                this.d = 0;
                this.e.release();
                this.e = null;
            }
            CyberPlayerManager.OnErrorListener onErrorListener = this.f;
            return onErrorListener != null && onErrorListener.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onResumeInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] onResumeInstance:" + this.d);
            if (this.d <= 0 || this.a != null) {
                return false;
            }
            a(this.e.isRemote());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("multi_instance_resume", this.e.getInstanceStaticsCount(false));
                sendCommand(1003, 0, 0L, jSONObject.toString());
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.pause();
            }
            if (this.d > 0) {
                this.e.updatePlayingStatus(false);
                this.e.updateSeekPos(getCurrentPosition(), getDuration());
                MultiInstanceManager.getInstance().updateInstanceTimestamp(this.d, System.currentTimeMillis());
            }
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.prepareAsync();
    }

    public void preparseHostWithURI(Uri uri) {
        String host;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, uri) == null) || !this.c || uri == null || (host = uri.getHost()) == null) {
            return;
        }
        String uri2 = uri.toString();
        if ((uri2.contains(".flv") || uri2.contains(".m3u8")) && CyberCfgManager.getInstance().a("use_httpdns_first", false)) {
            List<String> iPListWithHost = CyberPlayerManager.getIPListWithHost(host);
            CyberLog.d("CyberPlayer", "preparseHostWithURI ips: " + iPListWithHost);
            if (iPListWithHost == null || iPListWithHost.size() <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : iPListWithHost) {
                sb.append(str);
                sb.append(";");
            }
            setOption(CyberPlayerManager.OPT_PREPARSE_IP, sb.toString());
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.release();
            }
            if (this.c) {
                setOnPreparedListener(null);
                setOnCompletionListener(null);
                setOnBufferingUpdateListener(null);
                setOnSeekCompleteListener(null);
                setOnVideoSizeChangedListener(null);
                setOnErrorListener(null);
                setOnInfoListener(null);
            }
            if (this.d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.d);
                this.d = 0;
                this.e.release();
                this.e = null;
            }
            this.f = null;
            o.j();
            CyberCfgManager.getInstance().a();
        }
    }

    public void reset() {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.reset();
    }

    public void seekTo(long j) throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            seekTo(j, 3);
        }
    }

    public void seekTo(long j, int i) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.seekTo(j, i);
    }

    public void sendCommand(int i, int i2, long j, String str) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.sendCommand(i, i2, j, str);
    }

    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setClarityInfo(str);
            }
            if (this.d > 0) {
                this.e.setClarityInfo(str);
            }
        }
    }

    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, uri) == null) {
            if (this.a != null) {
                String a = CyberCfgManager.getInstance().a("force_url", (String) null);
                if (TextUtils.isEmpty(a)) {
                    this.a.setDataSource(context, uri);
                } else {
                    this.a.setDataSource(context, Uri.parse(a));
                }
                preparseHostWithURI(uri);
            }
            if (this.d > 0) {
                this.e.updateDataSource(context, uri, null);
            }
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, uri, map) == null) {
            if (this.a != null) {
                if (this.b) {
                    map = o.a(map);
                }
                String a = CyberCfgManager.getInstance().a("force_url", (String) null);
                if (TextUtils.isEmpty(a)) {
                    this.a.setDataSource(context, uri, map);
                } else {
                    this.a.setDataSource(context, Uri.parse(a), map);
                }
                preparseHostWithURI(uri);
            }
            if (this.d > 0) {
                this.e.updateDataSource(context, uri, map);
            }
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, fileDescriptor) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            setDataSource(str, (Map<String, String>) null);
        }
    }

    public void setDataSource(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, map) == null) {
            if (this.a != null) {
                if (this.b) {
                    map = o.a(map);
                }
                String a = CyberCfgManager.getInstance().a("force_url", (String) null);
                if (TextUtils.isEmpty(a)) {
                    this.a.setDataSource(str, map);
                } else {
                    this.a.setDataSource(a, map);
                }
            }
            if (this.d > 0) {
                this.e.updateDataSource(str, map);
            }
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, surfaceHolder) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setDisplay(surfaceHolder);
            }
            if (this.d <= 0 || surfaceHolder == null) {
                return;
            }
            this.e.updateSurface(surfaceHolder.getSurface());
        }
    }

    public void setEnableDumediaUA(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.b = z;
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setEnableDumediaUA(z);
            }
        }
    }

    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, str, obj) == null) || TextUtils.isEmpty(str) || this.a == null) {
            return;
        }
        if (str.equals("is_feed_video")) {
            if (obj == null || !(obj instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_feed_video", booleanValue ? "true" : "false");
                sendCommand(1003, 0, 0L, jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (str.equals(CyberPlayerManager.STR_STAGE_INFO)) {
            if (obj == null || !(obj instanceof Map)) {
                return;
            }
            sendCommand(1001, 0, 0L, new JSONObject((Map) obj).toString());
        } else if (str.equals(CyberPlayerManager.STR_STATISTICS_INFO) && obj != null && (obj instanceof Map)) {
            Map map = (Map) obj;
            String str2 = (String) map.get("type");
            int parseInt = !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : 0;
            map.remove("type");
            sendCommand(1003, parseInt, 0L, new JSONObject(map).toString());
        }
    }

    public void setIsInMainProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.c = z;
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setLooping(z);
            }
            if (this.d > 0) {
                this.e.updatePlayStateByType(1, z);
            }
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onBufferingUpdateListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnBufferingUpdateListener(onBufferingUpdateListener);
            }
            if (this.d > 0) {
                this.e.setOnBufferingUpdateListener(onBufferingUpdateListener);
            }
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onCompletionListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnCompletionListener(onCompletionListener);
            }
            if (this.d > 0) {
                this.e.setOnCompletionListener(onCompletionListener);
            }
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onErrorListener) == null) {
            this.f = onErrorListener;
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnErrorListener(this);
            }
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onInfoListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnInfoListener(onInfoListener);
            }
            if (this.d <= 0 || (mediaInstanceState = this.e) == null) {
                return;
            }
            mediaInstanceState.setOnInfoListener(onInfoListener);
        }
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onMediaSourceChangedListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
            }
            if (this.d > 0) {
                this.e.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
            }
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onPreparedListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnPreparedListener(onPreparedListener);
            }
            if (this.d > 0) {
                this.e.setOnPreparedListener(onPreparedListener);
            }
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onSeekCompleteListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnSeekCompleteListener(onSeekCompleteListener);
            }
            if (this.d > 0) {
                this.e.setOnSeekCompleteListener(onSeekCompleteListener);
            }
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onVideoSizeChangedListener) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
            }
            if (this.d > 0) {
                this.e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
            }
        }
    }

    public void setOption(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048620, this, str, j) == null) || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) {
            if (this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.a.setOption(str, str2);
            }
            if (this.d > 0) {
                MultiInstanceManager.getInstance().updateStringOption(this.d, str, str2);
            }
        }
    }

    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setPlayJson(str);
            }
            if (this.d > 0) {
                this.e.setPlayJson(str);
            }
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.setScreenOnWhilePlaying(z);
    }

    public void setSpeed(float f) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048624, this, f) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.setSpeed(f);
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, surface) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.setSurface(surface);
            }
            if (this.d > 0) {
                this.e.updateSurface(surface);
            }
        }
    }

    public void setVolume(float f, float f2) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.setVolume(f, f2);
    }

    public void setWakeMode(Context context, int i) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048627, this, context, i) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.setWakeMode(context, i);
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.d > 0) {
                if (this.e.needActiveInstance()) {
                    CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.d);
                    if (MultiInstanceManager.getInstance().activeInstance(this.d) && this.a == null) {
                        onResumeInstance();
                    }
                    this.e.updateInstanceState(1);
                }
                this.e.updatePlayingStatus(true);
            }
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.start();
            }
        }
    }

    public void stop() {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.stop();
    }

    public void switchMediaSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            PlayerProvider playerProvider = this.a;
            if (playerProvider != null) {
                playerProvider.switchMediaSource(i);
            }
            if (this.d > 0) {
                this.e.setMediaSourceRank(i);
            }
        }
    }

    public void updateDisplaySize(int i, int i2) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048631, this, i, i2) == null) || (playerProvider = this.a) == null) {
            return;
        }
        playerProvider.updateDisplaySize(i, i2);
    }
}
