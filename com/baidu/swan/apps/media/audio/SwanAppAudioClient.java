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
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
/* loaded from: classes8.dex */
public class SwanAppAudioClient {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f43719a;

    /* renamed from: b  reason: collision with root package name */
    public IAudioService f43720b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43721c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43722d;

    /* renamed from: e  reason: collision with root package name */
    public String f43723e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43724f;

    /* renamed from: g  reason: collision with root package name */
    public c f43725g;

    /* renamed from: h  reason: collision with root package name */
    public d f43726h;

    /* renamed from: i  reason: collision with root package name */
    public String f43727i;
    public boolean j;
    public ServiceConnection k;
    public final IAudioListener l;
    public final IBinder.DeathRecipient m;

    /* loaded from: classes8.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioClient f43730e;

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
            this.f43730e = swanAppAudioClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.f43730e.f43722d = true;
                    this.f43730e.f43720b = IAudioService.Stub.asInterface(iBinder);
                    this.f43730e.f43720b.registerListener(this.f43730e.l);
                    iBinder.linkToDeath(this.f43730e.m, 0);
                    this.f43730e.p();
                } catch (RemoteException e2) {
                    b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                    if (SwanAppAudioClient.n) {
                        e2.printStackTrace();
                    }
                }
                if (this.f43730e.f43726h != null) {
                    this.f43730e.f43726h.onServiceConnected(componentName, iBinder);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                try {
                    try {
                        this.f43730e.f43722d = false;
                        if (this.f43730e.f43720b != null) {
                            this.f43730e.f43720b.unregisterListener(this.f43730e.l);
                        }
                    } catch (RemoteException e2) {
                        b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                        if (SwanAppAudioClient.n) {
                            e2.printStackTrace();
                        }
                    }
                    if (this.f43730e.f43726h != null) {
                        this.f43730e.f43726h.onServiceDisconnected(componentName);
                    }
                } finally {
                    this.f43730e.f43720b = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioClient f43731e;

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
            this.f43731e = swanAppAudioClient;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = SwanAppAudioClient.n;
                if (this.f43731e.f43720b == null) {
                    return;
                }
                this.f43731e.f43720b.asBinder().unlinkToDeath(this.f43731e.m, 0);
                this.f43731e.f43720b = null;
                this.f43731e.f43721c = false;
                this.f43731e.f43722d = false;
                SwanAppAudioClient swanAppAudioClient = this.f43731e;
                swanAppAudioClient.bindService(swanAppAudioClient.f43719a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes8.dex */
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
        n = k.f6397a;
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
        this.f43723e = "";
        this.f43724f = true;
        this.j = false;
        this.k = new a(this);
        this.l = new IAudioListener.Stub(this) { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppAudioClient this$0;

            /* renamed from: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2$a */
            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Message f43728e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ AnonymousClass2 f43729f;

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
                    this.f43729f = anonymousClass2;
                    this.f43728e = message;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43729f.this$0.f43725g == null) {
                        return;
                    }
                    this.f43729f.this$0.f43725g.a(this.f43728e);
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
                    boolean unused = SwanAppAudioClient.n;
                    dispatchAudioEvent(1001);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onChangeSrc(String str) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    if (SwanAppAudioClient.n) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onChangeSrc() ");
                        sb.append((this.this$0.f43724f || TextUtils.equals(str, this.this$0.f43727i)) ? false : true);
                        sb.toString();
                    }
                    if (this.this$0.f43724f || TextUtils.equals(str, this.this$0.f43727i)) {
                        return;
                    }
                    dispatchAudioEvent(1004);
                    SwanAppAudioClient swanAppAudioClient = this.this$0;
                    swanAppAudioClient.unbindService(swanAppAudioClient.f43719a);
                    this.this$0.f43720b.unregisterListener(this.this$0.l);
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
                    boolean unused = SwanAppAudioClient.n;
                    dispatchAudioEvent(1005);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onError(int i4) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                    if (SwanAppAudioClient.n) {
                        String str = "onError() " + i4;
                    }
                    dispatchAudioEvent(1007, i4);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onNext() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    if (SwanAppAudioClient.n) {
                        String str = "onNext()" + Process.myPid();
                    }
                    dispatchAudioEvent(1010);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPause() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    boolean unused = SwanAppAudioClient.n;
                    dispatchAudioEvent(1003);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPlay() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    boolean unused = SwanAppAudioClient.n;
                    dispatchAudioEvent(1002);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPrev() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    if (SwanAppAudioClient.n) {
                        String str = "onPrev()" + Process.myPid();
                    }
                    dispatchAudioEvent(1009);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onSeekEnd() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                    if (SwanAppAudioClient.n) {
                        String str = "onSeekEnd()" + Process.myPid();
                    }
                    dispatchAudioEvent(1011);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onSeeking() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                    if (SwanAppAudioClient.n) {
                        String str = "onSeeking()" + Process.myPid();
                    }
                    dispatchAudioEvent(1012);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onStop() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                    boolean unused = SwanAppAudioClient.n;
                    dispatchAudioEvent(1004);
                    if (this.this$0.f43724f) {
                        return;
                    }
                    SwanAppAudioClient swanAppAudioClient = this.this$0;
                    swanAppAudioClient.unbindService(swanAppAudioClient.f43719a);
                    this.this$0.f43720b.unregisterListener(this.this$0.l);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onTimeUpdate(int i4, int i5) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048588, this, i4, i5) == null) {
                    int q = this.this$0.q() / 1000;
                    int i6 = i4 / 1000;
                    if (SwanAppAudioClient.n) {
                        String str = "onTimeUpdate() duration = " + q + " ; progress = " + i6;
                    }
                    dispatchAudioEvent(1006, q, i6);
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
                    q0.b0(new a(this, obtain));
                }
            }
        };
        this.m = new b(this);
        this.f43719a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) || this.f43721c) {
            return;
        }
        this.f43721c = true;
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        context.bindService(intent, this.k, 1);
        boolean z = n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindService(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, context) == null) && this.f43721c) {
            this.f43721c = false;
            context.unbindService(this.k);
            boolean z = n;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    this.f43720b.stop();
                    unbindService(this.f43719a);
                    this.j = true;
                }
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    this.f43720b.setParams(this.f43723e);
                }
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.f43721c && this.f43722d && this.f43720b != null) {
                    return this.f43720b.getDuration();
                }
                return -1;
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                    return -1;
                }
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    return this.f43720b.isPlaying();
                }
                return false;
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f43724f = z;
        }
    }

    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
            intent.setPackage(o);
            this.f43719a.startService(intent);
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
            intent.setPackage(o);
            this.f43719a.stopService(intent);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    this.f43720b.pause();
                }
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            this.f43723e = str;
            this.f43727i = str2;
            startService();
            if (!this.f43721c) {
                bindService(this.f43719a);
            } else {
                p();
            }
            this.j = false;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            w();
            unbindService(this.f43719a);
            this.j = false;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    this.f43720b.release();
                }
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    this.f43720b.play();
                } else if (this.j) {
                } else {
                    u(this.f43723e, this.f43727i);
                }
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            try {
                if (this.f43721c && this.f43722d) {
                    this.f43720b.seek(i2);
                }
            } catch (RemoteException e2) {
                b.a.p0.a.e0.d.b("backgroundAudio", e2.toString());
                if (n) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void z(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f43725g = cVar;
        }
    }
}
