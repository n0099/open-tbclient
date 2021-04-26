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
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class SwanAppAudioClient {
    public static final boolean n = k.f43101a;
    public static final String o = AppRuntime.getAppContext().getPackageName();

    /* renamed from: a  reason: collision with root package name */
    public Context f11743a;

    /* renamed from: b  reason: collision with root package name */
    public IAudioService f11744b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11745c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11746d;

    /* renamed from: g  reason: collision with root package name */
    public c f11749g;

    /* renamed from: h  reason: collision with root package name */
    public d f11750h;

    /* renamed from: i  reason: collision with root package name */
    public String f11751i;

    /* renamed from: e  reason: collision with root package name */
    public String f11747e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f11748f = true;
    public boolean j = false;
    public ServiceConnection k = new a();
    public final IAudioListener l = new IAudioListener.Stub() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient.2

        /* renamed from: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Message f11752e;

            public a(Message message) {
                this.f11752e = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioClient.this.f11749g != null) {
                    SwanAppAudioClient.this.f11749g.a(this.f11752e);
                }
            }
        }

        private void dispatchAudioEvent(int i2) {
            dispatchAudioEvent(i2, 0, 0);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onCanPlay() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onCanPlay() ");
            }
            dispatchAudioEvent(1001);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onChangeSrc(String str) throws RemoteException {
            if (SwanAppAudioClient.n) {
                StringBuilder sb = new StringBuilder();
                sb.append("onChangeSrc() ");
                sb.append((SwanAppAudioClient.this.f11748f || TextUtils.equals(str, SwanAppAudioClient.this.f11751i)) ? false : true);
                Log.d("SwanAppAudioClient", sb.toString());
            }
            if (SwanAppAudioClient.this.f11748f || TextUtils.equals(str, SwanAppAudioClient.this.f11751i)) {
                return;
            }
            dispatchAudioEvent(1004);
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.D(swanAppAudioClient.f11743a);
            SwanAppAudioClient.this.f11744b.unregisterListener(SwanAppAudioClient.this.l);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onDownloadProgress(int i2) throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onDownloadProgress() " + i2);
            }
            dispatchAudioEvent(1008, i2);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onEnded() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onEnded() ");
            }
            dispatchAudioEvent(1005);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onError(int i2) throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onError() " + i2);
            }
            dispatchAudioEvent(1007, i2);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onNext() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onNext()" + Process.myPid());
            }
            dispatchAudioEvent(1010);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPause() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onPause() ");
            }
            dispatchAudioEvent(1003);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPlay() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onPlay() ");
            }
            dispatchAudioEvent(1002);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPrev() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onPrev()" + Process.myPid());
            }
            dispatchAudioEvent(1009);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onSeekEnd() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onSeekEnd()" + Process.myPid());
            }
            dispatchAudioEvent(1011);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onSeeking() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onSeeking()" + Process.myPid());
            }
            dispatchAudioEvent(1012);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onStop() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onStop() ");
            }
            dispatchAudioEvent(1004);
            if (SwanAppAudioClient.this.f11748f) {
                return;
            }
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.D(swanAppAudioClient.f11743a);
            SwanAppAudioClient.this.f11744b.unregisterListener(SwanAppAudioClient.this.l);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onTimeUpdate(int i2, int i3) throws RemoteException {
            int r = SwanAppAudioClient.this.r() / 1000;
            int i4 = i2 / 1000;
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onTimeUpdate() duration = " + r + " ; progress = " + i4);
            }
            dispatchAudioEvent(1006, r, i4);
        }

        private void dispatchAudioEvent(int i2, int i3) {
            dispatchAudioEvent(i2, i3, 0);
        }

        private void dispatchAudioEvent(int i2, int i3, int i4) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = i3;
            obtain.arg2 = i4;
            k0.X(new a(obtain));
        }
    };
    public final IBinder.DeathRecipient m = new b();

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SwanAppAudioClient.this.f11746d = true;
                SwanAppAudioClient.this.f11744b = IAudioService.Stub.asInterface(iBinder);
                SwanAppAudioClient.this.f11744b.registerListener(SwanAppAudioClient.this.l);
                iBinder.linkToDeath(SwanAppAudioClient.this.m, 0);
                SwanAppAudioClient.this.q();
            } catch (RemoteException e2) {
                d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
                if (SwanAppAudioClient.n) {
                    e2.printStackTrace();
                }
            }
            if (SwanAppAudioClient.this.f11750h != null) {
                SwanAppAudioClient.this.f11750h.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                try {
                    SwanAppAudioClient.this.f11746d = false;
                    if (SwanAppAudioClient.this.f11744b != null) {
                        SwanAppAudioClient.this.f11744b.unregisterListener(SwanAppAudioClient.this.l);
                    }
                } catch (RemoteException e2) {
                    d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
                    if (SwanAppAudioClient.n) {
                        e2.printStackTrace();
                    }
                }
                if (SwanAppAudioClient.this.f11750h != null) {
                    SwanAppAudioClient.this.f11750h.onServiceDisconnected(componentName);
                }
            } finally {
                SwanAppAudioClient.this.f11744b = null;
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
            if (SwanAppAudioClient.this.f11744b == null) {
                return;
            }
            SwanAppAudioClient.this.f11744b.asBinder().unlinkToDeath(SwanAppAudioClient.this.m, 0);
            SwanAppAudioClient.this.f11744b = null;
            SwanAppAudioClient.this.f11745c = false;
            SwanAppAudioClient.this.f11746d = false;
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.p(swanAppAudioClient.f11743a);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean a(Message message);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    public SwanAppAudioClient(Context context) {
        this.f11743a = context;
    }

    public void A(c cVar) {
        this.f11749g = cVar;
    }

    public void B() {
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        this.f11743a.startService(intent);
    }

    public void C() {
        try {
            if (this.f11745c && this.f11746d) {
                this.f11744b.stop();
                D(this.f11743a);
                this.j = true;
            }
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public final void D(Context context) {
        if (this.f11745c) {
            this.f11745c = false;
            context.unbindService(this.k);
            if (n) {
                Log.d("SwanAppAudioClient", "unbindService()");
            }
        }
    }

    public final void p(Context context) {
        if (this.f11745c) {
            return;
        }
        this.f11745c = true;
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        context.bindService(intent, this.k, 1);
        if (n) {
            Log.d("SwanAppAudioClient", "bindService()");
        }
    }

    public final void q() {
        try {
            if (this.f11745c && this.f11746d) {
                this.f11744b.setParams(this.f11747e);
            }
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public int r() {
        try {
            if (this.f11745c && this.f11746d) {
                return this.f11744b.getDuration();
            }
            return -1;
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
                return -1;
            }
            return -1;
        }
    }

    public boolean s() {
        try {
            if (this.f11745c && this.f11746d) {
                return this.f11744b.isPlaying();
            }
            return false;
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void t(boolean z) {
        this.f11748f = z;
    }

    public void u() {
        try {
            if (this.f11745c && this.f11746d) {
                this.f11744b.pause();
            }
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public void v(String str, String str2) {
        this.f11747e = str;
        this.f11751i = str2;
        B();
        if (!this.f11745c) {
            p(this.f11743a);
        } else {
            q();
        }
        this.j = false;
    }

    public void w() {
        x();
        D(this.f11743a);
        this.j = false;
    }

    public final void x() {
        try {
            if (this.f11745c && this.f11746d) {
                this.f11744b.release();
            }
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public void y() {
        try {
            if (this.f11745c && this.f11746d) {
                this.f11744b.play();
            } else if (!this.j) {
                v(this.f11747e, this.f11751i);
            }
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public void z(int i2) {
        try {
            if (this.f11745c && this.f11746d) {
                this.f11744b.seek(i2);
            }
        } catch (RemoteException e2) {
            d.a.h0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }
}
