package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes3.dex */
public class j extends PlayerProvider implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public k f4909a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f4910b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4911c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4912d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4913e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4914f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4915g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f4916h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.OnMediaSourceChangedListener f4917i;
    public int j;
    public int k;
    public a l;
    public b m;
    public DuplayerHandlerThread n;
    public boolean o;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<j> f4918a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4918a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                j jVar = this.f4918a.get();
                if (jVar == null) {
                    CyberLog.e("MediaPlayerAsync", "EventHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                    return;
                }
                CyberLog.i("MediaPlayerAsync", "EventHandler handleMessage what=" + message.what);
                switch (message.what) {
                    case 1:
                        if (jVar.f4910b != null) {
                            jVar.f4910b.onPrepared();
                            return;
                        }
                        return;
                    case 2:
                        if (jVar.f4911c != null) {
                            jVar.f4911c.onCompletion();
                            return;
                        }
                        return;
                    case 3:
                        if (jVar.f4912d != null) {
                            jVar.f4912d.onBufferingUpdate(message.arg1);
                            return;
                        }
                        return;
                    case 4:
                        if (jVar.f4913e != null) {
                            jVar.f4913e.onSeekComplete();
                            return;
                        }
                        return;
                    case 5:
                        jVar.j = message.arg1;
                        jVar.k = message.arg2;
                        if (jVar.f4914f != null) {
                            jVar.f4914f.onVideoSizeChanged(message.arg1, message.arg2, 1, 1);
                            return;
                        }
                        return;
                    case 6:
                    default:
                        CyberLog.e("MediaPlayerAsync", "EventHandler Unknown message type=" + message.what);
                        return;
                    case 7:
                        if (jVar.f4915g != null) {
                            jVar.f4915g.onError(message.arg1, message.arg2, null);
                            return;
                        }
                        return;
                    case 8:
                        if (jVar.f4916h != null) {
                            jVar.f4916h.onInfo(message.arg1, message.arg2, null);
                            return;
                        }
                        return;
                    case 9:
                        if (jVar.f4917i != null) {
                            jVar.f4917i.onMediaSourceChanged(-100, message.arg1, null);
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<j> f4919a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4919a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                j jVar = this.f4919a.get();
                if (jVar == null || (jVar.f4909a == null && message.what != 8)) {
                    CyberLog.e("MediaPlayerAsync", "RequestHandler,MediaPlayerImpl went away with unhandled events msg.what:" + message.what);
                    return;
                }
                CyberLog.i("MediaPlayerAsync", "RequestHandler handleMessage what=" + message.what);
                switch (message.what) {
                    case 1:
                        jVar.f4909a.stop();
                        return;
                    case 2:
                        try {
                            jVar.f4909a.setOnPreparedListener(null);
                            jVar.f4909a.setOnCompletionListener(null);
                            jVar.f4909a.setOnBufferingUpdateListener(null);
                            jVar.f4909a.setOnSeekCompleteListener(null);
                            jVar.f4909a.setOnVideoSizeChangedListener(null);
                            jVar.f4909a.setOnErrorListener(null);
                            jVar.f4909a.setOnInfoListener(null);
                            jVar.f4909a.release();
                            jVar.f4909a = null;
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    case 3:
                        jVar.f4909a.reset();
                        return;
                    case 4:
                        jVar.f4909a.pause();
                        return;
                    case 5:
                        jVar.f4909a.start();
                        return;
                    case 6:
                        jVar.f4909a.prepareAsync();
                        return;
                    case 7:
                        if (message.obj instanceof Long) {
                            jVar.f4909a.seekTo((int) ((Long) message.obj).longValue(), message.arg1);
                            return;
                        }
                        return;
                    case 8:
                        jVar.d();
                        return;
                    case 9:
                        Object obj = message.obj;
                        if (obj == null) {
                            jVar.f4909a.setSurface(null);
                            return;
                        } else if ((obj instanceof Surface) && ((Surface) obj).isValid()) {
                            try {
                                jVar.f4909a.setSurface((Surface) message.obj);
                                return;
                            } catch (Exception unused2) {
                                str = "setSurface exception!";
                                break;
                            }
                        } else {
                            return;
                        }
                    case 10:
                        if (message.obj instanceof FileDescriptor) {
                            jVar.f4909a.setDataSource((FileDescriptor) message.obj);
                            return;
                        }
                        return;
                    case 11:
                        Object obj2 = message.obj;
                        if (obj2 instanceof Boolean) {
                            float f2 = ((Boolean) obj2).booleanValue() ? 0.0f : 1.0f;
                            jVar.f4909a.setVolume(f2, f2);
                            return;
                        }
                        return;
                    case 12:
                        Object obj3 = message.obj;
                        if (obj3 instanceof ArrayList) {
                            ArrayList arrayList = (ArrayList) obj3;
                            jVar.f4909a.setDataSource((Context) arrayList.get(0), (Uri) arrayList.get(1));
                            return;
                        }
                        return;
                    case 13:
                        Object obj4 = message.obj;
                        if (obj4 instanceof ArrayList) {
                            ArrayList arrayList2 = (ArrayList) obj4;
                            jVar.f4909a.setDataSource((Context) arrayList2.get(0), (Uri) arrayList2.get(1), (Map) arrayList2.get(2));
                            return;
                        }
                        return;
                    case 14:
                        if (message.obj instanceof String) {
                            jVar.f4909a.setDataSource(String.valueOf(message.obj));
                            return;
                        }
                        return;
                    case 15:
                        Object obj5 = message.obj;
                        if (obj5 instanceof ArrayList) {
                            ArrayList arrayList3 = (ArrayList) obj5;
                            try {
                                jVar.f4909a.setDataSource((String) arrayList3.get(0), (Map) arrayList3.get(1));
                                return;
                            } catch (IllegalArgumentException e2) {
                                jVar.b(7, -1004, -1004, null);
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case 16:
                        Object obj6 = message.obj;
                        if (obj6 instanceof ArrayList) {
                            ArrayList arrayList4 = (ArrayList) obj6;
                            jVar.f4909a.setWakeMode((Context) arrayList4.get(0), ((Integer) arrayList4.get(1)).intValue());
                            return;
                        }
                        return;
                    case 17:
                        if (message.obj instanceof Boolean) {
                            jVar.f4909a.setScreenOnWhilePlaying(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 18:
                        Object obj7 = message.obj;
                        if (obj7 == null) {
                            jVar.f4909a.setDisplay(null);
                            return;
                        } else if ((obj7 instanceof SurfaceHolder) && ((SurfaceHolder) obj7).getSurface() != null && ((SurfaceHolder) message.obj).getSurface().isValid()) {
                            try {
                                jVar.f4909a.setDisplay((SurfaceHolder) message.obj);
                                return;
                            } catch (Exception unused3) {
                                str = "setDisplay exception!";
                                break;
                            }
                        } else {
                            return;
                        }
                        break;
                    case 19:
                        if (message.obj instanceof Boolean) {
                            jVar.f4909a.setLooping(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        return;
                    case 20:
                        Object obj8 = message.obj;
                        if (obj8 instanceof ArrayList) {
                            ArrayList arrayList5 = (ArrayList) obj8;
                            jVar.f4909a.setVolume(((Float) arrayList5.get(0)).floatValue(), ((Float) arrayList5.get(1)).floatValue());
                            return;
                        }
                        return;
                    case 21:
                        Object obj9 = message.obj;
                        if (obj9 instanceof Float) {
                            jVar.f4909a.setSpeed(((Float) obj9).floatValue());
                            return;
                        }
                        return;
                    case 22:
                        Object obj10 = message.obj;
                        if (obj10 instanceof ArrayList) {
                            ArrayList arrayList6 = (ArrayList) obj10;
                            jVar.f4909a.changeProxyDynamic((String) arrayList6.get(0), ((Boolean) arrayList6.get(1)).booleanValue());
                            return;
                        }
                        return;
                    default:
                        str = "RequestHandler Unknown message type=" + message.what;
                        break;
                }
                CyberLog.e("MediaPlayerAsync", str);
            }
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static PlayerProvider a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            j jVar = new j();
            if (jVar.b()) {
                return jVar;
            }
            jVar.release();
            return null;
        }
        return (PlayerProvider) invokeV.objValue;
    }

    private ArrayList<Object> a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, objArr)) == null) {
            ArrayList<Object> arrayList = new ArrayList<>();
            for (Object obj : objArr) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            if (this.o) {
                b bVar = this.m;
                if (bVar != null) {
                    bVar.sendEmptyMessage(i2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private boolean a(int i2, int i3, int i4, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj})) == null) {
            if (this.o) {
                b bVar = this.m;
                if (bVar != null) {
                    this.m.sendMessage(bVar.obtainMessage(i2, i3, i4, obj));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) {
            if (this.o) {
                a aVar = this.l;
                if (aVar != null) {
                    aVar.sendEmptyMessage(i2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i2, int i3, int i4, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj})) == null) {
            if (this.o) {
                a aVar = this.l;
                if (aVar != null) {
                    this.l.sendMessage(aVar.obtainMessage(i2, i3, i4, obj));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                aVar = new a(this, myLooper);
            } else {
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null) {
                    this.l = null;
                    this.o = false;
                    if (o.m() || Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.n = DuplayerHandlerThreadPool.getInstance().obtain();
                        this.m = new b(this, this.n.getLooper());
                        CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.m);
                        this.o = true;
                    } else {
                        CyberLog.i("MediaPlayerAsync", "initPlayer, don't use request handler. thread:" + Thread.currentThread().getName());
                        this.m = null;
                    }
                    a(8);
                }
                aVar = new a(this, mainLooper);
            }
            this.l = aVar;
            this.o = false;
            if (o.m()) {
            }
            this.n = DuplayerHandlerThreadPool.getInstance().obtain();
            this.m = new b(this, this.n.getLooper());
            CyberLog.i("MediaPlayerAsync", "initPlayer, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.m);
            this.o = true;
            a(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            synchronized (this) {
                this.f4909a = new k();
                CyberLog.i("MediaPlayerAsync", "createPlayer mPlayer=" + this.f4909a);
                this.f4909a.setOnPreparedListener(this);
                this.f4909a.setOnCompletionListener(this);
                this.f4909a.setOnBufferingUpdateListener(this);
                this.f4909a.setOnSeekCompleteListener(this);
                this.f4909a.setOnVideoSizeChangedListener(this);
                this.f4909a.setOnErrorListener(this);
                this.f4909a.setOnInfoListener(this);
            }
        }
    }

    private synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            synchronized (this) {
                CyberLog.i("MediaPlayerAsync", "quitRequestHandlerThread");
                if (this.o) {
                    DuplayerHandlerThreadPool.getInstance().recycle(this.n);
                    this.n = null;
                }
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (!this.o || this.m == null || this.n == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            a(22, -1, -1, a(str, Boolean.valueOf(z)));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            k kVar = this.f4909a;
            if (kVar != null) {
                return kVar.getCurrentPosition();
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
            k kVar = this.f4909a;
            if (kVar != null) {
                return kVar.getCurrentPositionSync();
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
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            k kVar = this.f4909a;
            if (kVar != null) {
                return kVar.getDownloadSpeed();
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
            k kVar = this.f4909a;
            if (kVar != null) {
                return kVar.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            k kVar = this.f4909a;
            if (kVar != null) {
                return kVar.getPlayedTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            k kVar = this.f4909a;
            return kVar != null && kVar.isLooping();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            k kVar = this.f4909a;
            return kVar != null && kVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            a(11, -1, -1, Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            b(3, i2, -1, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b(2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048592, this, i2, i3, obj)) == null) ? b(7, i2, i3, null) : invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048593, this, i2, i3, obj)) == null) ? b(8, i2, i3, null) : invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(1);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b(4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048596, this, i2, i3, i4, i5) == null) {
            b(5, i2, i3, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            a(4);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            a(6);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages(null);
            }
            this.l.removeCallbacksAndMessages(null);
            a(2);
            e();
            this.m = null;
            this.f4910b = null;
            this.f4911c = null;
            this.f4912d = null;
            this.f4913e = null;
            this.f4914f = null;
            this.f4915g = null;
            this.f4916h = null;
            this.f4917i = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.removeCallbacksAndMessages(null);
            }
            this.l.removeCallbacksAndMessages(null);
            a(3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            seekTo(j, 3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            a(7, i2, -1, Long.valueOf(j));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, context, uri) == null) {
            a(12, -1, -1, a(context, uri));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, context, uri, map) == null) {
            a(13, -1, -1, a(context, uri, map));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fileDescriptor) == null) {
            a(10, -1, -1, fileDescriptor);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            a(14, -1, -1, str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, map) == null) {
            a(15, -1, -1, a(str, map));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, surfaceHolder) == null) {
            a(18, -1, -1, surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            a(19, -1, -1, Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onBufferingUpdateListener) == null) {
            this.f4912d = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onCompletionListener) == null) {
            this.f4911c = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onErrorListener) == null) {
            this.f4915g = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onInfoListener) == null) {
            this.f4916h = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onMediaSourceChangedListener) == null) {
            this.f4917i = onMediaSourceChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onPreparedListener) == null) {
            this.f4910b = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onSeekCompleteListener) == null) {
            this.f4913e = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onVideoSizeChangedListener) == null) {
            this.f4914f = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            a(17, -1, -1, Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            a(21, -1, -1, Float.valueOf(f2));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, surface) == null) {
            a(9, 0, 0, surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            a(20, -1, -1, a(Float.valueOf(f2), Float.valueOf(f3)));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, context, i2) == null) {
            a(16, -1, -1, a(context, Integer.valueOf(i2)));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            a(5);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            a(1);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            b(9, i2, -1, null);
        }
    }
}
