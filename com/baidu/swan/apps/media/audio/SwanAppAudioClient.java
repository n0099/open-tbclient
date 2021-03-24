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
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class SwanAppAudioClient {
    public static final boolean n = k.f45050a;
    public static final String o = AppRuntime.getAppContext().getPackageName();

    /* renamed from: a  reason: collision with root package name */
    public Context f12237a;

    /* renamed from: b  reason: collision with root package name */
    public IAudioService f12238b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12239c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12240d;

    /* renamed from: g  reason: collision with root package name */
    public c f12243g;

    /* renamed from: h  reason: collision with root package name */
    public d f12244h;
    public String i;

    /* renamed from: e  reason: collision with root package name */
    public String f12241e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f12242f = true;
    public boolean j = false;
    public ServiceConnection k = new a();
    public final IAudioListener l = new IAudioListener.Stub() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient.2

        /* renamed from: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Message f12245e;

            public a(Message message) {
                this.f12245e = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppAudioClient.this.f12243g != null) {
                    SwanAppAudioClient.this.f12243g.a(this.f12245e);
                }
            }
        }

        private void dispatchAudioEvent(int i) {
            dispatchAudioEvent(i, 0, 0);
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
                sb.append((SwanAppAudioClient.this.f12242f || TextUtils.equals(str, SwanAppAudioClient.this.i)) ? false : true);
                Log.d("SwanAppAudioClient", sb.toString());
            }
            if (SwanAppAudioClient.this.f12242f || TextUtils.equals(str, SwanAppAudioClient.this.i)) {
                return;
            }
            dispatchAudioEvent(1004);
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.D(swanAppAudioClient.f12237a);
            SwanAppAudioClient.this.f12238b.unregisterListener(SwanAppAudioClient.this.l);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onDownloadProgress(int i) throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onDownloadProgress() " + i);
            }
            dispatchAudioEvent(1008, i);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onEnded() throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onEnded() ");
            }
            dispatchAudioEvent(1005);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onError(int i) throws RemoteException {
            if (SwanAppAudioClient.n) {
                Log.d("SwanAppAudioClient", "onError() " + i);
            }
            dispatchAudioEvent(1007, i);
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
            if (SwanAppAudioClient.this.f12242f) {
                return;
            }
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.D(swanAppAudioClient.f12237a);
            SwanAppAudioClient.this.f12238b.unregisterListener(SwanAppAudioClient.this.l);
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

        private void dispatchAudioEvent(int i, int i2) {
            dispatchAudioEvent(i, i2, 0);
        }

        private void dispatchAudioEvent(int i, int i2, int i3) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
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
                SwanAppAudioClient.this.f12240d = true;
                SwanAppAudioClient.this.f12238b = IAudioService.Stub.asInterface(iBinder);
                SwanAppAudioClient.this.f12238b.registerListener(SwanAppAudioClient.this.l);
                iBinder.linkToDeath(SwanAppAudioClient.this.m, 0);
                SwanAppAudioClient.this.q();
            } catch (RemoteException e2) {
                d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
                if (SwanAppAudioClient.n) {
                    e2.printStackTrace();
                }
            }
            if (SwanAppAudioClient.this.f12244h != null) {
                SwanAppAudioClient.this.f12244h.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                try {
                    SwanAppAudioClient.this.f12240d = false;
                    if (SwanAppAudioClient.this.f12238b != null) {
                        SwanAppAudioClient.this.f12238b.unregisterListener(SwanAppAudioClient.this.l);
                    }
                } catch (RemoteException e2) {
                    d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
                    if (SwanAppAudioClient.n) {
                        e2.printStackTrace();
                    }
                }
                if (SwanAppAudioClient.this.f12244h != null) {
                    SwanAppAudioClient.this.f12244h.onServiceDisconnected(componentName);
                }
            } finally {
                SwanAppAudioClient.this.f12238b = null;
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
            if (SwanAppAudioClient.this.f12238b == null) {
                return;
            }
            SwanAppAudioClient.this.f12238b.asBinder().unlinkToDeath(SwanAppAudioClient.this.m, 0);
            SwanAppAudioClient.this.f12238b = null;
            SwanAppAudioClient.this.f12239c = false;
            SwanAppAudioClient.this.f12240d = false;
            SwanAppAudioClient swanAppAudioClient = SwanAppAudioClient.this;
            swanAppAudioClient.p(swanAppAudioClient.f12237a);
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
        this.f12237a = context;
    }

    public void A(c cVar) {
        this.f12243g = cVar;
    }

    public void B() {
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        this.f12237a.startService(intent);
    }

    public void C() {
        try {
            if (this.f12239c && this.f12240d) {
                this.f12238b.stop();
                D(this.f12237a);
                this.j = true;
            }
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public final void D(Context context) {
        if (this.f12239c) {
            this.f12239c = false;
            context.unbindService(this.k);
            if (n) {
                Log.d("SwanAppAudioClient", "unbindService()");
            }
        }
    }

    public final void p(Context context) {
        if (this.f12239c) {
            return;
        }
        this.f12239c = true;
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(o);
        context.bindService(intent, this.k, 1);
        if (n) {
            Log.d("SwanAppAudioClient", "bindService()");
        }
    }

    public final void q() {
        try {
            if (this.f12239c && this.f12240d) {
                this.f12238b.setParams(this.f12241e);
            }
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public int r() {
        try {
            if (this.f12239c && this.f12240d) {
                return this.f12238b.getDuration();
            }
            return -1;
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
                return -1;
            }
            return -1;
        }
    }

    public boolean s() {
        try {
            if (this.f12239c && this.f12240d) {
                return this.f12238b.isPlaying();
            }
            return false;
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void t(boolean z) {
        this.f12242f = z;
    }

    public void u() {
        try {
            if (this.f12239c && this.f12240d) {
                this.f12238b.pause();
            }
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public void v(String str, String str2) {
        this.f12241e = str;
        this.i = str2;
        B();
        if (!this.f12239c) {
            p(this.f12237a);
        } else {
            q();
        }
        this.j = false;
    }

    public void w() {
        x();
        D(this.f12237a);
        this.j = false;
    }

    public final void x() {
        try {
            if (this.f12239c && this.f12240d) {
                this.f12238b.release();
            }
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public void y() {
        try {
            if (this.f12239c && this.f12240d) {
                this.f12238b.play();
            } else if (!this.j) {
                v(this.f12241e, this.i);
            }
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }

    public void z(int i) {
        try {
            if (this.f12239c && this.f12240d) {
                this.f12238b.seek(i);
            }
        } catch (RemoteException e2) {
            d.b.g0.a.c0.c.b("backgroundAudio", e2.toString());
            if (n) {
                e2.printStackTrace();
            }
        }
    }
}
