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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.media.audio.c;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cjL = AppRuntime.getAppContext().getPackageName();
    private IAudioService cjM;
    private boolean cjN;
    private a cjO;
    private b cjP;
    private String cjQ;
    private Context mContext;
    private boolean mIsConnected;
    private String mParams = "";
    private boolean mIsForeground = true;
    private boolean cjR = false;
    private ServiceConnection cjS = new ServiceConnection() { // from class: com.baidu.swan.apps.media.audio.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.mIsConnected = true;
                c.this.cjM = IAudioService.Stub.asInterface(iBinder);
                c.this.cjM.registerListener(c.this.cjT);
                iBinder.linkToDeath(c.this.cjU, 0);
                c.this.ail();
            } catch (RemoteException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (c.DEBUG) {
                    e.printStackTrace();
                }
            }
            if (c.this.cjP != null) {
                c.this.cjP.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                c.this.mIsConnected = false;
                if (c.this.cjM != null) {
                    c.this.cjM.unregisterListener(c.this.cjT);
                }
            } catch (RemoteException e) {
                com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
                if (c.DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                c.this.cjM = null;
            }
            if (c.this.cjP != null) {
                c.this.cjP.onServiceDisconnected(componentName);
            }
        }
    };
    private final IAudioListener cjT = new IAudioListener.Stub() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2
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
            z = c.this.mIsForeground;
            if (!z) {
                c.this.bX(c.this.mContext);
                c.this.cjM.unregisterListener(c.this.cjT);
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
                z2 = c.this.mIsForeground;
                if (!z2) {
                    str3 = c.this.cjQ;
                    if (!TextUtils.equals(str, str3)) {
                        z3 = true;
                        Log.d("SwanAppAudioClient", append.append(z3).toString());
                    }
                }
                z3 = false;
                Log.d("SwanAppAudioClient", append.append(z3).toString());
            }
            z = c.this.mIsForeground;
            if (!z) {
                str2 = c.this.cjQ;
                if (!TextUtils.equals(str, str2)) {
                    dispatchAudioEvent(1004);
                    c.this.bX(c.this.mContext);
                    c.this.cjM.unregisterListener(c.this.cjT);
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
            dispatchAudioEvent(1006, duration, i3);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onError(int i) throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onError() " + i);
            }
            dispatchAudioEvent(1007, i);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onDownloadProgress(int i) throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onDownloadProgress() " + i);
            }
            dispatchAudioEvent(1008, i);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onPrev() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onPrev()" + Process.myPid());
            }
            dispatchAudioEvent(1009);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onNext() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onNext()" + Process.myPid());
            }
            dispatchAudioEvent(1010);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onSeeking() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onSeeking()" + Process.myPid());
            }
            dispatchAudioEvent(1012);
        }

        @Override // com.baidu.swan.apps.IAudioListener
        public void onSeekEnd() throws RemoteException {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "onSeekEnd()" + Process.myPid());
            }
            dispatchAudioEvent(1011);
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
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.media.audio.SwanAppAudioClient$2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.a aVar;
                    c.a aVar2;
                    aVar = c.this.cjO;
                    if (aVar != null) {
                        aVar2 = c.this.cjO;
                        aVar2.m(obtain);
                    }
                }
            });
        }
    };
    private final IBinder.DeathRecipient cjU = new IBinder.DeathRecipient() { // from class: com.baidu.swan.apps.media.audio.c.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (c.DEBUG) {
                Log.d("SwanAppAudioClient", "binderDied()");
            }
            if (c.this.cjM != null) {
                c.this.cjM.asBinder().unlinkToDeath(c.this.cjU, 0);
                c.this.cjM = null;
                c.this.cjN = false;
                c.this.mIsConnected = false;
                c.this.bW(c.this.mContext);
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        boolean m(Message message);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    public c(Context context) {
        this.mContext = context;
    }

    public void ee(boolean z) {
        this.mIsForeground = z;
    }

    public void startService() {
        Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
        intent.setPackage(cjL);
        this.mContext.startService(intent);
    }

    public void a(a aVar) {
        this.cjO = aVar;
    }

    public void bu(String str, String str2) {
        this.mParams = str;
        this.cjQ = str2;
        startService();
        if (!this.cjN) {
            bW(this.mContext);
        } else {
            ail();
        }
        this.cjR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ail() {
        try {
            if (this.cjN && this.mIsConnected) {
                this.cjM.setParams(this.mParams);
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
            if (this.cjN && this.mIsConnected) {
                this.cjM.play();
            } else if (!this.cjR) {
                bu(this.mParams, this.cjQ);
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
            if (this.cjN && this.mIsConnected) {
                this.cjM.pause();
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
            if (this.cjN && this.mIsConnected) {
                this.cjM.seek(i);
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
            if (this.cjN && this.mIsConnected) {
                this.cjM.stop();
                bX(this.mContext);
                this.cjR = true;
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
            if (this.cjN && this.mIsConnected) {
                return this.cjM.isPlaying();
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
            if (this.cjN && this.mIsConnected) {
                return this.cjM.getDuration();
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private void aim() {
        try {
            if (this.cjN && this.mIsConnected) {
                this.cjM.release();
            }
        } catch (RemoteException e) {
            com.baidu.swan.apps.console.c.e("backgroundAudio", e.toString());
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        aim();
        bX(this.mContext);
        this.cjR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(Context context) {
        if (!this.cjN) {
            this.cjN = true;
            Intent intent = new Intent("com.baidu.swan.apps.action.AUDIO_SERVICE");
            intent.setPackage(cjL);
            context.bindService(intent, this.cjS, 1);
            if (DEBUG) {
                Log.d("SwanAppAudioClient", "bindService()");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(Context context) {
        if (this.cjN) {
            this.cjN = false;
            context.unbindService(this.cjS);
            if (DEBUG) {
                Log.d("SwanAppAudioClient", "unbindService()");
            }
        }
    }
}
