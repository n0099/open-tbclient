package com.baidu.swan.apps.media.audio;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes11.dex */
public class SwanAppAudioClient {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public IAudioService f38828b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38829c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38830d;

    /* renamed from: e  reason: collision with root package name */
    public String f38831e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38832f;

    /* renamed from: g  reason: collision with root package name */
    public c f38833g;

    /* renamed from: h  reason: collision with root package name */
    public d f38834h;

    /* renamed from: i  reason: collision with root package name */
    public String f38835i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f38836j;
    public ServiceConnection k;
    public final IAudioListener l;
    public final IBinder.DeathRecipient m;

    /* loaded from: classes11.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioClient f38839e;

        public a(SwanAppAudioClient swanAppAudioClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38839e = swanAppAudioClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.f38839e.f38830d = true;
                    this.f38839e.f38828b = IAudioService.Stub.asInterface(iBinder);
                    this.f38839e.f38828b.registerListener(this.f38839e.l);
                    iBinder.linkToDeath(this.f38839e.m, 0);
                    if (!n0.B()) {
                        this.f38839e.p();
                    }
                } catch (RemoteException e2) {
                    c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                    if (SwanAppAudioClient.n) {
                        e2.printStackTrace();
                    }
                }
                if (this.f38839e.f38834h != null) {
                    this.f38839e.f38834h.onServiceConnected(componentName, iBinder);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                try {
                    try {
                        this.f38839e.f38830d = false;
                        if (this.f38839e.f38828b != null) {
                            this.f38839e.f38828b.unregisterListener(this.f38839e.l);
                        }
                    } catch (RemoteException e2) {
                        c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                        if (SwanAppAudioClient.n) {
                            e2.printStackTrace();
                        }
                    }
                    if (this.f38839e.f38834h != null) {
                        this.f38839e.f38834h.onServiceDisconnected(componentName);
                    }
                } finally {
                    this.f38839e.f38828b = null;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioClient f38840e;

        public b(SwanAppAudioClient swanAppAudioClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38840e = swanAppAudioClient;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = SwanAppAudioClient.n;
                if (this.f38840e.f38828b == null) {
                    return;
                }
                this.f38840e.f38828b.asBinder().unlinkToDeath(this.f38840e.m, 0);
                this.f38840e.f38828b = null;
                this.f38840e.f38829c = false;
                this.f38840e.f38830d = false;
                SwanAppAudioClient swanAppAudioClient = this.f38840e;
                swanAppAudioClient.bindService(swanAppAudioClient.a);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes11.dex */
    public interface d {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644850329, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644850329, "Lcom/baidu/swan/apps/media/audio/SwanAppAudioClient;");
                return;
            }
        }
        n = k.a;
        o = AppRuntime.getAppContext().getPackageName();
    }

    public SwanAppAudioClient(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38831e = "";
        this.f38832f = true;
        this.f38836j = false;
        this.k = new a(this);
        this.l = new IAudioListener.Stub(this) { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppAudioClient this$0;

            /* renamed from: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2$a */
            /* loaded from: classes11.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Message f38837e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f38838f;

                public a(AnonymousClass2 anonymousClass2, Message message) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, message};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38838f = anonymousClass2;
                    this.f38837e = message;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38838f.this$0.f38833g == null) {
                        return;
                    }
                    this.f38838f.this$0.f38833g.a(this.f38837e);
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void dispatchAudioEvent(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(65537, this, i4) == null) {
                    dispatchAudioEvent(i4, 0, 0);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onCanPlay() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onCanPlay");
                    dispatchAudioEvent(1001);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onChangeSrc(String str) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onChangeSrc src=" + str + " mCurrentSrc" + this.this$0.f38835i + " mIsForeground=" + this.this$0.f38832f);
                    if (this.this$0.f38832f || TextUtils.equals(str, this.this$0.f38835i)) {
                        return;
                    }
                    dispatchAudioEvent(1004);
                    SwanAppAudioClient swanAppAudioClient = this.this$0;
                    swanAppAudioClient.unbindService(swanAppAudioClient.a);
                    this.this$0.f38828b.unregisterListener(this.this$0.l);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onDownloadProgress(int i4) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) {
                    if (SwanAppAudioClient.n) {
                        String str = "onDownloadProgress() " + i4;
                    }
                    dispatchAudioEvent(1008, i4);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onEnded() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onEnded");
                    dispatchAudioEvent(1005);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onError(int i4) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onError errCode=" + i4);
                    dispatchAudioEvent(1007, i4);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onNext() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onNext pid=" + Process.myPid());
                    dispatchAudioEvent(1010);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPause() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onPause");
                    dispatchAudioEvent(1003);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPlay() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onPlay");
                    dispatchAudioEvent(1002);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPrev() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onPrev pid=" + Process.myPid());
                    dispatchAudioEvent(1009);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onSeekEnd() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onSeekEnd pid=" + Process.myPid());
                    dispatchAudioEvent(1011);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onSeeking() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onSeeking pid=" + Process.myPid());
                    dispatchAudioEvent(1012);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onStop() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                    c.a.r0.a.j1.c.d.b("SwanAppAudioClient", "#onStop");
                    dispatchAudioEvent(1004);
                    if (this.this$0.f38832f) {
                        return;
                    }
                    SwanAppAudioClient swanAppAudioClient = this.this$0;
                    swanAppAudioClient.unbindService(swanAppAudioClient.a);
                    this.this$0.f38828b.unregisterListener(this.this$0.l);
                    this.this$0.stopService();
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onTimeUpdate(int i4, int i5) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048588, this, i4, i5) == null) {
                    int r = this.this$0.r() / 1000;
                    int i6 = i4 / 1000;
                    if (SwanAppAudioClient.n) {
                        String str = "onTimeUpdate() duration = " + r + " ; progress = " + i6;
                    }
                    dispatchAudioEvent(1006, r, i6);
                }
            }

            private void dispatchAudioEvent(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(65538, this, i4, i5) == null) {
                    dispatchAudioEvent(i4, i5, 0);
                }
            }

            private void dispatchAudioEvent(int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIII(65539, this, i4, i5, i6) == null) {
                    Message obtain = Message.obtain();
                    obtain.what = i4;
                    obtain.arg1 = i5;
                    obtain.arg2 = i6;
                    q0.e0(new a(this, obtain));
                }
            }
        };
        this.m = new b(this);
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) || this.f38829c) {
            return;
        }
        this.f38829c = true;
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        context.bindService(intent, this.k, 1);
        boolean z = n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindService(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, context) == null) && this.f38829c) {
            this.f38829c = false;
            context.unbindService(this.k);
            boolean z = n;
        }
    }

    public void A(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f38833g = cVar;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f38829c && this.f38830d) {
                    this.f38828b.stop();
                    unbindService(this.a);
                    stopService();
                    this.f38836j = true;
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "audio stop exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.a.j1.c.d.c("SwanAppAudioClient", "#doPlay", new Exception("stack"));
            try {
                if (this.f38829c && this.f38830d) {
                    this.f38828b.setParams(this.f38831e);
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "audio play exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.d("backgroundAudio", "#doPlay error", e2);
            }
        }
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.f38835i) ? "" : this.f38835i : (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.f38829c && this.f38830d && this.f38828b != null) {
                    return this.f38828b.getDuration();
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "get audio duration exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.f38829c && this.f38830d) {
                    return this.f38828b.isPlaying();
                }
                return false;
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "get audio isPlaying exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
            intent.setPackage(o);
            this.a.startService(intent);
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
            intent.setPackage(o);
            this.a.stopService(intent);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f38832f = z;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                if (this.f38829c && this.f38830d) {
                    this.f38828b.pause();
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "audio pause exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.f38831e = str;
            this.f38835i = str2;
            startService();
            if (!this.f38829c) {
                bindService(this.a);
            } else {
                p();
            }
            this.f38836j = false;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            x();
            unbindService(this.a);
            this.f38836j = false;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                if (this.f38829c && this.f38830d) {
                    this.f38828b.release();
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "release audio exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                if (this.f38829c && this.f38830d) {
                    this.f38828b.play();
                } else if (this.f38836j) {
                } else {
                    v(this.f38831e, this.f38835i);
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "audio resume exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            try {
                if (this.f38829c && this.f38830d) {
                    this.f38828b.seek(i2);
                }
            } catch (RemoteException e2) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "audio seek exception, src is:" + this.f38835i, -1, "");
                c.a.r0.a.e0.d.c("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
