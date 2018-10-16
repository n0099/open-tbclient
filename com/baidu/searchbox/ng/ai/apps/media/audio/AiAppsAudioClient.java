package com.baidu.searchbox.ng.ai.apps.media.audio;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.IAudioListener;
import com.baidu.searchbox.ng.ai.apps.IAudioService;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
/* loaded from: classes2.dex */
public class AiAppsAudioClient {
    private static final String ACTION_AUDIO = "com.baidu.searchbox.ng.ai.apps.action.AUDIO_SERVICE";
    private static final boolean DEBUG = false;
    private static final int INVALID_DURATION = -1;
    private static final String MODULE_TAG = "backgroundAudio";
    private static final String PKG_NAME = "com.baidu.searchbox";
    private static final int SECOND_IN_MILLS = 1000;
    private static final String TAG = "AiAppsAudioClient";
    private Context mContext;
    private String mCurrentSrc;
    private IAudioService mIAudioService;
    private boolean mIsBound;
    private boolean mIsConnected;
    private boolean mIsForeground;
    private OnMessageCallback mMessageCallback;
    private String mParams;
    private OnServiceStatusCallback mServiceCallback;
    private ServiceConnection mServiceConn = new ServiceConnection() { // from class: com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioClient.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                AiAppsAudioClient.this.mIsConnected = true;
                AiAppsAudioClient.this.mIAudioService = IAudioService.Stub.asInterface(iBinder);
                AiAppsAudioClient.this.mIAudioService.registerListener(AiAppsAudioClient.this.mIAudioListener);
                iBinder.linkToDeath(AiAppsAudioClient.this.mDeathRecipient, 0);
                AiAppsAudioClient.this.doPlay();
            } catch (RemoteException e) {
                AiAppsLog.e(AiAppsAudioClient.MODULE_TAG, e.toString());
            }
            if (AiAppsAudioClient.this.mServiceCallback != null) {
                AiAppsAudioClient.this.mServiceCallback.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                AiAppsAudioClient.this.mIsConnected = false;
                AiAppsAudioClient.this.mIAudioService.unregisterListener(AiAppsAudioClient.this.mIAudioListener);
            } catch (RemoteException e) {
                AiAppsLog.e(AiAppsAudioClient.MODULE_TAG, e.toString());
            } finally {
                AiAppsAudioClient.this.mIAudioService = null;
            }
            if (AiAppsAudioClient.this.mServiceCallback != null) {
                AiAppsAudioClient.this.mServiceCallback.onServiceDisconnected(componentName);
            }
        }
    };
    private final IAudioListener mIAudioListener = new IAudioListener.Stub() { // from class: com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioClient.2
        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onCanPlay() throws RemoteException {
            dispatchAudioEvent(1001);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onPlay() throws RemoteException {
            dispatchAudioEvent(1002);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onPause() throws RemoteException {
            dispatchAudioEvent(1003);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onStop() throws RemoteException {
            dispatchAudioEvent(1004);
            if (!AiAppsAudioClient.this.mIsForeground) {
                AiAppsAudioClient.this.unbindService(AiAppsAudioClient.this.mContext);
                AiAppsAudioClient.this.mIAudioService.unregisterListener(AiAppsAudioClient.this.mIAudioListener);
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onEnded() throws RemoteException {
            dispatchAudioEvent(1005);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onChangeSrc(String str) throws RemoteException {
            dispatchAudioEvent(1004);
            if (!AiAppsAudioClient.this.mIsForeground && !TextUtils.equals(str, AiAppsAudioClient.this.mCurrentSrc)) {
                AiAppsAudioClient.this.unbindService(AiAppsAudioClient.this.mContext);
                AiAppsAudioClient.this.mIAudioService.unregisterListener(AiAppsAudioClient.this.mIAudioListener);
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onTimeUpdate(int i, int i2) throws RemoteException {
            dispatchAudioEvent(1006, AiAppsAudioClient.this.getDuration() / 1000, i / 1000);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onError(int i) throws RemoteException {
            dispatchAudioEvent(1007, i);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.IAudioListener
        public void onDownloadProgress(int i) throws RemoteException {
            dispatchAudioEvent(1008, i);
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
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioClient.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AiAppsAudioClient.this.mMessageCallback != null) {
                        AiAppsAudioClient.this.mMessageCallback.onHandleMessage(obtain);
                    }
                }
            });
        }
    };
    private final IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioClient.3
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (AiAppsAudioClient.this.mIAudioService != null) {
                AiAppsAudioClient.this.mIAudioService.asBinder().unlinkToDeath(AiAppsAudioClient.this.mDeathRecipient, 0);
                AiAppsAudioClient.this.mIAudioService = null;
                AiAppsAudioClient.this.mIsBound = false;
                AiAppsAudioClient.this.mIsConnected = false;
                AiAppsAudioClient.this.bindService(AiAppsAudioClient.this.mContext);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface OnMessageCallback {
        public static final int EVENT_ONCANPLAY = 1001;
        public static final int EVENT_ONDOWNLOAD_PROGRESS = 1008;
        public static final int EVENT_ONEND = 1005;
        public static final int EVENT_ONERROR = 1007;
        public static final int EVENT_ONPAUSE = 1003;
        public static final int EVENT_ONPLAY = 1002;
        public static final int EVENT_ONSTOP = 1004;
        public static final int EVENT_ONTIME_UPDATE = 1006;

        boolean onHandleMessage(Message message);
    }

    /* loaded from: classes2.dex */
    public interface OnServiceStatusCallback {
        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);
    }

    public AiAppsAudioClient(Context context) {
        this.mContext = context;
    }

    public void onForegroundChanged(boolean z) {
        this.mIsForeground = z;
    }

    public void startService() {
        Intent intent = new Intent(ACTION_AUDIO);
        intent.setPackage("com.baidu.searchbox");
        this.mContext.startService(intent);
    }

    public void stopService() {
        Intent intent = new Intent(ACTION_AUDIO);
        intent.setPackage("com.baidu.searchbox");
        this.mContext.stopService(intent);
    }

    public void setMessageCallback(OnMessageCallback onMessageCallback) {
        this.mMessageCallback = onMessageCallback;
    }

    public void setServiceStatusCallback(OnServiceStatusCallback onServiceStatusCallback) {
        this.mServiceCallback = onServiceStatusCallback;
    }

    public void play(String str, String str2) {
        this.mParams = str;
        this.mCurrentSrc = str2;
        startService();
        if (!this.mIsBound) {
            bindService(this.mContext);
        } else {
            doPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPlay() {
        try {
            if (this.mIsBound && this.mIsConnected) {
                this.mIAudioService.setParams(this.mParams);
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
    }

    public void resume() {
        try {
            if (this.mIsBound && this.mIsConnected && !isPlaying()) {
                this.mIAudioService.play();
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
    }

    public void pause() {
        try {
            if (this.mIsBound && this.mIsConnected) {
                this.mIAudioService.pause();
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
    }

    public void seek(int i) {
        try {
            if (this.mIsBound && this.mIsConnected) {
                this.mIAudioService.seek(i);
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
    }

    public void stop() {
        try {
            if (this.mIsBound && this.mIsConnected) {
                this.mIAudioService.stop();
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
    }

    public boolean isPlaying() {
        try {
            if (this.mIsBound && this.mIsConnected) {
                return this.mIAudioService.isPlaying();
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
        return false;
    }

    public int getDuration() {
        try {
            if (this.mIsBound && this.mIsConnected) {
                return this.mIAudioService.getDuration();
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
        return -1;
    }

    private void releaseAudio() {
        try {
            if (this.mIsBound && this.mIsConnected) {
                this.mIAudioService.release();
            }
        } catch (RemoteException e) {
            AiAppsLog.e(MODULE_TAG, e.toString());
        }
    }

    public void release() {
        releaseAudio();
        unbindService(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(Context context) {
        if (!this.mIsBound) {
            this.mIsBound = true;
            Intent intent = new Intent(ACTION_AUDIO);
            intent.setPackage("com.baidu.searchbox");
            context.bindService(intent, this.mServiceConn, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindService(Context context) {
        if (this.mIsBound) {
            this.mIsBound = false;
            context.unbindService(this.mServiceConn);
        }
    }
}
