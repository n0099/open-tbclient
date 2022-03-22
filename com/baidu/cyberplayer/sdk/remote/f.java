package com.baidu.cyberplayer.sdk.remote;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends b.a implements CyberPlayerManager.HttpDNS, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CyberPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public int f25430b;

    /* renamed from: c  reason: collision with root package name */
    public RemotePlayerService f25431c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteCallbackList<d> f25432d;

    /* renamed from: e  reason: collision with root package name */
    public Surface f25433e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f25434f;

    public f(int i, RemotePlayerService remotePlayerService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), remotePlayerService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25432d = new RemoteCallbackList<>();
        this.f25434f = new Object();
        this.f25430b = i;
        this.f25431c = remotePlayerService;
        CyberPlayer cyberPlayer = new CyberPlayer(i, this, false);
        this.a = cyberPlayer;
        cyberPlayer.setIsInMainProcess(false);
        this.a.setOnPreparedListener(this);
        this.a.setOnCompletionListener(this);
        this.a.setOnBufferingUpdateListener(this);
        this.a.setOnVideoSizeChangedListener(this);
        this.a.setOnSeekCompleteListener(this);
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this);
        this.a.setOnMediaSourceChangedListener(this);
        com.baidu.cyberplayer.sdk.d.l();
        com.baidu.cyberplayer.sdk.d.m();
    }

    private CyberPlayer q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.a : (CyberPlayer) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? q().getDecodeMode() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            q().setSpeed(f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            q().setVolume(f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            q().setWakeMode(CyberPlayerManager.getApplicationContext(), i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            q().updateDisplaySize(i, i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i, int i2, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) {
            q().sendCommand(i, i2, j, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            q().seekTo(j, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, surface) == null) {
            q().setSurface(surface);
            synchronized (this.f25434f) {
                if (this.f25433e != null && this.f25433e != surface) {
                    this.f25433e.release();
                }
                this.f25433e = surface;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f25432d.register(dVar);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            q().setDataSource(CyberPlayerManager.getApplicationContext(), eVar.a(), eVar.b());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("is_remote_play", 1);
                a(1003, 0, 0L, jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(String str) throws RemoteException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == null) {
            return;
        }
        q().setClarityInfo(str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(String str, String str2) {
        CyberPlayer q;
        long kernelNetHandle;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = CyberPlayerManager.OPT_PCDN_NETHANDLE;
        if (!str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
            str3 = CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE;
            if (!str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                q().setOption(str, str2);
                return;
            } else if (TextUtils.isEmpty(str2) || this.f25431c == null) {
                return;
            } else {
                q = q();
                kernelNetHandle = this.f25431c.getKernelNetHandle();
            }
        } else if (TextUtils.isEmpty(str2) || this.f25431c == null) {
            return;
        } else {
            q = q();
            kernelNetHandle = this.f25431c.getPCDNNetHandle();
        }
        q.setOption(str3, String.valueOf(kernelNetHandle));
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            q().changeProxyDynamic(str, z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            q().setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q().prepareAsync();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            q().switchMediaSource(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            this.f25432d.unregister(dVar);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            q().setPlayJson(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            q().setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q().start();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            q().setEnableDumediaUA(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            q().stop();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            q().muteOrUnmuteAudio(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            q().pause();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? q().getVideoWidth() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? q().getVideoHeight() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
    public List<String> getIpList(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                arrayList = null;
                for (int i = 0; i < beginBroadcast; i++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(str);
                            broadcastItem.a("onHttpDNS", arrayList2);
                            if (arrayList2.size() > 0) {
                                arrayList = arrayList2;
                            }
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? q().isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? q().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? q().getCurrentPositionSync() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? q().getDuration() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.release();
                }
            }
            synchronized (this.f25432d) {
                this.f25432d.kill();
            }
            if (this.f25433e != null) {
                synchronized (this.f25434f) {
                    if (this.f25433e != null && this.f25433e.isValid()) {
                        CyberLog.i("remotePlayer", "release mSurface");
                        this.f25433e.release();
                        this.f25433e = null;
                    }
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            q().reset();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? q().isLooping() : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? q().getPlayedTime() : invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i2);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.a(i);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.b();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i, i2, obj)) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                z = false;
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i3);
                    if (broadcastItem != null) {
                        try {
                            z = broadcastItem.a(i, i2, obj instanceof String ? (String) obj : null);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
            return z;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048614, this, i, i2, obj)) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                z = false;
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i3);
                    if (broadcastItem != null) {
                        try {
                            z = broadcastItem.b(i, i2, obj instanceof String ? (String) obj : null);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
            return z;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048615, this, i, i2, obj)) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                z = false;
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i3);
                    if (broadcastItem != null) {
                        try {
                            z = broadcastItem.c(i, i2, obj instanceof String ? (String) obj : null);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
            return z;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.c();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048618, this, i, i2, i3, i4) == null) {
            synchronized (this.f25432d) {
                int beginBroadcast = this.f25432d.beginBroadcast();
                for (int i5 = 0; i5 < beginBroadcast; i5++) {
                    d broadcastItem = this.f25432d.getBroadcastItem(i5);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.a(i, i2, i3, i4);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f25432d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? q().getDownloadSpeed() : invokeV.longValue;
    }
}
