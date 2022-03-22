package com.baidu.cyberplayer.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.remote.b;
import com.baidu.cyberplayer.sdk.remote.d;
import com.baidu.cyberplayer.sdk.remote.g;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends PlayerProvider implements g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.cyberplayer.sdk.remote.b a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.HttpDNS f25443b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f25444c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f25445d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f25446e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f25447f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f25448g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f25449h;
    public CyberPlayerManager.OnInfoListener i;
    public CyberPlayerManager.OnMediaSourceChangedListener j;
    public a k;
    public Surface l;
    public b m;
    public int n;
    public int o;
    public boolean p;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<h> a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hVar);
        }

        public static void a(h hVar, String str) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, hVar, str) == null) {
                try {
                    if (TextUtils.isEmpty(str) || (obj = new JSONObject(str).get("first_disp_notify_time")) == null || !(obj instanceof String)) {
                        return;
                    }
                    long parseLong = Long.parseLong((String) obj);
                    if (parseLong > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - parseLong;
                        CyberLog.i("RemotePlayerProxy", "costTime:" + currentTimeMillis);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("notify_fsp_thread_cost", currentTimeMillis);
                        hVar.sendCommand(1003, DpStatConstants.SESSION_TYPE_FIRST_SCREEN, 0L, jSONObject.toString());
                    }
                } catch (JSONException unused) {
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (hVar = this.a.get()) == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    if (hVar.f25444c != null) {
                        hVar.f25444c.onPrepared();
                        return;
                    }
                    return;
                case 1:
                    if (hVar.f25445d != null) {
                        hVar.f25445d.onCompletion();
                        return;
                    }
                    return;
                case 2:
                    if (hVar.f25446e != null) {
                        hVar.f25446e.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (hVar.f25447f != null) {
                        hVar.f25447f.onSeekComplete();
                        return;
                    }
                    return;
                case 4:
                    if (hVar.f25448g != null) {
                        int[] iArr = (int[]) message.obj;
                        hVar.f25448g.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                    }
                    return;
                case 5:
                    if (hVar.f25449h != null) {
                        hVar.f25449h.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (hVar.i != null) {
                        hVar.i.onInfo(message.arg1, message.arg2, message.obj);
                    }
                    int i = message.arg1;
                    if (904 == i) {
                        a(hVar, (String) message.obj);
                        return;
                    } else if (910 == i) {
                        hVar.o = message.arg2;
                        return;
                    } else {
                        return;
                    }
                case 7:
                    if (hVar.j != null) {
                        hVar.j.onMediaSourceChanged(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* renamed from: b  reason: collision with root package name */
        public CyberPlayerManager.HttpDNS f25450b;

        public b(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, httpDNS};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f25450b = httpDNS;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.sendEmptyMessage(0);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (aVar = this.a) == null) {
                return;
            }
            Message obtain = Message.obtain(aVar, 2);
            obtain.arg1 = i;
            this.a.sendMessage(obtain);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i, int i2, int i3, int i4) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) || (aVar = this.a) == null) {
                return;
            }
            Message obtain = Message.obtain(aVar, 4);
            obtain.obj = new int[]{i, i2, i3, i4};
            this.a.sendMessage(obtain);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(String str, List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) && str.equals("onHttpDNS")) {
                if (this.f25450b == null || list == null || list.size() <= 0) {
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                list.clear();
                List<String> ipList = this.f25450b.getIpList(list.get(0));
                if (ipList != null) {
                    list.addAll(ipList);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean a(int i, int i2, String str) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, str)) == null) {
                a aVar = this.a;
                if (aVar != null) {
                    Message obtain = Message.obtain(aVar, 5);
                    obtain.arg1 = i;
                    obtain.arg2 = i2;
                    obtain.obj = str;
                    this.a.sendMessage(obtain);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this) {
                    if (this.a != null) {
                        this.a.sendEmptyMessage(1);
                    }
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean b(int i, int i2, String str) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i, i2, str)) == null) {
                a aVar = this.a;
                if (aVar != null) {
                    Message obtain = Message.obtain(aVar, 6);
                    obtain.arg1 = i;
                    obtain.arg2 = i2;
                    obtain.obj = str;
                    this.a.sendMessage(obtain);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void c() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.a) == null) {
                return;
            }
            aVar.sendEmptyMessage(3);
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean c(int i, int i2, String str) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, str)) == null) {
                a aVar = this.a;
                if (aVar != null) {
                    Message obtain = Message.obtain(aVar, 7);
                    obtain.arg1 = i;
                    obtain.arg2 = i2;
                    obtain.obj = str;
                    this.a.sendMessage(obtain);
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.a = null;
                this.f25450b = null;
            }
        }
    }

    public h(com.baidu.cyberplayer.sdk.remote.b bVar, CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, httpDNS};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.a = bVar;
        this.f25443b = httpDNS;
        this.k = new a(this);
        b bVar2 = new b(this.k, httpDNS);
        this.m = bVar2;
        com.baidu.cyberplayer.sdk.remote.b bVar3 = this.a;
        if (bVar3 != null) {
            try {
                bVar3.a(bVar2);
                g.a().a(this);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static h a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, httpDNS)) == null) {
            com.baidu.cyberplayer.sdk.remote.b a2 = b.a.a(g.a().a(i));
            if (a2 != null) {
                return new h(a2, httpDNS);
            }
            return null;
        }
        return (h) invokeIL.objValue;
    }

    private void a(Uri uri, Map<String, String> map) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri, map) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(new e(uri, map));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(Uri, Map)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.g.b
    public void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.k) == null) {
            return;
        }
        Message obtain = Message.obtain(aVar, 5);
        obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
        obtain.arg2 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
        obtain.obj = "binderDied";
        this.p = true;
        this.k.sendMessage(obtain);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(str, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "changeProxyDynamic(String, boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.o;
            if (i > -1) {
                return i;
            }
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.i();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.j();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.a();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
                    if (onErrorListener != null) {
                        onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "getDecodeMode() mIsBinderDied:" + this.p);
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.p();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.n;
            if (i > -1) {
                return i;
            }
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    int k = bVar.k();
                    this.n = k;
                    return k;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.o();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.g();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.f();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.n();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
            if (bVar != null) {
                try {
                    return bVar.h();
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.d(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "muteOrUnmuteAudio(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "pause()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.b();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "prepareAsync()");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.cyberplayer.sdk.remote.h$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.baidu.cyberplayer.sdk.CyberPlayerManager$OnCompletionListener, android.view.Surface, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnPreparedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnMediaSourceChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnInfoListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnBufferingUpdateListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnErrorListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnVideoSizeChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$HttpDNS, com.baidu.cyberplayer.sdk.remote.b, com.baidu.cyberplayer.sdk.remote.h$b, java.lang.Object, com.baidu.cyberplayer.sdk.remote.h$a, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnSeekCompleteListener] */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            try {
                bVar.b(this.m);
                this.a.l();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            g.a().b(this);
            this.a = null;
            this.l = null;
            this.k.removeCallbacksAndMessages(null);
            this.m.d();
            this.m = null;
            this.k = null;
            this.f25443b = null;
            this.f25444c = null;
            this.f25445d = null;
            this.f25446e = null;
            this.f25447f = null;
            this.f25448g = null;
            this.f25449h = null;
            this.i = null;
            this.j = null;
            this.n = -1;
            this.o = -1;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.m();
            this.k.removeCallbacksAndMessages(null);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "reset()");
            }
        }
        this.n = -1;
        this.o = -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            seekTo(j, 3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(j, i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "seekTo(long)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str}) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(i, i2, j, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "sendCommand what:" + i + " arg1:" + i2 + " arg2:" + j + " isBinderDied:" + this.p);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, uri) == null) {
            a(uri, (Map<String, String>) null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, uri, map) == null) {
            a(uri, map);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        CyberPlayerManager.OnErrorListener onErrorListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, fileDescriptor) == null) || (onErrorListener = this.f25449h) == null) {
            return;
        }
        onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(FileDescriptor)");
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            a(Uri.parse(str), (Map<String, String>) null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, map) == null) {
            a(Uri.parse(str), map);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, surfaceHolder) == null) || this.a == null) {
            return;
        }
        if (surfaceHolder != null) {
            try {
                surface = surfaceHolder.getSurface();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDisplay()");
                    return;
                }
                return;
            }
        } else {
            surface = null;
        }
        this.a.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.c(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setEnableDumediaUA(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.b(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setLooping(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onBufferingUpdateListener) == null) {
            this.f25446e = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onCompletionListener) == null) {
            this.f25445d = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onErrorListener) == null) {
            this.f25449h = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onInfoListener) == null) {
            this.i = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onMediaSourceChangedListener) == null) {
            this.j = onMediaSourceChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onPreparedListener) == null) {
            this.f25444c = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onSeekCompleteListener) == null) {
            this.f25447f = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onVideoSizeChangedListener) == null) {
            this.f25448g = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048614, this, str, j) == null) {
            setOption(str, String.valueOf(j));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, str, str2) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(str, str2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setOption(String, String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            try {
                if (this.a != null) {
                    this.a.b(str);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setPlayJson(String)");
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setScreenOnWhilePlaying(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048618, this, f2) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(f2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSpeed(float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, surface) == null) || this.a == null) {
            return;
        }
        Surface surface2 = this.l;
        if (surface2 != surface || surface2 == null) {
            try {
                this.a.a(surface);
                this.l = surface;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSurface()");
                }
                this.l = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(f2, f3);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setVolume(float, float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048621, this, context, i) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.a(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setWakeMode()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f25449h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "start()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.d();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i) == null) || (bVar = this.a) == null) {
            return;
        }
        try {
            bVar.b(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void updateDisplaySize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048625, this, i, i2) == null) {
            try {
                if (this.a != null) {
                    this.a.a(i, i2);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
