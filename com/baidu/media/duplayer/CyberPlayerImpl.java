package com.baidu.media.duplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.DeviceInfoUtils;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.media.kernelnet.KernelNetApi;
import com.baidu.media.pcdn.PcdnApi;
import com.baidu.media.playerconfig.PlayerConfigManagerInternal;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.b;
/* loaded from: classes5.dex */
public class CyberPlayerImpl extends PlayerProvider implements IjkMediaPlayer.e, b.a, b.InterfaceC2156b, b.c, b.d, b.e, b.f, b.g, b.i {
    public static /* synthetic */ Interceptable $ic;
    public static boolean y;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public IjkMediaPlayer f42479e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f42480f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f42481g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f42482h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f42483i;

    /* renamed from: j  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f42484j;
    public CyberPlayerManager.OnErrorListener k;
    public CyberPlayerManager.OnInfoListener l;
    public CyberPlayerManager.OnMediaSourceChangedListener m;
    public boolean n;
    public boolean o;
    public String p;
    public int q;
    public long r;
    public long s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-590360507, "Lcom/baidu/media/duplayer/CyberPlayerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-590360507, "Lcom/baidu/media/duplayer/CyberPlayerImpl;");
        }
    }

    public CyberPlayerImpl(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), httpDNS};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = false;
        this.r = -1L;
        this.s = -1L;
        this.t = 3;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        try {
            if (!y && CyberPlayerManager.getNetHandleListener() != null) {
                long longValue = CyberPlayerManager.getNetHandleListener().getKerNetHandle().longValue();
                if (longValue != 0 && KernelNetApi.nativeKernelNetInit(longValue) == 0) {
                    y = true;
                }
            }
            IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
            this.f42479e = ijkMediaPlayer;
            this.q = i2;
            ijkMediaPlayer.c(i2);
            this.f42479e.a((b.f) this);
            this.f42479e.a((b.InterfaceC2156b) this);
            this.f42479e.a((b.a) this);
            this.f42479e.a((b.g) this);
            this.f42479e.a((b.i) this);
            this.f42479e.a((b.c) this);
            this.f42479e.a((b.d) this);
            this.f42479e.a((IjkMediaPlayer.e) this);
            this.f42479e.a(httpDNS);
            this.f42479e.a((b.e) this);
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 4) {
                int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("decode_mode", i2);
                if ((cfgIntValue == 2 || cfgIntValue == 0) && !CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_HW_DECODE, true)) {
                    return 1;
                }
                return cfgIntValue;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @Keep
    public static PlayerProvider create(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, httpDNS)) == null) {
            int c2 = c(i2);
            if (c2 == 4) {
                return null;
            }
            return new CyberPlayerImpl(c2, httpDNS);
        }
        return (PlayerProvider) invokeIL.objValue;
    }

    @Override // tv.danmaku.ijk.media.player.b.f
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.u = 2;
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.f42480f;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
            long j2 = this.s;
            if (j2 > 0) {
                seekTo(j2, this.t);
            }
            this.s = -1L;
            if (this.v == 3 && this.u == 2) {
                start();
            } else if (this.v == 4 && this.u == 2) {
                pause();
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.a
    public void a(b bVar, int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) || (onBufferingUpdateListener = this.f42482h) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(i2);
    }

    @Override // tv.danmaku.ijk.media.player.b.i
    public void a(b bVar, int i2, int i3, int i4, int i5) {
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (onVideoSizeChangedListener = this.f42484j) == null) {
            return;
        }
        onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
    }

    @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.e
    public boolean a(int i2, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bundle)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // tv.danmaku.ijk.media.player.b.c
    public boolean a(b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            this.u = -1;
            this.v = -1;
            CyberPlayerManager.OnErrorListener onErrorListener = this.k;
            return onErrorListener != null && onErrorListener.onError(i2, i3, obj);
        }
        return invokeCommon.booleanValue;
    }

    @Override // tv.danmaku.ijk.media.player.b.InterfaceC2156b
    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.u = 5;
            this.v = 5;
            CyberPlayerManager.OnCompletionListener onCompletionListener = this.f42481g;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.b.d
    public boolean b(b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            CyberLog.v("CyberPlayerImpl", "onInfo what:" + i2 + " extra:" + i3 + " obj:" + obj);
            if (i2 == 10102) {
                this.q = i3;
            }
            CyberPlayerManager.OnInfoListener onInfoListener = this.l;
            return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
        }
        return invokeCommon.booleanValue;
    }

    @Override // tv.danmaku.ijk.media.player.b.g
    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.r = -1L;
            CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f42483i;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete();
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (CyberCfgManager.getInstance().getCfgBoolValue("pcdn_forbidden", false) || c.h() == null) ? false : true : invokeV.booleanValue;
    }

    @Override // tv.danmaku.ijk.media.player.b.e
    public boolean c(b bVar, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) {
            CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.m;
            return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) || this.f42479e == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str = "http://" + str;
        }
        this.f42479e.a(str, z);
    }

    public final long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 0) {
                    return parseLong;
                }
                return 512000L;
            } catch (Exception unused) {
                return 512000L;
            }
        }
        return invokeL.longValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_BSO, false)) {
            this.f42479e.a(1, "bso_enable", 1L);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMO, false);
            if (cfgBoolValue) {
                this.f42479e.a(1, "dmo_enable", 1L);
                this.f42479e.a(1, HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                this.f42479e.a(1, "model", Build.MODEL);
                this.f42479e.a(1, HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            }
            boolean cfgBoolValue2 = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMR, false);
            if (cfgBoolValue2) {
                this.f42479e.a(1, "dmr_enable", 1L);
            }
            if (cfgBoolValue2 || cfgBoolValue) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f42479e.a(1, "cpu_max", DeviceInfoUtils.getMaxCpuFreq());
                this.f42479e.a(1, "cpu_min", DeviceInfoUtils.getMinCpuFreq());
                this.f42479e.a(1, "cpu_cur", DeviceInfoUtils.getCurCpuFreq());
                String[] memoryInfos = DeviceInfoUtils.getMemoryInfos();
                if (memoryInfos != null) {
                    this.f42479e.a(1, "memory_max", memoryInfos[0]);
                    this.f42479e.a(1, "memory_avail", memoryInfos[1]);
                    this.f42479e.a(1, "memory_threold", memoryInfos[2]);
                }
                String[] batteryInfos = DeviceInfoUtils.getBatteryInfos();
                if (batteryInfos != null) {
                    this.f42479e.a(1, "battery_health", batteryInfos[0]);
                    this.f42479e.a(1, "battery_status", batteryInfos[1]);
                    this.f42479e.a(1, "battery_level", batteryInfos[2]);
                    this.f42479e.a(1, "battery_scale", batteryInfos[3]);
                    this.f42479e.a(1, "battery_voltage", batteryInfos[4]);
                    this.f42479e.a(1, "battery_temperature", batteryInfos[5]);
                    this.f42479e.a(1, "battery_technology", batteryInfos[6]);
                }
                CyberLog.v("CyberPlayerImpl", "[wxc] cost times2:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String j2 = Utils.j();
            if (j2 == null || j2.length() <= 0) {
                return false;
            }
            setOption(CyberPlayerManager.OPT_HTTP_PROXY, j2);
            setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                long j2 = this.r;
                return j2 > -1 ? (int) j2 : (int) ijkMediaPlayer.m();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                long j2 = this.r;
                return j2 > -1 ? (int) j2 : (int) ijkMediaPlayer.n();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.q : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (l()) {
                return this.f42479e.t();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (m()) {
                return (int) this.f42479e.o();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (m()) {
                return this.f42479e.s();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                return ijkMediaPlayer.l();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                return ijkMediaPlayer.k();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final long h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            try {
                return Math.max(Long.parseLong(str), 3145728L);
            } catch (Exception unused) {
                return 3145728L;
            }
        }
        return invokeL.longValue;
    }

    public final void i() {
        IjkMediaPlayer ijkMediaPlayer;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (k() && this.n && !this.o) {
                ijkMediaPlayer = this.f42479e;
                j2 = 1;
            } else {
                ijkMediaPlayer = this.f42479e;
                j2 = 0;
            }
            ijkMediaPlayer.a(1, "proxytcp-enable", j2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            return ijkMediaPlayer != null && ijkMediaPlayer.r();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? l() && this.u == 3 : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final long j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            try {
                return Math.min(Math.max(Long.parseLong(str), 1048576L), (long) DownloadManager.MIN_LEFT_SIZE);
            } catch (Exception unused) {
                return 2097152L;
            }
        }
        return invokeL.longValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_FILE_CACHE, true) && !CyberCfgManager.getInstance().isBlackUrl(this.p);
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (this.f42479e == null || (i2 = this.u) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (this.f42479e == null || (i2 = this.u) == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.d(z);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (l()) {
                if (this.u != 4) {
                    this.u = 4;
                    this.f42479e.j();
                }
            } else if (this.f42479e != null) {
                sendCommand(1000, 0, 0L, null);
            }
            this.v = 4;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.f42479e == null) {
            return;
        }
        this.u = 1;
        g();
        i();
        e();
        f();
        this.f42479e.g();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        this.s = -1L;
        this.u = 0;
        this.v = 0;
        ijkMediaPlayer.p();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.s = -1L;
            this.r = -1L;
            this.u = 0;
            this.v = 0;
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                ijkMediaPlayer.q();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j2) == null) {
            seekTo(j2, 3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || this.f42479e == null) {
            return;
        }
        if (l()) {
            this.f42479e.a(j2, i2);
        } else {
            this.s = j2;
            this.t = i2;
        }
        this.r = j2;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i2, int i3, long j2, String str) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str}) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        if (i2 == 1000) {
            ijkMediaPlayer.c(i3 == 1);
            return;
        }
        try {
            if (i2 == 1001) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f42479e.b(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                }
            } else if (i2 == 1003 && !TextUtils.isEmpty(str)) {
                if (i3 == 0) {
                    i3 = DpStatConstants.SESSION_TYPE_PLAY_COMMON;
                }
                JSONObject jSONObject2 = new JSONObject(str);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    this.f42479e.b(i3, next2, jSONObject2.getString(next2));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, str) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.c(str);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, context, uri) == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, false)) {
                uri = PlayerConfigManagerInternal.getInstance().rebuildUrlForPlay(uri, (String) null, this.w, this.x);
                CyberLog.d("CyberPlayerImpl", "Override uri is => " + uri);
            }
            if (this.f42479e != null) {
                try {
                    this.p = uri.getHost();
                    this.f42479e.a(context, uri);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048618, this, context, uri, map) == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, false)) {
                uri = PlayerConfigManagerInternal.getInstance().rebuildUrlForPlay(uri, (String) null, this.w, this.x);
                CyberLog.d("CyberPlayerImpl", "Override uri is => " + uri);
            }
            if (this.f42479e != null) {
                try {
                    this.p = uri.getHost();
                    this.f42479e.a(context, uri, map);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, fileDescriptor) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        try {
            ijkMediaPlayer.b(fileDescriptor);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, false)) {
                Uri rebuildUrlForPlay = PlayerConfigManagerInternal.getInstance().rebuildUrlForPlay(str, (String) null, this.w, this.x);
                if (rebuildUrlForPlay == null) {
                    return;
                }
                String uri = rebuildUrlForPlay.toString();
                CyberLog.d("CyberPlayerImpl", "Override uri is => " + rebuildUrlForPlay);
                str = uri;
            }
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                try {
                    this.p = str;
                    ijkMediaPlayer.b(str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, map) == null) {
            if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAYER_SERVER, false)) {
                Uri rebuildUrlForPlay = PlayerConfigManagerInternal.getInstance().rebuildUrlForPlay(str, (String) null, this.w, this.x);
                if (rebuildUrlForPlay == null) {
                    return;
                }
                String uri = rebuildUrlForPlay.toString();
                CyberLog.d("CyberPlayerImpl", "Override uri is => " + rebuildUrlForPlay);
                str = uri;
            }
            IjkMediaPlayer ijkMediaPlayer = this.f42479e;
            if (ijkMediaPlayer != null) {
                try {
                    this.p = str;
                    ijkMediaPlayer.a(str, map);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, surfaceHolder) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(surfaceHolder);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.b(z);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onBufferingUpdateListener) == null) {
            this.f42482h = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onCompletionListener) == null) {
            this.f42481g = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onErrorListener) == null) {
            this.k = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onInfoListener) == null) {
            this.l = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onMediaSourceChangedListener) == null) {
            this.m = onMediaSourceChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onPreparedListener) == null) {
            this.f42480f = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onSeekCompleteListener) == null) {
            this.f42483i = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onVideoSizeChangedListener) == null) {
            this.f42484j = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j2) {
        IjkMediaPlayer ijkMediaPlayer;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048632, this, str, j2) == null) || this.f42479e == null) {
            return;
        }
        if (str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) || str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
            ijkMediaPlayer = this.f42479e;
            i2 = 1;
        } else {
            ijkMediaPlayer = this.f42479e;
            i2 = 4;
        }
        ijkMediaPlayer.a(i2, str, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (java.lang.Boolean.parseBoolean(r10) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0093, code lost:
        r0.a(1, r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d1, code lost:
        if (java.lang.Boolean.parseBoolean(r10) != false) goto L28;
     */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setOption(String str, String str2) {
        IjkMediaPlayer ijkMediaPlayer;
        long parseLong;
        String str3;
        IjkMediaPlayer ijkMediaPlayer2;
        IjkMediaPlayer ijkMediaPlayer3;
        String str4;
        IjkMediaPlayer ijkMediaPlayer4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, str2) == null) {
            CyberLog.v("CyberPlayerImpl", "setOption: " + str + "," + str2);
            if (this.f42479e != null) {
                if (str.equals(CyberPlayerManager.OPT_FILE_MIN_SIZE)) {
                    ijkMediaPlayer = this.f42479e;
                    parseLong = d(str2);
                } else if (!str.equals(CyberPlayerManager.OPT_FILE_MAX_SIZE)) {
                    if (str.equals(CyberPlayerManager.OPT_BUFFER_SIZE)) {
                        this.f42479e.a(4, str, j(str2));
                        return;
                    }
                    if (str.equals(CyberPlayerManager.OPT_HTTP_PROXY)) {
                        ijkMediaPlayer2 = this.f42479e;
                        str2 = "http://" + str2;
                    } else {
                        long j2 = 1;
                        if (str.equals(CyberPlayerManager.OPT_NEED_T5_AUTH)) {
                            ijkMediaPlayer4 = this.f42479e;
                        } else if (str.equals(CyberPlayerManager.OPT_ENABLE_FILECACHE)) {
                            this.n = Boolean.parseBoolean(str2);
                            return;
                        } else if (str.equals(CyberPlayerManager.OPT_IS_LIVE_VIDEO)) {
                            boolean parseBoolean = Boolean.parseBoolean(str2);
                            this.o = parseBoolean;
                            if (parseBoolean) {
                                this.f42479e.a(4, "opt-is-live-video", "1");
                                return;
                            }
                            return;
                        } else if (str.equals(CyberPlayerManager.OPT_SUPPORT_PROCESS)) {
                            ijkMediaPlayer4 = this.f42479e;
                        } else {
                            if (!str.equals(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME) && !str.equals(CyberPlayerManager.OPT_CLIENT_USER_CLICK_TIME)) {
                                if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
                                    if (c()) {
                                        PcdnApi.nativePcdnInit(c.h(), Long.parseLong(str2));
                                        return;
                                    }
                                    return;
                                } else if (str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                                    KernelNetApi.nativeKernelNetInit(Long.parseLong(str2));
                                    return;
                                } else if (!str.equals(CyberPlayerManager.OPT_ENABLE_PREBUFFER)) {
                                    if (str.equals(CyberPlayerManager.OPT_ENABLE_PCDN)) {
                                        if (c()) {
                                            this.f42479e.a(1, str, Long.parseLong(str2));
                                        }
                                        ijkMediaPlayer3 = this.f42479e;
                                        str4 = "pcdn_enable";
                                    } else if (str.equals(CyberPlayerManager.OPT_ENABLE_P2P)) {
                                        if (c()) {
                                            this.f42479e.a(1, str, Long.parseLong(str2));
                                        }
                                        ijkMediaPlayer3 = this.f42479e;
                                        str4 = "p2p_enable";
                                    } else if (str.equals(CyberPlayerManager.OPT_ENABLE_KERNEL_NET)) {
                                        this.f42479e.a(1, str, Long.parseLong(str2));
                                        ijkMediaPlayer3 = this.f42479e;
                                        str4 = "kernel_net_enable";
                                    } else if (!str.equals(CyberPlayerManager.OPT_PCDN_TYPE) && !str.equals(CyberPlayerManager.OPT_FILE_SIZE)) {
                                        if (!str.equals(CyberPlayerManager.OPT_STAGE_TYPE)) {
                                            if (str.equals(CyberPlayerManager.OPT_SR_OPTION)) {
                                                if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
                                                    this.f42479e.a(1, str, str2);
                                                    str3 = "enable sr";
                                                } else {
                                                    this.f42479e.a(1, str, 0L);
                                                    str3 = "disable sr";
                                                }
                                                CyberLog.v("CyberPlayerImpl", str3);
                                                return;
                                            } else if (!str.equals(CyberPlayerManager.OPT_NEED_HTTP_REFERER)) {
                                                if (str.equals(CyberPlayerManager.OPT_VIDEO_BPS)) {
                                                    try {
                                                        this.w = Integer.parseInt(str2);
                                                        return;
                                                    } catch (Exception unused) {
                                                        this.w = 0;
                                                        return;
                                                    }
                                                } else if (str.equals(CyberPlayerManager.OPT_VIDEO_MOOV_SIZE)) {
                                                    try {
                                                        this.x = Integer.parseInt(str2);
                                                        return;
                                                    } catch (Exception unused2) {
                                                        this.x = 0;
                                                        return;
                                                    }
                                                } else if (!str.equals(CyberPlayerManager.OPT_ENABLE_HLS_VOD_FILECACHE)) {
                                                    this.f42479e.a(4, str, str2);
                                                    return;
                                                }
                                            }
                                        }
                                        ijkMediaPlayer2 = this.f42479e;
                                    }
                                    ijkMediaPlayer3.b(DpStatConstants.SESSION_TYPE_PLAY_COMMON, str4, str2);
                                    return;
                                }
                            }
                            ijkMediaPlayer = this.f42479e;
                            parseLong = Long.parseLong(str2);
                        }
                    }
                    ijkMediaPlayer2.a(1, str, str2);
                    return;
                } else {
                    ijkMediaPlayer = this.f42479e;
                    parseLong = h(str2);
                }
                ijkMediaPlayer.a(1, str, parseLong);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, str) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(str);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048635, this, z) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(z);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048636, this, f2) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(f2);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, surface) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(f2, f3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048639, this, context, i2) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(context, i2);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (l()) {
                this.u = 3;
                this.f42479e.h();
            } else if (this.f42479e != null) {
                sendCommand(1000, 1, 0L, null);
            }
            this.v = 3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        this.s = -1L;
        this.u = 0;
        this.v = 0;
        ijkMediaPlayer.i();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i2) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.b(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void updateDisplaySize(int i2, int i3) {
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048643, this, i2, i3) == null) || (ijkMediaPlayer = this.f42479e) == null) {
            return;
        }
        ijkMediaPlayer.a(i2, i3);
    }
}
