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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class CyberPlayer implements CyberPlayerManager.OnErrorListener, MediaInstanceManagerProvider.OnClientInstanceHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PlayerProvider f4793a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4794b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4795c;

    /* renamed from: d  reason: collision with root package name */
    public int f4796d;

    /* renamed from: e  reason: collision with root package name */
    public MediaInstanceState f4797e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4798f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberPlayer() {
        this(0, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), (CyberPlayerManager.HttpDNS) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberPlayer(int i2) {
        this(i2, null, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (CyberPlayerManager.HttpDNS) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberPlayer(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        this(i2, httpDNS, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), httpDNS};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (CyberPlayerManager.HttpDNS) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public CyberPlayer(int i2, CyberPlayerManager.HttpDNS httpDNS, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), httpDNS, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f4794b = true;
        this.f4795c = true;
        this.f4796d = 0;
        this.f4793a = m.a().a(i2, httpDNS, z);
        if (z && a() && MultiInstanceManager.getInstance() != null) {
            this.f4796d = MultiInstanceManager.getInstance().registerInstance(this);
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] register instance: " + this.f4796d);
            if (this.f4796d > 0) {
                MediaInstanceState mediaInstanceState = new MediaInstanceState();
                this.f4797e = mediaInstanceState;
                mediaInstanceState.updateInstanceState(0);
                this.f4797e.updateDns(httpDNS);
                this.f4797e.updateDecoderMode(i2);
                this.f4797e.updateRemote(z);
            }
        }
    }

    private void a(boolean z) {
        MediaInstanceState mediaInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            if (this.f4797e != null) {
                this.f4793a = m.a().a(this.f4797e.getDecoderMode(), this.f4797e.dns(), z);
            }
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider == null || (mediaInstanceState = this.f4797e) == null) {
                return;
            }
            if (!z) {
                playerProvider.setOnPreparedListener(mediaInstanceState.getOnPreparedListener());
            }
            this.f4793a.setOnCompletionListener(this.f4797e.getOnCompletionListener());
            this.f4793a.setOnBufferingUpdateListener(this.f4797e.getOnBufferingUpdateListener());
            this.f4793a.setOnSeekCompleteListener(this.f4797e.getOnSeekCompleteListener());
            this.f4793a.setOnVideoSizeChangedListener(this.f4797e.getOnVideoSizeChangedListener());
            this.f4793a.setOnErrorListener(this);
            this.f4793a.setOnInfoListener(this.f4797e.getOnInfoListener());
            this.f4793a.setOnMediaSourceChangedListener(this.f4797e.getOnMediaSourceChangedListener());
            Bundle instanceStatusByType = MultiInstanceManager.getInstance().getInstanceStatusByType(this.f4796d, 0);
            if (instanceStatusByType != null) {
                for (String str : instanceStatusByType.keySet()) {
                    setOption(str, instanceStatusByType.getString(str));
                }
            }
            float lRVolume = this.f4797e.getLRVolume();
            if (lRVolume >= 0.0f) {
                setVolume(lRVolume, lRVolume);
            }
            this.f4793a.muteOrUnmuteAudio(this.f4797e.getPlayStateByType(0));
            this.f4793a.setLooping(this.f4797e.getPlayStateByType(1));
            this.f4793a.setEnableDumediaUA(this.f4794b);
            if (this.f4797e.getInstanceContext() != null) {
                setDataSource(this.f4797e.getInstanceContext(), this.f4797e.getInstanceUri(), this.f4797e.getInstanceHeader());
            } else if (this.f4797e.getInstanceUri() != null) {
                setDataSource(this.f4797e.getInstanceUri().getPath(), this.f4797e.getInstanceHeader());
            } else {
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] esumeInstance failed, source is null");
            }
            if (this.f4797e.getClarityInfo() != null) {
                setClarityInfo(this.f4797e.getClarityInfo());
            }
            if (this.f4797e.getPlayJson() != null) {
                setPlayJson(this.f4797e.getPlayJson());
            }
            if (this.f4797e.getMediaSourceRank() != Integer.MIN_VALUE) {
                switchMediaSource(this.f4797e.getMediaSourceRank());
            }
            this.f4793a.setSurface(this.f4797e.getInstanceSurface());
            this.f4793a.prepareAsync();
            if (this.f4797e.getCurrentPosition() >= 0) {
                seekTo(this.f4797e.getCurrentPosition());
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MULTI_INSTANCE, false) : invokeV.booleanValue;
    }

    public void changeProxyDynamic(String str, boolean z) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) || (playerProvider = this.f4793a) == null) {
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
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                return playerProvider.getCurrentPosition();
            }
            if (this.f4796d > 0) {
                return this.f4797e.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                return playerProvider.getCurrentPositionSync();
            }
            if (this.f4796d > 0) {
                return this.f4797e.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PlayerProvider playerProvider = this.f4793a;
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
            PlayerProvider playerProvider = this.f4793a;
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
            PlayerProvider playerProvider = this.f4793a;
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
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                return playerProvider.getPlayedTime();
            }
            if (this.f4796d > 0) {
                return this.f4797e.getPlayedTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PlayerProvider playerProvider = this.f4793a;
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
            PlayerProvider playerProvider = this.f4793a;
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
            PlayerProvider playerProvider = this.f4793a;
            return playerProvider != null && playerProvider.isLooping();
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PlayerProvider playerProvider = this.f4793a;
            return playerProvider != null && playerProvider.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public boolean isRemotePlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PlayerProvider playerProvider = this.f4793a;
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
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.muteOrUnmuteAudio(z);
            }
            if (this.f4796d <= 0 || (mediaInstanceState = this.f4797e) == null) {
                return;
            }
            mediaInstanceState.updatePlayStateByType(0, z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onDestroyInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] onDestroyInstance:" + this.f4796d);
            if (this.f4793a == null || this.f4796d <= 0) {
                return false;
            }
            this.f4797e.updateSeekPos(getCurrentPosition(), getDuration());
            this.f4797e.updatePlayedTime(getPlayedTime());
            this.f4797e.updateDownLoadSpeed(getDownloadSpeed());
            this.f4797e.updateDecoderMode(getDecodeMode());
            this.f4797e.updateInstanceDecodeMode(getDecodeMode());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("multi_instance_destroy", this.f4797e.getInstanceStaticsCount(true));
                sendCommand(1003, 0, 0L, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f4793a.stop();
            this.f4793a.release();
            this.f4793a = null;
            this.f4797e.updateInstanceState(0);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048591, this, i2, i3, obj)) == null) {
            if (this.f4796d <= 0 || CyberCfgManager.getInstance().a(CyberCfgManager.KEY_INT_REMOTE_RESUME_FORBIDDEN, true) || (!(i2 == -30000 || i2 == -30001) || (playerProvider = this.f4793a) == null)) {
                if (this.f4796d > 0) {
                    MultiInstanceManager.getInstance().unRegisterInstance(this.f4796d);
                    CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.f4796d);
                    this.f4796d = 0;
                    this.f4797e.release();
                    this.f4797e = null;
                }
                CyberPlayerManager.OnErrorListener onErrorListener = this.f4798f;
                return onErrorListener != null && onErrorListener.onError(i2, i3, obj);
            }
            playerProvider.stop();
            this.f4793a.release();
            a(true);
            MediaInstanceState mediaInstanceState = this.f4797e;
            if (mediaInstanceState != null) {
                if (mediaInstanceState.getPlayingStatus()) {
                    start();
                } else {
                    pause();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("multi_instance_resume_process", "1");
                sendCommand(1003, 0, 0L, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.MediaInstanceManagerProvider.OnClientInstanceHandler
    public boolean onResumeInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            CyberLog.i("CyberPlayer", "[MultiInstanceManager] onResumeInstance:" + this.f4796d);
            if (this.f4796d <= 0 || this.f4793a != null) {
                return false;
            }
            a(this.f4797e.isRemote());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("multi_instance_resume", this.f4797e.getInstanceStaticsCount(false));
                sendCommand(1003, 0, 0L, jSONObject.toString());
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.pause();
            }
            if (this.f4796d > 0) {
                this.f4797e.updatePlayingStatus(false);
                this.f4797e.updateSeekPos(getCurrentPosition(), getDuration());
                MultiInstanceManager.getInstance().updateInstanceTimestamp(this.f4796d, System.currentTimeMillis());
            }
        }
    }

    public void prepareAsync() {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.prepareAsync();
    }

    public void preparseHostWithURI(Uri uri) {
        String host;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, uri) == null) || !this.f4795c || uri == null || (host = uri.getHost()) == null) {
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
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.release();
            }
            if (this.f4795c) {
                setOnPreparedListener(null);
                setOnCompletionListener(null);
                setOnBufferingUpdateListener(null);
                setOnSeekCompleteListener(null);
                setOnVideoSizeChangedListener(null);
                setOnErrorListener(null);
                setOnInfoListener(null);
            }
            if (this.f4796d > 0) {
                MultiInstanceManager.getInstance().unRegisterInstance(this.f4796d);
                CyberLog.i("CyberPlayer", "[MultiInstanceManager] unRegister instance:" + this.f4796d);
                this.f4796d = 0;
                this.f4797e.release();
                this.f4797e = null;
            }
            this.f4798f = null;
            o.j();
            CyberCfgManager.getInstance().a();
        }
    }

    public void reset() {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (playerProvider = this.f4793a) == null) {
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

    public void seekTo(long j, int i2) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.seekTo(j, i2);
    }

    public void sendCommand(int i2, int i3, long j, String str) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str}) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.sendCommand(i2, i3, j, str);
    }

    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setClarityInfo(str);
            }
            if (this.f4796d > 0) {
                this.f4797e.setClarityInfo(str);
            }
        }
    }

    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, uri) == null) {
            if (this.f4793a != null) {
                String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
                if (TextUtils.isEmpty(a2)) {
                    this.f4793a.setDataSource(context, uri);
                } else {
                    this.f4793a.setDataSource(context, Uri.parse(a2));
                }
                preparseHostWithURI(uri);
            }
            if (this.f4796d > 0) {
                this.f4797e.updateDataSource(context, uri, null);
            }
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, uri, map) == null) {
            if (this.f4793a != null) {
                if (this.f4794b) {
                    map = o.a(map);
                }
                String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
                if (TextUtils.isEmpty(a2)) {
                    this.f4793a.setDataSource(context, uri, map);
                } else {
                    this.f4793a.setDataSource(context, Uri.parse(a2), map);
                }
                preparseHostWithURI(uri);
            }
            if (this.f4796d > 0) {
                this.f4797e.updateDataSource(context, uri, map);
            }
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, fileDescriptor) == null) || (playerProvider = this.f4793a) == null) {
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
            if (this.f4793a != null) {
                if (this.f4794b) {
                    map = o.a(map);
                }
                String a2 = CyberCfgManager.getInstance().a("force_url", (String) null);
                if (TextUtils.isEmpty(a2)) {
                    this.f4793a.setDataSource(str, map);
                } else {
                    this.f4793a.setDataSource(a2, map);
                }
            }
            if (this.f4796d > 0) {
                this.f4797e.updateDataSource(null, Uri.parse(str), map);
            }
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, surfaceHolder) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setDisplay(surfaceHolder);
            }
            if (this.f4796d <= 0 || surfaceHolder == null) {
                return;
            }
            this.f4797e.updateSurface(surfaceHolder.getSurface());
        }
    }

    public void setEnableDumediaUA(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f4794b = z;
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setEnableDumediaUA(z);
            }
        }
    }

    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, str, obj) == null) || TextUtils.isEmpty(str) || this.f4793a == null) {
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
            } catch (JSONException e2) {
                e2.printStackTrace();
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
            this.f4795c = z;
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setLooping(z);
            }
            if (this.f4796d > 0) {
                this.f4797e.updatePlayStateByType(1, z);
            }
        }
    }

    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onBufferingUpdateListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnBufferingUpdateListener(onBufferingUpdateListener);
            }
            if (this.f4796d > 0) {
                this.f4797e.setOnBufferingUpdateListener(onBufferingUpdateListener);
            }
        }
    }

    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onCompletionListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnCompletionListener(onCompletionListener);
            }
            if (this.f4796d > 0) {
                this.f4797e.setOnCompletionListener(onCompletionListener);
            }
        }
    }

    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onErrorListener) == null) {
            this.f4798f = onErrorListener;
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnErrorListener(this);
            }
        }
    }

    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        MediaInstanceState mediaInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onInfoListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnInfoListener(onInfoListener);
            }
            if (this.f4796d <= 0 || (mediaInstanceState = this.f4797e) == null) {
                return;
            }
            mediaInstanceState.setOnInfoListener(onInfoListener);
        }
    }

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onMediaSourceChangedListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
            }
            if (this.f4796d > 0) {
                this.f4797e.setOnMediaSourceChangedListener(onMediaSourceChangedListener);
            }
        }
    }

    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onPreparedListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnPreparedListener(onPreparedListener);
            }
            if (this.f4796d > 0) {
                this.f4797e.setOnPreparedListener(onPreparedListener);
            }
        }
    }

    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onSeekCompleteListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnSeekCompleteListener(onSeekCompleteListener);
            }
            if (this.f4796d > 0) {
                this.f4797e.setOnSeekCompleteListener(onSeekCompleteListener);
            }
        }
    }

    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onVideoSizeChangedListener) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
            }
            if (this.f4796d > 0) {
                this.f4797e.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
            }
        }
    }

    public void setOption(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048620, this, str, j) == null) || this.f4793a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4793a.setOption(str, j);
    }

    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) {
            if (this.f4793a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f4793a.setOption(str, str2);
            }
            if (this.f4796d > 0) {
                MultiInstanceManager.getInstance().updateStringOption(this.f4796d, str, str2);
            }
        }
    }

    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setPlayJson(str);
            }
            if (this.f4796d > 0) {
                this.f4797e.setPlayJson(str);
            }
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.setScreenOnWhilePlaying(z);
    }

    public void setSpeed(float f2) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048624, this, f2) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.setSpeed(f2);
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, surface) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.setSurface(surface);
            }
            if (this.f4796d > 0) {
                this.f4797e.updateSurface(surface);
            }
        }
    }

    public void setVolume(float f2, float f3) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.setVolume(f2, f3);
    }

    public void setWakeMode(Context context, int i2) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048627, this, context, i2) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.setWakeMode(context, i2);
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.f4796d > 0) {
                if (this.f4797e.needActiveInstance()) {
                    CyberLog.i("CyberPlayer", "[MultiInstanceManager] active instance: " + this.f4796d);
                    MultiInstanceManager.getInstance().activeInstance(this.f4796d);
                    this.f4797e.updateInstanceState(1);
                }
                this.f4797e.updatePlayingStatus(true);
            }
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.start();
            }
        }
    }

    public void stop() {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.stop();
    }

    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            PlayerProvider playerProvider = this.f4793a;
            if (playerProvider != null) {
                playerProvider.switchMediaSource(i2);
            }
            if (this.f4796d > 0) {
                this.f4797e.setMediaSourceRank(i2);
            }
        }
    }

    public void updateDisplaySize(int i2, int i3) {
        PlayerProvider playerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048631, this, i2, i3) == null) || (playerProvider = this.f4793a) == null) {
            return;
        }
        playerProvider.updateDisplaySize(i2, i3);
    }
}
