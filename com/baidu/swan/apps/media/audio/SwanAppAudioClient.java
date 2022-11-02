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
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.tieba.e12;
import com.baidu.tieba.hr2;
import com.baidu.tieba.kb3;
import com.baidu.tieba.ok1;
import com.baidu.tieba.vh3;
import com.baidu.tieba.yh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SwanAppAudioClient {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public IAudioService b;
    public boolean c;
    public boolean d;
    public String e;
    public boolean f;
    public c g;
    public d h;
    public String i;
    public boolean j;
    public ServiceConnection k;
    public final IAudioListener l;
    public final IBinder.DeathRecipient m;

    /* loaded from: classes3.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioClient a;

        public a(SwanAppAudioClient swanAppAudioClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioClient;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, componentName, iBinder) != null) {
                return;
            }
            try {
                this.a.d = true;
                this.a.b = IAudioService.Stub.asInterface(iBinder);
                this.a.b.registerListener(this.a.l);
                iBinder.linkToDeath(this.a.m, 0);
                if (!vh3.B()) {
                    this.a.p();
                }
            } catch (RemoteException e) {
                e12.c("backgroundAudio", e.toString());
                if (SwanAppAudioClient.n) {
                    e.printStackTrace();
                }
            }
            if (this.a.h != null) {
                this.a.h.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                try {
                    try {
                        this.a.d = false;
                        if (this.a.b != null) {
                            this.a.b.unregisterListener(this.a.l);
                        }
                    } catch (RemoteException e) {
                        e12.c("backgroundAudio", e.toString());
                        if (SwanAppAudioClient.n) {
                            e.printStackTrace();
                        }
                    }
                    if (this.a.h != null) {
                        this.a.h.onServiceDisconnected(componentName);
                    }
                } finally {
                    this.a.b = null;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioClient a;

        public b(SwanAppAudioClient swanAppAudioClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioClient;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (SwanAppAudioClient.n) {
                    Log.d("SwanAppAudioClient", "binderDied()");
                }
                if (this.a.b == null) {
                    return;
                }
                this.a.b.asBinder().unlinkToDeath(this.a.m, 0);
                this.a.b = null;
                this.a.c = false;
                this.a.d = false;
                SwanAppAudioClient swanAppAudioClient = this.a;
                swanAppAudioClient.bindService(swanAppAudioClient.a);
            }
        }
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
        n = ok1.a;
        o = AppRuntime.getAppContext().getPackageName();
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.i)) {
                return "";
            }
            return this.i;
        }
        return (String) invokeV.objValue;
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

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            x();
            unbindService(this.a);
            this.j = false;
        }
    }

    public SwanAppAudioClient(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = "";
        this.f = true;
        this.j = false;
        this.k = new a(this);
        this.l = new IAudioListener.Stub(this) { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppAudioClient this$0;

            /* renamed from: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Message a;
                public final /* synthetic */ AnonymousClass2 b;

                public a(AnonymousClass2 anonymousClass2, Message message) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {anonymousClass2, message};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = anonymousClass2;
                    this.a = message;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.this$0.g != null) {
                        this.b.this$0.g.a(this.a);
                    }
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void dispatchAudioEvent(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(65537, this, i3) == null) {
                    dispatchAudioEvent(i3, 0, 0);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onDownloadProgress(int i3) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i3) == null) {
                    if (SwanAppAudioClient.n) {
                        Log.d("SwanAppAudioClient", "onDownloadProgress() " + i3);
                    }
                    dispatchAudioEvent(1008, i3);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onError(int i3) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i3) == null) {
                    hr2.b("SwanAppAudioClient", "#onError errCode=" + i3);
                    dispatchAudioEvent(1007, i3);
                }
            }

            private void dispatchAudioEvent(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(65538, this, i3, i4) == null) {
                    dispatchAudioEvent(i3, i4, 0);
                }
            }

            private void dispatchAudioEvent(int i3, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIII(65539, this, i3, i4, i5) == null) {
                    Message obtain = Message.obtain();
                    obtain.what = i3;
                    obtain.arg1 = i4;
                    obtain.arg2 = i5;
                    yh3.e0(new a(this, obtain));
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onCanPlay() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onCanPlay");
                    dispatchAudioEvent(1001);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onEnded() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onEnded");
                    dispatchAudioEvent(1005);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onNext() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onNext pid=" + Process.myPid());
                    dispatchAudioEvent(1010);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPause() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onPause");
                    dispatchAudioEvent(1003);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPlay() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onPlay");
                    dispatchAudioEvent(1002);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onPrev() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onPrev pid=" + Process.myPid());
                    dispatchAudioEvent(1009);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onSeekEnd() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onSeekEnd pid=" + Process.myPid());
                    dispatchAudioEvent(1011);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onSeeking() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048586, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onSeeking pid=" + Process.myPid());
                    dispatchAudioEvent(1012);
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onChangeSrc(String str) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    hr2.b("SwanAppAudioClient", "#onChangeSrc src=" + str + " mCurrentSrc" + this.this$0.i + " mIsForeground=" + this.this$0.f);
                    if (!this.this$0.f && !TextUtils.equals(str, this.this$0.i)) {
                        dispatchAudioEvent(1004);
                        SwanAppAudioClient swanAppAudioClient = this.this$0;
                        swanAppAudioClient.unbindService(swanAppAudioClient.a);
                        this.this$0.b.unregisterListener(this.this$0.l);
                    }
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onStop() throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                    hr2.b("SwanAppAudioClient", "#onStop");
                    dispatchAudioEvent(1004);
                    if (!this.this$0.f) {
                        SwanAppAudioClient swanAppAudioClient = this.this$0;
                        swanAppAudioClient.unbindService(swanAppAudioClient.a);
                        this.this$0.b.unregisterListener(this.this$0.l);
                        this.this$0.stopService();
                    }
                }
            }

            @Override // com.baidu.swan.apps.IAudioListener
            public void onTimeUpdate(int i3, int i4) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048588, this, i3, i4) == null) {
                    int r = this.this$0.r() / 1000;
                    int i5 = i3 / 1000;
                    if (SwanAppAudioClient.n) {
                        Log.d("SwanAppAudioClient", "onTimeUpdate() duration = " + r + " ; progress = " + i5);
                    }
                    dispatchAudioEvent(1006, r, i5);
                }
            }
        };
        this.m = new b(this);
        this.a = context;
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            try {
                if (this.c && this.d) {
                    this.b.seek(i);
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "audio seek exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.e = str;
            this.i = str2;
            startService();
            if (!this.c) {
                bindService(this.a);
            } else {
                p();
            }
            this.j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindService(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, context) == null) && this.c) {
            this.c = false;
            context.unbindService(this.k);
            if (n) {
                Log.d("SwanAppAudioClient", "unbindService()");
            }
        }
    }

    public void A(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.g = cVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) != null) || this.c) {
            return;
        }
        this.c = true;
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        context.bindService(intent, this.k, 1);
        if (n) {
            Log.d("SwanAppAudioClient", "bindService()");
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.c && this.d) {
                    this.b.stop();
                    unbindService(this.a);
                    stopService();
                    this.j = true;
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "audio stop exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hr2.c("SwanAppAudioClient", "#doPlay", new Exception("stack"));
            try {
                if (this.c && this.d) {
                    this.b.setParams(this.e);
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "audio play exception, src is:" + this.i, -1, "");
                e12.d("backgroundAudio", "#doPlay error", e);
            }
        }
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.c && this.d && this.b != null) {
                    return this.b.getDuration();
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "get audio duration exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
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
                if (this.c && this.d) {
                    return this.b.isPlaying();
                }
                return false;
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "get audio isPlaying exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                if (this.c && this.d) {
                    this.b.pause();
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "audio pause exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                if (this.c && this.d) {
                    this.b.release();
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "release audio exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                if (this.c && this.d) {
                    this.b.play();
                } else if (!this.j) {
                    v(this.e, this.i);
                }
            } catch (RemoteException e) {
                kb3.b("audio", UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, "audio resume exception, src is:" + this.i, -1, "");
                e12.c("backgroundAudio", e.toString());
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }
}
