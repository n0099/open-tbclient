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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.tieba.af3;
import com.baidu.tieba.eo1;
import com.baidu.tieba.ll3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.u42;
import com.baidu.tieba.xu2;
/* loaded from: classes3.dex */
public class SwanAppAudioClient {
    public static final boolean n = eo1.a;
    public static final String o = AppRuntime.getAppContext().getPackageName();
    public Context a;
    public IAudioService b;
    public boolean c;
    public boolean d;
    public c g;
    public d h;
    public String i;
    public String e = "";
    public boolean f = true;
    public boolean j = false;
    public ServiceConnection k = new a();
    public final IAudioListener l = new IAudioListener.Stub() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient.2

        /* renamed from: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public final /* synthetic */ Message a;

            public a(Message message) {
                this.a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioClient.this.g != null) {
                    SwanAppAudioClient.this.g.a(this.a);
                }
            }
        }

        private void dispatchAudioEvent(int i) {
            dispatchAudioEvent(i, 0, 0);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onDownloadProgress(int i) throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onDownloadProgress() " + i);
            }
            dispatchAudioEvent(1008, i);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onError(int i) throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onError errCode=" + i);
            dispatchAudioEvent(1007, i);
        }

        private void dispatchAudioEvent(int i, int i2) {
            dispatchAudioEvent(i, i2, 0);
        }

        private void dispatchAudioEvent(int i, int i2, int i3) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            ol3.e0(new a(obtain));
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onCanPlay() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onCanPlay");
            dispatchAudioEvent(1001);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onEnded() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onEnded");
            dispatchAudioEvent(1005);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onNext() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onNext pid=" + Process.myPid());
            dispatchAudioEvent(1010);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPause() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onPause");
            dispatchAudioEvent(1003);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPlay() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onPlay");
            dispatchAudioEvent(1002);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPrev() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onPrev pid=" + Process.myPid());
            dispatchAudioEvent(1009);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onSeekEnd() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onSeekEnd pid=" + Process.myPid());
            dispatchAudioEvent(1011);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onSeeking() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onSeeking pid=" + Process.myPid());
            dispatchAudioEvent(1012);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onStop() throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onStop");
            dispatchAudioEvent(1004);
            if (!SwanAppAudioClient.this.f) {
                SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
                swanAppAudioClient.unbindService(swanAppAudioClient.a);
                SwanAppAudioClient.this.b.unregisterListener(SwanAppAudioClient.this.l);
                SwanAppAudioClient.this.stopService();
            }
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onChangeSrc(String str) throws RemoteException {
            xu2.b("SwanAppAudioClient", "#onChangeSrc src=" + str + " mCurrentSrc" + SwanAppAudioClient.this.i + " mIsForeground=" + SwanAppAudioClient.this.f);
            if (!SwanAppAudioClient.this.f && !TextUtils.equals(str, SwanAppAudioClient.this.i)) {
                dispatchAudioEvent(1004);
                SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
                swanAppAudioClient.unbindService(swanAppAudioClient.a);
                SwanAppAudioClient.this.b.unregisterListener(SwanAppAudioClient.this.l);
            }
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onTimeUpdate(int i, int i2) throws RemoteException {
            int r = SwanAppAudioClient.this.r() / 1000;
            int i3 = i / 1000;
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onTimeUpdate() duration = " + r + " ; progress = " + i3);
            }
            dispatchAudioEvent(1006, r, i3);
        }
    };
    public final IBinder.DeathRecipient m = new b();

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
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SwanAppAudioClient.this.d = true;
                SwanAppAudioClient.this.b = IAudioService.Stub.asInterface(iBinder);
                SwanAppAudioClient.this.b.registerListener(SwanAppAudioClient.this.l);
                iBinder.linkToDeath(SwanAppAudioClient.this.m, 0);
                if (!ll3.B()) {
                    SwanAppAudioClient.this.p();
                }
            } catch (RemoteException e) {
                u42.c("backgroundAudio", e.toString());
                if (SwanAppAudioClient.n) {
                    e.printStackTrace();
                }
            }
            if (SwanAppAudioClient.this.h != null) {
                SwanAppAudioClient.this.h.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                try {
                    SwanAppAudioClient.this.d = false;
                    if (SwanAppAudioClient.this.b != null) {
                        SwanAppAudioClient.this.b.unregisterListener(SwanAppAudioClient.this.l);
                    }
                } catch (RemoteException e) {
                    u42.c("backgroundAudio", e.toString());
                    if (SwanAppAudioClient.n) {
                        e.printStackTrace();
                    }
                }
                if (SwanAppAudioClient.this.h != null) {
                    SwanAppAudioClient.this.h.onServiceDisconnected(componentName);
                }
            } finally {
                SwanAppAudioClient.this.b = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements IBinder.DeathRecipient {
        public b() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "binderDied()");
            }
            if (SwanAppAudioClient.this.b == null) {
                return;
            }
            SwanAppAudioClient.this.b.asBinder().unlinkToDeath(SwanAppAudioClient.this.m, 0);
            SwanAppAudioClient.this.b = null;
            SwanAppAudioClient.this.c = false;
            SwanAppAudioClient.this.d = false;
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.bindService(swanAppAudioClient.a);
        }
    }

    public String q() {
        if (TextUtils.isEmpty(this.i)) {
            return "";
        }
        return this.i;
    }

    public void startService() {
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        this.a.startService(intent);
    }

    public void stopService() {
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        this.a.stopService(intent);
    }

    public void w() {
        x();
        unbindService(this.a);
        this.j = false;
    }

    public SwanAppAudioClient(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(Context context) {
        if (this.c) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindService(Context context) {
        if (this.c) {
            this.c = false;
            context.unbindService(this.k);
            if (n) {
                Log.d("SwanAppAudioClient", "unbindService()");
            }
        }
    }

    public void A(c cVar) {
        this.g = cVar;
    }

    public void t(boolean z) {
        this.f = z;
    }

    public void v(String str, String str2) {
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

    public void B() {
        try {
            if (this.c && this.d) {
                this.b.stop();
                unbindService(this.a);
                stopService();
                this.j = true;
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "audio stop exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
            }
        }
    }

    public void y() {
        try {
            if (this.c && this.d) {
                this.b.play();
            } else if (!this.j) {
                v(this.e, this.i);
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "audio resume exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
            }
        }
    }

    public final void p() {
        xu2.c("SwanAppAudioClient", "#doPlay", new Exception("stack"));
        try {
            if (this.c && this.d) {
                this.b.setParams(this.e);
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "audio play exception, src is:" + this.i, -1, "");
            u42.d("backgroundAudio", "#doPlay error", e);
        }
    }

    public int r() {
        try {
            if (this.c && this.d && this.b != null) {
                return this.b.getDuration();
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "get audio duration exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public boolean s() {
        try {
            if (this.c && this.d) {
                return this.b.isPlaying();
            }
            return false;
        } catch (RemoteException e) {
            af3.b("audio", 2009, "get audio isPlaying exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void u() {
        try {
            if (this.c && this.d) {
                this.b.pause();
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "audio pause exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
            }
        }
    }

    public final void x() {
        try {
            if (this.c && this.d) {
                this.b.release();
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "release audio exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
            }
        }
    }

    public void z(int i) {
        try {
            if (this.c && this.d) {
                this.b.seek(i);
            }
        } catch (RemoteException e) {
            af3.b("audio", 2009, "audio seek exception, src is:" + this.i, -1, "");
            u42.c("backgroundAudio", e.toString());
            if (n) {
                e.printStackTrace();
            }
        }
    }
}
