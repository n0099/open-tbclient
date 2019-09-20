package com.baidu.swan.apps.media.audio;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.media.audio.c;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String aBM = AppRuntime.getAppContext().getPackageName();
    private IAudioService aBN;
    private boolean aBO;
    private boolean aBP;
    private a aBQ;
    private b aBR;
    private String aBS;
    private Context mContext;
    private String mParams = "";
    private boolean asA = true;
    private boolean aBT = false;
    private ServiceConnection aBU = new ServiceConnection() { // from class: com.baidu.swan.apps.media.audio.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.aBP = true;
                c.this.aBN = IAudioService.Stub.asInterface(iBinder);
                c.this.aBN.registerListener(c.this.aBV);
                iBinder.linkToDeath(c.this.aBW, 0);
                c.this.GW();
            } catch (RemoteException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (c.DEBUG) {
                    e.printStackTrace();
                }
            }
            if (c.this.aBR != null) {
                c.this.aBR.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                c.this.aBP = false;
                c.this.aBN.unregisterListener(c.this.aBV);
            } catch (RemoteException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (c.DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                c.this.aBN = null;
            }
            if (c.this.aBR != null) {
                c.this.aBR.onServiceDisconnected(componentName);
            }
        }
    };
    private final IAudioListener aBV = new IAudioListener.Stub() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2
        @Override // com.baidu.swan.apps.IAudioListener
        public void onCanPlay() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onCanPlay() ");
            }
            dispatchAudioEvent(1001);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPlay() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onPlay() ");
            }
            dispatchAudioEvent(1002);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPause() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onPause() ");
            }
            dispatchAudioEvent(1003);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onStop() throws RemoteException {
            boolean z;
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onStop() ");
            }
            dispatchAudioEvent(1004);
            z = c.this.asA;
            if (!z) {
                c.this.bm(c.this.mContext);
                c.this.aBN.unregisterListener(c.this.aBV);
            }
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onEnded() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onEnded() ");
            }
            dispatchAudioEvent(1005);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onChangeSrc(String str) throws RemoteException {
            boolean z;
            String str2;
            boolean z2;
            boolean z3;
            String str3;
            if (c.DEBUG) {
                StringBuilder append = new StringBuilder().append("onChangeSrc() ");
                z2 = c.this.asA;
                if (!z2) {
                    str3 = c.this.aBS;
                    if (!TextUtils.equals(str, str3)) {
                        z3 = true;
                        Log.d("SwanAppAudioClient", append.append(z3).toString());
                    }
                }
                z3 = false;
                Log.d("SwanAppAudioClient", append.append(z3).toString());
            }
            dispatchAudioEvent(1004);
            z = c.this.asA;
            if (!z) {
                str2 = c.this.aBS;
                if (!TextUtils.equals(str, str2)) {
                    c.this.bm(c.this.mContext);
                    c.this.aBN.unregisterListener(c.this.aBV);
                }
            }
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onTimeUpdate(int i, int i2) throws RemoteException {
            int duration = c.this.getDuration() / 1000;
            int i3 = i / 1000;
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onTimeUpdate() duration = " + duration + " ; progress = " + i3);
            }
            dispatchAudioEvent(PointerIconCompat.TYPE_CELL, duration, i3);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onError(int i) throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onError() " + i);
            }
            dispatchAudioEvent(PointerIconCompat.TYPE_CROSSHAIR, i);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onDownloadProgress(int i) throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onDownloadProgress() " + i);
            }
            dispatchAudioEvent(PointerIconCompat.TYPE_TEXT, i);
        }

        private void dispatchAudioEvent(int i) {
            dispatchAudioEvent(i, 0, 0);
        }

        private void dispatchAudioEvent(int i, int i2) {
            dispatchAudioEvent(i, i2, 0);
        }

        private void dispatchAudioEvent(int i, int i2, int i3) {
            final Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = i2;
            obtain.arg2 = i3;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.a aVar;
                    c.a aVar2;
                    aVar = c.this.aBQ;
                    if (aVar != null) {
                        aVar2 = c.this.aBQ;
                        aVar2.j(obtain);
                    }
                }
            });
        }
    };
    private final IBinder.DeathRecipient aBW = new IBinder.DeathRecipient() { // from class: com.baidu.swan.apps.media.audio.c.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "binderDied()");
            }
            if (c.this.aBN != null) {
                c.this.aBN.asBinder().unlinkToDeath(c.this.aBW, 0);
                c.this.aBN = null;
                c.this.aBO = false;
                c.this.aBP = false;
                c.this.bl(c.this.mContext);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        boolean j(Message message);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void bw(boolean z) {
        this.asA = z;
    }

    public void startService() {
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(aBM);
        this.mContext.startService(intent);
    }

    public void a(a aVar) {
        this.aBQ = aVar;
    }

    public void an(String str, String str2) {
        this.mParams = str;
        this.aBS = str2;
        startService();
        if (!this.aBO) {
            bl(this.mContext);
        } else {
            GW();
        }
        this.aBT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW() {
        try {
            if (this.aBO && this.aBP) {
                this.aBN.setParams(this.mParams);
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void resume() {
        try {
            if (this.aBO && this.aBP) {
                this.aBN.play();
            } else if (!this.aBT) {
                an(this.mParams, this.aBS);
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        try {
            if (this.aBO && this.aBP) {
                this.aBN.pause();
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void seek(int i) {
        try {
            if (this.aBO && this.aBP) {
                this.aBN.seek(i);
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            if (this.aBO && this.aBP) {
                this.aBN.stop();
                bm(this.mContext);
                this.aBT = true;
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public boolean isPlaying() {
        try {
            if (this.aBO && this.aBP) {
                return this.aBN.isPlaying();
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int getDuration() {
        try {
            if (this.aBO && this.aBP) {
                return this.aBN.getDuration();
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private void releaseAudio() {
        try {
            if (this.aBO && this.aBP) {
                this.aBN.release();
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        releaseAudio();
        bm(this.mContext);
        this.aBT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(Context context) {
        if (!this.aBO) {
            this.aBO = true;
            Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
            intent.setPackage(aBM);
            context.bindService(intent, this.aBU, 1);
            if (DEBUG) {
                Log.d("SwanAppAudioClient", "bindService()");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(Context context) {
        if (this.aBO) {
            this.aBO = false;
            context.unbindService(this.aBU);
            if (DEBUG) {
                Log.d("SwanAppAudioClient", "unbindService()");
            }
        }
    }
}
