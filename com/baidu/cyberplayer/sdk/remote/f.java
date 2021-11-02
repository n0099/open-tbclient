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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends b.a implements CyberPlayerManager.HttpDNS, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f37179g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CyberPlayer f37180a;

    /* renamed from: b  reason: collision with root package name */
    public int f37181b;

    /* renamed from: c  reason: collision with root package name */
    public RemotePlayerService f37182c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteCallbackList<d> f37183d;

    /* renamed from: e  reason: collision with root package name */
    public Surface f37184e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f37185f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(924970822, "Lcom/baidu/cyberplayer/sdk/remote/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(924970822, "Lcom/baidu/cyberplayer/sdk/remote/f;");
        }
    }

    public f(int i2, RemotePlayerService remotePlayerService) {
        RemotePlayerService remotePlayerService2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), remotePlayerService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37183d = new RemoteCallbackList<>();
        this.f37185f = new Object();
        this.f37181b = i2;
        this.f37182c = remotePlayerService;
        CyberPlayer cyberPlayer = new CyberPlayer(i2, this, false);
        this.f37180a = cyberPlayer;
        cyberPlayer.setIsInMainProcess(false);
        this.f37180a.setOnPreparedListener(this);
        this.f37180a.setOnCompletionListener(this);
        this.f37180a.setOnBufferingUpdateListener(this);
        this.f37180a.setOnVideoSizeChangedListener(this);
        this.f37180a.setOnSeekCompleteListener(this);
        this.f37180a.setOnErrorListener(this);
        this.f37180a.setOnInfoListener(this);
        this.f37180a.setOnMediaSourceChangedListener(this);
        if (f37179g || (remotePlayerService2 = this.f37182c) == null) {
            return;
        }
        long kernelNetHandle = remotePlayerService2.getKernelNetHandle();
        if (kernelNetHandle == 0 || com.baidu.cyberplayer.sdk.d.c(kernelNetHandle) != 0) {
            return;
        }
        f37179g = true;
    }

    private CyberPlayer q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f37180a : (CyberPlayer) invokeV.objValue;
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
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            q().setWakeMode(CyberPlayerManager.getApplicationContext(), i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            q().updateDisplaySize(i2, i3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i2, int i3, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str}) == null) {
            q().sendCommand(i2, i3, j, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            q().seekTo(j, i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, surface) == null) {
            q().setSurface(surface);
            synchronized (this.f37185f) {
                if (this.f37184e != null && this.f37184e != surface) {
                    this.f37184e.release();
                }
                this.f37184e = surface;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f37183d.register(dVar);
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
            } else if (TextUtils.isEmpty(str2) || this.f37182c == null) {
                return;
            } else {
                q = q();
                kernelNetHandle = this.f37182c.getKernelNetHandle();
            }
        } else if (TextUtils.isEmpty(str2) || this.f37182c == null) {
            return;
        } else {
            q = q();
            kernelNetHandle = this.f37182c.getPCDNNetHandle();
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
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            q().switchMediaSource(i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            this.f37183d.unregister(dVar);
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
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                arrayList = null;
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i2);
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
                this.f37183d.finishBroadcast();
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
                if (this.f37180a != null) {
                    this.f37180a.release();
                }
            }
            synchronized (this.f37183d) {
                this.f37183d.kill();
            }
            if (this.f37184e != null) {
                synchronized (this.f37185f) {
                    if (this.f37184e != null && this.f37184e.isValid()) {
                        CyberLog.i("remotePlayer", "release mSurface");
                        this.f37184e.release();
                        this.f37184e = null;
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
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i3);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.a(i2);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i2);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.b();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i2, i3, obj)) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                z = false;
                for (int i4 = 0; i4 < beginBroadcast; i4++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i4);
                    if (broadcastItem != null) {
                        try {
                            z = broadcastItem.a(i2, i3, obj instanceof String ? (String) obj : null);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
            return z;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048614, this, i2, i3, obj)) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                z = false;
                for (int i4 = 0; i4 < beginBroadcast; i4++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i4);
                    if (broadcastItem != null) {
                        try {
                            z = broadcastItem.b(i2, i3, obj instanceof String ? (String) obj : null);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
            return z;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048615, this, i2, i3, obj)) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                z = false;
                for (int i4 = 0; i4 < beginBroadcast; i4++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i4);
                    if (broadcastItem != null) {
                        try {
                            z = broadcastItem.c(i2, i3, obj instanceof String ? (String) obj : null);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
            return z;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i2);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.a();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i2);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.c();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048618, this, i2, i3, i4, i5) == null) {
            synchronized (this.f37183d) {
                int beginBroadcast = this.f37183d.beginBroadcast();
                for (int i6 = 0; i6 < beginBroadcast; i6++) {
                    d broadcastItem = this.f37183d.getBroadcastItem(i6);
                    if (broadcastItem != null) {
                        try {
                            broadcastItem.a(i2, i3, i4, i5);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.f37183d.finishBroadcast();
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
